package in.etuwa.app.ui.examschedules;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.itextpdf.kernel.xmp.PdfConst;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.examschedules.ExamSchedule;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examschedules.ExamAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExamAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<ExamSchedule> exams = new ArrayList<>();
    private ExamScheduleListener listener;

    /* JADX INFO: compiled from: ExamAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/examschedules/ExamAdapter$ExamScheduleListener;", "", "downloadFile", "", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ExamScheduleListener {
        void downloadFile(String url);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exam_schedule, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …_schedule, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.exams.size() > 0) {
            return this.exams.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.exams.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: ExamAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/examschedules/ExamAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/examschedules/ExamAdapter;Landroid/view/View;)V", "date", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", PdfConst.Description, "downBtn", "Lcom/google/android/material/button/MaterialButton;", "examName", "subject", "time", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView date;
        private final TextView description;
        private final MaterialButton downBtn;
        private final TextView examName;
        private final TextView subject;
        final /* synthetic */ ExamAdapter this$0;
        private final TextView time;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ExamAdapter examAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = examAdapter;
            this.examName = (TextView) itemView.findViewById(R.id.exam_name);
            this.subject = (TextView) itemView.findViewById(R.id.exam_subject);
            this.description = (TextView) itemView.findViewById(R.id.exam_description);
            this.date = (TextView) itemView.findViewById(R.id.tv_date_exam);
            this.time = (TextView) itemView.findViewById(R.id.tv_time_exam);
            this.downBtn = (MaterialButton) itemView.findViewById(R.id.exam_download);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.exams.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "exams[position]");
                final ExamSchedule examSchedule = (ExamSchedule) obj;
                this.examName.setText(examSchedule.getExm_name());
                this.subject.setText(examSchedule.getSubject());
                this.description.setText(examSchedule.getDetails());
                this.date.setText(examSchedule.getDate());
                this.time.setText(examSchedule.getTime());
                boolean z = true;
                if (examSchedule.getUrl().length() == 0) {
                    this.downBtn.setVisibility(8);
                } else {
                    this.downBtn.setVisibility(0);
                }
                if (examSchedule.getDetails().length() != 0) {
                    z = false;
                }
                if (z) {
                    this.description.setVisibility(8);
                } else {
                    this.description.setVisibility(0);
                }
                MaterialButton materialButton = this.downBtn;
                final ExamAdapter examAdapter = this.this$0;
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examschedules.ExamAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ExamAdapter.ViewHolder.onBind$lambda$0(examAdapter, examSchedule, view);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ExamAdapter this$0, ExamSchedule exam, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(exam, "$exam");
            ExamScheduleListener examScheduleListener = this$0.listener;
            if (examScheduleListener != null) {
                examScheduleListener.downloadFile(exam.getUrl());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ExamSchedule> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.exams.clear();
        this.exams.addAll(list);
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setExamScheduleListener(ExamFragment context) {
        this.listener = context;
    }
}