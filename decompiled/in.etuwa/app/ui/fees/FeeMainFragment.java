package in.etuwa.app.ui.fees;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFeeMainBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FeeMainFragment.kt */
/* loaded from: classes4.dex */
public final class FeeMainFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFeeMainBinding _binding;

    /* renamed from: feeMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeMainViewModel;
    private final Set<Double> globalSet;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final FeeMainFragment newInstance() {
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

    public FeeMainFragment() {
        final FeeMainFragment feeMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeMainFragment, Reflection.getOrCreateKotlinClass(FeeMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeMainFragment feeMainFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.globalSet = new LinkedHashSet();
    }

    private final FeeMainViewModel getFeeMainViewModel() {
        return (FeeMainViewModel) this.feeMainViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentFeeMainBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: FeeMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/FeeMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/FeeMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeMainFragment newInstance() {
            return new FeeMainFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentFeeMainBinding.inflate(inflater, container, false);
        FragmentFeeMainBinding fragmentFeeMainBinding = get_binding();
        if (fragmentFeeMainBinding != null) {
            fragmentFeeMainBinding.setFeeMainViewModel(getFeeMainViewModel());
        }
        FragmentFeeMainBinding fragmentFeeMainBinding2 = get_binding();
        if (fragmentFeeMainBinding2 != null) {
            fragmentFeeMainBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFeeMainBinding fragmentFeeMainBinding3 = get_binding();
        if (fragmentFeeMainBinding3 != null) {
            return fragmentFeeMainBinding3.getRoot();
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
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        LinearLayout linearLayout8;
        getPreference().setNewLogin(false);
        FragmentFeeMainBinding fragmentFeeMainBinding = get_binding();
        if (fragmentFeeMainBinding != null && (linearLayout8 = fragmentFeeMainBinding.payBtn) != null) {
            linearLayout8.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainFragment.setUp$lambda$0(FeeMainFragment.this, view);
                }
            });
        }
        FragmentFeeMainBinding fragmentFeeMainBinding2 = get_binding();
        if (fragmentFeeMainBinding2 != null && (linearLayout7 = fragmentFeeMainBinding2.viewReceipt) != null) {
            linearLayout7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainFragment.setUp$lambda$1(FeeMainFragment.this, view);
                }
            });
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcet", false, 2, (Object) null)) {
            FragmentFeeMainBinding fragmentFeeMainBinding3 = get_binding();
            LinearLayout linearLayout9 = fragmentFeeMainBinding3 != null ? fragmentFeeMainBinding3.paymentGatewayBtn : null;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(8);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "//mea.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null)) {
            FragmentFeeMainBinding fragmentFeeMainBinding4 = get_binding();
            LinearLayout linearLayout10 = fragmentFeeMainBinding4 != null ? fragmentFeeMainBinding4.transportFeeBtn : null;
            if (linearLayout10 != null) {
                linearLayout10.setVisibility(0);
            }
            FragmentFeeMainBinding fragmentFeeMainBinding5 = get_binding();
            LinearLayout linearLayout11 = fragmentFeeMainBinding5 != null ? fragmentFeeMainBinding5.viewTransportReceipt : null;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(0);
            }
            FragmentFeeMainBinding fragmentFeeMainBinding6 = get_binding();
            TextView textView = fragmentFeeMainBinding6 != null ? fragmentFeeMainBinding6.tvTransportView : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            FragmentFeeMainBinding fragmentFeeMainBinding7 = get_binding();
            LinearLayout linearLayout12 = fragmentFeeMainBinding7 != null ? fragmentFeeMainBinding7.viewTransportBuspass : null;
            if (linearLayout12 != null) {
                linearLayout12.setVisibility(0);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null)) {
            FragmentFeeMainBinding fragmentFeeMainBinding8 = get_binding();
            LinearLayout linearLayout13 = fragmentFeeMainBinding8 != null ? fragmentFeeMainBinding8.transportFeeBtn : null;
            if (linearLayout13 != null) {
                linearLayout13.setVisibility(0);
            }
            FragmentFeeMainBinding fragmentFeeMainBinding9 = get_binding();
            LinearLayout linearLayout14 = fragmentFeeMainBinding9 != null ? fragmentFeeMainBinding9.viewTransportReceipt : null;
            if (linearLayout14 != null) {
                linearLayout14.setVisibility(0);
            }
            FragmentFeeMainBinding fragmentFeeMainBinding10 = get_binding();
            TextView textView2 = fragmentFeeMainBinding10 != null ? fragmentFeeMainBinding10.tvTransportView : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec.", false, 2, (Object) null)) {
            FragmentFeeMainBinding fragmentFeeMainBinding11 = get_binding();
            LinearLayout linearLayout15 = fragmentFeeMainBinding11 != null ? fragmentFeeMainBinding11.transportRegBtn : null;
            if (linearLayout15 != null) {
                linearLayout15.setVisibility(0);
            }
        }
        FragmentFeeMainBinding fragmentFeeMainBinding12 = get_binding();
        if (fragmentFeeMainBinding12 != null && (linearLayout6 = fragmentFeeMainBinding12.transportRegBtn) != null) {
            linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainFragment.setUp$lambda$2(FeeMainFragment.this, view);
                }
            });
        }
        FragmentFeeMainBinding fragmentFeeMainBinding13 = get_binding();
        if (fragmentFeeMainBinding13 != null && (linearLayout5 = fragmentFeeMainBinding13.transportFeeBtn) != null) {
            linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainFragment.setUp$lambda$3(FeeMainFragment.this, view);
                }
            });
        }
        FragmentFeeMainBinding fragmentFeeMainBinding14 = get_binding();
        if (fragmentFeeMainBinding14 != null && (linearLayout4 = fragmentFeeMainBinding14.viewTransportReceipt) != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainFragment.setUp$lambda$4(FeeMainFragment.this, view);
                }
            });
        }
        FragmentFeeMainBinding fragmentFeeMainBinding15 = get_binding();
        if (fragmentFeeMainBinding15 != null && (linearLayout3 = fragmentFeeMainBinding15.viewTransportBuspass) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainFragment.setUp$lambda$5(FeeMainFragment.this, view);
                }
            });
        }
        FragmentFeeMainBinding fragmentFeeMainBinding16 = get_binding();
        if (fragmentFeeMainBinding16 != null && (linearLayout2 = fragmentFeeMainBinding16.paymentGatewayBtn) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainFragment.setUp$lambda$6(FeeMainFragment.this, view);
                }
            });
        }
        FragmentFeeMainBinding fragmentFeeMainBinding17 = get_binding();
        if (fragmentFeeMainBinding17 == null || (linearLayout = fragmentFeeMainBinding17.transportHistoryBtn) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeeMainFragment.setUp$lambda$7(FeeMainFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainFeeClick(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainFeeClick(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.transportRegBtnClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.transportBtnClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.transportReceiptBtnClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.transportBusPassBtnClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.gatewayDetailsClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(FeeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showTransportHistory();
        }
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
}