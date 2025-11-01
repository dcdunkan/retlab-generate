package in.etuwa.app.ui.newquiz.viewresult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.quiz.result.mcq.McqQuestions;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizMultipleResultAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter$QuizInteraction;", "quiz", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setQuizInteraction", "context", "Lin/etuwa/app/ui/newquiz/viewresult/QuizResultFragment;", "QuizInteraction", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuizMultipleResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private QuizInteraction listener;
    private final ArrayList<McqQuestions> quiz = new ArrayList<>();

    /* compiled from: QuizMultipleResultAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter$QuizInteraction;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface QuizInteraction {
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_quiz_multiple, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_multiple, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.quiz.size() > 0) {
            return this.quiz.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.quiz.isEmpty() ? 1 : 0;
    }

    /* compiled from: QuizMultipleResultAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter;Landroid/view/View;)V", "option1", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "option2", "option3", "option4", "option5", "question", "questionNo", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView option1;
        private final TextView option2;
        private final TextView option3;
        private final TextView option4;
        private final TextView option5;
        private final TextView question;
        private final TextView questionNo;
        final /* synthetic */ QuizMultipleResultAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(QuizMultipleResultAdapter quizMultipleResultAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = quizMultipleResultAdapter;
            this.questionNo = (TextView) itemView.findViewById(R.id.question_no);
            this.question = (TextView) itemView.findViewById(R.id.question);
            this.option1 = (TextView) itemView.findViewById(R.id.option1);
            this.option2 = (TextView) itemView.findViewById(R.id.option2);
            this.option3 = (TextView) itemView.findViewById(R.id.option3);
            this.option4 = (TextView) itemView.findViewById(R.id.option4);
            this.option5 = (TextView) itemView.findViewById(R.id.option5);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.quiz.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "quiz[position]");
                McqQuestions mcqQuestions = (McqQuestions) obj;
                this.questionNo.setText("Question " + mcqQuestions.getQuestionNo() + ".");
                this.question.setText(mcqQuestions.getQuestionContent());
                if (mcqQuestions.getQuestionOptions().size() == 2) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(8);
                    this.option4.setVisibility(8);
                    this.option5.setVisibility(8);
                    this.option1.setText(mcqQuestions.getQuestionOptions().get(0).getOptionContent());
                    this.option2.setText(mcqQuestions.getQuestionOptions().get(1).getOptionContent());
                } else if (mcqQuestions.getQuestionOptions().size() == 3) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(8);
                    this.option5.setVisibility(8);
                    this.option1.setText(mcqQuestions.getQuestionOptions().get(0).getOptionContent());
                    this.option2.setText(mcqQuestions.getQuestionOptions().get(1).getOptionContent());
                    this.option3.setText(mcqQuestions.getQuestionOptions().get(2).getOptionContent());
                } else if (mcqQuestions.getQuestionOptions().size() == 4) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(0);
                    this.option5.setVisibility(8);
                    this.option1.setText(mcqQuestions.getQuestionOptions().get(0).getOptionContent());
                    this.option2.setText(mcqQuestions.getQuestionOptions().get(1).getOptionContent());
                    this.option3.setText(mcqQuestions.getQuestionOptions().get(2).getOptionContent());
                    this.option4.setText(mcqQuestions.getQuestionOptions().get(3).getOptionContent());
                } else if (mcqQuestions.getQuestionOptions().size() == 5) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(0);
                    this.option5.setVisibility(0);
                    this.option1.setText(mcqQuestions.getQuestionOptions().get(0).getOptionContent());
                    this.option2.setText(mcqQuestions.getQuestionOptions().get(1).getOptionContent());
                    this.option3.setText(mcqQuestions.getQuestionOptions().get(2).getOptionContent());
                    this.option4.setText(mcqQuestions.getQuestionOptions().get(3).getOptionContent());
                    this.option5.setText(mcqQuestions.getQuestionOptions().get(4).getOptionContent());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<McqQuestions> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.quiz.clear();
        this.quiz.addAll(list);
        notifyDataSetChanged();
    }

    public final void setQuizInteraction(QuizResultFragment context) {
        this.listener = context;
    }
}