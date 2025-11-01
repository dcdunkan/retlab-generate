package in.etuwa.app.ui.newquiz.questions;

import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.quiz.QuestionsNew;
import in.etuwa.app.data.model.quiz.QuestionsNewResponse;
import in.etuwa.app.data.model.quiz.submit.QuizSubmitResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentQuizQuestionsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: QuizQuestionsFragment.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 P2\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\tJ\u0010\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0007J\u0012\u0010/\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020\tH\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020\tH\u0002J\b\u00101\u001a\u000202H\u0014J\b\u00103\u001a\u000202H\u0014J\b\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u000202H\u0002J\b\u00106\u001a\u000202H\u0003J\b\u00107\u001a\u000202H\u0002J\"\u00108\u001a\u0002022\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u0002022\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J&\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010I\u001a\u000202H\u0016J\b\u0010J\u001a\u000202H\u0016J\u001a\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020D2\b\u0010A\u001a\u0004\u0018\u00010BH\u0017J\b\u0010M\u001a\u000202H\u0015J\b\u0010N\u001a\u000202H\u0014J\b\u0010O\u001a\u000202H\u0014J\u0010\u0010(\u001a\u0002022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b!\u0010\"R\"\u0010$\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006Q"}, d2 = {"Lin/etuwa/app/ui/newquiz/questions/QuizQuestionsFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentQuizQuestionsBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentQuizQuestionsBinding;", "descriptiveAnswer", "", "finalUpload", "", "flag", "flagFile", "i", "", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "option", "optionAnswer", "pickFile", "Ljava/io/File;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "quizAnswers", "", "quizQuestionsViewModel", "Lin/etuwa/app/ui/newquiz/questions/QuizQuestionsViewModel;", "getQuizQuestionsViewModel", "()Lin/etuwa/app/ui/newquiz/questions/QuizQuestionsViewModel;", "quizQuestionsViewModel$delegate", "quizResponse", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/quiz/QuestionsNew;", "Lkotlin/collections/ArrayList;", "submitAnswer", "Ljava/util/HashMap;", "getSubmitAnswer", "()Ljava/util/HashMap;", "containsImageUrl", "html", "convertHtmlToString", "extractImageUrl", "extractStringFromHtml", "hideBaseView", "", "hideProgress", "listenAnswerResponse", "listenProgressResponse", "listenResponse", "listenUploadResponse", "onActivityResult", "requestCode", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuizQuestionsFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentQuizQuestionsBinding _binding;
    private String descriptiveAnswer;
    private boolean finalUpload;
    private boolean flag;
    private boolean flagFile;
    private int i;
    private String id;
    private MainCallBackListener listener;
    private String option;
    private String optionAnswer;
    private File pickFile;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> quizAnswers;

    /* renamed from: quizQuestionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy quizQuestionsViewModel;
    private ArrayList<QuestionsNew> quizResponse;
    private final HashMap<String, String> submitAnswer;

    /* compiled from: QuizQuestionsFragment.kt */
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
    public static final QuizQuestionsFragment newInstance(String str) {
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

    public QuizQuestionsFragment() {
        final QuizQuestionsFragment quizQuestionsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(quizQuestionsFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.quizQuestionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(quizQuestionsFragment, Reflection.getOrCreateKotlinClass(QuizQuestionsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(QuizQuestionsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final QuizQuestionsFragment quizQuestionsFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = quizQuestionsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.quizAnswers = new ArrayList();
        this.option = "";
        this.submitAnswer = new HashMap<>();
        this.optionAnswer = "";
        this.descriptiveAnswer = "";
    }

    private final QuizQuestionsViewModel getQuizQuestionsViewModel() {
        return (QuizQuestionsViewModel) this.quizQuestionsViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentQuizQuestionsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final HashMap<String, String> getSubmitAnswer() {
        return this.submitAnswer;
    }

    /* compiled from: QuizQuestionsFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/newquiz/questions/QuizQuestionsFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/newquiz/questions/QuizQuestionsFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final QuizQuestionsFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            QuizQuestionsFragment quizQuestionsFragment = new QuizQuestionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            quizQuestionsFragment.setArguments(bundle);
            return quizQuestionsFragment;
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
        this._binding = FragmentQuizQuestionsBinding.inflate(inflater, container, false);
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = get_binding();
        if (fragmentQuizQuestionsBinding != null) {
            fragmentQuizQuestionsBinding.setQuizQuestionsViewModel(getQuizQuestionsViewModel());
        }
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = get_binding();
        if (fragmentQuizQuestionsBinding2 != null) {
            fragmentQuizQuestionsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding3 = get_binding();
        if (fragmentQuizQuestionsBinding3 != null) {
            return fragmentQuizQuestionsBinding3.getRoot();
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
        TextView textView4;
        RadioGroup radioGroup;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.quiz));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        listenResponse();
        listenAnswerResponse();
        listenUploadResponse();
        listenProgressResponse();
        QuizQuestionsViewModel quizQuestionsViewModel = getQuizQuestionsViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        quizQuestionsViewModel.getQuizQuestionsList(str);
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = get_binding();
        TextView textView5 = fragmentQuizQuestionsBinding != null ? fragmentQuizQuestionsBinding.backBtn : null;
        if (textView5 != null) {
            textView5.setVisibility(4);
        }
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = get_binding();
        if (fragmentQuizQuestionsBinding2 != null && (radioGroup = fragmentQuizQuestionsBinding2.quizQuestionsMultiple) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda4
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    QuizQuestionsFragment.setUp$lambda$1(QuizQuestionsFragment.this, radioGroup2, i);
                }
            });
        }
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding3 = get_binding();
        if (fragmentQuizQuestionsBinding3 != null && (textView4 = fragmentQuizQuestionsBinding3.nextBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuizQuestionsFragment.setUp$lambda$2(QuizQuestionsFragment.this, view);
                }
            });
        }
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding4 = get_binding();
        if (fragmentQuizQuestionsBinding4 != null && (textView3 = fragmentQuizQuestionsBinding4.backBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuizQuestionsFragment.setUp$lambda$3(QuizQuestionsFragment.this, view);
                }
            });
        }
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding5 = get_binding();
        if (fragmentQuizQuestionsBinding5 != null && (textView2 = fragmentQuizQuestionsBinding5.finishBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuizQuestionsFragment.setUp$lambda$4(QuizQuestionsFragment.this, view);
                }
            });
        }
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding6 = get_binding();
        if (fragmentQuizQuestionsBinding6 == null || (textView = fragmentQuizQuestionsBinding6.completionSelect) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuizQuestionsFragment.setUp$lambda$6(QuizQuestionsFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(QuizQuestionsFragment this$0, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.option_1) {
            this$0.option = "0";
            this$0.optionAnswer = "0";
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_2) {
            this$0.option = "1";
            this$0.optionAnswer = "1";
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_3) {
            this$0.option = ExifInterface.GPS_MEASUREMENT_2D;
            this$0.optionAnswer = ExifInterface.GPS_MEASUREMENT_2D;
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_4) {
            this$0.option = ExifInterface.GPS_MEASUREMENT_3D;
            this$0.optionAnswer = ExifInterface.GPS_MEASUREMENT_3D;
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_5) {
            this$0.option = "4";
            this$0.optionAnswer = "4";
        } else {
            this$0.optionAnswer = "";
        }
        int i2 = this$0.i;
        ArrayList<QuestionsNew> arrayList = this$0.quizResponse;
        Intrinsics.checkNotNull(arrayList);
        if (i2 <= arrayList.size()) {
            try {
                this$0.quizAnswers.set(this$0.i, this$0.option);
                this$0.option = "";
                System.out.println((Object) "");
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(QuizQuestionsFragment this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        RadioGroup radioGroup;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = this$0.get_binding();
        this$0.descriptiveAnswer = String.valueOf((fragmentQuizQuestionsBinding == null || (textInputEditText6 = fragmentQuizQuestionsBinding.etDescriptive) == null) ? null : textInputEditText6.getText());
        this$0.submitAnswer(this$0.i);
        System.out.println(this$0.quizAnswers);
        System.out.println(this$0.i);
        int i = this$0.i;
        ArrayList<QuestionsNew> arrayList = this$0.quizResponse;
        Intrinsics.checkNotNull(arrayList);
        if (i < arrayList.size()) {
            this$0.i++;
            ArrayList<QuestionsNew> arrayList2 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList2);
            if (Intrinsics.areEqual(arrayList2.get(this$0.i - 1).getQuestionType(), ExifInterface.GPS_MEASUREMENT_2D)) {
                List<String> list = this$0.quizAnswers;
                int i2 = this$0.i - 1;
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = this$0.get_binding();
                list.set(i2, String.valueOf((fragmentQuizQuestionsBinding2 == null || (textInputEditText5 = fragmentQuizQuestionsBinding2.etDescriptive) == null) ? null : textInputEditText5.getText()));
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding3 = this$0.get_binding();
                if (fragmentQuizQuestionsBinding3 != null && (textInputEditText4 = fragmentQuizQuestionsBinding3.etDescriptive) != null) {
                    textInputEditText4.setText("");
                }
            }
            int i3 = this$0.i;
            ArrayList<QuestionsNew> arrayList3 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList3);
            if (i3 <= arrayList3.size() - 1) {
                ArrayList<QuestionsNew> arrayList4 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList4);
                if (this$0.containsImageUrl(arrayList4.get(this$0.i).getQuestion())) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding4 = this$0.get_binding();
                    TextView textView = fragmentQuizQuestionsBinding4 != null ? fragmentQuizQuestionsBinding4.quizQuestion : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding5 = this$0.get_binding();
                    ImageView imageView = fragmentQuizQuestionsBinding5 != null ? fragmentQuizQuestionsBinding5.questionImage : null;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    ArrayList<QuestionsNew> arrayList5 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList5);
                    String extractImageUrl = this$0.extractImageUrl(arrayList5.get(this$0.i).getQuestion());
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding6 = this$0.get_binding();
                    TextView textView2 = fragmentQuizQuestionsBinding6 != null ? fragmentQuizQuestionsBinding6.quizQuestion : null;
                    if (textView2 != null) {
                        ArrayList<QuestionsNew> arrayList6 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList6);
                        textView2.setText("Q ) " + this$0.extractStringFromHtml(arrayList6.get(this$0.i).getQuestion()));
                    }
                    if (extractImageUrl != null) {
                        RequestBuilder<Drawable> load = Glide.with(this$0).load(extractImageUrl);
                        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding7 = this$0.get_binding();
                        ImageView imageView2 = fragmentQuizQuestionsBinding7 != null ? fragmentQuizQuestionsBinding7.questionImage : null;
                        Intrinsics.checkNotNull(imageView2);
                        load.into(imageView2);
                    }
                } else {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding8 = this$0.get_binding();
                    TextView textView3 = fragmentQuizQuestionsBinding8 != null ? fragmentQuizQuestionsBinding8.quizQuestion : null;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding9 = this$0.get_binding();
                    ImageView imageView3 = fragmentQuizQuestionsBinding9 != null ? fragmentQuizQuestionsBinding9.questionImage : null;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding10 = this$0.get_binding();
                    TextView textView4 = fragmentQuizQuestionsBinding10 != null ? fragmentQuizQuestionsBinding10.quizQuestion : null;
                    if (textView4 != null) {
                        ArrayList<QuestionsNew> arrayList7 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList7);
                        textView4.setText("Q) " + this$0.convertHtmlToString(arrayList7.get(this$0.i).getQuestion()));
                    }
                }
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding11 = this$0.get_binding();
            if (fragmentQuizQuestionsBinding11 != null && (textInputEditText3 = fragmentQuizQuestionsBinding11.etDescriptive) != null) {
                textInputEditText3.setText("");
            }
            System.out.println(this$0.quizAnswers);
            if (this$0.i == 0) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding12 = this$0.get_binding();
                TextView textView5 = fragmentQuizQuestionsBinding12 != null ? fragmentQuizQuestionsBinding12.backBtn : null;
                if (textView5 != null) {
                    textView5.setVisibility(4);
                }
            } else {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding13 = this$0.get_binding();
                TextView textView6 = fragmentQuizQuestionsBinding13 != null ? fragmentQuizQuestionsBinding13.backBtn : null;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
            }
            int i4 = this$0.i;
            ArrayList<QuestionsNew> arrayList8 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList8);
            if (i4 > arrayList8.size() - 1) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding14 = this$0.get_binding();
                TextView textView7 = fragmentQuizQuestionsBinding14 != null ? fragmentQuizQuestionsBinding14.nextBtn : null;
                if (textView7 != null) {
                    textView7.setVisibility(4);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding15 = this$0.get_binding();
                TextView textView8 = fragmentQuizQuestionsBinding15 != null ? fragmentQuizQuestionsBinding15.finishBtn : null;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
                this$0.flag = true;
            } else {
                int i5 = this$0.i;
                ArrayList<QuestionsNew> arrayList9 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList9);
                if (i5 == arrayList9.size() - 1) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding16 = this$0.get_binding();
                    TextView textView9 = fragmentQuizQuestionsBinding16 != null ? fragmentQuizQuestionsBinding16.nextBtn : null;
                    if (textView9 != null) {
                        textView9.setVisibility(4);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding17 = this$0.get_binding();
                    TextView textView10 = fragmentQuizQuestionsBinding17 != null ? fragmentQuizQuestionsBinding17.finishBtn : null;
                    if (textView10 != null) {
                        textView10.setVisibility(0);
                    }
                } else {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding18 = this$0.get_binding();
                    TextView textView11 = fragmentQuizQuestionsBinding18 != null ? fragmentQuizQuestionsBinding18.nextBtn : null;
                    if (textView11 != null) {
                        textView11.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding19 = this$0.get_binding();
                    TextView textView12 = fragmentQuizQuestionsBinding19 != null ? fragmentQuizQuestionsBinding19.finishBtn : null;
                    if (textView12 != null) {
                        textView12.setVisibility(4);
                    }
                }
            }
            if (this$0.flag) {
                return;
            }
            ArrayList<QuestionsNew> arrayList10 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList10);
            if (Intrinsics.areEqual(arrayList10.get(this$0.i).getQuestionType(), "1")) {
                if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "")) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding20 = this$0.get_binding();
                    if (fragmentQuizQuestionsBinding20 != null && (radioGroup = fragmentQuizQuestionsBinding20.quizQuestionsMultiple) != null) {
                        radioGroup.clearCheck();
                    }
                } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "0")) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding21 = this$0.get_binding();
                    RadioButton radioButton = fragmentQuizQuestionsBinding21 != null ? fragmentQuizQuestionsBinding21.option1 : null;
                    if (radioButton != null) {
                        radioButton.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "1")) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding22 = this$0.get_binding();
                    RadioButton radioButton2 = fragmentQuizQuestionsBinding22 != null ? fragmentQuizQuestionsBinding22.option2 : null;
                    if (radioButton2 != null) {
                        radioButton2.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_2D)) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding23 = this$0.get_binding();
                    RadioButton radioButton3 = fragmentQuizQuestionsBinding23 != null ? fragmentQuizQuestionsBinding23.option3 : null;
                    if (radioButton3 != null) {
                        radioButton3.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_3D)) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding24 = this$0.get_binding();
                    RadioButton radioButton4 = fragmentQuizQuestionsBinding24 != null ? fragmentQuizQuestionsBinding24.option4 : null;
                    if (radioButton4 != null) {
                        radioButton4.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "4")) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding25 = this$0.get_binding();
                    RadioButton radioButton5 = fragmentQuizQuestionsBinding25 != null ? fragmentQuizQuestionsBinding25.option5 : null;
                    if (radioButton5 != null) {
                        radioButton5.setChecked(true);
                    }
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding26 = this$0.get_binding();
                TextView textView13 = fragmentQuizQuestionsBinding26 != null ? fragmentQuizQuestionsBinding26.quizQuestionNo : null;
                if (textView13 != null) {
                    textView13.setText("Question " + (this$0.i + 1) + " (Multiple Choice)");
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding27 = this$0.get_binding();
                LinearLayout linearLayout = fragmentQuizQuestionsBinding27 != null ? fragmentQuizQuestionsBinding27.descriptiveAnswerLyt : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding28 = this$0.get_binding();
                LinearLayout linearLayout2 = fragmentQuizQuestionsBinding28 != null ? fragmentQuizQuestionsBinding28.multipleAnswerLyt : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding29 = this$0.get_binding();
                LinearLayout linearLayout3 = fragmentQuizQuestionsBinding29 != null ? fragmentQuizQuestionsBinding29.completionCard : null;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                ArrayList<QuestionsNew> arrayList11 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList11);
                if (arrayList11.get(this$0.i).getOptions().size() == 2) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding30 = this$0.get_binding();
                    RadioButton radioButton6 = fragmentQuizQuestionsBinding30 != null ? fragmentQuizQuestionsBinding30.option1 : null;
                    if (radioButton6 != null) {
                        radioButton6.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding31 = this$0.get_binding();
                    RadioButton radioButton7 = fragmentQuizQuestionsBinding31 != null ? fragmentQuizQuestionsBinding31.option2 : null;
                    if (radioButton7 != null) {
                        radioButton7.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding32 = this$0.get_binding();
                    RadioButton radioButton8 = fragmentQuizQuestionsBinding32 != null ? fragmentQuizQuestionsBinding32.option3 : null;
                    if (radioButton8 != null) {
                        radioButton8.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding33 = this$0.get_binding();
                    RadioButton radioButton9 = fragmentQuizQuestionsBinding33 != null ? fragmentQuizQuestionsBinding33.option4 : null;
                    if (radioButton9 != null) {
                        radioButton9.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding34 = this$0.get_binding();
                    RadioButton radioButton10 = fragmentQuizQuestionsBinding34 != null ? fragmentQuizQuestionsBinding34.option5 : null;
                    if (radioButton10 != null) {
                        radioButton10.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding35 = this$0.get_binding();
                    RadioButton radioButton11 = fragmentQuizQuestionsBinding35 != null ? fragmentQuizQuestionsBinding35.option1 : null;
                    if (radioButton11 != null) {
                        ArrayList<QuestionsNew> arrayList12 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList12);
                        radioButton11.setText(this$0.convertHtmlToString(arrayList12.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding36 = this$0.get_binding();
                    RadioButton radioButton12 = fragmentQuizQuestionsBinding36 != null ? fragmentQuizQuestionsBinding36.option2 : null;
                    if (radioButton12 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList13 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList13);
                    radioButton12.setText(this$0.convertHtmlToString(arrayList13.get(this$0.i).getOptions().get(1).getOption()));
                    return;
                }
                ArrayList<QuestionsNew> arrayList14 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList14);
                if (arrayList14.get(this$0.i).getOptions().size() == 3) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding37 = this$0.get_binding();
                    RadioButton radioButton13 = fragmentQuizQuestionsBinding37 != null ? fragmentQuizQuestionsBinding37.option1 : null;
                    if (radioButton13 != null) {
                        radioButton13.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding38 = this$0.get_binding();
                    RadioButton radioButton14 = fragmentQuizQuestionsBinding38 != null ? fragmentQuizQuestionsBinding38.option2 : null;
                    if (radioButton14 != null) {
                        radioButton14.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding39 = this$0.get_binding();
                    RadioButton radioButton15 = fragmentQuizQuestionsBinding39 != null ? fragmentQuizQuestionsBinding39.option3 : null;
                    if (radioButton15 != null) {
                        radioButton15.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding40 = this$0.get_binding();
                    RadioButton radioButton16 = fragmentQuizQuestionsBinding40 != null ? fragmentQuizQuestionsBinding40.option4 : null;
                    if (radioButton16 != null) {
                        radioButton16.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding41 = this$0.get_binding();
                    RadioButton radioButton17 = fragmentQuizQuestionsBinding41 != null ? fragmentQuizQuestionsBinding41.option5 : null;
                    if (radioButton17 != null) {
                        radioButton17.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding42 = this$0.get_binding();
                    RadioButton radioButton18 = fragmentQuizQuestionsBinding42 != null ? fragmentQuizQuestionsBinding42.option1 : null;
                    if (radioButton18 != null) {
                        ArrayList<QuestionsNew> arrayList15 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList15);
                        radioButton18.setText(this$0.convertHtmlToString(arrayList15.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding43 = this$0.get_binding();
                    RadioButton radioButton19 = fragmentQuizQuestionsBinding43 != null ? fragmentQuizQuestionsBinding43.option2 : null;
                    if (radioButton19 != null) {
                        ArrayList<QuestionsNew> arrayList16 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList16);
                        radioButton19.setText(this$0.convertHtmlToString(arrayList16.get(this$0.i).getOptions().get(1).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding44 = this$0.get_binding();
                    RadioButton radioButton20 = fragmentQuizQuestionsBinding44 != null ? fragmentQuizQuestionsBinding44.option3 : null;
                    if (radioButton20 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList17 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList17);
                    radioButton20.setText(this$0.convertHtmlToString(arrayList17.get(this$0.i).getOptions().get(2).getOption()));
                    return;
                }
                ArrayList<QuestionsNew> arrayList18 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList18);
                if (arrayList18.get(this$0.i).getOptions().size() == 4) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding45 = this$0.get_binding();
                    RadioButton radioButton21 = fragmentQuizQuestionsBinding45 != null ? fragmentQuizQuestionsBinding45.option1 : null;
                    if (radioButton21 != null) {
                        radioButton21.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding46 = this$0.get_binding();
                    RadioButton radioButton22 = fragmentQuizQuestionsBinding46 != null ? fragmentQuizQuestionsBinding46.option2 : null;
                    if (radioButton22 != null) {
                        radioButton22.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding47 = this$0.get_binding();
                    RadioButton radioButton23 = fragmentQuizQuestionsBinding47 != null ? fragmentQuizQuestionsBinding47.option3 : null;
                    if (radioButton23 != null) {
                        radioButton23.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding48 = this$0.get_binding();
                    RadioButton radioButton24 = fragmentQuizQuestionsBinding48 != null ? fragmentQuizQuestionsBinding48.option4 : null;
                    if (radioButton24 != null) {
                        radioButton24.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding49 = this$0.get_binding();
                    RadioButton radioButton25 = fragmentQuizQuestionsBinding49 != null ? fragmentQuizQuestionsBinding49.option5 : null;
                    if (radioButton25 != null) {
                        radioButton25.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding50 = this$0.get_binding();
                    RadioButton radioButton26 = fragmentQuizQuestionsBinding50 != null ? fragmentQuizQuestionsBinding50.option1 : null;
                    if (radioButton26 != null) {
                        ArrayList<QuestionsNew> arrayList19 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList19);
                        radioButton26.setText(this$0.convertHtmlToString(arrayList19.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding51 = this$0.get_binding();
                    RadioButton radioButton27 = fragmentQuizQuestionsBinding51 != null ? fragmentQuizQuestionsBinding51.option2 : null;
                    if (radioButton27 != null) {
                        ArrayList<QuestionsNew> arrayList20 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList20);
                        radioButton27.setText(this$0.convertHtmlToString(arrayList20.get(this$0.i).getOptions().get(1).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding52 = this$0.get_binding();
                    RadioButton radioButton28 = fragmentQuizQuestionsBinding52 != null ? fragmentQuizQuestionsBinding52.option3 : null;
                    if (radioButton28 != null) {
                        ArrayList<QuestionsNew> arrayList21 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList21);
                        radioButton28.setText(this$0.convertHtmlToString(arrayList21.get(this$0.i).getOptions().get(2).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding53 = this$0.get_binding();
                    RadioButton radioButton29 = fragmentQuizQuestionsBinding53 != null ? fragmentQuizQuestionsBinding53.option4 : null;
                    if (radioButton29 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList22 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList22);
                    radioButton29.setText(this$0.convertHtmlToString(arrayList22.get(this$0.i).getOptions().get(3).getOption()));
                    return;
                }
                ArrayList<QuestionsNew> arrayList23 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList23);
                if (arrayList23.get(this$0.i).getOptions().size() == 5) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding54 = this$0.get_binding();
                    RadioButton radioButton30 = fragmentQuizQuestionsBinding54 != null ? fragmentQuizQuestionsBinding54.option1 : null;
                    if (radioButton30 != null) {
                        radioButton30.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding55 = this$0.get_binding();
                    RadioButton radioButton31 = fragmentQuizQuestionsBinding55 != null ? fragmentQuizQuestionsBinding55.option2 : null;
                    if (radioButton31 != null) {
                        radioButton31.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding56 = this$0.get_binding();
                    RadioButton radioButton32 = fragmentQuizQuestionsBinding56 != null ? fragmentQuizQuestionsBinding56.option3 : null;
                    if (radioButton32 != null) {
                        radioButton32.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding57 = this$0.get_binding();
                    RadioButton radioButton33 = fragmentQuizQuestionsBinding57 != null ? fragmentQuizQuestionsBinding57.option4 : null;
                    if (radioButton33 != null) {
                        radioButton33.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding58 = this$0.get_binding();
                    RadioButton radioButton34 = fragmentQuizQuestionsBinding58 != null ? fragmentQuizQuestionsBinding58.option5 : null;
                    if (radioButton34 != null) {
                        radioButton34.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding59 = this$0.get_binding();
                    RadioButton radioButton35 = fragmentQuizQuestionsBinding59 != null ? fragmentQuizQuestionsBinding59.option1 : null;
                    if (radioButton35 != null) {
                        ArrayList<QuestionsNew> arrayList24 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList24);
                        radioButton35.setText(this$0.convertHtmlToString(arrayList24.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding60 = this$0.get_binding();
                    RadioButton radioButton36 = fragmentQuizQuestionsBinding60 != null ? fragmentQuizQuestionsBinding60.option2 : null;
                    if (radioButton36 != null) {
                        ArrayList<QuestionsNew> arrayList25 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList25);
                        radioButton36.setText(this$0.convertHtmlToString(arrayList25.get(this$0.i).getOptions().get(1).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding61 = this$0.get_binding();
                    RadioButton radioButton37 = fragmentQuizQuestionsBinding61 != null ? fragmentQuizQuestionsBinding61.option3 : null;
                    if (radioButton37 != null) {
                        ArrayList<QuestionsNew> arrayList26 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList26);
                        radioButton37.setText(this$0.convertHtmlToString(arrayList26.get(this$0.i).getOptions().get(2).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding62 = this$0.get_binding();
                    RadioButton radioButton38 = fragmentQuizQuestionsBinding62 != null ? fragmentQuizQuestionsBinding62.option4 : null;
                    if (radioButton38 != null) {
                        ArrayList<QuestionsNew> arrayList27 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList27);
                        radioButton38.setText(this$0.convertHtmlToString(arrayList27.get(this$0.i).getOptions().get(3).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding63 = this$0.get_binding();
                    RadioButton radioButton39 = fragmentQuizQuestionsBinding63 != null ? fragmentQuizQuestionsBinding63.option5 : null;
                    if (radioButton39 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList28 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList28);
                    radioButton39.setText(this$0.convertHtmlToString(arrayList28.get(this$0.i).getOptions().get(4).getOption()));
                    return;
                }
                return;
            }
            ArrayList<QuestionsNew> arrayList29 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList29);
            if (Intrinsics.areEqual(arrayList29.get(this$0.i).getQuestionType(), ExifInterface.GPS_MEASUREMENT_2D)) {
                if (!Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "")) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding64 = this$0.get_binding();
                    if (fragmentQuizQuestionsBinding64 != null && (textInputEditText2 = fragmentQuizQuestionsBinding64.etDescriptive) != null) {
                        textInputEditText2.setText(this$0.quizAnswers.get(this$0.i));
                    }
                } else {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding65 = this$0.get_binding();
                    if (fragmentQuizQuestionsBinding65 != null && (textInputEditText = fragmentQuizQuestionsBinding65.etDescriptive) != null) {
                        textInputEditText.setText("");
                    }
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding66 = this$0.get_binding();
                TextView textView14 = fragmentQuizQuestionsBinding66 != null ? fragmentQuizQuestionsBinding66.quizQuestionNo : null;
                if (textView14 != null) {
                    textView14.setText("Question " + (this$0.i + 1) + " (Descriptive)");
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding67 = this$0.get_binding();
                LinearLayout linearLayout4 = fragmentQuizQuestionsBinding67 != null ? fragmentQuizQuestionsBinding67.descriptiveAnswerLyt : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding68 = this$0.get_binding();
                LinearLayout linearLayout5 = fragmentQuizQuestionsBinding68 != null ? fragmentQuizQuestionsBinding68.multipleAnswerLyt : null;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding69 = this$0.get_binding();
                LinearLayout linearLayout6 = fragmentQuizQuestionsBinding69 != null ? fragmentQuizQuestionsBinding69.completionCard : null;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding70 = this$0.get_binding();
                TextView textView15 = fragmentQuizQuestionsBinding70 != null ? fragmentQuizQuestionsBinding70.quizQuestion : null;
                if (textView15 == null) {
                    return;
                }
                ArrayList<QuestionsNew> arrayList30 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList30);
                textView15.setText("Q ) " + this$0.convertHtmlToString(arrayList30.get(this$0.i).getQuestion()));
                return;
            }
            ArrayList<QuestionsNew> arrayList31 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList31);
            if (Intrinsics.areEqual(arrayList31.get(this$0.i).getQuestionType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding71 = this$0.get_binding();
                TextView textView16 = fragmentQuizQuestionsBinding71 != null ? fragmentQuizQuestionsBinding71.quizQuestionNo : null;
                if (textView16 != null) {
                    textView16.setText("Question " + (this$0.i + 1) + " (Upload)");
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding72 = this$0.get_binding();
                LinearLayout linearLayout7 = fragmentQuizQuestionsBinding72 != null ? fragmentQuizQuestionsBinding72.descriptiveAnswerLyt : null;
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding73 = this$0.get_binding();
                LinearLayout linearLayout8 = fragmentQuizQuestionsBinding73 != null ? fragmentQuizQuestionsBinding73.multipleAnswerLyt : null;
                if (linearLayout8 != null) {
                    linearLayout8.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding74 = this$0.get_binding();
                LinearLayout linearLayout9 = fragmentQuizQuestionsBinding74 != null ? fragmentQuizQuestionsBinding74.completionCard : null;
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding75 = this$0.get_binding();
                TextView textView17 = fragmentQuizQuestionsBinding75 != null ? fragmentQuizQuestionsBinding75.completionFileName : null;
                if (textView17 == null) {
                    return;
                }
                textView17.setText(this$0.quizAnswers.get(this$0.i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(QuizQuestionsFragment this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        RadioGroup radioGroup;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.i - 1;
        this$0.i = i;
        this$0.flag = false;
        System.out.println(i);
        if (this$0.i == 0) {
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = this$0.get_binding();
            TextView textView = fragmentQuizQuestionsBinding != null ? fragmentQuizQuestionsBinding.backBtn : null;
            if (textView != null) {
                textView.setVisibility(4);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = this$0.get_binding();
            TextView textView2 = fragmentQuizQuestionsBinding2 != null ? fragmentQuizQuestionsBinding2.nextBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding3 = this$0.get_binding();
            TextView textView3 = fragmentQuizQuestionsBinding3 != null ? fragmentQuizQuestionsBinding3.finishBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(4);
            }
        } else {
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding4 = this$0.get_binding();
            TextView textView4 = fragmentQuizQuestionsBinding4 != null ? fragmentQuizQuestionsBinding4.backBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding5 = this$0.get_binding();
            TextView textView5 = fragmentQuizQuestionsBinding5 != null ? fragmentQuizQuestionsBinding5.nextBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding6 = this$0.get_binding();
            TextView textView6 = fragmentQuizQuestionsBinding6 != null ? fragmentQuizQuestionsBinding6.finishBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(4);
            }
        }
        int i2 = this$0.i;
        ArrayList<QuestionsNew> arrayList = this$0.quizResponse;
        Intrinsics.checkNotNull(arrayList);
        if (i2 <= arrayList.size() - 1) {
            ArrayList<QuestionsNew> arrayList2 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList2);
            if (this$0.containsImageUrl(arrayList2.get(this$0.i).getQuestion())) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding7 = this$0.get_binding();
                TextView textView7 = fragmentQuizQuestionsBinding7 != null ? fragmentQuizQuestionsBinding7.quizQuestion : null;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding8 = this$0.get_binding();
                ImageView imageView = fragmentQuizQuestionsBinding8 != null ? fragmentQuizQuestionsBinding8.questionImage : null;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ArrayList<QuestionsNew> arrayList3 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList3);
                String extractImageUrl = this$0.extractImageUrl(arrayList3.get(this$0.i).getQuestion());
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding9 = this$0.get_binding();
                TextView textView8 = fragmentQuizQuestionsBinding9 != null ? fragmentQuizQuestionsBinding9.quizQuestion : null;
                if (textView8 != null) {
                    ArrayList<QuestionsNew> arrayList4 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList4);
                    textView8.setText("Q ) " + this$0.extractStringFromHtml(arrayList4.get(this$0.i).getQuestion()));
                }
                if (extractImageUrl != null) {
                    RequestBuilder<Drawable> load = Glide.with(this$0).load(extractImageUrl);
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding10 = this$0.get_binding();
                    ImageView imageView2 = fragmentQuizQuestionsBinding10 != null ? fragmentQuizQuestionsBinding10.questionImage : null;
                    Intrinsics.checkNotNull(imageView2);
                    load.into(imageView2);
                }
            } else {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding11 = this$0.get_binding();
                TextView textView9 = fragmentQuizQuestionsBinding11 != null ? fragmentQuizQuestionsBinding11.quizQuestion : null;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding12 = this$0.get_binding();
                ImageView imageView3 = fragmentQuizQuestionsBinding12 != null ? fragmentQuizQuestionsBinding12.questionImage : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding13 = this$0.get_binding();
                TextView textView10 = fragmentQuizQuestionsBinding13 != null ? fragmentQuizQuestionsBinding13.quizQuestion : null;
                if (textView10 != null) {
                    ArrayList<QuestionsNew> arrayList5 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList5);
                    textView10.setText(this$0.convertHtmlToString(arrayList5.get(this$0.i).getQuestion()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding14 = this$0.get_binding();
                TextView textView11 = fragmentQuizQuestionsBinding14 != null ? fragmentQuizQuestionsBinding14.quizQuestion : null;
                if (textView11 != null) {
                    ArrayList<QuestionsNew> arrayList6 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList6);
                    textView11.setText("Q) " + this$0.convertHtmlToString(arrayList6.get(this$0.i).getQuestion()));
                }
            }
        }
        ArrayList<QuestionsNew> arrayList7 = this$0.quizResponse;
        Intrinsics.checkNotNull(arrayList7);
        if (Intrinsics.areEqual(arrayList7.get(this$0.i).getQuestionType(), "1")) {
            if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "")) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding15 = this$0.get_binding();
                if (fragmentQuizQuestionsBinding15 != null && (radioGroup = fragmentQuizQuestionsBinding15.quizQuestionsMultiple) != null) {
                    radioGroup.clearCheck();
                }
            } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "0")) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding16 = this$0.get_binding();
                RadioButton radioButton = fragmentQuizQuestionsBinding16 != null ? fragmentQuizQuestionsBinding16.option1 : null;
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
            } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "1")) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding17 = this$0.get_binding();
                RadioButton radioButton2 = fragmentQuizQuestionsBinding17 != null ? fragmentQuizQuestionsBinding17.option2 : null;
                if (radioButton2 != null) {
                    radioButton2.setChecked(true);
                }
            } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_2D)) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding18 = this$0.get_binding();
                RadioButton radioButton3 = fragmentQuizQuestionsBinding18 != null ? fragmentQuizQuestionsBinding18.option3 : null;
                if (radioButton3 != null) {
                    radioButton3.setChecked(true);
                }
            } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_3D)) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding19 = this$0.get_binding();
                RadioButton radioButton4 = fragmentQuizQuestionsBinding19 != null ? fragmentQuizQuestionsBinding19.option4 : null;
                if (radioButton4 != null) {
                    radioButton4.setChecked(true);
                }
            } else if (Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "4")) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding20 = this$0.get_binding();
                RadioButton radioButton5 = fragmentQuizQuestionsBinding20 != null ? fragmentQuizQuestionsBinding20.option5 : null;
                if (radioButton5 != null) {
                    radioButton5.setChecked(true);
                }
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding21 = this$0.get_binding();
            TextView textView12 = fragmentQuizQuestionsBinding21 != null ? fragmentQuizQuestionsBinding21.quizQuestionNo : null;
            if (textView12 != null) {
                textView12.setText("Question " + (this$0.i + 1) + " (Multiple Choice)");
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding22 = this$0.get_binding();
            LinearLayout linearLayout = fragmentQuizQuestionsBinding22 != null ? fragmentQuizQuestionsBinding22.descriptiveAnswerLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding23 = this$0.get_binding();
            LinearLayout linearLayout2 = fragmentQuizQuestionsBinding23 != null ? fragmentQuizQuestionsBinding23.multipleAnswerLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding24 = this$0.get_binding();
            LinearLayout linearLayout3 = fragmentQuizQuestionsBinding24 != null ? fragmentQuizQuestionsBinding24.completionCard : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            ArrayList<QuestionsNew> arrayList8 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList8);
            if (arrayList8.get(this$0.i).getOptions().size() == 2) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding25 = this$0.get_binding();
                RadioButton radioButton6 = fragmentQuizQuestionsBinding25 != null ? fragmentQuizQuestionsBinding25.option1 : null;
                if (radioButton6 != null) {
                    radioButton6.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding26 = this$0.get_binding();
                RadioButton radioButton7 = fragmentQuizQuestionsBinding26 != null ? fragmentQuizQuestionsBinding26.option2 : null;
                if (radioButton7 != null) {
                    radioButton7.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding27 = this$0.get_binding();
                RadioButton radioButton8 = fragmentQuizQuestionsBinding27 != null ? fragmentQuizQuestionsBinding27.option3 : null;
                if (radioButton8 != null) {
                    radioButton8.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding28 = this$0.get_binding();
                RadioButton radioButton9 = fragmentQuizQuestionsBinding28 != null ? fragmentQuizQuestionsBinding28.option4 : null;
                if (radioButton9 != null) {
                    radioButton9.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding29 = this$0.get_binding();
                RadioButton radioButton10 = fragmentQuizQuestionsBinding29 != null ? fragmentQuizQuestionsBinding29.option5 : null;
                if (radioButton10 != null) {
                    radioButton10.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding30 = this$0.get_binding();
                RadioButton radioButton11 = fragmentQuizQuestionsBinding30 != null ? fragmentQuizQuestionsBinding30.option1 : null;
                if (radioButton11 != null) {
                    ArrayList<QuestionsNew> arrayList9 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList9);
                    radioButton11.setText(this$0.convertHtmlToString(arrayList9.get(this$0.i).getOptions().get(0).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding31 = this$0.get_binding();
                RadioButton radioButton12 = fragmentQuizQuestionsBinding31 != null ? fragmentQuizQuestionsBinding31.option2 : null;
                if (radioButton12 == null) {
                    return;
                }
                ArrayList<QuestionsNew> arrayList10 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList10);
                radioButton12.setText(this$0.convertHtmlToString(arrayList10.get(this$0.i).getOptions().get(1).getOption()));
                return;
            }
            ArrayList<QuestionsNew> arrayList11 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList11);
            if (arrayList11.get(this$0.i).getOptions().size() == 3) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding32 = this$0.get_binding();
                RadioButton radioButton13 = fragmentQuizQuestionsBinding32 != null ? fragmentQuizQuestionsBinding32.option1 : null;
                if (radioButton13 != null) {
                    radioButton13.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding33 = this$0.get_binding();
                RadioButton radioButton14 = fragmentQuizQuestionsBinding33 != null ? fragmentQuizQuestionsBinding33.option2 : null;
                if (radioButton14 != null) {
                    radioButton14.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding34 = this$0.get_binding();
                RadioButton radioButton15 = fragmentQuizQuestionsBinding34 != null ? fragmentQuizQuestionsBinding34.option3 : null;
                if (radioButton15 != null) {
                    radioButton15.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding35 = this$0.get_binding();
                RadioButton radioButton16 = fragmentQuizQuestionsBinding35 != null ? fragmentQuizQuestionsBinding35.option4 : null;
                if (radioButton16 != null) {
                    radioButton16.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding36 = this$0.get_binding();
                RadioButton radioButton17 = fragmentQuizQuestionsBinding36 != null ? fragmentQuizQuestionsBinding36.option5 : null;
                if (radioButton17 != null) {
                    radioButton17.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding37 = this$0.get_binding();
                RadioButton radioButton18 = fragmentQuizQuestionsBinding37 != null ? fragmentQuizQuestionsBinding37.option1 : null;
                if (radioButton18 != null) {
                    ArrayList<QuestionsNew> arrayList12 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList12);
                    radioButton18.setText(this$0.convertHtmlToString(arrayList12.get(this$0.i).getOptions().get(0).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding38 = this$0.get_binding();
                RadioButton radioButton19 = fragmentQuizQuestionsBinding38 != null ? fragmentQuizQuestionsBinding38.option2 : null;
                if (radioButton19 != null) {
                    ArrayList<QuestionsNew> arrayList13 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList13);
                    radioButton19.setText(this$0.convertHtmlToString(arrayList13.get(this$0.i).getOptions().get(1).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding39 = this$0.get_binding();
                RadioButton radioButton20 = fragmentQuizQuestionsBinding39 != null ? fragmentQuizQuestionsBinding39.option3 : null;
                if (radioButton20 == null) {
                    return;
                }
                ArrayList<QuestionsNew> arrayList14 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList14);
                radioButton20.setText(this$0.convertHtmlToString(arrayList14.get(this$0.i).getOptions().get(2).getOption()));
                return;
            }
            ArrayList<QuestionsNew> arrayList15 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList15);
            if (arrayList15.get(this$0.i).getOptions().size() == 4) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding40 = this$0.get_binding();
                RadioButton radioButton21 = fragmentQuizQuestionsBinding40 != null ? fragmentQuizQuestionsBinding40.option1 : null;
                if (radioButton21 != null) {
                    radioButton21.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding41 = this$0.get_binding();
                RadioButton radioButton22 = fragmentQuizQuestionsBinding41 != null ? fragmentQuizQuestionsBinding41.option2 : null;
                if (radioButton22 != null) {
                    radioButton22.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding42 = this$0.get_binding();
                RadioButton radioButton23 = fragmentQuizQuestionsBinding42 != null ? fragmentQuizQuestionsBinding42.option3 : null;
                if (radioButton23 != null) {
                    radioButton23.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding43 = this$0.get_binding();
                RadioButton radioButton24 = fragmentQuizQuestionsBinding43 != null ? fragmentQuizQuestionsBinding43.option4 : null;
                if (radioButton24 != null) {
                    radioButton24.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding44 = this$0.get_binding();
                RadioButton radioButton25 = fragmentQuizQuestionsBinding44 != null ? fragmentQuizQuestionsBinding44.option5 : null;
                if (radioButton25 != null) {
                    radioButton25.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding45 = this$0.get_binding();
                RadioButton radioButton26 = fragmentQuizQuestionsBinding45 != null ? fragmentQuizQuestionsBinding45.option1 : null;
                if (radioButton26 != null) {
                    ArrayList<QuestionsNew> arrayList16 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList16);
                    radioButton26.setText(this$0.convertHtmlToString(arrayList16.get(this$0.i).getOptions().get(0).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding46 = this$0.get_binding();
                RadioButton radioButton27 = fragmentQuizQuestionsBinding46 != null ? fragmentQuizQuestionsBinding46.option2 : null;
                if (radioButton27 != null) {
                    ArrayList<QuestionsNew> arrayList17 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList17);
                    radioButton27.setText(this$0.convertHtmlToString(arrayList17.get(this$0.i).getOptions().get(1).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding47 = this$0.get_binding();
                RadioButton radioButton28 = fragmentQuizQuestionsBinding47 != null ? fragmentQuizQuestionsBinding47.option3 : null;
                if (radioButton28 != null) {
                    ArrayList<QuestionsNew> arrayList18 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList18);
                    radioButton28.setText(this$0.convertHtmlToString(arrayList18.get(this$0.i).getOptions().get(2).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding48 = this$0.get_binding();
                RadioButton radioButton29 = fragmentQuizQuestionsBinding48 != null ? fragmentQuizQuestionsBinding48.option4 : null;
                if (radioButton29 == null) {
                    return;
                }
                ArrayList<QuestionsNew> arrayList19 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList19);
                radioButton29.setText(this$0.convertHtmlToString(arrayList19.get(this$0.i).getOptions().get(3).getOption()));
                return;
            }
            ArrayList<QuestionsNew> arrayList20 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList20);
            if (arrayList20.get(this$0.i).getOptions().size() == 5) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding49 = this$0.get_binding();
                RadioButton radioButton30 = fragmentQuizQuestionsBinding49 != null ? fragmentQuizQuestionsBinding49.option1 : null;
                if (radioButton30 != null) {
                    radioButton30.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding50 = this$0.get_binding();
                RadioButton radioButton31 = fragmentQuizQuestionsBinding50 != null ? fragmentQuizQuestionsBinding50.option2 : null;
                if (radioButton31 != null) {
                    radioButton31.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding51 = this$0.get_binding();
                RadioButton radioButton32 = fragmentQuizQuestionsBinding51 != null ? fragmentQuizQuestionsBinding51.option3 : null;
                if (radioButton32 != null) {
                    radioButton32.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding52 = this$0.get_binding();
                RadioButton radioButton33 = fragmentQuizQuestionsBinding52 != null ? fragmentQuizQuestionsBinding52.option4 : null;
                if (radioButton33 != null) {
                    radioButton33.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding53 = this$0.get_binding();
                RadioButton radioButton34 = fragmentQuizQuestionsBinding53 != null ? fragmentQuizQuestionsBinding53.option5 : null;
                if (radioButton34 != null) {
                    radioButton34.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding54 = this$0.get_binding();
                RadioButton radioButton35 = fragmentQuizQuestionsBinding54 != null ? fragmentQuizQuestionsBinding54.option1 : null;
                if (radioButton35 != null) {
                    ArrayList<QuestionsNew> arrayList21 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList21);
                    radioButton35.setText(this$0.convertHtmlToString(arrayList21.get(this$0.i).getOptions().get(0).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding55 = this$0.get_binding();
                RadioButton radioButton36 = fragmentQuizQuestionsBinding55 != null ? fragmentQuizQuestionsBinding55.option2 : null;
                if (radioButton36 != null) {
                    ArrayList<QuestionsNew> arrayList22 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList22);
                    radioButton36.setText(this$0.convertHtmlToString(arrayList22.get(this$0.i).getOptions().get(1).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding56 = this$0.get_binding();
                RadioButton radioButton37 = fragmentQuizQuestionsBinding56 != null ? fragmentQuizQuestionsBinding56.option3 : null;
                if (radioButton37 != null) {
                    ArrayList<QuestionsNew> arrayList23 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList23);
                    radioButton37.setText(this$0.convertHtmlToString(arrayList23.get(this$0.i).getOptions().get(2).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding57 = this$0.get_binding();
                RadioButton radioButton38 = fragmentQuizQuestionsBinding57 != null ? fragmentQuizQuestionsBinding57.option4 : null;
                if (radioButton38 != null) {
                    ArrayList<QuestionsNew> arrayList24 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList24);
                    radioButton38.setText(this$0.convertHtmlToString(arrayList24.get(this$0.i).getOptions().get(3).getOption()));
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding58 = this$0.get_binding();
                RadioButton radioButton39 = fragmentQuizQuestionsBinding58 != null ? fragmentQuizQuestionsBinding58.option5 : null;
                if (radioButton39 == null) {
                    return;
                }
                ArrayList<QuestionsNew> arrayList25 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList25);
                radioButton39.setText(this$0.convertHtmlToString(arrayList25.get(this$0.i).getOptions().get(4).getOption()));
                return;
            }
            return;
        }
        ArrayList<QuestionsNew> arrayList26 = this$0.quizResponse;
        Intrinsics.checkNotNull(arrayList26);
        if (Intrinsics.areEqual(arrayList26.get(this$0.i).getQuestionType(), ExifInterface.GPS_MEASUREMENT_2D)) {
            if (!Intrinsics.areEqual(this$0.quizAnswers.get(this$0.i), "")) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding59 = this$0.get_binding();
                if (fragmentQuizQuestionsBinding59 != null && (textInputEditText2 = fragmentQuizQuestionsBinding59.etDescriptive) != null) {
                    textInputEditText2.setText(this$0.quizAnswers.get(this$0.i));
                }
            } else {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding60 = this$0.get_binding();
                if (fragmentQuizQuestionsBinding60 != null && (textInputEditText = fragmentQuizQuestionsBinding60.etDescriptive) != null) {
                    textInputEditText.setText("");
                }
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding61 = this$0.get_binding();
            TextView textView13 = fragmentQuizQuestionsBinding61 != null ? fragmentQuizQuestionsBinding61.quizQuestionNo : null;
            if (textView13 != null) {
                textView13.setText("Question " + (this$0.i + 1) + " (Descriptive)");
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding62 = this$0.get_binding();
            LinearLayout linearLayout4 = fragmentQuizQuestionsBinding62 != null ? fragmentQuizQuestionsBinding62.descriptiveAnswerLyt : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding63 = this$0.get_binding();
            LinearLayout linearLayout5 = fragmentQuizQuestionsBinding63 != null ? fragmentQuizQuestionsBinding63.multipleAnswerLyt : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding64 = this$0.get_binding();
            LinearLayout linearLayout6 = fragmentQuizQuestionsBinding64 != null ? fragmentQuizQuestionsBinding64.completionCard : null;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(8);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding65 = this$0.get_binding();
            TextView textView14 = fragmentQuizQuestionsBinding65 != null ? fragmentQuizQuestionsBinding65.quizQuestion : null;
            if (textView14 == null) {
                return;
            }
            ArrayList<QuestionsNew> arrayList27 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList27);
            textView14.setText("Q ) " + this$0.convertHtmlToString(arrayList27.get(this$0.i).getQuestion()));
            return;
        }
        ArrayList<QuestionsNew> arrayList28 = this$0.quizResponse;
        Intrinsics.checkNotNull(arrayList28);
        if (Intrinsics.areEqual(arrayList28.get(this$0.i).getQuestionType(), ExifInterface.GPS_MEASUREMENT_3D)) {
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding66 = this$0.get_binding();
            TextView textView15 = fragmentQuizQuestionsBinding66 != null ? fragmentQuizQuestionsBinding66.quizQuestionNo : null;
            if (textView15 != null) {
                textView15.setText("Question " + (this$0.i + 1) + " (Upload)");
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding67 = this$0.get_binding();
            LinearLayout linearLayout7 = fragmentQuizQuestionsBinding67 != null ? fragmentQuizQuestionsBinding67.descriptiveAnswerLyt : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding68 = this$0.get_binding();
            LinearLayout linearLayout8 = fragmentQuizQuestionsBinding68 != null ? fragmentQuizQuestionsBinding68.multipleAnswerLyt : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(8);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding69 = this$0.get_binding();
            LinearLayout linearLayout9 = fragmentQuizQuestionsBinding69 != null ? fragmentQuizQuestionsBinding69.completionCard : null;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(0);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding70 = this$0.get_binding();
            TextView textView16 = fragmentQuizQuestionsBinding70 != null ? fragmentQuizQuestionsBinding70.completionFileName : null;
            if (textView16 == null) {
                return;
            }
            textView16.setText(this$0.quizAnswers.get(this$0.i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(QuizQuestionsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.submitAnswer(this$0.i);
        System.out.println(this$0.i);
        System.out.println((Object) "i");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(QuizQuestionsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    private final void submitAnswer(int i) {
        this.submitAnswer.clear();
        System.out.println(i);
        HashMap<String, String> hashMap = this.submitAnswer;
        ArrayList<QuestionsNew> arrayList = this.quizResponse;
        Intrinsics.checkNotNull(arrayList);
        String qno = arrayList.get(i).getQno();
        Intrinsics.checkNotNull(qno);
        hashMap.put("qno", qno);
        HashMap<String, String> hashMap2 = this.submitAnswer;
        String str = this.id;
        Intrinsics.checkNotNull(str);
        hashMap2.put("id", str);
        ArrayList<QuestionsNew> arrayList2 = this.quizResponse;
        Intrinsics.checkNotNull(arrayList2);
        if (Intrinsics.areEqual(arrayList2.get(i).getQuestionType(), "1")) {
            ArrayList<QuestionsNew> arrayList3 = this.quizResponse;
            Intrinsics.checkNotNull(arrayList3);
            if (i == arrayList3.size() - 1) {
                this.submitAnswer.put("final_submit", "1");
            }
            if (Intrinsics.areEqual(this.optionAnswer, "")) {
                return;
            }
            HashMap<String, String> hashMap3 = this.submitAnswer;
            ArrayList<QuestionsNew> arrayList4 = this.quizResponse;
            Intrinsics.checkNotNull(arrayList4);
            hashMap3.put("option", arrayList4.get(i).getOptions().get(Integer.parseInt(this.optionAnswer)).getId());
            this.optionAnswer = "";
            getQuizQuestionsViewModel().getQuizAnswerSubmit(this.submitAnswer);
            return;
        }
        ArrayList<QuestionsNew> arrayList5 = this.quizResponse;
        Intrinsics.checkNotNull(arrayList5);
        if (Intrinsics.areEqual(arrayList5.get(i).getQuestionType(), ExifInterface.GPS_MEASUREMENT_2D)) {
            ArrayList<QuestionsNew> arrayList6 = this.quizResponse;
            Intrinsics.checkNotNull(arrayList6);
            if (i == arrayList6.size() - 1) {
                this.submitAnswer.put("final_submit", "1");
            }
            this.submitAnswer.put("option", this.descriptiveAnswer);
            this.descriptiveAnswer = "";
            getQuizQuestionsViewModel().getQuizAnswerSubmit(this.submitAnswer);
            return;
        }
        if (this.flagFile) {
            ArrayList<QuestionsNew> arrayList7 = this.quizResponse;
            Intrinsics.checkNotNull(arrayList7);
            File file = null;
            if (i == arrayList7.size() - 1) {
                this.finalUpload = true;
                QuizQuestionsViewModel quizQuestionsViewModel = getQuizQuestionsViewModel();
                ArrayList<QuestionsNew> arrayList8 = this.quizResponse;
                Intrinsics.checkNotNull(arrayList8);
                String qno2 = arrayList8.get(i).getQno();
                Intrinsics.checkNotNull(qno2);
                String str2 = this.id;
                Intrinsics.checkNotNull(str2);
                File file2 = this.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                } else {
                    file = file2;
                }
                quizQuestionsViewModel.newQuizAnswerUploadFinalSubmit(qno2, str2, file);
                this.flagFile = false;
                return;
            }
            QuizQuestionsViewModel quizQuestionsViewModel2 = getQuizQuestionsViewModel();
            ArrayList<QuestionsNew> arrayList9 = this.quizResponse;
            Intrinsics.checkNotNull(arrayList9);
            String qno3 = arrayList9.get(i).getQno();
            Intrinsics.checkNotNull(qno3);
            String str3 = this.id;
            Intrinsics.checkNotNull(str3);
            File file3 = this.pickFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
            } else {
                file = file3;
            }
            quizQuestionsViewModel2.newQuizAnswerUploadSubmit(qno3, str3, file);
            this.flagFile = false;
        }
    }

    private final void listenResponse() {
        getQuizQuestionsViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuizQuestionsFragment.listenResponse$lambda$8(QuizQuestionsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$8(QuizQuestionsFragment this$0, Resource resource) {
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
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = this$0.get_binding();
            if (fragmentQuizQuestionsBinding == null || (textView = fragmentQuizQuestionsBinding.quizQuestion) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        QuestionsNewResponse questionsNewResponse = (QuestionsNewResponse) resource.getData();
        if (questionsNewResponse != null) {
            this$0.showBaseView();
            ArrayList<QuestionsNew> questions = questionsNewResponse.getQuestions();
            this$0.quizResponse = questions;
            Intrinsics.checkNotNull(questions);
            System.out.println(questions.size());
            ArrayList<QuestionsNew> arrayList = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList);
            System.out.println(arrayList.size());
            System.out.println(questionsNewResponse);
            int size = questionsNewResponse.getQuestions().size();
            for (int i2 = 0; i2 < size; i2++) {
                this$0.quizAnswers.add(i2, "");
            }
            ArrayList<QuestionsNew> arrayList2 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList2);
            if (this$0.containsImageUrl(arrayList2.get(this$0.i).getQuestion())) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = this$0.get_binding();
                TextView textView2 = fragmentQuizQuestionsBinding2 != null ? fragmentQuizQuestionsBinding2.quizQuestion : null;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding3 = this$0.get_binding();
                ImageView imageView = fragmentQuizQuestionsBinding3 != null ? fragmentQuizQuestionsBinding3.questionImage : null;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ArrayList<QuestionsNew> arrayList3 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList3);
                String extractImageUrl = this$0.extractImageUrl(arrayList3.get(this$0.i).getQuestion());
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding4 = this$0.get_binding();
                TextView textView3 = fragmentQuizQuestionsBinding4 != null ? fragmentQuizQuestionsBinding4.quizQuestion : null;
                if (textView3 != null) {
                    ArrayList<QuestionsNew> arrayList4 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList4);
                    textView3.setText("Q ) " + this$0.extractStringFromHtml(arrayList4.get(this$0.i).getQuestion()));
                }
                if (extractImageUrl != null) {
                    RequestBuilder<Drawable> load = Glide.with(this$0).load(extractImageUrl);
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding5 = this$0.get_binding();
                    ImageView imageView2 = fragmentQuizQuestionsBinding5 != null ? fragmentQuizQuestionsBinding5.questionImage : null;
                    Intrinsics.checkNotNull(imageView2);
                    load.into(imageView2);
                }
            } else {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding6 = this$0.get_binding();
                TextView textView4 = fragmentQuizQuestionsBinding6 != null ? fragmentQuizQuestionsBinding6.quizQuestion : null;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding7 = this$0.get_binding();
                ImageView imageView3 = fragmentQuizQuestionsBinding7 != null ? fragmentQuizQuestionsBinding7.questionImage : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding8 = this$0.get_binding();
                TextView textView5 = fragmentQuizQuestionsBinding8 != null ? fragmentQuizQuestionsBinding8.quizQuestion : null;
                if (textView5 != null) {
                    ArrayList<QuestionsNew> arrayList5 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList5);
                    textView5.setText("Q ) " + this$0.convertHtmlToString(arrayList5.get(this$0.i).getQuestion()));
                }
            }
            ArrayList<QuestionsNew> arrayList6 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList6);
            if (Intrinsics.areEqual(arrayList6.get(this$0.i).getQuestionType(), "1")) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding9 = this$0.get_binding();
                TextView textView6 = fragmentQuizQuestionsBinding9 != null ? fragmentQuizQuestionsBinding9.quizQuestionNo : null;
                if (textView6 != null) {
                    textView6.setText("Question " + (this$0.i + 1) + " (Multiple Choice)");
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding10 = this$0.get_binding();
                LinearLayout linearLayout = fragmentQuizQuestionsBinding10 != null ? fragmentQuizQuestionsBinding10.descriptiveAnswerLyt : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding11 = this$0.get_binding();
                LinearLayout linearLayout2 = fragmentQuizQuestionsBinding11 != null ? fragmentQuizQuestionsBinding11.multipleAnswerLyt : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding12 = this$0.get_binding();
                LinearLayout linearLayout3 = fragmentQuizQuestionsBinding12 != null ? fragmentQuizQuestionsBinding12.completionCard : null;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                ArrayList<QuestionsNew> arrayList7 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList7);
                if (arrayList7.get(this$0.i).getOptions().size() == 2) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding13 = this$0.get_binding();
                    RadioButton radioButton = fragmentQuizQuestionsBinding13 != null ? fragmentQuizQuestionsBinding13.option1 : null;
                    if (radioButton != null) {
                        radioButton.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding14 = this$0.get_binding();
                    RadioButton radioButton2 = fragmentQuizQuestionsBinding14 != null ? fragmentQuizQuestionsBinding14.option2 : null;
                    if (radioButton2 != null) {
                        radioButton2.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding15 = this$0.get_binding();
                    RadioButton radioButton3 = fragmentQuizQuestionsBinding15 != null ? fragmentQuizQuestionsBinding15.option3 : null;
                    if (radioButton3 != null) {
                        radioButton3.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding16 = this$0.get_binding();
                    RadioButton radioButton4 = fragmentQuizQuestionsBinding16 != null ? fragmentQuizQuestionsBinding16.option4 : null;
                    if (radioButton4 != null) {
                        radioButton4.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding17 = this$0.get_binding();
                    RadioButton radioButton5 = fragmentQuizQuestionsBinding17 != null ? fragmentQuizQuestionsBinding17.option5 : null;
                    if (radioButton5 != null) {
                        radioButton5.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding18 = this$0.get_binding();
                    RadioButton radioButton6 = fragmentQuizQuestionsBinding18 != null ? fragmentQuizQuestionsBinding18.option1 : null;
                    if (radioButton6 != null) {
                        ArrayList<QuestionsNew> arrayList8 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList8);
                        radioButton6.setText(this$0.convertHtmlToString(arrayList8.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding19 = this$0.get_binding();
                    RadioButton radioButton7 = fragmentQuizQuestionsBinding19 != null ? fragmentQuizQuestionsBinding19.option2 : null;
                    if (radioButton7 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList9 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList9);
                    radioButton7.setText(this$0.convertHtmlToString(arrayList9.get(this$0.i).getOptions().get(1).getOption()));
                    return;
                }
                ArrayList<QuestionsNew> arrayList10 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList10);
                if (arrayList10.get(this$0.i).getOptions().size() == 3) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding20 = this$0.get_binding();
                    RadioButton radioButton8 = fragmentQuizQuestionsBinding20 != null ? fragmentQuizQuestionsBinding20.option1 : null;
                    if (radioButton8 != null) {
                        radioButton8.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding21 = this$0.get_binding();
                    RadioButton radioButton9 = fragmentQuizQuestionsBinding21 != null ? fragmentQuizQuestionsBinding21.option2 : null;
                    if (radioButton9 != null) {
                        radioButton9.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding22 = this$0.get_binding();
                    RadioButton radioButton10 = fragmentQuizQuestionsBinding22 != null ? fragmentQuizQuestionsBinding22.option3 : null;
                    if (radioButton10 != null) {
                        radioButton10.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding23 = this$0.get_binding();
                    RadioButton radioButton11 = fragmentQuizQuestionsBinding23 != null ? fragmentQuizQuestionsBinding23.option4 : null;
                    if (radioButton11 != null) {
                        radioButton11.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding24 = this$0.get_binding();
                    RadioButton radioButton12 = fragmentQuizQuestionsBinding24 != null ? fragmentQuizQuestionsBinding24.option5 : null;
                    if (radioButton12 != null) {
                        radioButton12.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding25 = this$0.get_binding();
                    RadioButton radioButton13 = fragmentQuizQuestionsBinding25 != null ? fragmentQuizQuestionsBinding25.option1 : null;
                    if (radioButton13 != null) {
                        ArrayList<QuestionsNew> arrayList11 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList11);
                        radioButton13.setText(this$0.convertHtmlToString(arrayList11.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding26 = this$0.get_binding();
                    RadioButton radioButton14 = fragmentQuizQuestionsBinding26 != null ? fragmentQuizQuestionsBinding26.option2 : null;
                    if (radioButton14 != null) {
                        ArrayList<QuestionsNew> arrayList12 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList12);
                        radioButton14.setText(this$0.convertHtmlToString(arrayList12.get(this$0.i).getOptions().get(1).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding27 = this$0.get_binding();
                    RadioButton radioButton15 = fragmentQuizQuestionsBinding27 != null ? fragmentQuizQuestionsBinding27.option3 : null;
                    if (radioButton15 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList13 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList13);
                    radioButton15.setText(this$0.convertHtmlToString(arrayList13.get(this$0.i).getOptions().get(2).getOption()));
                    return;
                }
                ArrayList<QuestionsNew> arrayList14 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList14);
                if (arrayList14.get(this$0.i).getOptions().size() == 4) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding28 = this$0.get_binding();
                    RadioButton radioButton16 = fragmentQuizQuestionsBinding28 != null ? fragmentQuizQuestionsBinding28.option1 : null;
                    if (radioButton16 != null) {
                        radioButton16.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding29 = this$0.get_binding();
                    RadioButton radioButton17 = fragmentQuizQuestionsBinding29 != null ? fragmentQuizQuestionsBinding29.option2 : null;
                    if (radioButton17 != null) {
                        radioButton17.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding30 = this$0.get_binding();
                    RadioButton radioButton18 = fragmentQuizQuestionsBinding30 != null ? fragmentQuizQuestionsBinding30.option3 : null;
                    if (radioButton18 != null) {
                        radioButton18.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding31 = this$0.get_binding();
                    RadioButton radioButton19 = fragmentQuizQuestionsBinding31 != null ? fragmentQuizQuestionsBinding31.option4 : null;
                    if (radioButton19 != null) {
                        radioButton19.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding32 = this$0.get_binding();
                    RadioButton radioButton20 = fragmentQuizQuestionsBinding32 != null ? fragmentQuizQuestionsBinding32.option5 : null;
                    if (radioButton20 != null) {
                        radioButton20.setVisibility(8);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding33 = this$0.get_binding();
                    RadioButton radioButton21 = fragmentQuizQuestionsBinding33 != null ? fragmentQuizQuestionsBinding33.option1 : null;
                    if (radioButton21 != null) {
                        ArrayList<QuestionsNew> arrayList15 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList15);
                        radioButton21.setText(this$0.convertHtmlToString(arrayList15.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding34 = this$0.get_binding();
                    RadioButton radioButton22 = fragmentQuizQuestionsBinding34 != null ? fragmentQuizQuestionsBinding34.option2 : null;
                    if (radioButton22 != null) {
                        ArrayList<QuestionsNew> arrayList16 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList16);
                        radioButton22.setText(this$0.convertHtmlToString(arrayList16.get(this$0.i).getOptions().get(1).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding35 = this$0.get_binding();
                    RadioButton radioButton23 = fragmentQuizQuestionsBinding35 != null ? fragmentQuizQuestionsBinding35.option3 : null;
                    if (radioButton23 != null) {
                        ArrayList<QuestionsNew> arrayList17 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList17);
                        radioButton23.setText(this$0.convertHtmlToString(arrayList17.get(this$0.i).getOptions().get(2).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding36 = this$0.get_binding();
                    RadioButton radioButton24 = fragmentQuizQuestionsBinding36 != null ? fragmentQuizQuestionsBinding36.option4 : null;
                    if (radioButton24 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList18 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList18);
                    radioButton24.setText(this$0.convertHtmlToString(arrayList18.get(this$0.i).getOptions().get(3).getOption()));
                    return;
                }
                ArrayList<QuestionsNew> arrayList19 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList19);
                if (arrayList19.get(this$0.i).getOptions().size() == 5) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding37 = this$0.get_binding();
                    RadioButton radioButton25 = fragmentQuizQuestionsBinding37 != null ? fragmentQuizQuestionsBinding37.option1 : null;
                    if (radioButton25 != null) {
                        radioButton25.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding38 = this$0.get_binding();
                    RadioButton radioButton26 = fragmentQuizQuestionsBinding38 != null ? fragmentQuizQuestionsBinding38.option2 : null;
                    if (radioButton26 != null) {
                        radioButton26.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding39 = this$0.get_binding();
                    RadioButton radioButton27 = fragmentQuizQuestionsBinding39 != null ? fragmentQuizQuestionsBinding39.option3 : null;
                    if (radioButton27 != null) {
                        radioButton27.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding40 = this$0.get_binding();
                    RadioButton radioButton28 = fragmentQuizQuestionsBinding40 != null ? fragmentQuizQuestionsBinding40.option4 : null;
                    if (radioButton28 != null) {
                        radioButton28.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding41 = this$0.get_binding();
                    RadioButton radioButton29 = fragmentQuizQuestionsBinding41 != null ? fragmentQuizQuestionsBinding41.option5 : null;
                    if (radioButton29 != null) {
                        radioButton29.setVisibility(0);
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding42 = this$0.get_binding();
                    RadioButton radioButton30 = fragmentQuizQuestionsBinding42 != null ? fragmentQuizQuestionsBinding42.option1 : null;
                    if (radioButton30 != null) {
                        ArrayList<QuestionsNew> arrayList20 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList20);
                        radioButton30.setText(this$0.convertHtmlToString(arrayList20.get(this$0.i).getOptions().get(0).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding43 = this$0.get_binding();
                    RadioButton radioButton31 = fragmentQuizQuestionsBinding43 != null ? fragmentQuizQuestionsBinding43.option2 : null;
                    if (radioButton31 != null) {
                        ArrayList<QuestionsNew> arrayList21 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList21);
                        radioButton31.setText(this$0.convertHtmlToString(arrayList21.get(this$0.i).getOptions().get(1).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding44 = this$0.get_binding();
                    RadioButton radioButton32 = fragmentQuizQuestionsBinding44 != null ? fragmentQuizQuestionsBinding44.option3 : null;
                    if (radioButton32 != null) {
                        ArrayList<QuestionsNew> arrayList22 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList22);
                        radioButton32.setText(this$0.convertHtmlToString(arrayList22.get(this$0.i).getOptions().get(2).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding45 = this$0.get_binding();
                    RadioButton radioButton33 = fragmentQuizQuestionsBinding45 != null ? fragmentQuizQuestionsBinding45.option4 : null;
                    if (radioButton33 != null) {
                        ArrayList<QuestionsNew> arrayList23 = this$0.quizResponse;
                        Intrinsics.checkNotNull(arrayList23);
                        radioButton33.setText(this$0.convertHtmlToString(arrayList23.get(this$0.i).getOptions().get(3).getOption()));
                    }
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding46 = this$0.get_binding();
                    RadioButton radioButton34 = fragmentQuizQuestionsBinding46 != null ? fragmentQuizQuestionsBinding46.option5 : null;
                    if (radioButton34 == null) {
                        return;
                    }
                    ArrayList<QuestionsNew> arrayList24 = this$0.quizResponse;
                    Intrinsics.checkNotNull(arrayList24);
                    radioButton34.setText(this$0.convertHtmlToString(arrayList24.get(this$0.i).getOptions().get(4).getOption()));
                    return;
                }
                return;
            }
            ArrayList<QuestionsNew> arrayList25 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList25);
            if (Intrinsics.areEqual(arrayList25.get(this$0.i).getQuestionType(), ExifInterface.GPS_MEASUREMENT_2D)) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding47 = this$0.get_binding();
                TextView textView7 = fragmentQuizQuestionsBinding47 != null ? fragmentQuizQuestionsBinding47.quizQuestionNo : null;
                if (textView7 != null) {
                    textView7.setText("Question " + (this$0.i + 1) + " (Descriptive)");
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding48 = this$0.get_binding();
                LinearLayout linearLayout4 = fragmentQuizQuestionsBinding48 != null ? fragmentQuizQuestionsBinding48.descriptiveAnswerLyt : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding49 = this$0.get_binding();
                LinearLayout linearLayout5 = fragmentQuizQuestionsBinding49 != null ? fragmentQuizQuestionsBinding49.multipleAnswerLyt : null;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding50 = this$0.get_binding();
                LinearLayout linearLayout6 = fragmentQuizQuestionsBinding50 != null ? fragmentQuizQuestionsBinding50.completionCard : null;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding51 = this$0.get_binding();
                TextView textView8 = fragmentQuizQuestionsBinding51 != null ? fragmentQuizQuestionsBinding51.quizQuestion : null;
                if (textView8 == null) {
                    return;
                }
                ArrayList<QuestionsNew> arrayList26 = this$0.quizResponse;
                Intrinsics.checkNotNull(arrayList26);
                textView8.setText("Q ) " + this$0.convertHtmlToString(arrayList26.get(this$0.i).getQuestion()));
                return;
            }
            ArrayList<QuestionsNew> arrayList27 = this$0.quizResponse;
            Intrinsics.checkNotNull(arrayList27);
            if (Intrinsics.areEqual(arrayList27.get(this$0.i).getQuestionType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding52 = this$0.get_binding();
                TextView textView9 = fragmentQuizQuestionsBinding52 != null ? fragmentQuizQuestionsBinding52.quizQuestionNo : null;
                if (textView9 != null) {
                    textView9.setText("Question " + (this$0.i + 1) + " (Upload))");
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding53 = this$0.get_binding();
                LinearLayout linearLayout7 = fragmentQuizQuestionsBinding53 != null ? fragmentQuizQuestionsBinding53.descriptiveAnswerLyt : null;
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding54 = this$0.get_binding();
                LinearLayout linearLayout8 = fragmentQuizQuestionsBinding54 != null ? fragmentQuizQuestionsBinding54.multipleAnswerLyt : null;
                if (linearLayout8 != null) {
                    linearLayout8.setVisibility(8);
                }
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding55 = this$0.get_binding();
                LinearLayout linearLayout9 = fragmentQuizQuestionsBinding55 != null ? fragmentQuizQuestionsBinding55.completionCard : null;
                if (linearLayout9 == null) {
                    return;
                }
                linearLayout9.setVisibility(0);
            }
        }
    }

    private final void listenAnswerResponse() {
        getQuizQuestionsViewModel().getSubmitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuizQuestionsFragment.listenAnswerResponse$lambda$10(QuizQuestionsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAnswerResponse$lambda$10(QuizQuestionsFragment this$0, Resource resource) {
        TextView finishBtn;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            QuizSubmitResponse quizSubmitResponse = (QuizSubmitResponse) resource.getData();
            if (quizSubmitResponse != null) {
                this$0.showBaseView();
                if (quizSubmitResponse.getSuccess() && quizSubmitResponse.is_finished()) {
                    FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = this$0.get_binding();
                    if (fragmentQuizQuestionsBinding != null && (finishBtn = fragmentQuizQuestionsBinding.finishBtn) != null) {
                        Intrinsics.checkNotNullExpressionValue(finishBtn, "finishBtn");
                        ToastExtKt.showSuccessToast(finishBtn, "Successfully Completed");
                    }
                    MainCallBackListener mainCallBackListener = this$0.listener;
                    if (mainCallBackListener != null) {
                        mainCallBackListener.onQuizCompleted();
                        return;
                    }
                    return;
                }
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
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = this$0.get_binding();
        if (fragmentQuizQuestionsBinding2 == null || (textView = fragmentQuizQuestionsBinding2.finishBtn) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    private final void listenUploadResponse() {
        getQuizQuestionsViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuizQuestionsFragment.listenUploadResponse$lambda$12(QuizQuestionsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUploadResponse$lambda$12(QuizQuestionsFragment this$0, Resource resource) {
        FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding;
        TextView completionFileName;
        TextView completionFileName2;
        TextView textView;
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
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = this$0.get_binding();
            if (fragmentQuizQuestionsBinding2 == null || (textView = fragmentQuizQuestionsBinding2.completionFileName) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        QuizSubmitResponse quizSubmitResponse = (QuizSubmitResponse) resource.getData();
        if (quizSubmitResponse != null) {
            if (quizSubmitResponse.getSuccess() && quizSubmitResponse.is_finished() && this$0.finalUpload) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding3 = this$0.get_binding();
                if (fragmentQuizQuestionsBinding3 != null && (completionFileName2 = fragmentQuizQuestionsBinding3.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, "Successfully Completed");
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.onQuizCompleted();
                    return;
                }
                return;
            }
            if (!this$0.finalUpload || (fragmentQuizQuestionsBinding = this$0.get_binding()) == null || (completionFileName = fragmentQuizQuestionsBinding.completionFileName) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
            ToastExtKt.showErrorToast(completionFileName, "Something Went Wrong");
        }
    }

    private final void listenProgressResponse() {
        getQuizQuestionsViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuizQuestionsFragment.listenProgressResponse$lambda$14(QuizQuestionsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$14(QuizQuestionsFragment this$0, Resource resource) {
        TextView textView;
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
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = this$0.get_binding();
            if (fragmentQuizQuestionsBinding == null || (textView = fragmentQuizQuestionsBinding.completionFileName) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding2 = this$0.get_binding();
            ProgressBar progressBar = fragmentQuizQuestionsBinding2 != null ? fragmentQuizQuestionsBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding3 = this$0.get_binding();
            TextView textView2 = fragmentQuizQuestionsBinding3 != null ? fragmentQuizQuestionsBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        String str2;
        ContentResolver contentResolver2;
        ContentResolver contentResolver3;
        String str3;
        ContentResolver contentResolver4;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                FragmentQuizQuestionsBinding fragmentQuizQuestionsBinding = get_binding();
                TextView textView = fragmentQuizQuestionsBinding != null ? fragmentQuizQuestionsBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver4 = context.getContentResolver()) == null) {
                        str3 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver4, "contentResolver");
                        str3 = ResolvUtilKt.getFileName(contentResolver4, data2);
                    }
                    textView.setText("File : " + str3);
                }
                System.out.println(this.i);
                List<String> list = this.quizAnswers;
                int i = this.i;
                Context context2 = getContext();
                if (context2 == null || (contentResolver3 = context2.getContentResolver()) == null) {
                    str = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                    str = ResolvUtilKt.getFileName(contentResolver3, data2);
                }
                list.set(i, "File : " + str);
                Context context3 = getContext();
                if (context3 != null && (contentResolver = context3.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context4 = getContext();
                    File cacheDir = context4 != null ? context4.getCacheDir() : null;
                    Context context5 = getContext();
                    if (context5 == null || (contentResolver2 = context5.getContentResolver()) == null) {
                        str2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str2 = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, str2);
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                    this.flagFile = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String convertHtmlToString(String html) {
        Spanned fromHtml;
        Intrinsics.checkNotNullParameter(html, "html");
        fromHtml = Html.fromHtml(html, 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(html, Html.FROM_HTML_MODE_LEGACY)");
        return fromHtml.toString();
    }

    public final boolean containsImageUrl(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        return new Regex("<img[^>]+src=\"([^\"]+)\"").containsMatchIn(html);
    }

    private final String extractImageUrl(String html) {
        Matcher matcher = Pattern.compile("src=\"(.*?)\"").matcher(html);
        if (!matcher.find()) {
            return null;
        }
        String group = matcher.group(1);
        Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
        return StringsKt.replace$default(group, "\\", "", false, 4, (Object) null);
    }

    private final String extractStringFromHtml(String html) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String value;
        MatchResult find$default = Regex.find$default(new Regex("<p>.*?>(.*?)<\\/p>"), html, 0, 2, null);
        if (find$default == null || (groups = find$default.getGroups()) == null || (matchGroup = groups.get(1)) == null || (value = matchGroup.getValue()) == null) {
            return null;
        }
        return StringsKt.trim((CharSequence) value).toString();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
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