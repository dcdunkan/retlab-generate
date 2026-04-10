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