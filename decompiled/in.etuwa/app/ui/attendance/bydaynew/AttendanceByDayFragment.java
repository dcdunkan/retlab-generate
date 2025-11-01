package in.etuwa.app.ui.attendance.bydaynew;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.applandeo.materialcalendarview.EventDay;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.attendance.AttendanceNew;
import in.etuwa.app.data.model.attendance.AttendanceNewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentAttendanceByDayBinding;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
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
import ru.cleverpumpkin.calendar.CalendarView;

/* compiled from: AttendanceByDayFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0014J\b\u0010.\u001a\u00020,H\u0014J\b\u0010/\u001a\u00020,H\u0003J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u00020,2\u0006\u00109\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0016\u0010:\u001a\u00020,2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u0015J\b\u0010<\u001a\u00020,H\u0014J\b\u0010=\u001a\u00020,H\u0014J\b\u0010>\u001a\u00020,H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019¨\u0006@"}, d2 = {"Lin/etuwa/app/ui/attendance/bydaynew/AttendanceByDayFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/attendance/bydaynew/attendaceday/AttendanceDayDialog$AttendanceDayListner;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentAttendanceByDayBinding;", "attendanceByDayViewModel", "Lin/etuwa/app/ui/attendance/bydaynew/AttendanceByDayViewModel;", "getAttendanceByDayViewModel", "()Lin/etuwa/app/ui/attendance/bydaynew/AttendanceByDayViewModel;", "attendanceByDayViewModel$delegate", "Lkotlin/Lazy;", "attendances", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/attendance/AttendanceNew;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentAttendanceByDayBinding;", "calendar", "Ljava/util/Calendar;", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "eventList", "Lcom/applandeo/materialcalendarview/EventDay;", "getEventList", "()Ljava/util/ArrayList;", "setEventList", "(Ljava/util/ArrayList;)V", "indicators", "", "Lru/cleverpumpkin/calendar/CalendarView$DateIndicator;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "semid", "getSemid", "setSemid", "dismiss", "", "hideBaseView", "hideProgress", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", SvgConstants.Tags.VIEW, "remind", AttendanceDayDialogKt.ARG_SEM, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttendanceByDayFragment extends BaseFragment implements AttendanceDayDialog.AttendanceDayListner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentAttendanceByDayBinding _binding;

    /* renamed from: attendanceByDayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy attendanceByDayViewModel;
    private ArrayList<AttendanceNew> attendances;
    private Calendar calendar;
    private String date;
    private ArrayList<EventDay> eventList;
    private final List<CalendarView.DateIndicator> indicators;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semid;

    /* compiled from: AttendanceByDayFragment.kt */
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
    public static final AttendanceByDayFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public AttendanceByDayFragment() {
        final AttendanceByDayFragment attendanceByDayFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(attendanceByDayFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.attendanceByDayViewModel = FragmentViewModelLazyKt.createViewModelLazy(attendanceByDayFragment, Reflection.getOrCreateKotlinClass(AttendanceByDayViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AttendanceByDayViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.indicators = new ArrayList();
        this.attendances = new ArrayList<>();
        this.eventList = new ArrayList<>();
        this.date = "";
        this.semid = "";
        final AttendanceByDayFragment attendanceByDayFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = attendanceByDayFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final AttendanceByDayViewModel getAttendanceByDayViewModel() {
        return (AttendanceByDayViewModel) this.attendanceByDayViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentAttendanceByDayBinding get_binding() {
        return this._binding;
    }

    public final ArrayList<EventDay> getEventList() {
        return this.eventList;
    }

    public final void setEventList(ArrayList<EventDay> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.eventList = arrayList;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getSemid() {
        return this.semid;
    }

    public final void setSemid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semid = str;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: AttendanceByDayFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/attendance/bydaynew/AttendanceByDayFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/attendance/bydaynew/AttendanceByDayFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AttendanceByDayFragment newInstance() {
            return new AttendanceByDayFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentAttendanceByDayBinding.inflate(inflater, container, false);
        FragmentAttendanceByDayBinding fragmentAttendanceByDayBinding = get_binding();
        if (fragmentAttendanceByDayBinding != null) {
            fragmentAttendanceByDayBinding.setAttendanceByDayViewModel(getAttendanceByDayViewModel());
        }
        FragmentAttendanceByDayBinding fragmentAttendanceByDayBinding2 = get_binding();
        if (fragmentAttendanceByDayBinding2 != null) {
            fragmentAttendanceByDayBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentAttendanceByDayBinding fragmentAttendanceByDayBinding3 = get_binding();
        if (fragmentAttendanceByDayBinding3 != null) {
            return fragmentAttendanceByDayBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.attendance));
        }
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.calendar = calendar;
        showBaseView();
        listenResponse();
        getPreference().setNewLogin(false);
        System.out.println((Object) ("=======newattendance============" + this.attendances));
        String userSemId = getPreference().getUserSemId();
        this.semid = userSemId;
        System.out.println((Object) userSemId);
        AttendanceByDayViewModel attendanceByDayViewModel = getAttendanceByDayViewModel();
        String str = this.semid;
        Calendar calendar2 = this.calendar;
        Calendar calendar3 = null;
        if (calendar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar2 = null;
        }
        String valueOf = String.valueOf(calendar2.get(1));
        Calendar calendar4 = this.calendar;
        if (calendar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
        } else {
            calendar3 = calendar4;
        }
        attendanceByDayViewModel.getAttendanceByDay(str, valueOf, String.valueOf(calendar3.get(2) + 1));
    }

    private final void listenResponse() {
        getAttendanceByDayViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceByDayFragment.listenResponse$lambda$2(AttendanceByDayFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(AttendanceByDayFragment this$0, Resource resource) {
        android.widget.CalendarView calendarView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            FragmentAttendanceByDayBinding fragmentAttendanceByDayBinding = this$0.get_binding();
            if (fragmentAttendanceByDayBinding == null || (calendarView = fragmentAttendanceByDayBinding.attendanceView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(calendarView, message);
            Unit unit = Unit.INSTANCE;
            return;
        }
        this$0.hideProgress();
        AttendanceNewResponse attendanceNewResponse = (AttendanceNewResponse) resource.getData();
        if (attendanceNewResponse != null) {
            this$0.showBaseView();
            ArrayList<AttendanceNew> attends = attendanceNewResponse.getAttends();
            this$0.attendances = attends;
            for (AttendanceNew attendanceNew : attends) {
                Calendar calendar = Calendar.getInstance();
                Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
                this$0.calendar = calendar;
                List split$default = StringsKt.split$default((CharSequence) attendanceNew.getDate(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
                Calendar calendar2 = this$0.calendar;
                Calendar calendar3 = null;
                if (calendar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("calendar");
                    calendar2 = null;
                }
                int i2 = 0;
                calendar2.set(Integer.parseInt(StringsKt.trim((CharSequence) split$default.get(0)).toString()), Integer.parseInt(StringsKt.trim((CharSequence) split$default.get(1)).toString()) - 1, Integer.parseInt(StringsKt.trim((CharSequence) split$default.get(2)).toString()));
                int totalperiod = attendanceNew.getTotalperiod() - 1;
                int i3 = 0;
                int i4 = 0;
                if (totalperiod >= 0) {
                    int i5 = 0;
                    while (true) {
                        if (Intrinsics.areEqual(attendanceNew.getPeriods().get(i2).getAttendance(), "present")) {
                            i3++;
                        } else {
                            String lowerCase = attendanceNew.getPeriods().get(i2).getAttendance().toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (Intrinsics.areEqual(lowerCase, "n/a")) {
                                i4++;
                            } else if (Intrinsics.areEqual(attendanceNew.getPeriods().get(i2).getAttendance(), "absent")) {
                                i5++;
                            }
                        }
                        if (i2 == totalperiod) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    i2 = i5;
                }
                System.out.println((Object) ("================" + i2 + "===============" + i3 + "======="));
                if (i3 != 0 || i2 != 0) {
                    if (i3 == 0 && i2 == 1) {
                        int i6 = R.drawable.greenzeroredone;
                        ArrayList<EventDay> arrayList = this$0.eventList;
                        Calendar calendar4 = this$0.calendar;
                        if (calendar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar4 = null;
                        }
                        arrayList.add(new EventDay(calendar4, i6));
                    } else if (i3 == 0 && i2 == 2) {
                        int i7 = R.drawable.greenzeroredtwo;
                        ArrayList<EventDay> arrayList2 = this$0.eventList;
                        Calendar calendar5 = this$0.calendar;
                        if (calendar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar5 = null;
                        }
                        arrayList2.add(new EventDay(calendar5, i7));
                    } else if (i3 == 0 && i2 == 3) {
                        int i8 = R.drawable.greenzeroredthree;
                        ArrayList<EventDay> arrayList3 = this$0.eventList;
                        Calendar calendar6 = this$0.calendar;
                        if (calendar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar6 = null;
                        }
                        arrayList3.add(new EventDay(calendar6, i8));
                    } else if (i3 == 0 && i2 == 4) {
                        int i9 = R.drawable.greenzeroredfour;
                        ArrayList<EventDay> arrayList4 = this$0.eventList;
                        Calendar calendar7 = this$0.calendar;
                        if (calendar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar7 = null;
                        }
                        arrayList4.add(new EventDay(calendar7, i9));
                    } else if (i3 == 0 && i2 == 5) {
                        int i10 = R.drawable.greenzeroredfive;
                        ArrayList<EventDay> arrayList5 = this$0.eventList;
                        Calendar calendar8 = this$0.calendar;
                        if (calendar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar8 = null;
                        }
                        arrayList5.add(new EventDay(calendar8, i10));
                    } else if (i3 == 0 && i2 == 6 && attendanceNew.getTotalperiod() == 6) {
                        int i11 = R.drawable.ic_present;
                        ArrayList<EventDay> arrayList6 = this$0.eventList;
                        Calendar calendar9 = this$0.calendar;
                        if (calendar9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar9 = null;
                        }
                        arrayList6.add(new EventDay(calendar9, i11));
                    } else if (i3 == 0 && i2 == 6) {
                        int i12 = R.drawable.greenzeroredsix;
                        ArrayList<EventDay> arrayList7 = this$0.eventList;
                        Calendar calendar10 = this$0.calendar;
                        if (calendar10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar10 = null;
                        }
                        arrayList7.add(new EventDay(calendar10, i12));
                    } else if (i3 == 0 && i2 == 7 && attendanceNew.getTotalperiod() == 7) {
                        int i13 = R.drawable.ic_present;
                        ArrayList<EventDay> arrayList8 = this$0.eventList;
                        Calendar calendar11 = this$0.calendar;
                        if (calendar11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar11 = null;
                        }
                        arrayList8.add(new EventDay(calendar11, i13));
                    } else if (i3 == 0 && i2 == 7) {
                        int i14 = R.drawable.greenzeroredseven;
                        ArrayList<EventDay> arrayList9 = this$0.eventList;
                        Calendar calendar12 = this$0.calendar;
                        if (calendar12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar12 = null;
                        }
                        arrayList9.add(new EventDay(calendar12, i14));
                    } else if (i3 == 1 && i2 == 0) {
                        int i15 = R.drawable.ic_one;
                        ArrayList<EventDay> arrayList10 = this$0.eventList;
                        Calendar calendar13 = this$0.calendar;
                        if (calendar13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar13 = null;
                        }
                        arrayList10.add(new EventDay(calendar13, i15));
                    } else if (i3 == 1 && i2 == 1) {
                        int i16 = R.drawable.greenoneredone;
                        ArrayList<EventDay> arrayList11 = this$0.eventList;
                        Calendar calendar14 = this$0.calendar;
                        if (calendar14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar14 = null;
                        }
                        arrayList11.add(new EventDay(calendar14, i16));
                    } else if (i3 == 1 && i2 == 2) {
                        int i17 = R.drawable.greenoneredtwo;
                        ArrayList<EventDay> arrayList12 = this$0.eventList;
                        Calendar calendar15 = this$0.calendar;
                        if (calendar15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar15 = null;
                        }
                        arrayList12.add(new EventDay(calendar15, i17));
                    } else if (i3 == 1 && i2 == 3) {
                        int i18 = R.drawable.greenoneredthree;
                        ArrayList<EventDay> arrayList13 = this$0.eventList;
                        Calendar calendar16 = this$0.calendar;
                        if (calendar16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar16 = null;
                        }
                        arrayList13.add(new EventDay(calendar16, i18));
                    } else if (i3 == 1 && i2 == 4) {
                        int i19 = R.drawable.greenoneredfour;
                        ArrayList<EventDay> arrayList14 = this$0.eventList;
                        Calendar calendar17 = this$0.calendar;
                        if (calendar17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar17 = null;
                        }
                        arrayList14.add(new EventDay(calendar17, i19));
                    } else if (i3 == 1 && i2 == 5) {
                        int i20 = R.drawable.greenoneredfive;
                        ArrayList<EventDay> arrayList15 = this$0.eventList;
                        Calendar calendar18 = this$0.calendar;
                        if (calendar18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar18 = null;
                        }
                        arrayList15.add(new EventDay(calendar18, i20));
                    } else if (i3 == 1 && i2 == 6) {
                        int i21 = R.drawable.greenoneredsix;
                        ArrayList<EventDay> arrayList16 = this$0.eventList;
                        Calendar calendar19 = this$0.calendar;
                        if (calendar19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar19 = null;
                        }
                        arrayList16.add(new EventDay(calendar19, i21));
                    } else if (i3 == 1 && i2 == 7) {
                        int i22 = R.drawable.greenoneredseven;
                        ArrayList<EventDay> arrayList17 = this$0.eventList;
                        Calendar calendar20 = this$0.calendar;
                        if (calendar20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar20 = null;
                        }
                        arrayList17.add(new EventDay(calendar20, i22));
                    } else if (i3 == 2 && i2 == 0) {
                        int i23 = R.drawable.ic_two;
                        ArrayList<EventDay> arrayList18 = this$0.eventList;
                        Calendar calendar21 = this$0.calendar;
                        if (calendar21 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar21 = null;
                        }
                        arrayList18.add(new EventDay(calendar21, i23));
                    } else if (i3 == 2 && i2 == 1) {
                        int i24 = R.drawable.greentworedone;
                        ArrayList<EventDay> arrayList19 = this$0.eventList;
                        Calendar calendar22 = this$0.calendar;
                        if (calendar22 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar22 = null;
                        }
                        arrayList19.add(new EventDay(calendar22, i24));
                    } else if (i3 == 2 && i2 == 2) {
                        int i25 = R.drawable.greentworedtwo;
                        ArrayList<EventDay> arrayList20 = this$0.eventList;
                        Calendar calendar23 = this$0.calendar;
                        if (calendar23 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar23 = null;
                        }
                        arrayList20.add(new EventDay(calendar23, i25));
                    } else if (i3 == 2 && i2 == 3) {
                        int i26 = R.drawable.greentworedthree;
                        ArrayList<EventDay> arrayList21 = this$0.eventList;
                        Calendar calendar24 = this$0.calendar;
                        if (calendar24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar24 = null;
                        }
                        arrayList21.add(new EventDay(calendar24, i26));
                    } else if (i3 == 2 && i2 == 4) {
                        int i27 = R.drawable.greentworedfour;
                        ArrayList<EventDay> arrayList22 = this$0.eventList;
                        Calendar calendar25 = this$0.calendar;
                        if (calendar25 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar25 = null;
                        }
                        arrayList22.add(new EventDay(calendar25, i27));
                    } else if (i3 == 2 && i2 == 5) {
                        int i28 = R.drawable.greentworedfive;
                        ArrayList<EventDay> arrayList23 = this$0.eventList;
                        Calendar calendar26 = this$0.calendar;
                        if (calendar26 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar26 = null;
                        }
                        arrayList23.add(new EventDay(calendar26, i28));
                    } else if (i3 == 2 && i2 == 6) {
                        int i29 = R.drawable.greentworedsix;
                        ArrayList<EventDay> arrayList24 = this$0.eventList;
                        Calendar calendar27 = this$0.calendar;
                        if (calendar27 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar27 = null;
                        }
                        arrayList24.add(new EventDay(calendar27, i29));
                    } else if (i3 == 3 && i2 == 0) {
                        int i30 = R.drawable.ic_three;
                        ArrayList<EventDay> arrayList25 = this$0.eventList;
                        Calendar calendar28 = this$0.calendar;
                        if (calendar28 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar28 = null;
                        }
                        arrayList25.add(new EventDay(calendar28, i30));
                    } else if (i3 == 3 && i2 == 1) {
                        int i31 = R.drawable.greenthreeredone;
                        ArrayList<EventDay> arrayList26 = this$0.eventList;
                        Calendar calendar29 = this$0.calendar;
                        if (calendar29 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar29 = null;
                        }
                        arrayList26.add(new EventDay(calendar29, i31));
                    } else if (i3 == 3 && i2 == 2) {
                        int i32 = R.drawable.greenthreeredtwo;
                        ArrayList<EventDay> arrayList27 = this$0.eventList;
                        Calendar calendar30 = this$0.calendar;
                        if (calendar30 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar30 = null;
                        }
                        arrayList27.add(new EventDay(calendar30, i32));
                    } else if (i3 == 3 && i2 == 3) {
                        int i33 = R.drawable.greenthreeredthree;
                        ArrayList<EventDay> arrayList28 = this$0.eventList;
                        Calendar calendar31 = this$0.calendar;
                        if (calendar31 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar31 = null;
                        }
                        arrayList28.add(new EventDay(calendar31, i33));
                    } else if (i3 == 3 && i2 == 4) {
                        int i34 = R.drawable.greenthreeredfour;
                        ArrayList<EventDay> arrayList29 = this$0.eventList;
                        Calendar calendar32 = this$0.calendar;
                        if (calendar32 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar32 = null;
                        }
                        arrayList29.add(new EventDay(calendar32, i34));
                    } else if (i3 == 3 && i2 == 5) {
                        int i35 = R.drawable.greenthreeredfive;
                        ArrayList<EventDay> arrayList30 = this$0.eventList;
                        Calendar calendar33 = this$0.calendar;
                        if (calendar33 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar33 = null;
                        }
                        arrayList30.add(new EventDay(calendar33, i35));
                    } else if (i3 == 4 && i2 == 0) {
                        int i36 = R.drawable.ic_four;
                        ArrayList<EventDay> arrayList31 = this$0.eventList;
                        Calendar calendar34 = this$0.calendar;
                        if (calendar34 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar34 = null;
                        }
                        arrayList31.add(new EventDay(calendar34, i36));
                    } else if (i3 == 4 && i2 == 1) {
                        int i37 = R.drawable.greenfourredone;
                        ArrayList<EventDay> arrayList32 = this$0.eventList;
                        Calendar calendar35 = this$0.calendar;
                        if (calendar35 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar35 = null;
                        }
                        arrayList32.add(new EventDay(calendar35, i37));
                    } else if (i3 == 4 && i2 == 2) {
                        int i38 = R.drawable.greenfourredtwo;
                        ArrayList<EventDay> arrayList33 = this$0.eventList;
                        Calendar calendar36 = this$0.calendar;
                        if (calendar36 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar36 = null;
                        }
                        arrayList33.add(new EventDay(calendar36, i38));
                    } else if (i3 == 4 && i2 == 3) {
                        int i39 = R.drawable.greenfourredthree;
                        ArrayList<EventDay> arrayList34 = this$0.eventList;
                        Calendar calendar37 = this$0.calendar;
                        if (calendar37 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar37 = null;
                        }
                        arrayList34.add(new EventDay(calendar37, i39));
                    } else if (i3 == 4 && i2 == 4) {
                        int i40 = R.drawable.greenfourredfour;
                        ArrayList<EventDay> arrayList35 = this$0.eventList;
                        Calendar calendar38 = this$0.calendar;
                        if (calendar38 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar38 = null;
                        }
                        arrayList35.add(new EventDay(calendar38, i40));
                    } else if (i3 == 5 && i2 == 0) {
                        int i41 = R.drawable.ic_five;
                        ArrayList<EventDay> arrayList36 = this$0.eventList;
                        Calendar calendar39 = this$0.calendar;
                        if (calendar39 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar39 = null;
                        }
                        arrayList36.add(new EventDay(calendar39, i41));
                    } else if (i3 == 5 && i2 == 1) {
                        int i42 = R.drawable.greenfiveredone;
                        ArrayList<EventDay> arrayList37 = this$0.eventList;
                        Calendar calendar40 = this$0.calendar;
                        if (calendar40 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar40 = null;
                        }
                        arrayList37.add(new EventDay(calendar40, i42));
                    } else if (i3 == 5 && i2 == 2) {
                        int i43 = R.drawable.greenfiveredtwo;
                        ArrayList<EventDay> arrayList38 = this$0.eventList;
                        Calendar calendar41 = this$0.calendar;
                        if (calendar41 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar41 = null;
                        }
                        arrayList38.add(new EventDay(calendar41, i43));
                    } else if (i3 == 5 && i2 == 3) {
                        int i44 = R.drawable.greenfiveredthree;
                        ArrayList<EventDay> arrayList39 = this$0.eventList;
                        Calendar calendar42 = this$0.calendar;
                        if (calendar42 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar42 = null;
                        }
                        arrayList39.add(new EventDay(calendar42, i44));
                    } else if (i3 == 6 && attendanceNew.getTotalperiod() == 6) {
                        int i45 = R.drawable.ic_leave;
                        ArrayList<EventDay> arrayList40 = this$0.eventList;
                        Calendar calendar43 = this$0.calendar;
                        if (calendar43 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar43 = null;
                        }
                        arrayList40.add(new EventDay(calendar43, i45));
                    } else if (i3 == 6 && i2 == 0) {
                        int i46 = R.drawable.ic_six;
                        ArrayList<EventDay> arrayList41 = this$0.eventList;
                        Calendar calendar44 = this$0.calendar;
                        if (calendar44 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar44 = null;
                        }
                        arrayList41.add(new EventDay(calendar44, i46));
                    } else if (i3 == 6 && i2 == 1) {
                        int i47 = R.drawable.greensixredone;
                        ArrayList<EventDay> arrayList42 = this$0.eventList;
                        Calendar calendar45 = this$0.calendar;
                        if (calendar45 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar45 = null;
                        }
                        arrayList42.add(new EventDay(calendar45, i47));
                    } else if (i3 == 6 && i2 == 2) {
                        int i48 = R.drawable.greensixredtwo;
                        ArrayList<EventDay> arrayList43 = this$0.eventList;
                        Calendar calendar46 = this$0.calendar;
                        if (calendar46 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar46 = null;
                        }
                        arrayList43.add(new EventDay(calendar46, i48));
                    } else if (i3 == 7 && attendanceNew.getTotalperiod() == 7) {
                        int i49 = R.drawable.ic_leave;
                        ArrayList<EventDay> arrayList44 = this$0.eventList;
                        Calendar calendar47 = this$0.calendar;
                        if (calendar47 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar47 = null;
                        }
                        arrayList44.add(new EventDay(calendar47, i49));
                    } else if (i3 == 7 && i2 == 0) {
                        int i50 = R.drawable.greensevenredzero;
                        ArrayList<EventDay> arrayList45 = this$0.eventList;
                        Calendar calendar48 = this$0.calendar;
                        if (calendar48 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar48 = null;
                        }
                        arrayList45.add(new EventDay(calendar48, i50));
                    } else if (i3 == 7 && i2 == 1) {
                        int i51 = R.drawable.greensevenredone;
                        ArrayList<EventDay> arrayList46 = this$0.eventList;
                        Calendar calendar49 = this$0.calendar;
                        if (calendar49 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar49 = null;
                        }
                        arrayList46.add(new EventDay(calendar49, i51));
                    } else if (i3 == 8 && i2 == 0) {
                        int i52 = R.drawable.ic_leave;
                        ArrayList<EventDay> arrayList47 = this$0.eventList;
                        Calendar calendar50 = this$0.calendar;
                        if (calendar50 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar50 = null;
                        }
                        arrayList47.add(new EventDay(calendar50, i52));
                    }
                }
                if (i4 == attendanceNew.getTotalperiod() && !attendanceNew.getHoliday()) {
                    int i53 = R.drawable.not_applicable;
                    ArrayList<EventDay> arrayList48 = this$0.eventList;
                    Calendar calendar51 = this$0.calendar;
                    if (calendar51 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("calendar");
                        calendar51 = null;
                    }
                    arrayList48.add(new EventDay(calendar51, i53));
                }
                System.out.println(i3);
                if (attendanceNew.getHoliday()) {
                    int i54 = R.drawable.holiday;
                    ArrayList<EventDay> arrayList49 = this$0.eventList;
                    Calendar calendar52 = this$0.calendar;
                    if (calendar52 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("calendar");
                        calendar52 = null;
                    }
                    arrayList49.add(new EventDay(calendar52, i54));
                }
                if (i3 == attendanceNew.getTotalperiod()) {
                    int i55 = R.drawable.ic_leave;
                    ArrayList<EventDay> arrayList50 = this$0.eventList;
                    Calendar calendar53 = this$0.calendar;
                    if (calendar53 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("calendar");
                        calendar53 = null;
                    }
                    arrayList50.add(new EventDay(calendar53, i55));
                }
                if (i4 == attendanceNew.getTotalperiod() && !attendanceNew.getHoliday()) {
                    int i56 = R.drawable.holiday;
                    ArrayList<EventDay> arrayList51 = this$0.eventList;
                    Calendar calendar54 = this$0.calendar;
                    if (calendar54 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("calendar");
                        calendar54 = null;
                    }
                    arrayList51.add(new EventDay(calendar54, i56));
                }
                if (i2 == attendanceNew.getTotalperiod()) {
                    int i57 = R.drawable.ic_present;
                    ArrayList<EventDay> arrayList52 = this$0.eventList;
                    Calendar calendar55 = this$0.calendar;
                    if (calendar55 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("calendar");
                    } else {
                        calendar3 = calendar55;
                    }
                    arrayList52.add(new EventDay(calendar3, i57));
                }
            }
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
        }
        System.out.println((Object) ("======newyork=====" + this$0.attendances));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        FragmentAttendanceByDayBinding fragmentAttendanceByDayBinding = get_binding();
        android.widget.CalendarView calendarView = fragmentAttendanceByDayBinding != null ? fragmentAttendanceByDayBinding.attendanceView : null;
        if (calendarView == null) {
            return;
        }
        calendarView.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        FragmentAttendanceByDayBinding fragmentAttendanceByDayBinding = get_binding();
        android.widget.CalendarView calendarView = fragmentAttendanceByDayBinding != null ? fragmentAttendanceByDayBinding.attendanceView : null;
        if (calendarView == null) {
            return;
        }
        calendarView.setVisibility(8);
    }

    public final void remind(String date, String semester) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(semester, "semester");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AttendanceDayDialog newInstance = AttendanceDayDialog.INSTANCE.newInstance(date, semester);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialog.AttendanceDayListner
    public void dismiss() {
        AttendanceByDayViewModel attendanceByDayViewModel = getAttendanceByDayViewModel();
        String str = this.semid;
        Calendar calendar = this.calendar;
        Calendar calendar2 = null;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar = null;
        }
        String valueOf = String.valueOf(calendar.get(1));
        Calendar calendar3 = this.calendar;
        if (calendar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
        } else {
            calendar2 = calendar3;
        }
        attendanceByDayViewModel.getAttendanceByDay(str, valueOf, String.valueOf(calendar2.get(2) + 1));
    }
}