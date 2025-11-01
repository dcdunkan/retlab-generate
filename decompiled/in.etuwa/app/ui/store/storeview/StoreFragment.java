package in.etuwa.app.ui.store.storeview;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.store.StoreResponse;
import in.etuwa.app.data.model.store.departmentlist.DepartmentListResponse;
import in.etuwa.app.databinding.FragmentStoreBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.store.storeview.StoreAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: StoreFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020)H\u0014J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\u0012\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00106\u001a\u00020)H\u0016J\u001a\u00107\u001a\u00020)2\u0006\u00108\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00109\u001a\u00020)H\u0014J\b\u0010:\u001a\u00020)H\u0014J\b\u0010;\u001a\u00020)H\u0014J$\u0010<\u001a\u00020)2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lin/etuwa/app/ui/store/storeview/StoreFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/store/storeview/StoreAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentStoreBinding;", "adapter", "Lin/etuwa/app/ui/store/storeview/StoreAdapter;", "getAdapter", "()Lin/etuwa/app/ui/store/storeview/StoreAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentStoreBinding;", "selected", "", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", "spinnerAdapter", "Lin/etuwa/app/ui/store/storeview/StoreCategoryAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/store/storeview/StoreCategoryAdapter;", "spinnerAdapter$delegate", "storeViewModel", "Lin/etuwa/app/ui/store/storeview/StoreViewModel;", "getStoreViewModel", "()Lin/etuwa/app/ui/store/storeview/StoreViewModel;", "storeViewModel$delegate", StoreFragmentKt.SUB_ID, FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()D", "setTotal", "(D)V", "type", "hideBaseView", "", "hideProgress", "listenResponse", "listenSpinner", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "updateSelected", "sel", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StoreFragment extends BaseFragment implements StoreAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentStoreBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private List<String> selected;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: storeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy storeViewModel;
    private String subId;
    private double total;
    private String type;

    /* compiled from: StoreFragment.kt */
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
    public static final StoreFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public StoreFragment() {
        final StoreFragment storeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(storeFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.storeViewModel = FragmentViewModelLazyKt.createViewModelLazy(storeFragment, Reflection.getOrCreateKotlinClass(StoreViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(StoreViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final StoreFragment storeFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StoreAdapter>() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.store.storeview.StoreAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final StoreAdapter invoke() {
                ComponentCallbacks componentCallbacks = storeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoreAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(StoreFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<StoreCategoryAdapter>() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.store.storeview.StoreCategoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final StoreCategoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = storeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoreCategoryAdapter.class), b4, function02);
            }
        });
        this.selected = new ArrayList();
        this.type = "";
    }

    private final StoreViewModel getStoreViewModel() {
        return (StoreViewModel) this.storeViewModel.getValue();
    }

    private final StoreAdapter getAdapter() {
        return (StoreAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentStoreBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreCategoryAdapter getSpinnerAdapter() {
        return (StoreCategoryAdapter) this.spinnerAdapter.getValue();
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    /* compiled from: StoreFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/store/storeview/StoreFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/store/storeview/StoreFragment;", StoreFragmentKt.SUB_ID, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StoreFragment newInstance(String subId) {
            StoreFragment storeFragment = new StoreFragment();
            Bundle bundle = new Bundle();
            bundle.putString(StoreFragmentKt.SUB_ID, subId);
            storeFragment.setArguments(bundle);
            return storeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.subId = arguments.getString(StoreFragmentKt.SUB_ID);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentStoreBinding.inflate(inflater, container, false);
        FragmentStoreBinding fragmentStoreBinding = get_binding();
        if (fragmentStoreBinding != null) {
            fragmentStoreBinding.setStoreViewModel(getStoreViewModel());
        }
        FragmentStoreBinding fragmentStoreBinding2 = get_binding();
        if (fragmentStoreBinding2 != null) {
            fragmentStoreBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentStoreBinding fragmentStoreBinding3 = get_binding();
        if (fragmentStoreBinding3 != null) {
            return fragmentStoreBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Store");
        }
        hideBaseView();
        FragmentStoreBinding fragmentStoreBinding = get_binding();
        RecyclerView recyclerView = fragmentStoreBinding != null ? fragmentStoreBinding.rvStore : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        String str = this.subId;
        if (str != null) {
            getStoreViewModel().getStoreData(str);
        }
        listenResponse();
        FragmentStoreBinding fragmentStoreBinding2 = get_binding();
        Spinner spinner = fragmentStoreBinding2 != null ? fragmentStoreBinding2.spinnerCategory : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinner();
        FragmentStoreBinding fragmentStoreBinding3 = get_binding();
        Spinner spinner2 = fragmentStoreBinding3 != null ? fragmentStoreBinding3.spinnerCategory : null;
        if (spinner2 == null) {
            return;
        }
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$setUp$2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StoreCategoryAdapter spinnerAdapter;
                StoreFragment storeFragment = StoreFragment.this;
                spinnerAdapter = storeFragment.getSpinnerAdapter();
                storeFragment.type = spinnerAdapter.getSemester(position).getId();
            }
        });
    }

    private final void listenResponse() {
        getStoreViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StoreFragment.listenResponse$lambda$3(StoreFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(StoreFragment this$0, Resource resource) {
        RecyclerView rvStore;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            StoreResponse storeResponse = (StoreResponse) resource.getData();
            if (storeResponse != null) {
                this$0.showBaseView();
                if (storeResponse.getLogin()) {
                    this$0.getAdapter().addItems(storeResponse.getData());
                    return;
                }
                FragmentStoreBinding fragmentStoreBinding = this$0.get_binding();
                if (fragmentStoreBinding == null || (rvStore = fragmentStoreBinding.rvStore) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvStore, "rvStore");
                ToastExtKt.showErrorToast(rvStore, "netwok error");
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
        FragmentStoreBinding fragmentStoreBinding2 = this$0.get_binding();
        if (fragmentStoreBinding2 == null || (recyclerView = fragmentStoreBinding2.rvStore) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenSpinner() {
        getStoreViewModel().getDepResponse().observe(getViewLifecycleOwner(), new StoreFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DepartmentListResponse>, Unit>() { // from class: in.etuwa.app.ui.store.storeview.StoreFragment$listenSpinner$1

            /* compiled from: StoreFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DepartmentListResponse> resource) {
                invoke2((Resource<DepartmentListResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DepartmentListResponse> resource) {
                StoreCategoryAdapter spinnerAdapter;
                FragmentStoreBinding fragmentStoreBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    StoreFragment.this.hideProgress();
                    DepartmentListResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter = StoreFragment.this.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getData());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    StoreFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    StoreFragment.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                StoreFragment.this.hideProgress();
                fragmentStoreBinding = StoreFragment.this.get_binding();
                if (fragmentStoreBinding == null || (spinner = fragmentStoreBinding.spinnerCategory) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentStoreBinding fragmentStoreBinding = get_binding();
        if (fragmentStoreBinding == null || (recyclerView = fragmentStoreBinding.rvStore) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentStoreBinding fragmentStoreBinding = get_binding();
        if (fragmentStoreBinding == null || (recyclerView = fragmentStoreBinding.rvStore) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.store.storeview.StoreAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        TextView textView;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        int size = total.size() - 1;
        double d = 0.0d;
        if (size >= 0) {
            int i = 0;
            while (true) {
                d += Double.parseDouble(total.get(i));
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.selected = sel;
        this.total = d;
        FragmentStoreBinding fragmentStoreBinding = get_binding();
        TextView textView2 = fragmentStoreBinding != null ? fragmentStoreBinding.tvStoreTotal : null;
        if (textView2 != null) {
            textView2.setText(String.valueOf(d));
        }
        if (d <= 0.0d) {
            FragmentStoreBinding fragmentStoreBinding2 = get_binding();
            textView = fragmentStoreBinding2 != null ? fragmentStoreBinding2.payStoreBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        FragmentStoreBinding fragmentStoreBinding3 = get_binding();
        textView = fragmentStoreBinding3 != null ? fragmentStoreBinding3.payStoreBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }
}