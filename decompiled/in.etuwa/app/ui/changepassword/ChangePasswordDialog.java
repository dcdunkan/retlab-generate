package in.etuwa.app.ui.changepassword;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogChangePasswordBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.changepassword.main.LogoutChangePasswordFragment;
import in.etuwa.app.ui.profile.ProfileFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* JADX INFO: compiled from: ChangePasswordDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ChangePasswordDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogChangePasswordBinding _binding;

    /* JADX INFO: renamed from: changePasswordDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy changePasswordDialogViewModel;
    private String id;
    private RemindCounsellingListener listener;
    private MainCallBackListener listener2;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: compiled from: ChangePasswordDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/changepassword/ChangePasswordDialog$RemindCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RemindCounsellingListener {
        void dismiss();
    }

    @JvmStatic
    public static final ChangePasswordDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ChangePasswordDialog() {
        final ChangePasswordDialog changePasswordDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return changePasswordDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(changePasswordDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.changePasswordDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(changePasswordDialog, Reflection.getOrCreateKotlinClass(ChangePasswordViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ChangePasswordViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ChangePasswordDialog changePasswordDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = changePasswordDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final ChangePasswordViewModel getChangePasswordDialogViewModel() {
        return (ChangePasswordViewModel) this.changePasswordDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogChangePasswordBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: ChangePasswordDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/changepassword/ChangePasswordDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/changepassword/ChangePasswordDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChangePasswordDialog newInstance() {
            return new ChangePasswordDialog();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogChangePasswordBinding.inflate(inflater, container, false);
        DialogChangePasswordBinding dialogChangePasswordBinding = get_binding();
        if (dialogChangePasswordBinding != null) {
            dialogChangePasswordBinding.setChangePasswordDialogViewModel(getChangePasswordDialogViewModel());
        }
        DialogChangePasswordBinding dialogChangePasswordBinding2 = get_binding();
        if (dialogChangePasswordBinding2 != null) {
            dialogChangePasswordBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogChangePasswordBinding dialogChangePasswordBinding3 = get_binding();
        if (dialogChangePasswordBinding3 != null) {
            return dialogChangePasswordBinding3.getRoot();
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
        MaterialButton materialButton;
        listenChangePasswordResponse();
        getPreference().setNewLogin(false);
        DialogChangePasswordBinding dialogChangePasswordBinding = get_binding();
        if (dialogChangePasswordBinding == null || (materialButton = dialogChangePasswordBinding.changePassBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangePasswordDialog.setUp$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ChangePasswordDialog this$0, View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChangePasswordViewModel changePasswordDialogViewModel = this$0.getChangePasswordDialogViewModel();
        DialogChangePasswordBinding dialogChangePasswordBinding = this$0.get_binding();
        Editable text = null;
        String strValueOf = String.valueOf((dialogChangePasswordBinding == null || (editText3 = dialogChangePasswordBinding.etCurrentPassword) == null) ? null : editText3.getText());
        DialogChangePasswordBinding dialogChangePasswordBinding2 = this$0.get_binding();
        String strValueOf2 = String.valueOf((dialogChangePasswordBinding2 == null || (editText2 = dialogChangePasswordBinding2.etNewPassword) == null) ? null : editText2.getText());
        DialogChangePasswordBinding dialogChangePasswordBinding3 = this$0.get_binding();
        if (dialogChangePasswordBinding3 != null && (editText = dialogChangePasswordBinding3.etConfirmPass) != null) {
            text = editText.getText();
        }
        changePasswordDialogViewModel.changePassword(strValueOf, strValueOf2, String.valueOf(text));
    }

    private final void listenChangePasswordResponse() {
        getChangePasswordDialogViewModel().getChangePasswordResponse().observe(getViewLifecycleOwner(), new ChangePasswordDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog.listenChangePasswordResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.changepassword.ChangePasswordDialog$listenChangePasswordResponse$1$WhenMappings */
            /* JADX INFO: compiled from: ChangePasswordDialog.kt */
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
                MaterialButton changePassBtn;
                MaterialButton changePassBtn2;
                MaterialButton materialButton;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ChangePasswordDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ChangePasswordDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ChangePasswordDialog.this.hideProgress();
                    DialogChangePasswordBinding dialogChangePasswordBinding = ChangePasswordDialog.this.get_binding();
                    if (dialogChangePasswordBinding == null || (materialButton = dialogChangePasswordBinding.changePassBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(materialButton, message);
                    return;
                }
                ChangePasswordDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    ChangePasswordDialog changePasswordDialog = ChangePasswordDialog.this;
                    if (data.getSuccess()) {
                        DialogChangePasswordBinding dialogChangePasswordBinding2 = changePasswordDialog.get_binding();
                        if (dialogChangePasswordBinding2 != null && (changePassBtn2 = dialogChangePasswordBinding2.changePassBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(changePassBtn2, "changePassBtn");
                            ToastExtKt.showInfoToast(changePassBtn2, data.getMessage());
                        }
                        changePasswordDialog.dismiss();
                        return;
                    }
                    DialogChangePasswordBinding dialogChangePasswordBinding3 = changePasswordDialog.get_binding();
                    if (dialogChangePasswordBinding3 == null || (changePassBtn = dialogChangePasswordBinding3.changePassBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(changePassBtn, "changePassBtn");
                    ToastExtKt.showErrorToast(changePassBtn, "Some error occured,Try again!!");
                }
            }
        }));
    }

    public final void setCallBack(LogoutChangePasswordFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack(ProfileFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        RemindCounsellingListener remindCounsellingListener = this.listener;
        if (remindCounsellingListener != null) {
            remindCounsellingListener.dismiss();
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