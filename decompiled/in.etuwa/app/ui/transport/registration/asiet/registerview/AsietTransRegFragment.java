package in.etuwa.app.ui.transport.registration.asiet.registerview;

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
import in.etuwa.app.data.model.hostel.asiet.HostelAsietRegisterViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentAsietTransRegHistoryBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog;
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

/* compiled from: AsietTransRegFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u001a\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010*\u001a\u00020\u001bH\u0014J\b\u0010+\u001a\u00020\u001bH\u0014J\b\u0010,\u001a\u00020\u001bH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lin/etuwa/app/ui/transport/registration/asiet/registerview/AsietTransRegFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/transport/registration/register/TransportRegistrationDialog$AddRegistrationCallBack;", "Lin/etuwa/app/ui/transport/registration/asiet/registration/AsietTransRegDialog$AddRegistrationCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentAsietTransRegHistoryBinding;", "adapter", "Lin/etuwa/app/ui/transport/registration/asiet/registerview/AsietTransRegAdapter;", "getAdapter", "()Lin/etuwa/app/ui/transport/registration/asiet/registerview/AsietTransRegAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "asietTransRegViewModel", "Lin/etuwa/app/ui/transport/registration/asiet/registerview/AsietTransRegViewModel;", "getAsietTransRegViewModel", "()Lin/etuwa/app/ui/transport/registration/asiet/registerview/AsietTransRegViewModel;", "asietTransRegViewModel$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentAsietTransRegHistoryBinding;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDismiss", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsietTransRegFragment extends BaseFragment implements TransportRegistrationDialog.AddRegistrationCallBack, AsietTransRegDialog.AddRegistrationCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentAsietTransRegHistoryBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: asietTransRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy asietTransRegViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: AsietTransRegFragment.kt */
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
    public static final AsietTransRegFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public AsietTransRegFragment() {
        final AsietTransRegFragment asietTransRegFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(asietTransRegFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.asietTransRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(asietTransRegFragment, Reflection.getOrCreateKotlinClass(AsietTransRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AsietTransRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AsietTransRegFragment asietTransRegFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AsietTransRegAdapter>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AsietTransRegAdapter invoke() {
                ComponentCallbacks componentCallbacks = asietTransRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AsietTransRegAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = asietTransRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final AsietTransRegViewModel getAsietTransRegViewModel() {
        return (AsietTransRegViewModel) this.asietTransRegViewModel.getValue();
    }

    private final AsietTransRegAdapter getAdapter() {
        return (AsietTransRegAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentAsietTransRegHistoryBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: AsietTransRegFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/transport/registration/asiet/registerview/AsietTransRegFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transport/registration/asiet/registerview/AsietTransRegFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AsietTransRegFragment newInstance() {
            return new AsietTransRegFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentAsietTransRegHistoryBinding.inflate(inflater, container, false);
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding = get_binding();
        if (fragmentAsietTransRegHistoryBinding != null) {
            fragmentAsietTransRegHistoryBinding.setAsietTransRegViewModel(getAsietTransRegViewModel());
        }
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding2 = get_binding();
        if (fragmentAsietTransRegHistoryBinding2 != null) {
            fragmentAsietTransRegHistoryBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding3 = get_binding();
        if (fragmentAsietTransRegHistoryBinding3 != null) {
            return fragmentAsietTransRegHistoryBinding3.getRoot();
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
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding = get_binding();
        RecyclerView recyclerView = fragmentAsietTransRegHistoryBinding != null ? fragmentAsietTransRegHistoryBinding.rvRegHistoryTransport : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getPreference().setNewLogin(false);
        getAsietTransRegViewModel().getRegHistory();
        listenResponse();
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding2 = get_binding();
        if (fragmentAsietTransRegHistoryBinding2 == null || (floatingActionButton = fragmentAsietTransRegHistoryBinding2.fabAddTransReg) == null) {
            return;
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AsietTransRegFragment.setUp$lambda$0(AsietTransRegFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(AsietTransRegFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AsietTransRegDialog newInstance = AsietTransRegDialog.INSTANCE.newInstance();
        newInstance.setAddRegistrationCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getAsietTransRegViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AsietTransRegFragment.listenResponse$lambda$2(AsietTransRegFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(AsietTransRegFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelAsietRegisterViewResponse hostelAsietRegisterViewResponse = (HostelAsietRegisterViewResponse) resource.getData();
            if (hostelAsietRegisterViewResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(hostelAsietRegisterViewResponse.getHistory());
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
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding = this$0.get_binding();
        if (fragmentAsietTransRegHistoryBinding == null || (recyclerView = fragmentAsietTransRegHistoryBinding.rvRegHistoryTransport) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding = get_binding();
        if (fragmentAsietTransRegHistoryBinding == null || (recyclerView = fragmentAsietTransRegHistoryBinding.rvRegHistoryTransport) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentAsietTransRegHistoryBinding fragmentAsietTransRegHistoryBinding = get_binding();
        if (fragmentAsietTransRegHistoryBinding == null || (recyclerView = fragmentAsietTransRegHistoryBinding.rvRegHistoryTransport) == null) {
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
        getAsietTransRegViewModel().getRegHistory();
    }
}