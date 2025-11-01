package in.etuwa.app.ui.examregistration.revaluation.view.receipt;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import in.etuwa.app.data.model.examregister.RevaluationReceipt;
import in.etuwa.app.data.model.examregister.RevaluationReceiptResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentRevaluationReceiptBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RevaluationReceiptFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\u001a\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00100\u001a\u00020\u001eH\u0014J\b\u00101\u001a\u00020\u001eH\u0014J\b\u00102\u001a\u00020\u001eH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001b¨\u00064"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentRevaluationReceiptBinding;", "adapter", "Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptAdapter;", "getAdapter", "()Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentRevaluationReceiptBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "revaluationReceiptViewModel", "Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptViewModel;", "getRevaluationReceiptViewModel", "()Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptViewModel;", "revaluationReceiptViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RevaluationReceiptFragment extends BaseFragment implements RevaluationReceiptAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentRevaluationReceiptBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: revaluationReceiptViewModel$delegate, reason: from kotlin metadata */
    private final Lazy revaluationReceiptViewModel;

    /* compiled from: RevaluationReceiptFragment.kt */
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
    public static final RevaluationReceiptFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public RevaluationReceiptFragment() {
        final RevaluationReceiptFragment revaluationReceiptFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(revaluationReceiptFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.revaluationReceiptViewModel = FragmentViewModelLazyKt.createViewModelLazy(revaluationReceiptFragment, Reflection.getOrCreateKotlinClass(RevaluationReceiptViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(RevaluationReceiptViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final RevaluationReceiptFragment revaluationReceiptFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RevaluationReceiptAdapter>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final RevaluationReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = revaluationReceiptFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(RevaluationReceiptAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = revaluationReceiptFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final RevaluationReceiptViewModel getRevaluationReceiptViewModel() {
        return (RevaluationReceiptViewModel) this.revaluationReceiptViewModel.getValue();
    }

    private final RevaluationReceiptAdapter getAdapter() {
        return (RevaluationReceiptAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentRevaluationReceiptBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: RevaluationReceiptFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/revaluation/view/receipt/RevaluationReceiptFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RevaluationReceiptFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            RevaluationReceiptFragment revaluationReceiptFragment = new RevaluationReceiptFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            revaluationReceiptFragment.setArguments(bundle);
            return revaluationReceiptFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentRevaluationReceiptBinding.inflate(inflater, container, false);
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding = get_binding();
        if (fragmentRevaluationReceiptBinding != null) {
            fragmentRevaluationReceiptBinding.setRevaluationReceiptViewModel(getRevaluationReceiptViewModel());
        }
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding2 = get_binding();
        if (fragmentRevaluationReceiptBinding2 != null) {
            fragmentRevaluationReceiptBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding3 = get_binding();
        if (fragmentRevaluationReceiptBinding3 != null) {
            return fragmentRevaluationReceiptBinding3.getRoot();
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
            activity.setTitle("Revaluation Receipt");
        }
        hideBaseView();
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding = get_binding();
        RecyclerView recyclerView = fragmentRevaluationReceiptBinding != null ? fragmentRevaluationReceiptBinding.rvExamRevaluation : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        getPreference().setNewLogin(false);
        RevaluationReceiptViewModel revaluationReceiptViewModel = getRevaluationReceiptViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        revaluationReceiptViewModel.getExamData(str);
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding2 = get_binding();
        if (fragmentRevaluationReceiptBinding2 == null || (swipeRefreshLayout = fragmentRevaluationReceiptBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                RevaluationReceiptFragment.setUp$lambda$1(RevaluationReceiptFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(RevaluationReceiptFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RevaluationReceiptViewModel revaluationReceiptViewModel = this$0.getRevaluationReceiptViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        revaluationReceiptViewModel.getExamData(str);
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentRevaluationReceiptBinding != null ? fragmentRevaluationReceiptBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getRevaluationReceiptViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RevaluationReceiptFragment.listenResponse$lambda$3(RevaluationReceiptFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(RevaluationReceiptFragment this$0, Resource resource) {
        RecyclerView rvExamRevaluation;
        RecyclerView rvExamRevaluation2;
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
            FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding = this$0.get_binding();
            if (fragmentRevaluationReceiptBinding == null || (recyclerView = fragmentRevaluationReceiptBinding.rvExamRevaluation) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        RevaluationReceiptResponse revaluationReceiptResponse = (RevaluationReceiptResponse) resource.getData();
        if (revaluationReceiptResponse != null) {
            this$0.showBaseView();
            try {
                if (revaluationReceiptResponse.getReceipt().size() > 0) {
                    RevaluationReceiptAdapter adapter = this$0.getAdapter();
                    ArrayList<RevaluationReceipt> receipt = revaluationReceiptResponse.getReceipt();
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(receipt, requireContext);
                    FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding2 = this$0.get_binding();
                    TextView textView = fragmentRevaluationReceiptBinding2 != null ? fragmentRevaluationReceiptBinding2.payNowBtn : null;
                    if (textView != null) {
                        textView.setText("Total  :  " + revaluationReceiptResponse.getTotal());
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding3 = this$0.get_binding();
                if (fragmentRevaluationReceiptBinding3 == null || (rvExamRevaluation2 = fragmentRevaluationReceiptBinding3.rvExamRevaluation) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamRevaluation2, "rvExamRevaluation");
                ToastExtKt.showErrorToast(rvExamRevaluation2, "No Data Found");
                Unit unit2 = Unit.INSTANCE;
            } catch (NullPointerException unused) {
                FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding4 = this$0.get_binding();
                if (fragmentRevaluationReceiptBinding4 == null || (rvExamRevaluation = fragmentRevaluationReceiptBinding4.rvExamRevaluation) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamRevaluation, "rvExamRevaluation");
                ToastExtKt.showErrorToast(rvExamRevaluation, "No Data Found");
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding = get_binding();
        if (fragmentRevaluationReceiptBinding == null || (recyclerView = fragmentRevaluationReceiptBinding.rvExamRevaluation) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentRevaluationReceiptBinding fragmentRevaluationReceiptBinding = get_binding();
        if (fragmentRevaluationReceiptBinding == null || (recyclerView = fragmentRevaluationReceiptBinding.rvExamRevaluation) == null) {
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
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }
}