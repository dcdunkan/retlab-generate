package in.etuwa.app.ui.hostel.tkmhostel.fee;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.HostelFee;
import in.etuwa.app.data.model.hostel.HostelFeeResponse;
import in.etuwa.app.data.model.hostel.HostelMonth;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.data.model.hostel.HostelResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentHostelFeeTkmBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.hostel.tkmhostel.fee.HostelMonthAdapter;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: HostelFeeTkmFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelFeeTkmFragment extends BaseFragment implements HostelMonthAdapter.CallBack, HostelFeeConfirmFragment.FeeDetailListner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelFeeTkmBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private int amounts;
    private String date;
    private int fineAmount;
    private ArrayList<HostelMonth> hostel;

    /* JADX INFO: renamed from: hostelFeeTkmViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelFeeTkmViewModel;
    private MainCallBackListener listener;
    private String month;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private int total;
    private int totalAmount;
    private String url;
    private String year;

    @JvmStatic
    public static final HostelFeeTkmFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public HostelFeeTkmFragment() {
        final HostelFeeTkmFragment hostelFeeTkmFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return hostelFeeTkmFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelFeeTkmFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelFeeTkmViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelFeeTkmFragment, Reflection.getOrCreateKotlinClass(HostelFeeTkmViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(HostelFeeTkmViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelFeeTkmFragment hostelFeeTkmFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelMonthAdapter>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.tkmhostel.fee.HostelMonthAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelMonthAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelFeeTkmFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelMonthAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = hostelFeeTkmFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.month = "";
        this.year = "";
        this.date = "";
        this.selected = new ArrayList();
        this.hostel = new ArrayList<>();
        this.url = "";
    }

    private final HostelFeeTkmViewModel getHostelFeeTkmViewModel() {
        return (HostelFeeTkmViewModel) this.hostelFeeTkmViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HostelMonthAdapter getAdapter() {
        return (HostelMonthAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentHostelFeeTkmBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getMonth() {
        return this.month;
    }

    public final void setMonth(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.month = str;
    }

    public final String getYear() {
        return this.year;
    }

    public final void setYear(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.year = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final int getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(int i) {
        this.totalAmount = i;
    }

    public final int getAmounts() {
        return this.amounts;
    }

    public final void setAmounts(int i) {
        this.amounts = i;
    }

    public final int getFineAmount() {
        return this.fineAmount;
    }

    public final void setFineAmount(int i) {
        this.fineAmount = i;
    }

    /* JADX INFO: compiled from: HostelFeeTkmFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/fee/HostelFeeTkmFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/HostelFeeTkmFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelFeeTkmFragment newInstance() {
            return new HostelFeeTkmFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHostelFeeTkmBinding.inflate(inflater, container, false);
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding = get_binding();
        if (fragmentHostelFeeTkmBinding != null) {
            fragmentHostelFeeTkmBinding.setHostelFeeTkmViewModel(getHostelFeeTkmViewModel());
        }
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding2 = get_binding();
        if (fragmentHostelFeeTkmBinding2 != null) {
            fragmentHostelFeeTkmBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding3 = get_binding();
        if (fragmentHostelFeeTkmBinding3 != null) {
            return fragmentHostelFeeTkmBinding3.getRoot();
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
        TextView textView;
        TextView textView2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Pay Fee");
        }
        hideBaseView();
        listenResponse();
        listenMonthResponse();
        getHostelFeeTkmViewModel().getHostelFee();
        getHostelFeeTkmViewModel().getHostelMonthFee();
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelFeeTkmBinding != null ? fragmentHostelFeeTkmBinding.rvHostelFee : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        final HashMap map = new HashMap();
        final HashMap map2 = new HashMap();
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
            FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding2 = get_binding();
            LinearLayout linearLayout = fragmentHostelFeeTkmBinding2 != null ? fragmentHostelFeeTkmBinding2.monthLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding3 = get_binding();
            textView = fragmentHostelFeeTkmBinding3 != null ? fragmentHostelFeeTkmBinding3.tvHostelTotal : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding4 = get_binding();
            LinearLayout linearLayout2 = fragmentHostelFeeTkmBinding4 != null ? fragmentHostelFeeTkmBinding4.monthLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding5 = get_binding();
            textView = fragmentHostelFeeTkmBinding5 != null ? fragmentHostelFeeTkmBinding5.tvHostelTotal : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        System.out.println(this.selected.size());
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding6 = get_binding();
        if (fragmentHostelFeeTkmBinding6 == null || (textView2 = fragmentHostelFeeTkmBinding6.payNowBtn) == null) {
            return;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelFeeTkmFragment.setUp$lambda$0(this.f$0, map2, map, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(HostelFeeTkmFragment this$0, HashMap feeReceipt, HashMap feeCollection, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feeReceipt, "$feeReceipt");
        Intrinsics.checkNotNullParameter(feeCollection, "$feeCollection");
        System.out.println((Object) "===============================================");
        System.out.println(this$0.selected);
        System.out.println(this$0.hostel);
        int size = this$0.selected.size();
        System.out.println(size);
        int i = size - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                try {
                    if (Intrinsics.areEqual(this$0.selected.get(i2), "true")) {
                        ArrayList<HostelFee> payment = this$0.hostel.get(i2).getPayment();
                        int size2 = payment.size();
                        feeReceipt.put("payment", "1");
                        feeReceipt.put("Transaction[method]", "5");
                        feeReceipt.put("FeeReceipt[receipt_date]", this$0.date);
                        feeReceipt.put("FeeReceipt[fine_amount]", String.valueOf(((double) ((int) payment.get(i2).getAmount())) - (payment.get(i2).getPayable() + ((double) payment.get(i2).getPaid()))));
                        feeReceipt.put("FeeReceipt[total_amount]", String.valueOf(this$0.hostel.get(i2).getAmount()));
                        feeReceipt.put("FeeReceipt[amount]", String.valueOf(this$0.hostel.get(i2).getBalance()));
                        int i3 = size2 - 1;
                        if (i3 >= 0) {
                            int i4 = 0;
                            while (true) {
                                if (!Intrinsics.areEqual(payment.get(i4).getName(), "Fine") && !Intrinsics.areEqual(payment.get(i4).getName(), "Sub Total") && !Intrinsics.areEqual(payment.get(i4).getName(), "Total")) {
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][amount]", String.valueOf(payment.get(i4).getAmount()));
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][feegroup_id]", payment.get(i4).getFeeheadgroup_id());
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][feehead_id]", payment.get(i4).getFeehead_id());
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][tenant_id]", payment.get(i4).getTenant_id());
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][installment]", String.valueOf(payment.get(i4).getInstallment()));
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][user_id]", payment.get(i4).getUser_id());
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][status]", String.valueOf(payment.get(i4).getStatus()));
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][feetype]", payment.get(i4).getFeetype());
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][hostel_id]", payment.get(i4).getHostel_id());
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][month]", this$0.hostel.get(i2).getMonth());
                                    feeCollection.put("FeeCollection[" + this$0.hostel.get(i2).getYear() + "][" + this$0.hostel.get(i2).getMonth() + "][" + payment.get(i4).getFeehead_id() + "][year]", this$0.hostel.get(i2).getYear());
                                }
                                if (i4 == i3) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
        this$0.getHostelFeeTkmViewModel().getHostelFee(feeCollection, feeReceipt);
        this$0.listenUrlResponse();
    }

    private final void listenResponse() {
        getHostelFeeTkmViewModel().getResponse().observe(getViewLifecycleOwner(), new HostelFeeTkmFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: HostelFeeTkmFragment.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelResponse> resource) {
                invoke2((Resource<HostelResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        HostelFeeTkmFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        HostelFeeTkmFragment.this.hideProgress();
                        HostelFeeTkmFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        HostelFeeTkmFragment.this.hideProgress();
                        HostelFeeTkmFragment.this.showBaseView();
                        return;
                    }
                }
                HostelFeeTkmFragment.this.hideProgress();
                HostelResponse data = resource.getData();
                if (data != null) {
                    HostelFeeTkmFragment hostelFeeTkmFragment = HostelFeeTkmFragment.this;
                    hostelFeeTkmFragment.showBaseView();
                    FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding = hostelFeeTkmFragment.get_binding();
                    TextView textView = fragmentHostelFeeTkmBinding != null ? fragmentHostelFeeTkmBinding.roomNo : null;
                    if (textView != null) {
                        textView.setText(data.getRoomNo());
                    }
                    FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding2 = hostelFeeTkmFragment.get_binding();
                    TextView textView2 = fragmentHostelFeeTkmBinding2 != null ? fragmentHostelFeeTkmBinding2.joinDate : null;
                    if (textView2 != null) {
                        textView2.setText(data.getJoinDate());
                    }
                    FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding3 = hostelFeeTkmFragment.get_binding();
                    TextView textView3 = fragmentHostelFeeTkmBinding3 != null ? fragmentHostelFeeTkmBinding3.hostelTv : null;
                    if (textView3 != null) {
                        textView3.setText(data.getHostel());
                    }
                    try {
                        hostelFeeTkmFragment.setMonth(data.getMonth());
                        hostelFeeTkmFragment.setYear(data.getYear());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenMonthResponse() {
        getHostelFeeTkmViewModel().getMonthResponse().observe(getViewLifecycleOwner(), new HostelFeeTkmFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelMonthResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment.listenMonthResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$listenMonthResponse$1$WhenMappings */
            /* JADX INFO: compiled from: HostelFeeTkmFragment.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelMonthResponse> resource) {
                invoke2((Resource<HostelMonthResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelMonthResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    HostelFeeTkmFragment.this.hideProgress();
                    HostelMonthResponse data = resource.getData();
                    if (data != null) {
                        HostelFeeTkmFragment hostelFeeTkmFragment = HostelFeeTkmFragment.this;
                        hostelFeeTkmFragment.showBaseView();
                        try {
                            hostelFeeTkmFragment.getAdapter().addItems(data.getHostel());
                            hostelFeeTkmFragment.hostel = data.getHostel();
                            hostelFeeTkmFragment.setDate(data.getDate());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    HostelFeeTkmFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    HostelFeeTkmFragment.this.hideProgress();
                    HostelFeeTkmFragment.this.showBaseView();
                } else {
                    if (i != 4) {
                        return;
                    }
                    HostelFeeTkmFragment.this.hideProgress();
                    HostelFeeTkmFragment.this.showBaseView();
                }
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding = get_binding();
        if (fragmentHostelFeeTkmBinding == null || (recyclerView = fragmentHostelFeeTkmBinding.rvHostelFee) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding = get_binding();
        if (fragmentHostelFeeTkmBinding == null || (recyclerView = fragmentHostelFeeTkmBinding.rvHostelFee) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
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

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.hostel.tkmhostel.fee.HostelMonthAdapter.CallBack
    public void selectedIds(int total) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelFeeConfirmFragment hostelFeeConfirmFragmentNewInstance = HostelFeeConfirmFragment.INSTANCE.newInstance(total, 2);
        hostelFeeConfirmFragmentNewInstance.setCallBack(this);
        hostelFeeConfirmFragmentNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostel.tkmhostel.fee.HostelMonthAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        TextView textView;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
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
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding = get_binding();
        TextView textView2 = fragmentHostelFeeTkmBinding != null ? fragmentHostelFeeTkmBinding.tvHostelTotal : null;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i));
        }
        if (i <= 0) {
            if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
                FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding2 = get_binding();
                textView = fragmentHostelFeeTkmBinding2 != null ? fragmentHostelFeeTkmBinding2.payNowBtn : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
            FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding3 = get_binding();
            textView = fragmentHostelFeeTkmBinding3 != null ? fragmentHostelFeeTkmBinding3.payNowBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        FragmentHostelFeeTkmBinding fragmentHostelFeeTkmBinding4 = get_binding();
        textView = fragmentHostelFeeTkmBinding4 != null ? fragmentHostelFeeTkmBinding4.payNowBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.hostel.tkmhostel.fee.HostelMonthAdapter.CallBack
    public void kmeaFees(int position) {
        MainCallBackListener mainCallBackListener;
        if (!StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || (mainCallBackListener = this.listener) == null) {
            return;
        }
        mainCallBackListener.showKmeaHostelFragment(position);
    }

    @Override // in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment.FeeDetailListner
    public void dismiss() {
        getHostelFeeTkmViewModel().getHostelFee();
        getHostelFeeTkmViewModel().getHostelMonthFee();
    }

    private final void listenUrlResponse() {
        getHostelFeeTkmViewModel().getUrlResponse().observe(getViewLifecycleOwner(), new HostelFeeTkmFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelFeeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment.listenUrlResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment$listenUrlResponse$1$WhenMappings */
            /* JADX INFO: compiled from: HostelFeeTkmFragment.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelFeeResponse> resource) {
                invoke2((Resource<HostelFeeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelFeeResponse> resource) {
                MainCallBackListener mainCallBackListener;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        HostelFeeTkmFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        HostelFeeTkmFragment.this.hideProgress();
                        HostelFeeTkmFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        HostelFeeTkmFragment.this.hideProgress();
                        HostelFeeTkmFragment.this.showBaseView();
                        return;
                    }
                }
                HostelFeeTkmFragment.this.hideProgress();
                HostelFeeResponse data = resource.getData();
                if (data != null) {
                    HostelFeeTkmFragment hostelFeeTkmFragment = HostelFeeTkmFragment.this;
                    hostelFeeTkmFragment.showBaseView();
                    System.out.println((Object) data.getUrl());
                    if (Intrinsics.areEqual(data.getUrl(), "") || (mainCallBackListener = hostelFeeTkmFragment.listener) == null) {
                        return;
                    }
                    mainCallBackListener.openPaymentPage(data.getUrl());
                }
            }
        }));
    }
}