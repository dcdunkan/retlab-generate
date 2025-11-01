package in.etuwa.app.ui.subject.coverage;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subject.coverage.SubCoverage;
import in.etuwa.app.data.model.subject.coverage.SubCoverageResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SubjectCoverageFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SubjectCoverageFragment.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u001a\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010*\u001a\u00020\u001bH\u0014J\b\u0010+\u001a\u00020\u001bH\u0014J\b\u0010,\u001a\u00020\u001bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lin/etuwa/app/ui/subject/coverage/SubjectCoverageFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/SubjectCoverageFragmentBinding;", "adapter", "Lin/etuwa/app/ui/subject/coverage/SubjectCoverageAdapter;", "getAdapter", "()Lin/etuwa/app/ui/subject/coverage/SubjectCoverageAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/SubjectCoverageFragmentBinding;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", StoreFragmentKt.SUB_ID, "", "subjectCoverageViewModel", "Lin/etuwa/app/ui/subject/coverage/SubjectCoverageViewModel;", "getSubjectCoverageViewModel", "()Lin/etuwa/app/ui/subject/coverage/SubjectCoverageViewModel;", "subjectCoverageViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubjectCoverageFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SubjectCoverageFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String subId;

    /* renamed from: subjectCoverageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subjectCoverageViewModel;

    @JvmStatic
    public static final SubjectCoverageFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SubjectCoverageFragment() {
        final SubjectCoverageFragment subjectCoverageFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(subjectCoverageFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.subjectCoverageViewModel = FragmentViewModelLazyKt.createViewModelLazy(subjectCoverageFragment, Reflection.getOrCreateKotlinClass(SubjectCoverageViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SubjectCoverageViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SubjectCoverageFragment subjectCoverageFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SubjectCoverageAdapter>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subject.coverage.SubjectCoverageAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectCoverageAdapter invoke() {
                ComponentCallbacks componentCallbacks = subjectCoverageFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectCoverageAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = subjectCoverageFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final SubjectCoverageViewModel getSubjectCoverageViewModel() {
        return (SubjectCoverageViewModel) this.subjectCoverageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectCoverageAdapter getAdapter() {
        return (SubjectCoverageAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final SubjectCoverageFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: SubjectCoverageFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/subject/coverage/SubjectCoverageFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subject/coverage/SubjectCoverageFragment;", StoreFragmentKt.SUB_ID, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubjectCoverageFragment newInstance(String subId) {
            Intrinsics.checkNotNullParameter(subId, "subId");
            SubjectCoverageFragment subjectCoverageFragment = new SubjectCoverageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sub", subId);
            subjectCoverageFragment.setArguments(bundle);
            return subjectCoverageFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.subId = arguments.getString("sub");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SubjectCoverageFragmentBinding.inflate(inflater, container, false);
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding = get_binding();
        if (subjectCoverageFragmentBinding != null) {
            subjectCoverageFragmentBinding.setSubjectCoverageViewModel(getSubjectCoverageViewModel());
        }
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding2 = get_binding();
        if (subjectCoverageFragmentBinding2 != null) {
            subjectCoverageFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding3 = get_binding();
        if (subjectCoverageFragmentBinding3 != null) {
            return subjectCoverageFragmentBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        TextView textView;
        TextView textView2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.sub_coverage));
        }
        hideBaseView();
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding = get_binding();
        RecyclerView recyclerView = subjectCoverageFragmentBinding != null ? subjectCoverageFragmentBinding.rvSubCoverage : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding2 = get_binding();
        if (subjectCoverageFragmentBinding2 != null && (textView2 = subjectCoverageFragmentBinding2.covered) != null) {
            textView2.setBackgroundColor(Color.rgb(34, 139, 34));
        }
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding3 = get_binding();
        if (subjectCoverageFragmentBinding3 != null && (textView = subjectCoverageFragmentBinding3.notCovered) != null) {
            textView.setBackgroundColor(Color.rgb(225, 51, 0));
        }
        SubjectCoverageViewModel subjectCoverageViewModel = getSubjectCoverageViewModel();
        String str = this.subId;
        Intrinsics.checkNotNull(str);
        subjectCoverageViewModel.getCoverage(str, getPreference().getBatchId());
        listenResponse();
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding4 = get_binding();
        if (subjectCoverageFragmentBinding4 == null || (swipeRefreshLayout = subjectCoverageFragmentBinding4.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SubjectCoverageFragment.setUp$lambda$1(SubjectCoverageFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SubjectCoverageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SubjectCoverageViewModel subjectCoverageViewModel = this$0.getSubjectCoverageViewModel();
        String str = this$0.subId;
        Intrinsics.checkNotNull(str);
        subjectCoverageViewModel.getCoverage(str, this$0.getPreference().getBatchId());
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = subjectCoverageFragmentBinding != null ? subjectCoverageFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getSubjectCoverageViewModel().getResponse().observe(getViewLifecycleOwner(), new SubjectCoverageFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SubCoverageResponse>, Unit>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment$listenResponse$1

            /* compiled from: SubjectCoverageFragment.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SubCoverageResponse> resource) {
                invoke2((Resource<SubCoverageResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SubCoverageResponse> resource) {
                SubjectCoverageAdapter adapter;
                SubjectCoverageFragmentBinding subjectCoverageFragmentBinding;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    SubjectCoverageFragment.this.hideProgress();
                    SubCoverageResponse data = resource.getData();
                    if (data != null) {
                        SubjectCoverageFragment subjectCoverageFragment = SubjectCoverageFragment.this;
                        subjectCoverageFragment.showBaseView();
                        adapter = subjectCoverageFragment.getAdapter();
                        ArrayList<SubCoverage> coverage = data.getCoverage();
                        Context requireContext = subjectCoverageFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        adapter.addItems(coverage, requireContext);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    SubjectCoverageFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    SubjectCoverageFragment.this.hideProgress();
                    SubjectCoverageFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                SubjectCoverageFragment.this.hideProgress();
                SubjectCoverageFragment.this.showBaseView();
                subjectCoverageFragmentBinding = SubjectCoverageFragment.this.get_binding();
                if (subjectCoverageFragmentBinding == null || (recyclerView = subjectCoverageFragmentBinding.rvSubCoverage) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding = get_binding();
        if (subjectCoverageFragmentBinding == null || (recyclerView = subjectCoverageFragmentBinding.rvSubCoverage) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        SubjectCoverageFragmentBinding subjectCoverageFragmentBinding = get_binding();
        if (subjectCoverageFragmentBinding == null || (recyclerView = subjectCoverageFragmentBinding.rvSubCoverage) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}