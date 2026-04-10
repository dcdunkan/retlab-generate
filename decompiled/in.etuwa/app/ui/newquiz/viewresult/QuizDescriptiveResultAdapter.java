package in.etuwa.app.ui.newquiz.viewresult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.quiz.result.descriptive.DescriptiveQuestions;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: QuizDescriptiveResultAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QuizDescriptiveResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private QuizInteraction listener;
    private final ArrayList<DescriptiveQuestions> questions = new ArrayList<>();

    /* JADX INFO: compiled from: QuizDescriptiveResultAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter$QuizInteraction;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface QuizInteraction {
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_descriptive_result_item_modern, parent, false);
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

    /* JADX INFO: compiled from: QuizDescriptiveResultAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter;Landroid/view/View;)V", "answerContainer", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "attendanceStatus", "Landroid/widget/TextView;", "markObtained", "notAnsweredText", "questionContent", "questionNo", "studentAnswer", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout answerContainer;
        private final TextView attendanceStatus;
        private final TextView markObtained;
        private final TextView notAnsweredText;
        private final TextView questionContent;
        private final TextView questionNo;
        private final TextView studentAnswer;
        final /* synthetic */ QuizDescriptiveResultAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(QuizDescriptiveResultAdapter quizDescriptiveResultAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = quizDescriptiveResultAdapter;
            this.questionNo = (TextView) itemView.findViewById(R.id.question_no);
            this.attendanceStatus = (TextView) itemView.findViewById(R.id.attendance_status);
            this.markObtained = (TextView) itemView.findViewById(R.id.mark_obtained);
            this.questionContent = (TextView) itemView.findViewById(R.id.question_content);
            this.answerContainer = (LinearLayout) itemView.findViewById(R.id.answer_container);
            this.studentAnswer = (TextView) itemView.findViewById(R.id.student_answer);
            this.notAnsweredText = (TextView) itemView.findViewById(R.id.not_answered_text);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.questions.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "questions[position]");
                DescriptiveQuestions descriptiveQuestions = (DescriptiveQuestions) obj;
                TextView textView = this.questionNo;
                Object questionNo = descriptiveQuestions.getQuestionNo();
                boolean z = true;
                if (questionNo == null) {
                    questionNo = Integer.valueOf(position + 1);
                }
                textView.setText(SvgConstants.Attributes.PATH_DATA_QUAD_CURVE_TO + questionNo);
                if (descriptiveQuestions.isAttended()) {
                    this.attendanceStatus.setText("Attended");
                    this.attendanceStatus.setBackgroundResource(R.drawable.badge_green_background);
                } else {
                    this.attendanceStatus.setText("Not Attended");
                    this.attendanceStatus.setBackgroundResource(R.drawable.badge_red_background);
                }
                TextView textView2 = this.markObtained;
                String markObtained = descriptiveQuestions.getMarkObtained();
                if (markObtained == null) {
                    markObtained = "N/A";
                }
                textView2.setText(markObtained);
                TextView textView3 = this.questionContent;
                String questionContent = descriptiveQuestions.getQuestionContent();
                if (questionContent == null) {
                    questionContent = "No question content available";
                }
                textView3.setText(questionContent);
                String studentAnswer = descriptiveQuestions.getStudentAnswer();
                String str = studentAnswer;
                if (str != null && !StringsKt.isBlank(str)) {
                    z = false;
                }
                if (!z) {
                    this.studentAnswer.setText(studentAnswer);
                    this.studentAnswer.setVisibility(0);
                    this.notAnsweredText.setVisibility(8);
                } else {
                    this.studentAnswer.setVisibility(8);
                    this.notAnsweredText.setVisibility(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
            this.studentAnswer.setText("");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<DescriptiveQuestions> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.questions.clear();
        this.questions.addAll(list);
        notifyDataSetChanged();
    }

    public final void setQuizInteraction(QuizResultFragment context) {
        this.listener = context;
    }
}