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

/* compiled from: AcadamicFeeNextFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J&\u0010(\u001a\u00020)2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u000105H\u0016J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010<\u001a\u00020)H\u0016J\u001a\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u0002072\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicFeeNextFragment;", "Landroidx/fragment/app/Fragment;", "()V", "date", "", "id", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/academicfee/AcadamicConfBean;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", FirebaseAnalytics.Param.METHOD, "Landroid/widget/TextView;", "getMethod", "()Landroid/widget/TextView;", "setMethod", "(Landroid/widget/TextView;)V", "payNow", "getPayNow", "setPayNow", "pmethod", "recDate", "getRecDate", "setRecDate", "tableLayout", "Landroid/widget/TableLayout;", "getTableLayout", "()Landroid/widget/TableLayout;", "setTableLayout", "(Landroid/widget/TableLayout;)V", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "loadView", "", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcadamicFeeNextFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
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

    /* compiled from: AcadamicFeeNextFragment.kt */
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
        View findViewById = view.findViewById(R.id.tableAcadamicFeeConfirm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tableAcadamicFeeConfirm)");
        setTableLayout((TableLayout) findViewById);
        View findViewById2 = view.findViewById(R.id.acadamicNextdate);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.acadamicNextdate)");
        setRecDate((TextView) findViewById2);
        View findViewById3 = view.findViewById(R.id.acadamicPayNow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.acadamicPayNow)");
        setPayNow((TextView) findViewById3);
        View findViewById4 = view.findViewById(R.id.acadamic_payment_method);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.acadamic_payment_method)");
        setMethod((TextView) findViewById4);
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
                AcadamicFeeNextFragment.onViewCreated$lambda$1(AcadamicFeeNextFragment.this, view2);
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