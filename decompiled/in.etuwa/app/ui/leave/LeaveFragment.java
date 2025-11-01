package in.etuwa.app.ui.leave;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.databinding.FragmentLeaveBinding;
import in.etuwa.app.ui.base.BaseFragment;
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

/* compiled from: LeaveFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0014H\u0014J\b\u0010!\u001a\u00020\u0014H\u0014J\b\u0010\"\u001a\u00020\u0014H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lin/etuwa/app/ui/leave/LeaveFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentLeaveBinding;", "adapter", "Lin/etuwa/app/ui/leave/LeaveAdapter;", "getAdapter", "()Lin/etuwa/app/ui/leave/LeaveAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentLeaveBinding;", "leaveViewModel", "Lin/etuwa/app/ui/leave/LeaveViewModel;", "getLeaveViewModel", "()Lin/etuwa/app/ui/leave/LeaveViewModel;", "leaveViewModel$delegate", "hideBaseView", "", "hideProgress", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LeaveFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentLeaveBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: leaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy leaveViewModel;

    @JvmStatic
    public static final LeaveFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public LeaveFragment() {
        final LeaveFragment leaveFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.LeaveFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(leaveFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.leaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(leaveFragment, Reflection.getOrCreateKotlinClass(LeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.LeaveFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.LeaveFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(LeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final LeaveFragment leaveFragment2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.leave.LeaveFragment$adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(LeaveFragment.this.getChildFragmentManager());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<LeaveAdapter>() { // from class: in.etuwa.app.ui.leave.LeaveFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.LeaveAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LeaveAdapter invoke() {
                ComponentCallbacks componentCallbacks = leaveFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LeaveAdapter.class), b2, function02);
            }
        });
    }

    private final LeaveViewModel getLeaveViewModel() {
        return (LeaveViewModel) this.leaveViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentLeaveBinding get_binding() {
        return this._binding;
    }

    private final LeaveAdapter getAdapter() {
        return (LeaveAdapter) this.adapter.getValue();
    }

    /* compiled from: LeaveFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/leave/LeaveFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/LeaveFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LeaveFragment newInstance() {
            return new LeaveFragment();
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        TabLayout tabLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.leave));
        }
        FragmentLeaveBinding fragmentLeaveBinding = get_binding();
        ViewPager viewPager = fragmentLeaveBinding != null ? fragmentLeaveBinding.leavePager : null;
        if (viewPager != null) {
            viewPager.setAdapter(getAdapter());
        }
        FragmentLeaveBinding fragmentLeaveBinding2 = get_binding();
        if (fragmentLeaveBinding2 == null || (tabLayout = fragmentLeaveBinding2.tabs) == null) {
            return;
        }
        FragmentLeaveBinding fragmentLeaveBinding3 = get_binding();
        tabLayout.setupWithViewPager(fragmentLeaveBinding3 != null ? fragmentLeaveBinding3.leavePager : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentLeaveBinding.inflate(inflater, container, false);
        FragmentLeaveBinding fragmentLeaveBinding = get_binding();
        if (fragmentLeaveBinding != null) {
            fragmentLeaveBinding.setLeaveViewModel(getLeaveViewModel());
        }
        FragmentLeaveBinding fragmentLeaveBinding2 = get_binding();
        if (fragmentLeaveBinding2 != null) {
            fragmentLeaveBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentLeaveBinding fragmentLeaveBinding3 = get_binding();
        if (fragmentLeaveBinding3 != null) {
            return fragmentLeaveBinding3.getRoot();
        }
        return null;
    }
}