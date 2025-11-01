package in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.HostelMonth;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmission;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmissionResponse;
import in.etuwa.app.databinding.FragmentHostelFeeConfirmFragmentBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.feepartial.hostel.HostelPartialPayment;
import in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment;
import in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmFragment;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeesAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: HostelFeeConfirmFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002IJB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J\u0012\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010:\u001a\u00020.H\u0016J\b\u0010;\u001a\u00020.H\u0016J\u001a\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001c\u0010>\u001a\u00020.2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001dH\u0016J\u000e\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020.2\u0006\u0010A\u001a\u00020DJ\u000e\u0010E\u001a\u00020.2\u0006\u0010A\u001a\u00020FJ\b\u0010G\u001a\u00020.H\u0014J\b\u0010H\u001a\u00020.H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010'\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010*\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001b¨\u0006K"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeeConfirmFragment;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeesAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentHostelFeeConfirmFragmentBinding;", "adapter", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeesAdapter;", "getAdapter", "()Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentHostelFeeConfirmFragmentBinding;", "hostelFeeConfirmViewModel", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeeConfirmViewModel;", "getHostelFeeConfirmViewModel", "()Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeeConfirmViewModel;", "hostelFeeConfirmViewModel$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeeConfirmFragment$FeeDetailListner;", "month", "", "getMonth", "()Ljava/lang/String;", "setMonth", "(Ljava/lang/String;)V", "monthHashMap", "Ljava/util/HashMap;", "getMonthHashMap", "()Ljava/util/HashMap;", "pos", "", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "type", "getType", "setType", "year", "getYear", "setYear", "hideProgress", "", "listenResponse", "listenResponse2", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "selectedIds", HostelFeeConfirmFragmentKt.ARG_MONTHS, "setCallBack", "context", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/HostelFeeTkmFragment;", "setCallBack2", "Lin/etuwa/app/ui/hostel/palaihostel/PalaiHostelFragment;", "setCallBack3", "Lin/etuwa/app/ui/feepartial/hostel/HostelPartialPayment;", "setUp", "showProgress", "Companion", "FeeDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelFeeConfirmFragment extends BaseDialog implements HostelFeesAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelFeeConfirmFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: hostelFeeConfirmViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelFeeConfirmViewModel;
    private FeeDetailListner listener;
    private String month;
    private final HashMap<String, String> monthHashMap;
    private Integer pos;
    private Integer type;
    private String year;

    /* compiled from: HostelFeeConfirmFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeeConfirmFragment$FeeDetailListner;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface FeeDetailListner {
        void dismiss();
    }

    @JvmStatic
    public static final HostelFeeConfirmFragment newInstance(int i, int i2) {
        return INSTANCE.newInstance(i, i2);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeesAdapter.CallBack, in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailAdapter.CallBack
    public void selectedIds(HashMap<String, String> months) {
        Intrinsics.checkNotNullParameter(months, "months");
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public HostelFeeConfirmFragment() {
        final HostelFeeConfirmFragment hostelFeeConfirmFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelFeeConfirmFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelFeeConfirmViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelFeeConfirmFragment, Reflection.getOrCreateKotlinClass(HostelFeeConfirmViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelFeeConfirmViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelFeeConfirmFragment hostelFeeConfirmFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelFeesAdapter>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeesAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelFeesAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelFeeConfirmFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelFeesAdapter.class), b2, b3);
            }
        });
        this.month = "";
        this.year = "";
        this.monthHashMap = new HashMap<>();
    }

    private final HostelFeeConfirmViewModel getHostelFeeConfirmViewModel() {
        return (HostelFeeConfirmViewModel) this.hostelFeeConfirmViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HostelFeesAdapter getAdapter() {
        return (HostelFeesAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentHostelFeeConfirmFragmentBinding get_binding() {
        return this._binding;
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

    public final HashMap<String, String> getMonthHashMap() {
        return this.monthHashMap;
    }

    public final Integer getPos() {
        return this.pos;
    }

    public final void setPos(Integer num) {
        this.pos = num;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    /* compiled from: HostelFeeConfirmFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeeConfirmFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeeConfirmFragment;", CommonCssConstants.POSITION, "", "type", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelFeeConfirmFragment newInstance(int position, int type) {
            HostelFeeConfirmFragment hostelFeeConfirmFragment = new HostelFeeConfirmFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(HostelFeeConfirmFragmentKt.ARG_MONTHS, position);
            bundle.putInt("type", type);
            hostelFeeConfirmFragment.setArguments(bundle);
            return hostelFeeConfirmFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pos = Integer.valueOf(arguments.getInt(HostelFeeConfirmFragmentKt.ARG_MONTHS));
            this.type = Integer.valueOf(arguments.getInt("type"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHostelFeeConfirmFragmentBinding.inflate(inflater, container, false);
        FragmentHostelFeeConfirmFragmentBinding fragmentHostelFeeConfirmFragmentBinding = get_binding();
        if (fragmentHostelFeeConfirmFragmentBinding != null) {
            fragmentHostelFeeConfirmFragmentBinding.setHostelFeeConfirmViewModel(getHostelFeeConfirmViewModel());
        }
        FragmentHostelFeeConfirmFragmentBinding fragmentHostelFeeConfirmFragmentBinding2 = get_binding();
        if (fragmentHostelFeeConfirmFragmentBinding2 != null) {
            fragmentHostelFeeConfirmFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelFeeConfirmFragmentBinding fragmentHostelFeeConfirmFragmentBinding3 = get_binding();
        if (fragmentHostelFeeConfirmFragmentBinding3 != null) {
            return fragmentHostelFeeConfirmFragmentBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        System.out.println((Object) ("===========================" + this.monthHashMap));
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Pay Confirmation");
        }
        System.out.println((Object) "=====================");
        System.out.println(this.pos);
        FragmentHostelFeeConfirmFragmentBinding fragmentHostelFeeConfirmFragmentBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelFeeConfirmFragmentBinding != null ? fragmentHostelFeeConfirmFragmentBinding.rvHostelFee : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        Integer num = this.type;
        if (num != null && num.intValue() == 2) {
            getHostelFeeConfirmViewModel().getHostelMonthFee();
        } else {
            Integer num2 = this.type;
            if (num2 != null && num2.intValue() == 1) {
                getHostelFeeConfirmViewModel().getHostelMonthFee2();
            }
        }
        listenResponse();
        listenResponse2();
    }

    private final void listenResponse() {
        getHostelFeeConfirmViewModel().getMonthResponse().observe(getViewLifecycleOwner(), new HostelFeeConfirmFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelMonthResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment$listenResponse$1

            /* compiled from: HostelFeeConfirmFragment.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelMonthResponse> resource) {
                HostelFeesAdapter adapter;
                FragmentHostelFeeConfirmFragmentBinding fragmentHostelFeeConfirmFragmentBinding;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        HostelFeeConfirmFragment.this.showProgress();
                        return;
                    } else if (i == 3) {
                        HostelFeeConfirmFragment.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        HostelFeeConfirmFragment.this.hideProgress();
                        return;
                    }
                }
                HostelFeeConfirmFragment.this.hideProgress();
                HostelMonthResponse data = resource.getData();
                if (data != null) {
                    HostelFeeConfirmFragment hostelFeeConfirmFragment = HostelFeeConfirmFragment.this;
                    try {
                        adapter = hostelFeeConfirmFragment.getAdapter();
                        ArrayList<HostelMonth> hostel = data.getHostel();
                        Integer pos = hostelFeeConfirmFragment.getPos();
                        Intrinsics.checkNotNull(pos);
                        adapter.addItems(hostel.get(pos.intValue()).getPayment(), hostelFeeConfirmFragment.getPos());
                        System.out.println((Object) "=======testing========");
                        ArrayList<HostelMonth> hostel2 = data.getHostel();
                        Integer pos2 = hostelFeeConfirmFragment.getPos();
                        Intrinsics.checkNotNull(pos2);
                        System.out.println(hostel2.get(pos2.intValue()));
                        fragmentHostelFeeConfirmFragmentBinding = hostelFeeConfirmFragment.get_binding();
                        TextView textView = fragmentHostelFeeConfirmFragmentBinding != null ? fragmentHostelFeeConfirmFragmentBinding.monthLbl : null;
                        if (textView == null) {
                            return;
                        }
                        ArrayList<HostelMonth> hostel3 = data.getHostel();
                        Integer pos3 = hostelFeeConfirmFragment.getPos();
                        Intrinsics.checkNotNull(pos3);
                        textView.setText(hostel3.get(pos3.intValue()).getInstallment());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenResponse2() {
        getHostelFeeConfirmViewModel().getMonth2Response().observe(getViewLifecycleOwner(), new HostelFeeConfirmFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelPalaiAdmissionResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment$listenResponse2$1

            /* compiled from: HostelFeeConfirmFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelPalaiAdmissionResponse> resource) {
                invoke2((Resource<HostelPalaiAdmissionResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelPalaiAdmissionResponse> resource) {
                HostelFeesAdapter adapter;
                FragmentHostelFeeConfirmFragmentBinding fragmentHostelFeeConfirmFragmentBinding;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        HostelFeeConfirmFragment.this.showProgress();
                        return;
                    } else if (i == 3) {
                        HostelFeeConfirmFragment.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        HostelFeeConfirmFragment.this.hideProgress();
                        return;
                    }
                }
                HostelFeeConfirmFragment.this.hideProgress();
                HostelPalaiAdmissionResponse data = resource.getData();
                if (data != null) {
                    HostelFeeConfirmFragment hostelFeeConfirmFragment = HostelFeeConfirmFragment.this;
                    try {
                        adapter = hostelFeeConfirmFragment.getAdapter();
                        ArrayList<HostelPalaiAdmission> hostel = data.getHostel();
                        Integer pos = hostelFeeConfirmFragment.getPos();
                        Intrinsics.checkNotNull(pos);
                        adapter.addItems(hostel.get(pos.intValue()).getPayment(), hostelFeeConfirmFragment.getPos());
                        System.out.println((Object) "=======testing========");
                        ArrayList<HostelPalaiAdmission> hostel2 = data.getHostel();
                        Integer pos2 = hostelFeeConfirmFragment.getPos();
                        Intrinsics.checkNotNull(pos2);
                        System.out.println(hostel2.get(pos2.intValue()));
                        fragmentHostelFeeConfirmFragmentBinding = hostelFeeConfirmFragment.get_binding();
                        TextView textView = fragmentHostelFeeConfirmFragmentBinding != null ? fragmentHostelFeeConfirmFragmentBinding.monthLbl : null;
                        if (textView == null) {
                            return;
                        }
                        ArrayList<HostelPalaiAdmission> hostel3 = data.getHostel();
                        Integer pos3 = hostelFeeConfirmFragment.getPos();
                        Intrinsics.checkNotNull(pos3);
                        textView.setText(hostel3.get(pos3.intValue()).getInstallment());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    public final void setCallBack(HostelFeeTkmFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack2(PalaiHostelFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack3(HostelPartialPayment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }
}