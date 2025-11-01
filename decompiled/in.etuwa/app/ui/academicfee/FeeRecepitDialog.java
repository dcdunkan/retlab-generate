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

/* compiled from: FeeRecepitDialog.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/academicfee/FeeRecepitDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeRecepitDialog extends DialogFragment {

    /* renamed from: preference$delegate, reason: from kotlin metadata */
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
        View inflate = LayoutInflater.from(requireContext()).inflate(R.layout.fee_recepit_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.reciept_fee_re_no);
        TextView textView2 = (TextView) inflate.findViewById(R.id.reciept_fee_amount);
        TextView textView3 = (TextView) inflate.findViewById(R.id.reciept_fee_batch);
        TextView textView4 = (TextView) inflate.findViewById(R.id.reciept_fee_date);
        TextView textView5 = (TextView) inflate.findViewById(R.id.reciept_fee_method);
        TextView textView6 = (TextView) inflate.findViewById(R.id.reciept_fee_status);
        TextView textView7 = (TextView) inflate.findViewById(R.id.viewNoData);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.reciept_fee_layout);
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
        builder.setView(inflate);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        return create;
    }
}