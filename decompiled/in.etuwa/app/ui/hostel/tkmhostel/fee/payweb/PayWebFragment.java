package in.etuwa.app.ui.hostel.tkmhostel.fee.payweb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.FragmentPayWebBinding;
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

/* compiled from: PayWebFragment.kt */
/* loaded from: classes5.dex */
public final class PayWebFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentPayWebBinding _binding;

    /* renamed from: payWebViewModel$delegate, reason: from kotlin metadata */
    private final Lazy payWebViewModel;
    private String url;

    @JvmStatic
    public static final PayWebFragment newInstance(String str) {
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

    public PayWebFragment() {
        final PayWebFragment payWebFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payweb.PayWebFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(payWebFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.payWebViewModel = FragmentViewModelLazyKt.createViewModelLazy(payWebFragment, Reflection.getOrCreateKotlinClass(PayWebViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payweb.PayWebFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.fee.payweb.PayWebFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(PayWebViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final PayWebViewModel getPayWebViewModel() {
        return (PayWebViewModel) this.payWebViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentPayWebBinding get_binding() {
        return this._binding;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    /* compiled from: PayWebFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/fee/payweb/PayWebFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/tkmhostel/fee/payweb/PayWebFragment;", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PayWebFragment newInstance(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            PayWebFragment payWebFragment = new PayWebFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            payWebFragment.setArguments(bundle);
            return payWebFragment;
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
        this._binding = FragmentPayWebBinding.inflate(inflater, container, false);
        FragmentPayWebBinding fragmentPayWebBinding = get_binding();
        if (fragmentPayWebBinding != null) {
            fragmentPayWebBinding.setPayWebViewModel(getPayWebViewModel());
        }
        FragmentPayWebBinding fragmentPayWebBinding2 = get_binding();
        if (fragmentPayWebBinding2 != null) {
            fragmentPayWebBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentPayWebBinding fragmentPayWebBinding3 = get_binding();
        if (fragmentPayWebBinding3 != null) {
            return fragmentPayWebBinding3.getRoot();
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
        WebView webView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Payment Page");
        }
        FragmentPayWebBinding fragmentPayWebBinding = get_binding();
        WebView webView2 = fragmentPayWebBinding != null ? fragmentPayWebBinding.hostelWebView : null;
        if (webView2 != null) {
            webView2.setWebViewClient(new WebViewClient());
        }
        FragmentPayWebBinding fragmentPayWebBinding2 = get_binding();
        if (fragmentPayWebBinding2 != null && (webView = fragmentPayWebBinding2.hostelWebView) != null) {
            String url = webView.getUrl();
            if (url != null) {
                webView.loadUrl(url);
            }
            webView.getSettings().setJavaScriptEnabled(true);
        }
        System.out.println((Object) this.url);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}