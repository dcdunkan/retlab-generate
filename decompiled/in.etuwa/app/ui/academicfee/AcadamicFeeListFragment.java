package in.etuwa.app.ui.academicfee;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogKt;
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
import org.koin.core.qualifier.Qualifier;

/* compiled from: AcadamicFeeListFragment.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 U2\u00020\u0001:\u0001UB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J&\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u001a\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020N2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001a\u0010+\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u001a\u00104\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\u001a\u00107\u001a\u000208X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000fR\u001a\u0010@\u001a\u00020AX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\r\"\u0004\bH\u0010\u000f¨\u0006V"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicFeeListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "arrayAdapterMethod", "Landroid/widget/ArrayAdapter;", "", "getArrayAdapterMethod", "()Landroid/widget/ArrayAdapter;", "setArrayAdapterMethod", "(Landroid/widget/ArrayAdapter;)V", "balence", "Landroid/widget/TextView;", "getBalence", "()Landroid/widget/TextView;", "setBalence", "(Landroid/widget/TextView;)V", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "feeAmount", "getFeeAmount", "setFeeAmount", "id", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/academicfee/AcadamicFeeBean;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "methodList", "", "getMethodList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "nextBtn", "getNextBtn", "setNextBtn", "paid", "getPaid", "setPaid", "payMSg", "getPayMSg", "setPayMSg", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "recDate", "getRecDate", "setRecDate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "scholer", "getScholer", "setScholer", "spinnerMethod", "Landroid/widget/Spinner;", "getSpinnerMethod", "()Landroid/widget/Spinner;", "setSpinnerMethod", "(Landroid/widget/Spinner;)V", "totalPayable", "getTotalPayable", "setTotalPayable", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", SvgConstants.Tags.VIEW, "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcadamicFeeListFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public ArrayAdapter<String> arrayAdapterMethod;
    public TextView balence;
    public String date;
    public TextView feeAmount;
    private String id;
    private ArrayList<AcadamicFeeBean> list = new ArrayList<>();
    private final String[] methodList;
    public TextView nextBtn;
    public TextView paid;
    public TextView payMSg;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    public TextView recDate;
    public RecyclerView recyclerView;
    public TextView scholer;
    public Spinner spinnerMethod;
    public TextView totalPayable;

    @JvmStatic
    public static final AcadamicFeeListFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    public AcadamicFeeListFragment() {
        final AcadamicFeeListFragment acadamicFeeListFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.academicfee.AcadamicFeeListFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = acadamicFeeListFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
        this.methodList = new String[]{"FEDPAY(DEBIT/CREDIT/UPI)", "SBIEPAY(NETBANKING)"};
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    public final TextView getFeeAmount() {
        TextView textView = this.feeAmount;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feeAmount");
        return null;
    }

    public final void setFeeAmount(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.feeAmount = textView;
    }

    public final TextView getScholer() {
        TextView textView = this.scholer;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scholer");
        return null;
    }

    public final void setScholer(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.scholer = textView;
    }

    public final TextView getPaid() {
        TextView textView = this.paid;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paid");
        return null;
    }

    public final void setPaid(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.paid = textView;
    }

    public final TextView getBalence() {
        TextView textView = this.balence;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("balence");
        return null;
    }

    public final void setBalence(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.balence = textView;
    }

    public final TextView getTotalPayable() {
        TextView textView = this.totalPayable;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("totalPayable");
        return null;
    }

    public final void setTotalPayable(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.totalPayable = textView;
    }

    public final TextView getRecDate() {
        TextView textView = this.recDate;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recDate");
        return null;
    }

    public final void setRecDate(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.recDate = textView;
    }

    public final TextView getPayMSg() {
        TextView textView = this.payMSg;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payMSg");
        return null;
    }

    public final void setPayMSg(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.payMSg = textView;
    }

    public final TextView getNextBtn() {
        TextView textView = this.nextBtn;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
        return null;
    }

    public final void setNextBtn(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nextBtn = textView;
    }

    public final ArrayList<AcadamicFeeBean> getList() {
        return this.list;
    }

    public final void setList(ArrayList<AcadamicFeeBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final String getDate() {
        String str = this.date;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("date");
        return null;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final Spinner getSpinnerMethod() {
        Spinner spinner = this.spinnerMethod;
        if (spinner != null) {
            return spinner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spinnerMethod");
        return null;
    }

    public final void setSpinnerMethod(Spinner spinner) {
        Intrinsics.checkNotNullParameter(spinner, "<set-?>");
        this.spinnerMethod = spinner;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final ArrayAdapter<String> getArrayAdapterMethod() {
        ArrayAdapter<String> arrayAdapter = this.arrayAdapterMethod;
        if (arrayAdapter != null) {
            return arrayAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("arrayAdapterMethod");
        return null;
    }

    public final void setArrayAdapterMethod(ArrayAdapter<String> arrayAdapter) {
        Intrinsics.checkNotNullParameter(arrayAdapter, "<set-?>");
        this.arrayAdapterMethod = arrayAdapter;
    }

    public final String[] getMethodList() {
        return this.methodList;
    }

    /* compiled from: AcadamicFeeListFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicFeeListFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/academicfee/AcadamicFeeListFragment;", CommentReplyDialogKt.ARG_IMG, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AcadamicFeeListFragment newInstance(String param1) {
            Intrinsics.checkNotNullParameter(param1, "param1");
            AcadamicFeeListFragment acadamicFeeListFragment = new AcadamicFeeListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CommentReplyDialogKt.ARG_IMG, param1);
            acadamicFeeListFragment.setArguments(bundle);
            return acadamicFeeListFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString(CommentReplyDialogKt.ARG_IMG);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_acadamic_fee_list, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.recyc_payment);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recyc_payment)");
        setRecyclerView((RecyclerView) findViewById);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        View findViewById2 = view.findViewById(R.id.acadamicPayTotAmount);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.acadamicPayTotAmount)");
        setFeeAmount((TextView) findViewById2);
        View findViewById3 = view.findViewById(R.id.acadamicPayTotSchol);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.acadamicPayTotSchol)");
        setScholer((TextView) findViewById3);
        View findViewById4 = view.findViewById(R.id.acadamicPayTotPaid);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.acadamicPayTotPaid)");
        setPaid((TextView) findViewById4);
        View findViewById5 = view.findViewById(R.id.acadamicPayTotBal);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.acadamicPayTotBal)");
        setBalence((TextView) findViewById5);
        View findViewById6 = view.findViewById(R.id.acadamicPayTotPayebl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.acadamicPayTotPayebl)");
        setTotalPayable((TextView) findViewById6);
        View findViewById7 = view.findViewById(R.id.acadamicReciptDate);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.acadamicReciptDate)");
        setRecDate((TextView) findViewById7);
        View findViewById8 = view.findViewById(R.id.acadamicPayMsg);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.acadamicPayMsg)");
        setPayMSg((TextView) findViewById8);
        View findViewById9 = view.findViewById(R.id.acadamicPayNext);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.acadamicPayNext)");
        setNextBtn((TextView) findViewById9);
        getPreference().setNewLogin(false);
        View findViewById10 = view.findViewById(R.id.spinner_fee_method);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.spinner_fee_method)");
        setSpinnerMethod((Spinner) findViewById10);
        setArrayAdapterMethod(new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, this.methodList));
        getArrayAdapterMethod().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getSpinnerMethod().setAdapter((SpinnerAdapter) getArrayAdapterMethod());
    }
}