package in.etuwa.app.ui.survey.graduateexit.questions;

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
import in.etuwa.app.data.model.survey.graduateexit.DoGraduateSurveyQuestions;
import in.etuwa.app.data.model.survey.graduateexit.DoGraduateSurveyResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentGraduateExitSurveyQuestionsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.message.reply.ReplyDialogKt;
import in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsAdapter;
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

/* JADX INFO: compiled from: GraduateSurveyQuestionsFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class GraduateSurveyQuestionsFragment extends BaseFragment implements GraduateSurveyQuestionsAdapter.SurveyCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentGraduateExitSurveyQuestionsBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: graduateSurveyQuestionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy graduateSurveyQuestionsViewModel;
    private String id;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String sessionId;
    private final HashMap<String, String> submitAnswer;
    private ArrayList<DoGraduateSurveyQuestions> surveyList;

    /* JADX INFO: compiled from: GraduateSurveyQuestionsFragment.kt */
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
    public static final GraduateSurveyQuestionsFragment newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public GraduateSurveyQuestionsFragment() {
        final GraduateSurveyQuestionsFragment graduateSurveyQuestionsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return graduateSurveyQuestionsFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(graduateSurveyQuestionsFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.graduateSurveyQuestionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(graduateSurveyQuestionsFragment, Reflection.getOrCreateKotlinClass(GraduateSurveyQuestionsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(GraduateSurveyQuestionsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final GraduateSurveyQuestionsFragment graduateSurveyQuestionsFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GraduateSurveyQuestionsAdapter>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GraduateSurveyQuestionsAdapter invoke() {
                ComponentCallbacks componentCallbacks = graduateSurveyQuestionsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(GraduateSurveyQuestionsAdapter.class), b2, b3);
            }
        });
        this.surveyList = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = graduateSurveyQuestionsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.submitAnswer = new HashMap<>();
    }

    private final GraduateSurveyQuestionsViewModel getGraduateSurveyQuestionsViewModel() {
        return (GraduateSurveyQuestionsViewModel) this.graduateSurveyQuestionsViewModel.getValue();
    }

    private final GraduateSurveyQuestionsAdapter getAdapter() {
        return (GraduateSurveyQuestionsAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentGraduateExitSurveyQuestionsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final HashMap<String, String> getSubmitAnswer() {
        return this.submitAnswer;
    }

    /* JADX INFO: compiled from: GraduateSurveyQuestionsFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsFragment;", "id", "", "sessionId", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GraduateSurveyQuestionsFragment newInstance(String id, String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            GraduateSurveyQuestionsFragment graduateSurveyQuestionsFragment = new GraduateSurveyQuestionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(ReplyDialogKt.ARG_SENDER_ID, sessionId);
            graduateSurveyQuestionsFragment.setArguments(bundle);
            return graduateSurveyQuestionsFragment;
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
        this._binding = FragmentGraduateExitSurveyQuestionsBinding.inflate(inflater, container, false);
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding = get_binding();
        if (fragmentGraduateExitSurveyQuestionsBinding != null) {
            fragmentGraduateExitSurveyQuestionsBinding.setGraduateSurveyQuestionsViewModel(getGraduateSurveyQuestionsViewModel());
        }
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding2 = get_binding();
        if (fragmentGraduateExitSurveyQuestionsBinding2 != null) {
            fragmentGraduateExitSurveyQuestionsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding3 = get_binding();
        if (fragmentGraduateExitSurveyQuestionsBinding3 != null) {
            return fragmentGraduateExitSurveyQuestionsBinding3.getRoot();
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
            activity.setTitle("Graduate Exit Survey");
        }
        hideBaseView();
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding = get_binding();
        RecyclerView recyclerView = fragmentGraduateExitSurveyQuestionsBinding != null ? fragmentGraduateExitSurveyQuestionsBinding.rvSurveyQuestions : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenSubmitResponse();
        GraduateSurveyQuestionsViewModel graduateSurveyQuestionsViewModel = getGraduateSurveyQuestionsViewModel();
        String str = this.sessionId;
        Intrinsics.checkNotNull(str);
        graduateSurveyQuestionsViewModel.getSurveyQuestions(str);
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding2 = get_binding();
        if (fragmentGraduateExitSurveyQuestionsBinding2 == null || (textView = fragmentGraduateExitSurveyQuestionsBinding2.submitAnswer) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GraduateSurveyQuestionsFragment.setUp$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(GraduateSurveyQuestionsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.submitAnswer.clear();
        ArrayList<DoGraduateSurveyQuestions> items = this$0.getAdapter().getItems();
        this$0.surveyList = items;
        System.out.println(items);
        HashMap<String, String> map = this$0.submitAnswer;
        String str = this$0.sessionId;
        Intrinsics.checkNotNull(str);
        map.put("id", str);
        int size = this$0.surveyList.size();
        for (int i = 0; i < size; i++) {
            this$0.submitAnswer.put("GraduateExitOption[" + this$0.surveyList.get(i).getQ_id() + "]", this$0.surveyList.get(i).getAnswer_id());
        }
        System.out.println(this$0.submitAnswer);
        this$0.getGraduateSurveyQuestionsViewModel().getSurveyQuestions(this$0.submitAnswer);
    }

    private final void listenResponse() {
        getGraduateSurveyQuestionsViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GraduateSurveyQuestionsFragment.listenResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(GraduateSurveyQuestionsFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            DoGraduateSurveyResponse doGraduateSurveyResponse = (DoGraduateSurveyResponse) resource.getData();
            if (doGraduateSurveyResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(doGraduateSurveyResponse.getGequestions());
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
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding = this$0.get_binding();
        if (fragmentGraduateExitSurveyQuestionsBinding == null || (recyclerView = fragmentGraduateExitSurveyQuestionsBinding.rvSurveyQuestions) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenSubmitResponse() {
        getGraduateSurveyQuestionsViewModel().getSubmitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GraduateSurveyQuestionsFragment.listenSubmitResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSubmitResponse$lambda$5(GraduateSurveyQuestionsFragment this$0, Resource resource) {
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
            FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding = this$0.get_binding();
            if (fragmentGraduateExitSurveyQuestionsBinding == null || (recyclerView = fragmentGraduateExitSurveyQuestionsBinding.rvSurveyQuestions) == null) {
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
                FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding2 = this$0.get_binding();
                if (fragmentGraduateExitSurveyQuestionsBinding2 != null && (rvSurveyQuestions2 = fragmentGraduateExitSurveyQuestionsBinding2.rvSurveyQuestions) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvSurveyQuestions2, "rvSurveyQuestions");
                    ToastExtKt.showSuccessToast(rvSurveyQuestions2, successResponse.getMessage());
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.onGraduateExitSurveyCompleted();
                    return;
                }
                return;
            }
            FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding3 = this$0.get_binding();
            if (fragmentGraduateExitSurveyQuestionsBinding3 == null || (rvSurveyQuestions = fragmentGraduateExitSurveyQuestionsBinding3.rvSurveyQuestions) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvSurveyQuestions, "rvSurveyQuestions");
            ToastExtKt.showErrorToast(rvSurveyQuestions, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding = get_binding();
        if (fragmentGraduateExitSurveyQuestionsBinding == null || (recyclerView = fragmentGraduateExitSurveyQuestionsBinding.rvSurveyQuestions) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentGraduateExitSurveyQuestionsBinding fragmentGraduateExitSurveyQuestionsBinding = get_binding();
        if (fragmentGraduateExitSurveyQuestionsBinding == null || (recyclerView = fragmentGraduateExitSurveyQuestionsBinding.rvSurveyQuestions) == null) {
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