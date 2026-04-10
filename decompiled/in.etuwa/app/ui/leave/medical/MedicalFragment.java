package in.etuwa.app.ui.leave.medical;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.leave.medical.MedicalLeave;
import in.etuwa.app.databinding.MedicalFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.leave.medical.add.AddMedicalLeave;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: MedicalFragment.kt */
/* loaded from: classes5.dex */
public final class MedicalFragment extends BaseFragment implements AddMedicalLeave.AddLeaveCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MedicalFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: medicalViewModel$delegate, reason: from kotlin metadata */
    private final Lazy medicalViewModel;

    /* compiled from: MedicalFragment.kt */
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
    public static final MedicalFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public MedicalFragment() {
        final MedicalFragment medicalFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.medical.MedicalFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(medicalFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.medicalViewModel = FragmentViewModelLazyKt.createViewModelLazy(medicalFragment, Reflection.getOrCreateKotlinClass(MedicalViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.medical.MedicalFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.medical.MedicalFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(MedicalViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MedicalFragment medicalFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MedicalAdapter>() { // from class: in.etuwa.app.ui.leave.medical.MedicalFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.medical.MedicalAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MedicalAdapter invoke() {
                ComponentCallbacks componentCallbacks = medicalFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MedicalAdapter.class), b2, b3);
            }
        });
    }

    private final MedicalViewModel getMedicalViewModel() {
        return (MedicalViewModel) this.medicalViewModel.getValue();
    }

    private final MedicalAdapter getAdapter() {
        return (MedicalAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final MedicalFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: MedicalFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/leave/medical/MedicalFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/medical/MedicalFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MedicalFragment newInstance() {
            return new MedicalFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = MedicalFragmentBinding.inflate(inflater, container, false);
        MedicalFragmentBinding medicalFragmentBinding = get_binding();
        if (medicalFragmentBinding != null) {
            medicalFragmentBinding.setMedicalViewModel(getMedicalViewModel());
        }
        MedicalFragmentBinding medicalFragmentBinding2 = get_binding();
        if (medicalFragmentBinding2 != null) {
            medicalFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        MedicalFragmentBinding medicalFragmentBinding3 = get_binding();
        if (medicalFragmentBinding3 != null) {
            return medicalFragmentBinding3.getRoot();
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
        MedicalFragmentBinding medicalFragmentBinding = get_binding();
        RecyclerView recyclerView = medicalFragmentBinding != null ? medicalFragmentBinding.rvMedical : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        listenResponse();
        MedicalFragmentBinding medicalFragmentBinding2 = get_binding();
        if (medicalFragmentBinding2 != null && (floatingActionButton = medicalFragmentBinding2.fabAddLeave) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.medical.MedicalFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MedicalFragment.setUp$lambda$0(MedicalFragment.this, view);
                }
            });
        }
        MedicalFragmentBinding medicalFragmentBinding3 = get_binding();
        if (medicalFragmentBinding3 == null || (swipeRefreshLayout = medicalFragmentBinding3.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.leave.medical.MedicalFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                MedicalFragment.setUp$lambda$1(MedicalFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(MedicalFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddMedicalLeave newInstance = AddMedicalLeave.INSTANCE.newInstance();
        newInstance.setAddLeaveCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(MedicalFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMedicalViewModel().getLeave();
        MedicalFragmentBinding medicalFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = medicalFragmentBinding != null ? medicalFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getMedicalViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.medical.MedicalFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MedicalFragment.listenResponse$lambda$3(MedicalFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(MedicalFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<MedicalLeave> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(arrayList);
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
        MedicalFragmentBinding medicalFragmentBinding = this$0.get_binding();
        if (medicalFragmentBinding == null || (recyclerView = medicalFragmentBinding.rvMedical) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.leave.medical.add.AddMedicalLeave.AddLeaveCallBack
    public void onDismiss() {
        getMedicalViewModel().getLeave();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        MedicalFragmentBinding medicalFragmentBinding = get_binding();
        if (medicalFragmentBinding == null || (recyclerView = medicalFragmentBinding.rvMedical) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        MedicalFragmentBinding medicalFragmentBinding = get_binding();
        if (medicalFragmentBinding == null || (recyclerView = medicalFragmentBinding.rvMedical) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}