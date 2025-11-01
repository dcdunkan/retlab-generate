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

/* compiled from: GraduateSurveyQuestionsFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020'H\u0014J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00107\u001a\u00020'H\u0016J\u001a\u00108\u001a\u00020'2\u0006\u00109\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010:\u001a\u00020'H\u0014J\b\u0010;\u001a\u00020'H\u0014J\b\u0010<\u001a\u00020'H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter$SurveyCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentGraduateExitSurveyQuestionsBinding;", "adapter", "Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter;", "getAdapter", "()Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentGraduateExitSurveyQuestionsBinding;", "graduateSurveyQuestionsViewModel", "Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsViewModel;", "getGraduateSurveyQuestionsViewModel", "()Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsViewModel;", "graduateSurveyQuestionsViewModel$delegate", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "sessionId", "submitAnswer", "Ljava/util/HashMap;", "getSubmitAnswer", "()Ljava/util/HashMap;", "surveyList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/graduateexit/DoGraduateSurveyQuestions;", "Lkotlin/collections/ArrayList;", "hideBaseView", "", "hideProgress", "listenResponse", "listenSubmitResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GraduateSurveyQuestionsFragment extends BaseFragment implements GraduateSurveyQuestionsAdapter.SurveyCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentGraduateExitSurveyQuestionsBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: graduateSurveyQuestionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy graduateSurveyQuestionsViewModel;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String sessionId;
    private final HashMap<String, String> submitAnswer;
    private ArrayList<DoGraduateSurveyQuestions> surveyList;

    /* compiled from: GraduateSurveyQuestionsFragment.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(GraduateSurveyQuestionsViewModel.class), qualifier, b, null, koinScope);
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

    /* renamed from: getBinding, reason: from getter */
    private final FragmentGraduateExitSurveyQuestionsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final HashMap<String, String> getSubmitAnswer() {
        return this.submitAnswer;
    }

    /* compiled from: GraduateSurveyQuestionsFragment.kt */
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
                GraduateSurveyQuestionsFragment.setUp$lambda$1(GraduateSurveyQuestionsFragment.this, view);
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
        HashMap<String, String> hashMap = this$0.submitAnswer;
        String str = this$0.sessionId;
        Intrinsics.checkNotNull(str);
        hashMap.put("id", str);
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
                GraduateSurveyQuestionsFragment.listenResponse$lambda$3(GraduateSurveyQuestionsFragment.this, (Resource) obj);
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
                GraduateSurveyQuestionsFragment.listenSubmitResponse$lambda$5(GraduateSurveyQuestionsFragment.this, (Resource) obj);
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