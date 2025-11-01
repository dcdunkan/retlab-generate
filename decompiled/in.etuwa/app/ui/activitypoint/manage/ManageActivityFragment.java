package in.etuwa.app.ui.activitypoint.manage;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.activitypoint.manage.ActivityBatch;
import in.etuwa.app.data.model.activitypoint.manage.ActivityBatchResponse;
import in.etuwa.app.databinding.ManageActivityFragmentBinding;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter;
import in.etuwa.app.ui.activitypoint.manage.proofFile.ProofFileDialog;
import in.etuwa.app.ui.base.BaseFragment;
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

/* compiled from: ManageActivityFragment.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00100\u001a\u00020\u001aH\u0002J\b\u00101\u001a\u00020\u001aH\u0014J\b\u00102\u001a\u00020\u001aH\u0014J\b\u00103\u001a\u00020\u001aH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u00065"}, d2 = {"Lin/etuwa/app/ui/activitypoint/manage/ManageActivityFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter$CallBack;", "Lin/etuwa/app/ui/activitypoint/manage/proofFile/ProofFileDialog$UploadAssignmentCallBack;", "()V", "REQUEST_CODE", "", "_binding", "Lin/etuwa/app/databinding/ManageActivityFragmentBinding;", "adapter", "Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter;", "getAdapter", "()Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ManageActivityFragmentBinding;", "manageActivityViewModel", "Lin/etuwa/app/ui/activitypoint/manage/ManageActivityViewModel;", "getManageActivityViewModel", "()Lin/etuwa/app/ui/activitypoint/manage/ManageActivityViewModel;", "manageActivityViewModel$delegate", "checkPermissions", "", "hideBaseView", "", "hideProgress", "listenHandleResponse", "listenResponse", "loadPickerDialog", "id", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteClick", "onDestroy", "onDismiss", "onPickDoc", "onRequestClick", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ManageActivityFragment extends BaseFragment implements ManageActivityAdapter.CallBack, ProofFileDialog.UploadAssignmentCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int REQUEST_CODE;
    private ManageActivityFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: manageActivityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy manageActivityViewModel;

    /* compiled from: ManageActivityFragment.kt */
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
    public static final ManageActivityFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ManageActivityFragment() {
        final ManageActivityFragment manageActivityFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(manageActivityFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.manageActivityViewModel = FragmentViewModelLazyKt.createViewModelLazy(manageActivityFragment, Reflection.getOrCreateKotlinClass(ManageActivityViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ManageActivityViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ManageActivityFragment manageActivityFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ManageActivityAdapter>() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ManageActivityAdapter invoke() {
                ComponentCallbacks componentCallbacks = manageActivityFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ManageActivityAdapter.class), b2, b3);
            }
        });
        this.REQUEST_CODE = 1;
    }

    private final ManageActivityViewModel getManageActivityViewModel() {
        return (ManageActivityViewModel) this.manageActivityViewModel.getValue();
    }

    private final ManageActivityAdapter getAdapter() {
        return (ManageActivityAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final ManageActivityFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ManageActivityFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/activitypoint/manage/ManageActivityFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/activitypoint/manage/ManageActivityFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ManageActivityFragment newInstance() {
            return new ManageActivityFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ManageActivityFragmentBinding.inflate(inflater, container, false);
        ManageActivityFragmentBinding manageActivityFragmentBinding = get_binding();
        if (manageActivityFragmentBinding != null) {
            manageActivityFragmentBinding.setManageActivityViewModel(getManageActivityViewModel());
        }
        ManageActivityFragmentBinding manageActivityFragmentBinding2 = get_binding();
        if (manageActivityFragmentBinding2 != null) {
            manageActivityFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ManageActivityFragmentBinding manageActivityFragmentBinding3 = get_binding();
        if (manageActivityFragmentBinding3 != null) {
            return manageActivityFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.manage_activities));
        }
        hideBaseView();
        ManageActivityFragmentBinding manageActivityFragmentBinding = get_binding();
        RecyclerView recyclerView = manageActivityFragmentBinding != null ? manageActivityFragmentBinding.rvManageActivityPoint : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        listenHandleResponse();
        ManageActivityFragmentBinding manageActivityFragmentBinding2 = get_binding();
        if (manageActivityFragmentBinding2 == null || (swipeRefreshLayout = manageActivityFragmentBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$$ExternalSyntheticLambda3
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ManageActivityFragment.setUp$lambda$0(ManageActivityFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ManageActivityFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getManageActivityViewModel().getActivities();
        ManageActivityFragmentBinding manageActivityFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = manageActivityFragmentBinding != null ? manageActivityFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getManageActivityViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ManageActivityFragment.listenResponse$lambda$2(ManageActivityFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(ManageActivityFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ActivityBatchResponse activityBatchResponse = (ActivityBatchResponse) resource.getData();
            if (activityBatchResponse != null) {
                this$0.showBaseView();
                ManageActivityAdapter adapter = this$0.getAdapter();
                ArrayList<ActivityBatch> activityBatch = activityBatchResponse.getActivityBatch();
                if (activityBatch == null) {
                    activityBatch = new ArrayList<>();
                }
                Context requireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                adapter.addItems(activityBatch, requireContext);
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
        ManageActivityFragmentBinding manageActivityFragmentBinding = this$0.get_binding();
        if (manageActivityFragmentBinding == null || (recyclerView = manageActivityFragmentBinding.rvManageActivityPoint) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenHandleResponse() {
        getManageActivityViewModel().getHandleResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ManageActivityFragment.listenHandleResponse$lambda$4(ManageActivityFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenHandleResponse$lambda$4(ManageActivityFragment this$0, Resource resource) {
        RecyclerView rvManageActivityPoint;
        RecyclerView rvManageActivityPoint2;
        RecyclerView rvManageActivityPoint3;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            ManageActivityFragmentBinding manageActivityFragmentBinding = this$0.get_binding();
            if (manageActivityFragmentBinding == null || (recyclerView = manageActivityFragmentBinding.rvManageActivityPoint) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getLogin()) {
                if (successResponse.getSuccess()) {
                    this$0.getManageActivityViewModel().getActivities();
                    ManageActivityFragmentBinding manageActivityFragmentBinding2 = this$0.get_binding();
                    if (manageActivityFragmentBinding2 == null || (rvManageActivityPoint3 = manageActivityFragmentBinding2.rvManageActivityPoint) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvManageActivityPoint3, "rvManageActivityPoint");
                    ToastExtKt.showSuccessToast(rvManageActivityPoint3, successResponse.getMessage());
                    return;
                }
                ManageActivityFragmentBinding manageActivityFragmentBinding3 = this$0.get_binding();
                if (manageActivityFragmentBinding3 == null || (rvManageActivityPoint2 = manageActivityFragmentBinding3.rvManageActivityPoint) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvManageActivityPoint2, "rvManageActivityPoint");
                ToastExtKt.showErrorToast(rvManageActivityPoint2, successResponse.getMessage());
                return;
            }
            ManageActivityFragmentBinding manageActivityFragmentBinding4 = this$0.get_binding();
            if (manageActivityFragmentBinding4 == null || (rvManageActivityPoint = manageActivityFragmentBinding4.rvManageActivityPoint) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvManageActivityPoint, "rvManageActivityPoint");
            ToastExtKt.showInfoToast(rvManageActivityPoint, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter.CallBack
    public void onRequestClick(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getManageActivityViewModel().requestActivities(id);
    }

    @Override // in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter.CallBack
    public void onDeleteClick(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getManageActivityViewModel().deleteRequestActivities(id);
    }

    @Override // in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter.CallBack
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            loadPickerDialog(id);
        } else {
            requestPermission();
        }
    }

    private final void loadPickerDialog(String id) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ProofFileDialog newInstance = ProofFileDialog.INSTANCE.newInstance(id);
        newInstance.setUploadCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
            new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ManageActivityFragment.requestPermission$lambda$5(ManageActivityFragment.this, dialogInterface, i);
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$5(ManageActivityFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this$0.REQUEST_CODE);
    }

    private final boolean checkPermissions() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_EXTERNAL_STORAGE");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        Log.d("Permissions", "Read Permission: " + checkSelfPermission + ", Write Permission: " + checkSelfPermission2);
        return checkSelfPermission == 0 && checkSelfPermission2 == 0;
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        ManageActivityFragmentBinding manageActivityFragmentBinding = get_binding();
        if (manageActivityFragmentBinding == null || (recyclerView = manageActivityFragmentBinding.rvManageActivityPoint) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        ManageActivityFragmentBinding manageActivityFragmentBinding = get_binding();
        if (manageActivityFragmentBinding == null || (recyclerView = manageActivityFragmentBinding.rvManageActivityPoint) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.activitypoint.manage.proofFile.ProofFileDialog.UploadAssignmentCallBack
    public void onDismiss() {
        getManageActivityViewModel().getActivities();
    }
}