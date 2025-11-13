package in.etuwa.app.ui.examregistration.examsubjects.register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.examregister.ExamCourse;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ExamRegisterAdapter.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00029:B\u0005¢\u0006\u0002\u0010\u0003J.\u0010(\u001a\u00020)2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010+\u001a\u00020#H\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020#H\u0016J\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u0018\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u00022\u0006\u0010-\u001a\u00020#H\u0016J\u0018\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020#H\u0016J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u000bH\u0007J\u0010\u00107\u001a\u00020)2\b\u0010\u0011\u001a\u0004\u0018\u000108R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006;"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "checkBoxStatus", "", "getCheckBoxStatus", "()Ljava/lang/Boolean;", "setCheckBoxStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/ExamCourse;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter$CallBack;", "selected", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", "selectedTotal", "getSelectedTotal", "setSelectedTotal", FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()I", "setTotal", "(I)V", "addItems", "", "_list", "getItemCount", "getItemViewType", CommonCssConstants.POSITION, "getItems", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAll", "check", "setCallBack", "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExamRegisterAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private String baseUrl;
    private Boolean checkBoxStatus;
    private Context context;
    private CallBack listener;
    private int total;
    private final ArrayList<ExamCourse> list = new ArrayList<>();
    private List<String> selected = new ArrayList();
    private List<String> selectedTotal = new ArrayList();

    /* compiled from: ExamRegisterAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter$CallBack;", "", "updateSelected", "", "sel", "", "", FeeConfirmDialogKt.ARG_TOTAL, "updateSelected2", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void updateSelected(List<String> sel, List<String> total);

        void updateSelected2(List<String> sel, List<String> total);
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

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public final Boolean getCheckBoxStatus() {
        return this.checkBoxStatus;
    }

    public final void setCheckBoxStatus(Boolean bool) {
        this.checkBoxStatus = bool;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exam_update, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …am_update, parent, false)");
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

    /* compiled from: ExamRegisterAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter;Landroid/view/View;)V", ExamSubjectDetailDialogKt.ARG_AMOUNT, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "checkBox", "Landroid/widget/CheckBox;", "concession", "statusLyt", "Landroid/widget/LinearLayout;", "subjectHead", "type", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView amount;
        private final CheckBox checkBox;
        private final TextView concession;
        private final LinearLayout statusLyt;
        private final TextView subjectHead;
        final /* synthetic */ ExamRegisterAdapter this$0;
        private final TextView type;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ExamRegisterAdapter examRegisterAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = examRegisterAdapter;
            this.subjectHead = (TextView) itemView.findViewById(R.id.exam_sub_head);
            this.type = (TextView) itemView.findViewById(R.id.exam_type);
            this.concession = (TextView) itemView.findViewById(R.id.exam_concession);
            this.amount = (TextView) itemView.findViewById(R.id.exam_amount);
            this.statusLyt = (LinearLayout) itemView.findViewById(R.id.status_lyt);
            this.checkBox = (CheckBox) itemView.findViewById(R.id.exam_check_box);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00cc A[Catch: Exception -> 0x00f3, TryCatch #0 {Exception -> 0x00f3, blocks: (B:3:0x0003, B:5:0x005f, B:7:0x0074, B:9:0x0089, B:12:0x009f, B:13:0x00bc, B:15:0x00cc, B:16:0x00d1, B:18:0x00e9, B:23:0x00ab), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00e9 A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #0 {Exception -> 0x00f3, blocks: (B:3:0x0003, B:5:0x005f, B:7:0x0074, B:9:0x0089, B:12:0x009f, B:13:0x00bc, B:15:0x00cc, B:16:0x00d1, B:18:0x00e9, B:23:0x00ab), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(final int r8) {
            /*
                r7 = this;
                super.onBind(r8)
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r0 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.util.ArrayList r0 = in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter.access$getList$p(r0)     // Catch: java.lang.Exception -> Lf3
                java.lang.Object r0 = r0.get(r8)     // Catch: java.lang.Exception -> Lf3
                java.lang.String r1 = "list[position]"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> Lf3
                in.etuwa.app.data.model.examregister.ExamCourse r0 = (in.etuwa.app.data.model.examregister.ExamCourse) r0     // Catch: java.lang.Exception -> Lf3
                android.widget.TextView r1 = r7.subjectHead     // Catch: java.lang.Exception -> Lf3
                java.lang.String r2 = r0.getCourse()     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> Lf3
                r1.setText(r2)     // Catch: java.lang.Exception -> Lf3
                android.widget.TextView r1 = r7.type     // Catch: java.lang.Exception -> Lf3
                java.lang.String r2 = r0.getType()     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> Lf3
                r1.setText(r2)     // Catch: java.lang.Exception -> Lf3
                android.widget.TextView r1 = r7.concession     // Catch: java.lang.Exception -> Lf3
                java.lang.String r2 = r0.is_eligible()     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> Lf3
                r1.setText(r2)     // Catch: java.lang.Exception -> Lf3
                android.widget.LinearLayout r1 = r7.statusLyt     // Catch: java.lang.Exception -> Lf3
                r2 = 8
                r1.setVisibility(r2)     // Catch: java.lang.Exception -> Lf3
                android.widget.TextView r1 = r7.amount     // Catch: java.lang.Exception -> Lf3
                java.lang.String r3 = r0.getAmount()     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> Lf3
                r1.setText(r3)     // Catch: java.lang.Exception -> Lf3
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.lang.String r1 = r1.getBaseUrl()     // Catch: java.lang.Exception -> Lf3
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> Lf3
                java.lang.String r3 = "sbce"
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> Lf3
                r4 = 0
                r5 = 2
                r6 = 0
                boolean r1 = kotlin.text.StringsKt.contains$default(r1, r3, r6, r5, r4)     // Catch: java.lang.Exception -> Lf3
                if (r1 != 0) goto Lab
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.lang.String r1 = r1.getBaseUrl()     // Catch: java.lang.Exception -> Lf3
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> Lf3
                java.lang.String r3 = "mvjce"
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> Lf3
                boolean r1 = kotlin.text.StringsKt.contains$default(r1, r3, r6, r5, r4)     // Catch: java.lang.Exception -> Lf3
                if (r1 != 0) goto Lab
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.lang.String r1 = r1.getBaseUrl()     // Catch: java.lang.Exception -> Lf3
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> Lf3
                java.lang.String r3 = "vjec"
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> Lf3
                boolean r1 = kotlin.text.StringsKt.contains$default(r1, r3, r6, r5, r4)     // Catch: java.lang.Exception -> Lf3
                if (r1 != 0) goto Lab
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.lang.String r1 = r1.getBaseUrl()     // Catch: java.lang.Exception -> Lf3
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Exception -> Lf3
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> Lf3
                java.lang.String r3 = "uat"
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> Lf3
                boolean r1 = kotlin.text.StringsKt.contains$default(r1, r3, r6, r5, r4)     // Catch: java.lang.Exception -> Lf3
                if (r1 == 0) goto L9f
                goto Lab
            L9f:
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.util.List r1 = r1.getSelected()     // Catch: java.lang.Exception -> Lf3
                java.lang.String r3 = "false"
                r1.add(r8, r3)     // Catch: java.lang.Exception -> Lf3
                goto Lbc
            Lab:
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.util.List r1 = r1.getSelected()     // Catch: java.lang.Exception -> Lf3
                java.lang.String r3 = "true"
                r1.add(r8, r3)     // Catch: java.lang.Exception -> Lf3
                android.widget.CheckBox r1 = r7.checkBox     // Catch: java.lang.Exception -> Lf3
                r3 = 1
                r1.setChecked(r3)     // Catch: java.lang.Exception -> Lf3
            Lbc:
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.lang.Boolean r1 = r1.getCheckBoxStatus()     // Catch: java.lang.Exception -> Lf3
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Exception -> Lf3
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)     // Catch: java.lang.Exception -> Lf3
                if (r1 == 0) goto Ld1
                android.widget.CheckBox r1 = r7.checkBox     // Catch: java.lang.Exception -> Lf3
                r1.setVisibility(r2)     // Catch: java.lang.Exception -> Lf3
            Ld1:
                android.widget.CheckBox r1 = r7.checkBox     // Catch: java.lang.Exception -> Lf3
                boolean r2 = r0.is_selected()     // Catch: java.lang.Exception -> Lf3
                r1.setChecked(r2)     // Catch: java.lang.Exception -> Lf3
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r1 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                java.util.List r1 = r1.getSelectedTotal()     // Catch: java.lang.Exception -> Lf3
                java.lang.String r2 = "0"
                r1.add(r8, r2)     // Catch: java.lang.Exception -> Lf3
                android.widget.CheckBox r1 = r7.checkBox     // Catch: java.lang.Exception -> Lf3
                if (r1 == 0) goto Lf3
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter r2 = r7.this$0     // Catch: java.lang.Exception -> Lf3
                in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter$ViewHolder$$ExternalSyntheticLambda0 r3 = new in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter$ViewHolder$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> Lf3
                r3.<init>()     // Catch: java.lang.Exception -> Lf3
                r1.setOnClickListener(r3)     // Catch: java.lang.Exception -> Lf3
            Lf3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter.ViewHolder.onBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, ExamRegisterAdapter this$1, int i, ExamCourse exam, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(exam, "$exam");
            if (this$0.checkBox.isChecked()) {
                this$1.getSelected().set(i, "true");
                exam.set_selected(true);
                this$1.getSelectedTotal().set(i, exam.getAmount());
                String baseUrl = this$1.getBaseUrl();
                Intrinsics.checkNotNull(baseUrl);
                if (!StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "sbce", false, 2, (Object) null)) {
                    String baseUrl2 = this$1.getBaseUrl();
                    Intrinsics.checkNotNull(baseUrl2);
                    if (!StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "mvjce", false, 2, (Object) null)) {
                        CallBack callBack = this$1.listener;
                        if (callBack != null) {
                            callBack.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
                            return;
                        }
                        return;
                    }
                }
                CallBack callBack2 = this$1.listener;
                if (callBack2 != null) {
                    callBack2.updateSelected2(this$1.getSelected(), this$1.getSelectedTotal());
                    return;
                }
                return;
            }
            exam.set_selected(false);
            this$1.getSelected().set(i, "false");
            this$1.getSelectedTotal().set(i, "0");
            String baseUrl3 = this$1.getBaseUrl();
            Intrinsics.checkNotNull(baseUrl3);
            if (!StringsKt.contains$default((CharSequence) baseUrl3, (CharSequence) "sbce", false, 2, (Object) null)) {
                String baseUrl4 = this$1.getBaseUrl();
                Intrinsics.checkNotNull(baseUrl4);
                if (!StringsKt.contains$default((CharSequence) baseUrl4, (CharSequence) "mvjce", false, 2, (Object) null)) {
                    CallBack callBack3 = this$1.listener;
                    if (callBack3 != null) {
                        callBack3.updateSelected(this$1.getSelected(), this$1.getSelectedTotal());
                        return;
                    }
                    return;
                }
            }
            CallBack callBack4 = this$1.listener;
            if (callBack4 != null) {
                callBack4.updateSelected2(this$1.getSelected(), this$1.getSelectedTotal());
            }
        }
    }

    public final void setCallBack(ExamRegisterFragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ExamCourse> _list, String baseUrl, boolean checkBoxStatus) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.selectedTotal.clear();
        this.selected.clear();
        this.checkBoxStatus = Boolean.valueOf(checkBoxStatus);
        this.baseUrl = baseUrl;
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }

    public final ArrayList<ExamCourse> getItems() {
        return this.list;
    }

    public final void selectAll(boolean check) {
        int size = this.list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                this.list.get(i).set_selected(check);
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        notifyDataSetChanged();
    }
}