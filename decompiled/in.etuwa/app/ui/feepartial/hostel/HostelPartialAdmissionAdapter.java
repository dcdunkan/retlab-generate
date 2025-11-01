package in.etuwa.app.ui.feepartial.hostel;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.HostelMonth;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.feepartial.hostel.HostelPartialAdmissionAdapter;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPartialAdmissionAdapter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002EFB\u0005¢\u0006\u0002\u0010\u0003J \u00104\u001a\u0002052\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0018j\b\u0012\u0004\u0012\u00020\u001c`\u001aH\u0007J\b\u00107\u001a\u00020\u0005H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0016J\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0018j\b\u0012\u0004\u0012\u00020\u001c`\u001aJ\u000e\u0010;\u001a\u0002052\u0006\u00109\u001a\u00020\u0005J\u0018\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0005H\u0016J\u0018\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0005H\u0016J\u0010\u0010B\u001a\u0002052\b\u0010C\u001a\u0004\u0018\u00010DR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0018j\b\u0012\u0004\u0012\u00020\u001c`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R \u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001e\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006G"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/HostelPartialAdmissionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "bal", "", "getBal", "()I", "setBal", "(I)V", SvgConstants.Attributes.PATH_DATA_REL_CURVE_TO, "getC", "setC", "count", "getCount", "setCount", "deatilPosition", "", "", "getDeatilPosition", "()Ljava/util/List;", "setDeatilPosition", "(Ljava/util/List;)V", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/HostelMonth;", "Lkotlin/collections/ArrayList;", "hostelnew", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialPayment;", "isUpdating", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/feepartial/hostel/HostelPartialAdmissionAdapter$CallBack;", HostelFeeConfirmFragmentKt.ARG_MONTHS, "", "getMonths", "()[I", "selected", "getSelected", "setSelected", "selectedTotal", "getSelectedTotal", "setSelectedTotal", FeeConfirmDialogKt.ARG_TOTAL, "getTotal", "setTotal", "type", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "addAdmsnItems", "", "list", "getItemCount", "getItemViewType", CommonCssConstants.POSITION, "getItems", "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/feepartial/hostel/HostelPartialPayment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HostelPartialAdmissionAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private int bal;
    private int c;
    private boolean isUpdating;
    private CallBack listener;
    private int total;
    private Integer type;
    private final ArrayList<HostelMonth> hostel = new ArrayList<>();
    private final ArrayList<in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment> hostelnew = new ArrayList<>();
    private final int[] months = new int[12];
    private int count = -1;
    private List<String> selected = new ArrayList();
    private List<String> selectedTotal = new ArrayList();
    private List<String> deatilPosition = new ArrayList();

    /* compiled from: HostelPartialAdmissionAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J$\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¨\u0006\u0010"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/HostelPartialAdmissionAdapter$CallBack;", "", "calculateTotal", "", "checkBoxClicked", "editBalance", CommonCssConstants.POSITION, "", "kmeaFees", "selectedIds", "type", "updateSelected", "sel", "", "", FeeConfirmDialogKt.ARG_TOTAL, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void calculateTotal();

        void checkBoxClicked();

        void editBalance(int position);

        void kmeaFees(int position);

        void selectedIds(int position, int type);

        void updateSelected(List<String> sel, List<String> total);
    }

    public final int[] getMonths() {
        return this.months;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final int getC() {
        return this.c;
    }

    public final void setC(int i) {
        this.c = i;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final int getBal() {
        return this.bal;
    }

    public final void setBal(int i) {
        this.bal = i;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hostel_partial_monthly, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …l_monthly, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hostelnew.size() > 0) {
            return this.hostelnew.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.hostelnew.isEmpty() ? 1 : 0;
    }

    /* compiled from: HostelPartialAdmissionAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/HostelPartialAdmissionAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/feepartial/hostel/HostelPartialAdmissionAdapter;Landroid/view/View;)V", ExamSubjectDetailDialogKt.ARG_AMOUNT, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "balance", "checkBox", "Landroid/widget/CheckBox;", "month", "paid", "payable", "Landroid/widget/EditText;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView amount;
        private final TextView balance;
        private final CheckBox checkBox;
        private final TextView month;
        private final TextView paid;
        private final EditText payable;
        final /* synthetic */ HostelPartialAdmissionAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HostelPartialAdmissionAdapter hostelPartialAdmissionAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = hostelPartialAdmissionAdapter;
            this.month = (TextView) itemView.findViewById(R.id.hostel_installment);
            this.amount = (TextView) itemView.findViewById(R.id.hostel_main_amount);
            this.paid = (TextView) itemView.findViewById(R.id.hostel_main_paid);
            this.balance = (TextView) itemView.findViewById(R.id.hostel_main_balance);
            this.payable = (EditText) itemView.findViewById(R.id.hostel_main_payable);
            this.checkBox = (CheckBox) itemView.findViewById(R.id.installment_check);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.hostelnew.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "hostelnew[position]");
                final in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment hostelPartialPayment = (in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment) obj;
                this.month.setText(hostelPartialPayment.getName());
                this.amount.setText(hostelPartialPayment.getAmount());
                this.paid.setText(String.valueOf(hostelPartialPayment.getPaid()));
                this.balance.setText(String.valueOf(hostelPartialPayment.getBalance()));
                this.payable.setText(String.valueOf(hostelPartialPayment.getPayable()));
                TextView textView = this.balance;
                final HostelPartialAdmissionAdapter hostelPartialAdmissionAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialAdmissionAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HostelPartialAdmissionAdapter.ViewHolder.onBind$lambda$0(HostelPartialAdmissionAdapter.this, position, view);
                    }
                });
                if (hostelPartialPayment.getBalance() > 0) {
                    this.checkBox.setVisibility(0);
                } else {
                    this.checkBox.setVisibility(8);
                }
                CheckBox checkBox = this.checkBox;
                final HostelPartialAdmissionAdapter hostelPartialAdmissionAdapter2 = this.this$0;
                checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialAdmissionAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HostelPartialAdmissionAdapter.ViewHolder.onBind$lambda$1(HostelPartialAdmissionAdapter.ViewHolder.this, hostelPartialAdmissionAdapter2, position, view);
                    }
                });
                this.payable.setFilters(new InputFilter[]{new InputFilter() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialAdmissionAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.text.InputFilter
                    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                        CharSequence onBind$lambda$2;
                        onBind$lambda$2 = HostelPartialAdmissionAdapter.ViewHolder.onBind$lambda$2(charSequence, i, i2, spanned, i3, i4);
                        return onBind$lambda$2;
                    }
                }});
                EditText editText = this.payable;
                final HostelPartialAdmissionAdapter hostelPartialAdmissionAdapter3 = this.this$0;
                editText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialAdmissionAdapter$ViewHolder$onBind$3
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
                        EditText editText3;
                        z = HostelPartialAdmissionAdapter.this.isUpdating;
                        if (z) {
                            return;
                        }
                        HostelPartialAdmissionAdapter.this.isUpdating = true;
                        String obj2 = s != null ? s.toString() : null;
                        if (Intrinsics.areEqual(obj2, "")) {
                            hostelPartialPayment.setPayable(0);
                            editText3 = this.payable;
                            editText3.setText("0");
                        } else {
                            Intrinsics.checkNotNull(obj2);
                            int parseInt = Integer.parseInt(obj2);
                            if (parseInt < hostelPartialPayment.getBalance()) {
                                hostelPartialPayment.setPayable(Integer.parseInt(obj2));
                            } else if (parseInt != 0) {
                                in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment hostelPartialPayment2 = hostelPartialPayment;
                                hostelPartialPayment2.setPayable(hostelPartialPayment2.getBalance());
                                editText2 = this.payable;
                                editText2.setText(hostelPartialPayment.getBalance());
                            }
                        }
                        HostelPartialAdmissionAdapter.CallBack callBack = HostelPartialAdmissionAdapter.this.listener;
                        if (callBack != null) {
                            callBack.calculateTotal();
                        }
                        HostelPartialAdmissionAdapter.this.isUpdating = false;
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(HostelPartialAdmissionAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.editBalance(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ViewHolder this$0, HostelPartialAdmissionAdapter this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!this$0.checkBox.isChecked()) {
                ((in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment) this$1.hostelnew.get(i)).set_selected(false);
                this$1.notifyDataSetChanged();
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.checkBoxClicked();
                    return;
                }
                return;
            }
            ((in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment) this$1.hostelnew.get(i)).set_selected(true);
            this$1.notifyDataSetChanged();
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.checkBoxClicked();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence onBind$lambda$2(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
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

    public final void addAdmsnItems(ArrayList<in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.total = 0;
        this.hostel.clear();
        this.selectedTotal.clear();
        this.selected.clear();
        this.hostelnew.clear();
        this.hostelnew.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(HostelPartialPayment context) {
        this.listener = context;
    }

    public final ArrayList<in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment> getItems() {
        return this.hostelnew;
    }
}