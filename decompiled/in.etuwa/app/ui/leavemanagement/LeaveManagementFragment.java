package in.etuwa.app.ui.leavemanagement;

import android.content.ComponentCallbacks;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.leavemanagement.LeaveManagementResponse;
import in.etuwa.app.databinding.FragmentLeaveManagementBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.leavemanagement.LeaveManagementAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* compiled from: LeaveManagementFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u001a\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010$\u001a\u00020\u0015H\u0014J\b\u0010%\u001a\u00020\u0015H\u0014J\b\u0010&\u001a\u00020\u0015H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lin/etuwa/app/ui/leavemanagement/LeaveManagementFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/leavemanagement/LeaveManagementAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentLeaveManagementBinding;", "adapter", "Lin/etuwa/app/ui/leavemanagement/LeaveManagementAdapter;", "getAdapter", "()Lin/etuwa/app/ui/leavemanagement/LeaveManagementAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentLeaveManagementBinding;", "leaveManagementViewModel", "Lin/etuwa/app/ui/leavemanagement/LeaveManagementViewModel;", "getLeaveManagementViewModel", "()Lin/etuwa/app/ui/leavemanagement/LeaveManagementViewModel;", "leaveManagementViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LeaveManagementFragment extends BaseFragment implements LeaveManagementAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentLeaveManagementBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: leaveManagementViewModel$delegate, reason: from kotlin metadata */
    private final Lazy leaveManagementViewModel;

    /* compiled from: LeaveManagementFragment.kt */
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
    public static final LeaveManagementFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public LeaveManagementFragment() {
        final LeaveManagementFragment leaveManagementFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(leaveManagementFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.leaveManagementViewModel = FragmentViewModelLazyKt.createViewModelLazy(leaveManagementFragment, Reflection.getOrCreateKotlinClass(LeaveManagementViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(LeaveManagementViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final LeaveManagementFragment leaveManagementFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<LeaveManagementAdapter>() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leavemanagement.LeaveManagementAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LeaveManagementAdapter invoke() {
                ComponentCallbacks componentCallbacks = leaveManagementFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LeaveManagementAdapter.class), b2, b3);
            }
        });
    }

    private final LeaveManagementViewModel getLeaveManagementViewModel() {
        return (LeaveManagementViewModel) this.leaveManagementViewModel.getValue();
    }

    private final LeaveManagementAdapter getAdapter() {
        return (LeaveManagementAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentLeaveManagementBinding get_binding() {
        return this._binding;
    }

    /* compiled from: LeaveManagementFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/leavemanagement/LeaveManagementFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leavemanagement/LeaveManagementFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LeaveManagementFragment newInstance() {
            LeaveManagementFragment leaveManagementFragment = new LeaveManagementFragment();
            leaveManagementFragment.setArguments(new Bundle());
            return leaveManagementFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentLeaveManagementBinding.inflate(inflater, container, false);
        FragmentLeaveManagementBinding fragmentLeaveManagementBinding = get_binding();
        if (fragmentLeaveManagementBinding != null) {
            fragmentLeaveManagementBinding.setLeaveManagementViewModel(getLeaveManagementViewModel());
        }
        FragmentLeaveManagementBinding fragmentLeaveManagementBinding2 = get_binding();
        if (fragmentLeaveManagementBinding2 != null) {
            fragmentLeaveManagementBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentLeaveManagementBinding fragmentLeaveManagementBinding3 = get_binding();
        if (fragmentLeaveManagementBinding3 != null) {
            return fragmentLeaveManagementBinding3.getRoot();
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
        FragmentLeaveManagementBinding fragmentLeaveManagementBinding = get_binding();
        RecyclerView recyclerView = fragmentLeaveManagementBinding != null ? fragmentLeaveManagementBinding.rvLeave : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        getLeaveManagementViewModel().getLeave();
    }

    private final void listenResponse() {
        getLeaveManagementViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LeaveManagementFragment.listenResponse$lambda$2(LeaveManagementFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(LeaveManagementFragment this$0, Resource resource) {
        RecyclerView rvLeave;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            LeaveManagementResponse leaveManagementResponse = (LeaveManagementResponse) resource.getData();
            if (leaveManagementResponse != null) {
                this$0.showBaseView();
                if (leaveManagementResponse.getLogin()) {
                    this$0.getAdapter().addItems(leaveManagementResponse.getLeave_data());
                    return;
                }
                FragmentLeaveManagementBinding fragmentLeaveManagementBinding = this$0.get_binding();
                if (fragmentLeaveManagementBinding == null || (rvLeave = fragmentLeaveManagementBinding.rvLeave) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvLeave, "rvLeave");
                ToastExtKt.showErrorToast(rvLeave, "netwok error");
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
        FragmentLeaveManagementBinding fragmentLeaveManagementBinding2 = this$0.get_binding();
        if (fragmentLeaveManagementBinding2 == null || (recyclerView = fragmentLeaveManagementBinding2.rvLeave) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentLeaveManagementBinding fragmentLeaveManagementBinding = get_binding();
        if (fragmentLeaveManagementBinding == null || (recyclerView = fragmentLeaveManagementBinding.rvLeave) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentLeaveManagementBinding fragmentLeaveManagementBinding = get_binding();
        if (fragmentLeaveManagementBinding == null || (recyclerView = fragmentLeaveManagementBinding.rvLeave) == null) {
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