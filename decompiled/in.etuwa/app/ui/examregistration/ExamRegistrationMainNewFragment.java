package in.etuwa.app.ui.examregistration;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamReceiptResponse;
import in.etuwa.app.data.model.examregister.ExamRegisterResponse;
import in.etuwa.app.data.model.examregister.RevaluationStatusResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentExamRegistrationNewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter;
import in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter;
import in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptAdapter;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter;
import in.etuwa.app.ui.examregistration.revaluation.RevaluationAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: ExamRegistrationMainNewFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExamRegistrationMainNewFragment extends BaseFragment implements ExamSubjectAdapter.CallBack, RevaluationAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamRegistrationNewBinding _binding;
    private String abcId;

    /* JADX INFO: renamed from: adapterHomeWork$delegate, reason: from kotlin metadata */
    private final Lazy adapterHomeWork;

    /* JADX INFO: renamed from: adapterReceipt$delegate, reason: from kotlin metadata */
    private final Lazy adapterReceipt;

    /* JADX INFO: renamed from: adapterRevaluation$delegate, reason: from kotlin metadata */
    private final Lazy adapterRevaluation;

    /* JADX INFO: renamed from: adapterTutorial$delegate, reason: from kotlin metadata */
    private final Lazy adapterTutorial;
    private String current;
    private ArrayList<DownloadModel> downList;

    /* JADX INFO: renamed from: examRegistrationMainNewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examRegistrationMainNewViewModel;

    /* JADX INFO: renamed from: examSubjectAdapter$delegate, reason: from kotlin metadata */
    private final Lazy examSubjectAdapter;
    private String flag;
    private String id;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* JADX INFO: compiled from: ExamRegistrationMainNewFragment.kt */
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

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack
    public void viewBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public ExamRegistrationMainNewFragment() {
        final ExamRegistrationMainNewFragment examRegistrationMainNewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return examRegistrationMainNewFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examRegistrationMainNewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examRegistrationMainNewViewModel = FragmentViewModelLazyKt.createViewModelLazy(examRegistrationMainNewFragment, Reflection.getOrCreateKotlinClass(ExamRegistrationMainNewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ExamRegistrationMainNewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamRegistrationMainNewFragment examRegistrationMainNewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.examSubjectAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ExamSubjectAdapter>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamSubjectAdapter invoke() {
                ComponentCallbacks componentCallbacks = examRegistrationMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamSubjectAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterReceipt = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<ExamReceiptAdapter>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = examRegistrationMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamReceiptAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterRevaluation = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<RevaluationAdapter>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.revaluation.RevaluationAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final RevaluationAdapter invoke() {
                ComponentCallbacks componentCallbacks = examRegistrationMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(RevaluationAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.adapterTutorial = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<EvaluationTutorialAdapter>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationTutorialAdapter invoke() {
                ComponentCallbacks componentCallbacks = examRegistrationMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationTutorialAdapter.class), b8, b9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        final byte b11 = 0 == true ? 1 : 0;
        this.adapterHomeWork = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<EvaluationHomeworkAdapter>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EvaluationHomeworkAdapter invoke() {
                ComponentCallbacks componentCallbacks = examRegistrationMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(EvaluationHomeworkAdapter.class), b10, b11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b12 = 0 == true ? 1 : 0;
        final byte b13 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = examRegistrationMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b12, b13);
            }
        });
        this.current = "";
        this.semId = getPreference().getUserSemId();
        this.downList = new ArrayList<>();
        this.flag = "registration";
    }

    private final ExamRegistrationMainNewViewModel getExamRegistrationMainNewViewModel() {
        return (ExamRegistrationMainNewViewModel) this.examRegistrationMainNewViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentExamRegistrationNewBinding get_binding() {
        return this._binding;
    }

    private final ExamSubjectAdapter getExamSubjectAdapter() {
        return (ExamSubjectAdapter) this.examSubjectAdapter.getValue();
    }

    private final ExamReceiptAdapter getAdapterReceipt() {
        return (ExamReceiptAdapter) this.adapterReceipt.getValue();
    }

    private final RevaluationAdapter getAdapterRevaluation() {
        return (RevaluationAdapter) this.adapterRevaluation.getValue();
    }

    private final EvaluationTutorialAdapter getAdapterTutorial() {
        return (EvaluationTutorialAdapter) this.adapterTutorial.getValue();
    }

    private final EvaluationHomeworkAdapter getAdapterHomeWork() {
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

    /* JADX INFO: compiled from: ExamRegistrationMainNewFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/examregistration/ExamRegistrationMainNewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/ExamRegistrationMainNewFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExamRegistrationMainNewFragment newInstance() {
            return new ExamRegistrationMainNewFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentExamRegistrationNewBinding.inflate(inflater, container, false);
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = get_binding();
        if (fragmentExamRegistrationNewBinding != null) {
            fragmentExamRegistrationNewBinding.setExamRegistrationMainNewViewModel(getExamRegistrationMainNewViewModel());
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = get_binding();
        if (fragmentExamRegistrationNewBinding2 != null) {
            fragmentExamRegistrationNewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = get_binding();
        if (fragmentExamRegistrationNewBinding3 != null) {
            return fragmentExamRegistrationNewBinding3.getRoot();
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
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = get_binding();
        RecyclerView recyclerView = fragmentExamRegistrationNewBinding != null ? fragmentExamRegistrationNewBinding.rvRegistration : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getExamSubjectAdapter());
        }
        getExamSubjectAdapter().setCallBackNew(this);
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentExamRegistrationNewBinding2 != null ? fragmentExamRegistrationNewBinding2.rvReceipts : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterReceipt());
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = get_binding();
        RecyclerView recyclerView3 = fragmentExamRegistrationNewBinding3 != null ? fragmentExamRegistrationNewBinding3.rvRevaluation : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapterRevaluation());
        }
        getAdapterRevaluation().setCallBackNew(this);
        listenRegistrationResponse();
        listenReceiptsResponse();
        getExamRegistrationMainNewViewModel().getExamData();
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding4 = get_binding();
        if (fragmentExamRegistrationNewBinding4 != null && (textView4 = fragmentExamRegistrationNewBinding4.registrationBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRegistrationMainNewFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding5 = get_binding();
        if (fragmentExamRegistrationNewBinding5 != null && (textView3 = fragmentExamRegistrationNewBinding5.revaluationBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRegistrationMainNewFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding6 = get_binding();
        if (fragmentExamRegistrationNewBinding6 != null && (textView2 = fragmentExamRegistrationNewBinding6.resultBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRegistrationMainNewFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding7 = get_binding();
        if (fragmentExamRegistrationNewBinding7 == null || (textView = fragmentExamRegistrationNewBinding7.feeReceiptBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamRegistrationMainNewFragment.setUp$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ExamRegistrationMainNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "registration";
        this$0.getExamRegistrationMainNewViewModel().getExamData();
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding != null && (textView8 = fragmentExamRegistrationNewBinding.registrationBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding2 != null && (textView7 = fragmentExamRegistrationNewBinding2.resultBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding3 != null && (textView6 = fragmentExamRegistrationNewBinding3.revaluationBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding4 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding4 != null && (textView5 = fragmentExamRegistrationNewBinding4.feeReceiptBtn) != null) {
            textView5.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding5 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding5 != null && (textView4 = fragmentExamRegistrationNewBinding5.registrationBtn) != null) {
            textView4.setTextColor(-1);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding6 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding6 != null && (textView3 = fragmentExamRegistrationNewBinding6.resultBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding7 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding7 != null && (textView2 = fragmentExamRegistrationNewBinding7.revaluationBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding8 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding8 != null && (textView = fragmentExamRegistrationNewBinding8.feeReceiptBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding9 = this$0.get_binding();
        RecyclerView recyclerView = fragmentExamRegistrationNewBinding9 != null ? fragmentExamRegistrationNewBinding9.rvRegistration : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding10 = this$0.get_binding();
        RecyclerView recyclerView2 = fragmentExamRegistrationNewBinding10 != null ? fragmentExamRegistrationNewBinding10.rvExamResults : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding11 = this$0.get_binding();
        RecyclerView recyclerView3 = fragmentExamRegistrationNewBinding11 != null ? fragmentExamRegistrationNewBinding11.rvReceipts : null;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding12 = this$0.get_binding();
        RecyclerView recyclerView4 = fragmentExamRegistrationNewBinding12 != null ? fragmentExamRegistrationNewBinding12.rvRevaluation : null;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ExamRegistrationMainNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "revaluation";
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding != null && (textView8 = fragmentExamRegistrationNewBinding.registrationBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding2 != null && (textView7 = fragmentExamRegistrationNewBinding2.resultBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding3 != null && (textView6 = fragmentExamRegistrationNewBinding3.revaluationBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding4 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding4 != null && (textView5 = fragmentExamRegistrationNewBinding4.feeReceiptBtn) != null) {
            textView5.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding5 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding5 != null && (textView4 = fragmentExamRegistrationNewBinding5.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding6 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding6 != null && (textView3 = fragmentExamRegistrationNewBinding6.resultBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding7 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding7 != null && (textView2 = fragmentExamRegistrationNewBinding7.revaluationBtn) != null) {
            textView2.setTextColor(-1);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding8 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding8 != null && (textView = fragmentExamRegistrationNewBinding8.feeReceiptBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding9 = this$0.get_binding();
        RecyclerView recyclerView = fragmentExamRegistrationNewBinding9 != null ? fragmentExamRegistrationNewBinding9.rvRegistration : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding10 = this$0.get_binding();
        RecyclerView recyclerView2 = fragmentExamRegistrationNewBinding10 != null ? fragmentExamRegistrationNewBinding10.rvExamResults : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding11 = this$0.get_binding();
        RecyclerView recyclerView3 = fragmentExamRegistrationNewBinding11 != null ? fragmentExamRegistrationNewBinding11.rvReceipts : null;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding12 = this$0.get_binding();
        RecyclerView recyclerView4 = fragmentExamRegistrationNewBinding12 != null ? fragmentExamRegistrationNewBinding12.rvRevaluation : null;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ExamRegistrationMainNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flag = "results";
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding != null && (textView8 = fragmentExamRegistrationNewBinding.registrationBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding2 != null && (textView7 = fragmentExamRegistrationNewBinding2.resultBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding3 != null && (textView6 = fragmentExamRegistrationNewBinding3.revaluationBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding4 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding4 != null && (textView5 = fragmentExamRegistrationNewBinding4.feeReceiptBtn) != null) {
            textView5.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding5 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding5 != null && (textView4 = fragmentExamRegistrationNewBinding5.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding6 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding6 != null && (textView3 = fragmentExamRegistrationNewBinding6.resultBtn) != null) {
            textView3.setTextColor(-1);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding7 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding7 != null && (textView2 = fragmentExamRegistrationNewBinding7.revaluationBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding8 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding8 != null && (textView = fragmentExamRegistrationNewBinding8.feeReceiptBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding9 = this$0.get_binding();
        RecyclerView recyclerView = fragmentExamRegistrationNewBinding9 != null ? fragmentExamRegistrationNewBinding9.rvRegistration : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding10 = this$0.get_binding();
        RecyclerView recyclerView2 = fragmentExamRegistrationNewBinding10 != null ? fragmentExamRegistrationNewBinding10.rvExamResults : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding11 = this$0.get_binding();
        RecyclerView recyclerView3 = fragmentExamRegistrationNewBinding11 != null ? fragmentExamRegistrationNewBinding11.rvReceipts : null;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding12 = this$0.get_binding();
        RecyclerView recyclerView4 = fragmentExamRegistrationNewBinding12 != null ? fragmentExamRegistrationNewBinding12.rvRevaluation : null;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ExamRegistrationMainNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getExamRegistrationMainNewViewModel().getExamReceiptData();
        this$0.flag = "receipts";
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding != null && (textView8 = fragmentExamRegistrationNewBinding.registrationBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding2 != null && (textView7 = fragmentExamRegistrationNewBinding2.resultBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding3 != null && (textView6 = fragmentExamRegistrationNewBinding3.revaluationBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding4 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding4 != null && (textView5 = fragmentExamRegistrationNewBinding4.feeReceiptBtn) != null) {
            textView5.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding5 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding5 != null && (textView4 = fragmentExamRegistrationNewBinding5.registrationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding6 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding6 != null && (textView3 = fragmentExamRegistrationNewBinding6.resultBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding7 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding7 != null && (textView2 = fragmentExamRegistrationNewBinding7.revaluationBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding8 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding8 != null && (textView = fragmentExamRegistrationNewBinding8.feeReceiptBtn) != null) {
            textView.setTextColor(-1);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding9 = this$0.get_binding();
        RecyclerView recyclerView = fragmentExamRegistrationNewBinding9 != null ? fragmentExamRegistrationNewBinding9.rvRegistration : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding10 = this$0.get_binding();
        RecyclerView recyclerView2 = fragmentExamRegistrationNewBinding10 != null ? fragmentExamRegistrationNewBinding10.rvExamResults : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding11 = this$0.get_binding();
        RecyclerView recyclerView3 = fragmentExamRegistrationNewBinding11 != null ? fragmentExamRegistrationNewBinding11.rvReceipts : null;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(0);
        }
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding12 = this$0.get_binding();
        RecyclerView recyclerView4 = fragmentExamRegistrationNewBinding12 != null ? fragmentExamRegistrationNewBinding12.rvRevaluation : null;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setVisibility(8);
    }

    private final void listenRegistrationResponse() {
        getExamRegistrationMainNewViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegistrationMainNewFragment.listenRegistrationResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenRegistrationResponse$lambda$5(ExamRegistrationMainNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ExamRegisterResponse examRegisterResponse = (ExamRegisterResponse) resource.getData();
            if (examRegisterResponse != null) {
                this$0.showBaseView();
                if (examRegisterResponse.getLogin()) {
                    this$0.getExamSubjectAdapter().addItems(examRegisterResponse.getExam(), "");
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
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding == null || (recyclerView = fragmentExamRegistrationNewBinding.rvRegistration) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenReceiptsResponse() {
        getExamRegistrationMainNewViewModel().getExamReceiptResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegistrationMainNewFragment.listenReceiptsResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenReceiptsResponse$lambda$7(ExamRegistrationMainNewFragment this$0, Resource resource) {
        RecyclerView rvReceipts;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ExamReceiptResponse examReceiptResponse = (ExamReceiptResponse) resource.getData();
            if (examReceiptResponse != null) {
                this$0.showBaseView();
                if (examReceiptResponse.getLogin()) {
                    try {
                        this$0.getAdapterReceipt().addItems(examReceiptResponse.getReceipts());
                        return;
                    } catch (NullPointerException unused) {
                        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
                        if (fragmentExamRegistrationNewBinding == null || (rvReceipts = fragmentExamRegistrationNewBinding.rvReceipts) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(rvReceipts, "rvReceipts");
                        ToastExtKt.showInfoToast(rvReceipts, "No Receipts Available");
                        return;
                    }
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
        FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = this$0.get_binding();
        if (fragmentExamRegistrationNewBinding2 == null || (recyclerView = fragmentExamRegistrationNewBinding2.rvReceipts) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenAbcResponse() {
        getExamRegistrationMainNewViewModel().getAbcResponse().observe(getViewLifecycleOwner(), new ExamRegistrationMainNewFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AbcResponse>, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment.listenAbcResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$listenAbcResponse$1$WhenMappings */
            /* JADX INFO: compiled from: ExamRegistrationMainNewFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AbcResponse> resource) {
                invoke2((Resource<AbcResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AbcResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ExamRegistrationMainNewFragment.this.hideProgress();
                    AbcResponse data = resource.getData();
                    if (data != null) {
                        ExamRegistrationMainNewFragment examRegistrationMainNewFragment = ExamRegistrationMainNewFragment.this;
                        examRegistrationMainNewFragment.showBaseView();
                        String abc_id = data.getAbc_id();
                        if (abc_id == null) {
                            abc_id = "";
                        }
                        examRegistrationMainNewFragment.abcId = abc_id;
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    ExamRegistrationMainNewFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ExamRegistrationMainNewFragment.this.hideProgress();
                    ExamRegistrationMainNewFragment.this.showBaseView();
                } else {
                    if (i != 4) {
                        return;
                    }
                    ExamRegistrationMainNewFragment.this.hideProgress();
                    ExamRegistrationMainNewFragment.this.showBaseView();
                }
            }
        }));
    }

    private final void listenStatusResponse() {
        getExamRegistrationMainNewViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegistrationMainNewFragment.listenStatusResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenStatusResponse$lambda$9(ExamRegistrationMainNewFragment this$0, Resource resource) {
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
            FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
            if (fragmentExamRegistrationNewBinding == null || (recyclerView = fragmentExamRegistrationNewBinding.rvRegistration) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        RevaluationStatusResponse revaluationStatusResponse = (RevaluationStatusResponse) resource.getData();
        if (revaluationStatusResponse != null) {
            this$0.showBaseView();
            if (revaluationStatusResponse.getStatus()) {
                try {
                    MainCallBackListener mainCallBackListener = this$0.listener;
                    if (mainCallBackListener != null) {
                        String str = this$0.id;
                        Intrinsics.checkNotNull(str);
                        mainCallBackListener.viewRevaluationClicked(str);
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    return;
                } catch (NullPointerException unused) {
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
            }
            MainCallBackListener mainCallBackListener2 = this$0.listener;
            if (mainCallBackListener2 != null) {
                String str2 = this$0.id;
                Intrinsics.checkNotNull(str2);
                mainCallBackListener2.revaluationClicked(str2, true);
            }
        }
    }

    private final void listenDueResponse(final String id) {
        getExamRegistrationMainNewViewModel().getDueResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegistrationMainNewFragment.listenDueResponse$lambda$11(this.f$0, id, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDueResponse$lambda$11(ExamRegistrationMainNewFragment this$0, String id, Resource resource) {
        RecyclerView rvRegistration;
        RecyclerView rvRegistration2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
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
            FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
            if (fragmentExamRegistrationNewBinding == null || (recyclerView = fragmentExamRegistrationNewBinding.rvRegistration) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamCourseResponse examCourseResponse = (ExamCourseResponse) resource.getData();
        if (examCourseResponse != null) {
            this$0.showBaseView();
            if (examCourseResponse.getLogin()) {
                if (Intrinsics.areEqual(examCourseResponse.getError(), "You have a pending due. Please clear it to proceed with registering for this exam.")) {
                    FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = this$0.get_binding();
                    if (fragmentExamRegistrationNewBinding2 == null || (rvRegistration2 = fragmentExamRegistrationNewBinding2.rvRegistration) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvRegistration2, "rvRegistration");
                    ToastExtKt.showErrorToast(rvRegistration2, examCourseResponse.getError());
                    return;
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.showExamRegFragment(id);
                    return;
                }
                return;
            }
            FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = this$0.get_binding();
            if (fragmentExamRegistrationNewBinding3 == null || (rvRegistration = fragmentExamRegistrationNewBinding3.rvRegistration) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvRegistration, "rvRegistration");
            ToastExtKt.showErrorToast(rvRegistration, "netwok error");
        }
    }

    private final void listenErrorResponse(final String id) {
        getExamRegistrationMainNewViewModel().getDueResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegistrationMainNewFragment.listenErrorResponse$lambda$13(this.f$0, id, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenErrorResponse$lambda$13(ExamRegistrationMainNewFragment this$0, String id, Resource resource) {
        RecyclerView rvRegistration;
        RecyclerView rvRegistration2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
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
            FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding = this$0.get_binding();
            if (fragmentExamRegistrationNewBinding == null || (recyclerView = fragmentExamRegistrationNewBinding.rvRegistration) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamCourseResponse examCourseResponse = (ExamCourseResponse) resource.getData();
        if (examCourseResponse != null) {
            this$0.showBaseView();
            if (examCourseResponse.getLogin()) {
                if (!Intrinsics.areEqual(examCourseResponse.getError(), "")) {
                    FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding2 = this$0.get_binding();
                    if (fragmentExamRegistrationNewBinding2 == null || (rvRegistration2 = fragmentExamRegistrationNewBinding2.rvRegistration) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvRegistration2, "rvRegistration");
                    ToastExtKt.showErrorToast(rvRegistration2, examCourseResponse.getError());
                    return;
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.showExamRegFragment(id);
                    return;
                }
                return;
            }
            FragmentExamRegistrationNewBinding fragmentExamRegistrationNewBinding3 = this$0.get_binding();
            if (fragmentExamRegistrationNewBinding3 == null || (rvRegistration = fragmentExamRegistrationNewBinding3.rvRegistration) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvRegistration, "rvRegistration");
            ToastExtKt.showErrorToast(rvRegistration, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack
    public void viewRegisterBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.areEqual(this.abcId, "");
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sbce", false, 2, (Object) null)) {
            getExamRegistrationMainNewViewModel().getExamDetails(id);
            listenDueResponse(id);
        } else {
            getExamRegistrationMainNewViewModel().getExamDetails(id);
            listenErrorResponse(id);
        }
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack
    public void viewResultBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showExamResultFragment(id);
        }
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack
    public void viewRevaatuation(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        listenStatusResponse();
        getExamRegistrationMainNewViewModel().getExamStatusData(id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // in.etuwa.app.ui.examregistration.revaluation.RevaluationAdapter.CallBack
    public void updateSelected(List<String> revaluationSel, List<String> answerSheetSel) {
        Intrinsics.checkNotNullParameter(revaluationSel, "revaluationSel");
        Intrinsics.checkNotNullParameter(answerSheetSel, "answerSheetSel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}