package in.etuwa.app.ui.hostel.fee;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.helper.MainCallBackListener;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* JADX INFO: compiled from: HostelNextFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelNextFragment extends Fragment {
    private ArrayList<HostelConfBean> list = new ArrayList<>();
    private MainCallBackListener listener;
    public TextView method;
    public String month;
    public TextView payNow;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    public TextView recDate;
    public TableLayout tableLayout;
    public String url;
    public String year;

    private final void loadView(String month, String year, String meth) {
    }

    public HostelNextFragment() {
        final HostelNextFragment hostelNextFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostel.fee.HostelNextFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = hostelNextFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
    }

    public final TableLayout getTableLayout() {
        TableLayout tableLayout = this.tableLayout;
        if (tableLayout != null) {
            return tableLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tableLayout");
        return null;
    }

    public final void setTableLayout(TableLayout tableLayout) {
        Intrinsics.checkNotNullParameter(tableLayout, "<set-?>");
        this.tableLayout = tableLayout;
    }

    public final TextView getPayNow() {
        TextView textView = this.payNow;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payNow");
        return null;
    }

    public final void setPayNow(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.payNow = textView;
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

    public final ArrayList<HostelConfBean> getList() {
        return this.list;
    }

    public final void setList(ArrayList<HostelConfBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final String getUrl() {
        String str = this.url;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("url");
        return null;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getMonth() {
        String str = this.month;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("month");
        return null;
    }

    public final void setMonth(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.month = str;
    }

    public final String getYear() {
        String str = this.year;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("year");
        return null;
    }

    public final void setYear(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.year = str;
    }

    public final TextView getMethod() {
        TextView textView = this.method;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException(FirebaseAnalytics.Param.METHOD);
        return null;
    }

    public final void setMethod(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.method = textView;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_hostel_next, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        try {
            View viewFindViewById = view.findViewById(R.id.tableLayoutFeeConfirm);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.tableLayoutFeeConfirm)");
            setTableLayout((TableLayout) viewFindViewById);
            View viewFindViewById2 = view.findViewById(R.id.hostelPayNextdate);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.hostelPayNextdate)");
            setRecDate((TextView) viewFindViewById2);
            View viewFindViewById3 = view.findViewById(R.id.hostelPayNow);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.hostelPayNow)");
            setPayNow((TextView) viewFindViewById3);
            View viewFindViewById4 = view.findViewById(R.id.hostel_payment_method);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.hostel_payment_method)");
            setMethod((TextView) viewFindViewById4);
            Bundle arguments = getArguments();
            String string = arguments != null ? arguments.getString("month") : null;
            Intrinsics.checkNotNull(string);
            setMonth(string);
            String string2 = arguments.getString("year");
            Intrinsics.checkNotNull(string2);
            setYear(string2);
            String string3 = arguments.getString(FirebaseAnalytics.Param.METHOD);
            if (Intrinsics.areEqual(string3, ExifInterface.GPS_MEASUREMENT_2D)) {
                getMethod().setText("FEDPAY(DEBIT/CREDIT/UPI)");
            } else if (Intrinsics.areEqual(string3, ExifInterface.GPS_MEASUREMENT_3D)) {
                getMethod().setText("SBIEPAY(NETBANKING)");
            }
            if (getPreference().getClgId() == 6) {
                getMethod().setVisibility(8);
            }
            String month = getMonth();
            String year = getYear();
            Intrinsics.checkNotNull(string3);
            loadView(month, year, string3);
            getPayNow().setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.fee.HostelNextFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HostelNextFragment.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(HostelNextFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) HostelPaymentActivity.class);
            intent.putExtra("url", this$0.getUrl());
            this$0.startActivityForResult(intent, 2);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            MainCallBackListener mainCallBackListener = this.listener;
            if (mainCallBackListener != null) {
                mainCallBackListener.loadHostelPay(getMonth(), getYear());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }
}