package in.etuwa.app.ui.profile.updateprofile;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import in.etuwa.app.R;
import in.etuwa.app.data.model.updateprofile.UpdateProfile;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: UpdateProfileWebView.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\nH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/profile/updateprofile/UpdateProfileWebView;", "Lin/etuwa/app/ui/base/BaseActivity;", "()V", "updateProfileViewModel", "Lin/etuwa/app/ui/profile/updateprofile/UpdateProfileViewModel;", "getUpdateProfileViewModel", "()Lin/etuwa/app/ui/profile/updateprofile/UpdateProfileViewModel;", "updateProfileViewModel$delegate", "Lkotlin/Lazy;", "hideProgress", "", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUp", "showProgress", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateProfileWebView extends BaseActivity {

    /* renamed from: updateProfileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy updateProfileViewModel;

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void showProgress() {
    }

    public UpdateProfileWebView() {
        final UpdateProfileWebView updateProfileWebView = this;
        final UpdateProfileWebView updateProfileWebView2 = updateProfileWebView;
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(updateProfileWebView);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.updateProfileViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(UpdateProfileViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.updateprofile.UpdateProfileWebView$special$$inlined$viewModel$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.updateprofile.UpdateProfileWebView$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory(ViewModelStoreOwner.this, Reflection.getOrCreateKotlinClass(UpdateProfileViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final UpdateProfileViewModel getUpdateProfileViewModel() {
        return (UpdateProfileViewModel) this.updateProfileViewModel.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        setTitle("Update Profile");
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
        listenResponse();
        getUpdateProfileViewModel().updateBankData();
    }

    private final void listenResponse() {
        getUpdateProfileViewModel().getResponse().observe(this, new UpdateProfileWebView$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends UpdateProfile>, Unit>() { // from class: in.etuwa.app.ui.profile.updateprofile.UpdateProfileWebView$listenResponse$1

            /* compiled from: UpdateProfileWebView.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends UpdateProfile> resource) {
                invoke2((Resource<UpdateProfile>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<UpdateProfile> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    UpdateProfileWebView.this.hideProgress();
                    UpdateProfile data = resource.getData();
                    if (data != null) {
                        WebView webView = (WebView) UpdateProfileWebView.this.findViewById(R.id.resetWebView);
                        webView.setWebViewClient(new WebViewClient());
                        webView.loadUrl(data.getUrl());
                        webView.getSettings().setJavaScriptEnabled(true);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    UpdateProfileWebView.this.showProgress();
                } else if (i == 3) {
                    UpdateProfileWebView.this.hideProgress();
                } else {
                    if (i != 4) {
                        return;
                    }
                    UpdateProfileWebView.this.hideProgress();
                }
            }
        }));
    }
}