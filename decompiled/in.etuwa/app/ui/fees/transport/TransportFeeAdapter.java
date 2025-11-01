package in.etuwa.app.ui.fees.transport;

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
import in.etuwa.app.data.model.transport.TransportInstallments;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.fees.transport.TransportFeeAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransportFeeAdapter.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0007J\b\u0010\u0017\u001a\u00020\u0015H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006'"}, d2 = {"Lin/etuwa/app/ui/fees/transport/TransportFeeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/transport/TransportInstallments;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/fees/transport/TransportFeeAdapter$CallBack;", "selected", "", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", "selectedTotal", "getSelectedTotal", "setSelectedTotal", "addItems", "", "_list", "clearData", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/fees/transport/TransportFeeFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransportFeeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private final ArrayList<TransportInstallments> list = new ArrayList<>();
    private List<String> selected = new ArrayList();
    private List<String> selectedTotal = new ArrayList();

    /* compiled from: TransportFeeAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/fees/transport/TransportFeeAdapter$CallBack;", "", "updateSelected", "", "sel", "", "", FeeConfirmDialogKt.ARG_TOTAL, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transport, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …transport, parent, false)");
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

    /* compiled from: TransportFeeAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/ui/fees/transport/TransportFeeAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/fees/transport/TransportFeeAdapter;Landroid/view/View;)V", "adjustment", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", ExamSubjectDetailDialogKt.ARG_AMOUNT, "balance", "checkBox", "Landroid/widget/CheckBox;", "paid", "particular", "particularPaid", NotificationCompat.CATEGORY_STATUS, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private TextView adjustment;
        private TextView amount;
        private TextView balance;
        private CheckBox checkBox;
        private TextView paid;
        private TextView particular;
        private TextView particularPaid;
        private TextView status;
        final /* synthetic */ TransportFeeAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TransportFeeAdapter transportFeeAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = transportFeeAdapter;
            this.particular = (TextView) itemView.findViewById(R.id.transport_particular_tv);
            this.particularPaid = (TextView) itemView.findViewById(R.id.transport_particular_tv_paid);
            this.checkBox = (CheckBox) itemView.findViewById(R.id.fee_transport_check_box);
            this.balance = (TextView) itemView.findViewById(R.id.transport_balance_tv);
            this.amount = (TextView) itemView.findViewById(R.id.transport_amount_tv);
            this.adjustment = (TextView) itemView.findViewById(R.id.transport_adjustment_tv);
            this.paid = (TextView) itemView.findViewById(R.id.transport_paid_tv);
            this.status = (TextView) itemView.findViewById(R.id.transport_status_tv);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final TransportInstallments transportInstallments = (TransportInstallments) obj;
                this.particular.setText(transportInstallments.getParticular());
                this.particularPaid.setText(transportInstallments.getParticular());
                this.balance.setText(String.valueOf(transportInstallments.getBalance()));
                this.amount.setText(transportInstallments.getAmount());
                this.adjustment.setText(transportInstallments.getAdjustment());
                this.paid.setText(transportInstallments.getPaid());
                this.this$0.getSelected().add(position, "false");
                this.this$0.getSelectedTotal().add(position, "0");
                if (transportInstallments.getBalance() == 0) {
                    this.checkBox.setVisibility(8);
                    this.particular.setVisibility(8);
                    this.particularPaid.setVisibility(0);
                } else {
                    this.checkBox.setVisibility(0);
                    this.particular.setVisibility(0);
                    this.particularPaid.setVisibility(8);
                }
                if (transportInstallments.getFullpaid()) {
                    this.status.setText("Paid");
                } else {
                    this.status.setText("Not Paid");
                }
                CheckBox checkBox = this.checkBox;
                if (checkBox != null) {
                    final TransportFeeAdapter transportFeeAdapter = this.this$0;
                    checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TransportFeeAdapter.ViewHolder.onBind$lambda$0(TransportFeeAdapter.ViewHolder.this, transportFeeAdapter, position, transportInstallments, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, TransportFeeAdapter this$1, int i, TransportInstallments fee, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(fee, "$fee");
            if (this$0.checkBox.isChecked()) {
                this$1.getSelected().set(i, "true");
                this$1.getSelectedTotal().set(i, String.valueOf(fee.getBalance()));
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
                    return;
                }
                return;
            }
            this$1.getSelected().set(i, "false");
            this$1.getSelectedTotal().set(i, "0");
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
            }
        }
    }

    public final void setCallBack(TransportFeeFragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<TransportInstallments> _list) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        this.selected.clear();
        this.selectedTotal.clear();
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.list.clear();
        notifyDataSetChanged();
    }
}