package in.etuwa.app.ui.attendance.bysubject;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.attendance.Attendance;
import in.etuwa.app.data.model.attendance.AttendanceResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.AttendanceFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AttendanceFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u000200H\u0014J\b\u00101\u001a\u000200H\u0014J\b\u00102\u001a\u000200H\u0002J\b\u00103\u001a\u000200H\u0002J\u0010\u00104\u001a\u0002002\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u00105\u001a\u0002002\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010>\u001a\u000200H\u0016J\u001a\u0010?\u001a\u0002002\u0006\u0010@\u001a\u0002092\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010A\u001a\u000200H\u0014J\b\u0010B\u001a\u000200H\u0014J\b\u0010C\u001a\u000200H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lin/etuwa/app/ui/attendance/bysubject/AttendanceFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/AttendanceFragmentBinding;", "adapter", "Lin/etuwa/app/ui/attendance/bysubject/AttendanceAdapter;", "getAdapter", "()Lin/etuwa/app/ui/attendance/bysubject/AttendanceAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "attendanceViewModel", "Lin/etuwa/app/ui/attendance/bysubject/AttendanceViewModel;", "getAttendanceViewModel", "()Lin/etuwa/app/ui/attendance/bysubject/AttendanceViewModel;", "attendanceViewModel$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/AttendanceFragmentBinding;", "dutyLeave", "", "flag", "isArts", "Ljava/lang/Boolean;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "semId", "", "getSemId", "()Ljava/lang/String;", "setSemId", "(Ljava/lang/String;)V", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "getSavedSemesterList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "context", "Landroid/content/Context;", "hideBaseView", "", "hideProgress", "listenResponse", "listenSemResponse", "onAttach", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttendanceFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AttendanceFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: attendanceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy attendanceViewModel;
    private boolean dutyLeave;
    private boolean flag;
    private Boolean isArts;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: AttendanceFragment.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AttendanceViewModel.class), qualifier, b, null, koinScope);
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
                return ParametersHolderKt.parametersOf(AttendanceFragment.this.requireActivity());
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
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = attendanceFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
        this.semId = getPreference().getUserSemId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AttendanceViewModel getAttendanceViewModel() {
        return (AttendanceViewModel) this.attendanceViewModel.getValue();
    }

    private final AttendanceAdapter getAdapter() {
        return (AttendanceAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final AttendanceFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
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

    /* compiled from: AttendanceFragment.kt */
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
        SwipeRefreshLayout swipeRefreshLayout;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Button button;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.attendance));
        }
        hideBaseView();
        AttendanceFragmentBinding attendanceFragmentBinding = get_binding();
        RecyclerView recyclerView = attendanceFragmentBinding != null ? attendanceFragmentBinding.rvAttendance : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = get_binding();
        Spinner spinner = attendanceFragmentBinding2 != null ? attendanceFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getPreference().setNewLogin(false);
        listenSemResponse();
        listenResponse();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        System.out.println(getSavedSemesterList(requireContext));
        getAttendanceViewModel().getAttendance(this.semId);
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) {
            AttendanceFragmentBinding attendanceFragmentBinding3 = get_binding();
            LinearLayout linearLayout3 = attendanceFragmentBinding3 != null ? attendanceFragmentBinding3.segmentView : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            AttendanceFragmentBinding attendanceFragmentBinding4 = get_binding();
            CardView cardView = attendanceFragmentBinding4 != null ? attendanceFragmentBinding4.totalCv : null;
            if (cardView != null) {
                cardView.setVisibility(0);
            }
        } else {
            AttendanceFragmentBinding attendanceFragmentBinding5 = get_binding();
            LinearLayout linearLayout4 = attendanceFragmentBinding5 != null ? attendanceFragmentBinding5.segmentView : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            AttendanceFragmentBinding attendanceFragmentBinding6 = get_binding();
            CardView cardView2 = attendanceFragmentBinding6 != null ? attendanceFragmentBinding6.totalCv : null;
            if (cardView2 != null) {
                cardView2.setVisibility(8);
            }
        }
        if (this.flag) {
            AttendanceFragmentBinding attendanceFragmentBinding7 = get_binding();
            Button button2 = attendanceFragmentBinding7 != null ? attendanceFragmentBinding7.byDayBtn : null;
            if (button2 != null) {
                button2.setVisibility(8);
            }
            AttendanceFragmentBinding attendanceFragmentBinding8 = get_binding();
            LinearLayout linearLayout5 = attendanceFragmentBinding8 != null ? attendanceFragmentBinding8.spinnerLt : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
        } else {
            AttendanceFragmentBinding attendanceFragmentBinding9 = get_binding();
            Button button3 = attendanceFragmentBinding9 != null ? attendanceFragmentBinding9.byDayBtn : null;
            if (button3 != null) {
                button3.setVisibility(0);
            }
            AttendanceFragmentBinding attendanceFragmentBinding10 = get_binding();
            LinearLayout linearLayout6 = attendanceFragmentBinding10 != null ? attendanceFragmentBinding10.spinnerLt : null;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
        }
        AttendanceFragmentBinding attendanceFragmentBinding11 = get_binding();
        if (attendanceFragmentBinding11 != null && (button = attendanceFragmentBinding11.byDayBtn) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$1(AttendanceFragment.this, view);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding12 = get_binding();
        if (attendanceFragmentBinding12 != null && (linearLayout2 = attendanceFragmentBinding12.withoutBtn) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$2(AttendanceFragment.this, view);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding13 = get_binding();
        if (attendanceFragmentBinding13 != null && (linearLayout = attendanceFragmentBinding13.withBtn) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttendanceFragment.setUp$lambda$3(AttendanceFragment.this, view);
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding14 = get_binding();
        Spinner spinner2 = attendanceFragmentBinding14 != null ? attendanceFragmentBinding14.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$setUp$4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter;
                    boolean z;
                    SemesterSpinnerAdapter spinnerAdapter2;
                    SharedPrefManager preference;
                    SemesterSpinnerAdapter spinnerAdapter3;
                    AttendanceFragmentBinding attendanceFragmentBinding15;
                    Spinner spinner3;
                    AttendanceViewModel attendanceViewModel;
                    spinnerAdapter = AttendanceFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    z = AttendanceFragment.this.flag;
                    if (z) {
                        attendanceViewModel = AttendanceFragment.this.getAttendanceViewModel();
                        attendanceViewModel.getAttendance(semester.getId());
                        return;
                    }
                    AttendanceFragment.this.flag = true;
                    spinnerAdapter2 = AttendanceFragment.this.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = AttendanceFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = AttendanceFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i).getId())) {
                            attendanceFragmentBinding15 = AttendanceFragment.this.get_binding();
                            if (attendanceFragmentBinding15 == null || (spinner3 = attendanceFragmentBinding15.spinnerSem) == null) {
                                return;
                            }
                            spinner3.setSelection(i);
                            return;
                        }
                    }
                }
            });
        }
        AttendanceFragmentBinding attendanceFragmentBinding15 = get_binding();
        if (attendanceFragmentBinding15 == null || (swipeRefreshLayout = attendanceFragmentBinding15.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda4
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                AttendanceFragment.setUp$lambda$4(AttendanceFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showByDayAttendance();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dutyLeave = false;
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        TextView textView = attendanceFragmentBinding != null ? attendanceFragmentBinding.withoutTv : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
        TextView textView2 = attendanceFragmentBinding2 != null ? attendanceFragmentBinding2.withTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        this$0.getAttendanceViewModel().getAttendance(this$0.semId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AttendanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dutyLeave = true;
        AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
        TextView textView = attendanceFragmentBinding != null ? attendanceFragmentBinding.withoutTv : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
        TextView textView2 = attendanceFragmentBinding2 != null ? attendanceFragmentBinding2.withTv : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        this$0.getAttendanceViewModel().getAttendance(this$0.semId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AttendanceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAttendanceViewModel().getSemester();
    }

    private final ArrayList<Semester> getSavedSemesterList(Context context) {
        return (ArrayList) new Gson().fromJson(context.getSharedPreferences("app_prefs", 0).getString("semester_list", null), new TypeToken<ArrayList<Semester>>() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$getSavedSemesterList$type$1
        }.getType());
    }

    private final void listenSemResponse() {
        getAttendanceViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceFragment.listenSemResponse$lambda$6(AttendanceFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$6(AttendanceFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        r2 = null;
        Boolean bool = null;
        if (i != 1) {
            if (i == 2) {
                AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
                if (attendanceFragmentBinding != null && (swipeRefreshLayout2 = attendanceFragmentBinding.swipeLayout) != null) {
                    bool = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    return;
                }
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
            AttendanceFragmentBinding attendanceFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (attendanceFragmentBinding3 == null || (swipeRefreshLayout = attendanceFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
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
        getAttendanceViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AttendanceFragment.listenResponse$lambda$8(AttendanceFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$8(AttendanceFragment this$0, Resource resource) {
        CircleProgressView circleProgressView;
        CircleProgressView circleProgressView2;
        RecyclerView recyclerView;
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
            AttendanceFragmentBinding attendanceFragmentBinding = this$0.get_binding();
            if (attendanceFragmentBinding == null || (recyclerView = attendanceFragmentBinding.rvAttendance) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        AttendanceResponse attendanceResponse = (AttendanceResponse) resource.getData();
        if (attendanceResponse != null) {
            this$0.showBaseView();
            try {
                if (attendanceResponse.getLogin()) {
                    if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
                        this$0.isArts = true;
                    } else {
                        this$0.isArts = false;
                    }
                    if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) {
                        AttendanceAdapter adapter = this$0.getAdapter();
                        ArrayList<Attendance> subjects = attendanceResponse.getSubjects();
                        boolean z = this$0.dutyLeave;
                        Boolean bool = this$0.isArts;
                        Intrinsics.checkNotNull(bool);
                        adapter.addItems(subjects, z, true, bool.booleanValue());
                        AttendanceFragmentBinding attendanceFragmentBinding2 = this$0.get_binding();
                        TextView textView = attendanceFragmentBinding2 != null ? attendanceFragmentBinding2.attendanceByTotal : null;
                        if (textView != null) {
                            textView.setText(attendanceResponse.getTotal_credit());
                        }
                        if (Intrinsics.areEqual(attendanceResponse.getTotal_percent(), "N/A")) {
                            AttendanceFragmentBinding attendanceFragmentBinding3 = this$0.get_binding();
                            if (attendanceFragmentBinding3 == null || (circleProgressView2 = attendanceFragmentBinding3.attendanceByPer) == null) {
                                return;
                            }
                            circleProgressView2.setValueAnimated(0);
                            return;
                        }
                        AttendanceFragmentBinding attendanceFragmentBinding4 = this$0.get_binding();
                        if (attendanceFragmentBinding4 == null || (circleProgressView = attendanceFragmentBinding4.attendanceByPer) == null) {
                            return;
                        }
                        circleProgressView.setValueAnimated(Float.parseFloat(StringsKt.replace$default(attendanceResponse.getTotal_percent(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)));
                        return;
                    }
                    AttendanceAdapter adapter2 = this$0.getAdapter();
                    ArrayList<Attendance> subjects2 = attendanceResponse.getSubjects();
                    boolean z2 = this$0.dutyLeave;
                    Boolean bool2 = this$0.isArts;
                    Intrinsics.checkNotNull(bool2);
                    adapter2.addItems(subjects2, z2, false, bool2.booleanValue());
                }
            } catch (NullPointerException | NumberFormatException unused) {
            }
        }
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
}