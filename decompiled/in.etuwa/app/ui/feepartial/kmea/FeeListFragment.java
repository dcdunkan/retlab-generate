package in.etuwa.app.ui.feepartial.kmea;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.feemedical.FeesMed;
import in.etuwa.app.data.model.feepartial.InstallmentDetails;
import in.etuwa.app.data.model.feepartial.InstallmentDetailsResponse;
import in.etuwa.app.data.model.feepartial.InstallmentListResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFeePartialBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.feepartial.kmea.FeeListAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FeeListFragment.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\u0005¢\u0006\u0002\u0010\u0003J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u000209H\u0014J\b\u0010<\u001a\u000209H\u0014J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\b\u0010?\u001a\u000209H\u0002J\u0010\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0016J&\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u000209H\u0016J\u001a\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020D2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010N\u001a\u000209H\u0014J\b\u0010O\u001a\u000209H\u0014J\b\u0010P\u001a\u000209H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b!\u0010\"R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b/\u00100R\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006R"}, d2 = {"Lin/etuwa/app/ui/feepartial/kmea/FeeListFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentFeePartialBinding;", "adapter", "Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter;", "getAdapter", "()Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentFeePartialBinding;", "feeListViewModel", "Lin/etuwa/app/ui/feepartial/kmea/FeeListViewModel;", "getFeeListViewModel", "()Lin/etuwa/app/ui/feepartial/kmea/FeeListViewModel;", "feeListViewModel$delegate", "flag", "", "installmentId", "", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feemedical/FeesMed;", "list2", "Lin/etuwa/app/data/model/feepartial/InstallmentDetails;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "selected", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", "selectedTotal", "getSelectedTotal", "setSelectedTotal", "spinnerAdapter", "Lin/etuwa/app/ui/feepartial/kmea/FeePartialSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/feepartial/kmea/FeePartialSpinnerAdapter;", "spinnerAdapter$delegate", FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()D", "setTotal", "(D)V", "calculateTotal", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "hideBaseView", "hideProgress", "listenResponse", "listenSpinnerResponse", "listenUrlResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeListFragment extends BaseFragment implements FeeListAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFeePartialBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: feeListViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeListViewModel;
    private boolean flag;
    private String installmentId;
    private ArrayList<FeesMed> list;
    private ArrayList<InstallmentDetails> list2;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private List<String> selectedTotal;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private double total;

    /* compiled from: FeeListFragment.kt */
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
    public static final FeeListFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public FeeListFragment() {
        final FeeListFragment feeListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeListFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeListViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeListFragment, Reflection.getOrCreateKotlinClass(FeeListViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeListViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeListFragment feeListFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeeListAdapter>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feepartial.kmea.FeeListAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeListAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeListFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeListAdapter.class), b2, b3);
            }
        });
        this.flag = true;
        this.list = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeListFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(FeeListFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<FeePartialSpinnerAdapter>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feepartial.kmea.FeePartialSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeePartialSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeListFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeePartialSpinnerAdapter.class), b6, function02);
            }
        });
        this.selected = new ArrayList();
        this.selectedTotal = new ArrayList();
        this.list2 = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeListViewModel getFeeListViewModel() {
        return (FeeListViewModel) this.feeListViewModel.getValue();
    }

    private final FeeListAdapter getAdapter() {
        return (FeeListAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentFeePartialBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeePartialSpinnerAdapter getSpinnerAdapter() {
        return (FeePartialSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final List<String> getSelectedTotal() {
        return this.selectedTotal;
    }

    public final void setSelectedTotal(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selectedTotal = list;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    /* compiled from: FeeListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/feepartial/kmea/FeeListFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/feepartial/kmea/FeeListFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeListFragment newInstance() {
            return new FeeListFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentFeePartialBinding.inflate(inflater, container, false);
        FragmentFeePartialBinding fragmentFeePartialBinding = get_binding();
        if (fragmentFeePartialBinding != null) {
            fragmentFeePartialBinding.setFeeListViewModel(getFeeListViewModel());
        }
        FragmentFeePartialBinding fragmentFeePartialBinding2 = get_binding();
        if (fragmentFeePartialBinding2 != null) {
            fragmentFeePartialBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFeePartialBinding fragmentFeePartialBinding3 = get_binding();
        if (fragmentFeePartialBinding3 != null) {
            return fragmentFeePartialBinding3.getRoot();
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
        TextView textView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Fee Pay");
        }
        hideBaseView();
        FragmentFeePartialBinding fragmentFeePartialBinding = get_binding();
        Spinner spinner = fragmentFeePartialBinding != null ? fragmentFeePartialBinding.spinnerInstallment : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getPreference().setNewLogin(false);
        FragmentFeePartialBinding fragmentFeePartialBinding2 = get_binding();
        RecyclerView recyclerView = fragmentFeePartialBinding2 != null ? fragmentFeePartialBinding2.rvFee : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenSpinnerResponse();
        getFeeListViewModel().getInstallmentList();
        FragmentFeePartialBinding fragmentFeePartialBinding3 = get_binding();
        Spinner spinner2 = fragmentFeePartialBinding3 != null ? fragmentFeePartialBinding3.spinnerInstallment : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    FeePartialSpinnerAdapter spinnerAdapter;
                    FeeListViewModel feeListViewModel;
                    FeePartialSpinnerAdapter spinnerAdapter2;
                    FeeListFragment feeListFragment = FeeListFragment.this;
                    spinnerAdapter = feeListFragment.getSpinnerAdapter();
                    feeListFragment.installmentId = spinnerAdapter.getType(position).getId();
                    feeListViewModel = FeeListFragment.this.getFeeListViewModel();
                    spinnerAdapter2 = FeeListFragment.this.getSpinnerAdapter();
                    feeListViewModel.getFees(spinnerAdapter2.getType(position).getId());
                }
            });
        }
        listenResponse();
        final HashMap hashMap = new HashMap();
        FragmentFeePartialBinding fragmentFeePartialBinding4 = get_binding();
        if (fragmentFeePartialBinding4 == null || (textView = fragmentFeePartialBinding4.payNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeeListFragment.setUp$lambda$0(FeeListFragment.this, hashMap, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(FeeListFragment this$0, HashMap FeeCollection, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(FeeCollection, "$FeeCollection");
        this$0.list2.clear();
        this$0.list2.addAll(this$0.getAdapter().getItems());
        HashMap hashMap = FeeCollection;
        hashMap.put("payment", "1");
        hashMap.put("batch_id", this$0.getPreference().getBatchId());
        int size = this$0.list2.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (!Intrinsics.areEqual(this$0.list2.get(i).getBalance(), "0.00")) {
                    hashMap.put("FeeCollection[" + this$0.list2.get(i).getFeeheadgroup_id() + "][amount]", this$0.list2.get(i).getEditable_bal());
                    hashMap.put("FeeCollection[" + this$0.list2.get(i).getFeeheadgroup_id() + "][feeheadgroup_id]", this$0.list2.get(i).getFeeheadgroup_id());
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this$0.getFeeListViewModel().getFeeUrl(hashMap);
        this$0.listenUrlResponse();
    }

    private final void listenResponse() {
        getFeeListViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeListFragment.listenResponse$lambda$2(FeeListFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(FeeListFragment this$0, Resource resource) {
        RecyclerView rvFee;
        RecyclerView rvFee2;
        TextView textView;
        RecyclerView recyclerView;
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
            FragmentFeePartialBinding fragmentFeePartialBinding = this$0.get_binding();
            if (fragmentFeePartialBinding == null || (recyclerView = fragmentFeePartialBinding.rvFee) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        InstallmentDetailsResponse installmentDetailsResponse = (InstallmentDetailsResponse) resource.getData();
        if (installmentDetailsResponse != null) {
            this$0.showBaseView();
            try {
                if (installmentDetailsResponse.getLogin()) {
                    FeeListAdapter adapter = this$0.getAdapter();
                    ArrayList<InstallmentDetails> installments = installmentDetailsResponse.getInstallments();
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(installments, requireContext);
                    this$0.total = 0.0d;
                    int size = installmentDetailsResponse.getInstallments().size() - 1;
                    if (size >= 0) {
                        int i2 = 0;
                        while (true) {
                            this$0.total += Double.parseDouble(installmentDetailsResponse.getInstallments().get(i2).getBalance());
                            if (i2 == size) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    FragmentFeePartialBinding fragmentFeePartialBinding2 = this$0.get_binding();
                    if (fragmentFeePartialBinding2 == null || (textView = fragmentFeePartialBinding2.tvTotal) == null) {
                        return;
                    }
                    textView.setText(String.valueOf(this$0.total));
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                FragmentFeePartialBinding fragmentFeePartialBinding3 = this$0.get_binding();
                if (fragmentFeePartialBinding3 == null || (rvFee2 = fragmentFeePartialBinding3.rvFee) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvFee2, "rvFee");
                ToastExtKt.showErrorToast(rvFee2, "network error");
                Unit unit2 = Unit.INSTANCE;
            } catch (NullPointerException unused) {
                FragmentFeePartialBinding fragmentFeePartialBinding4 = this$0.get_binding();
                if (fragmentFeePartialBinding4 == null || (rvFee = fragmentFeePartialBinding4.rvFee) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                ToastExtKt.showErrorToast(rvFee, "Some Error occured while loading Fees");
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    private final void listenSpinnerResponse() {
        getFeeListViewModel().getInstallmentResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeListFragment.listenSpinnerResponse$lambda$4(FeeListFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r3v8, types: [kotlin.Unit] */
    public static final void listenSpinnerResponse$lambda$4(FeeListFragment this$0, Resource resource) {
        RecyclerView rvFee;
        RecyclerView recyclerView;
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
            FragmentFeePartialBinding fragmentFeePartialBinding = this$0.get_binding();
            if (fragmentFeePartialBinding == null || (recyclerView = fragmentFeePartialBinding.rvFee) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        InstallmentListResponse installmentListResponse = (InstallmentListResponse) resource.getData();
        if (installmentListResponse != null) {
            this$0.showBaseView();
            try {
                if (installmentListResponse.getLogin()) {
                    this$0.getSpinnerAdapter().addItems(installmentListResponse.getInstallments());
                    this$0 = Unit.INSTANCE;
                } else {
                    FragmentFeePartialBinding fragmentFeePartialBinding2 = this$0.get_binding();
                    this$0 = this$0;
                    if (fragmentFeePartialBinding2 != null) {
                        RecyclerView rvFee2 = fragmentFeePartialBinding2.rvFee;
                        this$0 = this$0;
                        if (rvFee2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rvFee2, "rvFee");
                            ToastExtKt.showErrorToast(rvFee2, "network error");
                            this$0 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (NullPointerException unused) {
                FragmentFeePartialBinding fragmentFeePartialBinding3 = this$0.get_binding();
                if (fragmentFeePartialBinding3 == null || (rvFee = fragmentFeePartialBinding3.rvFee) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                ToastExtKt.showErrorToast(rvFee, "Some Error occured while loading Fees");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void listenUrlResponse() {
        getFeeListViewModel().getFeeUrlResponse().observe(getViewLifecycleOwner(), new FeeListFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListFragment$listenUrlResponse$1

            /* compiled from: FeeListFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                FragmentFeePartialBinding fragmentFeePartialBinding;
                RecyclerView rvFee;
                MainCallBackListener mainCallBackListener;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        FeeListFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        FeeListFragment.this.hideProgress();
                        FeeListFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeListFragment.this.hideProgress();
                        FeeListFragment.this.showBaseView();
                        return;
                    }
                }
                FeeListFragment.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    FeeListFragment feeListFragment = FeeListFragment.this;
                    feeListFragment.showBaseView();
                    if (data.getSuccess()) {
                        mainCallBackListener = feeListFragment.listener;
                        if (mainCallBackListener != null) {
                            mainCallBackListener.openPaymentPage(data.getMessage());
                            return;
                        }
                        return;
                    }
                    fragmentFeePartialBinding = feeListFragment.get_binding();
                    if (fragmentFeePartialBinding == null || (rvFee = fragmentFeePartialBinding.rvFee) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvFee, "rvFee");
                    ToastExtKt.showErrorToast(rvFee, data.getError());
                }
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentFeePartialBinding fragmentFeePartialBinding = get_binding();
        if (fragmentFeePartialBinding == null || (recyclerView = fragmentFeePartialBinding.rvFee) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentFeePartialBinding fragmentFeePartialBinding = get_binding();
        if (fragmentFeePartialBinding == null || (recyclerView = fragmentFeePartialBinding.rvFee) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // in.etuwa.app.ui.feepartial.kmea.FeeListAdapter.CallBack
    public void calculateTotal() {
        this.list2.clear();
        this.list2.addAll(getAdapter().getItems());
        this.total = 0.0d;
        int size = this.list2.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                this.total += Double.parseDouble(this.list2.get(i).getEditable_bal());
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        FragmentFeePartialBinding fragmentFeePartialBinding = get_binding();
        TextView textView = fragmentFeePartialBinding != null ? fragmentFeePartialBinding.tvTotal : null;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(this.total));
    }

    @Override // in.etuwa.app.ui.feepartial.kmea.FeeListAdapter.CallBack
    public void error() {
        RecyclerView recyclerView;
        FragmentFeePartialBinding fragmentFeePartialBinding = get_binding();
        if (fragmentFeePartialBinding == null || (recyclerView = fragmentFeePartialBinding.rvFee) == null) {
            return;
        }
        ToastExtKt.showErrorToast(recyclerView, "Amount must be valid");
    }
}