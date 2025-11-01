package in.etuwa.app.ui.programoutcome;

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
import in.etuwa.app.data.model.programoutcome.ProgramOutcomeResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentProgramOutcomeBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.programoutcome.adapters.ProgramEducationalAdapter;
import in.etuwa.app.ui.programoutcome.adapters.ProgramOutcomeAdapter;
import in.etuwa.app.ui.programoutcome.adapters.ProgramSpecificAdapter;
import in.etuwa.app.utils.RecycleExtKt;
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

/* compiled from: ProgramOutcomeFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001=B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020)H\u0014J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\u0012\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00107\u001a\u00020)H\u0016J\u001a\u00108\u001a\u00020)2\u0006\u00109\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010:\u001a\u00020)H\u0014J\b\u0010;\u001a\u00020)H\u0014J\b\u0010<\u001a\u00020)H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&¨\u0006>"}, d2 = {"Lin/etuwa/app/ui/programoutcome/ProgramOutcomeFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/programoutcome/adapters/ProgramOutcomeAdapter$CallBack;", "Lin/etuwa/app/ui/programoutcome/adapters/ProgramEducationalAdapter$CallBack;", "Lin/etuwa/app/ui/programoutcome/adapters/ProgramSpecificAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentProgramOutcomeBinding;", "adapter", "Lin/etuwa/app/ui/programoutcome/adapters/ProgramOutcomeAdapter;", "getAdapter", "()Lin/etuwa/app/ui/programoutcome/adapters/ProgramOutcomeAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "adapter2", "Lin/etuwa/app/ui/programoutcome/adapters/ProgramEducationalAdapter;", "getAdapter2", "()Lin/etuwa/app/ui/programoutcome/adapters/ProgramEducationalAdapter;", "adapter2$delegate", "adapter3", "Lin/etuwa/app/ui/programoutcome/adapters/ProgramSpecificAdapter;", "getAdapter3", "()Lin/etuwa/app/ui/programoutcome/adapters/ProgramSpecificAdapter;", "adapter3$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentProgramOutcomeBinding;", "id", "", "Ljava/lang/Integer;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "programOutcomeViewModel", "Lin/etuwa/app/ui/programoutcome/ProgramOutcomeViewModel;", "getProgramOutcomeViewModel", "()Lin/etuwa/app/ui/programoutcome/ProgramOutcomeViewModel;", "programOutcomeViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "listenResponse2", "listenResponse3", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProgramOutcomeFragment extends BaseFragment implements ProgramOutcomeAdapter.CallBack, ProgramEducationalAdapter.CallBack, ProgramSpecificAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentProgramOutcomeBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: adapter2$delegate, reason: from kotlin metadata */
    private final Lazy adapter2;

    /* renamed from: adapter3$delegate, reason: from kotlin metadata */
    private final Lazy adapter3;
    private Integer id;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: programOutcomeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy programOutcomeViewModel;

    /* compiled from: ProgramOutcomeFragment.kt */
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
    public static final ProgramOutcomeFragment newInstance(int i) {
        return INSTANCE.newInstance(i);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ProgramOutcomeFragment() {
        final ProgramOutcomeFragment programOutcomeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(programOutcomeFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.programOutcomeViewModel = FragmentViewModelLazyKt.createViewModelLazy(programOutcomeFragment, Reflection.getOrCreateKotlinClass(ProgramOutcomeViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ProgramOutcomeViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ProgramOutcomeFragment programOutcomeFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ProgramOutcomeAdapter>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.programoutcome.adapters.ProgramOutcomeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ProgramOutcomeAdapter invoke() {
                ComponentCallbacks componentCallbacks = programOutcomeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ProgramOutcomeAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<ProgramEducationalAdapter>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.programoutcome.adapters.ProgramEducationalAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ProgramEducationalAdapter invoke() {
                ComponentCallbacks componentCallbacks = programOutcomeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ProgramEducationalAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<ProgramSpecificAdapter>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.programoutcome.adapters.ProgramSpecificAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ProgramSpecificAdapter invoke() {
                ComponentCallbacks componentCallbacks = programOutcomeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ProgramSpecificAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = programOutcomeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b8, b9);
            }
        });
    }

    private final ProgramOutcomeViewModel getProgramOutcomeViewModel() {
        return (ProgramOutcomeViewModel) this.programOutcomeViewModel.getValue();
    }

    private final ProgramOutcomeAdapter getAdapter() {
        return (ProgramOutcomeAdapter) this.adapter.getValue();
    }

    private final ProgramEducationalAdapter getAdapter2() {
        return (ProgramEducationalAdapter) this.adapter2.getValue();
    }

    private final ProgramSpecificAdapter getAdapter3() {
        return (ProgramSpecificAdapter) this.adapter3.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentProgramOutcomeBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ProgramOutcomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/programoutcome/ProgramOutcomeFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/programoutcome/ProgramOutcomeFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProgramOutcomeFragment newInstance(int id) {
            ProgramOutcomeFragment programOutcomeFragment = new ProgramOutcomeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            programOutcomeFragment.setArguments(bundle);
            return programOutcomeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = Integer.valueOf(arguments.getInt("id"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentProgramOutcomeBinding.inflate(inflater, container, false);
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding = get_binding();
        if (fragmentProgramOutcomeBinding != null) {
            fragmentProgramOutcomeBinding.setProgramOutcomeViewModel(getProgramOutcomeViewModel());
        }
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding2 = get_binding();
        if (fragmentProgramOutcomeBinding2 != null) {
            fragmentProgramOutcomeBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding3 = get_binding();
        if (fragmentProgramOutcomeBinding3 != null) {
            return fragmentProgramOutcomeBinding3.getRoot();
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
        RecyclerView recyclerView;
        getPreference().setNewLogin(false);
        hideBaseView();
        Integer num = this.id;
        if (num != null && num.intValue() == 0) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setTitle("Program Outcomes");
            }
            FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding = get_binding();
            recyclerView = fragmentProgramOutcomeBinding != null ? fragmentProgramOutcomeBinding.rvOutcome : null;
            if (recyclerView != null) {
                recyclerView.setAdapter(getAdapter());
            }
            getAdapter().setCallBack(this);
            listenResponse();
        } else {
            Integer num2 = this.id;
            if (num2 != null && num2.intValue() == 1) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.setTitle("Program Educational Objectives");
                }
                FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding2 = get_binding();
                recyclerView = fragmentProgramOutcomeBinding2 != null ? fragmentProgramOutcomeBinding2.rvEducational : null;
                if (recyclerView != null) {
                    recyclerView.setAdapter(getAdapter2());
                }
                getAdapter2().setCallBack(this);
                listenResponse2();
            } else {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.setTitle("Program Specific Objectives");
                }
                FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding3 = get_binding();
                recyclerView = fragmentProgramOutcomeBinding3 != null ? fragmentProgramOutcomeBinding3.rvSpecific : null;
                if (recyclerView != null) {
                    recyclerView.setAdapter(getAdapter3());
                }
                getAdapter3().setCallBack(this);
                listenResponse3();
            }
        }
        getProgramOutcomeViewModel().getOutcomes();
    }

    private final void listenResponse() {
        getProgramOutcomeViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ProgramOutcomeFragment.listenResponse$lambda$2(ProgramOutcomeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(ProgramOutcomeFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ProgramOutcomeResponse programOutcomeResponse = (ProgramOutcomeResponse) resource.getData();
            if (programOutcomeResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(programOutcomeResponse.getPgm_outcomes());
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
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding = this$0.get_binding();
        if (fragmentProgramOutcomeBinding == null || (recyclerView = fragmentProgramOutcomeBinding.rvOutcome) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenResponse2() {
        getProgramOutcomeViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ProgramOutcomeFragment.listenResponse2$lambda$4(ProgramOutcomeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse2$lambda$4(ProgramOutcomeFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ProgramOutcomeResponse programOutcomeResponse = (ProgramOutcomeResponse) resource.getData();
            if (programOutcomeResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter2().addItems(programOutcomeResponse.getPgm_educational());
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
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding = this$0.get_binding();
        if (fragmentProgramOutcomeBinding == null || (recyclerView = fragmentProgramOutcomeBinding.rvOutcome) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenResponse3() {
        getProgramOutcomeViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ProgramOutcomeFragment.listenResponse3$lambda$6(ProgramOutcomeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse3$lambda$6(ProgramOutcomeFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ProgramOutcomeResponse programOutcomeResponse = (ProgramOutcomeResponse) resource.getData();
            if (programOutcomeResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter3().addItems(programOutcomeResponse.getPgm_specific());
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
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding = this$0.get_binding();
        if (fragmentProgramOutcomeBinding == null || (recyclerView = fragmentProgramOutcomeBinding.rvOutcome) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding = get_binding();
        if (fragmentProgramOutcomeBinding != null && (recyclerView3 = fragmentProgramOutcomeBinding.rvOutcome) != null) {
            RecycleExtKt.show(recyclerView3);
        }
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding2 = get_binding();
        if (fragmentProgramOutcomeBinding2 != null && (recyclerView2 = fragmentProgramOutcomeBinding2.rvEducational) != null) {
            RecycleExtKt.show(recyclerView2);
        }
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding3 = get_binding();
        if (fragmentProgramOutcomeBinding3 == null || (recyclerView = fragmentProgramOutcomeBinding3.rvSpecific) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding = get_binding();
        if (fragmentProgramOutcomeBinding != null && (recyclerView3 = fragmentProgramOutcomeBinding.rvOutcome) != null) {
            RecycleExtKt.hide(recyclerView3);
        }
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding2 = get_binding();
        if (fragmentProgramOutcomeBinding2 != null && (recyclerView2 = fragmentProgramOutcomeBinding2.rvEducational) != null) {
            RecycleExtKt.hide(recyclerView2);
        }
        FragmentProgramOutcomeBinding fragmentProgramOutcomeBinding3 = get_binding();
        if (fragmentProgramOutcomeBinding3 == null || (recyclerView = fragmentProgramOutcomeBinding3.rvSpecific) == null) {
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