package in.etuwa.app.ui.hostel.fee;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* compiled from: HostelFeeFragment.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010a\u001a\u00020b2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\u00052\u0006\u0010c\u001a\u00020dH\u0002J&\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J\u001a\u0010m\u001a\u00020b2\u0006\u0010n\u001a\u00020f2\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J \u0010o\u001a\u00020b2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\u000e2\u0006\u0010p\u001a\u00020dH\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR\u0019\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0019\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b6\u0010.R\u001a\u00107\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R\u001a\u0010:\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@R\u001a\u0010C\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R\u001a\u0010F\u001a\u00020GX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020MX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR\u001a\u0010U\u001a\u00020MX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010O\"\u0004\bW\u0010QR\u001a\u0010X\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0014\"\u0004\bZ\u0010\u0016R\u001a\u0010[\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00102\"\u0004\b]\u00104R*\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\u000e0!j\b\u0012\u0004\u0012\u00020\u000e`#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010%\"\u0004\b`\u0010'¨\u0006q"}, d2 = {"Lin/etuwa/app/ui/hostel/fee/HostelFeeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "arrayAdapterMethod", "Landroid/widget/ArrayAdapter;", "", "getArrayAdapterMethod", "()Landroid/widget/ArrayAdapter;", "setArrayAdapterMethod", "(Landroid/widget/ArrayAdapter;)V", "arrayAdapterMonth", "getArrayAdapterMonth", "setArrayAdapterMonth", "arrayAdapterYear", "", "getArrayAdapterYear", "setArrayAdapterYear", "feeAmount", "Landroid/widget/TextView;", "getFeeAmount", "()Landroid/widget/TextView;", "setFeeAmount", "(Landroid/widget/TextView;)V", "fineAmount", "getFineAmount", "setFineAmount", "layoutPayable", "Landroid/widget/LinearLayout;", "getLayoutPayable", "()Landroid/widget/LinearLayout;", "setLayoutPayable", "(Landroid/widget/LinearLayout;)V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/hostel/fee/HostelFeeBean;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "methodLayout", "getMethodLayout", "setMethodLayout", "methodList", "", "getMethodList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "month", "getMonth", "()I", "setMonth", "(I)V", "monthList", "getMonthList", "nextBtn", "getNextBtn", "setNextBtn", "payMSg", "getPayMSg", "setPayMSg", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "recDate", "getRecDate", "setRecDate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "spinnerMethod", "Landroid/widget/Spinner;", "getSpinnerMethod", "()Landroid/widget/Spinner;", "setSpinnerMethod", "(Landroid/widget/Spinner;)V", "spinnerMonth", "getSpinnerMonth", "setSpinnerMonth", "spinnerYear", "getSpinnerYear", "setSpinnerYear", "totalPayable", "getTotalPayable", "setTotalPayable", "year", "getYear", "setYear", "yearList", "getYearList", "setYearList", "loadView", "", "flag", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", SvgConstants.Tags.VIEW, "setSpinner", "mnthflag", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelFeeFragment extends Fragment {
    public ArrayAdapter<String> arrayAdapterMethod;
    public ArrayAdapter<String> arrayAdapterMonth;
    public ArrayAdapter<Integer> arrayAdapterYear;
    public TextView feeAmount;
    public TextView fineAmount;
    public LinearLayout layoutPayable;
    public LinearLayout methodLayout;
    public TextView nextBtn;
    public TextView payMSg;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    public TextView recDate;
    public RecyclerView recyclerView;
    public Spinner spinnerMethod;
    public Spinner spinnerMonth;
    public Spinner spinnerYear;
    public TextView totalPayable;
    private ArrayList<Integer> yearList = new ArrayList<>();
    private ArrayList<HostelFeeBean> list = new ArrayList<>();
    private int month = -1;
    private int year = -1;
    private final String[] methodList = {"FEDPAY(DEBIT/CREDIT/UPI)", "SBIEPAY(NETBANKING)"};
    private final String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public HostelFeeFragment() {
        final HostelFeeFragment hostelFeeFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostel.fee.HostelFeeFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = hostelFeeFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
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

    public final Spinner getSpinnerMonth() {
        Spinner spinner = this.spinnerMonth;
        if (spinner != null) {
            return spinner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spinnerMonth");
        return null;
    }

    public final void setSpinnerMonth(Spinner spinner) {
        Intrinsics.checkNotNullParameter(spinner, "<set-?>");
        this.spinnerMonth = spinner;
    }

    public final Spinner getSpinnerYear() {
        Spinner spinner = this.spinnerYear;
        if (spinner != null) {
            return spinner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spinnerYear");
        return null;
    }

    public final void setSpinnerYear(Spinner spinner) {
        Intrinsics.checkNotNullParameter(spinner, "<set-?>");
        this.spinnerYear = spinner;
    }

    public final ArrayAdapter<String> getArrayAdapterMonth() {
        ArrayAdapter<String> arrayAdapter = this.arrayAdapterMonth;
        if (arrayAdapter != null) {
            return arrayAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("arrayAdapterMonth");
        return null;
    }

    public final void setArrayAdapterMonth(ArrayAdapter<String> arrayAdapter) {
        Intrinsics.checkNotNullParameter(arrayAdapter, "<set-?>");
        this.arrayAdapterMonth = arrayAdapter;
    }

    public final ArrayAdapter<Integer> getArrayAdapterYear() {
        ArrayAdapter<Integer> arrayAdapter = this.arrayAdapterYear;
        if (arrayAdapter != null) {
            return arrayAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("arrayAdapterYear");
        return null;
    }

    public final void setArrayAdapterYear(ArrayAdapter<Integer> arrayAdapter) {
        Intrinsics.checkNotNullParameter(arrayAdapter, "<set-?>");
        this.arrayAdapterYear = arrayAdapter;
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

    public final TextView getFineAmount() {
        TextView textView = this.fineAmount;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fineAmount");
        return null;
    }

    public final void setFineAmount(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.fineAmount = textView;
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

    public final LinearLayout getLayoutPayable() {
        LinearLayout linearLayout = this.layoutPayable;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutPayable");
        return null;
    }

    public final void setLayoutPayable(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.layoutPayable = linearLayout;
    }

    public final ArrayList<Integer> getYearList() {
        return this.yearList;
    }

    public final void setYearList(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.yearList = arrayList;
    }

    public final ArrayList<HostelFeeBean> getList() {
        return this.list;
    }

    public final void setList(ArrayList<HostelFeeBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final int getMonth() {
        return this.month;
    }

    public final void setMonth(int i) {
        this.month = i;
    }

    public final int getYear() {
        return this.year;
    }

    public final void setYear(int i) {
        this.year = i;
    }

    public final LinearLayout getMethodLayout() {
        LinearLayout linearLayout = this.methodLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("methodLayout");
        return null;
    }

    public final void setMethodLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.methodLayout = linearLayout;
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

    public final String[] getMonthList() {
        return this.monthList;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.hostel_fee_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.recyc_HostelFee);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recyc_HostelFee)");
        setRecyclerView((RecyclerView) findViewById);
        View findViewById2 = view.findViewById(R.id.spinnerHostelFeeMonth);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.spinnerHostelFeeMonth)");
        setSpinnerMonth((Spinner) findViewById2);
        View findViewById3 = view.findViewById(R.id.spinnerHostelFeeYear);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.spinnerHostelFeeYear)");
        setSpinnerYear((Spinner) findViewById3);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        TextView textView = (TextView) view.findViewById(R.id.hFeeSearchBtn);
        View findViewById4 = view.findViewById(R.id.layoutPayable);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.layoutPayable)");
        setLayoutPayable((LinearLayout) findViewById4);
        View findViewById5 = view.findViewById(R.id.hostFeeAmount);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.hostFeeAmount)");
        setFeeAmount((TextView) findViewById5);
        View findViewById6 = view.findViewById(R.id.hostFeeFine);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.hostFeeFine)");
        setFineAmount((TextView) findViewById6);
        View findViewById7 = view.findViewById(R.id.hostTotPayebl);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.hostTotPayebl)");
        setTotalPayable((TextView) findViewById7);
        View findViewById8 = view.findViewById(R.id.hostReciptDate);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.hostReciptDate)");
        setRecDate((TextView) findViewById8);
        View findViewById9 = view.findViewById(R.id.hostPayMsg);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.hostPayMsg)");
        setPayMSg((TextView) findViewById9);
        View findViewById10 = view.findViewById(R.id.hostPayNext);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.hostPayNext)");
        setNextBtn((TextView) findViewById10);
        View findViewById11 = view.findViewById(R.id.method_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.method_layout)");
        setMethodLayout((LinearLayout) findViewById11);
        getMethodLayout().setVisibility(8);
        View findViewById12 = view.findViewById(R.id.spinner_hostel_fee_method);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.spinner_hostel_fee_method)");
        setSpinnerMethod((Spinner) findViewById12);
        getPreference().setNewLogin(false);
        Calendar calendar = Calendar.getInstance();
        this.year = calendar.get(1);
        this.month = calendar.get(2);
        this.list.clear();
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                getSpinnerMonth().setAdapter((SpinnerAdapter) null);
                getSpinnerYear().setAdapter((SpinnerAdapter) null);
                String string = arguments.getString("month");
                Intrinsics.checkNotNull(string);
                int parseInt = Integer.parseInt(string);
                String string2 = arguments.getString("year");
                Intrinsics.checkNotNull(string2);
                loadView(parseInt, string2, true);
                String string3 = arguments.getString("month");
                Intrinsics.checkNotNull(string3);
                setSpinner(Integer.parseInt(string3), this.year, true);
            } catch (Exception unused) {
            }
        } else {
            setSpinner(this.month, this.year, false);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.fee.HostelFeeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HostelFeeFragment.onViewCreated$lambda$0(HostelFeeFragment.this, view2);
            }
        });
        getNextBtn().setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.fee.HostelFeeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HostelFeeFragment.onViewCreated$lambda$1(HostelFeeFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(HostelFeeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadView(this$0.getSpinnerMonth().getSelectedItemPosition() + 1, String.valueOf(this$0.getSpinnerYear().getSelectedItem()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(HostelFeeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager fragmentManager = this$0.getFragmentManager();
        Intrinsics.checkNotNull(fragmentManager);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager!!.beginTransaction()");
        beginTransaction.addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putString("month", String.valueOf(this$0.getSpinnerMonth().getSelectedItemPosition() + 1));
        bundle.putString("year", String.valueOf(this$0.getSpinnerYear().getSelectedItem()));
        bundle.putString(FirebaseAnalytics.Param.METHOD, String.valueOf(this$0.getSpinnerMethod().getSelectedItemPosition() + 2));
        HostelNextFragment hostelNextFragment = new HostelNextFragment();
        hostelNextFragment.setArguments(bundle);
        beginTransaction.replace(R.id.main_container, hostelNextFragment);
        beginTransaction.commit();
        this$0.getSpinnerMonth().setAdapter((SpinnerAdapter) null);
        this$0.getSpinnerYear().setAdapter((SpinnerAdapter) null);
    }

    private final void loadView(int month, String year, boolean flag) {
        getLayoutPayable().setVisibility(8);
        getNextBtn().setVisibility(8);
        getMethodLayout().setVisibility(8);
    }

    private final void setSpinner(int month, int year, boolean mnthflag) {
        this.yearList.clear();
        try {
            int parseInt = Integer.parseInt(getPreference().getAcademicYear());
            if (parseInt <= year) {
                int i = 0;
                while (i < 6) {
                    this.yearList.add(Integer.valueOf(parseInt));
                    i++;
                    if (parseInt == year) {
                        break;
                    } else {
                        parseInt++;
                    }
                }
            }
            setArrayAdapterYear(new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, this.yearList));
            getArrayAdapterYear().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getSpinnerYear().setAdapter((SpinnerAdapter) getArrayAdapterYear());
            getSpinnerYear().setSelection(this.yearList.size() - 1);
            setArrayAdapterMonth(new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, this.monthList));
            getArrayAdapterMonth().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getSpinnerMonth().setAdapter((SpinnerAdapter) getArrayAdapterMonth());
            setArrayAdapterMethod(new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, this.methodList));
            getArrayAdapterMethod().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getSpinnerMethod().setAdapter((SpinnerAdapter) getArrayAdapterMethod());
            if (mnthflag) {
                loadView(month, String.valueOf(year), false);
                getSpinnerMonth().setSelection(month - 1);
            } else {
                loadView(month + 1, String.valueOf(year), false);
                getSpinnerMonth().setSelection(month);
            }
        } catch (Exception unused) {
        }
    }
}