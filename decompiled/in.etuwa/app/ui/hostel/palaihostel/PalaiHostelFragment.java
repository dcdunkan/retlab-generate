package in.etuwa.app.ui.hostel.palaihostel;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.HostelFeePalaiResponse;
import in.etuwa.app.data.model.hostel.HostelMonth;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmission;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmissionResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiTypesResponse;
import in.etuwa.app.data.model.hostel.HostelResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentHostelFeePalaiBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdapter;
import in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdmissionAdapter;
import in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmDialog;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: PalaiHostelFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PalaiHostelFragment extends BaseFragment implements PalaiHostelAdapter.CallBack, HostelFeeConfirmFragment.FeeDetailListner, PalaiHostelFeeConfirmDialog.FeeDetailListner, PalaiHostelAdmissionAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelFeePalaiBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: adapter2$delegate, reason: from kotlin metadata */
    private final Lazy adapter2;
    private int amounts;
    private String date;
    private String fineAmount;
    private ArrayList<HostelMonth> hostel;
    private ArrayList<HostelPalaiAdmission> hostelNew;
    private MainCallBackListener listener;
    private String month;

    /* JADX INFO: renamed from: palaiHostelViewModel$delegate, reason: from kotlin metadata */
    private final Lazy palaiHostelViewModel;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private int total;
    private int totalAmount;
    private Integer type;
    private String url;
    private String year;

    @JvmStatic
    public static final PalaiHostelFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public PalaiHostelFragment() {
        final PalaiHostelFragment palaiHostelFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return palaiHostelFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(palaiHostelFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.palaiHostelViewModel = FragmentViewModelLazyKt.createViewModelLazy(palaiHostelFragment, Reflection.getOrCreateKotlinClass(PalaiHostelViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(PalaiHostelViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final PalaiHostelFragment palaiHostelFragment2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelPalaiSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.palaihostel.HostelPalaiSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelPalaiSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = palaiHostelFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelPalaiSpinnerAdapter.class), b2, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        final byte b4 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<PalaiHostelAdapter>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PalaiHostelAdapter invoke() {
                ComponentCallbacks componentCallbacks = palaiHostelFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PalaiHostelAdapter.class), b3, b4);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.adapter2 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<PalaiHostelAdmissionAdapter>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdmissionAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PalaiHostelAdmissionAdapter invoke() {
                ComponentCallbacks componentCallbacks = palaiHostelFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PalaiHostelAdmissionAdapter.class), b5, b6);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        final byte b8 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = palaiHostelFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b7, b8);
            }
        });
        this.month = "";
        this.year = "";
        this.date = "";
        this.selected = new ArrayList();
        this.hostel = new ArrayList<>();
        this.hostelNew = new ArrayList<>();
        this.url = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PalaiHostelViewModel getPalaiHostelViewModel() {
        return (PalaiHostelViewModel) this.palaiHostelViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HostelPalaiSpinnerAdapter getSpinnerAdapter() {
        return (HostelPalaiSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PalaiHostelAdapter getAdapter() {
        return (PalaiHostelAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PalaiHostelAdmissionAdapter getAdapter2() {
        return (PalaiHostelAdmissionAdapter) this.adapter2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentHostelFeePalaiBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getMonth() {
        return this.month;
    }

    public final void setMonth(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.month = str;
    }

    public final String getYear() {
        return this.year;
    }

    public final void setYear(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.year = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final int getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(int i) {
        this.totalAmount = i;
    }

    public final int getAmounts() {
        return this.amounts;
    }

    public final void setAmounts(int i) {
        this.amounts = i;
    }

    public final String getFineAmount() {
        return this.fineAmount;
    }

    public final void setFineAmount(String str) {
        this.fineAmount = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    /* JADX INFO: compiled from: PalaiHostelFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/palaihostel/PalaiHostelFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/palaihostel/PalaiHostelFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PalaiHostelFragment newInstance() {
            return new PalaiHostelFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHostelFeePalaiBinding.inflate(inflater, container, false);
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = get_binding();
        if (fragmentHostelFeePalaiBinding != null) {
            fragmentHostelFeePalaiBinding.setPalaiHostelViewModel(getPalaiHostelViewModel());
        }
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding2 = get_binding();
        if (fragmentHostelFeePalaiBinding2 != null) {
            fragmentHostelFeePalaiBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding3 = get_binding();
        if (fragmentHostelFeePalaiBinding3 != null) {
            return fragmentHostelFeePalaiBinding3.getRoot();
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
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelFeePalaiBinding != null ? fragmentHostelFeePalaiBinding.rvHostelFee : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentHostelFeePalaiBinding2 != null ? fragmentHostelFeePalaiBinding2.rvHostelFeeAdmission : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Pay Fee");
        }
        hideBaseView();
        listenResponse();
        listenTypesesponse();
        listenHostelPalaiResponse();
        listenUrlResponse();
        getPreference().setNewLogin(false);
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding3 = get_binding();
        Spinner spinner = fragmentHostelFeePalaiBinding3 != null ? fragmentHostelFeePalaiBinding3.spinnerHostelFee : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenMonthResponse();
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding4 = get_binding();
        RecyclerView recyclerView3 = fragmentHostelFeePalaiBinding4 != null ? fragmentHostelFeePalaiBinding4.rvHostelFee : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapter());
        }
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding5 = get_binding();
        RecyclerView recyclerView4 = fragmentHostelFeePalaiBinding5 != null ? fragmentHostelFeePalaiBinding5.rvHostelFeeAdmission : null;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(getAdapter2());
        }
        getAdapter().setCallBack(this);
        getAdapter2().setCallBack(this);
        getPalaiHostelViewModel().getHostelPalaiFeeTypes();
        final HashMap map = new HashMap();
        final HashMap map2 = new HashMap();
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
            FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding6 = get_binding();
            LinearLayout linearLayout = fragmentHostelFeePalaiBinding6 != null ? fragmentHostelFeePalaiBinding6.monthLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding7 = get_binding();
            TextView textView2 = fragmentHostelFeePalaiBinding7 != null ? fragmentHostelFeePalaiBinding7.tvHostelTotal : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding8 = get_binding();
            LinearLayout linearLayout2 = fragmentHostelFeePalaiBinding8 != null ? fragmentHostelFeePalaiBinding8.monthLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding9 = get_binding();
            TextView textView3 = fragmentHostelFeePalaiBinding9 != null ? fragmentHostelFeePalaiBinding9.tvHostelTotal : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        }
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding10 = get_binding();
        Spinner spinner2 = fragmentHostelFeePalaiBinding10 != null ? fragmentHostelFeePalaiBinding10.spinnerHostelFee : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    LinearLayout linearLayout3;
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding11 = PalaiHostelFragment.this.get_binding();
                    TextView textView4 = fragmentHostelFeePalaiBinding11 != null ? fragmentHostelFeePalaiBinding11.payNowBtn : null;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding12 = PalaiHostelFragment.this.get_binding();
                    TextView textView5 = fragmentHostelFeePalaiBinding12 != null ? fragmentHostelFeePalaiBinding12.tvHostelTotal : null;
                    if (textView5 != null) {
                        textView5.setText("0");
                    }
                    PalaiHostelFragment palaiHostelFragment = PalaiHostelFragment.this;
                    palaiHostelFragment.setType(Integer.valueOf(palaiHostelFragment.getSpinnerAdapter().getSemester(position).getId()));
                    Integer type = PalaiHostelFragment.this.getType();
                    if (type != null && type.intValue() == 2) {
                        PalaiHostelFragment.this.getPalaiHostelViewModel().getHostelFee();
                        PalaiHostelFragment.this.getPalaiHostelViewModel().getHostelMonthFee();
                        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding13 = PalaiHostelFragment.this.get_binding();
                        RecyclerView recyclerView5 = fragmentHostelFeePalaiBinding13 != null ? fragmentHostelFeePalaiBinding13.rvHostelFee : null;
                        if (recyclerView5 != null) {
                            recyclerView5.setVisibility(8);
                        }
                        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding14 = PalaiHostelFragment.this.get_binding();
                        RecyclerView recyclerView6 = fragmentHostelFeePalaiBinding14 != null ? fragmentHostelFeePalaiBinding14.rvHostelFeeAdmission : null;
                        if (recyclerView6 != null) {
                            recyclerView6.setVisibility(8);
                        }
                        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding15 = PalaiHostelFragment.this.get_binding();
                        LinearLayout linearLayout4 = fragmentHostelFeePalaiBinding15 != null ? fragmentHostelFeePalaiBinding15.swipeLayout : null;
                        if (linearLayout4 != null) {
                            linearLayout4.setVisibility(0);
                        }
                        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding16 = PalaiHostelFragment.this.get_binding();
                        linearLayout3 = fragmentHostelFeePalaiBinding16 != null ? fragmentHostelFeePalaiBinding16.swipeLayout2 : null;
                        if (linearLayout3 == null) {
                            return;
                        }
                        linearLayout3.setVisibility(8);
                        return;
                    }
                    PalaiHostelFragment.this.getPalaiHostelViewModel().getHostelPalaiFee(String.valueOf(PalaiHostelFragment.this.getType()));
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding17 = PalaiHostelFragment.this.get_binding();
                    RecyclerView recyclerView7 = fragmentHostelFeePalaiBinding17 != null ? fragmentHostelFeePalaiBinding17.rvHostelFee : null;
                    if (recyclerView7 != null) {
                        recyclerView7.setVisibility(8);
                    }
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding18 = PalaiHostelFragment.this.get_binding();
                    RecyclerView recyclerView8 = fragmentHostelFeePalaiBinding18 != null ? fragmentHostelFeePalaiBinding18.rvHostelFeeAdmission : null;
                    if (recyclerView8 != null) {
                        recyclerView8.setVisibility(0);
                    }
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding19 = PalaiHostelFragment.this.get_binding();
                    LinearLayout linearLayout5 = fragmentHostelFeePalaiBinding19 != null ? fragmentHostelFeePalaiBinding19.swipeLayout : null;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(8);
                    }
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding20 = PalaiHostelFragment.this.get_binding();
                    linearLayout3 = fragmentHostelFeePalaiBinding20 != null ? fragmentHostelFeePalaiBinding20.swipeLayout2 : null;
                    if (linearLayout3 == null) {
                        return;
                    }
                    linearLayout3.setVisibility(0);
                }
            });
        }
        System.out.println(this.selected.size());
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding11 = get_binding();
        if (fragmentHostelFeePalaiBinding11 == null || (textView = fragmentHostelFeePalaiBinding11.payNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PalaiHostelFragment.setUp$lambda$0(map, map2, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x05a8 A[LOOP:2: B:10:0x00af->B:31:0x05a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0ac7 A[LOOP:1: B:43:0x06a0->B:55:0x0ac7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0af5 A[EDGE_INSN: B:64:0x0af5->B:58:0x0af5 BREAK  A[LOOP:1: B:43:0x06a0->B:55:0x0ac7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x05ce A[EDGE_INSN: B:65:0x05ce->B:33:0x05ce BREAK  A[LOOP:2: B:10:0x00af->B:31:0x05a8], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void setUp$lambda$0(java.util.HashMap r35, java.util.HashMap r36, in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment r37, android.view.View r38) {
        /*
            Method dump skipped, instruction units count: 2878
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment.setUp$lambda$0(java.util.HashMap, java.util.HashMap, in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment, android.view.View):void");
    }

    private final void listenResponse() {
        getPalaiHostelViewModel().getResponse().observe(getViewLifecycleOwner(), new PalaiHostelFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: PalaiHostelFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelResponse> resource) {
                invoke2((Resource<HostelResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PalaiHostelFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    }
                }
                PalaiHostelFragment.this.hideProgress();
                HostelResponse data = resource.getData();
                if (data != null) {
                    PalaiHostelFragment palaiHostelFragment = PalaiHostelFragment.this;
                    palaiHostelFragment.showBaseView();
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = palaiHostelFragment.get_binding();
                    TextView textView = fragmentHostelFeePalaiBinding != null ? fragmentHostelFeePalaiBinding.roomNo : null;
                    if (textView != null) {
                        textView.setText(data.getRoomNo());
                    }
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding2 = palaiHostelFragment.get_binding();
                    TextView textView2 = fragmentHostelFeePalaiBinding2 != null ? fragmentHostelFeePalaiBinding2.joinDate : null;
                    if (textView2 != null) {
                        textView2.setText(data.getJoinDate());
                    }
                    FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding3 = palaiHostelFragment.get_binding();
                    TextView textView3 = fragmentHostelFeePalaiBinding3 != null ? fragmentHostelFeePalaiBinding3.hostelTv : null;
                    if (textView3 != null) {
                        textView3.setText(data.getHostel());
                    }
                    try {
                        palaiHostelFragment.setMonth(data.getMonth());
                        palaiHostelFragment.setYear(data.getYear());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenMonthResponse() {
        getPalaiHostelViewModel().getMonthResponse().observe(getViewLifecycleOwner(), new PalaiHostelFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelMonthResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment.listenMonthResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$listenMonthResponse$1$WhenMappings */
            /* JADX INFO: compiled from: PalaiHostelFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelMonthResponse> resource) {
                invoke2((Resource<HostelMonthResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelMonthResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PalaiHostelFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    }
                }
                PalaiHostelFragment.this.hideProgress();
                HostelMonthResponse data = resource.getData();
                if (data != null) {
                    PalaiHostelFragment palaiHostelFragment = PalaiHostelFragment.this;
                    palaiHostelFragment.showBaseView();
                    try {
                        PalaiHostelAdapter adapter = palaiHostelFragment.getAdapter();
                        ArrayList<HostelMonth> hostel = data.getHostel();
                        Integer type = palaiHostelFragment.getType();
                        Intrinsics.checkNotNull(type);
                        adapter.addItems(hostel, type.intValue());
                        palaiHostelFragment.hostel = data.getHostel();
                        palaiHostelFragment.setDate(data.getDate());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenTypesesponse() {
        getPalaiHostelViewModel().getHostelPalaiFeeTypesResponse().observe(getViewLifecycleOwner(), new PalaiHostelFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelPalaiTypesResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment.listenTypesesponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$listenTypesesponse$1$WhenMappings */
            /* JADX INFO: compiled from: PalaiHostelFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelPalaiTypesResponse> resource) {
                invoke2((Resource<HostelPalaiTypesResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelPalaiTypesResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PalaiHostelFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    }
                }
                PalaiHostelFragment.this.hideProgress();
                HostelPalaiTypesResponse data = resource.getData();
                if (data != null) {
                    PalaiHostelFragment palaiHostelFragment = PalaiHostelFragment.this;
                    palaiHostelFragment.showBaseView();
                    try {
                        palaiHostelFragment.getSpinnerAdapter().addItems(data.getTypes());
                    } catch (NullPointerException unused) {
                        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = palaiHostelFragment.get_binding();
                        RecyclerView recyclerView = fragmentHostelFeePalaiBinding != null ? fragmentHostelFeePalaiBinding.rvHostelFee : null;
                        if (recyclerView == null) {
                            return;
                        }
                        recyclerView.setVisibility(8);
                    }
                }
            }
        }));
    }

    private final void listenHostelPalaiResponse() {
        getPalaiHostelViewModel().getHostelPalaiFeeResponse().observe(getViewLifecycleOwner(), new PalaiHostelFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelPalaiAdmissionResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment.listenHostelPalaiResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$listenHostelPalaiResponse$1$WhenMappings */
            /* JADX INFO: compiled from: PalaiHostelFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelPalaiAdmissionResponse> resource) {
                invoke2((Resource<HostelPalaiAdmissionResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelPalaiAdmissionResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PalaiHostelFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    }
                }
                PalaiHostelFragment.this.hideProgress();
                HostelPalaiAdmissionResponse data = resource.getData();
                if (data != null) {
                    PalaiHostelFragment palaiHostelFragment = PalaiHostelFragment.this;
                    palaiHostelFragment.showBaseView();
                    try {
                        PalaiHostelAdmissionAdapter adapter2 = palaiHostelFragment.getAdapter2();
                        ArrayList<HostelPalaiAdmission> hostel = data.getHostel();
                        Integer type = palaiHostelFragment.getType();
                        Intrinsics.checkNotNull(type);
                        adapter2.addAdmsnItems(hostel, type.intValue());
                        palaiHostelFragment.hostelNew = data.getHostel();
                        palaiHostelFragment.setDate(data.getDate());
                        palaiHostelFragment.setFineAmount(data.getFine());
                    } catch (NullPointerException unused) {
                        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = palaiHostelFragment.get_binding();
                        RecyclerView recyclerView = fragmentHostelFeePalaiBinding != null ? fragmentHostelFeePalaiBinding.rvHostelFee : null;
                        if (recyclerView == null) {
                            return;
                        }
                        recyclerView.setVisibility(8);
                    }
                }
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = get_binding();
        if (fragmentHostelFeePalaiBinding == null || (recyclerView = fragmentHostelFeePalaiBinding.rvHostelFee) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = get_binding();
        if (fragmentHostelFeePalaiBinding == null || (recyclerView = fragmentHostelFeePalaiBinding.rvHostelFee) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
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

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdapter.CallBack, in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdmissionAdapter.CallBack
    public void selectedIds(int total, int type) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelFeeConfirmFragment hostelFeeConfirmFragmentNewInstance = HostelFeeConfirmFragment.INSTANCE.newInstance(total, type);
        hostelFeeConfirmFragmentNewInstance.setCallBack2(this);
        hostelFeeConfirmFragmentNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdapter.CallBack, in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdmissionAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        TextView textView;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        int size = total.size() - 1;
        int i = 0;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                i += Integer.parseInt(total.get(i2));
                if (i2 == size) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.selected.clear();
        this.selected = sel;
        this.total = i;
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding = get_binding();
        TextView textView2 = fragmentHostelFeePalaiBinding != null ? fragmentHostelFeePalaiBinding.tvHostelTotal : null;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i));
        }
        if (i <= 0) {
            FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding2 = get_binding();
            textView = fragmentHostelFeePalaiBinding2 != null ? fragmentHostelFeePalaiBinding2.payNowBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
            FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding3 = get_binding();
            textView = fragmentHostelFeePalaiBinding3 != null ? fragmentHostelFeePalaiBinding3.payNowBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        FragmentHostelFeePalaiBinding fragmentHostelFeePalaiBinding4 = get_binding();
        textView = fragmentHostelFeePalaiBinding4 != null ? fragmentHostelFeePalaiBinding4.payNowBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdapter.CallBack, in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdmissionAdapter.CallBack
    public void kmeaFees(int position) {
        MainCallBackListener mainCallBackListener;
        if (!StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || (mainCallBackListener = this.listener) == null) {
            return;
        }
        mainCallBackListener.showKmeaHostelFragment(position);
    }

    @Override // in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment.FeeDetailListner
    public void dismiss() {
        getPalaiHostelViewModel().getHostelFee();
        getPalaiHostelViewModel().getHostelMonthFee();
    }

    @Override // in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmDialog.FeeDetailListner
    public void openPaymentPage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPaymentPage(url);
        }
    }

    private final void listenUrlResponse() {
        getPalaiHostelViewModel().getUrlResponse().observe(getViewLifecycleOwner(), new PalaiHostelFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelFeePalaiResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment.listenUrlResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelFragment$listenUrlResponse$1$WhenMappings */
            /* JADX INFO: compiled from: PalaiHostelFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelFeePalaiResponse> resource) {
                invoke2((Resource<HostelFeePalaiResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelFeePalaiResponse> resource) {
                MainCallBackListener mainCallBackListener;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PalaiHostelFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        PalaiHostelFragment.this.hideProgress();
                        PalaiHostelFragment.this.showBaseView();
                        return;
                    }
                }
                PalaiHostelFragment.this.hideProgress();
                HostelFeePalaiResponse data = resource.getData();
                if (data != null) {
                    PalaiHostelFragment palaiHostelFragment = PalaiHostelFragment.this;
                    palaiHostelFragment.showBaseView();
                    System.out.println((Object) data.getUrl());
                    Integer type = palaiHostelFragment.getType();
                    if (type != null && type.intValue() == 2 && !Intrinsics.areEqual(data.getUrl(), "")) {
                        FragmentManager childFragmentManager = palaiHostelFragment.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        PalaiHostelFeeConfirmDialog palaiHostelFeeConfirmDialogNewInstance = PalaiHostelFeeConfirmDialog.INSTANCE.newInstance(String.valueOf(data.getTotal()), String.valueOf(data.getFine()), String.valueOf(data.getSubtotal()), data.getUrl());
                        palaiHostelFeeConfirmDialogNewInstance.setCallBack(palaiHostelFragment);
                        palaiHostelFeeConfirmDialogNewInstance.show(childFragmentManager, (String) null);
                    }
                    Integer type2 = palaiHostelFragment.getType();
                    if (type2 == null || type2.intValue() != 1 || Intrinsics.areEqual(data.getUrl(), "") || (mainCallBackListener = palaiHostelFragment.listener) == null) {
                        return;
                    }
                    mainCallBackListener.openPaymentPage(data.getUrl());
                }
            }
        }));
    }
}