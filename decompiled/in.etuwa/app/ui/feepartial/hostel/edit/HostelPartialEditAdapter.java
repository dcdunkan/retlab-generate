package in.etuwa.app.ui.feepartial.hostel.edit;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPartialEditAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialPayment;", "Lkotlin/collections/ArrayList;", "isUpdating", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter$CallBack;", "addItems", "", "list", "getItemCount", "getItemViewType", CommonCssConstants.POSITION, "getItems", "", "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditDialog;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HostelPartialEditAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private boolean isUpdating;
    private CallBack listener;
    private final ArrayList<HostelPartialPayment> hostel = new ArrayList<>();
    private int count = -1;

    /* compiled from: HostelPartialEditAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter$CallBack;", "", "calculateTotal", "", "editClicked", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void calculateTotal();

        void editClicked();
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hostel_fees, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …stel_fees, parent, false)");
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

    /* compiled from: HostelPartialEditAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter;Landroid/view/View;)V", ExamSubjectDetailDialogKt.ARG_AMOUNT, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "balance", "layout", "Landroid/widget/LinearLayout;", "name", "paid", "payable", "scholarship", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView amount;
        private final TextView balance;
        private final LinearLayout layout;
        private final TextView name;
        private final TextView paid;
        private final TextView payable;
        private final TextView scholarship;
        final /* synthetic */ HostelPartialEditAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HostelPartialEditAdapter hostelPartialEditAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = hostelPartialEditAdapter;
            this.name = (TextView) itemView.findViewById(R.id.hostel_fee_name);
            this.amount = (TextView) itemView.findViewById(R.id.amount_lbl);
            this.scholarship = (TextView) itemView.findViewById(R.id.scholorship_lbl);
            this.paid = (TextView) itemView.findViewById(R.id.paid_lbl);
            this.balance = (TextView) itemView.findViewById(R.id.balance_lbl);
            this.payable = (TextView) itemView.findViewById(R.id.payable_lbl);
            this.layout = (LinearLayout) itemView.findViewById(R.id.linearHostel);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.hostel.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "hostel[position]");
                final HostelPartialPayment hostelPartialPayment = (HostelPartialPayment) obj;
                this.name.setText(hostelPartialPayment.getName());
                this.amount.setText(hostelPartialPayment.getAmount());
                this.scholarship.setText(String.valueOf(hostelPartialPayment.getScholarship()));
                this.paid.setText(String.valueOf(hostelPartialPayment.getPaid()));
                this.balance.setText(String.valueOf(hostelPartialPayment.getBalance()));
                this.payable.setText(String.valueOf(hostelPartialPayment.getPayable()));
                this.payable.setFilters(new InputFilter[]{new InputFilter() { // from class: in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.text.InputFilter
                    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                        CharSequence onBind$lambda$0;
                        onBind$lambda$0 = HostelPartialEditAdapter.ViewHolder.onBind$lambda$0(charSequence, i, i2, spanned, i3, i4);
                        return onBind$lambda$0;
                    }
                }});
                TextView textView = this.payable;
                final HostelPartialEditAdapter hostelPartialEditAdapter = this.this$0;
                textView.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter$ViewHolder$onBind$1
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        boolean z;
                        TextView textView2;
                        HostelPartialEditAdapter.CallBack callBack;
                        TextView textView3;
                        z = HostelPartialEditAdapter.this.isUpdating;
                        if (z) {
                            return;
                        }
                        HostelPartialEditAdapter.this.isUpdating = true;
                        String obj2 = s != null ? s.toString() : null;
                        if (Intrinsics.areEqual(obj2, "")) {
                            hostelPartialPayment.setPayable(0);
                            textView3 = this.payable;
                            textView3.setText("0");
                        } else {
                            Intrinsics.checkNotNull(obj2);
                            double parseDouble = Double.parseDouble(obj2);
                            if (parseDouble < hostelPartialPayment.getBalance()) {
                                hostelPartialPayment.setPayable(Integer.parseInt(obj2));
                            } else {
                                if (!(parseDouble == 0.0d)) {
                                    HostelPartialPayment hostelPartialPayment2 = hostelPartialPayment;
                                    hostelPartialPayment2.setPayable(hostelPartialPayment2.getBalance());
                                    textView2 = this.payable;
                                    textView2.setText(hostelPartialPayment.getBalance());
                                }
                            }
                        }
                        callBack = HostelPartialEditAdapter.this.listener;
                        if (callBack != null) {
                            callBack.calculateTotal();
                        }
                        HostelPartialEditAdapter.this.isUpdating = false;
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence onBind$lambda$0(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            while (i < i2) {
                if (!Character.isDigit(charSequence.charAt(i))) {
                    return "";
                }
                i++;
            }
            return null;
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

    public final void addItems(ArrayList<HostelPartialPayment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.hostel.clear();
        this.hostel.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(HostelPartialEditDialog context) {
        this.listener = context;
    }

    public final List<HostelPartialPayment> getItems() {
        return this.hostel;
    }
}