package in.etuwa.app.ui.exam.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.exam.Exam;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.exam.ExamListener;
import in.etuwa.app.ui.exam.series.SeriesAdapter;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: SeriesAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/exam/series/SeriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "exams", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/Exam;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/exam/ExamListener;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setExamListener", "context", "Lin/etuwa/app/ui/exam/series/SeriesExamFragment;", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SeriesAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Exam> exams = new ArrayList<>();
    private ExamListener listener;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exam, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   ….row_exam, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
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

    /* compiled from: SeriesAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/ui/exam/series/SeriesAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/exam/series/SeriesAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "dwnBtn", "issueDate", "lastDate", AttendanceDayDialogKt.ARG_SEM, NotificationCompat.CATEGORY_STATUS, "sub", "title", "upBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final TextView dwnBtn;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView semester;
        private final TextView status;
        private final TextView sub;
        final /* synthetic */ SeriesAdapter this$0;
        private final TextView title;
        private final TextView upBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SeriesAdapter seriesAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = seriesAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.exam_subject);
            this.semester = (TextView) itemView.findViewById(R.id.exm_sem);
            this.title = (TextView) itemView.findViewById(R.id.exm_title);
            this.issueDate = (TextView) itemView.findViewById(R.id.exm_issue_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.exm_last_date);
            this.status = (TextView) itemView.findViewById(R.id.exm_status);
            this.dwnBtn = (TextView) itemView.findViewById(R.id.exm_download);
            this.upBtn = (TextView) itemView.findViewById(R.id.exm_upload_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_exm);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.exams.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "exams[position]");
                final Exam exam = (Exam) obj;
                this.sub.setText(StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) exam.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null).get(1)).toString());
                this.semester.setText(exam.getSemester());
                this.title.setText(exam.getTitle());
                this.issueDate.setText(exam.getStartTime());
                this.lastDate.setText(exam.getFinishTime());
                this.status.setText(exam.getStatus());
                if (Intrinsics.areEqual(exam.getStatus(), "SUBMITTED")) {
                    this.deleteBtn.setVisibility(0);
                } else {
                    this.deleteBtn.setVisibility(8);
                }
                if (exam.isDelete()) {
                    this.deleteBtn.setVisibility(0);
                } else {
                    this.deleteBtn.setVisibility(8);
                }
                TextView textView = this.deleteBtn;
                final SeriesAdapter seriesAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SeriesAdapter.ViewHolder.onBind$lambda$0(SeriesAdapter.this, exam, view);
                    }
                });
                TextView textView2 = this.dwnBtn;
                final SeriesAdapter seriesAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SeriesAdapter.ViewHolder.onBind$lambda$1(Exam.this, seriesAdapter2, this, view);
                    }
                });
                String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(exam.getUploadedFile(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                if (Intrinsics.areEqual(exam.getStatus(), "SUBMITTED")) {
                    ExamListener examListener = this.this$0.listener;
                    Boolean valueOf = examListener != null ? Boolean.valueOf(examListener.checkFileExistence(replace)) : null;
                    Intrinsics.checkNotNull(valueOf);
                    if (valueOf.booleanValue()) {
                        this.upBtn.setText("Open Submitted File");
                        this.upBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                    } else {
                        this.upBtn.setText("View Submitted File");
                        this.upBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                    }
                } else {
                    this.upBtn.setText("Submit");
                    this.upBtn.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
                }
                TextView textView3 = this.upBtn;
                final SeriesAdapter seriesAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SeriesAdapter.ViewHolder.onBind$lambda$2(Exam.this, seriesAdapter3, this, position, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(SeriesAdapter this$0, Exam exam, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(exam, "$exam");
            ExamListener examListener = this$0.listener;
            if (examListener != null) {
                examListener.deleteExam(exam.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(Exam exam, SeriesAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(exam, "$exam");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (exam.getCanDownload()) {
                ExamListener examListener = this$0.listener;
                if (examListener != null) {
                    examListener.openDownloadDialog(exam.getFiles());
                    return;
                }
                return;
            }
            TextView dwnBtn = this$1.dwnBtn;
            Intrinsics.checkNotNullExpressionValue(dwnBtn, "dwnBtn");
            ToastExtKt.showInfoToast(dwnBtn, "Student can download exam from start time to the end time only.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(Exam exam, SeriesAdapter this$0, ViewHolder this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(exam, "$exam");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!Intrinsics.areEqual(exam.getStatus(), "NOT SUBMITTED")) {
                ExamListener examListener = this$0.listener;
                if (examListener != null) {
                    examListener.downloadFile(exam.getUploadedFile(), i);
                    return;
                }
                return;
            }
            if (exam.getCanSubmit()) {
                ExamListener examListener2 = this$0.listener;
                if (examListener2 != null) {
                    examListener2.onPickDoc(exam.getId());
                    return;
                }
                return;
            }
            TextView upBtn = this$1.upBtn;
            Intrinsics.checkNotNullExpressionValue(upBtn, "upBtn");
            ToastExtKt.showInfoToast(upBtn, "Student can submit exam from start time to the end time only.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Exam> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.exams.clear();
        this.exams.addAll(list);
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setExamListener(SeriesExamFragment context) {
        this.listener = context;
    }
}