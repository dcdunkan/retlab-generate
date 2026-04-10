package in.etuwa.app.ui.transport.history;

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
import in.etuwa.app.data.model.transport.TransportHistoryResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentTransportHistoryBinding;
import in.etuwa.app.ui.base.BaseFragment;
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

/* compiled from: TransportHistoryFragment.kt */
/* loaded from: classes5.dex */
public final class TransportHistoryFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTransportHistoryBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: transportHistoryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy transportHistoryViewModel;

    /* compiled from: TransportHistoryFragment.kt */
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
    public static final TransportHistoryFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TransportHistoryFragment() {
        final TransportHistoryFragment transportHistoryFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(transportHistoryFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.transportHistoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(transportHistoryFragment, Reflection.getOrCreateKotlinClass(TransportHistoryViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TransportHistoryViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TransportHistoryFragment transportHistoryFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TransportHistoryAdapter>() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.history.TransportHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportHistoryFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportHistoryAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = transportHistoryFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final TransportHistoryViewModel getTransportHistoryViewModel() {
        return (TransportHistoryViewModel) this.transportHistoryViewModel.getValue();
    }

    private final TransportHistoryAdapter getAdapter() {
        return (TransportHistoryAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentTransportHistoryBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: TransportHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/transport/history/TransportHistoryFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transport/history/TransportHistoryFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TransportHistoryFragment newInstance() {
            return new TransportHistoryFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTransportHistoryBinding.inflate(inflater, container, false);
        FragmentTransportHistoryBinding fragmentTransportHistoryBinding = get_binding();
        if (fragmentTransportHistoryBinding != null) {
            fragmentTransportHistoryBinding.setTransportHistoryViewModel(getTransportHistoryViewModel());
        }
        FragmentTransportHistoryBinding fragmentTransportHistoryBinding2 = get_binding();
        if (fragmentTransportHistoryBinding2 != null) {
            fragmentTransportHistoryBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTransportHistoryBinding fragmentTransportHistoryBinding3 = get_binding();
        if (fragmentTransportHistoryBinding3 != null) {
            return fragmentTransportHistoryBinding3.getRoot();
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
            activity.setTitle("Transport History");
        }
        hideBaseView();
        FragmentTransportHistoryBinding fragmentTransportHistoryBinding = get_binding();
        RecyclerView recyclerView = fragmentTransportHistoryBinding != null ? fragmentTransportHistoryBinding.rvTransportFeeHistory : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getPreference().setNewLogin(false);
        getTransportHistoryViewModel().getTransportFeeHistory();
        listenResponse();
    }

    private final void listenResponse() {
        getTransportHistoryViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportHistoryFragment.listenResponse$lambda$1(TransportHistoryFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$1(TransportHistoryFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TransportHistoryResponse transportHistoryResponse = (TransportHistoryResponse) resource.getData();
            if (transportHistoryResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(transportHistoryResponse.getHistory());
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
        FragmentTransportHistoryBinding fragmentTransportHistoryBinding = this$0.get_binding();
        if (fragmentTransportHistoryBinding == null || (recyclerView = fragmentTransportHistoryBinding.rvTransportFeeHistory) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentTransportHistoryBinding fragmentTransportHistoryBinding = get_binding();
        if (fragmentTransportHistoryBinding == null || (recyclerView = fragmentTransportHistoryBinding.rvTransportFeeHistory) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentTransportHistoryBinding fragmentTransportHistoryBinding = get_binding();
        if (fragmentTransportHistoryBinding == null || (recyclerView = fragmentTransportHistoryBinding.rvTransportFeeHistory) == null) {
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