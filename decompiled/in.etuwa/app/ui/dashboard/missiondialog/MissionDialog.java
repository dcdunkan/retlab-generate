package in.etuwa.app.ui.dashboard.missiondialog;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogMissionBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: MissionDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MissionDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogMissionBinding _binding;
    private StoreListener listener;
    private MainCallBackListener listner2;

    /* JADX INFO: renamed from: missionDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy missionDialogViewModel;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: compiled from: MissionDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/dashboard/missiondialog/MissionDialog$StoreListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StoreListener {
        void dismiss();
    }

    @JvmStatic
    public static final MissionDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public MissionDialog() {
        final MissionDialog missionDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.dashboard.missiondialog.MissionDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return missionDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(missionDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.missionDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(missionDialog, Reflection.getOrCreateKotlinClass(MissionDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.dashboard.missiondialog.MissionDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.dashboard.missiondialog.MissionDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(MissionDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MissionDialog missionDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.missiondialog.MissionDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = missionDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final MissionDialogViewModel getMissionDialogViewModel() {
        return (MissionDialogViewModel) this.missionDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogMissionBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: MissionDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/dashboard/missiondialog/MissionDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/dashboard/missiondialog/MissionDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MissionDialog newInstance() {
            MissionDialog missionDialog = new MissionDialog();
            missionDialog.setArguments(new Bundle());
            return missionDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogMissionBinding.inflate(inflater, container, false);
        DialogMissionBinding dialogMissionBinding = get_binding();
        if (dialogMissionBinding != null) {
            dialogMissionBinding.setMissionDialogViewModel(getMissionDialogViewModel());
        }
        DialogMissionBinding dialogMissionBinding2 = get_binding();
        if (dialogMissionBinding2 != null) {
            dialogMissionBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogMissionBinding dialogMissionBinding3 = get_binding();
        if (dialogMissionBinding3 != null) {
            return dialogMissionBinding3.getRoot();
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
        listenResponse();
        if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://nssce.etlab.in/androidapp/mobile/")) {
            getMissionDialogViewModel().getDashData("99");
        } else {
            getMissionDialogViewModel().getDashData(null);
        }
    }

    private final void listenResponse() {
        getMissionDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new MissionDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DashResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.missiondialog.MissionDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.missiondialog.MissionDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: MissionDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DashResponse> resource) {
                invoke2((Resource<DashResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DashResponse> resource) {
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MissionDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        MissionDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    MissionDialog.this.hideProgress();
                    DialogMissionBinding dialogMissionBinding = MissionDialog.this.get_binding();
                    if (dialogMissionBinding == null || (textView = dialogMissionBinding.misColg) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                MissionDialog.this.hideProgress();
                DashResponse data = resource.getData();
                if (data != null) {
                    MissionDialog missionDialog = MissionDialog.this;
                    DialogMissionBinding dialogMissionBinding2 = missionDialog.get_binding();
                    TextView textView2 = dialogMissionBinding2 != null ? dialogMissionBinding2.misColg : null;
                    if (textView2 != null) {
                        textView2.setText(data.getClgMission());
                    }
                    DialogMissionBinding dialogMissionBinding3 = missionDialog.get_binding();
                    TextView textView3 = dialogMissionBinding3 != null ? dialogMissionBinding3.misColg : null;
                    if (textView3 != null) {
                        textView3.setSelected(true);
                    }
                    DialogMissionBinding dialogMissionBinding4 = missionDialog.get_binding();
                    TextView textView4 = dialogMissionBinding4 != null ? dialogMissionBinding4.misDept : null;
                    if (textView4 != null) {
                        textView4.setText(data.getDeptMission());
                    }
                    DialogMissionBinding dialogMissionBinding5 = missionDialog.get_binding();
                    TextView textView5 = dialogMissionBinding5 != null ? dialogMissionBinding5.misDept : null;
                    if (textView5 == null) {
                        return;
                    }
                    textView5.setSelected(true);
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listner2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    public final void setCallBack(DashboardFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        StoreListener storeListener = this.listener;
        if (storeListener != null) {
            storeListener.dismiss();
        }
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