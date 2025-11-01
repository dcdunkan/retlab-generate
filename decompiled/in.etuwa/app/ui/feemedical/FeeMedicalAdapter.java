package in.etuwa.app.ui.feemedical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.feemedical.FeesMed;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.feemedical.FeeMedicalAdapter;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FeeMedicalAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010!\u001a\u00020\u0005J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020#J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020#H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#H\u0016J\u0010\u0010-\u001a\u00020\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010.R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00061"}, d2 = {"Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", "deatilPosition", "", "", "getDeatilPosition", "()Ljava/util/List;", "setDeatilPosition", "(Ljava/util/List;)V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feemedical/FeesMed;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter$CallBack;", "selected", "getSelected", "setSelected", "selectedTotal", "getSelectedTotal", "setSelectedTotal", FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()D", "setTotal", "(D)V", "addItems", "", "_list", "_context", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "Lin/etuwa/app/ui/feemedical/FeeMedicalFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeMedicalAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private CallBack listener;
    private double total;
    private final ArrayList<FeesMed> list = new ArrayList<>();
    private List<String> selected = new ArrayList();
    private List<String> selectedTotal = new ArrayList();
    private List<String> deatilPosition = new ArrayList();

    /* compiled from: FeeMedicalAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter$CallBack;", "", "selectedIds", "", CommonCssConstants.POSITION, "", "updateSelected", "sel", "", "", FeeConfirmDialogKt.ARG_TOTAL, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void selectedIds(int position);

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

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    public final List<String> getDeatilPosition() {
        return this.deatilPosition;
    }

    public final void setDeatilPosition(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.deatilPosition = list;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_fee_engineer, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_engineer, parent, false)");
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

    /* compiled from: FeeMedicalAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/feemedical/FeeMedicalAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "detailBtn", "Landroid/widget/TextView;", "feeAmount", "feeBalance", "feeHead", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final CheckBox checkBox;
        private final TextView detailBtn;
        private final TextView feeAmount;
        private final TextView feeBalance;
        private final TextView feeHead;
        final /* synthetic */ FeeMedicalAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(FeeMedicalAdapter feeMedicalAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = feeMedicalAdapter;
            this.feeHead = (TextView) itemView.findViewById(R.id.fee_engnr_head);
            this.feeAmount = (TextView) itemView.findViewById(R.id.fee_engnr_amt);
            this.checkBox = (CheckBox) itemView.findViewById(R.id.fee_engnr_check_box);
            this.feeBalance = (TextView) itemView.findViewById(R.id.fee_engnr_balance);
            this.detailBtn = (TextView) itemView.findViewById(R.id.engineer_detail_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                FeesMed feesMed = (FeesMed) obj;
                this.feeHead.setText(feesMed.getInstallment_name());
                final Ref.DoubleRef doubleRef = new Ref.DoubleRef();
                this.this$0.getDeatilPosition().add(position, "notClicked");
                this.this$0.getSelected().add(position, "false");
                this.this$0.getSelectedTotal().add(position, "0.00");
                int i = 0;
                if (feesMed.getInstallments().size() == 0) {
                    this.feeHead.setVisibility(8);
                    this.feeAmount.setVisibility(8);
                    this.checkBox.setVisibility(8);
                    this.feeBalance.setVisibility(8);
                    this.detailBtn.setVisibility(8);
                } else {
                    this.feeHead.setVisibility(0);
                    this.feeAmount.setVisibility(0);
                    this.checkBox.setVisibility(0);
                    this.feeBalance.setVisibility(0);
                    this.detailBtn.setVisibility(0);
                }
                int size = feesMed.getInstallments().size() - 1;
                double d = 0.0d;
                if (size >= 0) {
                    while (true) {
                        doubleRef.element += Double.parseDouble(feesMed.getInstallments().get(i).getBalance());
                        d += Double.parseDouble(feesMed.getInstallments().get(i).getFees());
                        Double.parseDouble(feesMed.getInstallments().get(i).getPaid());
                        Double.parseDouble(feesMed.getInstallments().get(i).getScholarship());
                        Double.parseDouble(feesMed.getInstallments().get(i).getDiscount());
                        if (i == size) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                this.feeAmount.setText(String.valueOf(d));
                this.feeBalance.setText(String.valueOf(doubleRef.element));
                this.this$0.setTotal(doubleRef.element);
                CheckBox checkBox = this.checkBox;
                final FeeMedicalAdapter feeMedicalAdapter = this.this$0;
                checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeeMedicalAdapter.ViewHolder.onBind$lambda$0(FeeMedicalAdapter.ViewHolder.this, doubleRef, feeMedicalAdapter, position, view);
                    }
                });
                TextView textView = this.detailBtn;
                final FeeMedicalAdapter feeMedicalAdapter2 = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feemedical.FeeMedicalAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeeMedicalAdapter.ViewHolder.onBind$lambda$1(FeeMedicalAdapter.this, position, view);
                    }
                });
                this.this$0.notifyDataChanged(position);
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, Ref.DoubleRef balance, FeeMedicalAdapter this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(balance, "$balance");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.checkBox.isChecked() && balance.element > 0.0d) {
                this$1.getSelected().set(i, "true");
                this$1.getSelectedTotal().set(i, this$0.feeBalance.getText().toString());
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
                    return;
                }
                return;
            }
            this$1.getSelected().set(i, "false");
            this$1.getSelectedTotal().set(i, "0.00");
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(FeeMedicalAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getDeatilPosition().set(i, "clicked");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.selectedIds(i);
            }
        }
    }

    public final void setCallBack(FeeMedicalFragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void addItems(ArrayList<FeesMed> _list, Context _context) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        Intrinsics.checkNotNullParameter(_context, "_context");
        this.total = 0.0d;
        this.selectedTotal.clear();
        this.selected.clear();
        this.list.clear();
        this.list.addAll(_list);
        this.context = _context;
        notifyDataSetChanged();
    }
}