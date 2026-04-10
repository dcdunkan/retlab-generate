package in.etuwa.app.ui.hostel.mess.orderhistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.mess.OrderHistory;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OrderHistoryAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class OrderHistoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private final ArrayList<OrderHistory> mess = new ArrayList<>();

    /* JADX INFO: compiled from: OrderHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/hostel/mess/orderhistory/OrderHistoryAdapter$CallBack;", "", "cancelBtnClicked", "", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void cancelBtnClicked(String id);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_order_history, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …r_history, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mess.size() > 0) {
            return this.mess.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.mess.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: OrderHistoryAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/hostel/mess/orderhistory/OrderHistoryAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostel/mess/orderhistory/OrderHistoryAdapter;Landroid/view/View;)V", "cancelBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "date", "messMenuOne", "Landroid/widget/LinearLayout;", "messMenuTwo", "name", "nameTwo", FirebaseAnalytics.Param.QUANTITY, NotificationCompat.CATEGORY_STATUS, "type", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView cancelBtn;
        private final TextView date;
        private final LinearLayout messMenuOne;
        private final LinearLayout messMenuTwo;
        private final TextView name;
        private final TextView nameTwo;
        private final TextView quantity;
        private final TextView status;
        final /* synthetic */ OrderHistoryAdapter this$0;
        private final TextView type;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(OrderHistoryAdapter orderHistoryAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = orderHistoryAdapter;
            this.name = (TextView) itemView.findViewById(R.id.mess_menu);
            this.cancelBtn = (TextView) itemView.findViewById(R.id.mess_delete_btn);
            this.quantity = (TextView) itemView.findViewById(R.id.mess_qty);
            this.date = (TextView) itemView.findViewById(R.id.mess_booking_date);
            this.type = (TextView) itemView.findViewById(R.id.mess_type);
            this.status = (TextView) itemView.findViewById(R.id.mess_status);
            this.messMenuOne = (LinearLayout) itemView.findViewById(R.id.mess_menu_1);
            this.messMenuTwo = (LinearLayout) itemView.findViewById(R.id.mess_menu2);
            this.nameTwo = (TextView) itemView.findViewById(R.id.mess_name2);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.mess.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "mess[position]");
                final OrderHistory orderHistory = (OrderHistory) obj;
                this.name.setText(orderHistory.getType());
                this.quantity.setText(orderHistory.getQuantity());
                this.date.setText(orderHistory.getBooking_date());
                this.type.setText(orderHistory.getMenu());
                this.status.setText(orderHistory.getStatus());
                this.nameTwo.setText(orderHistory.getType());
                if (StringsKt.contains$default((CharSequence) orderHistory.getStatus(), (CharSequence) "Booked", false, 2, (Object) null)) {
                    this.cancelBtn.setVisibility(0);
                    this.messMenuTwo.setVisibility(8);
                    this.messMenuOne.setVisibility(0);
                } else {
                    this.cancelBtn.setVisibility(8);
                    this.messMenuTwo.setVisibility(0);
                    this.messMenuOne.setVisibility(8);
                }
                TextView textView = this.cancelBtn;
                if (textView != null) {
                    final OrderHistoryAdapter orderHistoryAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OrderHistoryAdapter.ViewHolder.onBind$lambda$0(orderHistoryAdapter, orderHistory, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(OrderHistoryAdapter this$0, OrderHistory mess, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(mess, "$mess");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.cancelBtnClicked(mess.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<OrderHistory> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mess.clear();
        this.mess.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(OrderHistoryFragment context) {
        this.listener = context;
    }
}