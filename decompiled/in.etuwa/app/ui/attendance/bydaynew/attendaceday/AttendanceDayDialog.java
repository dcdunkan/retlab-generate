package in.etuwa.app.ui.attendance.bydaynew.attendaceday;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.attendance.AttendanceDay;
import in.etuwa.app.data.model.attendance.AttendanceDayResponse;
import in.etuwa.app.databinding.AttendanceByDayDialogBinding;
import in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayFragment;
import in.etuwa.app.ui.attendance.bysubject.AttendanceFragment;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: AttendanceDayDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AttendanceDayDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AttendanceByDayDialogBinding _binding;

    /* JADX INFO: renamed from: attendanceDayDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy attendanceDayDialogViewModel;
    private ArrayList<AttendanceDay> attendances;
    private boolean c;
    private String date;
    private AttendanceDayListner listener;
    private String semester;

    /* JADX INFO: compiled from: AttendanceDayDialog.kt */
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
                return attendanceDayDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AttendanceDayDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.attendances = new ArrayList<>();
        this.c = true;
    }

    private final AttendanceDayDialogViewModel getAttendanceDayDialogViewModel() {
        return (AttendanceDayDialogViewModel) this.attendanceDayDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final AttendanceByDayDialogBinding get_binding() {
        return this._binding;
    }

    public final boolean getC() {
        return this.c;
    }

    public final void setC(boolean z) {
        this.c = z;
    }

    /* JADX INFO: compiled from: AttendanceDayDialog.kt */
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
        getAttendanceDayDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new AttendanceDayDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AttendanceDayResponse>, Unit>() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AttendanceDayDialog.kt */
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

            /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.attendance.AttendanceDayResponse> r10) {
                /*
                    Method dump skipped, instruction units count: 412
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog.AnonymousClass1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindPeriod(int index, AttendanceDay att) {
        Quad quad;
        String lowerCase = null;
        switch (index) {
            case 0:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding = get_binding();
                TextView textView = attendanceByDayDialogBinding != null ? attendanceByDayDialogBinding.subjectName1 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding2 = get_binding();
                TextView textView2 = attendanceByDayDialogBinding2 != null ? attendanceByDayDialogBinding2.coverage1 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding3 = get_binding();
                TextView textView3 = attendanceByDayDialogBinding3 != null ? attendanceByDayDialogBinding3.period1 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding4 = get_binding();
                quad = new Quad(textView, textView2, textView3, attendanceByDayDialogBinding4 != null ? attendanceByDayDialogBinding4.linearcoverage1 : null);
                break;
            case 1:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding5 = get_binding();
                TextView textView4 = attendanceByDayDialogBinding5 != null ? attendanceByDayDialogBinding5.subjectName2 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding6 = get_binding();
                TextView textView5 = attendanceByDayDialogBinding6 != null ? attendanceByDayDialogBinding6.coverage2 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding7 = get_binding();
                TextView textView6 = attendanceByDayDialogBinding7 != null ? attendanceByDayDialogBinding7.period2 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding8 = get_binding();
                quad = new Quad(textView4, textView5, textView6, attendanceByDayDialogBinding8 != null ? attendanceByDayDialogBinding8.linearcoverage2 : null);
                break;
            case 2:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding9 = get_binding();
                TextView textView7 = attendanceByDayDialogBinding9 != null ? attendanceByDayDialogBinding9.subjectName3 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding10 = get_binding();
                TextView textView8 = attendanceByDayDialogBinding10 != null ? attendanceByDayDialogBinding10.coverage3 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding11 = get_binding();
                TextView textView9 = attendanceByDayDialogBinding11 != null ? attendanceByDayDialogBinding11.period3 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding12 = get_binding();
                quad = new Quad(textView7, textView8, textView9, attendanceByDayDialogBinding12 != null ? attendanceByDayDialogBinding12.linearcoverage3 : null);
                break;
            case 3:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding13 = get_binding();
                TextView textView10 = attendanceByDayDialogBinding13 != null ? attendanceByDayDialogBinding13.subjectName4 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding14 = get_binding();
                TextView textView11 = attendanceByDayDialogBinding14 != null ? attendanceByDayDialogBinding14.coverage4 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding15 = get_binding();
                TextView textView12 = attendanceByDayDialogBinding15 != null ? attendanceByDayDialogBinding15.period4 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding16 = get_binding();
                quad = new Quad(textView10, textView11, textView12, attendanceByDayDialogBinding16 != null ? attendanceByDayDialogBinding16.linearcoverage4 : null);
                break;
            case 4:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding17 = get_binding();
                TextView textView13 = attendanceByDayDialogBinding17 != null ? attendanceByDayDialogBinding17.subjectName5 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding18 = get_binding();
                TextView textView14 = attendanceByDayDialogBinding18 != null ? attendanceByDayDialogBinding18.coverage5 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding19 = get_binding();
                TextView textView15 = attendanceByDayDialogBinding19 != null ? attendanceByDayDialogBinding19.period5 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding20 = get_binding();
                quad = new Quad(textView13, textView14, textView15, attendanceByDayDialogBinding20 != null ? attendanceByDayDialogBinding20.linearcoverage5 : null);
                break;
            case 5:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding21 = get_binding();
                TextView textView16 = attendanceByDayDialogBinding21 != null ? attendanceByDayDialogBinding21.subjectName6 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding22 = get_binding();
                TextView textView17 = attendanceByDayDialogBinding22 != null ? attendanceByDayDialogBinding22.coverage6 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding23 = get_binding();
                TextView textView18 = attendanceByDayDialogBinding23 != null ? attendanceByDayDialogBinding23.period6 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding24 = get_binding();
                quad = new Quad(textView16, textView17, textView18, attendanceByDayDialogBinding24 != null ? attendanceByDayDialogBinding24.linearcoverage6 : null);
                break;
            case 6:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding25 = get_binding();
                TextView textView19 = attendanceByDayDialogBinding25 != null ? attendanceByDayDialogBinding25.subjectName7 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding26 = get_binding();
                TextView textView20 = attendanceByDayDialogBinding26 != null ? attendanceByDayDialogBinding26.coverage7 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding27 = get_binding();
                TextView textView21 = attendanceByDayDialogBinding27 != null ? attendanceByDayDialogBinding27.period7 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding28 = get_binding();
                quad = new Quad(textView19, textView20, textView21, attendanceByDayDialogBinding28 != null ? attendanceByDayDialogBinding28.linearcoverage7 : null);
                break;
            case 7:
                AttendanceByDayDialogBinding attendanceByDayDialogBinding29 = get_binding();
                TextView textView22 = attendanceByDayDialogBinding29 != null ? attendanceByDayDialogBinding29.subjectName8 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding30 = get_binding();
                TextView textView23 = attendanceByDayDialogBinding30 != null ? attendanceByDayDialogBinding30.coverage8 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding31 = get_binding();
                TextView textView24 = attendanceByDayDialogBinding31 != null ? attendanceByDayDialogBinding31.period8 : null;
                AttendanceByDayDialogBinding attendanceByDayDialogBinding32 = get_binding();
                quad = new Quad(textView22, textView23, textView24, attendanceByDayDialogBinding32 != null ? attendanceByDayDialogBinding32.linearcoverage8 : null);
                break;
            default:
                return;
        }
        TextView textView25 = (TextView) quad.component1();
        TextView textView26 = (TextView) quad.component2();
        TextView textView27 = (TextView) quad.component3();
        LinearLayout linearLayout = (LinearLayout) quad.component4();
        if (att != null) {
            String subject = att.getSubject();
            if (!(subject == null || subject.length() == 0)) {
                if (textView25 != null) {
                    textView25.setVisibility(0);
                }
                if (textView27 != null) {
                    textView27.setVisibility(0);
                }
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                if (textView25 != null) {
                    textView25.setText(att.getSubject());
                }
                String strJoinToString$default = att.getCoverage().isEmpty() ^ true ? CollectionsKt.joinToString$default(att.getCoverage(), ",", null, null, 0, null, null, 62, null) : "Coverage not yet added";
                if (textView26 != null) {
                    textView26.setText(strJoinToString$default);
                }
                String attendance = att.getAttendance();
                if (attendance != null) {
                    lowerCase = attendance.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                }
                if (Intrinsics.areEqual(lowerCase, "present")) {
                    if (textView25 != null) {
                        textView25.setBackgroundColor(Color.parseColor("#3CB371"));
                        return;
                    }
                    return;
                } else {
                    if (!Intrinsics.areEqual(lowerCase, "absent") || textView25 == null) {
                        return;
                    }
                    textView25.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
            }
        }
        if (textView25 != null) {
            textView25.setVisibility(8);
        }
        if (textView27 != null) {
            textView27.setVisibility(8);
        }
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: compiled from: AttendanceDayDialog.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005B%\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002\u0012\u0006\u0010\t\u001a\u00028\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\fJN\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u00022\b\b\u0002\u0010\t\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog$Quad;", "A", SvgConstants.Attributes.PATH_DATA_BEARING, SvgConstants.Attributes.PATH_DATA_CURVE_TO, "D", "", "first", "second", "third", "fourth", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFourth", "getSecond", "getThird", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog$Quad;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class Quad<A, B, C, D> {
        private final A first;
        private final D fourth;
        private final B second;
        private final C third;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Quad copy$default(Quad quad, Object obj, Object obj2, Object obj3, Object obj4, int i, Object obj5) {
            if ((i & 1) != 0) {
                obj = quad.first;
            }
            if ((i & 2) != 0) {
                obj2 = quad.second;
            }
            if ((i & 4) != 0) {
                obj3 = quad.third;
            }
            if ((i & 8) != 0) {
                obj4 = quad.fourth;
            }
            return quad.copy(obj, obj2, obj3, obj4);
        }

        public final A component1() {
            return this.first;
        }

        public final B component2() {
            return this.second;
        }

        public final C component3() {
            return this.third;
        }

        public final D component4() {
            return this.fourth;
        }

        public final Quad<A, B, C, D> copy(A first, B second, C third, D fourth) {
            return new Quad<>(first, second, third, fourth);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Quad)) {
                return false;
            }
            Quad quad = (Quad) other;
            return Intrinsics.areEqual(this.first, quad.first) && Intrinsics.areEqual(this.second, quad.second) && Intrinsics.areEqual(this.third, quad.third) && Intrinsics.areEqual(this.fourth, quad.fourth);
        }

        public int hashCode() {
            A a2 = this.first;
            int iHashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
            B b = this.second;
            int iHashCode2 = (iHashCode + (b == null ? 0 : b.hashCode())) * 31;
            C c = this.third;
            int iHashCode3 = (iHashCode2 + (c == null ? 0 : c.hashCode())) * 31;
            D d = this.fourth;
            return iHashCode3 + (d != null ? d.hashCode() : 0);
        }

        public String toString() {
            return "Quad(first=" + this.first + ", second=" + this.second + ", third=" + this.third + ", fourth=" + this.fourth + ")";
        }

        public Quad(A a2, B b, C c, D d) {
            this.first = a2;
            this.second = b;
            this.third = c;
            this.fourth = d;
        }

        public final A getFirst() {
            return this.first;
        }

        public final D getFourth() {
            return this.fourth;
        }

        public final B getSecond() {
            return this.second;
        }

        public final C getThird() {
            return this.third;
        }
    }

    public final void setCallBack(AttendanceByDayFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCalendarCallBack(AttendanceCalendarViewFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCalendarCallBack2(AttendanceFragment context) {
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