package in.etuwa.app.ui.timetable;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.timetable.TimetableResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.TimeTableFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: TimeTableFragment.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\u001a\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010/\u001a\u00020\u001cH\u0014J\b\u00100\u001a\u00020\u001cH\u0014J\b\u00101\u001a\u00020\u001cH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019¨\u00063"}, d2 = {"Lin/etuwa/app/ui/timetable/TimeTableFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/timetable/TimetableListener;", "()V", "_binding", "Lin/etuwa/app/databinding/TimeTableFragmentBinding;", "adapter", "Lin/etuwa/app/ui/timetable/TimeTableAdapter;", "getAdapter", "()Lin/etuwa/app/ui/timetable/TimeTableAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/TimeTableFragmentBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "timeTableViewModel", "Lin/etuwa/app/ui/timetable/TimeTableViewModel;", "getTimeTableViewModel", "()Lin/etuwa/app/ui/timetable/TimeTableViewModel;", "timeTableViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "loadPage", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeTableFragment extends BaseFragment implements TimetableListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private TimeTableFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: timeTableViewModel$delegate, reason: from kotlin metadata */
    private final Lazy timeTableViewModel;

    /* compiled from: TimeTableFragment.kt */
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
    public static final TimeTableFragment newInstance() {
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

    public TimeTableFragment() {
        final TimeTableFragment timeTableFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(timeTableFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.timeTableViewModel = FragmentViewModelLazyKt.createViewModelLazy(timeTableFragment, Reflection.getOrCreateKotlinClass(TimeTableViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TimeTableViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TimeTableFragment timeTableFragment2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(TimeTableFragment.this.getChildFragmentManager());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TimeTableAdapter>() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.timetable.TimeTableAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TimeTableAdapter invoke() {
                ComponentCallbacks componentCallbacks = timeTableFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TimeTableAdapter.class), b2, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        final byte b4 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = timeTableFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b3, b4);
            }
        });
    }

    private final TimeTableViewModel getTimeTableViewModel() {
        return (TimeTableViewModel) this.timeTableViewModel.getValue();
    }

    private final TimeTableAdapter getAdapter() {
        return (TimeTableAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final TimeTableFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: TimeTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/timetable/TimeTableFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/timetable/TimeTableFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TimeTableFragment newInstance() {
            return new TimeTableFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TimeTableFragmentBinding.inflate(inflater, container, false);
        TimeTableFragmentBinding timeTableFragmentBinding = get_binding();
        if (timeTableFragmentBinding != null) {
            timeTableFragmentBinding.setTimeTableViewModel(getTimeTableViewModel());
        }
        TimeTableFragmentBinding timeTableFragmentBinding2 = get_binding();
        if (timeTableFragmentBinding2 != null) {
            timeTableFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        TimeTableFragmentBinding timeTableFragmentBinding3 = get_binding();
        if (timeTableFragmentBinding3 != null) {
            return timeTableFragmentBinding3.getRoot();
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
        FloatingActionButton floatingActionButton;
        FloatingActionButton floatingActionButton2;
        TabLayout tabLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.timetable));
        }
        TimeTableFragmentBinding timeTableFragmentBinding = get_binding();
        ViewPager viewPager = timeTableFragmentBinding != null ? timeTableFragmentBinding.timetablePager : null;
        if (viewPager != null) {
            viewPager.setAdapter(getAdapter());
        }
        TimeTableFragmentBinding timeTableFragmentBinding2 = get_binding();
        if (timeTableFragmentBinding2 != null && (tabLayout = timeTableFragmentBinding2.tabs) != null) {
            TimeTableFragmentBinding timeTableFragmentBinding3 = get_binding();
            tabLayout.setupWithViewPager(timeTableFragmentBinding3 != null ? timeTableFragmentBinding3.timetablePager : null);
        }
        getPreference().setNewLogin(false);
        listenResponse();
        getAdapter().setCallBack(this);
        TimeTableFragmentBinding timeTableFragmentBinding4 = get_binding();
        if (timeTableFragmentBinding4 != null && (floatingActionButton2 = timeTableFragmentBinding4.fabChange) != null) {
            floatingActionButton2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimeTableFragment.setUp$lambda$0(TimeTableFragment.this, view);
                }
            });
        }
        TimeTableFragmentBinding timeTableFragmentBinding5 = get_binding();
        if (timeTableFragmentBinding5 == null || (floatingActionButton = timeTableFragmentBinding5.fabSpecial) == null) {
            return;
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeTableFragment.setUp$lambda$1(TimeTableFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TimeTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.loadChangeTimetable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TimeTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.loadSpecialTimetable();
        }
    }

    private final void listenResponse() {
        getTimeTableViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.timetable.TimeTableFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TimeTableFragment.listenResponse$lambda$3(TimeTableFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(TimeTableFragment this$0, Resource resource) {
        ViewPager timetablePager;
        ViewPager viewPager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TimetableResponse timetableResponse = (TimetableResponse) resource.getData();
            if (timetableResponse != null) {
                if (timetableResponse.getLogin()) {
                    this$0.getAdapter().addItems(timetableResponse.getTimetable());
                    return;
                }
                TimeTableFragmentBinding timeTableFragmentBinding = this$0.get_binding();
                if (timeTableFragmentBinding == null || (timetablePager = timeTableFragmentBinding.timetablePager) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(timetablePager, "timetablePager");
                ToastExtKt.showErrorToast(timetablePager, timetableResponse.getError());
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        TimeTableFragmentBinding timeTableFragmentBinding2 = this$0.get_binding();
        if (timeTableFragmentBinding2 == null || (viewPager = timeTableFragmentBinding2.timetablePager) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(viewPager, message);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // in.etuwa.app.ui.timetable.TimetableListener
    public void loadPage() {
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        ViewPager viewPager7;
        ViewPager viewPager8;
        ViewPager viewPager9;
        ViewPager viewPager10;
        ViewPager viewPager11;
        ViewPager viewPager12;
        ViewPager viewPager13;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
        if (getPreference().getClgId() != 15 && getPreference().getClgId() != 5 && getPreference().getClgId() != 2) {
            String format = simpleDateFormat.format(Calendar.getInstance().getTime());
            if (format != null) {
                switch (format.hashCode()) {
                    case 70909:
                        if (format.equals("Fri")) {
                            TimeTableFragmentBinding timeTableFragmentBinding = get_binding();
                            if (timeTableFragmentBinding == null || (viewPager9 = timeTableFragmentBinding.timetablePager) == null) {
                                return;
                            }
                            viewPager9.setCurrentItem(4, true);
                            return;
                        }
                        break;
                    case 77548:
                        if (format.equals("Mon")) {
                            TimeTableFragmentBinding timeTableFragmentBinding2 = get_binding();
                            if (timeTableFragmentBinding2 == null || (viewPager10 = timeTableFragmentBinding2.timetablePager) == null) {
                                return;
                            }
                            viewPager10.setCurrentItem(0, true);
                            return;
                        }
                        break;
                    case 84065:
                        if (format.equals("Thu")) {
                            TimeTableFragmentBinding timeTableFragmentBinding3 = get_binding();
                            if (timeTableFragmentBinding3 == null || (viewPager11 = timeTableFragmentBinding3.timetablePager) == null) {
                                return;
                            }
                            viewPager11.setCurrentItem(3, true);
                            return;
                        }
                        break;
                    case 84452:
                        if (format.equals("Tue")) {
                            TimeTableFragmentBinding timeTableFragmentBinding4 = get_binding();
                            if (timeTableFragmentBinding4 == null || (viewPager12 = timeTableFragmentBinding4.timetablePager) == null) {
                                return;
                            }
                            viewPager12.setCurrentItem(1, true);
                            return;
                        }
                        break;
                    case 86838:
                        if (format.equals("Wed")) {
                            TimeTableFragmentBinding timeTableFragmentBinding5 = get_binding();
                            if (timeTableFragmentBinding5 == null || (viewPager13 = timeTableFragmentBinding5.timetablePager) == null) {
                                return;
                            }
                            viewPager13.setCurrentItem(2, true);
                            return;
                        }
                        break;
                }
            }
            TimeTableFragmentBinding timeTableFragmentBinding6 = get_binding();
            if (timeTableFragmentBinding6 == null || (viewPager8 = timeTableFragmentBinding6.timetablePager) == null) {
                return;
            }
            viewPager8.setCurrentItem(0, true);
            return;
        }
        String format2 = simpleDateFormat.format(Calendar.getInstance().getTime());
        if (format2 != null) {
            switch (format2.hashCode()) {
                case 70909:
                    if (format2.equals("Fri")) {
                        TimeTableFragmentBinding timeTableFragmentBinding7 = get_binding();
                        if (timeTableFragmentBinding7 == null || (viewPager2 = timeTableFragmentBinding7.timetablePager) == null) {
                            return;
                        }
                        viewPager2.setCurrentItem(4, true);
                        return;
                    }
                    break;
                case 77548:
                    if (format2.equals("Mon")) {
                        TimeTableFragmentBinding timeTableFragmentBinding8 = get_binding();
                        if (timeTableFragmentBinding8 == null || (viewPager3 = timeTableFragmentBinding8.timetablePager) == null) {
                            return;
                        }
                        viewPager3.setCurrentItem(0, true);
                        return;
                    }
                    break;
                case 82886:
                    if (format2.equals("Sat")) {
                        TimeTableFragmentBinding timeTableFragmentBinding9 = get_binding();
                        if (timeTableFragmentBinding9 == null || (viewPager4 = timeTableFragmentBinding9.timetablePager) == null) {
                            return;
                        }
                        viewPager4.setCurrentItem(5, true);
                        return;
                    }
                    break;
                case 84065:
                    if (format2.equals("Thu")) {
                        TimeTableFragmentBinding timeTableFragmentBinding10 = get_binding();
                        if (timeTableFragmentBinding10 == null || (viewPager5 = timeTableFragmentBinding10.timetablePager) == null) {
                            return;
                        }
                        viewPager5.setCurrentItem(3, true);
                        return;
                    }
                    break;
                case 84452:
                    if (format2.equals("Tue")) {
                        TimeTableFragmentBinding timeTableFragmentBinding11 = get_binding();
                        if (timeTableFragmentBinding11 == null || (viewPager6 = timeTableFragmentBinding11.timetablePager) == null) {
                            return;
                        }
                        viewPager6.setCurrentItem(1, true);
                        return;
                    }
                    break;
                case 86838:
                    if (format2.equals("Wed")) {
                        TimeTableFragmentBinding timeTableFragmentBinding12 = get_binding();
                        if (timeTableFragmentBinding12 == null || (viewPager7 = timeTableFragmentBinding12.timetablePager) == null) {
                            return;
                        }
                        viewPager7.setCurrentItem(2, true);
                        return;
                    }
                    break;
            }
        }
        TimeTableFragmentBinding timeTableFragmentBinding13 = get_binding();
        if (timeTableFragmentBinding13 == null || (viewPager = timeTableFragmentBinding13.timetablePager) == null) {
            return;
        }
        viewPager.setCurrentItem(0, true);
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

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
        getAdapter().setCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}