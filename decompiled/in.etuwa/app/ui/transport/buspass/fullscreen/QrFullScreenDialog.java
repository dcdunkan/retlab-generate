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

/* JADX INFO: compiled from: QrFullScreenDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QrFullScreenDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogQrFullScreenBinding _binding;
    private ArrayList<DownloadModel> downList;
    private String downloadUrl;
    private MainCallBackListener listener;
    private final BroadcastReceiver onDownloadComplete;

    /* JADX INFO: renamed from: qrFullScreenViewModel$delegate, reason: from kotlin metadata */
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
                return qrFullScreenDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(QrFullScreenViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                TextView textView;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                DialogQrFullScreenBinding dialogQrFullScreenBinding = this.this$0.get_binding();
                if (dialogQrFullScreenBinding != null && (textView = dialogQrFullScreenBinding.qrDownloadBtn) != null) {
                    ToastExtKt.showInfoToast(textView, "Download Completed");
                }
                try {
                    ArrayList arrayList = this.this$0.downList;
                    QrFullScreenDialog qrFullScreenDialog2 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            qrFullScreenDialog2.downList.remove(new DownloadModel(downloadModel.getId(), i));
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
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogQrFullScreenBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: QrFullScreenDialog.kt */
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
            RequestCreator requestCreatorError = Picasso.get().load(this.url).placeholder(R.drawable.ic_user_profile).fit().error(R.drawable.ic_user_profile);
            DialogQrFullScreenBinding dialogQrFullScreenBinding = get_binding();
            ImageView imageView = dialogQrFullScreenBinding != null ? dialogQrFullScreenBinding.qrImageView : null;
            Intrinsics.checkNotNull(imageView);
            requestCreatorError.into(imageView);
        }
        DialogQrFullScreenBinding dialogQrFullScreenBinding2 = get_binding();
        if (dialogQrFullScreenBinding2 == null || (textView = dialogQrFullScreenBinding2.qrDownloadBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrFullScreenDialog.setUp$lambda$1(this.f$0, view);
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
        String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission()) {
            if (checkFileExistence(strReplace)) {
                DialogQrFullScreenBinding dialogQrFullScreenBinding = get_binding();
                if (dialogQrFullScreenBinding != null && (textView2 = dialogQrFullScreenBinding.qrDownloadBtn) != null) {
                    ToastExtKt.showInfoToast(textView2, "Download Started");
                }
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext2).startDownloading(AppConstant.BUSS_PASS_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(jStartDownloading, position));
                return;
            }
            try {
                DialogQrFullScreenBinding dialogQrFullScreenBinding2 = get_binding();
                if (dialogQrFullScreenBinding2 != null && (textView = dialogQrFullScreenBinding2.qrDownloadBtn) != null) {
                    ToastExtKt.showInfoToast(textView, "Download Started");
                }
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                long jStartDownloading2 = new DownloadManagerHelper(contextRequireContext3).startDownloading(AppConstant.BUSS_PASS_PATH, url);
                Context context2 = getContext();
                if (context2 != null) {
                    context2.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(jStartDownloading2, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
        new ValidChecker(contextRequireContext4).showPermissionDialog();
    }

    private final boolean checkFileExistence(String fileName) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.BUSS_PASS_PATH);
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