package in.etuwa.app.ui.feenewengineer.payment.webview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.FragmentPaymentWebviewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
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

/* compiled from: PaymentWebViewFragment.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\u001a\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010%\u001a\u00020\u0013H\u0014J\b\u0010&\u001a\u00020\u0013H\u0003J\b\u0010'\u001a\u00020\u0013H\u0014J\b\u0010(\u001a\u00020\u0013H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/webview/PaymentWebViewFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentPaymentWebviewBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentPaymentWebviewBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "paymentWebViewViewModel", "Lin/etuwa/app/ui/feenewengineer/payment/webview/PaymentWebViewViewModel;", "getPaymentWebViewViewModel", "()Lin/etuwa/app/ui/feenewengineer/payment/webview/PaymentWebViewViewModel;", "paymentWebViewViewModel$delegate", "Lkotlin/Lazy;", "url", "", "hideBaseView", "", "hideProgress", "loadUrl", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "setupWebView", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaymentWebViewFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentPaymentWebviewBinding _binding;
    private MainCallBackListener listener;

    /* renamed from: paymentWebViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy paymentWebViewViewModel;
    private String url;

    @JvmStatic
    public static final PaymentWebViewFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public PaymentWebViewFragment() {
        final PaymentWebViewFragment paymentWebViewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.feenewengineer.payment.webview.PaymentWebViewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(paymentWebViewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.paymentWebViewViewModel = FragmentViewModelLazyKt.createViewModelLazy(paymentWebViewFragment, Reflection.getOrCreateKotlinClass(PaymentWebViewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.feenewengineer.payment.webview.PaymentWebViewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.feenewengineer.payment.webview.PaymentWebViewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(PaymentWebViewViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final PaymentWebViewViewModel getPaymentWebViewViewModel() {
        return (PaymentWebViewViewModel) this.paymentWebViewViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentPaymentWebviewBinding get_binding() {
        return this._binding;
    }

    /* compiled from: PaymentWebViewFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/webview/PaymentWebViewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/feenewengineer/payment/webview/PaymentWebViewFragment;", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PaymentWebViewFragment newInstance(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            PaymentWebViewFragment paymentWebViewFragment = new PaymentWebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            paymentWebViewFragment.setArguments(bundle);
            return paymentWebViewFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.url = arguments.getString("url");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentPaymentWebviewBinding.inflate(inflater, container, false);
        FragmentPaymentWebviewBinding fragmentPaymentWebviewBinding = get_binding();
        if (fragmentPaymentWebviewBinding != null) {
            fragmentPaymentWebviewBinding.setPaymentWebViewViewModel(getPaymentWebViewViewModel());
        }
        FragmentPaymentWebviewBinding fragmentPaymentWebviewBinding2 = get_binding();
        if (fragmentPaymentWebviewBinding2 != null) {
            fragmentPaymentWebviewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentPaymentWebviewBinding fragmentPaymentWebviewBinding3 = get_binding();
        if (fragmentPaymentWebviewBinding3 != null) {
            return fragmentPaymentWebviewBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Fee Pay");
        }
        setupWebView();
        String str = this.url;
        Intrinsics.checkNotNull(str);
        loadUrl(str);
    }

    private final void setupWebView() {
        WebView webView;
        WebSettings settings;
        FragmentPaymentWebviewBinding fragmentPaymentWebviewBinding = get_binding();
        if (fragmentPaymentWebviewBinding != null && (webView = fragmentPaymentWebviewBinding.webview) != null && (settings = webView.getSettings()) != null) {
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setAllowContentAccess(true);
            settings.setAllowFileAccess(true);
            settings.setSupportZoom(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setBlockNetworkImage(false);
            settings.setMixedContentMode(0);
        }
        WebView.setWebContentsDebuggingEnabled(true);
        FragmentPaymentWebviewBinding fragmentPaymentWebviewBinding2 = get_binding();
        WebView webView2 = fragmentPaymentWebviewBinding2 != null ? fragmentPaymentWebviewBinding2.webview : null;
        if (webView2 == null) {
            return;
        }
        webView2.setWebViewClient(new WebViewClient() { // from class: in.etuwa.app.ui.feenewengineer.payment.webview.PaymentWebViewFragment$setupWebView$2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            }
        });
    }

    private final void loadUrl(String url) {
        WebView webView;
        FragmentPaymentWebviewBinding fragmentPaymentWebviewBinding = get_binding();
        if (fragmentPaymentWebviewBinding == null || (webView = fragmentPaymentWebviewBinding.webview) == null) {
            return;
        }
        webView.loadUrl(url);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
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