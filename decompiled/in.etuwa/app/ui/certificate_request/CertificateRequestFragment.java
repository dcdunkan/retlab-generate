package in.etuwa.app.ui.certificate_request;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.certificaterequest.CertificateRequestResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.CertificateRequestFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CertificateRequestFragment.kt */
/* loaded from: classes4.dex */
public final class CertificateRequestFragment extends BaseFragment implements AddRequestDialog.AddRequestListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CertificateRequestFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: certificateRequestViewModel$delegate, reason: from kotlin metadata */
    private final Lazy certificateRequestViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private CertificateRequestViewModel viewModel;

    /* compiled from: CertificateRequestFragment.kt */
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

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public CertificateRequestFragment() {
        final CertificateRequestFragment certificateRequestFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(certificateRequestFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.certificateRequestViewModel = FragmentViewModelLazyKt.createViewModelLazy(certificateRequestFragment, Reflection.getOrCreateKotlinClass(CertificateRequestViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CertificateRequestViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CertificateRequestFragment certificateRequestFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CertificateRequestAdapter>() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.certificate_request.CertificateRequestAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CertificateRequestAdapter invoke() {
                ComponentCallbacks componentCallbacks = certificateRequestFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CertificateRequestAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = certificateRequestFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final CertificateRequestViewModel getCertificateRequestViewModel() {
        return (CertificateRequestViewModel) this.certificateRequestViewModel.getValue();
    }

    private final CertificateRequestAdapter getAdapter() {
        return (CertificateRequestAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final CertificateRequestFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: CertificateRequestFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/certificate_request/CertificateRequestFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/certificate_request/CertificateRequestFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CertificateRequestFragment newInstance() {
            return new CertificateRequestFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CertificateRequestFragmentBinding.inflate(inflater, container, false);
        CertificateRequestFragmentBinding certificateRequestFragmentBinding = get_binding();
        if (certificateRequestFragmentBinding != null) {
            certificateRequestFragmentBinding.setCertificateRequestViewModel(getCertificateRequestViewModel());
        }
        CertificateRequestFragmentBinding certificateRequestFragmentBinding2 = get_binding();
        if (certificateRequestFragmentBinding2 != null) {
            certificateRequestFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CertificateRequestFragmentBinding certificateRequestFragmentBinding3 = get_binding();
        if (certificateRequestFragmentBinding3 != null) {
            return certificateRequestFragmentBinding3.getRoot();
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
        Button button;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.certificate_request));
        }
        hideBaseView();
        CertificateRequestFragmentBinding certificateRequestFragmentBinding = get_binding();
        RecyclerView recyclerView = certificateRequestFragmentBinding != null ? certificateRequestFragmentBinding.rvCertificateRequest : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        CertificateRequestFragmentBinding certificateRequestFragmentBinding2 = get_binding();
        if (certificateRequestFragmentBinding2 != null && (button = certificateRequestFragmentBinding2.addRequestBtn) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CertificateRequestFragment.setUp$lambda$0(CertificateRequestFragment.this, view);
                }
            });
        }
        getPreference().setNewLogin(false);
        listenResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(CertificateRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddRequestDialog newInstance = AddRequestDialog.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        CertificateRequestFragmentBinding certificateRequestFragmentBinding = get_binding();
        if (certificateRequestFragmentBinding == null || (recyclerView = certificateRequestFragmentBinding.rvCertificateRequest) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        CertificateRequestFragmentBinding certificateRequestFragmentBinding = get_binding();
        if (certificateRequestFragmentBinding == null || (recyclerView = certificateRequestFragmentBinding.rvCertificateRequest) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    private final void listenResponse() {
        getCertificateRequestViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CertificateRequestFragment.listenResponse$lambda$2(CertificateRequestFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(CertificateRequestFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            CertificateRequestResponse certificateRequestResponse = (CertificateRequestResponse) resource.getData();
            if (certificateRequestResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(certificateRequestResponse.getCertificateRequests());
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
        CertificateRequestFragmentBinding certificateRequestFragmentBinding = this$0.get_binding();
        if (certificateRequestFragmentBinding == null || (recyclerView = certificateRequestFragmentBinding.rvCertificateRequest) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.AddRequestListener
    public void dismiss() {
        getCertificateRequestViewModel().getCertificateRequest();
    }
}