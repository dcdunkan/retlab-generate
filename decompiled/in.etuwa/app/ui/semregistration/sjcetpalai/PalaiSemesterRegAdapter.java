package in.etuwa.app.ui.semregistration.sjcetpalai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.semregistration.list.RegisterList;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PalaiSemesterRegAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PalaiSemesterRegAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private RegListCallBack listener;
    private final ArrayList<RegisterList> regList = new ArrayList<>();

    /* JADX INFO: compiled from: PalaiSemesterRegAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegAdapter$RegListCallBack;", "", "onEditClick", "", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RegListCallBack {
        void onEditClick(String id);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sem_reg_palai, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …reg_palai, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.regList.size() > 0) {
            return this.regList.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.regList.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: PalaiSemesterRegAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegAdapter;Landroid/view/View;)V", "appliedFor", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "card", "date", NotificationCompat.CATEGORY_STATUS, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView appliedFor;
        private final TextView card;
        private final TextView date;
        private final TextView status;
        final /* synthetic */ PalaiSemesterRegAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PalaiSemesterRegAdapter palaiSemesterRegAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = palaiSemesterRegAdapter;
            this.card = (TextView) itemView.findViewById(R.id.view_btn);
            this.appliedFor = (TextView) itemView.findViewById(R.id.applied_from);
            this.status = (TextView) itemView.findViewById(R.id.sem_status);
            this.date = (TextView) itemView.findViewById(R.id.sem_date);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.regList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "regList[position]");
                final RegisterList registerList = (RegisterList) obj;
                this.appliedFor.setText(registerList.getSemesterAppliedFrom());
                this.status.setText(registerList.getStatus());
                this.date.setText(registerList.getDate());
                TextView textView = this.card;
                final PalaiSemesterRegAdapter palaiSemesterRegAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PalaiSemesterRegAdapter.ViewHolder.onBind$lambda$0(palaiSemesterRegAdapter, registerList, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(PalaiSemesterRegAdapter this$0, RegisterList list, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "$list");
            RegListCallBack regListCallBack = this$0.listener;
            if (regListCallBack != null) {
                regListCallBack.onEditClick(list.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<RegisterList> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.regList.clear();
        this.regList.addAll(list);
        notifyDataSetChanged();
    }

    public final void setRegListCallBack(PalaiSemesterRegFragment context) {
        this.listener = context;
    }
}