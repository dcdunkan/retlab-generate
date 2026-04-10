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