package in.etuwa.app.ui.stationary.bookinghistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.stationary.StationaryReceipt;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BookingHistoryAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/ui/stationary/bookinghistory/BookingHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "item", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/stationary/StationaryReceipt;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/stationary/bookinghistory/BookingHistoryAdapter$StationaryListener;", "addItems", "", "list", "clearItems", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setStationaryCallBack", "context", "Lin/etuwa/app/ui/stationary/bookinghistory/BookingHistoryFragment;", "StationaryListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BookingHistoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<StationaryReceipt> item = new ArrayList<>();
    private StationaryListener listener;

    /* compiled from: BookingHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/stationary/bookinghistory/BookingHistoryAdapter$StationaryListener;", "", "onPrintBtnClicked", "", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StationaryListener {
        void onPrintBtnClicked(String url);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_booking_receipt, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …g_receipt, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.item.size() > 0) {
            return this.item.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.item.isEmpty() ? 1 : 0;
    }

    /* compiled from: BookingHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/stationary/bookinghistory/BookingHistoryAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/stationary/bookinghistory/BookingHistoryAdapter;Landroid/view/View;)V", "createDate", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "paymentMethod", "printReceiptBtn", "processedBy", "receiptDate", "receiptNo", NotificationCompat.CATEGORY_STATUS, FeeConfirmDialogKt.ARG_TOTAL, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView createDate;
        private final TextView paymentMethod;
        private final TextView printReceiptBtn;
        private final TextView processedBy;
        private final TextView receiptDate;
        private final TextView receiptNo;
        private final TextView status;
        final /* synthetic */ BookingHistoryAdapter this$0;
        private final TextView total;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BookingHistoryAdapter bookingHistoryAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = bookingHistoryAdapter;
            this.receiptNo = (TextView) itemView.findViewById(R.id.tv_receipt_no);
            this.total = (TextView) itemView.findViewById(R.id.tv_total);
            this.paymentMethod = (TextView) itemView.findViewById(R.id.tv_payment_method);
            this.receiptDate = (TextView) itemView.findViewById(R.id.tv_receipt_date);
            this.status = (TextView) itemView.findViewById(R.id.tv_status);
            this.processedBy = (TextView) itemView.findViewById(R.id.tv_processed_by);
            this.createDate = (TextView) itemView.findViewById(R.id.tv_create_date);
            this.printReceiptBtn = (TextView) itemView.findViewById(R.id.pre_book_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.item.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "item[position]");
                final StationaryReceipt stationaryReceipt = (StationaryReceipt) obj;
                this.receiptDate.setText(stationaryReceipt.getReceipt_date());
                this.total.setText(stationaryReceipt.getTotal_amount());
                this.paymentMethod.setText(stationaryReceipt.getMethod());
                this.status.setText(stationaryReceipt.getStatus());
                this.receiptNo.setText(stationaryReceipt.getReceipt_no());
                this.processedBy.setText(stationaryReceipt.getCreated_user());
                this.createDate.setText(stationaryReceipt.getCreate_time());
                TextView textView = this.printReceiptBtn;
                final BookingHistoryAdapter bookingHistoryAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookingHistoryAdapter.ViewHolder.onBind$lambda$0(BookingHistoryAdapter.this, stationaryReceipt, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(BookingHistoryAdapter this$0, StationaryReceipt item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            StationaryListener stationaryListener = this$0.listener;
            if (stationaryListener != null) {
                stationaryListener.onPrintBtnClicked(item.getPrint_url());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<StationaryReceipt> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.item.clear();
        this.item.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.item.clear();
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setStationaryCallBack(BookingHistoryFragment context) {
        this.listener = context;
    }
}