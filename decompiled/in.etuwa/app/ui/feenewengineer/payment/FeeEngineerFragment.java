package in.etuwa.app.ui.feenewengineer.payment;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineer;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerUrlResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFeeEngineerBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewengineer.payment.FeeEngineerAdapter;
import in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialog;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FeeEngineerFragment.kt */
/* loaded from: classes4.dex */
public final class FeeEngineerFragment extends BaseFragment implements FeeEngineerAdapter.CallBack, FeeDetailDialog.FeeDetailListner, FeeConfirmDialog.FeeDetailListner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFeeEngineerBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: feeEngineerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeEngineerViewModel;
    private ArrayList<FeeEngineer> list;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private List<String> selectedTotal;
    private double total;

    /* compiled from: FeeEngineerFragment.kt */
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
    public static final FeeEngineerFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public FeeEngineerFragment() {
        final FeeEngineerFragment feeEngineerFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeEngineerFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeEngineerViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeEngineerFragment, Reflection.getOrCreateKotlinClass(FeeEngineerViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeEngineerViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeEngineerFragment feeEngineerFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeeEngineerAdapter>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feenewengineer.payment.FeeEngineerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeEngineerAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeEngineerFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeEngineerAdapter.class), b2, b3);
            }
        });
        this.list = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeEngineerFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.selected = new ArrayList();
        this.selectedTotal = new ArrayList();
    }

    private final FeeEngineerViewModel getFeeEngineerViewModel() {
        return (FeeEngineerViewModel) this.feeEngineerViewModel.getValue();
    }

    private final FeeEngineerAdapter getAdapter() {
        return (FeeEngineerAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentFeeEngineerBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
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

    /* compiled from: FeeEngineerFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/FeeEngineerFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/feenewengineer/payment/FeeEngineerFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeEngineerFragment newInstance() {
            return new FeeEngineerFragment();
        }
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentFeeEngineerBinding.inflate(inflater, container, false);
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding = get_binding();
        if (fragmentFeeEngineerBinding != null) {
            fragmentFeeEngineerBinding.setFeeEngineeringViewModel(getFeeEngineerViewModel());
        }
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding2 = get_binding();
        if (fragmentFeeEngineerBinding2 != null) {
            fragmentFeeEngineerBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding3 = get_binding();
        if (fragmentFeeEngineerBinding3 != null) {
            return fragmentFeeEngineerBinding3.getRoot();
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
        getPreference().setNewLogin(false);
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding = get_binding();
        RecyclerView recyclerView = fragmentFeeEngineerBinding != null ? fragmentFeeEngineerBinding.rvFeeEngnr : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        getFeeEngineerViewModel().getFees();
        listenResponse();
        final HashMap hashMap = new HashMap();
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding2 = get_binding();
        if (fragmentFeeEngineerBinding2 == null || (textView = fragmentFeeEngineerBinding2.payFeeEngnrBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeeEngineerFragment.setUp$lambda$0(hashMap, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(HashMap FeeCollection, FeeEngineerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(FeeCollection, "$FeeCollection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = FeeCollection;
        hashMap.put("payment", "1");
        hashMap.put("batch_id", this$0.getPreference().getBatchId());
        int size = this$0.selected.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (Intrinsics.areEqual(this$0.selected.get(i), "true")) {
                    int size2 = this$0.list.get(i).getInstallments().size() - 1;
                    if (size2 >= 0) {
                        int i2 = 0;
                        while (true) {
                            if (Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance()) > 0.0d || Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance()) > 0.0d || Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance()) > 0.0d) {
                                Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance());
                                hashMap.put("FeeCollection[" + this$0.list.get(i).getInstallments().get(i2).getFeeheadgroup_id() + "][amount]", this$0.list.get(i).getInstallments().get(i2).getBalance());
                                hashMap.put("FeeCollection[" + this$0.list.get(i).getInstallments().get(i2).getFeeheadgroup_id() + "][feeheadgroup_id]", this$0.list.get(i).getInstallments().get(i2).getFeeheadgroup_id());
                            }
                            if (i2 == size2) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    hashMap.put("payment", "1");
                    hashMap.put("batch_id", this$0.getPreference().getBatchId());
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this$0.getFeeEngineerViewModel().getFeeUrl(hashMap);
        this$0.listenUrlResponse();
    }

    private final void listenResponse() {
        getFeeEngineerViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeEngineerFragment.listenResponse$lambda$2(FeeEngineerFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v8, types: [kotlin.Unit] */
    public static final void listenResponse$lambda$2(FeeEngineerFragment this$0, Resource resource) {
        RecyclerView rvFeeEngnr;
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
            FragmentFeeEngineerBinding fragmentFeeEngineerBinding = this$0.get_binding();
            if (fragmentFeeEngineerBinding == null || (recyclerView = fragmentFeeEngineerBinding.rvFeeEngnr) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        FeeEngineerResponse feeEngineerResponse = (FeeEngineerResponse) resource.getData();
        if (feeEngineerResponse != null) {
            this$0.showBaseView();
            try {
                if (feeEngineerResponse.getLogin() && feeEngineerResponse.getSuccess()) {
                    FeeEngineerAdapter adapter = this$0.getAdapter();
                    ArrayList<FeeEngineer> fees = feeEngineerResponse.getFees();
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(fees, requireContext);
                    this$0.list = feeEngineerResponse.getFees();
                    this$0 = Unit.INSTANCE;
                } else {
                    FragmentFeeEngineerBinding fragmentFeeEngineerBinding2 = this$0.get_binding();
                    this$0 = this$0;
                    if (fragmentFeeEngineerBinding2 != null) {
                        RecyclerView rvFeeEngnr2 = fragmentFeeEngineerBinding2.rvFeeEngnr;
                        this$0 = this$0;
                        if (rvFeeEngnr2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rvFeeEngnr2, "rvFeeEngnr");
                            ToastExtKt.showErrorToast(rvFeeEngnr2, feeEngineerResponse.getMessage());
                            this$0 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (NullPointerException unused) {
                FragmentFeeEngineerBinding fragmentFeeEngineerBinding3 = this$0.get_binding();
                if (fragmentFeeEngineerBinding3 == null || (rvFeeEngnr = fragmentFeeEngineerBinding3.rvFeeEngnr) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvFeeEngnr, "rvFeeEngnr");
                ToastExtKt.showErrorToast(rvFeeEngnr, "Some Error occured while loading Fees");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void listenKmeaResponse() {
        getFeeEngineerViewModel().getKmeaResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeEngineerFragment.listenKmeaResponse$lambda$4(FeeEngineerFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenKmeaResponse$lambda$4(FeeEngineerFragment this$0, Resource resource) {
        RecyclerView rvFeeEngnr;
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
            FragmentFeeEngineerBinding fragmentFeeEngineerBinding = this$0.get_binding();
            if (fragmentFeeEngineerBinding == null || (recyclerView = fragmentFeeEngineerBinding.rvFeeEngnr) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        FeeEngineerResponse feeEngineerResponse = (FeeEngineerResponse) resource.getData();
        if (feeEngineerResponse != null) {
            this$0.showBaseView();
            if (feeEngineerResponse.getLogin() && feeEngineerResponse.getSuccess()) {
                FeeEngineerAdapter adapter = this$0.getAdapter();
                ArrayList<FeeEngineer> fees = feeEngineerResponse.getFees();
                Context requireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                adapter.addItems(fees, requireContext);
                this$0.list = feeEngineerResponse.getFees();
                return;
            }
            FragmentFeeEngineerBinding fragmentFeeEngineerBinding2 = this$0.get_binding();
            if (fragmentFeeEngineerBinding2 == null || (rvFeeEngnr = fragmentFeeEngineerBinding2.rvFeeEngnr) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvFeeEngnr, "rvFeeEngnr");
            ToastExtKt.showErrorToast(rvFeeEngnr, feeEngineerResponse.getMessage());
        }
    }

    private final void listenUrlResponse() {
        getFeeEngineerViewModel().getFeeUrlResponse().observe(getViewLifecycleOwner(), new FeeEngineerFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends FeeEngineerUrlResponse>, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment$listenUrlResponse$1

            /* compiled from: FeeEngineerFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends FeeEngineerUrlResponse> resource) {
                invoke2((Resource<FeeEngineerUrlResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<FeeEngineerUrlResponse> resource) {
                FragmentFeeEngineerBinding fragmentFeeEngineerBinding;
                TextView payFeeEngnrBtn;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        FeeEngineerFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        FeeEngineerFragment.this.hideProgress();
                        FeeEngineerFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeEngineerFragment.this.hideProgress();
                        FeeEngineerFragment.this.showBaseView();
                        return;
                    }
                }
                FeeEngineerFragment.this.hideProgress();
                FeeEngineerUrlResponse data = resource.getData();
                if (data != null) {
                    FeeEngineerFragment feeEngineerFragment = FeeEngineerFragment.this;
                    feeEngineerFragment.showBaseView();
                    System.out.println((Object) data.getUrl());
                    if (Intrinsics.areEqual(data.getUrl(), "") || !Intrinsics.areEqual(data.getError(), "")) {
                        fragmentFeeEngineerBinding = feeEngineerFragment.get_binding();
                        if (fragmentFeeEngineerBinding == null || (payFeeEngnrBtn = fragmentFeeEngineerBinding.payFeeEngnrBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(payFeeEngnrBtn, "payFeeEngnrBtn");
                        ToastExtKt.showErrorToast(payFeeEngnrBtn, data.getError());
                        return;
                    }
                    FragmentManager childFragmentManager = feeEngineerFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    FeeConfirmDialog newInstance = FeeConfirmDialog.INSTANCE.newInstance(data.getTotal(), data.getFine(), data.getSubtotal(), data.getUrl());
                    newInstance.setCallBack(feeEngineerFragment);
                    newInstance.show(childFragmentManager, (String) null);
                }
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding = get_binding();
        if (fragmentFeeEngineerBinding == null || (recyclerView = fragmentFeeEngineerBinding.rvFeeEngnr) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding = get_binding();
        if (fragmentFeeEngineerBinding == null || (recyclerView = fragmentFeeEngineerBinding.rvFeeEngnr) == null) {
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

    @Override // in.etuwa.app.ui.feenewengineer.payment.FeeEngineerAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        int size;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        int size2 = total.size() - 1;
        double d = 0.0d;
        if (size2 >= 0) {
            int i = 0;
            while (true) {
                d += Double.parseDouble(total.get(i));
                if (d <= 0.0d) {
                    FragmentFeeEngineerBinding fragmentFeeEngineerBinding = get_binding();
                    TextView textView = fragmentFeeEngineerBinding != null ? fragmentFeeEngineerBinding.payFeeEngnrBtn : null;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                } else {
                    FragmentFeeEngineerBinding fragmentFeeEngineerBinding2 = get_binding();
                    TextView textView2 = fragmentFeeEngineerBinding2 != null ? fragmentFeeEngineerBinding2.payFeeEngnrBtn : null;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                }
                if (i == size2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding3 = get_binding();
        TextView textView3 = fragmentFeeEngineerBinding3 != null ? fragmentFeeEngineerBinding3.tvFeeEngnrTotal : null;
        if (textView3 != null) {
            textView3.setText(String.valueOf(d));
        }
        int size3 = this.selected.size() - 1;
        double d2 = 0.0d;
        if (size3 >= 0) {
            int i2 = 0;
            while (true) {
                try {
                    if (Intrinsics.areEqual(sel.get(i2), "true") && this.list.get(i2).getInstallments().size() - 1 >= 0) {
                        int i3 = 0;
                        while (true) {
                            d2 += Double.parseDouble(this.list.get(i2).getInstallments().get(i3).getBalance());
                            if (d2 <= 0.0d) {
                                FragmentFeeEngineerBinding fragmentFeeEngineerBinding4 = get_binding();
                                TextView textView4 = fragmentFeeEngineerBinding4 != null ? fragmentFeeEngineerBinding4.payFeeEngnrBtn : null;
                                if (textView4 != null) {
                                    textView4.setVisibility(8);
                                }
                            } else {
                                FragmentFeeEngineerBinding fragmentFeeEngineerBinding5 = get_binding();
                                TextView textView5 = fragmentFeeEngineerBinding5 != null ? fragmentFeeEngineerBinding5.payFeeEngnrBtn : null;
                                if (textView5 != null) {
                                    textView5.setVisibility(0);
                                }
                            }
                            if (i3 == size) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (i2 == size3) {
                        break;
                    } else {
                        i2++;
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
        this.selected = sel;
        this.selectedTotal = total;
        this.total = d2;
        if (d <= 0.0d) {
            FragmentFeeEngineerBinding fragmentFeeEngineerBinding6 = get_binding();
            TextView textView6 = fragmentFeeEngineerBinding6 != null ? fragmentFeeEngineerBinding6.payFeeEngnrBtn : null;
            if (textView6 == null) {
                return;
            }
            textView6.setVisibility(8);
            return;
        }
        FragmentFeeEngineerBinding fragmentFeeEngineerBinding7 = get_binding();
        TextView textView7 = fragmentFeeEngineerBinding7 != null ? fragmentFeeEngineerBinding7.payFeeEngnrBtn : null;
        if (textView7 == null) {
            return;
        }
        textView7.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.feenewengineer.payment.FeeEngineerAdapter.CallBack
    public void selectedIds(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FeeDetailDialog newInstance = FeeDetailDialog.INSTANCE.newInstance(position);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog.FeeDetailListner
    public void dismiss() {
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
            getFeeEngineerViewModel().getFeesKmea(getPreference().getBatchId());
        } else {
            getFeeEngineerViewModel().getFees();
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
            listenKmeaResponse();
        } else {
            listenResponse();
        }
    }

    @Override // in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialog.FeeDetailListner
    public void openPaymentPage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPaymentPage(url);
        }
    }
}