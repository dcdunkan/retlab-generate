package in.etuwa.app.ui.leave.duty.directapply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.forms.xfdf.XfdfConstants;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDirectApply;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DirectApplyAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveDirectApply;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyAdapter$CallBack;", "addItems", "", "_list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DirectApplyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<DutyLeaveDirectApply> list = new ArrayList<>();
    private CallBack listener;

    /* compiled from: DirectApplyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyAdapter$CallBack;", "", "delete", "", "id", "", "editBtnClicked", "reason", "fromDate", "toDate", XfdfConstants.HEAD, "updateHoursClicked", "viewProofBtnClicked", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void delete(String id);

        void editBtnClicked(String id, String reason, String fromDate, String toDate, String head);

        void updateHoursClicked(String id);

        void viewProofBtnClicked(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_direct_apply, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ect_apply, parent, false)");
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

    /* compiled from: DirectApplyAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "editBtn", "fromDateTv", "headTv", "reasonTv", "statusTv", "toDateTv", "updateHoursBtn", "viewProofBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final TextView editBtn;
        private final TextView fromDateTv;
        private final TextView headTv;
        private final TextView reasonTv;
        private final TextView statusTv;
        final /* synthetic */ DirectApplyAdapter this$0;
        private final TextView toDateTv;
        private final TextView updateHoursBtn;
        private final TextView viewProofBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DirectApplyAdapter directApplyAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = directApplyAdapter;
            this.headTv = (TextView) itemView.findViewById(R.id.head_tv);
            this.statusTv = (TextView) itemView.findViewById(R.id.status_tv);
            this.reasonTv = (TextView) itemView.findViewById(R.id.reason_tv);
            this.fromDateTv = (TextView) itemView.findViewById(R.id.from_date_tv);
            this.toDateTv = (TextView) itemView.findViewById(R.id.to_date_tv);
            this.updateHoursBtn = (TextView) itemView.findViewById(R.id.update_hours_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_btn);
            this.viewProofBtn = (TextView) itemView.findViewById(R.id.view_proof_btn);
            this.editBtn = (TextView) itemView.findViewById(R.id.edit_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final DutyLeaveDirectApply dutyLeaveDirectApply = (DutyLeaveDirectApply) obj;
                this.headTv.setText(dutyLeaveDirectApply.getHead());
                this.statusTv.setText(dutyLeaveDirectApply.getStatus());
                this.reasonTv.setText(dutyLeaveDirectApply.getReason());
                this.fromDateTv.setText(dutyLeaveDirectApply.getFrom_date());
                this.toDateTv.setText(dutyLeaveDirectApply.getTo_date());
                TextView textView = this.deleteBtn;
                final DirectApplyAdapter directApplyAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DirectApplyAdapter.ViewHolder.onBind$lambda$0(DirectApplyAdapter.this, dutyLeaveDirectApply, view);
                    }
                });
                TextView textView2 = this.updateHoursBtn;
                final DirectApplyAdapter directApplyAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DirectApplyAdapter.ViewHolder.onBind$lambda$1(DirectApplyAdapter.this, dutyLeaveDirectApply, view);
                    }
                });
                TextView textView3 = this.viewProofBtn;
                final DirectApplyAdapter directApplyAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DirectApplyAdapter.ViewHolder.onBind$lambda$2(DirectApplyAdapter.this, dutyLeaveDirectApply, view);
                    }
                });
                TextView textView4 = this.editBtn;
                final DirectApplyAdapter directApplyAdapter4 = this.this$0;
                textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter$ViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DirectApplyAdapter.ViewHolder.onBind$lambda$3(DirectApplyAdapter.this, dutyLeaveDirectApply, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DirectApplyAdapter this$0, DutyLeaveDirectApply item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.delete(item.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(DirectApplyAdapter this$0, DutyLeaveDirectApply item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.updateHoursClicked(item.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(DirectApplyAdapter this$0, DutyLeaveDirectApply item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.viewProofBtnClicked(item.getUrl());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$3(DirectApplyAdapter this$0, DutyLeaveDirectApply item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.editBtnClicked(item.getId(), item.getReason(), item.getFrom_date(), item.getTo_date(), item.getHead());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<DutyLeaveDirectApply> _list) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }

    public final void setCallBack(DirectApplyFragment context) {
        this.listener = context;
    }
}