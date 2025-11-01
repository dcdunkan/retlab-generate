package in.etuwa.app.ui.profile.bankdetails;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.dash.ProfileResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogBankDetailsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.profile.ProfileFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.HashMap;
import java.util.Locale;
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
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: BankDetailsDialog.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020(H\u0014J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020(H\u0002J\b\u00100\u001a\u00020(H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020@H\u0016J\u001a\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u000e\u0010C\u001a\u00020(2\u0006\u00102\u001a\u00020DJ\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0006H\u0002J\b\u0010H\u001a\u00020(H\u0014J\b\u0010I\u001a\u00020(H\u0014J\u0010\u0010J\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lin/etuwa/app/ui/profile/bankdetails/BankDetailsDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogBankDetailsBinding;", "abcId", "", "addEdit", "getAddEdit", "()Ljava/lang/String;", "setAddEdit", "(Ljava/lang/String;)V", "bankDetailsViewModel", "Lin/etuwa/app/ui/profile/bankdetails/BankDetailsViewModel;", "getBankDetailsViewModel", "()Lin/etuwa/app/ui/profile/bankdetails/BankDetailsViewModel;", "bankDetailsViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogBankDetailsBinding;", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "instruction", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/bankdetails/BankDetailsDialog$ProfileListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "url", "video", "confirmApproveView", "", "message", "hideProgress", "isValidIFSC", "ifsc", "isValidIndianBankAccount", "accountNumber", "listenResponse", "listenUpdateResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/profile/ProfileFragment;", "setLastDigitRed", "Landroid/text/SpannableString;", "text", "setUp", "showProgress", "successApproveView", "Companion", "ProfileListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankDetailsDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogBankDetailsBinding _binding;
    private String abcId;
    private String addEdit;

    /* renamed from: bankDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy bankDetailsViewModel;
    private boolean flag;
    private String instruction;
    private ProfileListener listener;
    private MainCallBackListener listener2;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String url;
    private String video;

    /* compiled from: BankDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/bankdetails/BankDetailsDialog$ProfileListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProfileListener {
        void dismiss();
    }

    @JvmStatic
    public static final BankDetailsDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public BankDetailsDialog() {
        final BankDetailsDialog bankDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(bankDetailsDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.bankDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(bankDetailsDialog, Reflection.getOrCreateKotlinClass(BankDetailsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(BankDetailsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.url = "";
        this.addEdit = "";
        final BankDetailsDialog bankDetailsDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = bankDetailsDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BankDetailsViewModel getBankDetailsViewModel() {
        return (BankDetailsViewModel) this.bankDetailsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogBankDetailsBinding get_binding() {
        return this._binding;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    public final String getAddEdit() {
        return this.addEdit;
    }

    public final void setAddEdit(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addEdit = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: BankDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/profile/bankdetails/BankDetailsDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/bankdetails/BankDetailsDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BankDetailsDialog newInstance() {
            BankDetailsDialog bankDetailsDialog = new BankDetailsDialog();
            bankDetailsDialog.setArguments(new Bundle());
            return bankDetailsDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogBankDetailsBinding.inflate(inflater, container, false);
        DialogBankDetailsBinding dialogBankDetailsBinding = get_binding();
        if (dialogBankDetailsBinding != null) {
            dialogBankDetailsBinding.setBankDetailsViewModel(getBankDetailsViewModel());
        }
        DialogBankDetailsBinding dialogBankDetailsBinding2 = get_binding();
        if (dialogBankDetailsBinding2 != null) {
            dialogBankDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogBankDetailsBinding dialogBankDetailsBinding3 = get_binding();
        if (dialogBankDetailsBinding3 != null) {
            return dialogBankDetailsBinding3.getRoot();
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
        listenResponse();
        listenUpdateResponse();
        getBankDetailsViewModel().getDashData();
        DialogBankDetailsBinding dialogBankDetailsBinding = get_binding();
        if (dialogBankDetailsBinding == null || (textView = dialogBankDetailsBinding.editBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankDetailsDialog.setUp$lambda$2(BankDetailsDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(final BankDetailsDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.flag) {
            this$0.flag = true;
            DialogBankDetailsBinding dialogBankDetailsBinding = this$0.get_binding();
            LinearLayout linearLayout = dialogBankDetailsBinding != null ? dialogBankDetailsBinding.updateLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            Drawable drawable = ContextCompat.getDrawable(this$0.requireContext(), R.drawable.baseline_close_24);
            DialogBankDetailsBinding dialogBankDetailsBinding2 = this$0.get_binding();
            if (dialogBankDetailsBinding2 != null && (textView5 = dialogBankDetailsBinding2.editBtn) != null) {
                textView5.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding3 = this$0.get_binding();
            TextView textView6 = dialogBankDetailsBinding3 != null ? dialogBankDetailsBinding3.name : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding4 = this$0.get_binding();
            TextView textView7 = dialogBankDetailsBinding4 != null ? dialogBankDetailsBinding4.accNo : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding5 = this$0.get_binding();
            TextView textView8 = dialogBankDetailsBinding5 != null ? dialogBankDetailsBinding5.ifsc : null;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding6 = this$0.get_binding();
            TextView textView9 = dialogBankDetailsBinding6 != null ? dialogBankDetailsBinding6.branch : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding7 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogBankDetailsBinding7 != null ? dialogBankDetailsBinding7.retypeAccLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding8 = this$0.get_binding();
            EditText editText = dialogBankDetailsBinding8 != null ? dialogBankDetailsBinding8.nameEt : null;
            if (editText != null) {
                editText.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding9 = this$0.get_binding();
            EditText editText2 = dialogBankDetailsBinding9 != null ? dialogBankDetailsBinding9.accNoEt : null;
            if (editText2 != null) {
                editText2.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding10 = this$0.get_binding();
            EditText editText3 = dialogBankDetailsBinding10 != null ? dialogBankDetailsBinding10.ifscEt : null;
            if (editText3 != null) {
                editText3.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding11 = this$0.get_binding();
            EditText editText4 = dialogBankDetailsBinding11 != null ? dialogBankDetailsBinding11.branchEt : null;
            if (editText4 != null) {
                editText4.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding12 = this$0.get_binding();
            TextView textView10 = dialogBankDetailsBinding12 != null ? dialogBankDetailsBinding12.view1 : null;
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding13 = this$0.get_binding();
            TextView textView11 = dialogBankDetailsBinding13 != null ? dialogBankDetailsBinding13.view2 : null;
            if (textView11 != null) {
                textView11.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding14 = this$0.get_binding();
            TextView textView12 = dialogBankDetailsBinding14 != null ? dialogBankDetailsBinding14.view4 : null;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding15 = this$0.get_binding();
            TextView textView13 = dialogBankDetailsBinding15 != null ? dialogBankDetailsBinding15.bankNameTv : null;
            if (textView13 != null) {
                textView13.setText(this$0.setLastDigitRed("Bank Name *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding16 = this$0.get_binding();
            TextView textView14 = dialogBankDetailsBinding16 != null ? dialogBankDetailsBinding16.accNoTv : null;
            if (textView14 != null) {
                textView14.setText(this$0.setLastDigitRed("Account Number *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding17 = this$0.get_binding();
            TextView textView15 = dialogBankDetailsBinding17 != null ? dialogBankDetailsBinding17.branchNameTv : null;
            if (textView15 != null) {
                textView15.setText(this$0.setLastDigitRed("Branch *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding18 = this$0.get_binding();
            TextView textView16 = dialogBankDetailsBinding18 != null ? dialogBankDetailsBinding18.ifscTv : null;
            if (textView16 != null) {
                textView16.setText(this$0.setLastDigitRed("IFSC *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding19 = this$0.get_binding();
            textView2 = dialogBankDetailsBinding19 != null ? dialogBankDetailsBinding19.retypeAccNoTv : null;
            if (textView2 != null) {
                textView2.setText(this$0.setLastDigitRed("Re-Type Account Number *"));
            }
        } else {
            this$0.flag = false;
            DialogBankDetailsBinding dialogBankDetailsBinding20 = this$0.get_binding();
            LinearLayout linearLayout3 = dialogBankDetailsBinding20 != null ? dialogBankDetailsBinding20.updateLyt : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            if (Intrinsics.areEqual(this$0.addEdit, "Edit")) {
                Drawable drawable2 = ContextCompat.getDrawable(this$0.requireContext(), R.drawable.ic_edit);
                DialogBankDetailsBinding dialogBankDetailsBinding21 = this$0.get_binding();
                if (dialogBankDetailsBinding21 != null && (textView3 = dialogBankDetailsBinding21.editBtn) != null) {
                    textView3.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else {
                Drawable drawable3 = ContextCompat.getDrawable(this$0.requireContext(), R.drawable.baseline_add_white);
                DialogBankDetailsBinding dialogBankDetailsBinding22 = this$0.get_binding();
                if (dialogBankDetailsBinding22 != null && (textView = dialogBankDetailsBinding22.editBtn) != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable3, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
            DialogBankDetailsBinding dialogBankDetailsBinding23 = this$0.get_binding();
            TextView textView17 = dialogBankDetailsBinding23 != null ? dialogBankDetailsBinding23.name : null;
            if (textView17 != null) {
                textView17.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding24 = this$0.get_binding();
            TextView textView18 = dialogBankDetailsBinding24 != null ? dialogBankDetailsBinding24.accNo : null;
            if (textView18 != null) {
                textView18.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding25 = this$0.get_binding();
            TextView textView19 = dialogBankDetailsBinding25 != null ? dialogBankDetailsBinding25.ifsc : null;
            if (textView19 != null) {
                textView19.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding26 = this$0.get_binding();
            TextView textView20 = dialogBankDetailsBinding26 != null ? dialogBankDetailsBinding26.branch : null;
            if (textView20 != null) {
                textView20.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding27 = this$0.get_binding();
            LinearLayout linearLayout4 = dialogBankDetailsBinding27 != null ? dialogBankDetailsBinding27.retypeAccLyt : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding28 = this$0.get_binding();
            EditText editText5 = dialogBankDetailsBinding28 != null ? dialogBankDetailsBinding28.nameEt : null;
            if (editText5 != null) {
                editText5.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding29 = this$0.get_binding();
            EditText editText6 = dialogBankDetailsBinding29 != null ? dialogBankDetailsBinding29.accNoEt : null;
            if (editText6 != null) {
                editText6.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding30 = this$0.get_binding();
            EditText editText7 = dialogBankDetailsBinding30 != null ? dialogBankDetailsBinding30.ifscEt : null;
            if (editText7 != null) {
                editText7.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding31 = this$0.get_binding();
            EditText editText8 = dialogBankDetailsBinding31 != null ? dialogBankDetailsBinding31.branchEt : null;
            if (editText8 != null) {
                editText8.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding32 = this$0.get_binding();
            TextView textView21 = dialogBankDetailsBinding32 != null ? dialogBankDetailsBinding32.view1 : null;
            if (textView21 != null) {
                textView21.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding33 = this$0.get_binding();
            TextView textView22 = dialogBankDetailsBinding33 != null ? dialogBankDetailsBinding33.view2 : null;
            if (textView22 != null) {
                textView22.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding34 = this$0.get_binding();
            TextView textView23 = dialogBankDetailsBinding34 != null ? dialogBankDetailsBinding34.view4 : null;
            if (textView23 != null) {
                textView23.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding35 = this$0.get_binding();
            TextView textView24 = dialogBankDetailsBinding35 != null ? dialogBankDetailsBinding35.bankNameTv : null;
            if (textView24 != null) {
                textView24.setText("Bank Name");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding36 = this$0.get_binding();
            TextView textView25 = dialogBankDetailsBinding36 != null ? dialogBankDetailsBinding36.accNoTv : null;
            if (textView25 != null) {
                textView25.setText("Account Number");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding37 = this$0.get_binding();
            TextView textView26 = dialogBankDetailsBinding37 != null ? dialogBankDetailsBinding37.branchNameTv : null;
            if (textView26 != null) {
                textView26.setText("Branch");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding38 = this$0.get_binding();
            TextView textView27 = dialogBankDetailsBinding38 != null ? dialogBankDetailsBinding38.ifscTv : null;
            if (textView27 != null) {
                textView27.setText("IFSC");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding39 = this$0.get_binding();
            textView2 = dialogBankDetailsBinding39 != null ? dialogBankDetailsBinding39.retypeAccNoTv : null;
            if (textView2 != null) {
                textView2.setText(this$0.setLastDigitRed("Re-Type Account Number *"));
            }
        }
        DialogBankDetailsBinding dialogBankDetailsBinding40 = this$0.get_binding();
        if (dialogBankDetailsBinding40 == null || (textView4 = dialogBankDetailsBinding40.updateBtn) == null) {
            return;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BankDetailsDialog.setUp$lambda$2$lambda$1(BankDetailsDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2$lambda$1(BankDetailsDialog this$0, View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        EditText editText7;
        EditText editText8;
        EditText editText9;
        EditText editText10;
        EditText editText11;
        EditText editText12;
        EditText editText13;
        EditText editText14;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogBankDetailsBinding dialogBankDetailsBinding = this$0.get_binding();
        Editable editable = null;
        if (Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding == null || (editText14 = dialogBankDetailsBinding.nameEt) == null) ? null : editText14.getText()), "")) {
            this$0.confirmApproveView("Bank name cannot be blank");
            return;
        }
        DialogBankDetailsBinding dialogBankDetailsBinding2 = this$0.get_binding();
        if (!Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding2 == null || (editText13 = dialogBankDetailsBinding2.accNoEt) == null) ? null : editText13.getText()), "")) {
            DialogBankDetailsBinding dialogBankDetailsBinding3 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding3 == null || (editText12 = dialogBankDetailsBinding3.retypeAccNoEt) == null) ? null : editText12.getText()), "")) {
                DialogBankDetailsBinding dialogBankDetailsBinding4 = this$0.get_binding();
                if (Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding4 == null || (editText11 = dialogBankDetailsBinding4.branchEt) == null) ? null : editText11.getText()), "")) {
                    this$0.confirmApproveView("Branch name cannot be empty");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding5 = this$0.get_binding();
                if (Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding5 == null || (editText10 = dialogBankDetailsBinding5.ifscEt) == null) ? null : editText10.getText()), "")) {
                    this$0.confirmApproveView("IFSC code name cannot be empty");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding6 = this$0.get_binding();
                if (!this$0.isValidIndianBankAccount(String.valueOf((dialogBankDetailsBinding6 == null || (editText9 = dialogBankDetailsBinding6.accNoEt) == null) ? null : editText9.getText()))) {
                    this$0.confirmApproveView("Please input valid Account Number");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding7 = this$0.get_binding();
                String valueOf = String.valueOf((dialogBankDetailsBinding7 == null || (editText8 = dialogBankDetailsBinding7.retypeAccNoEt) == null) ? null : editText8.getText());
                DialogBankDetailsBinding dialogBankDetailsBinding8 = this$0.get_binding();
                if (!Intrinsics.areEqual(valueOf, String.valueOf((dialogBankDetailsBinding8 == null || (editText7 = dialogBankDetailsBinding8.accNoEt) == null) ? null : editText7.getText()))) {
                    this$0.confirmApproveView("Account number mismatch");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding9 = this$0.get_binding();
                if (!this$0.isValidIFSC(String.valueOf((dialogBankDetailsBinding9 == null || (editText6 = dialogBankDetailsBinding9.ifscEt) == null) ? null : editText6.getText()))) {
                    this$0.confirmApproveView("Please input valid IFSC");
                    return;
                }
                HashMap hashMap = new HashMap();
                DialogBankDetailsBinding dialogBankDetailsBinding10 = this$0.get_binding();
                hashMap.put("StudentDetail[bank_name]", String.valueOf((dialogBankDetailsBinding10 == null || (editText5 = dialogBankDetailsBinding10.nameEt) == null) ? null : editText5.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding11 = this$0.get_binding();
                hashMap.put("StudentDetail[bank_accno]", String.valueOf((dialogBankDetailsBinding11 == null || (editText4 = dialogBankDetailsBinding11.accNoEt) == null) ? null : editText4.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding12 = this$0.get_binding();
                hashMap.put("StudentDetail[bank_accno_repeat]", String.valueOf((dialogBankDetailsBinding12 == null || (editText3 = dialogBankDetailsBinding12.retypeAccNoEt) == null) ? null : editText3.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding13 = this$0.get_binding();
                hashMap.put("StudentDetail[bank_ifsc_code]", String.valueOf((dialogBankDetailsBinding13 == null || (editText2 = dialogBankDetailsBinding13.ifscEt) == null) ? null : editText2.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding14 = this$0.get_binding();
                if (dialogBankDetailsBinding14 != null && (editText = dialogBankDetailsBinding14.branchEt) != null) {
                    editable = editText.getText();
                }
                hashMap.put("StudentDetail[bank_branch]", String.valueOf(editable));
                this$0.getBankDetailsViewModel().getUpdateData(hashMap);
                return;
            }
        }
        this$0.confirmApproveView("Account number cannot be blank");
    }

    private final void listenResponse() {
        getBankDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new BankDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ProfileResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$listenResponse$1

            /* compiled from: BankDetailsDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ProfileResponse> resource) {
                invoke2((Resource<ProfileResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ProfileResponse> resource) {
                DialogBankDetailsBinding dialogBankDetailsBinding;
                DialogBankDetailsBinding dialogBankDetailsBinding2;
                DialogBankDetailsBinding dialogBankDetailsBinding3;
                DialogBankDetailsBinding dialogBankDetailsBinding4;
                DialogBankDetailsBinding dialogBankDetailsBinding5;
                DialogBankDetailsBinding dialogBankDetailsBinding6;
                DialogBankDetailsBinding dialogBankDetailsBinding7;
                DialogBankDetailsBinding dialogBankDetailsBinding8;
                DialogBankDetailsBinding dialogBankDetailsBinding9;
                DialogBankDetailsBinding dialogBankDetailsBinding10;
                DialogBankDetailsBinding dialogBankDetailsBinding11;
                TextView textView;
                DialogBankDetailsBinding dialogBankDetailsBinding12;
                TextView textView2;
                SharedPrefManager preference;
                DialogBankDetailsBinding dialogBankDetailsBinding13;
                DialogBankDetailsBinding dialogBankDetailsBinding14;
                DialogBankDetailsBinding dialogBankDetailsBinding15;
                TextView textView3;
                EditText editText;
                EditText editText2;
                EditText editText3;
                EditText editText4;
                EditText editText5;
                DialogBankDetailsBinding dialogBankDetailsBinding16;
                TextView textView4;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        BankDetailsDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        BankDetailsDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    BankDetailsDialog.this.hideProgress();
                    dialogBankDetailsBinding16 = BankDetailsDialog.this.get_binding();
                    if (dialogBankDetailsBinding16 == null || (textView4 = dialogBankDetailsBinding16.name) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView4, message);
                    return;
                }
                BankDetailsDialog.this.hideProgress();
                ProfileResponse data = resource.getData();
                if (data != null) {
                    BankDetailsDialog bankDetailsDialog = BankDetailsDialog.this;
                    dialogBankDetailsBinding = bankDetailsDialog.get_binding();
                    TextView textView5 = dialogBankDetailsBinding != null ? dialogBankDetailsBinding.name : null;
                    if (textView5 != null) {
                        textView5.setText(data.getBank_name());
                    }
                    dialogBankDetailsBinding2 = bankDetailsDialog.get_binding();
                    TextView textView6 = dialogBankDetailsBinding2 != null ? dialogBankDetailsBinding2.ifsc : null;
                    if (textView6 != null) {
                        textView6.setText(data.getBank_ifsc_code());
                    }
                    dialogBankDetailsBinding3 = bankDetailsDialog.get_binding();
                    TextView textView7 = dialogBankDetailsBinding3 != null ? dialogBankDetailsBinding3.branch : null;
                    if (textView7 != null) {
                        textView7.setText(data.getBank_branch());
                    }
                    dialogBankDetailsBinding4 = bankDetailsDialog.get_binding();
                    TextView textView8 = dialogBankDetailsBinding4 != null ? dialogBankDetailsBinding4.accNo : null;
                    if (textView8 != null) {
                        textView8.setText(data.getBank_accno());
                    }
                    dialogBankDetailsBinding5 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding5 != null && (editText5 = dialogBankDetailsBinding5.nameEt) != null) {
                        editText5.setText(data.getBank_name());
                    }
                    dialogBankDetailsBinding6 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding6 != null && (editText4 = dialogBankDetailsBinding6.accNoEt) != null) {
                        editText4.setText(data.getBank_accno());
                    }
                    dialogBankDetailsBinding7 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding7 != null && (editText3 = dialogBankDetailsBinding7.ifscEt) != null) {
                        editText3.setText(data.getBank_ifsc_code());
                    }
                    dialogBankDetailsBinding8 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding8 != null && (editText2 = dialogBankDetailsBinding8.branchEt) != null) {
                        editText2.setText(data.getBank_branch());
                    }
                    dialogBankDetailsBinding9 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding9 != null && (editText = dialogBankDetailsBinding9.retypeAccNoEt) != null) {
                        editText.setText(data.getBank_accno());
                    }
                    if (Intrinsics.areEqual(data.getBank_name(), "") && Intrinsics.areEqual(data.getBank_accno(), "") && Intrinsics.areEqual(data.getBank_branch(), "") && Intrinsics.areEqual(data.getBank_ifsc_code(), "")) {
                        bankDetailsDialog.setAddEdit("Add");
                        dialogBankDetailsBinding14 = bankDetailsDialog.get_binding();
                        TextView textView9 = dialogBankDetailsBinding14 != null ? dialogBankDetailsBinding14.updateBtn : null;
                        if (textView9 != null) {
                            textView9.setText("Add");
                        }
                        Drawable drawable = ContextCompat.getDrawable(bankDetailsDialog.requireContext(), R.drawable.baseline_add_white);
                        dialogBankDetailsBinding15 = bankDetailsDialog.get_binding();
                        if (dialogBankDetailsBinding15 != null && (textView3 = dialogBankDetailsBinding15.editBtn) != null) {
                            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else {
                        bankDetailsDialog.setAddEdit("Edit");
                        Drawable drawable2 = ContextCompat.getDrawable(bankDetailsDialog.requireContext(), R.drawable.ic_edit);
                        dialogBankDetailsBinding10 = bankDetailsDialog.get_binding();
                        if (dialogBankDetailsBinding10 != null && (textView = dialogBankDetailsBinding10.editBtn) != null) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                        dialogBankDetailsBinding11 = bankDetailsDialog.get_binding();
                        TextView textView10 = dialogBankDetailsBinding11 != null ? dialogBankDetailsBinding11.updateBtn : null;
                        if (textView10 != null) {
                            textView10.setText("Update");
                        }
                    }
                    if (!data.getBank_edit()) {
                        preference = bankDetailsDialog.getPreference();
                        if (!StringsKt.contains$default((CharSequence) preference.getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                            dialogBankDetailsBinding13 = bankDetailsDialog.get_binding();
                            textView2 = dialogBankDetailsBinding13 != null ? dialogBankDetailsBinding13.editBtn : null;
                            if (textView2 == null) {
                                return;
                            }
                            textView2.setVisibility(8);
                            return;
                        }
                    }
                    dialogBankDetailsBinding12 = bankDetailsDialog.get_binding();
                    textView2 = dialogBankDetailsBinding12 != null ? dialogBankDetailsBinding12.editBtn : null;
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setVisibility(0);
                }
            }
        }));
    }

    private final void listenUpdateResponse() {
        getBankDetailsViewModel().getUpdateResponse().observe(getViewLifecycleOwner(), new BankDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$listenUpdateResponse$1

            /* compiled from: BankDetailsDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                BankDetailsViewModel bankDetailsViewModel;
                DialogBankDetailsBinding dialogBankDetailsBinding;
                DialogBankDetailsBinding dialogBankDetailsBinding2;
                DialogBankDetailsBinding dialogBankDetailsBinding3;
                DialogBankDetailsBinding dialogBankDetailsBinding4;
                DialogBankDetailsBinding dialogBankDetailsBinding5;
                DialogBankDetailsBinding dialogBankDetailsBinding6;
                DialogBankDetailsBinding dialogBankDetailsBinding7;
                DialogBankDetailsBinding dialogBankDetailsBinding8;
                DialogBankDetailsBinding dialogBankDetailsBinding9;
                DialogBankDetailsBinding dialogBankDetailsBinding10;
                DialogBankDetailsBinding dialogBankDetailsBinding11;
                DialogBankDetailsBinding dialogBankDetailsBinding12;
                DialogBankDetailsBinding dialogBankDetailsBinding13;
                DialogBankDetailsBinding dialogBankDetailsBinding14;
                DialogBankDetailsBinding dialogBankDetailsBinding15;
                DialogBankDetailsBinding dialogBankDetailsBinding16;
                DialogBankDetailsBinding dialogBankDetailsBinding17;
                DialogBankDetailsBinding dialogBankDetailsBinding18;
                SpannableString lastDigitRed;
                DialogBankDetailsBinding dialogBankDetailsBinding19;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        BankDetailsDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        BankDetailsDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    BankDetailsDialog.this.hideProgress();
                    dialogBankDetailsBinding19 = BankDetailsDialog.this.get_binding();
                    if (dialogBankDetailsBinding19 == null || (textView = dialogBankDetailsBinding19.name) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                BankDetailsDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    BankDetailsDialog bankDetailsDialog = BankDetailsDialog.this;
                    if (data.getSuccess()) {
                        bankDetailsDialog.successApproveView(data.getMessage());
                        bankDetailsViewModel = bankDetailsDialog.getBankDetailsViewModel();
                        bankDetailsViewModel.getDashData();
                        dialogBankDetailsBinding = bankDetailsDialog.get_binding();
                        LinearLayout linearLayout = dialogBankDetailsBinding != null ? dialogBankDetailsBinding.updateLyt : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                        dialogBankDetailsBinding2 = bankDetailsDialog.get_binding();
                        TextView textView2 = dialogBankDetailsBinding2 != null ? dialogBankDetailsBinding2.name : null;
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                        }
                        dialogBankDetailsBinding3 = bankDetailsDialog.get_binding();
                        TextView textView3 = dialogBankDetailsBinding3 != null ? dialogBankDetailsBinding3.accNo : null;
                        if (textView3 != null) {
                            textView3.setVisibility(0);
                        }
                        dialogBankDetailsBinding4 = bankDetailsDialog.get_binding();
                        TextView textView4 = dialogBankDetailsBinding4 != null ? dialogBankDetailsBinding4.ifsc : null;
                        if (textView4 != null) {
                            textView4.setVisibility(0);
                        }
                        dialogBankDetailsBinding5 = bankDetailsDialog.get_binding();
                        TextView textView5 = dialogBankDetailsBinding5 != null ? dialogBankDetailsBinding5.branch : null;
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                        }
                        dialogBankDetailsBinding6 = bankDetailsDialog.get_binding();
                        LinearLayout linearLayout2 = dialogBankDetailsBinding6 != null ? dialogBankDetailsBinding6.retypeAccLyt : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                        dialogBankDetailsBinding7 = bankDetailsDialog.get_binding();
                        EditText editText = dialogBankDetailsBinding7 != null ? dialogBankDetailsBinding7.nameEt : null;
                        if (editText != null) {
                            editText.setVisibility(8);
                        }
                        dialogBankDetailsBinding8 = bankDetailsDialog.get_binding();
                        EditText editText2 = dialogBankDetailsBinding8 != null ? dialogBankDetailsBinding8.accNoEt : null;
                        if (editText2 != null) {
                            editText2.setVisibility(8);
                        }
                        dialogBankDetailsBinding9 = bankDetailsDialog.get_binding();
                        EditText editText3 = dialogBankDetailsBinding9 != null ? dialogBankDetailsBinding9.ifscEt : null;
                        if (editText3 != null) {
                            editText3.setVisibility(8);
                        }
                        dialogBankDetailsBinding10 = bankDetailsDialog.get_binding();
                        EditText editText4 = dialogBankDetailsBinding10 != null ? dialogBankDetailsBinding10.branchEt : null;
                        if (editText4 != null) {
                            editText4.setVisibility(8);
                        }
                        dialogBankDetailsBinding11 = bankDetailsDialog.get_binding();
                        TextView textView6 = dialogBankDetailsBinding11 != null ? dialogBankDetailsBinding11.view1 : null;
                        if (textView6 != null) {
                            textView6.setVisibility(0);
                        }
                        dialogBankDetailsBinding12 = bankDetailsDialog.get_binding();
                        TextView textView7 = dialogBankDetailsBinding12 != null ? dialogBankDetailsBinding12.view2 : null;
                        if (textView7 != null) {
                            textView7.setVisibility(0);
                        }
                        dialogBankDetailsBinding13 = bankDetailsDialog.get_binding();
                        TextView textView8 = dialogBankDetailsBinding13 != null ? dialogBankDetailsBinding13.view4 : null;
                        if (textView8 != null) {
                            textView8.setVisibility(0);
                        }
                        dialogBankDetailsBinding14 = bankDetailsDialog.get_binding();
                        TextView textView9 = dialogBankDetailsBinding14 != null ? dialogBankDetailsBinding14.bankNameTv : null;
                        if (textView9 != null) {
                            textView9.setText("Bank Name");
                        }
                        dialogBankDetailsBinding15 = bankDetailsDialog.get_binding();
                        TextView textView10 = dialogBankDetailsBinding15 != null ? dialogBankDetailsBinding15.accNoTv : null;
                        if (textView10 != null) {
                            textView10.setText("Account Number");
                        }
                        dialogBankDetailsBinding16 = bankDetailsDialog.get_binding();
                        TextView textView11 = dialogBankDetailsBinding16 != null ? dialogBankDetailsBinding16.branchNameTv : null;
                        if (textView11 != null) {
                            textView11.setText("Branch");
                        }
                        dialogBankDetailsBinding17 = bankDetailsDialog.get_binding();
                        TextView textView12 = dialogBankDetailsBinding17 != null ? dialogBankDetailsBinding17.ifscTv : null;
                        if (textView12 != null) {
                            textView12.setText("IFSC");
                        }
                        dialogBankDetailsBinding18 = bankDetailsDialog.get_binding();
                        TextView textView13 = dialogBankDetailsBinding18 != null ? dialogBankDetailsBinding18.retypeAccNoTv : null;
                        if (textView13 == null) {
                            return;
                        }
                        lastDigitRed = bankDetailsDialog.setLastDigitRed("Re-Type Account Number *");
                        textView13.setText(lastDigitRed);
                        return;
                    }
                    bankDetailsDialog.confirmApproveView(data.getError());
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmApproveView(String message) {
        SpannableString spannableString = new SpannableString(message);
        spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, message.length(), 33);
        new MaterialAlertDialogBuilder(requireContext()).setTitle((CharSequence) "Please fix the following input errors:").setMessage((CharSequence) spannableString).setPositiveButton((CharSequence) "OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void successApproveView(String message) {
        SpannableString spannableString = new SpannableString(message);
        spannableString.setSpan(new ForegroundColorSpan(-16711936), 0, message.length(), 33);
        new MaterialAlertDialogBuilder(requireContext()).setTitle((CharSequence) "Success").setMessage((CharSequence) spannableString).setPositiveButton((CharSequence) "OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpannableString setLastDigitRed(String text) {
        String str = text;
        SpannableString spannableString = new SpannableString(str);
        if (str.length() > 0) {
            int length = text.length() - 1;
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), length, length + 1, 33);
        }
        return spannableString;
    }

    private final boolean isValidIndianBankAccount(String accountNumber) {
        boolean z;
        int length = accountNumber.length();
        if (9 <= length && length < 19) {
            String str = accountNumber;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                if (!Character.isDigit(str.charAt(i))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private final boolean isValidIFSC(String ifsc) {
        Regex regex = new Regex("^[A-Z0-9]+$");
        String upperCase = ifsc.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return regex.matches(upperCase);
    }

    public final void setCallBack(ProfileFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ProfileListener profileListener = this.listener;
        if (profileListener != null) {
            profileListener.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
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