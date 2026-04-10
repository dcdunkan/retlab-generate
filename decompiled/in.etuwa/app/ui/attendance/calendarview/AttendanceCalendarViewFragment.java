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
import java.time.LocalDate;
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

/* JADX INFO: compiled from: AttendanceCalendarViewFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AttendanceCalendarViewFragment extends BaseFragment implements AttendanceCalendarViewAdapter.DayClickListener, AttendanceDayDialog.AttendanceDayListner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentAttendanceCalendarViewBinding _binding;
    private int a;
    private List<String> absent;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: attendanceCalendarViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy attendanceCalendarViewViewModel;
    private ArrayList<AttendanceNew> attendances;
    private LocalDate currentDate;
    private String currentMonth;
    private String currentYear;
    private boolean flag;
    private boolean flag2;
    private MainCallBackListener listener;
    private List<String> notavailable;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> present;
    private String semId;

    /* JADX INFO: compiled from: AttendanceCalendarViewFragment.kt */
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
                return attendanceCalendarViewFragment;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AttendanceCalendarViewViewModel.class), qualifier, b, null, koinScope);
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

    /* JADX INFO: renamed from: getBinding, reason: from getter */
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

    /* JADX INFO: compiled from: AttendanceCalendarViewFragment.kt */
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
        LocalDate localDateNow = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(localDateNow, "now()");
        this.currentDate = localDateNow;
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("MM");
        LocalDate localDate = this.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        this.currentMonth = localDate.format(dateTimeFormatterOfPattern);
        DateTimeFormatter dateTimeFormatterOfPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate2 = null;
        }
        this.currentYear = localDate2.format(dateTimeFormatterOfPattern2);
        AttendanceCalendarViewViewModel attendanceCalendarViewViewModel = getAttendanceCalendarViewViewModel();
        String str = this.semId;
        String str2 = this.currentYear;
        Intrinsics.checkNotNull(str2);
        String str3 = this.currentMonth;
        Intrinsics.checkNotNull(str3);
        attendanceCalendarViewViewModel.getAttendanceByDay(str, str2, str3);
        LocalDate localDateNow2 = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(localDateNow2, "now()");
        System.out.println(generateDaysInMonth(localDateNow2));
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentAttendanceCalendarViewBinding2 != null ? fragmentAttendanceCalendarViewBinding2.rvCalender : null;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        }
        DateTimeFormatter dateTimeFormatterOfPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        String str4 = localDate3.format(dateTimeFormatterOfPattern3);
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding3 = get_binding();
        TextView textView3 = fragmentAttendanceCalendarViewBinding3 != null ? fragmentAttendanceCalendarViewBinding3.monthTv : null;
        if (textView3 != null) {
            textView3.setText(str4);
        }
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding4 = get_binding();
        if (fragmentAttendanceCalendarViewBinding4 != null && (textView2 = fragmentAttendanceCalendarViewBinding4.nextBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceCalendarViewFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding5 = get_binding();
        if (fragmentAttendanceCalendarViewBinding5 == null || (textView = fragmentAttendanceCalendarViewBinding5.previousBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendanceCalendarViewFragment.setUp$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AttendanceCalendarViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalDate localDate = this$0.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        LocalDate localDatePlusMonths = localDate.plusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(localDatePlusMonths, "currentDate.plusMonths(1)");
        this$0.currentDate = localDatePlusMonths;
        this$0.updateMonthYearDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AttendanceCalendarViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalDate localDate = this$0.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        LocalDate localDateMinusMonths = localDate.minusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(localDateMinusMonths, "currentDate.minusMonths(1)");
        this$0.currentDate = localDateMinusMonths;
        this$0.updateMonthYearDisplay();
    }

    private final void updateMonthYearDisplay() {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter dateTimeFormatterOfPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate = this.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        this.currentMonth = localDate.format(dateTimeFormatterOfPattern);
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate2 = null;
        }
        this.currentYear = localDate2.format(dateTimeFormatterOfPattern2);
        System.out.println((Object) this.currentMonth);
        System.out.println((Object) this.currentYear);
        DateTimeFormatter dateTimeFormatterOfPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        String str = localDate3.format(dateTimeFormatterOfPattern3);
        FragmentAttendanceCalendarViewBinding fragmentAttendanceCalendarViewBinding = get_binding();
        TextView textView = fragmentAttendanceCalendarViewBinding != null ? fragmentAttendanceCalendarViewBinding.monthTv : null;
        if (textView != null) {
            textView.setText(str);
        }
        AttendanceCalendarViewViewModel attendanceCalendarViewViewModel = getAttendanceCalendarViewViewModel();
        String str2 = this.semId;
        String str3 = this.currentYear;
        Intrinsics.checkNotNull(str3);
        String str4 = this.currentMonth;
        Intrinsics.checkNotNull(str4);
        attendanceCalendarViewViewModel.getAttendanceByDay(str2, str3, str4);
    }

    private final List<String> generateDaysInMonth(LocalDate date) {
        ArrayList arrayList = new ArrayList();
        YearMonth yearMonthOf = YearMonth.of(date.getYear(), date.getMonth());
        int i = 1;
        LocalDate localDateWithDayOfMonth = date.withDayOfMonth(1);
        LocalDate localDateWithDayOfMonth2 = date.withDayOfMonth(yearMonthOf.lengthOfMonth());
        int value = localDateWithDayOfMonth.getDayOfWeek().getValue() % 7;
        System.out.println((Object) "firstDayOfMonth");
        System.out.println(value);
        System.out.println((Object) "firstDayOfMonth");
        int i2 = value != 0 ? value : 7;
        for (int i3 = 1; i3 < i2; i3++) {
            arrayList.add("");
        }
        int dayOfMonth = localDateWithDayOfMonth2.getDayOfMonth();
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
        getAttendanceCalendarViewViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceCalendarViewFragment.listenResponse$lambda$4(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(AttendanceCalendarViewFragment this$0, Resource resource) {
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
                int year = localDate.getYear();
                LocalDate localDate3 = this$0.currentDate;
                if (localDate3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                    localDate3 = null;
                }
                YearMonth yearMonthOf = YearMonth.of(year, localDate3.getMonth());
                LocalDate localDate4 = this$0.currentDate;
                if (localDate4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                    localDate4 = null;
                }
                LocalDate localDateWithDayOfMonth = localDate4.withDayOfMonth(1);
                LocalDate localDate5 = this$0.currentDate;
                if (localDate5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                } else {
                    localDate2 = localDate5;
                }
                LocalDate localDateWithDayOfMonth2 = localDate2.withDayOfMonth(yearMonthOf.lengthOfMonth());
                int i6 = 7;
                int value = localDateWithDayOfMonth.getDayOfWeek().getValue() % 7;
                System.out.println((Object) "firstDayOfWeek");
                System.out.println(value);
                System.out.println((Object) "firstDayOfWeek");
                if (value != 0) {
                    i6 = value;
                }
                for (int i7 = 1; i7 < i6; i7++) {
                    arrayList.add("");
                    arrayList2.add("");
                    arrayList3.add("");
                    arrayList4.add("");
                    arrayList5.add(0);
                    arrayList6.add(false);
                    this$0.a = i7;
                }
                int dayOfMonth = localDateWithDayOfMonth2.getDayOfMonth();
                if (1 <= dayOfMonth) {
                    int i8 = 1;
                    while (true) {
                        arrayList.add(String.valueOf(i8));
                        if (i8 == dayOfMonth) {
                            break;
                        } else {
                            i8++;
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
                    int i9 = 0;
                    while (true) {
                        arrayList5.add(Integer.valueOf(this$0.attendances.get(i9).getTotalperiod()));
                        arrayList6.add(Boolean.valueOf(this$0.attendances.get(i9).getHoliday()));
                        int totalperiod = this$0.attendances.get(i9).getTotalperiod() - i5;
                        if (totalperiod >= 0) {
                            int i10 = 0;
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            while (true) {
                                if (Intrinsics.areEqual(this$0.attendances.get(i9).getPeriods().get(i10).getAttendance(), "present")) {
                                    i++;
                                } else {
                                    String lowerCase = this$0.attendances.get(i9).getPeriods().get(i10).getAttendance().toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    if (Intrinsics.areEqual(lowerCase, "n/a")) {
                                        i2++;
                                    } else if (Intrinsics.areEqual(this$0.attendances.get(i9).getPeriods().get(i10).getAttendance(), "absent")) {
                                        i3++;
                                    }
                                }
                                if (i10 == totalperiod) {
                                    break;
                                } else {
                                    i10++;
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
                        if (i9 == size) {
                            break;
                        }
                        i9++;
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
        Intrinsics.checkNotNullParameter(day, "day");
        String strPadStart = StringsKt.padStart(day, 2, '0');
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter dateTimeFormatterOfPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate = this.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        this.currentMonth = localDate.format(dateTimeFormatterOfPattern);
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate2 = null;
        }
        this.currentYear = localDate2.format(dateTimeFormatterOfPattern2);
        System.out.println((Object) this.currentMonth);
        System.out.println((Object) this.currentYear);
        DateTimeFormatter dateTimeFormatterOfPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        localDate3.format(dateTimeFormatterOfPattern3);
        String str = this.currentYear + HelpFormatter.DEFAULT_OPT_PREFIX + this.currentMonth + HelpFormatter.DEFAULT_OPT_PREFIX + strPadStart;
        System.out.println((Object) str);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AttendanceDayDialog attendanceDayDialogNewInstance = AttendanceDayDialog.INSTANCE.newInstance(str, this.semId);
        attendanceDayDialogNewInstance.setCalendarCallBack(this);
        attendanceDayDialogNewInstance.show(childFragmentManager, (String) null);
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