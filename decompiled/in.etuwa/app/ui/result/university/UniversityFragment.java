package in.etuwa.app.ui.result.university;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.result.univ.UnivResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.UniversityFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialog;
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

/* JADX INFO: compiled from: UniversityFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class UniversityFragment extends BaseFragment implements SemListDialog.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UniversityFragmentBinding _binding;
    private UniversityAdapter adapter;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: universityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy universityViewModel;

    /* JADX INFO: compiled from: UniversityFragment.kt */
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
    public static final UniversityFragment newInstance() {
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

    public UniversityFragment() {
        final UniversityFragment universityFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return universityFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(universityFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.universityViewModel = FragmentViewModelLazyKt.createViewModelLazy(universityFragment, Reflection.getOrCreateKotlinClass(UniversityViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(UniversityViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final UniversityFragment universityFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = universityFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final UniversityViewModel getUniversityViewModel() {
        return (UniversityViewModel) this.universityViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final UniversityFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: UniversityFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/result/university/UniversityFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/university/UniversityFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UniversityFragment newInstance() {
            return new UniversityFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = UniversityFragmentBinding.inflate(inflater, container, false);
        UniversityFragmentBinding universityFragmentBinding = get_binding();
        if (universityFragmentBinding != null) {
            universityFragmentBinding.setUniversityViewModel(getUniversityViewModel());
        }
        UniversityFragmentBinding universityFragmentBinding2 = get_binding();
        if (universityFragmentBinding2 != null) {
            universityFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        UniversityFragmentBinding universityFragmentBinding3 = get_binding();
        if (universityFragmentBinding3 != null) {
            return universityFragmentBinding3.getRoot();
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
        FloatingActionButton floatingActionButton;
        TabLayout tabLayout;
        UniversityFragmentBinding universityFragmentBinding = get_binding();
        if (universityFragmentBinding != null && (tabLayout = universityFragmentBinding.univTabs) != null) {
            UniversityFragmentBinding universityFragmentBinding2 = get_binding();
            tabLayout.setupWithViewPager(universityFragmentBinding2 != null ? universityFragmentBinding2.univPager : null);
        }
        UniversityFragmentBinding universityFragmentBinding3 = get_binding();
        TextView textView = universityFragmentBinding3 != null ? universityFragmentBinding3.internalSemText : null;
        if (textView != null) {
            textView.setText(getPreference().getUserSem());
        }
        listenResponse();
        UniversityFragmentBinding universityFragmentBinding4 = get_binding();
        if (universityFragmentBinding4 == null || (floatingActionButton = universityFragmentBinding4.fabUniv) == null) {
            return;
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityFragment.setUp$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(UniversityFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialog semListDialogNewInstance = SemListDialog.INSTANCE.newInstance();
        semListDialogNewInstance.setCallBack(this$0);
        semListDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getUniversityViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityFragment.listenResponse$lambda$2(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(UniversityFragment this$0, Resource resource) {
        FloatingActionButton fabUniv;
        FloatingActionButton floatingActionButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            UniversityFragmentBinding universityFragmentBinding = this$0.get_binding();
            if (universityFragmentBinding == null || (floatingActionButton = universityFragmentBinding.fabUniv) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(floatingActionButton, message);
            return;
        }
        this$0.hideProgress();
        UnivResponse univResponse = (UnivResponse) resource.getData();
        if (univResponse != null) {
            if (univResponse.getLogin()) {
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                this$0.adapter = new UniversityAdapter(childFragmentManager);
                UniversityFragmentBinding universityFragmentBinding2 = this$0.get_binding();
                UniversityAdapter universityAdapter = null;
                ViewPager viewPager = universityFragmentBinding2 != null ? universityFragmentBinding2.univPager : null;
                if (viewPager != null) {
                    UniversityAdapter universityAdapter2 = this$0.adapter;
                    if (universityAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        universityAdapter2 = null;
                    }
                    viewPager.setAdapter(universityAdapter2);
                }
                UniversityAdapter universityAdapter3 = this$0.adapter;
                if (universityAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    universityAdapter = universityAdapter3;
                }
                universityAdapter.addItems(univResponse.getDetails(), univResponse.getSubjects(), univResponse.getUnivExams());
                return;
            }
            UniversityFragmentBinding universityFragmentBinding3 = this$0.get_binding();
            if (universityFragmentBinding3 == null || (fabUniv = universityFragmentBinding3.fabUniv) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(fabUniv, "fabUniv");
            ToastExtKt.showErrorToast(fabUniv, univResponse.getError());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.result.university.semlistdialog.SemListDialog.SemDialogCallBack
    public void loadSelectedSem(String id, String semName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        getUniversityViewModel().getResult(id);
    }

    public final void onSemesterSelected(String id, String semName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        getUniversityViewModel().getResult(id);
        UniversityFragmentBinding universityFragmentBinding = get_binding();
        TextView textView = universityFragmentBinding != null ? universityFragmentBinding.internalSemText : null;
        if (textView == null) {
            return;
        }
        textView.setText(semName);
    }
}