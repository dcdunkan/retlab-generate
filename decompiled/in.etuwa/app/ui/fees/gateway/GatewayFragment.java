package in.etuwa.app.ui.fees.gateway;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.fee.GatewayDetailsResponse;
import in.etuwa.app.databinding.FragmentGatewayDetailsBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: GatewayFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GatewayFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentGatewayDetailsBinding _binding;
    private ArrayList<DownloadModel> downList;

    /* JADX INFO: renamed from: gatewayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gatewayViewModel;
    private String ipg;
    private final BroadcastReceiver onDownloadComplete;
    private String refund;

    /* JADX INFO: compiled from: GatewayFragment.kt */
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

    @JvmStatic
    public static final GatewayFragment newInstance() {
        return INSTANCE.newInstance();
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

    public GatewayFragment() {
        final GatewayFragment gatewayFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return gatewayFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(gatewayFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.gatewayViewModel = FragmentViewModelLazyKt.createViewModelLazy(gatewayFragment, Reflection.getOrCreateKotlinClass(GatewayViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(GatewayViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.ipg = "";
        this.refund = "";
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    ArrayList arrayList = this.this$0.downList;
                    GatewayFragment gatewayFragment2 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            gatewayFragment2.downList.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final GatewayViewModel getGatewayViewModel() {
        return (GatewayViewModel) this.gatewayViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentGatewayDetailsBinding get_binding() {
        return this._binding;
    }

    public final String getIpg() {
        return this.ipg;
    }

    public final void setIpg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ipg = str;
    }

    public final String getRefund() {
        return this.refund;
    }

    public final void setRefund(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refund = str;
    }

    /* JADX INFO: compiled from: GatewayFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/gateway/GatewayFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/gateway/GatewayFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GatewayFragment newInstance() {
            return new GatewayFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGatewayDetailsBinding.inflate(inflater, container, false);
        FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding = get_binding();
        if (fragmentGatewayDetailsBinding != null) {
            fragmentGatewayDetailsBinding.setGatewayViewModel(getGatewayViewModel());
        }
        FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding2 = get_binding();
        if (fragmentGatewayDetailsBinding2 != null) {
            fragmentGatewayDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding3 = get_binding();
        if (fragmentGatewayDetailsBinding3 != null) {
            return fragmentGatewayDetailsBinding3.getRoot();
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
        TextView textView;
        TextView textView2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Payment Gateway Details");
        }
        hideBaseView();
        listenResponse();
        getGatewayViewModel().getDetails();
        FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding = get_binding();
        if (fragmentGatewayDetailsBinding != null && (textView2 = fragmentGatewayDetailsBinding.ipgDownloadBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GatewayFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding2 = get_binding();
        if (fragmentGatewayDetailsBinding2 == null || (textView = fragmentGatewayDetailsBinding2.refundPolicyBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GatewayFragment.setUp$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(GatewayFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.downloadFile(this$0.ipg, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(GatewayFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.downloadFile(this$0.refund, 1);
    }

    private final void listenResponse() {
        getGatewayViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GatewayFragment.listenResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(GatewayFragment this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.hideBaseView();
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding = this$0.get_binding();
            if (fragmentGatewayDetailsBinding == null || (textView = fragmentGatewayDetailsBinding.merchantNameTv) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        GatewayDetailsResponse gatewayDetailsResponse = (GatewayDetailsResponse) resource.getData();
        if (gatewayDetailsResponse != null) {
            this$0.showBaseView();
            if (gatewayDetailsResponse.getLogin()) {
                FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding2 = this$0.get_binding();
                TextView textView2 = fragmentGatewayDetailsBinding2 != null ? fragmentGatewayDetailsBinding2.addrssTv : null;
                if (textView2 != null) {
                    textView2.setText(gatewayDetailsResponse.getAddress());
                }
                FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding3 = this$0.get_binding();
                TextView textView3 = fragmentGatewayDetailsBinding3 != null ? fragmentGatewayDetailsBinding3.merchantNameTv : null;
                if (textView3 != null) {
                    textView3.setText(gatewayDetailsResponse.getMerchant());
                }
                FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding4 = this$0.get_binding();
                TextView textView4 = fragmentGatewayDetailsBinding4 != null ? fragmentGatewayDetailsBinding4.contactTv : null;
                if (textView4 != null) {
                    textView4.setText(gatewayDetailsResponse.getPhone());
                }
                this$0.ipg = gatewayDetailsResponse.getIpg();
                this$0.refund = gatewayDetailsResponse.getRefund();
            }
        }
    }

    private final void downloadFile(String url, int position) {
        TextView textView;
        String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission()) {
            if (checkFileExistence(strReplace)) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                new DownloadManagerHelper(contextRequireContext2).openFile(strReplace, AppConstant.GATEWAY_PATH);
                return;
            }
            try {
                FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding = get_binding();
                if (fragmentGatewayDetailsBinding != null && (textView = fragmentGatewayDetailsBinding.merchantNameTv) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(textView, string);
                }
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext3).startDownloading(AppConstant.GATEWAY_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(jStartDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
        new ValidChecker(contextRequireContext4).showPermissionDialog();
    }

    private final boolean checkFileExistence(String fileName) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.GATEWAY_PATH);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}