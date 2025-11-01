package in.etuwa.app.ui.feemedical;

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
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.feemedical.FeesMed;
import in.etuwa.app.data.model.feemedical.FeesMedResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFeeMedicalBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feemedical.FeeMedicalAdapter;
import in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FeeMedicalFragment.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0014J\b\u00102\u001a\u000200H\u0014J\b\u00103\u001a\u000200H\u0002J\b\u00104\u001a\u000200H\u0002J\u0010\u00105\u001a\u0002002\u0006\u00106\u001a\u000207H\u0016J&\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u000200H\u0016J\u001a\u0010A\u001a\u0002002\u0006\u0010B\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u000200H\u0014J\b\u0010G\u001a\u000200H\u0014J\b\u0010H\u001a\u000200H\u0014J$\u0010I\u001a\u0002002\f\u0010J\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010&\u001a\b\u0012\u0004\u0012\u00020!0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006L"}, d2 = {"Lin/etuwa/app/ui/feemedical/FeeMedicalFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter$CallBack;", "Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailDialog$FeeDetailListner;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentFeeMedicalBinding;", "adapter", "Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter;", "getAdapter", "()Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentFeeMedicalBinding;", "feeMedicalViewModel", "Lin/etuwa/app/ui/feemedical/FeeMedicalViewModel;", "getFeeMedicalViewModel", "()Lin/etuwa/app/ui/feemedical/FeeMedicalViewModel;", "feeMedicalViewModel$delegate", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feemedical/FeesMed;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "selected", "", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", "selectedTotal", "getSelectedTotal", "setSelectedTotal", FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()D", "setTotal", "(D)V", "dismiss", "", "hideBaseView", "hideProgress", "listenResponse", "listenUrlResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "selectedIds", CommonCssConstants.POSITION, "", "setUp", "showBaseView", "showProgress", "updateSelected", "sel", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeMedicalFragment extends BaseFragment implements FeeMedicalAdapter.CallBack, FeeDetailDialog.FeeDetailListner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFeeMedicalBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: feeMedicalViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeMedicalViewModel;
    private ArrayList<FeesMed> list;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private List<String> selectedTotal;
    private double total;

    /* compiled from: FeeMedicalFragment.kt */
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
    public static final FeeMedicalFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog.FeeDetailListner
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public FeeMedicalFragment() {
        final FeeMedicalFragment feeMedicalFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeMedicalFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeMedicalViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeMedicalFragment, Reflection.getOrCreateKotlinClass(FeeMedicalViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeMedicalViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeMedicalFragment feeMedicalFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeeMedicalAdapter>() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feemedical.FeeMedicalAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeMedicalAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeMedicalFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeMedicalAdapter.class), b2, b3);
            }
        });
        this.list = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeMedicalFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.selected = new ArrayList();
        this.selectedTotal = new ArrayList();
    }

    private final FeeMedicalViewModel getFeeMedicalViewModel() {
        return (FeeMedicalViewModel) this.feeMedicalViewModel.getValue();
    }

    private final FeeMedicalAdapter getAdapter() {
        return (FeeMedicalAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentFeeMedicalBinding get_binding() {
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

    /* compiled from: FeeMedicalFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/feemedical/FeeMedicalFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/feemedical/FeeMedicalFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeMedicalFragment newInstance() {
            return new FeeMedicalFragment();
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
        this._binding = FragmentFeeMedicalBinding.inflate(inflater, container, false);
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding = get_binding();
        if (fragmentFeeMedicalBinding != null) {
            fragmentFeeMedicalBinding.setFeeMedicalViewModel(getFeeMedicalViewModel());
        }
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding2 = get_binding();
        if (fragmentFeeMedicalBinding2 != null) {
            fragmentFeeMedicalBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding3 = get_binding();
        if (fragmentFeeMedicalBinding3 != null) {
            return fragmentFeeMedicalBinding3.getRoot();
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
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding = get_binding();
        RecyclerView recyclerView = fragmentFeeMedicalBinding != null ? fragmentFeeMedicalBinding.rvFeeMedical : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        getFeeMedicalViewModel().getFees();
        listenResponse();
        final HashMap hashMap = new HashMap();
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding2 = get_binding();
        if (fragmentFeeMedicalBinding2 == null || (textView = fragmentFeeMedicalBinding2.payFeeMedicalBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeeMedicalFragment.setUp$lambda$0(hashMap, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(HashMap FeeCollection, FeeMedicalFragment this$0, View view) {
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
                            if (!Intrinsics.areEqual(this$0.list.get(i).getInstallments().get(i2).getBalance(), "0.00")) {
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
        this$0.getFeeMedicalViewModel().getFeeUrl(hashMap);
        this$0.listenUrlResponse();
    }

    private final void listenResponse() {
        getFeeMedicalViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeMedicalFragment.listenResponse$lambda$2(FeeMedicalFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v8, types: [kotlin.Unit] */
    public static final void listenResponse$lambda$2(FeeMedicalFragment this$0, Resource resource) {
        RecyclerView rvFeeMedical;
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
            FragmentFeeMedicalBinding fragmentFeeMedicalBinding = this$0.get_binding();
            if (fragmentFeeMedicalBinding == null || (recyclerView = fragmentFeeMedicalBinding.rvFeeMedical) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        FeesMedResponse feesMedResponse = (FeesMedResponse) resource.getData();
        if (feesMedResponse != null) {
            this$0.showBaseView();
            try {
                if (feesMedResponse.getLogin()) {
                    FeeMedicalAdapter adapter = this$0.getAdapter();
                    ArrayList<FeesMed> fees = feesMedResponse.getFees();
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(fees, requireContext);
                    this$0.list = feesMedResponse.getFees();
                    this$0 = Unit.INSTANCE;
                } else {
                    FragmentFeeMedicalBinding fragmentFeeMedicalBinding2 = this$0.get_binding();
                    this$0 = this$0;
                    if (fragmentFeeMedicalBinding2 != null) {
                        RecyclerView rvFeeMedical2 = fragmentFeeMedicalBinding2.rvFeeMedical;
                        this$0 = this$0;
                        if (rvFeeMedical2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rvFeeMedical2, "rvFeeMedical");
                            ToastExtKt.showErrorToast(rvFeeMedical2, "netwok error");
                            this$0 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (NullPointerException unused) {
                FragmentFeeMedicalBinding fragmentFeeMedicalBinding3 = this$0.get_binding();
                if (fragmentFeeMedicalBinding3 == null || (rvFeeMedical = fragmentFeeMedicalBinding3.rvFeeMedical) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvFeeMedical, "rvFeeMedical");
                ToastExtKt.showErrorToast(rvFeeMedical, "Some Error occured while loading Fees");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void listenUrlResponse() {
        getFeeMedicalViewModel().getFeeUrlResponse().observe(getViewLifecycleOwner(), new FeeMedicalFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalFragment$listenUrlResponse$1

            /* compiled from: FeeMedicalFragment.kt */
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
                MainCallBackListener mainCallBackListener;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        FeeMedicalFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        FeeMedicalFragment.this.hideProgress();
                        FeeMedicalFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeMedicalFragment.this.hideProgress();
                        FeeMedicalFragment.this.showBaseView();
                        return;
                    }
                }
                FeeMedicalFragment.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    FeeMedicalFragment feeMedicalFragment = FeeMedicalFragment.this;
                    feeMedicalFragment.showBaseView();
                    System.out.println((Object) data.getMessage());
                    mainCallBackListener = feeMedicalFragment.listener;
                    if (mainCallBackListener != null) {
                        mainCallBackListener.openPaymentPage(data.getMessage());
                    }
                }
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding = get_binding();
        if (fragmentFeeMedicalBinding == null || (recyclerView = fragmentFeeMedicalBinding.rvFeeMedical) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding = get_binding();
        if (fragmentFeeMedicalBinding == null || (recyclerView = fragmentFeeMedicalBinding.rvFeeMedical) == null) {
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

    @Override // in.etuwa.app.ui.feemedical.FeeMedicalAdapter.CallBack
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
                    FragmentFeeMedicalBinding fragmentFeeMedicalBinding = get_binding();
                    TextView textView = fragmentFeeMedicalBinding != null ? fragmentFeeMedicalBinding.payFeeMedicalBtn : null;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                } else {
                    FragmentFeeMedicalBinding fragmentFeeMedicalBinding2 = get_binding();
                    TextView textView2 = fragmentFeeMedicalBinding2 != null ? fragmentFeeMedicalBinding2.payFeeMedicalBtn : null;
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
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding3 = get_binding();
        TextView textView3 = fragmentFeeMedicalBinding3 != null ? fragmentFeeMedicalBinding3.tvFeeMedicalTotal : null;
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
                                FragmentFeeMedicalBinding fragmentFeeMedicalBinding4 = get_binding();
                                TextView textView4 = fragmentFeeMedicalBinding4 != null ? fragmentFeeMedicalBinding4.payFeeMedicalBtn : null;
                                if (textView4 != null) {
                                    textView4.setVisibility(8);
                                }
                            } else {
                                FragmentFeeMedicalBinding fragmentFeeMedicalBinding5 = get_binding();
                                TextView textView5 = fragmentFeeMedicalBinding5 != null ? fragmentFeeMedicalBinding5.payFeeMedicalBtn : null;
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
            FragmentFeeMedicalBinding fragmentFeeMedicalBinding6 = get_binding();
            TextView textView6 = fragmentFeeMedicalBinding6 != null ? fragmentFeeMedicalBinding6.payFeeMedicalBtn : null;
            if (textView6 == null) {
                return;
            }
            textView6.setVisibility(8);
            return;
        }
        FragmentFeeMedicalBinding fragmentFeeMedicalBinding7 = get_binding();
        TextView textView7 = fragmentFeeMedicalBinding7 != null ? fragmentFeeMedicalBinding7.payFeeMedicalBtn : null;
        if (textView7 == null) {
            return;
        }
        textView7.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.feemedical.FeeMedicalAdapter.CallBack
    public void selectedIds(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FeeDetailDialog newInstance = FeeDetailDialog.INSTANCE.newInstance(position);
        newInstance.setMedicalCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }
}