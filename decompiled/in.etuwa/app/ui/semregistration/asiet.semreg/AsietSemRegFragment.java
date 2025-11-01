package in.etuwa.app.ui.semregistration.asiet.semreg;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.textfield.TextInputEditText;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.store.departmentlist.DepartmentList;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentAsietSemRegBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.store.adapters.StoreSemesterAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AsietSemRegFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020\u0019H\u0014J\b\u0010(\u001a\u00020\u0019H\u0014J\b\u0010)\u001a\u00020\u0019H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lin/etuwa/app/ui/semregistration/asiet/semreg/AsietSemRegFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentAsietSemRegBinding;", "asietSemRegViewModel", "Lin/etuwa/app/ui/semregistration/asiet/semreg/AsietSemRegViewModel;", "getAsietSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/asiet/semreg/AsietSemRegViewModel;", "asietSemRegViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentAsietSemRegBinding;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "spinnerAdapter", "Lin/etuwa/app/ui/store/adapters/StoreSemesterAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/store/adapters/StoreSemesterAdapter;", "spinnerAdapter$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsietSemRegFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentAsietSemRegBinding _binding;

    /* renamed from: asietSemRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy asietSemRegViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: AsietSemRegFragment.kt */
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
    public static final AsietSemRegFragment newInstance() {
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

    public AsietSemRegFragment() {
        final AsietSemRegFragment asietSemRegFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(asietSemRegFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.asietSemRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(asietSemRegFragment, Reflection.getOrCreateKotlinClass(AsietSemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AsietSemRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AsietSemRegFragment asietSemRegFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = asietSemRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AsietSemRegFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<StoreSemesterAdapter>() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.store.adapters.StoreSemesterAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final StoreSemesterAdapter invoke() {
                ComponentCallbacks componentCallbacks = asietSemRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoreSemesterAdapter.class), b4, function02);
            }
        });
    }

    private final AsietSemRegViewModel getAsietSemRegViewModel() {
        return (AsietSemRegViewModel) this.asietSemRegViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentAsietSemRegBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    private final StoreSemesterAdapter getSpinnerAdapter() {
        return (StoreSemesterAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: AsietSemRegFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/semregistration/asiet/semreg/AsietSemRegFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/asiet/semreg/AsietSemRegFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AsietSemRegFragment newInstance() {
            return new AsietSemRegFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentAsietSemRegBinding.inflate(inflater, container, false);
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding = get_binding();
        if (fragmentAsietSemRegBinding != null) {
            fragmentAsietSemRegBinding.setAsietSemRegViewModel(getAsietSemRegViewModel());
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding2 = get_binding();
        if (fragmentAsietSemRegBinding2 != null) {
            fragmentAsietSemRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding3 = get_binding();
        if (fragmentAsietSemRegBinding3 != null) {
            return fragmentAsietSemRegBinding3.getRoot();
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
        Button button;
        TextView textView;
        TextView textView2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("New Registration");
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        listenResponse();
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding = get_binding();
        Spinner spinner = fragmentAsietSemRegBinding != null ? fragmentAsietSemRegBinding.spinnerSemesterLastAttended : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getSpinnerAdapter().addItems(CollectionsKt.arrayListOf(new DepartmentList(getPreference().getUserSemId(), getPreference().getUserSem())));
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding2 = get_binding();
        if (fragmentAsietSemRegBinding2 != null && (textView2 = fragmentAsietSemRegBinding2.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AsietSemRegFragment.setUp$lambda$0(AsietSemRegFragment.this, view);
                }
            });
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding3 = get_binding();
        if (fragmentAsietSemRegBinding3 != null && (textView = fragmentAsietSemRegBinding3.removeBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AsietSemRegFragment.setUp$lambda$1(AsietSemRegFragment.this, view);
                }
            });
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding4 = get_binding();
        if (fragmentAsietSemRegBinding4 == null || (button = fragmentAsietSemRegBinding4.registerBtn) == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AsietSemRegFragment.setUp$lambda$2(AsietSemRegFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(AsietSemRegFragment this$0, View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding = this$0.get_binding();
        if ((fragmentAsietSemRegBinding == null || (linearLayout7 = fragmentAsietSemRegBinding.attendanceOne) == null || linearLayout7.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding2 = this$0.get_binding();
            if ((fragmentAsietSemRegBinding2 == null || (linearLayout6 = fragmentAsietSemRegBinding2.attendanceTwo) == null || linearLayout6.getVisibility() != 0) ? false : true) {
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding3 = this$0.get_binding();
                if ((fragmentAsietSemRegBinding3 == null || (linearLayout5 = fragmentAsietSemRegBinding3.attendanceThree) == null || linearLayout5.getVisibility() != 0) ? false : true) {
                    FragmentAsietSemRegBinding fragmentAsietSemRegBinding4 = this$0.get_binding();
                    LinearLayout linearLayout8 = fragmentAsietSemRegBinding4 != null ? fragmentAsietSemRegBinding4.attendanceThree : null;
                    if (linearLayout8 != null) {
                        linearLayout8.setVisibility(0);
                    }
                    FragmentAsietSemRegBinding fragmentAsietSemRegBinding5 = this$0.get_binding();
                    LinearLayout linearLayout9 = fragmentAsietSemRegBinding5 != null ? fragmentAsietSemRegBinding5.attendanceTwo : null;
                    if (linearLayout9 != null) {
                        linearLayout9.setVisibility(0);
                    }
                    FragmentAsietSemRegBinding fragmentAsietSemRegBinding6 = this$0.get_binding();
                    linearLayout = fragmentAsietSemRegBinding6 != null ? fragmentAsietSemRegBinding6.attendanceThree : null;
                    if (linearLayout == null) {
                        return;
                    }
                    linearLayout.setVisibility(0);
                    return;
                }
            }
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding7 = this$0.get_binding();
        if ((fragmentAsietSemRegBinding7 == null || (linearLayout4 = fragmentAsietSemRegBinding7.attendanceOne) == null || linearLayout4.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding8 = this$0.get_binding();
            if ((fragmentAsietSemRegBinding8 == null || (linearLayout3 = fragmentAsietSemRegBinding8.attendanceTwo) == null || linearLayout3.getVisibility() != 0) ? false : true) {
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding9 = this$0.get_binding();
                LinearLayout linearLayout10 = fragmentAsietSemRegBinding9 != null ? fragmentAsietSemRegBinding9.attendanceOne : null;
                if (linearLayout10 != null) {
                    linearLayout10.setVisibility(0);
                }
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding10 = this$0.get_binding();
                LinearLayout linearLayout11 = fragmentAsietSemRegBinding10 != null ? fragmentAsietSemRegBinding10.attendanceTwo : null;
                if (linearLayout11 != null) {
                    linearLayout11.setVisibility(0);
                }
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding11 = this$0.get_binding();
                linearLayout = fragmentAsietSemRegBinding11 != null ? fragmentAsietSemRegBinding11.attendanceThree : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding12 = this$0.get_binding();
        if ((fragmentAsietSemRegBinding12 == null || (linearLayout2 = fragmentAsietSemRegBinding12.attendanceOne) == null || linearLayout2.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding13 = this$0.get_binding();
            LinearLayout linearLayout12 = fragmentAsietSemRegBinding13 != null ? fragmentAsietSemRegBinding13.attendanceOne : null;
            if (linearLayout12 != null) {
                linearLayout12.setVisibility(0);
            }
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding14 = this$0.get_binding();
            LinearLayout linearLayout13 = fragmentAsietSemRegBinding14 != null ? fragmentAsietSemRegBinding14.attendanceTwo : null;
            if (linearLayout13 != null) {
                linearLayout13.setVisibility(0);
            }
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding15 = this$0.get_binding();
            linearLayout = fragmentAsietSemRegBinding15 != null ? fragmentAsietSemRegBinding15.attendanceThree : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout14 = fragmentAsietSemRegBinding16 != null ? fragmentAsietSemRegBinding16.attendanceOne : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(0);
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout15 = fragmentAsietSemRegBinding17 != null ? fragmentAsietSemRegBinding17.attendanceTwo : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding18 = this$0.get_binding();
        linearLayout = fragmentAsietSemRegBinding18 != null ? fragmentAsietSemRegBinding18.attendanceThree : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AsietSemRegFragment this$0, View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding = this$0.get_binding();
        if ((fragmentAsietSemRegBinding == null || (linearLayout6 = fragmentAsietSemRegBinding.attendanceOne) == null || linearLayout6.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding2 = this$0.get_binding();
            if ((fragmentAsietSemRegBinding2 == null || (linearLayout5 = fragmentAsietSemRegBinding2.attendanceTwo) == null || linearLayout5.getVisibility() != 0) ? false : true) {
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding3 = this$0.get_binding();
                if ((fragmentAsietSemRegBinding3 == null || (linearLayout4 = fragmentAsietSemRegBinding3.attendanceThree) == null || linearLayout4.getVisibility() != 0) ? false : true) {
                    FragmentAsietSemRegBinding fragmentAsietSemRegBinding4 = this$0.get_binding();
                    LinearLayout linearLayout7 = fragmentAsietSemRegBinding4 != null ? fragmentAsietSemRegBinding4.attendanceThree : null;
                    if (linearLayout7 != null) {
                        linearLayout7.setVisibility(8);
                    }
                    FragmentAsietSemRegBinding fragmentAsietSemRegBinding5 = this$0.get_binding();
                    LinearLayout linearLayout8 = fragmentAsietSemRegBinding5 != null ? fragmentAsietSemRegBinding5.attendanceTwo : null;
                    if (linearLayout8 != null) {
                        linearLayout8.setVisibility(0);
                    }
                    FragmentAsietSemRegBinding fragmentAsietSemRegBinding6 = this$0.get_binding();
                    linearLayout = fragmentAsietSemRegBinding6 != null ? fragmentAsietSemRegBinding6.attendanceOne : null;
                    if (linearLayout == null) {
                        return;
                    }
                    linearLayout.setVisibility(0);
                    return;
                }
            }
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding7 = this$0.get_binding();
        if ((fragmentAsietSemRegBinding7 == null || (linearLayout3 = fragmentAsietSemRegBinding7.attendanceOne) == null || linearLayout3.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding8 = this$0.get_binding();
            if ((fragmentAsietSemRegBinding8 == null || (linearLayout2 = fragmentAsietSemRegBinding8.attendanceTwo) == null || linearLayout2.getVisibility() != 0) ? false : true) {
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding9 = this$0.get_binding();
                LinearLayout linearLayout9 = fragmentAsietSemRegBinding9 != null ? fragmentAsietSemRegBinding9.attendanceOne : null;
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                }
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding10 = this$0.get_binding();
                LinearLayout linearLayout10 = fragmentAsietSemRegBinding10 != null ? fragmentAsietSemRegBinding10.attendanceTwo : null;
                if (linearLayout10 != null) {
                    linearLayout10.setVisibility(8);
                }
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding11 = this$0.get_binding();
                linearLayout = fragmentAsietSemRegBinding11 != null ? fragmentAsietSemRegBinding11.attendanceThree : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(8);
                return;
            }
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding12 = this$0.get_binding();
        LinearLayout linearLayout11 = fragmentAsietSemRegBinding12 != null ? fragmentAsietSemRegBinding12.attendanceOne : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout12 = fragmentAsietSemRegBinding13 != null ? fragmentAsietSemRegBinding13.attendanceTwo : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding14 = this$0.get_binding();
        linearLayout = fragmentAsietSemRegBinding14 != null ? fragmentAsietSemRegBinding14.attendanceThree : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AsietSemRegFragment this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        LinearLayout linearLayout;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        LinearLayout linearLayout2;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        LinearLayout linearLayout3;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        hashMap.clear();
        HashMap hashMap2 = hashMap;
        hashMap2.put("SemesterRegistration[semester_id]", this$0.getPreference().getUserSemId());
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding = this$0.get_binding();
        Editable editable = null;
        hashMap2.put("SemesterRegistration[address]", String.valueOf((fragmentAsietSemRegBinding == null || (textInputEditText12 = fragmentAsietSemRegBinding.etAddress) == null) ? null : textInputEditText12.getText()));
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding2 = this$0.get_binding();
        hashMap2.put("SemesterRegistration[phone_parent]", String.valueOf((fragmentAsietSemRegBinding2 == null || (textInputEditText11 = fragmentAsietSemRegBinding2.etParentNo) == null) ? null : textInputEditText11.getText()));
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding3 = this$0.get_binding();
        hashMap2.put("SemesterRegistration[parent_email]", String.valueOf((fragmentAsietSemRegBinding3 == null || (textInputEditText10 = fragmentAsietSemRegBinding3.etParentEmail) == null) ? null : textInputEditText10.getText()));
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding4 = this$0.get_binding();
        if ((fragmentAsietSemRegBinding4 == null || (linearLayout3 = fragmentAsietSemRegBinding4.attendanceOne) == null || linearLayout3.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding5 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[subject][0]", String.valueOf((fragmentAsietSemRegBinding5 == null || (textInputEditText9 = fragmentAsietSemRegBinding5.etSub1) == null) ? null : textInputEditText9.getText()));
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding6 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[subject][0]", String.valueOf((fragmentAsietSemRegBinding6 == null || (textInputEditText8 = fragmentAsietSemRegBinding6.etSub1) == null) ? null : textInputEditText8.getText()));
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding7 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[subject][0]", String.valueOf((fragmentAsietSemRegBinding7 == null || (textInputEditText7 = fragmentAsietSemRegBinding7.etSub1) == null) ? null : textInputEditText7.getText()));
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding8 = this$0.get_binding();
        if ((fragmentAsietSemRegBinding8 == null || (linearLayout2 = fragmentAsietSemRegBinding8.attendanceTwo) == null || linearLayout2.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding9 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[semester][1]", String.valueOf((fragmentAsietSemRegBinding9 == null || (textInputEditText6 = fragmentAsietSemRegBinding9.etSem2) == null) ? null : textInputEditText6.getText()));
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding10 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[subject][1]", String.valueOf((fragmentAsietSemRegBinding10 == null || (textInputEditText5 = fragmentAsietSemRegBinding10.etSub2) == null) ? null : textInputEditText5.getText()));
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding11 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[reason][1]", String.valueOf((fragmentAsietSemRegBinding11 == null || (textInputEditText4 = fragmentAsietSemRegBinding11.etReason2) == null) ? null : textInputEditText4.getText()));
        }
        FragmentAsietSemRegBinding fragmentAsietSemRegBinding12 = this$0.get_binding();
        if ((fragmentAsietSemRegBinding12 == null || (linearLayout = fragmentAsietSemRegBinding12.attendanceThree) == null || linearLayout.getVisibility() != 0) ? false : true) {
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding13 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[semester][2]", String.valueOf((fragmentAsietSemRegBinding13 == null || (textInputEditText3 = fragmentAsietSemRegBinding13.etSem3) == null) ? null : textInputEditText3.getText()));
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding14 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[subject][2]", String.valueOf((fragmentAsietSemRegBinding14 == null || (textInputEditText2 = fragmentAsietSemRegBinding14.etSub3) == null) ? null : textInputEditText2.getText()));
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding15 = this$0.get_binding();
            if (fragmentAsietSemRegBinding15 != null && (textInputEditText = fragmentAsietSemRegBinding15.etReason3) != null) {
                editable = textInputEditText.getText();
            }
            hashMap2.put("SemesterRegistration[reason][2]", String.valueOf(editable));
        }
        this$0.getAsietSemRegViewModel().addSemRegResponse(hashMap2);
    }

    private final void listenResponse() {
        getAsietSemRegViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AsietSemRegFragment.listenResponse$lambda$4(AsietSemRegFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(AsietSemRegFragment this$0, Resource resource) {
        Button registerBtn;
        Button registerBtn2;
        Button button;
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
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding = this$0.get_binding();
            if (fragmentAsietSemRegBinding == null || (button = fragmentAsietSemRegBinding.registerBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(button, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getLogin() && successResponse.getSuccess()) {
                FragmentAsietSemRegBinding fragmentAsietSemRegBinding2 = this$0.get_binding();
                if (fragmentAsietSemRegBinding2 == null || (registerBtn2 = fragmentAsietSemRegBinding2.registerBtn) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                ToastExtKt.showSuccessToast(registerBtn2, successResponse.getMessage());
                return;
            }
            FragmentAsietSemRegBinding fragmentAsietSemRegBinding3 = this$0.get_binding();
            if (fragmentAsietSemRegBinding3 == null || (registerBtn = fragmentAsietSemRegBinding3.registerBtn) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
            ToastExtKt.showErrorToast(registerBtn, successResponse.getError());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}