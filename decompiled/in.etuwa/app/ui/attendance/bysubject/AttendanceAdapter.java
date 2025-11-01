package in.etuwa.app.ui.attendance.bysubject;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import at.grabner.circleprogress.CircleProgressView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.attendance.Attendance;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AttendanceAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J6\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/ui/attendance/bysubject/AttendanceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "attendances", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/attendance/Attendance;", "Lkotlin/collections/ArrayList;", "dutyLeave", "", "Ljava/lang/Boolean;", "flag", "isArts", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttendanceAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Attendance> attendances = new ArrayList<>();
    private Boolean dutyLeave;
    private Boolean flag;
    private Boolean isArts;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_by_subject, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …y_subject, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.attendances.size() > 0) {
            return this.attendances.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.attendances.isEmpty() ? 1 : 0;
    }

    /* compiled from: AttendanceAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/attendance/bysubject/AttendanceAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/attendance/bysubject/AttendanceAdapter;Landroid/view/View;)V", "perBar", "Lat/grabner/circleprogress/CircleProgressView;", "kotlin.jvm.PlatformType", "sideView", "sub", "Landroid/widget/TextView;", FeeConfirmDialogKt.ARG_TOTAL, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final CircleProgressView perBar;
        private final View sideView;
        private final TextView sub;
        final /* synthetic */ AttendanceAdapter this$0;
        private final TextView total;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(AttendanceAdapter attendanceAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = attendanceAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.attendance_by_sub);
            this.total = (TextView) itemView.findViewById(R.id.attendance_by_total);
            this.perBar = (CircleProgressView) itemView.findViewById(R.id.attendance_by_per);
            this.sideView = itemView.findViewById(R.id.side_bar_attendance);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.attendances.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "attendances[position]");
                Attendance attendance = (Attendance) obj;
                this.sub.setText(attendance.getSubject());
                if (!Intrinsics.areEqual((Object) this.this$0.isArts, (Object) true)) {
                    Boolean bool = this.this$0.flag;
                    Intrinsics.checkNotNull(bool);
                    if (!bool.booleanValue()) {
                        Boolean bool2 = this.this$0.dutyLeave;
                        Intrinsics.checkNotNull(bool2);
                        if (!bool2.booleanValue()) {
                            this.total.setText(attendance.getTotal_subject());
                            if (Intrinsics.areEqual(attendance.getPercentage_subject(), "N/A")) {
                                this.perBar.setValueAnimated(0);
                            } else {
                                this.perBar.setValueAnimated(Float.parseFloat(attendance.getPercentage_subject()));
                            }
                            if (Intrinsics.areEqual(attendance.getPercentage_subject(), "N/A")) {
                                this.sideView.setBackgroundColor(Color.parseColor("#34495E"));
                                return;
                            }
                            if (Integer.parseInt(attendance.getPercentage_subject()) >= 75) {
                                this.sideView.setBackgroundColor(Color.parseColor("#18460c"));
                                return;
                            } else if (Integer.parseInt(attendance.getPercentage_subject()) >= 50) {
                                this.sideView.setBackgroundColor(Color.parseColor("#266d19"));
                                return;
                            } else {
                                if (Integer.parseInt(attendance.getPercentage_subject()) < 50) {
                                    this.sideView.setBackgroundColor(Color.parseColor("#B71C1C"));
                                    return;
                                }
                                return;
                            }
                        }
                        this.total.setText(attendance.getTotal_dutyleave());
                        if (Intrinsics.areEqual(attendance.getPercentage_dutyleave(), "N/A")) {
                            this.perBar.setValueAnimated(0);
                        } else {
                            this.perBar.setValueAnimated(Float.parseFloat(attendance.getPercentage_dutyleave()));
                        }
                        if (Intrinsics.areEqual(attendance.getPercentage_dutyleave(), "N/A")) {
                            this.sideView.setBackgroundColor(Color.parseColor("#34495E"));
                            return;
                        }
                        if (Integer.parseInt(attendance.getPercentage_dutyleave()) >= 75) {
                            this.sideView.setBackgroundColor(Color.parseColor("#18460c"));
                            return;
                        } else if (Integer.parseInt(attendance.getPercentage_dutyleave()) >= 50) {
                            this.sideView.setBackgroundColor(Color.parseColor("#266d19"));
                            return;
                        } else {
                            if (Integer.parseInt(attendance.getPercentage_dutyleave()) < 50) {
                                this.sideView.setBackgroundColor(Color.parseColor("#B71C1C"));
                                return;
                            }
                            return;
                        }
                    }
                    this.total.setText(attendance.getCredit_total());
                    if (Intrinsics.areEqual(attendance.getCredit_percent(), "N/A")) {
                        this.perBar.setValueAnimated(0);
                    } else {
                        this.perBar.setValueAnimated(Float.parseFloat(StringsKt.replace$default(attendance.getCredit_percent(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)));
                    }
                    if (Intrinsics.areEqual(StringsKt.replace$default(attendance.getCredit_percent(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null), "N/A")) {
                        this.sideView.setBackgroundColor(Color.parseColor("#34495E"));
                        return;
                    }
                    if (Integer.parseInt(StringsKt.replace$default(attendance.getCredit_percent(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)) >= 75) {
                        this.sideView.setBackgroundColor(Color.parseColor("#18460c"));
                        return;
                    } else if (Integer.parseInt(StringsKt.replace$default(attendance.getCredit_percent(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)) >= 50) {
                        this.sideView.setBackgroundColor(Color.parseColor("#266d19"));
                        return;
                    } else {
                        if (Integer.parseInt(StringsKt.replace$default(attendance.getCredit_percent(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)) < 50) {
                            this.sideView.setBackgroundColor(Color.parseColor("#B71C1C"));
                            return;
                        }
                        return;
                    }
                }
                this.total.setText(attendance.getClass_attended() + RemoteSettings.FORWARD_SLASH_STRING + attendance.getTotal_classes());
                if (Intrinsics.areEqual(attendance.getPercentage(), "N/A")) {
                    this.perBar.setValueAnimated(0);
                } else {
                    this.perBar.setValueAnimated(Float.parseFloat(StringsKt.replace$default(attendance.getPercentage(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)));
                }
                if (Intrinsics.areEqual(StringsKt.replace$default(attendance.getPercentage(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null), "N/A")) {
                    this.sideView.setBackgroundColor(Color.parseColor("#34495E"));
                    return;
                }
                if (Integer.parseInt(StringsKt.replace$default(attendance.getPercentage(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)) >= 75) {
                    this.sideView.setBackgroundColor(Color.parseColor("#18460c"));
                } else if (Integer.parseInt(StringsKt.replace$default(attendance.getPercentage(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)) >= 50) {
                    this.sideView.setBackgroundColor(Color.parseColor("#266d19"));
                } else if (Integer.parseInt(StringsKt.replace$default(attendance.getPercentage(), CommonCssConstants.PERCENTAGE, "", false, 4, (Object) null)) < 50) {
                    this.sideView.setBackgroundColor(Color.parseColor("#B71C1C"));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Attendance> list, boolean dutyLeave, boolean flag, boolean isArts) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.attendances.clear();
        this.attendances.addAll(list);
        this.isArts = Boolean.valueOf(isArts);
        this.dutyLeave = Boolean.valueOf(dutyLeave);
        this.flag = Boolean.valueOf(flag);
        notifyDataSetChanged();
    }
}