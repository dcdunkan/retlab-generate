package in.etuwa.app.ui.transport.buspass;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import in.etuwa.app.R;
import in.etuwa.app.data.model.transportpalai.BusPass;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentTransportBuspassBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenDialog;
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

/* compiled from: BusPassFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0017H\u0014J\b\u0010&\u001a\u00020\u0017H\u0014J\b\u0010'\u001a\u00020\u0017H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lin/etuwa/app/ui/transport/buspass/BusPassFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentTransportBuspassBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentTransportBuspassBinding;", "busPassViewModel", "Lin/etuwa/app/ui/transport/buspass/BusPassViewModel;", "getBusPassViewModel", "()Lin/etuwa/app/ui/transport/buspass/BusPassViewModel;", "busPassViewModel$delegate", "Lkotlin/Lazy;", "downloadUrl", "", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "url", "hideBaseView", "", "hideProgress", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BusPassFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTransportBuspassBinding _binding;

    /* renamed from: busPassViewModel$delegate, reason: from kotlin metadata */
    private final Lazy busPassViewModel;
    private String downloadUrl;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String url;

    /* compiled from: BusPassFragment.kt */
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
    public static final BusPassFragment newInstance() {
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

    public BusPassFragment() {
        final BusPassFragment busPassFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.buspass.BusPassFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(busPassFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.busPassViewModel = FragmentViewModelLazyKt.createViewModelLazy(busPassFragment, Reflection.getOrCreateKotlinClass(BusPassViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.buspass.BusPassFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.buspass.BusPassFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(BusPassViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final BusPassFragment busPassFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.transport.buspass.BusPassFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = busPassFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final BusPassViewModel getBusPassViewModel() {
        return (BusPassViewModel) this.busPassViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentTransportBuspassBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: BusPassFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/transport/buspass/BusPassFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transport/buspass/BusPassFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BusPassFragment newInstance() {
            return new BusPassFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTransportBuspassBinding.inflate(inflater, container, false);
        FragmentTransportBuspassBinding fragmentTransportBuspassBinding = get_binding();
        if (fragmentTransportBuspassBinding != null) {
            fragmentTransportBuspassBinding.setBusPassViewModel(getBusPassViewModel());
        }
        FragmentTransportBuspassBinding fragmentTransportBuspassBinding2 = get_binding();
        if (fragmentTransportBuspassBinding2 != null) {
            fragmentTransportBuspassBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTransportBuspassBinding fragmentTransportBuspassBinding3 = get_binding();
        if (fragmentTransportBuspassBinding3 != null) {
            return fragmentTransportBuspassBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Transport Bus Pass");
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        getBusPassViewModel().getBusResponse();
        listenResponse();
        FragmentTransportBuspassBinding fragmentTransportBuspassBinding = get_binding();
        if (fragmentTransportBuspassBinding == null || (textView = fragmentTransportBuspassBinding.fullScreenQrBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.buspass.BusPassFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BusPassFragment.setUp$lambda$0(BusPassFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(BusPassFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        QrFullScreenDialog.Companion companion = QrFullScreenDialog.INSTANCE;
        String str = this$0.url;
        Intrinsics.checkNotNull(str);
        String str2 = this$0.downloadUrl;
        Intrinsics.checkNotNull(str2);
        companion.newInstance(str, str2).show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getBusPassViewModel().getBusPassResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.transport.buspass.BusPassFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BusPassFragment.listenResponse$lambda$2(BusPassFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(BusPassFragment this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            FragmentTransportBuspassBinding fragmentTransportBuspassBinding = this$0.get_binding();
            if (fragmentTransportBuspassBinding == null || (textView = fragmentTransportBuspassBinding.bpAcademicProgram) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        BusPass busPass = (BusPass) resource.getData();
        if (busPass != null) {
            this$0.showBaseView();
            if (Intrinsics.areEqual(busPass.getError(), "")) {
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding2 = this$0.get_binding();
                ScrollView scrollView = fragmentTransportBuspassBinding2 != null ? fragmentTransportBuspassBinding2.bussPassView : null;
                if (scrollView != null) {
                    scrollView.setVisibility(0);
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding3 = this$0.get_binding();
                TextView textView2 = fragmentTransportBuspassBinding3 != null ? fragmentTransportBuspassBinding3.tvError : null;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding4 = this$0.get_binding();
                TextView textView3 = fragmentTransportBuspassBinding4 != null ? fragmentTransportBuspassBinding4.bpAcademicProgram : null;
                if (textView3 != null) {
                    textView3.setText(busPass.getProgram());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding5 = this$0.get_binding();
                TextView textView4 = fragmentTransportBuspassBinding5 != null ? fragmentTransportBuspassBinding5.bpAdmssnNo : null;
                if (textView4 != null) {
                    textView4.setText(busPass.getAdmission_no());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding6 = this$0.get_binding();
                TextView textView5 = fragmentTransportBuspassBinding6 != null ? fragmentTransportBuspassBinding6.bpBatch : null;
                if (textView5 != null) {
                    textView5.setText(busPass.getBatch());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding7 = this$0.get_binding();
                TextView textView6 = fragmentTransportBuspassBinding7 != null ? fragmentTransportBuspassBinding7.bpPassCode : null;
                if (textView6 != null) {
                    textView6.setText(busPass.getPass_code());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding8 = this$0.get_binding();
                TextView textView7 = fragmentTransportBuspassBinding8 != null ? fragmentTransportBuspassBinding8.bpDuration : null;
                if (textView7 != null) {
                    textView7.setText(busPass.getDuration());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding9 = this$0.get_binding();
                TextView textView8 = fragmentTransportBuspassBinding9 != null ? fragmentTransportBuspassBinding9.bpSem : null;
                if (textView8 != null) {
                    textView8.setText(busPass.getSemester());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding10 = this$0.get_binding();
                TextView textView9 = fragmentTransportBuspassBinding10 != null ? fragmentTransportBuspassBinding10.bpGender : null;
                if (textView9 != null) {
                    textView9.setText(busPass.getGender());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding11 = this$0.get_binding();
                TextView textView10 = fragmentTransportBuspassBinding11 != null ? fragmentTransportBuspassBinding11.bpRoute : null;
                if (textView10 != null) {
                    textView10.setText(busPass.getRoute());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding12 = this$0.get_binding();
                TextView textView11 = fragmentTransportBuspassBinding12 != null ? fragmentTransportBuspassBinding12.bpBoardingPoint : null;
                if (textView11 != null) {
                    textView11.setText(busPass.getBoarding());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding13 = this$0.get_binding();
                TextView textView12 = fragmentTransportBuspassBinding13 != null ? fragmentTransportBuspassBinding13.bpPassCategory : null;
                if (textView12 != null) {
                    textView12.setText(busPass.getCategory());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding14 = this$0.get_binding();
                TextView textView13 = fragmentTransportBuspassBinding14 != null ? fragmentTransportBuspassBinding14.bpValidity : null;
                if (textView13 != null) {
                    textView13.setText(busPass.getValidity());
                }
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding15 = this$0.get_binding();
                TextView textView14 = fragmentTransportBuspassBinding15 != null ? fragmentTransportBuspassBinding15.bpName : null;
                if (textView14 != null) {
                    textView14.setText(busPass.getFull_name());
                }
                this$0.url = busPass.getQr_code();
                this$0.downloadUrl = busPass.getUrl();
                if (!Intrinsics.areEqual(busPass.getPhoto_url(), "")) {
                    RequestCreator fit = Picasso.get().load(busPass.getPhoto_url()).placeholder(R.drawable.ic_user_profile).fit();
                    FragmentTransportBuspassBinding fragmentTransportBuspassBinding16 = this$0.get_binding();
                    ImageView imageView = fragmentTransportBuspassBinding16 != null ? fragmentTransportBuspassBinding16.bpImage : null;
                    Intrinsics.checkNotNull(imageView);
                    fit.into(imageView);
                }
                if (Intrinsics.areEqual(busPass.getQr_code(), "")) {
                    return;
                }
                RequestCreator error = Picasso.get().load(busPass.getQr_code()).fit().error(R.drawable.ic_user_profile);
                FragmentTransportBuspassBinding fragmentTransportBuspassBinding17 = this$0.get_binding();
                ImageView imageView2 = fragmentTransportBuspassBinding17 != null ? fragmentTransportBuspassBinding17.bpQr : null;
                Intrinsics.checkNotNull(imageView2);
                error.into(imageView2);
                return;
            }
            FragmentTransportBuspassBinding fragmentTransportBuspassBinding18 = this$0.get_binding();
            ScrollView scrollView2 = fragmentTransportBuspassBinding18 != null ? fragmentTransportBuspassBinding18.bussPassView : null;
            if (scrollView2 != null) {
                scrollView2.setVisibility(8);
            }
            FragmentTransportBuspassBinding fragmentTransportBuspassBinding19 = this$0.get_binding();
            TextView textView15 = fragmentTransportBuspassBinding19 != null ? fragmentTransportBuspassBinding19.tvError : null;
            if (textView15 != null) {
                textView15.setVisibility(0);
            }
            FragmentTransportBuspassBinding fragmentTransportBuspassBinding20 = this$0.get_binding();
            TextView textView16 = fragmentTransportBuspassBinding20 != null ? fragmentTransportBuspassBinding20.tvError : null;
            if (textView16 == null) {
                return;
            }
            textView16.setText(busPass.getError());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}