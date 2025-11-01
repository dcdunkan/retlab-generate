package in.etuwa.app.ui.internship.completioncertificate;

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
import in.etuwa.app.databinding.CompletionCertificateDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.internship.InternshipFragment;
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

/* compiled from: CompletionCertificateDialog.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\u001a\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010*\u001a\u00020\u0015H\u0014J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0015H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/CompletionCertificateDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/CompletionCertificateDialogBinding;", "completionCertificateDialogViewModel", "Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialogViewModel;", "getCompletionCertificateDialogViewModel", "()Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialogViewModel;", "completionCertificateDialogViewModel$delegate", "Lkotlin/Lazy;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialog$UploadAssignmentCallBack;", "pickFile", "Ljava/io/File;", "hideProgress", "", "listenProgressResponse", "listenResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "setUploadCallBack", "context", "Lin/etuwa/app/ui/internship/InternshipFragment;", "showProgress", "Companion", "UploadAssignmentCallBack", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CompletionCertificateDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CompletionCertificateDialogBinding _binding;

    /* renamed from: completionCertificateDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy completionCertificateDialogViewModel;
    private String id;
    private UploadAssignmentCallBack listener;
    private File pickFile;

    /* compiled from: CompletionCertificateDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialog$UploadAssignmentCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface UploadAssignmentCallBack {
        void onDismiss();
    }

    /* compiled from: CompletionCertificateDialog.kt */
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
    public static final CompletionCertificateDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    public CompletionCertificateDialog() {
        final CompletionCertificateDialog completionCertificateDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(completionCertificateDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.completionCertificateDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(completionCertificateDialog, Reflection.getOrCreateKotlinClass(CompletionCertificateDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CompletionCertificateDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final CompletionCertificateDialogViewModel getCompletionCertificateDialogViewModel() {
        return (CompletionCertificateDialogViewModel) this.completionCertificateDialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final CompletionCertificateDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: CompletionCertificateDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CompletionCertificateDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            CompletionCertificateDialog completionCertificateDialog = new CompletionCertificateDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            completionCertificateDialog.setArguments(bundle);
            return completionCertificateDialog;
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
        this._binding = CompletionCertificateDialogBinding.inflate(inflater, container, false);
        CompletionCertificateDialogBinding completionCertificateDialogBinding = get_binding();
        if (completionCertificateDialogBinding != null) {
            completionCertificateDialogBinding.setCompletionCertificateDialogViewModel(getCompletionCertificateDialogViewModel());
        }
        CompletionCertificateDialogBinding completionCertificateDialogBinding2 = get_binding();
        if (completionCertificateDialogBinding2 != null) {
            completionCertificateDialogBinding2.setLifecycleOwner(this);
        }
        CompletionCertificateDialogBinding completionCertificateDialogBinding3 = get_binding();
        if (completionCertificateDialogBinding3 != null) {
            return completionCertificateDialogBinding3.getRoot();
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
        CompletionCertificateDialogBinding completionCertificateDialogBinding = get_binding();
        if (completionCertificateDialogBinding != null && (textView2 = completionCertificateDialogBinding.completionSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CompletionCertificateDialog.setUp$lambda$2(CompletionCertificateDialog.this, view);
                }
            });
        }
        CompletionCertificateDialogBinding completionCertificateDialogBinding2 = get_binding();
        if (completionCertificateDialogBinding2 == null || (textView = completionCertificateDialogBinding2.completionUpload) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompletionCertificateDialog.setUp$lambda$3(CompletionCertificateDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(CompletionCertificateDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(CompletionCertificateDialog this$0, View view) {
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
                if (file2.length() / 1024 <= 200) {
                    this$0.setCancelable(false);
                    CompletionCertificateDialogViewModel completionCertificateDialogViewModel = this$0.getCompletionCertificateDialogViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file3 = null;
                    }
                    completionCertificateDialogViewModel.uploadInternship(str, file3);
                    CompletionCertificateDialogBinding completionCertificateDialogBinding = this$0.get_binding();
                    LinearLayout linearLayout = completionCertificateDialogBinding != null ? completionCertificateDialogBinding.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    CompletionCertificateDialogBinding completionCertificateDialogBinding2 = this$0.get_binding();
                    LinearLayout linearLayout2 = completionCertificateDialogBinding2 != null ? completionCertificateDialogBinding2.progressView : null;
                    if (linearLayout2 == null) {
                        return;
                    }
                    linearLayout2.setVisibility(0);
                    return;
                }
                CompletionCertificateDialogBinding completionCertificateDialogBinding3 = this$0.get_binding();
                if (completionCertificateDialogBinding3 == null || (textView3 = completionCertificateDialogBinding3.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 200KB");
                return;
            }
            CompletionCertificateDialogBinding completionCertificateDialogBinding4 = this$0.get_binding();
            if (completionCertificateDialogBinding4 == null || (textView2 = completionCertificateDialogBinding4.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            CompletionCertificateDialogBinding completionCertificateDialogBinding5 = this$0.get_binding();
            if (completionCertificateDialogBinding5 == null || (textView = completionCertificateDialogBinding5.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    private final void listenResponse() {
        getCompletionCertificateDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CompletionCertificateDialog.listenResponse$lambda$5(CompletionCertificateDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(CompletionCertificateDialog this$0, Resource resource) {
        TextView completionFileName;
        TextView completionFileName2;
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
            CompletionCertificateDialogBinding completionCertificateDialogBinding = this$0.get_binding();
            if (completionCertificateDialogBinding != null && (textView = completionCertificateDialogBinding.completionFileName) != null) {
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
                CompletionCertificateDialogBinding completionCertificateDialogBinding2 = this$0.get_binding();
                if (completionCertificateDialogBinding2 != null && (completionFileName2 = completionCertificateDialogBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                UploadAssignmentCallBack uploadAssignmentCallBack2 = this$0.listener;
                if (uploadAssignmentCallBack2 != null) {
                    uploadAssignmentCallBack2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            CompletionCertificateDialogBinding completionCertificateDialogBinding3 = this$0.get_binding();
            if (completionCertificateDialogBinding3 != null && (completionFileName = completionCertificateDialogBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            UploadAssignmentCallBack uploadAssignmentCallBack3 = this$0.listener;
            if (uploadAssignmentCallBack3 != null) {
                uploadAssignmentCallBack3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getCompletionCertificateDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CompletionCertificateDialog.listenProgressResponse$lambda$7(CompletionCertificateDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$7(CompletionCertificateDialog this$0, Resource resource) {
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
            CompletionCertificateDialogBinding completionCertificateDialogBinding = this$0.get_binding();
            if (completionCertificateDialogBinding == null || (textView = completionCertificateDialogBinding.completionFileName) == null) {
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
            CompletionCertificateDialogBinding completionCertificateDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = completionCertificateDialogBinding2 != null ? completionCertificateDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            CompletionCertificateDialogBinding completionCertificateDialogBinding3 = this$0.get_binding();
            TextView textView2 = completionCertificateDialogBinding3 != null ? completionCertificateDialogBinding3.progressText : null;
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
                CompletionCertificateDialogBinding completionCertificateDialogBinding = get_binding();
                TextView textView = completionCertificateDialogBinding != null ? completionCertificateDialogBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        str2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        str2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + str2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, str);
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setUploadCallBack(InternshipFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
        CompletionCertificateDialogBinding completionCertificateDialogBinding = get_binding();
        ProgressBar progressBar = completionCertificateDialogBinding != null ? completionCertificateDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
        CompletionCertificateDialogBinding completionCertificateDialogBinding = get_binding();
        ProgressBar progressBar = completionCertificateDialogBinding != null ? completionCertificateDialogBinding.loader : null;
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