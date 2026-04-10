package in.etuwa.app.ui.feenewengineer.payment.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerInstallment;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FeeDetailAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeeDetailAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private final ArrayList<FeeEngineerInstallment> fee = new ArrayList<>();
    private int count = -1;
    private String baseUrl = "";

    /* JADX INFO: compiled from: FeeDetailAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailAdapter$CallBack;", "", "selectedIds", "", HostelFeeConfirmFragmentKt.ARG_MONTHS, "Ljava/util/HashMap;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void selectedIds(HashMap<String, String> months);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final void setBaseUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_fee_detail, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …ee_detail, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fee.size() > 0) {
            return this.fee.size();
        }
        return 1;
    }

    /* JADX INFO: compiled from: FeeDetailAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/feenewengineer/payment/dialog/FeeDetailAdapter;Landroid/view/View;)V", ExamSubjectDetailDialogKt.ARG_AMOUNT, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "balance", FirebaseAnalytics.Param.DISCOUNT, "discountLyt", "Landroid/widget/LinearLayout;", "name", "paid", "scholarship", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView amount;
        private final TextView balance;
        private final TextView discount;
        private final LinearLayout discountLyt;
        private final TextView name;
        private final TextView paid;
        private final TextView scholarship;
        final /* synthetic */ FeeDetailAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(FeeDetailAdapter feeDetailAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = feeDetailAdapter;
            this.name = (TextView) itemView.findViewById(R.id.engnr_fee_name);
            this.amount = (TextView) itemView.findViewById(R.id.engnr_amount_lbl);
            this.scholarship = (TextView) itemView.findViewById(R.id.engnr_scholorship_lbl);
            this.paid = (TextView) itemView.findViewById(R.id.engnr_paid_lbl);
            this.balance = (TextView) itemView.findViewById(R.id.engnr_balance_lbl);
            this.discount = (TextView) itemView.findViewById(R.id.engnr_discount_lbl);
            this.discountLyt = (LinearLayout) itemView.findViewById(R.id.discount_lyt);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            LinearLayout linearLayout;
            super.onBind(position);
            try {
                Object obj = this.this$0.fee.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "fee[position]");
                FeeEngineerInstallment feeEngineerInstallment = (FeeEngineerInstallment) obj;
                if (StringsKt.contains$default((CharSequence) this.this$0.getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) && (linearLayout = this.discountLyt) != null) {
                    linearLayout.setVisibility(8);
                }
                this.name.setText(feeEngineerInstallment.getFeehead());
                this.amount.setText(feeEngineerInstallment.getFees());
                this.scholarship.setText(feeEngineerInstallment.getScholarship());
                this.paid.setText(feeEngineerInstallment.getPaid());
                this.balance.setText(feeEngineerInstallment.getBalance());
                this.discount.setText(feeEngineerInstallment.getDiscount());
            } catch (Exception unused) {
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

    public final void addItems(ArrayList<FeeEngineerInstallment> list, Integer pos, String baseUrl) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.fee.clear();
        this.fee.addAll(list);
        this.baseUrl = baseUrl;
        notifyDataSetChanged();
    }

    public final void setCallBack(FeeDetailDialog context) {
        this.listener = context;
    }
}