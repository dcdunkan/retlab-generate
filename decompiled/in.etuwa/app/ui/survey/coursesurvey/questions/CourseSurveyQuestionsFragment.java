package in.etuwa.app.ui.survey.coursesurvey.questions;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyQuestions;
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyQuestionsResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentCourseSurveyQuestionsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.message.reply.ReplyDialogKt;
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
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

/* JADX INFO: compiled from: CourseSurveyQuestionsFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class CourseSurveyQuestionsFragment extends BaseFragment implements CourseSurveyQuestionsAdapter.SurveyCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentCourseSurveyQuestionsBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: courseSurveyQuestionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy courseSurveyQuestionsViewModel;
    private String id;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String sessionId;
    private final HashMap<String, String> submitAnswer;
    private ArrayList<CourseSurveyQuestions> surveyList;

    /* JADX INFO: compiled from: CourseSurveyQuestionsFragment.kt */
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
    public static final CourseSurveyQuestionsFragment newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public CourseSurveyQuestionsFragment() {
        final CourseSurveyQuestionsFragment courseSurveyQuestionsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return courseSurveyQuestionsFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(courseSurveyQuestionsFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.courseSurveyQuestionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(courseSurveyQuestionsFragment, Reflection.getOrCreateKotlinClass(CourseSurveyQuestionsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(CourseSurveyQuestionsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CourseSurveyQuestionsFragment courseSurveyQuestionsFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CourseSurveyQuestionsAdapter>() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CourseSurveyQuestionsAdapter invoke() {
                ComponentCallbacks componentCallbacks = courseSurveyQuestionsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CourseSurveyQuestionsAdapter.class), b2, b3);
            }
        });
        this.surveyList = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = courseSurveyQuestionsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.submitAnswer = new HashMap<>();
    }

    private final CourseSurveyQuestionsViewModel getCourseSurveyQuestionsViewModel() {
        return (CourseSurveyQuestionsViewModel) this.courseSurveyQuestionsViewModel.getValue();
    }

    private final CourseSurveyQuestionsAdapter getAdapter() {
        return (CourseSurveyQuestionsAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentCourseSurveyQuestionsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final HashMap<String, String> getSubmitAnswer() {
        return this.submitAnswer;
    }

    /* JADX INFO: compiled from: CourseSurveyQuestionsFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsFragment;", "id", "", "sessionId", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CourseSurveyQuestionsFragment newInstance(String id, String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            CourseSurveyQuestionsFragment courseSurveyQuestionsFragment = new CourseSurveyQuestionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(ReplyDialogKt.ARG_SENDER_ID, sessionId);
            courseSurveyQuestionsFragment.setArguments(bundle);
            return courseSurveyQuestionsFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.sessionId = arguments.getString(ReplyDialogKt.ARG_SENDER_ID);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentCourseSurveyQuestionsBinding.inflate(inflater, container, false);
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding = get_binding();
        if (fragmentCourseSurveyQuestionsBinding != null) {
            fragmentCourseSurveyQuestionsBinding.setCourseSurveyQuestionsViewModel(getCourseSurveyQuestionsViewModel());
        }
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding2 = get_binding();
        if (fragmentCourseSurveyQuestionsBinding2 != null) {
            fragmentCourseSurveyQuestionsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding3 = get_binding();
        if (fragmentCourseSurveyQuestionsBinding3 != null) {
            return fragmentCourseSurveyQuestionsBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Course Evaluation Survey");
        }
        hideBaseView();
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding = get_binding();
        RecyclerView recyclerView = fragmentCourseSurveyQuestionsBinding != null ? fragmentCourseSurveyQuestionsBinding.rvSurveyQuestions : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenSubmitResponse();
        CourseSurveyQuestionsViewModel courseSurveyQuestionsViewModel = getCourseSurveyQuestionsViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        courseSurveyQuestionsViewModel.getSurveyQuestions(str);
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding2 = get_binding();
        if (fragmentCourseSurveyQuestionsBinding2 == null || (textView = fragmentCourseSurveyQuestionsBinding2.submitAnswer) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CourseSurveyQuestionsFragment.setUp$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CourseSurveyQuestionsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.submitAnswer.clear();
        ArrayList<CourseSurveyQuestions> items = this$0.getAdapter().getItems();
        this$0.surveyList = items;
        System.out.println(items);
        HashMap<String, String> map = this$0.submitAnswer;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        map.put("session_id", str);
        HashMap<String, String> map2 = this$0.submitAnswer;
        String str2 = this$0.sessionId;
        Intrinsics.checkNotNull(str2);
        map2.put("subject_id", str2);
        int size = this$0.surveyList.size();
        for (int i = 0; i < size; i++) {
            this$0.submitAnswer.put("SurveyCourseOption[" + this$0.surveyList.get(i).getQ_id() + "]", this$0.surveyList.get(i).getAnswer_id());
        }
        System.out.println(this$0.submitAnswer);
        this$0.getCourseSurveyQuestionsViewModel().getSurveyQuestions(this$0.submitAnswer);
    }

    private final void listenResponse() {
        getCourseSurveyQuestionsViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CourseSurveyQuestionsFragment.listenResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(CourseSurveyQuestionsFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            CourseSurveyQuestionsResponse courseSurveyQuestionsResponse = (CourseSurveyQuestionsResponse) resource.getData();
            if (courseSurveyQuestionsResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(courseSurveyQuestionsResponse.getQuestions());
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
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding = this$0.get_binding();
        if (fragmentCourseSurveyQuestionsBinding == null || (recyclerView = fragmentCourseSurveyQuestionsBinding.rvSurveyQuestions) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenSubmitResponse() {
        getCourseSurveyQuestionsViewModel().getSubmitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CourseSurveyQuestionsFragment.listenSubmitResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSubmitResponse$lambda$5(CourseSurveyQuestionsFragment this$0, Resource resource) {
        RecyclerView rvSurveyQuestions;
        RecyclerView rvSurveyQuestions2;
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
            FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding = this$0.get_binding();
            if (fragmentCourseSurveyQuestionsBinding == null || (recyclerView = fragmentCourseSurveyQuestionsBinding.rvSurveyQuestions) == null) {
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
            if (successResponse.getLogin() && successResponse.getSuccess()) {
                FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding2 = this$0.get_binding();
                if (fragmentCourseSurveyQuestionsBinding2 != null && (rvSurveyQuestions2 = fragmentCourseSurveyQuestionsBinding2.rvSurveyQuestions) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvSurveyQuestions2, "rvSurveyQuestions");
                    ToastExtKt.showSuccessToast(rvSurveyQuestions2, successResponse.getMessage());
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    mainCallBackListener.onCourseSurveyCompleted(str);
                    return;
                }
                return;
            }
            FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding3 = this$0.get_binding();
            if (fragmentCourseSurveyQuestionsBinding3 == null || (rvSurveyQuestions = fragmentCourseSurveyQuestionsBinding3.rvSurveyQuestions) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvSurveyQuestions, "rvSurveyQuestions");
            ToastExtKt.showErrorToast(rvSurveyQuestions, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding = get_binding();
        if (fragmentCourseSurveyQuestionsBinding == null || (recyclerView = fragmentCourseSurveyQuestionsBinding.rvSurveyQuestions) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentCourseSurveyQuestionsBinding fragmentCourseSurveyQuestionsBinding = get_binding();
        if (fragmentCourseSurveyQuestionsBinding == null || (recyclerView = fragmentCourseSurveyQuestionsBinding.rvSurveyQuestions) == null) {
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
}