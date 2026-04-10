package in.etuwa.app.ui.leave.duty.fullday;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import in.etuwa.app.R;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.leave.duty.DutyLeaveTask;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: FullDayDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class FullDayDialog extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean btn;
    private String id;
    private LinearLayout layoutAply;
    private LinearLayout layoutAprov;
    private final ArrayList<DutyStatusBeanFull> list = new ArrayList<>();
    private TableLayout tableLayout;

    public final void hideProgress() {
    }

    public final void showProgress() {
    }

    /* JADX INFO: compiled from: FullDayDialog.kt */
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
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.full_day_dialog, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.tableDutyFull);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.tableDutyFull)");
        this.tableLayout = (TableLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.duty_header_apply);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.duty_header_apply)");
        this.layoutAply = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.duty_header_aprov);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.duty_header_aprov)");
        this.layoutAprov = (LinearLayout) viewFindViewById3;
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
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "builder.create()");
        return alertDialogCreate;
    }

    private final void loadAprove() {
        try {
            showProgress();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).statusBtnFullDuty(new CallBackResponse() { // from class: in.etuwa.app.ui.leave.duty.fullday.FullDayDialog.loadAprove.1
                @Override // in.etuwa.app.data.network.CallBackResponse
                public void serverResponse(String response) {
                    TableLayout tableLayout;
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        JSONArray jSONArray = new JSONArray(response);
                        float f = 1.0f;
                        int i = 17;
                        if (jSONArray.length() != 0) {
                            TableRow[] tableRowArr = new TableRow[jSONArray.length()];
                            int length = jSONArray.length();
                            int i2 = 0;
                            while (i2 < length) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                TableRow tableRow = new TableRow(FullDayDialog.this.getActivity());
                                tableRowArr[i2] = tableRow;
                                Intrinsics.checkNotNull(tableRow);
                                tableRow.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                TableRow tableRow2 = tableRowArr[i2];
                                Intrinsics.checkNotNull(tableRow2);
                                tableRow2.setGravity(i);
                                TextView textView = new TextView(FullDayDialog.this.getActivity());
                                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -1, f);
                                Context contextRequireContext2 = FullDayDialog.this.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                                ValidChecker validChecker = new ValidChecker(contextRequireContext2);
                                String string = jSONObject.getString("date");
                                Intrinsics.checkNotNullExpressionValue(string, "obj.getString(\"date\")");
                                textView.setText(validChecker.dateFormatter(string));
                                textView.setTextColor(-1);
                                layoutParams.setMargins(0, 10, 0, 20);
                                textView.setTextSize(20.0f);
                                textView.setLayoutParams(layoutParams);
                                textView.setTextColor(-1);
                                textView.setTextSize(20.0f);
                                textView.setGravity(17);
                                if (Intrinsics.areEqual(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), "0")) {
                                    textView.setBackgroundResource(R.color.colorRed);
                                } else if (Intrinsics.areEqual(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), "1")) {
                                    textView.setBackgroundResource(R.color.colorLightGrey);
                                } else if (Intrinsics.areEqual(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), ExifInterface.GPS_MEASUREMENT_2D)) {
                                    textView.setBackgroundResource(R.color.colorGreen);
                                }
                                TableRow tableRow3 = tableRowArr[i2];
                                Intrinsics.checkNotNull(tableRow3);
                                tableRow3.addView(textView);
                                TableLayout tableLayout2 = FullDayDialog.this.tableLayout;
                                if (tableLayout2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("tableLayout");
                                    tableLayout2 = null;
                                }
                                tableLayout2.addView(tableRowArr[i2]);
                                i2++;
                                f = 1.0f;
                                i = 17;
                            }
                        } else if (jSONArray.length() == 0) {
                            FragmentActivity activity = FullDayDialog.this.getActivity();
                            Intrinsics.checkNotNull(activity);
                            TableRow tableRow4 = new TableRow(activity);
                            TableRow[] tableRowArr2 = {tableRow4};
                            Intrinsics.checkNotNull(tableRow4);
                            tableRow4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            TableRow tableRow5 = tableRowArr2[0];
                            Intrinsics.checkNotNull(tableRow5);
                            tableRow5.setPadding(5, 5, 5, 5);
                            TableRow tableRow6 = tableRowArr2[0];
                            Intrinsics.checkNotNull(tableRow6);
                            tableRow6.setGravity(17);
                            TextView textView2 = new TextView(FullDayDialog.this.getActivity());
                            textView2.setLayoutParams(new TableRow.LayoutParams(-1, -1, 1.0f));
                            textView2.setText("No Dates Available!!");
                            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                            textView2.setTextSize(20.0f);
                            textView2.setPadding(5, 5, 5, 5);
                            textView2.setGravity(17);
                            TableRow tableRow7 = tableRowArr2[0];
                            Intrinsics.checkNotNull(tableRow7);
                            tableRow7.addView(textView2);
                            TableLayout tableLayout3 = FullDayDialog.this.tableLayout;
                            if (tableLayout3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tableLayout");
                                tableLayout = null;
                            } else {
                                tableLayout = tableLayout3;
                            }
                            tableLayout.addView(tableRowArr2[0]);
                        }
                        FullDayDialog.this.hideProgress();
                    } catch (Exception unused) {
                    }
                }
            }, this.id);
        } catch (Exception unused) {
        }
    }

    private final void loadApply() {
        try {
            showProgress();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).applyBtnDutyFull(new C05251(), this.id);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: in.etuwa.app.ui.leave.duty.fullday.FullDayDialog$loadApply$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FullDayDialog.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"in/etuwa/app/ui/leave/duty/fullday/FullDayDialog$loadApply$1", "Lin/etuwa/app/data/network/CallBackResponse;", "serverResponse", "", "response", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05251 implements CallBackResponse {
        C05251() {
        }

        @Override // in.etuwa.app.data.network.CallBackResponse
        public void serverResponse(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                JSONArray jSONArray = new JSONArray(response);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ArrayList arrayList = FullDayDialog.this.list;
                    String string = jSONObject.getString("date");
                    Intrinsics.checkNotNullExpressionValue(string, "obj.getString(\"date\")");
                    String string2 = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                    Intrinsics.checkNotNullExpressionValue(string2, "obj.getString(\"status\")");
                    arrayList.add(new DutyStatusBeanFull(string, string2));
                }
                int length2 = jSONArray.length();
                TableLayout tableLayout = null;
                if (length2 != 0) {
                    TableRow[] tableRowArr = new TableRow[FullDayDialog.this.list.size()];
                    int size = FullDayDialog.this.list.size();
                    for (final int i2 = 0; i2 < size; i2++) {
                        TableRow tableRow = new TableRow(FullDayDialog.this.getActivity());
                        tableRowArr[i2] = tableRow;
                        Intrinsics.checkNotNull(tableRow);
                        tableRow.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        TableRow tableRow2 = tableRowArr[i2];
                        Intrinsics.checkNotNull(tableRow2);
                        tableRow2.setGravity(17);
                        final TextView textView = new TextView(FullDayDialog.this.getActivity());
                        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-1, -1, 1.0f);
                        Context contextRequireContext = FullDayDialog.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        textView.setText(new ValidChecker(contextRequireContext).dateFormatter(((DutyStatusBeanFull) FullDayDialog.this.list.get(i2)).getDay()));
                        layoutParams.setMargins(0, 10, 0, 20);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextColor(-1);
                        textView.setTextSize(20.0f);
                        if (Intrinsics.areEqual(((DutyStatusBeanFull) FullDayDialog.this.list.get(i2)).getStatus(), "0")) {
                            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
                        } else {
                            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_blue);
                        }
                        textView.setGravity(17);
                        final FullDayDialog fullDayDialog = FullDayDialog.this;
                        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.fullday.FullDayDialog$loadApply$1$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                FullDayDialog.C05251.serverResponse$lambda$0(fullDayDialog, i2, textView, view);
                            }
                        });
                        TableRow tableRow3 = tableRowArr[i2];
                        Intrinsics.checkNotNull(tableRow3);
                        tableRow3.addView(textView);
                        TableLayout tableLayout2 = FullDayDialog.this.tableLayout;
                        if (tableLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tableLayout");
                            tableLayout2 = null;
                        }
                        tableLayout2.addView(tableRowArr[i2]);
                    }
                } else {
                    TableRow tableRow4 = new TableRow(FullDayDialog.this.getActivity());
                    TableRow[] tableRowArr2 = {tableRow4};
                    Intrinsics.checkNotNull(tableRow4);
                    tableRow4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    TableRow tableRow5 = tableRowArr2[0];
                    Intrinsics.checkNotNull(tableRow5);
                    tableRow5.setPadding(5, 5, 5, 5);
                    TableRow tableRow6 = tableRowArr2[0];
                    Intrinsics.checkNotNull(tableRow6);
                    tableRow6.setGravity(17);
                    TextView textView2 = new TextView(FullDayDialog.this.getActivity());
                    textView2.setLayoutParams(new TableRow.LayoutParams(-1, -1, 1.0f));
                    textView2.setText("No Dates Added Yet!!");
                    textView2.setTextColor(-1);
                    textView2.setTextSize(20.0f);
                    textView2.setPadding(5, 5, 5, 5);
                    textView2.setGravity(17);
                    TableRow tableRow7 = tableRowArr2[0];
                    Intrinsics.checkNotNull(tableRow7);
                    tableRow7.addView(textView2);
                    TableLayout tableLayout3 = FullDayDialog.this.tableLayout;
                    if (tableLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tableLayout");
                    } else {
                        tableLayout = tableLayout3;
                    }
                    tableLayout.addView(tableRowArr2[0]);
                }
                FullDayDialog.this.hideProgress();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void serverResponse$lambda$0(FullDayDialog this$0, int i, TextView textView, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(textView, "$textView");
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            ValidChecker validChecker = new ValidChecker(contextRequireContext);
            FragmentActivity activity = this$0.getActivity();
            Intrinsics.checkNotNull(activity);
            validChecker.vibrate(activity, 100L);
            this$0.showProgress();
            if (Intrinsics.areEqual(((DutyStatusBeanFull) this$0.list.get(i)).getStatus(), "0")) {
                this$0.applyStatus(((DutyStatusBeanFull) this$0.list.get(i)).getDay(), textView, i);
            } else {
                this$0.cancelStatus(((DutyStatusBeanFull) this$0.list.get(i)).getDay(), textView, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelStatus(String date, final TextView textView, final int i) {
        try {
            showProgress();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).cancelFullDay(new CallBackResponse() { // from class: in.etuwa.app.ui.leave.duty.fullday.FullDayDialog.cancelStatus.1
                @Override // in.etuwa.app.data.network.CallBackResponse
                public void serverResponse(String response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        if (new JSONObject(response).getBoolean("response")) {
                            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
                            ((DutyStatusBeanFull) this.list.get(i)).setStatus("0");
                            this.hideProgress();
                        }
                    } catch (Exception unused) {
                    }
                }
            }, this.id, date);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyStatus(String date, final TextView textView, final int i) {
        try {
            showProgress();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            new DutyLeaveTask(contextRequireContext).applyFullDay(new CallBackResponse() { // from class: in.etuwa.app.ui.leave.duty.fullday.FullDayDialog.applyStatus.1
                @Override // in.etuwa.app.data.network.CallBackResponse
                public void serverResponse(String response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        if (new JSONObject(response).getBoolean("response")) {
                            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_blue);
                            ((DutyStatusBeanFull) this.list.get(i)).setStatus("1");
                            this.hideProgress();
                        }
                    } catch (Exception unused) {
                    }
                }
            }, this.id, date);
        } catch (Exception unused) {
        }
    }
}