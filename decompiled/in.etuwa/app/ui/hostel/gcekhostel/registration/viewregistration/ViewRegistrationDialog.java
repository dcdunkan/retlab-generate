package in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.hostel.gcekhostel.registration.ViewRegistrationResponse;
import in.etuwa.app.databinding.DialogViewregistrationDialogBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ViewRegistrationDialog.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001eH\u0014J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J-\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020 2\u000e\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r012\u0006\u00102\u001a\u000203H\u0016¢\u0006\u0002\u00104J\u001a\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u00107\u001a\u00020\u001eH\u0002J\u000e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020\u001eH\u0015J\b\u0010<\u001a\u00020\u001eH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006?"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogViewregistrationDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogViewregistrationDialogBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationDialog$ViewRegistrationListener;", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "url", "viewRegistrationViewModel", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationViewModel;", "getViewRegistrationViewModel", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationViewModel;", "viewRegistrationViewModel$delegate", "Lkotlin/Lazy;", "checkFileExistence", "", "fileName", "flag", "downloadCertificate", "", CommonCssConstants.POSITION, "", "hideProgress", "listenSpinnerResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setCallBack", "context", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationFragment;", "setUp", "showProgress", "Companion", "ViewRegistrationListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewRegistrationDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogViewregistrationDialogBinding _binding;
    private ArrayList<DownloadModel> downList;
    private String id;
    private ViewRegistrationListener listener;
    private final BroadcastReceiver onDownloadComplete;
    private String url;

    /* renamed from: viewRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewRegistrationViewModel;

    /* compiled from: ViewRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationDialog$ViewRegistrationListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ViewRegistrationListener {
        void onDismiss();
    }

    @JvmStatic
    public static final ViewRegistrationDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ViewRegistrationDialog() {
        final ViewRegistrationDialog viewRegistrationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(viewRegistrationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.viewRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(viewRegistrationDialog, Reflection.getOrCreateKotlinClass(ViewRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ViewRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = ViewRegistrationDialog.this.downList;
                    ViewRegistrationDialog viewRegistrationDialog2 = ViewRegistrationDialog.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            arrayList2 = viewRegistrationDialog2.downList;
                            arrayList2.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final ViewRegistrationViewModel getViewRegistrationViewModel() {
        return (ViewRegistrationViewModel) this.viewRegistrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogViewregistrationDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ViewRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/viewregistration/ViewRegistrationDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewRegistrationDialog newInstance(String id) {
            ViewRegistrationDialog viewRegistrationDialog = new ViewRegistrationDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            viewRegistrationDialog.setArguments(bundle);
            return viewRegistrationDialog;
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
        this._binding = DialogViewregistrationDialogBinding.inflate(inflater, container, false);
        DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding = get_binding();
        if (dialogViewregistrationDialogBinding != null) {
            dialogViewregistrationDialogBinding.setViewRegistrationViewModel(getViewRegistrationViewModel());
        }
        DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding2 = get_binding();
        if (dialogViewregistrationDialogBinding2 != null) {
            dialogViewregistrationDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding3 = get_binding();
        if (dialogViewregistrationDialogBinding3 != null) {
            return dialogViewregistrationDialogBinding3.getRoot();
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
        listenSpinnerResponse();
        String str = this.id;
        if (str != null) {
            getViewRegistrationViewModel().getViewRegistrationData(str);
        }
        DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding = get_binding();
        if (dialogViewregistrationDialogBinding == null || (textView = dialogViewregistrationDialogBinding.certificateDwnRe) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewRegistrationDialog.setUp$lambda$2(ViewRegistrationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ViewRegistrationDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.url;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            this$0.downloadCertificate(str, 0, true);
            return;
        }
        DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding = this$0.get_binding();
        if (dialogViewregistrationDialogBinding == null || (textView = dialogViewregistrationDialogBinding.certificateDwnRe) == null) {
            return;
        }
        ToastExtKt.showErrorToast(textView, "not available right now");
    }

    private final void listenSpinnerResponse() {
        getViewRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new ViewRegistrationDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewRegistrationResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog$listenSpinnerResponse$1

            /* compiled from: ViewRegistrationDialog.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ViewRegistrationResponse> resource) {
                invoke2((Resource<ViewRegistrationResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ViewRegistrationResponse> resource) {
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding2;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding3;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding4;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding5;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding6;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding7;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding8;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding9;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding10;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding11;
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding12;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ViewRegistrationDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ViewRegistrationDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ViewRegistrationDialog.this.hideProgress();
                    dialogViewregistrationDialogBinding12 = ViewRegistrationDialog.this.get_binding();
                    if (dialogViewregistrationDialogBinding12 == null || (textView = dialogViewregistrationDialogBinding12.certificateDwnRe) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ViewRegistrationDialog.this.hideProgress();
                ViewRegistrationResponse data = resource.getData();
                if (data != null) {
                    ViewRegistrationDialog viewRegistrationDialog = ViewRegistrationDialog.this;
                    try {
                        dialogViewregistrationDialogBinding = viewRegistrationDialog.get_binding();
                        TextView textView2 = dialogViewregistrationDialogBinding != null ? dialogViewregistrationDialogBinding.admsnNumberRe : null;
                        if (textView2 != null) {
                            textView2.setText(data.getAdmission_no());
                        }
                        dialogViewregistrationDialogBinding2 = viewRegistrationDialog.get_binding();
                        TextView textView3 = dialogViewregistrationDialogBinding2 != null ? dialogViewregistrationDialogBinding2.nameRe : null;
                        if (textView3 != null) {
                            textView3.setText(data.getFull_name());
                        }
                        dialogViewregistrationDialogBinding3 = viewRegistrationDialog.get_binding();
                        TextView textView4 = dialogViewregistrationDialogBinding3 != null ? dialogViewregistrationDialogBinding3.hostelAppliedForRe : null;
                        if (textView4 != null) {
                            textView4.setText(data.getSemester());
                        }
                        dialogViewregistrationDialogBinding4 = viewRegistrationDialog.get_binding();
                        TextView textView5 = dialogViewregistrationDialogBinding4 != null ? dialogViewregistrationDialogBinding4.statusRe : null;
                        if (textView5 != null) {
                            textView5.setText(data.getStatus());
                        }
                        dialogViewregistrationDialogBinding5 = viewRegistrationDialog.get_binding();
                        TextView textView6 = dialogViewregistrationDialogBinding5 != null ? dialogViewregistrationDialogBinding5.remarksRe : null;
                        if (textView6 != null) {
                            textView6.setText(data.getRemarks());
                        }
                        dialogViewregistrationDialogBinding6 = viewRegistrationDialog.get_binding();
                        TextView textView7 = dialogViewregistrationDialogBinding6 != null ? dialogViewregistrationDialogBinding6.typeRe : null;
                        if (textView7 != null) {
                            textView7.setText(data.getType());
                        }
                        dialogViewregistrationDialogBinding7 = viewRegistrationDialog.get_binding();
                        TextView textView8 = dialogViewregistrationDialogBinding7 != null ? dialogViewregistrationDialogBinding7.addressRe : null;
                        if (textView8 != null) {
                            textView8.setText(data.getGuardian_address());
                        }
                        dialogViewregistrationDialogBinding8 = viewRegistrationDialog.get_binding();
                        TextView textView9 = dialogViewregistrationDialogBinding8 != null ? dialogViewregistrationDialogBinding8.phoneRe : null;
                        if (textView9 != null) {
                            textView9.setText(data.getPhone_guardian());
                        }
                        dialogViewregistrationDialogBinding9 = viewRegistrationDialog.get_binding();
                        TextView textView10 = dialogViewregistrationDialogBinding9 != null ? dialogViewregistrationDialogBinding9.distanceRe : null;
                        if (textView10 != null) {
                            textView10.setText(data.getDistance());
                        }
                        dialogViewregistrationDialogBinding10 = viewRegistrationDialog.get_binding();
                        TextView textView11 = dialogViewregistrationDialogBinding10 != null ? dialogViewregistrationDialogBinding10.readmissionRe : null;
                        if (textView11 != null) {
                            textView11.setText(data.getReadmission());
                        }
                        dialogViewregistrationDialogBinding11 = viewRegistrationDialog.get_binding();
                        TextView textView12 = dialogViewregistrationDialogBinding11 != null ? dialogViewregistrationDialogBinding11.annualIncomeRe : null;
                        if (textView12 != null) {
                            textView12.setText(data.getAnnual_income());
                        }
                        viewRegistrationDialog.url = data.getIncomeFile();
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void downloadCertificate(String url, int position, boolean flag) {
        TextView textView;
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        String str = flag ? AppConstant.INTERNSHIP_PATH : AppConstant.UPLOAD_INTERNSHIP_PATH;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission()) {
            if (checkFileExistence(replace, flag)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, str);
                return;
            }
            try {
                DialogViewregistrationDialogBinding dialogViewregistrationDialogBinding = get_binding();
                if (dialogViewregistrationDialogBinding != null && (textView = dialogViewregistrationDialogBinding.certificateDwnRe) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(textView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(str, url);
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

    private final boolean checkFileExistence(String fileName, boolean flag) {
        if (flag) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.INTERNSHIP_PATH);
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new ValidChecker(requireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_INTERNSHIP_PATH);
    }

    public final void setCallBack(RegistrationFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
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

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationDialog$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ViewRegistrationDialog.requestPermission$lambda$3(ViewRegistrationDialog.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$3(ViewRegistrationDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            try {
                if (!(!(grantResults.length == 0)) || grantResults[0] != 0) {
                    if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                        Context requireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        new ValidChecker(requireContext).showPermissionDialog();
                    } else {
                        Toast.makeText(requireContext(), "Permission Denied, You cannot Upload Profile Image .", 0).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}