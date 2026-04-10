package in.etuwa.app.ui.hostel.attendance.applyleave;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.attendance.LeaveTypeResponse;
import in.etuwa.app.databinding.DialogApplyHostelAttendanceBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: HostelApplyLeaveDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelApplyLeaveDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogApplyHostelAttendanceBinding _binding;
    private String dateType;

    /* JADX INFO: renamed from: hostelApplyLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelApplyLeaveViewModel;
    private ApplyLeaveCallBack listener;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: spinnerDateTypeAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerDateTypeAdapter;
    private String type;

    /* JADX INFO: compiled from: HostelApplyLeaveDialog.kt */
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
                return hostelApplyLeaveDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(HostelApplyLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        this.dateType = "";
        final HostelApplyLeaveDialog hostelApplyLeaveDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
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
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$spinnerDateTypeAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerDateTypeAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SpinnerDateTypeAdapter>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.attendance.applyleave.SpinnerDateTypeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SpinnerDateTypeAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelApplyLeaveDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SpinnerDateTypeAdapter.class), b3, function03);
            }
        });
    }

    private final HostelApplyLeaveViewModel getHostelApplyLeaveViewModel() {
        return (HostelApplyLeaveViewModel) this.hostelApplyLeaveViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogApplyHostelAttendanceBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HostelLeaveTypeSpinnerAdapter getSpinnerAdapter() {
        return (HostelLeaveTypeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpinnerDateTypeAdapter getSpinnerDateTypeAdapter() {
        return (SpinnerDateTypeAdapter) this.spinnerDateTypeAdapter.getValue();
    }

    /* JADX INFO: compiled from: HostelApplyLeaveDialog.kt */
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
        MaterialButton materialButton;
        CardView cardView;
        CardView cardView2;
        CardView cardView3;
        CardView cardView4;
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = get_binding();
        Spinner spinner = dialogApplyHostelAttendanceBinding != null ? dialogApplyHostelAttendanceBinding.spinnerLeaveType : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding2 = get_binding();
        Spinner spinner2 = dialogApplyHostelAttendanceBinding2 != null ? dialogApplyHostelAttendanceBinding2.spinnerDateType : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerDateTypeAdapter());
        }
        getSpinnerDateTypeAdapter().addItems(CollectionsKt.arrayListOf("Select Date Type", "Date and Time", "Date Only"));
        Calendar calendar = Calendar.getInstance();
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        listenResponse();
        listenSpinner();
        getHostelApplyLeaveViewModel().getHostelLeaveType();
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding3 = get_binding();
        Spinner spinner3 = dialogApplyHostelAttendanceBinding3 != null ? dialogApplyHostelAttendanceBinding3.spinnerLeaveType : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    HostelApplyLeaveDialog hostelApplyLeaveDialog = HostelApplyLeaveDialog.this;
                    hostelApplyLeaveDialog.type = String.valueOf(hostelApplyLeaveDialog.getSpinnerAdapter().getType(position).getId());
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding4 = get_binding();
        Spinner spinner4 = dialogApplyHostelAttendanceBinding4 != null ? dialogApplyHostelAttendanceBinding4.spinnerDateType : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CardView cardView5;
                    HostelApplyLeaveDialog hostelApplyLeaveDialog = HostelApplyLeaveDialog.this;
                    hostelApplyLeaveDialog.dateType = hostelApplyLeaveDialog.getSpinnerDateTypeAdapter().getType(position);
                    if (Intrinsics.areEqual(HostelApplyLeaveDialog.this.dateType, "Select Date Type")) {
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding5 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView6 = dialogApplyHostelAttendanceBinding5 != null ? dialogApplyHostelAttendanceBinding5.ltEndDateTime : null;
                        if (cardView6 != null) {
                            cardView6.setVisibility(8);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding6 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView7 = dialogApplyHostelAttendanceBinding6 != null ? dialogApplyHostelAttendanceBinding6.ltFromDateTime : null;
                        if (cardView7 != null) {
                            cardView7.setVisibility(8);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding7 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView8 = dialogApplyHostelAttendanceBinding7 != null ? dialogApplyHostelAttendanceBinding7.ltEndDate : null;
                        if (cardView8 != null) {
                            cardView8.setVisibility(8);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding8 = HostelApplyLeaveDialog.this.get_binding();
                        cardView5 = dialogApplyHostelAttendanceBinding8 != null ? dialogApplyHostelAttendanceBinding8.ltFromDate : null;
                        if (cardView5 == null) {
                            return;
                        }
                        cardView5.setVisibility(8);
                        return;
                    }
                    if (Intrinsics.areEqual(HostelApplyLeaveDialog.this.dateType, "Date and Time")) {
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding9 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView9 = dialogApplyHostelAttendanceBinding9 != null ? dialogApplyHostelAttendanceBinding9.ltEndDateTime : null;
                        if (cardView9 != null) {
                            cardView9.setVisibility(0);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding10 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView10 = dialogApplyHostelAttendanceBinding10 != null ? dialogApplyHostelAttendanceBinding10.ltFromDateTime : null;
                        if (cardView10 != null) {
                            cardView10.setVisibility(0);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding11 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView11 = dialogApplyHostelAttendanceBinding11 != null ? dialogApplyHostelAttendanceBinding11.ltEndDate : null;
                        if (cardView11 != null) {
                            cardView11.setVisibility(8);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding12 = HostelApplyLeaveDialog.this.get_binding();
                        cardView5 = dialogApplyHostelAttendanceBinding12 != null ? dialogApplyHostelAttendanceBinding12.ltFromDate : null;
                        if (cardView5 == null) {
                            return;
                        }
                        cardView5.setVisibility(8);
                        return;
                    }
                    if (Intrinsics.areEqual(HostelApplyLeaveDialog.this.dateType, "Date Only")) {
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding13 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView12 = dialogApplyHostelAttendanceBinding13 != null ? dialogApplyHostelAttendanceBinding13.ltEndDate : null;
                        if (cardView12 != null) {
                            cardView12.setVisibility(0);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding14 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView13 = dialogApplyHostelAttendanceBinding14 != null ? dialogApplyHostelAttendanceBinding14.ltFromDate : null;
                        if (cardView13 != null) {
                            cardView13.setVisibility(0);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding15 = HostelApplyLeaveDialog.this.get_binding();
                        CardView cardView14 = dialogApplyHostelAttendanceBinding15 != null ? dialogApplyHostelAttendanceBinding15.ltEndDateTime : null;
                        if (cardView14 != null) {
                            cardView14.setVisibility(8);
                        }
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding16 = HostelApplyLeaveDialog.this.get_binding();
                        cardView5 = dialogApplyHostelAttendanceBinding16 != null ? dialogApplyHostelAttendanceBinding16.ltFromDateTime : null;
                        if (cardView5 == null) {
                            return;
                        }
                        cardView5.setVisibility(8);
                    }
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding5 = get_binding();
        if (dialogApplyHostelAttendanceBinding5 != null && (cardView4 = dialogApplyHostelAttendanceBinding5.ltFromDate) != null) {
            cardView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding6 = get_binding();
        if (dialogApplyHostelAttendanceBinding6 != null && (cardView3 = dialogApplyHostelAttendanceBinding6.ltEndDate) != null) {
            cardView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding7 = get_binding();
        if (dialogApplyHostelAttendanceBinding7 != null && (cardView2 = dialogApplyHostelAttendanceBinding7.ltFromDateTime) != null) {
            cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$6(this.f$0, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding8 = get_binding();
        if (dialogApplyHostelAttendanceBinding8 != null && (cardView = dialogApplyHostelAttendanceBinding8.ltEndDateTime) != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelApplyLeaveDialog.setUp$lambda$9(this.f$0, view);
                }
            });
        }
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding9 = get_binding();
        if (dialogApplyHostelAttendanceBinding9 == null || (materialButton = dialogApplyHostelAttendanceBinding9.saveBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelApplyLeaveDialog.setUp$lambda$10(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final HostelApplyLeaveDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda6
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                HostelApplyLeaveDialog.setUp$lambda$1$lambda$0(this.f$0, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(HostelApplyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding == null || (textView = dialogApplyHostelAttendanceBinding.etFromDate) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(final HostelApplyLeaveDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                HostelApplyLeaveDialog.setUp$lambda$3$lambda$2(this.f$0, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
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
    public static final void setUp$lambda$6(final HostelApplyLeaveDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        final int i4 = calendar.get(11);
        final int i5 = calendar.get(12);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda2
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i6, int i7, int i8) {
                HostelApplyLeaveDialog.setUp$lambda$6$lambda$5(this.f$0, i4, i5, datePicker, i6, i7, i8);
            }
        }, i, i2, i3);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6$lambda$5(final HostelApplyLeaveDialog this$0, int i, int i2, DatePicker datePicker, final int i3, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new TimePickerDialog(this$0.requireContext(), new TimePickerDialog.OnTimeSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda5
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i6, int i7) {
                HostelApplyLeaveDialog.setUp$lambda$6$lambda$5$lambda$4(this.f$0, i3, i4, i5, timePicker, i6, i7);
            }
        }, i, i2, true).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6$lambda$5$lambda$4(HostelApplyLeaveDialog this$0, int i, int i2, int i3, TimePicker timePicker, int i4, int i5) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding == null || (textView = dialogApplyHostelAttendanceBinding.etFromDateTime) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3 + HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR + i4 + ":" + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(final HostelApplyLeaveDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        final int i4 = calendar.get(11);
        final int i5 = calendar.get(12);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda3
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i6, int i7, int i8) {
                HostelApplyLeaveDialog.setUp$lambda$9$lambda$8(this.f$0, i4, i5, datePicker, i6, i7, i8);
            }
        }, i, i2, i3);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9$lambda$8(final HostelApplyLeaveDialog this$0, int i, int i2, DatePicker datePicker, final int i3, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new TimePickerDialog(this$0.requireContext(), new TimePickerDialog.OnTimeSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$$ExternalSyntheticLambda4
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i6, int i7) {
                HostelApplyLeaveDialog.setUp$lambda$9$lambda$8$lambda$7(this.f$0, i3, i4, i5, timePicker, i6, i7);
            }
        }, i, i2, true).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9$lambda$8$lambda$7(HostelApplyLeaveDialog this$0, int i, int i2, int i3, TimePicker timePicker, int i4, int i5) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        if (dialogApplyHostelAttendanceBinding == null || (textView = dialogApplyHostelAttendanceBinding.etEndDateTime) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3 + HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR + i4 + ":" + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(HostelApplyLeaveDialog this$0, View view) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        Date date;
        MaterialButton materialButton3;
        MaterialButton materialButton4;
        TextView textView;
        TextView textView2;
        MaterialButton materialButton5;
        MaterialButton materialButton6;
        Date date2;
        Date date3;
        MaterialButton materialButton7;
        MaterialButton materialButton8;
        TextView textView3;
        TextView textView4;
        MaterialButton materialButton9;
        MaterialButton materialButton10;
        Spinner spinner;
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = this$0.get_binding();
        Date date4 = null;
        String string = StringsKt.trim((CharSequence) String.valueOf((dialogApplyHostelAttendanceBinding == null || (textInputEditText = dialogApplyHostelAttendanceBinding.etReason) == null) ? null : textInputEditText.getText())).toString();
        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding2 = this$0.get_binding();
        Integer numValueOf = (dialogApplyHostelAttendanceBinding2 == null || (spinner = dialogApplyHostelAttendanceBinding2.spinnerDateType) == null) ? null : Integer.valueOf(spinner.getSelectedItemPosition());
        if (string.length() == 0) {
            DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding3 = this$0.get_binding();
            if (dialogApplyHostelAttendanceBinding3 == null || (materialButton10 = dialogApplyHostelAttendanceBinding3.saveBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(materialButton10, "Reason cannot be empty..!!");
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 0) {
            DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding4 = this$0.get_binding();
            if (dialogApplyHostelAttendanceBinding4 == null || (materialButton9 = dialogApplyHostelAttendanceBinding4.saveBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(materialButton9, "Please select date type..!!");
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding5 = this$0.get_binding();
            String strValueOf = String.valueOf((dialogApplyHostelAttendanceBinding5 == null || (textView4 = dialogApplyHostelAttendanceBinding5.etFromDate) == null) ? null : textView4.getText());
            DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding6 = this$0.get_binding();
            String strValueOf2 = String.valueOf((dialogApplyHostelAttendanceBinding6 == null || (textView3 = dialogApplyHostelAttendanceBinding6.etEndDate) == null) ? null : textView3.getText());
            if ((strValueOf.length() == 0) || Intrinsics.areEqual(strValueOf, "From Date")) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding7 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding7 == null || (materialButton5 = dialogApplyHostelAttendanceBinding7.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton5, "Please choose from date..!!");
                return;
            }
            if ((strValueOf2.length() == 0) || Intrinsics.areEqual(strValueOf2, "To Date")) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding8 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding8 == null || (materialButton6 = dialogApplyHostelAttendanceBinding8.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton6, "Please choose to date..!!");
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            try {
                date2 = simpleDateFormat.parse(strValueOf);
            } catch (Exception unused) {
                date2 = null;
            }
            try {
                date3 = simpleDateFormat.parse(strValueOf2);
            } catch (Exception unused2) {
                date3 = null;
            }
            if (date2 == null || date3 == null) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding9 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding9 == null || (materialButton7 = dialogApplyHostelAttendanceBinding9.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton7, "Invalid date format..!!");
                return;
            }
            if (date3.before(date2)) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding10 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding10 == null || (materialButton8 = dialogApplyHostelAttendanceBinding10.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton8, "To date can't be earlier than From date..!!");
                return;
            }
            this$0.getHostelApplyLeaveViewModel().applyHostelLeave(this$0.type, strValueOf, strValueOf2, string);
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding11 = this$0.get_binding();
            String strValueOf3 = String.valueOf((dialogApplyHostelAttendanceBinding11 == null || (textView2 = dialogApplyHostelAttendanceBinding11.etFromDateTime) == null) ? null : textView2.getText());
            DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding12 = this$0.get_binding();
            String strValueOf4 = String.valueOf((dialogApplyHostelAttendanceBinding12 == null || (textView = dialogApplyHostelAttendanceBinding12.etEndDateTime) == null) ? null : textView.getText());
            if ((strValueOf3.length() == 0) || Intrinsics.areEqual(strValueOf3, "From Date & Time")) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding13 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding13 == null || (materialButton = dialogApplyHostelAttendanceBinding13.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton, "Please choose from date & time..!!");
                return;
            }
            if ((strValueOf4.length() == 0) || Intrinsics.areEqual(strValueOf4, "To Date & Time")) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding14 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding14 == null || (materialButton2 = dialogApplyHostelAttendanceBinding14.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton2, "Please choose to date & time..!!");
                return;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            try {
                date = simpleDateFormat2.parse(strValueOf3);
            } catch (Exception unused3) {
                date = null;
            }
            try {
                date4 = simpleDateFormat2.parse(strValueOf4);
            } catch (Exception unused4) {
            }
            if (date == null || date4 == null) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding15 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding15 == null || (materialButton3 = dialogApplyHostelAttendanceBinding15.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton3, "Invalid date & time format..!!");
                return;
            }
            if (date4.before(date)) {
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding16 = this$0.get_binding();
                if (dialogApplyHostelAttendanceBinding16 == null || (materialButton4 = dialogApplyHostelAttendanceBinding16.saveBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(materialButton4, "To date & time can't be earlier than From date & time..!!");
                return;
            }
            this$0.getHostelApplyLeaveViewModel().applyHostelLeave(this$0.type, strValueOf3, strValueOf4, string);
        }
        this$0.getSpinnerAdapter().notifyDataSetChanged();
        this$0.listenSpinner();
    }

    private final void listenResponse() {
        getHostelApplyLeaveViewModel().getApplyResponse().observe(getViewLifecycleOwner(), new HostelApplyLeaveDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: HostelApplyLeaveDialog.kt */
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
                MaterialButton saveBtn;
                MaterialButton saveBtn2;
                MaterialButton materialButton;
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
                    DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = HostelApplyLeaveDialog.this.get_binding();
                    if (dialogApplyHostelAttendanceBinding == null || (materialButton = dialogApplyHostelAttendanceBinding.saveBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(materialButton, message);
                    return;
                }
                HostelApplyLeaveDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    HostelApplyLeaveDialog hostelApplyLeaveDialog = HostelApplyLeaveDialog.this;
                    if (data.getSuccess()) {
                        DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding2 = hostelApplyLeaveDialog.get_binding();
                        if (dialogApplyHostelAttendanceBinding2 != null && (saveBtn2 = dialogApplyHostelAttendanceBinding2.saveBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(saveBtn2, "saveBtn");
                            ToastExtKt.showSuccessToast(saveBtn2, data.getMessage());
                        }
                        ApplyLeaveCallBack applyLeaveCallBack = hostelApplyLeaveDialog.listener;
                        if (applyLeaveCallBack != null) {
                            applyLeaveCallBack.onDismiss();
                        }
                        hostelApplyLeaveDialog.dismiss();
                        return;
                    }
                    DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding3 = hostelApplyLeaveDialog.get_binding();
                    if (dialogApplyHostelAttendanceBinding3 == null || (saveBtn = dialogApplyHostelAttendanceBinding3.saveBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(saveBtn, "saveBtn");
                    ToastExtKt.showSuccessToast(saveBtn, data.getError());
                }
            }
        }));
    }

    private final void listenSpinner() {
        getHostelApplyLeaveViewModel().getTypeResponse().observe(getViewLifecycleOwner(), new HostelApplyLeaveDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends LeaveTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog.listenSpinner.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog$listenSpinner$1$WhenMappings */
            /* JADX INFO: compiled from: HostelApplyLeaveDialog.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<LeaveTypeResponse> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    HostelApplyLeaveDialog.this.hideProgress();
                    LeaveTypeResponse data = resource.getData();
                    if (data != null) {
                        HostelApplyLeaveDialog.this.getSpinnerAdapter().addItems(data.getData());
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
                DialogApplyHostelAttendanceBinding dialogApplyHostelAttendanceBinding = HostelApplyLeaveDialog.this.get_binding();
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