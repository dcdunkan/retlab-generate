package in.etuwa.app.ui.survey.posurvey;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.survey.posurvey.POSurveyResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentPoSurveyBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsAdapter;
import in.etuwa.app.ui.survey.posurvey.POSurveyAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: POSurveyFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class POSurveyFragment extends BaseFragment implements POSurveyAdapter.SurveyCallBack, CourseSurveyQuestionsAdapter.SurveyCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentPoSurveyBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;
    private int i;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: pOSurveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy pOSurveyViewModel;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: compiled from: POSurveyFragment.kt */
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
    public static final POSurveyFragment newInstance(Integer num) {
        return INSTANCE.newInstance(num);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public POSurveyFragment() {
        final POSurveyFragment pOSurveyFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return pOSurveyFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(pOSurveyFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.pOSurveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(pOSurveyFragment, Reflection.getOrCreateKotlinClass(POSurveyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(POSurveyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final POSurveyFragment pOSurveyFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<POSurveyAdapter>() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.posurvey.POSurveyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final POSurveyAdapter invoke() {
                ComponentCallbacks componentCallbacks = pOSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(POSurveyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = pOSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final POSurveyViewModel getPOSurveyViewModel() {
        return (POSurveyViewModel) this.pOSurveyViewModel.getValue();
    }

    private final POSurveyAdapter getAdapter() {
        return (POSurveyAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentPoSurveyBinding get_binding() {
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

    /* JADX INFO: compiled from: POSurveyFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/POSurveyFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/posurvey/POSurveyFragment;", "id", "", "(Ljava/lang/Integer;)Lin/etuwa/app/ui/survey/posurvey/POSurveyFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final POSurveyFragment newInstance(Integer id) {
            POSurveyFragment pOSurveyFragment = new POSurveyFragment();
            Bundle bundle = new Bundle();
            Intrinsics.checkNotNull(id);
            bundle.putInt("id", id.intValue());
            pOSurveyFragment.setArguments(bundle);
            return pOSurveyFragment;
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
        this._binding = FragmentPoSurveyBinding.inflate(inflater, container, false);
        FragmentPoSurveyBinding fragmentPoSurveyBinding = get_binding();
        if (fragmentPoSurveyBinding != null) {
            fragmentPoSurveyBinding.setPOSurveyViewModel(getPOSurveyViewModel());
        }
        FragmentPoSurveyBinding fragmentPoSurveyBinding2 = get_binding();
        if (fragmentPoSurveyBinding2 != null) {
            fragmentPoSurveyBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentPoSurveyBinding fragmentPoSurveyBinding3 = get_binding();
        if (fragmentPoSurveyBinding3 != null) {
            return fragmentPoSurveyBinding3.getRoot();
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
            activity.setTitle("PO Survey");
        }
        hideBaseView();
        FragmentPoSurveyBinding fragmentPoSurveyBinding = get_binding();
        RecyclerView recyclerView = fragmentPoSurveyBinding != null ? fragmentPoSurveyBinding.rvSurvey : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        getPOSurveyViewModel().getSurveyList();
        FragmentPoSurveyBinding fragmentPoSurveyBinding2 = get_binding();
        if (fragmentPoSurveyBinding2 == null || (swipeRefreshLayout = fragmentPoSurveyBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                POSurveyFragment.setUp$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(POSurveyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPOSurveyViewModel().getSurveyList();
        FragmentPoSurveyBinding fragmentPoSurveyBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentPoSurveyBinding != null ? fragmentPoSurveyBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getPOSurveyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                POSurveyFragment.listenResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(POSurveyFragment this$0, Resource resource) {
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
            FragmentPoSurveyBinding fragmentPoSurveyBinding = this$0.get_binding();
            if (fragmentPoSurveyBinding == null || (recyclerView = fragmentPoSurveyBinding.rvSurvey) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        POSurveyResponse pOSurveyResponse = (POSurveyResponse) resource.getData();
        if (pOSurveyResponse != null) {
            this$0.showBaseView();
            this$0.getAdapter().addItems(pOSurveyResponse.getPosurvey());
            int size = pOSurveyResponse.getPosurvey().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                String lowerCase = pOSurveyResponse.getPosurvey().get(i2).getBtn().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!Intrinsics.areEqual(lowerCase, "completed")) {
                    String lowerCase2 = pOSurveyResponse.getPosurvey().get(i2).getBtn().toLowerCase(Locale.ROOT);
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

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentPoSurveyBinding fragmentPoSurveyBinding = get_binding();
        if (fragmentPoSurveyBinding == null || (recyclerView = fragmentPoSurveyBinding.rvSurvey) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentPoSurveyBinding fragmentPoSurveyBinding = get_binding();
        if (fragmentPoSurveyBinding == null || (recyclerView = fragmentPoSurveyBinding.rvSurvey) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
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

    @Override // in.etuwa.app.ui.survey.posurvey.POSurveyAdapter.SurveyCallBack
    public void doTheSurvey(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.doPOSurvey(id);
        }
    }
}