package in.etuwa.app.ui.calendar;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.calendar.CalendarResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentCalendarBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.calendar.CalendarFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.cleverpumpkin.calendar.CalendarDate;
import ru.cleverpumpkin.calendar.CalendarView;
import ru.cleverpumpkin.calendar.extension.ContextExtenisonKt;

/* compiled from: CalendarFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u000201B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\b\u0010!\u001a\u00020\u001fH\u0002J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\u001a\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010-\u001a\u00020\u001fH\u0014J\b\u0010.\u001a\u00020\u001fH\u0014J\b\u0010/\u001a\u00020\u001fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lin/etuwa/app/ui/calendar/CalendarFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentCalendarBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentCalendarBinding;", "calendar", "Ljava/util/Calendar;", "calendarViewModel", "Lin/etuwa/app/ui/calendar/CalendarViewModel;", "getCalendarViewModel", "()Lin/etuwa/app/ui/calendar/CalendarViewModel;", "calendarViewModel$delegate", "Lkotlin/Lazy;", "color", "", "", "getColor", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "indicators", "", "Lru/cleverpumpkin/calendar/CalendarView$DateIndicator;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "CalendarDateIndicator", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CalendarFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentCalendarBinding _binding;
    private Calendar calendar;

    /* renamed from: calendarViewModel$delegate, reason: from kotlin metadata */
    private final Lazy calendarViewModel;
    private final Integer[] color;
    private final List<CalendarView.DateIndicator> indicators;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: CalendarFragment.kt */
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
    public static final CalendarFragment newInstance() {
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

    public CalendarFragment() {
        final CalendarFragment calendarFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.calendar.CalendarFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(calendarFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.calendarViewModel = FragmentViewModelLazyKt.createViewModelLazy(calendarFragment, Reflection.getOrCreateKotlinClass(CalendarViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.calendar.CalendarFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.calendar.CalendarFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CalendarViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.indicators = new ArrayList();
        final CalendarFragment calendarFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.calendar.CalendarFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = calendarFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.color = new Integer[]{Integer.valueOf(R.color.event_1_color), Integer.valueOf(R.color.event_2_color), Integer.valueOf(R.color.event_3_color), Integer.valueOf(R.color.event_4_color), Integer.valueOf(R.color.event_5_color), Integer.valueOf(R.color.event_6_color)};
    }

    private final CalendarViewModel getCalendarViewModel() {
        return (CalendarViewModel) this.calendarViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentCalendarBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final Integer[] getColor() {
        return this.color;
    }

    /* compiled from: CalendarFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/calendar/CalendarFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/calendar/CalendarFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CalendarFragment newInstance() {
            return new CalendarFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentCalendarBinding.inflate(inflater, container, false);
        FragmentCalendarBinding fragmentCalendarBinding = get_binding();
        if (fragmentCalendarBinding != null) {
            fragmentCalendarBinding.setCalendarViewModel(getCalendarViewModel());
        }
        FragmentCalendarBinding fragmentCalendarBinding2 = get_binding();
        if (fragmentCalendarBinding2 != null) {
            fragmentCalendarBinding2.setLifecycleOwner(this);
        }
        FragmentCalendarBinding fragmentCalendarBinding3 = get_binding();
        if (fragmentCalendarBinding3 != null) {
            return fragmentCalendarBinding3.getRoot();
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
        CalendarView calendarView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.calender));
        }
        getPreference().setNewLogin(false);
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.calendar = calendar;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar = null;
        }
        Calendar calendar2 = this.calendar;
        if (calendar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar2 = null;
        }
        int i = calendar2.get(1);
        Calendar calendar3 = this.calendar;
        if (calendar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar3 = null;
        }
        calendar.set(i, calendar3.get(2), 1);
        Calendar calendar4 = this.calendar;
        if (calendar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar4 = null;
        }
        Date time = calendar4.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        CalendarDate calendarDate = new CalendarDate(time);
        Calendar calendar5 = this.calendar;
        if (calendar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar5 = null;
        }
        calendar5.set(2010, 0, 1);
        Calendar calendar6 = this.calendar;
        if (calendar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar6 = null;
        }
        Date time2 = calendar6.getTime();
        Intrinsics.checkNotNullExpressionValue(time2, "calendar.time");
        CalendarDate calendarDate2 = new CalendarDate(time2);
        Calendar calendar7 = this.calendar;
        if (calendar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar7 = null;
        }
        calendar7.set(2050, 11, 1);
        Calendar calendar8 = this.calendar;
        if (calendar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendar");
            calendar8 = null;
        }
        Date time3 = calendar8.getTime();
        Intrinsics.checkNotNullExpressionValue(time3, "calendar.time");
        CalendarDate calendarDate3 = new CalendarDate(time3);
        ArrayList arrayList = new ArrayList();
        FragmentCalendarBinding fragmentCalendarBinding = get_binding();
        if (fragmentCalendarBinding != null && (calendarView = fragmentCalendarBinding.calendarView) != null) {
            calendarView.setupCalendar(calendarDate, calendarDate2, calendarDate3, CalendarView.SelectionMode.NONE, arrayList, 1, true);
        }
        listenResponse();
        FragmentCalendarBinding fragmentCalendarBinding2 = get_binding();
        CalendarView calendarView2 = fragmentCalendarBinding2 != null ? fragmentCalendarBinding2.calendarView : null;
        if (calendarView2 == null) {
            return;
        }
        calendarView2.setOnDateClickListener(new Function1<CalendarDate, Unit>() { // from class: in.etuwa.app.ui.calendar.CalendarFragment$setUp$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CalendarDate calendarDate4) {
                invoke2(calendarDate4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CalendarDate date) {
                FragmentCalendarBinding fragmentCalendarBinding3;
                CalendarFragment.CalendarDateIndicator[] calendarDateIndicatorArr;
                CalendarView calendarView3;
                List<CalendarView.DateIndicator> dateIndicators;
                Intrinsics.checkNotNullParameter(date, "date");
                fragmentCalendarBinding3 = CalendarFragment.this.get_binding();
                if (fragmentCalendarBinding3 == null || (calendarView3 = fragmentCalendarBinding3.calendarView) == null || (dateIndicators = calendarView3.getDateIndicators(date)) == null) {
                    calendarDateIndicatorArr = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : dateIndicators) {
                        if (obj instanceof CalendarFragment.CalendarDateIndicator) {
                            arrayList2.add(obj);
                        }
                    }
                    calendarDateIndicatorArr = (CalendarFragment.CalendarDateIndicator[]) arrayList2.toArray(new CalendarFragment.CalendarDateIndicator[0]);
                }
                if (calendarDateIndicatorArr != null) {
                    if (!(calendarDateIndicatorArr.length == 0)) {
                        AlertDialog.Builder title = new AlertDialog.Builder(CalendarFragment.this.requireContext()).setTitle(String.valueOf(date));
                        Context requireContext = CalendarFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        AlertDialog create = title.setAdapter(new DateIndicatorsDialogAdapter(requireContext, calendarDateIndicatorArr), null).create();
                        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
                        create.show();
                    }
                }
            }
        });
    }

    private final void listenResponse() {
        getCalendarViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.calendar.CalendarFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CalendarFragment.listenResponse$lambda$3(CalendarFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(CalendarFragment this$0, Resource resource) {
        FragmentCalendarBinding fragmentCalendarBinding;
        CalendarView calendarView;
        CalendarView calendarView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                CalendarResponse calendarResponse = (CalendarResponse) resource.getData();
                if (calendarResponse == null || (fragmentCalendarBinding = this$0.get_binding()) == null || (calendarView = fragmentCalendarBinding.calendarView) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(calendarView, "calendarView");
                ToastExtKt.showErrorToast(calendarView, calendarResponse.getError());
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            FragmentCalendarBinding fragmentCalendarBinding2 = this$0.get_binding();
            if (fragmentCalendarBinding2 == null || (calendarView2 = fragmentCalendarBinding2.calendarView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(calendarView2, message);
            return;
        }
        this$0.hideProgress();
        CalendarResponse calendarResponse2 = (CalendarResponse) resource.getData();
        if (calendarResponse2 != null) {
            if (calendarResponse2.getLogin()) {
                loop0: while (true) {
                    int i2 = 0;
                    for (in.etuwa.app.data.model.calendar.Calendar calendar : calendarResponse2.getData()) {
                        List split$default = StringsKt.split$default((CharSequence) calendar.getDate(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
                        Calendar calendar2 = this$0.calendar;
                        if (calendar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar2 = null;
                        }
                        calendar2.set(Integer.parseInt(StringsKt.trim((CharSequence) split$default.get(0)).toString()), Integer.parseInt(StringsKt.trim((CharSequence) split$default.get(1)).toString()) - 1, Integer.parseInt(StringsKt.trim((CharSequence) split$default.get(2)).toString()));
                        List<CalendarView.DateIndicator> list = this$0.indicators;
                        Calendar calendar3 = this$0.calendar;
                        if (calendar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("calendar");
                            calendar3 = null;
                        }
                        Date time = calendar3.getTime();
                        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
                        CalendarDate calendarDate = new CalendarDate(time);
                        Context requireContext = this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        list.add(new CalendarDateIndicator(calendarDate, ContextExtenisonKt.getColorInt(requireContext, this$0.color[i2].intValue()), calendar.getSubject()));
                        if (i2 == 5) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            FragmentCalendarBinding fragmentCalendarBinding3 = this$0.get_binding();
            CalendarView calendarView3 = fragmentCalendarBinding3 != null ? fragmentCalendarBinding3.calendarView : null;
            if (calendarView3 == null) {
                return;
            }
            calendarView3.setDatesIndicators(this$0.indicators);
        }
    }

    /* compiled from: CalendarFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/calendar/CalendarFragment$CalendarDateIndicator;", "Lru/cleverpumpkin/calendar/CalendarView$DateIndicator;", "date", "Lru/cleverpumpkin/calendar/CalendarDate;", "color", "", "eventName", "", "(Lru/cleverpumpkin/calendar/CalendarDate;ILjava/lang/String;)V", "getColor", "()I", "getDate", "()Lru/cleverpumpkin/calendar/CalendarDate;", "getEventName", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CalendarDateIndicator implements CalendarView.DateIndicator {
        private final int color;
        private final CalendarDate date;
        private final String eventName;

        public CalendarDateIndicator(CalendarDate date, int i, String eventName) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.date = date;
            this.color = i;
            this.eventName = eventName;
        }

        @Override // ru.cleverpumpkin.calendar.CalendarView.DateIndicator
        public CalendarDate getDate() {
            return this.date;
        }

        @Override // ru.cleverpumpkin.calendar.CalendarView.DateIndicator
        public int getColor() {
            return this.color;
        }

        public final String getEventName() {
            return this.eventName;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}