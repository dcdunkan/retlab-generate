package in.etuwa.app.ui.result.university;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import in.etuwa.app.databinding.UniversityFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
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

/* compiled from: UniversityFragment.kt */
/* loaded from: classes5.dex */
public final class UniversityFragment extends BaseFragment implements SemListDialog.SemDialogCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UniversityFragmentBinding _binding;
    private UniversityAdapter adapter;

    /* renamed from: universityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy universityViewModel;

    /* compiled from: UniversityFragment.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(UniversityViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final UniversityViewModel getUniversityViewModel() {
        return (UniversityViewModel) this.universityViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final UniversityFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: UniversityFragment.kt */
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
        listenResponse();
        UniversityFragmentBinding universityFragmentBinding3 = get_binding();
        if (universityFragmentBinding3 == null || (floatingActionButton = universityFragmentBinding3.fabUniv) == null) {
            return;
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityFragment.setUp$lambda$0(UniversityFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(UniversityFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialog newInstance = SemListDialog.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getUniversityViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.university.UniversityFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityFragment.listenResponse$lambda$2(UniversityFragment.this, (Resource) obj);
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

    @Override // in.etuwa.app.ui.result.university.semlistdialog.SemListDialog.SemDialogCallBack
    public void loadSelectedSem(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getUniversityViewModel().getResult(id);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}