package in.etuwa.app.ui.timetable.special;

import android.content.ComponentCallbacks;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.timetable.special.SpecialResponse;
import in.etuwa.app.databinding.SpecialClassFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
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

/* compiled from: SpecialClassFragment.kt */
/* loaded from: classes5.dex */
public final class SpecialClassFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SpecialClassFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: specialClassViewModel$delegate, reason: from kotlin metadata */
    private final Lazy specialClassViewModel;

    /* compiled from: SpecialClassFragment.kt */
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
    public static final SpecialClassFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SpecialClassFragment() {
        final SpecialClassFragment specialClassFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.timetable.special.SpecialClassFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(specialClassFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.specialClassViewModel = FragmentViewModelLazyKt.createViewModelLazy(specialClassFragment, Reflection.getOrCreateKotlinClass(SpecialClassViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.timetable.special.SpecialClassFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.timetable.special.SpecialClassFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SpecialClassViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SpecialClassFragment specialClassFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SpecialClassAdapter>() { // from class: in.etuwa.app.ui.timetable.special.SpecialClassFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.timetable.special.SpecialClassAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SpecialClassAdapter invoke() {
                ComponentCallbacks componentCallbacks = specialClassFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SpecialClassAdapter.class), b2, b3);
            }
        });
    }

    private final SpecialClassViewModel getSpecialClassViewModel() {
        return (SpecialClassViewModel) this.specialClassViewModel.getValue();
    }

    private final SpecialClassAdapter getAdapter() {
        return (SpecialClassAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final SpecialClassFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: SpecialClassFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/timetable/special/SpecialClassFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/timetable/special/SpecialClassFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SpecialClassFragment newInstance() {
            return new SpecialClassFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SpecialClassFragmentBinding.inflate(inflater, container, false);
        SpecialClassFragmentBinding specialClassFragmentBinding = get_binding();
        if (specialClassFragmentBinding != null) {
            specialClassFragmentBinding.setSpecialClassViewModel(getSpecialClassViewModel());
        }
        SpecialClassFragmentBinding specialClassFragmentBinding2 = get_binding();
        if (specialClassFragmentBinding2 != null) {
            specialClassFragmentBinding2.setLifecycleOwner(this);
        }
        SpecialClassFragmentBinding specialClassFragmentBinding3 = get_binding();
        if (specialClassFragmentBinding3 != null) {
            return specialClassFragmentBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.specialclass));
        }
        SpecialClassFragmentBinding specialClassFragmentBinding = get_binding();
        RecyclerView recyclerView = specialClassFragmentBinding != null ? specialClassFragmentBinding.rvSpecialTimetable : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        hideBaseView();
        listenResponse();
    }

    private final void listenResponse() {
        getSpecialClassViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.timetable.special.SpecialClassFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpecialClassFragment.listenResponse$lambda$1(SpecialClassFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$1(SpecialClassFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<SpecialResponse> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(arrayList);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.showBaseView();
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        SpecialClassFragmentBinding specialClassFragmentBinding = this$0.get_binding();
        if (specialClassFragmentBinding == null || (recyclerView = specialClassFragmentBinding.rvSpecialTimetable) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        SpecialClassFragmentBinding specialClassFragmentBinding = get_binding();
        RecyclerView recyclerView = specialClassFragmentBinding != null ? specialClassFragmentBinding.rvSpecialTimetable : null;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        SpecialClassFragmentBinding specialClassFragmentBinding = get_binding();
        RecyclerView recyclerView = specialClassFragmentBinding != null ? specialClassFragmentBinding.rvSpecialTimetable : null;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}