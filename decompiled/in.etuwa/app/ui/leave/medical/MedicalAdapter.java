package in.etuwa.app.ui.leave.medical;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.leave.medical.MedicalLeave;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MedicalAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class MedicalAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<MedicalLeave> leaves = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_medical, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …w_medical, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: MedicalAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/leave/medical/MedicalAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/leave/medical/MedicalAdapter;Landroid/view/View;)V", "dFrom", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "dTo", "remark", "reson", "side", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView dFrom;
        private final TextView dTo;
        private final TextView remark;
        private final TextView reson;
        private final View side;
        final /* synthetic */ MedicalAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MedicalAdapter medicalAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = medicalAdapter;
            this.reson = (TextView) itemView.findViewById(R.id.medical_reason);
            this.dFrom = (TextView) itemView.findViewById(R.id.medical_date_f);
            this.dTo = (TextView) itemView.findViewById(R.id.medical_date_to);
            this.remark = (TextView) itemView.findViewById(R.id.medical_remark);
            this.side = itemView.findViewById(R.id.medical_view_side);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.leaves.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "leaves[position]");
                MedicalLeave medicalLeave = (MedicalLeave) obj;
                this.reson.setText(medicalLeave.getReason());
                this.dFrom.setText(medicalLeave.getDFrom());
                this.dTo.setText(medicalLeave.getDTo());
                this.remark.setText(medicalLeave.getRemark());
                String status = medicalLeave.getStatus();
                switch (status.hashCode()) {
                    case -543852386:
                        if (status.equals("Rejected")) {
                            this.side.setBackgroundColor(Color.parseColor("#c51212"));
                        }
                        break;
                    case 871417949:
                        if (status.equals("Applied")) {
                            this.side.setBackgroundColor(Color.parseColor("#0952B5"));
                        }
                        break;
                    case 1249888983:
                        if (status.equals("Approved")) {
                            this.side.setBackgroundColor(Color.parseColor("#286718"));
                        }
                        break;
                    case 1909758217:
                        if (status.equals("Attendance Added")) {
                            this.side.setBackgroundColor(Color.parseColor("#E74C3C"));
                        }
                        break;
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

    public final void addItems(ArrayList<MedicalLeave> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.leaves.clear();
        this.leaves.addAll(list);
        notifyDataSetChanged();
    }
}