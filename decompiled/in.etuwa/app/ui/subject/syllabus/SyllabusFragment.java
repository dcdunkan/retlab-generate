package in.etuwa.app.ui.subject.syllabus;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subject.syllabus.Syllabus;
import in.etuwa.app.data.model.subject.syllabus.SyllabusResponse;
import in.etuwa.app.databinding.SyllabusFragmentBinding;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SyllabusFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010%\u001a\u00020\u0016H\u0014J\b\u0010&\u001a\u00020\u0016H\u0014J\b\u0010'\u001a\u00020\u0016H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lin/etuwa/app/ui/subject/syllabus/SyllabusFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/SyllabusFragmentBinding;", "adapter", "Lin/etuwa/app/ui/subject/syllabus/SyllabusAdapter;", "getAdapter", "()Lin/etuwa/app/ui/subject/syllabus/SyllabusAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/SyllabusFragmentBinding;", StoreFragmentKt.SUB_ID, "", "syllabusViewModel", "Lin/etuwa/app/ui/subject/syllabus/SyllabusViewModel;", "getSyllabusViewModel", "()Lin/etuwa/app/ui/subject/syllabus/SyllabusViewModel;", "syllabusViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SyllabusFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SyllabusFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String subId;

    /* renamed from: syllabusViewModel$delegate, reason: from kotlin metadata */
    private final Lazy syllabusViewModel;

    /* compiled from: SyllabusFragment.kt */
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
    public static final SyllabusFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SyllabusFragment() {
        final SyllabusFragment syllabusFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(syllabusFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.syllabusViewModel = FragmentViewModelLazyKt.createViewModelLazy(syllabusFragment, Reflection.getOrCreateKotlinClass(SyllabusViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SyllabusViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SyllabusFragment syllabusFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SyllabusAdapter>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subject.syllabus.SyllabusAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SyllabusAdapter invoke() {
                ComponentCallbacks componentCallbacks = syllabusFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SyllabusAdapter.class), b2, b3);
            }
        });
    }

    private final SyllabusViewModel getSyllabusViewModel() {
        return (SyllabusViewModel) this.syllabusViewModel.getValue();
    }

    private final SyllabusAdapter getAdapter() {
        return (SyllabusAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final SyllabusFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: SyllabusFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/subject/syllabus/SyllabusFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subject/syllabus/SyllabusFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SyllabusFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            SyllabusFragment syllabusFragment = new SyllabusFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sub", id);
            syllabusFragment.setArguments(bundle);
            return syllabusFragment;
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
        this._binding = SyllabusFragmentBinding.inflate(inflater, container, false);
        SyllabusFragmentBinding syllabusFragmentBinding = get_binding();
        if (syllabusFragmentBinding != null) {
            syllabusFragmentBinding.setSyllabusViewModel(getSyllabusViewModel());
        }
        SyllabusFragmentBinding syllabusFragmentBinding2 = get_binding();
        if (syllabusFragmentBinding2 != null) {
            syllabusFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SyllabusFragmentBinding syllabusFragmentBinding3 = get_binding();
        if (syllabusFragmentBinding3 != null) {
            return syllabusFragmentBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.syllabus));
        }
        hideBaseView();
        SyllabusFragmentBinding syllabusFragmentBinding = get_binding();
        RecyclerView recyclerView = syllabusFragmentBinding != null ? syllabusFragmentBinding.rvSyllabus : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        SyllabusViewModel syllabusViewModel = getSyllabusViewModel();
        String str = this.subId;
        Intrinsics.checkNotNull(str);
        syllabusViewModel.getSyllabus(str);
        listenResponse();
        SyllabusFragmentBinding syllabusFragmentBinding2 = get_binding();
        if (syllabusFragmentBinding2 == null || (swipeRefreshLayout = syllabusFragmentBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SyllabusFragment.setUp$lambda$1(SyllabusFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SyllabusFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyllabusViewModel syllabusViewModel = this$0.getSyllabusViewModel();
        String str = this$0.subId;
        Intrinsics.checkNotNull(str);
        syllabusViewModel.getSyllabus(str);
        SyllabusFragmentBinding syllabusFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = syllabusFragmentBinding != null ? syllabusFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getSyllabusViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SyllabusFragment.listenResponse$lambda$3(SyllabusFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(SyllabusFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SyllabusResponse syllabusResponse = (SyllabusResponse) resource.getData();
            if (syllabusResponse != null) {
                this$0.showBaseView();
                SyllabusAdapter adapter = this$0.getAdapter();
                ArrayList<Syllabus> syllabus = syllabusResponse.getSyllabus();
                Context requireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                adapter.addItems(syllabus, requireContext);
                return;
            }
            return;
        }
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
        SyllabusFragmentBinding syllabusFragmentBinding = this$0.get_binding();
        if (syllabusFragmentBinding == null || (recyclerView = syllabusFragmentBinding.rvSyllabus) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        SyllabusFragmentBinding syllabusFragmentBinding = get_binding();
        if (syllabusFragmentBinding == null || (recyclerView = syllabusFragmentBinding.rvSyllabus) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        SyllabusFragmentBinding syllabusFragmentBinding = get_binding();
        if (syllabusFragmentBinding == null || (recyclerView = syllabusFragmentBinding.rvSyllabus) == null) {
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