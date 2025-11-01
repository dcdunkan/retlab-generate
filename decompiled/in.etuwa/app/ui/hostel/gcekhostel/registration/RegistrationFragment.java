package in.etuwa.app.ui.hostel.gcekhostel.registration;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.hostel.gcekhostel.registration.RegistrationResponse;
import in.etuwa.app.databinding.FragmentRegistrationBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog;
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog;
import in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RegistrationFragment.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001GB\u0005¢\u0006\u0002\u0010\u0007J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020!H\u0014J\b\u0010&\u001a\u00020!H\u0014J\b\u0010'\u001a\u00020!H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020!H\u0016J\b\u00104\u001a\u00020!H\u0016J\b\u00105\u001a\u00020!H\u0016J-\u00106\u001a\u00020!2\u0006\u00107\u001a\u0002082\u000e\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0:2\u0006\u0010;\u001a\u00020<H\u0016¢\u0006\u0002\u0010=J\u001a\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020$H\u0016J\b\u0010B\u001a\u00020!H\u0002J\b\u0010C\u001a\u00020!H\u0014J\b\u0010D\u001a\u00020!H\u0014J\b\u0010E\u001a\u00020!H\u0014J\u0010\u0010F\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e¨\u0006H"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter$CallBack;", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationDialog$NewRegistrationListener;", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/reregistration/ReRegistrationDialog$ReRegistrationListener;", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationDialog$EditRegistrationListener;", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationDialog$ViewRegistrationListener;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentRegistrationBinding;", "adapter", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter;", "getAdapter", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentRegistrationBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "reAdmission", "", "registrationViewModel", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationViewModel;", "getRegistrationViewModel", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationViewModel;", "registrationViewModel$delegate", "dismiss", "", "editBtnClicked", "id", "", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "printCertificate", "url", "requestPermission", "setUp", "showBaseView", "showProgress", "viewBtnClicked", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationFragment extends BaseFragment implements RegistrationAdapter.CallBack, NewRegistrationDialog.NewRegistrationListener, ReRegistrationDialog.ReRegistrationListener, EditRegistrationDialog.EditRegistrationListener, ViewRegistrationDialog.ViewRegistrationListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentRegistrationBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private MainCallBackListener listener;
    private boolean reAdmission;

    /* renamed from: registrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy registrationViewModel;

    @JvmStatic
    public static final RegistrationFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.ReRegistrationListener
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public RegistrationFragment() {
        final RegistrationFragment registrationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(registrationFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.registrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(registrationFragment, Reflection.getOrCreateKotlinClass(RegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(RegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final RegistrationFragment registrationFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RegistrationAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final RegistrationAdapter invoke() {
                ComponentCallbacks componentCallbacks = registrationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(RegistrationAdapter.class), b2, b3);
            }
        });
        this.downList = new ArrayList<>();
    }

    private final RegistrationViewModel getRegistrationViewModel() {
        return (RegistrationViewModel) this.registrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RegistrationAdapter getAdapter() {
        return (RegistrationAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentRegistrationBinding get_binding() {
        return this._binding;
    }

    /* compiled from: RegistrationFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RegistrationFragment newInstance() {
            return new RegistrationFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        FragmentRegistrationBinding fragmentRegistrationBinding = get_binding();
        if (fragmentRegistrationBinding != null) {
            fragmentRegistrationBinding.setRegistrationViewModel(getRegistrationViewModel());
        }
        FragmentRegistrationBinding fragmentRegistrationBinding2 = get_binding();
        if (fragmentRegistrationBinding2 != null) {
            fragmentRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentRegistrationBinding fragmentRegistrationBinding3 = get_binding();
        if (fragmentRegistrationBinding3 != null) {
            return fragmentRegistrationBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Registrations");
        }
        hideBaseView();
        FragmentRegistrationBinding fragmentRegistrationBinding = get_binding();
        RecyclerView recyclerView = fragmentRegistrationBinding != null ? fragmentRegistrationBinding.rvRegistration : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        getRegistrationViewModel().getRegistrationData();
        listenResponse();
        FragmentRegistrationBinding fragmentRegistrationBinding2 = get_binding();
        if (fragmentRegistrationBinding2 != null && (swipeRefreshLayout = fragmentRegistrationBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    RegistrationFragment.setUp$lambda$0(RegistrationFragment.this);
                }
            });
        }
        FragmentRegistrationBinding fragmentRegistrationBinding3 = get_binding();
        if (fragmentRegistrationBinding3 == null || (button = fragmentRegistrationBinding3.newRegistrationBtn) == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationFragment.setUp$lambda$1(RegistrationFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(RegistrationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getRegistrationViewModel().getRegistrationData();
        FragmentRegistrationBinding fragmentRegistrationBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentRegistrationBinding != null ? fragmentRegistrationBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(RegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        if (this$0.reAdmission) {
            ReRegistrationDialog.INSTANCE.newInstance().show(childFragmentManager, (String) null);
        } else {
            NewRegistrationDialog.INSTANCE.newInstance().show(childFragmentManager, (String) null);
        }
    }

    private final void listenResponse() {
        getRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new RegistrationFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends RegistrationResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$listenResponse$1

            /* compiled from: RegistrationFragment.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends RegistrationResponse> resource) {
                invoke2((Resource<RegistrationResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<RegistrationResponse> resource) {
                FragmentRegistrationBinding fragmentRegistrationBinding;
                Button button;
                RegistrationAdapter adapter;
                FragmentRegistrationBinding fragmentRegistrationBinding2;
                Button button2;
                FragmentRegistrationBinding fragmentRegistrationBinding3;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        RegistrationFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        RegistrationFragment.this.hideProgress();
                        RegistrationFragment.this.showBaseView();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    RegistrationFragment.this.hideProgress();
                    RegistrationFragment.this.showBaseView();
                    fragmentRegistrationBinding3 = RegistrationFragment.this.get_binding();
                    if (fragmentRegistrationBinding3 == null || (recyclerView = fragmentRegistrationBinding3.rvRegistration) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                RegistrationFragment.this.hideProgress();
                RegistrationResponse data = resource.getData();
                if (data != null) {
                    RegistrationFragment registrationFragment = RegistrationFragment.this;
                    registrationFragment.showBaseView();
                    try {
                        if (data.getRe_admission()) {
                            registrationFragment.reAdmission = data.getRe_admission();
                            fragmentRegistrationBinding2 = registrationFragment.get_binding();
                            if (fragmentRegistrationBinding2 != null && (button2 = fragmentRegistrationBinding2.newRegistrationBtn) != null) {
                                button2.setText("Re Registration");
                            }
                        } else {
                            registrationFragment.reAdmission = data.getRe_admission();
                            fragmentRegistrationBinding = registrationFragment.get_binding();
                            if (fragmentRegistrationBinding != null && (button = fragmentRegistrationBinding.newRegistrationBtn) != null) {
                                button.setText("New Registration");
                            }
                        }
                        adapter = registrationFragment.getAdapter();
                        adapter.addItems(data.getReg());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentRegistrationBinding fragmentRegistrationBinding = get_binding();
        if (fragmentRegistrationBinding == null || (recyclerView = fragmentRegistrationBinding.rvRegistration) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentRegistrationBinding fragmentRegistrationBinding = get_binding();
        if (fragmentRegistrationBinding == null || (recyclerView = fragmentRegistrationBinding.rvRegistration) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
        this.listener = null;
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RegistrationFragment.requestPermission$lambda$2(RegistrationFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$2(RegistrationFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            try {
                if (!(!(grantResults.length == 0)) || grantResults[0] != 0) {
                    if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                        Context requireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        new ValidChecker(requireContext).showPermissionDialog();
                    } else {
                        Toast.makeText(requireContext(), "Permission Denied, You cannot Upload Profile Image .", 0).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog.NewRegistrationListener, in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog.EditRegistrationListener, in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog.ViewRegistrationListener
    public void onDismiss() {
        getRegistrationViewModel().getRegistrationData();
    }

    @Override // in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter.CallBack
    public void editBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        EditRegistrationDialog.INSTANCE.newInstance(id).show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter.CallBack
    public void printCertificate(String url) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Intrinsics.areEqual(url, "")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            startActivity(Intent.createChooser(intent, "Open With"));
        } else {
            FragmentRegistrationBinding fragmentRegistrationBinding = get_binding();
            if (fragmentRegistrationBinding == null || (recyclerView = fragmentRegistrationBinding.rvRegistration) == null) {
                return;
            }
            ToastExtKt.showErrorToast(recyclerView, "not available right now");
        }
    }

    @Override // in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter.CallBack
    public void viewBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ViewRegistrationDialog.INSTANCE.newInstance(id).show(childFragmentManager, (String) null);
    }
}