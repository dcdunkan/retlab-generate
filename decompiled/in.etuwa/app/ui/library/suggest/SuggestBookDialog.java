package in.etuwa.app.ui.library.suggest;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.DialogSuggestBookBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.library.LibraryFragmeent;
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

/* JADX INFO: compiled from: SuggestBookDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SuggestBookDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogSuggestBookBinding _binding;
    private String id;
    private SuggestListener listener;
    private MainCallBackListener listener2;

    /* JADX INFO: renamed from: suggestBookViewModel$delegate, reason: from kotlin metadata */
    private final Lazy suggestBookViewModel;

    /* JADX INFO: compiled from: SuggestBookDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/library/suggest/SuggestBookDialog$SuggestListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SuggestListener {
        void dismiss();
    }

    @JvmStatic
    public static final SuggestBookDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public SuggestBookDialog() {
        final SuggestBookDialog suggestBookDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.library.suggest.SuggestBookDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return suggestBookDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(suggestBookDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.suggestBookViewModel = FragmentViewModelLazyKt.createViewModelLazy(suggestBookDialog, Reflection.getOrCreateKotlinClass(SuggestBookViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.library.suggest.SuggestBookDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.library.suggest.SuggestBookDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(SuggestBookViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final SuggestBookViewModel getSuggestBookViewModel() {
        return (SuggestBookViewModel) this.suggestBookViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogSuggestBookBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: SuggestBookDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/library/suggest/SuggestBookDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/library/suggest/SuggestBookDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SuggestBookDialog newInstance() {
            return new SuggestBookDialog();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogSuggestBookBinding.inflate(inflater, container, false);
        DialogSuggestBookBinding dialogSuggestBookBinding = get_binding();
        if (dialogSuggestBookBinding != null) {
            dialogSuggestBookBinding.setSuggestBookViewModel(getSuggestBookViewModel());
        }
        DialogSuggestBookBinding dialogSuggestBookBinding2 = get_binding();
        if (dialogSuggestBookBinding2 != null) {
            dialogSuggestBookBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogSuggestBookBinding dialogSuggestBookBinding3 = get_binding();
        if (dialogSuggestBookBinding3 != null) {
            return dialogSuggestBookBinding3.getRoot();
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
    }

    private final void listenResponse() {
        getSuggestBookViewModel().getResponse().observe(getViewLifecycleOwner(), new SuggestBookDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.library.suggest.SuggestBookDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.library.suggest.SuggestBookDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: SuggestBookDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                MaterialButton suggestBtn;
                MaterialButton suggestBtn2;
                MaterialButton materialButton;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        SuggestBookDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        SuggestBookDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    SuggestBookDialog.this.hideProgress();
                    DialogSuggestBookBinding dialogSuggestBookBinding = SuggestBookDialog.this.get_binding();
                    if (dialogSuggestBookBinding == null || (materialButton = dialogSuggestBookBinding.suggestBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(materialButton, message);
                    return;
                }
                SuggestBookDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    SuggestBookDialog suggestBookDialog = SuggestBookDialog.this;
                    if (data.getSuccess()) {
                        DialogSuggestBookBinding dialogSuggestBookBinding2 = suggestBookDialog.get_binding();
                        if (dialogSuggestBookBinding2 != null && (suggestBtn2 = dialogSuggestBookBinding2.suggestBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(suggestBtn2, "suggestBtn");
                            ToastExtKt.showInfoToast(suggestBtn2, data.getMessage());
                        }
                        suggestBookDialog.dismiss();
                        return;
                    }
                    DialogSuggestBookBinding dialogSuggestBookBinding3 = suggestBookDialog.get_binding();
                    if (dialogSuggestBookBinding3 == null || (suggestBtn = dialogSuggestBookBinding3.suggestBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(suggestBtn, "suggestBtn");
                    ToastExtKt.showErrorToast(suggestBtn, "Some error occured,Try again!!");
                }
            }
        }));
    }

    public final void setCallBack(LibraryFragmeent context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        SuggestListener suggestListener = this.listener;
        if (suggestListener != null) {
            suggestListener.dismiss();
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