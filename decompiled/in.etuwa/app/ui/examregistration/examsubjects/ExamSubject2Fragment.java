package in.etuwa.app.ui.examregistration.examsubjects;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.examregister.ExamRegister;
import in.etuwa.app.data.model.examregister.ExamRegisterResponse;
import in.etuwa.app.data.model.examregister.RevaluationStatusResponse;
import in.etuwa.app.databinding.FragmentExamSubjectBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: ExamSubject2Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExamSubject2Fragment extends BaseFragment implements ExamSubjectAdapter.CallBack, ExamSubjectDetailDialog.ExamDetailListner, ExamSubjectAdapter2.CallBack, ExamSubjectAdapter3.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamSubjectBinding _binding;

    /* JADX INFO: renamed from: adapter2$delegate, reason: from kotlin metadata */
    private final Lazy adapter2;

    /* JADX INFO: renamed from: examSubjectViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examSubjectViewModel;
    private String flag;
    private String id;
    private MainCallBackListener listener;

    /* JADX INFO: compiled from: ExamSubject2Fragment.kt */
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
    public static final ExamSubject2Fragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack
    public void viewBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public ExamSubject2Fragment() {
        final ExamSubject2Fragment examSubject2Fragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubject2Fragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return examSubject2Fragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examSubject2Fragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examSubjectViewModel = FragmentViewModelLazyKt.createViewModelLazy(examSubject2Fragment, Reflection.getOrCreateKotlinClass(ExamSubjectViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubject2Fragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubject2Fragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ExamSubjectViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamSubject2Fragment examSubject2Fragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter2 = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ExamSubjectAdapter2>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubject2Fragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamSubjectAdapter2 invoke() {
                ComponentCallbacks componentCallbacks = examSubject2Fragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamSubjectAdapter2.class), b2, b3);
            }
        });
    }

    private final ExamSubjectViewModel getExamSubjectViewModel() {
        return (ExamSubjectViewModel) this.examSubjectViewModel.getValue();
    }

    private final ExamSubjectAdapter2 getAdapter2() {
        return (ExamSubjectAdapter2) this.adapter2.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentExamSubjectBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: ExamSubject2Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubject2Fragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubject2Fragment;", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamSubject2Fragment newInstance(String flag) {
            Intrinsics.checkNotNullParameter(flag, "flag");
            ExamSubject2Fragment examSubject2Fragment = new ExamSubject2Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", flag);
            examSubject2Fragment.setArguments(bundle);
            return examSubject2Fragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.flag = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentExamSubjectBinding.inflate(inflater, container, false);
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        if (fragmentExamSubjectBinding != null) {
            fragmentExamSubjectBinding.setExamSubjectViewModel(getExamSubjectViewModel());
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding2 = get_binding();
        if (fragmentExamSubjectBinding2 != null) {
            fragmentExamSubjectBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding3 = get_binding();
        if (fragmentExamSubjectBinding3 != null) {
            return fragmentExamSubjectBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("University Exams");
        }
        hideBaseView();
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        RecyclerView recyclerView = fragmentExamSubjectBinding != null ? fragmentExamSubjectBinding.rvExamSubject : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter2());
        }
        getAdapter2().setCallBack(this);
        listenResponse();
        getExamSubjectViewModel().getExamData();
        FragmentExamSubjectBinding fragmentExamSubjectBinding2 = get_binding();
        if (fragmentExamSubjectBinding2 == null || (swipeRefreshLayout = fragmentExamSubjectBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubject2Fragment$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ExamSubject2Fragment.setUp$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ExamSubject2Fragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getExamSubjectViewModel().getExamData();
        FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentExamSubjectBinding != null ? fragmentExamSubjectBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getExamSubjectViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubject2Fragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamSubject2Fragment.listenResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(ExamSubject2Fragment this$0, Resource resource) {
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
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
            FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
            if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamRegisterResponse examRegisterResponse = (ExamRegisterResponse) resource.getData();
        if (examRegisterResponse != null) {
            this$0.showBaseView();
            if (examRegisterResponse.getLogin()) {
                try {
                    ExamSubjectAdapter2 adapter2 = this$0.getAdapter2();
                    ArrayList<ExamRegister> exam = examRegisterResponse.getExam();
                    String str = this$0.flag;
                    Intrinsics.checkNotNull(str);
                    adapter2.addItems(exam, str);
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (NullPointerException unused) {
                    FragmentExamSubjectBinding fragmentExamSubjectBinding2 = this$0.get_binding();
                    if (fragmentExamSubjectBinding2 == null || (rvExamSubject = fragmentExamSubjectBinding2.rvExamSubject) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
                    ToastExtKt.showErrorToast(rvExamSubject, "No Data Found");
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
            }
            FragmentExamSubjectBinding fragmentExamSubjectBinding3 = this$0.get_binding();
            if (fragmentExamSubjectBinding3 == null || (rvExamSubject2 = fragmentExamSubjectBinding3.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject2, "netwok error");
        }
    }

    private final void listenStatusResponse() {
        getExamSubjectViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubject2Fragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamSubject2Fragment.listenStatusResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenStatusResponse$lambda$5(ExamSubject2Fragment this$0, Resource resource) {
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
            FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
            if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
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

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
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
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack
    public void viewRegisterBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showExamRegFragment(id);
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
        getExamSubjectViewModel().getExamStatusData(id);
    }
}