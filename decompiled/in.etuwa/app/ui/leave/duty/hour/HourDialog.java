package in.etuwa.app.ui.leave.duty.hour;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HourDialog.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 K2\u00020\u0001:\u0001KB\u0005¢\u0006\u0002\u0010\u0002J(\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J(\u0010@\u001a\u0002092\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0006\u0010A\u001a\u000209J\u0012\u0010B\u001a\u0002092\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010C\u001a\u0002092\u0006\u0010:\u001a\u00020\u000eH\u0002J\u0010\u0010D\u001a\u0002092\u0006\u0010:\u001a\u00020\u000eH\u0002J\u0012\u0010E\u001a\u0002092\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u00020I2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0006\u0010J\u001a\u000209R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0016j\b\u0012\u0004\u0012\u00020\u000e`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u0016j\b\u0012\u0004\u0012\u00020)`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006L"}, d2 = {"Lin/etuwa/app/ui/leave/duty/hour/HourDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "applyLayout", "Landroid/widget/LinearLayout;", "getApplyLayout", "()Landroid/widget/LinearLayout;", "setApplyLayout", "(Landroid/widget/LinearLayout;)V", "aproveLayout", "getAproveLayout", "setAproveLayout", "arrayAdapter", "Landroid/widget/ArrayAdapter;", "", "getArrayAdapter", "()Landroid/widget/ArrayAdapter;", "setArrayAdapter", "(Landroid/widget/ArrayAdapter;)V", FullDayDialogKt.ARG_BTN, "", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDateList", "()Ljava/util/ArrayList;", "setDateList", "(Ljava/util/ArrayList;)V", "dialogView", "Landroid/view/View;", "getDialogView", "()Landroid/view/View;", "setDialogView", "(Landroid/view/View;)V", "flag", "getFlag", "()Z", "setFlag", "(Z)V", "id", "list", "Lin/etuwa/app/ui/leave/duty/hour/DutyStatusBeanHour;", "getList", "setList", "spinner", "Landroid/widget/Spinner;", "getSpinner", "()Landroid/widget/Spinner;", "setSpinner", "(Landroid/widget/Spinner;)V", "tableLayout", "Landroid/widget/TableLayout;", "getTableLayout", "()Landroid/widget/TableLayout;", "setTableLayout", "(Landroid/widget/TableLayout;)V", "applyStatus", "", "date", "hour", "textView", "Landroid/widget/TextView;", "i", "", "cancelStatus", "hideProgress", "loadSpinner", "loadViewAply", "loadViewAprov", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HourDialog extends DialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public LinearLayout applyLayout;
    public LinearLayout aproveLayout;
    public ArrayAdapter<String> arrayAdapter;
    private boolean btn;
    public View dialogView;
    private boolean flag;
    private String id;
    public Spinner spinner;
    public TableLayout tableLayout;
    private ArrayList<String> dateList = new ArrayList<>();
    private ArrayList<DutyStatusBeanHour> list = new ArrayList<>();

    private final void applyStatus(String date, String hour, TextView textView, int i) {
    }

    private final void cancelStatus(String date, String hour, TextView textView, int i) {
    }

    private final void loadSpinner(String id) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadViewAprov(String date) {
    }

    public final void hideProgress() {
    }

    public final void showProgress() {
    }

    public final Spinner getSpinner() {
        Spinner spinner = this.spinner;
        if (spinner != null) {
            return spinner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spinner");
        return null;
    }

    public final void setSpinner(Spinner spinner) {
        Intrinsics.checkNotNullParameter(spinner, "<set-?>");
        this.spinner = spinner;
    }

    public final ArrayAdapter<String> getArrayAdapter() {
        ArrayAdapter<String> arrayAdapter = this.arrayAdapter;
        if (arrayAdapter != null) {
            return arrayAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("arrayAdapter");
        return null;
    }

    public final void setArrayAdapter(ArrayAdapter<String> arrayAdapter) {
        Intrinsics.checkNotNullParameter(arrayAdapter, "<set-?>");
        this.arrayAdapter = arrayAdapter;
    }

    public final ArrayList<String> getDateList() {
        return this.dateList;
    }

    public final void setDateList(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.dateList = arrayList;
    }

    public final View getDialogView() {
        View view = this.dialogView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogView");
        return null;
    }

    public final void setDialogView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.dialogView = view;
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

    public final LinearLayout getApplyLayout() {
        LinearLayout linearLayout = this.applyLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applyLayout");
        return null;
    }

    public final void setApplyLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.applyLayout = linearLayout;
    }

    public final LinearLayout getAproveLayout() {
        LinearLayout linearLayout = this.aproveLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aproveLayout");
        return null;
    }

    public final void setAproveLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.aproveLayout = linearLayout;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    public final ArrayList<DutyStatusBeanHour> getList() {
        return this.list;
    }

    public final void setList(ArrayList<DutyStatusBeanHour> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    /* compiled from: HourDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/leave/duty/hour/HourDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/hour/HourDialog;", "id", "", FullDayDialogKt.ARG_BTN, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HourDialog newInstance(String id, boolean btn) {
            Intrinsics.checkNotNullParameter(id, "id");
            HourDialog hourDialog = new HourDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean(FullDayDialogKt.ARG_BTN, btn);
            hourDialog.setArguments(bundle);
            return hourDialog;
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
        View inflate = LayoutInflater.from(requireContext()).inflate(R.layout.hour_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(requireContext()).i…layout.hour_dialog, null)");
        setDialogView(inflate);
        View findViewById = getDialogView().findViewById(R.id.tableDutyHour);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogView.findViewById(R.id.tableDutyHour)");
        setTableLayout((TableLayout) findViewById);
        View findViewById2 = getDialogView().findViewById(R.id.duty_headr_hour_aply);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogView.findViewById(R.id.duty_headr_hour_aply)");
        setApplyLayout((LinearLayout) findViewById2);
        View findViewById3 = getDialogView().findViewById(R.id.duty_header_hour_aprove);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogView.findViewById(….duty_header_hour_aprove)");
        setAproveLayout((LinearLayout) findViewById3);
        View findViewById4 = getDialogView().findViewById(R.id.hour_spinner);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogView.findViewById(R.id.hour_spinner)");
        setSpinner((Spinner) findViewById4);
        if (this.btn) {
            getAproveLayout().setVisibility(8);
            builder.setTitle("Choose Period");
            this.flag = true;
        } else {
            getApplyLayout().setVisibility(8);
            builder.setTitle("Leave Status");
        }
        loadSpinner(this.id);
        getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.leave.duty.hour.HourDialog$onCreateDialog$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (HourDialog.this.getFlag()) {
                    HourDialog hourDialog = HourDialog.this;
                    hourDialog.loadViewAply(hourDialog.getSpinner().getSelectedItem().toString());
                } else {
                    HourDialog hourDialog2 = HourDialog.this;
                    hourDialog2.loadViewAprov(hourDialog2.getSpinner().getSelectedItem().toString());
                }
            }
        });
        builder.setView(getDialogView());
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadViewAply(String date) {
        getTableLayout().removeAllViews();
        this.list.clear();
        showProgress();
    }
}