package in.etuwa.app.ui.dashboard.dashtable;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DashTableViewAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashTableViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private String date;
    private Boolean isArts;
    private CallBack listener;
    private final ArrayList<PeriodsNew> tables = new ArrayList<>();
    private String userName;

    /* JADX INFO: compiled from: DashTableViewAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lin/etuwa/app/ui/dashboard/dashtable/DashTableViewAdapter$CallBack;", "", "onDate", "", "date", "", "onPeriodClicked", StoreFragmentKt.SUB_ID, "batchId", CommonCssConstants.POSITION, "", "title", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onDate(String date);

        void onPeriodClicked(String subId, String batchId, int position, String title);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_timetable, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …timetable, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.tables.size() > 0) {
            return this.tables.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.tables.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: DashTableViewAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/dashboard/dashtable/DashTableViewAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/dashboard/dashtable/DashTableViewAdapter;Landroid/view/View;)V", "hour", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "subject", "tableView", "Landroid/widget/LinearLayout;", "time", "timeLyt", "type", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView hour;
        private final TextView subject;
        private final LinearLayout tableView;
        final /* synthetic */ DashTableViewAdapter this$0;
        private final TextView time;
        private final LinearLayout timeLyt;
        private final TextView type;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DashTableViewAdapter dashTableViewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashTableViewAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.tt_subject);
            this.time = (TextView) itemView.findViewById(R.id.tt_time);
            this.timeLyt = (LinearLayout) itemView.findViewById(R.id.tt_time_lyt);
            this.hour = (TextView) itemView.findViewById(R.id.hour_tt);
            this.type = (TextView) itemView.findViewById(R.id.tt_type);
            this.tableView = (LinearLayout) itemView.findViewById(R.id.tt_lyt);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            Date date;
            super.onBind(position);
            try {
                Object obj = this.this$0.tables.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "tables[position]");
                PeriodsNew periodsNew = (PeriodsNew) obj;
                this.subject.setText(periodsNew.getSubject());
                this.hour.setText(String.valueOf(position + 1));
                this.time.setText(periodsNew.getTimeperiod());
                this.type.setText(periodsNew.getType());
                if (Intrinsics.areEqual(periodsNew.getTimeperiod(), "")) {
                    this.timeLyt.setVisibility(8);
                } else {
                    this.timeLyt.setVisibility(0);
                }
                String str = this.this$0.date;
                String strNormalizeTime = this.this$0.normalizeTime(StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) periodsNew.getTimeperiod(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null).get(0)).toString());
                try {
                    new SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.getDefault()).parse(str + HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR + strNormalizeTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                try {
                    String str2 = this.this$0.date;
                    Intrinsics.checkNotNull(str2);
                    date = simpleDateFormat.parse(str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    date = null;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                Date time = calendar.getTime();
                if (Intrinsics.areEqual(periodsNew.getAttendance_status(), "present")) {
                    this.tableView.setBackgroundColor(Color.parseColor("#F0FAF4"));
                    return;
                }
                if (Intrinsics.areEqual(periodsNew.getType(), "Free Period")) {
                    this.tableView.setBackgroundColor(Color.parseColor("#EFF4FF"));
                    return;
                }
                if (date != null && date.after(time)) {
                    this.tableView.setBackgroundColor(Color.parseColor("#F8F8FA"));
                } else if (Intrinsics.areEqual(periodsNew.getAttendance_status(), "N/A")) {
                    this.tableView.setBackgroundColor(Color.parseColor("#FEFCF5"));
                } else {
                    this.tableView.setBackgroundColor(Color.parseColor("#FEF2F2"));
                }
            } catch (Exception e3) {
                System.out.println(e3);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void setCallBack(DashTableViewFragment context) {
        this.listener = context;
    }

    public final String normalizeTime(String time) {
        Intrinsics.checkNotNullParameter(time, "time");
        try {
            String strReplace$default = StringsKt.replace$default(StringsKt.trim((CharSequence) time).toString(), ".", ":", false, 4, (Object) null);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = strReplace$default.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = StringsKt.trim((CharSequence) new Regex("\\s+").replace(StringsKt.replace$default(StringsKt.replace$default(lowerCase, "am", " am", false, 4, (Object) null), "pm", " pm", false, 4, (Object) null), HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR)).toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            Date date = simpleDateFormat.parse(string);
            Intrinsics.checkNotNull(date);
            String str = simpleDateFormat2.format(date);
            Intrinsics.checkNotNullExpressionValue(str, "{\n            // Replace….format(date!!)\n        }");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return time;
        }
    }

    public final void addItems(ArrayList<PeriodsNew> list, String date, boolean isArts, String username) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(username, "username");
        this.tables.clear();
        this.tables.addAll(list);
        this.userName = username;
        this.isArts = Boolean.valueOf(isArts);
        this.date = date;
        notifyDataSetChanged();
    }
}