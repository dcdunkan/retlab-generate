package in.etuwa.app.ui.subjectregistration.applywithpreference;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.subjectregistration.SemList;
import in.etuwa.app.data.model.subjectregistration.SubjectMainList;
import in.etuwa.app.data.model.subjectregistration.Subjects;
import in.etuwa.app.data.model.subjectregistration.SubjectsList;
import in.etuwa.app.data.model.subjectregistration.SubjectsListResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogApplyPreferenceSubRegBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegQuestionAdapter;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter;
import in.etuwa.app.utils.CustomEditText;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ApplyPreferenceSubRegDialog.kt */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0098\u0001\u0099\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010i\u001a\u00020j2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010k\u001a\u00020j2\u0006\u0010!\u001a\u00020\"H\u0016J\u000e\u0010l\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u0017J\u000e\u0010n\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u0017J\b\u0010o\u001a\u00020jH\u0014J\b\u0010p\u001a\u00020jH\u0002J\b\u0010q\u001a\u00020jH\u0002J\b\u0010r\u001a\u00020jH\u0002J\u0012\u0010s\u001a\u00020j2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J&\u0010v\u001a\u0004\u0018\u00010w2\u0006\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010{2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\b\u0010|\u001a\u00020jH\u0016J\b\u0010}\u001a\u00020jH\u0016J\u0011\u0010~\u001a\u00020j2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J#\u0010\u0081\u0001\u001a\u00020j2\u0007\u0010\u0082\u0001\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0007\u0010\u0083\u0001\u001a\u00020\"H\u0016J\u0011\u0010\u0084\u0001\u001a\u00020j2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010\u0085\u0001\u001a\u00020j2\u0007\u0010\u0082\u0001\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010\u0086\u0001\u001a\u00020j2\u0007\u0010\u0082\u0001\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u001c\u0010\u0087\u0001\u001a\u00020j2\u0007\u0010\u0088\u0001\u001a\u00020w2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\t\u0010\u0089\u0001\u001a\u00020jH\u0002J\t\u0010\u008a\u0001\u001a\u00020jH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020j2\u0007\u0010\u008c\u0001\u001a\u00020\u0017H\u0002J\u0011\u0010\u008d\u0001\u001a\u00020j2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001J\t\u0010\u0090\u0001\u001a\u00020jH\u0015J\t\u0010\u0091\u0001\u001a\u00020jH\u0014J\"\u0010\u0092\u0001\u001a\u00020j2\u0006\u0010\u001a\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\u0007\u0010\u0093\u0001\u001a\u00020\"H\u0016J+\u0010\u0094\u0001\u001a\u00020j\"\u0005\b\u0000\u0010\u0095\u0001*\t\u0012\u0005\u0012\u0003H\u0095\u00010B2\u0007\u0010\u0096\u0001\u001a\u00020\"2\u0007\u0010\u0097\u0001\u001a\u00020\"R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001e\u0010\u0014R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\r\u001a\u0004\b.\u0010+R\u001b\u00100\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\r\u001a\u0004\b1\u0010+R\u001b\u00103\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b4\u0010+R\u001b\u00106\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\r\u001a\u0004\b7\u0010+R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\r\u001a\u0004\b;\u0010<R\u000e\u0010>\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00170B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00170B¢\u0006\b\n\u0000\u001a\u0004\bF\u0010DR\u001e\u0010G\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\r\u001a\u0004\bM\u0010NR\u001b\u0010P\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\r\u001a\u0004\bR\u0010SR\u001e\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u00170Hj\b\u0012\u0004\u0012\u00020\u0017`JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u00170Hj\b\u0012\u0004\u0012\u00020\u0017`JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00170B¢\u0006\b\n\u0000\u001a\u0004\bX\u0010DR\u001e\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u00170Hj\b\u0012\u0004\u0012\u00020\u0017`JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Z\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\r\u001a\u0004\b\\\u0010]R\u001e\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u00170Hj\b\u0012\u0004\u0012\u00020\u0017`JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00170B¢\u0006\b\n\u0000\u001a\u0004\ba\u0010DR\u001e\u0010b\u001a\u0012\u0012\u0004\u0012\u00020c0Hj\b\u0012\u0004\u0012\u00020c`JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010d\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\r\u001a\u0004\bf\u0010g¨\u0006\u009a\u0001"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter$CallBack;", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegQuestionAdapter$CallBack;", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogApplyPreferenceSubRegBinding;", "applyPreferenceSubRegViewModel", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegViewModel;", "getApplyPreferenceSubRegViewModel", "()Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegViewModel;", "applyPreferenceSubRegViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogApplyPreferenceSubRegBinding;", "categoryAdapter", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/PathwaySpinnerAdapter;", "getCategoryAdapter", "()Lin/etuwa/app/ui/subjectregistration/applywithpreference/PathwaySpinnerAdapter;", "categoryAdapter$delegate", "categoryId", "", "flag", "", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog$AddPublicationListener;", "pathwayAdapter", "getPathwayAdapter", "pathwayAdapter$delegate", "pathwayId", CommonCssConstants.POSITION, "", "pref1Flag", "pref2Flag", "pref3Flag", "pref4Flag", "pref5Flag", "prefFiveAdapter", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/SubjectRegSpinnerAdapter;", "getPrefFiveAdapter", "()Lin/etuwa/app/ui/subjectregistration/applywithpreference/SubjectRegSpinnerAdapter;", "prefFiveAdapter$delegate", "prefFourAdapter", "getPrefFourAdapter", "prefFourAdapter$delegate", "prefOneAdapter", "getPrefOneAdapter", "prefOneAdapter$delegate", "prefThreeAdapter", "getPrefThreeAdapter", "prefThreeAdapter$delegate", "prefTwoAdapter", "getPrefTwoAdapter", "prefTwoAdapter$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "preferenceVisible", "semId", "semPosition", "semesterArray", "", "getSemesterArray", "()Ljava/util/List;", "semesterIdArray", "getSemesterIdArray", "semesterList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/SemList;", "Lkotlin/collections/ArrayList;", "semesterQuestionsAdapter", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter;", "getSemesterQuestionsAdapter", "()Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter;", "semesterQuestionsAdapter$delegate", "semesterSubjectsAdapter", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter;", "getSemesterSubjectsAdapter", "()Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter;", "semesterSubjectsAdapter$delegate", "semesters", "semestersIds", "sgpaArray", "getSgpaArray", "sgpaMarks", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "subjects", "subjectsArray", "getSubjectsArray", "subjectsList", "Lin/etuwa/app/data/model/subjectregistration/SubjectsList;", "subjectsQuestionsAdapter", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegQuestionAdapter;", "getSubjectsQuestionsAdapter", "()Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegQuestionAdapter;", "subjectsQuestionsAdapter$delegate", "btnClicked", "", "btnClicked2", "convertKey", "input", "convertKey2", "hideProgress", "listenRegResponse", "listenSemResponse", "listenSubjectsResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onExceedMaxMark", "mark", "maxMark", "onSelectSubjectClicked", "onSgpaMarkChanged", "onSubMarkChanged", "onViewCreated", SvgConstants.Tags.VIEW, "preferenceCalculator", "reloadSavedPreference", "removePreference", "prefKey", "setCallBack", "context", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationFragment;", "setUp", "showProgress", "spinnerSelected", "dropDownPos", "swap", "T", "i", "j", "AddPublicationListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplyPreferenceSubRegDialog extends BaseDialog implements ApplyPreferenceSubRegAdapter.CallBack, ApplyPreferenceSubRegQuestionAdapter.CallBack, ApplyPreferenceSubRegSemQndAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogApplyPreferenceSubRegBinding _binding;

    /* renamed from: applyPreferenceSubRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy applyPreferenceSubRegViewModel;

    /* renamed from: categoryAdapter$delegate, reason: from kotlin metadata */
    private final Lazy categoryAdapter;
    private String categoryId;
    private boolean flag;
    private String id;
    private AddPublicationListener listener;

    /* renamed from: pathwayAdapter$delegate, reason: from kotlin metadata */
    private final Lazy pathwayAdapter;
    private String pathwayId;
    private int position;
    private boolean pref1Flag;
    private boolean pref2Flag;
    private boolean pref3Flag;
    private boolean pref4Flag;
    private boolean pref5Flag;

    /* renamed from: prefFiveAdapter$delegate, reason: from kotlin metadata */
    private final Lazy prefFiveAdapter;

    /* renamed from: prefFourAdapter$delegate, reason: from kotlin metadata */
    private final Lazy prefFourAdapter;

    /* renamed from: prefOneAdapter$delegate, reason: from kotlin metadata */
    private final Lazy prefOneAdapter;

    /* renamed from: prefThreeAdapter$delegate, reason: from kotlin metadata */
    private final Lazy prefThreeAdapter;

    /* renamed from: prefTwoAdapter$delegate, reason: from kotlin metadata */
    private final Lazy prefTwoAdapter;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private int preferenceVisible;
    private String semId;
    private int semPosition;
    private final List<String> semesterArray;
    private final List<String> semesterIdArray;
    private ArrayList<SemList> semesterList;

    /* renamed from: semesterQuestionsAdapter$delegate, reason: from kotlin metadata */
    private final Lazy semesterQuestionsAdapter;

    /* renamed from: semesterSubjectsAdapter$delegate, reason: from kotlin metadata */
    private final Lazy semesterSubjectsAdapter;
    private ArrayList<String> semesters;
    private ArrayList<String> semestersIds;
    private final List<String> sgpaArray;
    private ArrayList<String> sgpaMarks;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private ArrayList<String> subjects;
    private final List<String> subjectsArray;
    private ArrayList<SubjectsList> subjectsList;

    /* renamed from: subjectsQuestionsAdapter$delegate, reason: from kotlin metadata */
    private final Lazy subjectsQuestionsAdapter;

    /* compiled from: ApplyPreferenceSubRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog$AddPublicationListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddPublicationListener {
        void onDismiss();
    }

    /* compiled from: ApplyPreferenceSubRegDialog.kt */
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
    public static final ApplyPreferenceSubRegDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ApplyPreferenceSubRegDialog() {
        final ApplyPreferenceSubRegDialog applyPreferenceSubRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(applyPreferenceSubRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.applyPreferenceSubRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(applyPreferenceSubRegDialog, Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ApplyPreferenceSubRegDialog applyPreferenceSubRegDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.subjectsList = new ArrayList<>();
        this.semesterList = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.semesters = new ArrayList<>();
        this.semestersIds = new ArrayList<>();
        this.sgpaMarks = new ArrayList<>();
        this.pathwayId = "";
        this.categoryId = "";
        this.subjectsArray = new ArrayList();
        this.semesterArray = new ArrayList();
        this.semesterIdArray = new ArrayList();
        this.sgpaArray = new ArrayList();
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$prefOneAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.prefOneAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SubjectRegSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.SubjectRegSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectRegSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectRegSpinnerAdapter.class), b5, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$prefTwoAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.prefTwoAdapter = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SubjectRegSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.SubjectRegSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectRegSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectRegSpinnerAdapter.class), b6, function04);
            }
        });
        final Function0<ParametersHolder> function05 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$prefThreeAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        this.prefThreeAdapter = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<SubjectRegSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.SubjectRegSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectRegSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectRegSpinnerAdapter.class), b7, function05);
            }
        });
        final Function0<ParametersHolder> function06 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$prefFourAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        this.prefFourAdapter = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<SubjectRegSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.SubjectRegSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectRegSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectRegSpinnerAdapter.class), b8, function06);
            }
        });
        final Function0<ParametersHolder> function07 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$prefFiveAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode7 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b9 = 0 == true ? 1 : 0;
        this.prefFiveAdapter = LazyKt.lazy(lazyThreadSafetyMode7, (Function0) new Function0<SubjectRegSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.SubjectRegSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectRegSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectRegSpinnerAdapter.class), b9, function07);
            }
        });
        final Function0<ParametersHolder> function08 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$pathwayAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode8 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        this.pathwayAdapter = LazyKt.lazy(lazyThreadSafetyMode8, (Function0) new Function0<PathwaySpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.PathwaySpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PathwaySpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PathwaySpinnerAdapter.class), b10, function08);
            }
        });
        final Function0<ParametersHolder> function09 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$categoryAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyPreferenceSubRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode9 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b11 = 0 == true ? 1 : 0;
        this.categoryAdapter = LazyKt.lazy(lazyThreadSafetyMode9, (Function0) new Function0<PathwaySpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.PathwaySpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PathwaySpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PathwaySpinnerAdapter.class), b11, function09);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode10 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b12 = 0 == true ? 1 : 0;
        final byte b13 = 0 == true ? 1 : 0;
        this.subjectsQuestionsAdapter = LazyKt.lazy(lazyThreadSafetyMode10, (Function0) new Function0<ApplyPreferenceSubRegQuestionAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegQuestionAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplyPreferenceSubRegQuestionAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegQuestionAdapter.class), b12, b13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode11 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b14 = 0 == true ? 1 : 0;
        final byte b15 = 0 == true ? 1 : 0;
        this.semesterQuestionsAdapter = LazyKt.lazy(lazyThreadSafetyMode11, (Function0) new Function0<ApplyPreferenceSubRegSemQndAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplyPreferenceSubRegSemQndAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegSemQndAdapter.class), b14, b15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode12 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b16 = 0 == true ? 1 : 0;
        final byte b17 = 0 == true ? 1 : 0;
        this.semesterSubjectsAdapter = LazyKt.lazy(lazyThreadSafetyMode12, (Function0) new Function0<ApplyPreferenceSubRegAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplyPreferenceSubRegAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyPreferenceSubRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegAdapter.class), b16, b17);
            }
        });
    }

    private final ApplyPreferenceSubRegViewModel getApplyPreferenceSubRegViewModel() {
        return (ApplyPreferenceSubRegViewModel) this.applyPreferenceSubRegViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogApplyPreferenceSubRegBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final List<String> getSubjectsArray() {
        return this.subjectsArray;
    }

    public final List<String> getSemesterArray() {
        return this.semesterArray;
    }

    public final List<String> getSemesterIdArray() {
        return this.semesterIdArray;
    }

    public final List<String> getSgpaArray() {
        return this.sgpaArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectRegSpinnerAdapter getPrefOneAdapter() {
        return (SubjectRegSpinnerAdapter) this.prefOneAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectRegSpinnerAdapter getPrefTwoAdapter() {
        return (SubjectRegSpinnerAdapter) this.prefTwoAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectRegSpinnerAdapter getPrefThreeAdapter() {
        return (SubjectRegSpinnerAdapter) this.prefThreeAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectRegSpinnerAdapter getPrefFourAdapter() {
        return (SubjectRegSpinnerAdapter) this.prefFourAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectRegSpinnerAdapter getPrefFiveAdapter() {
        return (SubjectRegSpinnerAdapter) this.prefFiveAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PathwaySpinnerAdapter getPathwayAdapter() {
        return (PathwaySpinnerAdapter) this.pathwayAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PathwaySpinnerAdapter getCategoryAdapter() {
        return (PathwaySpinnerAdapter) this.categoryAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplyPreferenceSubRegQuestionAdapter getSubjectsQuestionsAdapter() {
        return (ApplyPreferenceSubRegQuestionAdapter) this.subjectsQuestionsAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplyPreferenceSubRegSemQndAdapter getSemesterQuestionsAdapter() {
        return (ApplyPreferenceSubRegSemQndAdapter) this.semesterQuestionsAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplyPreferenceSubRegAdapter getSemesterSubjectsAdapter() {
        return (ApplyPreferenceSubRegAdapter) this.semesterSubjectsAdapter.getValue();
    }

    /* compiled from: ApplyPreferenceSubRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ApplyPreferenceSubRegDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ApplyPreferenceSubRegDialog applyPreferenceSubRegDialog = new ApplyPreferenceSubRegDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            applyPreferenceSubRegDialog.setArguments(bundle);
            return applyPreferenceSubRegDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogApplyPreferenceSubRegBinding.inflate(inflater, container, false);
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = get_binding();
        if (dialogApplyPreferenceSubRegBinding != null) {
            dialogApplyPreferenceSubRegBinding.setApplyPreferenceSubRegViewModel(getApplyPreferenceSubRegViewModel());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = get_binding();
        if (dialogApplyPreferenceSubRegBinding2 != null) {
            dialogApplyPreferenceSubRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = get_binding();
        if (dialogApplyPreferenceSubRegBinding3 != null) {
            return dialogApplyPreferenceSubRegBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        CustomEditText customEditText;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = get_binding();
        RecyclerView recyclerView = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.rvSemList : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getSemesterSubjectsAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = get_binding();
        Spinner spinner = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.spinnerSemesterLastAttended : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = get_binding();
        RecyclerView recyclerView2 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.rvQuestionNo : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getSubjectsQuestionsAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = get_binding();
        RecyclerView recyclerView3 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.rvSemesterNo : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getSemesterQuestionsAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = get_binding();
        Spinner spinner2 = dialogApplyPreferenceSubRegBinding5 != null ? dialogApplyPreferenceSubRegBinding5.spinnerPreferenceOne : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getPrefOneAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = get_binding();
        Spinner spinner3 = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.spinnerPreferenceTwo : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getPrefTwoAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = get_binding();
        Spinner spinner4 = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.spinnerPreferenceThree : null;
        if (spinner4 != null) {
            spinner4.setAdapter((SpinnerAdapter) getPrefThreeAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = get_binding();
        Spinner spinner5 = dialogApplyPreferenceSubRegBinding8 != null ? dialogApplyPreferenceSubRegBinding8.spinnerPreferenceFour : null;
        if (spinner5 != null) {
            spinner5.setAdapter((SpinnerAdapter) getPrefFourAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = get_binding();
        Spinner spinner6 = dialogApplyPreferenceSubRegBinding9 != null ? dialogApplyPreferenceSubRegBinding9.spinnerPreferenceFive : null;
        if (spinner6 != null) {
            spinner6.setAdapter((SpinnerAdapter) getPrefFiveAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = get_binding();
        Spinner spinner7 = dialogApplyPreferenceSubRegBinding10 != null ? dialogApplyPreferenceSubRegBinding10.spinnerPathway : null;
        if (spinner7 != null) {
            spinner7.setAdapter((SpinnerAdapter) getPathwayAdapter());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = get_binding();
        Spinner spinner8 = dialogApplyPreferenceSubRegBinding11 != null ? dialogApplyPreferenceSubRegBinding11.spinnerCategory : null;
        if (spinner8 != null) {
            spinner8.setAdapter((SpinnerAdapter) getCategoryAdapter());
        }
        getSemesterQuestionsAdapter().setCallBack(this);
        getSubjectsQuestionsAdapter().setCallBack(this);
        getSemesterSubjectsAdapter().setCallBack(this);
        listenSubjectsResponse();
        listenSemResponse();
        listenRegResponse();
        getApplyPreferenceSubRegViewModel().getSemester();
        getApplyPreferenceSubRegViewModel().getSpinnerData(getPreference().getUserSemId());
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = get_binding();
        TextView textView11 = dialogApplyPreferenceSubRegBinding12 != null ? dialogApplyPreferenceSubRegBinding12.semTv : null;
        if (textView11 != null) {
            textView11.setText(getPreference().getUserSem());
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = get_binding();
        Spinner spinner9 = dialogApplyPreferenceSubRegBinding13 != null ? dialogApplyPreferenceSubRegBinding13.spinnerSemesterLastAttended : null;
        if (spinner9 != null) {
            spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter;
                    SharedPrefManager preference;
                    SemesterSpinnerAdapter spinnerAdapter2;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14;
                    SemesterSpinnerAdapter spinnerAdapter3;
                    Spinner spinner10;
                    spinnerAdapter = ApplyPreferenceSubRegDialog.this.getSpinnerAdapter();
                    int count = spinnerAdapter.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = ApplyPreferenceSubRegDialog.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter2 = ApplyPreferenceSubRegDialog.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter2.getSemester(i).getId())) {
                            dialogApplyPreferenceSubRegBinding14 = ApplyPreferenceSubRegDialog.this.get_binding();
                            if (dialogApplyPreferenceSubRegBinding14 != null && (spinner10 = dialogApplyPreferenceSubRegBinding14.spinnerSemesterLastAttended) != null) {
                                spinner10.setSelection(i);
                            }
                            ApplyPreferenceSubRegDialog applyPreferenceSubRegDialog = ApplyPreferenceSubRegDialog.this;
                            spinnerAdapter3 = applyPreferenceSubRegDialog.getSpinnerAdapter();
                            applyPreferenceSubRegDialog.semId = spinnerAdapter3.getSemester(position).getId();
                            return;
                        }
                    }
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = get_binding();
        Spinner spinner10 = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.spinnerPathway : null;
        if (spinner10 != null) {
            spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    PathwaySpinnerAdapter pathwayAdapter;
                    ApplyPreferenceSubRegDialog applyPreferenceSubRegDialog = ApplyPreferenceSubRegDialog.this;
                    pathwayAdapter = applyPreferenceSubRegDialog.getPathwayAdapter();
                    applyPreferenceSubRegDialog.pathwayId = String.valueOf(pathwayAdapter.getSubjects(position).getId());
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = get_binding();
        Spinner spinner11 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.spinnerCategory : null;
        if (spinner11 != null) {
            spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    PathwaySpinnerAdapter categoryAdapter;
                    ApplyPreferenceSubRegDialog applyPreferenceSubRegDialog = ApplyPreferenceSubRegDialog.this;
                    categoryAdapter = applyPreferenceSubRegDialog.getCategoryAdapter();
                    applyPreferenceSubRegDialog.categoryId = String.valueOf(categoryAdapter.getSubjects(position).getId());
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = get_binding();
        if (dialogApplyPreferenceSubRegBinding16 != null && (customEditText = dialogApplyPreferenceSubRegBinding16.sgpaMark) != null) {
            customEditText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$4
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String str;
                    ArrayList arrayList;
                    int i;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17;
                    ArrayList arrayList2;
                    int i2;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18;
                    RecyclerView recyclerView4;
                    CustomEditText customEditText2;
                    if (s == null || (str = s.toString()) == null) {
                        str = "";
                    }
                    try {
                        if (Double.parseDouble(str) > 10.0d) {
                            dialogApplyPreferenceSubRegBinding17 = ApplyPreferenceSubRegDialog.this.get_binding();
                            if (dialogApplyPreferenceSubRegBinding17 != null && (customEditText2 = dialogApplyPreferenceSubRegBinding17.sgpaMark) != null) {
                                customEditText2.setText("");
                            }
                            arrayList2 = ApplyPreferenceSubRegDialog.this.sgpaMarks;
                            i2 = ApplyPreferenceSubRegDialog.this.semPosition;
                            arrayList2.set(i2, "");
                            dialogApplyPreferenceSubRegBinding18 = ApplyPreferenceSubRegDialog.this.get_binding();
                            if (dialogApplyPreferenceSubRegBinding18 == null || (recyclerView4 = dialogApplyPreferenceSubRegBinding18.rvSemList) == null) {
                                return;
                            }
                            ToastExtKt.showErrorToast(recyclerView4, "Sgpa cant exceed 10");
                            return;
                        }
                        arrayList = ApplyPreferenceSubRegDialog.this.sgpaMarks;
                        i = ApplyPreferenceSubRegDialog.this.semPosition;
                        arrayList.set(i, str);
                    } catch (NumberFormatException unused) {
                    }
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = get_binding();
        Spinner spinner12 = dialogApplyPreferenceSubRegBinding17 != null ? dialogApplyPreferenceSubRegBinding17.spinnerPreferenceOne : null;
        if (spinner12 != null) {
            spinner12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int positions, long id) {
                    ArrayList arrayList;
                    int i;
                    ArrayList arrayList2;
                    int i2;
                    ArrayList arrayList3;
                    int i3;
                    ArrayList arrayList4;
                    int i4;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19;
                    Spinner spinner13;
                    Spinner spinner14;
                    ArrayList arrayList5;
                    int i5;
                    ArrayList arrayList6;
                    int i6;
                    ArrayList arrayList7;
                    int i7;
                    ArrayList arrayList8;
                    int i8;
                    ArrayList arrayList9;
                    int i9;
                    ArrayList arrayList10;
                    int i10;
                    ArrayList arrayList11;
                    int i11;
                    int i12 = 0;
                    if (positions <= 0) {
                        if (positions == 0) {
                            arrayList = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i = ApplyPreferenceSubRegDialog.this.position;
                            int size = ((SubjectsList) arrayList.get(i)).getSubjects().size();
                            while (i12 < size) {
                                arrayList2 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i2 = ApplyPreferenceSubRegDialog.this.position;
                                if (Intrinsics.areEqual(((SubjectsList) arrayList2.get(i2)).getSubjects().get(i12).getAns(), "preference1")) {
                                    arrayList3 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i3 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList3.get(i3)).getSubjects().get(i12).setAns("");
                                }
                                i12++;
                            }
                            return;
                        }
                        return;
                    }
                    arrayList4 = ApplyPreferenceSubRegDialog.this.subjectsList;
                    i4 = ApplyPreferenceSubRegDialog.this.position;
                    int i13 = positions - 1;
                    if (!Intrinsics.areEqual(((SubjectsList) arrayList4.get(i4)).getSubjects().get(i13).getAns(), "preference2")) {
                        arrayList5 = ApplyPreferenceSubRegDialog.this.subjectsList;
                        i5 = ApplyPreferenceSubRegDialog.this.position;
                        if (!Intrinsics.areEqual(((SubjectsList) arrayList5.get(i5)).getSubjects().get(i13).getAns(), "preference3")) {
                            arrayList6 = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i6 = ApplyPreferenceSubRegDialog.this.position;
                            if (!Intrinsics.areEqual(((SubjectsList) arrayList6.get(i6)).getSubjects().get(i13).getAns(), "preference4")) {
                                arrayList7 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i7 = ApplyPreferenceSubRegDialog.this.position;
                                if (!Intrinsics.areEqual(((SubjectsList) arrayList7.get(i7)).getSubjects().get(i13).getAns(), "preference5")) {
                                    arrayList8 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i8 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList8.get(i8)).getSubjects().get(i13).setAns("preference1");
                                    arrayList9 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i9 = ApplyPreferenceSubRegDialog.this.position;
                                    int size2 = ((SubjectsList) arrayList9.get(i9)).getSubjects().size();
                                    while (i12 < size2) {
                                        arrayList10 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                        i10 = ApplyPreferenceSubRegDialog.this.position;
                                        if (Intrinsics.areEqual(((SubjectsList) arrayList10.get(i10)).getSubjects().get(i12).getAns(), "preference1") && i12 != i13) {
                                            arrayList11 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                            i11 = ApplyPreferenceSubRegDialog.this.position;
                                            ((SubjectsList) arrayList11.get(i11)).getSubjects().get(i12).setAns("");
                                        }
                                        i12++;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    dialogApplyPreferenceSubRegBinding18 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding18 != null && (spinner14 = dialogApplyPreferenceSubRegBinding18.spinnerPreferenceOne) != null) {
                        spinner14.setSelection(0);
                    }
                    dialogApplyPreferenceSubRegBinding19 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding19 == null || (spinner13 = dialogApplyPreferenceSubRegBinding19.spinnerPreferenceOne) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(spinner13, "You have already chosen this Subject");
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = get_binding();
        Spinner spinner13 = dialogApplyPreferenceSubRegBinding18 != null ? dialogApplyPreferenceSubRegBinding18.spinnerPreferenceTwo : null;
        if (spinner13 != null) {
            spinner13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$6
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int positions, long id) {
                    ArrayList arrayList;
                    int i;
                    ArrayList arrayList2;
                    int i2;
                    ArrayList arrayList3;
                    int i3;
                    ArrayList arrayList4;
                    int i4;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20;
                    Spinner spinner14;
                    Spinner spinner15;
                    ArrayList arrayList5;
                    int i5;
                    ArrayList arrayList6;
                    int i6;
                    ArrayList arrayList7;
                    int i7;
                    ArrayList arrayList8;
                    int i8;
                    ArrayList arrayList9;
                    int i9;
                    ArrayList arrayList10;
                    int i10;
                    ArrayList arrayList11;
                    int i11;
                    int i12 = 0;
                    if (positions <= 0) {
                        if (positions == 0) {
                            arrayList = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i = ApplyPreferenceSubRegDialog.this.position;
                            int size = ((SubjectsList) arrayList.get(i)).getSubjects().size();
                            while (i12 < size) {
                                arrayList2 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i2 = ApplyPreferenceSubRegDialog.this.position;
                                if (Intrinsics.areEqual(((SubjectsList) arrayList2.get(i2)).getSubjects().get(i12).getAns(), "preference2")) {
                                    arrayList3 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i3 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList3.get(i3)).getSubjects().get(i12).setAns("");
                                }
                                i12++;
                            }
                            return;
                        }
                        return;
                    }
                    arrayList4 = ApplyPreferenceSubRegDialog.this.subjectsList;
                    i4 = ApplyPreferenceSubRegDialog.this.position;
                    int i13 = positions - 1;
                    if (!Intrinsics.areEqual(((SubjectsList) arrayList4.get(i4)).getSubjects().get(i13).getAns(), "preference1")) {
                        arrayList5 = ApplyPreferenceSubRegDialog.this.subjectsList;
                        i5 = ApplyPreferenceSubRegDialog.this.position;
                        if (!Intrinsics.areEqual(((SubjectsList) arrayList5.get(i5)).getSubjects().get(i13).getAns(), "preference3")) {
                            arrayList6 = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i6 = ApplyPreferenceSubRegDialog.this.position;
                            if (!Intrinsics.areEqual(((SubjectsList) arrayList6.get(i6)).getSubjects().get(i13).getAns(), "preference4")) {
                                arrayList7 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i7 = ApplyPreferenceSubRegDialog.this.position;
                                if (!Intrinsics.areEqual(((SubjectsList) arrayList7.get(i7)).getSubjects().get(i13).getAns(), "preference5")) {
                                    arrayList8 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i8 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList8.get(i8)).getSubjects().get(i13).setAns("preference2");
                                    arrayList9 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i9 = ApplyPreferenceSubRegDialog.this.position;
                                    int size2 = ((SubjectsList) arrayList9.get(i9)).getSubjects().size();
                                    while (i12 < size2) {
                                        arrayList10 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                        i10 = ApplyPreferenceSubRegDialog.this.position;
                                        if (Intrinsics.areEqual(((SubjectsList) arrayList10.get(i10)).getSubjects().get(i12).getAns(), "preference2") && i12 != i13) {
                                            arrayList11 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                            i11 = ApplyPreferenceSubRegDialog.this.position;
                                            ((SubjectsList) arrayList11.get(i11)).getSubjects().get(i12).setAns("");
                                        }
                                        i12++;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    dialogApplyPreferenceSubRegBinding19 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding19 != null && (spinner15 = dialogApplyPreferenceSubRegBinding19.spinnerPreferenceTwo) != null) {
                        spinner15.setSelection(0);
                    }
                    dialogApplyPreferenceSubRegBinding20 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding20 == null || (spinner14 = dialogApplyPreferenceSubRegBinding20.spinnerPreferenceOne) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(spinner14, "You have already chosen this Subject");
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = get_binding();
        Spinner spinner14 = dialogApplyPreferenceSubRegBinding19 != null ? dialogApplyPreferenceSubRegBinding19.spinnerPreferenceThree : null;
        if (spinner14 != null) {
            spinner14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$7
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int positions, long id) {
                    ArrayList arrayList;
                    int i;
                    ArrayList arrayList2;
                    int i2;
                    ArrayList arrayList3;
                    int i3;
                    ArrayList arrayList4;
                    int i4;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21;
                    Spinner spinner15;
                    Spinner spinner16;
                    ArrayList arrayList5;
                    int i5;
                    ArrayList arrayList6;
                    int i6;
                    ArrayList arrayList7;
                    int i7;
                    ArrayList arrayList8;
                    int i8;
                    ArrayList arrayList9;
                    int i9;
                    ArrayList arrayList10;
                    int i10;
                    ArrayList arrayList11;
                    int i11;
                    int i12 = 0;
                    if (positions <= 0) {
                        if (positions == 0) {
                            arrayList = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i = ApplyPreferenceSubRegDialog.this.position;
                            int size = ((SubjectsList) arrayList.get(i)).getSubjects().size();
                            while (i12 < size) {
                                arrayList2 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i2 = ApplyPreferenceSubRegDialog.this.position;
                                if (Intrinsics.areEqual(((SubjectsList) arrayList2.get(i2)).getSubjects().get(i12).getAns(), "preference3")) {
                                    arrayList3 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i3 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList3.get(i3)).getSubjects().get(i12).setAns("");
                                }
                                i12++;
                            }
                            return;
                        }
                        return;
                    }
                    arrayList4 = ApplyPreferenceSubRegDialog.this.subjectsList;
                    i4 = ApplyPreferenceSubRegDialog.this.position;
                    int i13 = positions - 1;
                    if (!Intrinsics.areEqual(((SubjectsList) arrayList4.get(i4)).getSubjects().get(i13).getAns(), "preference2")) {
                        arrayList5 = ApplyPreferenceSubRegDialog.this.subjectsList;
                        i5 = ApplyPreferenceSubRegDialog.this.position;
                        if (!Intrinsics.areEqual(((SubjectsList) arrayList5.get(i5)).getSubjects().get(i13).getAns(), "preference1")) {
                            arrayList6 = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i6 = ApplyPreferenceSubRegDialog.this.position;
                            if (!Intrinsics.areEqual(((SubjectsList) arrayList6.get(i6)).getSubjects().get(i13).getAns(), "preference4")) {
                                arrayList7 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i7 = ApplyPreferenceSubRegDialog.this.position;
                                if (!Intrinsics.areEqual(((SubjectsList) arrayList7.get(i7)).getSubjects().get(i13).getAns(), "preference5")) {
                                    arrayList8 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i8 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList8.get(i8)).getSubjects().get(i13).setAns("preference3");
                                    arrayList9 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i9 = ApplyPreferenceSubRegDialog.this.position;
                                    int size2 = ((SubjectsList) arrayList9.get(i9)).getSubjects().size();
                                    while (i12 < size2) {
                                        arrayList10 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                        i10 = ApplyPreferenceSubRegDialog.this.position;
                                        if (Intrinsics.areEqual(((SubjectsList) arrayList10.get(i10)).getSubjects().get(i12).getAns(), "preference3") && i12 != i13) {
                                            arrayList11 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                            i11 = ApplyPreferenceSubRegDialog.this.position;
                                            ((SubjectsList) arrayList11.get(i11)).getSubjects().get(i12).setAns("");
                                        }
                                        i12++;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    dialogApplyPreferenceSubRegBinding20 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding20 != null && (spinner16 = dialogApplyPreferenceSubRegBinding20.spinnerPreferenceThree) != null) {
                        spinner16.setSelection(0);
                    }
                    dialogApplyPreferenceSubRegBinding21 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding21 == null || (spinner15 = dialogApplyPreferenceSubRegBinding21.spinnerPreferenceOne) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(spinner15, "You have already chosen this Subject");
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20 = get_binding();
        Spinner spinner15 = dialogApplyPreferenceSubRegBinding20 != null ? dialogApplyPreferenceSubRegBinding20.spinnerPreferenceFour : null;
        if (spinner15 != null) {
            spinner15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$8
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int positions, long id) {
                    ArrayList arrayList;
                    int i;
                    ArrayList arrayList2;
                    int i2;
                    ArrayList arrayList3;
                    int i3;
                    ArrayList arrayList4;
                    int i4;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding22;
                    Spinner spinner16;
                    Spinner spinner17;
                    ArrayList arrayList5;
                    int i5;
                    ArrayList arrayList6;
                    int i6;
                    ArrayList arrayList7;
                    int i7;
                    ArrayList arrayList8;
                    int i8;
                    ArrayList arrayList9;
                    int i9;
                    ArrayList arrayList10;
                    int i10;
                    ArrayList arrayList11;
                    int i11;
                    int i12 = 0;
                    if (positions <= 0) {
                        if (positions == 0) {
                            arrayList = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i = ApplyPreferenceSubRegDialog.this.position;
                            int size = ((SubjectsList) arrayList.get(i)).getSubjects().size();
                            while (i12 < size) {
                                arrayList2 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i2 = ApplyPreferenceSubRegDialog.this.position;
                                if (Intrinsics.areEqual(((SubjectsList) arrayList2.get(i2)).getSubjects().get(i12).getAns(), "preference4")) {
                                    arrayList3 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i3 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList3.get(i3)).getSubjects().get(i12).setAns("");
                                }
                                i12++;
                            }
                            return;
                        }
                        return;
                    }
                    arrayList4 = ApplyPreferenceSubRegDialog.this.subjectsList;
                    i4 = ApplyPreferenceSubRegDialog.this.position;
                    int i13 = positions - 1;
                    if (!Intrinsics.areEqual(((SubjectsList) arrayList4.get(i4)).getSubjects().get(i13).getAns(), "preference2")) {
                        arrayList5 = ApplyPreferenceSubRegDialog.this.subjectsList;
                        i5 = ApplyPreferenceSubRegDialog.this.position;
                        if (!Intrinsics.areEqual(((SubjectsList) arrayList5.get(i5)).getSubjects().get(i13).getAns(), "preference3")) {
                            arrayList6 = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i6 = ApplyPreferenceSubRegDialog.this.position;
                            if (!Intrinsics.areEqual(((SubjectsList) arrayList6.get(i6)).getSubjects().get(i13).getAns(), "preference1")) {
                                arrayList7 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i7 = ApplyPreferenceSubRegDialog.this.position;
                                if (!Intrinsics.areEqual(((SubjectsList) arrayList7.get(i7)).getSubjects().get(i13).getAns(), "preference5")) {
                                    arrayList8 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i8 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList8.get(i8)).getSubjects().get(i13).setAns("preference4");
                                    arrayList9 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i9 = ApplyPreferenceSubRegDialog.this.position;
                                    int size2 = ((SubjectsList) arrayList9.get(i9)).getSubjects().size();
                                    while (i12 < size2) {
                                        arrayList10 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                        i10 = ApplyPreferenceSubRegDialog.this.position;
                                        if (Intrinsics.areEqual(((SubjectsList) arrayList10.get(i10)).getSubjects().get(i12).getAns(), "preference4") && i12 != i13) {
                                            arrayList11 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                            i11 = ApplyPreferenceSubRegDialog.this.position;
                                            ((SubjectsList) arrayList11.get(i11)).getSubjects().get(i12).setAns("");
                                        }
                                        i12++;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    dialogApplyPreferenceSubRegBinding21 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding21 != null && (spinner17 = dialogApplyPreferenceSubRegBinding21.spinnerPreferenceFour) != null) {
                        spinner17.setSelection(0);
                    }
                    dialogApplyPreferenceSubRegBinding22 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding22 == null || (spinner16 = dialogApplyPreferenceSubRegBinding22.spinnerPreferenceOne) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(spinner16, "You have already chosen this Subject");
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21 = get_binding();
        Spinner spinner16 = dialogApplyPreferenceSubRegBinding21 != null ? dialogApplyPreferenceSubRegBinding21.spinnerPreferenceFive : null;
        if (spinner16 != null) {
            spinner16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$setUp$9
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int positions, long id) {
                    ArrayList arrayList;
                    int i;
                    ArrayList arrayList2;
                    int i2;
                    ArrayList arrayList3;
                    int i3;
                    ArrayList arrayList4;
                    int i4;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding22;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding23;
                    Spinner spinner17;
                    Spinner spinner18;
                    ArrayList arrayList5;
                    int i5;
                    ArrayList arrayList6;
                    int i6;
                    ArrayList arrayList7;
                    int i7;
                    ArrayList arrayList8;
                    int i8;
                    ArrayList arrayList9;
                    int i9;
                    ArrayList arrayList10;
                    int i10;
                    ArrayList arrayList11;
                    int i11;
                    int i12 = 0;
                    if (positions <= 0) {
                        if (positions == 0) {
                            arrayList = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i = ApplyPreferenceSubRegDialog.this.position;
                            int size = ((SubjectsList) arrayList.get(i)).getSubjects().size();
                            while (i12 < size) {
                                arrayList2 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i2 = ApplyPreferenceSubRegDialog.this.position;
                                if (Intrinsics.areEqual(((SubjectsList) arrayList2.get(i2)).getSubjects().get(i12).getAns(), "preference5")) {
                                    arrayList3 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i3 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList3.get(i3)).getSubjects().get(i12).setAns("");
                                }
                                i12++;
                            }
                            return;
                        }
                        return;
                    }
                    arrayList4 = ApplyPreferenceSubRegDialog.this.subjectsList;
                    i4 = ApplyPreferenceSubRegDialog.this.position;
                    int i13 = positions - 1;
                    if (!Intrinsics.areEqual(((SubjectsList) arrayList4.get(i4)).getSubjects().get(i13).getAns(), "preference2")) {
                        arrayList5 = ApplyPreferenceSubRegDialog.this.subjectsList;
                        i5 = ApplyPreferenceSubRegDialog.this.position;
                        if (!Intrinsics.areEqual(((SubjectsList) arrayList5.get(i5)).getSubjects().get(i13).getAns(), "preference3")) {
                            arrayList6 = ApplyPreferenceSubRegDialog.this.subjectsList;
                            i6 = ApplyPreferenceSubRegDialog.this.position;
                            if (!Intrinsics.areEqual(((SubjectsList) arrayList6.get(i6)).getSubjects().get(i13).getAns(), "preference4")) {
                                arrayList7 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                i7 = ApplyPreferenceSubRegDialog.this.position;
                                if (!Intrinsics.areEqual(((SubjectsList) arrayList7.get(i7)).getSubjects().get(i13).getAns(), "preference1")) {
                                    arrayList8 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i8 = ApplyPreferenceSubRegDialog.this.position;
                                    ((SubjectsList) arrayList8.get(i8)).getSubjects().get(i13).setAns("preference5");
                                    arrayList9 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                    i9 = ApplyPreferenceSubRegDialog.this.position;
                                    int size2 = ((SubjectsList) arrayList9.get(i9)).getSubjects().size();
                                    while (i12 < size2) {
                                        arrayList10 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                        i10 = ApplyPreferenceSubRegDialog.this.position;
                                        if (Intrinsics.areEqual(((SubjectsList) arrayList10.get(i10)).getSubjects().get(i12).getAns(), "preference5") && i12 != i13) {
                                            arrayList11 = ApplyPreferenceSubRegDialog.this.subjectsList;
                                            i11 = ApplyPreferenceSubRegDialog.this.position;
                                            ((SubjectsList) arrayList11.get(i11)).getSubjects().get(i12).setAns("");
                                        }
                                        i12++;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    dialogApplyPreferenceSubRegBinding22 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding22 != null && (spinner18 = dialogApplyPreferenceSubRegBinding22.spinnerPreferenceFive) != null) {
                        spinner18.setSelection(0);
                    }
                    dialogApplyPreferenceSubRegBinding23 = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding23 == null || (spinner17 = dialogApplyPreferenceSubRegBinding23.spinnerPreferenceOne) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(spinner17, "You have already chosen this Subject");
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding22 = get_binding();
        if (dialogApplyPreferenceSubRegBinding22 != null && (textView10 = dialogApplyPreferenceSubRegBinding22.nextBtn) != null) {
            textView10.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$1(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding23 = get_binding();
        if (dialogApplyPreferenceSubRegBinding23 != null && (textView9 = dialogApplyPreferenceSubRegBinding23.backBtn) != null) {
            textView9.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$2(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding24 = get_binding();
        if (dialogApplyPreferenceSubRegBinding24 != null && (textView8 = dialogApplyPreferenceSubRegBinding24.addBtn) != null) {
            textView8.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$3(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding25 = get_binding();
        if (dialogApplyPreferenceSubRegBinding25 != null && (textView7 = dialogApplyPreferenceSubRegBinding25.removeBtnOne) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$4(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding26 = get_binding();
        if (dialogApplyPreferenceSubRegBinding26 != null && (textView6 = dialogApplyPreferenceSubRegBinding26.removeBtnTwo) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$5(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding27 = get_binding();
        if (dialogApplyPreferenceSubRegBinding27 != null && (textView5 = dialogApplyPreferenceSubRegBinding27.removeBtnThree) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$6(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding28 = get_binding();
        if (dialogApplyPreferenceSubRegBinding28 != null && (textView4 = dialogApplyPreferenceSubRegBinding28.removeBtnFour) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$7(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding29 = get_binding();
        if (dialogApplyPreferenceSubRegBinding29 != null && (textView3 = dialogApplyPreferenceSubRegBinding29.semHistoryBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$8(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding30 = get_binding();
        if (dialogApplyPreferenceSubRegBinding30 != null && (textView2 = dialogApplyPreferenceSubRegBinding30.subjectsBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyPreferenceSubRegDialog.setUp$lambda$9(ApplyPreferenceSubRegDialog.this, view);
                }
            });
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding31 = get_binding();
        if (dialogApplyPreferenceSubRegBinding31 == null || (textView = dialogApplyPreferenceSubRegBinding31.finishBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyPreferenceSubRegDialog.setUp$lambda$14(ApplyPreferenceSubRegDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ApplyPreferenceSubRegDialog this$0, View view) {
        CustomEditText customEditText;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        RecyclerView recyclerView5;
        RecyclerView recyclerView6;
        RecyclerView recyclerView7;
        RecyclerView recyclerView8;
        CustomEditText customEditText2;
        RecyclerView recyclerView9;
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        Spinner spinner4;
        Spinner spinner5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.flag) {
            this$0.pref1Flag = false;
            this$0.pref2Flag = false;
            this$0.pref3Flag = false;
            this$0.pref4Flag = false;
            this$0.pref5Flag = false;
            this$0.position++;
            this$0.preferenceVisible = 0;
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
            TextView textView = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.addBtn : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
            TextView textView2 = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.backBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (this$0.position == this$0.subjectsList.size() - 1) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = this$0.get_binding();
                TextView textView3 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.nextBtn : null;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = this$0.get_binding();
                TextView textView4 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.finishBtn : null;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = this$0.get_binding();
                TextView textView5 = dialogApplyPreferenceSubRegBinding5 != null ? dialogApplyPreferenceSubRegBinding5.nextBtn : null;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = this$0.get_binding();
                TextView textView6 = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.finishBtn : null;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
            }
            this$0.getSubjectsQuestionsAdapter().addItems(this$0.subjects, this$0.position);
            this$0.getPrefOneAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 1");
            this$0.getPrefTwoAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 2");
            this$0.getPrefThreeAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 3");
            this$0.getPrefFourAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 4");
            this$0.getPrefFiveAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 5");
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding7 != null && (spinner5 = dialogApplyPreferenceSubRegBinding7.spinnerPreferenceOne) != null) {
                spinner5.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding8 != null && (spinner4 = dialogApplyPreferenceSubRegBinding8.spinnerPreferenceTwo) != null) {
                spinner4.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding9 != null && (spinner3 = dialogApplyPreferenceSubRegBinding9.spinnerPreferenceThree) != null) {
                spinner3.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding10 != null && (spinner2 = dialogApplyPreferenceSubRegBinding10.spinnerPreferenceFour) != null) {
                spinner2.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding11 != null && (spinner = dialogApplyPreferenceSubRegBinding11.spinnerPreferenceFive) != null) {
                spinner.setSelection(0);
            }
            this$0.reloadSavedPreference();
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding12 == null || (recyclerView9 = dialogApplyPreferenceSubRegBinding12.rvQuestionNo) == null) {
                return;
            }
            recyclerView9.scrollToPosition(this$0.position);
            return;
        }
        ArrayList<String> arrayList = this$0.sgpaMarks;
        int i = this$0.semPosition;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = this$0.get_binding();
        arrayList.set(i, String.valueOf((dialogApplyPreferenceSubRegBinding13 == null || (customEditText2 = dialogApplyPreferenceSubRegBinding13.sgpaMark) == null) ? null : customEditText2.getText()));
        int size = this$0.semesterList.get(this$0.semPosition).getSubjects().size();
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            if (Intrinsics.areEqual(this$0.semesterList.get(this$0.semPosition).getSubjects().get(i2).getAns(), "")) {
                z2 = true;
            }
            if (Intrinsics.areEqual(this$0.semesterList.get(this$0.semPosition).getSubjects().get(i2).getMark(), "")) {
                z = true;
            }
        }
        boolean areEqual = Intrinsics.areEqual(this$0.sgpaMarks.get(this$0.semPosition), "");
        if (z && z2 && areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding14 != null && (recyclerView8 = dialogApplyPreferenceSubRegBinding14.rvSemList) != null) {
                ToastExtKt.showErrorToast(recyclerView8, "All Marks, SGPA, and Subjects are mandatory before proceeding.");
            }
        } else if (z && z2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding15 != null && (recyclerView6 = dialogApplyPreferenceSubRegBinding15.rvSemList) != null) {
                ToastExtKt.showErrorToast(recyclerView6, "Marks and Subjects are mandatory before proceeding.");
            }
        } else if (z && areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding16 != null && (recyclerView5 = dialogApplyPreferenceSubRegBinding16.rvSemList) != null) {
                ToastExtKt.showErrorToast(recyclerView5, "Marks and SGPA are mandatory before proceeding.");
            }
        } else if (z2 && areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding17 != null && (recyclerView4 = dialogApplyPreferenceSubRegBinding17.rvSemList) != null) {
                ToastExtKt.showErrorToast(recyclerView4, "Subjects and SGPA are mandatory before proceeding.");
            }
        } else if (z) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding18 != null && (recyclerView3 = dialogApplyPreferenceSubRegBinding18.rvSemList) != null) {
                ToastExtKt.showErrorToast(recyclerView3, "Marks are mandatory before proceeding.");
            }
        } else if (z2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding19 != null && (recyclerView2 = dialogApplyPreferenceSubRegBinding19.rvSemList) != null) {
                ToastExtKt.showErrorToast(recyclerView2, "Subjects are mandatory before proceeding.");
            }
        } else if (areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding20 != null && (recyclerView = dialogApplyPreferenceSubRegBinding20.rvSemList) != null) {
                ToastExtKt.showErrorToast(recyclerView, "SGPA is mandatory before proceeding.");
            }
        } else {
            this$0.semPosition++;
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding21 != null && (customEditText = dialogApplyPreferenceSubRegBinding21.sgpaMark) != null) {
                customEditText.setText(this$0.sgpaMarks.get(this$0.semPosition));
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding22 = this$0.get_binding();
            TextView textView7 = dialogApplyPreferenceSubRegBinding22 != null ? dialogApplyPreferenceSubRegBinding22.addBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding23 = this$0.get_binding();
            TextView textView8 = dialogApplyPreferenceSubRegBinding23 != null ? dialogApplyPreferenceSubRegBinding23.backBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            if (this$0.semPosition == this$0.semesterList.size() - 1) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding24 = this$0.get_binding();
                TextView textView9 = dialogApplyPreferenceSubRegBinding24 != null ? dialogApplyPreferenceSubRegBinding24.nextBtn : null;
                if (textView9 != null) {
                    textView9.setVisibility(8);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding25 = this$0.get_binding();
                TextView textView10 = dialogApplyPreferenceSubRegBinding25 != null ? dialogApplyPreferenceSubRegBinding25.finishBtn : null;
                if (textView10 != null) {
                    textView10.setVisibility(0);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding26 = this$0.get_binding();
                TextView textView11 = dialogApplyPreferenceSubRegBinding26 != null ? dialogApplyPreferenceSubRegBinding26.nextBtn : null;
                if (textView11 != null) {
                    textView11.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding27 = this$0.get_binding();
                TextView textView12 = dialogApplyPreferenceSubRegBinding27 != null ? dialogApplyPreferenceSubRegBinding27.finishBtn : null;
                if (textView12 != null) {
                    textView12.setVisibility(8);
                }
            }
            this$0.getSemesterQuestionsAdapter().addItems(this$0.semesters, this$0.semPosition);
            if (this$0.semesterList.get(this$0.semPosition).getSubjects().size() > 0) {
                this$0.getSemesterSubjectsAdapter().addItems(this$0.semesterList.get(this$0.semPosition).getSubjects(), this$0.semPosition);
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding28 = this$0.get_binding();
                RecyclerView recyclerView10 = dialogApplyPreferenceSubRegBinding28 != null ? dialogApplyPreferenceSubRegBinding28.rvSemList : null;
                if (recyclerView10 != null) {
                    recyclerView10.setVisibility(0);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding29 = this$0.get_binding();
                RecyclerView recyclerView11 = dialogApplyPreferenceSubRegBinding29 != null ? dialogApplyPreferenceSubRegBinding29.rvSemList : null;
                if (recyclerView11 != null) {
                    recyclerView11.setVisibility(8);
                }
            }
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding30 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding30 == null || (recyclerView7 = dialogApplyPreferenceSubRegBinding30.rvSemesterNo) == null) {
            return;
        }
        recyclerView7.scrollToPosition(this$0.semPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ApplyPreferenceSubRegDialog this$0, View view) {
        CustomEditText customEditText;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        Spinner spinner4;
        Spinner spinner5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.flag) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
            TextView textView = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.addBtn : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
            TextView textView2 = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.nextBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            int i = this$0.position - 1;
            this$0.position = i;
            this$0.preferenceVisible = 0;
            if (i == 0) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = this$0.get_binding();
                TextView textView3 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.backBtn : null;
                if (textView3 != null) {
                    textView3.setVisibility(4);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = this$0.get_binding();
                TextView textView4 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.backBtn : null;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            }
            if (this$0.position == this$0.subjectsList.size() - 1) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = this$0.get_binding();
                TextView textView5 = dialogApplyPreferenceSubRegBinding5 != null ? dialogApplyPreferenceSubRegBinding5.nextBtn : null;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = this$0.get_binding();
                TextView textView6 = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.finishBtn : null;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = this$0.get_binding();
                TextView textView7 = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.nextBtn : null;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = this$0.get_binding();
                TextView textView8 = dialogApplyPreferenceSubRegBinding8 != null ? dialogApplyPreferenceSubRegBinding8.finishBtn : null;
                if (textView8 != null) {
                    textView8.setVisibility(8);
                }
            }
            this$0.getSubjectsQuestionsAdapter().addItems(this$0.subjects, this$0.position);
            this$0.getPrefOneAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 1");
            this$0.getPrefTwoAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 2");
            this$0.getPrefThreeAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 3");
            this$0.getPrefFourAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 4");
            this$0.getPrefFiveAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 5");
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding9 != null && (spinner5 = dialogApplyPreferenceSubRegBinding9.spinnerPreferenceOne) != null) {
                spinner5.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding10 != null && (spinner4 = dialogApplyPreferenceSubRegBinding10.spinnerPreferenceTwo) != null) {
                spinner4.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding11 != null && (spinner3 = dialogApplyPreferenceSubRegBinding11.spinnerPreferenceThree) != null) {
                spinner3.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding12 != null && (spinner2 = dialogApplyPreferenceSubRegBinding12.spinnerPreferenceFour) != null) {
                spinner2.setSelection(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding13 != null && (spinner = dialogApplyPreferenceSubRegBinding13.spinnerPreferenceFive) != null) {
                spinner.setSelection(0);
            }
            this$0.reloadSavedPreference();
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding14 != null && (recyclerView2 = dialogApplyPreferenceSubRegBinding14.rvQuestionNo) != null) {
                recyclerView2.scrollToPosition(this$0.position);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = this$0.get_binding();
            TextView textView9 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.addBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = this$0.get_binding();
            TextView textView10 = dialogApplyPreferenceSubRegBinding16 != null ? dialogApplyPreferenceSubRegBinding16.nextBtn : null;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            this$0.semPosition--;
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding17 != null && (customEditText = dialogApplyPreferenceSubRegBinding17.sgpaMark) != null) {
                customEditText.setText(this$0.sgpaMarks.get(this$0.semPosition));
            }
            if (this$0.semPosition == 0) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = this$0.get_binding();
                TextView textView11 = dialogApplyPreferenceSubRegBinding18 != null ? dialogApplyPreferenceSubRegBinding18.backBtn : null;
                if (textView11 != null) {
                    textView11.setVisibility(4);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = this$0.get_binding();
                TextView textView12 = dialogApplyPreferenceSubRegBinding19 != null ? dialogApplyPreferenceSubRegBinding19.backBtn : null;
                if (textView12 != null) {
                    textView12.setVisibility(0);
                }
            }
            if (this$0.semPosition == this$0.semesterList.size() - 1) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20 = this$0.get_binding();
                TextView textView13 = dialogApplyPreferenceSubRegBinding20 != null ? dialogApplyPreferenceSubRegBinding20.nextBtn : null;
                if (textView13 != null) {
                    textView13.setVisibility(8);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21 = this$0.get_binding();
                TextView textView14 = dialogApplyPreferenceSubRegBinding21 != null ? dialogApplyPreferenceSubRegBinding21.finishBtn : null;
                if (textView14 != null) {
                    textView14.setVisibility(0);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding22 = this$0.get_binding();
                TextView textView15 = dialogApplyPreferenceSubRegBinding22 != null ? dialogApplyPreferenceSubRegBinding22.nextBtn : null;
                if (textView15 != null) {
                    textView15.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding23 = this$0.get_binding();
                TextView textView16 = dialogApplyPreferenceSubRegBinding23 != null ? dialogApplyPreferenceSubRegBinding23.finishBtn : null;
                if (textView16 != null) {
                    textView16.setVisibility(8);
                }
            }
            this$0.getSemesterQuestionsAdapter().addItems(this$0.semesters, this$0.semPosition);
            if (this$0.semesterList.get(this$0.semPosition).getSubjects().size() > 0) {
                this$0.getSemesterSubjectsAdapter().addItems(this$0.semesterList.get(this$0.semPosition).getSubjects(), this$0.semPosition);
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding24 = this$0.get_binding();
                RecyclerView recyclerView3 = dialogApplyPreferenceSubRegBinding24 != null ? dialogApplyPreferenceSubRegBinding24.rvSemList : null;
                if (recyclerView3 != null) {
                    recyclerView3.setVisibility(0);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding25 = this$0.get_binding();
                RecyclerView recyclerView4 = dialogApplyPreferenceSubRegBinding25 != null ? dialogApplyPreferenceSubRegBinding25.rvSemList : null;
                if (recyclerView4 != null) {
                    recyclerView4.setVisibility(8);
                }
            }
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding26 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding26 == null || (recyclerView = dialogApplyPreferenceSubRegBinding26.rvSemesterNo) == null) {
            return;
        }
        recyclerView.scrollToPosition(this$0.semPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ApplyPreferenceSubRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.preferenceVisible + 1;
        this$0.preferenceVisible = i;
        if (i == 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
            FrameLayout frameLayout = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.prefLytTwo : null;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
            FrameLayout frameLayout2 = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.prefLytThree : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = this$0.get_binding();
            FrameLayout frameLayout3 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.prefLytFour : null;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = this$0.get_binding();
            FrameLayout frameLayout4 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.prefLytFive : null;
            if (frameLayout4 == null) {
                return;
            }
            frameLayout4.setVisibility(8);
            return;
        }
        if (i == 2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = this$0.get_binding();
            FrameLayout frameLayout5 = dialogApplyPreferenceSubRegBinding5 != null ? dialogApplyPreferenceSubRegBinding5.prefLytTwo : null;
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = this$0.get_binding();
            FrameLayout frameLayout6 = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.prefLytThree : null;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = this$0.get_binding();
            FrameLayout frameLayout7 = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.prefLytFour : null;
            if (frameLayout7 != null) {
                frameLayout7.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = this$0.get_binding();
            FrameLayout frameLayout8 = dialogApplyPreferenceSubRegBinding8 != null ? dialogApplyPreferenceSubRegBinding8.prefLytFive : null;
            if (frameLayout8 == null) {
                return;
            }
            frameLayout8.setVisibility(8);
            return;
        }
        if (i == 3) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = this$0.get_binding();
            FrameLayout frameLayout9 = dialogApplyPreferenceSubRegBinding9 != null ? dialogApplyPreferenceSubRegBinding9.prefLytTwo : null;
            if (frameLayout9 != null) {
                frameLayout9.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = this$0.get_binding();
            FrameLayout frameLayout10 = dialogApplyPreferenceSubRegBinding10 != null ? dialogApplyPreferenceSubRegBinding10.prefLytThree : null;
            if (frameLayout10 != null) {
                frameLayout10.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = this$0.get_binding();
            FrameLayout frameLayout11 = dialogApplyPreferenceSubRegBinding11 != null ? dialogApplyPreferenceSubRegBinding11.prefLytFour : null;
            if (frameLayout11 != null) {
                frameLayout11.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = this$0.get_binding();
            FrameLayout frameLayout12 = dialogApplyPreferenceSubRegBinding12 != null ? dialogApplyPreferenceSubRegBinding12.prefLytFive : null;
            if (frameLayout12 == null) {
                return;
            }
            frameLayout12.setVisibility(8);
            return;
        }
        if (i == 4) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = this$0.get_binding();
            FrameLayout frameLayout13 = dialogApplyPreferenceSubRegBinding13 != null ? dialogApplyPreferenceSubRegBinding13.prefLytTwo : null;
            if (frameLayout13 != null) {
                frameLayout13.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = this$0.get_binding();
            FrameLayout frameLayout14 = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.prefLytThree : null;
            if (frameLayout14 != null) {
                frameLayout14.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = this$0.get_binding();
            FrameLayout frameLayout15 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.prefLytFour : null;
            if (frameLayout15 != null) {
                frameLayout15.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = this$0.get_binding();
            FrameLayout frameLayout16 = dialogApplyPreferenceSubRegBinding16 != null ? dialogApplyPreferenceSubRegBinding16.prefLytFive : null;
            if (frameLayout16 != null) {
                frameLayout16.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = this$0.get_binding();
            TextView textView = dialogApplyPreferenceSubRegBinding17 != null ? dialogApplyPreferenceSubRegBinding17.addBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ApplyPreferenceSubRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.preferenceVisible--;
        this$0.removePreference("preference2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(ApplyPreferenceSubRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.preferenceVisible--;
        this$0.removePreference("preference3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(ApplyPreferenceSubRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.preferenceVisible--;
        this$0.removePreference("preference4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(ApplyPreferenceSubRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.preferenceVisible--;
        this$0.removePreference("preference5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(ApplyPreferenceSubRegDialog this$0, View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        CustomEditText customEditText;
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
        TextView textView3 = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.finishBtn : null;
        if (textView3 != null) {
            textView3.setText("Register");
        }
        this$0.flag = true;
        System.out.println(this$0.semPosition);
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding2 != null && (textView2 = dialogApplyPreferenceSubRegBinding2.semHistoryBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_new_selected);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding3 != null && (textView = dialogApplyPreferenceSubRegBinding3.subjectsBtn) != null) {
            textView.setBackgroundResource(R.drawable.shape_new_unselected);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = this$0.get_binding();
        RecyclerView recyclerView3 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.rvQuestionNo : null;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = this$0.get_binding();
        RecyclerView recyclerView4 = dialogApplyPreferenceSubRegBinding5 != null ? dialogApplyPreferenceSubRegBinding5.rvSemesterNo : null;
        if (recyclerView4 != null) {
            recyclerView4.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.semQuestionLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.subjectsLyt : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = this$0.get_binding();
        RecyclerView recyclerView5 = dialogApplyPreferenceSubRegBinding8 != null ? dialogApplyPreferenceSubRegBinding8.rvSemList : null;
        if (recyclerView5 != null) {
            recyclerView5.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = this$0.get_binding();
        CardView cardView = dialogApplyPreferenceSubRegBinding9 != null ? dialogApplyPreferenceSubRegBinding9.cvSgpa : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding10 != null && (customEditText = dialogApplyPreferenceSubRegBinding10.sgpaMark) != null) {
            customEditText.setText(this$0.sgpaMarks.get(this$0.semPosition));
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = this$0.get_binding();
        TextView textView4 = dialogApplyPreferenceSubRegBinding11 != null ? dialogApplyPreferenceSubRegBinding11.addBtn : null;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = this$0.get_binding();
        TextView textView5 = dialogApplyPreferenceSubRegBinding12 != null ? dialogApplyPreferenceSubRegBinding12.backBtn : null;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        if (this$0.semPosition == this$0.semesterList.size() - 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = this$0.get_binding();
            TextView textView6 = dialogApplyPreferenceSubRegBinding13 != null ? dialogApplyPreferenceSubRegBinding13.nextBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = this$0.get_binding();
            TextView textView7 = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.finishBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = this$0.get_binding();
            TextView textView8 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.nextBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = this$0.get_binding();
            TextView textView9 = dialogApplyPreferenceSubRegBinding16 != null ? dialogApplyPreferenceSubRegBinding16.finishBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        this$0.getSemesterQuestionsAdapter().addItems(this$0.semesters, this$0.semPosition);
        if (this$0.semesterList.get(this$0.semPosition).getSubjects().size() > 0) {
            this$0.getSemesterSubjectsAdapter().addItems(this$0.semesterList.get(this$0.semPosition).getSubjects(), this$0.semPosition);
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = this$0.get_binding();
            recyclerView = dialogApplyPreferenceSubRegBinding17 != null ? dialogApplyPreferenceSubRegBinding17.rvSemList : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = this$0.get_binding();
            recyclerView = dialogApplyPreferenceSubRegBinding18 != null ? dialogApplyPreferenceSubRegBinding18.rvSemList : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding19 == null || (recyclerView2 = dialogApplyPreferenceSubRegBinding19.rvSemesterNo) == null) {
            return;
        }
        recyclerView2.scrollToPosition(this$0.semPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(ApplyPreferenceSubRegDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        RecyclerView recyclerView;
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        Spinner spinner4;
        Spinner spinner5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.position == this$0.subjectsList.size() - 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
            TextView textView3 = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.nextBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
            TextView textView4 = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.finishBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = this$0.get_binding();
            TextView textView5 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.nextBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = this$0.get_binding();
            TextView textView6 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.finishBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        }
        this$0.getSubjectsQuestionsAdapter().addItems(this$0.subjects, this$0.position);
        this$0.getPrefOneAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 1");
        this$0.getPrefTwoAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 2");
        this$0.getPrefThreeAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 3");
        this$0.getPrefFourAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 4");
        this$0.getPrefFiveAdapter().addItems(this$0.subjectsList.get(this$0.position).getSubjects(), "Select Preference 5");
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding5 != null && (spinner5 = dialogApplyPreferenceSubRegBinding5.spinnerPreferenceOne) != null) {
            spinner5.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding6 != null && (spinner4 = dialogApplyPreferenceSubRegBinding6.spinnerPreferenceTwo) != null) {
            spinner4.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding7 != null && (spinner3 = dialogApplyPreferenceSubRegBinding7.spinnerPreferenceThree) != null) {
            spinner3.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding8 != null && (spinner2 = dialogApplyPreferenceSubRegBinding8.spinnerPreferenceFour) != null) {
            spinner2.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding9 != null && (spinner = dialogApplyPreferenceSubRegBinding9.spinnerPreferenceFive) != null) {
            spinner.setSelection(0);
        }
        this$0.reloadSavedPreference();
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding10 != null && (recyclerView = dialogApplyPreferenceSubRegBinding10.rvQuestionNo) != null) {
            recyclerView.scrollToPosition(this$0.position);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = this$0.get_binding();
        TextView textView7 = dialogApplyPreferenceSubRegBinding11 != null ? dialogApplyPreferenceSubRegBinding11.finishBtn : null;
        if (textView7 != null) {
            textView7.setText("Proceed");
        }
        this$0.flag = false;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding12 != null && (textView2 = dialogApplyPreferenceSubRegBinding12.subjectsBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_new_selected);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = this$0.get_binding();
        if (dialogApplyPreferenceSubRegBinding13 != null && (textView = dialogApplyPreferenceSubRegBinding13.semHistoryBtn) != null) {
            textView.setBackgroundResource(R.drawable.shape_new_unselected);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = this$0.get_binding();
        RecyclerView recyclerView2 = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.rvQuestionNo : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = this$0.get_binding();
        RecyclerView recyclerView3 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.rvSemesterNo : null;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout = dialogApplyPreferenceSubRegBinding16 != null ? dialogApplyPreferenceSubRegBinding16.semQuestionLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogApplyPreferenceSubRegBinding17 != null ? dialogApplyPreferenceSubRegBinding17.subjectsLyt : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = this$0.get_binding();
        RecyclerView recyclerView4 = dialogApplyPreferenceSubRegBinding18 != null ? dialogApplyPreferenceSubRegBinding18.rvSemList : null;
        if (recyclerView4 != null) {
            recyclerView4.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = this$0.get_binding();
        CardView cardView = dialogApplyPreferenceSubRegBinding19 != null ? dialogApplyPreferenceSubRegBinding19.cvSgpa : null;
        if (cardView == null) {
            return;
        }
        cardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$14(ApplyPreferenceSubRegDialog this$0, View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        RecyclerView recyclerView5;
        RecyclerView recyclerView6;
        RecyclerView recyclerView7;
        CustomEditText customEditText;
        TextView textView;
        TextView textView2;
        RecyclerView recyclerView8;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((dialogApplyPreferenceSubRegBinding == null || (textView3 = dialogApplyPreferenceSubRegBinding.finishBtn) == null) ? null : textView3.getText()), "Proceed")) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
            TextView textView4 = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.finishBtn : null;
            if (textView4 != null) {
                textView4.setText("Register");
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = this$0.get_binding();
            TextView textView5 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.finishBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = this$0.get_binding();
            TextView textView6 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.nextBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            this$0.getSemesterSubjectsAdapter().addItems(this$0.semesterList.get(this$0.semPosition).getSubjects(), this$0.semPosition);
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding5 != null && (recyclerView8 = dialogApplyPreferenceSubRegBinding5.rvSemesterNo) != null) {
                recyclerView8.scrollToPosition(this$0.semPosition);
            }
            this$0.flag = true;
            if (this$0.semPosition == this$0.semesterList.size() - 1) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = this$0.get_binding();
                TextView textView7 = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.nextBtn : null;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = this$0.get_binding();
                TextView textView8 = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.finishBtn : null;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
            } else {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = this$0.get_binding();
                TextView textView9 = dialogApplyPreferenceSubRegBinding8 != null ? dialogApplyPreferenceSubRegBinding8.nextBtn : null;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = this$0.get_binding();
                TextView textView10 = dialogApplyPreferenceSubRegBinding9 != null ? dialogApplyPreferenceSubRegBinding9.finishBtn : null;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                }
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding10 != null && (textView2 = dialogApplyPreferenceSubRegBinding10.semHistoryBtn) != null) {
                textView2.setBackgroundResource(R.drawable.shape_new_selected);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding11 != null && (textView = dialogApplyPreferenceSubRegBinding11.subjectsBtn) != null) {
                textView.setBackgroundResource(R.drawable.shape_new_unselected);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = this$0.get_binding();
            RecyclerView recyclerView9 = dialogApplyPreferenceSubRegBinding12 != null ? dialogApplyPreferenceSubRegBinding12.rvQuestionNo : null;
            if (recyclerView9 != null) {
                recyclerView9.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = this$0.get_binding();
            RecyclerView recyclerView10 = dialogApplyPreferenceSubRegBinding13 != null ? dialogApplyPreferenceSubRegBinding13.rvSemesterNo : null;
            if (recyclerView10 != null) {
                recyclerView10.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = this$0.get_binding();
            LinearLayout linearLayout = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.semQuestionLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.subjectsLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = this$0.get_binding();
            RecyclerView recyclerView11 = dialogApplyPreferenceSubRegBinding16 != null ? dialogApplyPreferenceSubRegBinding16.rvSemList : null;
            if (recyclerView11 != null) {
                recyclerView11.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = this$0.get_binding();
            CardView cardView = dialogApplyPreferenceSubRegBinding17 != null ? dialogApplyPreferenceSubRegBinding17.cvSgpa : null;
            if (cardView == null) {
                return;
            }
            cardView.setVisibility(0);
            return;
        }
        ArrayList<String> arrayList = this$0.sgpaMarks;
        int i = this$0.semPosition;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = this$0.get_binding();
        arrayList.set(i, String.valueOf((dialogApplyPreferenceSubRegBinding18 == null || (customEditText = dialogApplyPreferenceSubRegBinding18.sgpaMark) == null) ? null : customEditText.getText()));
        int size = this$0.semesterList.get(this$0.semPosition).getSubjects().size();
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            if (Intrinsics.areEqual(this$0.semesterList.get(this$0.semPosition).getSubjects().get(i2).getAns(), "")) {
                z2 = true;
            }
            if (Intrinsics.areEqual(this$0.semesterList.get(this$0.semPosition).getSubjects().get(i2).getMark(), "")) {
                z = true;
            }
        }
        boolean areEqual = Intrinsics.areEqual(this$0.sgpaMarks.get(this$0.semPosition), "");
        if (z && z2 && areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding19 == null || (recyclerView7 = dialogApplyPreferenceSubRegBinding19.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView7, "All Marks, SGPA, and Subjects are mandatory before registering.");
            return;
        }
        if (z && z2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding20 == null || (recyclerView6 = dialogApplyPreferenceSubRegBinding20.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView6, "Marks and Subjects are mandatory before registering.");
            return;
        }
        if (z && areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding21 == null || (recyclerView5 = dialogApplyPreferenceSubRegBinding21.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView5, "Marks and SGPA are mandatory before registering.");
            return;
        }
        if (z2 && areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding22 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding22 == null || (recyclerView4 = dialogApplyPreferenceSubRegBinding22.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView4, "Subjects and SGPA are mandatory before registering.");
            return;
        }
        if (z) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding23 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding23 == null || (recyclerView3 = dialogApplyPreferenceSubRegBinding23.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView3, "Marks are mandatory before registering.");
            return;
        }
        if (z2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding24 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding24 == null || (recyclerView2 = dialogApplyPreferenceSubRegBinding24.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView2, "Subjects are mandatory before registering.");
            return;
        }
        if (areEqual) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding25 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding25 == null || (recyclerView = dialogApplyPreferenceSubRegBinding25.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView, "SGPA is mandatory before registering.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.clear();
        HashMap hashMap2 = hashMap;
        hashMap2.put("sem_id", this$0.getPreference().getUserSemId());
        hashMap2.put("pathway", this$0.pathwayId);
        hashMap2.put("category", this$0.categoryId);
        hashMap2.put("register", "1");
        System.out.println(this$0.subjectsArray);
        List<String> list = this$0.subjectsArray;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            arrayList2.add(sb2);
        }
        ArrayList arrayList3 = arrayList2;
        List<String> list2 = this$0.subjectsArray;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (String str2 : list2) {
            StringBuilder sb3 = new StringBuilder();
            int length2 = str2.length();
            for (int i4 = 0; i4 < length2; i4++) {
                char charAt2 = str2.charAt(i4);
                if (Character.isLetter(charAt2)) {
                    sb3.append(charAt2);
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
            String lowerCase = sb4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.endsWith$default(lowerCase, SvgConstants.Attributes.PATH_DATA_REL_CURVE_TO_S, false, 2, (Object) null)) {
                lowerCase = lowerCase + SvgConstants.Attributes.PATH_DATA_REL_CURVE_TO_S;
            }
            arrayList4.add(lowerCase);
        }
        ArrayList arrayList5 = arrayList4;
        int size2 = this$0.semesterArray.size();
        for (int i5 = 0; i5 < size2; i5++) {
            String str3 = "SubjectRegistrationPrevSemSgpa[" + ((Object) this$0.semestersIds.get(i5)) + "][sgpa]";
            String str4 = this$0.sgpaMarks.get(i5);
            Intrinsics.checkNotNullExpressionValue(str4, "sgpaMarks[i]");
            hashMap2.put(str3, str4);
            int size3 = this$0.semesterList.get(i5).getSubjects().size();
            for (int i6 = 0; i6 < size3; i6++) {
                String convertKey = this$0.convertKey(this$0.semesterList.get(i5).getSubjects().get(i6).getName());
                this$0.convertKey2(this$0.semesterList.get(i5).getSubjects().get(i6).getName());
                String mark = this$0.semesterList.get(i5).getSubjects().get(i6).getMark();
                hashMap2.put("SubjectRegistrationPrevSubMarks[" + ((Object) this$0.semestersIds.get(i5)) + "][" + convertKey + "][subject_id]", this$0.semesterList.get(i5).getSubjects().get(i6).getAns());
                hashMap2.put("SubjectRegistrationPrevSubMarks[" + ((Object) this$0.semestersIds.get(i5)) + "][" + convertKey + "][mark]", mark);
            }
        }
        System.out.println(hashMap);
        System.out.println(hashMap);
        int size4 = this$0.subjectsList.size();
        for (int i7 = 0; i7 < size4; i7++) {
            int size5 = this$0.subjectsList.get(i7).getSubjects().size();
            for (int i8 = 0; i8 < size5; i8++) {
                if (Intrinsics.areEqual(this$0.subjectsList.get(i7).getSubjects().get(i8).getAns(), "preference1")) {
                    hashMap2.put("subject[" + arrayList5.get(i7) + "][" + arrayList3.get(i7) + "][0]", String.valueOf(this$0.subjectsList.get(i7).getSubjects().get(i8).getId()));
                } else if (Intrinsics.areEqual(this$0.subjectsList.get(i7).getSubjects().get(i8).getAns(), "preference2")) {
                    hashMap2.put("subject[" + arrayList5.get(i7) + "][" + arrayList3.get(i7) + "][1]", String.valueOf(this$0.subjectsList.get(i7).getSubjects().get(i8).getId()));
                } else if (Intrinsics.areEqual(this$0.subjectsList.get(i7).getSubjects().get(i8).getAns(), "preference3")) {
                    hashMap2.put("subject[" + arrayList5.get(i7) + "][" + arrayList3.get(i7) + "][2]", String.valueOf(this$0.subjectsList.get(i7).getSubjects().get(i8).getId()));
                } else if (Intrinsics.areEqual(this$0.subjectsList.get(i7).getSubjects().get(i8).getAns(), "preference4")) {
                    hashMap2.put("subject[" + arrayList5.get(i7) + "][" + arrayList3.get(i7) + "][3]", String.valueOf(this$0.subjectsList.get(i7).getSubjects().get(i8).getId()));
                } else if (Intrinsics.areEqual(this$0.subjectsList.get(i7).getSubjects().get(i8).getAns(), "preference5")) {
                    hashMap2.put("subject[" + arrayList5.get(i7) + "][" + arrayList3.get(i7) + "][4]", String.valueOf(this$0.subjectsList.get(i7).getSubjects().get(i8).getId()));
                }
            }
        }
        this$0.getApplyPreferenceSubRegViewModel().postRegisterData(hashMap2);
    }

    private final void listenRegResponse() {
        getApplyPreferenceSubRegViewModel().getRegisterResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ApplyPreferenceSubRegDialog.listenRegResponse$lambda$16(ApplyPreferenceSubRegDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenRegResponse$lambda$16(ApplyPreferenceSubRegDialog this$0, Resource resource) {
        RecyclerView rvQuestionNo;
        RecyclerView rvQuestionNo2;
        Spinner spinner;
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
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding == null || (spinner = dialogApplyPreferenceSubRegBinding.spinnerSemesterLastAttended) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(spinner, message);
            return;
        }
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
                if (dialogApplyPreferenceSubRegBinding2 != null && (rvQuestionNo2 = dialogApplyPreferenceSubRegBinding2.rvQuestionNo) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvQuestionNo2, "rvQuestionNo");
                    ToastExtKt.showSuccessToast(rvQuestionNo2, successResponse.getMessage());
                }
                this$0.dismiss();
                return;
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding3 == null || (rvQuestionNo = dialogApplyPreferenceSubRegBinding3.rvQuestionNo) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvQuestionNo, "rvQuestionNo");
            ToastExtKt.showErrorToast(rvQuestionNo, successResponse.getError());
        }
    }

    private final void listenSemResponse() {
        getApplyPreferenceSubRegViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ApplyPreferenceSubRegDialog.listenSemResponse$lambda$18(ApplyPreferenceSubRegDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$18(ApplyPreferenceSubRegDialog this$0, Resource resource) {
        Spinner spinner;
        Spinner spinner2;
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
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = this$0.get_binding();
            if (dialogApplyPreferenceSubRegBinding == null || (spinner2 = dialogApplyPreferenceSubRegBinding.spinnerSemesterLastAttended) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(spinner2, message);
            return;
        }
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            int count = this$0.getSpinnerAdapter().getCount();
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    break;
                }
                if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = this$0.get_binding();
                    if (dialogApplyPreferenceSubRegBinding2 != null && (spinner = dialogApplyPreferenceSubRegBinding2.spinnerSemesterLastAttended) != null) {
                        spinner.setSelection(i2);
                    }
                } else {
                    i2++;
                }
            }
            this$0.semesterIdArray.clear();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this$0.semesterIdArray.add(i3, arrayList.get(i3).getId());
            }
            this$0.semestersIds.addAll(this$0.semesterIdArray);
        }
    }

    private final void listenSubjectsResponse() {
        getApplyPreferenceSubRegViewModel().getSpinnerResponse().observe(getViewLifecycleOwner(), new ApplyPreferenceSubRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SubjectsListResponse>, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog$listenSubjectsResponse$1

            /* compiled from: ApplyPreferenceSubRegDialog.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SubjectsListResponse> resource) {
                invoke2((Resource<SubjectsListResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SubjectsListResponse> resource) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                ArrayList arrayList4;
                ArrayList arrayList5;
                ApplyPreferenceSubRegSemQndAdapter semesterQuestionsAdapter;
                ArrayList<String> arrayList6;
                int i;
                ApplyPreferenceSubRegQuestionAdapter subjectsQuestionsAdapter;
                ArrayList<String> arrayList7;
                int i2;
                ApplyPreferenceSubRegAdapter semesterSubjectsAdapter;
                int i3;
                int i4;
                PathwaySpinnerAdapter pathwayAdapter;
                PathwaySpinnerAdapter categoryAdapter;
                SubjectRegSpinnerAdapter prefOneAdapter;
                ArrayList arrayList8;
                int i5;
                SubjectRegSpinnerAdapter prefTwoAdapter;
                ArrayList arrayList9;
                int i6;
                SubjectRegSpinnerAdapter prefThreeAdapter;
                ArrayList arrayList10;
                int i7;
                SubjectRegSpinnerAdapter prefFourAdapter;
                ArrayList arrayList11;
                int i8;
                SubjectRegSpinnerAdapter prefFiveAdapter;
                ArrayList arrayList12;
                int i9;
                ArrayList arrayList13;
                ArrayList arrayList14;
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding;
                Spinner spinner;
                int i10 = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i10 != 1) {
                    if (i10 == 2) {
                        ApplyPreferenceSubRegDialog.this.showProgress();
                        return;
                    }
                    if (i10 == 3) {
                        ApplyPreferenceSubRegDialog.this.hideProgress();
                        return;
                    }
                    if (i10 != 4) {
                        return;
                    }
                    ApplyPreferenceSubRegDialog.this.hideProgress();
                    dialogApplyPreferenceSubRegBinding = ApplyPreferenceSubRegDialog.this.get_binding();
                    if (dialogApplyPreferenceSubRegBinding == null || (spinner = dialogApplyPreferenceSubRegBinding.spinnerSemesterLastAttended) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(spinner, message);
                    return;
                }
                ApplyPreferenceSubRegDialog.this.hideProgress();
                SubjectsListResponse data = resource.getData();
                if (data != null) {
                    ApplyPreferenceSubRegDialog applyPreferenceSubRegDialog = ApplyPreferenceSubRegDialog.this;
                    try {
                        applyPreferenceSubRegDialog.subjectsList = data.getSubject_list();
                        applyPreferenceSubRegDialog.semesterList = data.getSem_list();
                        arrayList = applyPreferenceSubRegDialog.subjectsList;
                        int size = arrayList.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            List<String> subjectsArray = applyPreferenceSubRegDialog.getSubjectsArray();
                            arrayList14 = applyPreferenceSubRegDialog.subjectsList;
                            subjectsArray.add(i11, StringsKt.replace$default(((SubjectsList) arrayList14.get(i11)).getName(), "_", HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR, false, 4, (Object) null));
                        }
                        arrayList2 = applyPreferenceSubRegDialog.semesterList;
                        int size2 = arrayList2.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            List<String> semesterArray = applyPreferenceSubRegDialog.getSemesterArray();
                            arrayList13 = applyPreferenceSubRegDialog.semesterList;
                            semesterArray.add(i12, String.valueOf(((SemList) arrayList13.get(i12)).getSem_pos()));
                            applyPreferenceSubRegDialog.getSgpaArray().add(i12, "");
                        }
                        arrayList3 = applyPreferenceSubRegDialog.semesters;
                        arrayList3.addAll(applyPreferenceSubRegDialog.getSemesterArray());
                        arrayList4 = applyPreferenceSubRegDialog.subjects;
                        arrayList4.addAll(applyPreferenceSubRegDialog.getSubjectsArray());
                        arrayList5 = applyPreferenceSubRegDialog.sgpaMarks;
                        arrayList5.addAll(applyPreferenceSubRegDialog.getSgpaArray());
                        semesterQuestionsAdapter = applyPreferenceSubRegDialog.getSemesterQuestionsAdapter();
                        arrayList6 = applyPreferenceSubRegDialog.semesters;
                        i = applyPreferenceSubRegDialog.semPosition;
                        semesterQuestionsAdapter.addItems(arrayList6, i);
                        subjectsQuestionsAdapter = applyPreferenceSubRegDialog.getSubjectsQuestionsAdapter();
                        arrayList7 = applyPreferenceSubRegDialog.subjects;
                        i2 = applyPreferenceSubRegDialog.position;
                        subjectsQuestionsAdapter.addItems(arrayList7, i2);
                        semesterSubjectsAdapter = applyPreferenceSubRegDialog.getSemesterSubjectsAdapter();
                        ArrayList<SemList> sem_list = data.getSem_list();
                        i3 = applyPreferenceSubRegDialog.semPosition;
                        ArrayList<SubjectMainList> subjects = sem_list.get(i3).getSubjects();
                        i4 = applyPreferenceSubRegDialog.semPosition;
                        semesterSubjectsAdapter.addItems(subjects, i4);
                        pathwayAdapter = applyPreferenceSubRegDialog.getPathwayAdapter();
                        pathwayAdapter.addItems(data.getPathway());
                        categoryAdapter = applyPreferenceSubRegDialog.getCategoryAdapter();
                        categoryAdapter.addItems(data.getCategory());
                        prefOneAdapter = applyPreferenceSubRegDialog.getPrefOneAdapter();
                        arrayList8 = applyPreferenceSubRegDialog.subjectsList;
                        i5 = applyPreferenceSubRegDialog.position;
                        prefOneAdapter.addItems(((SubjectsList) arrayList8.get(i5)).getSubjects(), "Select Preference 1");
                        prefTwoAdapter = applyPreferenceSubRegDialog.getPrefTwoAdapter();
                        arrayList9 = applyPreferenceSubRegDialog.subjectsList;
                        i6 = applyPreferenceSubRegDialog.position;
                        prefTwoAdapter.addItems(((SubjectsList) arrayList9.get(i6)).getSubjects(), "Select Preference 2");
                        prefThreeAdapter = applyPreferenceSubRegDialog.getPrefThreeAdapter();
                        arrayList10 = applyPreferenceSubRegDialog.subjectsList;
                        i7 = applyPreferenceSubRegDialog.position;
                        prefThreeAdapter.addItems(((SubjectsList) arrayList10.get(i7)).getSubjects(), "Select Preference 3");
                        prefFourAdapter = applyPreferenceSubRegDialog.getPrefFourAdapter();
                        arrayList11 = applyPreferenceSubRegDialog.subjectsList;
                        i8 = applyPreferenceSubRegDialog.position;
                        prefFourAdapter.addItems(((SubjectsList) arrayList11.get(i8)).getSubjects(), "Select Preference 4");
                        prefFiveAdapter = applyPreferenceSubRegDialog.getPrefFiveAdapter();
                        arrayList12 = applyPreferenceSubRegDialog.subjectsList;
                        i9 = applyPreferenceSubRegDialog.position;
                        prefFiveAdapter.addItems(((SubjectsList) arrayList12.get(i9)).getSubjects(), "Select Preference 5");
                        applyPreferenceSubRegDialog.reloadSavedPreference();
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    public final void setCallBack(SubjectRegistrationFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddPublicationListener addPublicationListener = this.listener;
        if (addPublicationListener != null) {
            addPublicationListener.onDismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegQuestionAdapter.CallBack
    public void btnClicked(int position) {
        TextView textView;
        RecyclerView recyclerView;
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        Spinner spinner4;
        Spinner spinner5;
        this.position = position;
        this.preferenceVisible = 0;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = get_binding();
        TextView textView2 = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.addBtn : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (position == 0) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = get_binding();
            TextView textView3 = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.backBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(4);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = get_binding();
            TextView textView4 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.backBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        if (position == this.subjectsList.size() - 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = get_binding();
            TextView textView5 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.nextBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = get_binding();
            textView = dialogApplyPreferenceSubRegBinding5 != null ? dialogApplyPreferenceSubRegBinding5.finishBtn : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = get_binding();
            TextView textView6 = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.nextBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = get_binding();
            textView = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.finishBtn : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        getSubjectsQuestionsAdapter().addItems(this.subjects, position);
        getPrefOneAdapter().addItems(this.subjectsList.get(position).getSubjects(), "Select Preference 1");
        getPrefTwoAdapter().addItems(this.subjectsList.get(position).getSubjects(), "Select Preference 2");
        getPrefThreeAdapter().addItems(this.subjectsList.get(position).getSubjects(), "Select Preference 3");
        getPrefFourAdapter().addItems(this.subjectsList.get(position).getSubjects(), "Select Preference 4");
        getPrefFiveAdapter().addItems(this.subjectsList.get(position).getSubjects(), "Select Preference 5");
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = get_binding();
        if (dialogApplyPreferenceSubRegBinding8 != null && (spinner5 = dialogApplyPreferenceSubRegBinding8.spinnerPreferenceOne) != null) {
            spinner5.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = get_binding();
        if (dialogApplyPreferenceSubRegBinding9 != null && (spinner4 = dialogApplyPreferenceSubRegBinding9.spinnerPreferenceTwo) != null) {
            spinner4.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = get_binding();
        if (dialogApplyPreferenceSubRegBinding10 != null && (spinner3 = dialogApplyPreferenceSubRegBinding10.spinnerPreferenceThree) != null) {
            spinner3.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = get_binding();
        if (dialogApplyPreferenceSubRegBinding11 != null && (spinner2 = dialogApplyPreferenceSubRegBinding11.spinnerPreferenceFour) != null) {
            spinner2.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = get_binding();
        if (dialogApplyPreferenceSubRegBinding12 != null && (spinner = dialogApplyPreferenceSubRegBinding12.spinnerPreferenceFive) != null) {
            spinner.setSelection(0);
        }
        reloadSavedPreference();
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = get_binding();
        if (dialogApplyPreferenceSubRegBinding13 == null || (recyclerView = dialogApplyPreferenceSubRegBinding13.rvQuestionNo) == null) {
            return;
        }
        recyclerView.scrollToPosition(position);
    }

    public final <T> void swap(List<T> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        T t = list.get(i);
        list.set(i, list.get(i2));
        list.set(i2, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadSavedPreference() {
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        Spinner spinner4;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding;
        Spinner spinner5;
        Spinner spinner6;
        Spinner spinner7;
        Spinner spinner8;
        Spinner spinner9;
        Spinner spinner10;
        Spinner spinner11;
        Spinner spinner12;
        Spinner spinner13;
        Spinner spinner14;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = get_binding();
        if (dialogApplyPreferenceSubRegBinding2 != null && (spinner14 = dialogApplyPreferenceSubRegBinding2.spinnerPreferenceOne) != null) {
            spinner14.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = get_binding();
        if (dialogApplyPreferenceSubRegBinding3 != null && (spinner13 = dialogApplyPreferenceSubRegBinding3.spinnerPreferenceTwo) != null) {
            spinner13.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = get_binding();
        if (dialogApplyPreferenceSubRegBinding4 != null && (spinner12 = dialogApplyPreferenceSubRegBinding4.spinnerPreferenceThree) != null) {
            spinner12.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = get_binding();
        if (dialogApplyPreferenceSubRegBinding5 != null && (spinner11 = dialogApplyPreferenceSubRegBinding5.spinnerPreferenceFour) != null) {
            spinner11.setSelection(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = get_binding();
        if (dialogApplyPreferenceSubRegBinding6 != null && (spinner10 = dialogApplyPreferenceSubRegBinding6.spinnerPreferenceFive) != null) {
            spinner10.setSelection(0);
        }
        int size = this.subjectsList.get(this.position).getSubjects().size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference1")) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = get_binding();
                if (dialogApplyPreferenceSubRegBinding7 != null && (spinner9 = dialogApplyPreferenceSubRegBinding7.spinnerPreferenceOne) != null) {
                    spinner9.setSelection(i + 1);
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference2")) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = get_binding();
                if (dialogApplyPreferenceSubRegBinding8 != null && (spinner8 = dialogApplyPreferenceSubRegBinding8.spinnerPreferenceTwo) != null) {
                    spinner8.setSelection(i + 1);
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference3")) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = get_binding();
                if (dialogApplyPreferenceSubRegBinding9 != null && (spinner7 = dialogApplyPreferenceSubRegBinding9.spinnerPreferenceThree) != null) {
                    spinner7.setSelection(i + 1);
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference4")) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = get_binding();
                if (dialogApplyPreferenceSubRegBinding10 != null && (spinner6 = dialogApplyPreferenceSubRegBinding10.spinnerPreferenceFour) != null) {
                    spinner6.setSelection(i + 1);
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference5") && (dialogApplyPreferenceSubRegBinding = get_binding()) != null && (spinner5 = dialogApplyPreferenceSubRegBinding.spinnerPreferenceFive) != null) {
                spinner5.setSelection(i + 1);
            }
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = get_binding();
        if (((dialogApplyPreferenceSubRegBinding11 == null || (spinner4 = dialogApplyPreferenceSubRegBinding11.spinnerPreferenceTwo) == null || spinner4.getSelectedItemPosition() != 0) ? false : true) && this.preferenceVisible < 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = get_binding();
            FrameLayout frameLayout = dialogApplyPreferenceSubRegBinding12 != null ? dialogApplyPreferenceSubRegBinding12.prefLytTwo : null;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else if (this.preferenceVisible == 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = get_binding();
            FrameLayout frameLayout2 = dialogApplyPreferenceSubRegBinding13 != null ? dialogApplyPreferenceSubRegBinding13.prefLytTwo : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = get_binding();
            FrameLayout frameLayout3 = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.prefLytThree : null;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = get_binding();
            FrameLayout frameLayout4 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.prefLytFour : null;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = get_binding();
            FrameLayout frameLayout5 = dialogApplyPreferenceSubRegBinding16 != null ? dialogApplyPreferenceSubRegBinding16.prefLytFive : null;
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(8);
            }
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = get_binding();
        if (((dialogApplyPreferenceSubRegBinding17 == null || (spinner3 = dialogApplyPreferenceSubRegBinding17.spinnerPreferenceThree) == null || spinner3.getSelectedItemPosition() != 0) ? false : true) && this.preferenceVisible < 2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = get_binding();
            FrameLayout frameLayout6 = dialogApplyPreferenceSubRegBinding18 != null ? dialogApplyPreferenceSubRegBinding18.prefLytThree : null;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(8);
            }
        } else if (this.preferenceVisible == 2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = get_binding();
            FrameLayout frameLayout7 = dialogApplyPreferenceSubRegBinding19 != null ? dialogApplyPreferenceSubRegBinding19.prefLytTwo : null;
            if (frameLayout7 != null) {
                frameLayout7.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20 = get_binding();
            FrameLayout frameLayout8 = dialogApplyPreferenceSubRegBinding20 != null ? dialogApplyPreferenceSubRegBinding20.prefLytThree : null;
            if (frameLayout8 != null) {
                frameLayout8.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21 = get_binding();
            FrameLayout frameLayout9 = dialogApplyPreferenceSubRegBinding21 != null ? dialogApplyPreferenceSubRegBinding21.prefLytFour : null;
            if (frameLayout9 != null) {
                frameLayout9.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding22 = get_binding();
            FrameLayout frameLayout10 = dialogApplyPreferenceSubRegBinding22 != null ? dialogApplyPreferenceSubRegBinding22.prefLytFive : null;
            if (frameLayout10 != null) {
                frameLayout10.setVisibility(8);
            }
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding23 = get_binding();
        if (((dialogApplyPreferenceSubRegBinding23 == null || (spinner2 = dialogApplyPreferenceSubRegBinding23.spinnerPreferenceFour) == null || spinner2.getSelectedItemPosition() != 0) ? false : true) && this.preferenceVisible < 3) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding24 = get_binding();
            FrameLayout frameLayout11 = dialogApplyPreferenceSubRegBinding24 != null ? dialogApplyPreferenceSubRegBinding24.prefLytFour : null;
            if (frameLayout11 != null) {
                frameLayout11.setVisibility(8);
            }
        } else if (this.preferenceVisible == 3) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding25 = get_binding();
            FrameLayout frameLayout12 = dialogApplyPreferenceSubRegBinding25 != null ? dialogApplyPreferenceSubRegBinding25.prefLytTwo : null;
            if (frameLayout12 != null) {
                frameLayout12.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding26 = get_binding();
            FrameLayout frameLayout13 = dialogApplyPreferenceSubRegBinding26 != null ? dialogApplyPreferenceSubRegBinding26.prefLytThree : null;
            if (frameLayout13 != null) {
                frameLayout13.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding27 = get_binding();
            FrameLayout frameLayout14 = dialogApplyPreferenceSubRegBinding27 != null ? dialogApplyPreferenceSubRegBinding27.prefLytFour : null;
            if (frameLayout14 != null) {
                frameLayout14.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding28 = get_binding();
            FrameLayout frameLayout15 = dialogApplyPreferenceSubRegBinding28 != null ? dialogApplyPreferenceSubRegBinding28.prefLytFive : null;
            if (frameLayout15 != null) {
                frameLayout15.setVisibility(8);
            }
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding29 = get_binding();
        if (((dialogApplyPreferenceSubRegBinding29 == null || (spinner = dialogApplyPreferenceSubRegBinding29.spinnerPreferenceFive) == null || spinner.getSelectedItemPosition() != 0) ? false : true) && this.preferenceVisible < 4) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding30 = get_binding();
            FrameLayout frameLayout16 = dialogApplyPreferenceSubRegBinding30 != null ? dialogApplyPreferenceSubRegBinding30.prefLytFive : null;
            if (frameLayout16 != null) {
                frameLayout16.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding31 = get_binding();
            TextView textView = dialogApplyPreferenceSubRegBinding31 != null ? dialogApplyPreferenceSubRegBinding31.addBtn : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else if (this.preferenceVisible == 4) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding32 = get_binding();
            FrameLayout frameLayout17 = dialogApplyPreferenceSubRegBinding32 != null ? dialogApplyPreferenceSubRegBinding32.prefLytTwo : null;
            if (frameLayout17 != null) {
                frameLayout17.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding33 = get_binding();
            FrameLayout frameLayout18 = dialogApplyPreferenceSubRegBinding33 != null ? dialogApplyPreferenceSubRegBinding33.prefLytThree : null;
            if (frameLayout18 != null) {
                frameLayout18.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding34 = get_binding();
            FrameLayout frameLayout19 = dialogApplyPreferenceSubRegBinding34 != null ? dialogApplyPreferenceSubRegBinding34.prefLytFour : null;
            if (frameLayout19 != null) {
                frameLayout19.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding35 = get_binding();
            FrameLayout frameLayout20 = dialogApplyPreferenceSubRegBinding35 != null ? dialogApplyPreferenceSubRegBinding35.prefLytFive : null;
            if (frameLayout20 != null) {
                frameLayout20.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding36 = get_binding();
            TextView textView2 = dialogApplyPreferenceSubRegBinding36 != null ? dialogApplyPreferenceSubRegBinding36.addBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        this.preferenceVisible = 0;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding37 = get_binding();
        FrameLayout frameLayout21 = dialogApplyPreferenceSubRegBinding37 != null ? dialogApplyPreferenceSubRegBinding37.prefLytTwo : null;
        if (frameLayout21 != null) {
            frameLayout21.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding38 = get_binding();
        FrameLayout frameLayout22 = dialogApplyPreferenceSubRegBinding38 != null ? dialogApplyPreferenceSubRegBinding38.prefLytThree : null;
        if (frameLayout22 != null) {
            frameLayout22.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding39 = get_binding();
        FrameLayout frameLayout23 = dialogApplyPreferenceSubRegBinding39 != null ? dialogApplyPreferenceSubRegBinding39.prefLytFour : null;
        if (frameLayout23 != null) {
            frameLayout23.setVisibility(8);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding40 = get_binding();
        FrameLayout frameLayout24 = dialogApplyPreferenceSubRegBinding40 != null ? dialogApplyPreferenceSubRegBinding40.prefLytFive : null;
        if (frameLayout24 != null) {
            frameLayout24.setVisibility(8);
        }
        int size2 = this.subjectsList.get(this.position).getSubjects().size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i2).getAns(), "preference2")) {
                if (this.preferenceVisible < 1) {
                    this.preferenceVisible = 1;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding41 = get_binding();
                    FrameLayout frameLayout25 = dialogApplyPreferenceSubRegBinding41 != null ? dialogApplyPreferenceSubRegBinding41.prefLytTwo : null;
                    if (frameLayout25 != null) {
                        frameLayout25.setVisibility(0);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding42 = get_binding();
                    FrameLayout frameLayout26 = dialogApplyPreferenceSubRegBinding42 != null ? dialogApplyPreferenceSubRegBinding42.prefLytThree : null;
                    if (frameLayout26 != null) {
                        frameLayout26.setVisibility(8);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding43 = get_binding();
                    FrameLayout frameLayout27 = dialogApplyPreferenceSubRegBinding43 != null ? dialogApplyPreferenceSubRegBinding43.prefLytFour : null;
                    if (frameLayout27 != null) {
                        frameLayout27.setVisibility(8);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding44 = get_binding();
                    FrameLayout frameLayout28 = dialogApplyPreferenceSubRegBinding44 != null ? dialogApplyPreferenceSubRegBinding44.prefLytFive : null;
                    if (frameLayout28 != null) {
                        frameLayout28.setVisibility(8);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding45 = get_binding();
                    TextView textView3 = dialogApplyPreferenceSubRegBinding45 != null ? dialogApplyPreferenceSubRegBinding45.addBtn : null;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i2).getAns(), "preference3")) {
                if (this.preferenceVisible < 2) {
                    this.preferenceVisible = 2;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding46 = get_binding();
                    FrameLayout frameLayout29 = dialogApplyPreferenceSubRegBinding46 != null ? dialogApplyPreferenceSubRegBinding46.prefLytTwo : null;
                    if (frameLayout29 != null) {
                        frameLayout29.setVisibility(0);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding47 = get_binding();
                    FrameLayout frameLayout30 = dialogApplyPreferenceSubRegBinding47 != null ? dialogApplyPreferenceSubRegBinding47.prefLytThree : null;
                    if (frameLayout30 != null) {
                        frameLayout30.setVisibility(0);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding48 = get_binding();
                    FrameLayout frameLayout31 = dialogApplyPreferenceSubRegBinding48 != null ? dialogApplyPreferenceSubRegBinding48.prefLytFour : null;
                    if (frameLayout31 != null) {
                        frameLayout31.setVisibility(8);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding49 = get_binding();
                    FrameLayout frameLayout32 = dialogApplyPreferenceSubRegBinding49 != null ? dialogApplyPreferenceSubRegBinding49.prefLytFive : null;
                    if (frameLayout32 != null) {
                        frameLayout32.setVisibility(8);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding50 = get_binding();
                    TextView textView4 = dialogApplyPreferenceSubRegBinding50 != null ? dialogApplyPreferenceSubRegBinding50.addBtn : null;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i2).getAns(), "preference4")) {
                if (this.preferenceVisible < 3) {
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding51 = get_binding();
                    FrameLayout frameLayout33 = dialogApplyPreferenceSubRegBinding51 != null ? dialogApplyPreferenceSubRegBinding51.prefLytTwo : null;
                    if (frameLayout33 != null) {
                        frameLayout33.setVisibility(0);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding52 = get_binding();
                    FrameLayout frameLayout34 = dialogApplyPreferenceSubRegBinding52 != null ? dialogApplyPreferenceSubRegBinding52.prefLytThree : null;
                    if (frameLayout34 != null) {
                        frameLayout34.setVisibility(0);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding53 = get_binding();
                    FrameLayout frameLayout35 = dialogApplyPreferenceSubRegBinding53 != null ? dialogApplyPreferenceSubRegBinding53.prefLytFour : null;
                    if (frameLayout35 != null) {
                        frameLayout35.setVisibility(0);
                    }
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding54 = get_binding();
                    FrameLayout frameLayout36 = dialogApplyPreferenceSubRegBinding54 != null ? dialogApplyPreferenceSubRegBinding54.prefLytFive : null;
                    if (frameLayout36 != null) {
                        frameLayout36.setVisibility(8);
                    }
                    this.preferenceVisible = 3;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding55 = get_binding();
                    TextView textView5 = dialogApplyPreferenceSubRegBinding55 != null ? dialogApplyPreferenceSubRegBinding55.addBtn : null;
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i2).getAns(), "preference5")) {
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding56 = get_binding();
                FrameLayout frameLayout37 = dialogApplyPreferenceSubRegBinding56 != null ? dialogApplyPreferenceSubRegBinding56.prefLytTwo : null;
                if (frameLayout37 != null) {
                    frameLayout37.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding57 = get_binding();
                FrameLayout frameLayout38 = dialogApplyPreferenceSubRegBinding57 != null ? dialogApplyPreferenceSubRegBinding57.prefLytThree : null;
                if (frameLayout38 != null) {
                    frameLayout38.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding58 = get_binding();
                FrameLayout frameLayout39 = dialogApplyPreferenceSubRegBinding58 != null ? dialogApplyPreferenceSubRegBinding58.prefLytFour : null;
                if (frameLayout39 != null) {
                    frameLayout39.setVisibility(0);
                }
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding59 = get_binding();
                FrameLayout frameLayout40 = dialogApplyPreferenceSubRegBinding59 != null ? dialogApplyPreferenceSubRegBinding59.prefLytFive : null;
                if (frameLayout40 != null) {
                    frameLayout40.setVisibility(0);
                }
                this.preferenceVisible = 4;
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding60 = get_binding();
                TextView textView6 = dialogApplyPreferenceSubRegBinding60 != null ? dialogApplyPreferenceSubRegBinding60.addBtn : null;
                if (textView6 == null) {
                    return;
                }
                textView6.setVisibility(8);
                return;
            }
        }
    }

    private final void removePreference(String prefKey) {
        Object obj;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = get_binding();
        TextView textView = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.addBtn : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        int i = this.preferenceVisible;
        if (i == 0) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = get_binding();
            FrameLayout frameLayout = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.prefLytTwo : null;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = get_binding();
            FrameLayout frameLayout2 = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.prefLytThree : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = get_binding();
            FrameLayout frameLayout3 = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.prefLytFour : null;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = get_binding();
            FrameLayout frameLayout4 = dialogApplyPreferenceSubRegBinding5 != null ? dialogApplyPreferenceSubRegBinding5.prefLytFive : null;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
            }
        } else if (i == 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = get_binding();
            FrameLayout frameLayout5 = dialogApplyPreferenceSubRegBinding6 != null ? dialogApplyPreferenceSubRegBinding6.prefLytTwo : null;
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = get_binding();
            FrameLayout frameLayout6 = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.prefLytThree : null;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = get_binding();
            FrameLayout frameLayout7 = dialogApplyPreferenceSubRegBinding8 != null ? dialogApplyPreferenceSubRegBinding8.prefLytFour : null;
            if (frameLayout7 != null) {
                frameLayout7.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = get_binding();
            FrameLayout frameLayout8 = dialogApplyPreferenceSubRegBinding9 != null ? dialogApplyPreferenceSubRegBinding9.prefLytFive : null;
            if (frameLayout8 != null) {
                frameLayout8.setVisibility(8);
            }
        } else if (i == 2) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = get_binding();
            FrameLayout frameLayout9 = dialogApplyPreferenceSubRegBinding10 != null ? dialogApplyPreferenceSubRegBinding10.prefLytTwo : null;
            if (frameLayout9 != null) {
                frameLayout9.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = get_binding();
            FrameLayout frameLayout10 = dialogApplyPreferenceSubRegBinding11 != null ? dialogApplyPreferenceSubRegBinding11.prefLytThree : null;
            if (frameLayout10 != null) {
                frameLayout10.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = get_binding();
            FrameLayout frameLayout11 = dialogApplyPreferenceSubRegBinding12 != null ? dialogApplyPreferenceSubRegBinding12.prefLytFour : null;
            if (frameLayout11 != null) {
                frameLayout11.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = get_binding();
            FrameLayout frameLayout12 = dialogApplyPreferenceSubRegBinding13 != null ? dialogApplyPreferenceSubRegBinding13.prefLytFive : null;
            if (frameLayout12 != null) {
                frameLayout12.setVisibility(8);
            }
        } else if (i == 3) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = get_binding();
            FrameLayout frameLayout13 = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.prefLytTwo : null;
            if (frameLayout13 != null) {
                frameLayout13.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding15 = get_binding();
            FrameLayout frameLayout14 = dialogApplyPreferenceSubRegBinding15 != null ? dialogApplyPreferenceSubRegBinding15.prefLytThree : null;
            if (frameLayout14 != null) {
                frameLayout14.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding16 = get_binding();
            FrameLayout frameLayout15 = dialogApplyPreferenceSubRegBinding16 != null ? dialogApplyPreferenceSubRegBinding16.prefLytFour : null;
            if (frameLayout15 != null) {
                frameLayout15.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding17 = get_binding();
            FrameLayout frameLayout16 = dialogApplyPreferenceSubRegBinding17 != null ? dialogApplyPreferenceSubRegBinding17.prefLytFive : null;
            if (frameLayout16 != null) {
                frameLayout16.setVisibility(8);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding18 = get_binding();
            FrameLayout frameLayout17 = dialogApplyPreferenceSubRegBinding18 != null ? dialogApplyPreferenceSubRegBinding18.prefLytTwo : null;
            if (frameLayout17 != null) {
                frameLayout17.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding19 = get_binding();
            FrameLayout frameLayout18 = dialogApplyPreferenceSubRegBinding19 != null ? dialogApplyPreferenceSubRegBinding19.prefLytThree : null;
            if (frameLayout18 != null) {
                frameLayout18.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding20 = get_binding();
            FrameLayout frameLayout19 = dialogApplyPreferenceSubRegBinding20 != null ? dialogApplyPreferenceSubRegBinding20.prefLytFour : null;
            if (frameLayout19 != null) {
                frameLayout19.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding21 = get_binding();
            FrameLayout frameLayout20 = dialogApplyPreferenceSubRegBinding21 != null ? dialogApplyPreferenceSubRegBinding21.prefLytFive : null;
            if (frameLayout20 != null) {
                frameLayout20.setVisibility(0);
            }
        }
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"preference1", "preference2", "preference3", "preference4", "preference5"});
        ArrayList<Subjects> subjects = this.subjectsList.get(this.position).getSubjects();
        int indexOf = listOf.indexOf(prefKey);
        if (indexOf == -1) {
            return;
        }
        List<String> subList = listOf.subList(indexOf, listOf.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
        for (String str : subList) {
            Iterator<T> it = subjects.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((Subjects) obj).getAns(), str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            arrayList.add((Subjects) obj);
        }
        ArrayList arrayList2 = arrayList;
        Iterator it2 = CollectionsKt.filterNotNull(arrayList2).iterator();
        while (it2.hasNext()) {
            ((Subjects) it2.next()).setAns("");
        }
        int size = arrayList2.size();
        for (int i2 = 1; i2 < size; i2++) {
            Subjects subjects2 = (Subjects) arrayList2.get(i2);
            if (subjects2 != null) {
                subjects2.setAns((String) listOf.get((indexOf + i2) - 1));
            }
        }
        reloadSavedPreference();
    }

    private final void preferenceCalculator() {
        TextView textView;
        this.preferenceVisible = 0;
        int size = this.subjectsList.get(this.position).getSubjects().size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference2")) {
                if (this.preferenceVisible < 1) {
                    this.preferenceVisible = 1;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = get_binding();
                    textView = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.addBtn : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference3")) {
                if (this.preferenceVisible < 2) {
                    this.preferenceVisible = 2;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = get_binding();
                    textView = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.addBtn : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference4")) {
                if (this.preferenceVisible < 3) {
                    this.preferenceVisible = 3;
                    DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = get_binding();
                    textView = dialogApplyPreferenceSubRegBinding3 != null ? dialogApplyPreferenceSubRegBinding3.addBtn : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            } else if (Intrinsics.areEqual(this.subjectsList.get(this.position).getSubjects().get(i).getAns(), "preference4")) {
                this.preferenceVisible = 4;
                DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = get_binding();
                textView = dialogApplyPreferenceSubRegBinding4 != null ? dialogApplyPreferenceSubRegBinding4.addBtn : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
        }
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter.CallBack
    public void btnClicked2(int position) {
        RecyclerView recyclerView;
        CustomEditText customEditText;
        RecyclerView recyclerView2;
        CustomEditText customEditText2;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = get_binding();
        TextView textView = dialogApplyPreferenceSubRegBinding != null ? dialogApplyPreferenceSubRegBinding.addBtn : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding2 = get_binding();
        TextView textView2 = dialogApplyPreferenceSubRegBinding2 != null ? dialogApplyPreferenceSubRegBinding2.nextBtn : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        ArrayList<String> arrayList = this.sgpaMarks;
        int i = this.semPosition;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding3 = get_binding();
        arrayList.set(i, String.valueOf((dialogApplyPreferenceSubRegBinding3 == null || (customEditText2 = dialogApplyPreferenceSubRegBinding3.sgpaMark) == null) ? null : customEditText2.getText()));
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (int i2 = 0; i2 < position; i2++) {
            if (Intrinsics.areEqual(this.sgpaMarks.get(i2), "")) {
                switch (i2) {
                    case 0:
                        z = true;
                        break;
                    case 1:
                        z2 = true;
                        break;
                    case 2:
                        z3 = true;
                        break;
                    case 3:
                        z4 = true;
                        break;
                    case 4:
                        z5 = true;
                        break;
                    case 5:
                        z6 = true;
                        break;
                    case 6:
                        z7 = true;
                        break;
                }
            }
            int size = this.semesterList.get(i2).getSubjects().size();
            for (int i3 = 0; i3 < size; i3++) {
                if (Intrinsics.areEqual(this.semesterList.get(i2).getSubjects().get(i3).getAns(), "")) {
                    switch (i2) {
                        case 0:
                            z = true;
                            break;
                        case 1:
                            z2 = true;
                            break;
                        case 2:
                            z3 = true;
                            break;
                        case 3:
                            z4 = true;
                            break;
                        case 4:
                            z5 = true;
                            break;
                        case 5:
                            z6 = true;
                            break;
                        case 6:
                            z7 = true;
                            break;
                    }
                }
                if (Intrinsics.areEqual(this.semesterList.get(i2).getSubjects().get(i3).getMark(), "")) {
                    switch (i2) {
                        case 0:
                            z = true;
                            break;
                        case 1:
                            z2 = true;
                            break;
                        case 2:
                            z3 = true;
                            break;
                        case 3:
                            z4 = true;
                            break;
                        case 4:
                            z5 = true;
                            break;
                        case 5:
                            z6 = true;
                            break;
                        case 6:
                            z7 = true;
                            break;
                    }
                }
            }
        }
        if (z || z2 || z3 || z4 || z5 || z6 || z7) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding4 = get_binding();
            if (dialogApplyPreferenceSubRegBinding4 == null || (recyclerView = dialogApplyPreferenceSubRegBinding4.rvSemList) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView, "Please fill previous semester details before accessing this Semester");
            return;
        }
        this.semPosition = position;
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding5 = get_binding();
        if (dialogApplyPreferenceSubRegBinding5 != null && (recyclerView2 = dialogApplyPreferenceSubRegBinding5.rvSemesterNo) != null) {
            recyclerView2.scrollToPosition(this.semPosition);
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding6 = get_binding();
        if (dialogApplyPreferenceSubRegBinding6 != null && (customEditText = dialogApplyPreferenceSubRegBinding6.sgpaMark) != null) {
            customEditText.setText(this.sgpaMarks.get(this.semPosition));
        }
        if (this.semPosition == 0) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding7 = get_binding();
            TextView textView3 = dialogApplyPreferenceSubRegBinding7 != null ? dialogApplyPreferenceSubRegBinding7.backBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(4);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding8 = get_binding();
            TextView textView4 = dialogApplyPreferenceSubRegBinding8 != null ? dialogApplyPreferenceSubRegBinding8.backBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        if (this.semPosition == this.semesterList.size() - 1) {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding9 = get_binding();
            TextView textView5 = dialogApplyPreferenceSubRegBinding9 != null ? dialogApplyPreferenceSubRegBinding9.nextBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding10 = get_binding();
            TextView textView6 = dialogApplyPreferenceSubRegBinding10 != null ? dialogApplyPreferenceSubRegBinding10.finishBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
        } else {
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding11 = get_binding();
            TextView textView7 = dialogApplyPreferenceSubRegBinding11 != null ? dialogApplyPreferenceSubRegBinding11.nextBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding12 = get_binding();
            TextView textView8 = dialogApplyPreferenceSubRegBinding12 != null ? dialogApplyPreferenceSubRegBinding12.finishBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
        }
        getSemesterQuestionsAdapter().addItems(this.semesters, this.semPosition);
        if (this.semesterList.get(this.semPosition).getSubjects().size() > 0) {
            getSemesterSubjectsAdapter().addItems(this.semesterList.get(this.semPosition).getSubjects(), this.semPosition);
            DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding13 = get_binding();
            RecyclerView recyclerView3 = dialogApplyPreferenceSubRegBinding13 != null ? dialogApplyPreferenceSubRegBinding13.rvSemList : null;
            if (recyclerView3 == null) {
                return;
            }
            recyclerView3.setVisibility(0);
            return;
        }
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding14 = get_binding();
        RecyclerView recyclerView4 = dialogApplyPreferenceSubRegBinding14 != null ? dialogApplyPreferenceSubRegBinding14.rvSemList : null;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setVisibility(8);
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.CallBack
    public void spinnerSelected(int id, int position, int dropDownPos) {
        this.semesterList.get(this.semPosition).getSubjects().get(position).setAns(String.valueOf(id));
        int size = this.semesterList.get(this.semPosition).getSubjects().get(position).getSubjects().size();
        for (int i = 0; i < size; i++) {
            if (dropDownPos == i) {
                this.semesterList.get(this.semPosition).getSubjects().get(position).getSubjects().get(i).setAns("Applied");
            } else {
                this.semesterList.get(this.semPosition).getSubjects().get(position).getSubjects().get(i).setAns("");
            }
        }
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.CallBack
    public void onSgpaMarkChanged(String mark, int position) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.semesterList.get(this.semPosition).getSubjects().get(position).setMark(mark);
        System.out.println(this.semesterList);
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.CallBack
    public void onSubMarkChanged(String mark, int position) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.semesterList.get(this.semPosition).getSubjects().get(position).setMark(mark);
        System.out.println(this.semesterList);
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.CallBack
    public void onExceedMaxMark(String mark, int position, int maxMark) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.semesterList.get(this.semPosition).getSubjects().get(position).setMark("");
        DialogApplyPreferenceSubRegBinding dialogApplyPreferenceSubRegBinding = get_binding();
        if (dialogApplyPreferenceSubRegBinding == null || (recyclerView = dialogApplyPreferenceSubRegBinding.rvSemList) == null) {
            return;
        }
        ToastExtKt.showErrorToast(recyclerView, "Mark cannot exceed " + maxMark);
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.CallBack
    public void onSelectSubjectClicked(int position) {
        this.semesterList.get(this.semPosition).getSubjects().get(position).setAns("");
        int size = this.semesterList.get(this.semPosition).getSubjects().get(position).getSubjects().size();
        for (int i = 0; i < size; i++) {
            this.semesterList.get(this.semPosition).getSubjects().get(position).getSubjects().get(i).setAns("");
        }
    }

    public final String convertKey(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return StringsKt.startsWith$default(input, "minor_", false, 2, (Object) null) ? StringsKt.replaceFirst$default(input, "minor_", "m_", false, 4, (Object) null) : StringsKt.startsWith$default(input, "mdc_", false, 2, (Object) null) ? StringsKt.replaceFirst$default(input, "mdc_", "d_", false, 4, (Object) null) : input;
    }

    public final String convertKey2(String input) {
        List<String> groupValues;
        String str;
        Intrinsics.checkNotNullParameter(input, "input");
        MatchResult find$default = Regex.find$default(new Regex("(minor|mdc)_(\\d+)"), input, 0, 2, null);
        return (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = groupValues.get(2)) == null) ? input : str;
    }
}