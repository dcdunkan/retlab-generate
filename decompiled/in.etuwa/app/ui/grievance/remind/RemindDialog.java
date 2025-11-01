package in.etuwa.app.ui.grievance.remind;

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
import in.etuwa.app.databinding.RemindDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.grievance.GrievanceFragment;
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

/* compiled from: RemindDialog.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0013H\u0014J\b\u0010(\u001a\u00020\u0013H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006+"}, d2 = {"Lin/etuwa/app/ui/grievance/remind/RemindDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/RemindDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/RemindDialogBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/grievance/remind/RemindDialog$RemindGrievanceListener;", "remindDialogViewModel", "Lin/etuwa/app/ui/grievance/remind/RemindDialogViewModel;", "getRemindDialogViewModel", "()Lin/etuwa/app/ui/grievance/remind/RemindDialogViewModel;", "remindDialogViewModel$delegate", "Lkotlin/Lazy;", "hideProgress", "", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/grievance/GrievanceFragment;", "setUp", "showProgress", "Companion", "RemindGrievanceListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RemindDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private RemindDialogBinding _binding;
    private String id;
    private RemindGrievanceListener listener;

    /* renamed from: remindDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy remindDialogViewModel;

    /* compiled from: RemindDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/grievance/remind/RemindDialog$RemindGrievanceListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RemindGrievanceListener {
        void dismiss();
    }

    @JvmStatic
    public static final RemindDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public RemindDialog() {
        final RemindDialog remindDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(remindDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.remindDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(remindDialog, Reflection.getOrCreateKotlinClass(RemindDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(RemindDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final RemindDialogViewModel getRemindDialogViewModel() {
        return (RemindDialogViewModel) this.remindDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final RemindDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: RemindDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/grievance/remind/RemindDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/grievance/remind/RemindDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RemindDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            RemindDialog remindDialog = new RemindDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            remindDialog.setArguments(bundle);
            return remindDialog;
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
        this._binding = RemindDialogBinding.inflate(inflater, container, false);
        RemindDialogBinding remindDialogBinding = get_binding();
        if (remindDialogBinding != null) {
            remindDialogBinding.setRemindDialogViewModel(getRemindDialogViewModel());
        }
        RemindDialogBinding remindDialogBinding2 = get_binding();
        if (remindDialogBinding2 != null) {
            remindDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        RemindDialogBinding remindDialogBinding3 = get_binding();
        if (remindDialogBinding3 != null) {
            return remindDialogBinding3.getRoot();
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
        RemindDialogBinding remindDialogBinding = get_binding();
        if (remindDialogBinding == null || (textView = remindDialogBinding.remindBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemindDialog.setUp$lambda$1(RemindDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(RemindDialog this$0, View view) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RemindDialogViewModel remindDialogViewModel = this$0.getRemindDialogViewModel();
        String str = this$0.id;
        RemindDialogBinding remindDialogBinding = this$0.get_binding();
        remindDialogViewModel.remindGrievance(str, String.valueOf((remindDialogBinding == null || (editText = remindDialogBinding.etRemind) == null) ? null : editText.getText()));
    }

    private final void listenResponse() {
        getRemindDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new RemindDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialog$listenResponse$1

            /* compiled from: RemindDialog.kt */
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
                RemindDialogBinding remindDialogBinding;
                TextView remindBtn;
                RemindDialogBinding remindDialogBinding2;
                TextView remindBtn2;
                RemindDialogBinding remindDialogBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        RemindDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        RemindDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    RemindDialog.this.hideProgress();
                    remindDialogBinding3 = RemindDialog.this.get_binding();
                    if (remindDialogBinding3 == null || (textView = remindDialogBinding3.remindBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                RemindDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    RemindDialog remindDialog = RemindDialog.this;
                    if (data.getSuccess()) {
                        remindDialogBinding2 = remindDialog.get_binding();
                        if (remindDialogBinding2 != null && (remindBtn2 = remindDialogBinding2.remindBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(remindBtn2, "remindBtn");
                            ToastExtKt.showSuccessToast(remindBtn2, data.getMessage());
                        }
                        remindDialog.dismiss();
                        return;
                    }
                    remindDialogBinding = remindDialog.get_binding();
                    if (remindDialogBinding == null || (remindBtn = remindDialogBinding.remindBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(remindBtn, "remindBtn");
                    ToastExtKt.showSuccessToast(remindBtn, data.getError());
                }
            }
        }));
    }

    public final void setCallBack(GrievanceFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        RemindGrievanceListener remindGrievanceListener = this.listener;
        if (remindGrievanceListener != null) {
            remindGrievanceListener.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}