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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
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

/* JADX INFO: compiled from: BankDetailsDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class BankDetailsDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogBankDetailsBinding _binding;
    private String abcId;
    private String addEdit;

    /* JADX INFO: renamed from: bankDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy bankDetailsViewModel;
    private boolean flag;
    private String instruction;
    private ProfileListener listener;
    private MainCallBackListener listener2;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String url;
    private String video;

    /* JADX INFO: compiled from: BankDetailsDialog.kt */
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
                return bankDetailsDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(BankDetailsViewModel.class), qualifier, b, null, koinScope);
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
    /* JADX INFO: renamed from: getBinding, reason: from getter */
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

    /* JADX INFO: compiled from: BankDetailsDialog.kt */
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
                BankDetailsDialog.setUp$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(final BankDetailsDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        MaterialButton materialButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.flag) {
            this$0.flag = true;
            DialogBankDetailsBinding dialogBankDetailsBinding = this$0.get_binding();
            LinearLayout linearLayout = dialogBankDetailsBinding != null ? dialogBankDetailsBinding.updateLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            ContextCompat.getDrawable(this$0.requireContext(), R.drawable.baseline_close_24);
            DialogBankDetailsBinding dialogBankDetailsBinding2 = this$0.get_binding();
            TextView textView4 = dialogBankDetailsBinding2 != null ? dialogBankDetailsBinding2.name : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding3 = this$0.get_binding();
            TextView textView5 = dialogBankDetailsBinding3 != null ? dialogBankDetailsBinding3.accNo : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding4 = this$0.get_binding();
            TextView textView6 = dialogBankDetailsBinding4 != null ? dialogBankDetailsBinding4.ifsc : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding5 = this$0.get_binding();
            TextView textView7 = dialogBankDetailsBinding5 != null ? dialogBankDetailsBinding5.branch : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding6 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogBankDetailsBinding6 != null ? dialogBankDetailsBinding6.retypeAccLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding7 = this$0.get_binding();
            TextInputEditText textInputEditText = dialogBankDetailsBinding7 != null ? dialogBankDetailsBinding7.nameEt : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding8 = this$0.get_binding();
            TextInputEditText textInputEditText2 = dialogBankDetailsBinding8 != null ? dialogBankDetailsBinding8.accNoEt : null;
            if (textInputEditText2 != null) {
                textInputEditText2.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding9 = this$0.get_binding();
            TextInputEditText textInputEditText3 = dialogBankDetailsBinding9 != null ? dialogBankDetailsBinding9.ifscEt : null;
            if (textInputEditText3 != null) {
                textInputEditText3.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding10 = this$0.get_binding();
            TextInputEditText textInputEditText4 = dialogBankDetailsBinding10 != null ? dialogBankDetailsBinding10.branchEt : null;
            if (textInputEditText4 != null) {
                textInputEditText4.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding11 = this$0.get_binding();
            View view2 = dialogBankDetailsBinding11 != null ? dialogBankDetailsBinding11.view1 : null;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding12 = this$0.get_binding();
            View view3 = dialogBankDetailsBinding12 != null ? dialogBankDetailsBinding12.view2 : null;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding13 = this$0.get_binding();
            View view4 = dialogBankDetailsBinding13 != null ? dialogBankDetailsBinding13.view4 : null;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding14 = this$0.get_binding();
            TextView textView8 = dialogBankDetailsBinding14 != null ? dialogBankDetailsBinding14.bankNameTv : null;
            if (textView8 != null) {
                textView8.setText(this$0.setLastDigitRed("Bank Name *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding15 = this$0.get_binding();
            TextView textView9 = dialogBankDetailsBinding15 != null ? dialogBankDetailsBinding15.accNoTv : null;
            if (textView9 != null) {
                textView9.setText(this$0.setLastDigitRed("Account Number *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding16 = this$0.get_binding();
            TextView textView10 = dialogBankDetailsBinding16 != null ? dialogBankDetailsBinding16.branchNameTv : null;
            if (textView10 != null) {
                textView10.setText(this$0.setLastDigitRed("Branch *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding17 = this$0.get_binding();
            TextView textView11 = dialogBankDetailsBinding17 != null ? dialogBankDetailsBinding17.ifscTv : null;
            if (textView11 != null) {
                textView11.setText(this$0.setLastDigitRed("IFSC *"));
            }
            DialogBankDetailsBinding dialogBankDetailsBinding18 = this$0.get_binding();
            textView2 = dialogBankDetailsBinding18 != null ? dialogBankDetailsBinding18.retypeAccNoTv : null;
            if (textView2 != null) {
                textView2.setText(this$0.setLastDigitRed("Re-Type Account Number *"));
            }
        } else {
            this$0.flag = false;
            DialogBankDetailsBinding dialogBankDetailsBinding19 = this$0.get_binding();
            LinearLayout linearLayout3 = dialogBankDetailsBinding19 != null ? dialogBankDetailsBinding19.updateLyt : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            if (Intrinsics.areEqual(this$0.addEdit, "Edit")) {
                Drawable drawable = ContextCompat.getDrawable(this$0.requireContext(), R.drawable.ic_edit);
                DialogBankDetailsBinding dialogBankDetailsBinding20 = this$0.get_binding();
                if (dialogBankDetailsBinding20 != null && (textView3 = dialogBankDetailsBinding20.editBtn) != null) {
                    textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else {
                Drawable drawable2 = ContextCompat.getDrawable(this$0.requireContext(), R.drawable.baseline_add_white);
                DialogBankDetailsBinding dialogBankDetailsBinding21 = this$0.get_binding();
                if (dialogBankDetailsBinding21 != null && (textView = dialogBankDetailsBinding21.editBtn) != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
            DialogBankDetailsBinding dialogBankDetailsBinding22 = this$0.get_binding();
            TextView textView12 = dialogBankDetailsBinding22 != null ? dialogBankDetailsBinding22.name : null;
            if (textView12 != null) {
                textView12.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding23 = this$0.get_binding();
            TextView textView13 = dialogBankDetailsBinding23 != null ? dialogBankDetailsBinding23.accNo : null;
            if (textView13 != null) {
                textView13.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding24 = this$0.get_binding();
            TextView textView14 = dialogBankDetailsBinding24 != null ? dialogBankDetailsBinding24.ifsc : null;
            if (textView14 != null) {
                textView14.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding25 = this$0.get_binding();
            TextView textView15 = dialogBankDetailsBinding25 != null ? dialogBankDetailsBinding25.branch : null;
            if (textView15 != null) {
                textView15.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding26 = this$0.get_binding();
            LinearLayout linearLayout4 = dialogBankDetailsBinding26 != null ? dialogBankDetailsBinding26.retypeAccLyt : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding27 = this$0.get_binding();
            TextInputEditText textInputEditText5 = dialogBankDetailsBinding27 != null ? dialogBankDetailsBinding27.nameEt : null;
            if (textInputEditText5 != null) {
                textInputEditText5.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding28 = this$0.get_binding();
            TextInputEditText textInputEditText6 = dialogBankDetailsBinding28 != null ? dialogBankDetailsBinding28.accNoEt : null;
            if (textInputEditText6 != null) {
                textInputEditText6.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding29 = this$0.get_binding();
            TextInputEditText textInputEditText7 = dialogBankDetailsBinding29 != null ? dialogBankDetailsBinding29.ifscEt : null;
            if (textInputEditText7 != null) {
                textInputEditText7.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding30 = this$0.get_binding();
            TextInputEditText textInputEditText8 = dialogBankDetailsBinding30 != null ? dialogBankDetailsBinding30.branchEt : null;
            if (textInputEditText8 != null) {
                textInputEditText8.setVisibility(8);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding31 = this$0.get_binding();
            View view5 = dialogBankDetailsBinding31 != null ? dialogBankDetailsBinding31.view1 : null;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding32 = this$0.get_binding();
            View view6 = dialogBankDetailsBinding32 != null ? dialogBankDetailsBinding32.view2 : null;
            if (view6 != null) {
                view6.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding33 = this$0.get_binding();
            View view7 = dialogBankDetailsBinding33 != null ? dialogBankDetailsBinding33.view4 : null;
            if (view7 != null) {
                view7.setVisibility(0);
            }
            DialogBankDetailsBinding dialogBankDetailsBinding34 = this$0.get_binding();
            TextView textView16 = dialogBankDetailsBinding34 != null ? dialogBankDetailsBinding34.bankNameTv : null;
            if (textView16 != null) {
                textView16.setText("Bank Name");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding35 = this$0.get_binding();
            TextView textView17 = dialogBankDetailsBinding35 != null ? dialogBankDetailsBinding35.accNoTv : null;
            if (textView17 != null) {
                textView17.setText("Account Number");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding36 = this$0.get_binding();
            TextView textView18 = dialogBankDetailsBinding36 != null ? dialogBankDetailsBinding36.branchNameTv : null;
            if (textView18 != null) {
                textView18.setText("Branch");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding37 = this$0.get_binding();
            TextView textView19 = dialogBankDetailsBinding37 != null ? dialogBankDetailsBinding37.ifscTv : null;
            if (textView19 != null) {
                textView19.setText("IFSC");
            }
            DialogBankDetailsBinding dialogBankDetailsBinding38 = this$0.get_binding();
            textView2 = dialogBankDetailsBinding38 != null ? dialogBankDetailsBinding38.retypeAccNoTv : null;
            if (textView2 != null) {
                textView2.setText(this$0.setLastDigitRed("Re-Type Account Number *"));
            }
        }
        DialogBankDetailsBinding dialogBankDetailsBinding39 = this$0.get_binding();
        if (dialogBankDetailsBinding39 == null || (materialButton = dialogBankDetailsBinding39.updateBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                BankDetailsDialog.setUp$lambda$2$lambda$1(this.f$0, view8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2$lambda$1(BankDetailsDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        TextInputEditText textInputEditText13;
        TextInputEditText textInputEditText14;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogBankDetailsBinding dialogBankDetailsBinding = this$0.get_binding();
        Editable text = null;
        if (Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding == null || (textInputEditText14 = dialogBankDetailsBinding.nameEt) == null) ? null : textInputEditText14.getText()), "")) {
            this$0.confirmApproveView("Bank name cannot be blank");
            return;
        }
        DialogBankDetailsBinding dialogBankDetailsBinding2 = this$0.get_binding();
        if (!Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding2 == null || (textInputEditText13 = dialogBankDetailsBinding2.accNoEt) == null) ? null : textInputEditText13.getText()), "")) {
            DialogBankDetailsBinding dialogBankDetailsBinding3 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding3 == null || (textInputEditText12 = dialogBankDetailsBinding3.retypeAccNoEt) == null) ? null : textInputEditText12.getText()), "")) {
                DialogBankDetailsBinding dialogBankDetailsBinding4 = this$0.get_binding();
                if (Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding4 == null || (textInputEditText11 = dialogBankDetailsBinding4.branchEt) == null) ? null : textInputEditText11.getText()), "")) {
                    this$0.confirmApproveView("Branch name cannot be empty");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding5 = this$0.get_binding();
                if (Intrinsics.areEqual(String.valueOf((dialogBankDetailsBinding5 == null || (textInputEditText10 = dialogBankDetailsBinding5.ifscEt) == null) ? null : textInputEditText10.getText()), "")) {
                    this$0.confirmApproveView("IFSC code name cannot be empty");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding6 = this$0.get_binding();
                if (!this$0.isValidIndianBankAccount(String.valueOf((dialogBankDetailsBinding6 == null || (textInputEditText9 = dialogBankDetailsBinding6.accNoEt) == null) ? null : textInputEditText9.getText()))) {
                    this$0.confirmApproveView("Please input valid Account Number");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding7 = this$0.get_binding();
                String strValueOf = String.valueOf((dialogBankDetailsBinding7 == null || (textInputEditText8 = dialogBankDetailsBinding7.retypeAccNoEt) == null) ? null : textInputEditText8.getText());
                DialogBankDetailsBinding dialogBankDetailsBinding8 = this$0.get_binding();
                if (!Intrinsics.areEqual(strValueOf, String.valueOf((dialogBankDetailsBinding8 == null || (textInputEditText7 = dialogBankDetailsBinding8.accNoEt) == null) ? null : textInputEditText7.getText()))) {
                    this$0.confirmApproveView("Account number mismatch");
                    return;
                }
                DialogBankDetailsBinding dialogBankDetailsBinding9 = this$0.get_binding();
                if (!this$0.isValidIFSC(String.valueOf((dialogBankDetailsBinding9 == null || (textInputEditText6 = dialogBankDetailsBinding9.ifscEt) == null) ? null : textInputEditText6.getText()))) {
                    this$0.confirmApproveView("Please input valid IFSC");
                    return;
                }
                HashMap map = new HashMap();
                DialogBankDetailsBinding dialogBankDetailsBinding10 = this$0.get_binding();
                map.put("StudentDetail[bank_name]", String.valueOf((dialogBankDetailsBinding10 == null || (textInputEditText5 = dialogBankDetailsBinding10.nameEt) == null) ? null : textInputEditText5.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding11 = this$0.get_binding();
                map.put("StudentDetail[bank_accno]", String.valueOf((dialogBankDetailsBinding11 == null || (textInputEditText4 = dialogBankDetailsBinding11.accNoEt) == null) ? null : textInputEditText4.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding12 = this$0.get_binding();
                map.put("StudentDetail[bank_accno_repeat]", String.valueOf((dialogBankDetailsBinding12 == null || (textInputEditText3 = dialogBankDetailsBinding12.retypeAccNoEt) == null) ? null : textInputEditText3.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding13 = this$0.get_binding();
                map.put("StudentDetail[bank_ifsc_code]", String.valueOf((dialogBankDetailsBinding13 == null || (textInputEditText2 = dialogBankDetailsBinding13.ifscEt) == null) ? null : textInputEditText2.getText()));
                DialogBankDetailsBinding dialogBankDetailsBinding14 = this$0.get_binding();
                if (dialogBankDetailsBinding14 != null && (textInputEditText = dialogBankDetailsBinding14.branchEt) != null) {
                    text = textInputEditText.getText();
                }
                map.put("StudentDetail[bank_branch]", String.valueOf(text));
                this$0.getBankDetailsViewModel().getUpdateData(map);
                return;
            }
        }
        this$0.confirmApproveView("Account number cannot be blank");
    }

    private final void listenResponse() {
        getBankDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new BankDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ProfileResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: BankDetailsDialog.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ProfileResponse> resource) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                TextInputEditText textInputEditText;
                TextInputEditText textInputEditText2;
                TextInputEditText textInputEditText3;
                TextInputEditText textInputEditText4;
                TextInputEditText textInputEditText5;
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
                    DialogBankDetailsBinding dialogBankDetailsBinding = BankDetailsDialog.this.get_binding();
                    if (dialogBankDetailsBinding == null || (textView4 = dialogBankDetailsBinding.name) == null) {
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
                    DialogBankDetailsBinding dialogBankDetailsBinding2 = bankDetailsDialog.get_binding();
                    TextView textView5 = dialogBankDetailsBinding2 != null ? dialogBankDetailsBinding2.name : null;
                    if (textView5 != null) {
                        textView5.setText(data.getBank_name());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding3 = bankDetailsDialog.get_binding();
                    TextView textView6 = dialogBankDetailsBinding3 != null ? dialogBankDetailsBinding3.ifsc : null;
                    if (textView6 != null) {
                        textView6.setText(data.getBank_ifsc_code());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding4 = bankDetailsDialog.get_binding();
                    TextView textView7 = dialogBankDetailsBinding4 != null ? dialogBankDetailsBinding4.branch : null;
                    if (textView7 != null) {
                        textView7.setText(data.getBank_branch());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding5 = bankDetailsDialog.get_binding();
                    TextView textView8 = dialogBankDetailsBinding5 != null ? dialogBankDetailsBinding5.accNo : null;
                    if (textView8 != null) {
                        textView8.setText(data.getBank_accno());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding6 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding6 != null && (textInputEditText5 = dialogBankDetailsBinding6.nameEt) != null) {
                        textInputEditText5.setText(data.getBank_name());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding7 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding7 != null && (textInputEditText4 = dialogBankDetailsBinding7.accNoEt) != null) {
                        textInputEditText4.setText(data.getBank_accno());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding8 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding8 != null && (textInputEditText3 = dialogBankDetailsBinding8.ifscEt) != null) {
                        textInputEditText3.setText(data.getBank_ifsc_code());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding9 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding9 != null && (textInputEditText2 = dialogBankDetailsBinding9.branchEt) != null) {
                        textInputEditText2.setText(data.getBank_branch());
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding10 = bankDetailsDialog.get_binding();
                    if (dialogBankDetailsBinding10 != null && (textInputEditText = dialogBankDetailsBinding10.retypeAccNoEt) != null) {
                        textInputEditText.setText(data.getBank_accno());
                    }
                    if (Intrinsics.areEqual(data.getBank_name(), "") && Intrinsics.areEqual(data.getBank_accno(), "") && Intrinsics.areEqual(data.getBank_branch(), "") && Intrinsics.areEqual(data.getBank_ifsc_code(), "")) {
                        bankDetailsDialog.setAddEdit("Add");
                        DialogBankDetailsBinding dialogBankDetailsBinding11 = bankDetailsDialog.get_binding();
                        MaterialButton materialButton = dialogBankDetailsBinding11 != null ? dialogBankDetailsBinding11.updateBtn : null;
                        if (materialButton != null) {
                            materialButton.setText("Add");
                        }
                        Drawable drawable = ContextCompat.getDrawable(bankDetailsDialog.requireContext(), R.drawable.baseline_add_white);
                        DialogBankDetailsBinding dialogBankDetailsBinding12 = bankDetailsDialog.get_binding();
                        if (dialogBankDetailsBinding12 != null && (textView3 = dialogBankDetailsBinding12.editBtn) != null) {
                            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else {
                        bankDetailsDialog.setAddEdit("Edit");
                        Drawable drawable2 = ContextCompat.getDrawable(bankDetailsDialog.requireContext(), R.drawable.ic_edit);
                        DialogBankDetailsBinding dialogBankDetailsBinding13 = bankDetailsDialog.get_binding();
                        if (dialogBankDetailsBinding13 != null && (textView = dialogBankDetailsBinding13.editBtn) != null) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding14 = bankDetailsDialog.get_binding();
                        MaterialButton materialButton2 = dialogBankDetailsBinding14 != null ? dialogBankDetailsBinding14.updateBtn : null;
                        if (materialButton2 != null) {
                            materialButton2.setText("Update");
                        }
                    }
                    if (data.getBank_edit() || StringsKt.contains$default((CharSequence) bankDetailsDialog.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                        DialogBankDetailsBinding dialogBankDetailsBinding15 = bankDetailsDialog.get_binding();
                        textView2 = dialogBankDetailsBinding15 != null ? dialogBankDetailsBinding15.editBtn : null;
                        if (textView2 == null) {
                            return;
                        }
                        textView2.setVisibility(0);
                        return;
                    }
                    DialogBankDetailsBinding dialogBankDetailsBinding16 = bankDetailsDialog.get_binding();
                    textView2 = dialogBankDetailsBinding16 != null ? dialogBankDetailsBinding16.editBtn : null;
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setVisibility(8);
                }
            }
        }));
    }

    private final void listenUpdateResponse() {
        getBankDetailsViewModel().getUpdateResponse().observe(getViewLifecycleOwner(), new BankDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog.listenUpdateResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog$listenUpdateResponse$1$WhenMappings */
            /* JADX INFO: compiled from: BankDetailsDialog.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
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
                    DialogBankDetailsBinding dialogBankDetailsBinding = BankDetailsDialog.this.get_binding();
                    if (dialogBankDetailsBinding == null || (textView = dialogBankDetailsBinding.name) == null) {
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
                        bankDetailsDialog.getBankDetailsViewModel().getDashData();
                        DialogBankDetailsBinding dialogBankDetailsBinding2 = bankDetailsDialog.get_binding();
                        LinearLayout linearLayout = dialogBankDetailsBinding2 != null ? dialogBankDetailsBinding2.updateLyt : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding3 = bankDetailsDialog.get_binding();
                        TextView textView2 = dialogBankDetailsBinding3 != null ? dialogBankDetailsBinding3.name : null;
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding4 = bankDetailsDialog.get_binding();
                        TextView textView3 = dialogBankDetailsBinding4 != null ? dialogBankDetailsBinding4.accNo : null;
                        if (textView3 != null) {
                            textView3.setVisibility(0);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding5 = bankDetailsDialog.get_binding();
                        TextView textView4 = dialogBankDetailsBinding5 != null ? dialogBankDetailsBinding5.ifsc : null;
                        if (textView4 != null) {
                            textView4.setVisibility(0);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding6 = bankDetailsDialog.get_binding();
                        TextView textView5 = dialogBankDetailsBinding6 != null ? dialogBankDetailsBinding6.branch : null;
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding7 = bankDetailsDialog.get_binding();
                        LinearLayout linearLayout2 = dialogBankDetailsBinding7 != null ? dialogBankDetailsBinding7.retypeAccLyt : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding8 = bankDetailsDialog.get_binding();
                        TextInputEditText textInputEditText = dialogBankDetailsBinding8 != null ? dialogBankDetailsBinding8.nameEt : null;
                        if (textInputEditText != null) {
                            textInputEditText.setVisibility(8);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding9 = bankDetailsDialog.get_binding();
                        TextInputEditText textInputEditText2 = dialogBankDetailsBinding9 != null ? dialogBankDetailsBinding9.accNoEt : null;
                        if (textInputEditText2 != null) {
                            textInputEditText2.setVisibility(8);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding10 = bankDetailsDialog.get_binding();
                        TextInputEditText textInputEditText3 = dialogBankDetailsBinding10 != null ? dialogBankDetailsBinding10.ifscEt : null;
                        if (textInputEditText3 != null) {
                            textInputEditText3.setVisibility(8);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding11 = bankDetailsDialog.get_binding();
                        TextInputEditText textInputEditText4 = dialogBankDetailsBinding11 != null ? dialogBankDetailsBinding11.branchEt : null;
                        if (textInputEditText4 != null) {
                            textInputEditText4.setVisibility(8);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding12 = bankDetailsDialog.get_binding();
                        View view = dialogBankDetailsBinding12 != null ? dialogBankDetailsBinding12.view1 : null;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding13 = bankDetailsDialog.get_binding();
                        View view2 = dialogBankDetailsBinding13 != null ? dialogBankDetailsBinding13.view2 : null;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding14 = bankDetailsDialog.get_binding();
                        View view3 = dialogBankDetailsBinding14 != null ? dialogBankDetailsBinding14.view4 : null;
                        if (view3 != null) {
                            view3.setVisibility(0);
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding15 = bankDetailsDialog.get_binding();
                        TextView textView6 = dialogBankDetailsBinding15 != null ? dialogBankDetailsBinding15.bankNameTv : null;
                        if (textView6 != null) {
                            textView6.setText("Bank Name");
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding16 = bankDetailsDialog.get_binding();
                        TextView textView7 = dialogBankDetailsBinding16 != null ? dialogBankDetailsBinding16.accNoTv : null;
                        if (textView7 != null) {
                            textView7.setText("Account Number");
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding17 = bankDetailsDialog.get_binding();
                        TextView textView8 = dialogBankDetailsBinding17 != null ? dialogBankDetailsBinding17.branchNameTv : null;
                        if (textView8 != null) {
                            textView8.setText("Branch");
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding18 = bankDetailsDialog.get_binding();
                        TextView textView9 = dialogBankDetailsBinding18 != null ? dialogBankDetailsBinding18.ifscTv : null;
                        if (textView9 != null) {
                            textView9.setText("IFSC");
                        }
                        DialogBankDetailsBinding dialogBankDetailsBinding19 = bankDetailsDialog.get_binding();
                        TextView textView10 = dialogBankDetailsBinding19 != null ? dialogBankDetailsBinding19.retypeAccNoTv : null;
                        if (textView10 == null) {
                            return;
                        }
                        textView10.setText(bankDetailsDialog.setLastDigitRed("Re-Type Account Number *"));
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