package in.etuwa.app.ui.hostel.palaihostel.confirmpage;

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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogFeeConfirmBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmViewModel;
import in.etuwa.app.ui.feepartial.hostel.HostelPartialPayment;
import in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment;
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

/* compiled from: PalaiHostelFeeConfirmDialog.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0014J\u0012\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020%H\u0016J\b\u00100\u001a\u00020%H\u0016J\u001a\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020%2\u0006\u00104\u001a\u000207J\b\u00108\u001a\u00020%H\u0014J\b\u00109\u001a\u00020%H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010!\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013¨\u0006<"}, d2 = {"Lin/etuwa/app/ui/hostel/palaihostel/confirmpage/PalaiHostelFeeConfirmDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogFeeConfirmBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogFeeConfirmBinding;", "feeConfirmViewModel", "Lin/etuwa/app/ui/feenewengineer/payment/feeconfirmdialog/FeeConfirmViewModel;", "getFeeConfirmViewModel", "()Lin/etuwa/app/ui/feenewengineer/payment/feeconfirmdialog/FeeConfirmViewModel;", "feeConfirmViewModel$delegate", "Lkotlin/Lazy;", "fine", "", "getFine", "()Ljava/lang/String;", "setFine", "(Ljava/lang/String;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/palaihostel/confirmpage/PalaiHostelFeeConfirmDialog$FeeDetailListner;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "subTotal", "getSubTotal", "setSubTotal", FeeConfirmDialogKt.ARG_TOTAL, "getTotal", "setTotal", "url", "getUrl", "setUrl", "hideProgress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/hostel/palaihostel/PalaiHostelFragment;", "setCallBack2", "Lin/etuwa/app/ui/feepartial/hostel/HostelPartialPayment;", "setUp", "showProgress", "Companion", "FeeDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PalaiHostelFeeConfirmDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogFeeConfirmBinding _binding;

    /* renamed from: feeConfirmViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeConfirmViewModel;
    private String fine;
    private FeeDetailListner listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String subTotal;
    private String total;
    private String url;

    /* compiled from: PalaiHostelFeeConfirmDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/hostel/palaihostel/confirmpage/PalaiHostelFeeConfirmDialog$FeeDetailListner;", "", "dismiss", "", "openPaymentPage", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface FeeDetailListner {
        void dismiss();

        void openPaymentPage(String url);
    }

    @JvmStatic
    public static final PalaiHostelFeeConfirmDialog newInstance(String str, String str2, String str3, String str4) {
        return INSTANCE.newInstance(str, str2, str3, str4);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public PalaiHostelFeeConfirmDialog() {
        final PalaiHostelFeeConfirmDialog palaiHostelFeeConfirmDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(palaiHostelFeeConfirmDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeConfirmViewModel = FragmentViewModelLazyKt.createViewModelLazy(palaiHostelFeeConfirmDialog, Reflection.getOrCreateKotlinClass(FeeConfirmViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeConfirmViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final PalaiHostelFeeConfirmDialog palaiHostelFeeConfirmDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = palaiHostelFeeConfirmDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final FeeConfirmViewModel getFeeConfirmViewModel() {
        return (FeeConfirmViewModel) this.feeConfirmViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogFeeConfirmBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getSubTotal() {
        return this.subTotal;
    }

    public final void setSubTotal(String str) {
        this.subTotal = str;
    }

    public final String getFine() {
        return this.fine;
    }

    public final void setFine(String str) {
        this.fine = str;
    }

    public final String getTotal() {
        return this.total;
    }

    public final void setTotal(String str) {
        this.total = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    /* compiled from: PalaiHostelFeeConfirmDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/hostel/palaihostel/confirmpage/PalaiHostelFeeConfirmDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/palaihostel/confirmpage/PalaiHostelFeeConfirmDialog;", "subTotal", "", "fine", FeeConfirmDialogKt.ARG_TOTAL, "url", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PalaiHostelFeeConfirmDialog newInstance(String subTotal, String fine, String total, String url) {
            Intrinsics.checkNotNullParameter(subTotal, "subTotal");
            Intrinsics.checkNotNullParameter(fine, "fine");
            Intrinsics.checkNotNullParameter(total, "total");
            Intrinsics.checkNotNullParameter(url, "url");
            PalaiHostelFeeConfirmDialog palaiHostelFeeConfirmDialog = new PalaiHostelFeeConfirmDialog();
            Bundle bundle = new Bundle();
            bundle.putString(FeeConfirmDialogKt.ARG_SUB_TOTAL, subTotal);
            bundle.putString("fine", fine);
            bundle.putString(FeeConfirmDialogKt.ARG_TOTAL, total);
            bundle.putString("url", url);
            palaiHostelFeeConfirmDialog.setArguments(bundle);
            return palaiHostelFeeConfirmDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.subTotal = arguments.getString(FeeConfirmDialogKt.ARG_SUB_TOTAL);
            this.fine = arguments.getString("fine");
            this.total = arguments.getString(FeeConfirmDialogKt.ARG_TOTAL);
            this.url = arguments.getString("url");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogFeeConfirmBinding.inflate(inflater, container, false);
        DialogFeeConfirmBinding dialogFeeConfirmBinding = get_binding();
        if (dialogFeeConfirmBinding != null) {
            dialogFeeConfirmBinding.setFeeConfirmViewModel(getFeeConfirmViewModel());
        }
        DialogFeeConfirmBinding dialogFeeConfirmBinding2 = get_binding();
        if (dialogFeeConfirmBinding2 != null) {
            dialogFeeConfirmBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogFeeConfirmBinding dialogFeeConfirmBinding3 = get_binding();
        if (dialogFeeConfirmBinding3 != null) {
            return dialogFeeConfirmBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        TextView textView;
        DialogFeeConfirmBinding dialogFeeConfirmBinding = get_binding();
        TextView textView2 = dialogFeeConfirmBinding != null ? dialogFeeConfirmBinding.subTotal : null;
        if (textView2 != null) {
            textView2.setText(this.total);
        }
        DialogFeeConfirmBinding dialogFeeConfirmBinding2 = get_binding();
        TextView textView3 = dialogFeeConfirmBinding2 != null ? dialogFeeConfirmBinding2.fine : null;
        if (textView3 != null) {
            textView3.setText(this.fine);
        }
        DialogFeeConfirmBinding dialogFeeConfirmBinding3 = get_binding();
        TextView textView4 = dialogFeeConfirmBinding3 != null ? dialogFeeConfirmBinding3.totalAmount : null;
        if (textView4 != null) {
            textView4.setText(this.subTotal);
        }
        DialogFeeConfirmBinding dialogFeeConfirmBinding4 = get_binding();
        if (dialogFeeConfirmBinding4 == null || (textView = dialogFeeConfirmBinding4.payConfirmBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PalaiHostelFeeConfirmDialog.setUp$lambda$1(PalaiHostelFeeConfirmDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(PalaiHostelFeeConfirmDialog this$0, View view) {
        FeeDetailListner feeDetailListner;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.url, "") || (feeDetailListner = this$0.listener) == null) {
            return;
        }
        String str = this$0.url;
        Intrinsics.checkNotNull(str);
        feeDetailListner.openPaymentPage(str);
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

    public final void setCallBack(PalaiHostelFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack2(HostelPartialPayment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }
}