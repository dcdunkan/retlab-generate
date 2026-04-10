package in.etuwa.app.ui.dashboard.dashtable;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentDashTableViewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker$$ExternalSyntheticApiModelOutline0;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.ui.dashboard.dashtable.DashTableViewAdapter;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import in.etuwa.etlabstaff.data.model.timetable.TimeTablePeriod;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: DashTableViewFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashTableViewFragment extends BaseFragment implements DashTableViewAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentDashTableViewBinding _binding;
    private String absentFlag;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String attendanceLock;
    private String batchId;

    /* JADX INFO: renamed from: dashTableViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dashTableViewViewModel;
    private String date;
    private String day;
    private String holidayFlag;
    private String hour;
    private Integer id;
    private boolean isFirstFragment;
    private boolean isLastFragment;
    private MainCallBackListener listener;
    private Integer position;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String subId;
    private ArrayList<PeriodsNew> tables;
    private String title;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void alertView$lambda$6(DialogInterface dialogInterface, int i) {
    }

    @JvmStatic
    public static final DashTableViewFragment newInstance(ArrayList<PeriodsNew> arrayList, String str, String str2, int i, boolean z, boolean z2) {
        return INSTANCE.newInstance(arrayList, str, str2, i, z, z2);
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

    public DashTableViewFragment() {
        final DashTableViewFragment dashTableViewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return dashTableViewFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(dashTableViewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.dashTableViewViewModel = FragmentViewModelLazyKt.createViewModelLazy(dashTableViewFragment, Reflection.getOrCreateKotlinClass(DashTableViewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(DashTableViewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final DashTableViewFragment dashTableViewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DashTableViewAdapter>() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.dashtable.DashTableViewAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashTableViewAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashTableViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashTableViewAdapter.class), b2, b3);
            }
        });
        this.batchId = "";
        this.subId = "";
        this.title = "";
        this.holidayFlag = "";
        this.absentFlag = "";
        this.position = 99;
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = dashTableViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final DashTableViewViewModel getDashTableViewViewModel() {
        return (DashTableViewViewModel) this.dashTableViewViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DashTableViewAdapter getAdapter() {
        return (DashTableViewAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentDashTableViewBinding get_binding() {
        return this._binding;
    }

    public final String getAttendanceLock() {
        return this.attendanceLock;
    }

    public final void setAttendanceLock(String str) {
        this.attendanceLock = str;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        scrollToRelevantPeriod();
    }

    /* JADX INFO: compiled from: DashTableViewFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/dashboard/dashtable/DashTableViewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/dashboard/dashtable/DashTableViewFragment;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/dashboard/dashtable/PeriodsNew;", "Lkotlin/collections/ArrayList;", "day", "", "date", "id", "", "isFirst", "", "isLast", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DashTableViewFragment newInstance(ArrayList<PeriodsNew> list, String day, String date, int id, boolean isFirst, boolean isLast) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(day, "day");
            Intrinsics.checkNotNullParameter(date, "date");
            DashTableViewFragment dashTableViewFragment = new DashTableViewFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("table", list);
            bundle.putString("flag", day);
            bundle.putString("date", date);
            bundle.putInt("id", id);
            bundle.putBoolean("is_first", isFirst);
            bundle.putBoolean("is_last", isLast);
            dashTableViewFragment.setArguments(bundle);
            return dashTableViewFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.tables = arguments.getParcelableArrayList("table");
            this.day = arguments.getString("flag");
            this.date = arguments.getString("date");
            this.id = Integer.valueOf(arguments.getInt("id"));
            Bundle arguments2 = getArguments();
            this.isFirstFragment = arguments2 != null ? arguments2.getBoolean("is_first") : false;
            Bundle arguments3 = getArguments();
            this.isLastFragment = arguments3 != null ? arguments3.getBoolean("is_last") : false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentDashTableViewBinding.inflate(inflater, container, false);
        FragmentDashTableViewBinding fragmentDashTableViewBinding = get_binding();
        if (fragmentDashTableViewBinding != null) {
            fragmentDashTableViewBinding.setDashTableViewViewModel(getDashTableViewViewModel());
        }
        FragmentDashTableViewBinding fragmentDashTableViewBinding2 = get_binding();
        if (fragmentDashTableViewBinding2 != null) {
            fragmentDashTableViewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentDashTableViewBinding fragmentDashTableViewBinding3 = get_binding();
        if (fragmentDashTableViewBinding3 != null) {
            return fragmentDashTableViewBinding3.getRoot();
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
        RecyclerView recyclerView;
        System.out.println((Object) ("initial loading " + this.day));
        FragmentDashTableViewBinding fragmentDashTableViewBinding = get_binding();
        RecyclerView recyclerView2 = fragmentDashTableViewBinding != null ? fragmentDashTableViewBinding.rvDashTableView : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        DashTableViewAdapter adapter = getAdapter();
        ArrayList<PeriodsNew> arrayList = this.tables;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        String str = this.day;
        Intrinsics.checkNotNull(str);
        adapter.addItems(arrayList, str, true, getPreference().getUserProName());
        getAdapter().setCallBack(this);
        FragmentDashTableViewBinding fragmentDashTableViewBinding2 = get_binding();
        if (fragmentDashTableViewBinding2 == null || (recyclerView = fragmentDashTableViewBinding2.rvDashTableView) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment.setUp.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView3, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                super.onScrolled(recyclerView3, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null) {
                    return;
                }
                int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int itemCount = DashTableViewFragment.this.getAdapter().getItemCount();
                if (DashTableViewFragment.this.isFirstFragment && iFindFirstCompletelyVisibleItemPosition == 0 && dy < 0) {
                    Fragment parentFragment = DashTableViewFragment.this.getParentFragment();
                    DashboardFragment dashboardFragment = parentFragment instanceof DashboardFragment ? (DashboardFragment) parentFragment : null;
                    if (dashboardFragment != null) {
                        dashboardFragment.onPreviousWeekRequested();
                    }
                }
                if (DashTableViewFragment.this.isLastFragment && iFindLastCompletelyVisibleItemPosition == itemCount - 1 && dy > 0) {
                    Fragment parentFragment2 = DashTableViewFragment.this.getParentFragment();
                    DashboardFragment dashboardFragment2 = parentFragment2 instanceof DashboardFragment ? (DashboardFragment) parentFragment2 : null;
                    if (dashboardFragment2 != null) {
                        dashboardFragment2.onNextWeekRequested();
                    }
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.dashboard.dashtable.DashTableViewAdapter.CallBack
    public void onPeriodClicked(String subId, String batchId, int position, String title) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(title, "title");
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Intrinsics.checkNotNullExpressionValue(str, "currentDate.format(formatter)");
        if (Intrinsics.areEqual(this.day, "M")) {
            System.out.println((Object) getDateForClickedDay(str, "Monday"));
        } else if (Intrinsics.areEqual(this.day, "T")) {
            System.out.println((Object) getDateForClickedDay(str, "Tuesday"));
        } else if (Intrinsics.areEqual(this.day, ExifInterface.LONGITUDE_WEST)) {
            System.out.println((Object) getDateForClickedDay(str, "Wednesday"));
        } else if (Intrinsics.areEqual(this.day, "Th")) {
            System.out.println((Object) getDateForClickedDay(str, "Thursday"));
        } else if (Intrinsics.areEqual(this.day, "F")) {
            System.out.println((Object) getDateForClickedDay(str, "Friday"));
        } else if (Intrinsics.areEqual(this.day, "S")) {
            System.out.println((Object) getDateForClickedDay(str, "Saturday"));
        } else if (Intrinsics.areEqual(this.day, "Su")) {
            System.out.println((Object) getDateForClickedDay(str, "Sunday"));
        }
        this.holidayFlag = "attendance";
        this.subId = subId;
        this.batchId = batchId;
        this.position = Integer.valueOf(position);
        this.title = title;
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate.now();
        String str2 = this.day;
        Intrinsics.checkNotNull(str2);
        LocalDate.parse(str2, dateTimeFormatterOfPattern);
    }

    @Override // in.etuwa.app.ui.dashboard.dashtable.DashTableViewAdapter.CallBack
    public void onDate(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        System.out.println((Object) ("date " + date));
    }

    private final String getDateForClickedDay(String currentDate, String clickedDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        Date date = simpleDateFormat.parse(currentDate);
        if (date == null) {
            return "Invalid Date";
        }
        calendar.setTime(date);
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Sunday", 1), TuplesKt.to("Monday", 2), TuplesKt.to("Tuesday", 3), TuplesKt.to("Wednesday", 4), TuplesKt.to("Thursday", 5), TuplesKt.to("Friday", 6), TuplesKt.to("Saturday", 7));
        int i = calendar.get(7);
        Integer num = (Integer) mapMapOf.get(clickedDay);
        if (num == null) {
            return "Invalid Day";
        }
        calendar.add(5, num.intValue() - i);
        String str = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "dateFormat.format(calendar.time)");
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    public final int findCurrentOrNextPeriodIndex(List<TimeTablePeriod> periods) {
        LocalTime localTime;
        LocalTime localTime2;
        Intrinsics.checkNotNullParameter(periods, "periods");
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("hh:mm a", Locale.US);
        LocalTime localTimeNow = LocalTime.now();
        Iterator<TimeTablePeriod> it = periods.iterator();
        long j = Long.MAX_VALUE;
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = i + 1;
            String timeperiod = it.next().getTimeperiod();
            List listSplit$default = timeperiod != null ? StringsKt.split$default((CharSequence) timeperiod, new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null) : null;
            if (listSplit$default != null && listSplit$default.size() == 2) {
                try {
                    localTime = LocalTime.parse(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString(), dateTimeFormatterOfPattern);
                    localTime2 = LocalTime.parse(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString(), dateTimeFormatterOfPattern);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (localTimeNow.isAfter(localTime) && localTimeNow.isBefore(localTime2)) {
                    return i;
                }
                if (localTime.isAfter(localTimeNow)) {
                    long minutes = Duration.between(ValidChecker$$ExternalSyntheticApiModelOutline0.m603m((Object) localTimeNow), ValidChecker$$ExternalSyntheticApiModelOutline0.m603m((Object) localTime)).toMinutes();
                    if (minutes < j) {
                        i2 = i;
                        i = i3;
                        j = minutes;
                    }
                }
            }
            i = i3;
        }
        return i2;
    }

    private final void scrollToRelevantPeriod() {
        RecyclerView recyclerView;
        Integer numValueOf;
        Calendar calendar = Calendar.getInstance();
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
        int i = (calendar.get(11) * 60) + calendar.get(12);
        boolean zAreEqual = Intrinsics.areEqual(str, this.day);
        final int iIntValue = 0;
        if (zAreEqual) {
            ArrayList<PeriodsNew> arrayList = this.tables;
            int i2 = -1;
            Integer numValueOf2 = null;
            if (arrayList != null) {
                Iterator<PeriodsNew> it = arrayList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    String timeperiod = it.next().getTimeperiod();
                    Intrinsics.checkNotNull(timeperiod);
                    if (isTimeInRange(timeperiod, i)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                numValueOf = Integer.valueOf(i3);
            } else {
                numValueOf = null;
            }
            if (numValueOf != null && numValueOf.intValue() >= 0) {
                iIntValue = numValueOf.intValue();
            } else {
                ArrayList<PeriodsNew> arrayList2 = this.tables;
                if (arrayList2 != null) {
                    Iterator<PeriodsNew> it2 = arrayList2.iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        String timeperiod2 = it2.next().getTimeperiod();
                        Intrinsics.checkNotNull(timeperiod2);
                        if (parseStartMinutes(timeperiod2) > i) {
                            i2 = i4;
                            break;
                        }
                        i4++;
                    }
                    numValueOf2 = Integer.valueOf(i2);
                }
                if (numValueOf2 != null && numValueOf2.intValue() >= 0) {
                    iIntValue = numValueOf2.intValue();
                }
            }
        }
        FragmentDashTableViewBinding fragmentDashTableViewBinding = get_binding();
        if (fragmentDashTableViewBinding == null || (recyclerView = fragmentDashTableViewBinding.rvDashTableView) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                DashTableViewFragment.scrollToRelevantPeriod$lambda$3(this.f$0, iIntValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToRelevantPeriod$lambda$3(DashTableViewFragment this$0, int i) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentDashTableViewBinding fragmentDashTableViewBinding = this$0.get_binding();
        if (fragmentDashTableViewBinding == null || (recyclerView = fragmentDashTableViewBinding.rvDashTableView) == null) {
            return;
        }
        recyclerView.scrollToPosition(i);
    }

    private final int parseStartMinutes(String timeRange) {
        try {
            Date date = new SimpleDateFormat("hh:mm a", Locale.getDefault()).parse(normalizeTime(StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) timeRange, new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null).get(0)).toString()));
            if (date == null) {
                return 0;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(12) + (calendar.get(11) * 60);
        } catch (Exception unused) {
            return 0;
        }
    }

    private final String normalizeTime(String time) {
        try {
            String strReplace$default = StringsKt.replace$default(StringsKt.trim((CharSequence) time).toString(), ".", ":", false, 4, (Object) null);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = strReplace$default.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = StringsKt.trim((CharSequence) new Regex("\\s+").replace(StringsKt.replace$default(StringsKt.replace$default(lowerCase, "am", " am", false, 4, (Object) null), "pm", " pm", false, 4, (Object) null), HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR)).toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            Date date = simpleDateFormat.parse(string);
            Intrinsics.checkNotNull(date);
            String str = simpleDateFormat2.format(date);
            Intrinsics.checkNotNullExpressionValue(str, "{\n            var cleane….format(date!!)\n        }");
            return str;
        } catch (Exception unused) {
            return time;
        }
    }

    private final boolean isTimeInRange(String timeRange, int currentMins) {
        Date date;
        try {
            List listSplit$default = StringsKt.split$default((CharSequence) timeRange, new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 2) {
                return false;
            }
            String strNormalizeTime = normalizeTime(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString());
            String strNormalizeTime2 = normalizeTime(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            Date date2 = simpleDateFormat.parse(strNormalizeTime);
            if (date2 == null || (date = simpleDateFormat.parse(strNormalizeTime2)) == null) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            return (calendar.get(11) * 60) + calendar.get(12) <= currentMins && currentMins < (calendar2.get(11) * 60) + calendar2.get(12);
        } catch (Exception unused) {
            return false;
        }
    }

    private final void alertView(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(String.valueOf(message));
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DashTableViewFragment.alertView$lambda$6(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}