package in.etuwa.app.ui.leave.duty.hour;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.ui.leave.duty.DutyLeaveTask;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import in.etuwa.app.ui.leave.duty.hour.HourDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: HourDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HourDialog extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    /* JADX INFO: compiled from: HourDialog.kt */
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
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.hour_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(requireContext()).i…layout.hour_dialog, null)");
        setDialogView(viewInflate);
        View viewFindViewById = getDialogView().findViewById(R.id.tableDutyHour);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "dialogView.findViewById(R.id.tableDutyHour)");
        setTableLayout((TableLayout) viewFindViewById);
        View viewFindViewById2 = getDialogView().findViewById(R.id.duty_headr_hour_aply);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "dialogView.findViewById(R.id.duty_headr_hour_aply)");
        setApplyLayout((LinearLayout) viewFindViewById2);
        View viewFindViewById3 = getDialogView().findViewById(R.id.duty_header_hour_aprove);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "dialogView.findViewById(….duty_header_hour_aprove)");
        setAproveLayout((LinearLayout) viewFindViewById3);
        View viewFindViewById4 = getDialogView().findViewById(R.id.hour_spinner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "dialogView.findViewById(R.id.hour_spinner)");
        setSpinner((Spinner) viewFindViewById4);
        if (this.btn) {
            getAproveLayout().setVisibility(8);
            builder.setTitle("Choose Period");
            this.flag = true;
        } else {
            getApplyLayout().setVisibility(8);
            builder.setTitle("Leave Status");
        }
        loadSpinner(this.id);
        getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.leave.duty.hour.HourDialog.onCreateDialog.1
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
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "builder.create()");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadViewAprov(String date) {
        try {
            showProgress();
            getTableLayout().removeAllViews();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).statusBtnHourDuty(new CallBackResponse() { // from class: in.etuwa.app.ui.leave.duty.hour.HourDialog.loadViewAprov.1
                @Override // in.etuwa.app.data.network.CallBackResponse
                public void serverResponse(String response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        JSONArray jSONArray = new JSONArray(response);
                        TableRow[] tableRowArr = new TableRow[jSONArray.length()];
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            TableRow tableRow = new TableRow(HourDialog.this.getActivity());
                            tableRowArr[i] = tableRow;
                            Intrinsics.checkNotNull(tableRow);
                            tableRow.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            TableRow tableRow2 = tableRowArr[i];
                            Intrinsics.checkNotNull(tableRow2);
                            tableRow2.setGravity(17);
                            TextView textView = new TextView(HourDialog.this.getActivity());
                            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -1, 1.0f);
                            textView.setText("Period " + jSONObject.getString(TypedValues.CycleType.S_WAVE_PERIOD));
                            textView.setTextColor(-1);
                            layoutParams.setMargins(0, 10, 0, 20);
                            textView.setTextSize(20.0f);
                            textView.setLayoutParams(layoutParams);
                            textView.setTextColor(-1);
                            textView.setTextSize(20.0f);
                            textView.setGravity(17);
                            if (Intrinsics.areEqual(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), ExifInterface.GPS_MEASUREMENT_2D)) {
                                textView.setBackgroundResource(R.color.colorGreen);
                            } else if (Intrinsics.areEqual(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), "0")) {
                                textView.setBackgroundResource(R.color.colorRed);
                            } else if (Intrinsics.areEqual(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), "1")) {
                                textView.setBackgroundResource(R.color.colorLightGrey);
                            }
                            TableRow tableRow3 = tableRowArr[i];
                            Intrinsics.checkNotNull(tableRow3);
                            tableRow3.addView(textView);
                            HourDialog.this.getTableLayout().addView(tableRowArr[i]);
                        }
                        if (jSONArray.length() == 0) {
                            TableRow tableRow4 = new TableRow(HourDialog.this.getActivity());
                            TableRow[] tableRowArr2 = {tableRow4};
                            Intrinsics.checkNotNull(tableRow4);
                            tableRow4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            TableRow tableRow5 = tableRowArr2[0];
                            Intrinsics.checkNotNull(tableRow5);
                            tableRow5.setPadding(5, 5, 5, 5);
                            TableRow tableRow6 = tableRowArr2[0];
                            Intrinsics.checkNotNull(tableRow6);
                            tableRow6.setGravity(17);
                            TextView textView2 = new TextView(HourDialog.this.getActivity());
                            textView2.setLayoutParams(new TableRow.LayoutParams(-1, -1, 1.0f));
                            textView2.setText("No Dates Available!!");
                            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                            textView2.setTextSize(20.0f);
                            textView2.setPadding(5, 5, 5, 5);
                            textView2.setGravity(17);
                            TableRow tableRow7 = tableRowArr2[0];
                            Intrinsics.checkNotNull(tableRow7);
                            tableRow7.addView(textView2);
                            HourDialog.this.getTableLayout().addView(tableRowArr2[0]);
                        }
                        HourDialog.this.hideProgress();
                    } catch (Exception unused) {
                    }
                }
            }, this.id, date);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadViewAply(String date) {
        getTableLayout().removeAllViews();
        this.list.clear();
        showProgress();
        try {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).applyBtnDutyHour(new C05291(date), this.id, date);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: in.etuwa.app.ui.leave.duty.hour.HourDialog$loadViewAply$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HourDialog.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"in/etuwa/app/ui/leave/duty/hour/HourDialog$loadViewAply$1", "Lin/etuwa/app/data/network/CallBackResponse;", "serverResponse", "", "response", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05291 implements CallBackResponse {
        final /* synthetic */ String $date;

        C05291(String str) {
            this.$date = str;
        }

        @Override // in.etuwa.app.data.network.CallBackResponse
        public void serverResponse(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                JSONArray jSONArray = new JSONArray(response);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ArrayList<DutyStatusBeanHour> list = HourDialog.this.getList();
                    String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                    Intrinsics.checkNotNullExpressionValue(string, "obj.getString(\"status\")");
                    String string2 = jSONObject.getString(CommonCssConstants.VALID);
                    Intrinsics.checkNotNullExpressionValue(string2, "obj.getString(\"valid\")");
                    list.add(new DutyStatusBeanHour(string, string2));
                }
                if (jSONArray.length() == 0) {
                    TableRow tableRow = new TableRow(HourDialog.this.getActivity());
                    TableRow[] tableRowArr = {tableRow};
                    Intrinsics.checkNotNull(tableRow);
                    tableRow.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    TableRow tableRow2 = tableRowArr[0];
                    Intrinsics.checkNotNull(tableRow2);
                    tableRow2.setPadding(5, 5, 5, 5);
                    TableRow tableRow3 = tableRowArr[0];
                    Intrinsics.checkNotNull(tableRow3);
                    tableRow3.setGravity(17);
                    TextView textView = new TextView(HourDialog.this.getActivity());
                    textView.setLayoutParams(new TableRow.LayoutParams(-1, -1, 1.0f));
                    textView.setText("No Dates Added Yet!!");
                    textView.setTextColor(-1);
                    textView.setTextSize(20.0f);
                    textView.setPadding(5, 5, 5, 5);
                    textView.setGravity(17);
                    TableRow tableRow4 = tableRowArr[0];
                    Intrinsics.checkNotNull(tableRow4);
                    tableRow4.addView(textView);
                    HourDialog.this.getTableLayout().addView(tableRowArr[0]);
                } else {
                    TableRow[] tableRowArr2 = new TableRow[HourDialog.this.getList().size()];
                    int size = HourDialog.this.getList().size();
                    final int i2 = 0;
                    while (i2 < size) {
                        TableRow tableRow5 = new TableRow(HourDialog.this.getActivity());
                        tableRowArr2[i2] = tableRow5;
                        Intrinsics.checkNotNull(tableRow5);
                        tableRow5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        TableRow tableRow6 = tableRowArr2[i2];
                        Intrinsics.checkNotNull(tableRow6);
                        tableRow6.setGravity(17);
                        final TextView textView2 = new TextView(HourDialog.this.getActivity());
                        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -1, 1.0f);
                        int i3 = i2 + 1;
                        textView2.setText("Period : " + i3);
                        layoutParams.setMargins(0, 10, 0, 20);
                        textView2.setLayoutParams(layoutParams);
                        textView2.setTextColor(-1);
                        textView2.setTextSize(20.0f);
                        if (Intrinsics.areEqual(HourDialog.this.getList().get(i2).getValid(), "false")) {
                            textView2.setBackgroundResource(R.color.view_color);
                        } else if (Intrinsics.areEqual(HourDialog.this.getList().get(i2).getStatus(), "not applied")) {
                            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
                        } else {
                            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_blue);
                        }
                        textView2.setGravity(17);
                        final HourDialog hourDialog = HourDialog.this;
                        final String str = this.$date;
                        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.hour.HourDialog$loadViewAply$1$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                HourDialog.C05291.serverResponse$lambda$0(hourDialog, i2, str, textView2, view);
                            }
                        });
                        TableRow tableRow7 = tableRowArr2[i2];
                        Intrinsics.checkNotNull(tableRow7);
                        tableRow7.addView(textView2);
                        HourDialog.this.getTableLayout().addView(tableRowArr2[i2]);
                        i2 = i3;
                    }
                }
                HourDialog.this.hideProgress();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void serverResponse$lambda$0(HourDialog this$0, int i, String date, TextView textView, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(date, "$date");
            Intrinsics.checkNotNullParameter(textView, "$textView");
            if (Intrinsics.areEqual(this$0.getList().get(i).getValid(), "true")) {
                if (!Intrinsics.areEqual(this$0.getList().get(i).getStatus(), "applied")) {
                    this$0.applyStatus(date, String.valueOf(i + 1), textView, i);
                } else {
                    this$0.cancelStatus(date, String.valueOf(i + 1), textView, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelStatus(String date, String hour, final TextView textView, final int i) {
        try {
            showProgress();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).cancelHour(new CallBackResponse() { // from class: in.etuwa.app.ui.leave.duty.hour.HourDialog.cancelStatus.1
                @Override // in.etuwa.app.data.network.CallBackResponse
                public void serverResponse(String response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        if (new JSONObject(response).getBoolean("response")) {
                            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
                            this.getList().get(i).setStatus("not applied");
                            this.hideProgress();
                        }
                    } catch (Exception unused) {
                    }
                }
            }, this.id, date, hour);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyStatus(String date, String hour, final TextView textView, final int i) {
        try {
            showProgress();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).applyHour(new CallBackResponse() { // from class: in.etuwa.app.ui.leave.duty.hour.HourDialog.applyStatus.1
                @Override // in.etuwa.app.data.network.CallBackResponse
                public void serverResponse(String response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        if (new JSONObject(response).getBoolean("response")) {
                            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_blue);
                            this.getList().get(i).setStatus("applied");
                            this.hideProgress();
                        }
                    } catch (Exception unused) {
                    }
                }
            }, this.id, date, hour);
        } catch (Exception unused) {
        }
    }

    private final void loadSpinner(String id) {
        try {
            showProgress();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).applyHourDutyDates(new CallBackResponse() { // from class: in.etuwa.app.ui.leave.duty.hour.HourDialog.loadSpinner.1
                @Override // in.etuwa.app.data.network.CallBackResponse
                public void serverResponse(String response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        JSONArray jSONArray = new JSONArray(response);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            HourDialog.this.getDateList().add(jSONArray.getString(i));
                        }
                        if (jSONArray.length() == 0) {
                            TableRow tableRow = new TableRow(HourDialog.this.getActivity());
                            TableRow[] tableRowArr = {tableRow};
                            Intrinsics.checkNotNull(tableRow);
                            tableRow.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            TableRow tableRow2 = tableRowArr[0];
                            Intrinsics.checkNotNull(tableRow2);
                            tableRow2.setPadding(5, 5, 5, 5);
                            TableRow tableRow3 = tableRowArr[0];
                            Intrinsics.checkNotNull(tableRow3);
                            tableRow3.setGravity(17);
                            TextView textView = new TextView(HourDialog.this.getActivity());
                            textView.setLayoutParams(new TableRow.LayoutParams(-1, -1, 1.0f));
                            textView.setText("No Dates Added Yet!!");
                            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                            textView.setTextSize(20.0f);
                            textView.setPadding(5, 5, 5, 5);
                            textView.setGravity(17);
                            TableRow tableRow4 = tableRowArr[0];
                            Intrinsics.checkNotNull(tableRow4);
                            tableRow4.addView(textView);
                            HourDialog.this.getTableLayout().addView(tableRowArr[0]);
                        }
                        HourDialog.this.setArrayAdapter(new ArrayAdapter<>(HourDialog.this.requireContext(), android.R.layout.simple_spinner_item, HourDialog.this.getDateList()));
                        HourDialog.this.getArrayAdapter().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        HourDialog.this.getSpinner().setAdapter((SpinnerAdapter) HourDialog.this.getArrayAdapter());
                        HourDialog.this.hideProgress();
                    } catch (Exception unused) {
                    }
                }
            }, id);
        } catch (Exception unused) {
        }
    }
}