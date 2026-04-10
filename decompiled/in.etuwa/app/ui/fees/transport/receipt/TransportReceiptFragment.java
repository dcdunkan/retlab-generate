package in.etuwa.app.ui.fees.transport.receipt;

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
import in.etuwa.app.databinding.FragmentTransportReceiptBinding;
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

/* compiled from: TransportReceiptFragment.kt */
/* loaded from: classes4.dex */
public final class TransportReceiptFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTransportReceiptBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: transportReceiptViewModel$delegate, reason: from kotlin metadata */
    private final Lazy transportReceiptViewModel;

    /* compiled from: TransportReceiptFragment.kt */
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
    public static final TransportReceiptFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TransportReceiptFragment() {
        final TransportReceiptFragment transportReceiptFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.transport.receipt.TransportReceiptFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(transportReceiptFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.transportReceiptViewModel = FragmentViewModelLazyKt.createViewModelLazy(transportReceiptFragment, Reflection.getOrCreateKotlinClass(TransportReceiptViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.transport.receipt.TransportReceiptFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.transport.receipt.TransportReceiptFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TransportReceiptViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TransportReceiptFragment transportReceiptFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TransportReceiptAdapter>() { // from class: in.etuwa.app.ui.fees.transport.receipt.TransportReceiptFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.transport.receipt.TransportReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportReceiptFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportReceiptAdapter.class), b2, b3);
            }
        });
    }

    private final TransportReceiptViewModel getTransportReceiptViewModel() {
        return (TransportReceiptViewModel) this.transportReceiptViewModel.getValue();
    }

    private final TransportReceiptAdapter getAdapter() {
        return (TransportReceiptAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentTransportReceiptBinding get_binding() {
        return this._binding;
    }

    /* compiled from: TransportReceiptFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/transport/receipt/TransportReceiptFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/transport/receipt/TransportReceiptFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TransportReceiptFragment newInstance() {
            return new TransportReceiptFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTransportReceiptBinding.inflate(inflater, container, false);
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding = get_binding();
        if (fragmentTransportReceiptBinding != null) {
            fragmentTransportReceiptBinding.setReceiptViewModel(getTransportReceiptViewModel());
        }
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding2 = get_binding();
        if (fragmentTransportReceiptBinding2 != null) {
            fragmentTransportReceiptBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding3 = get_binding();
        if (fragmentTransportReceiptBinding3 != null) {
            return fragmentTransportReceiptBinding3.getRoot();
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
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding = get_binding();
        RecyclerView recyclerView = fragmentTransportReceiptBinding != null ? fragmentTransportReceiptBinding.rvFeeReceipt : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        listenResponse();
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding2 = get_binding();
        if (fragmentTransportReceiptBinding2 == null || (swipeRefreshLayout = fragmentTransportReceiptBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.fees.transport.receipt.TransportReceiptFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                TransportReceiptFragment.setUp$lambda$0(TransportReceiptFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TransportReceiptFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentTransportReceiptBinding != null ? fragmentTransportReceiptBinding.swipeLayout : null;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        this$0.getTransportReceiptViewModel().getReceipts();
    }

    private final void listenResponse() {
        getTransportReceiptViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.transport.receipt.TransportReceiptFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportReceiptFragment.listenResponse$lambda$2(TransportReceiptFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(TransportReceiptFragment this$0, Resource resource) {
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
                    if (receiptResponse.getLogin()) {
                        this$0.getAdapter().addItems(receiptResponse.getReceipts());
                        return;
                    }
                    FragmentTransportReceiptBinding fragmentTransportReceiptBinding = this$0.get_binding();
                    if (fragmentTransportReceiptBinding == null || (rvFeeReceipt = fragmentTransportReceiptBinding.rvFeeReceipt) == null) {
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
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding2 = this$0.get_binding();
        if (fragmentTransportReceiptBinding2 == null || (recyclerView = fragmentTransportReceiptBinding2.rvFeeReceipt) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding = get_binding();
        if (fragmentTransportReceiptBinding == null || (recyclerView = fragmentTransportReceiptBinding.rvFeeReceipt) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentTransportReceiptBinding fragmentTransportReceiptBinding = get_binding();
        if (fragmentTransportReceiptBinding == null || (recyclerView = fragmentTransportReceiptBinding.rvFeeReceipt) == null) {
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