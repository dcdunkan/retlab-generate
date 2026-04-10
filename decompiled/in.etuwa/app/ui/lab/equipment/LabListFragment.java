package in.etuwa.app.ui.lab.equipment;

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
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.lab.LabList;
import in.etuwa.app.databinding.LabListFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.lab.equipment.LabListAdapter;
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

/* compiled from: LabListFragment.kt */
/* loaded from: classes5.dex */
public final class LabListFragment extends BaseFragment implements LabListAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private LabListFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: labListViewModel$delegate, reason: from kotlin metadata */
    private final Lazy labListViewModel;
    private MainCallBackListener listener;

    /* compiled from: LabListFragment.kt */
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
    public static final LabListFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public LabListFragment() {
        final LabListFragment labListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.lab.equipment.LabListFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(labListFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.labListViewModel = FragmentViewModelLazyKt.createViewModelLazy(labListFragment, Reflection.getOrCreateKotlinClass(LabListViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.lab.equipment.LabListFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.lab.equipment.LabListFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(LabListViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final LabListFragment labListFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<LabListAdapter>() { // from class: in.etuwa.app.ui.lab.equipment.LabListFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.lab.equipment.LabListAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LabListAdapter invoke() {
                ComponentCallbacks componentCallbacks = labListFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LabListAdapter.class), b2, b3);
            }
        });
    }

    private final LabListViewModel getLabListViewModel() {
        return (LabListViewModel) this.labListViewModel.getValue();
    }

    private final LabListAdapter getAdapter() {
        return (LabListAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final LabListFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: LabListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/lab/equipment/LabListFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/lab/equipment/LabListFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LabListFragment newInstance() {
            return new LabListFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = LabListFragmentBinding.inflate(inflater, container, false);
        LabListFragmentBinding labListFragmentBinding = get_binding();
        if (labListFragmentBinding != null) {
            labListFragmentBinding.setLabListViewModel(getLabListViewModel());
        }
        LabListFragmentBinding labListFragmentBinding2 = get_binding();
        if (labListFragmentBinding2 != null) {
            labListFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        LabListFragmentBinding labListFragmentBinding3 = get_binding();
        if (labListFragmentBinding3 != null) {
            return labListFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.labequpments));
        }
        hideBaseView();
        LabListFragmentBinding labListFragmentBinding = get_binding();
        RecyclerView recyclerView = labListFragmentBinding != null ? labListFragmentBinding.rvLabList : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        LabListFragmentBinding labListFragmentBinding2 = get_binding();
        if (labListFragmentBinding2 == null || (swipeRefreshLayout = labListFragmentBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.lab.equipment.LabListFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                LabListFragment.setUp$lambda$0(LabListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(LabListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLabListViewModel().getLabList();
        LabListFragmentBinding labListFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = labListFragmentBinding != null ? labListFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getLabListViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.equipment.LabListFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LabListFragment.listenResponse$lambda$2(LabListFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(LabListFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<LabList> arrayList = (ArrayList) resource.getData();
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
        LabListFragmentBinding labListFragmentBinding = this$0.get_binding();
        if (labListFragmentBinding == null || (recyclerView = labListFragmentBinding.rvLabList) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.lab.equipment.LabListAdapter.CallBack
    public void onLabListClick(int position, String labId) {
        Intrinsics.checkNotNullParameter(labId, "labId");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLabEquipmentItemClick(position, labId);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        LabListFragmentBinding labListFragmentBinding = get_binding();
        if (labListFragmentBinding == null || (recyclerView = labListFragmentBinding.rvLabList) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        LabListFragmentBinding labListFragmentBinding = get_binding();
        if (labListFragmentBinding == null || (recyclerView = labListFragmentBinding.rvLabList) == null) {
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