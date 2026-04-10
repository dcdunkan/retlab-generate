package in.etuwa.app.ui.academicfee;

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
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AcadamicFeeNextFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AcadamicFeeNextFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String date;
    private String id;
    private ArrayList<AcadamicConfBean> list = new ArrayList<>();
    private MainCallBackListener listener;
    public TextView method;
    public TextView payNow;
    private String pmethod;
    public TextView recDate;
    public TableLayout tableLayout;
    public String url;

    private final void loadView(String id, String date, String pmethod) {
    }

    @JvmStatic
    public static final AcadamicFeeNextFragment newInstance(String str, String str2, String str3) {
        return INSTANCE.newInstance(str, str2, str3);
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

    public final ArrayList<AcadamicConfBean> getList() {
        return this.list;
    }

    public final void setList(ArrayList<AcadamicConfBean> arrayList) {
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

    /* JADX INFO: compiled from: AcadamicFeeNextFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicFeeNextFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/academicfee/AcadamicFeeNextFragment;", "id", "", "date", FirebaseAnalytics.Param.METHOD, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AcadamicFeeNextFragment newInstance(String id, String date, String method) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(method, "method");
            AcadamicFeeNextFragment acadamicFeeNextFragment = new AcadamicFeeNextFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CommentReplyDialogKt.ARG_IMG, id);
            bundle.putString(CommentReplyDialogKt.ARG_NAME, date);
            bundle.putString(CommentReplyDialogKt.ARG_COMMENT, method);
            acadamicFeeNextFragment.setArguments(bundle);
            return acadamicFeeNextFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString(CommentReplyDialogKt.ARG_IMG);
            this.date = arguments.getString(CommentReplyDialogKt.ARG_NAME);
            this.pmethod = arguments.getString(CommentReplyDialogKt.ARG_COMMENT);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_acadamic_fee_next, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.tableAcadamicFeeConfirm);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.tableAcadamicFeeConfirm)");
        setTableLayout((TableLayout) viewFindViewById);
        View viewFindViewById2 = view.findViewById(R.id.acadamicNextdate);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.acadamicNextdate)");
        setRecDate((TextView) viewFindViewById2);
        View viewFindViewById3 = view.findViewById(R.id.acadamicPayNow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.acadamicPayNow)");
        setPayNow((TextView) viewFindViewById3);
        View viewFindViewById4 = view.findViewById(R.id.acadamic_payment_method);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.acadamic_payment_method)");
        setMethod((TextView) viewFindViewById4);
        Bundle arguments = getArguments();
        Intrinsics.checkNotNull(arguments);
        String string = arguments.getString("id");
        if (string == null) {
            string = "";
        }
        this.id = string;
        String string2 = arguments.getString(FirebaseAnalytics.Param.METHOD);
        if (Intrinsics.areEqual(string2, ExifInterface.GPS_MEASUREMENT_2D)) {
            getMethod().setText("FEDPAY(DEBIT/CREDIT/UPI)");
        } else if (Intrinsics.areEqual(string2, ExifInterface.GPS_MEASUREMENT_3D)) {
            getMethod().setText("SBIEPAY(NETBANKING)");
        }
        loadView(this.id, this.date, this.pmethod);
        getPayNow().setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.academicfee.AcadamicFeeNextFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcadamicFeeNextFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(AcadamicFeeNextFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) AcadamicPaymentActivity.class);
            intent.putExtra("url", this$0.getUrl());
            this$0.startActivityForResult(intent, 1);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.loadAcademicPay(this.id);
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