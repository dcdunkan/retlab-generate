package in.etuwa.app.ui.assignment.upload;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.UploadAssignmentDialogBinding;
import in.etuwa.app.ui.assignment.AssignmentFragment;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: UploadAssignmentDialog.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u000267B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\"\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016J\u001a\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010-\u001a\u00020\u0018H\u0014J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u00020\u0018H\u0014J\u0012\u00102\u001a\u00020\t*\u0002032\u0006\u00104\u001a\u000205R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u00068"}, d2 = {"Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/UploadAssignmentDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/UploadAssignmentDialogBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog$UploadAssignmentCallBack;", "pickFile", "Ljava/io/File;", "pickMedia", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/PickVisualMediaRequest;", "uploadAssignmentDialogViewModel", "Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialogViewModel;", "getUploadAssignmentDialogViewModel", "()Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialogViewModel;", "uploadAssignmentDialogViewModel$delegate", "Lkotlin/Lazy;", "hideProgress", "", "listenProgressResponse", "listenResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "setUploadCallBack", "context", "Lin/etuwa/app/ui/assignment/AssignmentFragment;", "showProgress", "getFileName", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "Companion", "UploadAssignmentCallBack", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UploadAssignmentDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UploadAssignmentDialogBinding _binding;
    private String id;
    private UploadAssignmentCallBack listener;
    private File pickFile;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;

    /* renamed from: uploadAssignmentDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy uploadAssignmentDialogViewModel;

    /* compiled from: UploadAssignmentDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog$UploadAssignmentCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface UploadAssignmentCallBack {
        void onDismiss();
    }

    /* compiled from: UploadAssignmentDialog.kt */
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
    public static final UploadAssignmentDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(Uri uri) {
    }

    public UploadAssignmentDialog() {
        final UploadAssignmentDialog uploadAssignmentDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(uploadAssignmentDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.uploadAssignmentDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(uploadAssignmentDialog, Reflection.getOrCreateKotlinClass(UploadAssignmentDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(UploadAssignmentDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final UploadAssignmentDialogViewModel getUploadAssignmentDialogViewModel() {
        return (UploadAssignmentDialogViewModel) this.uploadAssignmentDialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final UploadAssignmentDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: UploadAssignmentDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UploadAssignmentDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            UploadAssignmentDialog uploadAssignmentDialog = new UploadAssignmentDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            uploadAssignmentDialog.setArguments(bundle);
            return uploadAssignmentDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
        ActivityResultLauncher<PickVisualMediaRequest> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                UploadAssignmentDialog.onCreate$lambda$1((Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…dia()) { uri ->\n        }");
        this.pickMedia = registerForActivityResult;
        PickVisualMediaRequest PickVisualMediaRequest = PickVisualMediaRequestKt.PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE);
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher = this.pickMedia;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickMedia");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(PickVisualMediaRequest);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = UploadAssignmentDialogBinding.inflate(inflater, container, false);
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding = get_binding();
        if (uploadAssignmentDialogBinding != null) {
            uploadAssignmentDialogBinding.setUploadAssignmentDialogViewModel(getUploadAssignmentDialogViewModel());
        }
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = get_binding();
        if (uploadAssignmentDialogBinding2 != null) {
            uploadAssignmentDialogBinding2.setLifecycleOwner(this);
        }
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding3 = get_binding();
        if (uploadAssignmentDialogBinding3 != null) {
            return uploadAssignmentDialogBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        TextView textView;
        TextView textView2;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(128);
        }
        listenResponse();
        listenProgressResponse();
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding = get_binding();
        if (uploadAssignmentDialogBinding != null && (textView2 = uploadAssignmentDialogBinding.assiSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadAssignmentDialog.setUp$lambda$3(UploadAssignmentDialog.this, view);
                }
            });
        }
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = get_binding();
        if (uploadAssignmentDialogBinding2 == null || (textView = uploadAssignmentDialogBinding2.assiUpload) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadAssignmentDialog.setUp$lambda$4(UploadAssignmentDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(UploadAssignmentDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(UploadAssignmentDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            File file = this$0.pickFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file = null;
            }
            if (file.exists()) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                long j = 1024;
                if ((file2.length() / j) / j <= 5) {
                    this$0.setCancelable(false);
                    UploadAssignmentDialogViewModel uploadAssignmentDialogViewModel = this$0.getUploadAssignmentDialogViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file3 = null;
                    }
                    uploadAssignmentDialogViewModel.uploadAssignment(str, file3);
                    UploadAssignmentDialogBinding uploadAssignmentDialogBinding = this$0.get_binding();
                    LinearLayout linearLayout = uploadAssignmentDialogBinding != null ? uploadAssignmentDialogBinding.assiCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = this$0.get_binding();
                    LinearLayout linearLayout2 = uploadAssignmentDialogBinding2 != null ? uploadAssignmentDialogBinding2.progressView : null;
                    if (linearLayout2 == null) {
                        return;
                    }
                    linearLayout2.setVisibility(0);
                    return;
                }
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding3 = this$0.get_binding();
                if (uploadAssignmentDialogBinding3 == null || (textView3 = uploadAssignmentDialogBinding3.assiSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 5MB");
                return;
            }
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding4 = this$0.get_binding();
            if (uploadAssignmentDialogBinding4 == null || (textView2 = uploadAssignmentDialogBinding4.assiSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding5 = this$0.get_binding();
            if (uploadAssignmentDialogBinding5 == null || (textView = uploadAssignmentDialogBinding5.assiSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    private final void listenResponse() {
        getUploadAssignmentDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadAssignmentDialog.listenResponse$lambda$6(UploadAssignmentDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(UploadAssignmentDialog this$0, Resource resource) {
        TextView fileName;
        TextView fileName2;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding = this$0.get_binding();
            if (uploadAssignmentDialogBinding != null && (textView = uploadAssignmentDialogBinding.fileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            UploadAssignmentCallBack uploadAssignmentCallBack = this$0.listener;
            if (uploadAssignmentCallBack != null) {
                uploadAssignmentCallBack.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = this$0.get_binding();
                if (uploadAssignmentDialogBinding2 != null && (fileName2 = uploadAssignmentDialogBinding2.fileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(fileName2, "fileName");
                    ToastExtKt.showSuccessToast(fileName2, successResponse.getMessage());
                }
                UploadAssignmentCallBack uploadAssignmentCallBack2 = this$0.listener;
                if (uploadAssignmentCallBack2 != null) {
                    uploadAssignmentCallBack2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding3 = this$0.get_binding();
            if (uploadAssignmentDialogBinding3 != null && (fileName = uploadAssignmentDialogBinding3.fileName) != null) {
                Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                ToastExtKt.showErrorToast(fileName, successResponse.getMessage());
            }
            UploadAssignmentCallBack uploadAssignmentCallBack3 = this$0.listener;
            if (uploadAssignmentCallBack3 != null) {
                uploadAssignmentCallBack3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getUploadAssignmentDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadAssignmentDialog.listenProgressResponse$lambda$8(UploadAssignmentDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$8(UploadAssignmentDialog this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding = this$0.get_binding();
            if (uploadAssignmentDialogBinding == null || (textView = uploadAssignmentDialogBinding.fileName) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = uploadAssignmentDialogBinding2 != null ? uploadAssignmentDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding3 = this$0.get_binding();
            TextView textView2 = uploadAssignmentDialogBinding3 != null ? uploadAssignmentDialogBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        String str;
        ContentResolver contentResolver2;
        String str2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding = get_binding();
                TextView textView = uploadAssignmentDialogBinding != null ? uploadAssignmentDialogBinding.fileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        str2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        str2 = getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + str2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r")) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…riptor(it, \"r\") ?: return");
                    FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str = getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, str);
                    ByteStreamsKt.copyTo$default(fileInputStream, new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String getFileName(ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Cursor query = contentResolver.query(uri, null, null, null, null);
        if (query == null) {
            return "unknown_file";
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            int columnIndex = cursor2.getColumnIndex("_display_name");
            cursor2.moveToFirst();
            String string = cursor2.getString(columnIndex);
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(nameIndex)");
            CloseableKt.closeFinally(cursor, null);
            return string;
        } finally {
        }
    }

    public final void setUploadCallBack(AssignmentFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding = get_binding();
        ProgressBar progressBar = uploadAssignmentDialogBinding != null ? uploadAssignmentDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding = get_binding();
        ProgressBar progressBar = uploadAssignmentDialogBinding != null ? uploadAssignmentDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}