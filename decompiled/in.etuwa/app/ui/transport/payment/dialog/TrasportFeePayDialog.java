package in.etuwa.app.ui.transport.payment.dialog;

import android.content.Context;
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
import in.etuwa.app.databinding.DialogHostelNewConfirmBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.fees.transport.TransportFeeFragment;
import in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmDialog;
import in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmViewModel;
import kotlin.Lazy;
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

/* compiled from: TrasportFeePayDialog.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u000278B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020\"H\u0016J\b\u00100\u001a\u00020\"H\u0016J\u001a\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u000e\u00103\u001a\u00020\"2\u0006\u0010$\u001a\u000204J\b\u00105\u001a\u00020\"H\u0014J\b\u00106\u001a\u00020\"H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\r¨\u00069"}, d2 = {"Lin/etuwa/app/ui/transport/payment/dialog/TrasportFeePayDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogHostelNewConfirmBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogHostelNewConfirmBinding;", "fine", "", "getFine", "()Ljava/lang/String;", "setFine", "(Ljava/lang/String;)V", "hostelNewConfirmViewModel", "Lin/etuwa/app/ui/hostelnew/confirm/HostelNewConfirmViewModel;", "getHostelNewConfirmViewModel", "()Lin/etuwa/app/ui/hostelnew/confirm/HostelNewConfirmViewModel;", "hostelNewConfirmViewModel$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/transport/payment/dialog/TrasportFeePayDialog$FeeDetailListner;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "subTotal", "getSubTotal", "setSubTotal", FeeConfirmDialogKt.ARG_TOTAL, "getTotal", "setTotal", "url", "getUrl", "setUrl", "hideProgress", "", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/fees/transport/TransportFeeFragment;", "setUp", "showProgress", "Companion", "FeeDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrasportFeePayDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogHostelNewConfirmBinding _binding;
    private String fine;

    /* renamed from: hostelNewConfirmViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelNewConfirmViewModel;
    private FeeDetailListner listener;
    private MainCallBackListener listener2;
    private String subTotal;
    private String total;
    private String url;

    /* compiled from: TrasportFeePayDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/transport/payment/dialog/TrasportFeePayDialog$FeeDetailListner;", "", "dismiss", "", "openPaymentPage", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface FeeDetailListner {
        void dismiss();

        void openPaymentPage(String url);
    }

    @JvmStatic
    public static final HostelNewConfirmDialog newInstance(String str, String str2, String str3, String str4) {
        return INSTANCE.newInstance(str, str2, str3, str4);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public TrasportFeePayDialog() {
        final TrasportFeePayDialog trasportFeePayDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(trasportFeePayDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelNewConfirmViewModel = FragmentViewModelLazyKt.createViewModelLazy(trasportFeePayDialog, Reflection.getOrCreateKotlinClass(HostelNewConfirmViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelNewConfirmViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final HostelNewConfirmViewModel getHostelNewConfirmViewModel() {
        return (HostelNewConfirmViewModel) this.hostelNewConfirmViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogHostelNewConfirmBinding get_binding() {
        return this._binding;
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

    /* compiled from: TrasportFeePayDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/transport/payment/dialog/TrasportFeePayDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostelnew/confirm/HostelNewConfirmDialog;", "subTotal", "", "fine", FeeConfirmDialogKt.ARG_TOTAL, "url", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelNewConfirmDialog newInstance(String subTotal, String fine, String total, String url) {
            Intrinsics.checkNotNullParameter(subTotal, "subTotal");
            Intrinsics.checkNotNullParameter(fine, "fine");
            Intrinsics.checkNotNullParameter(total, "total");
            Intrinsics.checkNotNullParameter(url, "url");
            HostelNewConfirmDialog hostelNewConfirmDialog = new HostelNewConfirmDialog();
            Bundle bundle = new Bundle();
            bundle.putString(FeeConfirmDialogKt.ARG_SUB_TOTAL, subTotal);
            bundle.putString("fine", fine);
            bundle.putString(FeeConfirmDialogKt.ARG_TOTAL, total);
            bundle.putString("url", url);
            hostelNewConfirmDialog.setArguments(bundle);
            return hostelNewConfirmDialog;
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
        this._binding = DialogHostelNewConfirmBinding.inflate(inflater, container, false);
        DialogHostelNewConfirmBinding dialogHostelNewConfirmBinding = get_binding();
        if (dialogHostelNewConfirmBinding != null) {
            dialogHostelNewConfirmBinding.setHostelNewConfirmViewModel(getHostelNewConfirmViewModel());
        }
        DialogHostelNewConfirmBinding dialogHostelNewConfirmBinding2 = get_binding();
        if (dialogHostelNewConfirmBinding2 != null) {
            dialogHostelNewConfirmBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogHostelNewConfirmBinding dialogHostelNewConfirmBinding3 = get_binding();
        if (dialogHostelNewConfirmBinding3 != null) {
            return dialogHostelNewConfirmBinding3.getRoot();
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
        DialogHostelNewConfirmBinding dialogHostelNewConfirmBinding = get_binding();
        TextView textView2 = dialogHostelNewConfirmBinding != null ? dialogHostelNewConfirmBinding.subTotal : null;
        if (textView2 != null) {
            textView2.setText(this.subTotal);
        }
        DialogHostelNewConfirmBinding dialogHostelNewConfirmBinding2 = get_binding();
        TextView textView3 = dialogHostelNewConfirmBinding2 != null ? dialogHostelNewConfirmBinding2.fine : null;
        if (textView3 != null) {
            textView3.setText(this.fine);
        }
        DialogHostelNewConfirmBinding dialogHostelNewConfirmBinding3 = get_binding();
        TextView textView4 = dialogHostelNewConfirmBinding3 != null ? dialogHostelNewConfirmBinding3.totalAmount : null;
        if (textView4 != null) {
            textView4.setText(this.total);
        }
        DialogHostelNewConfirmBinding dialogHostelNewConfirmBinding4 = get_binding();
        if (dialogHostelNewConfirmBinding4 == null || (textView = dialogHostelNewConfirmBinding4.payConfirmBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TrasportFeePayDialog.setUp$lambda$1(TrasportFeePayDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TrasportFeePayDialog this$0, View view) {
        MainCallBackListener mainCallBackListener;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.url, "") || (mainCallBackListener = this$0.listener2) == null) {
            return;
        }
        String str = this$0.url;
        Intrinsics.checkNotNull(str);
        mainCallBackListener.openPaymentPage(str);
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

    public final void setCallBack(TransportFeeFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}