package in.etuwa.app.ui.result.tutorials;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.result.tutorial.TutorialResultResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.ResultTutorialFragmentBinding;
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

/* JADX INFO: compiled from: TutorialResultFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TutorialResultFragment extends BaseFragment implements SemListDialogTwo.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ResultTutorialFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: tutorialResultViewModel$delegate, reason: from kotlin metadata */
    private final Lazy tutorialResultViewModel;

    /* JADX INFO: compiled from: TutorialResultFragment.kt */
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
    public static final TutorialResultFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TutorialResultFragment() {
        final TutorialResultFragment tutorialResultFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return tutorialResultFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(tutorialResultFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.tutorialResultViewModel = FragmentViewModelLazyKt.createViewModelLazy(tutorialResultFragment, Reflection.getOrCreateKotlinClass(TutorialResultViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(TutorialResultViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TutorialResultFragment tutorialResultFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TutorialResultAdapter>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.tutorials.TutorialResultAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TutorialResultAdapter invoke() {
                ComponentCallbacks componentCallbacks = tutorialResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TutorialResultAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$spinnerAdapter$2
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
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = tutorialResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = tutorialResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TutorialResultViewModel getTutorialResultViewModel() {
        return (TutorialResultViewModel) this.tutorialResultViewModel.getValue();
    }

    private final TutorialResultAdapter getAdapter() {
        return (TutorialResultAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final ResultTutorialFragmentBinding get_binding() {
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

    /* JADX INFO: compiled from: TutorialResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/result/tutorials/TutorialResultFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/tutorials/TutorialResultFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TutorialResultFragment newInstance() {
            return new TutorialResultFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ResultTutorialFragmentBinding.inflate(inflater, container, false);
        ResultTutorialFragmentBinding resultTutorialFragmentBinding = get_binding();
        if (resultTutorialFragmentBinding != null) {
            resultTutorialFragmentBinding.setTutorialResultViewModel(getTutorialResultViewModel());
        }
        ResultTutorialFragmentBinding resultTutorialFragmentBinding2 = get_binding();
        if (resultTutorialFragmentBinding2 != null) {
            resultTutorialFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ResultTutorialFragmentBinding resultTutorialFragmentBinding3 = get_binding();
        if (resultTutorialFragmentBinding3 != null) {
            return resultTutorialFragmentBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Result");
        }
        hideBaseView();
        ResultTutorialFragmentBinding resultTutorialFragmentBinding = get_binding();
        RecyclerView recyclerView = resultTutorialFragmentBinding != null ? resultTutorialFragmentBinding.rvTutorial : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        ResultTutorialFragmentBinding resultTutorialFragmentBinding2 = get_binding();
        Spinner spinner = resultTutorialFragmentBinding2 != null ? resultTutorialFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getTutorialResultViewModel().getTutorial(getPreference().getUserSemId());
        listenSemResponse();
        listenResponse();
        TutorialResultViewModel tutorialResultViewModel = getTutorialResultViewModel();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        tutorialResultViewModel.getSemester(contextRequireContext);
        ResultTutorialFragmentBinding resultTutorialFragmentBinding3 = get_binding();
        TextView textView = resultTutorialFragmentBinding3 != null ? resultTutorialFragmentBinding3.tutorialSemTv : null;
        if (textView != null) {
            textView.setText(getPreference().getUserSem());
        }
        ResultTutorialFragmentBinding resultTutorialFragmentBinding4 = get_binding();
        if (resultTutorialFragmentBinding4 != null && (floatingActionButton = resultTutorialFragmentBinding4.fabTutorialResultSemester) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TutorialResultFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        ResultTutorialFragmentBinding resultTutorialFragmentBinding5 = get_binding();
        Spinner spinner2 = resultTutorialFragmentBinding5 != null ? resultTutorialFragmentBinding5.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Spinner spinner3;
                    Semester semester = TutorialResultFragment.this.getSpinnerAdapter().getSemester(position);
                    if (TutorialResultFragment.this.flag) {
                        TutorialResultFragment.this.getTutorialResultViewModel().getTutorial(semester.getId());
                        return;
                    }
                    TutorialResultFragment.this.flag = true;
                    int count = TutorialResultFragment.this.getSpinnerAdapter().getCount();
                    for (int i = 0; i < count; i++) {
                        if (Intrinsics.areEqual(TutorialResultFragment.this.getPreference().getUserSemId(), TutorialResultFragment.this.getSpinnerAdapter().getSemester(i).getId())) {
                            ResultTutorialFragmentBinding resultTutorialFragmentBinding6 = TutorialResultFragment.this.get_binding();
                            if (resultTutorialFragmentBinding6 != null && (spinner3 = resultTutorialFragmentBinding6.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                TutorialResultFragment.this.getTutorialResultViewModel().getTutorial(TutorialResultFragment.this.getPreference().getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        ResultTutorialFragmentBinding resultTutorialFragmentBinding6 = get_binding();
        if (resultTutorialFragmentBinding6 == null || (swipeRefreshLayout = resultTutorialFragmentBinding6.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                TutorialResultFragment.setUp$lambda$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TutorialResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo semListDialogTwoNewInstance = SemListDialogTwo.INSTANCE.newInstance();
        semListDialogTwoNewInstance.setCallBack(this$0);
        semListDialogTwoNewInstance.show(childFragmentManager, (String) null);
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
        getTutorialResultViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TutorialResultFragment.listenSemResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(TutorialResultFragment this$0, Resource resource) {
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
                ResultTutorialFragmentBinding resultTutorialFragmentBinding = this$0.get_binding();
                if (resultTutorialFragmentBinding != null && (swipeRefreshLayout2 = resultTutorialFragmentBinding.swipeLayout) != null) {
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
            ResultTutorialFragmentBinding resultTutorialFragmentBinding2 = this$0.get_binding();
            if (resultTutorialFragmentBinding2 == null || (recyclerView = resultTutorialFragmentBinding2.rvTutorial) == null) {
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
            ResultTutorialFragmentBinding resultTutorialFragmentBinding3 = this$0.get_binding();
            Boolean boolValueOf2 = (resultTutorialFragmentBinding3 == null || (swipeRefreshLayout = resultTutorialFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue()) {
                ResultTutorialFragmentBinding resultTutorialFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = resultTutorialFragmentBinding4 != null ? resultTutorialFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        ResultTutorialFragmentBinding resultTutorialFragmentBinding5 = this$0.get_binding();
                        if (resultTutorialFragmentBinding5 == null || (spinner = resultTutorialFragmentBinding5.spinnerSem) == null) {
                            return;
                        }
                        spinner.setSelection(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void listenResponse() {
        getTutorialResultViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TutorialResultFragment.listenResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(TutorialResultFragment this$0, Resource resource) {
        RecyclerView rvTutorial;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TutorialResultResponse tutorialResultResponse = (TutorialResultResponse) resource.getData();
            if (tutorialResultResponse != null) {
                this$0.showBaseView();
                if (tutorialResultResponse.getLogin()) {
                    this$0.getAdapter().addItems(tutorialResultResponse.getTutorials());
                    return;
                }
                ResultTutorialFragmentBinding resultTutorialFragmentBinding = this$0.get_binding();
                if (resultTutorialFragmentBinding == null || (rvTutorial = resultTutorialFragmentBinding.rvTutorial) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvTutorial, "rvTutorial");
                ToastExtKt.showErrorToast(rvTutorial, tutorialResultResponse.getError());
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
        ResultTutorialFragmentBinding resultTutorialFragmentBinding2 = this$0.get_binding();
        if (resultTutorialFragmentBinding2 == null || (recyclerView = resultTutorialFragmentBinding2.rvTutorial) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        ResultTutorialFragmentBinding resultTutorialFragmentBinding = get_binding();
        if (resultTutorialFragmentBinding == null || (recyclerView = resultTutorialFragmentBinding.rvTutorial) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        ResultTutorialFragmentBinding resultTutorialFragmentBinding = get_binding();
        if (resultTutorialFragmentBinding == null || (recyclerView = resultTutorialFragmentBinding.rvTutorial) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo.SemDialogCallBack
    public void loadSelectedSem(String id, String sem) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sem, "sem");
        getTutorialResultViewModel().getTutorial(id);
        ResultTutorialFragmentBinding resultTutorialFragmentBinding = get_binding();
        TextView textView = resultTutorialFragmentBinding != null ? resultTutorialFragmentBinding.tutorialSemTv : null;
        if (textView == null) {
            return;
        }
        textView.setText(sem);
    }

    public final void onSemesterSelected(String id, String semName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        getTutorialResultViewModel().getTutorial(id);
        ResultTutorialFragmentBinding resultTutorialFragmentBinding = get_binding();
        TextView textView = resultTutorialFragmentBinding != null ? resultTutorialFragmentBinding.tutorialSemTv : null;
        if (textView == null) {
            return;
        }
        textView.setText(semName);
    }
}