package in.etuwa.app.ui.survey.posurvey.questionsnew;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.survey.posurvey.PoQuestions;
import in.etuwa.app.data.model.survey.posurvey.PoQuestionsResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentPoQuestionsNewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

/* compiled from: PoSurveyQuestionsNewFragment.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000eH\u0007J\u0018\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u0017H\u0017J\b\u0010B\u001a\u00020<H\u0014J\b\u0010C\u001a\u00020<H\u0014J\b\u0010D\u001a\u00020<H\u0002J\b\u0010E\u001a\u00020<H\u0003J\u0010\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u00020<2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J&\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010R\u001a\u00020<H\u0016J\u001a\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020M2\b\u0010J\u001a\u0004\u0018\u00010KH\u0017J\b\u0010U\u001a\u00020<H\u0015J\b\u0010V\u001a\u00020<H\u0014J\b\u0010W\u001a\u00020<H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u000e\u0010\"\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\"\u00106\u001a\u0016\u0012\u0004\u0012\u000208\u0018\u000107j\n\u0012\u0004\u0012\u000208\u0018\u0001`9X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewAdapter$SurveyCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentPoQuestionsNewBinding;", "adapter", "Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewAdapter;", "getAdapter", "()Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "attendedOrNot", "", "", "getAttendedOrNot", "()Ljava/util/List;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentPoQuestionsNewBinding;", "flag", "", "i", "", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "mandatoryFlag", "getMandatoryFlag", "()Z", "setMandatoryFlag", "(Z)V", "mandatoryQuestions", "getMandatoryQuestions", "option", "poSurveyQuestionsNewViewModel", "Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewViewModel;", "getPoSurveyQuestionsNewViewModel", "()Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewViewModel;", "poSurveyQuestionsNewViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "subjectId", "submitAnswer", "Ljava/util/HashMap;", "getSubmitAnswer", "()Ljava/util/HashMap;", "surveyAnswers", "surveyFlag", "getSurveyFlag", "setSurveyFlag", "surveyResponse", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/posurvey/PoQuestions;", "Lkotlin/collections/ArrayList;", "teacherId", "clearCheckFields", "", "convertHtmlToString", "html", "doTheSurvey", "qNo", "j", "hideBaseView", "hideProgress", "listenAnswerResponse", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PoSurveyQuestionsNewFragment extends BaseFragment implements PoSurveyQuestionsNewAdapter.SurveyCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentPoQuestionsNewBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private final List<String> attendedOrNot;
    private boolean flag;
    private int i;
    private String id;
    private MainCallBackListener listener;
    private boolean mandatoryFlag;
    private final List<String> mandatoryQuestions;
    private String option;

    /* renamed from: poSurveyQuestionsNewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy poSurveyQuestionsNewViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String subjectId;
    private final HashMap<String, String> submitAnswer;
    private List<String> surveyAnswers;
    private boolean surveyFlag;
    private ArrayList<PoQuestions> surveyResponse;
    private String teacherId;

    /* compiled from: PoSurveyQuestionsNewFragment.kt */
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
    public static final PoSurveyQuestionsNewFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public PoSurveyQuestionsNewFragment() {
        final PoSurveyQuestionsNewFragment poSurveyQuestionsNewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(poSurveyQuestionsNewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.poSurveyQuestionsNewViewModel = FragmentViewModelLazyKt.createViewModelLazy(poSurveyQuestionsNewFragment, Reflection.getOrCreateKotlinClass(PoSurveyQuestionsNewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(PoSurveyQuestionsNewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final PoSurveyQuestionsNewFragment poSurveyQuestionsNewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = poSurveyQuestionsNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.surveyAnswers = new ArrayList();
        this.option = "";
        this.submitAnswer = new HashMap<>();
        this.mandatoryQuestions = new ArrayList();
        this.attendedOrNot = new ArrayList();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<PoSurveyQuestionsNewAdapter>() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PoSurveyQuestionsNewAdapter invoke() {
                ComponentCallbacks componentCallbacks = poSurveyQuestionsNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PoSurveyQuestionsNewAdapter.class), b4, b5);
            }
        });
    }

    private final PoSurveyQuestionsNewViewModel getPoSurveyQuestionsNewViewModel() {
        return (PoSurveyQuestionsNewViewModel) this.poSurveyQuestionsNewViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentPoQuestionsNewBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final HashMap<String, String> getSubmitAnswer() {
        return this.submitAnswer;
    }

    public final List<String> getMandatoryQuestions() {
        return this.mandatoryQuestions;
    }

    public final List<String> getAttendedOrNot() {
        return this.attendedOrNot;
    }

    private final PoSurveyQuestionsNewAdapter getAdapter() {
        return (PoSurveyQuestionsNewAdapter) this.adapter.getValue();
    }

    public final boolean getSurveyFlag() {
        return this.surveyFlag;
    }

    public final void setSurveyFlag(boolean z) {
        this.surveyFlag = z;
    }

    public final boolean getMandatoryFlag() {
        return this.mandatoryFlag;
    }

    public final void setMandatoryFlag(boolean z) {
        this.mandatoryFlag = z;
    }

    /* compiled from: PoSurveyQuestionsNewFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PoSurveyQuestionsNewFragment newInstance(String id) {
            PoSurveyQuestionsNewFragment poSurveyQuestionsNewFragment = new PoSurveyQuestionsNewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            poSurveyQuestionsNewFragment.setArguments(bundle);
            return poSurveyQuestionsNewFragment;
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
        this._binding = FragmentPoQuestionsNewBinding.inflate(inflater, container, false);
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = get_binding();
        if (fragmentPoQuestionsNewBinding != null) {
            fragmentPoQuestionsNewBinding.setPoSurveyQuestionsNewViewModel(getPoSurveyQuestionsNewViewModel());
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = get_binding();
        if (fragmentPoQuestionsNewBinding2 != null) {
            fragmentPoQuestionsNewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = get_binding();
        if (fragmentPoQuestionsNewBinding3 != null) {
            return fragmentPoQuestionsNewBinding3.getRoot();
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
        TextView textView2;
        TextView textView3;
        RadioGroup radioGroup;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("PO Survey Questions");
        }
        hideBaseView();
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = get_binding();
        RecyclerView recyclerView = fragmentPoQuestionsNewBinding != null ? fragmentPoQuestionsNewBinding.rvQuestionNo : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenAnswerResponse();
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = get_binding();
        TextView textView4 = fragmentPoQuestionsNewBinding2 != null ? fragmentPoQuestionsNewBinding2.backBtn : null;
        if (textView4 != null) {
            textView4.setVisibility(4);
        }
        PoSurveyQuestionsNewViewModel poSurveyQuestionsNewViewModel = getPoSurveyQuestionsNewViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        poSurveyQuestionsNewViewModel.getSurveyQuestions(str);
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = get_binding();
        LinearLayout linearLayout = fragmentPoQuestionsNewBinding3 != null ? fragmentPoQuestionsNewBinding3.strengthLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding4 = get_binding();
        if (fragmentPoQuestionsNewBinding4 != null && (radioGroup = fragmentPoQuestionsNewBinding4.teacherSurveyQuestionsMultiple) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$$ExternalSyntheticLambda2
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    PoSurveyQuestionsNewFragment.setUp$lambda$1(PoSurveyQuestionsNewFragment.this, radioGroup2, i);
                }
            });
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding5 = get_binding();
        if (fragmentPoQuestionsNewBinding5 != null && (textView3 = fragmentPoQuestionsNewBinding5.nextBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PoSurveyQuestionsNewFragment.setUp$lambda$2(PoSurveyQuestionsNewFragment.this, view);
                }
            });
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding6 = get_binding();
        if (fragmentPoQuestionsNewBinding6 != null && (textView2 = fragmentPoQuestionsNewBinding6.backBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PoSurveyQuestionsNewFragment.setUp$lambda$3(PoSurveyQuestionsNewFragment.this, view);
                }
            });
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding7 = get_binding();
        if (fragmentPoQuestionsNewBinding7 == null || (textView = fragmentPoQuestionsNewBinding7.finishBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PoSurveyQuestionsNewFragment.setUp$lambda$4(PoSurveyQuestionsNewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(PoSurveyQuestionsNewFragment this$0, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.option_1) {
            this$0.option = "0";
            System.out.println();
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_2) {
            this$0.option = "1";
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_3) {
            this$0.option = ExifInterface.GPS_MEASUREMENT_2D;
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_4) {
            this$0.option = ExifInterface.GPS_MEASUREMENT_3D;
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_5) {
            this$0.option = "4";
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_6) {
            this$0.option = "5";
        } else {
            this$0.option = "";
        }
        this$0.surveyAnswers.set(this$0.i, this$0.option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(PoSurveyQuestionsNewFragment this$0, View view) {
        RadioButton radioButton;
        RadioGroup radioGroup;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = this$0.get_binding();
        TextView textView = fragmentPoQuestionsNewBinding != null ? fragmentPoQuestionsNewBinding.backBtn : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        this$0.attendedOrNot.set(this$0.i, "YES");
        PoSurveyQuestionsNewAdapter adapter = this$0.getAdapter();
        List<String> list = this$0.surveyAnswers;
        int i = this$0.i;
        adapter.addItems(list, i + 1, this$0.mandatoryQuestions, this$0.attendedOrNot, i + 1);
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = this$0.get_binding();
        TextView textView2 = fragmentPoQuestionsNewBinding2 != null ? fragmentPoQuestionsNewBinding2.teacherSurveyQuestion : null;
        if (textView2 != null) {
            ArrayList<PoQuestions> arrayList = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList);
            textView2.setText(arrayList.get(this$0.i + 1).getQ_name());
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = this$0.get_binding();
        TextView textView3 = fragmentPoQuestionsNewBinding3 != null ? fragmentPoQuestionsNewBinding3.questionTv : null;
        if (textView3 != null) {
            int i2 = this$0.i + 2;
            ArrayList<PoQuestions> arrayList2 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList2);
            textView3.setText(i2 + RemoteSettings.FORWARD_SLASH_STRING + arrayList2.size());
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding4 = this$0.get_binding();
        TextView textView4 = fragmentPoQuestionsNewBinding4 != null ? fragmentPoQuestionsNewBinding4.teacherSurveyQuestionNo : null;
        if (textView4 != null) {
            textView4.setText("Question " + (this$0.i + 2) + " (Multiple Choice Question)");
        }
        int i3 = this$0.i + 1;
        this$0.i = i3;
        ArrayList<PoQuestions> arrayList3 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList3);
        if (i3 == arrayList3.size() - 1) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding5 = this$0.get_binding();
            TextView textView5 = fragmentPoQuestionsNewBinding5 != null ? fragmentPoQuestionsNewBinding5.finishBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding6 = this$0.get_binding();
            TextView textView6 = fragmentPoQuestionsNewBinding6 != null ? fragmentPoQuestionsNewBinding6.nextBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding7 = this$0.get_binding();
            TextView textView7 = fragmentPoQuestionsNewBinding7 != null ? fragmentPoQuestionsNewBinding7.finishBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding8 = this$0.get_binding();
            TextView textView8 = fragmentPoQuestionsNewBinding8 != null ? fragmentPoQuestionsNewBinding8.nextBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
        }
        ArrayList<PoQuestions> arrayList4 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList4);
        if (arrayList4.get(this$0.i).getOptions().size() == 2) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding9 = this$0.get_binding();
            RadioButton radioButton2 = fragmentPoQuestionsNewBinding9 != null ? fragmentPoQuestionsNewBinding9.option1 : null;
            if (radioButton2 != null) {
                radioButton2.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding10 = this$0.get_binding();
            RadioButton radioButton3 = fragmentPoQuestionsNewBinding10 != null ? fragmentPoQuestionsNewBinding10.option2 : null;
            if (radioButton3 != null) {
                radioButton3.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding11 = this$0.get_binding();
            RadioButton radioButton4 = fragmentPoQuestionsNewBinding11 != null ? fragmentPoQuestionsNewBinding11.option3 : null;
            if (radioButton4 != null) {
                radioButton4.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding12 = this$0.get_binding();
            RadioButton radioButton5 = fragmentPoQuestionsNewBinding12 != null ? fragmentPoQuestionsNewBinding12.option4 : null;
            if (radioButton5 != null) {
                radioButton5.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding13 = this$0.get_binding();
            RadioButton radioButton6 = fragmentPoQuestionsNewBinding13 != null ? fragmentPoQuestionsNewBinding13.option5 : null;
            if (radioButton6 != null) {
                radioButton6.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding14 = this$0.get_binding();
            RadioButton radioButton7 = fragmentPoQuestionsNewBinding14 != null ? fragmentPoQuestionsNewBinding14.option6 : null;
            if (radioButton7 != null) {
                radioButton7.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding15 = this$0.get_binding();
            RadioButton radioButton8 = fragmentPoQuestionsNewBinding15 != null ? fragmentPoQuestionsNewBinding15.option1 : null;
            if (radioButton8 != null) {
                ArrayList<PoQuestions> arrayList5 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList5);
                radioButton8.setText(this$0.convertHtmlToString(arrayList5.get(this$0.i).getOptions().get(0).getOption_name()));
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding16 = this$0.get_binding();
            RadioButton radioButton9 = fragmentPoQuestionsNewBinding16 != null ? fragmentPoQuestionsNewBinding16.option2 : null;
            if (radioButton9 != null) {
                ArrayList<PoQuestions> arrayList6 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList6);
                radioButton9.setText(this$0.convertHtmlToString(arrayList6.get(this$0.i).getOptions().get(1).getOption_name()));
            }
        } else {
            ArrayList<PoQuestions> arrayList7 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList7);
            if (arrayList7.get(this$0.i).getOptions().size() == 3) {
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding17 = this$0.get_binding();
                RadioButton radioButton10 = fragmentPoQuestionsNewBinding17 != null ? fragmentPoQuestionsNewBinding17.option1 : null;
                if (radioButton10 != null) {
                    radioButton10.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding18 = this$0.get_binding();
                RadioButton radioButton11 = fragmentPoQuestionsNewBinding18 != null ? fragmentPoQuestionsNewBinding18.option2 : null;
                if (radioButton11 != null) {
                    radioButton11.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding19 = this$0.get_binding();
                RadioButton radioButton12 = fragmentPoQuestionsNewBinding19 != null ? fragmentPoQuestionsNewBinding19.option3 : null;
                if (radioButton12 != null) {
                    radioButton12.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding20 = this$0.get_binding();
                RadioButton radioButton13 = fragmentPoQuestionsNewBinding20 != null ? fragmentPoQuestionsNewBinding20.option4 : null;
                if (radioButton13 != null) {
                    radioButton13.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding21 = this$0.get_binding();
                RadioButton radioButton14 = fragmentPoQuestionsNewBinding21 != null ? fragmentPoQuestionsNewBinding21.option5 : null;
                if (radioButton14 != null) {
                    radioButton14.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding22 = this$0.get_binding();
                RadioButton radioButton15 = fragmentPoQuestionsNewBinding22 != null ? fragmentPoQuestionsNewBinding22.option6 : null;
                if (radioButton15 != null) {
                    radioButton15.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding23 = this$0.get_binding();
                RadioButton radioButton16 = fragmentPoQuestionsNewBinding23 != null ? fragmentPoQuestionsNewBinding23.option1 : null;
                if (radioButton16 != null) {
                    ArrayList<PoQuestions> arrayList8 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList8);
                    radioButton16.setText(this$0.convertHtmlToString(arrayList8.get(this$0.i).getOptions().get(0).getOption_name()));
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding24 = this$0.get_binding();
                RadioButton radioButton17 = fragmentPoQuestionsNewBinding24 != null ? fragmentPoQuestionsNewBinding24.option2 : null;
                if (radioButton17 != null) {
                    ArrayList<PoQuestions> arrayList9 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList9);
                    radioButton17.setText(this$0.convertHtmlToString(arrayList9.get(this$0.i).getOptions().get(1).getOption_name()));
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding25 = this$0.get_binding();
                RadioButton radioButton18 = fragmentPoQuestionsNewBinding25 != null ? fragmentPoQuestionsNewBinding25.option3 : null;
                if (radioButton18 != null) {
                    ArrayList<PoQuestions> arrayList10 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList10);
                    radioButton18.setText(this$0.convertHtmlToString(arrayList10.get(this$0.i).getOptions().get(2).getOption_name()));
                }
            } else {
                ArrayList<PoQuestions> arrayList11 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList11);
                if (arrayList11.get(this$0.i).getOptions().size() == 4) {
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding26 = this$0.get_binding();
                    RadioButton radioButton19 = fragmentPoQuestionsNewBinding26 != null ? fragmentPoQuestionsNewBinding26.option1 : null;
                    if (radioButton19 != null) {
                        radioButton19.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding27 = this$0.get_binding();
                    RadioButton radioButton20 = fragmentPoQuestionsNewBinding27 != null ? fragmentPoQuestionsNewBinding27.option2 : null;
                    if (radioButton20 != null) {
                        radioButton20.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding28 = this$0.get_binding();
                    RadioButton radioButton21 = fragmentPoQuestionsNewBinding28 != null ? fragmentPoQuestionsNewBinding28.option3 : null;
                    if (radioButton21 != null) {
                        radioButton21.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding29 = this$0.get_binding();
                    RadioButton radioButton22 = fragmentPoQuestionsNewBinding29 != null ? fragmentPoQuestionsNewBinding29.option4 : null;
                    if (radioButton22 != null) {
                        radioButton22.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding30 = this$0.get_binding();
                    RadioButton radioButton23 = fragmentPoQuestionsNewBinding30 != null ? fragmentPoQuestionsNewBinding30.option5 : null;
                    if (radioButton23 != null) {
                        radioButton23.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding31 = this$0.get_binding();
                    RadioButton radioButton24 = fragmentPoQuestionsNewBinding31 != null ? fragmentPoQuestionsNewBinding31.option6 : null;
                    if (radioButton24 != null) {
                        radioButton24.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding32 = this$0.get_binding();
                    RadioButton radioButton25 = fragmentPoQuestionsNewBinding32 != null ? fragmentPoQuestionsNewBinding32.option1 : null;
                    if (radioButton25 != null) {
                        ArrayList<PoQuestions> arrayList12 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList12);
                        radioButton25.setText(this$0.convertHtmlToString(arrayList12.get(this$0.i).getOptions().get(0).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding33 = this$0.get_binding();
                    RadioButton radioButton26 = fragmentPoQuestionsNewBinding33 != null ? fragmentPoQuestionsNewBinding33.option2 : null;
                    if (radioButton26 != null) {
                        ArrayList<PoQuestions> arrayList13 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList13);
                        radioButton26.setText(this$0.convertHtmlToString(arrayList13.get(this$0.i).getOptions().get(1).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding34 = this$0.get_binding();
                    RadioButton radioButton27 = fragmentPoQuestionsNewBinding34 != null ? fragmentPoQuestionsNewBinding34.option3 : null;
                    if (radioButton27 != null) {
                        ArrayList<PoQuestions> arrayList14 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList14);
                        radioButton27.setText(this$0.convertHtmlToString(arrayList14.get(this$0.i).getOptions().get(2).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding35 = this$0.get_binding();
                    RadioButton radioButton28 = fragmentPoQuestionsNewBinding35 != null ? fragmentPoQuestionsNewBinding35.option4 : null;
                    if (radioButton28 != null) {
                        ArrayList<PoQuestions> arrayList15 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList15);
                        radioButton28.setText(this$0.convertHtmlToString(arrayList15.get(this$0.i).getOptions().get(3).getOption_name()));
                    }
                } else {
                    ArrayList<PoQuestions> arrayList16 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList16);
                    if (arrayList16.get(this$0.i).getOptions().size() == 5) {
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding36 = this$0.get_binding();
                        RadioButton radioButton29 = fragmentPoQuestionsNewBinding36 != null ? fragmentPoQuestionsNewBinding36.option1 : null;
                        if (radioButton29 != null) {
                            radioButton29.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding37 = this$0.get_binding();
                        RadioButton radioButton30 = fragmentPoQuestionsNewBinding37 != null ? fragmentPoQuestionsNewBinding37.option2 : null;
                        if (radioButton30 != null) {
                            radioButton30.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding38 = this$0.get_binding();
                        RadioButton radioButton31 = fragmentPoQuestionsNewBinding38 != null ? fragmentPoQuestionsNewBinding38.option3 : null;
                        if (radioButton31 != null) {
                            radioButton31.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding39 = this$0.get_binding();
                        RadioButton radioButton32 = fragmentPoQuestionsNewBinding39 != null ? fragmentPoQuestionsNewBinding39.option4 : null;
                        if (radioButton32 != null) {
                            radioButton32.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding40 = this$0.get_binding();
                        RadioButton radioButton33 = fragmentPoQuestionsNewBinding40 != null ? fragmentPoQuestionsNewBinding40.option5 : null;
                        if (radioButton33 != null) {
                            radioButton33.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding41 = this$0.get_binding();
                        RadioButton radioButton34 = fragmentPoQuestionsNewBinding41 != null ? fragmentPoQuestionsNewBinding41.option6 : null;
                        if (radioButton34 != null) {
                            radioButton34.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding42 = this$0.get_binding();
                        RadioButton radioButton35 = fragmentPoQuestionsNewBinding42 != null ? fragmentPoQuestionsNewBinding42.option1 : null;
                        if (radioButton35 != null) {
                            ArrayList<PoQuestions> arrayList17 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList17);
                            radioButton35.setText(this$0.convertHtmlToString(arrayList17.get(this$0.i).getOptions().get(0).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding43 = this$0.get_binding();
                        RadioButton radioButton36 = fragmentPoQuestionsNewBinding43 != null ? fragmentPoQuestionsNewBinding43.option2 : null;
                        if (radioButton36 != null) {
                            ArrayList<PoQuestions> arrayList18 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList18);
                            radioButton36.setText(this$0.convertHtmlToString(arrayList18.get(this$0.i).getOptions().get(1).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding44 = this$0.get_binding();
                        RadioButton radioButton37 = fragmentPoQuestionsNewBinding44 != null ? fragmentPoQuestionsNewBinding44.option3 : null;
                        if (radioButton37 != null) {
                            ArrayList<PoQuestions> arrayList19 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList19);
                            radioButton37.setText(this$0.convertHtmlToString(arrayList19.get(this$0.i).getOptions().get(2).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding45 = this$0.get_binding();
                        RadioButton radioButton38 = fragmentPoQuestionsNewBinding45 != null ? fragmentPoQuestionsNewBinding45.option4 : null;
                        if (radioButton38 != null) {
                            ArrayList<PoQuestions> arrayList20 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList20);
                            radioButton38.setText(this$0.convertHtmlToString(arrayList20.get(this$0.i).getOptions().get(3).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding46 = this$0.get_binding();
                        RadioButton radioButton39 = fragmentPoQuestionsNewBinding46 != null ? fragmentPoQuestionsNewBinding46.option5 : null;
                        if (radioButton39 != null) {
                            ArrayList<PoQuestions> arrayList21 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList21);
                            radioButton39.setText(this$0.convertHtmlToString(arrayList21.get(this$0.i).getOptions().get(4).getOption_name()));
                        }
                    } else {
                        ArrayList<PoQuestions> arrayList22 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList22);
                        if (arrayList22.get(this$0.i).getOptions().size() == 6) {
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding47 = this$0.get_binding();
                            RadioButton radioButton40 = fragmentPoQuestionsNewBinding47 != null ? fragmentPoQuestionsNewBinding47.option1 : null;
                            if (radioButton40 != null) {
                                radioButton40.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding48 = this$0.get_binding();
                            RadioButton radioButton41 = fragmentPoQuestionsNewBinding48 != null ? fragmentPoQuestionsNewBinding48.option2 : null;
                            if (radioButton41 != null) {
                                radioButton41.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding49 = this$0.get_binding();
                            RadioButton radioButton42 = fragmentPoQuestionsNewBinding49 != null ? fragmentPoQuestionsNewBinding49.option3 : null;
                            if (radioButton42 != null) {
                                radioButton42.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding50 = this$0.get_binding();
                            RadioButton radioButton43 = fragmentPoQuestionsNewBinding50 != null ? fragmentPoQuestionsNewBinding50.option4 : null;
                            if (radioButton43 != null) {
                                radioButton43.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding51 = this$0.get_binding();
                            RadioButton radioButton44 = fragmentPoQuestionsNewBinding51 != null ? fragmentPoQuestionsNewBinding51.option5 : null;
                            if (radioButton44 != null) {
                                radioButton44.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding52 = this$0.get_binding();
                            RadioButton radioButton45 = fragmentPoQuestionsNewBinding52 != null ? fragmentPoQuestionsNewBinding52.option6 : null;
                            if (radioButton45 != null) {
                                radioButton45.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding53 = this$0.get_binding();
                            RadioButton radioButton46 = fragmentPoQuestionsNewBinding53 != null ? fragmentPoQuestionsNewBinding53.option1 : null;
                            if (radioButton46 != null) {
                                ArrayList<PoQuestions> arrayList23 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList23);
                                radioButton46.setText(this$0.convertHtmlToString(arrayList23.get(this$0.i).getOptions().get(0).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding54 = this$0.get_binding();
                            RadioButton radioButton47 = fragmentPoQuestionsNewBinding54 != null ? fragmentPoQuestionsNewBinding54.option2 : null;
                            if (radioButton47 != null) {
                                ArrayList<PoQuestions> arrayList24 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList24);
                                radioButton47.setText(this$0.convertHtmlToString(arrayList24.get(this$0.i).getOptions().get(1).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding55 = this$0.get_binding();
                            RadioButton radioButton48 = fragmentPoQuestionsNewBinding55 != null ? fragmentPoQuestionsNewBinding55.option3 : null;
                            if (radioButton48 != null) {
                                ArrayList<PoQuestions> arrayList25 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList25);
                                radioButton48.setText(this$0.convertHtmlToString(arrayList25.get(this$0.i).getOptions().get(2).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding56 = this$0.get_binding();
                            RadioButton radioButton49 = fragmentPoQuestionsNewBinding56 != null ? fragmentPoQuestionsNewBinding56.option4 : null;
                            if (radioButton49 != null) {
                                ArrayList<PoQuestions> arrayList26 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList26);
                                radioButton49.setText(this$0.convertHtmlToString(arrayList26.get(this$0.i).getOptions().get(3).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding57 = this$0.get_binding();
                            RadioButton radioButton50 = fragmentPoQuestionsNewBinding57 != null ? fragmentPoQuestionsNewBinding57.option5 : null;
                            if (radioButton50 != null) {
                                ArrayList<PoQuestions> arrayList27 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList27);
                                radioButton50.setText(this$0.convertHtmlToString(arrayList27.get(this$0.i).getOptions().get(4).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding58 = this$0.get_binding();
                            RadioButton radioButton51 = fragmentPoQuestionsNewBinding58 != null ? fragmentPoQuestionsNewBinding58.option6 : null;
                            if (radioButton51 != null) {
                                ArrayList<PoQuestions> arrayList28 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList28);
                                radioButton51.setText(this$0.convertHtmlToString(arrayList28.get(this$0.i).getOptions().get(5).getOption_name()));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(this$0.i);
        ArrayList<PoQuestions> arrayList29 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList29);
        if (arrayList29.get(this$0.i).getRequired()) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding59 = this$0.get_binding();
            TextView textView9 = fragmentPoQuestionsNewBinding59 != null ? fragmentPoQuestionsNewBinding59.requiredTv : null;
            if (textView9 != null) {
                textView9.setVisibility(0);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding60 = this$0.get_binding();
            TextView textView10 = fragmentPoQuestionsNewBinding60 != null ? fragmentPoQuestionsNewBinding60.requiredTv : null;
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding61 = this$0.get_binding();
            if (fragmentPoQuestionsNewBinding61 != null && (radioGroup = fragmentPoQuestionsNewBinding61.teacherSurveyQuestionsMultiple) != null) {
                radioGroup.clearCheck();
            }
        } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "0")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding62 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding62 != null ? fragmentPoQuestionsNewBinding62.option1 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "1")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding63 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding63 != null ? fragmentPoQuestionsNewBinding63.option2 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_2D)) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding64 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding64 != null ? fragmentPoQuestionsNewBinding64.option3 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_3D)) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding65 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding65 != null ? fragmentPoQuestionsNewBinding65.option4 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "4")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding66 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding66 != null ? fragmentPoQuestionsNewBinding66.option5 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "5")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding67 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding67 != null ? fragmentPoQuestionsNewBinding67.option6 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        }
        System.out.println(this$0.surveyAnswers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(PoSurveyQuestionsNewFragment this$0, View view) {
        RadioButton radioButton;
        RadioGroup radioGroup;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PoSurveyQuestionsNewAdapter adapter = this$0.getAdapter();
        List<String> list = this$0.surveyAnswers;
        int i = this$0.i;
        adapter.addItems(list, i - 1, this$0.mandatoryQuestions, this$0.attendedOrNot, i - 1);
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = this$0.get_binding();
        TextView textView = fragmentPoQuestionsNewBinding != null ? fragmentPoQuestionsNewBinding.questionTv : null;
        if (textView != null) {
            int i2 = this$0.i;
            ArrayList<PoQuestions> arrayList = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList);
            textView.setText(i2 + RemoteSettings.FORWARD_SLASH_STRING + arrayList.size());
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = this$0.get_binding();
        TextView textView2 = fragmentPoQuestionsNewBinding2 != null ? fragmentPoQuestionsNewBinding2.teacherSurveyQuestion : null;
        if (textView2 != null) {
            ArrayList<PoQuestions> arrayList2 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList2);
            textView2.setText(arrayList2.get(this$0.i - 1).getQ_name());
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = this$0.get_binding();
        TextView textView3 = fragmentPoQuestionsNewBinding3 != null ? fragmentPoQuestionsNewBinding3.teacherSurveyQuestionNo : null;
        if (textView3 != null) {
            textView3.setText("Question " + this$0.i + " (Multiple Choice Question)");
        }
        this$0.i--;
        ArrayList<PoQuestions> arrayList3 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList3);
        if (arrayList3.get(this$0.i).getOptions().size() == 2) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding4 = this$0.get_binding();
            RadioButton radioButton2 = fragmentPoQuestionsNewBinding4 != null ? fragmentPoQuestionsNewBinding4.option1 : null;
            if (radioButton2 != null) {
                radioButton2.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding5 = this$0.get_binding();
            RadioButton radioButton3 = fragmentPoQuestionsNewBinding5 != null ? fragmentPoQuestionsNewBinding5.option2 : null;
            if (radioButton3 != null) {
                radioButton3.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding6 = this$0.get_binding();
            RadioButton radioButton4 = fragmentPoQuestionsNewBinding6 != null ? fragmentPoQuestionsNewBinding6.option3 : null;
            if (radioButton4 != null) {
                radioButton4.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding7 = this$0.get_binding();
            RadioButton radioButton5 = fragmentPoQuestionsNewBinding7 != null ? fragmentPoQuestionsNewBinding7.option4 : null;
            if (radioButton5 != null) {
                radioButton5.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding8 = this$0.get_binding();
            RadioButton radioButton6 = fragmentPoQuestionsNewBinding8 != null ? fragmentPoQuestionsNewBinding8.option5 : null;
            if (radioButton6 != null) {
                radioButton6.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding9 = this$0.get_binding();
            RadioButton radioButton7 = fragmentPoQuestionsNewBinding9 != null ? fragmentPoQuestionsNewBinding9.option6 : null;
            if (radioButton7 != null) {
                radioButton7.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding10 = this$0.get_binding();
            RadioButton radioButton8 = fragmentPoQuestionsNewBinding10 != null ? fragmentPoQuestionsNewBinding10.option1 : null;
            if (radioButton8 != null) {
                ArrayList<PoQuestions> arrayList4 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList4);
                radioButton8.setText(this$0.convertHtmlToString(arrayList4.get(this$0.i).getOptions().get(0).getOption_name()));
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding11 = this$0.get_binding();
            RadioButton radioButton9 = fragmentPoQuestionsNewBinding11 != null ? fragmentPoQuestionsNewBinding11.option2 : null;
            if (radioButton9 != null) {
                ArrayList<PoQuestions> arrayList5 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList5);
                radioButton9.setText(this$0.convertHtmlToString(arrayList5.get(this$0.i).getOptions().get(1).getOption_name()));
            }
        } else {
            ArrayList<PoQuestions> arrayList6 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList6);
            if (arrayList6.get(this$0.i).getOptions().size() == 3) {
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding12 = this$0.get_binding();
                RadioButton radioButton10 = fragmentPoQuestionsNewBinding12 != null ? fragmentPoQuestionsNewBinding12.option1 : null;
                if (radioButton10 != null) {
                    radioButton10.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding13 = this$0.get_binding();
                RadioButton radioButton11 = fragmentPoQuestionsNewBinding13 != null ? fragmentPoQuestionsNewBinding13.option2 : null;
                if (radioButton11 != null) {
                    radioButton11.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding14 = this$0.get_binding();
                RadioButton radioButton12 = fragmentPoQuestionsNewBinding14 != null ? fragmentPoQuestionsNewBinding14.option3 : null;
                if (radioButton12 != null) {
                    radioButton12.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding15 = this$0.get_binding();
                RadioButton radioButton13 = fragmentPoQuestionsNewBinding15 != null ? fragmentPoQuestionsNewBinding15.option4 : null;
                if (radioButton13 != null) {
                    radioButton13.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding16 = this$0.get_binding();
                RadioButton radioButton14 = fragmentPoQuestionsNewBinding16 != null ? fragmentPoQuestionsNewBinding16.option5 : null;
                if (radioButton14 != null) {
                    radioButton14.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding17 = this$0.get_binding();
                RadioButton radioButton15 = fragmentPoQuestionsNewBinding17 != null ? fragmentPoQuestionsNewBinding17.option6 : null;
                if (radioButton15 != null) {
                    radioButton15.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding18 = this$0.get_binding();
                RadioButton radioButton16 = fragmentPoQuestionsNewBinding18 != null ? fragmentPoQuestionsNewBinding18.option1 : null;
                if (radioButton16 != null) {
                    ArrayList<PoQuestions> arrayList7 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList7);
                    radioButton16.setText(this$0.convertHtmlToString(arrayList7.get(this$0.i).getOptions().get(0).getOption_name()));
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding19 = this$0.get_binding();
                RadioButton radioButton17 = fragmentPoQuestionsNewBinding19 != null ? fragmentPoQuestionsNewBinding19.option2 : null;
                if (radioButton17 != null) {
                    ArrayList<PoQuestions> arrayList8 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList8);
                    radioButton17.setText(this$0.convertHtmlToString(arrayList8.get(this$0.i).getOptions().get(1).getOption_name()));
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding20 = this$0.get_binding();
                RadioButton radioButton18 = fragmentPoQuestionsNewBinding20 != null ? fragmentPoQuestionsNewBinding20.option3 : null;
                if (radioButton18 != null) {
                    ArrayList<PoQuestions> arrayList9 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList9);
                    radioButton18.setText(this$0.convertHtmlToString(arrayList9.get(this$0.i).getOptions().get(2).getOption_name()));
                }
            } else {
                ArrayList<PoQuestions> arrayList10 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList10);
                if (arrayList10.get(this$0.i).getOptions().size() == 4) {
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding21 = this$0.get_binding();
                    RadioButton radioButton19 = fragmentPoQuestionsNewBinding21 != null ? fragmentPoQuestionsNewBinding21.option1 : null;
                    if (radioButton19 != null) {
                        radioButton19.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding22 = this$0.get_binding();
                    RadioButton radioButton20 = fragmentPoQuestionsNewBinding22 != null ? fragmentPoQuestionsNewBinding22.option2 : null;
                    if (radioButton20 != null) {
                        radioButton20.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding23 = this$0.get_binding();
                    RadioButton radioButton21 = fragmentPoQuestionsNewBinding23 != null ? fragmentPoQuestionsNewBinding23.option3 : null;
                    if (radioButton21 != null) {
                        radioButton21.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding24 = this$0.get_binding();
                    RadioButton radioButton22 = fragmentPoQuestionsNewBinding24 != null ? fragmentPoQuestionsNewBinding24.option4 : null;
                    if (radioButton22 != null) {
                        radioButton22.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding25 = this$0.get_binding();
                    RadioButton radioButton23 = fragmentPoQuestionsNewBinding25 != null ? fragmentPoQuestionsNewBinding25.option5 : null;
                    if (radioButton23 != null) {
                        radioButton23.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding26 = this$0.get_binding();
                    RadioButton radioButton24 = fragmentPoQuestionsNewBinding26 != null ? fragmentPoQuestionsNewBinding26.option6 : null;
                    if (radioButton24 != null) {
                        radioButton24.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding27 = this$0.get_binding();
                    RadioButton radioButton25 = fragmentPoQuestionsNewBinding27 != null ? fragmentPoQuestionsNewBinding27.option1 : null;
                    if (radioButton25 != null) {
                        ArrayList<PoQuestions> arrayList11 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList11);
                        radioButton25.setText(this$0.convertHtmlToString(arrayList11.get(this$0.i).getOptions().get(0).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding28 = this$0.get_binding();
                    RadioButton radioButton26 = fragmentPoQuestionsNewBinding28 != null ? fragmentPoQuestionsNewBinding28.option2 : null;
                    if (radioButton26 != null) {
                        ArrayList<PoQuestions> arrayList12 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList12);
                        radioButton26.setText(this$0.convertHtmlToString(arrayList12.get(this$0.i).getOptions().get(1).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding29 = this$0.get_binding();
                    RadioButton radioButton27 = fragmentPoQuestionsNewBinding29 != null ? fragmentPoQuestionsNewBinding29.option3 : null;
                    if (radioButton27 != null) {
                        ArrayList<PoQuestions> arrayList13 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList13);
                        radioButton27.setText(this$0.convertHtmlToString(arrayList13.get(this$0.i).getOptions().get(2).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding30 = this$0.get_binding();
                    RadioButton radioButton28 = fragmentPoQuestionsNewBinding30 != null ? fragmentPoQuestionsNewBinding30.option4 : null;
                    if (radioButton28 != null) {
                        ArrayList<PoQuestions> arrayList14 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList14);
                        radioButton28.setText(this$0.convertHtmlToString(arrayList14.get(this$0.i).getOptions().get(3).getOption_name()));
                    }
                } else {
                    ArrayList<PoQuestions> arrayList15 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList15);
                    if (arrayList15.get(this$0.i).getOptions().size() == 5) {
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding31 = this$0.get_binding();
                        RadioButton radioButton29 = fragmentPoQuestionsNewBinding31 != null ? fragmentPoQuestionsNewBinding31.option1 : null;
                        if (radioButton29 != null) {
                            radioButton29.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding32 = this$0.get_binding();
                        RadioButton radioButton30 = fragmentPoQuestionsNewBinding32 != null ? fragmentPoQuestionsNewBinding32.option2 : null;
                        if (radioButton30 != null) {
                            radioButton30.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding33 = this$0.get_binding();
                        RadioButton radioButton31 = fragmentPoQuestionsNewBinding33 != null ? fragmentPoQuestionsNewBinding33.option3 : null;
                        if (radioButton31 != null) {
                            radioButton31.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding34 = this$0.get_binding();
                        RadioButton radioButton32 = fragmentPoQuestionsNewBinding34 != null ? fragmentPoQuestionsNewBinding34.option4 : null;
                        if (radioButton32 != null) {
                            radioButton32.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding35 = this$0.get_binding();
                        RadioButton radioButton33 = fragmentPoQuestionsNewBinding35 != null ? fragmentPoQuestionsNewBinding35.option5 : null;
                        if (radioButton33 != null) {
                            radioButton33.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding36 = this$0.get_binding();
                        RadioButton radioButton34 = fragmentPoQuestionsNewBinding36 != null ? fragmentPoQuestionsNewBinding36.option6 : null;
                        if (radioButton34 != null) {
                            radioButton34.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding37 = this$0.get_binding();
                        RadioButton radioButton35 = fragmentPoQuestionsNewBinding37 != null ? fragmentPoQuestionsNewBinding37.option1 : null;
                        if (radioButton35 != null) {
                            ArrayList<PoQuestions> arrayList16 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList16);
                            radioButton35.setText(this$0.convertHtmlToString(arrayList16.get(this$0.i).getOptions().get(0).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding38 = this$0.get_binding();
                        RadioButton radioButton36 = fragmentPoQuestionsNewBinding38 != null ? fragmentPoQuestionsNewBinding38.option2 : null;
                        if (radioButton36 != null) {
                            ArrayList<PoQuestions> arrayList17 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList17);
                            radioButton36.setText(this$0.convertHtmlToString(arrayList17.get(this$0.i).getOptions().get(1).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding39 = this$0.get_binding();
                        RadioButton radioButton37 = fragmentPoQuestionsNewBinding39 != null ? fragmentPoQuestionsNewBinding39.option3 : null;
                        if (radioButton37 != null) {
                            ArrayList<PoQuestions> arrayList18 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList18);
                            radioButton37.setText(this$0.convertHtmlToString(arrayList18.get(this$0.i).getOptions().get(2).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding40 = this$0.get_binding();
                        RadioButton radioButton38 = fragmentPoQuestionsNewBinding40 != null ? fragmentPoQuestionsNewBinding40.option4 : null;
                        if (radioButton38 != null) {
                            ArrayList<PoQuestions> arrayList19 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList19);
                            radioButton38.setText(this$0.convertHtmlToString(arrayList19.get(this$0.i).getOptions().get(3).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding41 = this$0.get_binding();
                        RadioButton radioButton39 = fragmentPoQuestionsNewBinding41 != null ? fragmentPoQuestionsNewBinding41.option5 : null;
                        if (radioButton39 != null) {
                            ArrayList<PoQuestions> arrayList20 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList20);
                            radioButton39.setText(this$0.convertHtmlToString(arrayList20.get(this$0.i).getOptions().get(4).getOption_name()));
                        }
                    } else {
                        ArrayList<PoQuestions> arrayList21 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList21);
                        if (arrayList21.get(this$0.i).getOptions().size() == 6) {
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding42 = this$0.get_binding();
                            RadioButton radioButton40 = fragmentPoQuestionsNewBinding42 != null ? fragmentPoQuestionsNewBinding42.option1 : null;
                            if (radioButton40 != null) {
                                radioButton40.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding43 = this$0.get_binding();
                            RadioButton radioButton41 = fragmentPoQuestionsNewBinding43 != null ? fragmentPoQuestionsNewBinding43.option2 : null;
                            if (radioButton41 != null) {
                                radioButton41.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding44 = this$0.get_binding();
                            RadioButton radioButton42 = fragmentPoQuestionsNewBinding44 != null ? fragmentPoQuestionsNewBinding44.option3 : null;
                            if (radioButton42 != null) {
                                radioButton42.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding45 = this$0.get_binding();
                            RadioButton radioButton43 = fragmentPoQuestionsNewBinding45 != null ? fragmentPoQuestionsNewBinding45.option4 : null;
                            if (radioButton43 != null) {
                                radioButton43.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding46 = this$0.get_binding();
                            RadioButton radioButton44 = fragmentPoQuestionsNewBinding46 != null ? fragmentPoQuestionsNewBinding46.option5 : null;
                            if (radioButton44 != null) {
                                radioButton44.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding47 = this$0.get_binding();
                            RadioButton radioButton45 = fragmentPoQuestionsNewBinding47 != null ? fragmentPoQuestionsNewBinding47.option6 : null;
                            if (radioButton45 != null) {
                                radioButton45.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding48 = this$0.get_binding();
                            RadioButton radioButton46 = fragmentPoQuestionsNewBinding48 != null ? fragmentPoQuestionsNewBinding48.option1 : null;
                            if (radioButton46 != null) {
                                ArrayList<PoQuestions> arrayList22 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList22);
                                radioButton46.setText(this$0.convertHtmlToString(arrayList22.get(this$0.i).getOptions().get(0).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding49 = this$0.get_binding();
                            RadioButton radioButton47 = fragmentPoQuestionsNewBinding49 != null ? fragmentPoQuestionsNewBinding49.option2 : null;
                            if (radioButton47 != null) {
                                ArrayList<PoQuestions> arrayList23 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList23);
                                radioButton47.setText(this$0.convertHtmlToString(arrayList23.get(this$0.i).getOptions().get(1).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding50 = this$0.get_binding();
                            RadioButton radioButton48 = fragmentPoQuestionsNewBinding50 != null ? fragmentPoQuestionsNewBinding50.option3 : null;
                            if (radioButton48 != null) {
                                ArrayList<PoQuestions> arrayList24 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList24);
                                radioButton48.setText(this$0.convertHtmlToString(arrayList24.get(this$0.i).getOptions().get(2).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding51 = this$0.get_binding();
                            RadioButton radioButton49 = fragmentPoQuestionsNewBinding51 != null ? fragmentPoQuestionsNewBinding51.option4 : null;
                            if (radioButton49 != null) {
                                ArrayList<PoQuestions> arrayList25 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList25);
                                radioButton49.setText(this$0.convertHtmlToString(arrayList25.get(this$0.i).getOptions().get(3).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding52 = this$0.get_binding();
                            RadioButton radioButton50 = fragmentPoQuestionsNewBinding52 != null ? fragmentPoQuestionsNewBinding52.option5 : null;
                            if (radioButton50 != null) {
                                ArrayList<PoQuestions> arrayList26 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList26);
                                radioButton50.setText(this$0.convertHtmlToString(arrayList26.get(this$0.i).getOptions().get(4).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding53 = this$0.get_binding();
                            RadioButton radioButton51 = fragmentPoQuestionsNewBinding53 != null ? fragmentPoQuestionsNewBinding53.option6 : null;
                            if (radioButton51 != null) {
                                ArrayList<PoQuestions> arrayList27 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList27);
                                radioButton51.setText(this$0.convertHtmlToString(arrayList27.get(this$0.i).getOptions().get(5).getOption_name()));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(this$0.i);
        ArrayList<PoQuestions> arrayList28 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList28);
        if (arrayList28.get(this$0.i).getRequired()) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding54 = this$0.get_binding();
            TextView textView4 = fragmentPoQuestionsNewBinding54 != null ? fragmentPoQuestionsNewBinding54.requiredTv : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding55 = this$0.get_binding();
            TextView textView5 = fragmentPoQuestionsNewBinding55 != null ? fragmentPoQuestionsNewBinding55.requiredTv : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        if (this$0.i == 0) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding56 = this$0.get_binding();
            TextView textView6 = fragmentPoQuestionsNewBinding56 != null ? fragmentPoQuestionsNewBinding56.backBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(4);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding57 = this$0.get_binding();
            TextView textView7 = fragmentPoQuestionsNewBinding57 != null ? fragmentPoQuestionsNewBinding57.backBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        }
        int i3 = this$0.i;
        ArrayList<PoQuestions> arrayList29 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList29);
        if (i3 == arrayList29.size() - 1) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding58 = this$0.get_binding();
            TextView textView8 = fragmentPoQuestionsNewBinding58 != null ? fragmentPoQuestionsNewBinding58.finishBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding59 = this$0.get_binding();
            TextView textView9 = fragmentPoQuestionsNewBinding59 != null ? fragmentPoQuestionsNewBinding59.nextBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding60 = this$0.get_binding();
            TextView textView10 = fragmentPoQuestionsNewBinding60 != null ? fragmentPoQuestionsNewBinding60.finishBtn : null;
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding61 = this$0.get_binding();
            TextView textView11 = fragmentPoQuestionsNewBinding61 != null ? fragmentPoQuestionsNewBinding61.nextBtn : null;
            if (textView11 != null) {
                textView11.setVisibility(0);
            }
        }
        if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding62 = this$0.get_binding();
            if (fragmentPoQuestionsNewBinding62 == null || (radioGroup = fragmentPoQuestionsNewBinding62.teacherSurveyQuestionsMultiple) == null) {
                return;
            }
            radioGroup.clearCheck();
            return;
        }
        if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "0")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding63 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding63 != null ? fragmentPoQuestionsNewBinding63.option1 : null;
            if (radioButton == null) {
                return;
            }
            radioButton.setChecked(true);
            return;
        }
        if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "1")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding64 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding64 != null ? fragmentPoQuestionsNewBinding64.option2 : null;
            if (radioButton == null) {
                return;
            }
            radioButton.setChecked(true);
            return;
        }
        if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_2D)) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding65 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding65 != null ? fragmentPoQuestionsNewBinding65.option3 : null;
            if (radioButton == null) {
                return;
            }
            radioButton.setChecked(true);
            return;
        }
        if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_3D)) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding66 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding66 != null ? fragmentPoQuestionsNewBinding66.option4 : null;
            if (radioButton == null) {
                return;
            }
            radioButton.setChecked(true);
            return;
        }
        if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "4")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding67 = this$0.get_binding();
            radioButton = fragmentPoQuestionsNewBinding67 != null ? fragmentPoQuestionsNewBinding67.option5 : null;
            if (radioButton == null) {
                return;
            }
            radioButton.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(PoSurveyQuestionsNewFragment this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        System.out.println(this$0.surveyAnswers);
        int size = this$0.surveyAnswers.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (Intrinsics.areEqual(this$0.surveyAnswers.get(i), "") && Intrinsics.areEqual(this$0.mandatoryQuestions.get(i), "true")) {
                this$0.mandatoryFlag = false;
                break;
            } else {
                this$0.mandatoryFlag = true;
                i++;
            }
        }
        if (this$0.mandatoryFlag) {
            this$0.submitAnswer.clear();
            HashMap<String, String> hashMap = this$0.submitAnswer;
            String str = this$0.id;
            Intrinsics.checkNotNull(str);
            hashMap.put("id", str);
            int size2 = this$0.surveyAnswers.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (!Intrinsics.areEqual(this$0.surveyAnswers.get(i2), "")) {
                    HashMap<String, String> hashMap2 = this$0.submitAnswer;
                    ArrayList<PoQuestions> arrayList = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList);
                    String str2 = "SurveyPoOption[" + arrayList.get(i2).getQ_id() + "]";
                    ArrayList<PoQuestions> arrayList2 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList2);
                    hashMap2.put(str2, arrayList2.get(i2).getOptions().get(Integer.parseInt(this$0.surveyAnswers.get(i2))).getOption_id());
                }
            }
            System.out.println(this$0.submitAnswer);
            this$0.getPoSurveyQuestionsNewViewModel().getSurveyQuestions(this$0.submitAnswer);
            return;
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = this$0.get_binding();
        if (fragmentPoQuestionsNewBinding == null || (textView = fragmentPoQuestionsNewBinding.finishBtn) == null) {
            return;
        }
        ToastExtKt.showErrorToast(textView, "You have not answered all mandatory questions.");
    }

    private final void clearCheckFields() {
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = get_binding();
        RadioButton radioButton = fragmentPoQuestionsNewBinding != null ? fragmentPoQuestionsNewBinding.option1 : null;
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = get_binding();
        RadioButton radioButton2 = fragmentPoQuestionsNewBinding2 != null ? fragmentPoQuestionsNewBinding2.option2 : null;
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = get_binding();
        RadioButton radioButton3 = fragmentPoQuestionsNewBinding3 != null ? fragmentPoQuestionsNewBinding3.option3 : null;
        if (radioButton3 != null) {
            radioButton3.setChecked(false);
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding4 = get_binding();
        RadioButton radioButton4 = fragmentPoQuestionsNewBinding4 != null ? fragmentPoQuestionsNewBinding4.option4 : null;
        if (radioButton4 != null) {
            radioButton4.setChecked(false);
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding5 = get_binding();
        RadioButton radioButton5 = fragmentPoQuestionsNewBinding5 != null ? fragmentPoQuestionsNewBinding5.option5 : null;
        if (radioButton5 == null) {
            return;
        }
        radioButton5.setChecked(false);
    }

    private final void listenResponse() {
        getPoSurveyQuestionsNewViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PoSurveyQuestionsNewFragment.listenResponse$lambda$6(PoSurveyQuestionsNewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(PoSurveyQuestionsNewFragment this$0, Resource resource) {
        LinearLayout linearLayout;
        TextView textView;
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
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = this$0.get_binding();
            if (fragmentPoQuestionsNewBinding == null || (textView = fragmentPoQuestionsNewBinding.finishBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        PoQuestionsResponse poQuestionsResponse = (PoQuestionsResponse) resource.getData();
        if (poQuestionsResponse != null) {
            this$0.showBaseView();
            this$0.surveyResponse = poQuestionsResponse.getQuestions();
            System.out.println(poQuestionsResponse);
            int size = poQuestionsResponse.getQuestions().size();
            for (int i2 = 0; i2 < size; i2++) {
                this$0.surveyAnswers.add(i2, "");
                if (poQuestionsResponse.getQuestions().get(i2).getRequired()) {
                    this$0.mandatoryQuestions.add(i2, "true");
                } else {
                    this$0.mandatoryQuestions.add(i2, "false");
                }
                this$0.attendedOrNot.add(i2, "NOT");
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = this$0.get_binding();
            TextView textView2 = fragmentPoQuestionsNewBinding2 != null ? fragmentPoQuestionsNewBinding2.questionTv : null;
            if (textView2 != null) {
                int i3 = this$0.i + 1;
                ArrayList<PoQuestions> arrayList = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList);
                textView2.setText(i3 + RemoteSettings.FORWARD_SLASH_STRING + arrayList.size());
            }
            System.out.println(this$0.surveyAnswers);
            System.out.println(this$0.mandatoryQuestions);
            System.out.println(this$0.attendedOrNot);
            System.out.println(this$0.attendedOrNot);
            this$0.getAdapter().addItems(this$0.surveyAnswers, 0, this$0.mandatoryQuestions, this$0.attendedOrNot, 0);
            ArrayList<PoQuestions> arrayList2 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList2);
            if (arrayList2.get(this$0.i).getRequired()) {
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = this$0.get_binding();
                TextView textView3 = fragmentPoQuestionsNewBinding3 != null ? fragmentPoQuestionsNewBinding3.requiredTv : null;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            } else {
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding4 = this$0.get_binding();
                TextView textView4 = fragmentPoQuestionsNewBinding4 != null ? fragmentPoQuestionsNewBinding4.requiredTv : null;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding5 = this$0.get_binding();
            TextView textView5 = fragmentPoQuestionsNewBinding5 != null ? fragmentPoQuestionsNewBinding5.teacherSurveyQuestion : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding6 = this$0.get_binding();
            TextView textView6 = fragmentPoQuestionsNewBinding6 != null ? fragmentPoQuestionsNewBinding6.teacherSurveyQuestion : null;
            if (textView6 != null) {
                ArrayList<PoQuestions> arrayList3 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList3);
                textView6.setText("Q ) " + this$0.convertHtmlToString(arrayList3.get(this$0.i).getQ_name()));
            }
            ArrayList<PoQuestions> arrayList4 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList4);
            if (Intrinsics.areEqual(arrayList4.get(this$0.i).getAnswer(), "")) {
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding7 = this$0.get_binding();
                TextView textView7 = fragmentPoQuestionsNewBinding7 != null ? fragmentPoQuestionsNewBinding7.teacherSurveyQuestionNo : null;
                if (textView7 != null) {
                    textView7.setText("Question " + (this$0.i + 1) + " (Multiple Choice Question)");
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding8 = this$0.get_binding();
                LinearLayout linearLayout2 = fragmentPoQuestionsNewBinding8 != null ? fragmentPoQuestionsNewBinding8.descriptiveAnswerLyt : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding9 = this$0.get_binding();
                LinearLayout linearLayout3 = fragmentPoQuestionsNewBinding9 != null ? fragmentPoQuestionsNewBinding9.multipleAnswerLyt : null;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                ArrayList<PoQuestions> arrayList5 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList5);
                if (arrayList5.get(this$0.i).getOptions().size() == 2) {
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding10 = this$0.get_binding();
                    RadioButton radioButton = fragmentPoQuestionsNewBinding10 != null ? fragmentPoQuestionsNewBinding10.option1 : null;
                    if (radioButton != null) {
                        radioButton.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding11 = this$0.get_binding();
                    RadioButton radioButton2 = fragmentPoQuestionsNewBinding11 != null ? fragmentPoQuestionsNewBinding11.option2 : null;
                    if (radioButton2 != null) {
                        radioButton2.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding12 = this$0.get_binding();
                    RadioButton radioButton3 = fragmentPoQuestionsNewBinding12 != null ? fragmentPoQuestionsNewBinding12.option3 : null;
                    if (radioButton3 != null) {
                        radioButton3.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding13 = this$0.get_binding();
                    RadioButton radioButton4 = fragmentPoQuestionsNewBinding13 != null ? fragmentPoQuestionsNewBinding13.option4 : null;
                    if (radioButton4 != null) {
                        radioButton4.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding14 = this$0.get_binding();
                    RadioButton radioButton5 = fragmentPoQuestionsNewBinding14 != null ? fragmentPoQuestionsNewBinding14.option5 : null;
                    if (radioButton5 != null) {
                        radioButton5.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding15 = this$0.get_binding();
                    RadioButton radioButton6 = fragmentPoQuestionsNewBinding15 != null ? fragmentPoQuestionsNewBinding15.option6 : null;
                    if (radioButton6 != null) {
                        radioButton6.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding16 = this$0.get_binding();
                    RadioButton radioButton7 = fragmentPoQuestionsNewBinding16 != null ? fragmentPoQuestionsNewBinding16.option1 : null;
                    if (radioButton7 != null) {
                        ArrayList<PoQuestions> arrayList6 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList6);
                        radioButton7.setText(this$0.convertHtmlToString(arrayList6.get(this$0.i).getOptions().get(0).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding17 = this$0.get_binding();
                    RadioButton radioButton8 = fragmentPoQuestionsNewBinding17 != null ? fragmentPoQuestionsNewBinding17.option2 : null;
                    if (radioButton8 != null) {
                        ArrayList<PoQuestions> arrayList7 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList7);
                        radioButton8.setText(this$0.convertHtmlToString(arrayList7.get(this$0.i).getOptions().get(1).getOption_name()));
                    }
                } else {
                    ArrayList<PoQuestions> arrayList8 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList8);
                    if (arrayList8.get(this$0.i).getOptions().size() == 3) {
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding18 = this$0.get_binding();
                        RadioButton radioButton9 = fragmentPoQuestionsNewBinding18 != null ? fragmentPoQuestionsNewBinding18.option1 : null;
                        if (radioButton9 != null) {
                            radioButton9.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding19 = this$0.get_binding();
                        RadioButton radioButton10 = fragmentPoQuestionsNewBinding19 != null ? fragmentPoQuestionsNewBinding19.option2 : null;
                        if (radioButton10 != null) {
                            radioButton10.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding20 = this$0.get_binding();
                        RadioButton radioButton11 = fragmentPoQuestionsNewBinding20 != null ? fragmentPoQuestionsNewBinding20.option3 : null;
                        if (radioButton11 != null) {
                            radioButton11.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding21 = this$0.get_binding();
                        RadioButton radioButton12 = fragmentPoQuestionsNewBinding21 != null ? fragmentPoQuestionsNewBinding21.option4 : null;
                        if (radioButton12 != null) {
                            radioButton12.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding22 = this$0.get_binding();
                        RadioButton radioButton13 = fragmentPoQuestionsNewBinding22 != null ? fragmentPoQuestionsNewBinding22.option5 : null;
                        if (radioButton13 != null) {
                            radioButton13.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding23 = this$0.get_binding();
                        RadioButton radioButton14 = fragmentPoQuestionsNewBinding23 != null ? fragmentPoQuestionsNewBinding23.option6 : null;
                        if (radioButton14 != null) {
                            radioButton14.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding24 = this$0.get_binding();
                        RadioButton radioButton15 = fragmentPoQuestionsNewBinding24 != null ? fragmentPoQuestionsNewBinding24.option1 : null;
                        if (radioButton15 != null) {
                            ArrayList<PoQuestions> arrayList9 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList9);
                            radioButton15.setText(this$0.convertHtmlToString(arrayList9.get(this$0.i).getOptions().get(0).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding25 = this$0.get_binding();
                        RadioButton radioButton16 = fragmentPoQuestionsNewBinding25 != null ? fragmentPoQuestionsNewBinding25.option2 : null;
                        if (radioButton16 != null) {
                            ArrayList<PoQuestions> arrayList10 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList10);
                            radioButton16.setText(this$0.convertHtmlToString(arrayList10.get(this$0.i).getOptions().get(1).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding26 = this$0.get_binding();
                        RadioButton radioButton17 = fragmentPoQuestionsNewBinding26 != null ? fragmentPoQuestionsNewBinding26.option3 : null;
                        if (radioButton17 != null) {
                            ArrayList<PoQuestions> arrayList11 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList11);
                            radioButton17.setText(this$0.convertHtmlToString(arrayList11.get(this$0.i).getOptions().get(2).getOption_name()));
                        }
                    } else {
                        ArrayList<PoQuestions> arrayList12 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList12);
                        if (arrayList12.get(this$0.i).getOptions().size() == 4) {
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding27 = this$0.get_binding();
                            RadioButton radioButton18 = fragmentPoQuestionsNewBinding27 != null ? fragmentPoQuestionsNewBinding27.option1 : null;
                            if (radioButton18 != null) {
                                radioButton18.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding28 = this$0.get_binding();
                            RadioButton radioButton19 = fragmentPoQuestionsNewBinding28 != null ? fragmentPoQuestionsNewBinding28.option2 : null;
                            if (radioButton19 != null) {
                                radioButton19.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding29 = this$0.get_binding();
                            RadioButton radioButton20 = fragmentPoQuestionsNewBinding29 != null ? fragmentPoQuestionsNewBinding29.option3 : null;
                            if (radioButton20 != null) {
                                radioButton20.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding30 = this$0.get_binding();
                            RadioButton radioButton21 = fragmentPoQuestionsNewBinding30 != null ? fragmentPoQuestionsNewBinding30.option4 : null;
                            if (radioButton21 != null) {
                                radioButton21.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding31 = this$0.get_binding();
                            RadioButton radioButton22 = fragmentPoQuestionsNewBinding31 != null ? fragmentPoQuestionsNewBinding31.option5 : null;
                            if (radioButton22 != null) {
                                radioButton22.setVisibility(8);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding32 = this$0.get_binding();
                            RadioButton radioButton23 = fragmentPoQuestionsNewBinding32 != null ? fragmentPoQuestionsNewBinding32.option6 : null;
                            if (radioButton23 != null) {
                                radioButton23.setVisibility(8);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding33 = this$0.get_binding();
                            RadioButton radioButton24 = fragmentPoQuestionsNewBinding33 != null ? fragmentPoQuestionsNewBinding33.option1 : null;
                            if (radioButton24 != null) {
                                ArrayList<PoQuestions> arrayList13 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList13);
                                radioButton24.setText(this$0.convertHtmlToString(arrayList13.get(this$0.i).getOptions().get(0).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding34 = this$0.get_binding();
                            RadioButton radioButton25 = fragmentPoQuestionsNewBinding34 != null ? fragmentPoQuestionsNewBinding34.option2 : null;
                            if (radioButton25 != null) {
                                ArrayList<PoQuestions> arrayList14 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList14);
                                radioButton25.setText(this$0.convertHtmlToString(arrayList14.get(this$0.i).getOptions().get(1).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding35 = this$0.get_binding();
                            RadioButton radioButton26 = fragmentPoQuestionsNewBinding35 != null ? fragmentPoQuestionsNewBinding35.option3 : null;
                            if (radioButton26 != null) {
                                ArrayList<PoQuestions> arrayList15 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList15);
                                radioButton26.setText(this$0.convertHtmlToString(arrayList15.get(this$0.i).getOptions().get(2).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding36 = this$0.get_binding();
                            RadioButton radioButton27 = fragmentPoQuestionsNewBinding36 != null ? fragmentPoQuestionsNewBinding36.option4 : null;
                            if (radioButton27 != null) {
                                ArrayList<PoQuestions> arrayList16 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList16);
                                radioButton27.setText(this$0.convertHtmlToString(arrayList16.get(this$0.i).getOptions().get(3).getOption_name()));
                            }
                        } else {
                            ArrayList<PoQuestions> arrayList17 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList17);
                            if (arrayList17.get(this$0.i).getOptions().size() == 5) {
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding37 = this$0.get_binding();
                                RadioButton radioButton28 = fragmentPoQuestionsNewBinding37 != null ? fragmentPoQuestionsNewBinding37.option1 : null;
                                if (radioButton28 != null) {
                                    radioButton28.setVisibility(0);
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding38 = this$0.get_binding();
                                RadioButton radioButton29 = fragmentPoQuestionsNewBinding38 != null ? fragmentPoQuestionsNewBinding38.option2 : null;
                                if (radioButton29 != null) {
                                    radioButton29.setVisibility(0);
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding39 = this$0.get_binding();
                                RadioButton radioButton30 = fragmentPoQuestionsNewBinding39 != null ? fragmentPoQuestionsNewBinding39.option3 : null;
                                if (radioButton30 != null) {
                                    radioButton30.setVisibility(0);
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding40 = this$0.get_binding();
                                RadioButton radioButton31 = fragmentPoQuestionsNewBinding40 != null ? fragmentPoQuestionsNewBinding40.option4 : null;
                                if (radioButton31 != null) {
                                    radioButton31.setVisibility(0);
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding41 = this$0.get_binding();
                                RadioButton radioButton32 = fragmentPoQuestionsNewBinding41 != null ? fragmentPoQuestionsNewBinding41.option5 : null;
                                if (radioButton32 != null) {
                                    radioButton32.setVisibility(0);
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding42 = this$0.get_binding();
                                RadioButton radioButton33 = fragmentPoQuestionsNewBinding42 != null ? fragmentPoQuestionsNewBinding42.option6 : null;
                                if (radioButton33 != null) {
                                    radioButton33.setVisibility(8);
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding43 = this$0.get_binding();
                                RadioButton radioButton34 = fragmentPoQuestionsNewBinding43 != null ? fragmentPoQuestionsNewBinding43.option1 : null;
                                if (radioButton34 != null) {
                                    ArrayList<PoQuestions> arrayList18 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList18);
                                    radioButton34.setText(this$0.convertHtmlToString(arrayList18.get(this$0.i).getOptions().get(0).getOption_name()));
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding44 = this$0.get_binding();
                                RadioButton radioButton35 = fragmentPoQuestionsNewBinding44 != null ? fragmentPoQuestionsNewBinding44.option2 : null;
                                if (radioButton35 != null) {
                                    ArrayList<PoQuestions> arrayList19 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList19);
                                    radioButton35.setText(this$0.convertHtmlToString(arrayList19.get(this$0.i).getOptions().get(1).getOption_name()));
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding45 = this$0.get_binding();
                                RadioButton radioButton36 = fragmentPoQuestionsNewBinding45 != null ? fragmentPoQuestionsNewBinding45.option3 : null;
                                if (radioButton36 != null) {
                                    ArrayList<PoQuestions> arrayList20 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList20);
                                    radioButton36.setText(this$0.convertHtmlToString(arrayList20.get(this$0.i).getOptions().get(2).getOption_name()));
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding46 = this$0.get_binding();
                                RadioButton radioButton37 = fragmentPoQuestionsNewBinding46 != null ? fragmentPoQuestionsNewBinding46.option4 : null;
                                if (radioButton37 != null) {
                                    ArrayList<PoQuestions> arrayList21 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList21);
                                    radioButton37.setText(this$0.convertHtmlToString(arrayList21.get(this$0.i).getOptions().get(3).getOption_name()));
                                }
                                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding47 = this$0.get_binding();
                                RadioButton radioButton38 = fragmentPoQuestionsNewBinding47 != null ? fragmentPoQuestionsNewBinding47.option5 : null;
                                if (radioButton38 != null) {
                                    ArrayList<PoQuestions> arrayList22 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList22);
                                    radioButton38.setText(this$0.convertHtmlToString(arrayList22.get(this$0.i).getOptions().get(4).getOption_name()));
                                }
                            } else {
                                ArrayList<PoQuestions> arrayList23 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList23);
                                if (arrayList23.get(this$0.i).getOptions().size() == 6) {
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding48 = this$0.get_binding();
                                    RadioButton radioButton39 = fragmentPoQuestionsNewBinding48 != null ? fragmentPoQuestionsNewBinding48.option1 : null;
                                    if (radioButton39 != null) {
                                        radioButton39.setVisibility(0);
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding49 = this$0.get_binding();
                                    RadioButton radioButton40 = fragmentPoQuestionsNewBinding49 != null ? fragmentPoQuestionsNewBinding49.option2 : null;
                                    if (radioButton40 != null) {
                                        radioButton40.setVisibility(0);
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding50 = this$0.get_binding();
                                    RadioButton radioButton41 = fragmentPoQuestionsNewBinding50 != null ? fragmentPoQuestionsNewBinding50.option3 : null;
                                    if (radioButton41 != null) {
                                        radioButton41.setVisibility(0);
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding51 = this$0.get_binding();
                                    RadioButton radioButton42 = fragmentPoQuestionsNewBinding51 != null ? fragmentPoQuestionsNewBinding51.option4 : null;
                                    if (radioButton42 != null) {
                                        radioButton42.setVisibility(0);
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding52 = this$0.get_binding();
                                    RadioButton radioButton43 = fragmentPoQuestionsNewBinding52 != null ? fragmentPoQuestionsNewBinding52.option5 : null;
                                    if (radioButton43 != null) {
                                        radioButton43.setVisibility(0);
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding53 = this$0.get_binding();
                                    RadioButton radioButton44 = fragmentPoQuestionsNewBinding53 != null ? fragmentPoQuestionsNewBinding53.option6 : null;
                                    if (radioButton44 != null) {
                                        radioButton44.setVisibility(0);
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding54 = this$0.get_binding();
                                    RadioButton radioButton45 = fragmentPoQuestionsNewBinding54 != null ? fragmentPoQuestionsNewBinding54.option1 : null;
                                    if (radioButton45 != null) {
                                        ArrayList<PoQuestions> arrayList24 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList24);
                                        radioButton45.setText(this$0.convertHtmlToString(arrayList24.get(this$0.i).getOptions().get(0).getOption_name()));
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding55 = this$0.get_binding();
                                    RadioButton radioButton46 = fragmentPoQuestionsNewBinding55 != null ? fragmentPoQuestionsNewBinding55.option2 : null;
                                    if (radioButton46 != null) {
                                        ArrayList<PoQuestions> arrayList25 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList25);
                                        radioButton46.setText(this$0.convertHtmlToString(arrayList25.get(this$0.i).getOptions().get(1).getOption_name()));
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding56 = this$0.get_binding();
                                    RadioButton radioButton47 = fragmentPoQuestionsNewBinding56 != null ? fragmentPoQuestionsNewBinding56.option3 : null;
                                    if (radioButton47 != null) {
                                        ArrayList<PoQuestions> arrayList26 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList26);
                                        radioButton47.setText(this$0.convertHtmlToString(arrayList26.get(this$0.i).getOptions().get(2).getOption_name()));
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding57 = this$0.get_binding();
                                    RadioButton radioButton48 = fragmentPoQuestionsNewBinding57 != null ? fragmentPoQuestionsNewBinding57.option4 : null;
                                    if (radioButton48 != null) {
                                        ArrayList<PoQuestions> arrayList27 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList27);
                                        radioButton48.setText(this$0.convertHtmlToString(arrayList27.get(this$0.i).getOptions().get(3).getOption_name()));
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding58 = this$0.get_binding();
                                    RadioButton radioButton49 = fragmentPoQuestionsNewBinding58 != null ? fragmentPoQuestionsNewBinding58.option5 : null;
                                    if (radioButton49 != null) {
                                        ArrayList<PoQuestions> arrayList28 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList28);
                                        radioButton49.setText(this$0.convertHtmlToString(arrayList28.get(this$0.i).getOptions().get(4).getOption_name()));
                                    }
                                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding59 = this$0.get_binding();
                                    RadioButton radioButton50 = fragmentPoQuestionsNewBinding59 != null ? fragmentPoQuestionsNewBinding59.option6 : null;
                                    if (radioButton50 != null) {
                                        ArrayList<PoQuestions> arrayList29 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList29);
                                        radioButton50.setText(this$0.convertHtmlToString(arrayList29.get(this$0.i).getOptions().get(5).getOption_name()));
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                ArrayList<PoQuestions> arrayList30 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList30);
                if (Intrinsics.areEqual(arrayList30.get(this$0.i).getAnswer(), ExifInterface.GPS_MEASUREMENT_3D)) {
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding60 = this$0.get_binding();
                    TextView textView8 = fragmentPoQuestionsNewBinding60 != null ? fragmentPoQuestionsNewBinding60.teacherSurveyQuestionNo : null;
                    if (textView8 != null) {
                        textView8.setText("Question " + (this$0.i + 1) + " (Descriptive)");
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding61 = this$0.get_binding();
                    LinearLayout linearLayout4 = fragmentPoQuestionsNewBinding61 != null ? fragmentPoQuestionsNewBinding61.descriptiveAnswerLyt : null;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding62 = this$0.get_binding();
                    LinearLayout linearLayout5 = fragmentPoQuestionsNewBinding62 != null ? fragmentPoQuestionsNewBinding62.multipleAnswerLyt : null;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding63 = this$0.get_binding();
                    TextView textView9 = fragmentPoQuestionsNewBinding63 != null ? fragmentPoQuestionsNewBinding63.teacherSurveyQuestion : null;
                    if (textView9 != null) {
                        ArrayList<PoQuestions> arrayList31 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList31);
                        textView9.setText("Q ) " + this$0.convertHtmlToString(arrayList31.get(this$0.i).getQ_name()));
                    }
                }
            }
            if (!Intrinsics.areEqual(this$0.teacherId, "")) {
                if (this$0.i == 0) {
                    ArrayList<PoQuestions> arrayList32 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList32);
                    if (arrayList32.size() - 2 == 1) {
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding64 = this$0.get_binding();
                        TextView textView10 = fragmentPoQuestionsNewBinding64 != null ? fragmentPoQuestionsNewBinding64.backBtn : null;
                        if (textView10 != null) {
                            textView10.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding65 = this$0.get_binding();
                        TextView textView11 = fragmentPoQuestionsNewBinding65 != null ? fragmentPoQuestionsNewBinding65.nextBtn : null;
                        if (textView11 != null) {
                            textView11.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding66 = this$0.get_binding();
                        TextView textView12 = fragmentPoQuestionsNewBinding66 != null ? fragmentPoQuestionsNewBinding66.questionTv : null;
                        if (textView12 != null) {
                            textView12.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding67 = this$0.get_binding();
                        TextView textView13 = fragmentPoQuestionsNewBinding67 != null ? fragmentPoQuestionsNewBinding67.finishBtn : null;
                        if (textView13 != null) {
                            textView13.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding68 = this$0.get_binding();
                        linearLayout = fragmentPoQuestionsNewBinding68 != null ? fragmentPoQuestionsNewBinding68.finalQuestionsLyt : null;
                        if (linearLayout == null) {
                            return;
                        }
                        linearLayout.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this$0.i == 0) {
                ArrayList<PoQuestions> arrayList33 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList33);
                if (arrayList33.size() - 1 == 1) {
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding69 = this$0.get_binding();
                    TextView textView14 = fragmentPoQuestionsNewBinding69 != null ? fragmentPoQuestionsNewBinding69.backBtn : null;
                    if (textView14 != null) {
                        textView14.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding70 = this$0.get_binding();
                    TextView textView15 = fragmentPoQuestionsNewBinding70 != null ? fragmentPoQuestionsNewBinding70.nextBtn : null;
                    if (textView15 != null) {
                        textView15.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding71 = this$0.get_binding();
                    TextView textView16 = fragmentPoQuestionsNewBinding71 != null ? fragmentPoQuestionsNewBinding71.questionTv : null;
                    if (textView16 != null) {
                        textView16.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding72 = this$0.get_binding();
                    TextView textView17 = fragmentPoQuestionsNewBinding72 != null ? fragmentPoQuestionsNewBinding72.finishBtn : null;
                    if (textView17 != null) {
                        textView17.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding73 = this$0.get_binding();
                    linearLayout = fragmentPoQuestionsNewBinding73 != null ? fragmentPoQuestionsNewBinding73.finalQuestionsLyt : null;
                    if (linearLayout == null) {
                        return;
                    }
                    linearLayout.setVisibility(0);
                }
            }
        }
    }

    private final void listenAnswerResponse() {
        getPoSurveyQuestionsNewViewModel().getSubmitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PoSurveyQuestionsNewFragment.listenAnswerResponse$lambda$8(PoSurveyQuestionsNewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAnswerResponse$lambda$8(PoSurveyQuestionsNewFragment this$0, Resource resource) {
        TextView finishBtn;
        TextView finishBtn2;
        TextView textView;
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
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = this$0.get_binding();
            if (fragmentPoQuestionsNewBinding == null || (textView = fragmentPoQuestionsNewBinding.finishBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getSuccess()) {
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = this$0.get_binding();
                if (fragmentPoQuestionsNewBinding2 != null && (finishBtn2 = fragmentPoQuestionsNewBinding2.finishBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(finishBtn2, "finishBtn");
                    ToastExtKt.showSuccessToast(finishBtn2, successResponse.getMessage());
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.onSurveyCompleted(this$0.surveyFlag, this$0.id);
                    return;
                }
                return;
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = this$0.get_binding();
            if (fragmentPoQuestionsNewBinding3 == null || (finishBtn = fragmentPoQuestionsNewBinding3.finishBtn) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(finishBtn, "finishBtn");
            ToastExtKt.showErrorToast(finishBtn, successResponse.getMessage());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    public final String convertHtmlToString(String html) {
        Spanned fromHtml;
        Intrinsics.checkNotNullParameter(html, "html");
        fromHtml = Html.fromHtml(html, 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(html, Html.FROM_HTML_MODE_LEGACY)");
        return fromHtml.toString();
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

    @Override // in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewAdapter.SurveyCallBack
    public void doTheSurvey(String qNo, int j) {
        RadioButton radioButton;
        RadioGroup radioGroup;
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        this.i = Integer.parseInt(qNo);
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding = get_binding();
        TextView textView = fragmentPoQuestionsNewBinding != null ? fragmentPoQuestionsNewBinding.teacherSurveyQuestionNo : null;
        if (textView != null) {
            textView.setText("Question " + (this.i + 1) + " (Multiple Choice Question)");
        }
        int i = this.i;
        ArrayList<PoQuestions> arrayList = this.surveyResponse;
        Intrinsics.checkNotNull(arrayList);
        if (i == arrayList.size() - 1) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding2 = get_binding();
            TextView textView2 = fragmentPoQuestionsNewBinding2 != null ? fragmentPoQuestionsNewBinding2.finishBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding3 = get_binding();
            TextView textView3 = fragmentPoQuestionsNewBinding3 != null ? fragmentPoQuestionsNewBinding3.nextBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding4 = get_binding();
            TextView textView4 = fragmentPoQuestionsNewBinding4 != null ? fragmentPoQuestionsNewBinding4.finishBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding5 = get_binding();
            TextView textView5 = fragmentPoQuestionsNewBinding5 != null ? fragmentPoQuestionsNewBinding5.nextBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        }
        if (this.i == 0) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding6 = get_binding();
            TextView textView6 = fragmentPoQuestionsNewBinding6 != null ? fragmentPoQuestionsNewBinding6.backBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(4);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding7 = get_binding();
            TextView textView7 = fragmentPoQuestionsNewBinding7 != null ? fragmentPoQuestionsNewBinding7.backBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        }
        getAdapter().addItems(this.surveyAnswers, Integer.parseInt(qNo), this.mandatoryQuestions, this.attendedOrNot, Integer.parseInt(qNo));
        this.attendedOrNot.set(Integer.parseInt(qNo), "YES");
        getAdapter().addItems(this.surveyAnswers, Integer.parseInt(qNo), this.mandatoryQuestions, this.attendedOrNot, Integer.parseInt(qNo));
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding8 = get_binding();
        TextView textView8 = fragmentPoQuestionsNewBinding8 != null ? fragmentPoQuestionsNewBinding8.teacherSurveyQuestion : null;
        if (textView8 != null) {
            ArrayList<PoQuestions> arrayList2 = this.surveyResponse;
            Intrinsics.checkNotNull(arrayList2);
            textView8.setText(arrayList2.get(Integer.parseInt(qNo)).getQ_name());
        }
        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding9 = get_binding();
        TextView textView9 = fragmentPoQuestionsNewBinding9 != null ? fragmentPoQuestionsNewBinding9.questionTv : null;
        if (textView9 != null) {
            int parseInt = Integer.parseInt(qNo) + 1;
            ArrayList<PoQuestions> arrayList3 = this.surveyResponse;
            Intrinsics.checkNotNull(arrayList3);
            textView9.setText(parseInt + RemoteSettings.FORWARD_SLASH_STRING + arrayList3.size());
        }
        int i2 = this.i;
        ArrayList<PoQuestions> arrayList4 = this.surveyResponse;
        Intrinsics.checkNotNull(arrayList4);
        if (i2 == arrayList4.size() - 1) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding10 = get_binding();
            TextView textView10 = fragmentPoQuestionsNewBinding10 != null ? fragmentPoQuestionsNewBinding10.finishBtn : null;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding11 = get_binding();
            TextView textView11 = fragmentPoQuestionsNewBinding11 != null ? fragmentPoQuestionsNewBinding11.nextBtn : null;
            if (textView11 != null) {
                textView11.setVisibility(8);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding12 = get_binding();
            TextView textView12 = fragmentPoQuestionsNewBinding12 != null ? fragmentPoQuestionsNewBinding12.finishBtn : null;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding13 = get_binding();
            TextView textView13 = fragmentPoQuestionsNewBinding13 != null ? fragmentPoQuestionsNewBinding13.nextBtn : null;
            if (textView13 != null) {
                textView13.setVisibility(0);
            }
        }
        ArrayList<PoQuestions> arrayList5 = this.surveyResponse;
        Intrinsics.checkNotNull(arrayList5);
        if (arrayList5.get(this.i).getOptions().size() == 2) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding14 = get_binding();
            RadioButton radioButton2 = fragmentPoQuestionsNewBinding14 != null ? fragmentPoQuestionsNewBinding14.option1 : null;
            if (radioButton2 != null) {
                radioButton2.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding15 = get_binding();
            RadioButton radioButton3 = fragmentPoQuestionsNewBinding15 != null ? fragmentPoQuestionsNewBinding15.option2 : null;
            if (radioButton3 != null) {
                radioButton3.setVisibility(0);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding16 = get_binding();
            RadioButton radioButton4 = fragmentPoQuestionsNewBinding16 != null ? fragmentPoQuestionsNewBinding16.option3 : null;
            if (radioButton4 != null) {
                radioButton4.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding17 = get_binding();
            RadioButton radioButton5 = fragmentPoQuestionsNewBinding17 != null ? fragmentPoQuestionsNewBinding17.option4 : null;
            if (radioButton5 != null) {
                radioButton5.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding18 = get_binding();
            RadioButton radioButton6 = fragmentPoQuestionsNewBinding18 != null ? fragmentPoQuestionsNewBinding18.option5 : null;
            if (radioButton6 != null) {
                radioButton6.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding19 = get_binding();
            RadioButton radioButton7 = fragmentPoQuestionsNewBinding19 != null ? fragmentPoQuestionsNewBinding19.option6 : null;
            if (radioButton7 != null) {
                radioButton7.setVisibility(8);
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding20 = get_binding();
            RadioButton radioButton8 = fragmentPoQuestionsNewBinding20 != null ? fragmentPoQuestionsNewBinding20.option1 : null;
            if (radioButton8 != null) {
                ArrayList<PoQuestions> arrayList6 = this.surveyResponse;
                Intrinsics.checkNotNull(arrayList6);
                radioButton8.setText(convertHtmlToString(arrayList6.get(this.i).getOptions().get(0).getOption_name()));
            }
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding21 = get_binding();
            RadioButton radioButton9 = fragmentPoQuestionsNewBinding21 != null ? fragmentPoQuestionsNewBinding21.option2 : null;
            if (radioButton9 != null) {
                ArrayList<PoQuestions> arrayList7 = this.surveyResponse;
                Intrinsics.checkNotNull(arrayList7);
                radioButton9.setText(convertHtmlToString(arrayList7.get(this.i).getOptions().get(1).getOption_name()));
            }
        } else {
            ArrayList<PoQuestions> arrayList8 = this.surveyResponse;
            Intrinsics.checkNotNull(arrayList8);
            if (arrayList8.get(this.i).getOptions().size() == 3) {
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding22 = get_binding();
                RadioButton radioButton10 = fragmentPoQuestionsNewBinding22 != null ? fragmentPoQuestionsNewBinding22.option1 : null;
                if (radioButton10 != null) {
                    radioButton10.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding23 = get_binding();
                RadioButton radioButton11 = fragmentPoQuestionsNewBinding23 != null ? fragmentPoQuestionsNewBinding23.option2 : null;
                if (radioButton11 != null) {
                    radioButton11.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding24 = get_binding();
                RadioButton radioButton12 = fragmentPoQuestionsNewBinding24 != null ? fragmentPoQuestionsNewBinding24.option3 : null;
                if (radioButton12 != null) {
                    radioButton12.setVisibility(0);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding25 = get_binding();
                RadioButton radioButton13 = fragmentPoQuestionsNewBinding25 != null ? fragmentPoQuestionsNewBinding25.option4 : null;
                if (radioButton13 != null) {
                    radioButton13.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding26 = get_binding();
                RadioButton radioButton14 = fragmentPoQuestionsNewBinding26 != null ? fragmentPoQuestionsNewBinding26.option5 : null;
                if (radioButton14 != null) {
                    radioButton14.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding27 = get_binding();
                RadioButton radioButton15 = fragmentPoQuestionsNewBinding27 != null ? fragmentPoQuestionsNewBinding27.option6 : null;
                if (radioButton15 != null) {
                    radioButton15.setVisibility(8);
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding28 = get_binding();
                RadioButton radioButton16 = fragmentPoQuestionsNewBinding28 != null ? fragmentPoQuestionsNewBinding28.option1 : null;
                if (radioButton16 != null) {
                    ArrayList<PoQuestions> arrayList9 = this.surveyResponse;
                    Intrinsics.checkNotNull(arrayList9);
                    radioButton16.setText(convertHtmlToString(arrayList9.get(this.i).getOptions().get(0).getOption_name()));
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding29 = get_binding();
                RadioButton radioButton17 = fragmentPoQuestionsNewBinding29 != null ? fragmentPoQuestionsNewBinding29.option2 : null;
                if (radioButton17 != null) {
                    ArrayList<PoQuestions> arrayList10 = this.surveyResponse;
                    Intrinsics.checkNotNull(arrayList10);
                    radioButton17.setText(convertHtmlToString(arrayList10.get(this.i).getOptions().get(1).getOption_name()));
                }
                FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding30 = get_binding();
                RadioButton radioButton18 = fragmentPoQuestionsNewBinding30 != null ? fragmentPoQuestionsNewBinding30.option3 : null;
                if (radioButton18 != null) {
                    ArrayList<PoQuestions> arrayList11 = this.surveyResponse;
                    Intrinsics.checkNotNull(arrayList11);
                    radioButton18.setText(convertHtmlToString(arrayList11.get(this.i).getOptions().get(2).getOption_name()));
                }
            } else {
                ArrayList<PoQuestions> arrayList12 = this.surveyResponse;
                Intrinsics.checkNotNull(arrayList12);
                if (arrayList12.get(this.i).getOptions().size() == 4) {
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding31 = get_binding();
                    RadioButton radioButton19 = fragmentPoQuestionsNewBinding31 != null ? fragmentPoQuestionsNewBinding31.option1 : null;
                    if (radioButton19 != null) {
                        radioButton19.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding32 = get_binding();
                    RadioButton radioButton20 = fragmentPoQuestionsNewBinding32 != null ? fragmentPoQuestionsNewBinding32.option2 : null;
                    if (radioButton20 != null) {
                        radioButton20.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding33 = get_binding();
                    RadioButton radioButton21 = fragmentPoQuestionsNewBinding33 != null ? fragmentPoQuestionsNewBinding33.option3 : null;
                    if (radioButton21 != null) {
                        radioButton21.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding34 = get_binding();
                    RadioButton radioButton22 = fragmentPoQuestionsNewBinding34 != null ? fragmentPoQuestionsNewBinding34.option4 : null;
                    if (radioButton22 != null) {
                        radioButton22.setVisibility(0);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding35 = get_binding();
                    RadioButton radioButton23 = fragmentPoQuestionsNewBinding35 != null ? fragmentPoQuestionsNewBinding35.option5 : null;
                    if (radioButton23 != null) {
                        radioButton23.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding36 = get_binding();
                    RadioButton radioButton24 = fragmentPoQuestionsNewBinding36 != null ? fragmentPoQuestionsNewBinding36.option6 : null;
                    if (radioButton24 != null) {
                        radioButton24.setVisibility(8);
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding37 = get_binding();
                    RadioButton radioButton25 = fragmentPoQuestionsNewBinding37 != null ? fragmentPoQuestionsNewBinding37.option1 : null;
                    if (radioButton25 != null) {
                        ArrayList<PoQuestions> arrayList13 = this.surveyResponse;
                        Intrinsics.checkNotNull(arrayList13);
                        radioButton25.setText(convertHtmlToString(arrayList13.get(this.i).getOptions().get(0).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding38 = get_binding();
                    RadioButton radioButton26 = fragmentPoQuestionsNewBinding38 != null ? fragmentPoQuestionsNewBinding38.option2 : null;
                    if (radioButton26 != null) {
                        ArrayList<PoQuestions> arrayList14 = this.surveyResponse;
                        Intrinsics.checkNotNull(arrayList14);
                        radioButton26.setText(convertHtmlToString(arrayList14.get(this.i).getOptions().get(1).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding39 = get_binding();
                    RadioButton radioButton27 = fragmentPoQuestionsNewBinding39 != null ? fragmentPoQuestionsNewBinding39.option3 : null;
                    if (radioButton27 != null) {
                        ArrayList<PoQuestions> arrayList15 = this.surveyResponse;
                        Intrinsics.checkNotNull(arrayList15);
                        radioButton27.setText(convertHtmlToString(arrayList15.get(this.i).getOptions().get(2).getOption_name()));
                    }
                    FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding40 = get_binding();
                    RadioButton radioButton28 = fragmentPoQuestionsNewBinding40 != null ? fragmentPoQuestionsNewBinding40.option4 : null;
                    if (radioButton28 != null) {
                        ArrayList<PoQuestions> arrayList16 = this.surveyResponse;
                        Intrinsics.checkNotNull(arrayList16);
                        radioButton28.setText(convertHtmlToString(arrayList16.get(this.i).getOptions().get(3).getOption_name()));
                    }
                } else {
                    ArrayList<PoQuestions> arrayList17 = this.surveyResponse;
                    Intrinsics.checkNotNull(arrayList17);
                    if (arrayList17.get(this.i).getOptions().size() == 5) {
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding41 = get_binding();
                        RadioButton radioButton29 = fragmentPoQuestionsNewBinding41 != null ? fragmentPoQuestionsNewBinding41.option1 : null;
                        if (radioButton29 != null) {
                            radioButton29.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding42 = get_binding();
                        RadioButton radioButton30 = fragmentPoQuestionsNewBinding42 != null ? fragmentPoQuestionsNewBinding42.option2 : null;
                        if (radioButton30 != null) {
                            radioButton30.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding43 = get_binding();
                        RadioButton radioButton31 = fragmentPoQuestionsNewBinding43 != null ? fragmentPoQuestionsNewBinding43.option3 : null;
                        if (radioButton31 != null) {
                            radioButton31.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding44 = get_binding();
                        RadioButton radioButton32 = fragmentPoQuestionsNewBinding44 != null ? fragmentPoQuestionsNewBinding44.option4 : null;
                        if (radioButton32 != null) {
                            radioButton32.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding45 = get_binding();
                        RadioButton radioButton33 = fragmentPoQuestionsNewBinding45 != null ? fragmentPoQuestionsNewBinding45.option5 : null;
                        if (radioButton33 != null) {
                            radioButton33.setVisibility(0);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding46 = get_binding();
                        RadioButton radioButton34 = fragmentPoQuestionsNewBinding46 != null ? fragmentPoQuestionsNewBinding46.option6 : null;
                        if (radioButton34 != null) {
                            radioButton34.setVisibility(8);
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding47 = get_binding();
                        RadioButton radioButton35 = fragmentPoQuestionsNewBinding47 != null ? fragmentPoQuestionsNewBinding47.option1 : null;
                        if (radioButton35 != null) {
                            ArrayList<PoQuestions> arrayList18 = this.surveyResponse;
                            Intrinsics.checkNotNull(arrayList18);
                            radioButton35.setText(convertHtmlToString(arrayList18.get(this.i).getOptions().get(0).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding48 = get_binding();
                        RadioButton radioButton36 = fragmentPoQuestionsNewBinding48 != null ? fragmentPoQuestionsNewBinding48.option2 : null;
                        if (radioButton36 != null) {
                            ArrayList<PoQuestions> arrayList19 = this.surveyResponse;
                            Intrinsics.checkNotNull(arrayList19);
                            radioButton36.setText(convertHtmlToString(arrayList19.get(this.i).getOptions().get(1).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding49 = get_binding();
                        RadioButton radioButton37 = fragmentPoQuestionsNewBinding49 != null ? fragmentPoQuestionsNewBinding49.option3 : null;
                        if (radioButton37 != null) {
                            ArrayList<PoQuestions> arrayList20 = this.surveyResponse;
                            Intrinsics.checkNotNull(arrayList20);
                            radioButton37.setText(convertHtmlToString(arrayList20.get(this.i).getOptions().get(2).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding50 = get_binding();
                        RadioButton radioButton38 = fragmentPoQuestionsNewBinding50 != null ? fragmentPoQuestionsNewBinding50.option4 : null;
                        if (radioButton38 != null) {
                            ArrayList<PoQuestions> arrayList21 = this.surveyResponse;
                            Intrinsics.checkNotNull(arrayList21);
                            radioButton38.setText(convertHtmlToString(arrayList21.get(this.i).getOptions().get(3).getOption_name()));
                        }
                        FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding51 = get_binding();
                        RadioButton radioButton39 = fragmentPoQuestionsNewBinding51 != null ? fragmentPoQuestionsNewBinding51.option5 : null;
                        if (radioButton39 != null) {
                            ArrayList<PoQuestions> arrayList22 = this.surveyResponse;
                            Intrinsics.checkNotNull(arrayList22);
                            radioButton39.setText(convertHtmlToString(arrayList22.get(this.i).getOptions().get(4).getOption_name()));
                        }
                    } else {
                        ArrayList<PoQuestions> arrayList23 = this.surveyResponse;
                        Intrinsics.checkNotNull(arrayList23);
                        if (arrayList23.get(this.i).getOptions().size() == 6) {
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding52 = get_binding();
                            RadioButton radioButton40 = fragmentPoQuestionsNewBinding52 != null ? fragmentPoQuestionsNewBinding52.option1 : null;
                            if (radioButton40 != null) {
                                radioButton40.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding53 = get_binding();
                            RadioButton radioButton41 = fragmentPoQuestionsNewBinding53 != null ? fragmentPoQuestionsNewBinding53.option2 : null;
                            if (radioButton41 != null) {
                                radioButton41.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding54 = get_binding();
                            RadioButton radioButton42 = fragmentPoQuestionsNewBinding54 != null ? fragmentPoQuestionsNewBinding54.option3 : null;
                            if (radioButton42 != null) {
                                radioButton42.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding55 = get_binding();
                            RadioButton radioButton43 = fragmentPoQuestionsNewBinding55 != null ? fragmentPoQuestionsNewBinding55.option4 : null;
                            if (radioButton43 != null) {
                                radioButton43.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding56 = get_binding();
                            RadioButton radioButton44 = fragmentPoQuestionsNewBinding56 != null ? fragmentPoQuestionsNewBinding56.option5 : null;
                            if (radioButton44 != null) {
                                radioButton44.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding57 = get_binding();
                            RadioButton radioButton45 = fragmentPoQuestionsNewBinding57 != null ? fragmentPoQuestionsNewBinding57.option6 : null;
                            if (radioButton45 != null) {
                                radioButton45.setVisibility(0);
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding58 = get_binding();
                            RadioButton radioButton46 = fragmentPoQuestionsNewBinding58 != null ? fragmentPoQuestionsNewBinding58.option1 : null;
                            if (radioButton46 != null) {
                                ArrayList<PoQuestions> arrayList24 = this.surveyResponse;
                                Intrinsics.checkNotNull(arrayList24);
                                radioButton46.setText(convertHtmlToString(arrayList24.get(this.i).getOptions().get(0).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding59 = get_binding();
                            RadioButton radioButton47 = fragmentPoQuestionsNewBinding59 != null ? fragmentPoQuestionsNewBinding59.option2 : null;
                            if (radioButton47 != null) {
                                ArrayList<PoQuestions> arrayList25 = this.surveyResponse;
                                Intrinsics.checkNotNull(arrayList25);
                                radioButton47.setText(convertHtmlToString(arrayList25.get(this.i).getOptions().get(1).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding60 = get_binding();
                            RadioButton radioButton48 = fragmentPoQuestionsNewBinding60 != null ? fragmentPoQuestionsNewBinding60.option3 : null;
                            if (radioButton48 != null) {
                                ArrayList<PoQuestions> arrayList26 = this.surveyResponse;
                                Intrinsics.checkNotNull(arrayList26);
                                radioButton48.setText(convertHtmlToString(arrayList26.get(this.i).getOptions().get(2).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding61 = get_binding();
                            RadioButton radioButton49 = fragmentPoQuestionsNewBinding61 != null ? fragmentPoQuestionsNewBinding61.option4 : null;
                            if (radioButton49 != null) {
                                ArrayList<PoQuestions> arrayList27 = this.surveyResponse;
                                Intrinsics.checkNotNull(arrayList27);
                                radioButton49.setText(convertHtmlToString(arrayList27.get(this.i).getOptions().get(3).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding62 = get_binding();
                            RadioButton radioButton50 = fragmentPoQuestionsNewBinding62 != null ? fragmentPoQuestionsNewBinding62.option5 : null;
                            if (radioButton50 != null) {
                                ArrayList<PoQuestions> arrayList28 = this.surveyResponse;
                                Intrinsics.checkNotNull(arrayList28);
                                radioButton50.setText(convertHtmlToString(arrayList28.get(this.i).getOptions().get(4).getOption_name()));
                            }
                            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding63 = get_binding();
                            RadioButton radioButton51 = fragmentPoQuestionsNewBinding63 != null ? fragmentPoQuestionsNewBinding63.option6 : null;
                            if (radioButton51 != null) {
                                ArrayList<PoQuestions> arrayList29 = this.surveyResponse;
                                Intrinsics.checkNotNull(arrayList29);
                                radioButton51.setText(convertHtmlToString(arrayList29.get(this.i).getOptions().get(5).getOption_name()));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(this.i);
        ArrayList<PoQuestions> arrayList30 = this.surveyResponse;
        Intrinsics.checkNotNull(arrayList30);
        if (arrayList30.get(this.i).getRequired()) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding64 = get_binding();
            TextView textView14 = fragmentPoQuestionsNewBinding64 != null ? fragmentPoQuestionsNewBinding64.requiredTv : null;
            if (textView14 != null) {
                textView14.setVisibility(0);
            }
        } else {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding65 = get_binding();
            TextView textView15 = fragmentPoQuestionsNewBinding65 != null ? fragmentPoQuestionsNewBinding65.requiredTv : null;
            if (textView15 != null) {
                textView15.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(this.surveyAnswers.get(this.i), "")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding66 = get_binding();
            if (fragmentPoQuestionsNewBinding66 != null && (radioGroup = fragmentPoQuestionsNewBinding66.teacherSurveyQuestionsMultiple) != null) {
                radioGroup.clearCheck();
            }
        } else if (Intrinsics.areEqual(this.surveyAnswers.get(this.i), "0")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding67 = get_binding();
            radioButton = fragmentPoQuestionsNewBinding67 != null ? fragmentPoQuestionsNewBinding67.option1 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this.surveyAnswers.get(this.i), "1")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding68 = get_binding();
            radioButton = fragmentPoQuestionsNewBinding68 != null ? fragmentPoQuestionsNewBinding68.option2 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this.surveyAnswers.get(this.i), ExifInterface.GPS_MEASUREMENT_2D)) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding69 = get_binding();
            radioButton = fragmentPoQuestionsNewBinding69 != null ? fragmentPoQuestionsNewBinding69.option3 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this.surveyAnswers.get(this.i), ExifInterface.GPS_MEASUREMENT_3D)) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding70 = get_binding();
            radioButton = fragmentPoQuestionsNewBinding70 != null ? fragmentPoQuestionsNewBinding70.option4 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this.surveyAnswers.get(this.i), "4")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding71 = get_binding();
            radioButton = fragmentPoQuestionsNewBinding71 != null ? fragmentPoQuestionsNewBinding71.option5 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (Intrinsics.areEqual(this.surveyAnswers.get(this.i), "5")) {
            FragmentPoQuestionsNewBinding fragmentPoQuestionsNewBinding72 = get_binding();
            radioButton = fragmentPoQuestionsNewBinding72 != null ? fragmentPoQuestionsNewBinding72.option6 : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        }
        System.out.println(this.surveyAnswers);
    }
}