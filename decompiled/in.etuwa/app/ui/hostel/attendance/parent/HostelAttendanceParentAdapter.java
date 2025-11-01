package in.etuwa.app.ui.hostel.attendance.parent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.attendance.HostelAttParentView;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelAttendanceParentAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttParentView;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter$CallBack;", "addItems", "", "_list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelAttendanceParentAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private final ArrayList<HostelAttParentView> list = new ArrayList<>();
    private CallBack listener;

    /* compiled from: HostelAttendanceParentAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter$CallBack;", "", "approveBtnClicked", "", "id", "", "rejectBtnClicked", "revokeBtnClicked", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void approveBtnClicked(String id);

        void rejectBtnClicked(String id);

        void revokeBtnClicked(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_hostel_att_parent_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …rent_view, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.list.size() > 0) {
            return this.list.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.list.isEmpty() ? 1 : 0;
    }

    /* compiled from: HostelAttendanceParentAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostel/attendance/parent/HostelAttendanceParentAdapter;Landroid/view/View;)V", "approveBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "approveRejLyt", "Landroid/widget/LinearLayout;", "date", "leaveType", "reason", "rejectBtn", "revLyt", "revokeBtn", NotificationCompat.CATEGORY_STATUS, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView approveBtn;
        private final LinearLayout approveRejLyt;
        private final TextView date;
        private final TextView leaveType;
        private final TextView reason;
        private final TextView rejectBtn;
        private final LinearLayout revLyt;
        private final TextView revokeBtn;
        private final TextView status;
        final /* synthetic */ HostelAttendanceParentAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HostelAttendanceParentAdapter hostelAttendanceParentAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = hostelAttendanceParentAdapter;
            this.leaveType = (TextView) itemView.findViewById(R.id.leave_type_hostel);
            this.status = (TextView) itemView.findViewById(R.id.status_leave);
            this.date = (TextView) itemView.findViewById(R.id.date_leave);
            this.reason = (TextView) itemView.findViewById(R.id.reason_leave);
            this.revokeBtn = (TextView) itemView.findViewById(R.id.revoke_btn);
            this.rejectBtn = (TextView) itemView.findViewById(R.id.reject_btn);
            this.approveBtn = (TextView) itemView.findViewById(R.id.approve_btn);
            this.approveRejLyt = (LinearLayout) itemView.findViewById(R.id.app_rej_lyt);
            this.revLyt = (LinearLayout) itemView.findViewById(R.id.revoke_lyt);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final HostelAttParentView hostelAttParentView = (HostelAttParentView) obj;
                this.leaveType.setText(hostelAttParentView.getType());
                this.status.setText(hostelAttParentView.getStatus());
                this.date.setText(hostelAttParentView.getFrom_date());
                this.reason.setText(hostelAttParentView.getReason());
                if (!Intrinsics.areEqual(hostelAttParentView.getBtn_app(), "")) {
                    TextView textView = this.approveBtn;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    LinearLayout linearLayout = this.approveRejLyt;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                } else {
                    TextView textView2 = this.approveBtn;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    LinearLayout linearLayout2 = this.approveRejLyt;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                }
                if (!Intrinsics.areEqual(hostelAttParentView.getBtn_rej(), "")) {
                    TextView textView3 = this.rejectBtn;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    LinearLayout linearLayout3 = this.approveRejLyt;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                } else {
                    TextView textView4 = this.rejectBtn;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                    LinearLayout linearLayout4 = this.approveRejLyt;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                }
                if (!Intrinsics.areEqual(hostelAttParentView.getBtn_rev(), "")) {
                    TextView textView5 = this.revokeBtn;
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                    LinearLayout linearLayout5 = this.revLyt;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(0);
                    }
                } else {
                    TextView textView6 = this.revokeBtn;
                    if (textView6 != null) {
                        textView6.setVisibility(8);
                    }
                    LinearLayout linearLayout6 = this.revLyt;
                    if (linearLayout6 != null) {
                        linearLayout6.setVisibility(8);
                    }
                }
                TextView textView7 = this.revokeBtn;
                if (textView7 != null) {
                    final HostelAttendanceParentAdapter hostelAttendanceParentAdapter = this.this$0;
                    textView7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HostelAttendanceParentAdapter.ViewHolder.onBind$lambda$0(HostelAttendanceParentAdapter.this, hostelAttParentView, view);
                        }
                    });
                }
                TextView textView8 = this.rejectBtn;
                if (textView8 != null) {
                    final HostelAttendanceParentAdapter hostelAttendanceParentAdapter2 = this.this$0;
                    textView8.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HostelAttendanceParentAdapter.ViewHolder.onBind$lambda$1(HostelAttendanceParentAdapter.this, hostelAttParentView, view);
                        }
                    });
                }
                TextView textView9 = this.approveBtn;
                if (textView9 != null) {
                    final HostelAttendanceParentAdapter hostelAttendanceParentAdapter3 = this.this$0;
                    textView9.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter$ViewHolder$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HostelAttendanceParentAdapter.ViewHolder.onBind$lambda$2(HostelAttendanceParentAdapter.this, hostelAttParentView, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(HostelAttendanceParentAdapter this$0, HostelAttParentView leaveHostel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(leaveHostel, "$leaveHostel");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.revokeBtnClicked(leaveHostel.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(HostelAttendanceParentAdapter this$0, HostelAttParentView leaveHostel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(leaveHostel, "$leaveHostel");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.rejectBtnClicked(leaveHostel.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(HostelAttendanceParentAdapter this$0, HostelAttParentView leaveHostel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(leaveHostel, "$leaveHostel");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.approveBtnClicked(leaveHostel.getId());
            }
        }
    }

    public final void setCallBack(HostelAttendanceParentFragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<HostelAttParentView> _list) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }
}