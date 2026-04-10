package in.etuwa.app.ui.leave.duty.directapply.updatehours;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.leave.duty.DutyLeaveHour;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.leave.duty.directapply.updatehours.HourAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HourAdapter.kt */
/* loaded from: classes5.dex */
public final class HourAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<DutyLeaveHour> hour = new ArrayList<>();
    private LeaveCallBack listener;

    /* compiled from: HourAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/updatehours/HourAdapter$LeaveCallBack;", "", "onHourClick", "", "flag", "", "hour", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface LeaveCallBack {
        void onHourClick(boolean flag, String hour);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hour, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   ….row_hour, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hour.size() > 0) {
            return this.hour.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.hour.isEmpty() ? 1 : 0;
    }

    /* compiled from: HourAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/updatehours/HourAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/leave/duty/directapply/updatehours/HourAdapter;Landroid/view/View;)V", "hours", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView hours;
        final /* synthetic */ HourAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HourAdapter hourAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = hourAdapter;
            this.hours = (TextView) itemView.findViewById(R.id.hour_tv);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.hour.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "hour[position]");
                final DutyLeaveHour dutyLeaveHour = (DutyLeaveHour) obj;
                this.hours.setText("Hour " + dutyLeaveHour.getHour());
                if (Intrinsics.areEqual(dutyLeaveHour.getStatus(), CommonCssConstants.INVALID)) {
                    this.hours.setBackgroundResource(R.color.colorLightGrey);
                    this.hours.setTextColor(Color.parseColor("#000000"));
                } else if (Intrinsics.areEqual(dutyLeaveHour.getStatus(), CommonCssConstants.VALID)) {
                    this.hours.setBackgroundResource(R.color.green);
                    this.hours.setTextColor(Color.parseColor("#FFFFFF"));
                }
                TextView textView = this.hours;
                final HourAdapter hourAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.HourAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HourAdapter.ViewHolder.onBind$lambda$0(DutyLeaveHour.this, hourAdapter, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DutyLeaveHour hour, HourAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(hour, "$hour");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(hour.getStatus(), CommonCssConstants.VALID)) {
                LeaveCallBack leaveCallBack = this$0.listener;
                if (leaveCallBack != null) {
                    leaveCallBack.onHourClick(false, String.valueOf(hour.getHour()));
                    return;
                }
                return;
            }
            LeaveCallBack leaveCallBack2 = this$0.listener;
            if (leaveCallBack2 != null) {
                leaveCallBack2.onHourClick(true, String.valueOf(hour.getHour()));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<DutyLeaveHour> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.hour.clear();
        this.hour.addAll(list);
        notifyDataSetChanged();
    }

    public final void setHourCallBack(UpdateHoursDirectDialog context) {
        this.listener = context;
    }
}