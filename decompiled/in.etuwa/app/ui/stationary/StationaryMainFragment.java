package in.etuwa.app.ui.stationary;

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
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentStationaryMainBinding;
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

/* JADX INFO: compiled from: StationaryMainFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class StationaryMainFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentStationaryMainBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: stationaryMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy stationaryMainViewModel;

    @JvmStatic
    public static final StationaryMainFragment newInstance() {
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

    public StationaryMainFragment() {
        final StationaryMainFragment stationaryMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.stationary.StationaryMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return stationaryMainFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(stationaryMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.stationaryMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(stationaryMainFragment, Reflection.getOrCreateKotlinClass(StationaryMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.stationary.StationaryMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.stationary.StationaryMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(StationaryMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final StationaryMainFragment stationaryMainFragment2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.stationary.StationaryMainFragment$adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.getChildFragmentManager());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StationaryMainAdapter>() { // from class: in.etuwa.app.ui.stationary.StationaryMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.stationary.StationaryMainAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final StationaryMainAdapter invoke() {
                ComponentCallbacks componentCallbacks = stationaryMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StationaryMainAdapter.class), b2, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        final byte b4 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.stationary.StationaryMainFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = stationaryMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b3, b4);
            }
        });
    }

    private final StationaryMainViewModel getStationaryMainViewModel() {
        return (StationaryMainViewModel) this.stationaryMainViewModel.getValue();
    }

    private final StationaryMainAdapter getAdapter() {
        return (StationaryMainAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentStationaryMainBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: StationaryMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/stationary/StationaryMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/stationary/StationaryMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StationaryMainFragment newInstance() {
            return new StationaryMainFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentStationaryMainBinding.inflate(inflater, container, false);
        FragmentStationaryMainBinding fragmentStationaryMainBinding = get_binding();
        if (fragmentStationaryMainBinding != null) {
            fragmentStationaryMainBinding.setStationaryMainViewModel(getStationaryMainViewModel());
        }
        FragmentStationaryMainBinding fragmentStationaryMainBinding2 = get_binding();
        if (fragmentStationaryMainBinding2 != null) {
            fragmentStationaryMainBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentStationaryMainBinding fragmentStationaryMainBinding3 = get_binding();
        View root = fragmentStationaryMainBinding3 != null ? fragmentStationaryMainBinding3.getRoot() : null;
        Intrinsics.checkNotNull(root);
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        TabLayout tabLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Stationary");
        }
        FragmentStationaryMainBinding fragmentStationaryMainBinding = get_binding();
        ViewPager viewPager = fragmentStationaryMainBinding != null ? fragmentStationaryMainBinding.stationaryPager : null;
        if (viewPager != null) {
            viewPager.setAdapter(getAdapter());
        }
        FragmentStationaryMainBinding fragmentStationaryMainBinding2 = get_binding();
        if (fragmentStationaryMainBinding2 != null && (tabLayout = fragmentStationaryMainBinding2.tabs) != null) {
            FragmentStationaryMainBinding fragmentStationaryMainBinding3 = get_binding();
            tabLayout.setupWithViewPager(fragmentStationaryMainBinding3 != null ? fragmentStationaryMainBinding3.stationaryPager : null);
        }
        getPreference().setNewLogin(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}