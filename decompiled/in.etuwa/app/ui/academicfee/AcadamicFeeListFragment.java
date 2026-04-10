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

/* JADX INFO: compiled from: AcadamicFeeListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AcadamicFeeListFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
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

    /* JADX INFO: compiled from: AcadamicFeeListFragment.kt */
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
        View viewFindViewById = view.findViewById(R.id.recyc_payment);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.recyc_payment)");
        setRecyclerView((RecyclerView) viewFindViewById);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        View viewFindViewById2 = view.findViewById(R.id.acadamicPayTotAmount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.acadamicPayTotAmount)");
        setFeeAmount((TextView) viewFindViewById2);
        View viewFindViewById3 = view.findViewById(R.id.acadamicPayTotSchol);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.acadamicPayTotSchol)");
        setScholer((TextView) viewFindViewById3);
        View viewFindViewById4 = view.findViewById(R.id.acadamicPayTotPaid);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.acadamicPayTotPaid)");
        setPaid((TextView) viewFindViewById4);
        View viewFindViewById5 = view.findViewById(R.id.acadamicPayTotBal);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "view.findViewById(R.id.acadamicPayTotBal)");
        setBalence((TextView) viewFindViewById5);
        View viewFindViewById6 = view.findViewById(R.id.acadamicPayTotPayebl);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "view.findViewById(R.id.acadamicPayTotPayebl)");
        setTotalPayable((TextView) viewFindViewById6);
        View viewFindViewById7 = view.findViewById(R.id.acadamicReciptDate);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "view.findViewById(R.id.acadamicReciptDate)");
        setRecDate((TextView) viewFindViewById7);
        View viewFindViewById8 = view.findViewById(R.id.acadamicPayMsg);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "view.findViewById(R.id.acadamicPayMsg)");
        setPayMSg((TextView) viewFindViewById8);
        View viewFindViewById9 = view.findViewById(R.id.acadamicPayNext);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "view.findViewById(R.id.acadamicPayNext)");
        setNextBtn((TextView) viewFindViewById9);
        getPreference().setNewLogin(false);
        View viewFindViewById10 = view.findViewById(R.id.spinner_fee_method);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "view.findViewById(R.id.spinner_fee_method)");
        setSpinnerMethod((Spinner) viewFindViewById10);
        setArrayAdapterMethod(new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, this.methodList));
        getArrayAdapterMethod().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getSpinnerMethod().setAdapter((SpinnerAdapter) getArrayAdapterMethod());
    }
}