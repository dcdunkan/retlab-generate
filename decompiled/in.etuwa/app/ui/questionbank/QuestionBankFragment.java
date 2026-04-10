package in.etuwa.app.ui.questionbank;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.materials.Materials;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.QuestionBankFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.questionbank.QuestionBankAdapter;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialog;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: QuestionBankFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QuestionBankFragment extends BaseFragment implements QuestionBankAdapter.QuestionListener, SemListDialog.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private QuestionBankFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private final ArrayList<Materials> fillList;
    private boolean flag;
    private boolean isSearchOpen;
    private final BroadcastReceiver onDownloadComplete;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: questionBankViewModel$delegate, reason: from kotlin metadata */
    private final Lazy questionBankViewModel;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: spinnerFillAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerFillAdapter;
    private final ArrayList<Materials> subList;

    /* JADX INFO: compiled from: QuestionBankFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.EXCEPTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final QuestionBankFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public QuestionBankFragment() {
        final QuestionBankFragment questionBankFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return questionBankFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(questionBankFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.questionBankViewModel = FragmentViewModelLazyKt.createViewModelLazy(questionBankFragment, Reflection.getOrCreateKotlinClass(QuestionBankViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(QuestionBankViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final QuestionBankFragment questionBankFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<QuestionBankAdapter>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.questionbank.QuestionBankAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final QuestionBankAdapter invoke() {
                ComponentCallbacks componentCallbacks = questionBankFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(QuestionBankAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = questionBankFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$spinnerFillAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerFillAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<QBFilterAdapter>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.questionbank.QBFilterAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final QBFilterAdapter invoke() {
                ComponentCallbacks componentCallbacks = questionBankFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(QBFilterAdapter.class), b5, function03);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = questionBankFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b6, b7);
            }
        });
        this.fillList = new ArrayList<>();
        this.subList = new ArrayList<>();
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    ArrayList arrayList = this.this$0.downList;
                    QuestionBankFragment questionBankFragment3 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            questionBankFragment3.getAdapter().notifyDataChanged(((DownloadModel) questionBankFragment3.downList.get(i)).getPosition());
                            questionBankFragment3.downList.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final QuestionBankViewModel getQuestionBankViewModel() {
        return (QuestionBankViewModel) this.questionBankViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuestionBankAdapter getAdapter() {
        return (QuestionBankAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final QuestionBankFragmentBinding get_binding() {
        return this._binding;
    }

    private final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QBFilterAdapter getSpinnerFillAdapter() {
        return (QBFilterAdapter) this.spinnerFillAdapter.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: QuestionBankFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/questionbank/QuestionBankFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/questionbank/QuestionBankFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final QuestionBankFragment newInstance() {
            return new QuestionBankFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = QuestionBankFragmentBinding.inflate(inflater, container, false);
        QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
        if (questionBankFragmentBinding != null) {
            questionBankFragmentBinding.setQuestionBankViewModel(getQuestionBankViewModel());
        }
        QuestionBankFragmentBinding questionBankFragmentBinding2 = get_binding();
        if (questionBankFragmentBinding2 != null) {
            questionBankFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        QuestionBankFragmentBinding questionBankFragmentBinding3 = get_binding();
        if (questionBankFragmentBinding3 != null) {
            return questionBankFragmentBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        ImageView imageView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.quesionbank));
        }
        hideBaseView();
        setHasOptionsMenu(true);
        QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
        RecyclerView recyclerView = questionBankFragmentBinding != null ? questionBankFragmentBinding.rvQuestion : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        QuestionBankFragmentBinding questionBankFragmentBinding2 = get_binding();
        Spinner spinner = questionBankFragmentBinding2 != null ? questionBankFragmentBinding2.spinnerFill : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerFillAdapter());
        }
        getAdapter().setQuestionListener(this);
        getQuestionBankViewModel().getMaterials(getPreference().getUserSemId());
        listenResponse();
        setupSearch();
        getPreference().setNewLogin(false);
        QuestionBankFragmentBinding questionBankFragmentBinding3 = get_binding();
        Spinner spinner2 = questionBankFragmentBinding3 != null ? questionBankFragmentBinding3.spinnerFill : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    QuestionBankFragment.this.filter(QuestionBankFragment.this.getSpinnerFillAdapter().getData(position).getSubject());
                }
            });
        }
        QuestionBankFragmentBinding questionBankFragmentBinding4 = get_binding();
        if (questionBankFragmentBinding4 == null || (imageView = questionBankFragmentBinding4.spinnerSem) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionBankFragment.setUp$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(QuestionBankFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialog semListDialogNewInstance = SemListDialog.INSTANCE.newInstance();
        semListDialogNewInstance.setCallBack3(this$0);
        semListDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void setupSearch() {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
        if (questionBankFragmentBinding != null && (imageView2 = questionBankFragmentBinding.ivSearch) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuestionBankFragment.setupSearch$lambda$1(this.f$0, view);
                }
            });
        }
        QuestionBankFragmentBinding questionBankFragmentBinding2 = get_binding();
        if (questionBankFragmentBinding2 != null && (imageView = questionBankFragmentBinding2.ivClearSearch) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuestionBankFragment.setupSearch$lambda$2(this.f$0, view);
                }
            });
        }
        QuestionBankFragmentBinding questionBankFragmentBinding3 = get_binding();
        if (questionBankFragmentBinding3 == null || (editText = questionBankFragmentBinding3.searchInput) == null) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment.setupSearch.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string;
                if (s == null || (string = s.toString()) == null) {
                    string = "";
                }
                QuestionBankFragmentBinding questionBankFragmentBinding4 = QuestionBankFragment.this.get_binding();
                ImageView imageView3 = questionBankFragmentBinding4 != null ? questionBankFragmentBinding4.ivClearSearch : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(string.length() > 0 ? 0 : 8);
                }
                QuestionBankFragment.this.filterCurrentAdapter(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$1(QuestionBankFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSearchOpen) {
            this$0.closeSearch();
        } else {
            this$0.openSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$2(QuestionBankFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QuestionBankFragmentBinding questionBankFragmentBinding = this$0.get_binding();
        if (questionBankFragmentBinding == null || (editText = questionBankFragmentBinding.searchInput) == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    private final void openSearch() {
        EditText editText;
        ImageView imageView;
        this.isSearchOpen = true;
        QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
        CardView cardView = questionBankFragmentBinding != null ? questionBankFragmentBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        QuestionBankFragmentBinding questionBankFragmentBinding2 = get_binding();
        if (questionBankFragmentBinding2 != null && (imageView = questionBankFragmentBinding2.ivSearch) != null) {
            imageView.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        }
        QuestionBankFragmentBinding questionBankFragmentBinding3 = get_binding();
        ImageView imageView2 = questionBankFragmentBinding3 != null ? questionBankFragmentBinding3.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        QuestionBankFragmentBinding questionBankFragmentBinding4 = get_binding();
        if (questionBankFragmentBinding4 != null && (editText = questionBankFragmentBinding4.searchInput) != null) {
            editText.requestFocus();
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        QuestionBankFragmentBinding questionBankFragmentBinding5 = get_binding();
        inputMethodManager.showSoftInput(questionBankFragmentBinding5 != null ? questionBankFragmentBinding5.searchInput : null, 1);
    }

    private final void closeSearch() {
        EditText editText;
        ImageView imageView;
        EditText editText2;
        Editable text;
        this.isSearchOpen = false;
        QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
        IBinder windowToken = null;
        CardView cardView = questionBankFragmentBinding != null ? questionBankFragmentBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        QuestionBankFragmentBinding questionBankFragmentBinding2 = get_binding();
        if (questionBankFragmentBinding2 != null && (editText2 = questionBankFragmentBinding2.searchInput) != null && (text = editText2.getText()) != null) {
            text.clear();
        }
        QuestionBankFragmentBinding questionBankFragmentBinding3 = get_binding();
        if (questionBankFragmentBinding3 != null && (imageView = questionBankFragmentBinding3.ivSearch) != null) {
            imageView.setImageResource(R.drawable.ic_search);
        }
        QuestionBankFragmentBinding questionBankFragmentBinding4 = get_binding();
        ImageView imageView2 = questionBankFragmentBinding4 != null ? questionBankFragmentBinding4.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        QuestionBankFragmentBinding questionBankFragmentBinding5 = get_binding();
        if (questionBankFragmentBinding5 != null && (editText = questionBankFragmentBinding5.searchInput) != null) {
            windowToken = editText.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        filterCurrentAdapter("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filterCurrentAdapter(String query) {
        getAdapter().applyCombinedFilter(query);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        menu.clear();
        inflater.inflate(R.menu.action_filter, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final void listenResponse() {
        getQuestionBankViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuestionBankFragment.listenResponse$lambda$4(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(QuestionBankFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Materials> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
                this$0.loadFilter(arrayList);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        QuestionBankFragmentBinding questionBankFragmentBinding = this$0.get_binding();
        if (questionBankFragmentBinding == null || (recyclerView = questionBankFragmentBinding.rvQuestion) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void loadFilter(ArrayList<Materials> response) {
        this.subList.clear();
        this.subList.addAll(response);
        this.fillList.clear();
        this.fillList.add(new Materials("All", "All", "All", "All", "All", "All", "All"));
        ArrayList<Materials> arrayList = this.fillList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : response) {
            if (hashSet.add(((Materials) obj).getSubject())) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        getSpinnerFillAdapter().addItems(this.fillList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filter(String text) {
        ArrayList<Materials> arrayList = new ArrayList<>();
        if (Intrinsics.areEqual(text, "All")) {
            Iterator<T> it = this.subList.iterator();
            while (it.hasNext()) {
                arrayList.add((Materials) it.next());
            }
        } else {
            for (Materials materials : this.subList) {
                String lowerCase = materials.getSubject().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = text.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    arrayList.add(materials);
                }
            }
        }
        arrayList.remove(new Materials("All", "All", "All", "All", "All", "All", "All"));
        getAdapter().addItems(arrayList);
    }

    @Override // in.etuwa.app.ui.questionbank.QuestionBankAdapter.QuestionListener
    public void downloadFile(String url, int position) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(strReplace)) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                new DownloadManagerHelper(contextRequireContext2).openFile(strReplace, AppConstant.QUESTION_BANK_PATH);
                return;
            }
            try {
                QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
                if (questionBankFragmentBinding != null && (recyclerView = questionBankFragmentBinding.rvQuestion) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext3).startDownloading(AppConstant.QUESTION_BANK_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
                }
                this.downList.add(new DownloadModel(jStartDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
        new ValidChecker(contextRequireContext4).showPermissionDialog();
    }

    @Override // in.etuwa.app.ui.questionbank.QuestionBankAdapter.QuestionListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.QUESTION_BANK_PATH);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
        if (questionBankFragmentBinding == null || (recyclerView = questionBankFragmentBinding.rvQuestion) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
        if (questionBankFragmentBinding == null || (recyclerView = questionBankFragmentBinding.rvQuestion) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setQuestionListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.result.university.semlistdialog.SemListDialog.SemDialogCallBack
    public void loadSelectedSem(String id, String semName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        getQuestionBankViewModel().getMaterials(id);
    }
}