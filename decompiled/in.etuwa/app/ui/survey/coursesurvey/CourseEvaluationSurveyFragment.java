package in.etuwa.app.ui.survey.coursesurvey;

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
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentCourseSurveyBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyAdapter;
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsAdapter;
import in.etuwa.app.ui.survey.posurvey.POSurveyAdapter;
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

/* compiled from: CourseEvaluationSurveyFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001BB\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020*H\u0014J\b\u0010.\u001a\u00020*H\u0014J\b\u0010/\u001a\u00020*H\u0002J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u00020*2\b\u00104\u001a\u0004\u0018\u000105H\u0016J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010<\u001a\u00020*H\u0016J\u001a\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u0002072\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010?\u001a\u00020*H\u0014J\b\u0010@\u001a\u00020*H\u0014J\b\u0010A\u001a\u00020*H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b&\u0010'¨\u0006C"}, d2 = {"Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyAdapter$SurveyCallBack;", "Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsAdapter$SurveyCallBack;", "Lin/etuwa/app/ui/survey/posurvey/POSurveyAdapter$SurveyCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentCourseSurveyBinding;", "adapter", "Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyAdapter;", "getAdapter", "()Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentCourseSurveyBinding;", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "i", "", "getI", "()I", "setI", "(I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "surveyViewModel", "Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyViewModel;", "getSurveyViewModel", "()Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyViewModel;", "surveyViewModel$delegate", "doTheSurvey", "", "id", "", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CourseEvaluationSurveyFragment extends BaseFragment implements CourseEvaluationSurveyAdapter.SurveyCallBack, CourseSurveyQuestionsAdapter.SurveyCallBack, POSurveyAdapter.SurveyCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentCourseSurveyBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;
    private int i;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: surveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveyViewModel;

    /* compiled from: CourseEvaluationSurveyFragment.kt */
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
    public static final CourseEvaluationSurveyFragment newInstance(Integer num) {
        return INSTANCE.newInstance(num);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public CourseEvaluationSurveyFragment() {
        final CourseEvaluationSurveyFragment courseEvaluationSurveyFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(courseEvaluationSurveyFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.surveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(courseEvaluationSurveyFragment, Reflection.getOrCreateKotlinClass(CourseEvaluationSurveyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CourseEvaluationSurveyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CourseEvaluationSurveyFragment courseEvaluationSurveyFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CourseEvaluationSurveyAdapter>() { // from class: in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CourseEvaluationSurveyAdapter invoke() {
                ComponentCallbacks componentCallbacks = courseEvaluationSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CourseEvaluationSurveyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = courseEvaluationSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final CourseEvaluationSurveyViewModel getSurveyViewModel() {
        return (CourseEvaluationSurveyViewModel) this.surveyViewModel.getValue();
    }

    private final CourseEvaluationSurveyAdapter getAdapter() {
        return (CourseEvaluationSurveyAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentCourseSurveyBinding get_binding() {
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

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    /* compiled from: CourseEvaluationSurveyFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyFragment;", "id", "", "(Ljava/lang/Integer;)Lin/etuwa/app/ui/survey/coursesurvey/CourseEvaluationSurveyFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CourseEvaluationSurveyFragment newInstance(Integer id) {
            CourseEvaluationSurveyFragment courseEvaluationSurveyFragment = new CourseEvaluationSurveyFragment();
            Bundle bundle = new Bundle();
            Intrinsics.checkNotNull(id);
            bundle.putInt("id", id.intValue());
            courseEvaluationSurveyFragment.setArguments(bundle);
            return courseEvaluationSurveyFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getInt("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentCourseSurveyBinding.inflate(inflater, container, false);
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding = get_binding();
        if (fragmentCourseSurveyBinding != null) {
            fragmentCourseSurveyBinding.setSurveyViewModel(getSurveyViewModel());
        }
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding2 = get_binding();
        if (fragmentCourseSurveyBinding2 != null) {
            fragmentCourseSurveyBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding3 = get_binding();
        if (fragmentCourseSurveyBinding3 != null) {
            return fragmentCourseSurveyBinding3.getRoot();
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
            activity.setTitle("Course Evaluation Survey");
        }
        hideBaseView();
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding = get_binding();
        RecyclerView recyclerView = fragmentCourseSurveyBinding != null ? fragmentCourseSurveyBinding.rvSurvey : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        getSurveyViewModel().getSurveyList();
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding2 = get_binding();
        if (fragmentCourseSurveyBinding2 == null || (swipeRefreshLayout = fragmentCourseSurveyBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                CourseEvaluationSurveyFragment.setUp$lambda$1(CourseEvaluationSurveyFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CourseEvaluationSurveyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSurveyViewModel().getSurveyList();
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentCourseSurveyBinding != null ? fragmentCourseSurveyBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getSurveyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CourseEvaluationSurveyFragment.listenResponse$lambda$3(CourseEvaluationSurveyFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(CourseEvaluationSurveyFragment this$0, Resource resource) {
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
            FragmentCourseSurveyBinding fragmentCourseSurveyBinding = this$0.get_binding();
            if (fragmentCourseSurveyBinding == null || (recyclerView = fragmentCourseSurveyBinding.rvSurvey) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        CourseSurveyResponse courseSurveyResponse = (CourseSurveyResponse) resource.getData();
        if (courseSurveyResponse != null) {
            this$0.showBaseView();
            this$0.getAdapter().addItems(courseSurveyResponse.getSurvey());
            int size = courseSurveyResponse.getSurvey().size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    if (Intrinsics.areEqual(courseSurveyResponse.getSurvey().get(i2).getBtn(), "Completed") || Intrinsics.areEqual(courseSurveyResponse.getSurvey().get(i2).getBtn(), "Last Date Over")) {
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
            if (this$0.flag && this$0.i == 1 && (mainCallBackListener = this$0.listener) != null) {
                mainCallBackListener.onSurveyFullyCompleted(true, "");
            }
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding = get_binding();
        if (fragmentCourseSurveyBinding == null || (recyclerView = fragmentCourseSurveyBinding.rvSurvey) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentCourseSurveyBinding fragmentCourseSurveyBinding = get_binding();
        if (fragmentCourseSurveyBinding == null || (recyclerView = fragmentCourseSurveyBinding.rvSurvey) == null) {
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
        } else {
            super.onAttach(context);
        }
    }

    @Override // in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyAdapter.SurveyCallBack, in.etuwa.app.ui.survey.posurvey.POSurveyAdapter.SurveyCallBack
    public void doTheSurvey(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showCourseSurveySubjects(id);
        }
    }
}