package in.etuwa.app.ui.leave.duty.proof;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.DialogViewProofDutyLeaveBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.leave.duty.DutyLeaveFragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ViewProofDutyLeave.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\u001a\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0015J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0014H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006)"}, d2 = {"Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeave;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogViewProofDutyLeaveBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogViewProofDutyLeaveBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeave$ViewProofDutyLeaveCallBack;", "url", "viewProofDutyLeaveViewModel", "Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeaveViewModel;", "getViewProofDutyLeaveViewModel", "()Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeaveViewModel;", "viewProofDutyLeaveViewModel$delegate", "Lkotlin/Lazy;", "hideProgress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "setViewProofDutyLeaveCallBack", "context", "Lin/etuwa/app/ui/leave/duty/DutyLeaveFragment;", "showProgress", "Companion", "ViewProofDutyLeaveCallBack", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewProofDutyLeave extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogViewProofDutyLeaveBinding _binding;
    private String id;
    private ViewProofDutyLeaveCallBack listener;
    private String url;

    /* renamed from: viewProofDutyLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewProofDutyLeaveViewModel;

    /* compiled from: ViewProofDutyLeave.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeave$ViewProofDutyLeaveCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ViewProofDutyLeaveCallBack {
        void onDismiss();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ViewProofDutyLeave() {
        final ViewProofDutyLeave viewProofDutyLeave = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.duty.proof.ViewProofDutyLeave$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(viewProofDutyLeave);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.viewProofDutyLeaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(viewProofDutyLeave, Reflection.getOrCreateKotlinClass(ViewProofDutyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.duty.proof.ViewProofDutyLeave$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.duty.proof.ViewProofDutyLeave$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ViewProofDutyLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ViewProofDutyLeaveViewModel getViewProofDutyLeaveViewModel() {
        return (ViewProofDutyLeaveViewModel) this.viewProofDutyLeaveViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogViewProofDutyLeaveBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ViewProofDutyLeave.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeave$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeave;", "id", "", "url", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewProofDutyLeave newInstance(String id, String url) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            ViewProofDutyLeave viewProofDutyLeave = new ViewProofDutyLeave();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString("url", url);
            viewProofDutyLeave.setArguments(bundle);
            return viewProofDutyLeave;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.url = arguments.getString("url");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogViewProofDutyLeaveBinding.inflate(inflater, container, false);
        DialogViewProofDutyLeaveBinding dialogViewProofDutyLeaveBinding = get_binding();
        if (dialogViewProofDutyLeaveBinding != null) {
            dialogViewProofDutyLeaveBinding.setViewProofDutyLeaveViewModel(getViewProofDutyLeaveViewModel());
        }
        DialogViewProofDutyLeaveBinding dialogViewProofDutyLeaveBinding2 = get_binding();
        if (dialogViewProofDutyLeaveBinding2 != null) {
            dialogViewProofDutyLeaveBinding2.setLifecycleOwner(this);
        }
        DialogViewProofDutyLeaveBinding dialogViewProofDutyLeaveBinding3 = get_binding();
        if (dialogViewProofDutyLeaveBinding3 != null) {
            return dialogViewProofDutyLeaveBinding3.getRoot();
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
        WebSettings settings;
        WebView webView2;
        DialogViewProofDutyLeaveBinding dialogViewProofDutyLeaveBinding;
        WebView webView3;
        DialogViewProofDutyLeaveBinding dialogViewProofDutyLeaveBinding2 = get_binding();
        WebSettings webSettings = null;
        WebView webView4 = dialogViewProofDutyLeaveBinding2 != null ? dialogViewProofDutyLeaveBinding2.webview : null;
        if (webView4 != null) {
            webView4.setWebViewClient(new WebViewClient());
        }
        String str = this.url;
        if (str != null && (dialogViewProofDutyLeaveBinding = get_binding()) != null && (webView3 = dialogViewProofDutyLeaveBinding.webview) != null) {
            webView3.loadUrl(str);
        }
        DialogViewProofDutyLeaveBinding dialogViewProofDutyLeaveBinding3 = get_binding();
        if (dialogViewProofDutyLeaveBinding3 != null && (webView2 = dialogViewProofDutyLeaveBinding3.webview) != null) {
            webSettings = webView2.getSettings();
        }
        if (webSettings != null) {
            webSettings.setJavaScriptEnabled(true);
        }
        DialogViewProofDutyLeaveBinding dialogViewProofDutyLeaveBinding4 = get_binding();
        if (dialogViewProofDutyLeaveBinding4 == null || (webView = dialogViewProofDutyLeaveBinding4.webview) == null || (settings = webView.getSettings()) == null) {
            return;
        }
        settings.setSupportZoom(true);
    }

    public final void setViewProofDutyLeaveCallBack(DutyLeaveFragment context) {
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