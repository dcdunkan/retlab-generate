package in.etuwa.app.ui.attendance.bydaynew.attendaceday;

import android.content.DialogInterface;
import android.os.Bundle;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.attendance.AttendanceDay;
import in.etuwa.app.data.model.attendance.AttendanceDayResponse;
import in.etuwa.app.databinding.AttendanceByDayDialogBinding;
import in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayFragment;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
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

/* compiled from: AttendanceDayDialog.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u000256B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0016J\u001a\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001d2\u0006\u0010/\u001a\u000202J\b\u00103\u001a\u00020\u001dH\u0014J\b\u00104\u001a\u00020\u001dH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/AttendanceByDayDialogBinding;", "attendanceDayDialogViewModel", "Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialogViewModel;", "getAttendanceDayDialogViewModel", "()Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialogViewModel;", "attendanceDayDialogViewModel$delegate", "Lkotlin/Lazy;", "attendances", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/attendance/AttendanceDay;", "binding", "getBinding", "()Lin/etuwa/app/databinding/AttendanceByDayDialogBinding;", SvgConstants.Attributes.PATH_DATA_REL_CURVE_TO, "", "getC", "()Z", "setC", "(Z)V", "date", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog$AttendanceDayListner;", AttendanceDayDialogKt.ARG_SEM, "hideProgress", "", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCalendarCallBack", "context", "Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewFragment;", "setCallBack", "Lin/etuwa/app/ui/attendance/bydaynew/AttendanceByDayFragment;", "setUp", "showProgress", "AttendanceDayListner", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttendanceDayDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AttendanceByDayDialogBinding _binding;

    /* renamed from: attendanceDayDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy attendanceDayDialogViewModel;
    private ArrayList<AttendanceDay> attendances;
    private boolean c;
    private String date;
    private AttendanceDayListner listener;
    private String semester;

    /* compiled from: AttendanceDayDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog$AttendanceDayListner;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AttendanceDayListner {
        void dismiss();
    }

    @JvmStatic
    public static final AttendanceDayDialog newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AttendanceDayDialog() {
        final AttendanceDayDialog attendanceDayDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(attendanceDayDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.attendanceDayDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(attendanceDayDialog, Reflection.getOrCreateKotlinClass(AttendanceDayDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AttendanceDayDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.attendances = new ArrayList<>();
        this.c = true;
    }

    private final AttendanceDayDialogViewModel getAttendanceDayDialogViewModel() {
        return (AttendanceDayDialogViewModel) this.attendanceDayDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final AttendanceByDayDialogBinding get_binding() {
        return this._binding;
    }

    public final boolean getC() {
        return this.c;
    }

    public final void setC(boolean z) {
        this.c = z;
    }

    /* compiled from: AttendanceDayDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog;", "date", "", AttendanceDayDialogKt.ARG_SEM, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AttendanceDayDialog newInstance(String date, String semester) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(semester, "semester");
            AttendanceDayDialog attendanceDayDialog = new AttendanceDayDialog();
            Bundle bundle = new Bundle();
            bundle.putString("date", date);
            bundle.putString(AttendanceDayDialogKt.ARG_SEM, semester);
            attendanceDayDialog.setArguments(bundle);
            return attendanceDayDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.date = arguments.getString("date");
            this.semester = arguments.getString(AttendanceDayDialogKt.ARG_SEM);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AttendanceByDayDialogBinding.inflate(inflater, container, false);
        AttendanceByDayDialogBinding attendanceByDayDialogBinding = get_binding();
        if (attendanceByDayDialogBinding != null) {
            attendanceByDayDialogBinding.setAttendanceDayDialogViewModel(getAttendanceDayDialogViewModel());
        }
        AttendanceByDayDialogBinding attendanceByDayDialogBinding2 = get_binding();
        if (attendanceByDayDialogBinding2 != null) {
            attendanceByDayDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AttendanceByDayDialogBinding attendanceByDayDialogBinding3 = get_binding();
        if (attendanceByDayDialogBinding3 != null) {
            return attendanceByDayDialogBinding3.getRoot();
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
        AttendanceByDayDialogBinding attendanceByDayDialogBinding = get_binding();
        TextView textView = attendanceByDayDialogBinding != null ? attendanceByDayDialogBinding.dateTitle : null;
        if (textView != null) {
            textView.setText("Date : " + this.date);
        }
        listenResponse();
        AttendanceDayDialogViewModel attendanceDayDialogViewModel = getAttendanceDayDialogViewModel();
        String str = this.semester;
        Intrinsics.checkNotNull(str);
        String str2 = this.date;
        Intrinsics.checkNotNull(str2);
        attendanceDayDialogViewModel.getAttendanceByDay(str, str2);
    }

    private final void listenResponse() {
        getAttendanceDayDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new AttendanceDayDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AttendanceDayResponse>, Unit>() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog$listenResponse$1

            /* compiled from: AttendanceDayDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AttendanceDayResponse> resource) {
                invoke2((Resource<AttendanceDayResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:106:0x0271, code lost:
            
                r3 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:251:0x0b51, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:261:0x0b84, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:271:0x0bb7, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:281:0x0bea, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:291:0x0c1d, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:301:0x0c50, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:311:0x0c83, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:321:0x0cb4, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:331:0x0ce5, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:341:0x0d16, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:351:0x0d47, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:361:0x0d78, code lost:
            
                r1 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:610:0x03cd, code lost:
            
                r2 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:617:0x03fb, code lost:
            
                r2 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:742:0x063a, code lost:
            
                r2 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:752:0x066c, code lost:
            
                r2 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:762:0x069c, code lost:
            
                r2 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:772:0x06ce, code lost:
            
                r2 = r6.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:99:0x0243, code lost:
            
                r3 = r6.get_binding();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.attendance.AttendanceDayResponse> r18) {
                /*
                    Method dump skipped, instructions count: 3896
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog$listenResponse$1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }

    public final void setCallBack(AttendanceByDayFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCalendarCallBack(AttendanceCalendarViewFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AttendanceDayListner attendanceDayListner = this.listener;
        if (attendanceDayListner != null) {
            attendanceDayListner.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}