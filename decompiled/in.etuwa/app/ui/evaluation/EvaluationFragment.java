package in.etuwa.app.ui.evaluation;

import android.R;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.assignment.AssignmentResponse;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.data.model.exam.ModuleTestResponse;
import in.etuwa.app.data.model.exam.SeriesExamResponse;
import in.etuwa.app.data.model.homework.HomeWorkResponse;
import in.etuwa.app.data.model.tutorial.TutorialResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentEvaluationBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter;
import in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter;
import in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter;
import in.etuwa.app.ui.exam.ExamListener;
import in.etuwa.app.ui.exam.questions.QuestionDialog;
import in.etuwa.app.ui.exam.series.EvaluationSeriesAdapter;
import in.etuwa.app.ui.exam.submit.SubmitExamDialog;
import in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialog;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KFunction;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: EvaluationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EvaluationFragment extends BaseFragment implements EvaluationAssignmentAdapter.AssignmentListener, ExamListener, EvaluationTutorialAdapter.TutorialListener, EvaluationHomeworkAdapter.HomeWorkListener, UploadAssignmentDialog.UploadAssignmentCallBack, SubmitHomeWorkDialog.SubmitHomeWorkCallBack, SemListDialog.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentEvaluationBinding _binding;

    /* JADX INFO: renamed from: adapterAssignment$delegate, reason: from kotlin metadata */
    private final Lazy adapterAssignment;

    /* JADX INFO: renamed from: adapterHomeWork$delegate, reason: from kotlin metadata */
    private final Lazy adapterHomeWork;

    /* JADX INFO: renamed from: adapterModule$delegate, reason: from kotlin metadata */
    private final Lazy adapterModule;

    /* JADX INFO: renamed from: adapterSeries$delegate, reason: from kotlin metadata */
    private final Lazy adapterSeries;

    /* JADX INFO: renamed from: adapterTutorial$delegate, reason: from kotlin metadata */
    private final Lazy adapterTutorial;
    private String current;
    private ArrayList<DownloadModel> downList;

    /* JADX INFO: renamed from: evaluationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy evaluationViewModel;
    private String flag;
    private boolean flaglink;
    private boolean isSearchOpen;
    private final BroadcastReceiver onDownloadComplete;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String selectedFilter;
    private String semId;

    /* JADX INFO: compiled from: EvaluationFragment.kt */
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

    public EvaluationFragment() {
        final EvaluationFragment evaluationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return evaluationFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(evaluationFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.evaluationViewModel = FragmentViewModelLazyKt.createViewModelLazy(evaluationFragment, Reflection.getOrCreateKotlinClass(EvaluationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(EvaluationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final EvaluationFragment evaluationFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapterAssignment = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<EvaluationAssignmentAdapter>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationAssignmentAdapter invoke() {
                ComponentCallbacks componentCallbacks = evaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationAssignmentAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterSeries = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<EvaluationSeriesAdapter>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.exam.series.EvaluationSeriesAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationSeriesAdapter invoke() {
                ComponentCallbacks componentCallbacks = evaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationSeriesAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterModule = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<EvaluationModuleAdapter>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.evaluation.EvaluationModuleAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationModuleAdapter invoke() {
                ComponentCallbacks componentCallbacks = evaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationModuleAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.adapterTutorial = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<EvaluationTutorialAdapter>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationTutorialAdapter invoke() {
                ComponentCallbacks componentCallbacks = evaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationTutorialAdapter.class), b8, b9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        final byte b11 = 0 == true ? 1 : 0;
        this.adapterHomeWork = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<EvaluationHomeworkAdapter>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationHomeworkAdapter invoke() {
                ComponentCallbacks componentCallbacks = evaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationHomeworkAdapter.class), b10, b11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b12 = 0 == true ? 1 : 0;
        final byte b13 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = evaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b12, b13);
            }
        });
        this.current = "";
        this.semId = getPreference().getUserSemId();
        this.downList = new ArrayList<>();
        this.flag = "assignment";
        this.selectedFilter = "NOT SUBMITTED";
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$onDownloadComplete$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                KAnnotatedElement kAnnotatedElement;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    String str = this.this$0.flag;
                    switch (str.hashCode()) {
                        case -1912085273:
                            kAnnotatedElement = str.equals("series_exam") ? (KFunction) new EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$2(this.this$0.getAdapterSeries()) : (KFunction) new EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$5(this.this$0.getAdapterModule());
                            break;
                        case -485149584:
                            if (str.equals("homework")) {
                                kAnnotatedElement = (KFunction) new EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$4(this.this$0.getAdapterHomeWork());
                            }
                            break;
                        case 193276766:
                            if (str.equals("tutorial")) {
                                kAnnotatedElement = (KFunction) new EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$3(this.this$0.getAdapterTutorial());
                            }
                            break;
                        case 1026262733:
                            if (str.equals("assignment")) {
                                kAnnotatedElement = (KFunction) new EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$1(this.this$0.getAdapterAssignment());
                            }
                            break;
                        default:
                            break;
                    }
                    ArrayList arrayList = this.this$0.downList;
                    EvaluationFragment evaluationFragment3 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            ((Function1) kAnnotatedElement).invoke(Integer.valueOf(((DownloadModel) evaluationFragment3.downList.get(i)).getPosition()));
                            evaluationFragment3.downList.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final EvaluationViewModel getEvaluationViewModel() {
        return (EvaluationViewModel) this.evaluationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentEvaluationBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EvaluationAssignmentAdapter getAdapterAssignment() {
        return (EvaluationAssignmentAdapter) this.adapterAssignment.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EvaluationSeriesAdapter getAdapterSeries() {
        return (EvaluationSeriesAdapter) this.adapterSeries.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EvaluationModuleAdapter getAdapterModule() {
        return (EvaluationModuleAdapter) this.adapterModule.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EvaluationTutorialAdapter getAdapterTutorial() {
        return (EvaluationTutorialAdapter) this.adapterTutorial.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EvaluationHomeworkAdapter getAdapterHomeWork() {
        return (EvaluationHomeworkAdapter) this.adapterHomeWork.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getSemId() {
        return this.semId;
    }

    public final void setSemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semId = str;
    }

    /* JADX INFO: compiled from: EvaluationFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/evaluation/EvaluationFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EvaluationFragment newInstance() {
            return new EvaluationFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentEvaluationBinding.inflate(inflater, container, false);
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        if (fragmentEvaluationBinding != null) {
            fragmentEvaluationBinding.setEvaluationViewModel(getEvaluationViewModel());
        }
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        if (fragmentEvaluationBinding2 != null) {
            fragmentEvaluationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        if (fragmentEvaluationBinding3 != null) {
            return fragmentEvaluationBinding3.getRoot();
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
        ImageView imageView;
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        RecyclerView recyclerView = fragmentEvaluationBinding != null ? fragmentEvaluationBinding.rvAssignments : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapterAssignment());
        }
        getAdapterAssignment().setAssignmentListener(this);
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentEvaluationBinding2 != null ? fragmentEvaluationBinding2.rvSeriesExam : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterSeries());
        }
        getAdapterSeries().setExamListener(this);
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        RecyclerView recyclerView3 = fragmentEvaluationBinding3 != null ? fragmentEvaluationBinding3.rvTutorial : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapterTutorial());
        }
        getAdapterTutorial().setCallBack(this);
        FragmentEvaluationBinding fragmentEvaluationBinding4 = get_binding();
        RecyclerView recyclerView4 = fragmentEvaluationBinding4 != null ? fragmentEvaluationBinding4.rvModuletest : null;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(getAdapterModule());
        }
        getAdapterModule().setExamListener(this);
        FragmentEvaluationBinding fragmentEvaluationBinding5 = get_binding();
        RecyclerView recyclerView5 = fragmentEvaluationBinding5 != null ? fragmentEvaluationBinding5.rvHomeworks : null;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(getAdapterHomeWork());
        }
        getAdapterHomeWork().setCallBack(this);
        getEvaluationViewModel().getAssignment(this.selectedFilter, "", this.current);
        listenAssignmentResponse();
        listenSeriesExamResponse();
        listenTutorialExamResponse();
        listenHomeWorkExamResponse();
        listenModuleTestExamResponse();
        listenDeleteResponse();
        listenDeleteModuleResponse();
        setupSearch();
        setupTabButtons();
        setupFilterButtons();
        FragmentEvaluationBinding fragmentEvaluationBinding6 = get_binding();
        updateFilterUI(fragmentEvaluationBinding6 != null ? fragmentEvaluationBinding6.notSubmitBtn : null);
        applyFilter("NOT SUBMITTED");
        FragmentEvaluationBinding fragmentEvaluationBinding7 = get_binding();
        if (fragmentEvaluationBinding7 == null || (imageView = fragmentEvaluationBinding7.ivFilter) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationFragment.setUp$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(EvaluationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialog semListDialogNewInstance = SemListDialog.INSTANCE.newInstance();
        semListDialogNewInstance.setCallBackEvaluation(this$0);
        semListDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void setupSearch() {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        if (fragmentEvaluationBinding != null && (imageView2 = fragmentEvaluationBinding.ivSearch) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupSearch$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        if (fragmentEvaluationBinding2 != null && (imageView = fragmentEvaluationBinding2.ivClearSearch) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupSearch$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        if (fragmentEvaluationBinding3 == null || (editText = fragmentEvaluationBinding3.searchInput) == null) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment.setupSearch.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string;
                if (s == null || (string = s.toString()) == null) {
                    string = "";
                }
                FragmentEvaluationBinding fragmentEvaluationBinding4 = EvaluationFragment.this.get_binding();
                ImageView imageView3 = fragmentEvaluationBinding4 != null ? fragmentEvaluationBinding4.ivClearSearch : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(string.length() > 0 ? 0 : 8);
                }
                EvaluationFragment.this.filterCurrentAdapter(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$1(EvaluationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSearchOpen) {
            this$0.closeSearch();
        } else {
            this$0.openSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$2(EvaluationFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
        if (fragmentEvaluationBinding == null || (editText = fragmentEvaluationBinding.searchInput) == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    private final void openSearch() {
        EditText editText;
        ImageView imageView;
        this.isSearchOpen = true;
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        CardView cardView = fragmentEvaluationBinding != null ? fragmentEvaluationBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        if (fragmentEvaluationBinding2 != null && (imageView = fragmentEvaluationBinding2.ivSearch) != null) {
            imageView.setImageResource(R.drawable.ic_menu_close_clear_cancel);
        }
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        ImageView imageView2 = fragmentEvaluationBinding3 != null ? fragmentEvaluationBinding3.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        FragmentEvaluationBinding fragmentEvaluationBinding4 = get_binding();
        if (fragmentEvaluationBinding4 != null && (editText = fragmentEvaluationBinding4.searchInput) != null) {
            editText.requestFocus();
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentEvaluationBinding fragmentEvaluationBinding5 = get_binding();
        inputMethodManager.showSoftInput(fragmentEvaluationBinding5 != null ? fragmentEvaluationBinding5.searchInput : null, 1);
        updateSearchHint();
    }

    private final void closeSearch() {
        EditText editText;
        ImageView imageView;
        EditText editText2;
        Editable text;
        this.isSearchOpen = false;
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        IBinder windowToken = null;
        CardView cardView = fragmentEvaluationBinding != null ? fragmentEvaluationBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        if (fragmentEvaluationBinding2 != null && (editText2 = fragmentEvaluationBinding2.searchInput) != null && (text = editText2.getText()) != null) {
            text.clear();
        }
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        if (fragmentEvaluationBinding3 != null && (imageView = fragmentEvaluationBinding3.ivSearch) != null) {
            imageView.setImageResource(in.etuwa.app.R.drawable.ic_search);
        }
        FragmentEvaluationBinding fragmentEvaluationBinding4 = get_binding();
        ImageView imageView2 = fragmentEvaluationBinding4 != null ? fragmentEvaluationBinding4.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentEvaluationBinding fragmentEvaluationBinding5 = get_binding();
        if (fragmentEvaluationBinding5 != null && (editText = fragmentEvaluationBinding5.searchInput) != null) {
            windowToken = editText.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        filterCurrentAdapter("");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateSearchHint() {
        /*
            r2 = this;
            java.lang.String r0 = r2.flag
            int r1 = r0.hashCode()
            switch(r1) {
                case -1912085273: goto L3a;
                case -1194820987: goto L2e;
                case -485149584: goto L22;
                case 193276766: goto L16;
                case 1026262733: goto La;
                default: goto L9;
            }
        L9:
            goto L46
        La:
            java.lang.String r1 = "assignment"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L13
            goto L46
        L13:
            java.lang.String r0 = "Search assignments..."
            goto L48
        L16:
            java.lang.String r1 = "tutorial"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1f
            goto L46
        L1f:
            java.lang.String r0 = "Search tutorials..."
            goto L48
        L22:
            java.lang.String r1 = "homework"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2b
            goto L46
        L2b:
            java.lang.String r0 = "Search homeworks..."
            goto L48
        L2e:
            java.lang.String r1 = "module_test"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L37
            goto L46
        L37:
            java.lang.String r0 = "Search module tests..."
            goto L48
        L3a:
            java.lang.String r1 = "series_exam"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L43
            goto L46
        L43:
            java.lang.String r0 = "Search series exams..."
            goto L48
        L46:
            java.lang.String r0 = "Search..."
        L48:
            in.etuwa.app.databinding.FragmentEvaluationBinding r1 = r2.get_binding()
            if (r1 == 0) goto L51
            android.widget.EditText r1 = r1.searchInput
            goto L52
        L51:
            r1 = 0
        L52:
            if (r1 != 0) goto L55
            goto L5a
        L55:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setHint(r0)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationFragment.updateSearchHint():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void filterCurrentAdapter(String query) {
        String str = this.flag;
        switch (str.hashCode()) {
            case -1912085273:
                if (str.equals("series_exam")) {
                    getAdapterSeries().applyCombinedFilter(this.selectedFilter, query);
                    break;
                }
                break;
            case -1194820987:
                if (str.equals("module_test")) {
                    getAdapterModule().applyCombinedFilter(this.selectedFilter, query);
                    break;
                }
                break;
            case -485149584:
                if (str.equals("homework")) {
                    getAdapterHomeWork().applyCombinedFilter(this.selectedFilter, query);
                    break;
                }
                break;
            case 193276766:
                if (str.equals("tutorial")) {
                    getAdapterTutorial().applyCombinedFilter(this.selectedFilter, query);
                    break;
                }
                break;
            case 1026262733:
                if (str.equals("assignment")) {
                    getAdapterAssignment().filter(query);
                    break;
                }
                break;
        }
    }

    private final void setTabSelected(String selected) {
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"assignment", "series_exam", "module_test", "tutorial", "homework"});
        Pair[] pairArr = new Pair[5];
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        pairArr[0] = TuplesKt.to("assignment", fragmentEvaluationBinding != null ? fragmentEvaluationBinding.assignmentsBtn : null);
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        pairArr[1] = TuplesKt.to("series_exam", fragmentEvaluationBinding2 != null ? fragmentEvaluationBinding2.seriesBtn : null);
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        pairArr[2] = TuplesKt.to("module_test", fragmentEvaluationBinding3 != null ? fragmentEvaluationBinding3.moduleBtn : null);
        FragmentEvaluationBinding fragmentEvaluationBinding4 = get_binding();
        pairArr[3] = TuplesKt.to("tutorial", fragmentEvaluationBinding4 != null ? fragmentEvaluationBinding4.tutorialsBtn : null);
        FragmentEvaluationBinding fragmentEvaluationBinding5 = get_binding();
        pairArr[4] = TuplesKt.to("homework", fragmentEvaluationBinding5 != null ? fragmentEvaluationBinding5.homeworksBtn : null);
        Map mapMapOf = MapsKt.mapOf(pairArr);
        Pair[] pairArr2 = new Pair[5];
        FragmentEvaluationBinding fragmentEvaluationBinding6 = get_binding();
        pairArr2[0] = TuplesKt.to("assignment", fragmentEvaluationBinding6 != null ? fragmentEvaluationBinding6.rvAssignments : null);
        FragmentEvaluationBinding fragmentEvaluationBinding7 = get_binding();
        pairArr2[1] = TuplesKt.to("series_exam", fragmentEvaluationBinding7 != null ? fragmentEvaluationBinding7.rvSeriesExam : null);
        FragmentEvaluationBinding fragmentEvaluationBinding8 = get_binding();
        pairArr2[2] = TuplesKt.to("module_test", fragmentEvaluationBinding8 != null ? fragmentEvaluationBinding8.rvModuletest : null);
        FragmentEvaluationBinding fragmentEvaluationBinding9 = get_binding();
        pairArr2[3] = TuplesKt.to("tutorial", fragmentEvaluationBinding9 != null ? fragmentEvaluationBinding9.rvTutorial : null);
        FragmentEvaluationBinding fragmentEvaluationBinding10 = get_binding();
        pairArr2[4] = TuplesKt.to("homework", fragmentEvaluationBinding10 != null ? fragmentEvaluationBinding10.rvHomeworks : null);
        Map mapMapOf2 = MapsKt.mapOf(pairArr2);
        for (String str : listListOf) {
            if (Intrinsics.areEqual(str, selected)) {
                TextView textView = (TextView) mapMapOf.get(str);
                if (textView != null) {
                    textView.setBackgroundResource(in.etuwa.app.R.drawable.shape_round_selected);
                }
                TextView textView2 = (TextView) mapMapOf.get(str);
                if (textView2 != null) {
                    textView2.setTextColor(-1);
                }
                RecyclerView recyclerView = (RecyclerView) mapMapOf2.get(str);
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
            } else {
                TextView textView3 = (TextView) mapMapOf.get(str);
                if (textView3 != null) {
                    textView3.setBackgroundResource(in.etuwa.app.R.drawable.shape_round_unselected);
                }
                TextView textView4 = (TextView) mapMapOf.get(str);
                if (textView4 != null) {
                    textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
                RecyclerView recyclerView2 = (RecyclerView) mapMapOf2.get(str);
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(8);
                }
            }
        }
    }

    private final void setupTabButtons() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        if (fragmentEvaluationBinding != null && (textView5 = fragmentEvaluationBinding.assignmentsBtn) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupTabButtons$lambda$4(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        if (fragmentEvaluationBinding2 != null && (textView4 = fragmentEvaluationBinding2.seriesBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupTabButtons$lambda$5(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        if (fragmentEvaluationBinding3 != null && (textView3 = fragmentEvaluationBinding3.moduleBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupTabButtons$lambda$6(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding4 = get_binding();
        if (fragmentEvaluationBinding4 != null && (textView2 = fragmentEvaluationBinding4.tutorialsBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupTabButtons$lambda$7(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding5 = get_binding();
        if (fragmentEvaluationBinding5 == null || (textView = fragmentEvaluationBinding5.homeworksBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationFragment.setupTabButtons$lambda$8(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTabButtons$lambda$4(EvaluationFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "assignment";
        this$0.getEvaluationViewModel().getAssignment(this$0.selectedFilter, "", this$0.current);
        this$0.setTabSelected("assignment");
        if (this$0.isSearchOpen) {
            FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
            if (fragmentEvaluationBinding != null && (editText = fragmentEvaluationBinding.searchInput) != null && (text = editText.getText()) != null) {
                text.clear();
            }
            this$0.updateSearchHint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTabButtons$lambda$5(EvaluationFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "series_exam";
        this$0.getEvaluationViewModel().getExams(this$0.current);
        this$0.setTabSelected("series_exam");
        this$0.applyFilter(this$0.selectedFilter);
        if (this$0.isSearchOpen) {
            FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
            if (fragmentEvaluationBinding != null && (editText = fragmentEvaluationBinding.searchInput) != null && (text = editText.getText()) != null) {
                text.clear();
            }
            this$0.updateSearchHint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTabButtons$lambda$6(EvaluationFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "module_test";
        this$0.getEvaluationViewModel().getExams();
        this$0.setTabSelected("module_test");
        this$0.applyFilter(this$0.selectedFilter);
        if (this$0.isSearchOpen) {
            FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
            if (fragmentEvaluationBinding != null && (editText = fragmentEvaluationBinding.searchInput) != null && (text = editText.getText()) != null) {
                text.clear();
            }
            this$0.updateSearchHint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTabButtons$lambda$7(EvaluationFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "tutorial";
        this$0.getEvaluationViewModel().getTutorials();
        this$0.setTabSelected("tutorial");
        this$0.applyFilter(this$0.selectedFilter);
        if (this$0.isSearchOpen) {
            FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
            if (fragmentEvaluationBinding != null && (editText = fragmentEvaluationBinding.searchInput) != null && (text = editText.getText()) != null) {
                text.clear();
            }
            this$0.updateSearchHint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTabButtons$lambda$8(EvaluationFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "homework";
        this$0.getEvaluationViewModel().getHomeWork();
        this$0.setTabSelected("homework");
        this$0.applyFilter(this$0.selectedFilter);
        if (this$0.isSearchOpen) {
            FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
            if (fragmentEvaluationBinding != null && (editText = fragmentEvaluationBinding.searchInput) != null && (text = editText.getText()) != null) {
                text.clear();
            }
            this$0.updateSearchHint();
        }
    }

    private final void setupFilterButtons() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        if (fragmentEvaluationBinding != null && (textView3 = fragmentEvaluationBinding.submitBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupFilterButtons$lambda$9(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        if (fragmentEvaluationBinding2 != null && (textView2 = fragmentEvaluationBinding2.notSubmitBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EvaluationFragment.setupFilterButtons$lambda$10(this.f$0, view);
                }
            });
        }
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        if (fragmentEvaluationBinding3 == null || (textView = fragmentEvaluationBinding3.allBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationFragment.setupFilterButtons$lambda$11(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFilterButtons$lambda$9(EvaluationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.applyFilter("SUBMITTED");
        FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
        this$0.updateFilterUI(fragmentEvaluationBinding != null ? fragmentEvaluationBinding.submitBtn : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFilterButtons$lambda$10(EvaluationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.applyFilter("NOT SUBMITTED");
        FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
        this$0.updateFilterUI(fragmentEvaluationBinding != null ? fragmentEvaluationBinding.notSubmitBtn : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFilterButtons$lambda$11(EvaluationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.applyFilter("");
        FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
        this$0.updateFilterUI(fragmentEvaluationBinding != null ? fragmentEvaluationBinding.allBtn : null);
    }

    private final void updateFilterUI(View selected) {
        TextView[] textViewArr = new TextView[3];
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        textViewArr[0] = fragmentEvaluationBinding != null ? fragmentEvaluationBinding.submitBtn : null;
        FragmentEvaluationBinding fragmentEvaluationBinding2 = get_binding();
        textViewArr[1] = fragmentEvaluationBinding2 != null ? fragmentEvaluationBinding2.notSubmitBtn : null;
        FragmentEvaluationBinding fragmentEvaluationBinding3 = get_binding();
        textViewArr[2] = fragmentEvaluationBinding3 != null ? fragmentEvaluationBinding3.allBtn : null;
        for (TextView textView : CollectionsKt.listOf((Object[]) textViewArr)) {
            if (textView != null) {
                textView.setBackgroundColor(0);
            }
            if (textView != null) {
                textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        if (selected != null) {
            selected.setBackgroundResource(in.etuwa.app.R.drawable.shape_round_selected);
        }
        TextView textView2 = selected instanceof TextView ? (TextView) selected : null;
        if (textView2 != null) {
            textView2.setTextColor(-1);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void applyFilter(String status) {
        EditText editText;
        Editable text;
        String string;
        this.selectedFilter = status;
        String str = "";
        if (Intrinsics.areEqual(this.flag, "assignment")) {
            getEvaluationViewModel().getAssignment(this.selectedFilter, "", this.current);
        }
        FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
        if (fragmentEvaluationBinding != null && (editText = fragmentEvaluationBinding.searchInput) != null && (text = editText.getText()) != null && (string = text.toString()) != null) {
            str = string;
        }
        String str2 = this.flag;
        switch (str2.hashCode()) {
            case -1912085273:
                if (str2.equals("series_exam")) {
                    getAdapterSeries().applyCombinedFilter(status, str);
                    break;
                }
                break;
            case -1194820987:
                if (str2.equals("module_test")) {
                    getAdapterModule().applyCombinedFilter(status, str);
                    break;
                }
                break;
            case -485149584:
                if (str2.equals("homework")) {
                    getAdapterHomeWork().applyCombinedFilter(status, str);
                    break;
                }
                break;
            case 193276766:
                if (str2.equals("tutorial")) {
                    getAdapterTutorial().applyCombinedFilter(status, str);
                    break;
                }
                break;
        }
    }

    private final void listenAssignmentResponse() {
        getEvaluationViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenAssignmentResponse$lambda$15(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAssignmentResponse$lambda$15(EvaluationFragment this$0, Resource resource) {
        EditText editText;
        Editable text;
        String string;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            AssignmentResponse assignmentResponse = (AssignmentResponse) resource.getData();
            if (assignmentResponse != null) {
                this$0.showBaseView();
                if (assignmentResponse.getLogin()) {
                    this$0.flaglink = assignmentResponse.getSubmit_by_link();
                    this$0.getAdapterAssignment().addItems(assignmentResponse.getAssignments());
                    FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
                    if (fragmentEvaluationBinding == null || (editText = fragmentEvaluationBinding.searchInput) == null || (text = editText.getText()) == null || (string = text.toString()) == null) {
                        return;
                    }
                    this$0.getAdapterAssignment().filter(string);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        FragmentEvaluationBinding fragmentEvaluationBinding2 = this$0.get_binding();
        if (fragmentEvaluationBinding2 == null || (recyclerView = fragmentEvaluationBinding2.rvAssignments) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        String message = resource.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ToastExtKt.showErrorToast(recyclerView2, message);
    }

    private final void listenSeriesExamResponse() {
        getEvaluationViewModel().getExamResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenSeriesExamResponse$lambda$17(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSeriesExamResponse$lambda$17(EvaluationFragment this$0, Resource resource) {
        String string;
        EditText editText;
        Editable text;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SeriesExamResponse seriesExamResponse = (SeriesExamResponse) resource.getData();
            if (seriesExamResponse != null) {
                this$0.showBaseView();
                if (seriesExamResponse.getLogin()) {
                    this$0.getAdapterSeries().addItems(seriesExamResponse.getSeriesExams());
                    FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
                    if (fragmentEvaluationBinding == null || (editText = fragmentEvaluationBinding.searchInput) == null || (text = editText.getText()) == null || (string = text.toString()) == null) {
                        string = "";
                    }
                    this$0.getAdapterSeries().applyCombinedFilter(this$0.selectedFilter, string);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        FragmentEvaluationBinding fragmentEvaluationBinding2 = this$0.get_binding();
        if (fragmentEvaluationBinding2 == null || (recyclerView = fragmentEvaluationBinding2.rvAssignments) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        String message = resource.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ToastExtKt.showErrorToast(recyclerView2, message);
    }

    private final void listenTutorialExamResponse() {
        getEvaluationViewModel().getTutorialResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenTutorialExamResponse$lambda$19(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenTutorialExamResponse$lambda$19(EvaluationFragment this$0, Resource resource) {
        String string;
        EditText editText;
        Editable text;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TutorialResponse tutorialResponse = (TutorialResponse) resource.getData();
            if (tutorialResponse != null) {
                this$0.showBaseView();
                if (tutorialResponse.getLogin()) {
                    this$0.getAdapterTutorial().addItems(tutorialResponse.getTutorials());
                    FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
                    if (fragmentEvaluationBinding == null || (editText = fragmentEvaluationBinding.searchInput) == null || (text = editText.getText()) == null || (string = text.toString()) == null) {
                        string = "";
                    }
                    this$0.getAdapterTutorial().applyCombinedFilter(this$0.selectedFilter, string);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        FragmentEvaluationBinding fragmentEvaluationBinding2 = this$0.get_binding();
        if (fragmentEvaluationBinding2 == null || (recyclerView = fragmentEvaluationBinding2.rvAssignments) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        String message = resource.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ToastExtKt.showErrorToast(recyclerView2, message);
    }

    private final void listenHomeWorkExamResponse() {
        getEvaluationViewModel().getHWResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenHomeWorkExamResponse$lambda$21(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenHomeWorkExamResponse$lambda$21(EvaluationFragment this$0, Resource resource) {
        String string;
        EditText editText;
        Editable text;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HomeWorkResponse homeWorkResponse = (HomeWorkResponse) resource.getData();
            if (homeWorkResponse != null) {
                this$0.showBaseView();
                if (homeWorkResponse.getLogin()) {
                    this$0.getAdapterHomeWork().addItems(homeWorkResponse.getHomeworks());
                    FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
                    if (fragmentEvaluationBinding == null || (editText = fragmentEvaluationBinding.searchInput) == null || (text = editText.getText()) == null || (string = text.toString()) == null) {
                        string = "";
                    }
                    this$0.getAdapterHomeWork().applyCombinedFilter(this$0.selectedFilter, string);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        FragmentEvaluationBinding fragmentEvaluationBinding2 = this$0.get_binding();
        if (fragmentEvaluationBinding2 == null || (recyclerView = fragmentEvaluationBinding2.rvAssignments) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        String message = resource.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ToastExtKt.showErrorToast(recyclerView2, message);
    }

    private final void listenModuleTestExamResponse() {
        getEvaluationViewModel().getModuleResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenModuleTestExamResponse$lambda$23(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenModuleTestExamResponse$lambda$23(EvaluationFragment this$0, Resource resource) {
        String string;
        EditText editText;
        Editable text;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ModuleTestResponse moduleTestResponse = (ModuleTestResponse) resource.getData();
            if (moduleTestResponse != null) {
                this$0.showBaseView();
                if (moduleTestResponse.getLogin()) {
                    this$0.getAdapterModule().addItems(moduleTestResponse.getModuleTest());
                    FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
                    if (fragmentEvaluationBinding == null || (editText = fragmentEvaluationBinding.searchInput) == null || (text = editText.getText()) == null || (string = text.toString()) == null) {
                        string = "";
                    }
                    this$0.getAdapterModule().applyCombinedFilter(this$0.selectedFilter, string);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        FragmentEvaluationBinding fragmentEvaluationBinding2 = this$0.get_binding();
        if (fragmentEvaluationBinding2 == null || (recyclerView = fragmentEvaluationBinding2.rvAssignments) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        String message = resource.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ToastExtKt.showErrorToast(recyclerView2, message);
    }

    @Override // in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter.AssignmentListener, in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter.TutorialListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            loadPickerDialog(id);
        } else {
            requestPermission();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void loadPickerDialog(String id) {
        String str = this.flag;
        switch (str.hashCode()) {
            case -1912085273:
                if (str.equals("series_exam")) {
                    SubmitExamDialog submitExamDialogNewInstance = SubmitExamDialog.INSTANCE.newInstance(id, 0);
                    submitExamDialogNewInstance.setUploadCallBack(this);
                    submitExamDialogNewInstance.show(getChildFragmentManager(), (String) null);
                    break;
                }
                break;
            case -1194820987:
                if (str.equals("module_test")) {
                    SubmitExamDialog submitExamDialogNewInstance2 = SubmitExamDialog.INSTANCE.newInstance(id, 1);
                    submitExamDialogNewInstance2.setUploadCallBack(this);
                    submitExamDialogNewInstance2.show(getChildFragmentManager(), (String) null);
                    break;
                }
                break;
            case -485149584:
                if (str.equals("homework")) {
                    SubmitHomeWorkDialog submitHomeWorkDialogNewInstance = SubmitHomeWorkDialog.INSTANCE.newInstance(id);
                    submitHomeWorkDialogNewInstance.setSubmitHomeWorkCallBack(this);
                    submitHomeWorkDialogNewInstance.show(getChildFragmentManager(), (String) null);
                    break;
                }
                break;
            case 1026262733:
                if (str.equals("assignment")) {
                    UploadAssignmentDialog uploadAssignmentDialogNewInstance = UploadAssignmentDialog.INSTANCE.newInstance(id, this.flaglink);
                    uploadAssignmentDialogNewInstance.setUploadCallBack2(this);
                    uploadAssignmentDialogNewInstance.show(getChildFragmentManager(), (String) null);
                    break;
                }
                break;
        }
    }

    @Override // in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public void deleteHomeWork(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getEvaluationViewModel().deleteHomeWork(id);
    }

    @Override // in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter.TutorialListener
    public void deleteTutorials(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getEvaluationViewModel().deleteTutorial(id);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void deleteExam(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (Intrinsics.areEqual(this.flag, "series_exam")) {
            getEvaluationViewModel().deleteExam(id);
        } else {
            getEvaluationViewModel().deleteModuleExam(id);
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public void openDownloadDialog(ArrayList<ExamFiles> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        QuestionDialog.INSTANCE.newInstance(list, !Intrinsics.areEqual(this.flag, "module_test")).show(getChildFragmentManager(), (String) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void downloadFile(java.lang.String r6, int r7) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationFragment.downloadFile(java.lang.String, int):void");
    }

    private final void listenDeleteResponse() {
        getEvaluationViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenDeleteResponse$lambda$25(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$25(EvaluationFragment this$0, Resource resource) {
        RecyclerView rvAssignments;
        RecyclerView rvAssignments2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SuccessResponse successResponse = (SuccessResponse) resource.getData();
            if (successResponse != null) {
                this$0.showBaseView();
                if (successResponse.getSuccess()) {
                    FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
                    if (fragmentEvaluationBinding != null && (rvAssignments2 = fragmentEvaluationBinding.rvAssignments) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvAssignments2, "rvAssignments");
                        ToastExtKt.showSuccessToast(rvAssignments2, successResponse.getMessage());
                    }
                    this$0.getEvaluationViewModel().getAssignment("", "", this$0.current);
                    return;
                }
                FragmentEvaluationBinding fragmentEvaluationBinding2 = this$0.get_binding();
                if (fragmentEvaluationBinding2 == null || (rvAssignments = fragmentEvaluationBinding2.rvAssignments) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvAssignments, "rvAssignments");
                ToastExtKt.showErrorToast(rvAssignments, successResponse.getError());
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
        FragmentEvaluationBinding fragmentEvaluationBinding3 = this$0.get_binding();
        if (fragmentEvaluationBinding3 == null || (recyclerView = fragmentEvaluationBinding3.rvAssignments) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        String message = resource.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ToastExtKt.showErrorToast(recyclerView2, message);
    }

    private final void listenDeleteModuleResponse() {
        getEvaluationViewModel().getDeleteModuleResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.listenDeleteModuleResponse$lambda$27(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteModuleResponse$lambda$27(EvaluationFragment this$0, Resource resource) {
        RecyclerView rvAssignments;
        RecyclerView rvAssignments2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SuccessResponse successResponse = (SuccessResponse) resource.getData();
            if (successResponse != null) {
                this$0.showBaseView();
                if (successResponse.getSuccess()) {
                    FragmentEvaluationBinding fragmentEvaluationBinding = this$0.get_binding();
                    if (fragmentEvaluationBinding != null && (rvAssignments2 = fragmentEvaluationBinding.rvAssignments) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvAssignments2, "rvAssignments");
                        ToastExtKt.showSuccessToast(rvAssignments2, successResponse.getMessage());
                    }
                    this$0.getEvaluationViewModel().getExams();
                    return;
                }
                FragmentEvaluationBinding fragmentEvaluationBinding2 = this$0.get_binding();
                if (fragmentEvaluationBinding2 == null || (rvAssignments = fragmentEvaluationBinding2.rvAssignments) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvAssignments, "rvAssignments");
                ToastExtKt.showErrorToast(rvAssignments, successResponse.getError());
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
        FragmentEvaluationBinding fragmentEvaluationBinding3 = this$0.get_binding();
        if (fragmentEvaluationBinding3 == null || (recyclerView = fragmentEvaluationBinding3.rvAssignments) == null) {
            return;
        }
        RecyclerView recyclerView2 = recyclerView;
        String message = resource.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ToastExtKt.showErrorToast(recyclerView2, message);
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(in.etuwa.app.R.string.storage_permission_title)).setMessage(getString(in.etuwa.app.R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationFragment$$ExternalSyntheticLambda10
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        EvaluationFragment.requestPermission$lambda$28(this.f$0, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$28(EvaluationFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            try {
                if (!(!(grantResults.length == 0)) || grantResults[0] != 0) {
                    if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                        Context contextRequireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        new ValidChecker(contextRequireContext).showPermissionDialog();
                    } else {
                        Toast.makeText(requireContext(), "Permission Denied, You cannot Upload Profile Image.", 0).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String str = this.flag;
        switch (str.hashCode()) {
            case -1194820987:
                if (str.equals("module_test")) {
                    Context contextRequireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.UPLOAD_MODULE_TEST_PATH);
                }
                break;
            case -485149584:
                if (str.equals("homework")) {
                    Context contextRequireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    return new ValidChecker(contextRequireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_HOME_WORK_PATH);
                }
                break;
            case 193276766:
                if (str.equals("tutorial")) {
                    Context contextRequireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                    return new ValidChecker(contextRequireContext3).checkFileExistence(fileName, AppConstant.UPLOAD_TUTORIAL_PATH);
                }
                break;
            case 1026262733:
                if (str.equals("assignment")) {
                    Context contextRequireContext4 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
                    return new ValidChecker(contextRequireContext4).checkFileExistence(fileName, AppConstant.UPLOAD_ASSIGNMENT_PATH);
                }
                break;
        }
        Context contextRequireContext5 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext()");
        return new ValidChecker(contextRequireContext5).checkFileExistence(fileName, AppConstant.UPLOAD_SERIES_EXAM_PATH);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog.UploadAssignmentCallBack
    public void onDismiss() {
        String str = this.flag;
        switch (str.hashCode()) {
            case -1194820987:
                if (str.equals("module_test")) {
                    getEvaluationViewModel().getExams();
                    return;
                }
                break;
            case -485149584:
                if (str.equals("homework")) {
                    getEvaluationViewModel().getHomeWork();
                    return;
                }
                break;
            case 193276766:
                if (str.equals("tutorial")) {
                    getEvaluationViewModel().getTutorials();
                    return;
                }
                break;
            case 1026262733:
                if (str.equals("assignment")) {
                    getEvaluationViewModel().getAssignment("", "", this.current);
                    return;
                }
                break;
        }
        getEvaluationViewModel().getExams(this.current);
    }

    @Override // in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter.AssignmentListener
    public void deleteAssignment(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getEvaluationViewModel().deleteAssignment(id);
    }

    @Override // in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter.AssignmentListener, in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter.TutorialListener
    public void downloadFile(String url, int position, boolean flag) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        String str = flag ? "/etlab/assignments/" : AppConstant.UPLOAD_ASSIGNMENT_PATH;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(strReplace, flag)) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                new DownloadManagerHelper(contextRequireContext2).openFile(strReplace, str);
                return;
            }
            try {
                FragmentEvaluationBinding fragmentEvaluationBinding = get_binding();
                if (fragmentEvaluationBinding != null && (recyclerView = fragmentEvaluationBinding.rvAssignments) != null) {
                    String string = getString(in.etuwa.app.R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext3).startDownloading(str, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
                }
                this.downList.add(new DownloadModel(jStartDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter.AssignmentListener, in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter.TutorialListener
    public boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            return new ValidChecker(contextRequireContext).checkFileExistence(fileName, "/etlab/assignments/");
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        return new ValidChecker(contextRequireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_ASSIGNMENT_PATH);
    }

    @Override // in.etuwa.app.ui.result.university.semlistdialog.SemListDialog.SemDialogCallBack
    public void loadSelectedSem(String id, String semName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        if (Intrinsics.areEqual(this.flag, "assignment")) {
            getEvaluationViewModel().getAssignment(this.selectedFilter, "", id);
        } else if (Intrinsics.areEqual(this.flag, "series_exam")) {
            getEvaluationViewModel().getExams(id);
        }
    }
}