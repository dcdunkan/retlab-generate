package in.etuwa.app.ui.examregistration.exammain;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.itextpdf.svg.SvgConstants;
import defpackage.ExamMainAdapter;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentExamMainBinding;
import in.etuwa.app.ui.base.BaseFragment;
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

/* compiled from: ExamMainFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020\u001aH\u0014J\b\u0010(\u001a\u00020\u001aH\u0014J\b\u0010)\u001a\u00020\u001aH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lin/etuwa/app/ui/examregistration/exammain/ExamMainFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentExamMainBinding;", "adapter", "LExamMainAdapter;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentExamMainBinding;", "examMainViewModel", "Lin/etuwa/app/ui/examregistration/exammain/ExamMainViewModel;", "getExamMainViewModel", "()Lin/etuwa/app/ui/examregistration/exammain/ExamMainViewModel;", "examMainViewModel$delegate", "Lkotlin/Lazy;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "hideBaseView", "", "hideProgress", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExamMainFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamMainBinding _binding;
    private ExamMainAdapter adapter;

    /* renamed from: examMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examMainViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @JvmStatic
    public static final ExamMainFragment newInstance() {
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

    public ExamMainFragment() {
        final ExamMainFragment examMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.exammain.ExamMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(examMainFragment, Reflection.getOrCreateKotlinClass(ExamMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.exammain.ExamMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.exammain.ExamMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ExamMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamMainFragment examMainFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.exammain.ExamMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = examMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final ExamMainViewModel getExamMainViewModel() {
        return (ExamMainViewModel) this.examMainViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentExamMainBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ExamMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/examregistration/exammain/ExamMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/exammain/ExamMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamMainFragment newInstance() {
            return new ExamMainFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentExamMainBinding.inflate(inflater, container, false);
        FragmentExamMainBinding fragmentExamMainBinding = get_binding();
        if (fragmentExamMainBinding != null) {
            fragmentExamMainBinding.setExamMainViewModel(getExamMainViewModel());
        }
        FragmentExamMainBinding fragmentExamMainBinding2 = get_binding();
        if (fragmentExamMainBinding2 != null) {
            fragmentExamMainBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamMainBinding fragmentExamMainBinding3 = get_binding();
        View root = fragmentExamMainBinding3 != null ? fragmentExamMainBinding3.getRoot() : null;
        Intrinsics.checkNotNull(root);
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("University Exam");
        }
        this.adapter = new ExamMainAdapter(this);
        FragmentExamMainBinding fragmentExamMainBinding = get_binding();
        ViewPager2 viewPager2 = fragmentExamMainBinding != null ? fragmentExamMainBinding.examPager : null;
        if (viewPager2 != null) {
            ExamMainAdapter examMainAdapter = this.adapter;
            if (examMainAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                examMainAdapter = null;
            }
            viewPager2.setAdapter(examMainAdapter);
        }
        FragmentExamMainBinding fragmentExamMainBinding2 = get_binding();
        TabLayout tabLayout = fragmentExamMainBinding2 != null ? fragmentExamMainBinding2.tabs : null;
        Intrinsics.checkNotNull(tabLayout);
        FragmentExamMainBinding fragmentExamMainBinding3 = get_binding();
        ViewPager2 viewPager22 = fragmentExamMainBinding3 != null ? fragmentExamMainBinding3.examPager : null;
        Intrinsics.checkNotNull(viewPager22);
        new TabLayoutMediator(tabLayout, viewPager22, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.etuwa.app.ui.examregistration.exammain.ExamMainFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                ExamMainFragment.setUp$lambda$0(ExamMainFragment.this, tab, i);
            }
        }).attach();
        getPreference().setNewLogin(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ExamMainFragment this$0, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        ExamMainAdapter examMainAdapter = this$0.adapter;
        if (examMainAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            examMainAdapter = null;
        }
        tab.setText(examMainAdapter.getPageTitle(i));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}