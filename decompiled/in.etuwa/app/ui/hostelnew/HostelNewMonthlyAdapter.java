package in.etuwa.app.ui.hostelnew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.HostelMonth;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmission;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthly;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewMonthlyAdapter.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002IJB\u0005¢\u0006\u0002\u0010\u0003J(\u00108\u001a\u0002092\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00172\u0006\u0010(\u001a\u00020)H\u0007J\b\u0010:\u001a\u00020\u0005H\u0016J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0016J\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017J\u000e\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u0005J\u0018\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u0005H\u0016J\u0018\u0010A\u001a\u00020\u00022\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0005H\u0016J\u0010\u0010E\u001a\u0002092\b\u0010F\u001a\u0004\u0018\u00010GJ\b\u0010H\u001a\u000209H\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0015j\b\u0012\u0004\u0012\u00020\u0019`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0015j\b\u0012\u0004\u0012\u00020\u001b`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R \u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR\u001e\u00102\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006K"}, d2 = {"Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", SvgConstants.Attributes.PATH_DATA_REL_CURVE_TO, "", "getC", "()I", "setC", "(I)V", "count", "getCount", "setCount", "deatilPosition", "", "", "getDeatilPosition", "()Ljava/util/List;", "setDeatilPosition", "(Ljava/util/List;)V", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostelnew/HostelNewMonthly;", "Lkotlin/collections/ArrayList;", "hostelnew", "Lin/etuwa/app/data/model/hostel/HostelPalaiAdmission;", "list", "Lin/etuwa/app/data/model/hostel/HostelMonth;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter$CallBack;", HostelFeeConfirmFragmentKt.ARG_MONTHS, "", "getMonths", "()[I", "selected", "getSelected", "setSelected", "selectedTotal", "getSelectedTotal", "setSelectedTotal", NotificationCompat.CATEGORY_STATUS, "", "getStatus", "()Ljava/lang/Boolean;", "setStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", FeeConfirmDialogKt.ARG_TOTAL, "getTotal", "setTotal", "type", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "addItems", "", "getItemCount", "getItemViewType", CommonCssConstants.POSITION, "getItems", "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/hostelnew/HostelNewFragment;", "unCheckFees", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelNewMonthlyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private int c;
    private CallBack listener;
    private Boolean status;
    private int total;
    private Integer type;
    private final ArrayList<HostelNewMonthly> hostel = new ArrayList<>();
    private final ArrayList<HostelPalaiAdmission> hostelnew = new ArrayList<>();
    private final ArrayList<HostelMonth> list = new ArrayList<>();
    private final int[] months = new int[12];
    private int count = -1;
    private List<String> selected = new ArrayList();
    private List<String> selectedTotal = new ArrayList();
    private List<String> deatilPosition = new ArrayList();

    /* compiled from: HostelNewMonthlyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter$CallBack;", "", "feeClickedMonthly", "", "viewMonthlyBtnClicked", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void feeClickedMonthly();

        void viewMonthlyBtnClicked(int position);
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

    public final Boolean getStatus() {
        return this.status;
    }

    public final void setStatus(Boolean bool) {
        this.status = bool;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hostel_new_admission, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …admission, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hostel.size() <= 0) {
            return 1;
        }
        int size = this.hostel.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                this.selected.add(i, "false");
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        return this.hostel.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return ((this.hostel.isEmpty() ^ true) || (this.hostelnew.isEmpty() ^ true)) ? 1 : 0;
    }

    /* compiled from: HostelNewMonthlyAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter;Landroid/view/View;)V", ExamSubjectDetailDialogKt.ARG_AMOUNT, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "balance", "checkBox", "Landroid/widget/CheckBox;", "detailBtn", "lateFee", "month", "paid", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView amount;
        private final TextView balance;
        private final CheckBox checkBox;
        private final TextView detailBtn;
        private final TextView lateFee;
        private final TextView month;
        private final TextView paid;
        final /* synthetic */ HostelNewMonthlyAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HostelNewMonthlyAdapter hostelNewMonthlyAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = hostelNewMonthlyAdapter;
            this.month = (TextView) itemView.findViewById(R.id.hostel_installment);
            this.amount = (TextView) itemView.findViewById(R.id.hostel_main_amount);
            this.paid = (TextView) itemView.findViewById(R.id.hostel_main_paid);
            this.balance = (TextView) itemView.findViewById(R.id.hostel_main_balance);
            this.lateFee = (TextView) itemView.findViewById(R.id.hostel_late_fee);
            this.detailBtn = (TextView) itemView.findViewById(R.id.hostel_fee_detail);
            this.checkBox = (CheckBox) itemView.findViewById(R.id.installment_check);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.hostel.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "hostel[position]");
                final HostelNewMonthly hostelNewMonthly = (HostelNewMonthly) obj;
                this.this$0.getDeatilPosition().add(position, "notClicked");
                this.this$0.getSelectedTotal().add(position, "0");
                this.month.setText(hostelNewMonthly.getInstallment());
                this.amount.setText(String.valueOf(hostelNewMonthly.getAmount()));
                this.paid.setText(String.valueOf(hostelNewMonthly.getPaid()));
                this.lateFee.setText(String.valueOf(hostelNewMonthly.getFine()));
                this.balance.setText(String.valueOf(hostelNewMonthly.getFine() + hostelNewMonthly.getBalance()));
                this.checkBox.setChecked(hostelNewMonthly.is_selected());
                Boolean status = this.this$0.getStatus();
                Intrinsics.checkNotNull(status);
                if (status.booleanValue()) {
                    this.checkBox.setVisibility(8);
                    hostelNewMonthly.set_selected(true);
                    CallBack callBack = this.this$0.listener;
                    if (callBack != null) {
                        callBack.feeClickedMonthly();
                    }
                } else {
                    this.checkBox.setVisibility(0);
                }
                TextView textView = this.detailBtn;
                final HostelNewMonthlyAdapter hostelNewMonthlyAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HostelNewMonthlyAdapter.ViewHolder.onBind$lambda$0(HostelNewMonthlyAdapter.this, position, view);
                    }
                });
                CheckBox checkBox = this.checkBox;
                final HostelNewMonthlyAdapter hostelNewMonthlyAdapter2 = this.this$0;
                checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HostelNewMonthlyAdapter.ViewHolder.onBind$lambda$1(HostelNewMonthlyAdapter.ViewHolder.this, hostelNewMonthly, hostelNewMonthlyAdapter2, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(HostelNewMonthlyAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.viewMonthlyBtnClicked(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ViewHolder this$0, HostelNewMonthly hostel, HostelNewMonthlyAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(hostel, "$hostel");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.checkBox.isChecked()) {
                hostel.set_selected(true);
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.feeClickedMonthly();
                    return;
                }
                return;
            }
            hostel.set_selected(false);
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.feeClickedMonthly();
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

    public final void addItems(ArrayList<HostelNewMonthly> list, boolean status) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.total = 0;
        this.selectedTotal.clear();
        this.selected.clear();
        this.hostel.clear();
        this.hostelnew.clear();
        this.hostel.addAll(list);
        this.status = Boolean.valueOf(status);
        notifyDataSetChanged();
    }

    public final void setCallBack(HostelNewFragment context) {
        this.listener = context;
    }

    public final ArrayList<HostelNewMonthly> getItems() {
        return this.hostel;
    }

    public final void unCheckFees() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.addAll(this.hostel);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((HostelNewMonthly) arrayList.get(i)).set_selected(false);
        }
        this.hostel.clear();
        this.hostel.addAll(arrayList);
        notifyDataSetChanged();
    }
}