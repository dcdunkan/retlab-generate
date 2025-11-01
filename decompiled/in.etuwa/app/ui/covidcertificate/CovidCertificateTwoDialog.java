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
import in.etuwa.app.databinding.CovidCertificateTwoDialogBinding;
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

/* compiled from: CovidCertificateTwoDialog.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\"\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0011H\u0014J\b\u0010&\u001a\u00020\u0011H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lin/etuwa/app/ui/covidcertificate/CovidCertificateTwoDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/CovidCertificateTwoDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/CovidCertificateTwoDialogBinding;", "covidCertificateTwoDialogViewModel", "Lin/etuwa/app/ui/covidcertificate/CovidCertificateTwoDialogViewModel;", "getCovidCertificateTwoDialogViewModel", "()Lin/etuwa/app/ui/covidcertificate/CovidCertificateTwoDialogViewModel;", "covidCertificateTwoDialogViewModel$delegate", "Lkotlin/Lazy;", "pickFile", "Ljava/io/File;", "hideProgress", "", "listenProgressResponse", "listenResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CovidCertificateTwoDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CovidCertificateTwoDialogBinding _binding;

    /* renamed from: covidCertificateTwoDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy covidCertificateTwoDialogViewModel;
    private File pickFile;

    /* compiled from: CovidCertificateTwoDialog.kt */
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
    public static final CovidCertificateTwoDialog newInstance() {
        return INSTANCE.newInstance();
    }

    public CovidCertificateTwoDialog() {
        final CovidCertificateTwoDialog covidCertificateTwoDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(covidCertificateTwoDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.covidCertificateTwoDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(covidCertificateTwoDialog, Reflection.getOrCreateKotlinClass(CovidCertificateTwoDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CovidCertificateTwoDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final CovidCertificateTwoDialogViewModel getCovidCertificateTwoDialogViewModel() {
        return (CovidCertificateTwoDialogViewModel) this.covidCertificateTwoDialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final CovidCertificateTwoDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: CovidCertificateTwoDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/covidcertificate/CovidCertificateTwoDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/covidcertificate/CovidCertificateTwoDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CovidCertificateTwoDialog newInstance() {
            return new CovidCertificateTwoDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CovidCertificateTwoDialogBinding.inflate(inflater, container, false);
        CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = get_binding();
        if (covidCertificateTwoDialogBinding != null) {
            covidCertificateTwoDialogBinding.setCovidCertificateTwoDialogViewModel(getCovidCertificateTwoDialogViewModel());
        }
        CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding2 = get_binding();
        if (covidCertificateTwoDialogBinding2 != null) {
            covidCertificateTwoDialogBinding2.setLifecycleOwner(this);
        }
        CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding3 = get_binding();
        if (covidCertificateTwoDialogBinding3 != null) {
            return covidCertificateTwoDialogBinding3.getRoot();
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
        CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = get_binding();
        if (covidCertificateTwoDialogBinding != null && (textView2 = covidCertificateTwoDialogBinding.covidSelectSecond) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CovidCertificateTwoDialog.setUp$lambda$1(CovidCertificateTwoDialog.this, view);
                }
            });
        }
        CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding2 = get_binding();
        if (covidCertificateTwoDialogBinding2 == null || (textView = covidCertificateTwoDialogBinding2.covidUploadSecond) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CovidCertificateTwoDialog.setUp$lambda$2(CovidCertificateTwoDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CovidCertificateTwoDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(CovidCertificateTwoDialog this$0, View view) {
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
                    CovidCertificateTwoDialogViewModel covidCertificateTwoDialogViewModel = this$0.getCovidCertificateTwoDialogViewModel();
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file3 = null;
                    }
                    covidCertificateTwoDialogViewModel.uploadCovidCertificateTwo(file3);
                    CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = this$0.get_binding();
                    LinearLayout linearLayout = covidCertificateTwoDialogBinding != null ? covidCertificateTwoDialogBinding.covidCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding2 = this$0.get_binding();
                    LinearLayout linearLayout2 = covidCertificateTwoDialogBinding2 != null ? covidCertificateTwoDialogBinding2.progressView : null;
                    if (linearLayout2 == null) {
                        return;
                    }
                    linearLayout2.setVisibility(0);
                    return;
                }
                CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding3 = this$0.get_binding();
                if (covidCertificateTwoDialogBinding3 == null || (textView3 = covidCertificateTwoDialogBinding3.covidSelectSecond) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 100kB");
                return;
            }
            CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding4 = this$0.get_binding();
            if (covidCertificateTwoDialogBinding4 == null || (textView2 = covidCertificateTwoDialogBinding4.covidSelectSecond) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding5 = this$0.get_binding();
            if (covidCertificateTwoDialogBinding5 == null || (textView = covidCertificateTwoDialogBinding5.covidSelectSecond) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
        CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = get_binding();
        ProgressBar progressBar = covidCertificateTwoDialogBinding != null ? covidCertificateTwoDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
        CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = get_binding();
        ProgressBar progressBar = covidCertificateTwoDialogBinding != null ? covidCertificateTwoDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    private final void listenResponse() {
        getCovidCertificateTwoDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CovidCertificateTwoDialog.listenResponse$lambda$4(CovidCertificateTwoDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(CovidCertificateTwoDialog this$0, Resource resource) {
        TextView fileNameSecond;
        TextView fileNameSecond2;
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
            CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = this$0.get_binding();
            if (covidCertificateTwoDialogBinding != null && (textView = covidCertificateTwoDialogBinding.fileNameSecond) != null) {
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
                CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding2 = this$0.get_binding();
                if (covidCertificateTwoDialogBinding2 != null && (fileNameSecond2 = covidCertificateTwoDialogBinding2.fileNameSecond) != null) {
                    Intrinsics.checkNotNullExpressionValue(fileNameSecond2, "fileNameSecond");
                    ToastExtKt.showSuccessToast(fileNameSecond2, successResponse.getMessage());
                }
                this$0.dismiss();
                return;
            }
            CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding3 = this$0.get_binding();
            if (covidCertificateTwoDialogBinding3 != null && (fileNameSecond = covidCertificateTwoDialogBinding3.fileNameSecond) != null) {
                Intrinsics.checkNotNullExpressionValue(fileNameSecond, "fileNameSecond");
                ToastExtKt.showErrorToast(fileNameSecond, successResponse.getMessage());
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getCovidCertificateTwoDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CovidCertificateTwoDialog.listenProgressResponse$lambda$6(CovidCertificateTwoDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$6(CovidCertificateTwoDialog this$0, Resource resource) {
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
            CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = this$0.get_binding();
            if (covidCertificateTwoDialogBinding == null || (textView = covidCertificateTwoDialogBinding.fileNameSecond) == null) {
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
            CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = covidCertificateTwoDialogBinding2 != null ? covidCertificateTwoDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding3 = this$0.get_binding();
            TextView textView2 = covidCertificateTwoDialogBinding3 != null ? covidCertificateTwoDialogBinding3.progressText : null;
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
                CovidCertificateTwoDialogBinding covidCertificateTwoDialogBinding = get_binding();
                TextView textView = covidCertificateTwoDialogBinding != null ? covidCertificateTwoDialogBinding.fileNameSecond : null;
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