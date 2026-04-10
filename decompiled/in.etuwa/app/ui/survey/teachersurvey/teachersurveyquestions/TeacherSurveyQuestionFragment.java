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
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.SubmitResponse;
import in.etuwa.app.data.model.survey.SubmitTeacherResponse;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: TeacherSurveyQuestionFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TeacherSurveyQuestionFragment extends BaseFragment implements TeacherSurveyQuestionAdapter.SurveyCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTeacherSurveyQuestionsBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private final List<String> attendedOrNot;
    private boolean flag;
    private int i;
    private String id;
    private String image;
    private boolean isRestoringAnswer;
    private String lastDesc;
    private MainCallBackListener listener;
    private boolean mandatoryFlag;
    private final List<String> mandatoryQuestions;
    private String option;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
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
    private String teacherName;

    /* JADX INFO: renamed from: teacherSurveyQuestionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy teacherSurveyQuestionViewModel;

    /* JADX INFO: compiled from: TeacherSurveyQuestionFragment.kt */
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
    public static final TeacherSurveyQuestionFragment newInstance(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5, str6, z, str7);
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
                return teacherSurveyQuestionFragment;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(TeacherSurveyQuestionViewModel.class), qualifier, b, null, koinScope);
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
        this.teacherName = "";
    }

    private final TeacherSurveyQuestionViewModel getTeacherSurveyQuestionViewModel() {
        return (TeacherSurveyQuestionViewModel) this.teacherSurveyQuestionViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
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

    public final String getTeacherName() {
        return this.teacherName;
    }

    public final void setTeacherName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacherName = str;
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

    /* JADX INFO: compiled from: TeacherSurveyQuestionFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionFragment;", "id", "", "teacherId", "subjectId", SvgConstants.Tags.IMAGE, AttendanceDayDialogKt.ARG_SEM, "subject", "flag", "", "teacherName", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TeacherSurveyQuestionFragment newInstance(String id, String teacherId, String subjectId, String image, String semester, String subject, boolean flag, String teacherName) {
            Intrinsics.checkNotNullParameter(teacherName, "teacherName");
            TeacherSurveyQuestionFragment teacherSurveyQuestionFragment = new TeacherSurveyQuestionFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(ReplyDialogKt.ARG_SENDER_ID, teacherId);
            bundle.putString(CommentReplyDialogKt.ARG_SUB_ID, subjectId);
            bundle.putString(CommentReplyDialogKt.ARG_IMG, image);
            bundle.putString(AttendanceDayDialogKt.ARG_SEM, semester);
            bundle.putString("sub", subject);
            bundle.putBoolean("flag", flag);
            bundle.putString("date", teacherName);
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
            String string4 = arguments.getString("date");
            Intrinsics.checkNotNull(string4);
            this.teacherName = string4;
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

    private final void updateProgress() {
        ArrayList<SurveyQuestion> arrayList = this.surveyResponse;
        if (arrayList == null) {
            return;
        }
        boolean zAreEqual = Intrinsics.areEqual(this.teacherId, "");
        int size = arrayList.size();
        int i = !zAreEqual ? size - 2 : size - 1;
        if (i <= 0) {
            return;
        }
        int iCoerceIn = RangesKt.coerceIn((int) (((this.i + 1) / i) * 100), 0, 100);
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = get_binding();
        ProgressBar progressBar = fragmentTeacherSurveyQuestionsBinding != null ? fragmentTeacherSurveyQuestionsBinding.surveyProgress : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(iCoerceIn);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        MaterialButton materialButton3;
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
        getAdapter().setSurveyFlag(this.surveyFlag);
        getPreference().setNewLogin(false);
        listenResponse();
        listenAnswerResponse();
        if (!this.surveyFlag) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = get_binding();
            TextView textView = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.subTv : null;
            if (textView != null) {
                textView.setText(this.teacherName);
            }
        } else {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = get_binding();
            TextView textView2 = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.subTv : null;
            if (textView2 != null) {
                textView2.setText(this.teacherName + " - " + this.subject);
            }
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = get_binding();
        MaterialButton materialButton4 = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.backBtn : null;
        if (materialButton4 != null) {
            materialButton4.setVisibility(4);
        }
        String str = this.teacherId;
        Intrinsics.checkNotNull(str);
        if (Intrinsics.areEqual(str, "")) {
            TeacherSurveyQuestionViewModel teacherSurveyQuestionViewModel = getTeacherSurveyQuestionViewModel();
            String str2 = this.id;
            Intrinsics.checkNotNull(str2);
            teacherSurveyQuestionViewModel.getGenSurveyQuestionList(str2);
        } else {
            TeacherSurveyQuestionViewModel teacherSurveyQuestionViewModel2 = getTeacherSurveyQuestionViewModel();
            String str3 = this.id;
            Intrinsics.checkNotNull(str3);
            String str4 = this.teacherId;
            Intrinsics.checkNotNull(str4);
            String str5 = this.subjectId;
            Intrinsics.checkNotNull(str5);
            teacherSurveyQuestionViewModel2.getSurveyQuestionListList(str3, str4, str5);
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mbits", false, 2, (Object) null)) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = get_binding();
            CardView cardView = fragmentTeacherSurveyQuestionsBinding5 != null ? fragmentTeacherSurveyQuestionsBinding5.mbitsLyt : null;
            if (cardView != null) {
                cardView.setVisibility(0);
            }
            if (this.image.length() > 0) {
                RequestCreator requestCreatorFit = Picasso.get().load(this.image).placeholder(R.drawable.ic_user_profile).error(R.drawable.ic_user_profile).fit();
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = get_binding();
                ImageView imageView = fragmentTeacherSurveyQuestionsBinding6 != null ? fragmentTeacherSurveyQuestionsBinding6.teacherImg : null;
                Intrinsics.checkNotNull(imageView);
                requestCreatorFit.into(imageView);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = get_binding();
            TextView textView3 = fragmentTeacherSurveyQuestionsBinding7 != null ? fragmentTeacherSurveyQuestionsBinding7.semTv : null;
            if (textView3 != null) {
                textView3.setText(this.semester);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = get_binding();
            TextView textView4 = fragmentTeacherSurveyQuestionsBinding8 != null ? fragmentTeacherSurveyQuestionsBinding8.subTv : null;
            if (textView4 != null) {
                textView4.setText(this.subject);
            }
        } else {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding9 = get_binding();
            CardView cardView2 = fragmentTeacherSurveyQuestionsBinding9 != null ? fragmentTeacherSurveyQuestionsBinding9.mbitsLyt : null;
            if (cardView2 != null) {
                cardView2.setVisibility(8);
            }
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding10 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding10 != null && (radioGroup = fragmentTeacherSurveyQuestionsBinding10.teacherSurveyQuestionsMultiple) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda2
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    TeacherSurveyQuestionFragment.setUp$lambda$1(this.f$0, radioGroup2, i);
                }
            });
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding11 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding11 != null && (materialButton3 = fragmentTeacherSurveyQuestionsBinding11.nextBtn) != null) {
            materialButton3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeacherSurveyQuestionFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding12 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding12 != null && (materialButton2 = fragmentTeacherSurveyQuestionsBinding12.backBtn) != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeacherSurveyQuestionFragment.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding13 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding13 == null || (materialButton = fragmentTeacherSurveyQuestionsBinding13.finishBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeacherSurveyQuestionFragment.setUp$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TeacherSurveyQuestionFragment this$0, RadioGroup radioGroup, int i) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (this$0.isRestoringAnswer) {
            return;
        }
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.option_1) {
            str = "0";
        } else if (checkedRadioButtonId == R.id.option_2) {
            str = "1";
        } else if (checkedRadioButtonId == R.id.option_3) {
            str = ExifInterface.GPS_MEASUREMENT_2D;
        } else if (checkedRadioButtonId == R.id.option_4) {
            str = ExifInterface.GPS_MEASUREMENT_3D;
        } else {
            str = checkedRadioButtonId == R.id.option_5 ? "4" : this$0.option;
        }
        this$0.option = str;
        this$0.applyRadioButtonTint(str);
        try {
            if (!Intrinsics.areEqual(this$0.teacherId, "")) {
                int i2 = this$0.i;
                Intrinsics.checkNotNull(this$0.surveyResponse);
                if (i2 > r2.size() - 2) {
                } else {
                    this$0.surveyAnswers.set(this$0.i, this$0.option);
                }
            } else {
                int i3 = this$0.i;
                Intrinsics.checkNotNull(this$0.surveyResponse);
                if (i3 > r2.size() - 1) {
                } else {
                    this$0.surveyAnswers.set(this$0.i, this$0.option);
                }
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void setUp$lambda$2(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment r21, android.view.View r22) {
        /*
            Method dump skipped, instruction units count: 1132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.setUp$lambda$2(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(TeacherSurveyQuestionFragment this$0, View view) {
        TextView textView;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeacherSurveyQuestionAdapter adapter = this$0.getAdapter();
        List<String> list = this$0.surveyAnswers;
        int i = this$0.i;
        adapter.addItems(list, i - 1, this$0.mandatoryQuestions, this$0.attendedOrNot, i - 1);
        this$0.i--;
        this$0.updateProgress();
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = this$0.get_binding();
        CardView cardView = fragmentTeacherSurveyQuestionsBinding != null ? fragmentTeacherSurveyQuestionsBinding.mbitsLyt : null;
        if (cardView != null) {
            cardView.setVisibility((this$0.i == 0 && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mbits", false, 2, (Object) null)) ? 0 : 8);
        }
        if (!Intrinsics.areEqual(this$0.teacherId, "")) {
            int i2 = this$0.i;
            ArrayList<SurveyQuestion> arrayList = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList);
            if (i2 == arrayList.size() - 4) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = this$0.get_binding();
                this$0.strength = String.valueOf((fragmentTeacherSurveyQuestionsBinding2 == null || (textInputEditText10 = fragmentTeacherSurveyQuestionsBinding2.etStrength) == null) ? null : textInputEditText10.getText());
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = this$0.get_binding();
                this$0.remarks = String.valueOf((fragmentTeacherSurveyQuestionsBinding3 == null || (textInputEditText9 = fragmentTeacherSurveyQuestionsBinding3.etRemarks) == null) ? null : textInputEditText9.getText());
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = this$0.get_binding();
                this$0.lastDesc = String.valueOf((fragmentTeacherSurveyQuestionsBinding4 == null || (textInputEditText8 = fragmentTeacherSurveyQuestionsBinding4.etDescriptive) == null) ? null : textInputEditText8.getText());
            }
            ArrayList<SurveyQuestion> arrayList2 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList2);
            if (Intrinsics.areEqual(arrayList2.get(this$0.i + 1).getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                List<String> list2 = this$0.surveyAnswers;
                int i3 = this$0.i + 1;
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = this$0.get_binding();
                list2.set(i3, String.valueOf((fragmentTeacherSurveyQuestionsBinding5 == null || (textInputEditText7 = fragmentTeacherSurveyQuestionsBinding5.etDescriptive) == null) ? null : textInputEditText7.getText()));
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = this$0.get_binding();
                if (fragmentTeacherSurveyQuestionsBinding6 != null && (textInputEditText6 = fragmentTeacherSurveyQuestionsBinding6.etDescriptive) != null) {
                    textInputEditText6.setText(this$0.surveyAnswers.get(this$0.i));
                }
            }
            this$0.flag = false;
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = this$0.get_binding();
            LinearLayout linearLayout = fragmentTeacherSurveyQuestionsBinding7 != null ? fragmentTeacherSurveyQuestionsBinding7.finalQuestionsLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = this$0.get_binding();
            MaterialButton materialButton = fragmentTeacherSurveyQuestionsBinding8 != null ? fragmentTeacherSurveyQuestionsBinding8.backBtn : null;
            if (materialButton != null) {
                materialButton.setVisibility(this$0.i != 0 ? 0 : 4);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding9 = this$0.get_binding();
            MaterialButton materialButton2 = fragmentTeacherSurveyQuestionsBinding9 != null ? fragmentTeacherSurveyQuestionsBinding9.nextBtn : null;
            if (materialButton2 != null) {
                materialButton2.setVisibility(0);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding10 = this$0.get_binding();
            MaterialButton materialButton3 = fragmentTeacherSurveyQuestionsBinding10 != null ? fragmentTeacherSurveyQuestionsBinding10.finishBtn : null;
            if (materialButton3 != null) {
                materialButton3.setVisibility(8);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding11 = this$0.get_binding();
            TextView textView2 = fragmentTeacherSurveyQuestionsBinding11 != null ? fragmentTeacherSurveyQuestionsBinding11.questionTv : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            try {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding12 = this$0.get_binding();
                TextView textView3 = fragmentTeacherSurveyQuestionsBinding12 != null ? fragmentTeacherSurveyQuestionsBinding12.requiredTv : null;
                if (textView3 != null) {
                    ArrayList<SurveyQuestion> arrayList3 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList3);
                    textView3.setVisibility(Intrinsics.areEqual(arrayList3.get(this$0.i).getRequired(), "true") ? 0 : 8);
                }
            } catch (NullPointerException unused) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding13 = this$0.get_binding();
                TextView textView4 = fragmentTeacherSurveyQuestionsBinding13 != null ? fragmentTeacherSurveyQuestionsBinding13.requiredTv : null;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            }
            int i4 = this$0.i;
            Intrinsics.checkNotNull(this$0.surveyResponse);
            if (i4 <= r2.size() - 3) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding14 = this$0.get_binding();
                TextView textView5 = fragmentTeacherSurveyQuestionsBinding14 != null ? fragmentTeacherSurveyQuestionsBinding14.teacherSurveyQuestion : null;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding15 = this$0.get_binding();
                TextView textView6 = fragmentTeacherSurveyQuestionsBinding15 != null ? fragmentTeacherSurveyQuestionsBinding15.teacherSurveyQuestion : null;
                if (textView6 != null) {
                    ArrayList<SurveyQuestion> arrayList4 = this$0.surveyResponse;
                    Intrinsics.checkNotNull(arrayList4);
                    String question = arrayList4.get(this$0.i).getQuestion();
                    Intrinsics.checkNotNull(question);
                    textView6.setText("Q) " + this$0.convertHtmlToString(question));
                }
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding16 = this$0.get_binding();
            textView = fragmentTeacherSurveyQuestionsBinding16 != null ? fragmentTeacherSurveyQuestionsBinding16.questionTv : null;
            if (textView != null) {
                int i5 = this$0.i + 1;
                ArrayList<SurveyQuestion> arrayList5 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList5);
                textView.setText(i5 + RemoteSettings.FORWARD_SLASH_STRING + (arrayList5.size() - 2));
            }
            this$0.renderQuestion(this$0.i);
            return;
        }
        int i6 = this$0.i;
        Intrinsics.checkNotNull(this$0.surveyResponse);
        if (i6 == r9.size() - 3) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding17 = this$0.get_binding();
            this$0.strength = String.valueOf((fragmentTeacherSurveyQuestionsBinding17 == null || (textInputEditText5 = fragmentTeacherSurveyQuestionsBinding17.etStrength) == null) ? null : textInputEditText5.getText());
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding18 = this$0.get_binding();
            this$0.remarks = String.valueOf((fragmentTeacherSurveyQuestionsBinding18 == null || (textInputEditText4 = fragmentTeacherSurveyQuestionsBinding18.etRemarks) == null) ? null : textInputEditText4.getText());
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding19 = this$0.get_binding();
            this$0.lastDesc = String.valueOf((fragmentTeacherSurveyQuestionsBinding19 == null || (textInputEditText3 = fragmentTeacherSurveyQuestionsBinding19.etDescriptive) == null) ? null : textInputEditText3.getText());
        }
        ArrayList<SurveyQuestion> arrayList6 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList6);
        if (Intrinsics.areEqual(arrayList6.get(this$0.i + 1).getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
            List<String> list3 = this$0.surveyAnswers;
            int i7 = this$0.i + 1;
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding20 = this$0.get_binding();
            list3.set(i7, String.valueOf((fragmentTeacherSurveyQuestionsBinding20 == null || (textInputEditText2 = fragmentTeacherSurveyQuestionsBinding20.etDescriptive) == null) ? null : textInputEditText2.getText()));
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding21 = this$0.get_binding();
            if (fragmentTeacherSurveyQuestionsBinding21 != null && (textInputEditText = fragmentTeacherSurveyQuestionsBinding21.etDescriptive) != null) {
                textInputEditText.setText(this$0.surveyAnswers.get(this$0.i));
            }
        }
        this$0.flag = false;
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding22 = this$0.get_binding();
        LinearLayout linearLayout2 = fragmentTeacherSurveyQuestionsBinding22 != null ? fragmentTeacherSurveyQuestionsBinding22.finalQuestionsLyt : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding23 = this$0.get_binding();
        MaterialButton materialButton4 = fragmentTeacherSurveyQuestionsBinding23 != null ? fragmentTeacherSurveyQuestionsBinding23.backBtn : null;
        if (materialButton4 != null) {
            materialButton4.setVisibility(this$0.i != 0 ? 0 : 4);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding24 = this$0.get_binding();
        MaterialButton materialButton5 = fragmentTeacherSurveyQuestionsBinding24 != null ? fragmentTeacherSurveyQuestionsBinding24.nextBtn : null;
        if (materialButton5 != null) {
            materialButton5.setVisibility(0);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding25 = this$0.get_binding();
        MaterialButton materialButton6 = fragmentTeacherSurveyQuestionsBinding25 != null ? fragmentTeacherSurveyQuestionsBinding25.finishBtn : null;
        if (materialButton6 != null) {
            materialButton6.setVisibility(8);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding26 = this$0.get_binding();
        TextView textView7 = fragmentTeacherSurveyQuestionsBinding26 != null ? fragmentTeacherSurveyQuestionsBinding26.questionTv : null;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        try {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding27 = this$0.get_binding();
            TextView textView8 = fragmentTeacherSurveyQuestionsBinding27 != null ? fragmentTeacherSurveyQuestionsBinding27.requiredTv : null;
            if (textView8 != null) {
                ArrayList<SurveyQuestion> arrayList7 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList7);
                textView8.setVisibility(Intrinsics.areEqual(arrayList7.get(this$0.i).getRequired(), "true") ? 0 : 8);
            }
        } catch (NullPointerException unused2) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding28 = this$0.get_binding();
            TextView textView9 = fragmentTeacherSurveyQuestionsBinding28 != null ? fragmentTeacherSurveyQuestionsBinding28.requiredTv : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        int i8 = this$0.i;
        ArrayList<SurveyQuestion> arrayList8 = this$0.surveyResponse;
        Intrinsics.checkNotNull(arrayList8);
        if (i8 <= arrayList8.size() - 2) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding29 = this$0.get_binding();
            TextView textView10 = fragmentTeacherSurveyQuestionsBinding29 != null ? fragmentTeacherSurveyQuestionsBinding29.teacherSurveyQuestion : null;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding30 = this$0.get_binding();
            TextView textView11 = fragmentTeacherSurveyQuestionsBinding30 != null ? fragmentTeacherSurveyQuestionsBinding30.teacherSurveyQuestion : null;
            if (textView11 != null) {
                ArrayList<SurveyQuestion> arrayList9 = this$0.surveyResponse;
                Intrinsics.checkNotNull(arrayList9);
                String question2 = arrayList9.get(this$0.i).getQuestion();
                Intrinsics.checkNotNull(question2);
                textView11.setText("Q) " + this$0.convertHtmlToString(question2));
            }
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding31 = this$0.get_binding();
        textView = fragmentTeacherSurveyQuestionsBinding31 != null ? fragmentTeacherSurveyQuestionsBinding31.questionTv : null;
        if (textView != null) {
            int i9 = this$0.i + 1;
            ArrayList<SurveyQuestion> arrayList10 = this$0.surveyResponse;
            Intrinsics.checkNotNull(arrayList10);
            textView.setText(i9 + RemoteSettings.FORWARD_SLASH_STRING + (arrayList10.size() - 1));
        }
        this$0.renderQuestion(this$0.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void setUp$lambda$4(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment r10, android.view.View r11) {
        /*
            Method dump skipped, instruction units count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.setUp$lambda$4(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment, android.view.View):void");
    }

    private final void showFinalSection() {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = get_binding();
        MaterialButton materialButton = fragmentTeacherSurveyQuestionsBinding != null ? fragmentTeacherSurveyQuestionsBinding.nextBtn : null;
        if (materialButton != null) {
            materialButton.setVisibility(8);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = get_binding();
        MaterialButton materialButton2 = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.finishBtn : null;
        if (materialButton2 != null) {
            materialButton2.setVisibility(0);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = get_binding();
        LinearLayout linearLayout = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.finalQuestionsLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = get_binding();
        TextView textView = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.questionTv : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding5 != null && (textInputEditText3 = fragmentTeacherSurveyQuestionsBinding5.etRemarks) != null) {
            textInputEditText3.setText(this.remarks);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding6 != null && (textInputEditText2 = fragmentTeacherSurveyQuestionsBinding6.etStrength) != null) {
            textInputEditText2.setText(this.strength);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding7 != null && (textInputEditText = fragmentTeacherSurveyQuestionsBinding7.etDescriptive) != null) {
            textInputEditText.setText(this.lastDesc);
        }
        this.flag = true;
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = get_binding();
        ProgressBar progressBar = fragmentTeacherSurveyQuestionsBinding8 != null ? fragmentTeacherSurveyQuestionsBinding8.surveyProgress : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(100);
    }

    private final void showQuestionSection() {
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = get_binding();
        TextView textView = fragmentTeacherSurveyQuestionsBinding != null ? fragmentTeacherSurveyQuestionsBinding.questionTv : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = get_binding();
        MaterialButton materialButton = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.nextBtn : null;
        if (materialButton != null) {
            materialButton.setVisibility(0);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = get_binding();
        MaterialButton materialButton2 = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.finishBtn : null;
        if (materialButton2 != null) {
            materialButton2.setVisibility(8);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = get_binding();
        LinearLayout linearLayout = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.finalQuestionsLyt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void renderQuestion(int index) {
        String type;
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding;
        RadioGroup radioGroup;
        TextInputEditText textInputEditText;
        ArrayList<SurveyQuestion> arrayList = this.surveyResponse;
        if (arrayList == null || (type = arrayList.get(index).getType()) == null) {
            return;
        }
        switch (type.hashCode()) {
            case 49:
                if (type.equals("1")) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = get_binding();
                    TextView textView = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.teacherSurveyQuestionNo : null;
                    if (textView != null) {
                        textView.setText("Question " + (index + 1) + " (Multiple Choice)");
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = get_binding();
                    LinearLayout linearLayout = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.descriptiveAnswerLyt : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = get_binding();
                    LinearLayout linearLayout2 = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.multipleAnswerLyt : null;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    this.isRestoringAnswer = true;
                    String str = this.surveyAnswers.get(index);
                    int iHashCode = str.hashCode();
                    if (iHashCode != 0) {
                        switch (iHashCode) {
                            case 48:
                                if (str.equals("0")) {
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = get_binding();
                                    RadioButton radioButton = fragmentTeacherSurveyQuestionsBinding5 != null ? fragmentTeacherSurveyQuestionsBinding5.option1 : null;
                                    if (radioButton != null) {
                                        radioButton.setChecked(true);
                                    }
                                }
                                break;
                            case 49:
                                if (str.equals("1")) {
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = get_binding();
                                    RadioButton radioButton2 = fragmentTeacherSurveyQuestionsBinding6 != null ? fragmentTeacherSurveyQuestionsBinding6.option2 : null;
                                    if (radioButton2 != null) {
                                        radioButton2.setChecked(true);
                                    }
                                }
                                break;
                            case 50:
                                if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = get_binding();
                                    RadioButton radioButton3 = fragmentTeacherSurveyQuestionsBinding7 != null ? fragmentTeacherSurveyQuestionsBinding7.option3 : null;
                                    if (radioButton3 != null) {
                                        radioButton3.setChecked(true);
                                    }
                                }
                                break;
                            case 51:
                                if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = get_binding();
                                    RadioButton radioButton4 = fragmentTeacherSurveyQuestionsBinding8 != null ? fragmentTeacherSurveyQuestionsBinding8.option4 : null;
                                    if (radioButton4 != null) {
                                        radioButton4.setChecked(true);
                                    }
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding9 = get_binding();
                                    RadioButton radioButton5 = fragmentTeacherSurveyQuestionsBinding9 != null ? fragmentTeacherSurveyQuestionsBinding9.option5 : null;
                                    if (radioButton5 != null) {
                                        radioButton5.setChecked(true);
                                    }
                                }
                                break;
                        }
                    } else if (str.equals("") && (fragmentTeacherSurveyQuestionsBinding = get_binding()) != null && (radioGroup = fragmentTeacherSurveyQuestionsBinding.teacherSurveyQuestionsMultiple) != null) {
                        radioGroup.clearCheck();
                    }
                    this.isRestoringAnswer = false;
                    applyRadioButtonTint(this.surveyAnswers.get(index));
                    ArrayList<String> option = arrayList.get(index).getOption();
                    if (option == null) {
                        return;
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding10 = get_binding();
                    RadioButton radioButton6 = fragmentTeacherSurveyQuestionsBinding10 != null ? fragmentTeacherSurveyQuestionsBinding10.option1 : null;
                    if (radioButton6 != null) {
                        radioButton6.setVisibility(option.size() >= 1 ? 0 : 8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding11 = get_binding();
                    RadioButton radioButton7 = fragmentTeacherSurveyQuestionsBinding11 != null ? fragmentTeacherSurveyQuestionsBinding11.option2 : null;
                    if (radioButton7 != null) {
                        radioButton7.setVisibility(option.size() >= 2 ? 0 : 8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding12 = get_binding();
                    RadioButton radioButton8 = fragmentTeacherSurveyQuestionsBinding12 != null ? fragmentTeacherSurveyQuestionsBinding12.option3 : null;
                    if (radioButton8 != null) {
                        radioButton8.setVisibility(option.size() >= 3 ? 0 : 8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding13 = get_binding();
                    RadioButton radioButton9 = fragmentTeacherSurveyQuestionsBinding13 != null ? fragmentTeacherSurveyQuestionsBinding13.option4 : null;
                    if (radioButton9 != null) {
                        radioButton9.setVisibility(option.size() >= 4 ? 0 : 8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding14 = get_binding();
                    RadioButton radioButton10 = fragmentTeacherSurveyQuestionsBinding14 != null ? fragmentTeacherSurveyQuestionsBinding14.option5 : null;
                    if (radioButton10 != null) {
                        radioButton10.setVisibility(option.size() >= 5 ? 0 : 8);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding15 = get_binding();
                    RadioButton radioButton11 = fragmentTeacherSurveyQuestionsBinding15 != null ? fragmentTeacherSurveyQuestionsBinding15.option6 : null;
                    if (radioButton11 != null) {
                        radioButton11.setVisibility(option.size() >= 6 ? 0 : 8);
                    }
                    if (option.size() >= 1) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding16 = get_binding();
                        RadioButton radioButton12 = fragmentTeacherSurveyQuestionsBinding16 != null ? fragmentTeacherSurveyQuestionsBinding16.option1 : null;
                        if (radioButton12 != null) {
                            String str2 = option.get(0);
                            Intrinsics.checkNotNullExpressionValue(str2, "opts[0]");
                            radioButton12.setText(convertHtmlToString(str2));
                        }
                    }
                    if (option.size() >= 2) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding17 = get_binding();
                        RadioButton radioButton13 = fragmentTeacherSurveyQuestionsBinding17 != null ? fragmentTeacherSurveyQuestionsBinding17.option2 : null;
                        if (radioButton13 != null) {
                            String str3 = option.get(1);
                            Intrinsics.checkNotNullExpressionValue(str3, "opts[1]");
                            radioButton13.setText(convertHtmlToString(str3));
                        }
                    }
                    if (option.size() >= 3) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding18 = get_binding();
                        RadioButton radioButton14 = fragmentTeacherSurveyQuestionsBinding18 != null ? fragmentTeacherSurveyQuestionsBinding18.option3 : null;
                        if (radioButton14 != null) {
                            String str4 = option.get(2);
                            Intrinsics.checkNotNullExpressionValue(str4, "opts[2]");
                            radioButton14.setText(convertHtmlToString(str4));
                        }
                    }
                    if (option.size() >= 4) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding19 = get_binding();
                        RadioButton radioButton15 = fragmentTeacherSurveyQuestionsBinding19 != null ? fragmentTeacherSurveyQuestionsBinding19.option4 : null;
                        if (radioButton15 != null) {
                            String str5 = option.get(3);
                            Intrinsics.checkNotNullExpressionValue(str5, "opts[3]");
                            radioButton15.setText(convertHtmlToString(str5));
                        }
                    }
                    if (option.size() >= 5) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding20 = get_binding();
                        RadioButton radioButton16 = fragmentTeacherSurveyQuestionsBinding20 != null ? fragmentTeacherSurveyQuestionsBinding20.option5 : null;
                        if (radioButton16 != null) {
                            String str6 = option.get(4);
                            Intrinsics.checkNotNullExpressionValue(str6, "opts[4]");
                            radioButton16.setText(convertHtmlToString(str6));
                        }
                    }
                    if (option.size() >= 6) {
                        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding21 = get_binding();
                        RadioButton radioButton17 = fragmentTeacherSurveyQuestionsBinding21 != null ? fragmentTeacherSurveyQuestionsBinding21.option6 : null;
                        if (radioButton17 == null) {
                            return;
                        }
                        String str7 = option.get(5);
                        Intrinsics.checkNotNullExpressionValue(str7, "opts[5]");
                        radioButton17.setText(convertHtmlToString(str7));
                        return;
                    }
                    return;
                }
                return;
            case 50:
                if (!type.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    return;
                }
                break;
            case 51:
                if (!type.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    return;
                }
                break;
            default:
                return;
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding22 = get_binding();
        TextView textView2 = fragmentTeacherSurveyQuestionsBinding22 != null ? fragmentTeacherSurveyQuestionsBinding22.teacherSurveyQuestionNo : null;
        if (textView2 != null) {
            textView2.setText("Question " + (index + 1) + " (Descriptive)");
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding23 = get_binding();
        LinearLayout linearLayout3 = fragmentTeacherSurveyQuestionsBinding23 != null ? fragmentTeacherSurveyQuestionsBinding23.descriptiveAnswerLyt : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding24 = get_binding();
        LinearLayout linearLayout4 = fragmentTeacherSurveyQuestionsBinding24 != null ? fragmentTeacherSurveyQuestionsBinding24.multipleAnswerLyt : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding25 = get_binding();
        TextView textView3 = fragmentTeacherSurveyQuestionsBinding25 != null ? fragmentTeacherSurveyQuestionsBinding25.teacherSurveyQuestion : null;
        if (textView3 != null) {
            String question = arrayList.get(index).getQuestion();
            Intrinsics.checkNotNull(question);
            textView3.setText("Q ) " + convertHtmlToString(question));
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding26 = get_binding();
        if (fragmentTeacherSurveyQuestionsBinding26 == null || (textInputEditText = fragmentTeacherSurveyQuestionsBinding26.etDescriptive) == null) {
            return;
        }
        textInputEditText.setText(Intrinsics.areEqual(this.surveyAnswers.get(index), "") ? "" : this.surveyAnswers.get(index));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void buildSubmitMap() {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.buildSubmitMap():void");
    }

    private final void listenResponse() {
        getTeacherSurveyQuestionViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherSurveyQuestionFragment.listenResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(TeacherSurveyQuestionFragment this$0, Resource resource) {
        MaterialButton materialButton;
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
            if (fragmentTeacherSurveyQuestionsBinding == null || (materialButton = fragmentTeacherSurveyQuestionsBinding.finishBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(materialButton, message);
            return;
        }
        this$0.hideProgress();
        ArrayList<SurveyQuestion> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.showBaseView();
            this$0.surveyResponse = arrayList;
            if (!Intrinsics.areEqual(this$0.teacherId, "")) {
                int size = arrayList.size() - 2;
                for (int i2 = 0; i2 < size; i2++) {
                    this$0.surveyAnswers.add(i2, "");
                    this$0.mandatoryQuestions.add(i2, Intrinsics.areEqual(arrayList.get(i2).getRequired(), "true") ? "true" : "false");
                    this$0.attendedOrNot.add(i2, "NOT");
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = this$0.get_binding();
                TextView textView = fragmentTeacherSurveyQuestionsBinding2 != null ? fragmentTeacherSurveyQuestionsBinding2.questionTv : null;
                if (textView != null) {
                    textView.setText((this$0.i + 1) + RemoteSettings.FORWARD_SLASH_STRING + (arrayList.size() - 2));
                }
            } else {
                int size2 = arrayList.size() - 1;
                for (int i3 = 0; i3 < size2; i3++) {
                    this$0.surveyAnswers.add(i3, "");
                    this$0.mandatoryQuestions.add(i3, Intrinsics.areEqual(arrayList.get(i3).getRequired(), "true") ? "true" : "false");
                    this$0.attendedOrNot.add(i3, "NOT");
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = this$0.get_binding();
                TextView textView2 = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.questionTv : null;
                if (textView2 != null) {
                    textView2.setText((this$0.i + 1) + RemoteSettings.FORWARD_SLASH_STRING + (arrayList.size() - 1));
                }
            }
            this$0.getAdapter().addItems(this$0.surveyAnswers, 0, this$0.mandatoryQuestions, this$0.attendedOrNot, 0);
            this$0.updateProgress();
            try {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = this$0.get_binding();
                TextView textView3 = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.requiredTv : null;
                if (textView3 != null) {
                    textView3.setVisibility(Intrinsics.areEqual(arrayList.get(this$0.i).getRequired(), "true") ? 0 : 8);
                }
            } catch (NullPointerException unused) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = this$0.get_binding();
                TextView textView4 = fragmentTeacherSurveyQuestionsBinding5 != null ? fragmentTeacherSurveyQuestionsBinding5.requiredTv : null;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = this$0.get_binding();
            TextView textView5 = fragmentTeacherSurveyQuestionsBinding6 != null ? fragmentTeacherSurveyQuestionsBinding6.teacherSurveyQuestion : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = this$0.get_binding();
            TextView textView6 = fragmentTeacherSurveyQuestionsBinding7 != null ? fragmentTeacherSurveyQuestionsBinding7.teacherSurveyQuestion : null;
            if (textView6 != null) {
                String question = arrayList.get(this$0.i).getQuestion();
                Intrinsics.checkNotNull(question);
                textView6.setText("Q ) " + this$0.convertHtmlToString(question));
            }
            this$0.renderQuestion(this$0.i);
            if (!Intrinsics.areEqual(this$0.teacherId, "")) {
                if (this$0.i == 0 && arrayList.size() - 2 == 1) {
                    this$0.showFinalSection();
                    return;
                }
                return;
            }
            if (this$0.i == 0 && arrayList.size() - 1 == 1) {
                this$0.showFinalSection();
            }
        }
    }

    private final void listenAnswerResponse() {
        getTeacherSurveyQuestionViewModel().getSubmitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherSurveyQuestionFragment.listenAnswerResponse$lambda$8(this.f$0, (Resource) obj);
            }
        });
        getTeacherSurveyQuestionViewModel().getSubmitTeacherResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherSurveyQuestionFragment.listenAnswerResponse$lambda$11(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAnswerResponse$lambda$8(TeacherSurveyQuestionFragment this$0, Resource resource) {
        MaterialButton finishBtn;
        MaterialButton finishBtn2;
        MaterialButton materialButton;
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
            if (fragmentTeacherSurveyQuestionsBinding == null || (materialButton = fragmentTeacherSurveyQuestionsBinding.finishBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(materialButton, message);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAnswerResponse$lambda$11(TeacherSurveyQuestionFragment this$0, Resource resource) {
        MaterialButton materialButton;
        MaterialButton nextBtn;
        MaterialButton materialButton2;
        MaterialButton materialButton3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding = this$0.get_binding();
            materialButton = fragmentTeacherSurveyQuestionsBinding != null ? fragmentTeacherSurveyQuestionsBinding.nextBtn : null;
            if (materialButton != null) {
                materialButton.setEnabled(true);
            }
            SubmitTeacherResponse submitTeacherResponse = (SubmitTeacherResponse) resource.getData();
            if (submitTeacherResponse != null) {
                if (!submitTeacherResponse.getStatus()) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2 = this$0.get_binding();
                    if (fragmentTeacherSurveyQuestionsBinding2 == null || (nextBtn = fragmentTeacherSurveyQuestionsBinding2.nextBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(nextBtn, "nextBtn");
                    MaterialButton materialButton4 = nextBtn;
                    String error = submitTeacherResponse.getError();
                    ToastExtKt.showErrorToast(materialButton4, error.length() == 0 ? "Failed to save answer" : error);
                    return;
                }
                this$0.advanceToNextQuestion();
                return;
            }
            return;
        }
        if (i == 2) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = this$0.get_binding();
            materialButton = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.nextBtn : null;
            if (materialButton == null) {
                return;
            }
            materialButton.setEnabled(false);
            return;
        }
        if (i == 3) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = this$0.get_binding();
            materialButton = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.nextBtn : null;
            if (materialButton != null) {
                materialButton.setEnabled(true);
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = this$0.get_binding();
            if (fragmentTeacherSurveyQuestionsBinding5 == null || (materialButton2 = fragmentTeacherSurveyQuestionsBinding5.nextBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(materialButton2, "Failed to save answer");
            return;
        }
        if (i != 4) {
            return;
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = this$0.get_binding();
        materialButton = fragmentTeacherSurveyQuestionsBinding6 != null ? fragmentTeacherSurveyQuestionsBinding6.nextBtn : null;
        if (materialButton != null) {
            materialButton.setEnabled(true);
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = this$0.get_binding();
        if (fragmentTeacherSurveyQuestionsBinding7 == null || (materialButton3 = fragmentTeacherSurveyQuestionsBinding7.nextBtn) == null) {
            return;
        }
        ToastExtKt.showErrorToast(materialButton3, "Failed to save answer, please retry");
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
        }
    }

    public final String convertHtmlToString(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        Spanned spannedFromHtml = Html.fromHtml(html, 0);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(html, Html.FROM_HTML_MODE_LEGACY)");
        return spannedFromHtml.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x0261  */
    @Override // in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter.SurveyCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doTheSurvey(java.lang.String r17, int r18) {
        /*
            Method dump skipped, instruction units count: 1427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.doTheSurvey(java.lang.String, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void applyRadioButtonTint(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.applyRadioButtonTint(java.lang.String):void");
    }

    private final void submitIndividualAnswer(int index) {
        String qid;
        ArrayList<String> id;
        ArrayList<SurveyQuestion> arrayList = this.surveyResponse;
        if (arrayList == null) {
            return;
        }
        String str = this.surveyAnswers.get(index);
        if (str.length() == 0) {
            return;
        }
        SurveyQuestion surveyQuestion = arrayList.get(index);
        Intrinsics.checkNotNullExpressionValue(surveyQuestion, "response[index]");
        SurveyQuestion surveyQuestion2 = surveyQuestion;
        if (!Intrinsics.areEqual(surveyQuestion2.getType(), "1") || (qid = surveyQuestion2.getQid()) == null || (id = surveyQuestion2.getId()) == null) {
            return;
        }
        ArrayList<String> arrayList2 = id;
        Integer intOrNull = StringsKt.toIntOrNull(str);
        String str2 = (String) CollectionsKt.getOrNull(arrayList2, intOrNull != null ? intOrNull.intValue() : -1);
        if (str2 == null) {
            return;
        }
        TeacherSurveyQuestionViewModel teacherSurveyQuestionViewModel = getTeacherSurveyQuestionViewModel();
        String str3 = this.teacherId;
        Intrinsics.checkNotNull(str3);
        String str4 = this.subjectId;
        Intrinsics.checkNotNull(str4);
        String str5 = this.id;
        Intrinsics.checkNotNull(str5);
        teacherSurveyQuestionViewModel.getSurveyAnswerSubmit(qid, str2, str3, str4, str5);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean canProceedFromCurrent() {
        /*
            r4 = this;
            java.util.ArrayList<in.etuwa.app.data.model.survey.SurveyQuestion> r0 = r4.surveyResponse
            r1 = 1
            if (r0 != 0) goto L6
            return r1
        L6:
            int r2 = r4.i
            int r0 = r0.size()
            if (r2 < r0) goto Lf
            return r1
        Lf:
            java.util.List<java.lang.String> r0 = r4.mandatoryQuestions
            int r2 = r4.i
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r2)
            java.lang.String r2 = "true"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            java.util.List<java.lang.String> r2 = r4.surveyAnswers
            int r3 = r4.i
            java.lang.Object r2 = kotlin.collections.CollectionsKt.getOrNull(r2, r3)
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            if (r2 == 0) goto L39
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L34
            r2 = 1
            goto L35
        L34:
            r2 = 0
        L35:
            if (r2 != r1) goto L39
            r2 = 1
            goto L3a
        L39:
            r2 = 0
        L3a:
            if (r0 == 0) goto L50
            if (r2 != 0) goto L50
            in.etuwa.app.databinding.FragmentTeacherSurveyQuestionsBinding r0 = r4.get_binding()
            if (r0 == 0) goto L4f
            com.google.android.material.button.MaterialButton r0 = r0.nextBtn
            if (r0 == 0) goto L4f
            android.view.View r0 = (android.view.View) r0
            java.lang.String r1 = "This question is mandatory. Please answer before proceeding."
            in.etuwa.app.utils.ToastExtKt.showErrorToast(r0, r1)
        L4f:
            r1 = 0
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment.canProceedFromCurrent():boolean");
    }

    private final void advanceToNextQuestion() {
        MaterialButton materialButton;
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding;
        TextInputEditText textInputEditText;
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding2;
        TextInputEditText textInputEditText2;
        ArrayList<SurveyQuestion> arrayList = this.surveyResponse;
        if (arrayList == null) {
            return;
        }
        this.attendedOrNot.set(this.i, "YES");
        TeacherSurveyQuestionAdapter adapter = getAdapter();
        List<String> list = this.surveyAnswers;
        int i = this.i;
        adapter.addItems(list, i + 1, this.mandatoryQuestions, this.attendedOrNot, i + 1);
        if (!Intrinsics.areEqual(this.teacherId, "")) {
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding3 = get_binding();
            TextView textView = fragmentTeacherSurveyQuestionsBinding3 != null ? fragmentTeacherSurveyQuestionsBinding3.questionTv : null;
            if (textView != null) {
                textView.setText((this.i + 2) + RemoteSettings.FORWARD_SLASH_STRING + (arrayList.size() - 2));
            }
            if (this.i < arrayList.size()) {
                this.i++;
                updateProgress();
                if ((Intrinsics.areEqual(arrayList.get(this.i - 1).getType(), ExifInterface.GPS_MEASUREMENT_3D) || Intrinsics.areEqual(arrayList.get(this.i - 1).getType(), ExifInterface.GPS_MEASUREMENT_2D)) && (fragmentTeacherSurveyQuestionsBinding2 = get_binding()) != null && (textInputEditText2 = fragmentTeacherSurveyQuestionsBinding2.etDescriptive) != null) {
                    textInputEditText2.setText(this.surveyAnswers.get(this.i));
                }
                try {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding4 = get_binding();
                    TextView textView2 = fragmentTeacherSurveyQuestionsBinding4 != null ? fragmentTeacherSurveyQuestionsBinding4.requiredTv : null;
                    if (textView2 != null) {
                        textView2.setVisibility(Intrinsics.areEqual(arrayList.get(this.i).getRequired(), "true") ? 0 : 8);
                    }
                } catch (NullPointerException unused) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding5 = get_binding();
                    TextView textView3 = fragmentTeacherSurveyQuestionsBinding5 != null ? fragmentTeacherSurveyQuestionsBinding5.requiredTv : null;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                }
                if (this.i <= arrayList.size() - 3) {
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding6 = get_binding();
                    TextView textView4 = fragmentTeacherSurveyQuestionsBinding6 != null ? fragmentTeacherSurveyQuestionsBinding6.teacherSurveyQuestion : null;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                    FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding7 = get_binding();
                    TextView textView5 = fragmentTeacherSurveyQuestionsBinding7 != null ? fragmentTeacherSurveyQuestionsBinding7.teacherSurveyQuestion : null;
                    if (textView5 != null) {
                        String question = arrayList.get(this.i).getQuestion();
                        Intrinsics.checkNotNull(question);
                        textView5.setText("Q) " + convertHtmlToString(question));
                    }
                }
            }
            FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding8 = get_binding();
            materialButton = fragmentTeacherSurveyQuestionsBinding8 != null ? fragmentTeacherSurveyQuestionsBinding8.backBtn : null;
            if (materialButton != null) {
                materialButton.setVisibility(this.i != 0 ? 0 : 4);
            }
            if (this.i <= arrayList.size() - 3 && this.i != arrayList.size() - 3) {
                showQuestionSection();
            } else {
                showFinalSection();
            }
            if (this.flag) {
                return;
            }
            renderQuestion(this.i);
            return;
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding9 = get_binding();
        TextView textView6 = fragmentTeacherSurveyQuestionsBinding9 != null ? fragmentTeacherSurveyQuestionsBinding9.questionTv : null;
        if (textView6 != null) {
            textView6.setText((this.i + 2) + RemoteSettings.FORWARD_SLASH_STRING + (arrayList.size() - 1));
        }
        if (this.i < arrayList.size()) {
            this.i++;
            updateProgress();
            if (Intrinsics.areEqual(arrayList.get(this.i - 1).getType(), ExifInterface.GPS_MEASUREMENT_3D) && (fragmentTeacherSurveyQuestionsBinding = get_binding()) != null && (textInputEditText = fragmentTeacherSurveyQuestionsBinding.etDescriptive) != null) {
                textInputEditText.setText(this.surveyAnswers.get(this.i));
            }
            try {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding10 = get_binding();
                TextView textView7 = fragmentTeacherSurveyQuestionsBinding10 != null ? fragmentTeacherSurveyQuestionsBinding10.requiredTv : null;
                if (textView7 != null) {
                    textView7.setVisibility((!Intrinsics.areEqual(arrayList.get(this.i).getRequired(), "true") || Intrinsics.areEqual(arrayList.get(this.i).getType(), ExifInterface.GPS_MEASUREMENT_3D)) ? 8 : 0);
                }
            } catch (NullPointerException unused2) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding11 = get_binding();
                TextView textView8 = fragmentTeacherSurveyQuestionsBinding11 != null ? fragmentTeacherSurveyQuestionsBinding11.requiredTv : null;
                if (textView8 != null) {
                    textView8.setVisibility(8);
                }
            }
            if (this.i <= arrayList.size() - 2) {
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding12 = get_binding();
                TextView textView9 = fragmentTeacherSurveyQuestionsBinding12 != null ? fragmentTeacherSurveyQuestionsBinding12.teacherSurveyQuestion : null;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
                FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding13 = get_binding();
                TextView textView10 = fragmentTeacherSurveyQuestionsBinding13 != null ? fragmentTeacherSurveyQuestionsBinding13.teacherSurveyQuestion : null;
                if (textView10 != null) {
                    String question2 = arrayList.get(this.i).getQuestion();
                    Intrinsics.checkNotNull(question2);
                    textView10.setText("Q) " + convertHtmlToString(question2));
                }
            }
        }
        FragmentTeacherSurveyQuestionsBinding fragmentTeacherSurveyQuestionsBinding14 = get_binding();
        materialButton = fragmentTeacherSurveyQuestionsBinding14 != null ? fragmentTeacherSurveyQuestionsBinding14.backBtn : null;
        if (materialButton != null) {
            materialButton.setVisibility(this.i != 0 ? 0 : 4);
        }
        if (this.i <= arrayList.size() - 2 && this.i != arrayList.size() - 2) {
            showQuestionSection();
        } else {
            showFinalSection();
        }
        if (this.flag) {
            return;
        }
        renderQuestion(this.i);
    }

    private final void submitDescriptiveAnswer(int index) {
        ArrayList<SurveyQuestion> arrayList = this.surveyResponse;
        if (arrayList == null) {
            return;
        }
        String str = this.surveyAnswers.get(index);
        SurveyQuestion surveyQuestion = arrayList.get(index);
        Intrinsics.checkNotNullExpressionValue(surveyQuestion, "response[index]");
        String qid = surveyQuestion.getQid();
        if (qid == null) {
            return;
        }
        TeacherSurveyQuestionViewModel teacherSurveyQuestionViewModel = getTeacherSurveyQuestionViewModel();
        String str2 = this.teacherId;
        Intrinsics.checkNotNull(str2);
        String str3 = this.subjectId;
        Intrinsics.checkNotNull(str3);
        String str4 = this.id;
        Intrinsics.checkNotNull(str4);
        teacherSurveyQuestionViewModel.getSurveyAnswerSubmit(qid, str, str2, str3, str4);
    }
}