package in.etuwa.app.ui.examregistration.examsubjects.detaildialog;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
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
import in.etuwa.app.databinding.DialogExamSubjectDetailsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment;
import in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment;
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
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

/* compiled from: ExamSubjectDetailDialog.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0016J\u001a\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u000e\u00102\u001a\u00020\u001e2\u0006\u0010 \u001a\u000203J\u000e\u00104\u001a\u00020\u001e2\u0006\u0010 \u001a\u000205J\u000e\u00106\u001a\u00020\u001e2\u0006\u0010 \u001a\u000207J\b\u00108\u001a\u00020\u001eH\u0014J\b\u00109\u001a\u00020\u001eH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogExamSubjectDetailsBinding;", ExamSubjectDetailDialogKt.ARG_AMOUNT, "", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogExamSubjectDetailsBinding;", "examSubjectDetailViewModel", "Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailViewModel;", "getExamSubjectDetailViewModel", "()Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailViewModel;", "examSubjectDetailViewModel$delegate", "Lkotlin/Lazy;", "fine", "fixedAmount", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailDialog$ExamDetailListner;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", FeeConfirmDialogKt.ARG_TOTAL, "url", "hideProgress", "", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectFragment;", "setCallBack2", "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterFragment;", "setCallBackUpdate", "Lin/etuwa/app/ui/examregistration/examsubjects/updateregister/UpdateRegisterFragment;", "setUp", "showProgress", "Companion", "ExamDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExamSubjectDetailDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogExamSubjectDetailsBinding _binding;
    private String amount;

    /* renamed from: examSubjectDetailViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examSubjectDetailViewModel;
    private String fine;
    private String fixedAmount;
    private ExamDetailListner listener;
    private MainCallBackListener listener2;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String total;
    private String url;

    /* compiled from: ExamSubjectDetailDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailDialog$ExamDetailListner;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ExamDetailListner {
    }

    @JvmStatic
    public static final ExamSubjectDetailDialog newInstance(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ExamSubjectDetailDialog() {
        final ExamSubjectDetailDialog examSubjectDetailDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examSubjectDetailDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examSubjectDetailViewModel = FragmentViewModelLazyKt.createViewModelLazy(examSubjectDetailDialog, Reflection.getOrCreateKotlinClass(ExamSubjectDetailViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ExamSubjectDetailViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamSubjectDetailDialog examSubjectDetailDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = examSubjectDetailDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.url = "";
    }

    private final ExamSubjectDetailViewModel getExamSubjectDetailViewModel() {
        return (ExamSubjectDetailViewModel) this.examSubjectDetailViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogExamSubjectDetailsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ExamSubjectDetailDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailDialog;", ExamSubjectDetailDialogKt.ARG_AMOUNT, "", "fixedAmount", "fine", FeeConfirmDialogKt.ARG_TOTAL, "url", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamSubjectDetailDialog newInstance(String amount, String fixedAmount, String fine, String total, String url) {
            Intrinsics.checkNotNullParameter(amount, "amount");
            Intrinsics.checkNotNullParameter(fixedAmount, "fixedAmount");
            Intrinsics.checkNotNullParameter(fine, "fine");
            Intrinsics.checkNotNullParameter(total, "total");
            Intrinsics.checkNotNullParameter(url, "url");
            ExamSubjectDetailDialog examSubjectDetailDialog = new ExamSubjectDetailDialog();
            Bundle bundle = new Bundle();
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, amount);
            bundle.putString("fixed", fixedAmount);
            bundle.putString("fine", fine);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_TOTAL, total);
            bundle.putString("url", url);
            examSubjectDetailDialog.setArguments(bundle);
            return examSubjectDetailDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.amount = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.fixedAmount = arguments.getString("fixed");
            this.fine = arguments.getString("fine");
            this.total = arguments.getString(ExamSubjectDetailDialogKt.ARG_TOTAL);
            this.url = String.valueOf(arguments.getString("url"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogExamSubjectDetailsBinding.inflate(inflater, container, false);
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding = get_binding();
        if (dialogExamSubjectDetailsBinding != null) {
            dialogExamSubjectDetailsBinding.setExamSubjectDetailViewModel(getExamSubjectDetailViewModel());
        }
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding2 = get_binding();
        if (dialogExamSubjectDetailsBinding2 != null) {
            dialogExamSubjectDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding3 = get_binding();
        if (dialogExamSubjectDetailsBinding3 != null) {
            return dialogExamSubjectDetailsBinding3.getRoot();
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
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding = get_binding();
        TextView textView2 = dialogExamSubjectDetailsBinding != null ? dialogExamSubjectDetailsBinding.tvFine : null;
        if (textView2 != null) {
            textView2.setText(this.fine);
        }
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding2 = get_binding();
        TextView textView3 = dialogExamSubjectDetailsBinding2 != null ? dialogExamSubjectDetailsBinding2.tvAmount : null;
        if (textView3 != null) {
            textView3.setText(this.amount);
        }
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding3 = get_binding();
        TextView textView4 = dialogExamSubjectDetailsBinding3 != null ? dialogExamSubjectDetailsBinding3.tvFixed : null;
        if (textView4 != null) {
            textView4.setText(this.fixedAmount);
        }
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding4 = get_binding();
        TextView textView5 = dialogExamSubjectDetailsBinding4 != null ? dialogExamSubjectDetailsBinding4.tvTotal : null;
        if (textView5 != null) {
            textView5.setText(this.total);
        }
        DialogExamSubjectDetailsBinding dialogExamSubjectDetailsBinding5 = get_binding();
        if (dialogExamSubjectDetailsBinding5 == null || (textView = dialogExamSubjectDetailsBinding5.payNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamSubjectDetailDialog.setUp$lambda$1(ExamSubjectDetailDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ExamSubjectDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.url, "")) {
            return;
        }
        System.out.println((Object) this$0.url);
        System.out.println((Object) this$0.url);
        MainCallBackListener mainCallBackListener = this$0.listener2;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPaymentPage(this$0.url);
        }
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this._binding = null;
    }

    public final void setCallBack(ExamSubjectFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack2(ExamRegisterFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBackUpdate(UpdateRegisterFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }
}