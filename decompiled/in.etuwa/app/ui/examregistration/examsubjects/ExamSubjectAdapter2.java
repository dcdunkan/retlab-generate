package in.etuwa.app.ui.examregistration.examsubjects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.examregister.ExamRegister;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamSubjectAdapter2.kt */
/* loaded from: classes4.dex */
public final class ExamSubjectAdapter2 extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private String flag;
    private final ArrayList<ExamRegister> list = new ArrayList<>();
    private CallBack listener;

    /* compiled from: ExamSubjectAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter2$CallBack;", "", "viewBtnClicked", "", "id", "", "viewRegisterBtnClicked", "viewResultBtnClicked", "viewRevaatuation", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void viewBtnClicked(String id);

        void viewRegisterBtnClicked(String id);

        void viewResultBtnClicked(String id);

        void viewRevaatuation(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exam_subject2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_subject2, parent, false)");
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

    /* compiled from: ExamSubjectAdapter2.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter2$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter2;Landroid/view/View;)V", "subjectHead", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "viewBtn", "viewRegisterBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView subjectHead;
        final /* synthetic */ ExamSubjectAdapter2 this$0;
        private final TextView viewBtn;
        private final TextView viewRegisterBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ExamSubjectAdapter2 examSubjectAdapter2, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = examSubjectAdapter2;
            this.subjectHead = (TextView) itemView.findViewById(R.id.subject_head);
            this.viewRegisterBtn = (TextView) itemView.findViewById(R.id.view_register_btn);
            this.viewBtn = (TextView) itemView.findViewById(R.id.view_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final ExamRegister examRegister = (ExamRegister) obj;
                this.subjectHead.setText(examRegister.getName());
                TextView textView = this.viewRegisterBtn;
                if (textView != null) {
                    textView.setText("View Result");
                }
                TextView textView2 = this.viewBtn;
                if (textView2 != null) {
                    textView2.setVisibility(4);
                }
                TextView textView3 = this.viewRegisterBtn;
                if (textView3 != null) {
                    final ExamSubjectAdapter2 examSubjectAdapter2 = this.this$0;
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ExamSubjectAdapter2.ViewHolder.onBind$lambda$0(ExamSubjectAdapter2.this, examRegister, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ExamSubjectAdapter2 this$0, ExamRegister exam, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(exam, "$exam");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.viewResultBtnClicked(exam.getId());
            }
        }
    }

    public final void setCallBack(ExamSubject2Fragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ExamRegister> _list, String flag) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.list.clear();
        this.list.addAll(_list);
        this.flag = flag;
        notifyDataSetChanged();
    }
}