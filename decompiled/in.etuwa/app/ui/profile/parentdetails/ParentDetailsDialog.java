package in.etuwa.app.ui.profile.parentdetails;

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
import in.etuwa.app.data.model.dash.ProfileResponse;
import in.etuwa.app.databinding.DialogParentDetailsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.profile.ProfileFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
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

/* JADX INFO: compiled from: ParentDetailsDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ParentDetailsDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogParentDetailsBinding _binding;
    private String abcId;
    private String instruction;
    private ProfileListener listener;
    private MainCallBackListener listener2;

    /* JADX INFO: renamed from: parentDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy parentDetailsViewModel;
    private String video;

    /* JADX INFO: compiled from: ParentDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/parentdetails/ParentDetailsDialog$ProfileListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProfileListener {
        void dismiss();
    }

    @JvmStatic
    public static final ParentDetailsDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ParentDetailsDialog() {
        final ParentDetailsDialog parentDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.parentdetails.ParentDetailsDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return parentDetailsDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(parentDetailsDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.parentDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(parentDetailsDialog, Reflection.getOrCreateKotlinClass(ParentDetailsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.parentdetails.ParentDetailsDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.parentdetails.ParentDetailsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ParentDetailsViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ParentDetailsViewModel getParentDetailsViewModel() {
        return (ParentDetailsViewModel) this.parentDetailsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogParentDetailsBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: ParentDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/profile/parentdetails/ParentDetailsDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/parentdetails/ParentDetailsDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ParentDetailsDialog newInstance() {
            ParentDetailsDialog parentDetailsDialog = new ParentDetailsDialog();
            parentDetailsDialog.setArguments(new Bundle());
            return parentDetailsDialog;
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
        this._binding = DialogParentDetailsBinding.inflate(inflater, container, false);
        DialogParentDetailsBinding dialogParentDetailsBinding = get_binding();
        if (dialogParentDetailsBinding != null) {
            dialogParentDetailsBinding.setParentDetailsViewModel(getParentDetailsViewModel());
        }
        DialogParentDetailsBinding dialogParentDetailsBinding2 = get_binding();
        if (dialogParentDetailsBinding2 != null) {
            dialogParentDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogParentDetailsBinding dialogParentDetailsBinding3 = get_binding();
        if (dialogParentDetailsBinding3 != null) {
            return dialogParentDetailsBinding3.getRoot();
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
        getParentDetailsViewModel().getDashData();
    }

    private final void listenResponse() {
        getParentDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new ParentDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ProfileResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.parentdetails.ParentDetailsDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.profile.parentdetails.ParentDetailsDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: ParentDetailsDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ProfileResponse> resource) {
                invoke2((Resource<ProfileResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ProfileResponse> resource) {
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ParentDetailsDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ParentDetailsDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ParentDetailsDialog.this.hideProgress();
                    DialogParentDetailsBinding dialogParentDetailsBinding = ParentDetailsDialog.this.get_binding();
                    if (dialogParentDetailsBinding == null || (textView = dialogParentDetailsBinding.fatherOcc) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ParentDetailsDialog.this.hideProgress();
                ProfileResponse data = resource.getData();
                if (data != null) {
                    ParentDetailsDialog parentDetailsDialog = ParentDetailsDialog.this;
                    DialogParentDetailsBinding dialogParentDetailsBinding2 = parentDetailsDialog.get_binding();
                    TextView textView2 = dialogParentDetailsBinding2 != null ? dialogParentDetailsBinding2.fatherName : null;
                    if (textView2 != null) {
                        textView2.setText(data.getFather_name());
                    }
                    DialogParentDetailsBinding dialogParentDetailsBinding3 = parentDetailsDialog.get_binding();
                    TextView textView3 = dialogParentDetailsBinding3 != null ? dialogParentDetailsBinding3.fatherNumber : null;
                    if (textView3 != null) {
                        textView3.setText(data.getPhone_father());
                    }
                    DialogParentDetailsBinding dialogParentDetailsBinding4 = parentDetailsDialog.get_binding();
                    TextView textView4 = dialogParentDetailsBinding4 != null ? dialogParentDetailsBinding4.fatherOcc : null;
                    if (textView4 != null) {
                        textView4.setText(data.getFather_occupation());
                    }
                    DialogParentDetailsBinding dialogParentDetailsBinding5 = parentDetailsDialog.get_binding();
                    TextView textView5 = dialogParentDetailsBinding5 != null ? dialogParentDetailsBinding5.motherName : null;
                    if (textView5 != null) {
                        textView5.setText(data.getMother_name());
                    }
                    DialogParentDetailsBinding dialogParentDetailsBinding6 = parentDetailsDialog.get_binding();
                    TextView textView6 = dialogParentDetailsBinding6 != null ? dialogParentDetailsBinding6.motherOcc : null;
                    if (textView6 != null) {
                        textView6.setText(data.getMother_occupation());
                    }
                    DialogParentDetailsBinding dialogParentDetailsBinding7 = parentDetailsDialog.get_binding();
                    TextView textView7 = dialogParentDetailsBinding7 != null ? dialogParentDetailsBinding7.motherNum : null;
                    if (textView7 != null) {
                        textView7.setText(data.getPhone_mother());
                    }
                    DialogParentDetailsBinding dialogParentDetailsBinding8 = parentDetailsDialog.get_binding();
                    TextView textView8 = dialogParentDetailsBinding8 != null ? dialogParentDetailsBinding8.email : null;
                    if (textView8 == null) {
                        return;
                    }
                    textView8.setText(data.getEmail());
                }
            }
        }));
    }

    public final void setCallBack(ProfileFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ProfileListener profileListener = this.listener;
        if (profileListener != null) {
            profileListener.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}