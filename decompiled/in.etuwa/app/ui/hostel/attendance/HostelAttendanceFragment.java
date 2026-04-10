package in.etuwa.app.ui.hostel.attendance;

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
import com.applandeo.materialcalendarview.EventDay;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.FragmentHostelAttendanceBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.cleverpumpkin.calendar.adapter.CalendarAdapter;

/* JADX INFO: compiled from: HostelAttendanceFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelAttendanceFragment extends BaseFragment implements HostelApplyLeaveDialog.ApplyLeaveCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelAttendanceBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private Calendar calendar;
    private LocalDate currentDate;
    private String currentMonth;
    private String currentYear;
    private ArrayList<EventDay> eventList;

    /* JADX INFO: renamed from: hostelAttendanceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelAttendanceViewModel;
    private MainCallBackListener listener;

    /* JADX INFO: compiled from: HostelAttendanceFragment.kt */
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
    public static final HostelAttendanceFragment newInstance() {
        return INSTANCE.newInstance();
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

    public HostelAttendanceFragment() {
        final HostelAttendanceFragment hostelAttendanceFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return hostelAttendanceFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelAttendanceFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelAttendanceViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelAttendanceFragment, Reflection.getOrCreateKotlinClass(HostelAttendanceViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(HostelAttendanceViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.eventList = new ArrayList<>();
        final HostelAttendanceFragment hostelAttendanceFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelAttendanceAdapter>() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.attendance.HostelAttendanceAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelAttendanceAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelAttendanceFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelAttendanceAdapter.class), b2, b3);
            }
        });
    }

    private final HostelAttendanceViewModel getHostelAttendanceViewModel() {
        return (HostelAttendanceViewModel) this.hostelAttendanceViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentHostelAttendanceBinding get_binding() {
        return this._binding;
    }

    public final ArrayList<EventDay> getEventList() {
        return this.eventList;
    }

    public final void setEventList(ArrayList<EventDay> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.eventList = arrayList;
    }

    private final HostelAttendanceAdapter getAdapter() {
        return (HostelAttendanceAdapter) this.adapter.getValue();
    }

    /* JADX INFO: compiled from: HostelAttendanceFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelAttendanceFragment newInstance() {
            HostelAttendanceFragment hostelAttendanceFragment = new HostelAttendanceFragment();
            hostelAttendanceFragment.setArguments(new Bundle());
            return hostelAttendanceFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHostelAttendanceBinding.inflate(inflater, container, false);
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding = get_binding();
        if (fragmentHostelAttendanceBinding != null) {
            fragmentHostelAttendanceBinding.setHostelAttendanceViewModel(getHostelAttendanceViewModel());
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding2 = get_binding();
        if (fragmentHostelAttendanceBinding2 != null) {
            fragmentHostelAttendanceBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding3 = get_binding();
        if (fragmentHostelAttendanceBinding3 != null) {
            return fragmentHostelAttendanceBinding3.getRoot();
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
        TextView textView3;
        TextView textView4;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Attendance");
        }
        hideBaseView();
        listenResponse();
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelAttendanceBinding != null ? fragmentHostelAttendanceBinding.rvCalender : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.calendar = calendar;
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
        HostelAttendanceViewModel hostelAttendanceViewModel = getHostelAttendanceViewModel();
        Calendar calendar2 = this.calendar;
        if (calendar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar2 = null;
        }
        String strValueOf = String.valueOf(calendar2.get(2) + 1);
        Calendar calendar3 = this.calendar;
        if (calendar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar3 = null;
        }
        hostelAttendanceViewModel.getHostelAttCalView(strValueOf, String.valueOf(calendar3.get(1)));
        LocalDate localDateNow2 = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(localDateNow2, "now()");
        System.out.println(generateDaysInMonth(localDateNow2));
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentHostelAttendanceBinding2 != null ? fragmentHostelAttendanceBinding2.rvCalender : null;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        }
        DateTimeFormatter dateTimeFormatterOfPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        String str = localDate3.format(dateTimeFormatterOfPattern3);
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding3 = get_binding();
        TextView textView5 = fragmentHostelAttendanceBinding3 != null ? fragmentHostelAttendanceBinding3.monthTv : null;
        if (textView5 != null) {
            textView5.setText(str);
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding4 = get_binding();
        if (fragmentHostelAttendanceBinding4 != null && (textView4 = fragmentHostelAttendanceBinding4.nextBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelAttendanceFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding5 = get_binding();
        if (fragmentHostelAttendanceBinding5 != null && (textView3 = fragmentHostelAttendanceBinding5.previousBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelAttendanceFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding6 = get_binding();
        if (fragmentHostelAttendanceBinding6 != null && (textView2 = fragmentHostelAttendanceBinding6.btnView) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelAttendanceFragment.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding7 = get_binding();
        if (fragmentHostelAttendanceBinding7 == null || (textView = fragmentHostelAttendanceBinding7.btnApply) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelAttendanceFragment.setUp$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HostelAttendanceFragment this$0, View view) {
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
    public static final void setUp$lambda$2(HostelAttendanceFragment this$0, View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(HostelAttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onHostelAttViewClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(HostelAttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelApplyLeaveDialog hostelApplyLeaveDialogNewInstance = HostelApplyLeaveDialog.INSTANCE.newInstance();
        hostelApplyLeaveDialogNewInstance.setApplyLeaveCallBack(this$0);
        hostelApplyLeaveDialogNewInstance.show(childFragmentManager, (String) null);
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
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding = get_binding();
        TextView textView = fragmentHostelAttendanceBinding != null ? fragmentHostelAttendanceBinding.monthTv : null;
        if (textView != null) {
            textView.setText(str);
        }
        HostelAttendanceViewModel hostelAttendanceViewModel = getHostelAttendanceViewModel();
        String str2 = this.currentYear;
        Intrinsics.checkNotNull(str2);
        String str3 = this.currentMonth;
        Intrinsics.checkNotNull(str3);
        hostelAttendanceViewModel.getHostelAttCalView(str2, str3);
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
        getHostelAttendanceViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceFragment.listenResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void listenResponse$lambda$6(in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment r22, in.etuwa.app.utils.Resource r23) {
        /*
            Method dump skipped, instruction units count: 816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment.listenResponse$lambda$6(in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment, in.etuwa.app.utils.Resource):void");
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

    @Override // in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog.ApplyLeaveCallBack
    public void onDismiss() {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onHostelAttViewClicked();
        }
    }
}