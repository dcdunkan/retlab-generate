package in.etuwa.app.ui.feenewengineer.payment.dialog;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineer;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerInstallment;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogEngineerFeeEtailBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.feemedical.FeeMedicalFragment;
import in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment;
import in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailAdapter;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FeeDetailDialog.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002JKB\u0005¢\u0006\u0002\u0010\u0004J\b\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u000201H\u0002J\b\u00103\u001a\u000201H\u0002J\u0012\u00104\u001a\u0002012\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010=\u001a\u000201H\u0016J\b\u0010>\u001a\u000201H\u0016J\u001a\u0010?\u001a\u0002012\u0006\u0010@\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001c\u0010A\u001a\u0002012\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001eH\u0016J\u000e\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u0002012\u0006\u0010D\u001a\u00020GJ\b\u0010H\u001a\u000201H\u0014J\b\u0010I\u001a\u000201H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\f\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001c¨\u0006L"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/payconfirm/HostelFeesAdapter$CallBack;", "Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogEngineerFeeEtailBinding;", "adapter", "Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailAdapter;", "getAdapter", "()Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogEngineerFeeEtailBinding;", "feeDetailViewModelViewModel", "Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailViewModel;", "getFeeDetailViewModelViewModel", "()Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailViewModel;", "feeDetailViewModelViewModel$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailDialog$FeeDetailListner;", "month", "", "getMonth", "()Ljava/lang/String;", "setMonth", "(Ljava/lang/String;)V", "monthHashMap", "Ljava/util/HashMap;", "getMonthHashMap", "()Ljava/util/HashMap;", "pos", "", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "year", "getYear", "setYear", "hideProgress", "", "listenKmeaResponse", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "selectedIds", HostelFeeConfirmFragmentKt.ARG_MONTHS, "setCallBack", "context", "Lin/etuwa/app/ui/feenewengineer/payment/FeeEngineerFragment;", "setMedicalCallBack", "Lin/etuwa/app/ui/feemedical/FeeMedicalFragment;", "setUp", "showProgress", "Companion", "FeeDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeDetailDialog extends BaseDialog implements HostelFeesAdapter.CallBack, FeeDetailAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogEngineerFeeEtailBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: feeDetailViewModelViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeDetailViewModelViewModel;
    private FeeDetailListner listener;
    private String month;
    private final HashMap<String, String> monthHashMap;
    private Integer pos;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String year;

    /* compiled from: FeeDetailDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailDialog$FeeDetailListner;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface FeeDetailListner {
        void dismiss();
    }

    @JvmStatic
    public static final FeeDetailDialog newInstance(int i) {
        return INSTANCE.newInstance(i);
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

    public FeeDetailDialog() {
        final FeeDetailDialog feeDetailDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeDetailDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeDetailViewModelViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeDetailDialog, Reflection.getOrCreateKotlinClass(FeeDetailViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeDetailViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeDetailDialog feeDetailDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeeDetailAdapter>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeDetailAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeDetailDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeDetailAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeDetailDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.month = "";
        this.year = "";
        this.monthHashMap = new HashMap<>();
    }

    private final FeeDetailViewModel getFeeDetailViewModelViewModel() {
        return (FeeDetailViewModel) this.feeDetailViewModelViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeDetailAdapter getAdapter() {
        return (FeeDetailAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogEngineerFeeEtailBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
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

    public final HashMap<String, String> getMonthHashMap() {
        return this.monthHashMap;
    }

    public final Integer getPos() {
        return this.pos;
    }

    public final void setPos(Integer num) {
        this.pos = num;
    }

    /* compiled from: FeeDetailDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailDialog;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeDetailDialog newInstance(int position) {
            FeeDetailDialog feeDetailDialog = new FeeDetailDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(HostelFeeConfirmFragmentKt.ARG_MONTHS, position);
            feeDetailDialog.setArguments(bundle);
            return feeDetailDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pos = Integer.valueOf(arguments.getInt(HostelFeeConfirmFragmentKt.ARG_MONTHS));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogEngineerFeeEtailBinding.inflate(inflater, container, false);
        DialogEngineerFeeEtailBinding dialogEngineerFeeEtailBinding = get_binding();
        if (dialogEngineerFeeEtailBinding != null) {
            dialogEngineerFeeEtailBinding.setFeeDetailViewModelViewModel(getFeeDetailViewModelViewModel());
        }
        DialogEngineerFeeEtailBinding dialogEngineerFeeEtailBinding2 = get_binding();
        if (dialogEngineerFeeEtailBinding2 != null) {
            dialogEngineerFeeEtailBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogEngineerFeeEtailBinding dialogEngineerFeeEtailBinding3 = get_binding();
        if (dialogEngineerFeeEtailBinding3 != null) {
            return dialogEngineerFeeEtailBinding3.getRoot();
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
        System.out.println((Object) "=====================");
        System.out.println(this.pos);
        DialogEngineerFeeEtailBinding dialogEngineerFeeEtailBinding = get_binding();
        RecyclerView recyclerView = dialogEngineerFeeEtailBinding != null ? dialogEngineerFeeEtailBinding.rvHostelFee : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
            getFeeDetailViewModelViewModel().getFeesKmea(getPreference().getBatchId());
            listenKmeaResponse();
        } else {
            getFeeDetailViewModelViewModel().getFees();
            listenResponse();
        }
    }

    private final void listenResponse() {
        getFeeDetailViewModelViewModel().getResponse().observe(getViewLifecycleOwner(), new FeeDetailDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends FeeEngineerResponse>, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog$listenResponse$1

            /* compiled from: FeeDetailDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends FeeEngineerResponse> resource) {
                invoke2((Resource<FeeEngineerResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<FeeEngineerResponse> resource) {
                FeeDetailAdapter adapter;
                SharedPrefManager preference;
                DialogEngineerFeeEtailBinding dialogEngineerFeeEtailBinding;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        FeeDetailDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        FeeDetailDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeDetailDialog.this.hideProgress();
                        return;
                    }
                }
                FeeDetailDialog.this.hideProgress();
                FeeEngineerResponse data = resource.getData();
                if (data != null) {
                    FeeDetailDialog feeDetailDialog = FeeDetailDialog.this;
                    adapter = feeDetailDialog.getAdapter();
                    ArrayList<FeeEngineer> fees = data.getFees();
                    Integer pos = feeDetailDialog.getPos();
                    Intrinsics.checkNotNull(pos);
                    ArrayList<FeeEngineerInstallment> installments = fees.get(pos.intValue()).getInstallments();
                    Integer pos2 = feeDetailDialog.getPos();
                    preference = feeDetailDialog.getPreference();
                    adapter.addItems(installments, pos2, preference.getBaseUrl());
                    System.out.println((Object) "=======testing========");
                    ArrayList<FeeEngineer> fees2 = data.getFees();
                    Integer pos3 = feeDetailDialog.getPos();
                    Intrinsics.checkNotNull(pos3);
                    System.out.println(fees2.get(pos3.intValue()));
                    dialogEngineerFeeEtailBinding = feeDetailDialog.get_binding();
                    TextView textView = dialogEngineerFeeEtailBinding != null ? dialogEngineerFeeEtailBinding.monthLbl : null;
                    if (textView == null) {
                        return;
                    }
                    ArrayList<FeeEngineer> fees3 = data.getFees();
                    Integer pos4 = feeDetailDialog.getPos();
                    Intrinsics.checkNotNull(pos4);
                    textView.setText(fees3.get(pos4.intValue()).getInstallment_name());
                }
            }
        }));
    }

    private final void listenKmeaResponse() {
        getFeeDetailViewModelViewModel().getKmeaResponse().observe(getViewLifecycleOwner(), new FeeDetailDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends FeeEngineerResponse>, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog$listenKmeaResponse$1

            /* compiled from: FeeDetailDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends FeeEngineerResponse> resource) {
                invoke2((Resource<FeeEngineerResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<FeeEngineerResponse> resource) {
                FeeDetailAdapter adapter;
                SharedPrefManager preference;
                DialogEngineerFeeEtailBinding dialogEngineerFeeEtailBinding;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        FeeDetailDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        FeeDetailDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeDetailDialog.this.hideProgress();
                        return;
                    }
                }
                FeeDetailDialog.this.hideProgress();
                FeeEngineerResponse data = resource.getData();
                if (data != null) {
                    FeeDetailDialog feeDetailDialog = FeeDetailDialog.this;
                    adapter = feeDetailDialog.getAdapter();
                    ArrayList<FeeEngineer> fees = data.getFees();
                    Integer pos = feeDetailDialog.getPos();
                    Intrinsics.checkNotNull(pos);
                    ArrayList<FeeEngineerInstallment> installments = fees.get(pos.intValue()).getInstallments();
                    Integer pos2 = feeDetailDialog.getPos();
                    preference = feeDetailDialog.getPreference();
                    adapter.addItems(installments, pos2, preference.getBaseUrl());
                    System.out.println((Object) "=======testing========");
                    ArrayList<FeeEngineer> fees2 = data.getFees();
                    Integer pos3 = feeDetailDialog.getPos();
                    Intrinsics.checkNotNull(pos3);
                    System.out.println(fees2.get(pos3.intValue()));
                    dialogEngineerFeeEtailBinding = feeDetailDialog.get_binding();
                    TextView textView = dialogEngineerFeeEtailBinding != null ? dialogEngineerFeeEtailBinding.monthLbl : null;
                    if (textView == null) {
                        return;
                    }
                    ArrayList<FeeEngineer> fees3 = data.getFees();
                    Integer pos4 = feeDetailDialog.getPos();
                    Intrinsics.checkNotNull(pos4);
                    textView.setText(fees3.get(pos4.intValue()).getInstallment_name());
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

    public final void setCallBack(FeeEngineerFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setMedicalCallBack(FeeMedicalFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }
}