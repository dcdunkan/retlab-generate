package in.etuwa.app.ui.attendance.calendarview;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.attendance.AttendanceNew;
import in.etuwa.app.data.model.attendance.AttendanceNewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentAttendanceCalendarViewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.cleverpumpkin.calendar.adapter.CalendarAdapter;

/* compiled from: AttendanceCalendarViewFragment.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001RB\u0005¢\u0006\u0002\u0010\u0004J\b\u00106\u001a\u000207H\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00109\u001a\u00020\u001eH\u0003J\b\u0010:\u001a\u000207H\u0014J\b\u0010;\u001a\u000207H\u0014J\b\u0010<\u001a\u000207H\u0003J\u0010\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u0002072\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J&\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u000bH\u0017J\b\u0010K\u001a\u000207H\u0016J\u001a\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020D2\b\u0010A\u001a\u0004\u0018\u00010BH\u0017J\b\u0010N\u001a\u000207H\u0015J\b\u0010O\u001a\u000207H\u0014J\b\u0010P\u001a\u000207H\u0014J\b\u0010Q\u001a\u000207H\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006S"}, d2 = {"Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter$DayClickListener;", "Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog$AttendanceDayListner;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentAttendanceCalendarViewBinding;", "a", "", "absent", "", "", "adapter", "Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter;", "getAdapter", "()Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "attendanceCalendarViewViewModel", "Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewViewModel;", "getAttendanceCalendarViewViewModel", "()Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewViewModel;", "attendanceCalendarViewViewModel$delegate", "attendances", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/attendance/AttendanceNew;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentAttendanceCalendarViewBinding;", "currentDate", "Ljava/time/LocalDate;", "currentMonth", "currentYear", "flag", "", "flag2", "getFlag2", "()Z", "setFlag2", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "notavailable", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "present", "semId", "getSemId", "()Ljava/lang/String;", "setSemId", "(Ljava/lang/String;)V", "dismiss", "", "generateDaysInMonth", "date", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDateClicked", "day", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "updateMonthYearDisplay", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttendanceCalendarViewFragment extends BaseFragment implements AttendanceCalendarViewAdapter.DayClickListener, AttendanceDayDialog.AttendanceDayListner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentAttendanceCalendarViewBinding _binding;
    private int a;
    private List<String> absent;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: attendanceCalendarViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy attendanceCalendarViewViewModel;
    private ArrayList<AttendanceNew> attendances;
    private LocalDate currentDate;
    private String currentMonth;
    private String currentYear;
    private boolean flag;
    private boolean flag2;
    private MainCallBackListener listener;
    private List<String> notavailable;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> present;
    private String semId;

    /* compiled from: AttendanceCalendarViewFragment.kt */
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

    @JvmStatic
    public static final AttendanceCalendarViewFragment newInstance(boolean z) {
        return INSTANCE.newInstance(z);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public AttendanceCalendarViewFragment() {
        final AttendanceCalendarViewFragment attendanceCalendarViewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(attendanceCalendarViewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.attendanceCalendarViewViewModel = FragmentViewModelLazyKt.createViewModelLazy(attendanceCalendarViewFragment, Reflection.getOrCreateKotlinClass(AttendanceCalendarViewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AttendanceCalendarViewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AttendanceCalendarViewFragment attendanceCalendarViewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AttendanceCalendarViewAdapter>() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AttendanceCalendarViewAdapter invoke() {
                ComponentCallbacks componentCallbacks = attendanceCalendarViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AttendanceCalendarViewAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = attendanceCalendarViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.semId = getPreference().getUserSemId();
        this.attendances = new ArrayList<>();
    }

    private final AttendanceCalendarViewViewModel getAttendanceCalendarViewViewModel() {
        return (AttendanceCalendarViewViewModel) this.attendanceCalendarViewViewModel.getValue();
    }

    private final AttendanceCalendarViewAdapter getAdapter() {
        return (AttendanceCalendarViewAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentAttendanceCalendarViewBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getSemId() {
        return this.semId;
    }

    public final void setSemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semId = str;
    }

    public final boolean getFlag2() {
        return this.flag2;
    }

    public final void setFlag2(boolean z) {
        this.flag2 = z;
    }

    /* compiled from: AttendanceCalendarViewFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewFragment;", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AttendanceCalendarViewFragment newInstance(boolean flag) {
            AttendanceCalendarViewFragment attendanceCalendarViewFragment = new AttendanceCalendarViewFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", flag);
            attendanceCalendarViewFragment.setArguments(bundle);
            return attendanceCalendarViewFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.flag = arguments.getBoolean("flag");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentAttendanceCalendarViewBinding.inflate(inflater, container, false);
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding = get_binding();
        if (fragmentAttendanceCalendarViewBinding != null) {
            fragmentAttendanceCalendarViewBinding.setAttendanceCalendarViewViewModel(getAttendanceCalendarViewViewModel());
        }
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding2 = get_binding();
        if (fragmentAttendanceCalendarViewBinding2 != null) {
            fragmentAttendanceCalendarViewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding3 = get_binding();
        if (fragmentAttendanceCalendarViewBinding3 != null) {
            return fragmentAttendanceCalendarViewBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        LocalDate now;
        DateTimeFormatter ofPattern;
        String format;
        DateTimeFormatter ofPattern2;
        String format2;
        LocalDate now2;
        DateTimeFormatter ofPattern3;
        String format3;
        TextView textView;
        TextView textView2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.attendance));
        }
        hideBaseView();
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding = get_binding();
        RecyclerView recyclerView = fragmentAttendanceCalendarViewBinding != null ? fragmentAttendanceCalendarViewBinding.rvCalender : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCalendarCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        now = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now, "now()");
        this.currentDate = now;
        ofPattern = DateTimeFormatter.ofPattern("MM");
        LocalDate localDate = this.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        format = localDate.format(ofPattern);
        this.currentMonth = format;
        ofPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate2 = null;
        }
        format2 = localDate2.format(ofPattern2);
        this.currentYear = format2;
        AttendanceCalendarViewViewModel attendanceCalendarViewViewModel = getAttendanceCalendarViewViewModel();
        String str = this.semId;
        String str2 = this.currentYear;
        Intrinsics.checkNotNull(str2);
        String str3 = this.currentMonth;
        Intrinsics.checkNotNull(str3);
        attendanceCalendarViewViewModel.getAttendanceByDay(str, str2, str3);
        now2 = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now2, "now()");
        System.out.println(generateDaysInMonth(now2));
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentAttendanceCalendarViewBinding2 != null ? fragmentAttendanceCalendarViewBinding2.rvCalender : null;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        }
        ofPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        format3 = localDate3.format(ofPattern3);
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding3 = get_binding();
        TextView textView3 = fragmentAttendanceCalendarViewBinding3 != null ? fragmentAttendanceCalendarViewBinding3.monthTv : null;
        if (textView3 != null) {
            textView3.setText(format3);
        }
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding4 = get_binding();
        if (fragmentAttendanceCalendarViewBinding4 != null && (textView2 = fragmentAttendanceCalendarViewBinding4.nextBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceCalendarViewFragment.setUp$lambda$1(AttendanceCalendarViewFragment.this, view);
                }
            });
        }
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding5 = get_binding();
        if (fragmentAttendanceCalendarViewBinding5 == null || (textView = fragmentAttendanceCalendarViewBinding5.previousBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendanceCalendarViewFragment.setUp$lambda$2(AttendanceCalendarViewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AttendanceCalendarViewFragment this$0, View view) {
        LocalDate plusMonths;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalDate localDate = this$0.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        plusMonths = localDate.plusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(plusMonths, "currentDate.plusMonths(1)");
        this$0.currentDate = plusMonths;
        this$0.updateMonthYearDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AttendanceCalendarViewFragment this$0, View view) {
        LocalDate minusMonths;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalDate localDate = this$0.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        minusMonths = localDate.minusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(minusMonths, "currentDate.minusMonths(1)");
        this$0.currentDate = minusMonths;
        this$0.updateMonthYearDisplay();
    }

    private final void updateMonthYearDisplay() {
        DateTimeFormatter ofPattern;
        DateTimeFormatter ofPattern2;
        String format;
        String format2;
        DateTimeFormatter ofPattern3;
        String format3;
        ofPattern = DateTimeFormatter.ofPattern("MM");
        ofPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate = this.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        format = localDate.format(ofPattern);
        this.currentMonth = format;
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate2 = null;
        }
        format2 = localDate2.format(ofPattern2);
        this.currentYear = format2;
        System.out.println((Object) this.currentMonth);
        System.out.println((Object) this.currentYear);
        ofPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        format3 = localDate3.format(ofPattern3);
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding = get_binding();
        TextView textView = fragmentAttendanceCalendarViewBinding != null ? fragmentAttendanceCalendarViewBinding.monthTv : null;
        if (textView != null) {
            textView.setText(format3);
        }
        AttendanceCalendarViewViewModel attendanceCalendarViewViewModel = getAttendanceCalendarViewViewModel();
        String str = this.semId;
        String str2 = this.currentYear;
        Intrinsics.checkNotNull(str2);
        String str3 = this.currentMonth;
        Intrinsics.checkNotNull(str3);
        attendanceCalendarViewViewModel.getAttendanceByDay(str, str2, str3);
    }

    private final List<String> generateDaysInMonth(LocalDate date) {
        int year;
        Month month;
        YearMonth of;
        LocalDate withDayOfMonth;
        int lengthOfMonth;
        LocalDate withDayOfMonth2;
        DayOfWeek dayOfWeek;
        int value;
        int dayOfMonth;
        ArrayList arrayList = new ArrayList();
        year = date.getYear();
        month = date.getMonth();
        of = YearMonth.of(year, month);
        int i = 1;
        withDayOfMonth = date.withDayOfMonth(1);
        lengthOfMonth = of.lengthOfMonth();
        withDayOfMonth2 = date.withDayOfMonth(lengthOfMonth);
        dayOfWeek = withDayOfMonth.getDayOfWeek();
        value = dayOfWeek.getValue();
        int i2 = value % 7;
        System.out.println((Object) "firstDayOfMonth");
        System.out.println(i2);
        System.out.println((Object) "firstDayOfMonth");
        int i3 = i2 != 0 ? i2 : 7;
        for (int i4 = 1; i4 < i3; i4++) {
            arrayList.add("");
        }
        dayOfMonth = withDayOfMonth2.getDayOfMonth();
        if (1 <= dayOfMonth) {
            while (true) {
                arrayList.add(String.valueOf(i));
                if (i == dayOfMonth) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private final void listenResponse() {
        getAttendanceCalendarViewViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceCalendarViewFragment.listenResponse$lambda$4(AttendanceCalendarViewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(AttendanceCalendarViewFragment this$0, Resource resource) {
        int year;
        Month month;
        YearMonth of;
        LocalDate withDayOfMonth;
        int lengthOfMonth;
        LocalDate withDayOfMonth2;
        DayOfWeek dayOfWeek;
        int value;
        int dayOfMonth;
        int i;
        int i2;
        int i3;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i4 = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            if (i4 == 2) {
                this$0.hideBaseView();
                this$0.showProgress();
                return;
            }
            if (i4 == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i4 != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding = this$0.get_binding();
            if (fragmentAttendanceCalendarViewBinding == null || (recyclerView = fragmentAttendanceCalendarViewBinding.rvCalender) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        AttendanceNewResponse attendanceNewResponse = (AttendanceNewResponse) resource.getData();
        if (attendanceNewResponse != null) {
            this$0.showBaseView();
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                LocalDate localDate = this$0.currentDate;
                LocalDate localDate2 = null;
                if (localDate == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                    localDate = null;
                }
                year = localDate.getYear();
                LocalDate localDate3 = this$0.currentDate;
                if (localDate3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                    localDate3 = null;
                }
                month = localDate3.getMonth();
                of = YearMonth.of(year, month);
                LocalDate localDate4 = this$0.currentDate;
                if (localDate4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                    localDate4 = null;
                }
                withDayOfMonth = localDate4.withDayOfMonth(1);
                LocalDate localDate5 = this$0.currentDate;
                if (localDate5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                } else {
                    localDate2 = localDate5;
                }
                lengthOfMonth = of.lengthOfMonth();
                withDayOfMonth2 = localDate2.withDayOfMonth(lengthOfMonth);
                dayOfWeek = withDayOfMonth.getDayOfWeek();
                value = dayOfWeek.getValue();
                int i6 = 7;
                int i7 = value % 7;
                System.out.println((Object) "firstDayOfWeek");
                System.out.println(i7);
                System.out.println((Object) "firstDayOfWeek");
                if (i7 != 0) {
                    i6 = i7;
                }
                for (int i8 = 1; i8 < i6; i8++) {
                    arrayList.add("");
                    arrayList2.add("");
                    arrayList3.add("");
                    arrayList4.add("");
                    arrayList5.add(0);
                    arrayList6.add(false);
                    this$0.a = i8;
                }
                dayOfMonth = withDayOfMonth2.getDayOfMonth();
                if (1 <= dayOfMonth) {
                    int i9 = 1;
                    while (true) {
                        arrayList.add(String.valueOf(i9));
                        if (i9 == dayOfMonth) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                }
                this$0.absent = arrayList;
                this$0.present = arrayList;
                this$0.notavailable = arrayList;
                System.out.println(this$0.a);
                System.out.println(this$0.absent);
                System.out.println(this$0.present);
                System.out.println(this$0.notavailable);
                System.out.println(this$0.a);
                ArrayList<AttendanceNew> attends = attendanceNewResponse.getAttends();
                this$0.attendances = attends;
                int size = attends.size() - 1;
                if (size >= 0) {
                    int i10 = 0;
                    while (true) {
                        arrayList5.add(Integer.valueOf(this$0.attendances.get(i10).getTotalperiod()));
                        arrayList6.add(Boolean.valueOf(this$0.attendances.get(i10).getHoliday()));
                        int totalperiod = this$0.attendances.get(i10).getTotalperiod() - i5;
                        if (totalperiod >= 0) {
                            int i11 = 0;
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            while (true) {
                                if (Intrinsics.areEqual(this$0.attendances.get(i10).getPeriods().get(i11).getAttendance(), "present")) {
                                    i++;
                                } else {
                                    String lowerCase = this$0.attendances.get(i10).getPeriods().get(i11).getAttendance().toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    if (Intrinsics.areEqual(lowerCase, "n/a")) {
                                        i2++;
                                    } else if (Intrinsics.areEqual(this$0.attendances.get(i10).getPeriods().get(i11).getAttendance(), "absent")) {
                                        i3++;
                                    }
                                }
                                if (i11 == totalperiod) {
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                        }
                        arrayList2.add(String.valueOf(i3));
                        arrayList3.add(String.valueOf(i));
                        arrayList4.add(String.valueOf(i2));
                        if (i10 == size) {
                            break;
                        }
                        i10++;
                        i5 = 1;
                    }
                }
                this$0.absent = arrayList2;
                this$0.present = arrayList3;
                this$0.notavailable = arrayList4;
                AttendanceCalendarViewAdapter adapter = this$0.getAdapter();
                List<String> list = this$0.present;
                Intrinsics.checkNotNull(list);
                List<String> list2 = this$0.absent;
                Intrinsics.checkNotNull(list2);
                List<String> list3 = this$0.notavailable;
                Intrinsics.checkNotNull(list3);
                adapter.addItems(arrayList, list, list2, list3, arrayList5, arrayList6);
                System.out.println(this$0.a);
                System.out.println(this$0.absent);
                System.out.println(this$0.present);
                System.out.println(this$0.notavailable);
                System.out.println(arrayList5);
                System.out.println(this$0.a);
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter.DayClickListener
    public void onDateClicked(String day) {
        DateTimeFormatter ofPattern;
        DateTimeFormatter ofPattern2;
        String format;
        String format2;
        DateTimeFormatter ofPattern3;
        Intrinsics.checkNotNullParameter(day, "day");
        String padStart = StringsKt.padStart(day, 2, '0');
        ofPattern = DateTimeFormatter.ofPattern("MM");
        ofPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate = this.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        format = localDate.format(ofPattern);
        this.currentMonth = format;
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate2 = null;
        }
        format2 = localDate2.format(ofPattern2);
        this.currentYear = format2;
        System.out.println((Object) this.currentMonth);
        System.out.println((Object) this.currentYear);
        ofPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        localDate3.format(ofPattern3);
        String str = this.currentYear + HelpFormatter.DEFAULT_OPT_PREFIX + this.currentMonth + HelpFormatter.DEFAULT_OPT_PREFIX + padStart;
        System.out.println((Object) str);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AttendanceDayDialog newInstance = AttendanceDayDialog.INSTANCE.newInstance(str, this.semId);
        newInstance.setCalendarCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog.AttendanceDayListner
    public void dismiss() {
        AttendanceCalendarViewViewModel attendanceCalendarViewViewModel = getAttendanceCalendarViewViewModel();
        String str = this.semId;
        String str2 = this.currentYear;
        Intrinsics.checkNotNull(str2);
        String str3 = this.currentMonth;
        Intrinsics.checkNotNull(str3);
        attendanceCalendarViewViewModel.getAttendanceByDay(str, str2, str3);
    }
}