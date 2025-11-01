package in.etuwa.app.ui.newquiz.viewresult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.quiz.list.Quiz;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizDescriptiveResultAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter$QuizInteraction;", "quiz", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/quiz/list/Quiz;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setQuizInteraction", "context", "Lin/etuwa/app/ui/newquiz/viewresult/QuizResultFragment;", "QuizInteraction", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuizDescriptiveResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private QuizInteraction listener;
    private final ArrayList<Quiz> quiz = new ArrayList<>();

    /* compiled from: QuizDescriptiveResultAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter$QuizInteraction;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_quiz, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   ….row_quiz, parent, false)");
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

    /* compiled from: QuizDescriptiveResultAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter;Landroid/view/View;)V", "endTime", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "quizBtn", "quizName", "quizText", "quizType", "startTime", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView endTime;
        private final TextView quizBtn;
        private final TextView quizName;
        private final TextView quizText;
        private final TextView quizType;
        private final TextView startTime;
        final /* synthetic */ QuizDescriptiveResultAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(QuizDescriptiveResultAdapter quizDescriptiveResultAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = quizDescriptiveResultAdapter;
            this.quizName = (TextView) itemView.findViewById(R.id.quiz_name);
            this.quizType = (TextView) itemView.findViewById(R.id.quiz_type);
            this.startTime = (TextView) itemView.findViewById(R.id.quiz_start_time);
            this.endTime = (TextView) itemView.findViewById(R.id.quiz_end_time);
            this.quizText = (TextView) itemView.findViewById(R.id.quiz_text);
            this.quizBtn = (TextView) itemView.findViewById(R.id.quiz_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.quiz.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "quiz[position]");
                Quiz quiz = (Quiz) obj;
                this.quizName.setText(quiz.getName());
                this.quizType.setText(quiz.getTypeText());
                this.startTime.setText("Start Time : " + quiz.getStartTime());
                this.endTime.setText("End Time : " + quiz.getEndTime());
                if (quiz.isResultPublished()) {
                    this.quizBtn.setText("View Result");
                    this.quizBtn.setVisibility(0);
                    this.quizText.setVisibility(8);
                } else if (quiz.isStarted() && !quiz.isOnGoing()) {
                    this.quizText.setText("Quiz/Viva Over");
                    this.quizBtn.setVisibility(8);
                    this.quizText.setVisibility(0);
                } else if (quiz.isStarted() && quiz.isOnGoing()) {
                    if (quiz.isCompleted()) {
                        this.quizText.setText("Completed");
                        this.quizBtn.setVisibility(8);
                        this.quizText.setVisibility(0);
                    } else {
                        this.quizBtn.setText("Attempt");
                        this.quizBtn.setVisibility(0);
                        this.quizText.setVisibility(8);
                    }
                } else if (!quiz.isStarted() && !quiz.isOnGoing()) {
                    this.quizText.setText("Not Started");
                    this.quizBtn.setVisibility(8);
                    this.quizText.setVisibility(0);
                } else {
                    this.quizBtn.setText("Quiz/Viva Over");
                    this.quizBtn.setVisibility(0);
                    this.quizText.setVisibility(8);
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

    public final void addItems(ArrayList<Quiz> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.quiz.clear();
        this.quiz.addAll(list);
        notifyDataSetChanged();
    }

    public final void setQuizInteraction(QuizResultFragment context) {
        this.listener = context;
    }
}