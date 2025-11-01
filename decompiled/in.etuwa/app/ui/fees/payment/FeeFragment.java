package in.etuwa.app.ui.fees.payment;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.fee.FeeGroups;
import in.etuwa.app.data.model.fee.FeeResponse;
import in.etuwa.app.data.model.fee.FeeSreeChitraUrl;
import in.etuwa.app.data.model.fee.FeeUrlResponse;
import in.etuwa.app.data.model.fee.feeheadgroups.FeeHeadGroupResponse;
import in.etuwa.app.data.model.fee.installment.InstallmentResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FeeFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.RecycleExtKt;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FeeFragment.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020)H\u0014J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\u0012\u0010/\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020)H\u0016J\b\u0010=\u001a\u00020)H\u0016J\b\u0010>\u001a\u00020)H\u0016J\u001a\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010A\u001a\u00020)H\u0014J\b\u0010B\u001a\u00020)H\u0014J\b\u0010C\u001a\u00020)H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lin/etuwa/app/ui/fees/payment/FeeFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FeeFragmentBinding;", "adapter", "Lin/etuwa/app/ui/fees/payment/FeeAdapter;", "getAdapter", "()Lin/etuwa/app/ui/fees/payment/FeeAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "batchId", "", "binding", "getBinding", "()Lin/etuwa/app/databinding/FeeFragmentBinding;", "feeViewModel", "Lin/etuwa/app/ui/fees/payment/FeeViewModel;", "getFeeViewModel", "()Lin/etuwa/app/ui/fees/payment/FeeViewModel;", "feeViewModel$delegate", "headGroup", "installmentId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "receiptDate", "spinnerAdapter", "Lin/etuwa/app/ui/fees/payment/FeeSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/fees/payment/FeeSpinnerAdapter;", "spinnerAdapter$delegate", "studentId", "totalAmount", "type", "", "hideBaseView", "", "hideProgress", "listenHeadResponse", "listenInstallmentResponse", "listenResponse", "listenResponseBatchId", "loadCustomTabs", "url", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onResume", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FeeFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String batchId;

    /* renamed from: feeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeViewModel;
    private String headGroup;
    private String installmentId;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String receiptDate;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String studentId;
    private String totalAmount;
    private int type;

    /* compiled from: FeeFragment.kt */
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
    public static final FeeFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public FeeFragment() {
        final FeeFragment feeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeFragment, Reflection.getOrCreateKotlinClass(FeeViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeFragment feeFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeeAdapter>() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.payment.FeeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(FeeFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<FeeSpinnerAdapter>() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.payment.FeeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
        this.installmentId = "";
        this.totalAmount = "";
        this.receiptDate = "";
        this.headGroup = "";
        this.batchId = "";
        this.studentId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeViewModel getFeeViewModel() {
        return (FeeViewModel) this.feeViewModel.getValue();
    }

    private final FeeAdapter getAdapter() {
        return (FeeAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FeeFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeSpinnerAdapter getSpinnerAdapter() {
        return (FeeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: FeeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/payment/FeeFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/payment/FeeFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeFragment newInstance() {
            return new FeeFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getFeeViewModel().getInstallments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FeeFragmentBinding.inflate(inflater, container, false);
        FeeFragmentBinding feeFragmentBinding = get_binding();
        if (feeFragmentBinding != null) {
            feeFragmentBinding.setFeeViewModel(getFeeViewModel());
        }
        FeeFragmentBinding feeFragmentBinding2 = get_binding();
        if (feeFragmentBinding2 != null) {
            feeFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FeeFragmentBinding feeFragmentBinding3 = get_binding();
        if (feeFragmentBinding3 != null) {
            return feeFragmentBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0137, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) "gcek", false, 2, (java.lang.Object) null) != false) goto L47;
     */
    @Override // in.etuwa.app.ui.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void setUp() {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.fees.payment.FeeFragment.setUp():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(FeeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFeeViewModel().getInstallments();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15(final FeeFragment this$0, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenResponseBatchId();
        this$0.listenHeadResponse();
        ArrayList<FeeGroups> items = this$0.getAdapter().getItems();
        HashMap<String, String> hashMap = new HashMap<>();
        String lowerCase = this$0.getPreference().getBaseUrl().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str10 = "][amount]";
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "sctce", false, 2, (Object) null)) {
            HashMap<String, String> hashMap2 = hashMap;
            hashMap2.put("payment", "1");
            hashMap2.put("batch_id", this$0.batchId);
            hashMap2.put("verify", "1");
            System.out.println((Object) ("====================" + this$0.type));
            HashMap<String, String> hashMap3 = new HashMap<>();
            new HashMap();
            for (FeeGroups feeGroups : items) {
                if (Intrinsics.areEqual(feeGroups.getPaid(), "0")) {
                    HashMap<String, String> hashMap4 = hashMap3;
                    hashMap4.put("FeeCollection[" + feeGroups.getFeeHeadGroupId() + "][amount]", feeGroups.getBalance());
                    hashMap4.put("FeeCollection[" + feeGroups.getFeeHeadGroupId() + "][feeheadgroup_id]", feeGroups.getFeeHeadGroupId());
                }
                System.out.println((Object) ("the real feeheadGroup is " + this$0.batchId));
            }
            this$0.getFeeViewModel().payFees(hashMap3, hashMap);
            this$0.getFeeViewModel().getPayResponse().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeeFragment.setUp$lambda$15$lambda$4(FeeFragment.this, (Resource) obj);
                }
            });
            return;
        }
        String lowerCase2 = this$0.getPreference().getBaseUrl().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        String str11 = "][feeheadgroup_id]";
        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "sctce", false, 2, (Object) null)) {
            str = "][feetype_id]";
            str2 = "][feehead_id]";
            str3 = "the real feeheadGroup is ";
            str4 = "][feegroup_id]";
        } else {
            String lowerCase3 = this$0.getPreference().getBaseUrl().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            String str12 = "][feetype_id]";
            String str13 = "][feegroup_id]";
            String str14 = "][amount]";
            String str15 = "][feehead_id]";
            if (!StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "kmeaarts", false, 2, (Object) null)) {
                String lowerCase4 = this$0.getPreference().getBaseUrl().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "sjcp", false, 2, (Object) null)) {
                    this$0.listenResponse();
                    HashMap<String, String> hashMap5 = hashMap;
                    hashMap5.put("FeeReceipt[amount]", this$0.totalAmount);
                    hashMap5.put("FeeReceipt[receipt_date]", this$0.receiptDate);
                    System.out.println((Object) ("====================" + this$0.type));
                    HashMap<String, String> hashMap6 = new HashMap<>();
                    HashMap<String, String> hashMap7 = new HashMap<>();
                    hashMap7.put("Transaction[method]", "5");
                    for (FeeGroups feeGroups2 : items) {
                        if (Intrinsics.areEqual(feeGroups2.getPaid(), "0")) {
                            HashMap<String, String> hashMap8 = hashMap6;
                            String feeHeadId = feeGroups2.getFeeHeadId();
                            StringBuilder sb = new StringBuilder("FeeCollection[");
                            sb.append(feeHeadId);
                            str7 = str14;
                            sb.append(str7);
                            hashMap8.put(sb.toString(), feeGroups2.getBalance());
                            String feeHeadId2 = feeGroups2.getFeeHeadId();
                            StringBuilder sb2 = new StringBuilder("FeeCollection[");
                            sb2.append(feeHeadId2);
                            str6 = str13;
                            sb2.append(str6);
                            hashMap8.put(sb2.toString(), feeGroups2.getFeeGroupId());
                            String feeHeadId3 = feeGroups2.getFeeHeadId();
                            StringBuilder sb3 = new StringBuilder("FeeCollection[");
                            sb3.append(feeHeadId3);
                            str8 = str15;
                            sb3.append(str8);
                            hashMap8.put(sb3.toString(), feeGroups2.getFeeHeadId());
                            String feeHeadId4 = feeGroups2.getFeeHeadId();
                            StringBuilder sb4 = new StringBuilder("FeeCollection[");
                            sb4.append(feeHeadId4);
                            str9 = str12;
                            sb4.append(str9);
                            hashMap8.put(sb4.toString(), feeGroups2.getFeeTypeId());
                            hashMap8.put("FeeCollection[" + feeGroups2.getFeeHeadId() + "][student_id]", this$0.studentId);
                            hashMap8.put("FeeCollection[" + feeGroups2.getFeeHeadId() + "][installment_id]", this$0.installmentId);
                        } else {
                            str6 = str13;
                            str7 = str14;
                            str8 = str15;
                            str9 = str12;
                        }
                        System.out.println((Object) ("the real feeheadGroup is " + this$0.batchId));
                        str15 = str8;
                        str12 = str9;
                        str14 = str7;
                        str13 = str6;
                    }
                    this$0.getFeeViewModel().paySreeChitraFees(hashMap6, hashMap, hashMap7, "1", this$0.installmentId);
                    this$0.getFeeViewModel().getPayFeeSreeChitraResponse().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda8
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            FeeFragment.setUp$lambda$15$lambda$10(FeeFragment.this, (Resource) obj);
                        }
                    });
                    return;
                }
                HashMap<String, String> hashMap9 = hashMap;
                hashMap9.put("payment", "1");
                hashMap9.put("batch_id", this$0.batchId);
                hashMap9.put("verify", "1");
                System.out.println((Object) ("====================" + this$0.type));
                HashMap<String, String> hashMap10 = new HashMap<>();
                new HashMap();
                for (FeeGroups feeGroups3 : items) {
                    if (Intrinsics.areEqual(feeGroups3.getPaid(), "0")) {
                        HashMap<String, String> hashMap11 = hashMap10;
                        hashMap11.put("FeeCollection[" + feeGroups3.getFeeHeadGroupId() + str14, feeGroups3.getBalance());
                        String feeHeadGroupId = feeGroups3.getFeeHeadGroupId();
                        StringBuilder sb5 = new StringBuilder("FeeCollection[");
                        sb5.append(feeHeadGroupId);
                        str5 = str11;
                        sb5.append(str5);
                        hashMap11.put(sb5.toString(), feeGroups3.getFeeHeadGroupId());
                    } else {
                        str5 = str11;
                    }
                    System.out.println((Object) ("the real feeheadGroup is " + this$0.batchId));
                    str11 = str5;
                }
                this$0.getFeeViewModel().payFees(hashMap10, hashMap);
                this$0.getFeeViewModel().getPayResponse().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda9
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        FeeFragment.setUp$lambda$15$lambda$14(FeeFragment.this, (Resource) obj);
                    }
                });
                return;
            }
            str4 = str13;
            str10 = str14;
            str3 = "the real feeheadGroup is ";
            str2 = str15;
            str = str12;
        }
        HashMap<String, String> hashMap12 = hashMap;
        hashMap12.put("FeeReceipt[amount]", this$0.totalAmount);
        hashMap12.put("FeeReceipt[receipt_date]", this$0.receiptDate);
        System.out.println((Object) ("====================" + this$0.type));
        HashMap<String, String> hashMap13 = new HashMap<>();
        HashMap<String, String> hashMap14 = new HashMap<>();
        hashMap14.put("Transaction[method]", "5");
        for (FeeGroups feeGroups4 : items) {
            if (Intrinsics.areEqual(feeGroups4.getPaid(), "0")) {
                HashMap<String, String> hashMap15 = hashMap13;
                hashMap15.put("FeeCollection[" + feeGroups4.getFeeHeadId() + str10, feeGroups4.getBalance());
                hashMap15.put("FeeCollection[" + feeGroups4.getFeeHeadId() + str4, feeGroups4.getFeeGroupId());
                hashMap15.put("FeeCollection[" + feeGroups4.getFeeHeadId() + str2, feeGroups4.getFeeHeadId());
                hashMap15.put("FeeCollection[" + feeGroups4.getFeeHeadId() + str, feeGroups4.getFeeTypeId());
                hashMap15.put("FeeCollection[" + feeGroups4.getFeeHeadId() + "][student_id]", this$0.studentId);
                hashMap15.put("FeeCollection[" + feeGroups4.getFeeHeadId() + str2, this$0.installmentId);
            }
            System.out.println((Object) (str3 + this$0.batchId));
        }
        this$0.getFeeViewModel().paySreeChitraFees(hashMap13, hashMap, hashMap14, "1", this$0.installmentId);
        this$0.getFeeViewModel().getPayFeeSreeChitraResponse().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeFragment.setUp$lambda$15$lambda$7(FeeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15$lambda$4(FeeFragment this$0, Resource resource) {
        FeeFragmentBinding feeFragmentBinding;
        RecyclerView rvFee;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            FeeUrlResponse feeUrlResponse = (FeeUrlResponse) resource.getData();
            if (feeUrlResponse != null) {
                if (Intrinsics.areEqual(feeUrlResponse.getError(), "")) {
                    this$0.loadCustomTabs(feeUrlResponse.getUrl());
                    return;
                }
                String error = feeUrlResponse.getError();
                if (error != null && (feeFragmentBinding = this$0.get_binding()) != null && (rvFee = feeFragmentBinding.rvFee) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                    ToastExtKt.showErrorToast(rvFee, error);
                }
                this$0.showProgress();
                this$0.hideProgress();
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
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        FeeFragmentBinding feeFragmentBinding2 = this$0.get_binding();
        if (feeFragmentBinding2 == null || (recyclerView = feeFragmentBinding2.rvFee) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15$lambda$7(FeeFragment this$0, Resource resource) {
        RecyclerView rvFee;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            FeeSreeChitraUrl feeSreeChitraUrl = (FeeSreeChitraUrl) resource.getData();
            if (feeSreeChitraUrl != null) {
                if (Intrinsics.areEqual((Object) feeSreeChitraUrl.getSuccess(), (Object) true)) {
                    this$0.loadCustomTabs(feeSreeChitraUrl.getUrl());
                    return;
                }
                FeeFragmentBinding feeFragmentBinding = this$0.get_binding();
                if (feeFragmentBinding != null && (rvFee = feeFragmentBinding.rvFee) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                    ToastExtKt.showErrorToast(rvFee, "Error");
                }
                this$0.showProgress();
                this$0.hideProgress();
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
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        FeeFragmentBinding feeFragmentBinding2 = this$0.get_binding();
        if (feeFragmentBinding2 == null || (recyclerView = feeFragmentBinding2.rvFee) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15$lambda$10(FeeFragment this$0, Resource resource) {
        RecyclerView rvFee;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            FeeSreeChitraUrl feeSreeChitraUrl = (FeeSreeChitraUrl) resource.getData();
            if (feeSreeChitraUrl != null) {
                if (Intrinsics.areEqual((Object) feeSreeChitraUrl.getSuccess(), (Object) true)) {
                    this$0.loadCustomTabs(feeSreeChitraUrl.getUrl());
                    return;
                }
                FeeFragmentBinding feeFragmentBinding = this$0.get_binding();
                if (feeFragmentBinding != null && (rvFee = feeFragmentBinding.rvFee) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                    ToastExtKt.showErrorToast(rvFee, "Error");
                }
                this$0.showProgress();
                this$0.hideProgress();
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
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        FeeFragmentBinding feeFragmentBinding2 = this$0.get_binding();
        if (feeFragmentBinding2 == null || (recyclerView = feeFragmentBinding2.rvFee) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15$lambda$14(FeeFragment this$0, Resource resource) {
        FeeFragmentBinding feeFragmentBinding;
        RecyclerView rvFee;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            FeeUrlResponse feeUrlResponse = (FeeUrlResponse) resource.getData();
            if (feeUrlResponse != null) {
                if (Intrinsics.areEqual(feeUrlResponse.getError(), "")) {
                    this$0.loadCustomTabs(feeUrlResponse.getUrl());
                    return;
                }
                String error = feeUrlResponse.getError();
                if (error != null && (feeFragmentBinding = this$0.get_binding()) != null && (rvFee = feeFragmentBinding.rvFee) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                    ToastExtKt.showErrorToast(rvFee, error);
                }
                this$0.showProgress();
                this$0.hideProgress();
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
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        FeeFragmentBinding feeFragmentBinding2 = this$0.get_binding();
        if (feeFragmentBinding2 == null || (recyclerView = feeFragmentBinding2.rvFee) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void loadCustomTabs(String url) {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPaymentPage(url);
        }
    }

    private final void listenInstallmentResponse() {
        getFeeViewModel().getInstalmentResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeFragment.listenInstallmentResponse$lambda$17(FeeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenInstallmentResponse$lambda$17(FeeFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView rvFee;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        r2 = null;
        Boolean bool = null;
        if (i != 1) {
            if (i == 2) {
                FeeFragmentBinding feeFragmentBinding = this$0.get_binding();
                if (feeFragmentBinding != null && (swipeRefreshLayout2 = feeFragmentBinding.swipeLayout) != null) {
                    bool = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    return;
                }
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
            FeeFragmentBinding feeFragmentBinding2 = this$0.get_binding();
            if (feeFragmentBinding2 == null || (recyclerView = feeFragmentBinding2.rvFee) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        InstallmentResponse installmentResponse = (InstallmentResponse) resource.getData();
        if (installmentResponse != null) {
            this$0.showBaseView();
            try {
                if (installmentResponse.getLogin()) {
                    if (installmentResponse.getSuccess()) {
                        this$0.getSpinnerAdapter().addItems(installmentResponse.getInstallments());
                    } else {
                        FeeFragmentBinding feeFragmentBinding3 = this$0.get_binding();
                        if (feeFragmentBinding3 != null && (rvFee = feeFragmentBinding3.rvFee) != null) {
                            Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                            ToastExtKt.showErrorToast(rvFee, installmentResponse.getMessage());
                        }
                    }
                }
                FeeFragmentBinding feeFragmentBinding4 = this$0.get_binding();
                Boolean valueOf = (feeFragmentBinding4 == null || (swipeRefreshLayout = feeFragmentBinding4.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    FeeFragmentBinding feeFragmentBinding5 = this$0.get_binding();
                    SwipeRefreshLayout swipeRefreshLayout3 = feeFragmentBinding5 != null ? feeFragmentBinding5.swipeLayout : null;
                    if (swipeRefreshLayout3 != null) {
                        swipeRefreshLayout3.setRefreshing(false);
                    }
                    FeeFragmentBinding feeFragmentBinding6 = this$0.get_binding();
                    if (feeFragmentBinding6 == null || (spinner = feeFragmentBinding6.spinnerInstallment) == null) {
                        return;
                    } else {
                        spinner.setSelection(0);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (NullPointerException unused) {
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    private final void listenResponse() {
        getFeeViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeFragment.listenResponse$lambda$19(FeeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$19(FeeFragment this$0, Resource resource) {
        RecyclerView rvFee;
        TextView textView;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            FeeFragmentBinding feeFragmentBinding = this$0.get_binding();
            if (feeFragmentBinding == null || (recyclerView = feeFragmentBinding.rvFee) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        FeeResponse feeResponse = (FeeResponse) resource.getData();
        if (feeResponse != null) {
            this$0.showBaseView();
            if (feeResponse.getLogin()) {
                if (feeResponse.getSuccess()) {
                    this$0.getAdapter().addItems(feeResponse.getFeeGroups());
                    FeeFragmentBinding feeFragmentBinding2 = this$0.get_binding();
                    TextView textView2 = feeFragmentBinding2 != null ? feeFragmentBinding2.tvTotal : null;
                    if (textView2 != null) {
                        textView2.setText(feeResponse.getBalance());
                    }
                    this$0.studentId = feeResponse.getStudentId();
                    this$0.totalAmount = feeResponse.getBalance();
                    this$0.receiptDate = feeResponse.getDate();
                    if (Intrinsics.areEqual(this$0.totalAmount, "0")) {
                        FeeFragmentBinding feeFragmentBinding3 = this$0.get_binding();
                        textView = feeFragmentBinding3 != null ? feeFragmentBinding3.payNowBtn : null;
                        if (textView == null) {
                            return;
                        }
                        textView.setVisibility(8);
                        return;
                    }
                    if (StringsKt.contains$default((CharSequence) this$0.totalAmount, (CharSequence) HelpFormatter.DEFAULT_OPT_PREFIX, false, 2, (Object) null)) {
                        FeeFragmentBinding feeFragmentBinding4 = this$0.get_binding();
                        textView = feeFragmentBinding4 != null ? feeFragmentBinding4.payNowBtn : null;
                        if (textView == null) {
                            return;
                        }
                        textView.setVisibility(8);
                        return;
                    }
                    FeeFragmentBinding feeFragmentBinding5 = this$0.get_binding();
                    textView = feeFragmentBinding5 != null ? feeFragmentBinding5.payNowBtn : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
                FeeFragmentBinding feeFragmentBinding6 = this$0.get_binding();
                if (feeFragmentBinding6 == null || (rvFee = feeFragmentBinding6.rvFee) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                ToastExtKt.showErrorToast(rvFee, feeResponse.getMessage());
            }
        }
    }

    private final void listenHeadResponse() {
        getFeeViewModel().getHeadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeFragment.listenHeadResponse$lambda$21(FeeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenHeadResponse$lambda$21(FeeFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            FeeHeadGroupResponse feeHeadGroupResponse = (FeeHeadGroupResponse) resource.getData();
            if (feeHeadGroupResponse != null) {
                this$0.showBaseView();
                feeHeadGroupResponse.getFeeHeadGroups();
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
        FeeFragmentBinding feeFragmentBinding = this$0.get_binding();
        if (feeFragmentBinding == null || (recyclerView = feeFragmentBinding.rvFee) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenResponseBatchId() {
        getFeeViewModel().getResponseBatchId().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.payment.FeeFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeFragment.listenResponseBatchId$lambda$23(FeeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponseBatchId$lambda$23(FeeFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            DashResponse dashResponse = (DashResponse) resource.getData();
            if (dashResponse != null) {
                this$0.showBaseView();
                if (dashResponse.getBatchId() != null) {
                    this$0.batchId = dashResponse.getBatchId();
                    this$0.studentId = dashResponse.getStudentId();
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
        FeeFragmentBinding feeFragmentBinding = this$0.get_binding();
        if (feeFragmentBinding == null || (recyclerView = feeFragmentBinding.rvFee) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FeeFragmentBinding feeFragmentBinding = get_binding();
        if (feeFragmentBinding == null || (recyclerView = feeFragmentBinding.rvFee) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FeeFragmentBinding feeFragmentBinding = get_binding();
        if (feeFragmentBinding == null || (recyclerView = feeFragmentBinding.rvFee) == null) {
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
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
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
}