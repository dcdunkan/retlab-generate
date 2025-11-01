package in.etuwa.app.ui.survey.posurvey.questions;

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
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.survey.posurvey.PoQuestions;
import in.etuwa.app.data.model.survey.posurvey.PoQuestionsResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentPoSurveyQuestionsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsAdapter;
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

/* compiled from: POSurveyQuestionsFragment.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020&H\u0014J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00106\u001a\u00020&H\u0016J\u0018\u00107\u001a\u00020&2\u0006\u00108\u001a\u0002092\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u0010<\u001a\u00020&H\u0014J\b\u0010=\u001a\u00020&H\u0014J\b\u0010>\u001a\u00020&H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsAdapter$SurveyCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentPoSurveyQuestionsBinding;", "adapter", "Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsAdapter;", "getAdapter", "()Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentPoSurveyQuestionsBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "poSurveyQuestionsViewModel", "Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsViewModel;", "getPoSurveyQuestionsViewModel", "()Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsViewModel;", "poSurveyQuestionsViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "submitAnswer", "Ljava/util/HashMap;", "getSubmitAnswer", "()Ljava/util/HashMap;", "surveyList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/posurvey/PoQuestions;", "Lkotlin/collections/ArrayList;", "hideBaseView", "", "hideProgress", "listenResponse", "listenSubmitResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onRadioBtnClicked", CommonCssConstants.POSITION, "", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class POSurveyQuestionsFragment extends BaseFragment implements POSurveyQuestionsAdapter.SurveyCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentPoSurveyQuestionsBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: poSurveyQuestionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy poSurveyQuestionsViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private final HashMap<String, String> submitAnswer;
    private ArrayList<PoQuestions> surveyList;

    /* compiled from: POSurveyQuestionsFragment.kt */
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
    public static final POSurveyQuestionsFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public POSurveyQuestionsFragment() {
        final POSurveyQuestionsFragment pOSurveyQuestionsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(pOSurveyQuestionsFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.poSurveyQuestionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(pOSurveyQuestionsFragment, Reflection.getOrCreateKotlinClass(POSurveyQuestionsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(POSurveyQuestionsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final POSurveyQuestionsFragment pOSurveyQuestionsFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<POSurveyQuestionsAdapter>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final POSurveyQuestionsAdapter invoke() {
                ComponentCallbacks componentCallbacks = pOSurveyQuestionsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(POSurveyQuestionsAdapter.class), b2, b3);
            }
        });
        this.surveyList = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = pOSurveyQuestionsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.submitAnswer = new HashMap<>();
    }

    private final POSurveyQuestionsViewModel getPoSurveyQuestionsViewModel() {
        return (POSurveyQuestionsViewModel) this.poSurveyQuestionsViewModel.getValue();
    }

    private final POSurveyQuestionsAdapter getAdapter() {
        return (POSurveyQuestionsAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentPoSurveyQuestionsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final HashMap<String, String> getSubmitAnswer() {
        return this.submitAnswer;
    }

    /* compiled from: POSurveyQuestionsFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/posurvey/questions/POSurveyQuestionsFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final POSurveyQuestionsFragment newInstance(String id) {
            POSurveyQuestionsFragment pOSurveyQuestionsFragment = new POSurveyQuestionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            pOSurveyQuestionsFragment.setArguments(bundle);
            return pOSurveyQuestionsFragment;
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
        this._binding = FragmentPoSurveyQuestionsBinding.inflate(inflater, container, false);
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding = get_binding();
        if (fragmentPoSurveyQuestionsBinding != null) {
            fragmentPoSurveyQuestionsBinding.setPoSurveyQuestionsViewModel(getPoSurveyQuestionsViewModel());
        }
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding2 = get_binding();
        if (fragmentPoSurveyQuestionsBinding2 != null) {
            fragmentPoSurveyQuestionsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding3 = get_binding();
        if (fragmentPoSurveyQuestionsBinding3 != null) {
            return fragmentPoSurveyQuestionsBinding3.getRoot();
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
            activity.setTitle("PO Survey");
        }
        hideBaseView();
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding = get_binding();
        RecyclerView recyclerView = fragmentPoSurveyQuestionsBinding != null ? fragmentPoSurveyQuestionsBinding.rvSurveyQuestions : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenSubmitResponse();
        POSurveyQuestionsViewModel poSurveyQuestionsViewModel = getPoSurveyQuestionsViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        poSurveyQuestionsViewModel.getSurveyQuestions(str);
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding2 = get_binding();
        if (fragmentPoSurveyQuestionsBinding2 == null || (textView = fragmentPoSurveyQuestionsBinding2.submitAnswer) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                POSurveyQuestionsFragment.setUp$lambda$1(POSurveyQuestionsFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(POSurveyQuestionsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.submitAnswer.clear();
        ArrayList<PoQuestions> items = this$0.getAdapter().getItems();
        this$0.surveyList = items;
        System.out.println(items);
        HashMap<String, String> hashMap = this$0.submitAnswer;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        hashMap.put("id", str);
        int size = this$0.surveyList.size();
        for (int i = 0; i < size; i++) {
            this$0.submitAnswer.put("SurveyPoOption[" + this$0.surveyList.get(i).getQ_id() + "]", this$0.surveyList.get(i).getAnswer());
        }
        System.out.println(this$0.submitAnswer);
        this$0.getPoSurveyQuestionsViewModel().getSurveyQuestions(this$0.submitAnswer);
    }

    private final void listenResponse() {
        getPoSurveyQuestionsViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                POSurveyQuestionsFragment.listenResponse$lambda$3(POSurveyQuestionsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(POSurveyQuestionsFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            PoQuestionsResponse poQuestionsResponse = (PoQuestionsResponse) resource.getData();
            if (poQuestionsResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(poQuestionsResponse.getQuestions());
                this$0.surveyList = poQuestionsResponse.getQuestions();
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
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding = this$0.get_binding();
        if (fragmentPoSurveyQuestionsBinding == null || (recyclerView = fragmentPoSurveyQuestionsBinding.rvSurveyQuestions) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenSubmitResponse() {
        getPoSurveyQuestionsViewModel().getSubmitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                POSurveyQuestionsFragment.listenSubmitResponse$lambda$5(POSurveyQuestionsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSubmitResponse$lambda$5(POSurveyQuestionsFragment this$0, Resource resource) {
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
            FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding = this$0.get_binding();
            if (fragmentPoSurveyQuestionsBinding == null || (recyclerView = fragmentPoSurveyQuestionsBinding.rvSurveyQuestions) == null) {
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
            if (successResponse.getSuccess()) {
                FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding2 = this$0.get_binding();
                if (fragmentPoSurveyQuestionsBinding2 != null && (rvSurveyQuestions2 = fragmentPoSurveyQuestionsBinding2.rvSurveyQuestions) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvSurveyQuestions2, "rvSurveyQuestions");
                    ToastExtKt.showSuccessToast(rvSurveyQuestions2, successResponse.getMessage());
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.onPOSurveyCompleted();
                    return;
                }
                return;
            }
            FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding3 = this$0.get_binding();
            if (fragmentPoSurveyQuestionsBinding3 == null || (rvSurveyQuestions = fragmentPoSurveyQuestionsBinding3.rvSurveyQuestions) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvSurveyQuestions, "rvSurveyQuestions");
            ToastExtKt.showErrorToast(rvSurveyQuestions, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding = get_binding();
        if (fragmentPoSurveyQuestionsBinding == null || (recyclerView = fragmentPoSurveyQuestionsBinding.rvSurveyQuestions) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentPoSurveyQuestionsBinding fragmentPoSurveyQuestionsBinding = get_binding();
        if (fragmentPoSurveyQuestionsBinding == null || (recyclerView = fragmentPoSurveyQuestionsBinding.rvSurveyQuestions) == null) {
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

    @Override // in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsAdapter.SurveyCallBack
    public void onRadioBtnClicked(int position, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.surveyList.clear();
        this.surveyList.addAll(getAdapter().getItems());
        getAdapter().addItems(this.surveyList);
    }
}