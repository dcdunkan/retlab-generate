package in.etuwa.app.ui.profile.coursesattended;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.coursesattended.CoursesAttendedResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentCourseAttendedBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.profile.coursesattended.CoursesAttendedAdapter;
import in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog;
import in.etuwa.app.ui.profile.sport.add.AddSportDialog;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* compiled from: CoursesAttendedFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001@B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0002J\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001eH\u0016J@\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020 H\u0014J\b\u0010.\u001a\u00020 H\u0014J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020 H\u0016J\u001a\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010=\u001a\u00020 H\u0014J\b\u0010>\u001a\u00020 H\u0014J\b\u0010?\u001a\u00020 H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019¨\u0006A"}, d2 = {"Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedAdapter$CoursesListener;", "Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedDialog$AddCourseListener;", "Lin/etuwa/app/ui/profile/sport/add/AddSportDialog$AddSportListener;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentCourseAttendedBinding;", "adapter", "Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedAdapter;", "getAdapter", "()Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentCourseAttendedBinding;", "coursesAttendedViewModel", "Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedViewModel;", "getCoursesAttendedViewModel", "()Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedViewModel;", "coursesAttendedViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "deleteView", "downloadFile", "url", CommonCssConstants.POSITION, "editBtnClicked", "name", "organised", TypedValues.TransitionType.S_DURATION, "achievements", "fromDate", "toDate", "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDismiss", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CoursesAttendedFragment extends BaseFragment implements CoursesAttendedAdapter.CoursesListener, AddCourseAttendedDialog.AddCourseListener, AddSportDialog.AddSportListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentCourseAttendedBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: coursesAttendedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy coursesAttendedViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: CoursesAttendedFragment.kt */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteView$lambda$7(DialogInterface dialogInterface, int i) {
    }

    @JvmStatic
    public static final CoursesAttendedFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.profile.coursesattended.CoursesAttendedAdapter.CoursesListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return true;
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public CoursesAttendedFragment() {
        final CoursesAttendedFragment coursesAttendedFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(coursesAttendedFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.coursesAttendedViewModel = FragmentViewModelLazyKt.createViewModelLazy(coursesAttendedFragment, Reflection.getOrCreateKotlinClass(CoursesAttendedViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CoursesAttendedViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CoursesAttendedFragment coursesAttendedFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CoursesAttendedAdapter>() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.coursesattended.CoursesAttendedAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CoursesAttendedAdapter invoke() {
                ComponentCallbacks componentCallbacks = coursesAttendedFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CoursesAttendedAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = coursesAttendedFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final CoursesAttendedViewModel getCoursesAttendedViewModel() {
        return (CoursesAttendedViewModel) this.coursesAttendedViewModel.getValue();
    }

    private final CoursesAttendedAdapter getAdapter() {
        return (CoursesAttendedAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentCourseAttendedBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: CoursesAttendedFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CoursesAttendedFragment newInstance() {
            return new CoursesAttendedFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentCourseAttendedBinding.inflate(inflater, container, false);
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding = get_binding();
        if (fragmentCourseAttendedBinding != null) {
            fragmentCourseAttendedBinding.setCoursesAttendedViewModel(getCoursesAttendedViewModel());
        }
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding2 = get_binding();
        if (fragmentCourseAttendedBinding2 != null) {
            fragmentCourseAttendedBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding3 = get_binding();
        if (fragmentCourseAttendedBinding3 != null) {
            return fragmentCourseAttendedBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Courses Attended");
        }
        hideBaseView();
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding = get_binding();
        RecyclerView recyclerView = fragmentCourseAttendedBinding != null ? fragmentCourseAttendedBinding.rvCourse : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCoursesListener(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenDeleteResponse();
        getCoursesAttendedViewModel().getCoursesAttendedData();
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding2 = get_binding();
        if (fragmentCourseAttendedBinding2 != null && (swipeRefreshLayout = fragmentCourseAttendedBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$$ExternalSyntheticLambda2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    CoursesAttendedFragment.setUp$lambda$0(CoursesAttendedFragment.this);
                }
            });
        }
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding3 = get_binding();
        if (fragmentCourseAttendedBinding3 == null || (textView = fragmentCourseAttendedBinding3.addBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CoursesAttendedFragment.setUp$lambda$1(CoursesAttendedFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(CoursesAttendedFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCoursesAttendedViewModel().getCoursesAttendedData();
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentCourseAttendedBinding != null ? fragmentCourseAttendedBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CoursesAttendedFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddCourseAttendedDialog newInstance = AddCourseAttendedDialog.INSTANCE.newInstance("", "", "", "", "", "", "");
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getCoursesAttendedViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CoursesAttendedFragment.listenResponse$lambda$3(CoursesAttendedFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(CoursesAttendedFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            CoursesAttendedResponse coursesAttendedResponse = (CoursesAttendedResponse) resource.getData();
            if (coursesAttendedResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(coursesAttendedResponse.getCourses());
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
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding = this$0.get_binding();
        if (fragmentCourseAttendedBinding == null || (recyclerView = fragmentCourseAttendedBinding.rvCourse) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenDeleteResponse() {
        getCoursesAttendedViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CoursesAttendedFragment.listenDeleteResponse$lambda$5(CoursesAttendedFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$5(CoursesAttendedFragment this$0, Resource resource) {
        RecyclerView rvCourse;
        RecyclerView rvCourse2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            FragmentCourseAttendedBinding fragmentCourseAttendedBinding = this$0.get_binding();
            if (fragmentCourseAttendedBinding == null || (recyclerView = fragmentCourseAttendedBinding.rvCourse) == null) {
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
            if (successResponse.getSuccess()) {
                FragmentCourseAttendedBinding fragmentCourseAttendedBinding2 = this$0.get_binding();
                if (fragmentCourseAttendedBinding2 != null && (rvCourse2 = fragmentCourseAttendedBinding2.rvCourse) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvCourse2, "rvCourse");
                    ToastExtKt.showSuccessToast(rvCourse2, successResponse.getMessage());
                }
                this$0.getCoursesAttendedViewModel().getCoursesAttendedData();
                return;
            }
            FragmentCourseAttendedBinding fragmentCourseAttendedBinding3 = this$0.get_binding();
            if (fragmentCourseAttendedBinding3 == null || (rvCourse = fragmentCourseAttendedBinding3.rvCourse) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvCourse, "rvCourse");
            ToastExtKt.showErrorToast(rvCourse, successResponse.getMessage());
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding = get_binding();
        if (fragmentCourseAttendedBinding == null || (recyclerView = fragmentCourseAttendedBinding.rvCourse) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentCourseAttendedBinding fragmentCourseAttendedBinding = get_binding();
        if (fragmentCourseAttendedBinding == null || (recyclerView = fragmentCourseAttendedBinding.rvCourse) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.profile.coursesattended.CoursesAttendedAdapter.CoursesListener
    public void downloadFile(String url, String position) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(position, "position");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        startActivity(Intent.createChooser(intent, "Open With"));
    }

    @Override // in.etuwa.app.ui.profile.coursesattended.CoursesAttendedAdapter.CoursesListener
    public void editBtnClicked(String id, String name, String organised, String duration, String achievements, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(organised, "organised");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddCourseAttendedDialog newInstance = AddCourseAttendedDialog.INSTANCE.newInstance(id, name, organised, duration, achievements, fromDate, toDate);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void deleteView(final String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Are you sure you want to Delete?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CoursesAttendedFragment.deleteView$lambda$6(CoursesAttendedFragment.this, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CoursesAttendedFragment.deleteView$lambda$7(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteView$lambda$6(CoursesAttendedFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getCoursesAttendedViewModel().deleteCourseData(id);
    }

    @Override // in.etuwa.app.ui.profile.coursesattended.CoursesAttendedAdapter.CoursesListener
    public void deleteBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        deleteView(id);
    }

    @Override // in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog.AddCourseListener
    public void onDismiss() {
        getCoursesAttendedViewModel().getCoursesAttendedData();
    }
}