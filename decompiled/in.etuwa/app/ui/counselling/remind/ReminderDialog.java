package in.etuwa.app.ui.counselling.remind;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.RemindDialog2Binding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.counselling.CounsellingFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* compiled from: ReminderDialog.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0013H\u0014J\b\u0010(\u001a\u00020\u0013H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006+"}, d2 = {"Lin/etuwa/app/ui/counselling/remind/ReminderDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/RemindDialog2Binding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/RemindDialog2Binding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/counselling/remind/ReminderDialog$RemindCounsellingListener;", "reminderDialogViewModel", "Lin/etuwa/app/ui/counselling/remind/ReminderDialogViewModel;", "getReminderDialogViewModel", "()Lin/etuwa/app/ui/counselling/remind/ReminderDialogViewModel;", "reminderDialogViewModel$delegate", "Lkotlin/Lazy;", "hideProgress", "", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/counselling/CounsellingFragment;", "setUp", "showProgress", "Companion", "RemindCounsellingListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReminderDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private RemindDialog2Binding _binding;
    private String id;
    private RemindCounsellingListener listener;

    /* renamed from: reminderDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy reminderDialogViewModel;

    /* compiled from: ReminderDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/counselling/remind/ReminderDialog$RemindCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RemindCounsellingListener {
        void dismiss();
    }

    @JvmStatic
    public static final ReminderDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ReminderDialog() {
        final ReminderDialog reminderDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.counselling.remind.ReminderDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(reminderDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.reminderDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(reminderDialog, Reflection.getOrCreateKotlinClass(ReminderDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.counselling.remind.ReminderDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.counselling.remind.ReminderDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ReminderDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ReminderDialogViewModel getReminderDialogViewModel() {
        return (ReminderDialogViewModel) this.reminderDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final RemindDialog2Binding get_binding() {
        return this._binding;
    }

    /* compiled from: ReminderDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/counselling/remind/ReminderDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/counselling/remind/ReminderDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReminderDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ReminderDialog reminderDialog = new ReminderDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            reminderDialog.setArguments(bundle);
            return reminderDialog;
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
        this._binding = RemindDialog2Binding.inflate(inflater, container, false);
        RemindDialog2Binding remindDialog2Binding = get_binding();
        if (remindDialog2Binding != null) {
            remindDialog2Binding.setReminderDialogViewModel(getReminderDialogViewModel());
        }
        RemindDialog2Binding remindDialog2Binding2 = get_binding();
        if (remindDialog2Binding2 != null) {
            remindDialog2Binding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        RemindDialog2Binding remindDialog2Binding3 = get_binding();
        if (remindDialog2Binding3 != null) {
            return remindDialog2Binding3.getRoot();
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
        RemindDialog2Binding remindDialog2Binding = get_binding();
        if (remindDialog2Binding == null || (textView = remindDialog2Binding.remindBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.remind.ReminderDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReminderDialog.setUp$lambda$1(ReminderDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ReminderDialog this$0, View view) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReminderDialogViewModel reminderDialogViewModel = this$0.getReminderDialogViewModel();
        String str = this$0.id;
        RemindDialog2Binding remindDialog2Binding = this$0.get_binding();
        reminderDialogViewModel.remindCounselling(str, String.valueOf((remindDialog2Binding == null || (editText = remindDialog2Binding.etRemind) == null) ? null : editText.getText()));
    }

    private final void listenResponse() {
        getReminderDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new ReminderDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.remind.ReminderDialog$listenResponse$1

            /* compiled from: ReminderDialog.kt */
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
                RemindDialog2Binding remindDialog2Binding;
                TextView remindBtn;
                RemindDialog2Binding remindDialog2Binding2;
                TextView remindBtn2;
                RemindDialog2Binding remindDialog2Binding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ReminderDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ReminderDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ReminderDialog.this.hideProgress();
                    remindDialog2Binding3 = ReminderDialog.this.get_binding();
                    if (remindDialog2Binding3 == null || (textView = remindDialog2Binding3.remindBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ReminderDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    ReminderDialog reminderDialog = ReminderDialog.this;
                    if (data.getSuccess()) {
                        remindDialog2Binding2 = reminderDialog.get_binding();
                        if (remindDialog2Binding2 != null && (remindBtn2 = remindDialog2Binding2.remindBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(remindBtn2, "remindBtn");
                            ToastExtKt.showSuccessToast(remindBtn2, data.getMessage());
                        }
                        reminderDialog.dismiss();
                        return;
                    }
                    remindDialog2Binding = reminderDialog.get_binding();
                    if (remindDialog2Binding == null || (remindBtn = remindDialog2Binding.remindBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(remindBtn, "remindBtn");
                    ToastExtKt.showSuccessToast(remindBtn, data.getError());
                }
            }
        }));
    }

    public final void setCallBack(CounsellingFragment context) {
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
}