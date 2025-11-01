package in.etuwa.app.ui.dashboard.daywisetimetable;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.dash.daywisetimetaable.DayWiseResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentDayWiseTimeTableBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableAdapter;
import in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: DayWiseTimeTableFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0014J\b\u0010%\u001a\u00020#H\u0014J\b\u0010&\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020#H\u0016J\b\u00103\u001a\u00020#H\u0016J\u001a\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00106\u001a\u00020#H\u0015J\b\u00107\u001a\u00020#H\u0014J\b\u00108\u001a\u00020#H\u0014J\u0018\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\u001f\u0010 ¨\u0006>"}, d2 = {"Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableAdapter$CallBack;", "Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanDialog$StoreListener;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentDayWiseTimeTableBinding;", "adapter", "Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableAdapter;", "getAdapter", "()Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentDayWiseTimeTableBinding;", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "dayWiseTimeTableViewModel", "Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableViewModel;", "getDayWiseTimeTableViewModel", "()Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableViewModel;", "dayWiseTimeTableViewModel$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "dismiss", "", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "subjectPlanClicked", "postion", "", "hour", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DayWiseTimeTableFragment extends BaseFragment implements DayWiseTimeTableAdapter.CallBack, SubjectPlanDialog.StoreListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentDayWiseTimeTableBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String date;

    /* renamed from: dayWiseTimeTableViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dayWiseTimeTableViewModel;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final DayWiseTimeTableFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog.StoreListener
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public DayWiseTimeTableFragment() {
        final DayWiseTimeTableFragment dayWiseTimeTableFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(dayWiseTimeTableFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.dayWiseTimeTableViewModel = FragmentViewModelLazyKt.createViewModelLazy(dayWiseTimeTableFragment, Reflection.getOrCreateKotlinClass(DayWiseTimeTableViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(DayWiseTimeTableViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final DayWiseTimeTableFragment dayWiseTimeTableFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DayWiseTimeTableAdapter>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DayWiseTimeTableAdapter invoke() {
                ComponentCallbacks componentCallbacks = dayWiseTimeTableFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DayWiseTimeTableAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = dayWiseTimeTableFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.date = "";
    }

    private final DayWiseTimeTableViewModel getDayWiseTimeTableViewModel() {
        return (DayWiseTimeTableViewModel) this.dayWiseTimeTableViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DayWiseTimeTableAdapter getAdapter() {
        return (DayWiseTimeTableAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentDayWiseTimeTableBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    /* compiled from: DayWiseTimeTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DayWiseTimeTableFragment newInstance() {
            return new DayWiseTimeTableFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentDayWiseTimeTableBinding.inflate(inflater, container, false);
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding = get_binding();
        if (fragmentDayWiseTimeTableBinding != null) {
            fragmentDayWiseTimeTableBinding.setDayWiseTimeTableViewModel(getDayWiseTimeTableViewModel());
        }
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding2 = get_binding();
        if (fragmentDayWiseTimeTableBinding2 != null) {
            fragmentDayWiseTimeTableBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding3 = get_binding();
        if (fragmentDayWiseTimeTableBinding3 != null) {
            return fragmentDayWiseTimeTableBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FloatingActionButton floatingActionButton;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Day Wise Timetable");
        }
        hideBaseView();
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding = get_binding();
        RecyclerView recyclerView = fragmentDayWiseTimeTableBinding != null ? fragmentDayWiseTimeTableBinding.rvTimetable : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        Date parse = new SimpleDateFormat("yyyy-M-d").parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Intrinsics.checkNotNull(parse);
        String outputDateStr = simpleDateFormat.format(parse);
        DayWiseTimeTableViewModel dayWiseTimeTableViewModel = getDayWiseTimeTableViewModel();
        Intrinsics.checkNotNullExpressionValue(outputDateStr, "outputDateStr");
        dayWiseTimeTableViewModel.getTableData(outputDateStr);
        this.date = outputDateStr;
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding2 = get_binding();
        if (fragmentDayWiseTimeTableBinding2 != null && (floatingActionButton = fragmentDayWiseTimeTableBinding2.fabDatePicker) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DayWiseTimeTableFragment.setUp$lambda$1(DayWiseTimeTableFragment.this, i, i2, i3, view);
                }
            });
        }
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding3 = get_binding();
        if (fragmentDayWiseTimeTableBinding3 == null || (swipeRefreshLayout = fragmentDayWiseTimeTableBinding3.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                DayWiseTimeTableFragment.setUp$lambda$2(DayWiseTimeTableFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final DayWiseTimeTableFragment this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$$ExternalSyntheticLambda2
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                DayWiseTimeTableFragment.setUp$lambda$1$lambda$0(DayWiseTimeTableFragment.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(DayWiseTimeTableFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Date parse = new SimpleDateFormat("yyyy-M-d").parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Intrinsics.checkNotNull(parse);
        String outputDateStr1 = simpleDateFormat.format(parse);
        Intrinsics.checkNotNullExpressionValue(outputDateStr1, "outputDateStr1");
        this$0.date = outputDateStr1;
        this$0.getDayWiseTimeTableViewModel().getTableData(outputDateStr1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(DayWiseTimeTableFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDayWiseTimeTableViewModel().getTableData(this$0.date);
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentDayWiseTimeTableBinding != null ? fragmentDayWiseTimeTableBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getDayWiseTimeTableViewModel().getTimeTableResponse().observe(getViewLifecycleOwner(), new DayWiseTimeTableFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DayWiseResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment$listenResponse$1

            /* compiled from: DayWiseTimeTableFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DayWiseResponse> resource) {
                invoke2((Resource<DayWiseResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DayWiseResponse> resource) {
                DayWiseTimeTableAdapter adapter;
                DayWiseTimeTableAdapter adapter2;
                FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    DayWiseTimeTableFragment.this.hideProgress();
                    DayWiseResponse data = resource.getData();
                    if (data != null) {
                        DayWiseTimeTableFragment dayWiseTimeTableFragment = DayWiseTimeTableFragment.this;
                        dayWiseTimeTableFragment.showBaseView();
                        if (data.getTimetable().size() > 0) {
                            adapter2 = dayWiseTimeTableFragment.getAdapter();
                            adapter2.addItems(data.getTimetable().get(0).getSub());
                            return;
                        } else {
                            adapter = dayWiseTimeTableFragment.getAdapter();
                            adapter.clearItems();
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    DayWiseTimeTableFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    DayWiseTimeTableFragment.this.hideProgress();
                    DayWiseTimeTableFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                DayWiseTimeTableFragment.this.hideProgress();
                DayWiseTimeTableFragment.this.showBaseView();
                fragmentDayWiseTimeTableBinding = DayWiseTimeTableFragment.this.get_binding();
                if (fragmentDayWiseTimeTableBinding == null || (recyclerView = fragmentDayWiseTimeTableBinding.rvTimetable) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding = get_binding();
        if (fragmentDayWiseTimeTableBinding == null || (recyclerView = fragmentDayWiseTimeTableBinding.rvTimetable) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentDayWiseTimeTableBinding fragmentDayWiseTimeTableBinding = get_binding();
        if (fragmentDayWiseTimeTableBinding == null || (recyclerView = fragmentDayWiseTimeTableBinding.rvTimetable) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
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

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableAdapter.CallBack
    public void subjectPlanClicked(int postion, int hour) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SubjectPlanDialog newInstance = SubjectPlanDialog.INSTANCE.newInstance(postion, this.date, hour);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }
}