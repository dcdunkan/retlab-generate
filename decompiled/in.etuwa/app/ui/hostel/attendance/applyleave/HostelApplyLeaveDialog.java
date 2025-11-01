package in.etuwa.app.ui.hostel.attendance.applyleave;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.attendance.LeaveTypeResponse;
import in.etuwa.app.databinding.DialogApplyHostelAttendanceBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

/* compiled from: HostelApplyLeaveDialog.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020+J\b\u0010,\u001a\u00020\u0018H\u0015J\b\u0010-\u001a\u00020\u0018H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogApplyHostelAttendanceBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogApplyHostelAttendanceBinding;", "hostelApplyLeaveViewModel", "Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveViewModel;", "getHostelApplyLeaveViewModel", "()Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveViewModel;", "hostelApplyLeaveViewModel$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveDialog$ApplyLeaveCallBack;", "spinnerAdapter", "Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelLeaveTypeSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelLeaveTypeSpinnerAdapter;", "spinnerAdapter$delegate", "type", "", "dismiss", "", "hideProgress", "listenResponse", "listenSpinner", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setApplyLeaveCallBack", "context", "Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceFragment;", "Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveFragment;", "setUp", "showProgress", "ApplyLeaveCallBack", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelApplyLeaveDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogApplyHostelAttendanceBinding _binding;

    /* renamed from: hostelApplyLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelApplyLeaveViewModel;
    private ApplyLeaveCallBack listener;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String type;

    /* compiled from: HostelApplyLeaveDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveDialog$ApplyLeaveCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ApplyLeaveCallBack {
        void onDismiss();
    }

    @JvmStatic
    public static final HostelApplyLeaveDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public HostelApplyLeaveDialog() {
        final HostelApplyLeaveDialog hostelApplyLeaveDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelApplyLeaveDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelApplyLeaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelApplyLeaveDialog, Reflection.getOrCreateKotlinClass(HostelApplyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelApplyLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        final HostelApplyLeaveDialog hostelApplyLeaveDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(HostelApplyLeaveDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelLeaveTypeSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.attendance.applyleave.HostelLeaveTypeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelLeaveTypeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelApplyLeaveDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelLeaveTypeSpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final HostelApplyLeaveViewModel getHostelApplyLeaveViewModel() {
        return (HostelApplyLeaveViewModel) this.hostelApplyLeaveViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogApplyHostelAttendanceBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HostelLeaveTypeSpinnerAdapter getSpinnerAdapter() {
        return (HostelLeaveTypeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: HostelApplyLeaveDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelApplyLeaveDialog newInstance() {
            return new HostelApplyLeaveDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogApplyHostelAttendanceBinding.inflate(inflater, container, false);
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = get_binding();
        if (dialogApplyHostelAttendanceBinding != null) {
            dialogApplyHostelAttendanceBinding.setHostelApplyLeaveViewModel(getHostelApplyLeaveViewModel());
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding2 = get_binding();
        if (dialogApplyHostelAttendanceBinding2 != null) {
            dialogApplyHostelAttendanceBinding2.setLifecycleOwner(this);
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding3 = get_binding();
        if (dialogApplyHostelAttendanceBinding3 != null) {
            return dialogApplyHostelAttendanceBinding3.getRoot();
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
        CardView cardView;
        TextView textView3;
        CardView cardView2;
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = get_binding();
        Spinner spinner = dialogApplyHostelAttendanceBinding != null ? dialogApplyHostelAttendanceBinding.spinnerLeaveType : null;
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
        getHostelApplyLeaveViewModel().getHostelLeaveType();
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding2 = get_binding();
        Spinner spinner2 = dialogApplyHostelAttendanceBinding2 != null ? dialogApplyHostelAttendanceBinding2.spinnerLeaveType : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    HostelLeaveTypeSpinnerAdapter spinnerAdapter;
                    HostelApplyLeaveDialog hostelApplyLeaveDialog = HostelApplyLeaveDialog.this;
                    spinnerAdapter = hostelApplyLeaveDialog.getSpinnerAdapter();
                    hostelApplyLeaveDialog.type = String.valueOf(spinnerAdapter.getType(position).getId());
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding3 = get_binding();
        if (dialogApplyHostelAttendanceBinding3 != null && (cardView2 = dialogApplyHostelAttendanceBinding3.ltEndDate) != null) {
            cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$1(HostelApplyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding4 = get_binding();
        if (dialogApplyHostelAttendanceBinding4 != null && (textView3 = dialogApplyHostelAttendanceBinding4.etEndDate) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$3(HostelApplyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding5 = get_binding();
        if (dialogApplyHostelAttendanceBinding5 != null && (cardView = dialogApplyHostelAttendanceBinding5.ltFromDate) != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$5(HostelApplyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding6 = get_binding();
        if (dialogApplyHostelAttendanceBinding6 != null && (textView2 = dialogApplyHostelAttendanceBinding6.etFromDate) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$7(HostelApplyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding7 = get_binding();
        if (dialogApplyHostelAttendanceBinding7 == null || (textView = dialogApplyHostelAttendanceBinding7.saveBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelApplyLeaveDialog.setUp$lambda$8(HostelApplyLeaveDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final HostelApplyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda2
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                HostelApplyLeaveDialog.setUp$lambda$1$lambda$0(HostelApplyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(HostelApplyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding == null || (textView = dialogApplyHostelAttendanceBinding.etEndDate) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(final HostelApplyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda8
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                HostelApplyLeaveDialog.setUp$lambda$3$lambda$2(HostelApplyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3$lambda$2(HostelApplyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding == null || (textView = dialogApplyHostelAttendanceBinding.etEndDate) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(final HostelApplyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                HostelApplyLeaveDialog.setUp$lambda$5$lambda$4(HostelApplyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5$lambda$4(HostelApplyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding == null || (textView = dialogApplyHostelAttendanceBinding.etFromDate) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(final HostelApplyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                HostelApplyLeaveDialog.setUp$lambda$7$lambda$6(HostelApplyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7$lambda$6(HostelApplyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding == null || (textView = dialogApplyHostelAttendanceBinding.etFromDate) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(HostelApplyLeaveDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextInputEditText textInputEditText2;
        TextView textView5;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        Editable editable = null;
        Date parse = simpleDateFormat.parse(String.valueOf((dialogApplyHostelAttendanceBinding == null || (textView6 = dialogApplyHostelAttendanceBinding.etFromDate) == null) ? null : textView6.getText()));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding2 = this$0.get_binding();
        Date parse2 = simpleDateFormat2.parse(String.valueOf((dialogApplyHostelAttendanceBinding2 == null || (textView5 = dialogApplyHostelAttendanceBinding2.etEndDate) == null) ? null : textView5.getText()));
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding3 = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((dialogApplyHostelAttendanceBinding3 == null || (textInputEditText2 = dialogApplyHostelAttendanceBinding3.etReason) == null) ? null : textInputEditText2.getText()), "")) {
            return;
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding4 = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((dialogApplyHostelAttendanceBinding4 == null || (textView4 = dialogApplyHostelAttendanceBinding4.etFromDate) == null) ? null : textView4.getText()), "")) {
            return;
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding5 = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((dialogApplyHostelAttendanceBinding5 == null || (textView3 = dialogApplyHostelAttendanceBinding5.etEndDate) == null) ? null : textView3.getText()), "")) {
            return;
        }
        Intrinsics.checkNotNull(parse2);
        if (parse2.before(parse)) {
            return;
        }
        HostelApplyLeaveViewModel hostelApplyLeaveViewModel = this$0.getHostelApplyLeaveViewModel();
        String str = this$0.type;
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding6 = this$0.get_binding();
        String valueOf = String.valueOf((dialogApplyHostelAttendanceBinding6 == null || (textView2 = dialogApplyHostelAttendanceBinding6.etFromDate) == null) ? null : textView2.getText());
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding7 = this$0.get_binding();
        String valueOf2 = String.valueOf((dialogApplyHostelAttendanceBinding7 == null || (textView = dialogApplyHostelAttendanceBinding7.etEndDate) == null) ? null : textView.getText());
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding8 = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding8 != null && (textInputEditText = dialogApplyHostelAttendanceBinding8.etReason) != null) {
            editable = textInputEditText.getText();
        }
        hostelApplyLeaveViewModel.appluyHostelLeave(str, valueOf, valueOf2, String.valueOf(editable));
        this$0.getSpinnerAdapter().notifyDataSetChanged();
        this$0.listenSpinner();
    }

    private final void listenResponse() {
        getHostelApplyLeaveViewModel().getApplyResponse().observe(getViewLifecycleOwner(), new HostelApplyLeaveDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$listenResponse$1

            /* compiled from: HostelApplyLeaveDialog.kt */
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
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding;
                TextView saveBtn;
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding2;
                HostelApplyLeaveDialog.ApplyLeaveCallBack applyLeaveCallBack;
                TextView saveBtn2;
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        HostelApplyLeaveDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        HostelApplyLeaveDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    HostelApplyLeaveDialog.this.hideProgress();
                    dialogApplyHostelAttendanceBinding3 = HostelApplyLeaveDialog.this.get_binding();
                    if (dialogApplyHostelAttendanceBinding3 == null || (textView = dialogApplyHostelAttendanceBinding3.saveBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                HostelApplyLeaveDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    HostelApplyLeaveDialog hostelApplyLeaveDialog = HostelApplyLeaveDialog.this;
                    if (data.getSuccess()) {
                        dialogApplyHostelAttendanceBinding2 = hostelApplyLeaveDialog.get_binding();
                        if (dialogApplyHostelAttendanceBinding2 != null && (saveBtn2 = dialogApplyHostelAttendanceBinding2.saveBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(saveBtn2, "saveBtn");
                            ToastExtKt.showSuccessToast(saveBtn2, data.getMessage());
                        }
                        applyLeaveCallBack = hostelApplyLeaveDialog.listener;
                        if (applyLeaveCallBack != null) {
                            applyLeaveCallBack.onDismiss();
                        }
                        hostelApplyLeaveDialog.dismiss();
                        return;
                    }
                    dialogApplyHostelAttendanceBinding = hostelApplyLeaveDialog.get_binding();
                    if (dialogApplyHostelAttendanceBinding == null || (saveBtn = dialogApplyHostelAttendanceBinding.saveBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(saveBtn, "saveBtn");
                    ToastExtKt.showSuccessToast(saveBtn, data.getError());
                }
            }
        }));
    }

    private final void listenSpinner() {
        getHostelApplyLeaveViewModel().getTypeResponse().observe(getViewLifecycleOwner(), new HostelApplyLeaveDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends LeaveTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$listenSpinner$1

            /* compiled from: HostelApplyLeaveDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends LeaveTypeResponse> resource) {
                invoke2((Resource<LeaveTypeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<LeaveTypeResponse> resource) {
                HostelLeaveTypeSpinnerAdapter spinnerAdapter;
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    HostelApplyLeaveDialog.this.hideProgress();
                    LeaveTypeResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter = HostelApplyLeaveDialog.this.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getData());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    HostelApplyLeaveDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    HostelApplyLeaveDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                HostelApplyLeaveDialog.this.hideProgress();
                dialogApplyHostelAttendanceBinding = HostelApplyLeaveDialog.this.get_binding();
                if (dialogApplyHostelAttendanceBinding == null || (spinner = dialogApplyHostelAttendanceBinding.spinnerLeaveType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    public final void setApplyLeaveCallBack(HostelAttendanceFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setApplyLeaveCallBack(HostelViewLeaveFragment context) {
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
    }
}