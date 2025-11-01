package in.etuwa.app.ui.questionbank;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.materials.Materials;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.QuestionBankFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.questionbank.QuestionBankAdapter;
import in.etuwa.app.ui.studymaterials.MaterialFilterAdapter;
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

/* compiled from: QuestionBankFragment.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002022\u0006\u00107\u001a\u000200H\u0002J\b\u00108\u001a\u000202H\u0014J\b\u00109\u001a\u000202H\u0014J\b\u0010:\u001a\u000202H\u0002J\b\u0010;\u001a\u000202H\u0002J \u0010<\u001a\u0002022\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012H\u0002J\u0018\u0010>\u001a\u0002022\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J&\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010A\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u000202H\u0016J\b\u0010K\u001a\u000202H\u0016J\u001a\u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010N\u001a\u000202H\u0014J\b\u0010O\u001a\u000202H\u0014J\b\u0010P\u001a\u000202H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lin/etuwa/app/ui/questionbank/QuestionBankFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/questionbank/QuestionBankAdapter$QuestionListener;", "()V", "_binding", "Lin/etuwa/app/databinding/QuestionBankFragmentBinding;", "adapter", "Lin/etuwa/app/ui/questionbank/QuestionBankAdapter;", "getAdapter", "()Lin/etuwa/app/ui/questionbank/QuestionBankAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/QuestionBankFragmentBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "fillList", "Lin/etuwa/app/data/model/materials/Materials;", "flag", "", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "questionBankViewModel", "Lin/etuwa/app/ui/questionbank/QuestionBankViewModel;", "getQuestionBankViewModel", "()Lin/etuwa/app/ui/questionbank/QuestionBankViewModel;", "questionBankViewModel$delegate", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerFillAdapter", "Lin/etuwa/app/ui/studymaterials/MaterialFilterAdapter;", "getSpinnerFillAdapter", "()Lin/etuwa/app/ui/studymaterials/MaterialFilterAdapter;", "spinnerFillAdapter$delegate", "subList", "checkFileExistence", "fileName", "", "downloadFile", "", "url", CommonCssConstants.POSITION, "", SvgConstants.Tags.FILTER, "text", "hideBaseView", "hideProgress", "listenResponse", "listenSemResponse", "loadFilter", "response", "onCreateOptionsMenu", CommonCssConstants.MENU, "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestionBankFragment extends BaseFragment implements QuestionBankAdapter.QuestionListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private QuestionBankFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private final ArrayList<Materials> fillList;
    private boolean flag;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: questionBankViewModel$delegate, reason: from kotlin metadata */
    private final Lazy questionBankViewModel;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerFillAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerFillAdapter;
    private final ArrayList<Materials> subList;

    /* compiled from: QuestionBankFragment.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(QuestionBankViewModel.class), qualifier, b, null, koinScope);
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
                return ParametersHolderKt.parametersOf(QuestionBankFragment.this.requireActivity());
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
                return ParametersHolderKt.parametersOf(QuestionBankFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerFillAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<MaterialFilterAdapter>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.studymaterials.MaterialFilterAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialFilterAdapter invoke() {
                ComponentCallbacks componentCallbacks = questionBankFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MaterialFilterAdapter.class), b5, function03);
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
                ArrayList arrayList;
                QuestionBankAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = QuestionBankFragment.this.downList;
                    QuestionBankFragment questionBankFragment3 = QuestionBankFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = questionBankFragment3.getAdapter();
                            arrayList2 = questionBankFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = questionBankFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuestionBankViewModel getQuestionBankViewModel() {
        return (QuestionBankViewModel) this.questionBankViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuestionBankAdapter getAdapter() {
        return (QuestionBankAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final QuestionBankFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MaterialFilterAdapter getSpinnerFillAdapter() {
        return (MaterialFilterAdapter) this.spinnerFillAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: QuestionBankFragment.kt */
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
        SwipeRefreshLayout swipeRefreshLayout;
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
        Spinner spinner = questionBankFragmentBinding2 != null ? questionBankFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        QuestionBankFragmentBinding questionBankFragmentBinding3 = get_binding();
        Spinner spinner2 = questionBankFragmentBinding3 != null ? questionBankFragmentBinding3.spinnerFill : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerFillAdapter());
        }
        getAdapter().setQuestionListener(this);
        getQuestionBankViewModel().getMaterials(getPreference().getUserSemId());
        listenSemResponse();
        listenResponse();
        getPreference().setNewLogin(false);
        QuestionBankFragmentBinding questionBankFragmentBinding4 = get_binding();
        Spinner spinner3 = questionBankFragmentBinding4 != null ? questionBankFragmentBinding4.spinnerSem : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter;
                    QuestionBankAdapter adapter;
                    MaterialFilterAdapter spinnerFillAdapter;
                    boolean z;
                    SharedPrefManager preference;
                    SemesterSpinnerAdapter spinnerAdapter2;
                    SemesterSpinnerAdapter spinnerAdapter3;
                    SharedPrefManager preference2;
                    SemesterSpinnerAdapter spinnerAdapter4;
                    QuestionBankFragmentBinding questionBankFragmentBinding5;
                    Spinner spinner4;
                    QuestionBankViewModel questionBankViewModel;
                    QuestionBankViewModel questionBankViewModel2;
                    spinnerAdapter = QuestionBankFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    adapter = QuestionBankFragment.this.getAdapter();
                    adapter.clearItems();
                    spinnerFillAdapter = QuestionBankFragment.this.getSpinnerFillAdapter();
                    spinnerFillAdapter.clearItems();
                    z = QuestionBankFragment.this.flag;
                    if (z) {
                        questionBankViewModel2 = QuestionBankFragment.this.getQuestionBankViewModel();
                        questionBankViewModel2.getMaterials(semester.getId());
                        return;
                    }
                    QuestionBankFragment.this.flag = true;
                    try {
                        preference = QuestionBankFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter2 = QuestionBankFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter2.getSemester(0).getId())) {
                            questionBankViewModel = QuestionBankFragment.this.getQuestionBankViewModel();
                            questionBankViewModel.getMaterials(semester.getId());
                        } else {
                            spinnerAdapter3 = QuestionBankFragment.this.getSpinnerAdapter();
                            int count = spinnerAdapter3.getCount();
                            for (int i = 0; i < count; i++) {
                                preference2 = QuestionBankFragment.this.getPreference();
                                String userSemId2 = preference2.getUserSemId();
                                spinnerAdapter4 = QuestionBankFragment.this.getSpinnerAdapter();
                                if (Intrinsics.areEqual(userSemId2, spinnerAdapter4.getSemester(i).getId())) {
                                    questionBankFragmentBinding5 = QuestionBankFragment.this.get_binding();
                                    if (questionBankFragmentBinding5 != null && (spinner4 = questionBankFragmentBinding5.spinnerSem) != null) {
                                        spinner4.setSelection(i);
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
        QuestionBankFragmentBinding questionBankFragmentBinding5 = get_binding();
        Spinner spinner4 = questionBankFragmentBinding5 != null ? questionBankFragmentBinding5.spinnerFill : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MaterialFilterAdapter spinnerFillAdapter;
                    spinnerFillAdapter = QuestionBankFragment.this.getSpinnerFillAdapter();
                    QuestionBankFragment.this.filter(spinnerFillAdapter.getData(position).getSubject());
                }
            });
        }
        QuestionBankFragmentBinding questionBankFragmentBinding6 = get_binding();
        if (questionBankFragmentBinding6 == null || (swipeRefreshLayout = questionBankFragmentBinding6.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                QuestionBankFragment.setUp$lambda$0(QuestionBankFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(QuestionBankFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getQuestionBankViewModel().getSemester();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        menu.clear();
        inflater.inflate(R.menu.action_filter, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final void listenSemResponse() {
        getQuestionBankViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuestionBankFragment.listenSemResponse$lambda$2(QuestionBankFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$2(QuestionBankFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        r2 = null;
        Boolean bool = null;
        if (i != 1) {
            if (i == 2) {
                QuestionBankFragmentBinding questionBankFragmentBinding = this$0.get_binding();
                if (questionBankFragmentBinding != null && (swipeRefreshLayout2 = questionBankFragmentBinding.swipeLayout) != null) {
                    bool = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    return;
                }
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
            QuestionBankFragmentBinding questionBankFragmentBinding2 = this$0.get_binding();
            if (questionBankFragmentBinding2 == null || (recyclerView = questionBankFragmentBinding2.rvQuestion) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            QuestionBankFragmentBinding questionBankFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (questionBankFragmentBinding3 == null || (swipeRefreshLayout = questionBankFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                QuestionBankFragmentBinding questionBankFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = questionBankFragmentBinding4 != null ? questionBankFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        QuestionBankFragmentBinding questionBankFragmentBinding5 = this$0.get_binding();
                        if (questionBankFragmentBinding5 == null || (spinner = questionBankFragmentBinding5.spinnerSem) == null) {
                            return;
                        }
                        spinner.setSelection(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void listenResponse() {
        getQuestionBankViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.questionbank.QuestionBankFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuestionBankFragment.listenResponse$lambda$4(QuestionBankFragment.this, (Resource) obj);
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
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(replace)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, AppConstant.QUESTION_BANK_PATH);
                return;
            }
            try {
                QuestionBankFragmentBinding questionBankFragmentBinding = get_binding();
                if (questionBankFragmentBinding != null && (recyclerView = questionBankFragmentBinding.rvQuestion) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.QUESTION_BANK_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
        new ValidChecker(requireContext4).showPermissionDialog();
    }

    @Override // in.etuwa.app.ui.questionbank.QuestionBankAdapter.QuestionListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.QUESTION_BANK_PATH);
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
}