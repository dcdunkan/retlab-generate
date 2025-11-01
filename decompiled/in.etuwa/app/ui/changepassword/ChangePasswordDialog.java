package in.etuwa.app.ui.changepassword;

import android.content.ComponentCallbacks;
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

/* compiled from: ChangePasswordDialog.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u000234B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0016J\u001a\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020/J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u000200J\b\u00101\u001a\u00020\u001aH\u0014J\b\u00102\u001a\u00020\u001aH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u0017¨\u00065"}, d2 = {"Lin/etuwa/app/ui/changepassword/ChangePasswordDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogChangePasswordBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogChangePasswordBinding;", "changePasswordDialogViewModel", "Lin/etuwa/app/ui/changepassword/ChangePasswordViewModel;", "getChangePasswordDialogViewModel", "()Lin/etuwa/app/ui/changepassword/ChangePasswordViewModel;", "changePasswordDialogViewModel$delegate", "Lkotlin/Lazy;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/changepassword/ChangePasswordDialog$RemindCounsellingListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "hideProgress", "", "listenChangePasswordResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/changepassword/main/LogoutChangePasswordFragment;", "Lin/etuwa/app/ui/profile/ProfileFragment;", "setUp", "showProgress", "Companion", "RemindCounsellingListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChangePasswordDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogChangePasswordBinding _binding;

    /* renamed from: changePasswordDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy changePasswordDialogViewModel;
    private String id;
    private RemindCounsellingListener listener;
    private MainCallBackListener listener2;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: ChangePasswordDialog.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ChangePasswordViewModel.class), qualifier, b, null, koinScope);
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
    /* renamed from: getBinding, reason: from getter */
    public final DialogChangePasswordBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ChangePasswordDialog.kt */
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
        TextView textView;
        listenChangePasswordResponse();
        getPreference().setNewLogin(false);
        DialogChangePasswordBinding dialogChangePasswordBinding = get_binding();
        if (dialogChangePasswordBinding == null || (textView = dialogChangePasswordBinding.changePassBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangePasswordDialog.setUp$lambda$0(ChangePasswordDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ChangePasswordDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChangePasswordViewModel changePasswordDialogViewModel = this$0.getChangePasswordDialogViewModel();
        DialogChangePasswordBinding dialogChangePasswordBinding = this$0.get_binding();
        Editable editable = null;
        String valueOf = String.valueOf((dialogChangePasswordBinding == null || (textInputEditText3 = dialogChangePasswordBinding.etCurrentPassword) == null) ? null : textInputEditText3.getText());
        DialogChangePasswordBinding dialogChangePasswordBinding2 = this$0.get_binding();
        String valueOf2 = String.valueOf((dialogChangePasswordBinding2 == null || (textInputEditText2 = dialogChangePasswordBinding2.etNewPassword) == null) ? null : textInputEditText2.getText());
        DialogChangePasswordBinding dialogChangePasswordBinding3 = this$0.get_binding();
        if (dialogChangePasswordBinding3 != null && (textInputEditText = dialogChangePasswordBinding3.etConfirmPass) != null) {
            editable = textInputEditText.getText();
        }
        changePasswordDialogViewModel.changePassword(valueOf, valueOf2, String.valueOf(editable));
    }

    private final void listenChangePasswordResponse() {
        getChangePasswordDialogViewModel().getChangePasswordResponse().observe(getViewLifecycleOwner(), new ChangePasswordDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordDialog$listenChangePasswordResponse$1

            /* compiled from: ChangePasswordDialog.kt */
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
                DialogChangePasswordBinding dialogChangePasswordBinding;
                TextView changePassBtn;
                DialogChangePasswordBinding dialogChangePasswordBinding2;
                TextView changePassBtn2;
                DialogChangePasswordBinding dialogChangePasswordBinding3;
                TextView textView;
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
                    dialogChangePasswordBinding3 = ChangePasswordDialog.this.get_binding();
                    if (dialogChangePasswordBinding3 == null || (textView = dialogChangePasswordBinding3.changePassBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ChangePasswordDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    ChangePasswordDialog changePasswordDialog = ChangePasswordDialog.this;
                    if (data.getSuccess()) {
                        dialogChangePasswordBinding2 = changePasswordDialog.get_binding();
                        if (dialogChangePasswordBinding2 != null && (changePassBtn2 = dialogChangePasswordBinding2.changePassBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(changePassBtn2, "changePassBtn");
                            ToastExtKt.showInfoToast(changePassBtn2, data.getMessage());
                        }
                        changePasswordDialog.dismiss();
                        return;
                    }
                    dialogChangePasswordBinding = changePasswordDialog.get_binding();
                    if (dialogChangePasswordBinding == null || (changePassBtn = dialogChangePasswordBinding.changePassBtn) == null) {
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