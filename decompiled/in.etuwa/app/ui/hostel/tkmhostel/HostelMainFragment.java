package in.etuwa.app.ui.hostel.tkmhostel;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.HostelFragmentTkmBinding;
import in.etuwa.app.helper.MainCallBackListener;
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

/* compiled from: HostelMainFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u001a\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/HostelMainFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lin/etuwa/app/databinding/HostelFragmentTkmBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/HostelFragmentTkmBinding;", "hostelMainViewModel", "Lin/etuwa/app/ui/hostel/tkmhostel/HostelMainViewModel;", "getHostelMainViewModel", "()Lin/etuwa/app/ui/hostel/tkmhostel/HostelMainViewModel;", "hostelMainViewModel$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelMainFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HostelFragmentTkmBinding _binding;

    /* renamed from: hostelMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelMainViewModel;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final HostelMainFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public HostelMainFragment() {
        final HostelMainFragment hostelMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelMainFragment, Reflection.getOrCreateKotlinClass(HostelMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelMainFragment hostelMainFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = hostelMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final HostelMainViewModel getHostelMainViewModel() {
        return (HostelMainViewModel) this.hostelMainViewModel.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final HostelFragmentTkmBinding get_binding() {
        return this._binding;
    }

    /* compiled from: HostelMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/HostelMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/tkmhostel/HostelMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelMainFragment newInstance() {
            return new HostelMainFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = HostelFragmentTkmBinding.inflate(inflater, container, false);
        HostelFragmentTkmBinding hostelFragmentTkmBinding = get_binding();
        if (hostelFragmentTkmBinding != null) {
            hostelFragmentTkmBinding.setHostelMainViewModel(getHostelMainViewModel());
        }
        HostelFragmentTkmBinding hostelFragmentTkmBinding2 = get_binding();
        if (hostelFragmentTkmBinding2 != null) {
            hostelFragmentTkmBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        HostelFragmentTkmBinding hostelFragmentTkmBinding3 = get_binding();
        if (hostelFragmentTkmBinding3 != null) {
            return hostelFragmentTkmBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getPreference().setNewLogin(false);
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
            HostelFragmentTkmBinding hostelFragmentTkmBinding = get_binding();
            LinearLayout linearLayout7 = hostelFragmentTkmBinding != null ? hostelFragmentTkmBinding.messGcekBtn : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(0);
            }
            HostelFragmentTkmBinding hostelFragmentTkmBinding2 = get_binding();
            View view2 = hostelFragmentTkmBinding2 != null ? hostelFragmentTkmBinding2.viewRegHostel : null;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            HostelFragmentTkmBinding hostelFragmentTkmBinding3 = get_binding();
            LinearLayout linearLayout8 = hostelFragmentTkmBinding3 != null ? hostelFragmentTkmBinding3.hostelNewRegistration : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
        } else {
            HostelFragmentTkmBinding hostelFragmentTkmBinding4 = get_binding();
            LinearLayout linearLayout9 = hostelFragmentTkmBinding4 != null ? hostelFragmentTkmBinding4.messGcekBtn : null;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(8);
            }
            HostelFragmentTkmBinding hostelFragmentTkmBinding5 = get_binding();
            View view3 = hostelFragmentTkmBinding5 != null ? hostelFragmentTkmBinding5.viewRegHostel : null;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            HostelFragmentTkmBinding hostelFragmentTkmBinding6 = get_binding();
            LinearLayout linearLayout10 = hostelFragmentTkmBinding6 != null ? hostelFragmentTkmBinding6.hostelNewRegistration : null;
            if (linearLayout10 != null) {
                linearLayout10.setVisibility(8);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) {
            HostelFragmentTkmBinding hostelFragmentTkmBinding7 = get_binding();
            linearLayout = hostelFragmentTkmBinding7 != null ? hostelFragmentTkmBinding7.attendanceHostelBtn : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            HostelFragmentTkmBinding hostelFragmentTkmBinding8 = get_binding();
            linearLayout = hostelFragmentTkmBinding8 != null ? hostelFragmentTkmBinding8.attendanceHostelBtn : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        HostelFragmentTkmBinding hostelFragmentTkmBinding9 = get_binding();
        if (hostelFragmentTkmBinding9 != null && (linearLayout6 = hostelFragmentTkmBinding9.hostelNewRegistration) != null) {
            linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    HostelMainFragment.onViewCreated$lambda$0(HostelMainFragment.this, view4);
                }
            });
        }
        HostelFragmentTkmBinding hostelFragmentTkmBinding10 = get_binding();
        if (hostelFragmentTkmBinding10 != null && (linearLayout5 = hostelFragmentTkmBinding10.payTkmBtn) != null) {
            linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    HostelMainFragment.onViewCreated$lambda$1(HostelMainFragment.this, view4);
                }
            });
        }
        HostelFragmentTkmBinding hostelFragmentTkmBinding11 = get_binding();
        if (hostelFragmentTkmBinding11 != null && (linearLayout4 = hostelFragmentTkmBinding11.messGcekBtn) != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    HostelMainFragment.onViewCreated$lambda$2(HostelMainFragment.this, view4);
                }
            });
        }
        HostelFragmentTkmBinding hostelFragmentTkmBinding12 = get_binding();
        if (hostelFragmentTkmBinding12 != null && (linearLayout3 = hostelFragmentTkmBinding12.receiptTkmBtn) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    HostelMainFragment.onViewCreated$lambda$3(HostelMainFragment.this, view4);
                }
            });
        }
        HostelFragmentTkmBinding hostelFragmentTkmBinding13 = get_binding();
        if (hostelFragmentTkmBinding13 == null || (linearLayout2 = hostelFragmentTkmBinding13.attendanceHostelBtn) == null) {
            return;
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                HostelMainFragment.onViewCreated$lambda$4(HostelMainFragment.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(HostelMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainHostelClick(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(HostelMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "tkm", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
            MainCallBackListener mainCallBackListener = this$0.listener;
            if (mainCallBackListener != null) {
                mainCallBackListener.onTkmHostelPayClick();
                return;
            }
            return;
        }
        MainCallBackListener mainCallBackListener2 = this$0.listener;
        if (mainCallBackListener2 != null) {
            mainCallBackListener2.onPalaiHostelPayClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(HostelMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onHostelMessClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(HostelMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onTkmHostelReceipt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(HostelMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onHostelMainAttViewClicked();
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