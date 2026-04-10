package in.etuwa.app.ui.newquiz.viewresult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.quiz.result.filetype.FileTypeQuestions;
import in.etuwa.app.data.model.quiz.result.filetype.QuizResultFile;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizUploadResultAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QuizUploadResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private QuizInteraction listener;
    private final ArrayList<FileTypeQuestions> questions = new ArrayList<>();

    /* JADX INFO: compiled from: QuizUploadResultAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizUploadResultAdapter$QuizInteraction;", "", "viewUploadClicked", "", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface QuizInteraction {
        void viewUploadClicked(String url);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_upload_result_item_modern, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …em_modern, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.questions.size() > 0) {
            return this.questions.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.questions.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: QuizUploadResultAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizUploadResultAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/newquiz/viewresult/QuizUploadResultAdapter;Landroid/view/View;)V", "attendanceStatus", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "filesContainer", "Landroid/widget/LinearLayout;", "markObtained", "questionContent", "questionNo", "addFileView", "", "file", "Lin/etuwa/app/data/model/quiz/result/filetype/QuizResultFile;", "container", "clear", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView attendanceStatus;
        private final LinearLayout filesContainer;
        private final TextView markObtained;
        private final TextView questionContent;
        private final TextView questionNo;
        final /* synthetic */ QuizUploadResultAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(QuizUploadResultAdapter quizUploadResultAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = quizUploadResultAdapter;
            this.questionNo = (TextView) itemView.findViewById(R.id.question_no);
            this.attendanceStatus = (TextView) itemView.findViewById(R.id.attendance_status);
            this.markObtained = (TextView) itemView.findViewById(R.id.mark_obtained);
            this.questionContent = (TextView) itemView.findViewById(R.id.question_content);
            this.filesContainer = (LinearLayout) itemView.findViewById(R.id.files_container);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.questions.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "questions[position]");
                FileTypeQuestions fileTypeQuestions = (FileTypeQuestions) obj;
                TextView textView = this.questionNo;
                Object questionNo = fileTypeQuestions.getQuestionNo();
                if (questionNo == null) {
                    questionNo = Integer.valueOf(position + 1);
                }
                textView.setText(SvgConstants.Attributes.PATH_DATA_QUAD_CURVE_TO + questionNo);
                if (fileTypeQuestions.isAttended()) {
                    this.attendanceStatus.setText("Attended");
                    this.attendanceStatus.setBackgroundResource(R.drawable.badge_green_background);
                } else {
                    this.attendanceStatus.setText("Not Attended");
                    this.attendanceStatus.setBackgroundResource(R.drawable.badge_red_background);
                }
                TextView textView2 = this.markObtained;
                String markObtained = fileTypeQuestions.getMarkObtained();
                if (markObtained == null) {
                    markObtained = "N/A";
                }
                textView2.setText(markObtained);
                TextView textView3 = this.questionContent;
                String questionContent = fileTypeQuestions.getQuestionContent();
                if (questionContent == null) {
                    questionContent = "No question content available";
                }
                textView3.setText(questionContent);
                this.filesContainer.removeAllViews();
                ArrayList<QuizResultFile> file = fileTypeQuestions.getFile();
                if (file != null) {
                    if (!(!file.isEmpty())) {
                        TextView textView4 = new TextView(this.itemView.getContext());
                        textView4.setText("No files uploaded");
                        textView4.setTextSize(13.0f);
                        textView4.setTextColor(ContextCompat.getColor(textView4.getContext(), R.color.colorBlack));
                        textView4.setAlpha(0.5f);
                        textView4.setPadding(0, 8, 0, 8);
                        this.filesContainer.addView(textView4);
                        return;
                    }
                    for (QuizResultFile quizResultFile : file) {
                        LinearLayout filesContainer = this.filesContainer;
                        Intrinsics.checkNotNullExpressionValue(filesContainer, "filesContainer");
                        addFileView(quizResultFile, filesContainer);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void addFileView(final in.etuwa.app.data.model.quiz.result.filetype.QuizResultFile r8, android.widget.LinearLayout r9) {
            /*
                Method dump skipped, instruction units count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.newquiz.viewresult.QuizUploadResultAdapter.ViewHolder.addFileView(in.etuwa.app.data.model.quiz.result.filetype.QuizResultFile, android.widget.LinearLayout):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void addFileView$lambda$4(QuizResultFile file, QuizUploadResultAdapter this$0, View view) {
            QuizInteraction quizInteraction;
            Intrinsics.checkNotNullParameter(file, "$file");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String path = file.getPath();
            if (path == null || (quizInteraction = this$0.listener) == null) {
                return;
            }
            quizInteraction.viewUploadClicked(path);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void addFileView$lambda$6(QuizResultFile file, QuizUploadResultAdapter this$0, View view) {
            QuizInteraction quizInteraction;
            Intrinsics.checkNotNullParameter(file, "$file");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String path = file.getPath();
            if (path == null || (quizInteraction = this$0.listener) == null) {
                return;
            }
            quizInteraction.viewUploadClicked(path);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
            this.filesContainer.removeAllViews();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<FileTypeQuestions> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.questions.clear();
        this.questions.addAll(list);
        notifyDataSetChanged();
    }

    public final void setQuizInteraction(QuizResultFragment context) {
        this.listener = context;
    }
}