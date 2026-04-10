package in.etuwa.app.ui.result.assignment;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.result.ResultAssignment;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.AssignmentResultFragmentBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: AssignmentResultFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class AssignmentResultFragment extends BaseFragment implements SemListDialogTwo.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AssignmentResultFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: assignmentResultViewModel$delegate, reason: from kotlin metadata */
    private final Lazy assignmentResultViewModel;
    private boolean flag;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: compiled from: AssignmentResultFragment.kt */
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
    public static final AssignmentResultFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public AssignmentResultFragment() {
        final AssignmentResultFragment assignmentResultFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return assignmentResultFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(assignmentResultFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.assignmentResultViewModel = FragmentViewModelLazyKt.createViewModelLazy(assignmentResultFragment, Reflection.getOrCreateKotlinClass(AssignmentResultViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AssignmentResultViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AssignmentResultFragment assignmentResultFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AssignmentResultAdapter>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.assignment.AssignmentResultAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AssignmentResultAdapter invoke() {
                ComponentCallbacks componentCallbacks = assignmentResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AssignmentResultAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = assignmentResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = assignmentResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssignmentResultViewModel getAssignmentResultViewModel() {
        return (AssignmentResultViewModel) this.assignmentResultViewModel.getValue();
    }

    private final AssignmentResultAdapter getAdapter() {
        return (AssignmentResultAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final AssignmentResultFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: AssignmentResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/result/assignment/AssignmentResultFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/assignment/AssignmentResultFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssignmentResultFragment newInstance() {
            return new AssignmentResultFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AssignmentResultFragmentBinding.inflate(inflater, container, false);
        AssignmentResultFragmentBinding assignmentResultFragmentBinding = get_binding();
        if (assignmentResultFragmentBinding != null) {
            assignmentResultFragmentBinding.setAssignmentResultViewModel(getAssignmentResultViewModel());
        }
        AssignmentResultFragmentBinding assignmentResultFragmentBinding2 = get_binding();
        if (assignmentResultFragmentBinding2 != null) {
            assignmentResultFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AssignmentResultFragmentBinding assignmentResultFragmentBinding3 = get_binding();
        if (assignmentResultFragmentBinding3 != null) {
            return assignmentResultFragmentBinding3.getRoot();
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
        FloatingActionButton floatingActionButton;
        hideBaseView();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.result));
        }
        AssignmentResultFragmentBinding assignmentResultFragmentBinding = get_binding();
        TextView textView = assignmentResultFragmentBinding != null ? assignmentResultFragmentBinding.semesterText : null;
        if (textView != null) {
            textView.setText(getPreference().getUserSem());
        }
        AssignmentResultFragmentBinding assignmentResultFragmentBinding2 = get_binding();
        MaterialCardView materialCardView = assignmentResultFragmentBinding2 != null ? assignmentResultFragmentBinding2.assignmentResultLayout : null;
        if (materialCardView != null) {
            materialCardView.setVisibility(8);
        }
        AssignmentResultFragmentBinding assignmentResultFragmentBinding3 = get_binding();
        RecyclerView recyclerView = assignmentResultFragmentBinding3 != null ? assignmentResultFragmentBinding3.rvResultAssignment : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        AssignmentResultFragmentBinding assignmentResultFragmentBinding4 = get_binding();
        Spinner spinner = assignmentResultFragmentBinding4 != null ? assignmentResultFragmentBinding4.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getAssignmentResultViewModel().getResult(getPreference().getUserSemId());
        listenSemResponse();
        listenResponse();
        AssignmentResultFragmentBinding assignmentResultFragmentBinding5 = get_binding();
        if (assignmentResultFragmentBinding5 != null && (floatingActionButton = assignmentResultFragmentBinding5.fabAssignmentResultSemester) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentResultFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        AssignmentResultFragmentBinding assignmentResultFragmentBinding6 = get_binding();
        Spinner spinner2 = assignmentResultFragmentBinding6 != null ? assignmentResultFragmentBinding6.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TextView textView2;
                    Spinner spinner3;
                    Semester semester = AssignmentResultFragment.this.getSpinnerAdapter().getSemester(position);
                    if (AssignmentResultFragment.this.flag) {
                        AssignmentResultFragment.this.getAssignmentResultViewModel().getResult(semester.getId());
                        AssignmentResultFragmentBinding assignmentResultFragmentBinding7 = AssignmentResultFragment.this.get_binding();
                        textView2 = assignmentResultFragmentBinding7 != null ? assignmentResultFragmentBinding7.semesterText : null;
                        if (textView2 == null) {
                            return;
                        }
                        textView2.setText(semester.getName());
                        return;
                    }
                    AssignmentResultFragment.this.flag = true;
                    int count = AssignmentResultFragment.this.getSpinnerAdapter().getCount();
                    for (int i = 0; i < count; i++) {
                        if (Intrinsics.areEqual(AssignmentResultFragment.this.getPreference().getUserSemId(), AssignmentResultFragment.this.getSpinnerAdapter().getSemester(i).getId())) {
                            AssignmentResultFragmentBinding assignmentResultFragmentBinding8 = AssignmentResultFragment.this.get_binding();
                            if (assignmentResultFragmentBinding8 != null && (spinner3 = assignmentResultFragmentBinding8.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            AssignmentResultFragmentBinding assignmentResultFragmentBinding9 = AssignmentResultFragment.this.get_binding();
                            textView2 = assignmentResultFragmentBinding9 != null ? assignmentResultFragmentBinding9.semesterText : null;
                            if (textView2 != null) {
                                textView2.setText(AssignmentResultFragment.this.getSpinnerAdapter().getSemester(i).getName());
                            }
                            if (position == 0) {
                                AssignmentResultFragment.this.getAssignmentResultViewModel().getResult(AssignmentResultFragment.this.getPreference().getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        AssignmentResultViewModel assignmentResultViewModel = getAssignmentResultViewModel();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        assignmentResultViewModel.getSemester(contextRequireContext);
        AssignmentResultFragmentBinding assignmentResultFragmentBinding7 = get_binding();
        if (assignmentResultFragmentBinding7 == null || (swipeRefreshLayout = assignmentResultFragmentBinding7.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$$ExternalSyntheticLambda3
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                AssignmentResultFragment.setUp$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(AssignmentResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo semListDialogTwoNewInstance = SemListDialogTwo.INSTANCE.newInstance();
        semListDialogTwoNewInstance.setCallBack(this$0);
        semListDialogTwoNewInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AssignmentResultFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AssignmentResultViewModel assignmentResultViewModel = this$0.getAssignmentResultViewModel();
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        assignmentResultViewModel.getSemester(contextRequireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        menu.clear();
        inflater.inflate(R.menu.action_filter, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final void listenSemResponse() {
        getAssignmentResultViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AssignmentResultFragment.listenSemResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(AssignmentResultFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (i != 1) {
            if (i == 2) {
                AssignmentResultFragmentBinding assignmentResultFragmentBinding = this$0.get_binding();
                if (assignmentResultFragmentBinding != null && (swipeRefreshLayout2 = assignmentResultFragmentBinding.swipeLayout) != null) {
                    boolValueOf = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    return;
                }
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
            AssignmentResultFragmentBinding assignmentResultFragmentBinding2 = this$0.get_binding();
            if (assignmentResultFragmentBinding2 == null || (recyclerView = assignmentResultFragmentBinding2.rvResultAssignment) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            AssignmentResultFragmentBinding assignmentResultFragmentBinding3 = this$0.get_binding();
            Boolean boolValueOf2 = (assignmentResultFragmentBinding3 == null || (swipeRefreshLayout = assignmentResultFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue()) {
                AssignmentResultFragmentBinding assignmentResultFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = assignmentResultFragmentBinding4 != null ? assignmentResultFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        AssignmentResultFragmentBinding assignmentResultFragmentBinding5 = this$0.get_binding();
                        if (assignmentResultFragmentBinding5 != null && (spinner = assignmentResultFragmentBinding5.spinnerSem) != null) {
                            spinner.setSelection(i2);
                        }
                        AssignmentResultFragmentBinding assignmentResultFragmentBinding6 = this$0.get_binding();
                        TextView textView = assignmentResultFragmentBinding6 != null ? assignmentResultFragmentBinding6.semesterText : null;
                        if (textView == null) {
                            return;
                        }
                        textView.setText(this$0.getSpinnerAdapter().getSemester(i2).getName());
                        return;
                    }
                }
            }
        }
    }

    private final void listenResponse() {
        getAssignmentResultViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AssignmentResultFragment.listenResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(AssignmentResultFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<ResultAssignment> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(arrayList);
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
        AssignmentResultFragmentBinding assignmentResultFragmentBinding = this$0.get_binding();
        if (assignmentResultFragmentBinding == null || (recyclerView = assignmentResultFragmentBinding.rvResultAssignment) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        AssignmentResultFragmentBinding assignmentResultFragmentBinding = get_binding();
        if (assignmentResultFragmentBinding == null || (recyclerView = assignmentResultFragmentBinding.rvResultAssignment) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        AssignmentResultFragmentBinding assignmentResultFragmentBinding = get_binding();
        if (assignmentResultFragmentBinding == null || (recyclerView = assignmentResultFragmentBinding.rvResultAssignment) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    public final void onSemesterSelected(String id, String semName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        getAssignmentResultViewModel().getResult(id);
        AssignmentResultFragmentBinding assignmentResultFragmentBinding = get_binding();
        TextView textView = assignmentResultFragmentBinding != null ? assignmentResultFragmentBinding.semesterText : null;
        if (textView == null) {
            return;
        }
        textView.setText(semName);
    }

    @Override // in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo.SemDialogCallBack
    public void loadSelectedSem(String id, String sem) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sem, "sem");
        getAssignmentResultViewModel().getResult(id);
        AssignmentResultFragmentBinding assignmentResultFragmentBinding = get_binding();
        TextView textView = assignmentResultFragmentBinding != null ? assignmentResultFragmentBinding.semesterText : null;
        if (textView == null) {
            return;
        }
        textView.setText(sem);
    }
}