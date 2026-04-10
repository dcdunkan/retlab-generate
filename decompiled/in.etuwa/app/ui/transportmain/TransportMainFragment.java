package in.etuwa.app.ui.transportmain;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
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
import com.google.android.material.button.MaterialButton;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.fee.receipts.ReceiptResponse;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.model.transport.TransportHistoryResponse;
import in.etuwa.app.data.model.transport.TransportInstallments;
import in.etuwa.app.data.model.transport.TransportPayUrl;
import in.etuwa.app.data.model.transportpalai.registration.RegisterViewResponse;
import in.etuwa.app.databinding.FragmentTransportMainBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.fees.transport.TransportFeeAdapter;
import in.etuwa.app.ui.fees.transport.receipt.TransportReceiptAdapter;
import in.etuwa.app.ui.transport.history.TransportHistoryAdapter;
import in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog;
import in.etuwa.app.ui.transport.registration.register.BoardingSpinnerAdapter;
import in.etuwa.app.ui.transport.registration.view.TransportRegHistoryAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: TransportMainFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TransportMainFragment extends BaseFragment implements TransportFeeAdapter.CallBack, TrasportFeePayDialog.FeeDetailListner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTransportMainBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: adapterFeeHistory$delegate, reason: from kotlin metadata */
    private final Lazy adapterFeeHistory;

    /* JADX INFO: renamed from: adapterHistory$delegate, reason: from kotlin metadata */
    private final Lazy adapterHistory;

    /* JADX INFO: renamed from: adapterReceipt$delegate, reason: from kotlin metadata */
    private final Lazy adapterReceipt;
    private ArrayList<TransportInstallments> list;
    private MainCallBackListener listener;
    private List<String> selected;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String studentId;
    private int total;

    /* JADX INFO: renamed from: transportMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy transportMainViewModel;
    private String yearId;

    /* JADX INFO: compiled from: TransportMainFragment.kt */
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
    public static final TransportMainFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog.FeeDetailListner
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog.FeeDetailListner
    public void openPaymentPage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TransportMainFragment() {
        final TransportMainFragment transportMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return transportMainFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(transportMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.transportMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(transportMainFragment, Reflection.getOrCreateKotlinClass(TransportMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(TransportMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TransportMainFragment transportMainFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TransportFeeAdapter>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.transport.TransportFeeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportFeeAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportFeeAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterReceipt = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<TransportReceiptAdapter>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.transport.receipt.TransportReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportReceiptAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterHistory = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<TransportRegHistoryAdapter>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.registration.view.TransportRegHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportRegHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportRegHistoryAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.adapterFeeHistory = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<TransportHistoryAdapter>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.history.TransportHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportHistoryAdapter.class), b8, b9);
            }
        });
        this.list = new ArrayList<>();
        this.selected = new ArrayList();
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<BoardingSpinnerAdapter>() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.registration.register.BoardingSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BoardingSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BoardingSpinnerAdapter.class), b10, function02);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransportMainViewModel getTransportMainViewModel() {
        return (TransportMainViewModel) this.transportMainViewModel.getValue();
    }

    private final TransportFeeAdapter getAdapter() {
        return (TransportFeeAdapter) this.adapter.getValue();
    }

    private final TransportReceiptAdapter getAdapterReceipt() {
        return (TransportReceiptAdapter) this.adapterReceipt.getValue();
    }

    private final TransportRegHistoryAdapter getAdapterHistory() {
        return (TransportRegHistoryAdapter) this.adapterHistory.getValue();
    }

    private final TransportHistoryAdapter getAdapterFeeHistory() {
        return (TransportHistoryAdapter) this.adapterFeeHistory.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentTransportMainBinding get_binding() {
        return this._binding;
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoardingSpinnerAdapter getSpinnerAdapter() {
        return (BoardingSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: compiled from: TransportMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/transportmain/TransportMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transportmain/TransportMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TransportMainFragment newInstance() {
            return new TransportMainFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTransportMainBinding.inflate(inflater, container, false);
        FragmentTransportMainBinding fragmentTransportMainBinding = get_binding();
        if (fragmentTransportMainBinding != null) {
            fragmentTransportMainBinding.setTransportMainViewModel(getTransportMainViewModel());
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = get_binding();
        if (fragmentTransportMainBinding2 != null) {
            fragmentTransportMainBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = get_binding();
        if (fragmentTransportMainBinding3 != null) {
            return fragmentTransportMainBinding3.getRoot();
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
        MaterialButton materialButton;
        SwipeRefreshLayout swipeRefreshLayout;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Transport Fees");
        }
        hideBaseView();
        FragmentTransportMainBinding fragmentTransportMainBinding = get_binding();
        RecyclerView recyclerView = fragmentTransportMainBinding != null ? fragmentTransportMainBinding.rvTransport : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = get_binding();
        Spinner spinner = fragmentTransportMainBinding2 != null ? fragmentTransportMainBinding2.spinnerYearTransport : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinnerResponse();
        listenUrlResponse();
        listenReceiptResponse();
        listenHistoryResponse();
        listenTransportFeeHistoryResponse();
        final HashMap map = new HashMap();
        getAdapter().setCallBackNew(this);
        getTransportMainViewModel().getTransportFeeYears();
        FragmentTransportMainBinding fragmentTransportMainBinding3 = get_binding();
        if (fragmentTransportMainBinding3 != null && (textView6 = fragmentTransportMainBinding3.feesBtn) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportMainFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding4 = get_binding();
        if (fragmentTransportMainBinding4 != null && (textView5 = fragmentTransportMainBinding4.receiptBtn) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportMainFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding5 = get_binding();
        if (fragmentTransportMainBinding5 != null && (textView4 = fragmentTransportMainBinding5.registrationBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportMainFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding6 = get_binding();
        if (fragmentTransportMainBinding6 != null && (textView3 = fragmentTransportMainBinding6.historyBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportMainFragment.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding7 = get_binding();
        if (fragmentTransportMainBinding7 != null && (textView2 = fragmentTransportMainBinding7.busPassBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportMainFragment.setUp$lambda$4(this.f$0, view);
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding8 = get_binding();
        if (fragmentTransportMainBinding8 != null && (textView = fragmentTransportMainBinding8.gatewayBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportMainFragment.setUp$lambda$5(this.f$0, view);
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding9 = get_binding();
        if (fragmentTransportMainBinding9 != null && (swipeRefreshLayout = fragmentTransportMainBinding9.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda12
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    TransportMainFragment.setUp$lambda$6(this.f$0);
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding10 = get_binding();
        Spinner spinner2 = fragmentTransportMainBinding10 != null ? fragmentTransportMainBinding10.spinnerYearTransport : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment.setUp.8
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TransportMainFragment transportMainFragment = TransportMainFragment.this;
                    transportMainFragment.yearId = String.valueOf(transportMainFragment.getSpinnerAdapter().getType(position).getId());
                    TransportMainViewModel transportMainViewModel = TransportMainFragment.this.getTransportMainViewModel();
                    String str = TransportMainFragment.this.yearId;
                    Intrinsics.checkNotNull(str);
                    transportMainViewModel.getTransportFees(str);
                    TransportMainFragment.this.listenResponse();
                }
            });
        }
        FragmentTransportMainBinding fragmentTransportMainBinding11 = get_binding();
        if (fragmentTransportMainBinding11 == null || (materialButton = fragmentTransportMainBinding11.payTransportBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransportMainFragment.setUp$lambda$7(map, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TransportMainFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTransportMainViewModel().getTransportFeeYears();
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding != null && (textView12 = fragmentTransportMainBinding.receiptBtn) != null) {
            textView12.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
        if (fragmentTransportMainBinding2 != null && (textView11 = fragmentTransportMainBinding2.feesBtn) != null) {
            textView11.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
        if (fragmentTransportMainBinding3 != null && (textView10 = fragmentTransportMainBinding3.registrationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding4 = this$0.get_binding();
        if (fragmentTransportMainBinding4 != null && (textView9 = fragmentTransportMainBinding4.historyBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding5 = this$0.get_binding();
        if (fragmentTransportMainBinding5 != null && (textView8 = fragmentTransportMainBinding5.busPassBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding6 = this$0.get_binding();
        if (fragmentTransportMainBinding6 != null && (textView7 = fragmentTransportMainBinding6.gatewayBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding7 = this$0.get_binding();
        if (fragmentTransportMainBinding7 != null && (textView6 = fragmentTransportMainBinding7.receiptBtn) != null) {
            textView6.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding8 = this$0.get_binding();
        if (fragmentTransportMainBinding8 != null && (textView5 = fragmentTransportMainBinding8.feesBtn) != null) {
            textView5.setTextColor(-1);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding9 = this$0.get_binding();
        if (fragmentTransportMainBinding9 != null && (textView4 = fragmentTransportMainBinding9.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding10 = this$0.get_binding();
        if (fragmentTransportMainBinding10 != null && (textView3 = fragmentTransportMainBinding10.historyBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding11 = this$0.get_binding();
        if (fragmentTransportMainBinding11 != null && (textView2 = fragmentTransportMainBinding11.busPassBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding12 = this$0.get_binding();
        if (fragmentTransportMainBinding12 == null || (textView = fragmentTransportMainBinding12.gatewayBtn) == null) {
            return;
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TransportMainFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTransportMainViewModel().getReceipts();
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding != null && (textView12 = fragmentTransportMainBinding.receiptBtn) != null) {
            textView12.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
        if (fragmentTransportMainBinding2 != null && (textView11 = fragmentTransportMainBinding2.feesBtn) != null) {
            textView11.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
        if (fragmentTransportMainBinding3 != null && (textView10 = fragmentTransportMainBinding3.registrationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding4 = this$0.get_binding();
        if (fragmentTransportMainBinding4 != null && (textView9 = fragmentTransportMainBinding4.historyBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding5 = this$0.get_binding();
        if (fragmentTransportMainBinding5 != null && (textView8 = fragmentTransportMainBinding5.busPassBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding6 = this$0.get_binding();
        if (fragmentTransportMainBinding6 != null && (textView7 = fragmentTransportMainBinding6.gatewayBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding7 = this$0.get_binding();
        if (fragmentTransportMainBinding7 != null && (textView6 = fragmentTransportMainBinding7.receiptBtn) != null) {
            textView6.setTextColor(-1);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding8 = this$0.get_binding();
        if (fragmentTransportMainBinding8 != null && (textView5 = fragmentTransportMainBinding8.feesBtn) != null) {
            textView5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding9 = this$0.get_binding();
        if (fragmentTransportMainBinding9 != null && (textView4 = fragmentTransportMainBinding9.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding10 = this$0.get_binding();
        if (fragmentTransportMainBinding10 != null && (textView3 = fragmentTransportMainBinding10.historyBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding11 = this$0.get_binding();
        if (fragmentTransportMainBinding11 != null && (textView2 = fragmentTransportMainBinding11.busPassBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding12 = this$0.get_binding();
        if (fragmentTransportMainBinding12 == null || (textView = fragmentTransportMainBinding12.gatewayBtn) == null) {
            return;
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(TransportMainFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTransportMainViewModel().getRegHistory();
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding != null && (textView12 = fragmentTransportMainBinding.receiptBtn) != null) {
            textView12.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
        if (fragmentTransportMainBinding2 != null && (textView11 = fragmentTransportMainBinding2.feesBtn) != null) {
            textView11.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
        if (fragmentTransportMainBinding3 != null && (textView10 = fragmentTransportMainBinding3.registrationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding4 = this$0.get_binding();
        if (fragmentTransportMainBinding4 != null && (textView9 = fragmentTransportMainBinding4.historyBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding5 = this$0.get_binding();
        if (fragmentTransportMainBinding5 != null && (textView8 = fragmentTransportMainBinding5.busPassBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding6 = this$0.get_binding();
        if (fragmentTransportMainBinding6 != null && (textView7 = fragmentTransportMainBinding6.gatewayBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding7 = this$0.get_binding();
        if (fragmentTransportMainBinding7 != null && (textView6 = fragmentTransportMainBinding7.receiptBtn) != null) {
            textView6.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding8 = this$0.get_binding();
        if (fragmentTransportMainBinding8 != null && (textView5 = fragmentTransportMainBinding8.feesBtn) != null) {
            textView5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding9 = this$0.get_binding();
        if (fragmentTransportMainBinding9 != null && (textView4 = fragmentTransportMainBinding9.registrationBtn) != null) {
            textView4.setTextColor(-1);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding10 = this$0.get_binding();
        if (fragmentTransportMainBinding10 != null && (textView3 = fragmentTransportMainBinding10.historyBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding11 = this$0.get_binding();
        if (fragmentTransportMainBinding11 != null && (textView2 = fragmentTransportMainBinding11.busPassBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding12 = this$0.get_binding();
        if (fragmentTransportMainBinding12 == null || (textView = fragmentTransportMainBinding12.gatewayBtn) == null) {
            return;
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(TransportMainFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTransportMainViewModel().getTransportFeeHistory();
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding != null && (textView12 = fragmentTransportMainBinding.receiptBtn) != null) {
            textView12.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
        if (fragmentTransportMainBinding2 != null && (textView11 = fragmentTransportMainBinding2.feesBtn) != null) {
            textView11.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
        if (fragmentTransportMainBinding3 != null && (textView10 = fragmentTransportMainBinding3.registrationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding4 = this$0.get_binding();
        if (fragmentTransportMainBinding4 != null && (textView9 = fragmentTransportMainBinding4.historyBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding5 = this$0.get_binding();
        if (fragmentTransportMainBinding5 != null && (textView8 = fragmentTransportMainBinding5.busPassBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding6 = this$0.get_binding();
        if (fragmentTransportMainBinding6 != null && (textView7 = fragmentTransportMainBinding6.gatewayBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding7 = this$0.get_binding();
        if (fragmentTransportMainBinding7 != null && (textView6 = fragmentTransportMainBinding7.receiptBtn) != null) {
            textView6.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding8 = this$0.get_binding();
        if (fragmentTransportMainBinding8 != null && (textView5 = fragmentTransportMainBinding8.feesBtn) != null) {
            textView5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding9 = this$0.get_binding();
        if (fragmentTransportMainBinding9 != null && (textView4 = fragmentTransportMainBinding9.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding10 = this$0.get_binding();
        if (fragmentTransportMainBinding10 != null && (textView3 = fragmentTransportMainBinding10.historyBtn) != null) {
            textView3.setTextColor(-1);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding11 = this$0.get_binding();
        if (fragmentTransportMainBinding11 != null && (textView2 = fragmentTransportMainBinding11.busPassBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding12 = this$0.get_binding();
        if (fragmentTransportMainBinding12 == null || (textView = fragmentTransportMainBinding12.gatewayBtn) == null) {
            return;
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(TransportMainFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTransportMainViewModel().getBusPassResponse();
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding != null && (textView12 = fragmentTransportMainBinding.receiptBtn) != null) {
            textView12.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
        if (fragmentTransportMainBinding2 != null && (textView11 = fragmentTransportMainBinding2.feesBtn) != null) {
            textView11.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
        if (fragmentTransportMainBinding3 != null && (textView10 = fragmentTransportMainBinding3.registrationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding4 = this$0.get_binding();
        if (fragmentTransportMainBinding4 != null && (textView9 = fragmentTransportMainBinding4.historyBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding5 = this$0.get_binding();
        if (fragmentTransportMainBinding5 != null && (textView8 = fragmentTransportMainBinding5.busPassBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding6 = this$0.get_binding();
        if (fragmentTransportMainBinding6 != null && (textView7 = fragmentTransportMainBinding6.gatewayBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding7 = this$0.get_binding();
        if (fragmentTransportMainBinding7 != null && (textView6 = fragmentTransportMainBinding7.receiptBtn) != null) {
            textView6.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding8 = this$0.get_binding();
        if (fragmentTransportMainBinding8 != null && (textView5 = fragmentTransportMainBinding8.feesBtn) != null) {
            textView5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding9 = this$0.get_binding();
        if (fragmentTransportMainBinding9 != null && (textView4 = fragmentTransportMainBinding9.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding10 = this$0.get_binding();
        if (fragmentTransportMainBinding10 != null && (textView3 = fragmentTransportMainBinding10.historyBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding11 = this$0.get_binding();
        if (fragmentTransportMainBinding11 != null && (textView2 = fragmentTransportMainBinding11.busPassBtn) != null) {
            textView2.setTextColor(-1);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding12 = this$0.get_binding();
        if (fragmentTransportMainBinding12 == null || (textView = fragmentTransportMainBinding12.gatewayBtn) == null) {
            return;
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(TransportMainFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding != null && (textView12 = fragmentTransportMainBinding.receiptBtn) != null) {
            textView12.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
        if (fragmentTransportMainBinding2 != null && (textView11 = fragmentTransportMainBinding2.feesBtn) != null) {
            textView11.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
        if (fragmentTransportMainBinding3 != null && (textView10 = fragmentTransportMainBinding3.registrationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding4 = this$0.get_binding();
        if (fragmentTransportMainBinding4 != null && (textView9 = fragmentTransportMainBinding4.historyBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding5 = this$0.get_binding();
        if (fragmentTransportMainBinding5 != null && (textView8 = fragmentTransportMainBinding5.busPassBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding6 = this$0.get_binding();
        if (fragmentTransportMainBinding6 != null && (textView7 = fragmentTransportMainBinding6.gatewayBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding7 = this$0.get_binding();
        if (fragmentTransportMainBinding7 != null && (textView6 = fragmentTransportMainBinding7.receiptBtn) != null) {
            textView6.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding8 = this$0.get_binding();
        if (fragmentTransportMainBinding8 != null && (textView5 = fragmentTransportMainBinding8.feesBtn) != null) {
            textView5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding9 = this$0.get_binding();
        if (fragmentTransportMainBinding9 != null && (textView4 = fragmentTransportMainBinding9.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding10 = this$0.get_binding();
        if (fragmentTransportMainBinding10 != null && (textView3 = fragmentTransportMainBinding10.historyBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding11 = this$0.get_binding();
        if (fragmentTransportMainBinding11 != null && (textView2 = fragmentTransportMainBinding11.busPassBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentTransportMainBinding fragmentTransportMainBinding12 = this$0.get_binding();
        if (fragmentTransportMainBinding12 == null || (textView = fragmentTransportMainBinding12.gatewayBtn) == null) {
            return;
        }
        textView.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(TransportMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TransportMainViewModel transportMainViewModel = this$0.getTransportMainViewModel();
        String str = this$0.yearId;
        Intrinsics.checkNotNull(str);
        transportMainViewModel.getTransportFees(str);
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentTransportMainBinding != null ? fragmentTransportMainBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(HashMap transportFeeCollection, TransportMainFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(transportFeeCollection, "$transportFeeCollection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap map = transportFeeCollection;
        map.put("year_id", String.valueOf(this$0.yearId));
        map.put("TransportReceipt[method]", "4");
        map.put("Payment", "1");
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        CharSequence text = null;
        map.put("TransportReceipt[amount]", String.valueOf((fragmentTransportMainBinding == null || (textView2 = fragmentTransportMainBinding.tvTransportTotal) == null) ? null : textView2.getText()));
        FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
        if (fragmentTransportMainBinding2 != null && (textView = fragmentTransportMainBinding2.tvTransportTotal) != null) {
            text = textView.getText();
        }
        map.put("TransportReceipt[sub_total]", String.valueOf(text));
        map.put("TransportReceipt[fine_amount]", "0");
        int size = this$0.selected.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (Intrinsics.areEqual(this$0.selected.get(i), "true")) {
                    map.put("TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][head_id]", this$0.list.get(i).getHead_id());
                    String str = "TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][student_id]";
                    String str2 = this$0.studentId;
                    Intrinsics.checkNotNull(str2);
                    map.put(str, str2);
                    map.put("TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][installment_id]", this$0.list.get(i).getInstallment_id());
                    map.put("TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][fine]", "");
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this$0.getTransportMainViewModel().getTransportFeesUrl(map);
    }

    private final void listenSpinnerResponse() {
        getTransportMainViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportMainFragment.listenSpinnerResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSpinnerResponse$lambda$9(TransportMainFragment this$0, Resource resource) {
        RecyclerView rvTransport;
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
            FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
            if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        TransportFeeResponse transportFeeResponse = (TransportFeeResponse) resource.getData();
        if (transportFeeResponse != null) {
            this$0.showBaseView();
            if (Intrinsics.areEqual(transportFeeResponse.getError(), "")) {
                this$0.getSpinnerAdapter().addItems(transportFeeResponse.getYears());
                this$0.yearId = String.valueOf(transportFeeResponse.getYears().get(0).getId());
                FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
                TextView textView = fragmentTransportMainBinding2 != null ? fragmentTransportMainBinding2.boardingPointTv : null;
                if (textView == null) {
                    return;
                }
                textView.setText("BoardingPoint : " + transportFeeResponse.getBoarding_point());
                return;
            }
            FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
            if (fragmentTransportMainBinding3 == null || (rvTransport = fragmentTransportMainBinding3.rvTransport) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvTransport, "rvTransport");
            ToastExtKt.showErrorToast(rvTransport, transportFeeResponse.getError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void listenResponse() {
        getTransportMainViewModel().getFeesResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportMainFragment.listenResponse$lambda$11(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$11(TransportMainFragment this$0, Resource resource) {
        RecyclerView rvTransport;
        TextView textView;
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
            FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
            if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        TransportFeeResponse transportFeeResponse = (TransportFeeResponse) resource.getData();
        if (transportFeeResponse != null) {
            this$0.showBaseView();
            try {
                if (Intrinsics.areEqual(transportFeeResponse.getError(), "")) {
                    FragmentTransportMainBinding fragmentTransportMainBinding2 = this$0.get_binding();
                    SwipeRefreshLayout swipeRefreshLayout = fragmentTransportMainBinding2 != null ? fragmentTransportMainBinding2.swipeLayout : null;
                    if (swipeRefreshLayout != null) {
                        swipeRefreshLayout.setVisibility(0);
                    }
                    FragmentTransportMainBinding fragmentTransportMainBinding3 = this$0.get_binding();
                    LinearLayout linearLayout = fragmentTransportMainBinding3 != null ? fragmentTransportMainBinding3.noDataLyt : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    this$0.getAdapter().addItems(transportFeeResponse.getInstallments());
                    this$0.list = transportFeeResponse.getInstallments();
                    FragmentTransportMainBinding fragmentTransportMainBinding4 = this$0.get_binding();
                    textView = fragmentTransportMainBinding4 != null ? fragmentTransportMainBinding4.noDataTv : null;
                    if (textView != null) {
                        textView.setText(transportFeeResponse.getError());
                    }
                } else {
                    FragmentTransportMainBinding fragmentTransportMainBinding5 = this$0.get_binding();
                    SwipeRefreshLayout swipeRefreshLayout2 = fragmentTransportMainBinding5 != null ? fragmentTransportMainBinding5.swipeLayout : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setVisibility(8);
                    }
                    FragmentTransportMainBinding fragmentTransportMainBinding6 = this$0.get_binding();
                    LinearLayout linearLayout2 = fragmentTransportMainBinding6 != null ? fragmentTransportMainBinding6.noDataLyt : null;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    FragmentTransportMainBinding fragmentTransportMainBinding7 = this$0.get_binding();
                    textView = fragmentTransportMainBinding7 != null ? fragmentTransportMainBinding7.noDataTv : null;
                    if (textView != null) {
                        textView.setText(transportFeeResponse.getError());
                    }
                }
            } catch (NullPointerException unused) {
                this$0.getAdapter().clearData();
                FragmentTransportMainBinding fragmentTransportMainBinding8 = this$0.get_binding();
                if (fragmentTransportMainBinding8 != null && (rvTransport = fragmentTransportMainBinding8.rvTransport) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvTransport, "rvTransport");
                    ToastExtKt.showErrorToast(rvTransport, transportFeeResponse.getError());
                }
            }
            this$0.studentId = transportFeeResponse.getStudent_id();
        }
    }

    private final void listenUrlResponse() {
        getTransportMainViewModel().getFeesUrlResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportMainFragment.listenUrlResponse$lambda$13(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUrlResponse$lambda$13(TransportMainFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TransportPayUrl transportPayUrl = (TransportPayUrl) resource.getData();
            if (transportPayUrl != null) {
                this$0.showBaseView();
                System.out.println((Object) transportPayUrl.getUrl());
                if (Intrinsics.areEqual(transportPayUrl.getUrl(), "") || (mainCallBackListener = this$0.listener) == null) {
                    return;
                }
                mainCallBackListener.openPaymentPage(transportPayUrl.getUrl());
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
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenReceiptResponse() {
        getTransportMainViewModel().getReceiptResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportMainFragment.listenReceiptResponse$lambda$15(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenReceiptResponse$lambda$15(TransportMainFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ReceiptResponse receiptResponse = (ReceiptResponse) resource.getData();
            if (receiptResponse != null) {
                this$0.showBaseView();
                this$0.getAdapterReceipt().addItems(receiptResponse.getReceipts());
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
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenHistoryResponse() {
        getTransportMainViewModel().getHistoryResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportMainFragment.listenHistoryResponse$lambda$17(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenHistoryResponse$lambda$17(TransportMainFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            RegisterViewResponse registerViewResponse = (RegisterViewResponse) resource.getData();
            if (registerViewResponse != null) {
                this$0.showBaseView();
                this$0.getAdapterHistory().addItems(registerViewResponse.getHistory());
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
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenTransportFeeHistoryResponse() {
        getTransportMainViewModel().getFeeHistoryResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transportmain.TransportMainFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportMainFragment.listenTransportFeeHistoryResponse$lambda$19(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenTransportFeeHistoryResponse$lambda$19(TransportMainFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TransportHistoryResponse transportHistoryResponse = (TransportHistoryResponse) resource.getData();
            if (transportHistoryResponse != null) {
                this$0.showBaseView();
                this$0.getAdapterFeeHistory().addItems(transportHistoryResponse.getHistory());
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
        FragmentTransportMainBinding fragmentTransportMainBinding = this$0.get_binding();
        if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
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

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentTransportMainBinding fragmentTransportMainBinding = get_binding();
        if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentTransportMainBinding fragmentTransportMainBinding = get_binding();
        if (fragmentTransportMainBinding == null || (recyclerView = fragmentTransportMainBinding.rvTransport) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.fees.transport.TransportFeeAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        MaterialButton materialButton;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        System.out.println(total);
        int size = total.size() - 1;
        int i = 0;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                i += Integer.parseInt(total.get(i2));
                if (i2 == size) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.selected = sel;
        this.total = i;
        FragmentTransportMainBinding fragmentTransportMainBinding = get_binding();
        TextView textView = fragmentTransportMainBinding != null ? fragmentTransportMainBinding.tvTransportTotal : null;
        if (textView != null) {
            textView.setText(String.valueOf(i));
        }
        if (i <= 0) {
            FragmentTransportMainBinding fragmentTransportMainBinding2 = get_binding();
            materialButton = fragmentTransportMainBinding2 != null ? fragmentTransportMainBinding2.payTransportBtn : null;
            if (materialButton == null) {
                return;
            }
            materialButton.setVisibility(8);
            return;
        }
        FragmentTransportMainBinding fragmentTransportMainBinding3 = get_binding();
        materialButton = fragmentTransportMainBinding3 != null ? fragmentTransportMainBinding3.payTransportBtn : null;
        if (materialButton == null) {
            return;
        }
        materialButton.setVisibility(0);
    }
}