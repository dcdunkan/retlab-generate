package in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.hostel.attendance.HostelScanViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogSecurityQrBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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

/* compiled from: SecurityQrDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001eJ\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001eJ\b\u0010%\u001a\u00020\"H\u0014J\b\u0010&\u001a\u00020\"H\u0002J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00100\u001a\u00020\"H\u0016J\u001a\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0014J\b\u00105\u001a\u00020\"H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/viewleave/qrdialog/SecurityQrDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogSecurityQrBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogSecurityQrBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "downloadUrl", "", "id", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "securityQrViewModel", "Lin/etuwa/app/ui/hostel/attendance/viewleave/qrdialog/SecurityQrViewModel;", "getSecurityQrViewModel", "()Lin/etuwa/app/ui/hostel/attendance/viewleave/qrdialog/SecurityQrViewModel;", "securityQrViewModel$delegate", "url", "checkFileExistence", "", "fileName", "flag", "downloadFile", "", CommonCssConstants.POSITION, "", "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SecurityQrDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogSecurityQrBinding _binding;
    private ArrayList<DownloadModel> downList;
    private String downloadUrl;
    private String id;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: securityQrViewModel$delegate, reason: from kotlin metadata */
    private final Lazy securityQrViewModel;
    private String url;

    /* compiled from: SecurityQrDialog.kt */
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
    public static final SecurityQrDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public SecurityQrDialog() {
        final SecurityQrDialog securityQrDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(securityQrDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.securityQrViewModel = FragmentViewModelLazyKt.createViewModelLazy(securityQrDialog, Reflection.getOrCreateKotlinClass(SecurityQrViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SecurityQrViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SecurityQrDialog securityQrDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = securityQrDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = SecurityQrDialog.this.downList;
                    SecurityQrDialog securityQrDialog3 = SecurityQrDialog.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            arrayList2 = securityQrDialog3.downList;
                            arrayList2.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final SecurityQrViewModel getSecurityQrViewModel() {
        return (SecurityQrViewModel) this.securityQrViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogSecurityQrBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: SecurityQrDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/viewleave/qrdialog/SecurityQrDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/attendance/viewleave/qrdialog/SecurityQrDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SecurityQrDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            SecurityQrDialog securityQrDialog = new SecurityQrDialog();
            Bundle bundle = new Bundle();
            bundle.putString(HostelFeeConfirmFragmentKt.ARG_MONTHS, id);
            securityQrDialog.setArguments(bundle);
            return securityQrDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString(HostelFeeConfirmFragmentKt.ARG_MONTHS);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogSecurityQrBinding.inflate(inflater, container, false);
        DialogSecurityQrBinding dialogSecurityQrBinding = get_binding();
        if (dialogSecurityQrBinding != null) {
            dialogSecurityQrBinding.setSecurityQrViewModel(getSecurityQrViewModel());
        }
        DialogSecurityQrBinding dialogSecurityQrBinding2 = get_binding();
        if (dialogSecurityQrBinding2 != null) {
            dialogSecurityQrBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogSecurityQrBinding dialogSecurityQrBinding3 = get_binding();
        if (dialogSecurityQrBinding3 != null) {
            return dialogSecurityQrBinding3.getRoot();
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
        getPreference().setNewLogin(false);
        SecurityQrViewModel securityQrViewModel = getSecurityQrViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        securityQrViewModel.getHostelGatePassView(str);
        listenResponse();
        DialogSecurityQrBinding dialogSecurityQrBinding = get_binding();
        if (dialogSecurityQrBinding == null || (textView = dialogSecurityQrBinding.downloadBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecurityQrDialog.setUp$lambda$1(SecurityQrDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SecurityQrDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.downloadUrl;
        Intrinsics.checkNotNull(str);
        String str2 = this$0.id;
        Intrinsics.checkNotNull(str2);
        this$0.downloadFile(str, Integer.parseInt(str2), false);
    }

    private final void listenResponse() {
        getSecurityQrViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SecurityQrDialog.listenResponse$lambda$3(SecurityQrDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(SecurityQrDialog this$0, Resource resource) {
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
            DialogSecurityQrBinding dialogSecurityQrBinding = this$0.get_binding();
            if (dialogSecurityQrBinding == null || (imageView = dialogSecurityQrBinding.bpQr) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(imageView, message);
            return;
        }
        this$0.hideProgress();
        HostelScanViewResponse hostelScanViewResponse = (HostelScanViewResponse) resource.getData();
        if (hostelScanViewResponse != null) {
            if (hostelScanViewResponse.getLogin()) {
                DialogSecurityQrBinding dialogSecurityQrBinding2 = this$0.get_binding();
                TextView textView = dialogSecurityQrBinding2 != null ? dialogSecurityQrBinding2.bpName : null;
                if (textView != null) {
                    textView.setText(hostelScanViewResponse.getName());
                }
                DialogSecurityQrBinding dialogSecurityQrBinding3 = this$0.get_binding();
                TextView textView2 = dialogSecurityQrBinding3 != null ? dialogSecurityQrBinding3.roomNoTv : null;
                if (textView2 != null) {
                    textView2.setText(hostelScanViewResponse.getRoom());
                }
                DialogSecurityQrBinding dialogSecurityQrBinding4 = this$0.get_binding();
                TextView textView3 = dialogSecurityQrBinding4 != null ? dialogSecurityQrBinding4.addressTv : null;
                if (textView3 != null) {
                    textView3.setText(hostelScanViewResponse.getAddress());
                }
                DialogSecurityQrBinding dialogSecurityQrBinding5 = this$0.get_binding();
                TextView textView4 = dialogSecurityQrBinding5 != null ? dialogSecurityQrBinding5.dateOfLeaveTv : null;
                if (textView4 != null) {
                    textView4.setText(hostelScanViewResponse.getFrom_date());
                }
                DialogSecurityQrBinding dialogSecurityQrBinding6 = this$0.get_binding();
                TextView textView5 = dialogSecurityQrBinding6 != null ? dialogSecurityQrBinding6.reasonTv : null;
                if (textView5 != null) {
                    textView5.setText(hostelScanViewResponse.getReason());
                }
                DialogSecurityQrBinding dialogSecurityQrBinding7 = this$0.get_binding();
                TextView textView6 = dialogSecurityQrBinding7 != null ? dialogSecurityQrBinding7.statusTv : null;
                if (textView6 != null) {
                    textView6.setText(hostelScanViewResponse.getStatus());
                }
                String lowerCase = hostelScanViewResponse.getStatus().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "student exited")) {
                    DialogSecurityQrBinding dialogSecurityQrBinding8 = this$0.get_binding();
                    ImageView imageView2 = dialogSecurityQrBinding8 != null ? dialogSecurityQrBinding8.approvedImage : null;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                } else {
                    DialogSecurityQrBinding dialogSecurityQrBinding9 = this$0.get_binding();
                    ImageView imageView3 = dialogSecurityQrBinding9 != null ? dialogSecurityQrBinding9.approvedImage : null;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                    }
                }
                DialogSecurityQrBinding dialogSecurityQrBinding10 = this$0.get_binding();
                TextView textView7 = dialogSecurityQrBinding10 != null ? dialogSecurityQrBinding10.phoneTv : null;
                if (textView7 != null) {
                    textView7.setText(hostelScanViewResponse.getPhone_no());
                }
                DialogSecurityQrBinding dialogSecurityQrBinding11 = this$0.get_binding();
                TextView textView8 = dialogSecurityQrBinding11 != null ? dialogSecurityQrBinding11.dateTv : null;
                if (textView8 != null) {
                    textView8.setText(hostelScanViewResponse.getDate());
                }
                DialogSecurityQrBinding dialogSecurityQrBinding12 = this$0.get_binding();
                TextView textView9 = dialogSecurityQrBinding12 != null ? dialogSecurityQrBinding12.hostelNameTv : null;
                if (textView9 != null) {
                    textView9.setText(hostelScanViewResponse.getHostel());
                }
                this$0.url = hostelScanViewResponse.getQrcode();
                this$0.downloadUrl = hostelScanViewResponse.getUrl();
                if (!Intrinsics.areEqual(hostelScanViewResponse.getQrcode(), "")) {
                    RequestCreator error = Picasso.get().load(hostelScanViewResponse.getQrcode()).fit().error(R.drawable.not_available_circle);
                    DialogSecurityQrBinding dialogSecurityQrBinding13 = this$0.get_binding();
                    ImageView imageView4 = dialogSecurityQrBinding13 != null ? dialogSecurityQrBinding13.bpQr : null;
                    Intrinsics.checkNotNull(imageView4);
                    error.into(imageView4);
                }
                if (Intrinsics.areEqual(hostelScanViewResponse.getImage(), "")) {
                    return;
                }
                RequestCreator error2 = Picasso.get().load(hostelScanViewResponse.getImage()).fit().error(R.drawable.not_available_circle);
                DialogSecurityQrBinding dialogSecurityQrBinding14 = this$0.get_binding();
                ImageView imageView5 = dialogSecurityQrBinding14 != null ? dialogSecurityQrBinding14.bpImage : null;
                Intrinsics.checkNotNull(imageView5);
                error2.into(imageView5);
                return;
            }
            DialogSecurityQrBinding dialogSecurityQrBinding15 = this$0.get_binding();
            ScrollView scrollView = dialogSecurityQrBinding15 != null ? dialogSecurityQrBinding15.bussPassView : null;
            if (scrollView != null) {
                scrollView.setVisibility(8);
            }
            DialogSecurityQrBinding dialogSecurityQrBinding16 = this$0.get_binding();
            TextView textView10 = dialogSecurityQrBinding16 != null ? dialogSecurityQrBinding16.tvError : null;
            if (textView10 == null) {
                return;
            }
            textView10.setVisibility(0);
        }
    }

    public final void downloadFile(String url, int position, boolean flag) {
        TextView textView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(replace, flag)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, "/etlab/assignments/");
                return;
            }
            try {
                DialogSecurityQrBinding dialogSecurityQrBinding = get_binding();
                if (dialogSecurityQrBinding != null && (textView = dialogSecurityQrBinding.downloadBtn) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(textView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading("/etlab/assignments/", url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        requestPermission();
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SecurityQrDialog.requestPermission$lambda$4(SecurityQrDialog.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$4(SecurityQrDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    public final boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new ValidChecker(requireContext).checkFileExistence(fileName, "/etlab/assignments/");
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new ValidChecker(requireContext2).checkFileExistence(fileName, "/etlab/assignments/");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}