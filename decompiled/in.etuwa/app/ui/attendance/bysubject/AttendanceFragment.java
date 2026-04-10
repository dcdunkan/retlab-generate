package in.etuwa.app.ui.attendance.bysubject;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.attendance.Attendance;
import in.etuwa.app.data.model.attendance.AttendanceNew;
import in.etuwa.app.data.model.attendance.AttendanceNewResponse;
import in.etuwa.app.data.model.attendance.AttendancePeriod;
import in.etuwa.app.data.model.attendance.AttendanceResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.AttendanceFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.cleverpumpkin.calendar.adapter.CalendarAdapter;

/* JADX INFO: compiled from: AttendanceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AttendanceFragment extends BaseFragment implements AttendanceCalendarViewAdapter.DayClickListener, AttendanceDayDialog.AttendanceDayListner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AttendanceFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: adapterCal$delegate, reason: from kotlin metadata */
    private final Lazy adapterCal;

    /* JADX INFO: renamed from: attendanceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy attendanceViewModel;
    private ArrayList<AttendanceNew> attendances;
    private LocalDate currentDate;
    private String currentMonth;
    private String currentYear;
    private boolean dutyLeave;
    private boolean flag;
    private Boolean isArts;
    private boolean isLoading;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: compiled from: AttendanceFragment.kt */
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
    public static final AttendanceFragment newInstance(boolean z) {
        return INSTANCE.newInstance(z);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public AttendanceFragment() {
        final AttendanceFragment attendanceFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return attendanceFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(attendanceFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.attendanceViewModel = FragmentViewModelLazyKt.createViewModelLazy(attendanceFragment, Reflection.getOrCreateKotlinClass(AttendanceViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AttendanceViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AttendanceFragment attendanceFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AttendanceAdapter>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.attendance.bysubject.AttendanceAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AttendanceAdapter invoke() {
                ComponentCallbacks componentCallbacks = attendanceFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AttendanceAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = attendanceFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.adapterCal = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<AttendanceCalendarViewAdapter>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AttendanceCalendarViewAdapter invoke() {
                ComponentCallbacks componentCallbacks = attendanceFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AttendanceCalendarViewAdapter.class), b5, b6);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        final byte b8 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = attendanceFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b7, b8);
            }
        });
        this.semId = "";
        this.attendances = new ArrayList<>();
    }

    private final AttendanceViewModel getAttendanceViewModel() {
        return (AttendanceViewModel) this.attendanceViewModel.getValue();
    }

    private final AttendanceAdapter getAdapter() {
        return (AttendanceAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final AttendanceFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    private final AttendanceCalendarViewAdapter getAdapterCal() {
        return (AttendanceCalendarViewAdapter) this.adapterCal.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getSemId() {
        return this.semId;
    }

    public final void setSemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semId = str;
    }

    /* JADX INFO: compiled from: AttendanceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/attendance/bysubject/AttendanceFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/attendance/bysubject/AttendanceFragment;", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AttendanceFragment newInstance(boolean flag) {
            AttendanceFragment attendanceFragment = new AttendanceFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", flag);
            attendanceFragment.setArguments(bundle);
            return attendanceFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.flag = arguments.getBoolean("flag");
        }
        this.semId = getPreference().getUserSemId();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AttendanceFragmentBinding.inflate(inflater, container, false);
        AttendanceFragmentBinding attendanceFragmentBinding = get_binding();
        if (attendanceFragmentBinding != null) {
            attendanceFragmentBinding.setAttendanceViewModel(getAttendanceViewModel());
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = get_binding();
        if (attendanceFragmentBinding2 != null) {
            attendanceFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AttendanceFragmentBinding attendanceFragmentBinding3 = get_binding();
        if (attendanceFragmentBinding3 != null) {
            return attendanceFragmentBinding3.getRoot();
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
        CardView cardView;
        CardView cardView2;
        TextView textView;
        TextView textView2;
        SwipeRefreshLayout swipeRefreshLayout;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.attendance));
        }
        AttendanceFragmentBinding attendanceFragmentBinding = get_binding();
        RecyclerView recyclerView = attendanceFragmentBinding != null ? attendanceFragmentBinding.rvCalender : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapterCal());
        }
        getAdapterCal().setCalendarCallBack2(this);
        hideBaseView();
        AttendanceFragmentBinding attendanceFragmentBinding2 = get_binding();
        RecyclerView recyclerView2 = attendanceFragmentBinding2 != null ? attendanceFragmentBinding2.rvAttendance : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        AttendanceFragmentBinding attendanceFragmentBinding3 = get_binding();
        Spinner spinner = attendanceFragmentBinding3 != null ? attendanceFragmentBinding3.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getPreference().setNewLogin(false);
        LocalDate localDateNow = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(localDateNow, "now()");
        this.currentDate = localDateNow;
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
        listenSemResponse();
        listenResponse();
        listenCalResponse();
        loadSemesterList$default(this, false, 1, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) {
            AttendanceFragmentBinding attendanceFragmentBinding4 = get_binding();
            MaterialCardView materialCardView = attendanceFragmentBinding4 != null ? attendanceFragmentBinding4.segmentView : null;
            if (materialCardView != null) {
                materialCardView.setVisibility(8);
            }
            AttendanceFragmentBinding attendanceFragmentBinding5 = get_binding();
            MaterialCardView materialCardView2 = attendanceFragmentBinding5 != null ? attendanceFragmentBinding5.totalCv : null;
            if (materialCardView2 != null) {
                materialCardView2.setVisibility(0);
            }
        } else {
            AttendanceFragmentBinding attendanceFragmentBinding6 = get_binding();
            MaterialCardView materialCardView3 = attendanceFragmentBinding6 != null ? attendanceFragmentBinding6.segmentView : null;
            if (materialCardView3 != null) {
                materialCardView3.setVisibility(0);
            }
            AttendanceFragmentBinding attendanceFragmentBinding7 = get_binding();
            MaterialCardView materialCardView4 = attendanceFragmentBinding7 != null ? attendanceFragmentBinding7.totalCv : null;
            if (materialCardView4 != null) {
                materialCardView4.setVisibility(8);
            }
        }
        if (this.flag) {
            AttendanceFragmentBinding attendanceFragmentBinding8 = get_binding();
            TextView textView3 = attendanceFragmentBinding8 != null ? attendanceFragmentBinding8.byDayBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            AttendanceFragmentBinding attendanceFragmentBinding9 = get_binding();
            MaterialCardView materialCardView5 = attendanceFragmentBinding9 != null ? attendanceFragmentBinding9.spinnerLt : null;
            if (materialCardView5 != null) {
                materialCardView5.setVisibility(8);
            }
        } else {
            AttendanceFragmentBinding attendanceFragmentBinding10 = get_binding();
            TextView textView4 = attendanceFragmentBinding10 != null ? attendanceFragmentBinding10.byDayBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            AttendanceFragmentBinding attendanceFragmentBinding11 = get_binding();
            MaterialCardView materialCardView6 = attendanceFragmentBinding11 != null ? attendanceFragmentBinding11.spinnerLt : null;
            if (materialCardView6 != null) {
                materialCardView6.setVisibility(0);
            }
        }
        AttendanceFragmentBinding attendanceFragmentBinding12 = get_binding();
        if (attendanceFragmentBinding12 != null && (linearLayout2 = attendanceFragmentBinding12.withoutBtn) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding13 = get_binding();
        if (attendanceFragmentBinding13 != null && (linearLayout = attendanceFragmentBinding13.withBtn) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding14 = get_binding();
        Spinner spinner2 = attendanceFragmentBinding14 != null ? attendanceFragmentBinding14.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment.setUp.4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Spinner spinner3;
                    if (!AttendanceFragment.this.flag) {
                        AttendanceFragment.this.flag = true;
                        int count = AttendanceFragment.this.getSpinnerAdapter().getCount();
                        for (int i = 0; i < count; i++) {
                            if (Intrinsics.areEqual(AttendanceFragment.this.getPreference().getUserSemId(), AttendanceFragment.this.getSpinnerAdapter().getSemester(i).getId())) {
                                AttendanceFragmentBinding attendanceFragmentBinding15 = AttendanceFragment.this.get_binding();
                                if (attendanceFragmentBinding15 == null || (spinner3 = attendanceFragmentBinding15.spinnerSem) == null) {
                                    return;
                                }
                                spinner3.setSelection(i);
                                return;
                            }
                        }
                        return;
                    }
                    String id2 = AttendanceFragment.this.getSpinnerAdapter().getSemester(position).getId();
                    if (Intrinsics.areEqual(id2, AttendanceFragment.this.getSemId())) {
                        return;
                    }
                    AttendanceFragment.this.setSemId(id2);
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(AttendanceFragment.this), null, null, new AttendanceFragment$setUp$4$onItemSelected$1(AttendanceFragment.this, null), 3, null);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding15 = get_binding();
        if (attendanceFragmentBinding15 != null && (swipeRefreshLayout = attendanceFragmentBinding15.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda18
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    AttendanceFragment.setUp$lambda$3(this.f$0);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding16 = get_binding();
        if (attendanceFragmentBinding16 != null && (textView2 = attendanceFragmentBinding16.bySubjectBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda19
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$4(this.f$0, view);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding17 = get_binding();
        if (attendanceFragmentBinding17 != null && (textView = attendanceFragmentBinding17.byDayBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$5(this.f$0, view);
                }
            });
        }
        DateTimeFormatter dateTimeFormatterOfPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        AttendanceFragmentBinding attendanceFragmentBinding18 = get_binding();
        TextView textView5 = attendanceFragmentBinding18 != null ? attendanceFragmentBinding18.monthTv : null;
        if (textView5 != null) {
            LocalDate localDate3 = this.currentDate;
            if (localDate3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                localDate3 = null;
            }
            textView5.setText(localDate3.format(dateTimeFormatterOfPattern3));
        }
        AttendanceFragmentBinding attendanceFragmentBinding19 = get_binding();
        RecyclerView recyclerView3 = attendanceFragmentBinding19 != null ? attendanceFragmentBinding19.rvCalender : null;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        }
        AttendanceFragmentBinding attendanceFragmentBinding20 = get_binding();
        if (attendanceFragmentBinding20 != null && (cardView2 = attendanceFragmentBinding20.nextBtn) != null) {
            cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$6(this.f$0, view);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding21 = get_binding();
        if (attendanceFragmentBinding21 == null || (cardView = attendanceFragmentBinding21.previousBtn) == null) {
            return;
        }
        cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendanceFragment.setUp$lambda$7(this.f$0, view);
            }
        });
    }

    /* JADX INFO: renamed from: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$setUp$1, reason: invalid class name */
    /* JADX INFO: compiled from: AttendanceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$setUp$1", f = "AttendanceFragment.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AttendanceFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (AttendanceFragment.this.isLoading) {
                        return Unit.INSTANCE;
                    }
                    AttendanceFragment.this.isLoading = true;
                    AttendanceFragment.this.loadSubjectAttendance();
                    this.label = 1;
                    if (DelayKt.delay(((long) RangesKt.random(new IntRange(200, 500), Random.INSTANCE)) + ((long) RangesKt.random(new IntRange(0, 300), Random.INSTANCE)), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AttendanceFragment.this.loadCalendarAttendance();
                AttendanceFragment.this.isLoading = false;
                return Unit.INSTANCE;
            } catch (Throwable th) {
                AttendanceFragment.this.isLoading = false;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dutyLeave = false;
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        View view2 = attendanceFragmentBinding != null ? attendanceFragmentBinding.withoutTv : null;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
        View view3 = attendanceFragmentBinding2 != null ? attendanceFragmentBinding2.withTv : null;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        this$0.reloadSubjectFromCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dutyLeave = true;
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        View view2 = attendanceFragmentBinding != null ? attendanceFragmentBinding.withoutTv : null;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
        View view3 = attendanceFragmentBinding2 != null ? attendanceFragmentBinding2.withTv : null;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this$0.reloadSubjectFromCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AttendanceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearAttendanceCache();
        this$0.loadSemesterList(true);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new AttendanceFragment$setUp$5$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AttendanceFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        if (attendanceFragmentBinding != null && (textView4 = attendanceFragmentBinding.bySubjectBtn) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_selected);
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
        if (attendanceFragmentBinding2 != null && (textView3 = attendanceFragmentBinding2.byDayBtn) != null) {
            textView3.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        AttendanceFragmentBinding attendanceFragmentBinding3 = this$0.get_binding();
        if (attendanceFragmentBinding3 != null && (textView2 = attendanceFragmentBinding3.bySubjectBtn) != null) {
            textView2.setTextColor(-1);
        }
        AttendanceFragmentBinding attendanceFragmentBinding4 = this$0.get_binding();
        if (attendanceFragmentBinding4 != null && (textView = attendanceFragmentBinding4.byDayBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        AttendanceFragmentBinding attendanceFragmentBinding5 = this$0.get_binding();
        LinearLayout linearLayout = attendanceFragmentBinding5 != null ? attendanceFragmentBinding5.bySubjectLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        AttendanceFragmentBinding attendanceFragmentBinding6 = this$0.get_binding();
        CardView cardView = attendanceFragmentBinding6 != null ? attendanceFragmentBinding6.atteandceByDayLyt : null;
        if (cardView == null) {
            return;
        }
        cardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(AttendanceFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        if (attendanceFragmentBinding != null && (textView4 = attendanceFragmentBinding.bySubjectBtn) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
        if (attendanceFragmentBinding2 != null && (textView3 = attendanceFragmentBinding2.byDayBtn) != null) {
            textView3.setBackgroundResource(R.drawable.shape_round_selected);
        }
        AttendanceFragmentBinding attendanceFragmentBinding3 = this$0.get_binding();
        if (attendanceFragmentBinding3 != null && (textView2 = attendanceFragmentBinding3.bySubjectBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        AttendanceFragmentBinding attendanceFragmentBinding4 = this$0.get_binding();
        if (attendanceFragmentBinding4 != null && (textView = attendanceFragmentBinding4.byDayBtn) != null) {
            textView.setTextColor(-1);
        }
        AttendanceFragmentBinding attendanceFragmentBinding5 = this$0.get_binding();
        LinearLayout linearLayout = attendanceFragmentBinding5 != null ? attendanceFragmentBinding5.bySubjectLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        AttendanceFragmentBinding attendanceFragmentBinding6 = this$0.get_binding();
        CardView cardView = attendanceFragmentBinding6 != null ? attendanceFragmentBinding6.atteandceByDayLyt : null;
        if (cardView == null) {
            return;
        }
        cardView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(AttendanceFragment this$0, View view) {
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
    public static final void setUp$lambda$7(AttendanceFragment this$0, View view) {
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

    static /* synthetic */ void loadSemesterList$default(AttendanceFragment attendanceFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        attendanceFragment.loadSemesterList(z);
    }

    private final void loadSemesterList(boolean forceRefresh) {
        if (!forceRefresh) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            if (isSemesterCached(contextRequireContext)) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                if (!isSemesterCacheExpired(contextRequireContext2)) {
                    Context contextRequireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                    ArrayList<Semester> savedSemesterList = getSavedSemesterList(contextRequireContext3);
                    if (savedSemesterList != null) {
                        getSpinnerAdapter().addItems(savedSemesterList);
                        return;
                    }
                    return;
                }
            }
        }
        getAttendanceViewModel().getSemester();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadSubjectAttendance() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (isAttendanceSubjectCacheValid(contextRequireContext, this.semId)) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            AttendanceResponse attendanceSubjectCache = getAttendanceSubjectCache(contextRequireContext2, this.semId);
            if (attendanceSubjectCache != null) {
                handleAttendanceResponse(attendanceSubjectCache);
                showBaseView();
                return;
            }
            return;
        }
        getAttendanceViewModel().getAttendance(this.semId);
    }

    private final void reloadSubjectFromCache() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (isAttendanceSubjectCacheValid(contextRequireContext, this.semId)) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            AttendanceResponse attendanceSubjectCache = getAttendanceSubjectCache(contextRequireContext2, this.semId);
            if (attendanceSubjectCache != null) {
                handleAttendanceResponse(attendanceSubjectCache);
                showBaseView();
                return;
            }
            return;
        }
        getAttendanceViewModel().getAttendance(this.semId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadCalendarAttendance() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String str = this.semId;
        String str2 = this.currentYear;
        Intrinsics.checkNotNull(str2);
        String str3 = this.currentMonth;
        Intrinsics.checkNotNull(str3);
        if (isAttendanceCalendarCacheValid(contextRequireContext, str, str2, str3)) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            String str4 = this.semId;
            String str5 = this.currentYear;
            Intrinsics.checkNotNull(str5);
            String str6 = this.currentMonth;
            Intrinsics.checkNotNull(str6);
            AttendanceNewResponse attendanceCalendarCache = getAttendanceCalendarCache(contextRequireContext2, str4, str5, str6);
            if (attendanceCalendarCache != null) {
                handleCalendarResponse(attendanceCalendarCache);
                return;
            }
            return;
        }
        AttendanceViewModel attendanceViewModel = getAttendanceViewModel();
        String str7 = this.semId;
        String str8 = this.currentYear;
        Intrinsics.checkNotNull(str8);
        String str9 = this.currentMonth;
        Intrinsics.checkNotNull(str9);
        attendanceViewModel.getAttendanceByDay(str7, str8, str9);
    }

    private final void clearAttendanceCache() {
        requireContext().getSharedPreferences("attendance_cache", 0).edit().clear().apply();
    }

    private final void listenSemResponse() {
        getAttendanceViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceFragment.listenSemResponse$lambda$13(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$13(AttendanceFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
                if ((attendanceFragmentBinding == null || (swipeRefreshLayout2 = attendanceFragmentBinding.swipeLayout) == null || swipeRefreshLayout2.isRefreshing()) ? false : true) {
                    this$0.showProgress();
                    return;
                }
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
            if (attendanceFragmentBinding2 == null || (recyclerView = attendanceFragmentBinding2.rvAttendance) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            this$0.saveSemesterList(contextRequireContext, arrayList);
            AttendanceFragmentBinding attendanceFragmentBinding3 = this$0.get_binding();
            if ((attendanceFragmentBinding3 == null || (swipeRefreshLayout = attendanceFragmentBinding3.swipeLayout) == null || !swipeRefreshLayout.isRefreshing()) ? false : true) {
                AttendanceFragmentBinding attendanceFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = attendanceFragmentBinding4 != null ? attendanceFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        AttendanceFragmentBinding attendanceFragmentBinding5 = this$0.get_binding();
                        if (attendanceFragmentBinding5 == null || (spinner = attendanceFragmentBinding5.spinnerSem) == null) {
                            return;
                        }
                        spinner.setSelection(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void listenResponse() {
        getAttendanceViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceFragment.listenResponse$lambda$15(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$15(AttendanceFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            AttendanceResponse attendanceResponse = (AttendanceResponse) resource.getData();
            if (attendanceResponse != null) {
                this$0.showBaseView();
                try {
                    if (attendanceResponse.getLogin()) {
                        Context contextRequireContext = this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        this$0.saveAttendanceSubjectCache(contextRequireContext, attendanceResponse, this$0.semId);
                        this$0.handleAttendanceResponse(attendanceResponse);
                        return;
                    }
                    return;
                } catch (NullPointerException unused) {
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        if (attendanceFragmentBinding == null || (recyclerView = attendanceFragmentBinding.rvAttendance) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenCalResponse() {
        getAttendanceViewModel().getCalendarResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceFragment.listenCalResponse$lambda$17(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenCalResponse$lambda$17(AttendanceFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            AttendanceNewResponse attendanceNewResponse = (AttendanceNewResponse) resource.getData();
            if (attendanceNewResponse != null) {
                Context contextRequireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                String str = this$0.semId;
                String str2 = this$0.currentYear;
                Intrinsics.checkNotNull(str2);
                String str3 = this$0.currentMonth;
                Intrinsics.checkNotNull(str3);
                this$0.saveAttendanceCalendarCache(contextRequireContext, attendanceNewResponse, str, str2, str3);
                this$0.handleCalendarResponse(attendanceNewResponse);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        if (attendanceFragmentBinding == null || (recyclerView = attendanceFragmentBinding.rvCalender) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void handleAttendanceResponse(AttendanceResponse response) {
        CircleProgressView circleProgressView;
        try {
            if (response.getLogin()) {
                this.isArts = Boolean.valueOf(StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null));
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) {
                    AttendanceAdapter adapter = getAdapter();
                    ArrayList<Attendance> subjects = response.getSubjects();
                    boolean z = this.dutyLeave;
                    Boolean bool = this.isArts;
                    Intrinsics.checkNotNull(bool);
                    adapter.addItems(subjects, z, true, bool.booleanValue());
                    AttendanceFragmentBinding attendanceFragmentBinding = get_binding();
                    TextView textView = attendanceFragmentBinding != null ? attendanceFragmentBinding.attendanceByTotal : null;
                    if (textView != null) {
                        textView.setText(response.getTotal_credit());
                    }
                    float f = Intrinsics.areEqual(response.getTotal_percent(), "N/A") ? 0.0f : Float.parseFloat(StringsKt.replace$default(response.getTotal_percent(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null));
                    AttendanceFragmentBinding attendanceFragmentBinding2 = get_binding();
                    if (attendanceFragmentBinding2 == null || (circleProgressView = attendanceFragmentBinding2.attendanceByPer) == null) {
                        return;
                    }
                    circleProgressView.setValueAnimated(f);
                    return;
                }
                AttendanceAdapter adapter2 = getAdapter();
                ArrayList<Attendance> subjects2 = response.getSubjects();
                boolean z2 = this.dutyLeave;
                Boolean bool2 = this.isArts;
                Intrinsics.checkNotNull(bool2);
                adapter2.addItems(subjects2, z2, false, bool2.booleanValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void handleCalendarResponse(AttendanceNewResponse response) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            LocalDate localDate = this.currentDate;
            LocalDate localDate2 = null;
            if (localDate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                localDate = null;
            }
            int year = localDate.getYear();
            LocalDate localDate3 = this.currentDate;
            if (localDate3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                localDate3 = null;
            }
            YearMonth yearMonthOf = YearMonth.of(year, localDate3.getMonth());
            LocalDate localDate4 = this.currentDate;
            if (localDate4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            } else {
                localDate2 = localDate4;
            }
            int i = 1;
            int i2 = 7;
            int value = localDate2.withDayOfMonth(1).getDayOfWeek().getValue() % 7;
            if (value != 0) {
                i2 = value;
            }
            for (int i3 = 1; i3 < i2; i3++) {
                arrayList.add("");
                arrayList2.add("");
                arrayList3.add("");
                arrayList4.add("");
                arrayList5.add(0);
                arrayList6.add(false);
            }
            int iLengthOfMonth = yearMonthOf.lengthOfMonth();
            if (1 <= iLengthOfMonth) {
                while (true) {
                    arrayList.add(String.valueOf(i));
                    if (i == iLengthOfMonth) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            for (AttendanceNew attendanceNew : response.getAttends()) {
                Iterator<AttendancePeriod> it = attendanceNew.getPeriods().iterator();
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (it.hasNext()) {
                    String lowerCase = it.next().getAttendance().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    int iHashCode = lowerCase.hashCode();
                    if (iHashCode != -1423908039) {
                        if (iHashCode != -318277445) {
                            if (iHashCode == 107264) {
                                if (lowerCase.equals("n/a")) {
                                    i6++;
                                }
                            }
                        } else if (lowerCase.equals("present")) {
                            i4++;
                        }
                    } else if (lowerCase.equals("absent")) {
                        i5++;
                    }
                }
                arrayList2.add(String.valueOf(i4));
                arrayList3.add(String.valueOf(i5));
                arrayList4.add(String.valueOf(i6));
                arrayList5.add(Integer.valueOf(attendanceNew.getTotalperiod()));
                arrayList6.add(Boolean.valueOf(attendanceNew.getHoliday()));
            }
            getAdapterCal().addItems(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void updateMonthYearDisplay() {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter dateTimeFormatterOfPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate = this.currentDate;
        LocalDate localDate2 = null;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        this.currentMonth = localDate.format(dateTimeFormatterOfPattern);
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        this.currentYear = localDate3.format(dateTimeFormatterOfPattern2);
        DateTimeFormatter dateTimeFormatterOfPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        AttendanceFragmentBinding attendanceFragmentBinding = get_binding();
        TextView textView = attendanceFragmentBinding != null ? attendanceFragmentBinding.monthTv : null;
        if (textView != null) {
            LocalDate localDate4 = this.currentDate;
            if (localDate4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            } else {
                localDate2 = localDate4;
            }
            textView.setText(localDate2.format(dateTimeFormatterOfPattern3));
        }
        loadCalendarAttendance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        AttendanceFragmentBinding attendanceFragmentBinding = get_binding();
        if (attendanceFragmentBinding == null || (recyclerView = attendanceFragmentBinding.rvAttendance) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        AttendanceFragmentBinding attendanceFragmentBinding = get_binding();
        if (attendanceFragmentBinding == null || (recyclerView = attendanceFragmentBinding.rvAttendance) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
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
        String str = this.currentYear + HelpFormatter.DEFAULT_OPT_PREFIX + this.currentMonth + HelpFormatter.DEFAULT_OPT_PREFIX + strPadStart;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AttendanceDayDialog attendanceDayDialogNewInstance = AttendanceDayDialog.INSTANCE.newInstance(str, this.semId);
        attendanceDayDialogNewInstance.setCalendarCallBack2(this);
        attendanceDayDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog.AttendanceDayListner
    public void dismiss() {
        AttendanceViewModel attendanceViewModel = getAttendanceViewModel();
        String str = this.semId;
        String str2 = this.currentYear;
        Intrinsics.checkNotNull(str2);
        String str3 = this.currentMonth;
        Intrinsics.checkNotNull(str3);
        attendanceViewModel.getAttendanceByDay(str, str2, str3);
    }

    private final void saveSemesterList(Context context, ArrayList<Semester> semesterList) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app_prefs", 0).edit();
        editorEdit.putString("semester_list", new Gson().toJson(semesterList));
        editorEdit.putLong("semester_cache_time", System.currentTimeMillis());
        editorEdit.apply();
    }

    private final boolean isSemesterCached(Context context) {
        return context.getSharedPreferences("app_prefs", 0).contains("semester_list");
    }

    private final ArrayList<Semester> getSavedSemesterList(Context context) {
        return (ArrayList) new Gson().fromJson(context.getSharedPreferences("app_prefs", 0).getString("semester_list", null), new TypeToken<ArrayList<Semester>>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$getSavedSemesterList$type$1
        }.getType());
    }

    private final boolean isSemesterCacheExpired(Context context) {
        long j = context.getSharedPreferences("app_prefs", 0).getLong("semester_cache_time", 0L);
        return j == 0 || (System.currentTimeMillis() - j) / ((long) 86400000) >= 30;
    }

    public final void saveAttendanceSubjectCache(Context context, AttendanceResponse data, String semId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(semId, "semId");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("attendance_cache", 0).edit();
        editorEdit.putString("subject_" + semId, new Gson().toJson(data));
        editorEdit.putLong("subject_time_" + semId, System.currentTimeMillis());
        editorEdit.apply();
    }

    public final AttendanceResponse getAttendanceSubjectCache(Context context, String semId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(semId, "semId");
        String string = context.getSharedPreferences("attendance_cache", 0).getString("subject_" + semId, null);
        if (string != null) {
            return (AttendanceResponse) new Gson().fromJson(string, AttendanceResponse.class);
        }
        return null;
    }

    public final boolean isAttendanceSubjectCacheValid(Context context, String semId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(semId, "semId");
        return CacheUtils.INSTANCE.isCacheValidForDuration(context.getSharedPreferences("attendance_cache", 0).getLong("subject_time_" + semId, 0L), 3600000L);
    }

    private final void saveAttendanceCalendarCache(Context context, AttendanceNewResponse data, String semId, String year, String month) {
        String str = "calendar_" + semId + "_" + year + "_" + month;
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("attendance_cache", 0).edit();
        editorEdit.putString(str, new Gson().toJson(data));
        editorEdit.putLong(str + "_time", System.currentTimeMillis());
        editorEdit.apply();
    }

    private final AttendanceNewResponse getAttendanceCalendarCache(Context context, String semId, String year, String month) {
        String string = context.getSharedPreferences("attendance_cache", 0).getString("calendar_" + semId + "_" + year + "_" + month, null);
        if (string != null) {
            return (AttendanceNewResponse) new Gson().fromJson(string, AttendanceNewResponse.class);
        }
        return null;
    }

    private final boolean isAttendanceCalendarCacheValid(Context context, String semId, String year, String month) {
        String str = "calendar_" + semId + "_" + year + "_" + month;
        return CacheUtils.INSTANCE.isCacheValidForDuration(context.getSharedPreferences("attendance_cache", 0).getLong(str + "_time", 0L), 3600000L);
    }
}