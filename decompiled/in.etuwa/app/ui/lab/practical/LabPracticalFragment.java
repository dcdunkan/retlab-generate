package in.etuwa.app.ui.lab.practical;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
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
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.lab.Practical;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.LabPracticalFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.lab.practical.LabPracticalAdapter;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
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

/* compiled from: LabPracticalFragment.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0014J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020#H\u0016J\b\u00103\u001a\u00020#H\u0016J\u0012\u00104\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001c\u00107\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u0001062\b\u00108\u001a\u0004\u0018\u000106H\u0016J\u001a\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010;\u001a\u00020#H\u0014J\b\u0010<\u001a\u00020#H\u0014J\b\u0010=\u001a\u00020#H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 ¨\u0006?"}, d2 = {"Lin/etuwa/app/ui/lab/practical/LabPracticalFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/lab/practical/LabPracticalAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/LabPracticalFragmentBinding;", "adapter", "Lin/etuwa/app/ui/lab/practical/LabPracticalAdapter;", "getAdapter", "()Lin/etuwa/app/ui/lab/practical/LabPracticalAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/LabPracticalFragmentBinding;", "flag", "", "labPracticalViewModel", "Lin/etuwa/app/ui/lab/practical/LabPracticalViewModel;", "getLabPracticalViewModel", "()Lin/etuwa/app/ui/lab/practical/LabPracticalViewModel;", "labPracticalViewModel$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "listenSemResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onEvaluationClick", StoreFragmentKt.SUB_ID, "", "onExperimentClick", "subPid", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LabPracticalFragment extends BaseFragment implements LabPracticalAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private LabPracticalFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;

    /* renamed from: labPracticalViewModel$delegate, reason: from kotlin metadata */
    private final Lazy labPracticalViewModel;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: LabPracticalFragment.kt */
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
    public static final LabPracticalFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public LabPracticalFragment() {
        final LabPracticalFragment labPracticalFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(labPracticalFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.labPracticalViewModel = FragmentViewModelLazyKt.createViewModelLazy(labPracticalFragment, Reflection.getOrCreateKotlinClass(LabPracticalViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(LabPracticalViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final LabPracticalFragment labPracticalFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<LabPracticalAdapter>() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.lab.practical.LabPracticalAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LabPracticalAdapter invoke() {
                ComponentCallbacks componentCallbacks = labPracticalFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LabPracticalAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(LabPracticalFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = labPracticalFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = labPracticalFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LabPracticalViewModel getLabPracticalViewModel() {
        return (LabPracticalViewModel) this.labPracticalViewModel.getValue();
    }

    private final LabPracticalAdapter getAdapter() {
        return (LabPracticalAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final LabPracticalFragmentBinding get_binding() {
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

    /* compiled from: LabPracticalFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/lab/practical/LabPracticalFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/lab/practical/LabPracticalFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LabPracticalFragment newInstance() {
            return new LabPracticalFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = LabPracticalFragmentBinding.inflate(inflater, container, false);
        LabPracticalFragmentBinding labPracticalFragmentBinding = get_binding();
        if (labPracticalFragmentBinding != null) {
            labPracticalFragmentBinding.setLabPracticalViewModel(getLabPracticalViewModel());
        }
        LabPracticalFragmentBinding labPracticalFragmentBinding2 = get_binding();
        if (labPracticalFragmentBinding2 != null) {
            labPracticalFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        LabPracticalFragmentBinding labPracticalFragmentBinding3 = get_binding();
        if (labPracticalFragmentBinding3 != null) {
            return labPracticalFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.practical));
        }
        hideBaseView();
        LabPracticalFragmentBinding labPracticalFragmentBinding = get_binding();
        RecyclerView recyclerView = labPracticalFragmentBinding != null ? labPracticalFragmentBinding.rvPractical : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        LabPracticalFragmentBinding labPracticalFragmentBinding2 = get_binding();
        Spinner spinner = labPracticalFragmentBinding2 != null ? labPracticalFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSemResponse();
        listenResponse();
        LabPracticalFragmentBinding labPracticalFragmentBinding3 = get_binding();
        Spinner spinner2 = labPracticalFragmentBinding3 != null ? labPracticalFragmentBinding3.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$setUp$1
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
                    LabPracticalFragmentBinding labPracticalFragmentBinding4;
                    Spinner spinner3;
                    LabPracticalViewModel labPracticalViewModel;
                    spinnerAdapter = LabPracticalFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    z = LabPracticalFragment.this.flag;
                    if (z) {
                        labPracticalViewModel = LabPracticalFragment.this.getLabPracticalViewModel();
                        labPracticalViewModel.getPractical(semester.getId());
                        return;
                    }
                    LabPracticalFragment.this.flag = true;
                    spinnerAdapter2 = LabPracticalFragment.this.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = LabPracticalFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = LabPracticalFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i).getId())) {
                            labPracticalFragmentBinding4 = LabPracticalFragment.this.get_binding();
                            if (labPracticalFragmentBinding4 == null || (spinner3 = labPracticalFragmentBinding4.spinnerSem) == null) {
                                return;
                            }
                            spinner3.setSelection(i);
                            return;
                        }
                    }
                }
            });
        }
        LabPracticalFragmentBinding labPracticalFragmentBinding4 = get_binding();
        if (labPracticalFragmentBinding4 == null || (swipeRefreshLayout = labPracticalFragmentBinding4.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                LabPracticalFragment.setUp$lambda$0(LabPracticalFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(LabPracticalFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLabPracticalViewModel().getSemester();
    }

    private final void listenSemResponse() {
        getLabPracticalViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LabPracticalFragment.listenSemResponse$lambda$2(LabPracticalFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$2(LabPracticalFragment this$0, Resource resource) {
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
                LabPracticalFragmentBinding labPracticalFragmentBinding = this$0.get_binding();
                if (labPracticalFragmentBinding != null && (swipeRefreshLayout2 = labPracticalFragmentBinding.swipeLayout) != null) {
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
            LabPracticalFragmentBinding labPracticalFragmentBinding2 = this$0.get_binding();
            if (labPracticalFragmentBinding2 == null || (recyclerView = labPracticalFragmentBinding2.rvPractical) == null) {
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
            LabPracticalFragmentBinding labPracticalFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (labPracticalFragmentBinding3 == null || (swipeRefreshLayout = labPracticalFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                LabPracticalFragmentBinding labPracticalFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = labPracticalFragmentBinding4 != null ? labPracticalFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        LabPracticalFragmentBinding labPracticalFragmentBinding5 = this$0.get_binding();
                        if (labPracticalFragmentBinding5 == null || (spinner = labPracticalFragmentBinding5.spinnerSem) == null) {
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
        getLabPracticalViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.practical.LabPracticalFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LabPracticalFragment.listenResponse$lambda$4(LabPracticalFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(LabPracticalFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Practical> arrayList = (ArrayList) resource.getData();
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
        LabPracticalFragmentBinding labPracticalFragmentBinding = this$0.get_binding();
        if (labPracticalFragmentBinding == null || (recyclerView = labPracticalFragmentBinding.rvPractical) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.lab.practical.LabPracticalAdapter.CallBack
    public void onEvaluationClick(String subId) {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLabPracticalItemClick(0, subId, "");
        }
    }

    @Override // in.etuwa.app.ui.lab.practical.LabPracticalAdapter.CallBack
    public void onExperimentClick(String subId, String subPid) {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLabPracticalItemClick(1, subId, subPid);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        LabPracticalFragmentBinding labPracticalFragmentBinding = get_binding();
        if (labPracticalFragmentBinding == null || (recyclerView = labPracticalFragmentBinding.rvPractical) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        LabPracticalFragmentBinding labPracticalFragmentBinding = get_binding();
        if (labPracticalFragmentBinding == null || (recyclerView = labPracticalFragmentBinding.rvPractical) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
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

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
        this.listener = null;
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}