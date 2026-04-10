package in.etuwa.app.ui.leave.duty.directapply;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.forms.xfdf.XfdfConstants;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDirectApplyResponse;
import in.etuwa.app.databinding.FragmentDirectApplyBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.internship.VerifiedCertificateActivity;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter;
import in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog;
import in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog;
import in.etuwa.app.ui.leave.duty.directapply.viewproof.ViewProofDialog;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: DirectApplyFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class DirectApplyFragment extends BaseFragment implements DirectApplyAdapter.CallBack, ApplyDirectDutyLeaveDialog.NewDutyLeaveListener, UpdateHoursDirectDialog.NewDutyLeaveListener, ViewProofDialog.NewDutyLeaveListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentDirectApplyBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: directApplyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy directApplyViewModel;
    private ArrayList<DownloadModel> downList;
    private final BroadcastReceiver onDownloadComplete;

    /* JADX INFO: compiled from: DirectApplyFragment.kt */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteView$lambda$2(DialogInterface dialogInterface, int i) {
    }

    @JvmStatic
    public static final DirectApplyFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public DirectApplyFragment() {
        final DirectApplyFragment directApplyFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return directApplyFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(directApplyFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.directApplyViewModel = FragmentViewModelLazyKt.createViewModelLazy(directApplyFragment, Reflection.getOrCreateKotlinClass(DirectApplyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(DirectApplyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final DirectApplyFragment directApplyFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DirectApplyAdapter>() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DirectApplyAdapter invoke() {
                ComponentCallbacks componentCallbacks = directApplyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DirectApplyAdapter.class), b2, b3);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    ArrayList arrayList = this.this$0.downList;
                    DirectApplyFragment directApplyFragment3 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            directApplyFragment3.downList.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final DirectApplyViewModel getDirectApplyViewModel() {
        return (DirectApplyViewModel) this.directApplyViewModel.getValue();
    }

    private final DirectApplyAdapter getAdapter() {
        return (DirectApplyAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentDirectApplyBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: DirectApplyFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DirectApplyFragment newInstance() {
            return new DirectApplyFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentDirectApplyBinding.inflate(inflater, container, false);
        FragmentDirectApplyBinding fragmentDirectApplyBinding = get_binding();
        if (fragmentDirectApplyBinding != null) {
            fragmentDirectApplyBinding.setDirectApplyViewModel(getDirectApplyViewModel());
        }
        FragmentDirectApplyBinding fragmentDirectApplyBinding2 = get_binding();
        if (fragmentDirectApplyBinding2 != null) {
            fragmentDirectApplyBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentDirectApplyBinding fragmentDirectApplyBinding3 = get_binding();
        if (fragmentDirectApplyBinding3 != null) {
            return fragmentDirectApplyBinding3.getRoot();
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
        TextView textView;
        hideBaseView();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Direct Apply");
        }
        FragmentDirectApplyBinding fragmentDirectApplyBinding = get_binding();
        RecyclerView recyclerView = fragmentDirectApplyBinding != null ? fragmentDirectApplyBinding.rvDutyDirectLeave : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        listenDeleteResponse();
        getDirectApplyViewModel().getLeave();
        FragmentDirectApplyBinding fragmentDirectApplyBinding2 = get_binding();
        if (fragmentDirectApplyBinding2 == null || (textView = fragmentDirectApplyBinding2.applyLeaveBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DirectApplyFragment.setUp$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(DirectApplyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ApplyDirectDutyLeaveDialog applyDirectDutyLeaveDialogNewInstance = ApplyDirectDutyLeaveDialog.INSTANCE.newInstance("", "", "", "", "");
        applyDirectDutyLeaveDialogNewInstance.setCallBack(this$0);
        applyDirectDutyLeaveDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void deleteView(final String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Are you sure you want to delete?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DirectApplyFragment.deleteView$lambda$1(this.f$0, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DirectApplyFragment.deleteView$lambda$2(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteView$lambda$1(DirectApplyFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getDirectApplyViewModel().deleteLeave(id);
    }

    private final void listenResponse() {
        getDirectApplyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DirectApplyFragment.listenResponse$lambda$4(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(DirectApplyFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            DutyLeaveDirectApplyResponse dutyLeaveDirectApplyResponse = (DutyLeaveDirectApplyResponse) resource.getData();
            if (dutyLeaveDirectApplyResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(dutyLeaveDirectApplyResponse.getData());
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        FragmentDirectApplyBinding fragmentDirectApplyBinding = this$0.get_binding();
        if (fragmentDirectApplyBinding == null || (recyclerView = fragmentDirectApplyBinding.rvDutyDirectLeave) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenDeleteResponse() {
        getDirectApplyViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DirectApplyFragment.listenDeleteResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$6(DirectApplyFragment this$0, Resource resource) {
        RecyclerView rvDutyDirectLeave;
        RecyclerView rvDutyDirectLeave2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.hideBaseView();
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
            FragmentDirectApplyBinding fragmentDirectApplyBinding = this$0.get_binding();
            if (fragmentDirectApplyBinding == null || (recyclerView = fragmentDirectApplyBinding.rvDutyDirectLeave) == null) {
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
            this$0.showBaseView();
            if (successResponse.getLogin() && successResponse.getSuccess()) {
                FragmentDirectApplyBinding fragmentDirectApplyBinding2 = this$0.get_binding();
                if (fragmentDirectApplyBinding2 != null && (rvDutyDirectLeave2 = fragmentDirectApplyBinding2.rvDutyDirectLeave) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvDutyDirectLeave2, "rvDutyDirectLeave");
                    ToastExtKt.showSuccessToast(rvDutyDirectLeave2, successResponse.getMessage());
                }
                this$0.getDirectApplyViewModel().getLeave();
                return;
            }
            FragmentDirectApplyBinding fragmentDirectApplyBinding3 = this$0.get_binding();
            if (fragmentDirectApplyBinding3 == null || (rvDutyDirectLeave = fragmentDirectApplyBinding3.rvDutyDirectLeave) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvDutyDirectLeave, "rvDutyDirectLeave");
            ToastExtKt.showSuccessToast(rvDutyDirectLeave, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentDirectApplyBinding fragmentDirectApplyBinding = get_binding();
        if (fragmentDirectApplyBinding == null || (recyclerView = fragmentDirectApplyBinding.rvDutyDirectLeave) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentDirectApplyBinding fragmentDirectApplyBinding = get_binding();
        if (fragmentDirectApplyBinding == null || (recyclerView = fragmentDirectApplyBinding.rvDutyDirectLeave) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter.CallBack
    public void delete(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        deleteView(id);
    }

    @Override // in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter.CallBack
    public void viewProofBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        onViewDoc(id);
    }

    @Override // in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter.CallBack
    public void editBtnClicked(String id, String reason, String fromDate, String toDate, String head) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(head, "head");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ApplyDirectDutyLeaveDialog applyDirectDutyLeaveDialogNewInstance = ApplyDirectDutyLeaveDialog.INSTANCE.newInstance(id, reason, fromDate, toDate, head);
        applyDirectDutyLeaveDialogNewInstance.setCallBack(this);
        applyDirectDutyLeaveDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter.CallBack
    public void updateHoursClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        UpdateHoursDirectDialog updateHoursDirectDialogNewInstance = UpdateHoursDirectDialog.INSTANCE.newInstance(id);
        updateHoursDirectDialogNewInstance.setCallBack(this);
        updateHoursDirectDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog.NewDutyLeaveListener, in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog.NewDutyLeaveListener
    public void onDismiss() {
        getDirectApplyViewModel().getLeave();
    }

    public final void downloadFile(String url, int position, boolean flag) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        String str = flag ? AppConstant.INTERNSHIP_PATH : AppConstant.UPLOAD_INTERNSHIP_PATH;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(strReplace, flag)) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                new DownloadManagerHelper(contextRequireContext2).openFile(strReplace, str);
                return;
            }
            try {
                FragmentDirectApplyBinding fragmentDirectApplyBinding = get_binding();
                if (fragmentDirectApplyBinding != null && (recyclerView = fragmentDirectApplyBinding.rvDutyDirectLeave) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext3).startDownloading(str, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(jStartDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        requestPermission();
    }

    public final boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.INTERNSHIP_PATH);
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        return new ValidChecker(contextRequireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_INTERNSHIP_PATH);
    }

    public final void onViewDoc(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(getActivity(), (Class<?>) VerifiedCertificateActivity.class);
        intent.putExtra("url", url);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DirectApplyFragment.requestPermission$lambda$7(this.f$0, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$7(DirectApplyFragment this$0, DialogInterface dialogInterface, int i) {
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
                        Context contextRequireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        new ValidChecker(contextRequireContext).showPermissionDialog();
                    } else {
                        Toast.makeText(requireContext(), "Permission Denied, You cannot Upload Profile Image .", 0).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}