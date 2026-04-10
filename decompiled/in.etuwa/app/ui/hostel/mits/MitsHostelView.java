package in.etuwa.app.ui.hostel.mits;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.mits.MitsFeePay;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: MitsHostelView.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class MitsHostelView extends BaseActivity {

    /* JADX INFO: renamed from: mitsHostelViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mitsHostelViewModel;

    /* JADX INFO: compiled from: MitsHostelView.kt */
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

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void showProgress() {
    }

    public MitsHostelView() {
        final MitsHostelView mitsHostelView = this;
        final MitsHostelView mitsHostelView2 = mitsHostelView;
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(mitsHostelView);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.mitsHostelViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MitsHostelViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.mits.MitsHostelView$special$$inlined$viewModel$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = mitsHostelView.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.mits.MitsHostelView$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory(mitsHostelView2, Reflection.getOrCreateKotlinClass(MitsHostelViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final MitsHostelViewModel getMitsHostelViewModel() {
        return (MitsHostelViewModel) this.mitsHostelViewModel.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mits_hotel_view);
        setTitle("Hostel");
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
        listenResponse();
        getMitsHostelViewModel().getUrl();
        System.out.println((Object) "url");
    }

    private final void listenResponse() {
        getMitsHostelViewModel().getResponse().observe(this, new Observer() { // from class: in.etuwa.app.ui.hostel.mits.MitsHostelView$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MitsHostelView.listenResponse$lambda$2(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(MitsHostelView this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            MitsFeePay mitsFeePay = (MitsFeePay) resource.getData();
            if (mitsFeePay != null) {
                WebView webView = (WebView) this$0.findViewById(R.id.mits_hostel_webview);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(mitsFeePay.getUrl());
                webView.getSettings().setJavaScriptEnabled(true);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
        } else if (i == 3) {
            this$0.hideProgress();
        } else {
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
        }
    }
}