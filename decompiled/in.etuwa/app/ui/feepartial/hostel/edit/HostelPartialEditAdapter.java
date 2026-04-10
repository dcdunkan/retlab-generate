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
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
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

/* JADX INFO: compiled from: HostelPartialEditAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HostelPartialEditAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private boolean isUpdating;
    private CallBack listener;
    private final ArrayList<HostelPartialPayment> hostel = new ArrayList<>();
    private int count = -1;

    /* JADX INFO: compiled from: HostelPartialEditAdapter.kt */
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
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hostel_fees, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …stel_fees, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hostel.size() > 0) {
            return this.hostel.size();
        }
        return 1;
    }

    /* JADX INFO: compiled from: HostelPartialEditAdapter.kt */
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
                        return HostelPartialEditAdapter.ViewHolder.onBind$lambda$0(charSequence, i, i2, spanned, i3, i4);
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
                        if (hostelPartialEditAdapter.isUpdating) {
                            return;
                        }
                        hostelPartialEditAdapter.isUpdating = true;
                        String string = s != null ? s.toString() : null;
                        if (Intrinsics.areEqual(string, "")) {
                            hostelPartialPayment.setPayable(0);
                            this.payable.setText("0");
                        } else {
                            Intrinsics.checkNotNull(string);
                            double d = Double.parseDouble(string);
                            if (d < hostelPartialPayment.getBalance()) {
                                hostelPartialPayment.setPayable(Integer.parseInt(string));
                            } else {
                                if (!(d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                                    HostelPartialPayment hostelPartialPayment2 = hostelPartialPayment;
                                    hostelPartialPayment2.setPayable(hostelPartialPayment2.getBalance());
                                    this.payable.setText(hostelPartialPayment.getBalance());
                                }
                            }
                        }
                        HostelPartialEditAdapter.CallBack callBack = hostelPartialEditAdapter.listener;
                        if (callBack != null) {
                            callBack.calculateTotal();
                        }
                        hostelPartialEditAdapter.isUpdating = false;
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