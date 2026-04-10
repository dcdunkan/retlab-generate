package in.etuwa.app.ui.timetable.change;

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
import in.etuwa.app.data.model.timetable.change.ChangeTimeTableResponse;
import in.etuwa.app.databinding.ChangeInTimetableFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.timetable.special.SpecialClassFragment;
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

/* JADX INFO: compiled from: ChangeInTimetableFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ChangeInTimetableFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ChangeInTimetableFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: changeInTimetableViewModel$delegate, reason: from kotlin metadata */
    private final Lazy changeInTimetableViewModel;

    /* JADX INFO: compiled from: ChangeInTimetableFragment.kt */
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

    public ChangeInTimetableFragment() {
        final ChangeInTimetableFragment changeInTimetableFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return changeInTimetableFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(changeInTimetableFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.changeInTimetableViewModel = FragmentViewModelLazyKt.createViewModelLazy(changeInTimetableFragment, Reflection.getOrCreateKotlinClass(ChangeInTimetableViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ChangeInTimetableViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ChangeInTimetableFragment changeInTimetableFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ChangeInTimetableAdapter>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.timetable.change.ChangeInTimetableAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ChangeInTimetableAdapter invoke() {
                ComponentCallbacks componentCallbacks = changeInTimetableFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ChangeInTimetableAdapter.class), b2, b3);
            }
        });
    }

    private final ChangeInTimetableViewModel getChangeInTimetableViewModel() {
        return (ChangeInTimetableViewModel) this.changeInTimetableViewModel.getValue();
    }

    private final ChangeInTimetableAdapter getAdapter() {
        return (ChangeInTimetableAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final ChangeInTimetableFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: ChangeInTimetableFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/timetable/change/ChangeInTimetableFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/timetable/special/SpecialClassFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        this._binding = ChangeInTimetableFragmentBinding.inflate(inflater, container, false);
        ChangeInTimetableFragmentBinding changeInTimetableFragmentBinding = get_binding();
        if (changeInTimetableFragmentBinding != null) {
            changeInTimetableFragmentBinding.setChangeInTimetableViewModel(getChangeInTimetableViewModel());
        }
        ChangeInTimetableFragmentBinding changeInTimetableFragmentBinding2 = get_binding();
        if (changeInTimetableFragmentBinding2 != null) {
            changeInTimetableFragmentBinding2.setLifecycleOwner(this);
        }
        ChangeInTimetableFragmentBinding changeInTimetableFragmentBinding3 = get_binding();
        if (changeInTimetableFragmentBinding3 != null) {
            return changeInTimetableFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.changeintimetable));
        }
        ChangeInTimetableFragmentBinding changeInTimetableFragmentBinding = get_binding();
        RecyclerView recyclerView = changeInTimetableFragmentBinding != null ? changeInTimetableFragmentBinding.rvChangeTimetable : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        hideBaseView();
        listenResponse();
    }

    private final void listenResponse() {
        getChangeInTimetableViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChangeInTimetableFragment.listenResponse$lambda$1(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$1(ChangeInTimetableFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<ChangeTimeTableResponse> arrayList = (ArrayList) resource.getData();
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
        ChangeInTimetableFragmentBinding changeInTimetableFragmentBinding = this$0.get_binding();
        if (changeInTimetableFragmentBinding == null || (recyclerView = changeInTimetableFragmentBinding.rvChangeTimetable) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        ChangeInTimetableFragmentBinding changeInTimetableFragmentBinding = get_binding();
        RecyclerView recyclerView = changeInTimetableFragmentBinding != null ? changeInTimetableFragmentBinding.rvChangeTimetable : null;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        ChangeInTimetableFragmentBinding changeInTimetableFragmentBinding = get_binding();
        RecyclerView recyclerView = changeInTimetableFragmentBinding != null ? changeInTimetableFragmentBinding.rvChangeTimetable : null;
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