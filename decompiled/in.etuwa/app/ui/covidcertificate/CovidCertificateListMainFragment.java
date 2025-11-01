package in.etuwa.app.ui.covidcertificate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.CovidCertificateListMainFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CovidCertificateListMainFragment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0014J\b\u0010\u001c\u001a\u00020\u000fH\u0014J\b\u0010\u001d\u001a\u00020\u000fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/ui/covidcertificate/CovidCertificateListMainFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/CovidCertificateListMainFragmentBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/CovidCertificateListMainFragmentBinding;", "covidCertificateListMainViewModel", "Lin/etuwa/app/ui/covidcertificate/CovidCertificateListMainViewModel;", "getCovidCertificateListMainViewModel", "()Lin/etuwa/app/ui/covidcertificate/CovidCertificateListMainViewModel;", "covidCertificateListMainViewModel$delegate", "Lkotlin/Lazy;", "hideBaseView", "", "hideProgress", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CovidCertificateListMainFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CovidCertificateListMainFragmentBinding _binding;

    /* renamed from: covidCertificateListMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy covidCertificateListMainViewModel;

    public CovidCertificateListMainFragment() {
        final CovidCertificateListMainFragment covidCertificateListMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateListMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(covidCertificateListMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.covidCertificateListMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(covidCertificateListMainFragment, Reflection.getOrCreateKotlinClass(CovidCertificateListMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateListMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateListMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CovidCertificateListMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final CovidCertificateListMainViewModel getCovidCertificateListMainViewModel() {
        return (CovidCertificateListMainViewModel) this.covidCertificateListMainViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final CovidCertificateListMainFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: CovidCertificateListMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/covidcertificate/CovidCertificateListMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/covidcertificate/CovidCertificateListMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CovidCertificateListMainFragment newInstance() {
            return new CovidCertificateListMainFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CovidCertificateListMainFragmentBinding.inflate(inflater, container, false);
        CovidCertificateListMainFragmentBinding covidCertificateListMainFragmentBinding = get_binding();
        if (covidCertificateListMainFragmentBinding != null) {
            covidCertificateListMainFragmentBinding.setCovidCertificateListMainViewModel(getCovidCertificateListMainViewModel());
        }
        CovidCertificateListMainFragmentBinding covidCertificateListMainFragmentBinding2 = get_binding();
        if (covidCertificateListMainFragmentBinding2 != null) {
            covidCertificateListMainFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CovidCertificateListMainFragmentBinding covidCertificateListMainFragmentBinding3 = get_binding();
        if (covidCertificateListMainFragmentBinding3 != null) {
            return covidCertificateListMainFragmentBinding3.getRoot();
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
            activity.setTitle("Vaccine Certificate");
        }
        CovidCertificateListMainFragmentBinding covidCertificateListMainFragmentBinding = get_binding();
        if (covidCertificateListMainFragmentBinding != null && (textView2 = covidCertificateListMainFragmentBinding.firstDoseBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateListMainFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CovidCertificateListMainFragment.setUp$lambda$1(CovidCertificateListMainFragment.this, view);
                }
            });
        }
        CovidCertificateListMainFragmentBinding covidCertificateListMainFragmentBinding2 = get_binding();
        if (covidCertificateListMainFragmentBinding2 == null || (textView = covidCertificateListMainFragmentBinding2.secondDoseBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateListMainFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CovidCertificateListMainFragment.setUp$lambda$3(CovidCertificateListMainFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CovidCertificateListMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CovidCertificateDialog newInstance = CovidCertificateDialog.INSTANCE.newInstance();
        FragmentManager fragmentManager = this$0.getFragmentManager();
        if (fragmentManager != null) {
            newInstance.show(fragmentManager, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(CovidCertificateListMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CovidCertificateTwoDialog newInstance = CovidCertificateTwoDialog.INSTANCE.newInstance();
        FragmentManager fragmentManager = this$0.getFragmentManager();
        if (fragmentManager != null) {
            newInstance.show(fragmentManager, (String) null);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}