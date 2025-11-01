package in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.SubmitResponse;
import in.etuwa.app.data.model.survey.SurveyQuestion;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentTeacherSurveyQuestionsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogKt;
import in.etuwa.app.ui.message.reply.ReplyDialogKt;
import in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter;
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
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: TeacherSurveyQuestionFragment.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001kB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u000eH\u0007J\u0018\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u0017H\u0017J\b\u0010U\u001a\u00020RH\u0014J\b\u0010V\u001a\u00020RH\u0014J\b\u0010W\u001a\u00020RH\u0002J\b\u0010X\u001a\u00020RH\u0003J\u0010\u0010Y\u001a\u00020R2\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u00020R2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J&\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010e\u001a\u00020RH\u0016J\u001a\u0010f\u001a\u00020R2\u0006\u0010g\u001a\u00020`2\b\u0010]\u001a\u0004\u0018\u00010^H\u0017J\b\u0010h\u001a\u00020RH\u0015J\b\u0010i\u001a\u00020RH\u0014J\b\u0010j\u001a\u00020RH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u000e\u0010*\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u001a\u00103\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001a\u00106\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001a\u00109\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u0010\u0010<\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010%\"\u0004\bD\u0010'R\"\u0010E\u001a\u0016\u0012\u0004\u0012\u00020G\u0018\u00010Fj\n\u0012\u0004\u0012\u00020G\u0018\u0001`HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bL\u0010M¨\u0006l"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter$SurveyCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentTeacherSurveyQuestionsBinding;", "adapter", "Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter;", "getAdapter", "()Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "attendedOrNot", "", "", "getAttendedOrNot", "()Ljava/util/List;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentTeacherSurveyQuestionsBinding;", "flag", "", "i", "", "id", SvgConstants.Tags.IMAGE, "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "lastDesc", "getLastDesc", "setLastDesc", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "mandatoryFlag", "getMandatoryFlag", "()Z", "setMandatoryFlag", "(Z)V", "mandatoryQuestions", "getMandatoryQuestions", "option", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "remarks", "getRemarks", "setRemarks", AttendanceDayDialogKt.ARG_SEM, "getSemester", "setSemester", "strength", "getStrength", "setStrength", "subject", "getSubject", "setSubject", "subjectId", "submitAnswer", "Ljava/util/HashMap;", "getSubmitAnswer", "()Ljava/util/HashMap;", "surveyAnswers", "surveyFlag", "getSurveyFlag", "setSurveyFlag", "surveyResponse", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/SurveyQuestion;", "Lkotlin/collections/ArrayList;", "teacherId", "teacherSurveyQuestionViewModel", "Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionViewModel;", "getTeacherSurveyQuestionViewModel", "()Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionViewModel;", "teacherSurveyQuestionViewModel$delegate", "convertHtmlToString", "html", "doTheSurvey", "", "qNo", "j", "hideBaseView", "hideProgress", "listenAnswerResponse", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TeacherSurveyQuestionFragment extends BaseFragment implements TeacherSurveyQuestionAdapter.SurveyCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTeacherSurveyQuestionsBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private final List<String> attendedOrNot;
    private boolean flag;
    private int i;
    private String id;
    private String image;
    private String lastDesc;
    private MainCallBackListener listener;
    private boolean mandatoryFlag;
    private final List<String> mandatoryQuestions;
    private String option;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String remarks;
    private String semester;
    private String strength;
    private String subject;
    private String subjectId;
    private final HashMap<String, String> submitAnswer;
    private List<String> surveyAnswers;
    private boolean surveyFlag;
    private ArrayList<SurveyQuestion> surveyResponse;
    private String teacherId;

    /* renamed from: teacherSurveyQuestionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy teacherSurveyQuestionViewModel;

    /* compiled from: TeacherSurveyQuestionFragment.kt */
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
    public static final TeacherSurveyQuestionFragment newInstance(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5, str6, z);
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

    public TeacherSurveyQuestionFragment() {
        final TeacherSurveyQuestionFragment teacherSurveyQuestionFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(teacherSurveyQuestionFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.teacherSurveyQuestionViewModel = FragmentViewModelLazyKt.createViewModelLazy(teacherSurveyQuestionFragment, Reflection.getOrCreateKotlinClass(TeacherSurveyQuestionViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TeacherSurveyQuestionViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TeacherSurveyQuestionFragment teacherSurveyQuestionFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = teacherSurveyQuestionFragment2;
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
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<TeacherSurveyQuestionAdapter>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TeacherSurveyQuestionAdapter invoke() {
                ComponentCallbacks componentCallbacks = teacherSurveyQuestionFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TeacherSurveyQuestionAdapter.class), b4, b5);
            }
        });
        this.strength = "";
        this.remarks = "";
        this.lastDesc = "";
        this.image = "";
        this.semester = "";
        this.subject = "";
    }

    private final TeacherSurveyQuestionViewModel getTeacherSurveyQuestionViewModel() {
        return (TeacherSurveyQuestionViewModel) this.teacherSurveyQuestionViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentTeacherSurveyQuestionsBinding get_binding() {
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

    private final TeacherSurveyQuestionAdapter getAdapter() {
        return (TeacherSurveyQuestionAdapter) this.adapter.getValue();
    }

    public final String getStrength() {
        return this.strength;
    }

    public final void setStrength(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.strength = str;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final void setRemarks(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remarks = str;
    }

    public final String getLastDesc() {
        return this.lastDesc;
    }

    public final void setLastDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastDesc = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final void setSemester(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semester = str;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final void setSubject(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subject = str;
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

    /* compiled from: TeacherSurveyQuestionFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionFragment;", "id", "", "teacherId", "subjectId", SvgConstants.Tags.IMAGE, AttendanceDayDialogKt.ARG_SEM, "subject", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TeacherSurveyQuestionFragment newInstance(String id, String teacherId, String subjectId, String image, String semester, String subject, boolean flag) {
            TeacherSurveyQuestionFragment teacherSurveyQuestionFragment = new TeacherSurveyQuestionFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(ReplyDialogKt.ARG_SENDER_ID, teacherId);
            bundle.putString(CommentReplyDialogKt.ARG_SUB_ID, subjectId);
            bundle.putString(CommentReplyDialogKt.ARG_IMG, image);
            bundle.putString(AttendanceDayDialogKt.ARG_SEM, semester);
            bundle.putString("sub", subject);
            bundle.putBoolean("flag", flag);
            teacherSurveyQuestionFragment.setArguments(bundle);
            return teacherSurveyQuestionFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.teacherId = arguments.getString(ReplyDialogKt.ARG_SENDER_ID);
            this.subjectId = arguments.getString(CommentReplyDialogKt.ARG_SUB_ID);
            String string = arguments.getString(CommentReplyDialogKt.ARG_IMG);
            Intrinsics.checkNotNull(string);
            this.image = string;
            String string2 = arguments.getString(AttendanceDayDialogKt.ARG_SEM);
            Intrinsics.checkNotNull(string2);
            this.semester = string2;
            String string3 = arguments.getString("sub");
            Intrinsics.checkNotNull(string3);
            this.subject = string3;
            this.surveyFlag = arguments.getBoolean("flag");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTeacherSurveyQuestionsBinding.inflate(inflater, container, false);
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding != null) {
            fragmentTeacherSurveyQuestionsBinding.setTeacherSurveyQuestionViewModel(getTeacherSurveyQuestionViewModel());
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding2 != null) {
            fragmentTeacherSurveyQuestionsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding3 != null) {
            return fragmentTeacherSurveyQuestionsBinding3.getRoot();
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
            activity.setTitle("Teacher Survey Questions");
        }
        hideBaseView();
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = get_binding();
        RecyclerView recyclerView = fragmentTeacherSurveyQuestionsBinding != null ? fragmentTeacherSurveyQuestionsBinding.rvQuestionNo : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenAnswerResponse();
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = get_binding();
        TextView textView4 = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.backBtn : null;
        if (textView4 != null) {
            textView4.setVisibility(4);
        }
        String str = this.teacherId;
        Intrinsics.checkNotNull(str);
        if (Intrinsics.areEqual(str, "")) {
            TeacherSurveyQuestionViewModel teacherSurveyQuestionViewModel = getTeacherSurveyQuestionViewModel();
            String str2 = this.id;
            Intrinsics.checkNotNull(str2);
            teacherSurveyQuestionViewModel.getGenSurveyQuestionList(str2);
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = get_binding();
            LinearLayout linearLayout = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.strengthLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            TeacherSurveyQuestionViewModel teacherSurveyQuestionViewModel2 = getTeacherSurveyQuestionViewModel();
            String str3 = this.id;
            Intrinsics.checkNotNull(str3);
            String str4 = this.teacherId;
            Intrinsics.checkNotNull(str4);
            String str5 = this.subjectId;
            Intrinsics.checkNotNull(str5);
            teacherSurveyQuestionViewModel2.getSurveyQuestionListList(str3, str4, str5);
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = get_binding();
            LinearLayout linearLayout2 = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.strengthLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mbits", false, 2, (Object) null)) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = get_binding();
            LinearLayout linearLayout3 = fragmentTeacherSurveyQuestionsBinding5 != null ? fragmentTeacherSurveyQuestionsBinding5.mbitsLyt : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            if (this.image.length() > 0) {
                RequestCreator fit = Picasso.get().load(this.image).placeholder(R.drawable.ic_user_profile).error(R.drawable.ic_user_profile).fit();
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = get_binding();
                ImageView imageView = fragmentTeacherSurveyQuestionsBinding6 != null ? fragmentTeacherSurveyQuestionsBinding6.teacherImg : null;
                Intrinsics.checkNotNull(imageView);
                fit.into(imageView);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = get_binding();
            TextView textView5 = fragmentTeacherSurveyQuestionsBinding7 != null ? fragmentTeacherSurveyQuestionsBinding7.semTv : null;
            if (textView5 != null) {
                textView5.setText(this.semester);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = get_binding();
            TextView textView6 = fragmentTeacherSurveyQuestionsBinding8 != null ? fragmentTeacherSurveyQuestionsBinding8.subTv : null;
            if (textView6 != null) {
                textView6.setText(this.subject);
            }
        } else {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding9 = get_binding();
            LinearLayout linearLayout4 = fragmentTeacherSurveyQuestionsBinding9 != null ? fragmentTeacherSurveyQuestionsBinding9.mbitsLyt : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding10 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding10 != null && (radioGroup = fragmentTeacherSurveyQuestionsBinding10.teacherSurveyQuestionsMultiple) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    TeacherSurveyQuestionFragment.setUp$lambda$1(TeacherSurveyQuestionFragment.this, radioGroup2, i);
                }
            });
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding11 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding11 != null && (textView3 = fragmentTeacherSurveyQuestionsBinding11.nextBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeacherSurveyQuestionFragment.setUp$lambda$2(TeacherSurveyQuestionFragment.this, view);
                }
            });
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding12 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding12 != null && (textView2 = fragmentTeacherSurveyQuestionsBinding12.backBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeacherSurveyQuestionFragment.setUp$lambda$3(TeacherSurveyQuestionFragment.this, view);
                }
            });
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding13 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding13 == null || (textView = fragmentTeacherSurveyQuestionsBinding13.finishBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeacherSurveyQuestionFragment.setUp$lambda$4(TeacherSurveyQuestionFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TeacherSurveyQuestionFragment this$0, RadioGroup radioGroup, int i) {
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
        }
        try {
            if (!Intrinsics.areEqual(this$0.teacherId, "")) {
                int i2 = this$0.i;
                Intrinsics.checkNotNull(this$0.surveyResponse);
                if (i2 == r1.size() - 3) {
                    System.out.println((Object) "option");
                    System.out.println((Object) this$0.option);
                    System.out.println(this$0.i);
                    System.out.println((Object) "option");
                    return;
                }
                int i3 = this$0.i;
                Intrinsics.checkNotNull(this$0.surveyResponse);
                if (i3 > r0.size() - 2) {
                    return;
                }
                this$0.surveyAnswers.set(this$0.i, this$0.option);
                this$0.option = "";
                System.out.println((Object) "");
            } else {
                int i4 = this$0.i;
                Intrinsics.checkNotNull(this$0.surveyResponse);
                if (i4 == r1.size() - 2) {
                    System.out.println((Object) "option");
                    System.out.println((Object) this$0.option);
                    System.out.println(this$0.i);
                    System.out.println((Object) "option");
                    return;
                }
                int i5 = this$0.i;
                Intrinsics.checkNotNull(this$0.surveyResponse);
                if (i5 > r0.size() - 1) {
                    return;
                }
                this$0.surveyAnswers.set(this$0.i, this$0.option);
                this$0.option = "";
                System.out.println((Object) "");
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:10|(2:12|(15:14|(1:16)(1:529)|(1:18)|19|(1:21)|518|(1:528)(1:522)|523|(1:527)|23|24|25|(3:27|(1:29)(1:504)|(1:31)(1:503))(3:505|(1:507)(1:511)|(1:509)(1:510))|32|(6:34|(1:36)(1:45)|(1:38)|39|(1:41)(1:44)|(1:43))))(1:536)|530|(1:532)(1:535)|(1:534)|19|(0)|518|(1:520)|528|523|(2:525|527)|23|24|25|(0)(0)|32|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0124, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1.get(r27.i - 1).getType(), androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_2D) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x09f2, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1.get(r27.i).getType(), androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_2D) != false) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x01b4, code lost:
    
        r1 = r27.get_binding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x01b9, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x01bb, code lost:
    
        r1 = r1.requiredTv;
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x01bf, code lost:
    
        if (r1 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x01c2, code lost:
    
        r1.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x01be, code lost:
    
        r1 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x018f A[Catch: NullPointerException -> 0x01b4, TryCatch #1 {NullPointerException -> 0x01b4, blocks: (B:25:0x0173, B:27:0x018f, B:29:0x0195, B:503:0x019c, B:505:0x01a1, B:507:0x01a7, B:510:0x01ae), top: B:24:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x01a1 A[Catch: NullPointerException -> 0x01b4, TryCatch #1 {NullPointerException -> 0x01b4, blocks: (B:25:0x0173, B:27:0x018f, B:29:0x0195, B:503:0x019c, B:505:0x01a1, B:507:0x01a7, B:510:0x01ae), top: B:24:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0c41  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0f2e  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x0f35  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0f54  */
    /* JADX WARN: Removed duplicated region for block: B:666:0x0f5b  */
    /* JADX WARN: Removed duplicated region for block: B:669:0x0f66  */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0f6d  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x0f8c  */
    /* JADX WARN: Removed duplicated region for block: B:720:0x104e  */
    /* JADX WARN: Removed duplicated region for block: B:892:0x0f69  */
    /* JADX WARN: Removed duplicated region for block: B:893:0x0f57  */
    /* JADX WARN: Removed duplicated region for block: B:894:0x0f31  */
    /* JADX WARN: Type inference failed for: r1v455 */
    /* JADX WARN: Type inference failed for: r1v456, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v468 */
    /* JADX WARN: Type inference failed for: r1v469, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v510 */
    /* JADX WARN: Type inference failed for: r1v511, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v513 */
    /* JADX WARN: Type inference failed for: r1v514, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v578 */
    /* JADX WARN: Type inference failed for: r1v579, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v581 */
    /* JADX WARN: Type inference failed for: r1v582, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v772 */
    /* JADX WARN: Type inference failed for: r1v773, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v798 */
    /* JADX WARN: Type inference failed for: r1v799, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v857 */
    /* JADX WARN: Type inference failed for: r1v858 */
    /* JADX WARN: Type inference failed for: r1v859 */
    /* JADX WARN: Type inference failed for: r1v860 */
    /* JADX WARN: Type inference failed for: r1v861 */
    /* JADX WARN: Type inference failed for: r1v862 */
    /* JADX WARN: Type inference failed for: r1v863 */
    /* JADX WARN: Type inference failed for: r1v864 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void setUp$lambda$2(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment r27, android.view.View r28) {
        /*
            Method dump skipped, instructions count: 5379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.setUp$lambda$2(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(TeacherSurveyQuestionFragment this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        RadioGroup radioGroup;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        RadioGroup radioGroup2;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        TextInputEditText textInputEditText13;
        TextInputEditText textInputEditText14;
        TextInputEditText textInputEditText15;
        TextInputEditText textInputEditText16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeacherSurveyQuestionAdapter adapter = this$0.getAdapter();
        List<String> list = this$0.surveyAnswers;
        int i = this$0.i;
        adapter.addItems(list, i - 1, this$0.mandatoryQuestions, this$0.attendedOrNot, i - 1);
        int i2 = this$0.i - 1;
        this$0.i = i2;
        if (i2 == 0 && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mbits", false, 2, (Object) null)) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = this$0.get_binding();
            LinearLayout linearLayout = fragmentTeacherSurveyQuestionsBinding != null ? fragmentTeacherSurveyQuestionsBinding.mbitsLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = this$0.get_binding();
            LinearLayout linearLayout2 = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.mbitsLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        if (!Intrinsics.areEqual(this$0.teacherId, "")) {
            int i3 = this$0.i;
            Intrinsics.checkNotNull(this$0.surveyResponse);
            if (i3 == r7.size() - 4) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = this$0.get_binding();
                System.out.println((Object) String.valueOf((fragmentTeacherSurveyQuestionsBinding3 == null || (textInputEditText16 = fragmentTeacherSurveyQuestionsBinding3.etDescriptive) == null) ? null : textInputEditText16.getText()));
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = this$0.get_binding();
                this$0.strength = String.valueOf((fragmentTeacherSurveyQuestionsBinding4 == null || (textInputEditText15 = fragmentTeacherSurveyQuestionsBinding4.etStrength) == null) ? null : textInputEditText15.getText());
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = this$0.get_binding();
                this$0.remarks = String.valueOf((fragmentTeacherSurveyQuestionsBinding5 == null || (textInputEditText14 = fragmentTeacherSurveyQuestionsBinding5.etRemarks) == null) ? null : textInputEditText14.getText());
                System.out.println((Object) "tech");
                System.out.println(this$0.i + 1);
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = this$0.get_binding();
                String valueOf = String.valueOf((fragmentTeacherSurveyQuestionsBinding6 == null || (textInputEditText13 = fragmentTeacherSurveyQuestionsBinding6.etDescriptive) == null) ? null : textInputEditText13.getText());
                this$0.lastDesc = valueOf;
                System.out.println((Object) valueOf);
                System.out.println((Object) "tech");
            }
            ArrayList<SurveyQuestion> arrayList = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList);
            if (Intrinsics.areEqual(arrayList.get(this$0.i + 1).getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                List<String> list2 = this$0.surveyAnswers;
                int i4 = this$0.i + 1;
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = this$0.get_binding();
                list2.set(i4, String.valueOf((fragmentTeacherSurveyQuestionsBinding7 == null || (textInputEditText12 = fragmentTeacherSurveyQuestionsBinding7.etDescriptive) == null) ? null : textInputEditText12.getText()));
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = this$0.get_binding();
                if (fragmentTeacherSurveyQuestionsBinding8 != null && (textInputEditText11 = fragmentTeacherSurveyQuestionsBinding8.etDescriptive) != null) {
                    textInputEditText11.setText(this$0.surveyAnswers.get(this$0.i));
                    Unit unit = Unit.INSTANCE;
                }
            }
            this$0.flag = false;
            System.out.println(this$0.i);
            System.out.println(this$0.surveyAnswers);
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding9 = this$0.get_binding();
            LinearLayout linearLayout3 = fragmentTeacherSurveyQuestionsBinding9 != null ? fragmentTeacherSurveyQuestionsBinding9.finalQuestionsLyt : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            if (this$0.i == 0) {
                this$0.i = 0;
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding10 = this$0.get_binding();
                TextView textView = fragmentTeacherSurveyQuestionsBinding10 != null ? fragmentTeacherSurveyQuestionsBinding10.backBtn : null;
                if (textView != null) {
                    textView.setVisibility(4);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding11 = this$0.get_binding();
                TextView textView2 = fragmentTeacherSurveyQuestionsBinding11 != null ? fragmentTeacherSurveyQuestionsBinding11.nextBtn : null;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding12 = this$0.get_binding();
                TextView textView3 = fragmentTeacherSurveyQuestionsBinding12 != null ? fragmentTeacherSurveyQuestionsBinding12.finishBtn : null;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding13 = this$0.get_binding();
                TextView textView4 = fragmentTeacherSurveyQuestionsBinding13 != null ? fragmentTeacherSurveyQuestionsBinding13.questionTv : null;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            } else {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding14 = this$0.get_binding();
                TextView textView5 = fragmentTeacherSurveyQuestionsBinding14 != null ? fragmentTeacherSurveyQuestionsBinding14.backBtn : null;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding15 = this$0.get_binding();
                TextView textView6 = fragmentTeacherSurveyQuestionsBinding15 != null ? fragmentTeacherSurveyQuestionsBinding15.nextBtn : null;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding16 = this$0.get_binding();
                TextView textView7 = fragmentTeacherSurveyQuestionsBinding16 != null ? fragmentTeacherSurveyQuestionsBinding16.finishBtn : null;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding17 = this$0.get_binding();
                TextView textView8 = fragmentTeacherSurveyQuestionsBinding17 != null ? fragmentTeacherSurveyQuestionsBinding17.questionTv : null;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
            }
            ArrayList<SurveyQuestion> arrayList2 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList2);
            String required = arrayList2.get(this$0.i).getRequired();
            Intrinsics.checkNotNull(required);
            if (Intrinsics.areEqual(required, "true")) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding18 = this$0.get_binding();
                TextView textView9 = fragmentTeacherSurveyQuestionsBinding18 != null ? fragmentTeacherSurveyQuestionsBinding18.requiredTv : null;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
            } else {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding19 = this$0.get_binding();
                TextView textView10 = fragmentTeacherSurveyQuestionsBinding19 != null ? fragmentTeacherSurveyQuestionsBinding19.requiredTv : null;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                }
            }
            int i5 = this$0.i;
            ArrayList<SurveyQuestion> arrayList3 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList3);
            if (i5 <= arrayList3.size() - 3) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding20 = this$0.get_binding();
                TextView textView11 = fragmentTeacherSurveyQuestionsBinding20 != null ? fragmentTeacherSurveyQuestionsBinding20.teacherSurveyQuestion : null;
                if (textView11 != null) {
                    textView11.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding21 = this$0.get_binding();
                TextView textView12 = fragmentTeacherSurveyQuestionsBinding21 != null ? fragmentTeacherSurveyQuestionsBinding21.teacherSurveyQuestion : null;
                if (textView12 != null) {
                    ArrayList<SurveyQuestion> arrayList4 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList4);
                    String question = arrayList4.get(this$0.i).getQuestion();
                    Intrinsics.checkNotNull(question);
                    textView12.setText(this$0.convertHtmlToString(question));
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding22 = this$0.get_binding();
                TextView textView13 = fragmentTeacherSurveyQuestionsBinding22 != null ? fragmentTeacherSurveyQuestionsBinding22.teacherSurveyQuestion : null;
                if (textView13 != null) {
                    ArrayList<SurveyQuestion> arrayList5 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList5);
                    String question2 = arrayList5.get(this$0.i).getQuestion();
                    Intrinsics.checkNotNull(question2);
                    textView13.setText("Q) " + this$0.convertHtmlToString(question2));
                }
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding23 = this$0.get_binding();
            TextView textView14 = fragmentTeacherSurveyQuestionsBinding23 != null ? fragmentTeacherSurveyQuestionsBinding23.questionTv : null;
            if (textView14 != null) {
                int i6 = this$0.i + 1;
                ArrayList<SurveyQuestion> arrayList6 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList6);
                textView14.setText(i6 + RemoteSettings.FORWARD_SLASH_STRING + (arrayList6.size() - 2));
            }
            ArrayList<SurveyQuestion> arrayList7 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList7);
            if (Intrinsics.areEqual(arrayList7.get(this$0.i).getType(), "1")) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding24 = this$0.get_binding();
                TextView textView15 = fragmentTeacherSurveyQuestionsBinding24 != null ? fragmentTeacherSurveyQuestionsBinding24.teacherSurveyQuestionNo : null;
                if (textView15 != null) {
                    textView15.setText("Question " + (this$0.i + 1) + " (Multiple Choice)");
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding25 = this$0.get_binding();
                LinearLayout linearLayout4 = fragmentTeacherSurveyQuestionsBinding25 != null ? fragmentTeacherSurveyQuestionsBinding25.descriptiveAnswerLyt : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding26 = this$0.get_binding();
                LinearLayout linearLayout5 = fragmentTeacherSurveyQuestionsBinding26 != null ? fragmentTeacherSurveyQuestionsBinding26.multipleAnswerLyt : null;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                }
                if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding27 = this$0.get_binding();
                    if (fragmentTeacherSurveyQuestionsBinding27 != null && (radioGroup2 = fragmentTeacherSurveyQuestionsBinding27.teacherSurveyQuestionsMultiple) != null) {
                        radioGroup2.clearCheck();
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "0")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding28 = this$0.get_binding();
                    RadioButton radioButton = fragmentTeacherSurveyQuestionsBinding28 != null ? fragmentTeacherSurveyQuestionsBinding28.option1 : null;
                    if (radioButton != null) {
                        radioButton.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "1")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding29 = this$0.get_binding();
                    RadioButton radioButton2 = fragmentTeacherSurveyQuestionsBinding29 != null ? fragmentTeacherSurveyQuestionsBinding29.option2 : null;
                    if (radioButton2 != null) {
                        radioButton2.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_2D)) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding30 = this$0.get_binding();
                    RadioButton radioButton3 = fragmentTeacherSurveyQuestionsBinding30 != null ? fragmentTeacherSurveyQuestionsBinding30.option3 : null;
                    if (radioButton3 != null) {
                        radioButton3.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_3D)) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding31 = this$0.get_binding();
                    RadioButton radioButton4 = fragmentTeacherSurveyQuestionsBinding31 != null ? fragmentTeacherSurveyQuestionsBinding31.option4 : null;
                    if (radioButton4 != null) {
                        radioButton4.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "4")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding32 = this$0.get_binding();
                    RadioButton radioButton5 = fragmentTeacherSurveyQuestionsBinding32 != null ? fragmentTeacherSurveyQuestionsBinding32.option5 : null;
                    if (radioButton5 != null) {
                        radioButton5.setChecked(true);
                    }
                }
                ArrayList<SurveyQuestion> arrayList8 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList8);
                ArrayList<String> option = arrayList8.get(this$0.i).getOption();
                Intrinsics.checkNotNull(option);
                if (option.size() == 2) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding33 = this$0.get_binding();
                    RadioButton radioButton6 = fragmentTeacherSurveyQuestionsBinding33 != null ? fragmentTeacherSurveyQuestionsBinding33.option1 : null;
                    if (radioButton6 != null) {
                        radioButton6.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding34 = this$0.get_binding();
                    RadioButton radioButton7 = fragmentTeacherSurveyQuestionsBinding34 != null ? fragmentTeacherSurveyQuestionsBinding34.option2 : null;
                    if (radioButton7 != null) {
                        radioButton7.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding35 = this$0.get_binding();
                    RadioButton radioButton8 = fragmentTeacherSurveyQuestionsBinding35 != null ? fragmentTeacherSurveyQuestionsBinding35.option3 : null;
                    if (radioButton8 != null) {
                        radioButton8.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding36 = this$0.get_binding();
                    RadioButton radioButton9 = fragmentTeacherSurveyQuestionsBinding36 != null ? fragmentTeacherSurveyQuestionsBinding36.option4 : null;
                    if (radioButton9 != null) {
                        radioButton9.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding37 = this$0.get_binding();
                    RadioButton radioButton10 = fragmentTeacherSurveyQuestionsBinding37 != null ? fragmentTeacherSurveyQuestionsBinding37.option5 : null;
                    if (radioButton10 != null) {
                        radioButton10.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding38 = this$0.get_binding();
                    RadioButton radioButton11 = fragmentTeacherSurveyQuestionsBinding38 != null ? fragmentTeacherSurveyQuestionsBinding38.option1 : null;
                    if (radioButton11 != null) {
                        ArrayList<SurveyQuestion> arrayList9 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList9);
                        ArrayList<String> option2 = arrayList9.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option2);
                        String str = option2.get(0);
                        Intrinsics.checkNotNullExpressionValue(str, "surveyResponse!![i].option!![0]");
                        radioButton11.setText(this$0.convertHtmlToString(str));
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding39 = this$0.get_binding();
                    RadioButton radioButton12 = fragmentTeacherSurveyQuestionsBinding39 != null ? fragmentTeacherSurveyQuestionsBinding39.option2 : null;
                    if (radioButton12 != null) {
                        ArrayList<SurveyQuestion> arrayList10 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList10);
                        ArrayList<String> option3 = arrayList10.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option3);
                        String str2 = option3.get(1);
                        Intrinsics.checkNotNullExpressionValue(str2, "surveyResponse!![i].option!![1]");
                        radioButton12.setText(this$0.convertHtmlToString(str2));
                    }
                } else {
                    ArrayList<SurveyQuestion> arrayList11 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList11);
                    ArrayList<String> option4 = arrayList11.get(this$0.i).getOption();
                    Intrinsics.checkNotNull(option4);
                    if (option4.size() == 3) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding40 = this$0.get_binding();
                        RadioButton radioButton13 = fragmentTeacherSurveyQuestionsBinding40 != null ? fragmentTeacherSurveyQuestionsBinding40.option1 : null;
                        if (radioButton13 != null) {
                            radioButton13.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding41 = this$0.get_binding();
                        RadioButton radioButton14 = fragmentTeacherSurveyQuestionsBinding41 != null ? fragmentTeacherSurveyQuestionsBinding41.option2 : null;
                        if (radioButton14 != null) {
                            radioButton14.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding42 = this$0.get_binding();
                        RadioButton radioButton15 = fragmentTeacherSurveyQuestionsBinding42 != null ? fragmentTeacherSurveyQuestionsBinding42.option3 : null;
                        if (radioButton15 != null) {
                            radioButton15.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding43 = this$0.get_binding();
                        RadioButton radioButton16 = fragmentTeacherSurveyQuestionsBinding43 != null ? fragmentTeacherSurveyQuestionsBinding43.option4 : null;
                        if (radioButton16 != null) {
                            radioButton16.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding44 = this$0.get_binding();
                        RadioButton radioButton17 = fragmentTeacherSurveyQuestionsBinding44 != null ? fragmentTeacherSurveyQuestionsBinding44.option5 : null;
                        if (radioButton17 != null) {
                            radioButton17.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding45 = this$0.get_binding();
                        RadioButton radioButton18 = fragmentTeacherSurveyQuestionsBinding45 != null ? fragmentTeacherSurveyQuestionsBinding45.option1 : null;
                        if (radioButton18 != null) {
                            ArrayList<SurveyQuestion> arrayList12 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList12);
                            ArrayList<String> option5 = arrayList12.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option5);
                            String str3 = option5.get(0);
                            Intrinsics.checkNotNullExpressionValue(str3, "surveyResponse!![i].option!![0]");
                            radioButton18.setText(this$0.convertHtmlToString(str3));
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding46 = this$0.get_binding();
                        RadioButton radioButton19 = fragmentTeacherSurveyQuestionsBinding46 != null ? fragmentTeacherSurveyQuestionsBinding46.option2 : null;
                        if (radioButton19 != null) {
                            ArrayList<SurveyQuestion> arrayList13 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList13);
                            ArrayList<String> option6 = arrayList13.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option6);
                            String str4 = option6.get(1);
                            Intrinsics.checkNotNullExpressionValue(str4, "surveyResponse!![i].option!![1]");
                            radioButton19.setText(this$0.convertHtmlToString(str4));
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding47 = this$0.get_binding();
                        RadioButton radioButton20 = fragmentTeacherSurveyQuestionsBinding47 != null ? fragmentTeacherSurveyQuestionsBinding47.option3 : null;
                        if (radioButton20 != null) {
                            ArrayList<SurveyQuestion> arrayList14 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList14);
                            ArrayList<String> option7 = arrayList14.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option7);
                            String str5 = option7.get(2);
                            Intrinsics.checkNotNullExpressionValue(str5, "surveyResponse!![i].option!![2]");
                            radioButton20.setText(this$0.convertHtmlToString(str5));
                        }
                    } else {
                        ArrayList<SurveyQuestion> arrayList15 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList15);
                        ArrayList<String> option8 = arrayList15.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option8);
                        if (option8.size() == 4) {
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding48 = this$0.get_binding();
                            RadioButton radioButton21 = fragmentTeacherSurveyQuestionsBinding48 != null ? fragmentTeacherSurveyQuestionsBinding48.option1 : null;
                            if (radioButton21 != null) {
                                radioButton21.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding49 = this$0.get_binding();
                            RadioButton radioButton22 = fragmentTeacherSurveyQuestionsBinding49 != null ? fragmentTeacherSurveyQuestionsBinding49.option2 : null;
                            if (radioButton22 != null) {
                                radioButton22.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding50 = this$0.get_binding();
                            RadioButton radioButton23 = fragmentTeacherSurveyQuestionsBinding50 != null ? fragmentTeacherSurveyQuestionsBinding50.option3 : null;
                            if (radioButton23 != null) {
                                radioButton23.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding51 = this$0.get_binding();
                            RadioButton radioButton24 = fragmentTeacherSurveyQuestionsBinding51 != null ? fragmentTeacherSurveyQuestionsBinding51.option4 : null;
                            if (radioButton24 != null) {
                                radioButton24.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding52 = this$0.get_binding();
                            RadioButton radioButton25 = fragmentTeacherSurveyQuestionsBinding52 != null ? fragmentTeacherSurveyQuestionsBinding52.option5 : null;
                            if (radioButton25 != null) {
                                radioButton25.setVisibility(8);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding53 = this$0.get_binding();
                            RadioButton radioButton26 = fragmentTeacherSurveyQuestionsBinding53 != null ? fragmentTeacherSurveyQuestionsBinding53.option1 : null;
                            if (radioButton26 != null) {
                                ArrayList<SurveyQuestion> arrayList16 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList16);
                                ArrayList<String> option9 = arrayList16.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option9);
                                String str6 = option9.get(0);
                                Intrinsics.checkNotNullExpressionValue(str6, "surveyResponse!![i].option!![0]");
                                radioButton26.setText(this$0.convertHtmlToString(str6));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding54 = this$0.get_binding();
                            RadioButton radioButton27 = fragmentTeacherSurveyQuestionsBinding54 != null ? fragmentTeacherSurveyQuestionsBinding54.option2 : null;
                            if (radioButton27 != null) {
                                ArrayList<SurveyQuestion> arrayList17 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList17);
                                ArrayList<String> option10 = arrayList17.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option10);
                                String str7 = option10.get(1);
                                Intrinsics.checkNotNullExpressionValue(str7, "surveyResponse!![i].option!![1]");
                                radioButton27.setText(this$0.convertHtmlToString(str7));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding55 = this$0.get_binding();
                            RadioButton radioButton28 = fragmentTeacherSurveyQuestionsBinding55 != null ? fragmentTeacherSurveyQuestionsBinding55.option3 : null;
                            if (radioButton28 != null) {
                                ArrayList<SurveyQuestion> arrayList18 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList18);
                                ArrayList<String> option11 = arrayList18.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option11);
                                String str8 = option11.get(2);
                                Intrinsics.checkNotNullExpressionValue(str8, "surveyResponse!![i].option!![2]");
                                radioButton28.setText(this$0.convertHtmlToString(str8));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding56 = this$0.get_binding();
                            RadioButton radioButton29 = fragmentTeacherSurveyQuestionsBinding56 != null ? fragmentTeacherSurveyQuestionsBinding56.option4 : null;
                            if (radioButton29 != null) {
                                ArrayList<SurveyQuestion> arrayList19 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList19);
                                ArrayList<String> option12 = arrayList19.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option12);
                                String str9 = option12.get(3);
                                Intrinsics.checkNotNullExpressionValue(str9, "surveyResponse!![i].option!![3]");
                                radioButton29.setText(this$0.convertHtmlToString(str9));
                            }
                        } else {
                            ArrayList<SurveyQuestion> arrayList20 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList20);
                            ArrayList<String> option13 = arrayList20.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option13);
                            if (option13.size() == 5) {
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding57 = this$0.get_binding();
                                RadioButton radioButton30 = fragmentTeacherSurveyQuestionsBinding57 != null ? fragmentTeacherSurveyQuestionsBinding57.option1 : null;
                                if (radioButton30 != null) {
                                    radioButton30.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding58 = this$0.get_binding();
                                RadioButton radioButton31 = fragmentTeacherSurveyQuestionsBinding58 != null ? fragmentTeacherSurveyQuestionsBinding58.option2 : null;
                                if (radioButton31 != null) {
                                    radioButton31.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding59 = this$0.get_binding();
                                RadioButton radioButton32 = fragmentTeacherSurveyQuestionsBinding59 != null ? fragmentTeacherSurveyQuestionsBinding59.option3 : null;
                                if (radioButton32 != null) {
                                    radioButton32.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding60 = this$0.get_binding();
                                RadioButton radioButton33 = fragmentTeacherSurveyQuestionsBinding60 != null ? fragmentTeacherSurveyQuestionsBinding60.option4 : null;
                                if (radioButton33 != null) {
                                    radioButton33.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding61 = this$0.get_binding();
                                RadioButton radioButton34 = fragmentTeacherSurveyQuestionsBinding61 != null ? fragmentTeacherSurveyQuestionsBinding61.option5 : null;
                                if (radioButton34 != null) {
                                    radioButton34.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding62 = this$0.get_binding();
                                RadioButton radioButton35 = fragmentTeacherSurveyQuestionsBinding62 != null ? fragmentTeacherSurveyQuestionsBinding62.option1 : null;
                                if (radioButton35 != null) {
                                    ArrayList<SurveyQuestion> arrayList21 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList21);
                                    ArrayList<String> option14 = arrayList21.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option14);
                                    String str10 = option14.get(0);
                                    Intrinsics.checkNotNullExpressionValue(str10, "surveyResponse!![i].option!![0]");
                                    radioButton35.setText(this$0.convertHtmlToString(str10));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding63 = this$0.get_binding();
                                RadioButton radioButton36 = fragmentTeacherSurveyQuestionsBinding63 != null ? fragmentTeacherSurveyQuestionsBinding63.option2 : null;
                                if (radioButton36 != null) {
                                    ArrayList<SurveyQuestion> arrayList22 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList22);
                                    ArrayList<String> option15 = arrayList22.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option15);
                                    String str11 = option15.get(1);
                                    Intrinsics.checkNotNullExpressionValue(str11, "surveyResponse!![i].option!![1]");
                                    radioButton36.setText(this$0.convertHtmlToString(str11));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding64 = this$0.get_binding();
                                RadioButton radioButton37 = fragmentTeacherSurveyQuestionsBinding64 != null ? fragmentTeacherSurveyQuestionsBinding64.option3 : null;
                                if (radioButton37 != null) {
                                    ArrayList<SurveyQuestion> arrayList23 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList23);
                                    ArrayList<String> option16 = arrayList23.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option16);
                                    String str12 = option16.get(2);
                                    Intrinsics.checkNotNullExpressionValue(str12, "surveyResponse!![i].option!![2]");
                                    radioButton37.setText(this$0.convertHtmlToString(str12));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding65 = this$0.get_binding();
                                RadioButton radioButton38 = fragmentTeacherSurveyQuestionsBinding65 != null ? fragmentTeacherSurveyQuestionsBinding65.option4 : null;
                                if (radioButton38 != null) {
                                    ArrayList<SurveyQuestion> arrayList24 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList24);
                                    ArrayList<String> option17 = arrayList24.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option17);
                                    String str13 = option17.get(3);
                                    Intrinsics.checkNotNullExpressionValue(str13, "surveyResponse!![i].option!![3]");
                                    radioButton38.setText(this$0.convertHtmlToString(str13));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding66 = this$0.get_binding();
                                RadioButton radioButton39 = fragmentTeacherSurveyQuestionsBinding66 != null ? fragmentTeacherSurveyQuestionsBinding66.option5 : null;
                                if (radioButton39 != null) {
                                    ArrayList<SurveyQuestion> arrayList25 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList25);
                                    ArrayList<String> option18 = arrayList25.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option18);
                                    String str14 = option18.get(4);
                                    Intrinsics.checkNotNullExpressionValue(str14, "surveyResponse!![i].option!![4]");
                                    radioButton39.setText(this$0.convertHtmlToString(str14));
                                }
                            }
                        }
                    }
                }
            } else {
                ArrayList<SurveyQuestion> arrayList26 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList26);
                if (Intrinsics.areEqual(arrayList26.get(this$0.i).getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                    if (!Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "")) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding67 = this$0.get_binding();
                        if (fragmentTeacherSurveyQuestionsBinding67 != null && (textInputEditText10 = fragmentTeacherSurveyQuestionsBinding67.etDescriptive) != null) {
                            textInputEditText10.setText(this$0.surveyAnswers.get(this$0.i));
                            Unit unit3 = Unit.INSTANCE;
                        }
                    } else {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding68 = this$0.get_binding();
                        if (fragmentTeacherSurveyQuestionsBinding68 != null && (textInputEditText9 = fragmentTeacherSurveyQuestionsBinding68.etDescriptive) != null) {
                            textInputEditText9.setText("");
                            Unit unit4 = Unit.INSTANCE;
                        }
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding69 = this$0.get_binding();
                    TextView textView16 = fragmentTeacherSurveyQuestionsBinding69 != null ? fragmentTeacherSurveyQuestionsBinding69.teacherSurveyQuestionNo : null;
                    if (textView16 != null) {
                        textView16.setText("Question " + (this$0.i + 1) + " (Descriptive)");
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding70 = this$0.get_binding();
                    LinearLayout linearLayout6 = fragmentTeacherSurveyQuestionsBinding70 != null ? fragmentTeacherSurveyQuestionsBinding70.descriptiveAnswerLyt : null;
                    if (linearLayout6 != null) {
                        linearLayout6.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding71 = this$0.get_binding();
                    LinearLayout linearLayout7 = fragmentTeacherSurveyQuestionsBinding71 != null ? fragmentTeacherSurveyQuestionsBinding71.multipleAnswerLyt : null;
                    if (linearLayout7 != null) {
                        linearLayout7.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding72 = this$0.get_binding();
                    TextView textView17 = fragmentTeacherSurveyQuestionsBinding72 != null ? fragmentTeacherSurveyQuestionsBinding72.teacherSurveyQuestion : null;
                    if (textView17 != null) {
                        ArrayList<SurveyQuestion> arrayList27 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList27);
                        String question3 = arrayList27.get(this$0.i).getQuestion();
                        Intrinsics.checkNotNull(question3);
                        textView17.setText("Q ) " + this$0.convertHtmlToString(question3));
                    }
                }
            }
        } else {
            int i7 = this$0.i;
            Intrinsics.checkNotNull(this$0.surveyResponse);
            if (i7 == r7.size() - 3) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding73 = this$0.get_binding();
                System.out.println((Object) String.valueOf((fragmentTeacherSurveyQuestionsBinding73 == null || (textInputEditText8 = fragmentTeacherSurveyQuestionsBinding73.etDescriptive) == null) ? null : textInputEditText8.getText()));
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding74 = this$0.get_binding();
                this$0.strength = String.valueOf((fragmentTeacherSurveyQuestionsBinding74 == null || (textInputEditText7 = fragmentTeacherSurveyQuestionsBinding74.etStrength) == null) ? null : textInputEditText7.getText());
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding75 = this$0.get_binding();
                this$0.remarks = String.valueOf((fragmentTeacherSurveyQuestionsBinding75 == null || (textInputEditText6 = fragmentTeacherSurveyQuestionsBinding75.etRemarks) == null) ? null : textInputEditText6.getText());
                System.out.println((Object) "tech");
                System.out.println(this$0.i + 1);
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding76 = this$0.get_binding();
                String valueOf2 = String.valueOf((fragmentTeacherSurveyQuestionsBinding76 == null || (textInputEditText5 = fragmentTeacherSurveyQuestionsBinding76.etDescriptive) == null) ? null : textInputEditText5.getText());
                this$0.lastDesc = valueOf2;
                System.out.println((Object) valueOf2);
                System.out.println((Object) "tech");
            }
            ArrayList<SurveyQuestion> arrayList28 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList28);
            if (Intrinsics.areEqual(arrayList28.get(this$0.i + 1).getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                List<String> list3 = this$0.surveyAnswers;
                int i8 = this$0.i + 1;
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding77 = this$0.get_binding();
                list3.set(i8, String.valueOf((fragmentTeacherSurveyQuestionsBinding77 == null || (textInputEditText4 = fragmentTeacherSurveyQuestionsBinding77.etDescriptive) == null) ? null : textInputEditText4.getText()));
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding78 = this$0.get_binding();
                if (fragmentTeacherSurveyQuestionsBinding78 != null && (textInputEditText3 = fragmentTeacherSurveyQuestionsBinding78.etDescriptive) != null) {
                    textInputEditText3.setText(this$0.surveyAnswers.get(this$0.i));
                    Unit unit5 = Unit.INSTANCE;
                }
            }
            this$0.flag = false;
            System.out.println(this$0.i);
            System.out.println(this$0.surveyAnswers);
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding79 = this$0.get_binding();
            LinearLayout linearLayout8 = fragmentTeacherSurveyQuestionsBinding79 != null ? fragmentTeacherSurveyQuestionsBinding79.finalQuestionsLyt : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(8);
            }
            if (this$0.i == 0) {
                this$0.i = 0;
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding80 = this$0.get_binding();
                TextView textView18 = fragmentTeacherSurveyQuestionsBinding80 != null ? fragmentTeacherSurveyQuestionsBinding80.backBtn : null;
                if (textView18 != null) {
                    textView18.setVisibility(4);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding81 = this$0.get_binding();
                TextView textView19 = fragmentTeacherSurveyQuestionsBinding81 != null ? fragmentTeacherSurveyQuestionsBinding81.nextBtn : null;
                if (textView19 != null) {
                    textView19.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding82 = this$0.get_binding();
                TextView textView20 = fragmentTeacherSurveyQuestionsBinding82 != null ? fragmentTeacherSurveyQuestionsBinding82.finishBtn : null;
                if (textView20 != null) {
                    textView20.setVisibility(8);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding83 = this$0.get_binding();
                TextView textView21 = fragmentTeacherSurveyQuestionsBinding83 != null ? fragmentTeacherSurveyQuestionsBinding83.questionTv : null;
                if (textView21 != null) {
                    textView21.setVisibility(0);
                }
            } else {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding84 = this$0.get_binding();
                TextView textView22 = fragmentTeacherSurveyQuestionsBinding84 != null ? fragmentTeacherSurveyQuestionsBinding84.backBtn : null;
                if (textView22 != null) {
                    textView22.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding85 = this$0.get_binding();
                TextView textView23 = fragmentTeacherSurveyQuestionsBinding85 != null ? fragmentTeacherSurveyQuestionsBinding85.nextBtn : null;
                if (textView23 != null) {
                    textView23.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding86 = this$0.get_binding();
                TextView textView24 = fragmentTeacherSurveyQuestionsBinding86 != null ? fragmentTeacherSurveyQuestionsBinding86.finishBtn : null;
                if (textView24 != null) {
                    textView24.setVisibility(8);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding87 = this$0.get_binding();
                TextView textView25 = fragmentTeacherSurveyQuestionsBinding87 != null ? fragmentTeacherSurveyQuestionsBinding87.questionTv : null;
                if (textView25 != null) {
                    textView25.setVisibility(0);
                }
            }
            ArrayList<SurveyQuestion> arrayList29 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList29);
            String required2 = arrayList29.get(this$0.i).getRequired();
            Intrinsics.checkNotNull(required2);
            if (Intrinsics.areEqual(required2, "true")) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding88 = this$0.get_binding();
                TextView textView26 = fragmentTeacherSurveyQuestionsBinding88 != null ? fragmentTeacherSurveyQuestionsBinding88.requiredTv : null;
                if (textView26 != null) {
                    textView26.setVisibility(0);
                }
            } else {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding89 = this$0.get_binding();
                TextView textView27 = fragmentTeacherSurveyQuestionsBinding89 != null ? fragmentTeacherSurveyQuestionsBinding89.requiredTv : null;
                if (textView27 != null) {
                    textView27.setVisibility(8);
                }
            }
            int i9 = this$0.i;
            ArrayList<SurveyQuestion> arrayList30 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList30);
            if (i9 <= arrayList30.size() - 2) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding90 = this$0.get_binding();
                TextView textView28 = fragmentTeacherSurveyQuestionsBinding90 != null ? fragmentTeacherSurveyQuestionsBinding90.teacherSurveyQuestion : null;
                if (textView28 != null) {
                    textView28.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding91 = this$0.get_binding();
                TextView textView29 = fragmentTeacherSurveyQuestionsBinding91 != null ? fragmentTeacherSurveyQuestionsBinding91.teacherSurveyQuestion : null;
                if (textView29 != null) {
                    ArrayList<SurveyQuestion> arrayList31 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList31);
                    String question4 = arrayList31.get(this$0.i).getQuestion();
                    Intrinsics.checkNotNull(question4);
                    textView29.setText(this$0.convertHtmlToString(question4));
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding92 = this$0.get_binding();
                TextView textView30 = fragmentTeacherSurveyQuestionsBinding92 != null ? fragmentTeacherSurveyQuestionsBinding92.teacherSurveyQuestion : null;
                if (textView30 != null) {
                    ArrayList<SurveyQuestion> arrayList32 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList32);
                    String question5 = arrayList32.get(this$0.i).getQuestion();
                    Intrinsics.checkNotNull(question5);
                    textView30.setText("Q) " + this$0.convertHtmlToString(question5));
                }
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding93 = this$0.get_binding();
            TextView textView31 = fragmentTeacherSurveyQuestionsBinding93 != null ? fragmentTeacherSurveyQuestionsBinding93.questionTv : null;
            if (textView31 != null) {
                int i10 = this$0.i + 1;
                ArrayList<SurveyQuestion> arrayList33 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList33);
                textView31.setText(i10 + RemoteSettings.FORWARD_SLASH_STRING + (arrayList33.size() - 1));
            }
            ArrayList<SurveyQuestion> arrayList34 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList34);
            if (Intrinsics.areEqual(arrayList34.get(this$0.i).getType(), "1")) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding94 = this$0.get_binding();
                TextView textView32 = fragmentTeacherSurveyQuestionsBinding94 != null ? fragmentTeacherSurveyQuestionsBinding94.teacherSurveyQuestionNo : null;
                if (textView32 != null) {
                    textView32.setText("Question " + (this$0.i + 1) + " (Multiple Choice)");
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding95 = this$0.get_binding();
                LinearLayout linearLayout9 = fragmentTeacherSurveyQuestionsBinding95 != null ? fragmentTeacherSurveyQuestionsBinding95.descriptiveAnswerLyt : null;
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(8);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding96 = this$0.get_binding();
                LinearLayout linearLayout10 = fragmentTeacherSurveyQuestionsBinding96 != null ? fragmentTeacherSurveyQuestionsBinding96.multipleAnswerLyt : null;
                if (linearLayout10 != null) {
                    linearLayout10.setVisibility(0);
                }
                if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding97 = this$0.get_binding();
                    if (fragmentTeacherSurveyQuestionsBinding97 != null && (radioGroup = fragmentTeacherSurveyQuestionsBinding97.teacherSurveyQuestionsMultiple) != null) {
                        radioGroup.clearCheck();
                        Unit unit6 = Unit.INSTANCE;
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "0")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding98 = this$0.get_binding();
                    RadioButton radioButton40 = fragmentTeacherSurveyQuestionsBinding98 != null ? fragmentTeacherSurveyQuestionsBinding98.option1 : null;
                    if (radioButton40 != null) {
                        radioButton40.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "1")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding99 = this$0.get_binding();
                    RadioButton radioButton41 = fragmentTeacherSurveyQuestionsBinding99 != null ? fragmentTeacherSurveyQuestionsBinding99.option2 : null;
                    if (radioButton41 != null) {
                        radioButton41.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_2D)) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding100 = this$0.get_binding();
                    RadioButton radioButton42 = fragmentTeacherSurveyQuestionsBinding100 != null ? fragmentTeacherSurveyQuestionsBinding100.option3 : null;
                    if (radioButton42 != null) {
                        radioButton42.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), ExifInterface.GPS_MEASUREMENT_3D)) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding101 = this$0.get_binding();
                    RadioButton radioButton43 = fragmentTeacherSurveyQuestionsBinding101 != null ? fragmentTeacherSurveyQuestionsBinding101.option4 : null;
                    if (radioButton43 != null) {
                        radioButton43.setChecked(true);
                    }
                } else if (Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "4")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding102 = this$0.get_binding();
                    RadioButton radioButton44 = fragmentTeacherSurveyQuestionsBinding102 != null ? fragmentTeacherSurveyQuestionsBinding102.option5 : null;
                    if (radioButton44 != null) {
                        radioButton44.setChecked(true);
                    }
                }
                ArrayList<SurveyQuestion> arrayList35 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList35);
                ArrayList<String> option19 = arrayList35.get(this$0.i).getOption();
                Intrinsics.checkNotNull(option19);
                if (option19.size() == 2) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding103 = this$0.get_binding();
                    RadioButton radioButton45 = fragmentTeacherSurveyQuestionsBinding103 != null ? fragmentTeacherSurveyQuestionsBinding103.option1 : null;
                    if (radioButton45 != null) {
                        radioButton45.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding104 = this$0.get_binding();
                    RadioButton radioButton46 = fragmentTeacherSurveyQuestionsBinding104 != null ? fragmentTeacherSurveyQuestionsBinding104.option2 : null;
                    if (radioButton46 != null) {
                        radioButton46.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding105 = this$0.get_binding();
                    RadioButton radioButton47 = fragmentTeacherSurveyQuestionsBinding105 != null ? fragmentTeacherSurveyQuestionsBinding105.option3 : null;
                    if (radioButton47 != null) {
                        radioButton47.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding106 = this$0.get_binding();
                    RadioButton radioButton48 = fragmentTeacherSurveyQuestionsBinding106 != null ? fragmentTeacherSurveyQuestionsBinding106.option4 : null;
                    if (radioButton48 != null) {
                        radioButton48.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding107 = this$0.get_binding();
                    RadioButton radioButton49 = fragmentTeacherSurveyQuestionsBinding107 != null ? fragmentTeacherSurveyQuestionsBinding107.option5 : null;
                    if (radioButton49 != null) {
                        radioButton49.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding108 = this$0.get_binding();
                    RadioButton radioButton50 = fragmentTeacherSurveyQuestionsBinding108 != null ? fragmentTeacherSurveyQuestionsBinding108.option1 : null;
                    if (radioButton50 != null) {
                        ArrayList<SurveyQuestion> arrayList36 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList36);
                        ArrayList<String> option20 = arrayList36.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option20);
                        String str15 = option20.get(0);
                        Intrinsics.checkNotNullExpressionValue(str15, "surveyResponse!![i].option!![0]");
                        radioButton50.setText(this$0.convertHtmlToString(str15));
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding109 = this$0.get_binding();
                    RadioButton radioButton51 = fragmentTeacherSurveyQuestionsBinding109 != null ? fragmentTeacherSurveyQuestionsBinding109.option2 : null;
                    if (radioButton51 != null) {
                        ArrayList<SurveyQuestion> arrayList37 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList37);
                        ArrayList<String> option21 = arrayList37.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option21);
                        String str16 = option21.get(1);
                        Intrinsics.checkNotNullExpressionValue(str16, "surveyResponse!![i].option!![1]");
                        radioButton51.setText(this$0.convertHtmlToString(str16));
                    }
                } else {
                    ArrayList<SurveyQuestion> arrayList38 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList38);
                    ArrayList<String> option22 = arrayList38.get(this$0.i).getOption();
                    Intrinsics.checkNotNull(option22);
                    if (option22.size() == 3) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding110 = this$0.get_binding();
                        RadioButton radioButton52 = fragmentTeacherSurveyQuestionsBinding110 != null ? fragmentTeacherSurveyQuestionsBinding110.option1 : null;
                        if (radioButton52 != null) {
                            radioButton52.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding111 = this$0.get_binding();
                        RadioButton radioButton53 = fragmentTeacherSurveyQuestionsBinding111 != null ? fragmentTeacherSurveyQuestionsBinding111.option2 : null;
                        if (radioButton53 != null) {
                            radioButton53.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding112 = this$0.get_binding();
                        RadioButton radioButton54 = fragmentTeacherSurveyQuestionsBinding112 != null ? fragmentTeacherSurveyQuestionsBinding112.option3 : null;
                        if (radioButton54 != null) {
                            radioButton54.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding113 = this$0.get_binding();
                        RadioButton radioButton55 = fragmentTeacherSurveyQuestionsBinding113 != null ? fragmentTeacherSurveyQuestionsBinding113.option4 : null;
                        if (radioButton55 != null) {
                            radioButton55.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding114 = this$0.get_binding();
                        RadioButton radioButton56 = fragmentTeacherSurveyQuestionsBinding114 != null ? fragmentTeacherSurveyQuestionsBinding114.option5 : null;
                        if (radioButton56 != null) {
                            radioButton56.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding115 = this$0.get_binding();
                        RadioButton radioButton57 = fragmentTeacherSurveyQuestionsBinding115 != null ? fragmentTeacherSurveyQuestionsBinding115.option1 : null;
                        if (radioButton57 != null) {
                            ArrayList<SurveyQuestion> arrayList39 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList39);
                            ArrayList<String> option23 = arrayList39.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option23);
                            String str17 = option23.get(0);
                            Intrinsics.checkNotNullExpressionValue(str17, "surveyResponse!![i].option!![0]");
                            radioButton57.setText(this$0.convertHtmlToString(str17));
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding116 = this$0.get_binding();
                        RadioButton radioButton58 = fragmentTeacherSurveyQuestionsBinding116 != null ? fragmentTeacherSurveyQuestionsBinding116.option2 : null;
                        if (radioButton58 != null) {
                            ArrayList<SurveyQuestion> arrayList40 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList40);
                            ArrayList<String> option24 = arrayList40.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option24);
                            String str18 = option24.get(1);
                            Intrinsics.checkNotNullExpressionValue(str18, "surveyResponse!![i].option!![1]");
                            radioButton58.setText(this$0.convertHtmlToString(str18));
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding117 = this$0.get_binding();
                        RadioButton radioButton59 = fragmentTeacherSurveyQuestionsBinding117 != null ? fragmentTeacherSurveyQuestionsBinding117.option3 : null;
                        if (radioButton59 != null) {
                            ArrayList<SurveyQuestion> arrayList41 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList41);
                            ArrayList<String> option25 = arrayList41.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option25);
                            String str19 = option25.get(2);
                            Intrinsics.checkNotNullExpressionValue(str19, "surveyResponse!![i].option!![2]");
                            radioButton59.setText(this$0.convertHtmlToString(str19));
                        }
                    } else {
                        ArrayList<SurveyQuestion> arrayList42 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList42);
                        ArrayList<String> option26 = arrayList42.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option26);
                        if (option26.size() == 4) {
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding118 = this$0.get_binding();
                            RadioButton radioButton60 = fragmentTeacherSurveyQuestionsBinding118 != null ? fragmentTeacherSurveyQuestionsBinding118.option1 : null;
                            if (radioButton60 != null) {
                                radioButton60.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding119 = this$0.get_binding();
                            RadioButton radioButton61 = fragmentTeacherSurveyQuestionsBinding119 != null ? fragmentTeacherSurveyQuestionsBinding119.option2 : null;
                            if (radioButton61 != null) {
                                radioButton61.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding120 = this$0.get_binding();
                            RadioButton radioButton62 = fragmentTeacherSurveyQuestionsBinding120 != null ? fragmentTeacherSurveyQuestionsBinding120.option3 : null;
                            if (radioButton62 != null) {
                                radioButton62.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding121 = this$0.get_binding();
                            RadioButton radioButton63 = fragmentTeacherSurveyQuestionsBinding121 != null ? fragmentTeacherSurveyQuestionsBinding121.option4 : null;
                            if (radioButton63 != null) {
                                radioButton63.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding122 = this$0.get_binding();
                            RadioButton radioButton64 = fragmentTeacherSurveyQuestionsBinding122 != null ? fragmentTeacherSurveyQuestionsBinding122.option5 : null;
                            if (radioButton64 != null) {
                                radioButton64.setVisibility(8);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding123 = this$0.get_binding();
                            RadioButton radioButton65 = fragmentTeacherSurveyQuestionsBinding123 != null ? fragmentTeacherSurveyQuestionsBinding123.option1 : null;
                            if (radioButton65 != null) {
                                ArrayList<SurveyQuestion> arrayList43 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList43);
                                ArrayList<String> option27 = arrayList43.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option27);
                                String str20 = option27.get(0);
                                Intrinsics.checkNotNullExpressionValue(str20, "surveyResponse!![i].option!![0]");
                                radioButton65.setText(this$0.convertHtmlToString(str20));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding124 = this$0.get_binding();
                            RadioButton radioButton66 = fragmentTeacherSurveyQuestionsBinding124 != null ? fragmentTeacherSurveyQuestionsBinding124.option2 : null;
                            if (radioButton66 != null) {
                                ArrayList<SurveyQuestion> arrayList44 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList44);
                                ArrayList<String> option28 = arrayList44.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option28);
                                String str21 = option28.get(1);
                                Intrinsics.checkNotNullExpressionValue(str21, "surveyResponse!![i].option!![1]");
                                radioButton66.setText(this$0.convertHtmlToString(str21));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding125 = this$0.get_binding();
                            RadioButton radioButton67 = fragmentTeacherSurveyQuestionsBinding125 != null ? fragmentTeacherSurveyQuestionsBinding125.option3 : null;
                            if (radioButton67 != null) {
                                ArrayList<SurveyQuestion> arrayList45 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList45);
                                ArrayList<String> option29 = arrayList45.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option29);
                                String str22 = option29.get(2);
                                Intrinsics.checkNotNullExpressionValue(str22, "surveyResponse!![i].option!![2]");
                                radioButton67.setText(this$0.convertHtmlToString(str22));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding126 = this$0.get_binding();
                            RadioButton radioButton68 = fragmentTeacherSurveyQuestionsBinding126 != null ? fragmentTeacherSurveyQuestionsBinding126.option4 : null;
                            if (radioButton68 != null) {
                                ArrayList<SurveyQuestion> arrayList46 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList46);
                                ArrayList<String> option30 = arrayList46.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option30);
                                String str23 = option30.get(3);
                                Intrinsics.checkNotNullExpressionValue(str23, "surveyResponse!![i].option!![3]");
                                radioButton68.setText(this$0.convertHtmlToString(str23));
                            }
                        } else {
                            ArrayList<SurveyQuestion> arrayList47 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList47);
                            ArrayList<String> option31 = arrayList47.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option31);
                            if (option31.size() == 5) {
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding127 = this$0.get_binding();
                                RadioButton radioButton69 = fragmentTeacherSurveyQuestionsBinding127 != null ? fragmentTeacherSurveyQuestionsBinding127.option1 : null;
                                if (radioButton69 != null) {
                                    radioButton69.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding128 = this$0.get_binding();
                                RadioButton radioButton70 = fragmentTeacherSurveyQuestionsBinding128 != null ? fragmentTeacherSurveyQuestionsBinding128.option2 : null;
                                if (radioButton70 != null) {
                                    radioButton70.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding129 = this$0.get_binding();
                                RadioButton radioButton71 = fragmentTeacherSurveyQuestionsBinding129 != null ? fragmentTeacherSurveyQuestionsBinding129.option3 : null;
                                if (radioButton71 != null) {
                                    radioButton71.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding130 = this$0.get_binding();
                                RadioButton radioButton72 = fragmentTeacherSurveyQuestionsBinding130 != null ? fragmentTeacherSurveyQuestionsBinding130.option4 : null;
                                if (radioButton72 != null) {
                                    radioButton72.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding131 = this$0.get_binding();
                                RadioButton radioButton73 = fragmentTeacherSurveyQuestionsBinding131 != null ? fragmentTeacherSurveyQuestionsBinding131.option5 : null;
                                if (radioButton73 != null) {
                                    radioButton73.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding132 = this$0.get_binding();
                                RadioButton radioButton74 = fragmentTeacherSurveyQuestionsBinding132 != null ? fragmentTeacherSurveyQuestionsBinding132.option1 : null;
                                if (radioButton74 != null) {
                                    ArrayList<SurveyQuestion> arrayList48 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList48);
                                    ArrayList<String> option32 = arrayList48.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option32);
                                    String str24 = option32.get(0);
                                    Intrinsics.checkNotNullExpressionValue(str24, "surveyResponse!![i].option!![0]");
                                    radioButton74.setText(this$0.convertHtmlToString(str24));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding133 = this$0.get_binding();
                                RadioButton radioButton75 = fragmentTeacherSurveyQuestionsBinding133 != null ? fragmentTeacherSurveyQuestionsBinding133.option2 : null;
                                if (radioButton75 != null) {
                                    ArrayList<SurveyQuestion> arrayList49 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList49);
                                    ArrayList<String> option33 = arrayList49.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option33);
                                    String str25 = option33.get(1);
                                    Intrinsics.checkNotNullExpressionValue(str25, "surveyResponse!![i].option!![1]");
                                    radioButton75.setText(this$0.convertHtmlToString(str25));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding134 = this$0.get_binding();
                                RadioButton radioButton76 = fragmentTeacherSurveyQuestionsBinding134 != null ? fragmentTeacherSurveyQuestionsBinding134.option3 : null;
                                if (radioButton76 != null) {
                                    ArrayList<SurveyQuestion> arrayList50 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList50);
                                    ArrayList<String> option34 = arrayList50.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option34);
                                    String str26 = option34.get(2);
                                    Intrinsics.checkNotNullExpressionValue(str26, "surveyResponse!![i].option!![2]");
                                    radioButton76.setText(this$0.convertHtmlToString(str26));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding135 = this$0.get_binding();
                                RadioButton radioButton77 = fragmentTeacherSurveyQuestionsBinding135 != null ? fragmentTeacherSurveyQuestionsBinding135.option4 : null;
                                if (radioButton77 != null) {
                                    ArrayList<SurveyQuestion> arrayList51 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList51);
                                    ArrayList<String> option35 = arrayList51.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option35);
                                    String str27 = option35.get(3);
                                    Intrinsics.checkNotNullExpressionValue(str27, "surveyResponse!![i].option!![3]");
                                    radioButton77.setText(this$0.convertHtmlToString(str27));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding136 = this$0.get_binding();
                                RadioButton radioButton78 = fragmentTeacherSurveyQuestionsBinding136 != null ? fragmentTeacherSurveyQuestionsBinding136.option5 : null;
                                if (radioButton78 != null) {
                                    ArrayList<SurveyQuestion> arrayList52 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList52);
                                    ArrayList<String> option36 = arrayList52.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option36);
                                    String str28 = option36.get(4);
                                    Intrinsics.checkNotNullExpressionValue(str28, "surveyResponse!![i].option!![4]");
                                    radioButton78.setText(this$0.convertHtmlToString(str28));
                                }
                            }
                        }
                    }
                }
            } else {
                ArrayList<SurveyQuestion> arrayList53 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList53);
                if (Intrinsics.areEqual(arrayList53.get(this$0.i).getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                    if (!Intrinsics.areEqual(this$0.surveyAnswers.get(this$0.i), "")) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding137 = this$0.get_binding();
                        if (fragmentTeacherSurveyQuestionsBinding137 != null && (textInputEditText2 = fragmentTeacherSurveyQuestionsBinding137.etDescriptive) != null) {
                            textInputEditText2.setText(this$0.surveyAnswers.get(this$0.i));
                            Unit unit7 = Unit.INSTANCE;
                        }
                    } else {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding138 = this$0.get_binding();
                        if (fragmentTeacherSurveyQuestionsBinding138 != null && (textInputEditText = fragmentTeacherSurveyQuestionsBinding138.etDescriptive) != null) {
                            textInputEditText.setText("");
                            Unit unit8 = Unit.INSTANCE;
                        }
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding139 = this$0.get_binding();
                    TextView textView33 = fragmentTeacherSurveyQuestionsBinding139 != null ? fragmentTeacherSurveyQuestionsBinding139.teacherSurveyQuestionNo : null;
                    if (textView33 != null) {
                        textView33.setText("Question " + (this$0.i + 1) + " (Descriptive)");
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding140 = this$0.get_binding();
                    LinearLayout linearLayout11 = fragmentTeacherSurveyQuestionsBinding140 != null ? fragmentTeacherSurveyQuestionsBinding140.descriptiveAnswerLyt : null;
                    if (linearLayout11 != null) {
                        linearLayout11.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding141 = this$0.get_binding();
                    LinearLayout linearLayout12 = fragmentTeacherSurveyQuestionsBinding141 != null ? fragmentTeacherSurveyQuestionsBinding141.multipleAnswerLyt : null;
                    if (linearLayout12 != null) {
                        linearLayout12.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding142 = this$0.get_binding();
                    TextView textView34 = fragmentTeacherSurveyQuestionsBinding142 != null ? fragmentTeacherSurveyQuestionsBinding142.teacherSurveyQuestion : null;
                    if (textView34 != null) {
                        ArrayList<SurveyQuestion> arrayList54 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList54);
                        String question6 = arrayList54.get(this$0.i).getQuestion();
                        Intrinsics.checkNotNull(question6);
                        textView34.setText("Q ) " + this$0.convertHtmlToString(question6));
                    }
                }
            }
        }
        System.out.println((Object) "yo");
        System.out.println(this$0.i);
        System.out.println((Object) "yo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0456, code lost:
    
        if ((r2.size() - 2) != 1) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x004e, code lost:
    
        if ((r2.size() - 2) != 1) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void setUp$lambda$4(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment r16, android.view.View r17) {
        /*
            Method dump skipped, instructions count: 2239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.setUp$lambda$4(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment, android.view.View):void");
    }

    private final void listenResponse() {
        getTeacherSurveyQuestionViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherSurveyQuestionFragment.listenResponse$lambda$6(TeacherSurveyQuestionFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(TeacherSurveyQuestionFragment this$0, Resource resource) {
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
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = this$0.get_binding();
            if (fragmentTeacherSurveyQuestionsBinding == null || (textView = fragmentTeacherSurveyQuestionsBinding.finishBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            Unit unit = Unit.INSTANCE;
            return;
        }
        this$0.hideProgress();
        ArrayList<SurveyQuestion> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.showBaseView();
            this$0.surveyResponse = arrayList;
            System.out.println(arrayList);
            if (!Intrinsics.areEqual(this$0.teacherId, "")) {
                int size = arrayList.size() - 2;
                for (int i2 = 0; i2 < size; i2++) {
                    this$0.surveyAnswers.add(i2, "");
                    if (Intrinsics.areEqual(arrayList.get(i2).getRequired(), "true")) {
                        this$0.mandatoryQuestions.add(i2, "true");
                    } else {
                        this$0.mandatoryQuestions.add(i2, "false");
                    }
                    this$0.attendedOrNot.add(i2, "NOT");
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = this$0.get_binding();
                TextView textView2 = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.questionTv : null;
                if (textView2 != null) {
                    int i3 = this$0.i + 1;
                    ArrayList<SurveyQuestion> arrayList2 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList2);
                    textView2.setText(i3 + RemoteSettings.FORWARD_SLASH_STRING + (arrayList2.size() - 2));
                }
            } else {
                int size2 = arrayList.size() - 1;
                for (int i4 = 0; i4 < size2; i4++) {
                    this$0.surveyAnswers.add(i4, "");
                    if (Intrinsics.areEqual(arrayList.get(i4).getRequired(), "true")) {
                        this$0.mandatoryQuestions.add(i4, "true");
                    } else {
                        this$0.mandatoryQuestions.add(i4, "false");
                    }
                    this$0.attendedOrNot.add(i4, "NOT");
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = this$0.get_binding();
                TextView textView3 = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.questionTv : null;
                if (textView3 != null) {
                    int i5 = this$0.i + 1;
                    ArrayList<SurveyQuestion> arrayList3 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList3);
                    textView3.setText(i5 + RemoteSettings.FORWARD_SLASH_STRING + (arrayList3.size() - 1));
                }
            }
            this$0.getAdapter().addItems(this$0.surveyAnswers, 0, this$0.mandatoryQuestions, this$0.attendedOrNot, 0);
            ArrayList<SurveyQuestion> arrayList4 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList4);
            String required = arrayList4.get(this$0.i).getRequired();
            Intrinsics.checkNotNull(required);
            if (Intrinsics.areEqual(required, "true")) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = this$0.get_binding();
                TextView textView4 = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.requiredTv : null;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            } else {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = this$0.get_binding();
                TextView textView5 = fragmentTeacherSurveyQuestionsBinding5 != null ? fragmentTeacherSurveyQuestionsBinding5.requiredTv : null;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = this$0.get_binding();
            TextView textView6 = fragmentTeacherSurveyQuestionsBinding6 != null ? fragmentTeacherSurveyQuestionsBinding6.teacherSurveyQuestion : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = this$0.get_binding();
            TextView textView7 = fragmentTeacherSurveyQuestionsBinding7 != null ? fragmentTeacherSurveyQuestionsBinding7.teacherSurveyQuestion : null;
            if (textView7 != null) {
                ArrayList<SurveyQuestion> arrayList5 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList5);
                String question = arrayList5.get(this$0.i).getQuestion();
                Intrinsics.checkNotNull(question);
                textView7.setText("Q ) " + this$0.convertHtmlToString(question));
            }
            ArrayList<SurveyQuestion> arrayList6 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList6);
            if (Intrinsics.areEqual(arrayList6.get(this$0.i).getType(), "1")) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = this$0.get_binding();
                TextView textView8 = fragmentTeacherSurveyQuestionsBinding8 != null ? fragmentTeacherSurveyQuestionsBinding8.teacherSurveyQuestionNo : null;
                if (textView8 != null) {
                    textView8.setText("Question " + (this$0.i + 1) + " (Multiple Choice Question)");
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding9 = this$0.get_binding();
                LinearLayout linearLayout = fragmentTeacherSurveyQuestionsBinding9 != null ? fragmentTeacherSurveyQuestionsBinding9.descriptiveAnswerLyt : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding10 = this$0.get_binding();
                LinearLayout linearLayout2 = fragmentTeacherSurveyQuestionsBinding10 != null ? fragmentTeacherSurveyQuestionsBinding10.multipleAnswerLyt : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                ArrayList<SurveyQuestion> arrayList7 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList7);
                ArrayList<String> option = arrayList7.get(this$0.i).getOption();
                Intrinsics.checkNotNull(option);
                if (option.size() == 2) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding11 = this$0.get_binding();
                    RadioButton radioButton = fragmentTeacherSurveyQuestionsBinding11 != null ? fragmentTeacherSurveyQuestionsBinding11.option1 : null;
                    if (radioButton != null) {
                        radioButton.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding12 = this$0.get_binding();
                    RadioButton radioButton2 = fragmentTeacherSurveyQuestionsBinding12 != null ? fragmentTeacherSurveyQuestionsBinding12.option2 : null;
                    if (radioButton2 != null) {
                        radioButton2.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding13 = this$0.get_binding();
                    RadioButton radioButton3 = fragmentTeacherSurveyQuestionsBinding13 != null ? fragmentTeacherSurveyQuestionsBinding13.option3 : null;
                    if (radioButton3 != null) {
                        radioButton3.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding14 = this$0.get_binding();
                    RadioButton radioButton4 = fragmentTeacherSurveyQuestionsBinding14 != null ? fragmentTeacherSurveyQuestionsBinding14.option4 : null;
                    if (radioButton4 != null) {
                        radioButton4.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding15 = this$0.get_binding();
                    RadioButton radioButton5 = fragmentTeacherSurveyQuestionsBinding15 != null ? fragmentTeacherSurveyQuestionsBinding15.option5 : null;
                    if (radioButton5 != null) {
                        radioButton5.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding16 = this$0.get_binding();
                    RadioButton radioButton6 = fragmentTeacherSurveyQuestionsBinding16 != null ? fragmentTeacherSurveyQuestionsBinding16.option6 : null;
                    if (radioButton6 != null) {
                        radioButton6.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding17 = this$0.get_binding();
                    RadioButton radioButton7 = fragmentTeacherSurveyQuestionsBinding17 != null ? fragmentTeacherSurveyQuestionsBinding17.option1 : null;
                    if (radioButton7 != null) {
                        ArrayList<SurveyQuestion> arrayList8 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList8);
                        ArrayList<String> option2 = arrayList8.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option2);
                        String str = option2.get(0);
                        Intrinsics.checkNotNullExpressionValue(str, "surveyResponse!![i].option!![0]");
                        radioButton7.setText(this$0.convertHtmlToString(str));
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding18 = this$0.get_binding();
                    RadioButton radioButton8 = fragmentTeacherSurveyQuestionsBinding18 != null ? fragmentTeacherSurveyQuestionsBinding18.option2 : null;
                    if (radioButton8 != null) {
                        ArrayList<SurveyQuestion> arrayList9 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList9);
                        ArrayList<String> option3 = arrayList9.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option3);
                        String str2 = option3.get(1);
                        Intrinsics.checkNotNullExpressionValue(str2, "surveyResponse!![i].option!![1]");
                        radioButton8.setText(this$0.convertHtmlToString(str2));
                    }
                } else {
                    ArrayList<SurveyQuestion> arrayList10 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList10);
                    ArrayList<String> option4 = arrayList10.get(this$0.i).getOption();
                    Intrinsics.checkNotNull(option4);
                    if (option4.size() == 3) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding19 = this$0.get_binding();
                        RadioButton radioButton9 = fragmentTeacherSurveyQuestionsBinding19 != null ? fragmentTeacherSurveyQuestionsBinding19.option1 : null;
                        if (radioButton9 != null) {
                            radioButton9.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding20 = this$0.get_binding();
                        RadioButton radioButton10 = fragmentTeacherSurveyQuestionsBinding20 != null ? fragmentTeacherSurveyQuestionsBinding20.option2 : null;
                        if (radioButton10 != null) {
                            radioButton10.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding21 = this$0.get_binding();
                        RadioButton radioButton11 = fragmentTeacherSurveyQuestionsBinding21 != null ? fragmentTeacherSurveyQuestionsBinding21.option3 : null;
                        if (radioButton11 != null) {
                            radioButton11.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding22 = this$0.get_binding();
                        RadioButton radioButton12 = fragmentTeacherSurveyQuestionsBinding22 != null ? fragmentTeacherSurveyQuestionsBinding22.option4 : null;
                        if (radioButton12 != null) {
                            radioButton12.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding23 = this$0.get_binding();
                        RadioButton radioButton13 = fragmentTeacherSurveyQuestionsBinding23 != null ? fragmentTeacherSurveyQuestionsBinding23.option5 : null;
                        if (radioButton13 != null) {
                            radioButton13.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding24 = this$0.get_binding();
                        RadioButton radioButton14 = fragmentTeacherSurveyQuestionsBinding24 != null ? fragmentTeacherSurveyQuestionsBinding24.option6 : null;
                        if (radioButton14 != null) {
                            radioButton14.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding25 = this$0.get_binding();
                        RadioButton radioButton15 = fragmentTeacherSurveyQuestionsBinding25 != null ? fragmentTeacherSurveyQuestionsBinding25.option1 : null;
                        if (radioButton15 != null) {
                            ArrayList<SurveyQuestion> arrayList11 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList11);
                            ArrayList<String> option5 = arrayList11.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option5);
                            String str3 = option5.get(0);
                            Intrinsics.checkNotNullExpressionValue(str3, "surveyResponse!![i].option!![0]");
                            radioButton15.setText(this$0.convertHtmlToString(str3));
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding26 = this$0.get_binding();
                        RadioButton radioButton16 = fragmentTeacherSurveyQuestionsBinding26 != null ? fragmentTeacherSurveyQuestionsBinding26.option2 : null;
                        if (radioButton16 != null) {
                            ArrayList<SurveyQuestion> arrayList12 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList12);
                            ArrayList<String> option6 = arrayList12.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option6);
                            String str4 = option6.get(1);
                            Intrinsics.checkNotNullExpressionValue(str4, "surveyResponse!![i].option!![1]");
                            radioButton16.setText(this$0.convertHtmlToString(str4));
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding27 = this$0.get_binding();
                        RadioButton radioButton17 = fragmentTeacherSurveyQuestionsBinding27 != null ? fragmentTeacherSurveyQuestionsBinding27.option3 : null;
                        if (radioButton17 != null) {
                            ArrayList<SurveyQuestion> arrayList13 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList13);
                            ArrayList<String> option7 = arrayList13.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option7);
                            String str5 = option7.get(2);
                            Intrinsics.checkNotNullExpressionValue(str5, "surveyResponse!![i].option!![2]");
                            radioButton17.setText(this$0.convertHtmlToString(str5));
                        }
                    } else {
                        ArrayList<SurveyQuestion> arrayList14 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList14);
                        ArrayList<String> option8 = arrayList14.get(this$0.i).getOption();
                        Intrinsics.checkNotNull(option8);
                        if (option8.size() == 4) {
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding28 = this$0.get_binding();
                            RadioButton radioButton18 = fragmentTeacherSurveyQuestionsBinding28 != null ? fragmentTeacherSurveyQuestionsBinding28.option1 : null;
                            if (radioButton18 != null) {
                                radioButton18.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding29 = this$0.get_binding();
                            RadioButton radioButton19 = fragmentTeacherSurveyQuestionsBinding29 != null ? fragmentTeacherSurveyQuestionsBinding29.option2 : null;
                            if (radioButton19 != null) {
                                radioButton19.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding30 = this$0.get_binding();
                            RadioButton radioButton20 = fragmentTeacherSurveyQuestionsBinding30 != null ? fragmentTeacherSurveyQuestionsBinding30.option3 : null;
                            if (radioButton20 != null) {
                                radioButton20.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding31 = this$0.get_binding();
                            RadioButton radioButton21 = fragmentTeacherSurveyQuestionsBinding31 != null ? fragmentTeacherSurveyQuestionsBinding31.option4 : null;
                            if (radioButton21 != null) {
                                radioButton21.setVisibility(0);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding32 = this$0.get_binding();
                            RadioButton radioButton22 = fragmentTeacherSurveyQuestionsBinding32 != null ? fragmentTeacherSurveyQuestionsBinding32.option5 : null;
                            if (radioButton22 != null) {
                                radioButton22.setVisibility(8);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding33 = this$0.get_binding();
                            RadioButton radioButton23 = fragmentTeacherSurveyQuestionsBinding33 != null ? fragmentTeacherSurveyQuestionsBinding33.option6 : null;
                            if (radioButton23 != null) {
                                radioButton23.setVisibility(8);
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding34 = this$0.get_binding();
                            RadioButton radioButton24 = fragmentTeacherSurveyQuestionsBinding34 != null ? fragmentTeacherSurveyQuestionsBinding34.option1 : null;
                            if (radioButton24 != null) {
                                ArrayList<SurveyQuestion> arrayList15 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList15);
                                ArrayList<String> option9 = arrayList15.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option9);
                                String str6 = option9.get(0);
                                Intrinsics.checkNotNullExpressionValue(str6, "surveyResponse!![i].option!![0]");
                                radioButton24.setText(this$0.convertHtmlToString(str6));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding35 = this$0.get_binding();
                            RadioButton radioButton25 = fragmentTeacherSurveyQuestionsBinding35 != null ? fragmentTeacherSurveyQuestionsBinding35.option2 : null;
                            if (radioButton25 != null) {
                                ArrayList<SurveyQuestion> arrayList16 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList16);
                                ArrayList<String> option10 = arrayList16.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option10);
                                String str7 = option10.get(1);
                                Intrinsics.checkNotNullExpressionValue(str7, "surveyResponse!![i].option!![1]");
                                radioButton25.setText(this$0.convertHtmlToString(str7));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding36 = this$0.get_binding();
                            RadioButton radioButton26 = fragmentTeacherSurveyQuestionsBinding36 != null ? fragmentTeacherSurveyQuestionsBinding36.option3 : null;
                            if (radioButton26 != null) {
                                ArrayList<SurveyQuestion> arrayList17 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList17);
                                ArrayList<String> option11 = arrayList17.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option11);
                                String str8 = option11.get(2);
                                Intrinsics.checkNotNullExpressionValue(str8, "surveyResponse!![i].option!![2]");
                                radioButton26.setText(this$0.convertHtmlToString(str8));
                            }
                            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding37 = this$0.get_binding();
                            RadioButton radioButton27 = fragmentTeacherSurveyQuestionsBinding37 != null ? fragmentTeacherSurveyQuestionsBinding37.option4 : null;
                            if (radioButton27 != null) {
                                ArrayList<SurveyQuestion> arrayList18 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList18);
                                ArrayList<String> option12 = arrayList18.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option12);
                                String str9 = option12.get(3);
                                Intrinsics.checkNotNullExpressionValue(str9, "surveyResponse!![i].option!![3]");
                                radioButton27.setText(this$0.convertHtmlToString(str9));
                            }
                        } else {
                            ArrayList<SurveyQuestion> arrayList19 = this$0.surveyResponse;
                            Intrinsics.checkNotNull(arrayList19);
                            ArrayList<String> option13 = arrayList19.get(this$0.i).getOption();
                            Intrinsics.checkNotNull(option13);
                            if (option13.size() == 5) {
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding38 = this$0.get_binding();
                                RadioButton radioButton28 = fragmentTeacherSurveyQuestionsBinding38 != null ? fragmentTeacherSurveyQuestionsBinding38.option1 : null;
                                if (radioButton28 != null) {
                                    radioButton28.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding39 = this$0.get_binding();
                                RadioButton radioButton29 = fragmentTeacherSurveyQuestionsBinding39 != null ? fragmentTeacherSurveyQuestionsBinding39.option2 : null;
                                if (radioButton29 != null) {
                                    radioButton29.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding40 = this$0.get_binding();
                                RadioButton radioButton30 = fragmentTeacherSurveyQuestionsBinding40 != null ? fragmentTeacherSurveyQuestionsBinding40.option3 : null;
                                if (radioButton30 != null) {
                                    radioButton30.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding41 = this$0.get_binding();
                                RadioButton radioButton31 = fragmentTeacherSurveyQuestionsBinding41 != null ? fragmentTeacherSurveyQuestionsBinding41.option4 : null;
                                if (radioButton31 != null) {
                                    radioButton31.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding42 = this$0.get_binding();
                                RadioButton radioButton32 = fragmentTeacherSurveyQuestionsBinding42 != null ? fragmentTeacherSurveyQuestionsBinding42.option5 : null;
                                if (radioButton32 != null) {
                                    radioButton32.setVisibility(0);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding43 = this$0.get_binding();
                                RadioButton radioButton33 = fragmentTeacherSurveyQuestionsBinding43 != null ? fragmentTeacherSurveyQuestionsBinding43.option6 : null;
                                if (radioButton33 != null) {
                                    radioButton33.setVisibility(8);
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding44 = this$0.get_binding();
                                RadioButton radioButton34 = fragmentTeacherSurveyQuestionsBinding44 != null ? fragmentTeacherSurveyQuestionsBinding44.option1 : null;
                                if (radioButton34 != null) {
                                    ArrayList<SurveyQuestion> arrayList20 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList20);
                                    ArrayList<String> option14 = arrayList20.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option14);
                                    String str10 = option14.get(0);
                                    Intrinsics.checkNotNullExpressionValue(str10, "surveyResponse!![i].option!![0]");
                                    radioButton34.setText(this$0.convertHtmlToString(str10));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding45 = this$0.get_binding();
                                RadioButton radioButton35 = fragmentTeacherSurveyQuestionsBinding45 != null ? fragmentTeacherSurveyQuestionsBinding45.option2 : null;
                                if (radioButton35 != null) {
                                    ArrayList<SurveyQuestion> arrayList21 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList21);
                                    ArrayList<String> option15 = arrayList21.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option15);
                                    String str11 = option15.get(1);
                                    Intrinsics.checkNotNullExpressionValue(str11, "surveyResponse!![i].option!![1]");
                                    radioButton35.setText(this$0.convertHtmlToString(str11));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding46 = this$0.get_binding();
                                RadioButton radioButton36 = fragmentTeacherSurveyQuestionsBinding46 != null ? fragmentTeacherSurveyQuestionsBinding46.option3 : null;
                                if (radioButton36 != null) {
                                    ArrayList<SurveyQuestion> arrayList22 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList22);
                                    ArrayList<String> option16 = arrayList22.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option16);
                                    String str12 = option16.get(2);
                                    Intrinsics.checkNotNullExpressionValue(str12, "surveyResponse!![i].option!![2]");
                                    radioButton36.setText(this$0.convertHtmlToString(str12));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding47 = this$0.get_binding();
                                RadioButton radioButton37 = fragmentTeacherSurveyQuestionsBinding47 != null ? fragmentTeacherSurveyQuestionsBinding47.option4 : null;
                                if (radioButton37 != null) {
                                    ArrayList<SurveyQuestion> arrayList23 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList23);
                                    ArrayList<String> option17 = arrayList23.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option17);
                                    String str13 = option17.get(3);
                                    Intrinsics.checkNotNullExpressionValue(str13, "surveyResponse!![i].option!![3]");
                                    radioButton37.setText(this$0.convertHtmlToString(str13));
                                }
                                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding48 = this$0.get_binding();
                                RadioButton radioButton38 = fragmentTeacherSurveyQuestionsBinding48 != null ? fragmentTeacherSurveyQuestionsBinding48.option5 : null;
                                if (radioButton38 != null) {
                                    ArrayList<SurveyQuestion> arrayList24 = this$0.surveyResponse;
                                    Intrinsics.checkNotNull(arrayList24);
                                    ArrayList<String> option18 = arrayList24.get(this$0.i).getOption();
                                    Intrinsics.checkNotNull(option18);
                                    String str14 = option18.get(4);
                                    Intrinsics.checkNotNullExpressionValue(str14, "surveyResponse!![i].option!![4]");
                                    radioButton38.setText(this$0.convertHtmlToString(str14));
                                }
                            } else {
                                ArrayList<SurveyQuestion> arrayList25 = this$0.surveyResponse;
                                Intrinsics.checkNotNull(arrayList25);
                                ArrayList<String> option19 = arrayList25.get(this$0.i).getOption();
                                Intrinsics.checkNotNull(option19);
                                if (option19.size() == 6) {
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding49 = this$0.get_binding();
                                    RadioButton radioButton39 = fragmentTeacherSurveyQuestionsBinding49 != null ? fragmentTeacherSurveyQuestionsBinding49.option1 : null;
                                    if (radioButton39 != null) {
                                        radioButton39.setVisibility(0);
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding50 = this$0.get_binding();
                                    RadioButton radioButton40 = fragmentTeacherSurveyQuestionsBinding50 != null ? fragmentTeacherSurveyQuestionsBinding50.option2 : null;
                                    if (radioButton40 != null) {
                                        radioButton40.setVisibility(0);
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding51 = this$0.get_binding();
                                    RadioButton radioButton41 = fragmentTeacherSurveyQuestionsBinding51 != null ? fragmentTeacherSurveyQuestionsBinding51.option3 : null;
                                    if (radioButton41 != null) {
                                        radioButton41.setVisibility(0);
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding52 = this$0.get_binding();
                                    RadioButton radioButton42 = fragmentTeacherSurveyQuestionsBinding52 != null ? fragmentTeacherSurveyQuestionsBinding52.option4 : null;
                                    if (radioButton42 != null) {
                                        radioButton42.setVisibility(0);
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding53 = this$0.get_binding();
                                    RadioButton radioButton43 = fragmentTeacherSurveyQuestionsBinding53 != null ? fragmentTeacherSurveyQuestionsBinding53.option5 : null;
                                    if (radioButton43 != null) {
                                        radioButton43.setVisibility(0);
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding54 = this$0.get_binding();
                                    RadioButton radioButton44 = fragmentTeacherSurveyQuestionsBinding54 != null ? fragmentTeacherSurveyQuestionsBinding54.option6 : null;
                                    if (radioButton44 != null) {
                                        radioButton44.setVisibility(0);
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding55 = this$0.get_binding();
                                    RadioButton radioButton45 = fragmentTeacherSurveyQuestionsBinding55 != null ? fragmentTeacherSurveyQuestionsBinding55.option1 : null;
                                    if (radioButton45 != null) {
                                        ArrayList<SurveyQuestion> arrayList26 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList26);
                                        ArrayList<String> option20 = arrayList26.get(this$0.i).getOption();
                                        Intrinsics.checkNotNull(option20);
                                        String str15 = option20.get(0);
                                        Intrinsics.checkNotNullExpressionValue(str15, "surveyResponse!![i].option!![0]");
                                        radioButton45.setText(this$0.convertHtmlToString(str15));
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding56 = this$0.get_binding();
                                    RadioButton radioButton46 = fragmentTeacherSurveyQuestionsBinding56 != null ? fragmentTeacherSurveyQuestionsBinding56.option2 : null;
                                    if (radioButton46 != null) {
                                        ArrayList<SurveyQuestion> arrayList27 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList27);
                                        ArrayList<String> option21 = arrayList27.get(this$0.i).getOption();
                                        Intrinsics.checkNotNull(option21);
                                        String str16 = option21.get(1);
                                        Intrinsics.checkNotNullExpressionValue(str16, "surveyResponse!![i].option!![1]");
                                        radioButton46.setText(this$0.convertHtmlToString(str16));
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding57 = this$0.get_binding();
                                    RadioButton radioButton47 = fragmentTeacherSurveyQuestionsBinding57 != null ? fragmentTeacherSurveyQuestionsBinding57.option3 : null;
                                    if (radioButton47 != null) {
                                        ArrayList<SurveyQuestion> arrayList28 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList28);
                                        ArrayList<String> option22 = arrayList28.get(this$0.i).getOption();
                                        Intrinsics.checkNotNull(option22);
                                        String str17 = option22.get(2);
                                        Intrinsics.checkNotNullExpressionValue(str17, "surveyResponse!![i].option!![2]");
                                        radioButton47.setText(this$0.convertHtmlToString(str17));
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding58 = this$0.get_binding();
                                    RadioButton radioButton48 = fragmentTeacherSurveyQuestionsBinding58 != null ? fragmentTeacherSurveyQuestionsBinding58.option4 : null;
                                    if (radioButton48 != null) {
                                        ArrayList<SurveyQuestion> arrayList29 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList29);
                                        ArrayList<String> option23 = arrayList29.get(this$0.i).getOption();
                                        Intrinsics.checkNotNull(option23);
                                        String str18 = option23.get(3);
                                        Intrinsics.checkNotNullExpressionValue(str18, "surveyResponse!![i].option!![3]");
                                        radioButton48.setText(this$0.convertHtmlToString(str18));
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding59 = this$0.get_binding();
                                    RadioButton radioButton49 = fragmentTeacherSurveyQuestionsBinding59 != null ? fragmentTeacherSurveyQuestionsBinding59.option5 : null;
                                    if (radioButton49 != null) {
                                        ArrayList<SurveyQuestion> arrayList30 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList30);
                                        ArrayList<String> option24 = arrayList30.get(this$0.i).getOption();
                                        Intrinsics.checkNotNull(option24);
                                        String str19 = option24.get(4);
                                        Intrinsics.checkNotNullExpressionValue(str19, "surveyResponse!![i].option!![4]");
                                        radioButton49.setText(this$0.convertHtmlToString(str19));
                                    }
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding60 = this$0.get_binding();
                                    RadioButton radioButton50 = fragmentTeacherSurveyQuestionsBinding60 != null ? fragmentTeacherSurveyQuestionsBinding60.option6 : null;
                                    if (radioButton50 != null) {
                                        ArrayList<SurveyQuestion> arrayList31 = this$0.surveyResponse;
                                        Intrinsics.checkNotNull(arrayList31);
                                        ArrayList<String> option25 = arrayList31.get(this$0.i).getOption();
                                        Intrinsics.checkNotNull(option25);
                                        String str20 = option25.get(5);
                                        Intrinsics.checkNotNullExpressionValue(str20, "surveyResponse!![i].option!![5]");
                                        radioButton50.setText(this$0.convertHtmlToString(str20));
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                ArrayList<SurveyQuestion> arrayList32 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList32);
                if (Intrinsics.areEqual(arrayList32.get(this$0.i).getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding61 = this$0.get_binding();
                    TextView textView9 = fragmentTeacherSurveyQuestionsBinding61 != null ? fragmentTeacherSurveyQuestionsBinding61.teacherSurveyQuestionNo : null;
                    if (textView9 != null) {
                        textView9.setText("Question " + (this$0.i + 1) + " (Descriptive)");
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding62 = this$0.get_binding();
                    LinearLayout linearLayout3 = fragmentTeacherSurveyQuestionsBinding62 != null ? fragmentTeacherSurveyQuestionsBinding62.descriptiveAnswerLyt : null;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding63 = this$0.get_binding();
                    LinearLayout linearLayout4 = fragmentTeacherSurveyQuestionsBinding63 != null ? fragmentTeacherSurveyQuestionsBinding63.multipleAnswerLyt : null;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding64 = this$0.get_binding();
                    TextView textView10 = fragmentTeacherSurveyQuestionsBinding64 != null ? fragmentTeacherSurveyQuestionsBinding64.teacherSurveyQuestion : null;
                    if (textView10 != null) {
                        ArrayList<SurveyQuestion> arrayList33 = this$0.surveyResponse;
                        Intrinsics.checkNotNull(arrayList33);
                        String question2 = arrayList33.get(this$0.i).getQuestion();
                        Intrinsics.checkNotNull(question2);
                        textView10.setText("Q ) " + this$0.convertHtmlToString(question2));
                    }
                }
            }
            if (!Intrinsics.areEqual(this$0.teacherId, "")) {
                if (this$0.i == 0) {
                    ArrayList<SurveyQuestion> arrayList34 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList34);
                    if (arrayList34.size() - 2 == 1) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding65 = this$0.get_binding();
                        TextView textView11 = fragmentTeacherSurveyQuestionsBinding65 != null ? fragmentTeacherSurveyQuestionsBinding65.backBtn : null;
                        if (textView11 != null) {
                            textView11.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding66 = this$0.get_binding();
                        TextView textView12 = fragmentTeacherSurveyQuestionsBinding66 != null ? fragmentTeacherSurveyQuestionsBinding66.nextBtn : null;
                        if (textView12 != null) {
                            textView12.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding67 = this$0.get_binding();
                        TextView textView13 = fragmentTeacherSurveyQuestionsBinding67 != null ? fragmentTeacherSurveyQuestionsBinding67.questionTv : null;
                        if (textView13 != null) {
                            textView13.setVisibility(8);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding68 = this$0.get_binding();
                        TextView textView14 = fragmentTeacherSurveyQuestionsBinding68 != null ? fragmentTeacherSurveyQuestionsBinding68.finishBtn : null;
                        if (textView14 != null) {
                            textView14.setVisibility(0);
                        }
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding69 = this$0.get_binding();
                        LinearLayout linearLayout5 = fragmentTeacherSurveyQuestionsBinding69 != null ? fragmentTeacherSurveyQuestionsBinding69.finalQuestionsLyt : null;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(0);
                        }
                    }
                }
            } else if (this$0.i == 0) {
                ArrayList<SurveyQuestion> arrayList35 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList35);
                if (arrayList35.size() - 1 == 1) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding70 = this$0.get_binding();
                    TextView textView15 = fragmentTeacherSurveyQuestionsBinding70 != null ? fragmentTeacherSurveyQuestionsBinding70.backBtn : null;
                    if (textView15 != null) {
                        textView15.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding71 = this$0.get_binding();
                    TextView textView16 = fragmentTeacherSurveyQuestionsBinding71 != null ? fragmentTeacherSurveyQuestionsBinding71.nextBtn : null;
                    if (textView16 != null) {
                        textView16.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding72 = this$0.get_binding();
                    TextView textView17 = fragmentTeacherSurveyQuestionsBinding72 != null ? fragmentTeacherSurveyQuestionsBinding72.questionTv : null;
                    if (textView17 != null) {
                        textView17.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding73 = this$0.get_binding();
                    TextView textView18 = fragmentTeacherSurveyQuestionsBinding73 != null ? fragmentTeacherSurveyQuestionsBinding73.finishBtn : null;
                    if (textView18 != null) {
                        textView18.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding74 = this$0.get_binding();
                    LinearLayout linearLayout6 = fragmentTeacherSurveyQuestionsBinding74 != null ? fragmentTeacherSurveyQuestionsBinding74.finalQuestionsLyt : null;
                    if (linearLayout6 != null) {
                        linearLayout6.setVisibility(0);
                    }
                }
            }
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
        }
    }

    private final void listenAnswerResponse() {
        getTeacherSurveyQuestionViewModel().getSubmitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherSurveyQuestionFragment.listenAnswerResponse$lambda$8(TeacherSurveyQuestionFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAnswerResponse$lambda$8(TeacherSurveyQuestionFragment this$0, Resource resource) {
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
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = this$0.get_binding();
            if (fragmentTeacherSurveyQuestionsBinding == null || (textView = fragmentTeacherSurveyQuestionsBinding.finishBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        SubmitResponse submitResponse = (SubmitResponse) resource.getData();
        if (submitResponse != null) {
            this$0.showBaseView();
            if (Intrinsics.areEqual(submitResponse.getStatus(), "Success")) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = this$0.get_binding();
                if (fragmentTeacherSurveyQuestionsBinding2 != null && (finishBtn2 = fragmentTeacherSurveyQuestionsBinding2.finishBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(finishBtn2, "finishBtn");
                    ToastExtKt.showSuccessToast(finishBtn2, submitResponse.getResponse());
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.onSurveyCompleted(this$0.surveyFlag, this$0.id);
                    return;
                }
                return;
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = this$0.get_binding();
            if (fragmentTeacherSurveyQuestionsBinding3 == null || (finishBtn = fragmentTeacherSurveyQuestionsBinding3.finishBtn) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(finishBtn, "finishBtn");
            ToastExtKt.showErrorToast(finishBtn, submitResponse.getResponse());
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

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0389, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.get(r30).getType(), androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_2D) != false) goto L252;
     */
    @Override // in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter.SurveyCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doTheSurvey(java.lang.String r29, int r30) {
        /*
            Method dump skipped, instructions count: 5653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.doTheSurvey(java.lang.String, int):void");
    }
}