package in.etuwa.app.ui.leave.duty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.leave.duty.DutyLeave;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.leave.duty.DutyLeaveAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "leaves", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/leave/duty/DutyLeave;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter$LeaveCallBack;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLeaveCallBack", "context", "Lin/etuwa/app/ui/leave/duty/DutyLeaveFragment;", "LeaveCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DutyLeaveAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<DutyLeave> leaves = new ArrayList<>();
    private LeaveCallBack listener;

    /* compiled from: DutyLeaveAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter$LeaveCallBack;", "", "applyBtnClick", "", "id", "", NotificationCompat.CATEGORY_STATUS, "url", "appDates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onBtnClick", "leave", "Lin/etuwa/app/data/model/leave/duty/DutyLeave;", "proofBtnClickd", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface LeaveCallBack {
        void applyBtnClick(String id, String status);

        void applyBtnClick(String id, String status, String url, ArrayList<String> appDates);

        void onBtnClick(DutyLeave leave);

        void proofBtnClickd(String id, String status, String url);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_duty, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   ….row_duty, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.leaves.size() > 0) {
            return this.leaves.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.leaves.isEmpty() ? 1 : 0;
    }

    /* compiled from: DutyLeaveAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter;Landroid/view/View;)V", "applyBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "dutyBtn", "dutyDescription", "dutyLastDate", "dutyStatus", "dutyType", "name", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView applyBtn;
        private final TextView dutyBtn;
        private final TextView dutyDescription;
        private final TextView dutyLastDate;
        private final TextView dutyStatus;
        private final TextView dutyType;
        private final TextView name;
        final /* synthetic */ DutyLeaveAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DutyLeaveAdapter dutyLeaveAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dutyLeaveAdapter;
            this.name = (TextView) itemView.findViewById(R.id.duty_name);
            this.dutyType = (TextView) itemView.findViewById(R.id.duty_type);
            this.dutyStatus = (TextView) itemView.findViewById(R.id.duty_status);
            this.dutyLastDate = (TextView) itemView.findViewById(R.id.duty_last_date);
            this.dutyDescription = (TextView) itemView.findViewById(R.id.duty_description);
            this.dutyBtn = (TextView) itemView.findViewById(R.id.duty_btn);
            this.applyBtn = (TextView) itemView.findViewById(R.id.duty_apply_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.leaves.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "leaves[position]");
                final DutyLeave dutyLeave = (DutyLeave) obj;
                this.name.setText(dutyLeave.getName());
                if (Intrinsics.areEqual(dutyLeave.getType(), "1")) {
                    this.dutyType.setText("Full Day");
                } else {
                    this.dutyType.setText("Hour");
                }
                this.dutyStatus.setText(dutyLeave.getStatus());
                this.dutyLastDate.setText(dutyLeave.getLastDate());
                if (!Intrinsics.areEqual(dutyLeave.getDescription(), "null")) {
                    this.dutyDescription.setText("Description : " + dutyLeave.getDescription());
                } else {
                    this.dutyDescription.setText("Description : ");
                }
                if (dutyLeave.getBtnStatus()) {
                    this.dutyBtn.setText("View Status");
                } else {
                    this.dutyBtn.setText("View Status");
                }
                if (dutyLeave.getBtnStatus()) {
                    this.applyBtn.setVisibility(0);
                } else {
                    this.applyBtn.setVisibility(8);
                }
                if (dutyLeave.getProofStatus()) {
                    this.applyBtn.setText("View Proof");
                } else {
                    this.applyBtn.setText("Apply");
                }
                TextView textView = this.applyBtn;
                final DutyLeaveAdapter dutyLeaveAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DutyLeaveAdapter.ViewHolder.onBind$lambda$0(DutyLeave.this, dutyLeaveAdapter, this, view);
                    }
                });
                TextView textView2 = this.dutyBtn;
                final DutyLeaveAdapter dutyLeaveAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DutyLeaveAdapter.ViewHolder.onBind$lambda$1(DutyLeaveAdapter.this, dutyLeave, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DutyLeave leave, DutyLeaveAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(leave, "$leave");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!leave.getProofStatus()) {
                LeaveCallBack leaveCallBack = this$0.listener;
                if (leaveCallBack != null) {
                    leaveCallBack.applyBtnClick(leave.getId(), this$1.applyBtn.getText().toString());
                    return;
                }
                return;
            }
            LeaveCallBack leaveCallBack2 = this$0.listener;
            if (leaveCallBack2 != null) {
                leaveCallBack2.proofBtnClickd(leave.getId(), this$1.applyBtn.getText().toString(), leave.getProofUrl());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(DutyLeaveAdapter this$0, DutyLeave leave, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(leave, "$leave");
            LeaveCallBack leaveCallBack = this$0.listener;
            if (leaveCallBack != null) {
                leaveCallBack.onBtnClick(leave);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<DutyLeave> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.leaves.clear();
        this.leaves.addAll(list);
        notifyDataSetChanged();
    }

    public final void setLeaveCallBack(DutyLeaveFragment context) {
        this.listener = context;
    }
}