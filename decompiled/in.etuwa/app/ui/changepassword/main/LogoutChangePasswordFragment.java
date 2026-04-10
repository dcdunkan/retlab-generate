package in.etuwa.app.ui.changepassword.main;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.LogoutChangePasswordFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.changepassword.ChangePasswordDialog;
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

/* compiled from: LogoutChangePasswordFragment.kt */
/* loaded from: classes4.dex */
public final class LogoutChangePasswordFragment extends BaseFragment implements ChangePasswordDialog.RemindCounsellingListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private LogoutChangePasswordFragmentBinding _binding;
    private String id;
    private ChangePasswordDialog.RemindCounsellingListener listener;
    private MainCallBackListener listener2;

    /* renamed from: logoutChangePasswordViewModel$delegate, reason: from kotlin metadata */
    private final Lazy logoutChangePasswordViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final LogoutChangePasswordFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.changepassword.ChangePasswordDialog.RemindCounsellingListener
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public LogoutChangePasswordFragment() {
        final LogoutChangePasswordFragment logoutChangePasswordFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.changepassword.main.LogoutChangePasswordFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(logoutChangePasswordFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.logoutChangePasswordViewModel = FragmentViewModelLazyKt.createViewModelLazy(logoutChangePasswordFragment, Reflection.getOrCreateKotlinClass(LogoutChangePasswordViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.changepassword.main.LogoutChangePasswordFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.changepassword.main.LogoutChangePasswordFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(LogoutChangePasswordViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final LogoutChangePasswordFragment logoutChangePasswordFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.changepassword.main.LogoutChangePasswordFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = logoutChangePasswordFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final LogoutChangePasswordViewModel getLogoutChangePasswordViewModel() {
        return (LogoutChangePasswordViewModel) this.logoutChangePasswordViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final LogoutChangePasswordFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: LogoutChangePasswordFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/changepassword/main/LogoutChangePasswordFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/changepassword/main/LogoutChangePasswordFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LogoutChangePasswordFragment newInstance() {
            return new LogoutChangePasswordFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = LogoutChangePasswordFragmentBinding.inflate(inflater, container, false);
        LogoutChangePasswordFragmentBinding logoutChangePasswordFragmentBinding = get_binding();
        if (logoutChangePasswordFragmentBinding != null) {
            logoutChangePasswordFragmentBinding.setLogoutChangePasswordViewModel(getLogoutChangePasswordViewModel());
        }
        LogoutChangePasswordFragmentBinding logoutChangePasswordFragmentBinding2 = get_binding();
        if (logoutChangePasswordFragmentBinding2 != null) {
            logoutChangePasswordFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        LogoutChangePasswordFragmentBinding logoutChangePasswordFragmentBinding3 = get_binding();
        if (logoutChangePasswordFragmentBinding3 != null) {
            return logoutChangePasswordFragmentBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LogoutChangePasswordFragmentBinding logoutChangePasswordFragmentBinding = get_binding();
        if (logoutChangePasswordFragmentBinding != null && (textView2 = logoutChangePasswordFragmentBinding.changeBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.changepassword.main.LogoutChangePasswordFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LogoutChangePasswordFragment.onViewCreated$lambda$0(LogoutChangePasswordFragment.this, view2);
                }
            });
        }
        LogoutChangePasswordFragmentBinding logoutChangePasswordFragmentBinding2 = get_binding();
        if (logoutChangePasswordFragmentBinding2 == null || (textView = logoutChangePasswordFragmentBinding2.logoutBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.changepassword.main.LogoutChangePasswordFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LogoutChangePasswordFragment.onViewCreated$lambda$1(LogoutChangePasswordFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(LogoutChangePasswordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener2;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainChangeLogoutClick(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(LogoutChangePasswordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener2;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainChangeLogoutClick(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener2 = null;
    }
}