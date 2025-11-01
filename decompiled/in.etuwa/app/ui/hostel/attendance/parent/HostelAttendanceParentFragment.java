package in.etuwa.app.ui.hostel.attendance.parent;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelAttParentViewResponse;
import in.etuwa.app.databinding.FragmentHostelAttendanceParentFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: HostelAttendanceParentFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020!H\u0014J\b\u0010$\u001a\u00020!H\u0014J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0012\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00104\u001a\u00020!H\u0016J\u001a\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020!H\u0015J\b\u0010:\u001a\u00020!H\u0014J\b\u0010;\u001a\u00020!H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006="}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentHostelAttendanceParentFragmentBinding;", "adapter", "Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter;", "getAdapter", "()Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentHostelAttendanceParentFragmentBinding;", "currentDate", "", "getCurrentDate", "()Ljava/lang/String;", "setCurrentDate", "(Ljava/lang/String;)V", "hostelAttendanceParentViewModel", "Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentViewModel;", "getHostelAttendanceParentViewModel", "()Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentViewModel;", "hostelAttendanceParentViewModel$delegate", "temp", "", "getTemp", "()I", "setTemp", "(I)V", "approveBtnClicked", "", "id", "hideBaseView", "hideProgress", "listenApprovalResponse", "listenApproveResponse", "listenRejectResponse", "listenRejectsResponse", "listenResponse", "listenRevokeResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "rejectBtnClicked", "revokeBtnClicked", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelAttendanceParentFragment extends BaseFragment implements HostelAttendanceParentAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelAttendanceParentFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String currentDate;

    /* renamed from: hostelAttendanceParentViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelAttendanceParentViewModel;
    private int temp;

    /* compiled from: HostelAttendanceParentFragment.kt */
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
    public static final HostelAttendanceParentFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public HostelAttendanceParentFragment() {
        final HostelAttendanceParentFragment hostelAttendanceParentFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelAttendanceParentFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelAttendanceParentViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelAttendanceParentFragment, Reflection.getOrCreateKotlinClass(HostelAttendanceParentViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelAttendanceParentViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelAttendanceParentFragment hostelAttendanceParentFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelAttendanceParentAdapter>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelAttendanceParentAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelAttendanceParentFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelAttendanceParentAdapter.class), b2, b3);
            }
        });
        this.currentDate = "";
        this.temp = 1;
    }

    private final HostelAttendanceParentViewModel getHostelAttendanceParentViewModel() {
        return (HostelAttendanceParentViewModel) this.hostelAttendanceParentViewModel.getValue();
    }

    private final HostelAttendanceParentAdapter getAdapter() {
        return (HostelAttendanceParentAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentHostelAttendanceParentFragmentBinding get_binding() {
        return this._binding;
    }

    public final String getCurrentDate() {
        return this.currentDate;
    }

    public final void setCurrentDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentDate = str;
    }

    public final int getTemp() {
        return this.temp;
    }

    public final void setTemp(int i) {
        this.temp = i;
    }

    /* compiled from: HostelAttendanceParentFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelAttendanceParentFragment newInstance() {
            HostelAttendanceParentFragment hostelAttendanceParentFragment = new HostelAttendanceParentFragment();
            hostelAttendanceParentFragment.setArguments(new Bundle());
            return hostelAttendanceParentFragment;
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
        this._binding = FragmentHostelAttendanceParentFragmentBinding.inflate(inflater, container, false);
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding != null) {
            fragmentHostelAttendanceParentFragmentBinding.setHostelAttendanceParentViewModel(getHostelAttendanceParentViewModel());
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding2 != null) {
            fragmentHostelAttendanceParentFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding3 != null) {
            return fragmentHostelAttendanceParentFragmentBinding3.getRoot();
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
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Leave View");
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelAttendanceParentFragmentBinding != null ? fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        hideBaseView();
        listenResponse();
        listenRevokeResponse();
        listenApproveResponse();
        listenRejectResponse();
        listenRejectsResponse();
        listenApprovalResponse();
        getHostelAttendanceParentViewModel().getHostelAttParentApproveView(this.currentDate);
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding2 != null && (textView6 = fragmentHostelAttendanceParentFragmentBinding2.approvalTv) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_corner_green);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding3 != null && (textView5 = fragmentHostelAttendanceParentFragmentBinding3.rejectsTv) != null) {
            textView5.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding4 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding4 != null && (textView4 = fragmentHostelAttendanceParentFragmentBinding4.allTv) != null) {
            textView4.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding5 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding5 != null && (textView3 = fragmentHostelAttendanceParentFragmentBinding5.approvalTv) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelAttendanceParentFragment.setUp$lambda$1(HostelAttendanceParentFragment.this, view);
                }
            });
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding6 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding6 != null && (textView2 = fragmentHostelAttendanceParentFragmentBinding6.rejectsTv) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelAttendanceParentFragment.setUp$lambda$2(HostelAttendanceParentFragment.this, view);
                }
            });
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding7 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding7 != null && (textView = fragmentHostelAttendanceParentFragmentBinding7.allTv) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelAttendanceParentFragment.setUp$lambda$3(HostelAttendanceParentFragment.this, view);
                }
            });
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding8 = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding8 == null || (floatingActionButton = fragmentHostelAttendanceParentFragmentBinding8.fabDateFilter) == null) {
            return;
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelAttendanceParentFragment.setUp$lambda$5(HostelAttendanceParentFragment.this, i, i2, i3, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HostelAttendanceParentFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.temp = 1;
        this$0.currentDate = "";
        this$0.getHostelAttendanceParentViewModel().getHostelAttParentApproveView(this$0.currentDate);
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding != null && (textView3 = fragmentHostelAttendanceParentFragmentBinding.approvalTv) != null) {
            textView3.setBackgroundResource(R.drawable.shape_round_corner_green);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding2 != null && (textView2 = fragmentHostelAttendanceParentFragmentBinding2.rejectsTv) != null) {
            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding3 == null || (textView = fragmentHostelAttendanceParentFragmentBinding3.allTv) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(HostelAttendanceParentFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.temp = 2;
        this$0.currentDate = "";
        this$0.getHostelAttendanceParentViewModel().getHostelAttParentRejectView(this$0.currentDate);
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding != null && (textView3 = fragmentHostelAttendanceParentFragmentBinding.approvalTv) != null) {
            textView3.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding2 != null && (textView2 = fragmentHostelAttendanceParentFragmentBinding2.rejectsTv) != null) {
            textView2.setBackgroundResource(R.drawable.shape_round_corner_green);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding3 == null || (textView = fragmentHostelAttendanceParentFragmentBinding3.allTv) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(HostelAttendanceParentFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.temp = 3;
        this$0.currentDate = "";
        this$0.getHostelAttendanceParentViewModel().getHostelAttParentView(this$0.currentDate);
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding != null && (textView3 = fragmentHostelAttendanceParentFragmentBinding.approvalTv) != null) {
            textView3.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding2 != null && (textView2 = fragmentHostelAttendanceParentFragmentBinding2.rejectsTv) != null) {
            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding3 == null || (textView = fragmentHostelAttendanceParentFragmentBinding3.allTv) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_round_corner_green);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(final HostelAttendanceParentFragment this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda9
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                HostelAttendanceParentFragment.setUp$lambda$5$lambda$4(HostelAttendanceParentFragment.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5$lambda$4(HostelAttendanceParentFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentDate = (i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3).toString();
        int i4 = this$0.temp;
        if (i4 == 1) {
            this$0.getHostelAttendanceParentViewModel().getHostelAttParentApproveView(this$0.currentDate);
        } else if (i4 == 2) {
            this$0.getHostelAttendanceParentViewModel().getHostelAttParentRejectView(this$0.currentDate);
        } else {
            if (i4 != 3) {
                return;
            }
            this$0.getHostelAttendanceParentViewModel().getHostelAttParentView(this$0.currentDate);
        }
    }

    private final void listenResponse() {
        getHostelAttendanceParentViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceParentFragment.listenResponse$lambda$7(HostelAttendanceParentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$7(HostelAttendanceParentFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        TextView textView;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
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
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        HostelAttParentViewResponse hostelAttParentViewResponse = (HostelAttParentViewResponse) resource.getData();
        if (hostelAttParentViewResponse != null) {
            this$0.showBaseView();
            if (hostelAttParentViewResponse.getLogin()) {
                this$0.getAdapter().addItems(hostelAttParentViewResponse.getData());
                if (hostelAttParentViewResponse.getData().size() == 0) {
                    FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
                    CardView cardView = fragmentHostelAttendanceParentFragmentBinding2 != null ? fragmentHostelAttendanceParentFragmentBinding2.swipeLayout : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
                    textView = fragmentHostelAttendanceParentFragmentBinding3 != null ? fragmentHostelAttendanceParentFragmentBinding3.noData : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding4 = this$0.get_binding();
                CardView cardView2 = fragmentHostelAttendanceParentFragmentBinding4 != null ? fragmentHostelAttendanceParentFragmentBinding4.swipeLayout : null;
                if (cardView2 != null) {
                    cardView2.setVisibility(0);
                }
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding5 = this$0.get_binding();
                textView = fragmentHostelAttendanceParentFragmentBinding5 != null ? fragmentHostelAttendanceParentFragmentBinding5.noData : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding6 = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding6 == null || (rvHostelAttView = fragmentHostelAttendanceParentFragmentBinding6.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    private final void listenApprovalResponse() {
        getHostelAttendanceParentViewModel().getApproveViewResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceParentFragment.listenApprovalResponse$lambda$9(HostelAttendanceParentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenApprovalResponse$lambda$9(HostelAttendanceParentFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        TextView textView;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
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
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        HostelAttParentViewResponse hostelAttParentViewResponse = (HostelAttParentViewResponse) resource.getData();
        if (hostelAttParentViewResponse != null) {
            this$0.showBaseView();
            if (hostelAttParentViewResponse.getLogin()) {
                this$0.getAdapter().addItems(hostelAttParentViewResponse.getData());
                if (hostelAttParentViewResponse.getData().size() == 0) {
                    FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
                    CardView cardView = fragmentHostelAttendanceParentFragmentBinding2 != null ? fragmentHostelAttendanceParentFragmentBinding2.swipeLayout : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
                    textView = fragmentHostelAttendanceParentFragmentBinding3 != null ? fragmentHostelAttendanceParentFragmentBinding3.noData : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding4 = this$0.get_binding();
                CardView cardView2 = fragmentHostelAttendanceParentFragmentBinding4 != null ? fragmentHostelAttendanceParentFragmentBinding4.swipeLayout : null;
                if (cardView2 != null) {
                    cardView2.setVisibility(0);
                }
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding5 = this$0.get_binding();
                textView = fragmentHostelAttendanceParentFragmentBinding5 != null ? fragmentHostelAttendanceParentFragmentBinding5.noData : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding6 = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding6 == null || (rvHostelAttView = fragmentHostelAttendanceParentFragmentBinding6.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    private final void listenRejectsResponse() {
        getHostelAttendanceParentViewModel().getRejectViewResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceParentFragment.listenRejectsResponse$lambda$11(HostelAttendanceParentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenRejectsResponse$lambda$11(HostelAttendanceParentFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        TextView textView;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
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
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        HostelAttParentViewResponse hostelAttParentViewResponse = (HostelAttParentViewResponse) resource.getData();
        if (hostelAttParentViewResponse != null) {
            this$0.showBaseView();
            if (hostelAttParentViewResponse.getLogin()) {
                this$0.getAdapter().addItems(hostelAttParentViewResponse.getData());
                if (hostelAttParentViewResponse.getData().size() == 0) {
                    FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
                    CardView cardView = fragmentHostelAttendanceParentFragmentBinding2 != null ? fragmentHostelAttendanceParentFragmentBinding2.swipeLayout : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
                    textView = fragmentHostelAttendanceParentFragmentBinding3 != null ? fragmentHostelAttendanceParentFragmentBinding3.noData : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding4 = this$0.get_binding();
                CardView cardView2 = fragmentHostelAttendanceParentFragmentBinding4 != null ? fragmentHostelAttendanceParentFragmentBinding4.swipeLayout : null;
                if (cardView2 != null) {
                    cardView2.setVisibility(0);
                }
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding5 = this$0.get_binding();
                textView = fragmentHostelAttendanceParentFragmentBinding5 != null ? fragmentHostelAttendanceParentFragmentBinding5.noData : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding6 = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding6 == null || (rvHostelAttView = fragmentHostelAttendanceParentFragmentBinding6.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    private final void listenApproveResponse() {
        getHostelAttendanceParentViewModel().getApproveResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceParentFragment.listenApproveResponse$lambda$13(HostelAttendanceParentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenApproveResponse$lambda$13(HostelAttendanceParentFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        RecyclerView rvHostelAttView2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
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
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getLogin()) {
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
                if (fragmentHostelAttendanceParentFragmentBinding2 != null && (rvHostelAttView2 = fragmentHostelAttendanceParentFragmentBinding2.rvHostelAttView) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvHostelAttView2, "rvHostelAttView");
                    ToastExtKt.showSuccessToast(rvHostelAttView2, successResponse.getMessage());
                }
                int i2 = this$0.temp;
                if (i2 == 1) {
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentApproveView(this$0.currentDate);
                    return;
                } else if (i2 == 2) {
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentRejectView(this$0.currentDate);
                    return;
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentView(this$0.currentDate);
                    return;
                }
            }
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding3 == null || (rvHostelAttView = fragmentHostelAttendanceParentFragmentBinding3.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    private final void listenRejectResponse() {
        getHostelAttendanceParentViewModel().getRejectResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceParentFragment.listenRejectResponse$lambda$15(HostelAttendanceParentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenRejectResponse$lambda$15(HostelAttendanceParentFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        RecyclerView rvHostelAttView2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
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
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getLogin()) {
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
                if (fragmentHostelAttendanceParentFragmentBinding2 != null && (rvHostelAttView2 = fragmentHostelAttendanceParentFragmentBinding2.rvHostelAttView) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvHostelAttView2, "rvHostelAttView");
                    ToastExtKt.showSuccessToast(rvHostelAttView2, successResponse.getMessage());
                }
                int i2 = this$0.temp;
                if (i2 == 1) {
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentApproveView(this$0.currentDate);
                    return;
                } else if (i2 == 2) {
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentRejectView(this$0.currentDate);
                    return;
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentView(this$0.currentDate);
                    return;
                }
            }
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding3 == null || (rvHostelAttView = fragmentHostelAttendanceParentFragmentBinding3.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    private final void listenRevokeResponse() {
        getHostelAttendanceParentViewModel().getRevokeResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelAttendanceParentFragment.listenRevokeResponse$lambda$17(HostelAttendanceParentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenRevokeResponse$lambda$17(HostelAttendanceParentFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        RecyclerView rvHostelAttView2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
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
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getLogin()) {
                FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding2 = this$0.get_binding();
                if (fragmentHostelAttendanceParentFragmentBinding2 != null && (rvHostelAttView2 = fragmentHostelAttendanceParentFragmentBinding2.rvHostelAttView) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvHostelAttView2, "rvHostelAttView");
                    ToastExtKt.showSuccessToast(rvHostelAttView2, successResponse.getMessage());
                }
                int i2 = this$0.temp;
                if (i2 == 1) {
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentApproveView(this$0.currentDate);
                    return;
                } else if (i2 == 2) {
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentRejectView(this$0.currentDate);
                    return;
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    this$0.getHostelAttendanceParentViewModel().getHostelAttParentView(this$0.currentDate);
                    return;
                }
            }
            FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding3 = this$0.get_binding();
            if (fragmentHostelAttendanceParentFragmentBinding3 == null || (rvHostelAttView = fragmentHostelAttendanceParentFragmentBinding3.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentHostelAttendanceParentFragmentBinding fragmentHostelAttendanceParentFragmentBinding = get_binding();
        if (fragmentHostelAttendanceParentFragmentBinding == null || (recyclerView = fragmentHostelAttendanceParentFragmentBinding.rvHostelAttView) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter.CallBack
    public void approveBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getHostelAttendanceParentViewModel().getAApproveResponse(id);
    }

    @Override // in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter.CallBack
    public void rejectBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getHostelAttendanceParentViewModel().getRejectParent(id);
    }

    @Override // in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter.CallBack
    public void revokeBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getHostelAttendanceParentViewModel().getRevokeParent(id);
    }
}