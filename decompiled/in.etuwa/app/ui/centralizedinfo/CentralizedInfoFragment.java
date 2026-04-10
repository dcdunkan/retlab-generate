package in.etuwa.app.ui.centralizedinfo;

import android.content.ComponentCallbacks;
import android.content.Intent;
import android.net.Uri;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.centralizedinfo.CentralizedInfoResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.CentralizedInfoFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.centralizedinfo.CentralizedInfoAdapter;
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

/* compiled from: CentralizedInfoFragment.kt */
/* loaded from: classes4.dex */
public final class CentralizedInfoFragment extends BaseFragment implements CentralizedInfoAdapter.InfoCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CentralizedInfoFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: centralizedInfoViewModel$delegate, reason: from kotlin metadata */
    private final Lazy centralizedInfoViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: CentralizedInfoFragment.kt */
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
    public static final CentralizedInfoFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public CentralizedInfoFragment() {
        final CentralizedInfoFragment centralizedInfoFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(centralizedInfoFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.centralizedInfoViewModel = FragmentViewModelLazyKt.createViewModelLazy(centralizedInfoFragment, Reflection.getOrCreateKotlinClass(CentralizedInfoViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CentralizedInfoViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CentralizedInfoFragment centralizedInfoFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CentralizedInfoAdapter>() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.centralizedinfo.CentralizedInfoAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CentralizedInfoAdapter invoke() {
                ComponentCallbacks componentCallbacks = centralizedInfoFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CentralizedInfoAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = centralizedInfoFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final CentralizedInfoViewModel getCentralizedInfoViewModel() {
        return (CentralizedInfoViewModel) this.centralizedInfoViewModel.getValue();
    }

    private final CentralizedInfoAdapter getAdapter() {
        return (CentralizedInfoAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final CentralizedInfoFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: CentralizedInfoFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/centralizedinfo/CentralizedInfoFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/centralizedinfo/CentralizedInfoFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CentralizedInfoFragment newInstance() {
            return new CentralizedInfoFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CentralizedInfoFragmentBinding.inflate(inflater, container, false);
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding = get_binding();
        if (centralizedInfoFragmentBinding != null) {
            centralizedInfoFragmentBinding.setCentralizedInfoViewModel(getCentralizedInfoViewModel());
        }
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding2 = get_binding();
        if (centralizedInfoFragmentBinding2 != null) {
            centralizedInfoFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding3 = get_binding();
        if (centralizedInfoFragmentBinding3 != null) {
            return centralizedInfoFragmentBinding3.getRoot();
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
        if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://chinarts.etlab.in/androidapp/")) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setTitle("Hobby");
            }
        } else {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setTitle(getString(R.string.info));
            }
        }
        getPreference().setNewLogin(false);
        hideBaseView();
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding = get_binding();
        RecyclerView recyclerView = centralizedInfoFragmentBinding != null ? centralizedInfoFragmentBinding.rvInfo : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding2 = get_binding();
        if (centralizedInfoFragmentBinding2 == null || (swipeRefreshLayout = centralizedInfoFragmentBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                CentralizedInfoFragment.setUp$lambda$0(CentralizedInfoFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(CentralizedInfoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCentralizedInfoViewModel().getCentralizedInfo();
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = centralizedInfoFragmentBinding != null ? centralizedInfoFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getCentralizedInfoViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CentralizedInfoFragment.listenResponse$lambda$2(CentralizedInfoFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(CentralizedInfoFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            CentralizedInfoResponse centralizedInfoResponse = (CentralizedInfoResponse) resource.getData();
            if (centralizedInfoResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(centralizedInfoResponse.getInfo());
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
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding = this$0.get_binding();
        if (centralizedInfoFragmentBinding == null || (recyclerView = centralizedInfoFragmentBinding.rvInfo) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.centralizedinfo.CentralizedInfoAdapter.InfoCallBack
    public void onItemClick(String link) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(link, "link");
        if (!Intrinsics.areEqual(link, "")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(link));
                startActivity(Intent.createChooser(intent, "Open With"));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding = get_binding();
        if (centralizedInfoFragmentBinding == null || (recyclerView = centralizedInfoFragmentBinding.rvInfo) == null) {
            return;
        }
        ToastExtKt.showInfoToast(recyclerView, "No Link Attached With It!!");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding = get_binding();
        if (centralizedInfoFragmentBinding == null || (recyclerView = centralizedInfoFragmentBinding.rvInfo) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        CentralizedInfoFragmentBinding centralizedInfoFragmentBinding = get_binding();
        if (centralizedInfoFragmentBinding == null || (recyclerView = centralizedInfoFragmentBinding.rvInfo) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}