package in.etuwa.app.ui.academicfee;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* JADX INFO: compiled from: FeeRecepitDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeeRecepitDialog extends DialogFragment {

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public FeeRecepitDialog() {
        final FeeRecepitDialog feeRecepitDialog = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.academicfee.FeeRecepitDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeRecepitDialog;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.fee_recepit_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.reciept_fee_re_no);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.reciept_fee_amount);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.reciept_fee_batch);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.reciept_fee_date);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.reciept_fee_method);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.reciept_fee_status);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.viewNoData);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.reciept_fee_layout);
        textView7.setVisibility(4);
        getPreference().setNewLogin(false);
        Bundle arguments = getArguments();
        Intrinsics.checkNotNull(arguments);
        if (arguments.size() == 0) {
            textView7.setVisibility(0);
            linearLayout.setVisibility(4);
        } else {
            textView.setText(arguments.getString("receipt_no"));
            textView2.setText(arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT));
            textView3.setText(arguments.getString("batch"));
            textView4.setText(arguments.getString("date"));
            textView5.setText(arguments.getString(FirebaseAnalytics.Param.METHOD));
            textView6.setText(arguments.getString(NotificationCompat.CATEGORY_STATUS));
        }
        builder.setNegativeButton("close", (DialogInterface.OnClickListener) null);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "builder.create()");
        return alertDialogCreate;
    }
}