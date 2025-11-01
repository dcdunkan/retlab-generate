package in.etuwa.app.ui.hostel.attendance;

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
import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.FragmentHostelAttendanceBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.Lazy;
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

/* compiled from: HostelAttendanceFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u001a\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010.\u001a\u00020\u001bH\u0014J\b\u0010/\u001a\u00020\u001bH\u0014J\b\u00100\u001a\u00020\u001bH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveDialog$ApplyLeaveCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentHostelAttendanceBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentHostelAttendanceBinding;", "calendar", "Ljava/util/Calendar;", "eventList", "Ljava/util/ArrayList;", "Lcom/applandeo/materialcalendarview/EventDay;", "getEventList", "()Ljava/util/ArrayList;", "setEventList", "(Ljava/util/ArrayList;)V", "hostelAttendanceViewModel", "Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceViewModel;", "getHostelAttendanceViewModel", "()Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceViewModel;", "hostelAttendanceViewModel$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "hideBaseView", "", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelAttendanceFragment extends BaseFragment implements HostelApplyLeaveDialog.ApplyLeaveCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelAttendanceBinding _binding;
    private Calendar calendar;
    private ArrayList<EventDay> eventList;

    /* renamed from: hostelAttendanceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelAttendanceViewModel;
    private MainCallBackListener listener;

    /* compiled from: HostelAttendanceFragment.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelAttendanceViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.eventList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HostelAttendanceViewModel getHostelAttendanceViewModel() {
        return (HostelAttendanceViewModel) this.hostelAttendanceViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentHostelAttendanceBinding get_binding() {
        return this._binding;
    }

    public final ArrayList<EventDay> getEventList() {
        return this.eventList;
    }

    public final void setEventList(ArrayList<EventDay> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.eventList = arrayList;
    }

    /* compiled from: HostelAttendanceFragment.kt */
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
        CalendarView calendarView;
        CalendarView calendarView2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Attendance");
        }
        hideBaseView();
        listenResponse();
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.calendar = calendar;
        HostelAttendanceViewModel hostelAttendanceViewModel = getHostelAttendanceViewModel();
        Calendar calendar2 = this.calendar;
        Calendar calendar3 = null;
        if (calendar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar2 = null;
        }
        String valueOf = String.valueOf(calendar2.get(2) + 1);
        Calendar calendar4 = this.calendar;
        if (calendar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
        } else {
            calendar3 = calendar4;
        }
        hostelAttendanceViewModel.getHostelAttCalView(valueOf, String.valueOf(calendar3.get(1)));
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding = get_binding();
        if (fragmentHostelAttendanceBinding != null && (calendarView2 = fragmentHostelAttendanceBinding.attendanceView) != null) {
            calendarView2.setOnForwardPageChangeListener(new OnCalendarPageChangeListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$setUp$1
                @Override // com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener
                public void onChange() {
                    FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding2;
                    HostelAttendanceViewModel hostelAttendanceViewModel2;
                    FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding3;
                    FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding4;
                    CalendarView calendarView3;
                    Calendar currentPageDate;
                    CalendarView calendarView4;
                    Calendar currentPageDate2;
                    CalendarView calendarView5;
                    Calendar currentPageDate3;
                    fragmentHostelAttendanceBinding2 = HostelAttendanceFragment.this.get_binding();
                    Integer num = null;
                    System.out.println((fragmentHostelAttendanceBinding2 == null || (calendarView5 = fragmentHostelAttendanceBinding2.attendanceView) == null || (currentPageDate3 = calendarView5.getCurrentPageDate()) == null) ? null : Integer.valueOf(currentPageDate3.get(2) + 1));
                    hostelAttendanceViewModel2 = HostelAttendanceFragment.this.getHostelAttendanceViewModel();
                    fragmentHostelAttendanceBinding3 = HostelAttendanceFragment.this.get_binding();
                    String valueOf2 = String.valueOf((fragmentHostelAttendanceBinding3 == null || (calendarView4 = fragmentHostelAttendanceBinding3.attendanceView) == null || (currentPageDate2 = calendarView4.getCurrentPageDate()) == null) ? null : Integer.valueOf(currentPageDate2.get(2) + 1));
                    fragmentHostelAttendanceBinding4 = HostelAttendanceFragment.this.get_binding();
                    if (fragmentHostelAttendanceBinding4 != null && (calendarView3 = fragmentHostelAttendanceBinding4.attendanceView) != null && (currentPageDate = calendarView3.getCurrentPageDate()) != null) {
                        num = Integer.valueOf(currentPageDate.get(1));
                    }
                    hostelAttendanceViewModel2.getHostelAttCalView(valueOf2, String.valueOf(num));
                }
            });
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding2 = get_binding();
        if (fragmentHostelAttendanceBinding2 != null && (calendarView = fragmentHostelAttendanceBinding2.attendanceView) != null) {
            calendarView.setOnPreviousPageChangeListener(new OnCalendarPageChangeListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$setUp$2
                @Override // com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener
                public void onChange() {
                    HostelAttendanceViewModel hostelAttendanceViewModel2;
                    FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding3;
                    FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding4;
                    CalendarView calendarView3;
                    Calendar currentPageDate;
                    CalendarView calendarView4;
                    Calendar currentPageDate2;
                    hostelAttendanceViewModel2 = HostelAttendanceFragment.this.getHostelAttendanceViewModel();
                    fragmentHostelAttendanceBinding3 = HostelAttendanceFragment.this.get_binding();
                    Integer num = null;
                    String valueOf2 = String.valueOf((fragmentHostelAttendanceBinding3 == null || (calendarView4 = fragmentHostelAttendanceBinding3.attendanceView) == null || (currentPageDate2 = calendarView4.getCurrentPageDate()) == null) ? null : Integer.valueOf(currentPageDate2.get(2) + 1));
                    fragmentHostelAttendanceBinding4 = HostelAttendanceFragment.this.get_binding();
                    if (fragmentHostelAttendanceBinding4 != null && (calendarView3 = fragmentHostelAttendanceBinding4.attendanceView) != null && (currentPageDate = calendarView3.getCurrentPageDate()) != null) {
                        num = Integer.valueOf(currentPageDate.get(1));
                    }
                    hostelAttendanceViewModel2.getHostelAttCalView(valueOf2, String.valueOf(num));
                }
            });
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding3 = get_binding();
        if (fragmentHostelAttendanceBinding3 != null && (textView2 = fragmentHostelAttendanceBinding3.btnView) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelAttendanceFragment.setUp$lambda$1(HostelAttendanceFragment.this, view);
                }
            });
        }
        FragmentHostelAttendanceBinding fragmentHostelAttendanceBinding4 = get_binding();
        if (fragmentHostelAttendanceBinding4 == null || (textView = fragmentHostelAttendanceBinding4.btnApply) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelAttendanceFragment.setUp$lambda$2(HostelAttendanceFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HostelAttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onHostelAttViewClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(HostelAttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelApplyLeaveDialog newInstance = HostelApplyLeaveDialog.INSTANCE.newInstance();
        newInstance.setApplyLeaveCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getHostelAttendanceViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceFragment.listenResponse$lambda$4(HostelAttendanceFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0207 A[LOOP:0: B:29:0x006b->B:41:0x0207, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x020b A[EDGE_INSN: B:42:0x020b->B:81:0x020b BREAK  A[LOOP:0: B:29:0x006b->B:41:0x0207], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void listenResponse$lambda$4(in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment r13, in.etuwa.app.utils.Resource r14) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment.listenResponse$lambda$4(in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment, in.etuwa.app.utils.Resource):void");
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