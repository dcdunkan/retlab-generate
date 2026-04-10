package in.etuwa.app.ui.homework.submit;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
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
import in.etuwa.app.databinding.SubmitHomeWorkDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.evaluation.EvaluationFragment;
import in.etuwa.app.ui.homework.HomeWorkFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: SubmitHomeWorkDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SubmitHomeWorkDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SubmitHomeWorkDialogBinding _binding;
    private String id;
    private SubmitHomeWorkCallBack listener;
    private File pickFile;

    /* JADX INFO: renamed from: submitHomeWorkDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy submitHomeWorkDialogViewModel;

    /* JADX INFO: compiled from: SubmitHomeWorkDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/homework/submit/SubmitHomeWorkDialog$SubmitHomeWorkCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubmitHomeWorkCallBack {
        void onDismiss();
    }

    /* JADX INFO: compiled from: SubmitHomeWorkDialog.kt */
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
    public static final SubmitHomeWorkDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    public SubmitHomeWorkDialog() {
        final SubmitHomeWorkDialog submitHomeWorkDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return submitHomeWorkDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(submitHomeWorkDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.submitHomeWorkDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(submitHomeWorkDialog, Reflection.getOrCreateKotlinClass(SubmitHomeWorkDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(SubmitHomeWorkDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final SubmitHomeWorkDialogViewModel getSubmitHomeWorkDialogViewModel() {
        return (SubmitHomeWorkDialogViewModel) this.submitHomeWorkDialogViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final SubmitHomeWorkDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: SubmitHomeWorkDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/homework/submit/SubmitHomeWorkDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/homework/submit/SubmitHomeWorkDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubmitHomeWorkDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            SubmitHomeWorkDialog submitHomeWorkDialog = new SubmitHomeWorkDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            submitHomeWorkDialog.setArguments(bundle);
            return submitHomeWorkDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SubmitHomeWorkDialogBinding.inflate(inflater, container, false);
        SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = get_binding();
        if (submitHomeWorkDialogBinding != null) {
            submitHomeWorkDialogBinding.setSubmitHomeWorkDialogViewModel(getSubmitHomeWorkDialogViewModel());
        }
        SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding2 = get_binding();
        if (submitHomeWorkDialogBinding2 != null) {
            submitHomeWorkDialogBinding2.setLifecycleOwner(this);
        }
        SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding3 = get_binding();
        if (submitHomeWorkDialogBinding3 != null) {
            return submitHomeWorkDialogBinding3.getRoot();
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
        SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = get_binding();
        if (submitHomeWorkDialogBinding != null && (textView2 = submitHomeWorkDialogBinding.hwSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubmitHomeWorkDialog.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding2 = get_binding();
        if (submitHomeWorkDialogBinding2 == null || (textView = submitHomeWorkDialogBinding2.hwUpload) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubmitHomeWorkDialog.setUp$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(SubmitHomeWorkDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(SubmitHomeWorkDialog this$0, View view) {
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
                    SubmitHomeWorkDialogViewModel submitHomeWorkDialogViewModel = this$0.getSubmitHomeWorkDialogViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file3 = null;
                    }
                    submitHomeWorkDialogViewModel.submitHomework(str, file3);
                    SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = this$0.get_binding();
                    LinearLayout linearLayout = submitHomeWorkDialogBinding != null ? submitHomeWorkDialogBinding.hwCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding2 = this$0.get_binding();
                    LinearLayout linearLayout2 = submitHomeWorkDialogBinding2 != null ? submitHomeWorkDialogBinding2.progressView : null;
                    if (linearLayout2 == null) {
                        return;
                    }
                    linearLayout2.setVisibility(0);
                    return;
                }
                SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding3 = this$0.get_binding();
                if (submitHomeWorkDialogBinding3 == null || (textView3 = submitHomeWorkDialogBinding3.hwSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 5MB");
                return;
            }
            SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding4 = this$0.get_binding();
            if (submitHomeWorkDialogBinding4 == null || (textView2 = submitHomeWorkDialogBinding4.hwSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding5 = this$0.get_binding();
            if (submitHomeWorkDialogBinding5 == null || (textView = submitHomeWorkDialogBinding5.hwSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    private final void listenResponse() {
        getSubmitHomeWorkDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubmitHomeWorkDialog.listenResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(SubmitHomeWorkDialog this$0, Resource resource) {
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
            SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = this$0.get_binding();
            if (submitHomeWorkDialogBinding != null && (textView = submitHomeWorkDialogBinding.fileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            SubmitHomeWorkCallBack submitHomeWorkCallBack = this$0.listener;
            if (submitHomeWorkCallBack != null) {
                submitHomeWorkCallBack.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding2 = this$0.get_binding();
                if (submitHomeWorkDialogBinding2 != null && (fileName2 = submitHomeWorkDialogBinding2.fileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(fileName2, "fileName");
                    ToastExtKt.showSuccessToast(fileName2, successResponse.getMessage());
                }
                SubmitHomeWorkCallBack submitHomeWorkCallBack2 = this$0.listener;
                if (submitHomeWorkCallBack2 != null) {
                    submitHomeWorkCallBack2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding3 = this$0.get_binding();
            if (submitHomeWorkDialogBinding3 != null && (fileName = submitHomeWorkDialogBinding3.fileName) != null) {
                Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                ToastExtKt.showErrorToast(fileName, successResponse.getMessage());
            }
            SubmitHomeWorkCallBack submitHomeWorkCallBack3 = this$0.listener;
            if (submitHomeWorkCallBack3 != null) {
                submitHomeWorkCallBack3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getSubmitHomeWorkDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubmitHomeWorkDialog.listenProgressResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$7(SubmitHomeWorkDialog this$0, Resource resource) {
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
            SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = this$0.get_binding();
            if (submitHomeWorkDialogBinding == null || (textView = submitHomeWorkDialogBinding.fileName) == null) {
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
            float fFloatValue = f.floatValue();
            SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = submitHomeWorkDialogBinding2 != null ? submitHomeWorkDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) fFloatValue);
            }
            SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding3 = this$0.get_binding();
            TextView textView2 = submitHomeWorkDialogBinding3 != null ? submitHomeWorkDialogBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) fFloatValue) + " %");
            }
            if (((int) fFloatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ContentResolver contentResolver;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        String fileName;
        ContentResolver contentResolver2;
        String fileName2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = get_binding();
                TextView textView = submitHomeWorkDialogBinding != null ? submitHomeWorkDialogBinding.fileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        fileName2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        fileName2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + fileName2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(parcelFileDescriptorOpenFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        fileName = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        fileName = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, fileName);
                    ByteStreamsKt.copyTo$default(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setSubmitHomeWorkCallBack(HomeWorkFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setSubmitHomeWorkCallBack(EvaluationFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
        SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = get_binding();
        ProgressBar progressBar = submitHomeWorkDialogBinding != null ? submitHomeWorkDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
        SubmitHomeWorkDialogBinding submitHomeWorkDialogBinding = get_binding();
        ProgressBar progressBar = submitHomeWorkDialogBinding != null ? submitHomeWorkDialogBinding.loader : null;
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