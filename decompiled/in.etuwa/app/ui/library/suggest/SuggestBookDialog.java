package in.etuwa.app.ui.library.suggest;

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

/* compiled from: SuggestBookDialog.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020*J\b\u0010+\u001a\u00020\u0015H\u0014J\b\u0010,\u001a\u00020\u0015H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006/"}, d2 = {"Lin/etuwa/app/ui/library/suggest/SuggestBookDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogSuggestBookBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogSuggestBookBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/library/suggest/SuggestBookDialog$SuggestListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "suggestBookViewModel", "Lin/etuwa/app/ui/library/suggest/SuggestBookViewModel;", "getSuggestBookViewModel", "()Lin/etuwa/app/ui/library/suggest/SuggestBookViewModel;", "suggestBookViewModel$delegate", "Lkotlin/Lazy;", "hideProgress", "", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/library/LibraryFragmeent;", "setUp", "showProgress", "Companion", "SuggestListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SuggestBookDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogSuggestBookBinding _binding;
    private String id;
    private SuggestListener listener;
    private MainCallBackListener listener2;

    /* renamed from: suggestBookViewModel$delegate, reason: from kotlin metadata */
    private final Lazy suggestBookViewModel;

    /* compiled from: SuggestBookDialog.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SuggestBookViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final SuggestBookViewModel getSuggestBookViewModel() {
        return (SuggestBookViewModel) this.suggestBookViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogSuggestBookBinding get_binding() {
        return this._binding;
    }

    /* compiled from: SuggestBookDialog.kt */
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
        getSuggestBookViewModel().getResponse().observe(getViewLifecycleOwner(), new SuggestBookDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.library.suggest.SuggestBookDialog$listenResponse$1

            /* compiled from: SuggestBookDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                DialogSuggestBookBinding dialogSuggestBookBinding;
                TextView suggestBtn;
                DialogSuggestBookBinding dialogSuggestBookBinding2;
                TextView suggestBtn2;
                DialogSuggestBookBinding dialogSuggestBookBinding3;
                TextView textView;
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
                    dialogSuggestBookBinding3 = SuggestBookDialog.this.get_binding();
                    if (dialogSuggestBookBinding3 == null || (textView = dialogSuggestBookBinding3.suggestBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                SuggestBookDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    SuggestBookDialog suggestBookDialog = SuggestBookDialog.this;
                    if (data.getSuccess()) {
                        dialogSuggestBookBinding2 = suggestBookDialog.get_binding();
                        if (dialogSuggestBookBinding2 != null && (suggestBtn2 = dialogSuggestBookBinding2.suggestBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(suggestBtn2, "suggestBtn");
                            ToastExtKt.showInfoToast(suggestBtn2, data.getMessage());
                        }
                        suggestBookDialog.dismiss();
                        return;
                    }
                    dialogSuggestBookBinding = suggestBookDialog.get_binding();
                    if (dialogSuggestBookBinding == null || (suggestBtn = dialogSuggestBookBinding.suggestBtn) == null) {
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