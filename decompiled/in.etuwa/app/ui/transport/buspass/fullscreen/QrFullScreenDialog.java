package in.etuwa.app.ui.transport.buspass.fullscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.databinding.DialogQrFullScreenBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
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

/* compiled from: QrFullScreenDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001cH\u0014J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010-\u001a\u00020\u001cH\u0016J\b\u0010.\u001a\u00020\u001cH\u0016J\u001a\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00101\u001a\u00020\u001cH\u0015J\b\u00102\u001a\u00020\u001cH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lin/etuwa/app/ui/transport/buspass/fullscreen/QrFullScreenDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogQrFullScreenBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogQrFullScreenBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "downloadUrl", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "qrFullScreenViewModel", "Lin/etuwa/app/ui/transport/buspass/fullscreen/QrFullScreenViewModel;", "getQrFullScreenViewModel", "()Lin/etuwa/app/ui/transport/buspass/fullscreen/QrFullScreenViewModel;", "qrFullScreenViewModel$delegate", "Lkotlin/Lazy;", "url", "checkFileExistence", "", "fileName", "dismiss", "", "downloadFile", CommonCssConstants.POSITION, "", "hideProgress", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrFullScreenDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogQrFullScreenBinding _binding;
    private ArrayList<DownloadModel> downList;
    private String downloadUrl;
    private MainCallBackListener listener;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: qrFullScreenViewModel$delegate, reason: from kotlin metadata */
    private final Lazy qrFullScreenViewModel;
    private String url;

    @JvmStatic
    public static final QrFullScreenDialog newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public QrFullScreenDialog() {
        final QrFullScreenDialog qrFullScreenDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(qrFullScreenDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.qrFullScreenViewModel = FragmentViewModelLazyKt.createViewModelLazy(qrFullScreenDialog, Reflection.getOrCreateKotlinClass(QrFullScreenViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(QrFullScreenViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                DialogQrFullScreenBinding dialogQrFullScreenBinding;
                ArrayList arrayList;
                ArrayList arrayList2;
                TextView textView;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                dialogQrFullScreenBinding = QrFullScreenDialog.this.get_binding();
                if (dialogQrFullScreenBinding != null && (textView = dialogQrFullScreenBinding.qrDownloadBtn) != null) {
                    ToastExtKt.showInfoToast(textView, "Download Completed");
                }
                try {
                    arrayList = QrFullScreenDialog.this.downList;
                    QrFullScreenDialog qrFullScreenDialog2 = QrFullScreenDialog.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            arrayList2 = qrFullScreenDialog2.downList;
                            arrayList2.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final QrFullScreenViewModel getQrFullScreenViewModel() {
        return (QrFullScreenViewModel) this.qrFullScreenViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogQrFullScreenBinding get_binding() {
        return this._binding;
    }

    /* compiled from: QrFullScreenDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/transport/buspass/fullscreen/QrFullScreenDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transport/buspass/fullscreen/QrFullScreenDialog;", "url", "", "downloadUrl", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final QrFullScreenDialog newInstance(String url, String downloadUrl) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
            QrFullScreenDialog qrFullScreenDialog = new QrFullScreenDialog();
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, downloadUrl);
            qrFullScreenDialog.setArguments(bundle);
            return qrFullScreenDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.url = arguments.getString("url");
            this.downloadUrl = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogQrFullScreenBinding.inflate(inflater, container, false);
        DialogQrFullScreenBinding dialogQrFullScreenBinding = get_binding();
        if (dialogQrFullScreenBinding != null) {
            dialogQrFullScreenBinding.setQrFullScreenViewModel(getQrFullScreenViewModel());
        }
        DialogQrFullScreenBinding dialogQrFullScreenBinding2 = get_binding();
        if (dialogQrFullScreenBinding2 != null) {
            dialogQrFullScreenBinding2.setLifecycleOwner(this);
        }
        DialogQrFullScreenBinding dialogQrFullScreenBinding3 = get_binding();
        if (dialogQrFullScreenBinding3 != null) {
            return dialogQrFullScreenBinding3.getRoot();
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
        if (!Intrinsics.areEqual(this.url, "")) {
            RequestCreator error = Picasso.get().load(this.url).placeholder(R.drawable.ic_user_profile).fit().error(R.drawable.ic_user_profile);
            DialogQrFullScreenBinding dialogQrFullScreenBinding = get_binding();
            ImageView imageView = dialogQrFullScreenBinding != null ? dialogQrFullScreenBinding.qrImageView : null;
            Intrinsics.checkNotNull(imageView);
            error.into(imageView);
        }
        DialogQrFullScreenBinding dialogQrFullScreenBinding2 = get_binding();
        if (dialogQrFullScreenBinding2 == null || (textView = dialogQrFullScreenBinding2.qrDownloadBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrFullScreenDialog.setUp$lambda$1(QrFullScreenDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(QrFullScreenDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this$0.downloadUrl));
        this$0.startActivity(Intent.createChooser(intent, "Open With"));
    }

    private final void downloadFile(String url, int position) {
        TextView textView;
        TextView textView2;
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission()) {
            if (checkFileExistence(replace)) {
                DialogQrFullScreenBinding dialogQrFullScreenBinding = get_binding();
                if (dialogQrFullScreenBinding != null && (textView2 = dialogQrFullScreenBinding.qrDownloadBtn) != null) {
                    ToastExtKt.showInfoToast(textView2, "Download Started");
                }
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext2).startDownloading(AppConstant.BUSS_PASS_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            }
            try {
                DialogQrFullScreenBinding dialogQrFullScreenBinding2 = get_binding();
                if (dialogQrFullScreenBinding2 != null && (textView = dialogQrFullScreenBinding2.qrDownloadBtn) != null) {
                    ToastExtKt.showInfoToast(textView, "Download Started");
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading2 = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.BUSS_PASS_PATH, url);
                Context context2 = getContext();
                if (context2 != null) {
                    context2.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(startDownloading2, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
        new ValidChecker(requireContext4).showPermissionDialog();
    }

    private final boolean checkFileExistence(String fileName) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.BUSS_PASS_PATH);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}