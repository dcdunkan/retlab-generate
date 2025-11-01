package in.etuwa.app.ui.feepartial.kmea;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.feepartial.InstallmentDetails;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.feepartial.kmea.FeeListAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeListAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0016\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0018J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u0016J\u0010\u0010$\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010%R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", "isUpdating", "", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feepartial/InstallmentDetails;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter$CallBack;", FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()D", "setTotal", "(D)V", "addItems", "", "_list", "_context", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "getItems", "", "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "Lin/etuwa/app/ui/feepartial/kmea/FeeListFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private boolean isUpdating;
    private final ArrayList<InstallmentDetails> list = new ArrayList<>();
    private CallBack listener;
    private double total;

    /* compiled from: FeeListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter$CallBack;", "", "calculateTotal", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void calculateTotal();

        void error();
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_fee_partial, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …e_partial, parent, false)");
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

    /* compiled from: FeeListAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/feepartial/kmea/FeeListAdapter;Landroid/view/View;)V", "feeAmount", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "feeBalance", "feeDiscount", "feeHead", "feePaid", "feePaying", "Landroid/widget/EditText;", "feeScholarship", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView feeAmount;
        private final TextView feeBalance;
        private final TextView feeDiscount;
        private final TextView feeHead;
        private final TextView feePaid;
        private final EditText feePaying;
        private final TextView feeScholarship;
        final /* synthetic */ FeeListAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(FeeListAdapter feeListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = feeListAdapter;
            this.feeHead = (TextView) itemView.findViewById(R.id.engnr_fee_name);
            this.feeAmount = (TextView) itemView.findViewById(R.id.engnr_amount_lbl);
            this.feeScholarship = (TextView) itemView.findViewById(R.id.engnr_scholorship_lbl);
            this.feeDiscount = (TextView) itemView.findViewById(R.id.engnr_discount_lbl);
            this.feePaid = (TextView) itemView.findViewById(R.id.engnr_paid_lbl);
            this.feeBalance = (TextView) itemView.findViewById(R.id.engnr_balance_lbl);
            this.feePaying = (EditText) itemView.findViewById(R.id.engnr_paying_lbl);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final InstallmentDetails installmentDetails = (InstallmentDetails) obj;
                this.feeHead.setText(installmentDetails.getFeehead());
                this.feeAmount.setText(installmentDetails.getFees());
                this.feeScholarship.setText(installmentDetails.getScholarship());
                this.feeDiscount.setText(installmentDetails.getDiscount());
                this.feePaid.setText(installmentDetails.getPaid());
                this.feeBalance.setText(installmentDetails.getBalance());
                this.feePaying.setText(installmentDetails.getEditable_bal());
                this.feePaying.setFilters(new InputFilter[]{new InputFilter() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.text.InputFilter
                    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                        CharSequence onBind$lambda$0;
                        onBind$lambda$0 = FeeListAdapter.ViewHolder.onBind$lambda$0(charSequence, i, i2, spanned, i3, i4);
                        return onBind$lambda$0;
                    }
                }});
                EditText editText = this.feePaying;
                final FeeListAdapter feeListAdapter = this.this$0;
                editText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.feepartial.kmea.FeeListAdapter$ViewHolder$onBind$1
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        boolean z;
                        EditText editText2;
                        FeeListAdapter.CallBack callBack;
                        FeeListAdapter.CallBack callBack2;
                        EditText editText3;
                        z = FeeListAdapter.this.isUpdating;
                        if (z) {
                            return;
                        }
                        FeeListAdapter.this.isUpdating = true;
                        String obj2 = s != null ? s.toString() : null;
                        if (Intrinsics.areEqual(obj2, "")) {
                            installmentDetails.setEditable_bal("0");
                            editText3 = this.feePaying;
                            editText3.setText("0");
                        } else {
                            Intrinsics.checkNotNull(obj2);
                            double parseDouble = Double.parseDouble(obj2);
                            if (parseDouble < Double.parseDouble(installmentDetails.getBalance())) {
                                installmentDetails.setEditable_bal(obj2);
                            } else {
                                if (parseDouble == 0.0d) {
                                    callBack = FeeListAdapter.this.listener;
                                    Intrinsics.checkNotNull(callBack);
                                    callBack.error();
                                } else {
                                    InstallmentDetails installmentDetails2 = installmentDetails;
                                    installmentDetails2.setEditable_bal(installmentDetails2.getBalance());
                                    editText2 = this.feePaying;
                                    editText2.setText(installmentDetails.getBalance());
                                }
                            }
                        }
                        callBack2 = FeeListAdapter.this.listener;
                        if (callBack2 != null) {
                            callBack2.calculateTotal();
                        }
                        FeeListAdapter.this.isUpdating = false;
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

    public final void setCallBack(FeeListFragment context) {
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

    public final void addItems(ArrayList<InstallmentDetails> _list, Context _context) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        Intrinsics.checkNotNullParameter(_context, "_context");
        this.total = 0.0d;
        this.list.clear();
        this.list.addAll(_list);
        this.context = _context;
        notifyDataSetChanged();
    }

    public final List<InstallmentDetails> getItems() {
        return this.list;
    }
}