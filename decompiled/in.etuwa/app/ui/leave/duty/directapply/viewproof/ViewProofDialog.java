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

/* JADX INFO: compiled from: ViewProofDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ViewProofDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogViewProofBinding _binding;
    private NewDutyLeaveListener listener;
    private String url;

    /* JADX INFO: renamed from: viewProofViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewProofViewModel;

    /* JADX INFO: compiled from: ViewProofDialog.kt */
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
                return viewProofDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ViewProofViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ViewProofViewModel getViewProofViewModel() {
        return (ViewProofViewModel) this.viewProofViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final DialogViewProofBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: ViewProofDialog.kt */
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