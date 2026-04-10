package in.etuwa.app.ui.fees.receipt;

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
import in.etuwa.app.data.model.fee.receipts.ReceiptResponse;
import in.etuwa.app.databinding.ReceiptFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* JADX INFO: compiled from: ReceiptFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReceiptFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ReceiptFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: receiptViewModel$delegate, reason: from kotlin metadata */
    private final Lazy receiptViewModel;

    /* JADX INFO: compiled from: ReceiptFragment.kt */
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
    public static final ReceiptFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ReceiptFragment() {
        final ReceiptFragment receiptFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.receipt.ReceiptFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return receiptFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(receiptFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.receiptViewModel = FragmentViewModelLazyKt.createViewModelLazy(receiptFragment, Reflection.getOrCreateKotlinClass(ReceiptViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.receipt.ReceiptFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.receipt.ReceiptFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ReceiptViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ReceiptFragment receiptFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ReceiptAdapter>() { // from class: in.etuwa.app.ui.fees.receipt.ReceiptFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.receipt.ReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = receiptFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ReceiptAdapter.class), b2, b3);
            }
        });
    }

    private final ReceiptViewModel getReceiptViewModel() {
        return (ReceiptViewModel) this.receiptViewModel.getValue();
    }

    private final ReceiptAdapter getAdapter() {
        return (ReceiptAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final ReceiptFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: ReceiptFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/receipt/ReceiptFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/receipt/ReceiptFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReceiptFragment newInstance() {
            return new ReceiptFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ReceiptFragmentBinding.inflate(inflater, container, false);
        ReceiptFragmentBinding receiptFragmentBinding = get_binding();
        if (receiptFragmentBinding != null) {
            receiptFragmentBinding.setReceiptViewModel(getReceiptViewModel());
        }
        ReceiptFragmentBinding receiptFragmentBinding2 = get_binding();
        if (receiptFragmentBinding2 != null) {
            receiptFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ReceiptFragmentBinding receiptFragmentBinding3 = get_binding();
        if (receiptFragmentBinding3 != null) {
            return receiptFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.fee_receipt));
        }
        hideBaseView();
        ReceiptFragmentBinding receiptFragmentBinding = get_binding();
        RecyclerView recyclerView = receiptFragmentBinding != null ? receiptFragmentBinding.rvFeeReceipt : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        listenResponse();
        ReceiptFragmentBinding receiptFragmentBinding2 = get_binding();
        if (receiptFragmentBinding2 == null || (swipeRefreshLayout = receiptFragmentBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.fees.receipt.ReceiptFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ReceiptFragment.setUp$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ReceiptFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getReceiptViewModel().getReceipts();
    }

    private final void listenResponse() {
        getReceiptViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.receipt.ReceiptFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReceiptFragment.listenResponse$lambda$2(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(ReceiptFragment this$0, Resource resource) {
        RecyclerView rvFeeReceipt;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ReceiptResponse receiptResponse = (ReceiptResponse) resource.getData();
            if (receiptResponse != null) {
                this$0.showBaseView();
                if (receiptResponse.getLogin()) {
                    if (receiptResponse.getSuccess()) {
                        this$0.getAdapter().addItems(receiptResponse.getReceipts());
                        return;
                    }
                    ReceiptFragmentBinding receiptFragmentBinding = this$0.get_binding();
                    if (receiptFragmentBinding == null || (rvFeeReceipt = receiptFragmentBinding.rvFeeReceipt) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvFeeReceipt, "rvFeeReceipt");
                    ToastExtKt.showErrorToast(rvFeeReceipt, receiptResponse.getMessage());
                    return;
                }
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
        ReceiptFragmentBinding receiptFragmentBinding2 = this$0.get_binding();
        if (receiptFragmentBinding2 == null || (recyclerView = receiptFragmentBinding2.rvFeeReceipt) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        ReceiptFragmentBinding receiptFragmentBinding = get_binding();
        if (receiptFragmentBinding == null || (recyclerView = receiptFragmentBinding.rvFeeReceipt) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        ReceiptFragmentBinding receiptFragmentBinding = get_binding();
        if (receiptFragmentBinding == null || (recyclerView = receiptFragmentBinding.rvFeeReceipt) == null) {
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