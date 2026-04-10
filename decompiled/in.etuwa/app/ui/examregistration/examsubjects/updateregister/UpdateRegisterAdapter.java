package in.etuwa.app.ui.examregistration.examsubjects.updateregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.examregister.ExamUpdate;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterAdapter;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateRegisterAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UpdateRegisterAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private CallBack listener;
    private int total;
    private final ArrayList<ExamUpdate> list = new ArrayList<>();
    private List<String> selected = new ArrayList();
    private List<String> selectedTotal = new ArrayList();

    /* JADX INFO: compiled from: UpdateRegisterAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/updateregister/UpdateRegisterAdapter$CallBack;", "", "updateSelected", "", "sel", "", "", FeeConfirmDialogKt.ARG_TOTAL, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void updateSelected(List<String> sel, List<String> total);
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final List<String> getSelectedTotal() {
        return this.selectedTotal;
    }

    public final void setSelectedTotal(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selectedTotal = list;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exam_update, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …am_update, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: UpdateRegisterAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/updateregister/UpdateRegisterAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/examregistration/examsubjects/updateregister/UpdateRegisterAdapter;Landroid/view/View;)V", ExamSubjectDetailDialogKt.ARG_AMOUNT, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "checkBox", "Landroid/widget/CheckBox;", "concession", NotificationCompat.CATEGORY_STATUS, "subjectHead", "type", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView amount;
        private final CheckBox checkBox;
        private final TextView concession;
        private final TextView status;
        private final TextView subjectHead;
        final /* synthetic */ UpdateRegisterAdapter this$0;
        private final TextView type;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(UpdateRegisterAdapter updateRegisterAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = updateRegisterAdapter;
            this.subjectHead = (TextView) itemView.findViewById(R.id.exam_sub_head);
            this.type = (TextView) itemView.findViewById(R.id.exam_type);
            this.concession = (TextView) itemView.findViewById(R.id.exam_concession);
            this.amount = (TextView) itemView.findViewById(R.id.exam_amount);
            this.checkBox = (CheckBox) itemView.findViewById(R.id.exam_check_box);
            this.status = (TextView) itemView.findViewById(R.id.exam_msg);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final ExamUpdate examUpdate = (ExamUpdate) obj;
                this.subjectHead.setText(examUpdate.getCourse());
                this.type.setText(examUpdate.getType());
                this.concession.setText(examUpdate.is_eligible());
                this.amount.setText(examUpdate.getAmount());
                this.this$0.getSelected().add(position, "false");
                this.this$0.getSelectedTotal().add(position, "0");
                this.checkBox.setChecked(examUpdate.is_selected());
                String lowerCase = examUpdate.getMsg().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "registration submitted to college")) {
                    this.checkBox.setVisibility(8);
                    this.status.setText(examUpdate.getMsg());
                    examUpdate.set_selected(false);
                } else {
                    this.status.setText("Not yet Registered");
                    this.checkBox.setVisibility(0);
                }
                CheckBox checkBox = this.checkBox;
                if (checkBox != null) {
                    final UpdateRegisterAdapter updateRegisterAdapter = this.this$0;
                    checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UpdateRegisterAdapter.ViewHolder.onBind$lambda$0(this.f$0, examUpdate, updateRegisterAdapter, position, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, ExamUpdate exam, UpdateRegisterAdapter this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(exam, "$exam");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.checkBox.isChecked()) {
                exam.set_selected(true);
                this$1.getSelected().set(i, "true");
                this$1.getSelectedTotal().set(i, exam.getAmount());
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
                    return;
                }
                return;
            }
            exam.set_selected(false);
            this$1.getSelected().set(i, "false");
            this$1.getSelectedTotal().set(i, "0");
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
            }
        }
    }

    public final void setCallBack(UpdateRegisterFragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ExamUpdate> _list) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        this.selectedTotal.clear();
        this.selected.clear();
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }

    public final ArrayList<ExamUpdate> getItems() {
        return this.list;
    }
}