package in.etuwa.app.ui.result.moduletest;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
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
import in.etuwa.app.data.model.result.moduletest.ResultModuleTestResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.ResultModuleTestFragmentBinding;
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

/* compiled from: ResultModuleTestFragment.kt */
/* loaded from: classes5.dex */
public final class ResultModuleTestFragment extends BaseFragment implements SemListDialogTwo.SemDialogCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ResultModuleTestFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: resultModuleTestViewModel$delegate, reason: from kotlin metadata */
    private final Lazy resultModuleTestViewModel;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: ResultModuleTestFragment.kt */
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
    public static final ResultModuleTestFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ResultModuleTestFragment() {
        final ResultModuleTestFragment resultModuleTestFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(resultModuleTestFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.resultModuleTestViewModel = FragmentViewModelLazyKt.createViewModelLazy(resultModuleTestFragment, Reflection.getOrCreateKotlinClass(ResultModuleTestViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ResultModuleTestViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ResultModuleTestFragment resultModuleTestFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ResultModuleTestAdapter>() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.moduletest.ResultModuleTestAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ResultModuleTestAdapter invoke() {
                ComponentCallbacks componentCallbacks = resultModuleTestFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ResultModuleTestAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ResultModuleTestFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = resultModuleTestFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = resultModuleTestFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResultModuleTestViewModel getResultModuleTestViewModel() {
        return (ResultModuleTestViewModel) this.resultModuleTestViewModel.getValue();
    }

    private final ResultModuleTestAdapter getAdapter() {
        return (ResultModuleTestAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final ResultModuleTestFragmentBinding get_binding() {
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

    /* compiled from: ResultModuleTestFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/result/moduletest/ResultModuleTestFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/moduletest/ResultModuleTestFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ResultModuleTestFragment newInstance() {
            return new ResultModuleTestFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ResultModuleTestFragmentBinding.inflate(inflater, container, false);
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding = get_binding();
        if (resultModuleTestFragmentBinding != null) {
            resultModuleTestFragmentBinding.setResultModuleTestViewModel(getResultModuleTestViewModel());
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding2 = get_binding();
        if (resultModuleTestFragmentBinding2 != null) {
            resultModuleTestFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding3 = get_binding();
        if (resultModuleTestFragmentBinding3 != null) {
            return resultModuleTestFragmentBinding3.getRoot();
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
            activity.setTitle("Result");
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding = get_binding();
        LinearLayout linearLayout = resultModuleTestFragmentBinding != null ? resultModuleTestFragmentBinding.moduleLayout : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding2 = get_binding();
        RecyclerView recyclerView = resultModuleTestFragmentBinding2 != null ? resultModuleTestFragmentBinding2.rvResultModuleTest : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding3 = get_binding();
        Spinner spinner = resultModuleTestFragmentBinding3 != null ? resultModuleTestFragmentBinding3.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getResultModuleTestViewModel().getResult(getPreference().getUserSemId());
        listenSemResponse();
        listenResponse();
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding4 = get_binding();
        TextView textView = resultModuleTestFragmentBinding4 != null ? resultModuleTestFragmentBinding4.moduleSemTv : null;
        if (textView != null) {
            textView.setText(getPreference().getUserSem());
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding5 = get_binding();
        if (resultModuleTestFragmentBinding5 != null && (floatingActionButton = resultModuleTestFragmentBinding5.fabModuleResultSemester) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultModuleTestFragment.setUp$lambda$0(ResultModuleTestFragment.this, view);
                }
            });
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding6 = get_binding();
        Spinner spinner2 = resultModuleTestFragmentBinding6 != null ? resultModuleTestFragmentBinding6.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter;
                    boolean z;
                    SemesterSpinnerAdapter spinnerAdapter2;
                    SharedPrefManager preference;
                    SemesterSpinnerAdapter spinnerAdapter3;
                    ResultModuleTestFragmentBinding resultModuleTestFragmentBinding7;
                    ResultModuleTestViewModel resultModuleTestViewModel;
                    SharedPrefManager preference2;
                    Spinner spinner3;
                    ResultModuleTestViewModel resultModuleTestViewModel2;
                    spinnerAdapter = ResultModuleTestFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    z = ResultModuleTestFragment.this.flag;
                    if (z) {
                        resultModuleTestViewModel2 = ResultModuleTestFragment.this.getResultModuleTestViewModel();
                        resultModuleTestViewModel2.getResult(semester.getId());
                        return;
                    }
                    ResultModuleTestFragment.this.flag = true;
                    spinnerAdapter2 = ResultModuleTestFragment.this.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = ResultModuleTestFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = ResultModuleTestFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i).getId())) {
                            resultModuleTestFragmentBinding7 = ResultModuleTestFragment.this.get_binding();
                            if (resultModuleTestFragmentBinding7 != null && (spinner3 = resultModuleTestFragmentBinding7.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                resultModuleTestViewModel = ResultModuleTestFragment.this.getResultModuleTestViewModel();
                                preference2 = ResultModuleTestFragment.this.getPreference();
                                resultModuleTestViewModel.getResult(preference2.getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding7 = get_binding();
        if (resultModuleTestFragmentBinding7 == null || (swipeRefreshLayout = resultModuleTestFragmentBinding7.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ResultModuleTestFragment.setUp$lambda$1(ResultModuleTestFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ResultModuleTestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo newInstance = SemListDialogTwo.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ResultModuleTestFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getResultModuleTestViewModel().getSemester();
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
        getResultModuleTestViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultModuleTestFragment.listenSemResponse$lambda$3(ResultModuleTestFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(ResultModuleTestFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        r2 = null;
        Boolean bool = null;
        if (i != 1) {
            if (i == 2) {
                ResultModuleTestFragmentBinding resultModuleTestFragmentBinding = this$0.get_binding();
                if (resultModuleTestFragmentBinding != null && (swipeRefreshLayout2 = resultModuleTestFragmentBinding.swipeLayout) != null) {
                    bool = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
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
            ResultModuleTestFragmentBinding resultModuleTestFragmentBinding2 = this$0.get_binding();
            if (resultModuleTestFragmentBinding2 == null || (recyclerView = resultModuleTestFragmentBinding2.rvResultModuleTest) == null) {
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
            ResultModuleTestFragmentBinding resultModuleTestFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (resultModuleTestFragmentBinding3 == null || (swipeRefreshLayout = resultModuleTestFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                ResultModuleTestFragmentBinding resultModuleTestFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = resultModuleTestFragmentBinding4 != null ? resultModuleTestFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding5 = this$0.get_binding();
                        if (resultModuleTestFragmentBinding5 == null || (spinner = resultModuleTestFragmentBinding5.spinnerSem) == null) {
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
        getResultModuleTestViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultModuleTestFragment.listenResponse$lambda$5(ResultModuleTestFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(ResultModuleTestFragment this$0, Resource resource) {
        RecyclerView rvResultModuleTest;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ResultModuleTestResponse resultModuleTestResponse = (ResultModuleTestResponse) resource.getData();
            if (resultModuleTestResponse != null) {
                this$0.showBaseView();
                if (resultModuleTestResponse.getModuleTest() != null) {
                    this$0.getAdapter().addItems(resultModuleTestResponse.getModuleTest());
                    return;
                }
                ResultModuleTestFragmentBinding resultModuleTestFragmentBinding = this$0.get_binding();
                if (resultModuleTestFragmentBinding == null || (rvResultModuleTest = resultModuleTestFragmentBinding.rvResultModuleTest) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvResultModuleTest, "rvResultModuleTest");
                ToastExtKt.showErrorToast(rvResultModuleTest, "No result to show...");
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
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding2 = this$0.get_binding();
        if (resultModuleTestFragmentBinding2 == null || (recyclerView = resultModuleTestFragmentBinding2.rvResultModuleTest) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding = get_binding();
        if (resultModuleTestFragmentBinding == null || (recyclerView = resultModuleTestFragmentBinding.rvResultModuleTest) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding = get_binding();
        if (resultModuleTestFragmentBinding == null || (recyclerView = resultModuleTestFragmentBinding.rvResultModuleTest) == null) {
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
        getResultModuleTestViewModel().getResult(id);
        ResultModuleTestFragmentBinding resultModuleTestFragmentBinding = get_binding();
        TextView textView = resultModuleTestFragmentBinding != null ? resultModuleTestFragmentBinding.moduleSemTv : null;
        if (textView == null) {
            return;
        }
        textView.setText(sem);
    }
}