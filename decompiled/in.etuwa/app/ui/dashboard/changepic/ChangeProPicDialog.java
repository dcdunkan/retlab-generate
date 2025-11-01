package in.etuwa.app.ui.dashboard.changepic;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.databinding.ChangeProPicDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ChangeProPicDialog.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\"\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020\u0019H\u0014J\b\u00101\u001a\u00020\u0019H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/ChangeProPicDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ChangeProPicDialogBinding;", "canProUpload", "", "canSignUpload", "changeProPicDialogViewModel", "Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialogViewModel;", "getChangeProPicDialogViewModel", "()Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialogViewModel;", "changeProPicDialogViewModel$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialog$ProfileCallBack;", "proFile", "Ljava/io/File;", "signFile", "uploadCount", "", "hideProgress", "", "listenProgressResponse", "listenResponse", "listenUploadResponse", "onActivityResult", "requestCode", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setProfileCallBack", "context", "Lin/etuwa/app/ui/dashboard/DashboardFragment;", "setUp", "showProgress", "Companion", "ProfileCallBack", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChangeProPicDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ChangeProPicDialogBinding _binding;
    private boolean canProUpload;
    private boolean canSignUpload;

    /* renamed from: changeProPicDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy changeProPicDialogViewModel;
    private ProfileCallBack listener;
    private File proFile;
    private File signFile;
    private int uploadCount;

    /* compiled from: ChangeProPicDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialog$ProfileCallBack;", "", "onDismissProfile", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProfileCallBack {
        void onDismissProfile();
    }

    /* compiled from: ChangeProPicDialog.kt */
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
    public static final ChangeProPicDialog newInstance() {
        return INSTANCE.newInstance();
    }

    public ChangeProPicDialog() {
        final ChangeProPicDialog changeProPicDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(changeProPicDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.changeProPicDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(changeProPicDialog, Reflection.getOrCreateKotlinClass(ChangeProPicDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ChangeProPicDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.canProUpload = true;
        this.canSignUpload = true;
    }

    private final ChangeProPicDialogViewModel getChangeProPicDialogViewModel() {
        return (ChangeProPicDialogViewModel) this.changeProPicDialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final ChangeProPicDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ChangeProPicDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChangeProPicDialog newInstance() {
            return new ChangeProPicDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ChangeProPicDialogBinding.inflate(inflater, container, false);
        ChangeProPicDialogBinding changeProPicDialogBinding = get_binding();
        if (changeProPicDialogBinding != null) {
            changeProPicDialogBinding.setChangeProPicDialogViewModel(getChangeProPicDialogViewModel());
        }
        ChangeProPicDialogBinding changeProPicDialogBinding2 = get_binding();
        if (changeProPicDialogBinding2 != null) {
            changeProPicDialogBinding2.setLifecycleOwner(this);
        }
        ChangeProPicDialogBinding changeProPicDialogBinding3 = get_binding();
        if (changeProPicDialogBinding3 != null) {
            return changeProPicDialogBinding3.getRoot();
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
        ImageView imageView;
        CircleImageView circleImageView;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(128);
        }
        listenResponse();
        listenUploadResponse();
        listenProgressResponse();
        ChangeProPicDialogBinding changeProPicDialogBinding = get_binding();
        if (changeProPicDialogBinding != null && (circleImageView = changeProPicDialogBinding.ivProPic) != null) {
            circleImageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChangeProPicDialog.setUp$lambda$1(ChangeProPicDialog.this, view);
                }
            });
        }
        ChangeProPicDialogBinding changeProPicDialogBinding2 = get_binding();
        if (changeProPicDialogBinding2 != null && (imageView = changeProPicDialogBinding2.ivSignature) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChangeProPicDialog.setUp$lambda$3(ChangeProPicDialog.this, view);
                }
            });
        }
        ChangeProPicDialogBinding changeProPicDialogBinding3 = get_binding();
        if (changeProPicDialogBinding3 == null || (textView = changeProPicDialogBinding3.submitBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeProPicDialog.setUp$lambda$4(ChangeProPicDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ChangeProPicDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ChangeProPicDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ChangeProPicDialog this$0, View view) {
        ImageView imageView;
        CircleImageView circleImageView;
        CircleImageView circleImageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.uploadCount = 0;
            File file = this$0.proFile;
            if (file != null) {
                this$0.uploadCount = 0 + 1;
                Intrinsics.checkNotNull(file);
                if (file.length() / 1024 > 100) {
                    this$0.canProUpload = false;
                    ChangeProPicDialogBinding changeProPicDialogBinding = this$0.get_binding();
                    if (changeProPicDialogBinding != null && (circleImageView2 = changeProPicDialogBinding.ivProPic) != null) {
                        ToastExtKt.showInfoToast(circleImageView2, "Profile File Size Limit Exceeds");
                    }
                }
            }
            File file2 = this$0.signFile;
            if (file2 != null) {
                this$0.uploadCount++;
                Intrinsics.checkNotNull(file2);
                if (file2.length() / 1024 > 30) {
                    this$0.canSignUpload = false;
                    ChangeProPicDialogBinding changeProPicDialogBinding2 = this$0.get_binding();
                    if (changeProPicDialogBinding2 != null && (circleImageView = changeProPicDialogBinding2.ivProPic) != null) {
                        ToastExtKt.showInfoToast(circleImageView, "Sign File Size Limit Exceeds");
                    }
                }
            }
            if (this$0.canProUpload || this$0.canSignUpload) {
                this$0.setCancelable(true);
                if (this$0.proFile != null) {
                    this$0.uploadCount--;
                    this$0.getChangeProPicDialogViewModel().uploadProPic(this$0.proFile);
                } else if (this$0.signFile != null) {
                    this$0.uploadCount--;
                    this$0.getChangeProPicDialogViewModel().uploadSignPic(this$0.signFile);
                }
                ChangeProPicDialogBinding changeProPicDialogBinding3 = this$0.get_binding();
                LinearLayout linearLayout = changeProPicDialogBinding3 != null ? changeProPicDialogBinding3.profileCard : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                ChangeProPicDialogBinding changeProPicDialogBinding4 = this$0.get_binding();
                LinearLayout linearLayout2 = changeProPicDialogBinding4 != null ? changeProPicDialogBinding4.progressView : null;
                if (linearLayout2 == null) {
                    return;
                }
                linearLayout2.setVisibility(0);
            }
        } catch (Exception unused) {
            ChangeProPicDialogBinding changeProPicDialogBinding5 = this$0.get_binding();
            if (changeProPicDialogBinding5 == null || (imageView = changeProPicDialogBinding5.ivSignature) == null) {
                return;
            }
            ToastExtKt.showInfoToast(imageView, "Please Select A File");
        }
    }

    private final void listenResponse() {
        getChangeProPicDialogViewModel().getDashResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChangeProPicDialog.listenResponse$lambda$6(ChangeProPicDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(ChangeProPicDialog this$0, Resource resource) {
        ImageView imageView;
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
            ChangeProPicDialogBinding changeProPicDialogBinding = this$0.get_binding();
            if (changeProPicDialogBinding == null || (imageView = changeProPicDialogBinding.ivSignature) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(imageView, message);
            return;
        }
        this$0.hideProgress();
        DashResponse dashResponse = (DashResponse) resource.getData();
        if (dashResponse != null) {
            try {
                RequestBuilder<Drawable> load = Glide.with(this$0.requireActivity()).load(dashResponse.getUrl());
                ChangeProPicDialogBinding changeProPicDialogBinding2 = this$0.get_binding();
                CircleImageView circleImageView = changeProPicDialogBinding2 != null ? changeProPicDialogBinding2.ivProPic : null;
                Intrinsics.checkNotNull(circleImageView);
                load.into(circleImageView);
                RequestBuilder<Drawable> load2 = Glide.with(this$0.requireActivity()).load(dashResponse.getUrlSign());
                ChangeProPicDialogBinding changeProPicDialogBinding3 = this$0.get_binding();
                ImageView imageView2 = changeProPicDialogBinding3 != null ? changeProPicDialogBinding3.ivSignature : null;
                Intrinsics.checkNotNull(imageView2);
                Intrinsics.checkNotNullExpressionValue(load2.into(imageView2), "{\n                      …                        }");
            } catch (Exception unused) {
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void listenUploadResponse() {
        getChangeProPicDialogViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChangeProPicDialog.listenUploadResponse$lambda$8(ChangeProPicDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUploadResponse$lambda$8(ChangeProPicDialog this$0, Resource resource) {
        LinearLayout linearLayout;
        ImageView ivSignature;
        ImageView ivSignature2;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                ChangeProPicDialogBinding changeProPicDialogBinding = this$0.get_binding();
                LinearLayout linearLayout2 = changeProPicDialogBinding != null ? changeProPicDialogBinding.progressView : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                ChangeProPicDialogBinding changeProPicDialogBinding2 = this$0.get_binding();
                linearLayout = changeProPicDialogBinding2 != null ? changeProPicDialogBinding2.profileCard : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            ChangeProPicDialogBinding changeProPicDialogBinding3 = this$0.get_binding();
            if (changeProPicDialogBinding3 != null && (imageView = changeProPicDialogBinding3.ivSignature) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(imageView, message);
            }
            ChangeProPicDialogBinding changeProPicDialogBinding4 = this$0.get_binding();
            LinearLayout linearLayout3 = changeProPicDialogBinding4 != null ? changeProPicDialogBinding4.progressView : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            ChangeProPicDialogBinding changeProPicDialogBinding5 = this$0.get_binding();
            linearLayout = changeProPicDialogBinding5 != null ? changeProPicDialogBinding5.profileCard : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                ChangeProPicDialogBinding changeProPicDialogBinding6 = this$0.get_binding();
                LinearLayout linearLayout4 = changeProPicDialogBinding6 != null ? changeProPicDialogBinding6.progressView : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                ChangeProPicDialogBinding changeProPicDialogBinding7 = this$0.get_binding();
                linearLayout = changeProPicDialogBinding7 != null ? changeProPicDialogBinding7.profileCard : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                int i2 = this$0.uploadCount;
                if (i2 != 0) {
                    this$0.uploadCount = i2 - 1;
                    this$0.getChangeProPicDialogViewModel().uploadSignPic(this$0.signFile);
                    return;
                }
                ChangeProPicDialogBinding changeProPicDialogBinding8 = this$0.get_binding();
                if (changeProPicDialogBinding8 != null && (ivSignature2 = changeProPicDialogBinding8.ivSignature) != null) {
                    Intrinsics.checkNotNullExpressionValue(ivSignature2, "ivSignature");
                    ToastExtKt.showSuccessToast(ivSignature2, successResponse.getMessage());
                }
                ProfileCallBack profileCallBack = this$0.listener;
                if (profileCallBack != null) {
                    profileCallBack.onDismissProfile();
                }
                this$0.dismiss();
                return;
            }
            ChangeProPicDialogBinding changeProPicDialogBinding9 = this$0.get_binding();
            LinearLayout linearLayout5 = changeProPicDialogBinding9 != null ? changeProPicDialogBinding9.progressView : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            ChangeProPicDialogBinding changeProPicDialogBinding10 = this$0.get_binding();
            linearLayout = changeProPicDialogBinding10 != null ? changeProPicDialogBinding10.profileCard : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            ChangeProPicDialogBinding changeProPicDialogBinding11 = this$0.get_binding();
            if (changeProPicDialogBinding11 == null || (ivSignature = changeProPicDialogBinding11.ivSignature) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(ivSignature, "ivSignature");
            ToastExtKt.showErrorToast(ivSignature, successResponse.getError());
        }
    }

    private final void listenProgressResponse() {
        getChangeProPicDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChangeProPicDialog.listenProgressResponse$lambda$10(ChangeProPicDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$10(ChangeProPicDialog this$0, Resource resource) {
        ImageView imageView;
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
            ChangeProPicDialogBinding changeProPicDialogBinding = this$0.get_binding();
            if (changeProPicDialogBinding == null || (imageView = changeProPicDialogBinding.ivSignature) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(imageView, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            ChangeProPicDialogBinding changeProPicDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = changeProPicDialogBinding2 != null ? changeProPicDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            ChangeProPicDialogBinding changeProPicDialogBinding3 = this$0.get_binding();
            TextView textView = changeProPicDialogBinding3 != null ? changeProPicDialogBinding3.progressText : null;
            if (textView != null) {
                textView.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a0 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f A[Catch: Exception -> 0x01b4, TryCatch #0 {Exception -> 0x01b4, blocks: (B:5:0x000c, B:9:0x0032, B:11:0x0038, B:13:0x003e, B:15:0x0046, B:20:0x0052, B:23:0x0069, B:25:0x006f, B:27:0x0075, B:32:0x007c, B:34:0x0087, B:35:0x008d, B:37:0x0093, B:39:0x0099, B:40:0x00a2, B:42:0x00d4, B:43:0x00d6, B:49:0x005a, B:52:0x0061, B:55:0x00e1, B:57:0x00e7, B:59:0x00eb, B:64:0x00f5, B:66:0x00fb, B:68:0x0101, B:70:0x0109, B:75:0x0115, B:78:0x012c, B:80:0x0132, B:82:0x0138, B:86:0x013f, B:88:0x014a, B:89:0x0150, B:91:0x0156, B:93:0x015c, B:94:0x0165, B:96:0x0197, B:97:0x0199, B:103:0x011d, B:106:0x0124, B:109:0x01a1, B:111:0x01a7, B:113:0x01ab), top: B:4:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087 A[Catch: Exception -> 0x01b4, TryCatch #0 {Exception -> 0x01b4, blocks: (B:5:0x000c, B:9:0x0032, B:11:0x0038, B:13:0x003e, B:15:0x0046, B:20:0x0052, B:23:0x0069, B:25:0x006f, B:27:0x0075, B:32:0x007c, B:34:0x0087, B:35:0x008d, B:37:0x0093, B:39:0x0099, B:40:0x00a2, B:42:0x00d4, B:43:0x00d6, B:49:0x005a, B:52:0x0061, B:55:0x00e1, B:57:0x00e7, B:59:0x00eb, B:64:0x00f5, B:66:0x00fb, B:68:0x0101, B:70:0x0109, B:75:0x0115, B:78:0x012c, B:80:0x0132, B:82:0x0138, B:86:0x013f, B:88:0x014a, B:89:0x0150, B:91:0x0156, B:93:0x015c, B:94:0x0165, B:96:0x0197, B:97:0x0199, B:103:0x011d, B:106:0x0124, B:109:0x01a1, B:111:0x01a7, B:113:0x01ab), top: B:4:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4 A[Catch: Exception -> 0x01b4, TryCatch #0 {Exception -> 0x01b4, blocks: (B:5:0x000c, B:9:0x0032, B:11:0x0038, B:13:0x003e, B:15:0x0046, B:20:0x0052, B:23:0x0069, B:25:0x006f, B:27:0x0075, B:32:0x007c, B:34:0x0087, B:35:0x008d, B:37:0x0093, B:39:0x0099, B:40:0x00a2, B:42:0x00d4, B:43:0x00d6, B:49:0x005a, B:52:0x0061, B:55:0x00e1, B:57:0x00e7, B:59:0x00eb, B:64:0x00f5, B:66:0x00fb, B:68:0x0101, B:70:0x0109, B:75:0x0115, B:78:0x012c, B:80:0x0132, B:82:0x0138, B:86:0x013f, B:88:0x014a, B:89:0x0150, B:91:0x0156, B:93:0x015c, B:94:0x0165, B:96:0x0197, B:97:0x0199, B:103:0x011d, B:106:0x0124, B:109:0x01a1, B:111:0x01a7, B:113:0x01ab), top: B:4:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e0 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0132 A[Catch: Exception -> 0x01b4, TryCatch #0 {Exception -> 0x01b4, blocks: (B:5:0x000c, B:9:0x0032, B:11:0x0038, B:13:0x003e, B:15:0x0046, B:20:0x0052, B:23:0x0069, B:25:0x006f, B:27:0x0075, B:32:0x007c, B:34:0x0087, B:35:0x008d, B:37:0x0093, B:39:0x0099, B:40:0x00a2, B:42:0x00d4, B:43:0x00d6, B:49:0x005a, B:52:0x0061, B:55:0x00e1, B:57:0x00e7, B:59:0x00eb, B:64:0x00f5, B:66:0x00fb, B:68:0x0101, B:70:0x0109, B:75:0x0115, B:78:0x012c, B:80:0x0132, B:82:0x0138, B:86:0x013f, B:88:0x014a, B:89:0x0150, B:91:0x0156, B:93:0x015c, B:94:0x0165, B:96:0x0197, B:97:0x0199, B:103:0x011d, B:106:0x0124, B:109:0x01a1, B:111:0x01a7, B:113:0x01ab), top: B:4:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014a A[Catch: Exception -> 0x01b4, TryCatch #0 {Exception -> 0x01b4, blocks: (B:5:0x000c, B:9:0x0032, B:11:0x0038, B:13:0x003e, B:15:0x0046, B:20:0x0052, B:23:0x0069, B:25:0x006f, B:27:0x0075, B:32:0x007c, B:34:0x0087, B:35:0x008d, B:37:0x0093, B:39:0x0099, B:40:0x00a2, B:42:0x00d4, B:43:0x00d6, B:49:0x005a, B:52:0x0061, B:55:0x00e1, B:57:0x00e7, B:59:0x00eb, B:64:0x00f5, B:66:0x00fb, B:68:0x0101, B:70:0x0109, B:75:0x0115, B:78:0x012c, B:80:0x0132, B:82:0x0138, B:86:0x013f, B:88:0x014a, B:89:0x0150, B:91:0x0156, B:93:0x015c, B:94:0x0165, B:96:0x0197, B:97:0x0199, B:103:0x011d, B:106:0x0124, B:109:0x01a1, B:111:0x01a7, B:113:0x01ab), top: B:4:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0197 A[Catch: Exception -> 0x01b4, TryCatch #0 {Exception -> 0x01b4, blocks: (B:5:0x000c, B:9:0x0032, B:11:0x0038, B:13:0x003e, B:15:0x0046, B:20:0x0052, B:23:0x0069, B:25:0x006f, B:27:0x0075, B:32:0x007c, B:34:0x0087, B:35:0x008d, B:37:0x0093, B:39:0x0099, B:40:0x00a2, B:42:0x00d4, B:43:0x00d6, B:49:0x005a, B:52:0x0061, B:55:0x00e1, B:57:0x00e7, B:59:0x00eb, B:64:0x00f5, B:66:0x00fb, B:68:0x0101, B:70:0x0109, B:75:0x0115, B:78:0x012c, B:80:0x0132, B:82:0x0138, B:86:0x013f, B:88:0x014a, B:89:0x0150, B:91:0x0156, B:93:0x015c, B:94:0x0165, B:96:0x0197, B:97:0x0199, B:103:0x011d, B:106:0x0124, B:109:0x01a1, B:111:0x01a7, B:113:0x01ab), top: B:4:0x000c }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r17, int r18, android.content.Intent r19) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void setProfileCallBack(DashboardFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
        ChangeProPicDialogBinding changeProPicDialogBinding = get_binding();
        ProgressBar progressBar = changeProPicDialogBinding != null ? changeProPicDialogBinding.loader : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
        ChangeProPicDialogBinding changeProPicDialogBinding = get_binding();
        ProgressBar progressBar = changeProPicDialogBinding != null ? changeProPicDialogBinding.loader : null;
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