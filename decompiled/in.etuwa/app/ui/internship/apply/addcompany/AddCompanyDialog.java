package in.etuwa.app.ui.internship.apply.addcompany;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.AddCompanyDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.internship.apply.ApplyInternship;
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

/* JADX INFO: compiled from: AddCompanyDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class AddCompanyDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AddCompanyDialogBinding _binding;

    /* JADX INFO: renamed from: addCompanyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addCompanyViewModel;
    private String id;
    private AddCompanyListener listener;

    /* JADX INFO: compiled from: AddCompanyDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/internship/apply/addcompany/AddCompanyDialog$AddCompanyListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCompanyListener {
        void dismiss();
    }

    @JvmStatic
    public static final AddCompanyDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddCompanyDialog() {
        final AddCompanyDialog addCompanyDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return addCompanyDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addCompanyDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addCompanyViewModel = FragmentViewModelLazyKt.createViewModelLazy(addCompanyDialog, Reflection.getOrCreateKotlinClass(AddCompanyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AddCompanyViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final AddCompanyViewModel getAddCompanyViewModel() {
        return (AddCompanyViewModel) this.addCompanyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final AddCompanyDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: AddCompanyDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/internship/apply/addcompany/AddCompanyDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/internship/apply/addcompany/AddCompanyDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddCompanyDialog newInstance() {
            AddCompanyDialog addCompanyDialog = new AddCompanyDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", addCompanyDialog.id);
            addCompanyDialog.setArguments(bundle);
            return addCompanyDialog;
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
        this._binding = AddCompanyDialogBinding.inflate(inflater, container, false);
        AddCompanyDialogBinding addCompanyDialogBinding = get_binding();
        if (addCompanyDialogBinding != null) {
            addCompanyDialogBinding.setAddCompanyDialogViewModel(getAddCompanyViewModel());
        }
        AddCompanyDialogBinding addCompanyDialogBinding2 = get_binding();
        if (addCompanyDialogBinding2 != null) {
            addCompanyDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AddCompanyDialogBinding addCompanyDialogBinding3 = get_binding();
        if (addCompanyDialogBinding3 != null) {
            return addCompanyDialogBinding3.getRoot();
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
        TextView textView2;
        listenResponse();
        AddCompanyDialogBinding addCompanyDialogBinding = get_binding();
        if (addCompanyDialogBinding != null && (textView2 = addCompanyDialogBinding.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddCompanyDialog.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        AddCompanyDialogBinding addCompanyDialogBinding2 = get_binding();
        if (addCompanyDialogBinding2 == null || (textView = addCompanyDialogBinding2.cancelBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCompanyDialog.setUp$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AddCompanyDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddCompanyDialogBinding addCompanyDialogBinding = this$0.get_binding();
        Editable text = null;
        if (Intrinsics.areEqual(String.valueOf((addCompanyDialogBinding == null || (textInputEditText4 = addCompanyDialogBinding.etCompanyName) == null) ? null : textInputEditText4.getText()), "")) {
            return;
        }
        AddCompanyDialogBinding addCompanyDialogBinding2 = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((addCompanyDialogBinding2 == null || (textInputEditText3 = addCompanyDialogBinding2.etCompanyAddress) == null) ? null : textInputEditText3.getText()), "")) {
            return;
        }
        AddCompanyViewModel addCompanyViewModel = this$0.getAddCompanyViewModel();
        AddCompanyDialogBinding addCompanyDialogBinding3 = this$0.get_binding();
        String strValueOf = String.valueOf((addCompanyDialogBinding3 == null || (textInputEditText2 = addCompanyDialogBinding3.etCompanyName) == null) ? null : textInputEditText2.getText());
        AddCompanyDialogBinding addCompanyDialogBinding4 = this$0.get_binding();
        if (addCompanyDialogBinding4 != null && (textInputEditText = addCompanyDialogBinding4.etCompanyAddress) != null) {
            text = textInputEditText.getText();
        }
        addCompanyViewModel.addCompany(strValueOf, String.valueOf(text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddCompanyDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ApplyInternship.INSTANCE.newInstance().show(childFragmentManager, (String) null);
        this$0.dismiss();
    }

    private final void listenResponse() {
        getAddCompanyViewModel().getResponse().observe(getViewLifecycleOwner(), new AddCompanyDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AddCompanyDialog.kt */
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
                TextView addBtn;
                TextView addBtn2;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddCompanyDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddCompanyDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddCompanyDialog.this.hideProgress();
                    AddCompanyDialogBinding addCompanyDialogBinding = AddCompanyDialog.this.get_binding();
                    if (addCompanyDialogBinding == null || (textView = addCompanyDialogBinding.addBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                AddCompanyDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddCompanyDialog addCompanyDialog = AddCompanyDialog.this;
                    if (data.getSuccess()) {
                        AddCompanyDialogBinding addCompanyDialogBinding2 = addCompanyDialog.get_binding();
                        if (addCompanyDialogBinding2 != null && (addBtn2 = addCompanyDialogBinding2.addBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                            ToastExtKt.showSuccessToast(addBtn2, data.getMessage());
                        }
                        FragmentManager childFragmentManager = addCompanyDialog.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        ApplyInternship.INSTANCE.newInstance().show(childFragmentManager, (String) null);
                        addCompanyDialog.onStop();
                        return;
                    }
                    AddCompanyDialogBinding addCompanyDialogBinding3 = addCompanyDialog.get_binding();
                    if (addCompanyDialogBinding3 == null || (addBtn = addCompanyDialogBinding3.addBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn, data.getError());
                }
            }
        }));
    }

    public final void setCallBack(ApplyInternship context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddCompanyListener addCompanyListener = this.listener;
        if (addCompanyListener != null) {
            addCompanyListener.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}