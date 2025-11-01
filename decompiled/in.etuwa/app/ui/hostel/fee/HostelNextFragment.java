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

/* compiled from: HostelNextFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u00101\u001a\u0002022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0002J\"\u00104\u001a\u0002022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020<H\u0016J&\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u000202H\u0016J\u001a\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020>2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010.\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018¨\u0006H"}, d2 = {"Lin/etuwa/app/ui/hostel/fee/HostelNextFragment;", "Landroidx/fragment/app/Fragment;", "()V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/hostel/fee/HostelConfBean;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", FirebaseAnalytics.Param.METHOD, "Landroid/widget/TextView;", "getMethod", "()Landroid/widget/TextView;", "setMethod", "(Landroid/widget/TextView;)V", "month", "", "getMonth", "()Ljava/lang/String;", "setMonth", "(Ljava/lang/String;)V", "payNow", "getPayNow", "setPayNow", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "recDate", "getRecDate", "setRecDate", "tableLayout", "Landroid/widget/TableLayout;", "getTableLayout", "()Landroid/widget/TableLayout;", "setTableLayout", "(Landroid/widget/TableLayout;)V", "url", "getUrl", "setUrl", "year", "getYear", "setYear", "loadView", "", "meth", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelNextFragment extends Fragment {
    private ArrayList<HostelConfBean> list = new ArrayList<>();
    private MainCallBackListener listener;
    public TextView method;
    public String month;
    public TextView payNow;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
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
            View findViewById = view.findViewById(R.id.tableLayoutFeeConfirm);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tableLayoutFeeConfirm)");
            setTableLayout((TableLayout) findViewById);
            View findViewById2 = view.findViewById(R.id.hostelPayNextdate);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.hostelPayNextdate)");
            setRecDate((TextView) findViewById2);
            View findViewById3 = view.findViewById(R.id.hostelPayNow);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.hostelPayNow)");
            setPayNow((TextView) findViewById3);
            View findViewById4 = view.findViewById(R.id.hostel_payment_method);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.hostel_payment_method)");
            setMethod((TextView) findViewById4);
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
                    HostelNextFragment.onViewCreated$lambda$0(HostelNextFragment.this, view2);
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