package in.etuwa.app.ui.leave.duty.directapply.viewproof;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.DialogViewProofBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ViewProofDialog.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0013H\u0015J\b\u0010%\u001a\u00020\u0013H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/viewproof/ViewProofDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogViewProofBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogViewProofBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/duty/directapply/viewproof/ViewProofDialog$NewDutyLeaveListener;", "url", "", "viewProofViewModel", "Lin/etuwa/app/ui/leave/duty/directapply/viewproof/ViewProofViewModel;", "getViewProofViewModel", "()Lin/etuwa/app/ui/leave/duty/directapply/viewproof/ViewProofViewModel;", "viewProofViewModel$delegate", "Lkotlin/Lazy;", "hideProgress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyFragment;", "setUp", "showProgress", "Companion", "NewDutyLeaveListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewProofDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogViewProofBinding _binding;
    private NewDutyLeaveListener listener;
    private String url;

    /* renamed from: viewProofViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewProofViewModel;

    /* compiled from: ViewProofDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/viewproof/ViewProofDialog$NewDutyLeaveListener;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NewDutyLeaveListener {
    }

    @JvmStatic
    public static final ViewProofDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ViewProofDialog() {
        final ViewProofDialog viewProofDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.duty.directapply.viewproof.ViewProofDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(viewProofDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.viewProofViewModel = FragmentViewModelLazyKt.createViewModelLazy(viewProofDialog, Reflection.getOrCreateKotlinClass(ViewProofViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.duty.directapply.viewproof.ViewProofDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.duty.directapply.viewproof.ViewProofDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ViewProofViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ViewProofViewModel getViewProofViewModel() {
        return (ViewProofViewModel) this.viewProofViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogViewProofBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ViewProofDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/viewproof/ViewProofDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/directapply/viewproof/ViewProofDialog;", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewProofDialog newInstance(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            ViewProofDialog viewProofDialog = new ViewProofDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", url);
            viewProofDialog.setArguments(bundle);
            return viewProofDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.url = arguments.getString("flag");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogViewProofBinding.inflate(inflater, container, false);
        DialogViewProofBinding dialogViewProofBinding = get_binding();
        if (dialogViewProofBinding != null) {
            dialogViewProofBinding.setViewProofViewModel(getViewProofViewModel());
        }
        DialogViewProofBinding dialogViewProofBinding2 = get_binding();
        if (dialogViewProofBinding2 != null) {
            dialogViewProofBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogViewProofBinding dialogViewProofBinding3 = get_binding();
        if (dialogViewProofBinding3 != null) {
            return dialogViewProofBinding3.getRoot();
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
        WebView webView;
        System.out.println((Object) this.url);
        System.out.println((Object) this.url);
        DialogViewProofBinding dialogViewProofBinding = get_binding();
        WebView webView2 = dialogViewProofBinding != null ? dialogViewProofBinding.proofView : null;
        if (webView2 != null) {
            webView2.setWebViewClient(new WebViewClient());
        }
        DialogViewProofBinding dialogViewProofBinding2 = get_binding();
        if (dialogViewProofBinding2 == null || (webView = dialogViewProofBinding2.proofView) == null) {
            return;
        }
        String url = webView.getUrl();
        if (url != null) {
            webView.loadUrl(url);
        }
        webView.getSettings().setJavaScriptEnabled(true);
    }

    public final void setCallBack(DirectApplyFragment context) {
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
}