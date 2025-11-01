package in.etuwa.app.ui.hostel.tkmhostel.kmeahostel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.HostelFee;
import in.etuwa.app.data.model.hostel.HostelFeeResponse;
import in.etuwa.app.data.model.hostel.HostelMonth;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.databinding.FragmentKmeaBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
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

/* compiled from: KmeaHostelFragment.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 L2\u00020\u0001:\u0002LMB\u0005¢\u0006\u0002\u0010\u0002J\b\u00106\u001a\u000207H\u0014J\b\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u000207H\u0002J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0012\u0010=\u001a\u0002072\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010F\u001a\u000207H\u0016J\b\u0010G\u001a\u000207H\u0016J\u001a\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020A2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010J\u001a\u000207H\u0014J\b\u0010K\u001a\u000207H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00100\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\nR\u001a\u00103\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013¨\u0006N"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/kmeahostel/KmeaHostelFragment;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentKmeaBinding;", "amounts", "", "getAmounts", "()I", "setAmounts", "(I)V", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentKmeaBinding;", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "fineAmount", "getFineAmount", "setFineAmount", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/HostelMonth;", "Lkotlin/collections/ArrayList;", "kmeaHostelViewModel", "Lin/etuwa/app/ui/hostel/tkmhostel/kmeahostel/KmeaHostelViewModel;", "getKmeaHostelViewModel", "()Lin/etuwa/app/ui/hostel/tkmhostel/kmeahostel/KmeaHostelViewModel;", "kmeaHostelViewModel$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "month", "getMonth", "setMonth", "monthHashMap", "Ljava/util/HashMap;", "getMonthHashMap", "()Ljava/util/HashMap;", "pos", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "totalAmount", "getTotalAmount", "setTotalAmount", "year", "getYear", "setYear", "hideProgress", "", "listenResponse", "listenUrlResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "FeeDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmeaHostelFragment extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentKmeaBinding _binding;
    private int amounts;
    private String date;
    private int fineAmount;
    private ArrayList<HostelMonth> hostel;

    /* renamed from: kmeaHostelViewModel$delegate, reason: from kotlin metadata */
    private final Lazy kmeaHostelViewModel;
    private MainCallBackListener listener;
    private String month;
    private final HashMap<String, String> monthHashMap;
    private Integer pos;
    private int totalAmount;
    private String year;

    /* compiled from: KmeaHostelFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/kmeahostel/KmeaHostelFragment$FeeDetailListner;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface FeeDetailListner {
        void dismiss();
    }

    @JvmStatic
    public static final KmeaHostelFragment newInstance(int i) {
        return INSTANCE.newInstance(i);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public KmeaHostelFragment() {
        final KmeaHostelFragment kmeaHostelFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(kmeaHostelFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.kmeaHostelViewModel = FragmentViewModelLazyKt.createViewModelLazy(kmeaHostelFragment, Reflection.getOrCreateKotlinClass(KmeaHostelViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(KmeaHostelViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.month = "";
        this.year = "";
        this.hostel = new ArrayList<>();
        this.monthHashMap = new HashMap<>();
        this.date = "";
    }

    private final KmeaHostelViewModel getKmeaHostelViewModel() {
        return (KmeaHostelViewModel) this.kmeaHostelViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentKmeaBinding get_binding() {
        return this._binding;
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

    public final HashMap<String, String> getMonthHashMap() {
        return this.monthHashMap;
    }

    public final Integer getPos() {
        return this.pos;
    }

    public final void setPos(Integer num) {
        this.pos = num;
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

    public final int getFineAmount() {
        return this.fineAmount;
    }

    public final void setFineAmount(int i) {
        this.fineAmount = i;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    /* compiled from: KmeaHostelFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/kmeahostel/KmeaHostelFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/tkmhostel/kmeahostel/KmeaHostelFragment;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final KmeaHostelFragment newInstance(int position) {
            KmeaHostelFragment kmeaHostelFragment = new KmeaHostelFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(HostelFeeConfirmFragmentKt.ARG_MONTHS, position);
            kmeaHostelFragment.setArguments(bundle);
            return kmeaHostelFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pos = Integer.valueOf(arguments.getInt(HostelFeeConfirmFragmentKt.ARG_MONTHS));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentKmeaBinding.inflate(inflater, container, false);
        FragmentKmeaBinding fragmentKmeaBinding = get_binding();
        if (fragmentKmeaBinding != null) {
            fragmentKmeaBinding.setKmeaHostelViewModel(getKmeaHostelViewModel());
        }
        FragmentKmeaBinding fragmentKmeaBinding2 = get_binding();
        if (fragmentKmeaBinding2 != null) {
            fragmentKmeaBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentKmeaBinding fragmentKmeaBinding3 = get_binding();
        if (fragmentKmeaBinding3 != null) {
            return fragmentKmeaBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        System.out.println((Object) ("===========================" + this.monthHashMap));
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        TextView textView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Pay Confirmation");
        }
        System.out.println((Object) "=====================");
        System.out.println(this.pos);
        listenResponse();
        getKmeaHostelViewModel().getHostelMonthFee();
        FragmentKmeaBinding fragmentKmeaBinding = get_binding();
        if (fragmentKmeaBinding == null || (textView = fragmentKmeaBinding.payNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KmeaHostelFragment.setUp$lambda$1(KmeaHostelFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(KmeaHostelFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList<HostelMonth> arrayList = this$0.hostel;
        Integer num = this$0.pos;
        Intrinsics.checkNotNull(num);
        ArrayList<HostelFee> payment = arrayList.get(num.intValue()).getPayment();
        int size = payment.size();
        HashMap hashMap3 = hashMap2;
        ArrayList<HostelMonth> arrayList2 = this$0.hostel;
        Integer num2 = this$0.pos;
        Intrinsics.checkNotNull(num2);
        String year = arrayList2.get(num2.intValue()).getYear();
        ArrayList<HostelMonth> arrayList3 = this$0.hostel;
        Integer num3 = this$0.pos;
        Intrinsics.checkNotNull(num3);
        String str = "fine_" + year + HelpFormatter.DEFAULT_OPT_PREFIX + arrayList3.get(num3.intValue()).getMonth() + "-01";
        ArrayList<HostelMonth> arrayList4 = this$0.hostel;
        Integer num4 = this$0.pos;
        Intrinsics.checkNotNull(num4);
        hashMap3.put(str, arrayList4.get(num4.intValue()).getFine());
        int i = this$0.amounts;
        ArrayList<HostelMonth> arrayList5 = this$0.hostel;
        Integer num5 = this$0.pos;
        Intrinsics.checkNotNull(num5);
        this$0.amounts = i + arrayList5.get(num5.intValue()).getAmount();
        int i2 = this$0.totalAmount;
        ArrayList<HostelMonth> arrayList6 = this$0.hostel;
        Integer num6 = this$0.pos;
        Intrinsics.checkNotNull(num6);
        int amount = arrayList6.get(num6.intValue()).getAmount();
        ArrayList<HostelMonth> arrayList7 = this$0.hostel;
        Integer num7 = this$0.pos;
        Intrinsics.checkNotNull(num7);
        this$0.totalAmount = i2 + amount + Integer.parseInt(arrayList7.get(num7.intValue()).getFine());
        int i3 = this$0.fineAmount;
        ArrayList<HostelMonth> arrayList8 = this$0.hostel;
        Integer num8 = this$0.pos;
        Intrinsics.checkNotNull(num8);
        this$0.fineAmount = i3 + Integer.parseInt(arrayList8.get(num8.intValue()).getFine());
        hashMap3.put("payment", "1");
        hashMap3.put("Transaction[method]", "5");
        hashMap3.put("FeeReceipt[receipt_date]", this$0.date);
        int i4 = size - 1;
        if (i4 >= 0) {
            int i5 = 0;
            while (true) {
                HashMap hashMap4 = hashMap;
                ArrayList<HostelMonth> arrayList9 = this$0.hostel;
                Integer num9 = this$0.pos;
                Intrinsics.checkNotNull(num9);
                String year2 = arrayList9.get(num9.intValue()).getYear();
                ArrayList<HostelMonth> arrayList10 = this$0.hostel;
                Integer num10 = this$0.pos;
                Intrinsics.checkNotNull(num10);
                hashMap4.put("FeeCollection[" + year2 + "][" + arrayList10.get(num10.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][amount]", payment.get(i5).getAmount());
                ArrayList<HostelMonth> arrayList11 = this$0.hostel;
                Integer num11 = this$0.pos;
                Intrinsics.checkNotNull(num11);
                String year3 = arrayList11.get(num11.intValue()).getYear();
                ArrayList<HostelMonth> arrayList12 = this$0.hostel;
                Integer num12 = this$0.pos;
                Intrinsics.checkNotNull(num12);
                hashMap4.put("FeeCollection[" + year3 + "][" + arrayList12.get(num12.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][feegroup_id]", payment.get(i5).getFeeheadgroup_id());
                ArrayList<HostelMonth> arrayList13 = this$0.hostel;
                Integer num13 = this$0.pos;
                Intrinsics.checkNotNull(num13);
                String year4 = arrayList13.get(num13.intValue()).getYear();
                ArrayList<HostelMonth> arrayList14 = this$0.hostel;
                Integer num14 = this$0.pos;
                Intrinsics.checkNotNull(num14);
                hashMap4.put("FeeCollection[" + year4 + "][" + arrayList14.get(num14.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][feehead_id]", payment.get(i5).getFeehead_id());
                ArrayList<HostelMonth> arrayList15 = this$0.hostel;
                Integer num15 = this$0.pos;
                Intrinsics.checkNotNull(num15);
                String year5 = arrayList15.get(num15.intValue()).getYear();
                ArrayList<HostelMonth> arrayList16 = this$0.hostel;
                Integer num16 = this$0.pos;
                Intrinsics.checkNotNull(num16);
                hashMap4.put("FeeCollection[" + year5 + "][" + arrayList16.get(num16.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][tenant_id]", payment.get(i5).getTenant_id());
                ArrayList<HostelMonth> arrayList17 = this$0.hostel;
                Integer num17 = this$0.pos;
                Intrinsics.checkNotNull(num17);
                String year6 = arrayList17.get(num17.intValue()).getYear();
                ArrayList<HostelMonth> arrayList18 = this$0.hostel;
                Integer num18 = this$0.pos;
                Intrinsics.checkNotNull(num18);
                hashMap4.put("FeeCollection[" + year6 + "][" + arrayList18.get(num18.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][installment]", String.valueOf(payment.get(i5).getInstallment()));
                ArrayList<HostelMonth> arrayList19 = this$0.hostel;
                Integer num19 = this$0.pos;
                Intrinsics.checkNotNull(num19);
                String year7 = arrayList19.get(num19.intValue()).getYear();
                ArrayList<HostelMonth> arrayList20 = this$0.hostel;
                Integer num20 = this$0.pos;
                Intrinsics.checkNotNull(num20);
                hashMap4.put("FeeCollection[" + year7 + "][" + arrayList20.get(num20.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][user_id]", payment.get(i5).getUser_id());
                ArrayList<HostelMonth> arrayList21 = this$0.hostel;
                Integer num21 = this$0.pos;
                Intrinsics.checkNotNull(num21);
                String year8 = arrayList21.get(num21.intValue()).getYear();
                ArrayList<HostelMonth> arrayList22 = this$0.hostel;
                Integer num22 = this$0.pos;
                Intrinsics.checkNotNull(num22);
                hashMap4.put("FeeCollection[" + year8 + "][" + arrayList22.get(num22.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][status]", String.valueOf(payment.get(i5).getStatus()));
                ArrayList<HostelMonth> arrayList23 = this$0.hostel;
                Integer num23 = this$0.pos;
                Intrinsics.checkNotNull(num23);
                String year9 = arrayList23.get(num23.intValue()).getYear();
                ArrayList<HostelMonth> arrayList24 = this$0.hostel;
                Integer num24 = this$0.pos;
                Intrinsics.checkNotNull(num24);
                hashMap4.put("FeeCollection[" + year9 + "][" + arrayList24.get(num24.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][feetype]", payment.get(i5).getFeetype());
                ArrayList<HostelMonth> arrayList25 = this$0.hostel;
                Integer num25 = this$0.pos;
                Intrinsics.checkNotNull(num25);
                String year10 = arrayList25.get(num25.intValue()).getYear();
                ArrayList<HostelMonth> arrayList26 = this$0.hostel;
                Integer num26 = this$0.pos;
                Intrinsics.checkNotNull(num26);
                hashMap4.put("FeeCollection[" + year10 + "][" + arrayList26.get(num26.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][hostel_id]", payment.get(i5).getHostel_id());
                ArrayList<HostelMonth> arrayList27 = this$0.hostel;
                Integer num27 = this$0.pos;
                Intrinsics.checkNotNull(num27);
                String year11 = arrayList27.get(num27.intValue()).getYear();
                ArrayList<HostelMonth> arrayList28 = this$0.hostel;
                Integer num28 = this$0.pos;
                Intrinsics.checkNotNull(num28);
                String str2 = "FeeCollection[" + year11 + "][" + arrayList28.get(num28.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][month]";
                ArrayList<HostelMonth> arrayList29 = this$0.hostel;
                Integer num29 = this$0.pos;
                Intrinsics.checkNotNull(num29);
                hashMap4.put(str2, arrayList29.get(num29.intValue()).getMonth());
                ArrayList<HostelMonth> arrayList30 = this$0.hostel;
                Integer num30 = this$0.pos;
                Intrinsics.checkNotNull(num30);
                String year12 = arrayList30.get(num30.intValue()).getYear();
                ArrayList<HostelMonth> arrayList31 = this$0.hostel;
                Integer num31 = this$0.pos;
                Intrinsics.checkNotNull(num31);
                String str3 = "FeeCollection[" + year12 + "][" + arrayList31.get(num31.intValue()).getMonth() + "][" + payment.get(i5).getFeehead_id() + "][year]";
                ArrayList<HostelMonth> arrayList32 = this$0.hostel;
                Integer num32 = this$0.pos;
                Intrinsics.checkNotNull(num32);
                hashMap4.put(str3, arrayList32.get(num32.intValue()).getYear());
                if (i5 == i4) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        System.out.println((Object) ("amount - " + this$0.amounts + " totalAmount - " + this$0.totalAmount + " fineTotal - " + this$0.fineAmount));
        hashMap3.put("FeeReceipt[total_amount]", String.valueOf(this$0.totalAmount));
        hashMap3.put("FeeReceipt[amount]", String.valueOf(this$0.amounts));
        hashMap3.put("FeeReceipt[fine_amount]", String.valueOf(this$0.fineAmount));
        this$0.getKmeaHostelViewModel().getHostelFee(hashMap, hashMap3);
        this$0.listenUrlResponse();
    }

    private final void listenResponse() {
        getKmeaHostelViewModel().getMonthResponse().observe(getViewLifecycleOwner(), new KmeaHostelFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelMonthResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$listenResponse$1

            /* compiled from: KmeaHostelFragment.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelMonthResponse> resource) {
                FragmentKmeaBinding fragmentKmeaBinding;
                FragmentKmeaBinding fragmentKmeaBinding2;
                FragmentKmeaBinding fragmentKmeaBinding3;
                FragmentKmeaBinding fragmentKmeaBinding4;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        KmeaHostelFragment.this.showProgress();
                        return;
                    } else if (i == 3) {
                        KmeaHostelFragment.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        KmeaHostelFragment.this.hideProgress();
                        return;
                    }
                }
                KmeaHostelFragment.this.hideProgress();
                HostelMonthResponse data = resource.getData();
                if (data != null) {
                    KmeaHostelFragment kmeaHostelFragment = KmeaHostelFragment.this;
                    try {
                        kmeaHostelFragment.hostel = data.getHostel();
                        kmeaHostelFragment.setDate(data.getDate());
                        fragmentKmeaBinding = kmeaHostelFragment.get_binding();
                        TextView textView = fragmentKmeaBinding != null ? fragmentKmeaBinding.kmeaMonthTv : null;
                        if (textView != null) {
                            ArrayList<HostelMonth> hostel = data.getHostel();
                            Integer pos = kmeaHostelFragment.getPos();
                            Intrinsics.checkNotNull(pos);
                            String month = hostel.get(pos.intValue()).getMonth();
                            ArrayList<HostelMonth> hostel2 = data.getHostel();
                            Integer pos2 = kmeaHostelFragment.getPos();
                            Intrinsics.checkNotNull(pos2);
                            textView.setText("01-" + month + HelpFormatter.DEFAULT_OPT_PREFIX + hostel2.get(pos2.intValue()).getYear());
                        }
                        fragmentKmeaBinding2 = kmeaHostelFragment.get_binding();
                        TextView textView2 = fragmentKmeaBinding2 != null ? fragmentKmeaBinding2.kmeaAmountTv : null;
                        if (textView2 != null) {
                            ArrayList<HostelMonth> hostel3 = data.getHostel();
                            Integer pos3 = kmeaHostelFragment.getPos();
                            Intrinsics.checkNotNull(pos3);
                            textView2.setText(String.valueOf(hostel3.get(pos3.intValue()).getAmount()));
                        }
                        fragmentKmeaBinding3 = kmeaHostelFragment.get_binding();
                        TextView textView3 = fragmentKmeaBinding3 != null ? fragmentKmeaBinding3.kmeaFineTv : null;
                        if (textView3 != null) {
                            ArrayList<HostelMonth> hostel4 = data.getHostel();
                            Integer pos4 = kmeaHostelFragment.getPos();
                            Intrinsics.checkNotNull(pos4);
                            textView3.setText(hostel4.get(pos4.intValue()).getFine());
                        }
                        ArrayList<HostelMonth> hostel5 = data.getHostel();
                        Integer pos5 = kmeaHostelFragment.getPos();
                        Intrinsics.checkNotNull(pos5);
                        int amount = hostel5.get(pos5.intValue()).getAmount();
                        ArrayList<HostelMonth> hostel6 = data.getHostel();
                        Integer pos6 = kmeaHostelFragment.getPos();
                        Intrinsics.checkNotNull(pos6);
                        int parseInt = amount + Integer.parseInt(hostel6.get(pos6.intValue()).getFine());
                        fragmentKmeaBinding4 = kmeaHostelFragment.get_binding();
                        TextView textView4 = fragmentKmeaBinding4 != null ? fragmentKmeaBinding4.kmeaTotalTv : null;
                        if (textView4 == null) {
                            return;
                        }
                        textView4.setText(String.valueOf(parseInt));
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void listenUrlResponse() {
        getKmeaHostelViewModel().getUrlResponse().observe(getViewLifecycleOwner(), new KmeaHostelFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelFeeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$listenUrlResponse$1

            /* compiled from: KmeaHostelFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelFeeResponse> resource) {
                invoke2((Resource<HostelFeeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
            
                r0 = r0.listener;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.hostel.HostelFeeResponse> r4) {
                /*
                    r3 = this;
                    in.etuwa.app.utils.Status r0 = r4.getStatus()
                    int[] r1 = in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$listenUrlResponse$1.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 1
                    if (r0 == r1) goto L2b
                    r4 = 2
                    if (r0 == r4) goto L25
                    r4 = 3
                    if (r0 == r4) goto L1f
                    r4 = 4
                    if (r0 == r4) goto L19
                    goto L5c
                L19:
                    in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment r4 = in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment.this
                    r4.hideProgress()
                    goto L5c
                L1f:
                    in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment r4 = in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment.this
                    r4.hideProgress()
                    goto L5c
                L25:
                    in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment r4 = in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment.this
                    r4.showProgress()
                    goto L5c
                L2b:
                    in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment r0 = in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment.this
                    r0.hideProgress()
                    java.lang.Object r4 = r4.getData()
                    in.etuwa.app.data.model.hostel.HostelFeeResponse r4 = (in.etuwa.app.data.model.hostel.HostelFeeResponse) r4
                    if (r4 == 0) goto L5c
                    in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment r0 = in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment.this
                    java.lang.String r1 = r4.getUrl()
                    java.io.PrintStream r2 = java.lang.System.out
                    r2.println(r1)
                    java.lang.String r1 = r4.getUrl()
                    java.lang.String r2 = ""
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                    if (r1 != 0) goto L5c
                    in.etuwa.app.helper.MainCallBackListener r0 = in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment.access$getListener$p(r0)
                    if (r0 == 0) goto L5c
                    java.lang.String r4 = r4.getUrl()
                    r0.openPaymentPage(r4)
                L5c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment$listenUrlResponse$1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }
}