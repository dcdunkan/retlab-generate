package in.etuwa.app.ui.lab;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.lab.LabDue;
import in.etuwa.app.data.model.lab.LabList;
import in.etuwa.app.data.model.lab.Practical;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentLabBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.lab.equipment.LabListAdapter;
import in.etuwa.app.ui.lab.labdue.LabDueAdapter;
import in.etuwa.app.ui.lab.practical.LabPracticalAdapter;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: LabFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class LabFragment extends Fragment implements LabPracticalAdapter.CallBack, LabListAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentLabBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: adapterDue$delegate, reason: from kotlin metadata */
    private final Lazy adapterDue;

    /* JADX INFO: renamed from: adapterList$delegate, reason: from kotlin metadata */
    private final Lazy adapterList;
    private boolean flag;

    /* JADX INFO: renamed from: labViewModel$delegate, reason: from kotlin metadata */
    private final Lazy labViewModel;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: compiled from: LabFragment.kt */
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
    public static final LabFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public LabFragment() {
        final LabFragment labFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = labFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
        final LabFragment labFragment2 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return labFragment2;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(labFragment2);
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.labViewModel = FragmentViewModelLazyKt.createViewModelLazy(labFragment2, Reflection.getOrCreateKotlinClass(LabViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(LabViewModel.class), b2, b3, null, koinScope);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<LabPracticalAdapter>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.lab.practical.LabPracticalAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LabPracticalAdapter invoke() {
                ComponentCallbacks componentCallbacks = labFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LabPracticalAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterDue = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<LabDueAdapter>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.lab.labdue.LabDueAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LabDueAdapter invoke() {
                ComponentCallbacks componentCallbacks = labFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LabDueAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.adapterList = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<LabListAdapter>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.lab.equipment.LabListAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LabListAdapter invoke() {
                ComponentCallbacks componentCallbacks = labFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LabListAdapter.class), b8, b9);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.lab.LabFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.lab.LabFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = labFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b10, function02);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LabViewModel getLabViewModel() {
        return (LabViewModel) this.labViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentLabBinding get_binding() {
        return this._binding;
    }

    private final LabPracticalAdapter getAdapter() {
        return (LabPracticalAdapter) this.adapter.getValue();
    }

    private final LabDueAdapter getAdapterDue() {
        return (LabDueAdapter) this.adapterDue.getValue();
    }

    private final LabListAdapter getAdapterList() {
        return (LabListAdapter) this.adapterList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: compiled from: LabFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/lab/LabFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/lab/LabFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LabFragment newInstance() {
            return new LabFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentLabBinding.inflate(inflater, container, false);
        FragmentLabBinding fragmentLabBinding = get_binding();
        if (fragmentLabBinding != null) {
            fragmentLabBinding.setLabViewModel(getLabViewModel());
        }
        FragmentLabBinding fragmentLabBinding2 = get_binding();
        if (fragmentLabBinding2 != null) {
            fragmentLabBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentLabBinding fragmentLabBinding3 = get_binding();
        if (fragmentLabBinding3 != null) {
            return fragmentLabBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.laboratory));
        }
        getPreference().setNewLogin(false);
        FragmentLabBinding fragmentLabBinding = get_binding();
        RecyclerView recyclerView = fragmentLabBinding != null ? fragmentLabBinding.rvPractical : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        FragmentLabBinding fragmentLabBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentLabBinding2 != null ? fragmentLabBinding2.rvLabDue : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterDue());
        }
        getAdapter().setCallBack2(this);
        FragmentLabBinding fragmentLabBinding3 = get_binding();
        RecyclerView recyclerView3 = fragmentLabBinding3 != null ? fragmentLabBinding3.rvLabList : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapterList());
        }
        getAdapterList().setCallBack2(this);
        FragmentLabBinding fragmentLabBinding4 = get_binding();
        Spinner spinner = fragmentLabBinding4 != null ? fragmentLabBinding4.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenDueResponse();
        listenSemResponse();
        listenResponse();
        listenLabListResponse();
        getLabViewModel().getPractical(getPreference().getUserSemId());
        getLabViewModel().getSemester();
        FragmentLabBinding fragmentLabBinding5 = get_binding();
        if (fragmentLabBinding5 != null && (textView3 = fragmentLabBinding5.cardPractical) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.lab.LabFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabFragment.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        FragmentLabBinding fragmentLabBinding6 = get_binding();
        if (fragmentLabBinding6 != null && (textView2 = fragmentLabBinding6.cardEquipment) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.lab.LabFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabFragment.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        FragmentLabBinding fragmentLabBinding7 = get_binding();
        if (fragmentLabBinding7 != null && (textView = fragmentLabBinding7.cardDue) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.lab.LabFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabFragment.onViewCreated$lambda$2(this.f$0, view2);
                }
            });
        }
        FragmentLabBinding fragmentLabBinding8 = get_binding();
        Spinner spinner2 = fragmentLabBinding8 != null ? fragmentLabBinding8.spinnerSem : null;
        if (spinner2 == null) {
            return;
        }
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.lab.LabFragment.onViewCreated.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                Spinner spinner3;
                Semester semester = LabFragment.this.getSpinnerAdapter().getSemester(position);
                if (LabFragment.this.flag) {
                    LabFragment.this.getLabViewModel().getPractical(semester.getId());
                    return;
                }
                LabFragment.this.flag = true;
                int count = LabFragment.this.getSpinnerAdapter().getCount();
                for (int i = 0; i < count; i++) {
                    if (Intrinsics.areEqual(LabFragment.this.getPreference().getUserSemId(), LabFragment.this.getSpinnerAdapter().getSemester(i).getId())) {
                        FragmentLabBinding fragmentLabBinding9 = LabFragment.this.get_binding();
                        if (fragmentLabBinding9 == null || (spinner3 = fragmentLabBinding9.spinnerSem) == null) {
                            return;
                        }
                        spinner3.setSelection(i);
                        return;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(LabFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLabViewModel().getPractical(this$0.getPreference().getUserSemId());
        FragmentLabBinding fragmentLabBinding = this$0.get_binding();
        FrameLayout frameLayout = fragmentLabBinding != null ? fragmentLabBinding.practicalLyt : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FragmentLabBinding fragmentLabBinding2 = this$0.get_binding();
        FrameLayout frameLayout2 = fragmentLabBinding2 != null ? fragmentLabBinding2.equipmentLyt : null;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        FragmentLabBinding fragmentLabBinding3 = this$0.get_binding();
        FrameLayout frameLayout3 = fragmentLabBinding3 != null ? fragmentLabBinding3.labDueLyt : null;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(8);
        }
        FragmentLabBinding fragmentLabBinding4 = this$0.get_binding();
        if (fragmentLabBinding4 != null && (textView6 = fragmentLabBinding4.cardPractical) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentLabBinding fragmentLabBinding5 = this$0.get_binding();
        if (fragmentLabBinding5 != null && (textView5 = fragmentLabBinding5.cardEquipment) != null) {
            textView5.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentLabBinding fragmentLabBinding6 = this$0.get_binding();
        if (fragmentLabBinding6 != null && (textView4 = fragmentLabBinding6.cardDue) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentLabBinding fragmentLabBinding7 = this$0.get_binding();
        if (fragmentLabBinding7 != null && (textView3 = fragmentLabBinding7.cardPractical) != null) {
            textView3.setTextColor(-1);
        }
        FragmentLabBinding fragmentLabBinding8 = this$0.get_binding();
        if (fragmentLabBinding8 != null && (textView2 = fragmentLabBinding8.cardEquipment) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentLabBinding fragmentLabBinding9 = this$0.get_binding();
        if (fragmentLabBinding9 == null || (textView = fragmentLabBinding9.cardDue) == null) {
            return;
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(LabFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLabViewModel().getLabList();
        FragmentLabBinding fragmentLabBinding = this$0.get_binding();
        FrameLayout frameLayout = fragmentLabBinding != null ? fragmentLabBinding.practicalLyt : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FragmentLabBinding fragmentLabBinding2 = this$0.get_binding();
        FrameLayout frameLayout2 = fragmentLabBinding2 != null ? fragmentLabBinding2.equipmentLyt : null;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        FragmentLabBinding fragmentLabBinding3 = this$0.get_binding();
        FrameLayout frameLayout3 = fragmentLabBinding3 != null ? fragmentLabBinding3.labDueLyt : null;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(8);
        }
        FragmentLabBinding fragmentLabBinding4 = this$0.get_binding();
        if (fragmentLabBinding4 != null && (textView6 = fragmentLabBinding4.cardPractical) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentLabBinding fragmentLabBinding5 = this$0.get_binding();
        if (fragmentLabBinding5 != null && (textView5 = fragmentLabBinding5.cardEquipment) != null) {
            textView5.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentLabBinding fragmentLabBinding6 = this$0.get_binding();
        if (fragmentLabBinding6 != null && (textView4 = fragmentLabBinding6.cardDue) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentLabBinding fragmentLabBinding7 = this$0.get_binding();
        if (fragmentLabBinding7 != null && (textView3 = fragmentLabBinding7.cardPractical) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentLabBinding fragmentLabBinding8 = this$0.get_binding();
        if (fragmentLabBinding8 != null && (textView2 = fragmentLabBinding8.cardEquipment) != null) {
            textView2.setTextColor(-1);
        }
        FragmentLabBinding fragmentLabBinding9 = this$0.get_binding();
        if (fragmentLabBinding9 == null || (textView = fragmentLabBinding9.cardDue) == null) {
            return;
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(LabFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLabViewModel().getLabDue();
        FragmentLabBinding fragmentLabBinding = this$0.get_binding();
        FrameLayout frameLayout = fragmentLabBinding != null ? fragmentLabBinding.practicalLyt : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FragmentLabBinding fragmentLabBinding2 = this$0.get_binding();
        FrameLayout frameLayout2 = fragmentLabBinding2 != null ? fragmentLabBinding2.equipmentLyt : null;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        FragmentLabBinding fragmentLabBinding3 = this$0.get_binding();
        FrameLayout frameLayout3 = fragmentLabBinding3 != null ? fragmentLabBinding3.labDueLyt : null;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        FragmentLabBinding fragmentLabBinding4 = this$0.get_binding();
        if (fragmentLabBinding4 != null && (textView6 = fragmentLabBinding4.cardPractical) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentLabBinding fragmentLabBinding5 = this$0.get_binding();
        if (fragmentLabBinding5 != null && (textView5 = fragmentLabBinding5.cardEquipment) != null) {
            textView5.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentLabBinding fragmentLabBinding6 = this$0.get_binding();
        if (fragmentLabBinding6 != null && (textView4 = fragmentLabBinding6.cardDue) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentLabBinding fragmentLabBinding7 = this$0.get_binding();
        if (fragmentLabBinding7 != null && (textView3 = fragmentLabBinding7.cardPractical) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentLabBinding fragmentLabBinding8 = this$0.get_binding();
        if (fragmentLabBinding8 != null && (textView2 = fragmentLabBinding8.cardEquipment) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentLabBinding fragmentLabBinding9 = this$0.get_binding();
        if (fragmentLabBinding9 == null || (textView = fragmentLabBinding9.cardDue) == null) {
            return;
        }
        textView.setTextColor(-1);
    }

    private final void listenDueResponse() {
        getLabViewModel().getLabDueResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.LabFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LabFragment.listenDueResponse$lambda$4(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDueResponse$lambda$4(LabFragment this$0, Resource resource) {
        FragmentLabBinding fragmentLabBinding;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            ArrayList<LabDue> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.getAdapterDue().addItems(arrayList);
                return;
            }
            return;
        }
        if (i != 4 || (fragmentLabBinding = this$0.get_binding()) == null || (recyclerView = fragmentLabBinding.rvLabDue) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenSemResponse() {
        getLabViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.LabFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LabFragment.listenSemResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$6(LabFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        FragmentLabBinding fragmentLabBinding;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (i != 1) {
            if (i == 2) {
                FragmentLabBinding fragmentLabBinding2 = this$0.get_binding();
                if (fragmentLabBinding2 != null && (swipeRefreshLayout2 = fragmentLabBinding2.swipeLayout) != null) {
                    boolValueOf = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(boolValueOf);
                boolValueOf.booleanValue();
                return;
            }
            if (i != 4 || (fragmentLabBinding = this$0.get_binding()) == null || (recyclerView = fragmentLabBinding.rvPractical) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            FragmentLabBinding fragmentLabBinding3 = this$0.get_binding();
            Boolean boolValueOf2 = (fragmentLabBinding3 == null || (swipeRefreshLayout = fragmentLabBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue()) {
                FragmentLabBinding fragmentLabBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = fragmentLabBinding4 != null ? fragmentLabBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        FragmentLabBinding fragmentLabBinding5 = this$0.get_binding();
                        if (fragmentLabBinding5 == null || (spinner = fragmentLabBinding5.spinnerSem) == null) {
                            return;
                        }
                        spinner.setSelection(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void listenResponse() {
        getLabViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.LabFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LabFragment.listenResponse$lambda$8(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$8(LabFragment this$0, Resource resource) {
        FragmentLabBinding fragmentLabBinding;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            ArrayList<Practical> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.getAdapter().addItems(arrayList);
                return;
            }
            return;
        }
        if (i != 4 || (fragmentLabBinding = this$0.get_binding()) == null || (recyclerView = fragmentLabBinding.rvPractical) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenLabListResponse() {
        getLabViewModel().getLabListResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.lab.LabFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LabFragment.listenLabListResponse$lambda$10(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenLabListResponse$lambda$10(LabFragment this$0, Resource resource) {
        FragmentLabBinding fragmentLabBinding;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            ArrayList<LabList> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.getAdapterList().addItems(arrayList);
                return;
            }
            return;
        }
        if (i != 4 || (fragmentLabBinding = this$0.get_binding()) == null || (recyclerView = fragmentLabBinding.rvLabList) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // in.etuwa.app.ui.lab.practical.LabPracticalAdapter.CallBack
    public void onEvaluationClick(String subId) {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLabPracticalItemClick(0, subId, "");
        }
    }

    @Override // in.etuwa.app.ui.lab.practical.LabPracticalAdapter.CallBack
    public void onExperimentClick(String subId, String subPid) {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLabPracticalItemClick(1, subId, subPid);
        }
    }

    @Override // in.etuwa.app.ui.lab.equipment.LabListAdapter.CallBack
    public void onLabListClick(int position, String labId) {
        Intrinsics.checkNotNullParameter(labId, "labId");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLabEquipmentItemClick(position, labId);
        }
    }
}