package in.etuwa.app.ui.exam.submit;

import android.app.Dialog;
import android.content.ComponentCallbacks;
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
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SubmitExamDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.exam.ExamListener;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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

/* compiled from: SubmitExamDialog.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\"\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010-\u001a\u00020\u001cH\u0016J\b\u0010.\u001a\u00020\u001cH\u0016J\u001a\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00101\u001a\u00020\u001cH\u0014J\u000e\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\rJ\b\u00104\u001a\u00020\u001cH\u0014J\b\u00105\u001a\u00020\u001cH\u0002J\b\u00106\u001a\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u00068"}, d2 = {"Lin/etuwa/app/ui/exam/submit/SubmitExamDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/SubmitExamDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/SubmitExamDialogBinding;", "examType", "", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/exam/ExamListener;", "pickFile", "Ljava/io/File;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "submitExamDialogViewModel", "Lin/etuwa/app/ui/exam/submit/SubmitExamDialogViewModel;", "getSubmitExamDialogViewModel", "()Lin/etuwa/app/ui/exam/submit/SubmitExamDialogViewModel;", "submitExamDialogViewModel$delegate", "hideProgress", "", "listenProgressResponse", "listenResponse", "onActivityResult", "requestCode", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "setUploadCallBack", "context", "showProgress", "uploadModuleExam", "uploadSeriesExam", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubmitExamDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SubmitExamDialogBinding _binding;
    private int examType;
    private String id;
    private ExamListener listener;
    private File pickFile;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: submitExamDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy submitExamDialogViewModel;

    /* compiled from: SubmitExamDialog.kt */
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
    public static final SubmitExamDialog newInstance(String str, int i) {
        return INSTANCE.newInstance(str, i);
    }

    public SubmitExamDialog() {
        final SubmitExamDialog submitExamDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(submitExamDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.submitExamDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(submitExamDialog, Reflection.getOrCreateKotlinClass(SubmitExamDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SubmitExamDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SubmitExamDialog submitExamDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = submitExamDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.examType = -1;
    }

    private final SubmitExamDialogViewModel getSubmitExamDialogViewModel() {
        return (SubmitExamDialogViewModel) this.submitExamDialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final SubmitExamDialogBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: SubmitExamDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/exam/submit/SubmitExamDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/exam/submit/SubmitExamDialog;", "id", "", "examType", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubmitExamDialog newInstance(String id, int examType) {
            Intrinsics.checkNotNullParameter(id, "id");
            SubmitExamDialog submitExamDialog = new SubmitExamDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putInt("type", examType);
            submitExamDialog.setArguments(bundle);
            return submitExamDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.examType = arguments.getInt("type");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SubmitExamDialogBinding.inflate(inflater, container, false);
        SubmitExamDialogBinding submitExamDialogBinding = get_binding();
        if (submitExamDialogBinding != null) {
            submitExamDialogBinding.setSubmitExamDialogViewModel(getSubmitExamDialogViewModel());
        }
        SubmitExamDialogBinding submitExamDialogBinding2 = get_binding();
        if (submitExamDialogBinding2 != null) {
            submitExamDialogBinding2.setLifecycleOwner(this);
        }
        SubmitExamDialogBinding submitExamDialogBinding3 = get_binding();
        if (submitExamDialogBinding3 != null) {
            return submitExamDialogBinding3.getRoot();
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
        TextView textView3;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(128);
        }
        getPreference().setNewLogin(false);
        if (this.examType == 0) {
            SubmitExamDialogBinding submitExamDialogBinding = get_binding();
            textView = submitExamDialogBinding != null ? submitExamDialogBinding.tvSizeLimit : null;
            if (textView != null) {
                textView.setText(getString(R.string.file_size_limit_is_20mb));
            }
        } else {
            SubmitExamDialogBinding submitExamDialogBinding2 = get_binding();
            textView = submitExamDialogBinding2 != null ? submitExamDialogBinding2.tvSizeLimit : null;
            if (textView != null) {
                textView.setText(getString(R.string.file_size_limit_is_5mb));
            }
        }
        listenResponse();
        listenProgressResponse();
        SubmitExamDialogBinding submitExamDialogBinding3 = get_binding();
        if (submitExamDialogBinding3 != null && (textView3 = submitExamDialogBinding3.examSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubmitExamDialog.setUp$lambda$2(SubmitExamDialog.this, view);
                }
            });
        }
        SubmitExamDialogBinding submitExamDialogBinding4 = get_binding();
        if (submitExamDialogBinding4 == null || (textView2 = submitExamDialogBinding4.examUpload) == null) {
            return;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubmitExamDialog.setUp$lambda$3(SubmitExamDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(SubmitExamDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(SubmitExamDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.examType == 0) {
            this$0.uploadSeriesExam();
        } else {
            this$0.uploadModuleExam();
        }
    }

    private final void uploadSeriesExam() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        try {
            File file = this.pickFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file = null;
            }
            if (file.exists()) {
                File file3 = this.pickFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file3 = null;
                }
                long j = 1024;
                if ((file3.length() / j) / j <= 20) {
                    setCancelable(false);
                    SubmitExamDialogBinding submitExamDialogBinding = get_binding();
                    LinearLayout linearLayout = submitExamDialogBinding != null ? submitExamDialogBinding.examCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    SubmitExamDialogBinding submitExamDialogBinding2 = get_binding();
                    LinearLayout linearLayout2 = submitExamDialogBinding2 != null ? submitExamDialogBinding2.progressView : null;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    SubmitExamDialogViewModel submitExamDialogViewModel = getSubmitExamDialogViewModel();
                    String str = this.id;
                    Intrinsics.checkNotNull(str);
                    File file4 = this.pickFile;
                    if (file4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    } else {
                        file2 = file4;
                    }
                    submitExamDialogViewModel.submitSeriesExam(str, file2);
                    return;
                }
                SubmitExamDialogBinding submitExamDialogBinding3 = get_binding();
                if (submitExamDialogBinding3 == null || (textView3 = submitExamDialogBinding3.examSelect) == null) {
                    return;
                }
                String string = getString(R.string.file_size_limit_is_20mb);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.file_size_limit_is_20mb)");
                ToastExtKt.showInfoToast(textView3, string);
                return;
            }
            SubmitExamDialogBinding submitExamDialogBinding4 = get_binding();
            if (submitExamDialogBinding4 == null || (textView2 = submitExamDialogBinding4.examSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            SubmitExamDialogBinding submitExamDialogBinding5 = get_binding();
            if (submitExamDialogBinding5 == null || (textView = submitExamDialogBinding5.examSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    private final void uploadModuleExam() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        try {
            File file = this.pickFile;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file = null;
            }
            if (file.exists()) {
                File file3 = this.pickFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file3 = null;
                }
                long j = 1024;
                if ((file3.length() / j) / j <= 5) {
                    setCancelable(false);
                    SubmitExamDialogBinding submitExamDialogBinding = get_binding();
                    LinearLayout linearLayout = submitExamDialogBinding != null ? submitExamDialogBinding.examCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    SubmitExamDialogBinding submitExamDialogBinding2 = get_binding();
                    LinearLayout linearLayout2 = submitExamDialogBinding2 != null ? submitExamDialogBinding2.progressView : null;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    SubmitExamDialogViewModel submitExamDialogViewModel = getSubmitExamDialogViewModel();
                    String str = this.id;
                    Intrinsics.checkNotNull(str);
                    File file4 = this.pickFile;
                    if (file4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    } else {
                        file2 = file4;
                    }
                    submitExamDialogViewModel.submitModuleTest(str, file2);
                    return;
                }
                SubmitExamDialogBinding submitExamDialogBinding3 = get_binding();
                if (submitExamDialogBinding3 == null || (textView3 = submitExamDialogBinding3.examSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 5MB");
                return;
            }
            SubmitExamDialogBinding submitExamDialogBinding4 = get_binding();
            if (submitExamDialogBinding4 == null || (textView2 = submitExamDialogBinding4.examSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            SubmitExamDialogBinding submitExamDialogBinding5 = get_binding();
            if (submitExamDialogBinding5 == null || (textView = submitExamDialogBinding5.examSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    private final void listenResponse() {
        getSubmitExamDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubmitExamDialog.listenResponse$lambda$5(SubmitExamDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(SubmitExamDialog this$0, Resource resource) {
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
            SubmitExamDialogBinding submitExamDialogBinding = this$0.get_binding();
            if (submitExamDialogBinding != null && (textView = submitExamDialogBinding.fileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            ExamListener examListener = this$0.listener;
            if (examListener != null) {
                examListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                SubmitExamDialogBinding submitExamDialogBinding2 = this$0.get_binding();
                if (submitExamDialogBinding2 != null && (fileName2 = submitExamDialogBinding2.fileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(fileName2, "fileName");
                    ToastExtKt.showSuccessToast(fileName2, successResponse.getMessage());
                }
                ExamListener examListener2 = this$0.listener;
                if (examListener2 != null) {
                    examListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            SubmitExamDialogBinding submitExamDialogBinding3 = this$0.get_binding();
            if (submitExamDialogBinding3 != null && (fileName = submitExamDialogBinding3.fileName) != null) {
                Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                ToastExtKt.showErrorToast(fileName, successResponse.getMessage());
            }
            ExamListener examListener3 = this$0.listener;
            if (examListener3 != null) {
                examListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getSubmitExamDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.submit.SubmitExamDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubmitExamDialog.listenProgressResponse$lambda$7(SubmitExamDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$7(SubmitExamDialog this$0, Resource resource) {
        TextView textView;
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
            SubmitExamDialogBinding submitExamDialogBinding = this$0.get_binding();
            if (submitExamDialogBinding == null || (textView = submitExamDialogBinding.fileName) == null) {
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
            SubmitExamDialogBinding submitExamDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = submitExamDialogBinding2 != null ? submitExamDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            SubmitExamDialogBinding submitExamDialogBinding3 = this$0.get_binding();
            TextView textView2 = submitExamDialogBinding3 != null ? submitExamDialogBinding3.progressText : null;
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
                SubmitExamDialogBinding submitExamDialogBinding = get_binding();
                TextView textView = submitExamDialogBinding != null ? submitExamDialogBinding.fileName : null;
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

    public final void setUploadCallBack(ExamListener context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
        SubmitExamDialogBinding submitExamDialogBinding = get_binding();
        ProgressBar progressBar = submitExamDialogBinding != null ? submitExamDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
        SubmitExamDialogBinding submitExamDialogBinding = get_binding();
        ProgressBar progressBar = submitExamDialogBinding != null ? submitExamDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}