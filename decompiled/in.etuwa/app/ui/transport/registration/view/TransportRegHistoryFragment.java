package in.etuwa.app.ui.transport.registration.view;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.transportpalai.registration.RegisterViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentTransportRegHistoryBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog;
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

/* JADX INFO: compiled from: TransportRegHistoryFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TransportRegHistoryFragment extends BaseFragment implements TransportRegistrationDialog.AddRegistrationCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTransportRegHistoryBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: transportRegHistoryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy transportRegHistoryViewModel;

    /* JADX INFO: compiled from: TransportRegHistoryFragment.kt */
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
    public static final TransportRegHistoryFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TransportRegHistoryFragment() {
        final TransportRegHistoryFragment transportRegHistoryFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return transportRegHistoryFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(transportRegHistoryFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.transportRegHistoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(transportRegHistoryFragment, Reflection.getOrCreateKotlinClass(TransportRegHistoryViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(TransportRegHistoryViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TransportRegHistoryFragment transportRegHistoryFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TransportRegHistoryAdapter>() { // from class: in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.registration.view.TransportRegHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportRegHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportRegHistoryFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportRegHistoryAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = transportRegHistoryFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final TransportRegHistoryViewModel getTransportRegHistoryViewModel() {
        return (TransportRegHistoryViewModel) this.transportRegHistoryViewModel.getValue();
    }

    private final TransportRegHistoryAdapter getAdapter() {
        return (TransportRegHistoryAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentTransportRegHistoryBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: TransportRegHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/transport/registration/view/TransportRegHistoryFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transport/registration/view/TransportRegHistoryFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TransportRegHistoryFragment newInstance() {
            return new TransportRegHistoryFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTransportRegHistoryBinding.inflate(inflater, container, false);
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding = get_binding();
        if (fragmentTransportRegHistoryBinding != null) {
            fragmentTransportRegHistoryBinding.setTransportRegHistoryViewModel(getTransportRegHistoryViewModel());
        }
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding2 = get_binding();
        if (fragmentTransportRegHistoryBinding2 != null) {
            fragmentTransportRegHistoryBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding3 = get_binding();
        if (fragmentTransportRegHistoryBinding3 != null) {
            return fragmentTransportRegHistoryBinding3.getRoot();
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
        FloatingActionButton floatingActionButton;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Transport Registration");
        }
        hideBaseView();
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding = get_binding();
        RecyclerView recyclerView = fragmentTransportRegHistoryBinding != null ? fragmentTransportRegHistoryBinding.rvRegHistoryTransport : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getPreference().setNewLogin(false);
        getTransportRegHistoryViewModel().getRegHistory();
        listenResponse();
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding2 = get_binding();
        if (fragmentTransportRegHistoryBinding2 == null || (floatingActionButton = fragmentTransportRegHistoryBinding2.fabAddTransReg) == null) {
            return;
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransportRegHistoryFragment.setUp$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TransportRegHistoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        TransportRegistrationDialog transportRegistrationDialogNewInstance = TransportRegistrationDialog.INSTANCE.newInstance();
        transportRegistrationDialogNewInstance.setAddRegistrationCallBack(this$0);
        transportRegistrationDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getTransportRegHistoryViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportRegHistoryFragment.listenResponse$lambda$2(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(TransportRegHistoryFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            RegisterViewResponse registerViewResponse = (RegisterViewResponse) resource.getData();
            if (registerViewResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(registerViewResponse.getHistory());
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
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding = this$0.get_binding();
        if (fragmentTransportRegHistoryBinding == null || (recyclerView = fragmentTransportRegHistoryBinding.rvRegHistoryTransport) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding = get_binding();
        if (fragmentTransportRegHistoryBinding == null || (recyclerView = fragmentTransportRegHistoryBinding.rvRegHistoryTransport) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentTransportRegHistoryBinding fragmentTransportRegHistoryBinding = get_binding();
        if (fragmentTransportRegHistoryBinding == null || (recyclerView = fragmentTransportRegHistoryBinding.rvRegHistoryTransport) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.transport.registration.register.TransportRegistrationDialog.AddRegistrationCallBack, in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog.AddRegistrationCallBack
    public void onDismiss() {
        getTransportRegHistoryViewModel().getRegHistory();
    }
}