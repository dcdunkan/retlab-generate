package in.etuwa.app.ui.survey;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.chip.ChipGroup;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.Survey;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentSurveyBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.SurveyAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: SurveyFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SurveyFragment extends BaseFragment implements SurveyAdapter.SurveyCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentSurveyBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String currentFilter;
    private boolean flag;
    private int i;
    private boolean isSearchOpen;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: surveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveyViewModel;

    /* JADX INFO: compiled from: SurveyFragment.kt */
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
    public static final SurveyFragment newInstance(Integer num) {
        return INSTANCE.newInstance(num);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SurveyFragment() {
        final SurveyFragment surveyFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return surveyFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(surveyFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.surveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(surveyFragment, Reflection.getOrCreateKotlinClass(SurveyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(SurveyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SurveyFragment surveyFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SurveyAdapter>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.SurveyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SurveyAdapter invoke() {
                ComponentCallbacks componentCallbacks = surveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SurveyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = surveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.currentFilter = "pending";
    }

    private final SurveyViewModel getSurveyViewModel() {
        return (SurveyViewModel) this.surveyViewModel.getValue();
    }

    private final SurveyAdapter getAdapter() {
        return (SurveyAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentSurveyBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    /* JADX INFO: compiled from: SurveyFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/SurveyFragment;", "id", "", "(Ljava/lang/Integer;)Lin/etuwa/app/ui/survey/SurveyFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SurveyFragment newInstance(Integer id) {
            SurveyFragment surveyFragment = new SurveyFragment();
            Bundle bundle = new Bundle();
            Intrinsics.checkNotNull(id);
            bundle.putInt("id", id.intValue());
            surveyFragment.setArguments(bundle);
            return surveyFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getInt("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentSurveyBinding.inflate(inflater, container, false);
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        if (fragmentSurveyBinding != null) {
            fragmentSurveyBinding.setSurveyViewModel(getSurveyViewModel());
        }
        FragmentSurveyBinding fragmentSurveyBinding2 = get_binding();
        if (fragmentSurveyBinding2 != null) {
            fragmentSurveyBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentSurveyBinding fragmentSurveyBinding3 = get_binding();
        if (fragmentSurveyBinding3 != null) {
            return fragmentSurveyBinding3.getRoot();
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
        CardView cardView;
        CardView cardView2;
        CardView cardView3;
        CardView cardView4;
        ImageView imageView;
        ChipGroup chipGroup;
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.survey));
        }
        hideBaseView();
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        RecyclerView recyclerView = fragmentSurveyBinding != null ? fragmentSurveyBinding.rvSurvey : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        setupSearch();
        getSurveyViewModel().getSurveyList();
        FragmentSurveyBinding fragmentSurveyBinding2 = get_binding();
        if (fragmentSurveyBinding2 != null && (swipeRefreshLayout = fragmentSurveyBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda3
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    SurveyFragment.setUp$lambda$1(this.f$0);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding3 = get_binding();
        if (fragmentSurveyBinding3 != null && (chipGroup = fragmentSurveyBinding3.chipGroupFilter) != null) {
            chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda4
                @Override // com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
                public final void onCheckedChanged(ChipGroup chipGroup2, List list) {
                    SurveyFragment.setUp$lambda$2(this.f$0, chipGroup2, list);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding4 = get_binding();
        if (fragmentSurveyBinding4 != null && (imageView = fragmentSurveyBinding4.ivFilter) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null)) {
            FragmentSurveyBinding fragmentSurveyBinding5 = get_binding();
            CardView cardView5 = fragmentSurveyBinding5 != null ? fragmentSurveyBinding5.courseBtn : null;
            if (cardView5 != null) {
                cardView5.setVisibility(0);
            }
        } else {
            FragmentSurveyBinding fragmentSurveyBinding6 = get_binding();
            CardView cardView6 = fragmentSurveyBinding6 != null ? fragmentSurveyBinding6.courseBtn : null;
            if (cardView6 != null) {
                cardView6.setVisibility(8);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sahrdaya", false, 2, (Object) null)) {
            FragmentSurveyBinding fragmentSurveyBinding7 = get_binding();
            cardView = fragmentSurveyBinding7 != null ? fragmentSurveyBinding7.graduateBtn : null;
            if (cardView != null) {
                cardView.setVisibility(0);
            }
        } else {
            FragmentSurveyBinding fragmentSurveyBinding8 = get_binding();
            cardView = fragmentSurveyBinding8 != null ? fragmentSurveyBinding8.graduateBtn : null;
            if (cardView != null) {
                cardView.setVisibility(8);
            }
        }
        FragmentSurveyBinding fragmentSurveyBinding9 = get_binding();
        if (fragmentSurveyBinding9 != null && (cardView4 = fragmentSurveyBinding9.courseBtn) != null) {
            cardView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.setUp$lambda$4(this.f$0, view);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding10 = get_binding();
        if (fragmentSurveyBinding10 != null && (cardView3 = fragmentSurveyBinding10.poSurveyBtn) != null) {
            cardView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.setUp$lambda$5(this.f$0, view);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding11 = get_binding();
        if (fragmentSurveyBinding11 == null || (cardView2 = fragmentSurveyBinding11.graduateBtn) == null) {
            return;
        }
        cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyFragment.setUp$lambda$6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SurveyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSurveyViewModel().getSurveyList();
        FragmentSurveyBinding fragmentSurveyBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentSurveyBinding != null ? fragmentSurveyBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(SurveyFragment this$0, ChipGroup chipGroup, List checkedIds) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chipGroup, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(checkedIds, "checkedIds");
        Integer num = (Integer) CollectionsKt.firstOrNull(checkedIds);
        int i = R.id.chip_pending;
        if (num != null && num.intValue() == i) {
            str = "pending";
        } else {
            str = (num != null && num.intValue() == R.id.chip_completed) ? "completed" : "all";
        }
        this$0.currentFilter = str;
        this$0.getAdapter().setFilter(this$0.currentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAdapter().toggleSort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showCourseSurvey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPoSurvey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onGradiateSurveyOpen();
        }
    }

    private final void listenResponse() {
        getSurveyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SurveyFragment.listenResponse$lambda$8(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$8(SurveyFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
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
            FragmentSurveyBinding fragmentSurveyBinding = this$0.get_binding();
            if (fragmentSurveyBinding == null || (recyclerView = fragmentSurveyBinding.rvSurvey) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ArrayList<Survey> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.showBaseView();
            this$0.getAdapter().addItems(arrayList);
            SurveyAdapter.applyCombinedFilter$default(this$0.getAdapter(), null, 1, null);
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                String lowerCase = arrayList.get(i2).getBtnStatus().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!Intrinsics.areEqual(lowerCase, "completed")) {
                    String lowerCase2 = arrayList.get(i2).getBtnStatus().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (!Intrinsics.areEqual(lowerCase2, "last date over")) {
                        this$0.flag = false;
                        break;
                    }
                }
                this$0.flag = true;
                i2++;
            }
            if (this$0.flag && this$0.i == 1 && (mainCallBackListener = this$0.listener) != null) {
                mainCallBackListener.onSurveyFullyCompleted(true, "");
            }
        }
    }

    private final void setupSearch() {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        if (fragmentSurveyBinding != null && (imageView2 = fragmentSurveyBinding.ivSearch) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.setupSearch$lambda$9(this.f$0, view);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding2 = get_binding();
        if (fragmentSurveyBinding2 != null && (imageView = fragmentSurveyBinding2.ivClearSearch) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.setupSearch$lambda$10(this.f$0, view);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding3 = get_binding();
        if (fragmentSurveyBinding3 == null || (editText = fragmentSurveyBinding3.searchInput) == null) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.survey.SurveyFragment.setupSearch.3
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
                FragmentSurveyBinding fragmentSurveyBinding4 = SurveyFragment.this.get_binding();
                ImageView imageView3 = fragmentSurveyBinding4 != null ? fragmentSurveyBinding4.ivClearSearch : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(string.length() > 0 ? 0 : 8);
                }
                SurveyFragment.this.filterCurrentAdapter(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$9(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSearchOpen) {
            this$0.closeSearch();
        } else {
            this$0.openSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$10(SurveyFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentSurveyBinding fragmentSurveyBinding = this$0.get_binding();
        if (fragmentSurveyBinding == null || (editText = fragmentSurveyBinding.searchInput) == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    private final void openSearch() {
        EditText editText;
        ImageView imageView;
        this.isSearchOpen = true;
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        CardView cardView = fragmentSurveyBinding != null ? fragmentSurveyBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        FragmentSurveyBinding fragmentSurveyBinding2 = get_binding();
        if (fragmentSurveyBinding2 != null && (imageView = fragmentSurveyBinding2.ivSearch) != null) {
            imageView.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        }
        FragmentSurveyBinding fragmentSurveyBinding3 = get_binding();
        ImageView imageView2 = fragmentSurveyBinding3 != null ? fragmentSurveyBinding3.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        FragmentSurveyBinding fragmentSurveyBinding4 = get_binding();
        if (fragmentSurveyBinding4 != null && (editText = fragmentSurveyBinding4.searchInput) != null) {
            editText.requestFocus();
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentSurveyBinding fragmentSurveyBinding5 = get_binding();
        inputMethodManager.showSoftInput(fragmentSurveyBinding5 != null ? fragmentSurveyBinding5.searchInput : null, 1);
    }

    private final void closeSearch() {
        EditText editText;
        ImageView imageView;
        EditText editText2;
        Editable text;
        this.isSearchOpen = false;
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        IBinder windowToken = null;
        CardView cardView = fragmentSurveyBinding != null ? fragmentSurveyBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        FragmentSurveyBinding fragmentSurveyBinding2 = get_binding();
        if (fragmentSurveyBinding2 != null && (editText2 = fragmentSurveyBinding2.searchInput) != null && (text = editText2.getText()) != null) {
            text.clear();
        }
        FragmentSurveyBinding fragmentSurveyBinding3 = get_binding();
        if (fragmentSurveyBinding3 != null && (imageView = fragmentSurveyBinding3.ivSearch) != null) {
            imageView.setImageResource(R.drawable.ic_search);
        }
        FragmentSurveyBinding fragmentSurveyBinding4 = get_binding();
        ImageView imageView2 = fragmentSurveyBinding4 != null ? fragmentSurveyBinding4.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentSurveyBinding fragmentSurveyBinding5 = get_binding();
        if (fragmentSurveyBinding5 != null && (editText = fragmentSurveyBinding5.searchInput) != null) {
            windowToken = editText.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        filterCurrentAdapter("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filterCurrentAdapter(String query) {
        getAdapter().applyCombinedFilter(query);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        if (fragmentSurveyBinding == null || (recyclerView = fragmentSurveyBinding.rvSurvey) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        if (fragmentSurveyBinding == null || (recyclerView = fragmentSurveyBinding.rvSurvey) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.survey.SurveyAdapter.SurveyCallBack
    public void doTheSurvey(String id, String type, String surveyName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(surveyName, "surveyName");
        if (Intrinsics.areEqual(type, ExifInterface.GPS_MEASUREMENT_2D)) {
            MainCallBackListener mainCallBackListener = this.listener;
            if (mainCallBackListener != null) {
                mainCallBackListener.doGeneralSurvey(id, surveyName);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(type, "1")) {
            MainCallBackListener mainCallBackListener2 = this.listener;
            if (mainCallBackListener2 != null) {
                mainCallBackListener2.showTeacherSurveyList(id);
                return;
            }
            return;
        }
        MainCallBackListener mainCallBackListener3 = this.listener;
        if (mainCallBackListener3 != null) {
            mainCallBackListener3.doGeneralSurvey(id, surveyName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}