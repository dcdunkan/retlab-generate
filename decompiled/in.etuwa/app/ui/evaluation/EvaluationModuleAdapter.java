package in.etuwa.app.ui.evaluation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.CookieSpecs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.exam.Exam;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.exam.ExamListener;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EvaluationModuleAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EvaluationModuleAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Exam> exams = new ArrayList<>();
    private final ArrayList<Exam> filteredExams = new ArrayList<>();
    private ExamListener listener;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_exam, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   ….row_exam, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.filteredExams.size() > 0) {
            return this.filteredExams.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.filteredExams.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: EvaluationModuleAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationModuleAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/evaluation/EvaluationModuleAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "dwnBtn", "issueDate", "lastDate", AttendanceDayDialogKt.ARG_SEM, "sub", "submittedView", "title", "upBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final TextView dwnBtn;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView semester;
        private final TextView sub;
        private final View submittedView;
        final /* synthetic */ EvaluationModuleAdapter this$0;
        private final TextView title;
        private final TextView upBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(EvaluationModuleAdapter evaluationModuleAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = evaluationModuleAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.exam_subject);
            this.semester = (TextView) itemView.findViewById(R.id.exm_sem);
            this.title = (TextView) itemView.findViewById(R.id.exm_title);
            this.issueDate = (TextView) itemView.findViewById(R.id.exm_issue_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.exm_last_date);
            this.dwnBtn = (TextView) itemView.findViewById(R.id.exm_download);
            this.upBtn = (TextView) itemView.findViewById(R.id.exm_upload_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_exm);
            this.submittedView = itemView.findViewById(R.id.submitted_view_module);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0138 A[Catch: Exception -> 0x0192, TryCatch #0 {Exception -> 0x0192, blocks: (B:3:0x0005, B:5:0x0037, B:7:0x0043, B:9:0x004b, B:12:0x0090, B:14:0x0096, B:16:0x00a0, B:18:0x00ab, B:22:0x00bb, B:24:0x00c8, B:26:0x00e4, B:28:0x0121, B:33:0x0132, B:46:0x0186, B:34:0x0138, B:36:0x0142, B:38:0x014a, B:43:0x0154, B:44:0x0165, B:45:0x0176, B:25:0x00d7, B:17:0x00a6, B:8:0x0046), top: B:49:0x0005 }] */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(final int r12) {
            /*
                Method dump skipped, instruction units count: 403
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationModuleAdapter.ViewHolder.onBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(EvaluationModuleAdapter this$0, Exam exam, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(exam, "$exam");
            ExamListener examListener = this$0.listener;
            if (examListener != null) {
                examListener.deleteExam(exam.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(Exam exam, EvaluationModuleAdapter this$0, ViewHolder this$1, View view) {
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
        public static final void onBind$lambda$2(Exam exam, EvaluationModuleAdapter this$0, ViewHolder this$1, int i, View view) {
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
        ArrayList<Exam> arrayList = list;
        this.exams.addAll(arrayList);
        this.filteredExams.clear();
        this.filteredExams.addAll(arrayList);
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyCombinedFilter(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList<in.etuwa.app.data.model.exam.Exam> r0 = r10.filteredExams
            r0.clear()
            java.util.ArrayList<in.etuwa.app.data.model.exam.Exam> r0 = r10.exams
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L49
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L29:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L44
            java.lang.Object r3 = r0.next()
            r4 = r3
            in.etuwa.app.data.model.exam.Exam r4 = (in.etuwa.app.data.model.exam.Exam) r4
            java.lang.String r4 = r4.getStatus()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r11, r2)
            if (r4 == 0) goto L29
            r1.add(r3)
            goto L29
        L44:
            java.util.List r1 = (java.util.List) r1
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L49:
            r11 = r12
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            r11 = r11 ^ r2
            if (r11 == 0) goto Lb4
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r11 = r12.toLowerCase(r11)
            java.lang.String r12 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L6b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Laf
            java.lang.Object r3 = r0.next()
            r4 = r3
            in.etuwa.app.data.model.exam.Exam r4 = (in.etuwa.app.data.model.exam.Exam) r4
            java.lang.String r5 = r4.getSubject()
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r12)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = r11
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r6, r7, r8, r9)
            if (r5 != 0) goto La8
            java.lang.String r4 = r4.getTitle()
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r12)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.contains$default(r4, r6, r7, r8, r9)
            if (r4 == 0) goto La9
        La8:
            r7 = 1
        La9:
            if (r7 == 0) goto L6b
            r1.add(r3)
            goto L6b
        Laf:
            java.util.List r1 = (java.util.List) r1
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        Lb4:
            java.util.ArrayList<in.etuwa.app.data.model.exam.Exam> r11 = r10.filteredExams
            java.util.Collection r0 = (java.util.Collection) r0
            r11.addAll(r0)
            r10.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationModuleAdapter.applyCombinedFilter(java.lang.String, java.lang.String):void");
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setExamListener(EvaluationFragment context) {
        this.listener = context;
    }

    public static /* synthetic */ String orShort$default(EvaluationModuleAdapter evaluationModuleAdapter, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        }
        return evaluationModuleAdapter.orShort(str, str2);
    }

    public final String orShort(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "default");
        String str3 = str;
        return ((str3 == null || StringsKt.isBlank(str3)) || Intrinsics.areEqual(str, "null")) ? str2 : str;
    }
}