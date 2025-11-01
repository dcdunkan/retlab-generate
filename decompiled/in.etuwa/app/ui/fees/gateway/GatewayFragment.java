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

/* compiled from: GatewayFragment.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020!H\u0014J\b\u0010&\u001a\u00020!H\u0014J\b\u0010'\u001a\u00020!H\u0002J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020!H\u0016J\u001a\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00103\u001a\u00020!H\u0014J\b\u00104\u001a\u00020!H\u0014J\b\u00105\u001a\u00020!H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017¨\u00067"}, d2 = {"Lin/etuwa/app/ui/fees/gateway/GatewayFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentGatewayDetailsBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentGatewayDetailsBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "gatewayViewModel", "Lin/etuwa/app/ui/fees/gateway/GatewayViewModel;", "getGatewayViewModel", "()Lin/etuwa/app/ui/fees/gateway/GatewayViewModel;", "gatewayViewModel$delegate", "Lkotlin/Lazy;", "ipg", "", "getIpg", "()Ljava/lang/String;", "setIpg", "(Ljava/lang/String;)V", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", FirebaseAnalytics.Event.REFUND, "getRefund", "setRefund", "checkFileExistence", "", "fileName", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "hideBaseView", "hideProgress", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GatewayFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentGatewayDetailsBinding _binding;
    private ArrayList<DownloadModel> downList;

    /* renamed from: gatewayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gatewayViewModel;
    private String ipg;
    private final BroadcastReceiver onDownloadComplete;
    private String refund;

    /* compiled from: GatewayFragment.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(GatewayViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.ipg = "";
        this.refund = "";
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.fees.gateway.GatewayFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = GatewayFragment.this.downList;
                    GatewayFragment gatewayFragment2 = GatewayFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            arrayList2 = gatewayFragment2.downList;
                            arrayList2.remove(new DownloadModel(downloadModel.getId(), i));
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

    /* renamed from: getBinding, reason: from getter */
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

    /* compiled from: GatewayFragment.kt */
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
                    GatewayFragment.setUp$lambda$0(GatewayFragment.this, view);
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
                GatewayFragment.setUp$lambda$1(GatewayFragment.this, view);
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
                GatewayFragment.listenResponse$lambda$3(GatewayFragment.this, (Resource) obj);
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
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission()) {
            if (checkFileExistence(replace)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, AppConstant.GATEWAY_PATH);
                return;
            }
            try {
                FragmentGatewayDetailsBinding fragmentGatewayDetailsBinding = get_binding();
                if (fragmentGatewayDetailsBinding != null && (textView = fragmentGatewayDetailsBinding.merchantNameTv) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(textView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.GATEWAY_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
        new ValidChecker(requireContext4).showPermissionDialog();
    }

    private final boolean checkFileExistence(String fileName) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.GATEWAY_PATH);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}