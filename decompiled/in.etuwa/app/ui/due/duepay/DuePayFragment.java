package in.etuwa.app.ui.due.duepay;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.due.duepay.DuePayUrl;
import in.etuwa.app.data.model.due.duepaynew.DuePayNew;
import in.etuwa.app.data.model.due.duepaynew.DuePayNewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DuePayFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.due.duepay.DuePayAdapter;
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

/* compiled from: DuePayFragment.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020-H\u0014J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020-H\u0016J\u001a\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020-H\u0014J\b\u0010@\u001a\u00020-H\u0014J\b\u0010A\u001a\u00020-H\u0014J$\u0010B\u001a\u00020-2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006E"}, d2 = {"Lin/etuwa/app/ui/due/duepay/DuePayFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/due/duepay/DuePayAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DuePayFragmentBinding;", "adapter", "Lin/etuwa/app/ui/due/duepay/DuePayAdapter;", "getAdapter", "()Lin/etuwa/app/ui/due/duepay/DuePayAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DuePayFragmentBinding;", "duePayViewModel", "Lin/etuwa/app/ui/due/duepay/DuePayViewModel;", "getDuePayViewModel", "()Lin/etuwa/app/ui/due/duepay/DuePayViewModel;", "duePayViewModel$delegate", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/due/duepaynew/DuePayNew;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "selected", "", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()D", "setTotal", "(D)V", "hideBaseView", "", "hideProgress", "listenResponse", "listenUrlResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "updateSelected", "sel", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DuePayFragment extends BaseFragment implements DuePayAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DuePayFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: duePayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy duePayViewModel;
    private ArrayList<DuePayNew> list;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private double total;

    /* compiled from: DuePayFragment.kt */
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
    public static final DuePayFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public DuePayFragment() {
        final DuePayFragment duePayFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(duePayFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.duePayViewModel = FragmentViewModelLazyKt.createViewModelLazy(duePayFragment, Reflection.getOrCreateKotlinClass(DuePayViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(DuePayViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final DuePayFragment duePayFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DuePayAdapter>() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.due.duepay.DuePayAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DuePayAdapter invoke() {
                ComponentCallbacks componentCallbacks = duePayFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DuePayAdapter.class), b2, b3);
            }
        });
        this.selected = new ArrayList();
        this.list = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = duePayFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final DuePayViewModel getDuePayViewModel() {
        return (DuePayViewModel) this.duePayViewModel.getValue();
    }

    private final DuePayAdapter getAdapter() {
        return (DuePayAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DuePayFragmentBinding get_binding() {
        return this._binding;
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: DuePayFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/due/duepay/DuePayFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/due/duepay/DuePayFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DuePayFragment newInstance() {
            return new DuePayFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DuePayFragmentBinding.inflate(inflater, container, false);
        DuePayFragmentBinding duePayFragmentBinding = get_binding();
        if (duePayFragmentBinding != null) {
            duePayFragmentBinding.setDuePayViewModel(getDuePayViewModel());
        }
        DuePayFragmentBinding duePayFragmentBinding2 = get_binding();
        if (duePayFragmentBinding2 != null) {
            duePayFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DuePayFragmentBinding duePayFragmentBinding3 = get_binding();
        if (duePayFragmentBinding3 != null) {
            return duePayFragmentBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.due));
        }
        hideBaseView();
        DuePayFragmentBinding duePayFragmentBinding = get_binding();
        RecyclerView recyclerView = duePayFragmentBinding != null ? duePayFragmentBinding.rvDuePay : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        DuePayFragmentBinding duePayFragmentBinding2 = get_binding();
        if (duePayFragmentBinding2 != null && (swipeRefreshLayout = duePayFragmentBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    DuePayFragment.setUp$lambda$0(DuePayFragment.this);
                }
            });
        }
        DuePayFragmentBinding duePayFragmentBinding3 = get_binding();
        if (duePayFragmentBinding3 == null || (textView = duePayFragmentBinding3.payDueBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DuePayFragment.setUp$lambda$1(hashMap2, this, hashMap, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(DuePayFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDuePayViewModel().getDues();
        DuePayFragmentBinding duePayFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = duePayFragmentBinding != null ? duePayFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HashMap dueFeeReceipt, DuePayFragment this$0, HashMap dueFeeCollection, View view) {
        Intrinsics.checkNotNullParameter(dueFeeReceipt, "$dueFeeReceipt");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dueFeeCollection, "$dueFeeCollection");
        HashMap hashMap = dueFeeReceipt;
        hashMap.put("DueFeeReceipt[amount]", String.valueOf(this$0.total));
        int i = 0;
        hashMap.put("DueFeeReceipt[receipt_date]", this$0.list.get(0).getDate());
        hashMap.put("Transaction[method]", "5");
        hashMap.put("payment", "1");
        hashMap.put("admission_no", this$0.list.get(0).getAdmission_no());
        hashMap.put("batch_id", this$0.getPreference().getBatchId());
        int size = this$0.selected.size() - 1;
        if (size >= 0) {
            while (true) {
                if (Intrinsics.areEqual(this$0.selected.get(i), "true")) {
                    HashMap hashMap2 = dueFeeCollection;
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][amount]", this$0.list.get(i).getBalance());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][student_id]", this$0.list.get(i).getStudent_id());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][head_id]", this$0.list.get(i).getHead_id());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][due_id]", this$0.list.get(i).getDue_id());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][batch_id]", this$0.getPreference().getBatchId());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][semester_id]", this$0.getPreference().getUserSemId());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][dept_id]", this$0.list.get(i).getDepartment_id());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][collection_date]", this$0.list.get(i).getDate());
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][status]", "1");
                    hashMap2.put("DueFeeCollection[" + this$0.list.get(i).getStudent_id() + "][" + this$0.list.get(i).getDue_id() + "][" + this$0.list.get(i).getHead_id() + "][year_id]", this$0.list.get(i).getYear_id());
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this$0.getDuePayViewModel().getDueUrl(dueFeeCollection, hashMap);
        this$0.listenUrlResponse();
        System.out.println(this$0.selected);
        System.out.println(this$0.total);
        System.out.println(dueFeeCollection);
    }

    private final void listenResponse() {
        getDuePayViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DuePayFragment.listenResponse$lambda$3(DuePayFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(DuePayFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            DuePayNewResponse duePayNewResponse = (DuePayNewResponse) resource.getData();
            if (duePayNewResponse != null) {
                this$0.showBaseView();
                try {
                    this$0.list = duePayNewResponse.getCollect();
                    DuePayAdapter adapter = this$0.getAdapter();
                    ArrayList<DuePayNew> collect = duePayNewResponse.getCollect();
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(collect, requireContext);
                    return;
                } catch (NullPointerException unused) {
                    return;
                }
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
        DuePayFragmentBinding duePayFragmentBinding = this$0.get_binding();
        if (duePayFragmentBinding == null || (recyclerView = duePayFragmentBinding.rvDuePay) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenUrlResponse() {
        getDuePayViewModel().getDueUrlResponse().observe(getViewLifecycleOwner(), new DuePayFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DuePayUrl>, Unit>() { // from class: in.etuwa.app.ui.due.duepay.DuePayFragment$listenUrlResponse$1

            /* compiled from: DuePayFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DuePayUrl> resource) {
                invoke2((Resource<DuePayUrl>) resource);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
            
                r0 = r0.listener;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.due.duepay.DuePayUrl> r4) {
                /*
                    r3 = this;
                    in.etuwa.app.utils.Status r0 = r4.getStatus()
                    int[] r1 = in.etuwa.app.ui.due.duepay.DuePayFragment$listenUrlResponse$1.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 1
                    if (r0 == r1) goto L35
                    r4 = 2
                    if (r0 == r4) goto L2f
                    r4 = 3
                    if (r0 == r4) goto L24
                    r4 = 4
                    if (r0 == r4) goto L19
                    goto L69
                L19:
                    in.etuwa.app.ui.due.duepay.DuePayFragment r4 = in.etuwa.app.ui.due.duepay.DuePayFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.due.duepay.DuePayFragment r4 = in.etuwa.app.ui.due.duepay.DuePayFragment.this
                    r4.showBaseView()
                    goto L69
                L24:
                    in.etuwa.app.ui.due.duepay.DuePayFragment r4 = in.etuwa.app.ui.due.duepay.DuePayFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.due.duepay.DuePayFragment r4 = in.etuwa.app.ui.due.duepay.DuePayFragment.this
                    r4.showBaseView()
                    goto L69
                L2f:
                    in.etuwa.app.ui.due.duepay.DuePayFragment r4 = in.etuwa.app.ui.due.duepay.DuePayFragment.this
                    r4.showProgress()
                    goto L69
                L35:
                    in.etuwa.app.ui.due.duepay.DuePayFragment r0 = in.etuwa.app.ui.due.duepay.DuePayFragment.this
                    r0.hideProgress()
                    java.lang.Object r4 = r4.getData()
                    in.etuwa.app.data.model.due.duepay.DuePayUrl r4 = (in.etuwa.app.data.model.due.duepay.DuePayUrl) r4
                    if (r4 == 0) goto L69
                    in.etuwa.app.ui.due.duepay.DuePayFragment r0 = in.etuwa.app.ui.due.duepay.DuePayFragment.this
                    r0.showBaseView()
                    java.lang.String r1 = r4.getUrl()
                    java.io.PrintStream r2 = java.lang.System.out
                    r2.println(r1)
                    java.lang.String r1 = r4.getUrl()
                    java.lang.String r2 = ""
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                    if (r1 != 0) goto L69
                    in.etuwa.app.helper.MainCallBackListener r0 = in.etuwa.app.ui.due.duepay.DuePayFragment.access$getListener$p(r0)
                    if (r0 == 0) goto L69
                    java.lang.String r4 = r4.getUrl()
                    r0.openPaymentPage(r4)
                L69:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.due.duepay.DuePayFragment$listenUrlResponse$1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        DuePayFragmentBinding duePayFragmentBinding = get_binding();
        if (duePayFragmentBinding == null || (recyclerView = duePayFragmentBinding.rvDuePay) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        DuePayFragmentBinding duePayFragmentBinding = get_binding();
        if (duePayFragmentBinding == null || (recyclerView = duePayFragmentBinding.rvDuePay) == null) {
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

    @Override // in.etuwa.app.ui.due.duepay.DuePayAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        TextView textView;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        int size = total.size() - 1;
        double d = 0.0d;
        if (size >= 0) {
            int i = 0;
            while (true) {
                d += Double.parseDouble(total.get(i));
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.selected = sel;
        this.total = d;
        DuePayFragmentBinding duePayFragmentBinding = get_binding();
        TextView textView2 = duePayFragmentBinding != null ? duePayFragmentBinding.tvDueTotal : null;
        if (textView2 != null) {
            textView2.setText(String.valueOf(d));
        }
        if (d <= 0.0d) {
            DuePayFragmentBinding duePayFragmentBinding2 = get_binding();
            textView = duePayFragmentBinding2 != null ? duePayFragmentBinding2.payDueBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        DuePayFragmentBinding duePayFragmentBinding3 = get_binding();
        textView = duePayFragmentBinding3 != null ? duePayFragmentBinding3.payDueBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }
}