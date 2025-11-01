package in.etuwa.app.ui.leave.duty.fullday;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullDayDialog.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010 \u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lin/etuwa/app/ui/leave/duty/fullday/FullDayDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", FullDayDialogKt.ARG_BTN, "", "id", "", "layoutAply", "Landroid/widget/LinearLayout;", "layoutAprov", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/leave/duty/fullday/DutyStatusBeanFull;", "Lkotlin/collections/ArrayList;", "tableLayout", "Landroid/widget/TableLayout;", "applyStatus", "", "date", "textView", "Landroid/widget/TextView;", "i", "", "cancelStatus", "hideProgress", "loadApply", "loadAprove", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FullDayDialog extends DialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean btn;
    private String id;
    private LinearLayout layoutAply;
    private LinearLayout layoutAprov;
    private final ArrayList<DutyStatusBeanFull> list = new ArrayList<>();
    private TableLayout tableLayout;

    private final void applyStatus(String date, TextView textView, int i) {
    }

    private final void cancelStatus(String date, TextView textView, int i) {
    }

    private final void loadApply() {
    }

    private final void loadAprove() {
    }

    public final void hideProgress() {
    }

    public final void showProgress() {
    }

    /* compiled from: FullDayDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/leave/duty/fullday/FullDayDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/fullday/FullDayDialog;", "id", "", FullDayDialogKt.ARG_BTN, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FullDayDialog newInstance(String id, boolean btn) {
            Intrinsics.checkNotNullParameter(id, "id");
            FullDayDialog fullDayDialog = new FullDayDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean(FullDayDialogKt.ARG_BTN, btn);
            fullDayDialog.setArguments(bundle);
            return fullDayDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.btn = arguments.getBoolean(FullDayDialogKt.ARG_BTN);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LinearLayout linearLayout = null;
        View inflate = LayoutInflater.from(requireContext()).inflate(R.layout.full_day_dialog, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tableDutyFull);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tableDutyFull)");
        this.tableLayout = (TableLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.duty_header_apply);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.duty_header_apply)");
        this.layoutAply = (LinearLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.duty_header_aprov);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.duty_header_aprov)");
        this.layoutAprov = (LinearLayout) findViewById3;
        if (this.btn) {
            builder.setTitle("Choose Day");
            LinearLayout linearLayout2 = this.layoutAprov;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutAprov");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            loadApply();
        } else {
            builder.setTitle("Leave Status");
            LinearLayout linearLayout3 = this.layoutAply;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutAply");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(8);
            loadAprove();
        }
        builder.setView(inflate);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        return create;
    }
}