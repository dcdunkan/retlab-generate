package in.etuwa.app.ui.lab.practical.evaluation;

import android.content.ComponentCallbacks;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.lab.Evaluation;
import in.etuwa.app.databinding.EvaluationFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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

/* compiled from: EvaluationFragment.kt */
/* loaded from: classes5.dex */
public final class EvaluationFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private EvaluationFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: evaluationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy evaluationViewModel;
    private String subId;

    /* compiled from: EvaluationFragment.kt */
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
    public static final EvaluationFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public EvaluationFragment() {
        final EvaluationFragment evaluationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.lab.practical.evaluation.EvaluationFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(evaluationFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.evaluationViewModel = FragmentViewModelLazyKt.createViewModelLazy(evaluationFragment, Reflection.getOrCreateKotlinClass(EvaluationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.lab.practical.evaluation.EvaluationFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.lab.practical.evaluation.EvaluationFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(EvaluationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final EvaluationFragment evaluationFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<EvaluationAdapter>() { // from class: in.etuwa.app.ui.lab.practical.evaluation.EvaluationFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.lab.practical.evaluation.EvaluationAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationAdapter invoke() {
                ComponentCallbacks componentCallbacks = evaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationAdapter.class), b2, b3);
            }
        });
    }

    private final EvaluationViewModel getEvaluationViewModel() {
        return (EvaluationViewModel) this.evaluationViewModel.getValue();
    }

    private final EvaluationAdapter getAdapter() {
        return (EvaluationAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final EvaluationFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: EvaluationFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/lab/practical/evaluation/EvaluationFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/lab/practical/evaluation/EvaluationFragment;", StoreFragmentKt.SUB_ID, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final EvaluationFragment newInstance(String subId) {
            EvaluationFragment evaluationFragment = new EvaluationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sub", subId);
            evaluationFragment.setArguments(bundle);
            return evaluationFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.subId = arguments.getString("sub");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = EvaluationFragmentBinding.inflate(inflater, container, false);
        EvaluationFragmentBinding evaluationFragmentBinding = get_binding();
        if (evaluationFragmentBinding != null) {
            evaluationFragmentBinding.setEvaluationViewModel(getEvaluationViewModel());
        }
        EvaluationFragmentBinding evaluationFragmentBinding2 = get_binding();
        if (evaluationFragmentBinding2 != null) {
            evaluationFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        EvaluationFragmentBinding evaluationFragmentBinding3 = get_binding();
        if (evaluationFragmentBinding3 != null) {
            return evaluationFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.evaluation));
        }
        hideBaseView();
        EvaluationFragmentBinding evaluationFragmentBinding = get_binding();
        RecyclerView recyclerView = evaluationFragmentBinding != null ? evaluationFragmentBinding.rvEvaluation : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getEvaluationViewModel().getEvaluation(this.subId);
        listenResponse();
        EvaluationFragmentBinding evaluationFragmentBinding2 = get_binding();
        if (evaluationFragmentBinding2 == null || (swipeRefreshLayout = evaluationFragmentBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.lab.practical.evaluation.EvaluationFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                EvaluationFragment.setUp$lambda$1(EvaluationFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(EvaluationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getEvaluationViewModel().getEvaluation(this$0.subId);
        EvaluationFragmentBinding evaluationFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = evaluationFragmentBinding != null ? evaluationFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getEvaluationViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.practical.evaluation.EvaluationFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenResponse$lambda$3(EvaluationFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(EvaluationFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Evaluation> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(arrayList);
                return;
            }
            return;
        }
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
        EvaluationFragmentBinding evaluationFragmentBinding = this$0.get_binding();
        if (evaluationFragmentBinding == null || (recyclerView = evaluationFragmentBinding.rvEvaluation) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        EvaluationFragmentBinding evaluationFragmentBinding = get_binding();
        if (evaluationFragmentBinding == null || (recyclerView = evaluationFragmentBinding.rvEvaluation) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        EvaluationFragmentBinding evaluationFragmentBinding = get_binding();
        if (evaluationFragmentBinding == null || (recyclerView = evaluationFragmentBinding.rvEvaluation) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}