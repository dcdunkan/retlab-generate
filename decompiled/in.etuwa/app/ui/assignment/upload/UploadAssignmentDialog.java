package in.etuwa.app.ui.assignment.upload;

import android.app.Dialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FilenameUtils;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.UploadAssignmentDialogBinding;
import in.etuwa.app.ui.assignment.AssignmentFragment;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.evaluation.EvaluationFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: UploadAssignmentDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UploadAssignmentDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UploadAssignmentDialogBinding _binding;
    private final List<String> allowedExtensions;
    private Boolean flag;
    private String id;
    private UploadAssignmentCallBack listener;
    private File pickFile;
    private final ActivityResultLauncher<String[]> pickFileLauncher;

    /* JADX INFO: renamed from: uploadAssignmentDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy uploadAssignmentDialogViewModel;

    /* JADX INFO: compiled from: UploadAssignmentDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog$UploadAssignmentCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface UploadAssignmentCallBack {
        void onDismiss();
    }

    /* JADX INFO: compiled from: UploadAssignmentDialog.kt */
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
                iArr[Status.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final UploadAssignmentDialog newInstance(String str, boolean z) {
        return INSTANCE.newInstance(str, z);
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
                return uploadAssignmentDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(UploadAssignmentDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.allowedExtensions = CollectionsKt.listOf((Object[]) new String[]{"jpg", "jpeg", "pdf", "doc", "docx", "xls", "xlsx", "java", SvgConstants.Attributes.PATH_DATA_REL_CURVE_TO, "txt"});
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new ActivityResultCallback() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                UploadAssignmentDialog.pickFileLauncher$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…dlePickedFile(it) }\n    }");
        this.pickFileLauncher = activityResultLauncherRegisterForActivityResult;
    }

    private final UploadAssignmentDialogViewModel getUploadAssignmentDialogViewModel() {
        return (UploadAssignmentDialogViewModel) this.uploadAssignmentDialogViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final UploadAssignmentDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickFileLauncher$lambda$1(UploadAssignmentDialog this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uri != null) {
            this$0.handlePickedFile(uri);
        }
    }

    /* JADX INFO: compiled from: UploadAssignmentDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog;", "id", "", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UploadAssignmentDialog newInstance(String id, boolean flag) {
            Intrinsics.checkNotNullParameter(id, "id");
            UploadAssignmentDialog uploadAssignmentDialog = new UploadAssignmentDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("flag", flag);
            uploadAssignmentDialog.setArguments(bundle);
            return uploadAssignmentDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.id = arguments != null ? arguments.getString("id") : null;
        Bundle arguments2 = getArguments();
        this.flag = arguments2 != null ? Boolean.valueOf(arguments2.getBoolean("flag")) : null;
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
        EditText editText;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(128);
        }
        listenResponse();
        listenProgressResponse();
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding = get_binding();
        if (uploadAssignmentDialogBinding != null && (textView3 = uploadAssignmentDialogBinding.assiSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadAssignmentDialog.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        if (Intrinsics.areEqual((Object) this.flag, (Object) true)) {
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = get_binding();
            editText = uploadAssignmentDialogBinding2 != null ? uploadAssignmentDialogBinding2.linkInput : null;
            if (editText != null) {
                editText.setVisibility(0);
            }
        } else {
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding3 = get_binding();
            editText = uploadAssignmentDialogBinding3 != null ? uploadAssignmentDialogBinding3.linkInput : null;
            if (editText != null) {
                editText.setVisibility(8);
            }
        }
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding4 = get_binding();
        if (uploadAssignmentDialogBinding4 != null && (textView2 = uploadAssignmentDialogBinding4.assiDismiss) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadAssignmentDialog.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding5 = get_binding();
        if (uploadAssignmentDialogBinding5 == null || (textView = uploadAssignmentDialogBinding5.assiUpload) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadAssignmentDialog.setUp$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(UploadAssignmentDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pickFileLauncher.launch(new String[]{"*/*"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(UploadAssignmentDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void setUp$lambda$4(in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog r6, android.view.View r7) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog.setUp$lambda$4(in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog, android.view.View):void");
    }

    private final void handlePickedFile(Uri uri) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        try {
            ContentResolver contentResolver = requireContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "requireContext().contentResolver");
            String fileName = getFileName(contentResolver, uri);
            String lowerCase = StringsKt.substringAfterLast(fileName, FilenameUtils.EXTENSION_SEPARATOR, "").toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!this.allowedExtensions.contains(lowerCase)) {
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding = get_binding();
                if (uploadAssignmentDialogBinding == null || (textView3 = uploadAssignmentDialogBinding.assiSelect) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textView3, "Only files with these extensions are allowed: jpg, jpeg, pdf, doc, docx, xls, xlsx, java, c, txt.");
                return;
            }
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = requireContext().getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            File file = new File(requireContext().getCacheDir(), fileName);
            ByteStreamsKt.copyTo$default(fileInputStream, new FileOutputStream(file), 0, 2, null);
            if (!isFileSizeValid(file)) {
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = get_binding();
                if (uploadAssignmentDialogBinding2 == null || (textView2 = uploadAssignmentDialogBinding2.assiSelect) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textView2, "File size must be less than 1MB");
                return;
            }
            this.pickFile = file;
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding3 = get_binding();
            TextView textView4 = uploadAssignmentDialogBinding3 != null ? uploadAssignmentDialogBinding3.fileName : null;
            if (textView4 == null) {
                return;
            }
            textView4.setText("File : " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding4 = get_binding();
            if (uploadAssignmentDialogBinding4 == null || (textView = uploadAssignmentDialogBinding4.assiSelect) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Unable to process selected file");
        }
    }

    private final boolean isFileSizeValid(File file) {
        return file.length() <= 1048576;
    }

    public final String getFileName(ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return "unknown_file";
        }
        Cursor cursor = cursorQuery;
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

    private final void listenResponse() {
        getUploadAssignmentDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadAssignmentDialog.listenResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(UploadAssignmentDialog this$0, Resource resource) {
        TextView textView;
        LinearLayout linearLayout;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                this$0.hideProgress();
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding = this$0.get_binding();
                if (uploadAssignmentDialogBinding != null && (textView4 = uploadAssignmentDialogBinding.fileName) != null) {
                    TextView textView5 = textView4;
                    String message = resource.getMessage();
                    if (message == null) {
                        message = "Unknown error";
                    }
                    ToastExtKt.showErrorToast(textView5, message);
                }
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = this$0.get_binding();
                LinearLayout linearLayout2 = uploadAssignmentDialogBinding2 != null ? uploadAssignmentDialogBinding2.assiCard : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                UploadAssignmentDialogBinding uploadAssignmentDialogBinding3 = this$0.get_binding();
                linearLayout = uploadAssignmentDialogBinding3 != null ? uploadAssignmentDialogBinding3.progressView : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        this$0.hideProgress();
        Object data = resource.getData();
        Intrinsics.checkNotNull(data);
        SuccessResponse successResponse = (SuccessResponse) data;
        if (successResponse.getSuccess()) {
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding4 = this$0.get_binding();
            if (uploadAssignmentDialogBinding4 != null && (textView3 = uploadAssignmentDialogBinding4.fileName) != null) {
                ToastExtKt.showSuccessToast(textView3, successResponse.getMessage());
            }
            UploadAssignmentCallBack uploadAssignmentCallBack = this$0.listener;
            if (uploadAssignmentCallBack != null) {
                uploadAssignmentCallBack.onDismiss();
            }
            this$0.dismiss();
            return;
        }
        try {
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding5 = this$0.get_binding();
            if (uploadAssignmentDialogBinding5 != null && (textView2 = uploadAssignmentDialogBinding5.fileName) != null) {
                ToastExtKt.showErrorToast(textView2, successResponse.getError());
            }
        } catch (NullPointerException unused) {
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding6 = this$0.get_binding();
            if (uploadAssignmentDialogBinding6 != null && (textView = uploadAssignmentDialogBinding6.assiSelect) != null) {
                ToastExtKt.showErrorToast(textView, "Some error occurred");
            }
        }
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding7 = this$0.get_binding();
        LinearLayout linearLayout3 = uploadAssignmentDialogBinding7 != null ? uploadAssignmentDialogBinding7.assiCard : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        UploadAssignmentDialogBinding uploadAssignmentDialogBinding8 = this$0.get_binding();
        linearLayout = uploadAssignmentDialogBinding8 != null ? uploadAssignmentDialogBinding8.progressView : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    private final void listenProgressResponse() {
        getUploadAssignmentDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadAssignmentDialog.listenProgressResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$7(UploadAssignmentDialog this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (resource.getStatus() == Status.SUCCESS) {
            Object data = resource.getData();
            Intrinsics.checkNotNull(data);
            int iFloatValue = (int) ((Number) data).floatValue();
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding = this$0.get_binding();
            ProgressBar progressBar = uploadAssignmentDialogBinding != null ? uploadAssignmentDialogBinding.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress(iFloatValue);
            }
            UploadAssignmentDialogBinding uploadAssignmentDialogBinding2 = this$0.get_binding();
            TextView textView = uploadAssignmentDialogBinding2 != null ? uploadAssignmentDialogBinding2.progressText : null;
            if (textView != null) {
                textView.setText(iFloatValue + " %");
            }
            if (iFloatValue == 100) {
                this$0.showProgress();
            }
        }
    }

    public final void setUploadCallBack(AssignmentFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setUploadCallBack2(EvaluationFragment context) {
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