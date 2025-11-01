package in.etuwa.app.ui.hostel.tkmhostel.receipt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.receipt.HostelReceipt;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TkmReceiptAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/receipt/TkmReceiptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/receipt/HostelReceipt;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/tkmhostel/receipt/TkmReceiptAdapter$CallBack;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/hostel/tkmhostel/receipt/TkmReceiptFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TkmReceiptAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<HostelReceipt> hostel = new ArrayList<>();
    private CallBack listener;

    /* compiled from: TkmReceiptAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/receipt/TkmReceiptAdapter$CallBack;", "", "receiptDownload", "", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void receiptDownload(String url);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hostel_receipt, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …l_receipt, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hostel.size() > 0) {
            return this.hostel.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.hostel.isEmpty() ? 1 : 0;
    }

    /* compiled from: TkmReceiptAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/hostel/tkmhostel/receipt/TkmReceiptAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostel/tkmhostel/receipt/TkmReceiptAdapter;Landroid/view/View;)V", "hostelName", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "receiptAmount", "receiptDate", "receiptDownload", "receiptInstallment", "receiptNo", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView hostelName;
        private final TextView receiptAmount;
        private final TextView receiptDate;
        private final TextView receiptDownload;
        private final TextView receiptInstallment;
        private final TextView receiptNo;
        final /* synthetic */ TkmReceiptAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TkmReceiptAdapter tkmReceiptAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = tkmReceiptAdapter;
            this.receiptNo = (TextView) itemView.findViewById(R.id.hostel_receipt_no);
            this.receiptInstallment = (TextView) itemView.findViewById(R.id.receipt_installment);
            this.receiptAmount = (TextView) itemView.findViewById(R.id.hostel_receipt_amount);
            this.receiptDate = (TextView) itemView.findViewById(R.id.hostel_receipt_date);
            this.hostelName = (TextView) itemView.findViewById(R.id.hostel_name);
            this.receiptDownload = (TextView) itemView.findViewById(R.id.receipt_download);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.hostel.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "hostel[position]");
                final HostelReceipt hostelReceipt = (HostelReceipt) obj;
                this.receiptNo.setText(hostelReceipt.getFeeReceiptNo());
                this.receiptInstallment.setText(hostelReceipt.getInstallment());
                this.receiptAmount.setText(hostelReceipt.getAmount());
                this.receiptDate.setText(hostelReceipt.getReceipt_date());
                this.hostelName.setText(hostelReceipt.getHostel());
                TextView textView = this.receiptDownload;
                final TkmReceiptAdapter tkmReceiptAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TkmReceiptAdapter.ViewHolder.onBind$lambda$0(TkmReceiptAdapter.this, hostelReceipt, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(TkmReceiptAdapter this$0, HostelReceipt hostel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(hostel, "$hostel");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.receiptDownload(hostel.getReceipt_url());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void addItems(ArrayList<HostelReceipt> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.hostel.clear();
        this.hostel.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(TkmReceiptFragment context) {
        this.listener = context;
    }
}