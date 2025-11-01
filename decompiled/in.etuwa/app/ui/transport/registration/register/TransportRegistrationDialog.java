package in.etuwa.app.ui.transport.registration.register;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.transportpalai.registration.RegisterSucessResponse;
import in.etuwa.app.data.model.transportpalai.registration.RegisterViewResponse;
import in.etuwa.app.databinding.DialogAddTransRegBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog;
import in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.Calendar;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: TransportRegistrationDialog.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002./B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\u001a\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0019H\u0015J\b\u0010-\u001a\u00020\u0019H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/internship/apply/addcompany/AddCompanyDialog$AddCompanyListener;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddTransRegBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddTransRegBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationDialog$AddRegistrationCallBack;", "spinnerAdapter", "Lin/etuwa/app/ui/transport/registration/register/BoardingSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/transport/registration/register/BoardingSpinnerAdapter;", "spinnerAdapter$delegate", "Lkotlin/Lazy;", "transportRegistrationViewModel", "Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationViewModel;", "getTransportRegistrationViewModel", "()Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationViewModel;", "transportRegistrationViewModel$delegate", "type", "", "dismiss", "", "hideProgress", "listenResponse", "listenSpinner", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setAddRegistrationCallBack", "context", "Lin/etuwa/app/ui/transport/registration/view/TransportRegHistoryFragment;", "setUp", "showProgress", "AddRegistrationCallBack", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransportRegistrationDialog extends BaseDialog implements AddCompanyDialog.AddCompanyListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddTransRegBinding _binding;
    private AddRegistrationCallBack listener;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: transportRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy transportRegistrationViewModel;
    private String type;

    /* compiled from: TransportRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationDialog$AddRegistrationCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddRegistrationCallBack {
        void onDismiss();
    }

    @JvmStatic
    public static final TransportRegistrationDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public TransportRegistrationDialog() {
        final TransportRegistrationDialog transportRegistrationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(transportRegistrationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.transportRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(transportRegistrationDialog, Reflection.getOrCreateKotlinClass(TransportRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TransportRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        final TransportRegistrationDialog transportRegistrationDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(TransportRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<BoardingSpinnerAdapter>() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.registration.register.BoardingSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BoardingSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BoardingSpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final TransportRegistrationViewModel getTransportRegistrationViewModel() {
        return (TransportRegistrationViewModel) this.transportRegistrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddTransRegBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoardingSpinnerAdapter getSpinnerAdapter() {
        return (BoardingSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: TransportRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TransportRegistrationDialog newInstance() {
            return new TransportRegistrationDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddTransRegBinding.inflate(inflater, container, false);
        DialogAddTransRegBinding dialogAddTransRegBinding = get_binding();
        if (dialogAddTransRegBinding != null) {
            dialogAddTransRegBinding.setTransportRegistrationViewModel(getTransportRegistrationViewModel());
        }
        DialogAddTransRegBinding dialogAddTransRegBinding2 = get_binding();
        if (dialogAddTransRegBinding2 != null) {
            dialogAddTransRegBinding2.setLifecycleOwner(this);
        }
        DialogAddTransRegBinding dialogAddTransRegBinding3 = get_binding();
        if (dialogAddTransRegBinding3 != null) {
            return dialogAddTransRegBinding3.getRoot();
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
        EditText editText;
        DialogAddTransRegBinding dialogAddTransRegBinding = get_binding();
        Spinner spinner = dialogAddTransRegBinding != null ? dialogAddTransRegBinding.spinnerBoarding : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        listenResponse();
        listenSpinner();
        getTransportRegistrationViewModel().getRegHistory();
        DialogAddTransRegBinding dialogAddTransRegBinding2 = get_binding();
        Spinner spinner2 = dialogAddTransRegBinding2 != null ? dialogAddTransRegBinding2.spinnerBoarding : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    BoardingSpinnerAdapter spinnerAdapter;
                    TransportRegistrationDialog transportRegistrationDialog = TransportRegistrationDialog.this;
                    spinnerAdapter = transportRegistrationDialog.getSpinnerAdapter();
                    transportRegistrationDialog.type = String.valueOf(spinnerAdapter.getType(position).getId());
                }
            });
        }
        DialogAddTransRegBinding dialogAddTransRegBinding3 = get_binding();
        if (dialogAddTransRegBinding3 != null && (editText = dialogAddTransRegBinding3.etDate) != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportRegistrationDialog.setUp$lambda$1(TransportRegistrationDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddTransRegBinding dialogAddTransRegBinding4 = get_binding();
        if (dialogAddTransRegBinding4 != null && (textView2 = dialogAddTransRegBinding4.etDate2) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransportRegistrationDialog.setUp$lambda$3(TransportRegistrationDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddTransRegBinding dialogAddTransRegBinding5 = get_binding();
        if (dialogAddTransRegBinding5 == null || (textView = dialogAddTransRegBinding5.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransportRegistrationDialog.setUp$lambda$4(TransportRegistrationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final TransportRegistrationDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$$ExternalSyntheticLambda4
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                TransportRegistrationDialog.setUp$lambda$1$lambda$0(TransportRegistrationDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(TransportRegistrationDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogAddTransRegBinding dialogAddTransRegBinding = this$0.get_binding();
        if (dialogAddTransRegBinding == null || (editText = dialogAddTransRegBinding.etDate) == null) {
            return;
        }
        editText.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(final TransportRegistrationDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                TransportRegistrationDialog.setUp$lambda$3$lambda$2(TransportRegistrationDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3$lambda$2(TransportRegistrationDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogAddTransRegBinding dialogAddTransRegBinding = this$0.get_binding();
        if (dialogAddTransRegBinding == null || (editText = dialogAddTransRegBinding.etDate) == null) {
            return;
        }
        editText.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(TransportRegistrationDialog this$0, View view) {
        EditText editText;
        EditText editText2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogAddTransRegBinding dialogAddTransRegBinding = this$0.get_binding();
        Editable editable = null;
        if (Intrinsics.areEqual(String.valueOf((dialogAddTransRegBinding == null || (editText2 = dialogAddTransRegBinding.etDate) == null) ? null : editText2.getText()), "") || Intrinsics.areEqual(this$0.type, "")) {
            return;
        }
        TransportRegistrationViewModel transportRegistrationViewModel = this$0.getTransportRegistrationViewModel();
        String str = this$0.type;
        DialogAddTransRegBinding dialogAddTransRegBinding2 = this$0.get_binding();
        if (dialogAddTransRegBinding2 != null && (editText = dialogAddTransRegBinding2.etDate) != null) {
            editable = editText.getText();
        }
        transportRegistrationViewModel.addTransportReg(str, String.valueOf(editable));
    }

    private final void listenResponse() {
        getTransportRegistrationViewModel().getAddResponse().observe(getViewLifecycleOwner(), new TransportRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends RegisterSucessResponse>, Unit>() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$listenResponse$1

            /* compiled from: TransportRegistrationDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends RegisterSucessResponse> resource) {
                invoke2((Resource<RegisterSucessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<RegisterSucessResponse> resource) {
                DialogAddTransRegBinding dialogAddTransRegBinding;
                TextView registerBtn;
                DialogAddTransRegBinding dialogAddTransRegBinding2;
                TextView registerBtn2;
                DialogAddTransRegBinding dialogAddTransRegBinding3;
                TextView registerBtn3;
                DialogAddTransRegBinding dialogAddTransRegBinding4;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        TransportRegistrationDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        TransportRegistrationDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    TransportRegistrationDialog.this.hideProgress();
                    dialogAddTransRegBinding4 = TransportRegistrationDialog.this.get_binding();
                    if (dialogAddTransRegBinding4 == null || (textView = dialogAddTransRegBinding4.registerBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                TransportRegistrationDialog.this.hideProgress();
                RegisterSucessResponse data = resource.getData();
                if (data != null) {
                    TransportRegistrationDialog transportRegistrationDialog = TransportRegistrationDialog.this;
                    try {
                        if (data.getSuccess()) {
                            dialogAddTransRegBinding3 = transportRegistrationDialog.get_binding();
                            if (dialogAddTransRegBinding3 != null && (registerBtn3 = dialogAddTransRegBinding3.registerBtn) != null) {
                                Intrinsics.checkNotNullExpressionValue(registerBtn3, "registerBtn");
                                ToastExtKt.showSuccessToast(registerBtn3, data.getMessage());
                            }
                            transportRegistrationDialog.dismiss();
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        dialogAddTransRegBinding2 = transportRegistrationDialog.get_binding();
                        if (dialogAddTransRegBinding2 == null || (registerBtn2 = dialogAddTransRegBinding2.registerBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                        ToastExtKt.showErrorToast(registerBtn2, "Your request for transport registration is pending for approval.");
                        Unit unit2 = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        dialogAddTransRegBinding = transportRegistrationDialog.get_binding();
                        if (dialogAddTransRegBinding == null || (registerBtn = dialogAddTransRegBinding.registerBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                        ToastExtKt.showErrorToast(registerBtn, "Your request for transport registration is pending for approval.");
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenSpinner() {
        getTransportRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new TransportRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends RegisterViewResponse>, Unit>() { // from class: in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog$listenSpinner$1

            /* compiled from: TransportRegistrationDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends RegisterViewResponse> resource) {
                invoke2((Resource<RegisterViewResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<RegisterViewResponse> resource) {
                BoardingSpinnerAdapter spinnerAdapter;
                DialogAddTransRegBinding dialogAddTransRegBinding;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    TransportRegistrationDialog.this.hideProgress();
                    RegisterViewResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter = TransportRegistrationDialog.this.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getBoardings());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    TransportRegistrationDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    TransportRegistrationDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                TransportRegistrationDialog.this.hideProgress();
                dialogAddTransRegBinding = TransportRegistrationDialog.this.get_binding();
                if (dialogAddTransRegBinding == null || (textView = dialogAddTransRegBinding.registerBtn) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
        }));
    }

    public final void setAddRegistrationCallBack(TransportRegHistoryFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
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

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        AddRegistrationCallBack addRegistrationCallBack = this.listener;
        if (addRegistrationCallBack != null) {
            addRegistrationCallBack.onDismiss();
        }
    }
}