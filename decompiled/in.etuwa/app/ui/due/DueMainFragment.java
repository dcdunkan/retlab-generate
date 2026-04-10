package in.etuwa.app.ui.due;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.due.duepay.NoDueCertificateResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentDuesMainBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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

/* compiled from: DueMainFragment.kt */
/* loaded from: classes4.dex */
public final class DueMainFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentDuesMainBinding _binding;

    /* renamed from: dueMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dueMainViewModel;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String url;

    /* compiled from: DueMainFragment.kt */
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
    public static final DueMainFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public DueMainFragment() {
        final DueMainFragment dueMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.due.DueMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(dueMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.dueMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(dueMainFragment, Reflection.getOrCreateKotlinClass(DueMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.due.DueMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.due.DueMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(DueMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final DueMainFragment dueMainFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.due.DueMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = dueMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.url = "";
    }

    private final DueMainViewModel getDueMainViewModel() {
        return (DueMainViewModel) this.dueMainViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentDuesMainBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: DueMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/due/DueMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/due/DueMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DueMainFragment newInstance() {
            return new DueMainFragment();
        }
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentDuesMainBinding.inflate(inflater, container, false);
        FragmentDuesMainBinding fragmentDuesMainBinding = get_binding();
        if (fragmentDuesMainBinding != null) {
            fragmentDuesMainBinding.setDueMainViewModel(getDueMainViewModel());
        }
        FragmentDuesMainBinding fragmentDuesMainBinding2 = get_binding();
        if (fragmentDuesMainBinding2 != null) {
            fragmentDuesMainBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentDuesMainBinding fragmentDuesMainBinding3 = get_binding();
        if (fragmentDuesMainBinding3 != null) {
            return fragmentDuesMainBinding3.getRoot();
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
        TextView textView3;
        getPreference().setNewLogin(false);
        getDueMainViewModel().getDuesCertificate();
        FragmentDuesMainBinding fragmentDuesMainBinding = get_binding();
        if (fragmentDuesMainBinding != null && (textView3 = fragmentDuesMainBinding.payDueBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.due.DueMainFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DueMainFragment.setUp$lambda$0(DueMainFragment.this, view);
                }
            });
        }
        FragmentDuesMainBinding fragmentDuesMainBinding2 = get_binding();
        if (fragmentDuesMainBinding2 != null && (textView2 = fragmentDuesMainBinding2.viewDueReceipt) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.due.DueMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DueMainFragment.setUp$lambda$1(DueMainFragment.this, view);
                }
            });
        }
        FragmentDuesMainBinding fragmentDuesMainBinding3 = get_binding();
        if (fragmentDuesMainBinding3 == null || (textView = fragmentDuesMainBinding3.viewDueCertificate) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.due.DueMainFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DueMainFragment.setUp$lambda$2(DueMainFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(DueMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainDueClick(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(DueMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainDueClick(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(DueMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenResponse();
        this$0.openReport(this$0.url);
    }

    private final void listenResponse() {
        getDueMainViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.due.DueMainFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DueMainFragment.listenResponse$lambda$4(DueMainFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(DueMainFragment this$0, Resource resource) {
        TextView viewDueCertificate;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            NoDueCertificateResponse noDueCertificateResponse = (NoDueCertificateResponse) resource.getData();
            if (noDueCertificateResponse != null) {
                this$0.showBaseView();
                if (noDueCertificateResponse.getUrl() != null) {
                    this$0.url = noDueCertificateResponse.getUrl();
                    return;
                }
                FragmentDuesMainBinding fragmentDuesMainBinding = this$0.get_binding();
                if (fragmentDuesMainBinding == null || (viewDueCertificate = fragmentDuesMainBinding.viewDueCertificate) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(viewDueCertificate, "viewDueCertificate");
                ToastExtKt.showErrorToast(viewDueCertificate, "You have pending dues!!!");
                return;
            }
            return;
        }
        if (i == 2) {
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
        FragmentDuesMainBinding fragmentDuesMainBinding2 = this$0.get_binding();
        if (fragmentDuesMainBinding2 == null || (textView = fragmentDuesMainBinding2.viewDueCertificate) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    public final void openReport(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            if (Intrinsics.areEqual(url, "")) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            startActivity(Intent.createChooser(intent, "Open With"));
        } catch (NullPointerException unused) {
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        FragmentDuesMainBinding fragmentDuesMainBinding = get_binding();
        TextView textView = fragmentDuesMainBinding != null ? fragmentDuesMainBinding.viewDueCertificate : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        FragmentDuesMainBinding fragmentDuesMainBinding = get_binding();
        TextView textView = fragmentDuesMainBinding != null ? fragmentDuesMainBinding.viewDueCertificate : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}