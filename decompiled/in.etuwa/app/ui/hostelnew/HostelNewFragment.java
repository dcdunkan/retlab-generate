package in.etuwa.app.ui.hostelnew;

import android.content.ComponentCallbacks;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.HostelFee;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmission;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmissionResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewHistoryResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthly;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthlyResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewPay;
import in.etuwa.app.data.model.hostelnew.HostelStatusNew;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentHostelNewBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewHistory2Adapter;
import in.etuwa.app.ui.hostelnew.HostelNewHistoryAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewReceiptAdapter;
import in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmDialog;
import in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
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

/* JADX INFO: compiled from: HostelNewFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelNewFragment extends BaseFragment implements HostelNewAdmissionAdapter.CallBack, HostelNewMonthlyAdapter.CallBack, HostelNewReceiptAdapter.CallBack, HostelNewDetailsDialog.FeeDetailListner, HostelNewConfirmDialog.FeeDetailListner, HostelNewHistoryAdapter.CallBack, HostelNewHistory2Adapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelNewBinding _binding;

    /* JADX INFO: renamed from: adapterAdmission$delegate, reason: from kotlin metadata */
    private final Lazy adapterAdmission;

    /* JADX INFO: renamed from: adapterAdmissionHistory$delegate, reason: from kotlin metadata */
    private final Lazy adapterAdmissionHistory;

    /* JADX INFO: renamed from: adapterMonthly$delegate, reason: from kotlin metadata */
    private final Lazy adapterMonthly;

    /* JADX INFO: renamed from: adapterMonthlyHistory$delegate, reason: from kotlin metadata */
    private final Lazy adapterMonthlyHistory;

    /* JADX INFO: renamed from: adapterReceipt$delegate, reason: from kotlin metadata */
    private final Lazy adapterReceipt;
    private String date;
    private Integer fine;
    private ArrayList<HostelNewAdmission> hostelAdmission;
    private ArrayList<HostelNewMonthly> hostelMonthly;

    /* JADX INFO: renamed from: hostelNewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelNewViewModel;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private Boolean status;
    private Integer subtotal;

    /* JADX INFO: compiled from: HostelNewFragment.kt */
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
    public static final HostelNewFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmDialog.FeeDetailListner
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmDialog.FeeDetailListner
    public void openPaymentPage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewReceiptAdapter.CallBack
    public void receiptDownload(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public HostelNewFragment() {
        final HostelNewFragment hostelNewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return hostelNewFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelNewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelNewViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelNewFragment, Reflection.getOrCreateKotlinClass(HostelNewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(HostelNewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelNewFragment hostelNewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapterMonthly = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelNewMonthlyAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewMonthlyAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewMonthlyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterAdmission = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<HostelNewAdmissionAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewAdmissionAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewAdmissionAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterReceipt = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<HostelNewReceiptAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewReceiptAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.adapterAdmissionHistory = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<HostelNewHistoryAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewHistoryAdapter.class), b8, b9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        final byte b11 = 0 == true ? 1 : 0;
        this.adapterMonthlyHistory = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<HostelNewHistory2Adapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewHistory2Adapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewHistory2Adapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewHistory2Adapter.class), b10, b11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b12 = 0 == true ? 1 : 0;
        final byte b13 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b12, b13);
            }
        });
        this.hostelAdmission = new ArrayList<>();
        this.hostelMonthly = new ArrayList<>();
        this.status = false;
    }

    private final HostelNewViewModel getHostelNewViewModel() {
        return (HostelNewViewModel) this.hostelNewViewModel.getValue();
    }

    private final HostelNewMonthlyAdapter getAdapterMonthly() {
        return (HostelNewMonthlyAdapter) this.adapterMonthly.getValue();
    }

    private final HostelNewAdmissionAdapter getAdapterAdmission() {
        return (HostelNewAdmissionAdapter) this.adapterAdmission.getValue();
    }

    private final HostelNewReceiptAdapter getAdapterReceipt() {
        return (HostelNewReceiptAdapter) this.adapterReceipt.getValue();
    }

    private final HostelNewHistoryAdapter getAdapterAdmissionHistory() {
        return (HostelNewHistoryAdapter) this.adapterAdmissionHistory.getValue();
    }

    private final HostelNewHistory2Adapter getAdapterMonthlyHistory() {
        return (HostelNewHistory2Adapter) this.adapterMonthlyHistory.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentHostelNewBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final void setStatus(Boolean bool) {
        this.status = bool;
    }

    public final Integer getFine() {
        return this.fine;
    }

    public final void setFine(Integer num) {
        this.fine = num;
    }

    public final Integer getSubtotal() {
        return this.subtotal;
    }

    public final void setSubtotal(Integer num) {
        this.subtotal = num;
    }

    /* JADX INFO: compiled from: HostelNewFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostelnew/HostelNewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostelnew/HostelNewFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelNewFragment newInstance() {
            return new HostelNewFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHostelNewBinding.inflate(inflater, container, false);
        FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
        if (fragmentHostelNewBinding != null) {
            fragmentHostelNewBinding.setHostelNewViewModel(getHostelNewViewModel());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
        if (fragmentHostelNewBinding2 != null) {
            fragmentHostelNewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        if (fragmentHostelNewBinding3 != null) {
            return fragmentHostelNewBinding3.getRoot();
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
        MaterialButton materialButton2;
        MaterialButton materialButton3;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Fee");
        }
        hideBaseView();
        FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.rvMonthly : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapterMonthly());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.rvAdmission : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterAdmission());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        RecyclerView recyclerView3 = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.rvReceipts : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapterReceipt());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding4 = get_binding();
        RecyclerView recyclerView4 = fragmentHostelNewBinding4 != null ? fragmentHostelNewBinding4.rvAdmissionHistory : null;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(getAdapterAdmissionHistory());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding5 = get_binding();
        RecyclerView recyclerView5 = fragmentHostelNewBinding5 != null ? fragmentHostelNewBinding5.rvMonthlyHistory : null;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(getAdapterMonthlyHistory());
        }
        getAdapterMonthly().setCallBack(this);
        getAdapterAdmission().setCallBack(this);
        getPreference().setNewLogin(false);
        getHostelNewViewModel().getHostelStatus();
        listenAdmissionResponse();
        listenMonthlyResponse();
        listenHistoryResponse();
        listenPayResponse();
        listenStatusResponse();
        final HashMap map = new HashMap();
        final HashMap map2 = new HashMap();
        getHostelNewViewModel().getHostelAdmissionFee();
        getHostelNewViewModel().getHostelMonthlyFee();
        getHostelNewViewModel().getHostelHistory();
        FragmentHostelNewBinding fragmentHostelNewBinding6 = get_binding();
        if (fragmentHostelNewBinding6 != null && (materialButton3 = fragmentHostelNewBinding6.payOnlineBtn) != null) {
            materialButton3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelNewFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        FragmentHostelNewBinding fragmentHostelNewBinding7 = get_binding();
        if (fragmentHostelNewBinding7 != null && (materialButton2 = fragmentHostelNewBinding7.receiptBtn) != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelNewFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentHostelNewBinding fragmentHostelNewBinding8 = get_binding();
        if (fragmentHostelNewBinding8 == null || (materialButton = fragmentHostelNewBinding8.payFeeEngnrBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelNewFragment.setUp$lambda$2(map2, map, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(HostelNewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        MaterialButton materialButton = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.payOnlineBtn : null;
        if (materialButton != null) {
            materialButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = this$0.get_binding();
        MaterialButton materialButton2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.receiptBtn : null;
        if (materialButton2 != null) {
            materialButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2077C9")));
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.swipeLayout : null;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setVisibility(0);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding4 = this$0.get_binding();
        MaterialCardView materialCardView = fragmentHostelNewBinding4 != null ? fragmentHostelNewBinding4.payBtnLyt : null;
        if (materialCardView != null) {
            materialCardView.setVisibility(0);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding5 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout2 = fragmentHostelNewBinding5 != null ? fragmentHostelNewBinding5.swipeLayoutHistory : null;
        if (swipeRefreshLayout2 == null) {
            return;
        }
        swipeRefreshLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HostelNewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        MaterialButton materialButton = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.payOnlineBtn : null;
        if (materialButton != null) {
            materialButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2077C9")));
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = this$0.get_binding();
        MaterialButton materialButton2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.receiptBtn : null;
        if (materialButton2 != null) {
            materialButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.swipeLayout : null;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setVisibility(8);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding4 = this$0.get_binding();
        MaterialCardView materialCardView = fragmentHostelNewBinding4 != null ? fragmentHostelNewBinding4.payBtnLyt : null;
        if (materialCardView != null) {
            materialCardView.setVisibility(8);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding5 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout2 = fragmentHostelNewBinding5 != null ? fragmentHostelNewBinding5.swipeLayoutHistory : null;
        if (swipeRefreshLayout2 == null) {
            return;
        }
        swipeRefreshLayout2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(HashMap map, HashMap feeCollection, HostelNewFragment hostelNewFragment, View view) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj;
        String str9;
        String str10;
        double d;
        String str11;
        Object obj2;
        String str12;
        String str13;
        String str14;
        int i2;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        Object obj3;
        String str23;
        int i3;
        String str24;
        String str25;
        HostelNewFragment hostelNewFragment2;
        Object obj4;
        int i4;
        String str26;
        String str27;
        HashMap feeReceipt = map;
        HostelNewFragment this$0 = hostelNewFragment;
        Intrinsics.checkNotNullParameter(feeReceipt, "$feeReceipt");
        Intrinsics.checkNotNullParameter(feeCollection, "$feeCollection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        map.clear();
        feeCollection.clear();
        this$0.hostelAdmission = hostelNewFragment.getAdapterAdmission().getItems();
        this$0.hostelMonthly = hostelNewFragment.getAdapterMonthly().getItems();
        int size = this$0.hostelAdmission.size();
        double balance = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i5 = 0; i5 < size; i5++) {
            if (this$0.hostelAdmission.get(i5).is_selected()) {
                balance += this$0.hostelAdmission.get(i5).getBalance();
            }
        }
        int size2 = this$0.hostelMonthly.size();
        int fine = 0;
        for (int i6 = 0; i6 < size2; i6++) {
            if (this$0.hostelMonthly.get(i6).is_selected()) {
                balance += (double) this$0.hostelMonthly.get(i6).getBalance();
                fine += this$0.hostelMonthly.get(i6).getFine();
            }
        }
        int size3 = this$0.hostelAdmission.size();
        int i7 = 0;
        while (true) {
            i = fine;
            str = "Sub Total";
            str2 = "Fine";
            str3 = "HostelFeeReceipt[amount]";
            str4 = "HostelFeeReceipt[fine_amount]";
            str5 = "4";
            str6 = "][amount]";
            str7 = "payment";
            str8 = "1";
            obj = "Total";
            str9 = "HostelFeeCollection[";
            if (i7 >= size3) {
                break;
            }
            int i8 = size3;
            if (this$0.hostelAdmission.get(i7).is_selected()) {
                ArrayList<HostelFee> payment = this$0.hostelAdmission.get(i7).getPayment();
                int size4 = payment.size();
                String str28 = "][";
                HashMap map2 = feeReceipt;
                map2.put("payment", "1");
                map2.put("fee_group_type", "1");
                map2.put("Transaction[method]", "4");
                double amount = ((double) ((int) payment.get(i7).getAmount())) - (payment.get(i7).getPayable() + ((double) payment.get(i7).getPaid()));
                map2.put("HostelFeeReceipt[fine_amount]", String.valueOf(amount));
                map2.put("HostelFeeReceipt[total_amount]", String.valueOf(amount + balance));
                map2.put("HostelFeeReceipt[amount]", String.valueOf(balance));
                map2.put("fine_8", "0");
                int i9 = 0;
                while (i9 < size4) {
                    if (Intrinsics.areEqual(payment.get(i9).getName(), "Fine") || Intrinsics.areEqual(payment.get(i9).getName(), "Sub Total")) {
                        obj4 = obj;
                    } else {
                        obj4 = obj;
                        if (!Intrinsics.areEqual(payment.get(i9).getName(), obj4)) {
                            HashMap map3 = feeCollection;
                            int installment = payment.get(i9).getInstallment();
                            String feegroup_id = payment.get(i9).getFeegroup_id();
                            String feehead_id = payment.get(i9).getFeehead_id();
                            str26 = str9;
                            StringBuilder sb = new StringBuilder(str26);
                            sb.append(installment);
                            str27 = str28;
                            sb.append(str27);
                            sb.append(feegroup_id);
                            sb.append(str27);
                            sb.append(feehead_id);
                            String str29 = str6;
                            sb.append(str29);
                            map3.put(sb.toString(), String.valueOf(payment.get(i9).getBalance()));
                            int i10 = size4;
                            str6 = str29;
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][feegroup_id]", payment.get(i9).getFeegroup_id());
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][feehead_id]", payment.get(i9).getFeehead_id());
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][tenant_id]", payment.get(i9).getTenant_id());
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][installment]", String.valueOf(payment.get(i9).getInstallment()));
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][user_id]", payment.get(i9).getUser_id());
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][status]", String.valueOf(payment.get(i9).getStatus()));
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][hostel_id]", payment.get(i9).getHostel_id());
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][month]", hostelNewFragment.hostelAdmission.get(i7).getM());
                            i4 = i10;
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][year]", hostelNewFragment.hostelAdmission.get(i7).getY());
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][feeheadgroup_id]", payment.get(i9).getFeeheadgroup_id());
                            map3.put(str26 + payment.get(i9).getInstallment() + str27 + payment.get(i9).getFeegroup_id() + str27 + payment.get(i9).getFeehead_id() + "][scholarship_amount]", String.valueOf(payment.get(i9).getAdjustment()));
                            i9++;
                            obj = obj4;
                            str28 = str27;
                            size4 = i4;
                            str9 = str26;
                        }
                    }
                    str26 = str9;
                    str27 = str28;
                    i4 = size4;
                    i9++;
                    obj = obj4;
                    str28 = str27;
                    size4 = i4;
                    str9 = str26;
                }
                hostelNewFragment2 = hostelNewFragment;
            } else {
                hostelNewFragment2 = this$0;
            }
            i7++;
            feeReceipt = map;
            this$0 = hostelNewFragment2;
            fine = i;
            size3 = i8;
        }
        HostelNewFragment hostelNewFragment3 = this$0;
        Object obj5 = obj;
        String str30 = str9;
        int size5 = hostelNewFragment3.hostelMonthly.size();
        String str31 = "][";
        int i11 = 0;
        while (i11 < size5) {
            int i12 = size5;
            if (hostelNewFragment3.hostelMonthly.get(i11).is_selected()) {
                ArrayList<HostelFee> payment2 = hostelNewFragment3.hostelMonthly.get(i11).getPayment();
                String str32 = str30;
                int size6 = payment2.size();
                Object obj6 = obj5;
                str12 = str;
                HashMap map4 = map;
                map4.put(str7, str8);
                map4.put("Transaction[method]", str5);
                str10 = str8;
                map4.put(str4, String.valueOf(i));
                str14 = str4;
                int i13 = i;
                str18 = str5;
                map4.put("HostelFeeReceipt[total_amount]", String.valueOf(((double) i13) + balance));
                map4.put(str3, String.valueOf(balance));
                i2 = i13;
                d = balance;
                map4.put("fine_" + hostelNewFragment3.hostelMonthly.get(i11).getYear() + HelpFormatter.DEFAULT_OPT_PREFIX + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + "-01", String.valueOf(hostelNewFragment3.hostelMonthly.get(i11).getFine()));
                int i14 = 0;
                while (i14 < size6) {
                    if (!Intrinsics.areEqual(payment2.get(i14).getName(), str2)) {
                        String str33 = str12;
                        if (Intrinsics.areEqual(payment2.get(i14).getName(), str33)) {
                            str12 = str33;
                        } else {
                            Object obj7 = obj6;
                            if (Intrinsics.areEqual(payment2.get(i14).getName(), obj7)) {
                                i3 = size6;
                                str12 = str33;
                                str20 = str7;
                                obj3 = obj7;
                                str21 = str2;
                                str22 = str32;
                                str23 = str31;
                                str24 = str6;
                                str25 = str3;
                                i14++;
                                str31 = str23;
                                str3 = str25;
                                str6 = str24;
                                size6 = i3;
                                obj6 = obj3;
                                str7 = str20;
                                str32 = str22;
                                str2 = str21;
                            } else {
                                HashMap map5 = feeCollection;
                                int installment2 = payment2.get(i14).getInstallment();
                                i3 = size6;
                                String year = hostelNewFragment3.hostelMonthly.get(i11).getYear();
                                str12 = str33;
                                String month = hostelNewFragment3.hostelMonthly.get(i11).getMonth();
                                str20 = str7;
                                String feehead_id2 = payment2.get(i14).getFeehead_id();
                                obj3 = obj7;
                                str21 = str2;
                                str22 = str32;
                                StringBuilder sb2 = new StringBuilder(str22);
                                sb2.append(installment2);
                                str23 = str31;
                                sb2.append(str23);
                                sb2.append(year);
                                sb2.append(str23);
                                sb2.append(month);
                                sb2.append(str23);
                                sb2.append(feehead_id2);
                                String str34 = str6;
                                sb2.append(str34);
                                map5.put(sb2.toString(), String.valueOf(payment2.get(i14).getBalance()));
                                str24 = str34;
                                str25 = str3;
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][feegroup_id]", payment2.get(i14).getFeegroup_id());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][feehead_id]", payment2.get(i14).getFeehead_id());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][feeheadgroup_id]", payment2.get(i14).getFeeheadgroup_id());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][tenant_id]", payment2.get(i14).getTenant_id());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][installment]", String.valueOf(payment2.get(i14).getInstallment()));
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][user_id]", payment2.get(i14).getUser_id());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][status]", String.valueOf(payment2.get(i14).getStatus()));
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][hostel_id]", payment2.get(i14).getHostel_id());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][month]", hostelNewFragment3.hostelMonthly.get(i11).getMonth());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][year]", hostelNewFragment3.hostelMonthly.get(i11).getYear());
                                map5.put(str22 + payment2.get(i14).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i11).getMonth() + str23 + payment2.get(i14).getFeehead_id() + "][scholarship_amount]", String.valueOf(payment2.get(i14).getAdjustment()));
                                i14++;
                                str31 = str23;
                                str3 = str25;
                                str6 = str24;
                                size6 = i3;
                                obj6 = obj3;
                                str7 = str20;
                                str32 = str22;
                                str2 = str21;
                            }
                        }
                    }
                    str20 = str7;
                    str21 = str2;
                    str22 = str32;
                    obj3 = obj6;
                    str23 = str31;
                    i3 = size6;
                    str24 = str6;
                    str25 = str3;
                    i14++;
                    str31 = str23;
                    str3 = str25;
                    str6 = str24;
                    size6 = i3;
                    obj6 = obj3;
                    str7 = str20;
                    str32 = str22;
                    str2 = str21;
                }
                str11 = str7;
                str13 = str2;
                str16 = str32;
                obj2 = obj6;
                str19 = str31;
                str15 = str6;
                str17 = str3;
            } else {
                str10 = str8;
                d = balance;
                str11 = str7;
                obj2 = obj5;
                str12 = str;
                str13 = str2;
                str14 = str4;
                i2 = i;
                str15 = str6;
                str16 = str30;
                str17 = str3;
                str18 = str5;
                str19 = str31;
            }
            i11++;
            str30 = str16;
            str31 = str19;
            str5 = str18;
            str3 = str17;
            size5 = i12;
            str6 = str15;
            str = str12;
            str8 = str10;
            str4 = str14;
            i = i2;
            balance = d;
            obj5 = obj2;
            str7 = str11;
            str2 = str13;
        }
        System.out.println(map);
        System.out.println(feeCollection);
        hostelNewFragment.getHostelNewViewModel().getHostelPay(feeCollection, map);
    }

    private final void listenAdmissionResponse() {
        getHostelNewViewModel().getAdmissionResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenAdmissionResponse$lambda$4(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAdmissionResponse$lambda$4(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewAdmissionResponse hostelNewAdmissionResponse = (HostelNewAdmissionResponse) resource.getData();
            if (hostelNewAdmissionResponse != null) {
                this$0.showBaseView();
                try {
                    HostelNewAdmissionAdapter adapterAdmission = this$0.getAdapterAdmission();
                    ArrayList<HostelNewAdmission> hostel = hostelNewAdmissionResponse.getHostel();
                    Boolean bool = this$0.status;
                    adapterAdmission.addAdmsnItems(hostel, bool != null ? bool.booleanValue() : false);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(Unit.INSTANCE);
                    return;
                }
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenMonthlyResponse() {
        getHostelNewViewModel().getMonthlyResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenMonthlyResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenMonthlyResponse$lambda$6(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewMonthlyResponse hostelNewMonthlyResponse = (HostelNewMonthlyResponse) resource.getData();
            if (hostelNewMonthlyResponse != null) {
                this$0.showBaseView();
                HostelNewMonthlyAdapter adapterMonthly = this$0.getAdapterMonthly();
                ArrayList<HostelNewMonthly> hostel = hostelNewMonthlyResponse.getHostel();
                Boolean bool = this$0.status;
                Intrinsics.checkNotNull(bool);
                adapterMonthly.addItems(hostel, bool.booleanValue());
                this$0.date = hostelNewMonthlyResponse.getDate();
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenHistoryResponse() {
        getHostelNewViewModel().getHistoryResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenHistoryResponse$lambda$8(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenHistoryResponse$lambda$8(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewHistoryResponse hostelNewHistoryResponse = (HostelNewHistoryResponse) resource.getData();
            if (hostelNewHistoryResponse != null) {
                this$0.showBaseView();
                this$0.getAdapterAdmissionHistory().addItems(hostelNewHistoryResponse.getAdmission_history());
                this$0.getAdapterMonthlyHistory().addItems(hostelNewHistoryResponse.getMonthly_history());
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenPayResponse() {
        getHostelNewViewModel().getHostelPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenPayResponse$lambda$10(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPayResponse$lambda$10(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewPay hostelNewPay = (HostelNewPay) resource.getData();
            if (hostelNewPay != null) {
                this$0.showBaseView();
                System.out.println(hostelNewPay);
                double total_amount = hostelNewPay.getTotal_amount() - ((double) hostelNewPay.getFine());
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                HostelNewConfirmDialog hostelNewConfirmDialogNewInstance = HostelNewConfirmDialog.INSTANCE.newInstance(String.valueOf(total_amount), String.valueOf(this$0.fine), String.valueOf(hostelNewPay.getTotal_amount()), hostelNewPay.getUrl());
                hostelNewConfirmDialogNewInstance.setCallBack(this$0);
                hostelNewConfirmDialogNewInstance.show(childFragmentManager, (String) null);
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenStatusResponse() {
        getHostelNewViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenStatusResponse$lambda$12(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenStatusResponse$lambda$12(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelStatusNew hostelStatusNew = (HostelStatusNew) resource.getData();
            if (hostelStatusNew != null) {
                this$0.showBaseView();
                this$0.status = Boolean.valueOf(hostelStatusNew.getAllpayment());
                FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
                TextView textView = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.tvFeeEngnrTotal : null;
                if (textView != null) {
                    textView.setText(IdManager.DEFAULT_VERSION_NAME);
                }
                FragmentHostelNewBinding fragmentHostelNewBinding2 = this$0.get_binding();
                MaterialButton materialButton = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.payFeeEngnrBtn : null;
                if (materialButton != null) {
                    materialButton.setVisibility(8);
                }
                this$0.getHostelNewViewModel().getHostelAdmissionFee();
                this$0.getHostelNewViewModel().getHostelMonthlyFee();
                this$0.getHostelNewViewModel().getHostelHistory();
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
        FragmentHostelNewBinding fragmentHostelNewBinding3 = this$0.get_binding();
        if (fragmentHostelNewBinding3 == null || (recyclerView = fragmentHostelNewBinding3.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter.CallBack
    public void viewAdmissionBtnClicked(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelNewDetailsDialog hostelNewDetailsDialogNewInstance = HostelNewDetailsDialog.INSTANCE.newInstance(position, 1);
        hostelNewDetailsDialogNewInstance.setCallBack(this);
        hostelNewDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter.CallBack
    public void viewMonthlyBtnClicked(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelNewDetailsDialog hostelNewDetailsDialogNewInstance = HostelNewDetailsDialog.INSTANCE.newInstance(position, 2);
        hostelNewDetailsDialogNewInstance.setCallBack(this);
        hostelNewDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter.CallBack
    public void feeClickedAdmission() {
        Boolean bool = this.status;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            getAdapterMonthly().unCheckFees();
        }
        this.fine = 0;
        ArrayList<HostelNewAdmission> items = getAdapterAdmission().getItems();
        ArrayList<HostelNewMonthly> items2 = getAdapterMonthly().getItems();
        System.out.println(items);
        System.out.println(items2);
        int size = items.size();
        double balance = 0.0d;
        double balance2 = 0.0d;
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                balance += items.get(i).getBalance() + ((double) items.get(i).getPayment().get(0).getFine());
                balance2 += items.get(i).getBalance();
                Integer num = this.fine;
                Intrinsics.checkNotNull(num);
                this.fine = Integer.valueOf(num.intValue() + items.get(i).getPayment().get(0).getFine());
            }
        }
        int size2 = items2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (items2.get(i2).is_selected()) {
                balance += (double) (items2.get(i2).getBalance() + items2.get(i2).getFine());
                Integer num2 = this.fine;
                Intrinsics.checkNotNull(num2);
                this.fine = Integer.valueOf(num2.intValue() + items2.get(i2).getFine());
                balance2 += (double) items2.get(i2).getBalance();
            }
        }
        this.subtotal = Integer.valueOf((int) balance2);
        if (balance > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
            MaterialButton materialButton = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.payFeeEngnrBtn : null;
            if (materialButton != null) {
                materialButton.setVisibility(0);
            }
        } else {
            FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
            MaterialButton materialButton2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.payFeeEngnrBtn : null;
            if (materialButton2 != null) {
                materialButton2.setVisibility(8);
            }
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        TextView textView = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.tvFeeEngnrTotal : null;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(balance));
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter.CallBack
    public void feeClickedMonthly() {
        Boolean bool = this.status;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            getAdapterAdmission().unCheckFees();
        }
        this.fine = 0;
        ArrayList<HostelNewAdmission> items = getAdapterAdmission().getItems();
        ArrayList<HostelNewMonthly> items2 = getAdapterMonthly().getItems();
        System.out.println(items);
        System.out.println(items2);
        int size = items.size();
        double balance = 0.0d;
        double balance2 = 0.0d;
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                balance += items.get(i).getBalance() + ((double) items.get(i).getPayment().get(0).getFine());
                balance2 += items.get(i).getBalance();
                Integer num = this.fine;
                Intrinsics.checkNotNull(num);
                this.fine = Integer.valueOf(num.intValue() + items.get(i).getPayment().get(0).getFine());
            }
        }
        int size2 = items2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (items2.get(i2).is_selected()) {
                balance += (double) (items2.get(i2).getBalance() + items2.get(i2).getFine());
                Integer num2 = this.fine;
                Intrinsics.checkNotNull(num2);
                this.fine = Integer.valueOf(num2.intValue() + items2.get(i2).getFine());
                balance2 += (double) items2.get(i2).getBalance();
            }
        }
        this.subtotal = Integer.valueOf((int) balance2);
        if (balance > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
            MaterialButton materialButton = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.payFeeEngnrBtn : null;
            if (materialButton != null) {
                materialButton.setVisibility(0);
            }
        } else {
            FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
            MaterialButton materialButton2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.payFeeEngnrBtn : null;
            if (materialButton2 != null) {
                materialButton2.setVisibility(8);
            }
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        TextView textView = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.tvFeeEngnrTotal : null;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(balance));
    }
}