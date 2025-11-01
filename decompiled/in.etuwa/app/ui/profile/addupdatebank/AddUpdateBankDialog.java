package in.etuwa.app.ui.profile.addupdatebank;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.DialogAddUpdateBankBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.profile.ProfileFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.HashMap;
import kotlin.Lazy;
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

/* compiled from: AddUpdateBankDialog.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010*\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020+J\b\u0010,\u001a\u00020\u0015H\u0014J\b\u0010-\u001a\u00020\u0015H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lin/etuwa/app/ui/profile/addupdatebank/AddUpdateBankDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddUpdateBankBinding;", "addUpdateBankViewModel", "Lin/etuwa/app/ui/profile/addupdatebank/AddUpdateBankViewModel;", "getAddUpdateBankViewModel", "()Lin/etuwa/app/ui/profile/addupdatebank/AddUpdateBankViewModel;", "addUpdateBankViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddUpdateBankBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/addupdatebank/AddUpdateBankDialog$ProfileListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "hideProgress", "", "listenResponse", "listenVerifyResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/profile/ProfileFragment;", "setUp", "showProgress", "Companion", "ProfileListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddUpdateBankDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddUpdateBankBinding _binding;

    /* renamed from: addUpdateBankViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addUpdateBankViewModel;
    private String id;
    private ProfileListener listener;
    private MainCallBackListener listener2;

    /* compiled from: AddUpdateBankDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/addupdatebank/AddUpdateBankDialog$ProfileListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProfileListener {
        void dismiss();
    }

    @JvmStatic
    public static final AddUpdateBankDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddUpdateBankDialog() {
        final AddUpdateBankDialog addUpdateBankDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addUpdateBankDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addUpdateBankViewModel = FragmentViewModelLazyKt.createViewModelLazy(addUpdateBankDialog, Reflection.getOrCreateKotlinClass(AddUpdateBankViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddUpdateBankViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final AddUpdateBankViewModel getAddUpdateBankViewModel() {
        return (AddUpdateBankViewModel) this.addUpdateBankViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddUpdateBankBinding get_binding() {
        return this._binding;
    }

    /* compiled from: AddUpdateBankDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/profile/addupdatebank/AddUpdateBankDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/addupdatebank/AddUpdateBankDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddUpdateBankDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            AddUpdateBankDialog addUpdateBankDialog = new AddUpdateBankDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            addUpdateBankDialog.setArguments(bundle);
            return addUpdateBankDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddUpdateBankBinding.inflate(inflater, container, false);
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding = get_binding();
        if (dialogAddUpdateBankBinding != null) {
            dialogAddUpdateBankBinding.setAddUpdateBankViewModel(getAddUpdateBankViewModel());
        }
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding2 = get_binding();
        if (dialogAddUpdateBankBinding2 != null) {
            dialogAddUpdateBankBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding3 = get_binding();
        if (dialogAddUpdateBankBinding3 != null) {
            return dialogAddUpdateBankBinding3.getRoot();
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
        TextInputLayout textInputLayout;
        TextView textView;
        TextView textView2;
        TextView textView3;
        final HashMap hashMap = new HashMap();
        listenResponse();
        listenVerifyResponse();
        if (Intrinsics.areEqual(this.id, "false")) {
            DialogAddUpdateBankBinding dialogAddUpdateBankBinding = get_binding();
            TextView textView4 = dialogAddUpdateBankBinding != null ? dialogAddUpdateBankBinding.verifyBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(4);
            }
            DialogAddUpdateBankBinding dialogAddUpdateBankBinding2 = get_binding();
            textInputLayout = dialogAddUpdateBankBinding2 != null ? dialogAddUpdateBankBinding2.reEnterAccEt : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
        } else {
            DialogAddUpdateBankBinding dialogAddUpdateBankBinding3 = get_binding();
            if (dialogAddUpdateBankBinding3 != null && (textView = dialogAddUpdateBankBinding3.updateBtn) != null) {
                textView.setText("Add");
            }
            DialogAddUpdateBankBinding dialogAddUpdateBankBinding4 = get_binding();
            TextView textView5 = dialogAddUpdateBankBinding4 != null ? dialogAddUpdateBankBinding4.updateBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(4);
            }
            DialogAddUpdateBankBinding dialogAddUpdateBankBinding5 = get_binding();
            textInputLayout = dialogAddUpdateBankBinding5 != null ? dialogAddUpdateBankBinding5.reEnterAccEt : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(8);
            }
        }
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding6 = get_binding();
        if (dialogAddUpdateBankBinding6 != null && (textView3 = dialogAddUpdateBankBinding6.verifyBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddUpdateBankDialog.setUp$lambda$1(AddUpdateBankDialog.this, hashMap, view);
                }
            });
        }
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding7 = get_binding();
        if (dialogAddUpdateBankBinding7 == null || (textView2 = dialogAddUpdateBankBinding7.updateBtn) == null) {
            return;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddUpdateBankDialog.setUp$lambda$2(AddUpdateBankDialog.this, hashMap, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AddUpdateBankDialog this$0, HashMap studentDetail, View view) {
        TextView textView;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(studentDetail, "$studentDetail");
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding = this$0.get_binding();
        Editable editable = null;
        if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding == null || (textInputEditText8 = dialogAddUpdateBankBinding.etAccno) == null) ? null : textInputEditText8.getText()), "")) {
            DialogAddUpdateBankBinding dialogAddUpdateBankBinding2 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding2 == null || (textInputEditText7 = dialogAddUpdateBankBinding2.etBankName) == null) ? null : textInputEditText7.getText()), "")) {
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding3 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding3 == null || (textInputEditText6 = dialogAddUpdateBankBinding3.etBranchName) == null) ? null : textInputEditText6.getText()), "")) {
                    DialogAddUpdateBankBinding dialogAddUpdateBankBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding4 == null || (textInputEditText5 = dialogAddUpdateBankBinding4.etIfscCode) == null) ? null : textInputEditText5.getText()), "")) {
                        studentDetail.clear();
                        HashMap hashMap = studentDetail;
                        DialogAddUpdateBankBinding dialogAddUpdateBankBinding5 = this$0.get_binding();
                        hashMap.put("StudentDetail[bank_name_repeat]", String.valueOf((dialogAddUpdateBankBinding5 == null || (textInputEditText4 = dialogAddUpdateBankBinding5.etBankName) == null) ? null : textInputEditText4.getText()));
                        DialogAddUpdateBankBinding dialogAddUpdateBankBinding6 = this$0.get_binding();
                        hashMap.put("StudentDetail[bank_accno_repeat]", String.valueOf((dialogAddUpdateBankBinding6 == null || (textInputEditText3 = dialogAddUpdateBankBinding6.etAccno) == null) ? null : textInputEditText3.getText()));
                        DialogAddUpdateBankBinding dialogAddUpdateBankBinding7 = this$0.get_binding();
                        hashMap.put("StudentDetail[bank_branch_repeat]", String.valueOf((dialogAddUpdateBankBinding7 == null || (textInputEditText2 = dialogAddUpdateBankBinding7.etBranchName) == null) ? null : textInputEditText2.getText()));
                        DialogAddUpdateBankBinding dialogAddUpdateBankBinding8 = this$0.get_binding();
                        if (dialogAddUpdateBankBinding8 != null && (textInputEditText = dialogAddUpdateBankBinding8.etIfscCode) != null) {
                            editable = textInputEditText.getText();
                        }
                        hashMap.put("StudentDetail[bank_ifsc_code_repeat]", String.valueOf(editable));
                        this$0.getAddUpdateBankViewModel().verifyBankData(hashMap);
                        return;
                    }
                }
            }
        }
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding9 = this$0.get_binding();
        if (dialogAddUpdateBankBinding9 == null || (textView = dialogAddUpdateBankBinding9.updateBtn) == null) {
            return;
        }
        ToastExtKt.showErrorToast(textView, "Please fill all the fields!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddUpdateBankDialog this$0, HashMap studentDetail, View view) {
        TextView textView;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextView textView2;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(studentDetail, "$studentDetail");
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding = this$0.get_binding();
        Editable editable = null;
        if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding == null || (textInputEditText12 = dialogAddUpdateBankBinding.etAccno) == null) ? null : textInputEditText12.getText()), "")) {
            DialogAddUpdateBankBinding dialogAddUpdateBankBinding2 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding2 == null || (textInputEditText11 = dialogAddUpdateBankBinding2.etBankName) == null) ? null : textInputEditText11.getText()), "")) {
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding3 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding3 == null || (textInputEditText10 = dialogAddUpdateBankBinding3.etBranchName) == null) ? null : textInputEditText10.getText()), "")) {
                    DialogAddUpdateBankBinding dialogAddUpdateBankBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding4 == null || (textInputEditText9 = dialogAddUpdateBankBinding4.etConfirmAccno) == null) ? null : textInputEditText9.getText()), "")) {
                        DialogAddUpdateBankBinding dialogAddUpdateBankBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddUpdateBankBinding5 == null || (textInputEditText8 = dialogAddUpdateBankBinding5.etIfscCode) == null) ? null : textInputEditText8.getText()), "")) {
                            DialogAddUpdateBankBinding dialogAddUpdateBankBinding6 = this$0.get_binding();
                            String valueOf = String.valueOf((dialogAddUpdateBankBinding6 == null || (textInputEditText7 = dialogAddUpdateBankBinding6.etAccno) == null) ? null : textInputEditText7.getText());
                            DialogAddUpdateBankBinding dialogAddUpdateBankBinding7 = this$0.get_binding();
                            if (!Intrinsics.areEqual(valueOf, String.valueOf((dialogAddUpdateBankBinding7 == null || (textInputEditText6 = dialogAddUpdateBankBinding7.etConfirmAccno) == null) ? null : textInputEditText6.getText()))) {
                                DialogAddUpdateBankBinding dialogAddUpdateBankBinding8 = this$0.get_binding();
                                if (dialogAddUpdateBankBinding8 == null || (textView2 = dialogAddUpdateBankBinding8.updateBtn) == null) {
                                    return;
                                }
                                ToastExtKt.showErrorToast(textView2, "Account number must be repeated exactly.");
                                return;
                            }
                            studentDetail.clear();
                            HashMap hashMap = studentDetail;
                            DialogAddUpdateBankBinding dialogAddUpdateBankBinding9 = this$0.get_binding();
                            hashMap.put("StudentDetail[bank_name]", String.valueOf((dialogAddUpdateBankBinding9 == null || (textInputEditText5 = dialogAddUpdateBankBinding9.etBankName) == null) ? null : textInputEditText5.getText()));
                            DialogAddUpdateBankBinding dialogAddUpdateBankBinding10 = this$0.get_binding();
                            hashMap.put("StudentDetail[bank_accno]", String.valueOf((dialogAddUpdateBankBinding10 == null || (textInputEditText4 = dialogAddUpdateBankBinding10.etAccno) == null) ? null : textInputEditText4.getText()));
                            DialogAddUpdateBankBinding dialogAddUpdateBankBinding11 = this$0.get_binding();
                            hashMap.put("StudentDetail[bank_branch]", String.valueOf((dialogAddUpdateBankBinding11 == null || (textInputEditText3 = dialogAddUpdateBankBinding11.etBranchName) == null) ? null : textInputEditText3.getText()));
                            DialogAddUpdateBankBinding dialogAddUpdateBankBinding12 = this$0.get_binding();
                            hashMap.put("StudentDetail[bank_ifsc_code]", String.valueOf((dialogAddUpdateBankBinding12 == null || (textInputEditText2 = dialogAddUpdateBankBinding12.etIfscCode) == null) ? null : textInputEditText2.getText()));
                            DialogAddUpdateBankBinding dialogAddUpdateBankBinding13 = this$0.get_binding();
                            if (dialogAddUpdateBankBinding13 != null && (textInputEditText = dialogAddUpdateBankBinding13.etConfirmAccno) != null) {
                                editable = textInputEditText.getText();
                            }
                            hashMap.put("StudentDetail[bank_accno_repeat]", String.valueOf(editable));
                            this$0.getAddUpdateBankViewModel().updateBankData(hashMap);
                            return;
                        }
                    }
                }
            }
        }
        DialogAddUpdateBankBinding dialogAddUpdateBankBinding14 = this$0.get_binding();
        if (dialogAddUpdateBankBinding14 == null || (textView = dialogAddUpdateBankBinding14.updateBtn) == null) {
            return;
        }
        ToastExtKt.showErrorToast(textView, "Please fill all the fields!!");
    }

    private final void listenResponse() {
        getAddUpdateBankViewModel().getResponse().observe(getViewLifecycleOwner(), new AddUpdateBankDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog$listenResponse$1

            /* compiled from: AddUpdateBankDialog.kt */
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
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding;
                TextView updateBtn;
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding2;
                TextView updateBtn2;
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddUpdateBankDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddUpdateBankDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddUpdateBankDialog.this.hideProgress();
                    dialogAddUpdateBankBinding3 = AddUpdateBankDialog.this.get_binding();
                    if (dialogAddUpdateBankBinding3 == null || (textView = dialogAddUpdateBankBinding3.updateBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                AddUpdateBankDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddUpdateBankDialog addUpdateBankDialog = AddUpdateBankDialog.this;
                    if (data.getSuccess()) {
                        dialogAddUpdateBankBinding2 = addUpdateBankDialog.get_binding();
                        if (dialogAddUpdateBankBinding2 != null && (updateBtn2 = dialogAddUpdateBankBinding2.updateBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(updateBtn2, "updateBtn");
                            ToastExtKt.showInfoToast(updateBtn2, data.getMessage());
                        }
                        addUpdateBankDialog.dismiss();
                        return;
                    }
                    dialogAddUpdateBankBinding = addUpdateBankDialog.get_binding();
                    if (dialogAddUpdateBankBinding == null || (updateBtn = dialogAddUpdateBankBinding.updateBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(updateBtn, "updateBtn");
                    ToastExtKt.showErrorToast(updateBtn, "Some error occured,Try again!!");
                }
            }
        }));
    }

    private final void listenVerifyResponse() {
        getAddUpdateBankViewModel().getVerifyResponse().observe(getViewLifecycleOwner(), new AddUpdateBankDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog$listenVerifyResponse$1

            /* compiled from: AddUpdateBankDialog.kt */
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
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding;
                TextView verifyBtn;
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding2;
                TextView verifyBtn2;
                DialogAddUpdateBankBinding dialogAddUpdateBankBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddUpdateBankDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddUpdateBankDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddUpdateBankDialog.this.hideProgress();
                    dialogAddUpdateBankBinding3 = AddUpdateBankDialog.this.get_binding();
                    if (dialogAddUpdateBankBinding3 == null || (textView = dialogAddUpdateBankBinding3.verifyBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                AddUpdateBankDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddUpdateBankDialog addUpdateBankDialog = AddUpdateBankDialog.this;
                    if (data.getSuccess()) {
                        dialogAddUpdateBankBinding2 = addUpdateBankDialog.get_binding();
                        if (dialogAddUpdateBankBinding2 != null && (verifyBtn2 = dialogAddUpdateBankBinding2.verifyBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(verifyBtn2, "verifyBtn");
                            ToastExtKt.showInfoToast(verifyBtn2, data.getMessage());
                        }
                        addUpdateBankDialog.dismiss();
                        return;
                    }
                    dialogAddUpdateBankBinding = addUpdateBankDialog.get_binding();
                    if (dialogAddUpdateBankBinding == null || (verifyBtn = dialogAddUpdateBankBinding.verifyBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(verifyBtn, "verifyBtn");
                    ToastExtKt.showErrorToast(verifyBtn, "Some error occured,Try again!!");
                }
            }
        }));
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