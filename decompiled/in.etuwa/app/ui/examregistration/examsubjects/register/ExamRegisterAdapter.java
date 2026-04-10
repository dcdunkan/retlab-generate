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

/* JADX INFO: compiled from: ExamRegisterAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExamRegisterAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private String baseUrl;
    private Context context;
    private CallBack listener;
    private int total;
    private final ArrayList<ExamCourse> list = new ArrayList<>();
    private List<String> selected = new ArrayList();
    private List<String> selectedTotal = new ArrayList();

    /* JADX INFO: compiled from: ExamRegisterAdapter.kt */
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exam_update, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …am_update, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: ExamRegisterAdapter.kt */
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

        /* JADX WARN: Removed duplicated region for block: B:13:0x00ab A[Catch: Exception -> 0x00de, TryCatch #0 {Exception -> 0x00de, blocks: (B:3:0x0003, B:5:0x005f, B:7:0x0074, B:9:0x0089, B:12:0x009f, B:14:0x00bc, B:16:0x00d4, B:13:0x00ab), top: B:19:0x0003 }] */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(final int r7) {
            /*
                Method dump skipped, instruction units count: 223
                To view this dump change 'Code comments level' option to 'DEBUG'
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

    public final void addItems(ArrayList<ExamCourse> _list, String baseUrl) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.selectedTotal.clear();
        this.selected.clear();
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