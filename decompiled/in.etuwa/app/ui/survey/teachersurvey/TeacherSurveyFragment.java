package in.etuwa.app.ui.survey.teachersurvey;

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
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.survey.TeacherList;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentTeacherSurveyListBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: TeacherSurveyFragment.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J0\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020$H\u0014J\b\u0010+\u001a\u00020$H\u0014J\b\u0010,\u001a\u00020$H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00109\u001a\u00020$H\u0016J\u001a\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u0010<\u001a\u00020$H\u0014J\b\u0010=\u001a\u00020$H\u0014J\b\u0010>\u001a\u00020$H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!¨\u0006@"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyAdapter$SurveyCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentTeacherSurveyListBinding;", "adapter", "Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyAdapter;", "getAdapter", "()Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentTeacherSurveyListBinding;", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "teacherSurveyViewModel", "Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyViewModel;", "getTeacherSurveyViewModel", "()Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyViewModel;", "teacherSurveyViewModel$delegate", "doTheSurvey", "", "teacherId", "subjectId", SvgConstants.Tags.IMAGE, AttendanceDayDialogKt.ARG_SEM, "subject", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TeacherSurveyFragment extends BaseFragment implements TeacherSurveyAdapter.SurveyCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTeacherSurveyListBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: teacherSurveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy teacherSurveyViewModel;

    /* compiled from: TeacherSurveyFragment.kt */
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
    public static final TeacherSurveyFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TeacherSurveyFragment() {
        final TeacherSurveyFragment teacherSurveyFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(teacherSurveyFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.teacherSurveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(teacherSurveyFragment, Reflection.getOrCreateKotlinClass(TeacherSurveyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TeacherSurveyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TeacherSurveyFragment teacherSurveyFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TeacherSurveyAdapter>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TeacherSurveyAdapter invoke() {
                ComponentCallbacks componentCallbacks = teacherSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TeacherSurveyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = teacherSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final TeacherSurveyViewModel getTeacherSurveyViewModel() {
        return (TeacherSurveyViewModel) this.teacherSurveyViewModel.getValue();
    }

    private final TeacherSurveyAdapter getAdapter() {
        return (TeacherSurveyAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentTeacherSurveyListBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    /* compiled from: TeacherSurveyFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TeacherSurveyFragment newInstance(String id) {
            TeacherSurveyFragment teacherSurveyFragment = new TeacherSurveyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            teacherSurveyFragment.setArguments(bundle);
            return teacherSurveyFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTeacherSurveyListBinding.inflate(inflater, container, false);
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        if (fragmentTeacherSurveyListBinding != null) {
            fragmentTeacherSurveyListBinding.setTeacherSurveyViewModel(getTeacherSurveyViewModel());
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding2 = get_binding();
        if (fragmentTeacherSurveyListBinding2 != null) {
            fragmentTeacherSurveyListBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding3 = get_binding();
        if (fragmentTeacherSurveyListBinding3 != null) {
            return fragmentTeacherSurveyListBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Teacher Survey");
        }
        hideBaseView();
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        RecyclerView recyclerView = fragmentTeacherSurveyListBinding != null ? fragmentTeacherSurveyListBinding.rvTeacherSurvey : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        TeacherSurveyViewModel teacherSurveyViewModel = getTeacherSurveyViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        teacherSurveyViewModel.getSurveyList(str);
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding2 = get_binding();
        if (fragmentTeacherSurveyListBinding2 == null || (swipeRefreshLayout = fragmentTeacherSurveyListBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                TeacherSurveyFragment.setUp$lambda$1(TeacherSurveyFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TeacherSurveyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeacherSurveyViewModel teacherSurveyViewModel = this$0.getTeacherSurveyViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        teacherSurveyViewModel.getSurveyList(str);
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentTeacherSurveyListBinding != null ? fragmentTeacherSurveyListBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getTeacherSurveyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherSurveyFragment.listenResponse$lambda$3(TeacherSurveyFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(TeacherSurveyFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
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
            FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = this$0.get_binding();
            if (fragmentTeacherSurveyListBinding == null || (recyclerView = fragmentTeacherSurveyListBinding.rvTeacherSurvey) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ArrayList<TeacherList> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.showBaseView();
            this$0.getAdapter().addItems(arrayList);
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    if (Intrinsics.areEqual(arrayList.get(i2).getStatus(), "Completed")) {
                        this$0.flag = true;
                        i2++;
                    } else {
                        this$0.flag = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!this$0.flag || (mainCallBackListener = this$0.listener) == null) {
                return;
            }
            mainCallBackListener.onSurveyCompleted(false, this$0.id);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        if (fragmentTeacherSurveyListBinding == null || (recyclerView = fragmentTeacherSurveyListBinding.rvTeacherSurvey) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        if (fragmentTeacherSurveyListBinding == null || (recyclerView = fragmentTeacherSurveyListBinding.rvTeacherSurvey) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter.SurveyCallBack
    public void doTheSurvey(String teacherId, String subjectId, String image, String semester, String subject) {
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(subject, "subject");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            String str = this.id;
            Intrinsics.checkNotNull(str);
            mainCallBackListener.doTeacherSurvey(str, teacherId, subjectId, image, semester, subject);
        }
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
}