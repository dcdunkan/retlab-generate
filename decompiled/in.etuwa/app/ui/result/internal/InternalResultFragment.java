package in.etuwa.app.ui.result.internal;

import android.content.ComponentCallbacks;
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
import in.etuwa.app.data.model.result.ResultInternal;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.InternalResultFragmentBinding;
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

/* compiled from: InternalResultFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\u0018\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0016J\u0018\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020!H\u0016J\u001a\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020/2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00108\u001a\u00020!H\u0014J\b\u00109\u001a\u00020!H\u0014J\b\u0010:\u001a\u00020!H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001e¨\u0006<"}, d2 = {"Lin/etuwa/app/ui/result/internal/InternalResultFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo$SemDialogCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/InternalResultFragmentBinding;", "adapter", "Lin/etuwa/app/ui/result/internal/InternalResultAdapter;", "getAdapter", "()Lin/etuwa/app/ui/result/internal/InternalResultAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/InternalResultFragmentBinding;", "flag", "", "internalResultViewModel", "Lin/etuwa/app/ui/result/internal/InternalResultViewModel;", "getInternalResultViewModel", "()Lin/etuwa/app/ui/result/internal/InternalResultViewModel;", "internalResultViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "listenSemResponse", "loadSelectedSem", "id", "", "sem", "onCreateOptionsMenu", CommonCssConstants.MENU, "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InternalResultFragment extends BaseFragment implements SemListDialogTwo.SemDialogCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private InternalResultFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;

    /* renamed from: internalResultViewModel$delegate, reason: from kotlin metadata */
    private final Lazy internalResultViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: InternalResultFragment.kt */
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
    public static final InternalResultFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public InternalResultFragment() {
        final InternalResultFragment internalResultFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(internalResultFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.internalResultViewModel = FragmentViewModelLazyKt.createViewModelLazy(internalResultFragment, Reflection.getOrCreateKotlinClass(InternalResultViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(InternalResultViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final InternalResultFragment internalResultFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<InternalResultAdapter>() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.internal.InternalResultAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InternalResultAdapter invoke() {
                ComponentCallbacks componentCallbacks = internalResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(InternalResultAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(InternalResultFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = internalResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = internalResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InternalResultViewModel getInternalResultViewModel() {
        return (InternalResultViewModel) this.internalResultViewModel.getValue();
    }

    private final InternalResultAdapter getAdapter() {
        return (InternalResultAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final InternalResultFragmentBinding get_binding() {
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

    /* compiled from: InternalResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/result/internal/InternalResultFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/internal/InternalResultFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InternalResultFragment newInstance() {
            return new InternalResultFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = InternalResultFragmentBinding.inflate(inflater, container, false);
        InternalResultFragmentBinding internalResultFragmentBinding = get_binding();
        if (internalResultFragmentBinding != null) {
            internalResultFragmentBinding.setInternalResultViewModel(getInternalResultViewModel());
        }
        InternalResultFragmentBinding internalResultFragmentBinding2 = get_binding();
        if (internalResultFragmentBinding2 != null) {
            internalResultFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        InternalResultFragmentBinding internalResultFragmentBinding3 = get_binding();
        if (internalResultFragmentBinding3 != null) {
            return internalResultFragmentBinding3.getRoot();
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
        setHasOptionsMenu(true);
        InternalResultFragmentBinding internalResultFragmentBinding = get_binding();
        RecyclerView recyclerView = internalResultFragmentBinding != null ? internalResultFragmentBinding.rvResultInternal : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        InternalResultFragmentBinding internalResultFragmentBinding2 = get_binding();
        Spinner spinner = internalResultFragmentBinding2 != null ? internalResultFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSemResponse();
        listenResponse();
        InternalResultFragmentBinding internalResultFragmentBinding3 = get_binding();
        TextView textView = internalResultFragmentBinding3 != null ? internalResultFragmentBinding3.internalSemText : null;
        if (textView != null) {
            textView.setText(getPreference().getUserSem());
        }
        InternalResultFragmentBinding internalResultFragmentBinding4 = get_binding();
        if (internalResultFragmentBinding4 != null && (floatingActionButton = internalResultFragmentBinding4.fabInternalResultSemester) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InternalResultFragment.setUp$lambda$0(InternalResultFragment.this, view);
                }
            });
        }
        getInternalResultViewModel().getResult(getPreference().getUserSemId());
        InternalResultFragmentBinding internalResultFragmentBinding5 = get_binding();
        Spinner spinner2 = internalResultFragmentBinding5 != null ? internalResultFragmentBinding5.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$setUp$2
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
                    InternalResultFragmentBinding internalResultFragmentBinding6;
                    InternalResultViewModel internalResultViewModel;
                    SharedPrefManager preference2;
                    Spinner spinner3;
                    InternalResultViewModel internalResultViewModel2;
                    spinnerAdapter = InternalResultFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    z = InternalResultFragment.this.flag;
                    if (z) {
                        internalResultViewModel2 = InternalResultFragment.this.getInternalResultViewModel();
                        internalResultViewModel2.getResult(semester.getId());
                        return;
                    }
                    InternalResultFragment.this.flag = true;
                    spinnerAdapter2 = InternalResultFragment.this.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = InternalResultFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = InternalResultFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i).getId())) {
                            internalResultFragmentBinding6 = InternalResultFragment.this.get_binding();
                            if (internalResultFragmentBinding6 != null && (spinner3 = internalResultFragmentBinding6.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                internalResultViewModel = InternalResultFragment.this.getInternalResultViewModel();
                                preference2 = InternalResultFragment.this.getPreference();
                                internalResultViewModel.getResult(preference2.getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        InternalResultFragmentBinding internalResultFragmentBinding6 = get_binding();
        if (internalResultFragmentBinding6 == null || (swipeRefreshLayout = internalResultFragmentBinding6.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                InternalResultFragment.setUp$lambda$1(InternalResultFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(InternalResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo newInstance = SemListDialogTwo.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(InternalResultFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getInternalResultViewModel().getSemester();
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
        getInternalResultViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InternalResultFragment.listenSemResponse$lambda$3(InternalResultFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(InternalResultFragment this$0, Resource resource) {
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
                InternalResultFragmentBinding internalResultFragmentBinding = this$0.get_binding();
                if (internalResultFragmentBinding != null && (swipeRefreshLayout2 = internalResultFragmentBinding.swipeLayout) != null) {
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
            InternalResultFragmentBinding internalResultFragmentBinding2 = this$0.get_binding();
            if (internalResultFragmentBinding2 == null || (recyclerView = internalResultFragmentBinding2.rvResultInternal) == null) {
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
            InternalResultFragmentBinding internalResultFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (internalResultFragmentBinding3 == null || (swipeRefreshLayout = internalResultFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                InternalResultFragmentBinding internalResultFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = internalResultFragmentBinding4 != null ? internalResultFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        InternalResultFragmentBinding internalResultFragmentBinding5 = this$0.get_binding();
                        if (internalResultFragmentBinding5 == null || (spinner = internalResultFragmentBinding5.spinnerSem) == null) {
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
        getInternalResultViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.internal.InternalResultFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InternalResultFragment.listenResponse$lambda$5(InternalResultFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(InternalResultFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<ResultInternal> arrayList = (ArrayList) resource.getData();
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
        InternalResultFragmentBinding internalResultFragmentBinding = this$0.get_binding();
        if (internalResultFragmentBinding == null || (recyclerView = internalResultFragmentBinding.rvResultInternal) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        InternalResultFragmentBinding internalResultFragmentBinding = get_binding();
        if (internalResultFragmentBinding == null || (recyclerView = internalResultFragmentBinding.rvResultInternal) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        InternalResultFragmentBinding internalResultFragmentBinding = get_binding();
        if (internalResultFragmentBinding == null || (recyclerView = internalResultFragmentBinding.rvResultInternal) == null) {
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
        getInternalResultViewModel().getResult(id);
        InternalResultFragmentBinding internalResultFragmentBinding = get_binding();
        TextView textView = internalResultFragmentBinding != null ? internalResultFragmentBinding.internalSemText : null;
        if (textView == null) {
            return;
        }
        textView.setText(sem);
    }
}