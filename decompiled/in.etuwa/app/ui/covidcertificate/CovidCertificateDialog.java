package in.etuwa.app.ui.covidcertificate;

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
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.CovidCertificateDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
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

/* compiled from: CovidCertificateDialog.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\"\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0011H\u0014J\b\u0010&\u001a\u00020\u0011H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lin/etuwa/app/ui/covidcertificate/CovidCertificateDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/CovidCertificateDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/CovidCertificateDialogBinding;", "covidCertificateDialogViewModel", "Lin/etuwa/app/ui/covidcertificate/CovidCertificateDialogViewModel;", "getCovidCertificateDialogViewModel", "()Lin/etuwa/app/ui/covidcertificate/CovidCertificateDialogViewModel;", "covidCertificateDialogViewModel$delegate", "Lkotlin/Lazy;", "pickFile", "Ljava/io/File;", "hideProgress", "", "listenProgressResponse", "listenResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CovidCertificateDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CovidCertificateDialogBinding _binding;

    /* renamed from: covidCertificateDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy covidCertificateDialogViewModel;
    private File pickFile;

    /* compiled from: CovidCertificateDialog.kt */
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
    public static final CovidCertificateDialog newInstance() {
        return INSTANCE.newInstance();
    }

    public CovidCertificateDialog() {
        final CovidCertificateDialog covidCertificateDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(covidCertificateDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.covidCertificateDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(covidCertificateDialog, Reflection.getOrCreateKotlinClass(CovidCertificateDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CovidCertificateDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final CovidCertificateDialogViewModel getCovidCertificateDialogViewModel() {
        return (CovidCertificateDialogViewModel) this.covidCertificateDialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final CovidCertificateDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: CovidCertificateDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/covidcertificate/CovidCertificateDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/covidcertificate/CovidCertificateDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CovidCertificateDialog newInstance() {
            return new CovidCertificateDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CovidCertificateDialogBinding.inflate(inflater, container, false);
        CovidCertificateDialogBinding covidCertificateDialogBinding = get_binding();
        if (covidCertificateDialogBinding != null) {
            covidCertificateDialogBinding.setCovidCertificateDialogViewModel(getCovidCertificateDialogViewModel());
        }
        CovidCertificateDialogBinding covidCertificateDialogBinding2 = get_binding();
        if (covidCertificateDialogBinding2 != null) {
            covidCertificateDialogBinding2.setLifecycleOwner(this);
        }
        CovidCertificateDialogBinding covidCertificateDialogBinding3 = get_binding();
        if (covidCertificateDialogBinding3 != null) {
            return covidCertificateDialogBinding3.getRoot();
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
        CovidCertificateDialogBinding covidCertificateDialogBinding = get_binding();
        if (covidCertificateDialogBinding != null && (textView2 = covidCertificateDialogBinding.covidSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CovidCertificateDialog.setUp$lambda$1(CovidCertificateDialog.this, view);
                }
            });
        }
        CovidCertificateDialogBinding covidCertificateDialogBinding2 = get_binding();
        if (covidCertificateDialogBinding2 == null || (textView = covidCertificateDialogBinding2.covidUpload) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CovidCertificateDialog.setUp$lambda$2(CovidCertificateDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CovidCertificateDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(CovidCertificateDialog this$0, View view) {
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
                if ((file2.length() / j) / j <= 0.1d) {
                    this$0.setCancelable(false);
                    CovidCertificateDialogViewModel covidCertificateDialogViewModel = this$0.getCovidCertificateDialogViewModel();
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file3 = null;
                    }
                    covidCertificateDialogViewModel.uploadCovidCertificate(file3);
                    CovidCertificateDialogBinding covidCertificateDialogBinding = this$0.get_binding();
                    LinearLayout linearLayout = covidCertificateDialogBinding != null ? covidCertificateDialogBinding.covidCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    CovidCertificateDialogBinding covidCertificateDialogBinding2 = this$0.get_binding();
                    LinearLayout linearLayout2 = covidCertificateDialogBinding2 != null ? covidCertificateDialogBinding2.progressView : null;
                    if (linearLayout2 == null) {
                        return;
                    }
                    linearLayout2.setVisibility(0);
                    return;
                }
                CovidCertificateDialogBinding covidCertificateDialogBinding3 = this$0.get_binding();
                if (covidCertificateDialogBinding3 == null || (textView3 = covidCertificateDialogBinding3.covidSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 100kB");
                return;
            }
            CovidCertificateDialogBinding covidCertificateDialogBinding4 = this$0.get_binding();
            if (covidCertificateDialogBinding4 == null || (textView2 = covidCertificateDialogBinding4.covidSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            CovidCertificateDialogBinding covidCertificateDialogBinding5 = this$0.get_binding();
            if (covidCertificateDialogBinding5 == null || (textView = covidCertificateDialogBinding5.covidSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
        CovidCertificateDialogBinding covidCertificateDialogBinding = get_binding();
        ProgressBar progressBar = covidCertificateDialogBinding != null ? covidCertificateDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
        CovidCertificateDialogBinding covidCertificateDialogBinding = get_binding();
        ProgressBar progressBar = covidCertificateDialogBinding != null ? covidCertificateDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    private final void listenResponse() {
        getCovidCertificateDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CovidCertificateDialog.listenResponse$lambda$4(CovidCertificateDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(CovidCertificateDialog this$0, Resource resource) {
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
            CovidCertificateDialogBinding covidCertificateDialogBinding = this$0.get_binding();
            if (covidCertificateDialogBinding != null && (textView = covidCertificateDialogBinding.fileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                CovidCertificateDialogBinding covidCertificateDialogBinding2 = this$0.get_binding();
                if (covidCertificateDialogBinding2 != null && (fileName2 = covidCertificateDialogBinding2.fileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(fileName2, "fileName");
                    ToastExtKt.showSuccessToast(fileName2, successResponse.getMessage());
                }
                this$0.dismiss();
                return;
            }
            CovidCertificateDialogBinding covidCertificateDialogBinding3 = this$0.get_binding();
            if (covidCertificateDialogBinding3 != null && (fileName = covidCertificateDialogBinding3.fileName) != null) {
                Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                ToastExtKt.showErrorToast(fileName, successResponse.getMessage());
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getCovidCertificateDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CovidCertificateDialog.listenProgressResponse$lambda$6(CovidCertificateDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$6(CovidCertificateDialog this$0, Resource resource) {
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
            CovidCertificateDialogBinding covidCertificateDialogBinding = this$0.get_binding();
            if (covidCertificateDialogBinding == null || (textView = covidCertificateDialogBinding.fileName) == null) {
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
            CovidCertificateDialogBinding covidCertificateDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = covidCertificateDialogBinding2 != null ? covidCertificateDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            CovidCertificateDialogBinding covidCertificateDialogBinding3 = this$0.get_binding();
            TextView textView2 = covidCertificateDialogBinding3 != null ? covidCertificateDialogBinding3.progressText : null;
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
                CovidCertificateDialogBinding covidCertificateDialogBinding = get_binding();
                TextView textView = covidCertificateDialogBinding != null ? covidCertificateDialogBinding.fileName : null;
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}