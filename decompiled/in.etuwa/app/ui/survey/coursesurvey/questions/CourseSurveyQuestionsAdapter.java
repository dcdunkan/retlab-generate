package in.etuwa.app.ui.survey.coursesurvey.questions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyQuestions;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CourseSurveyQuestionsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsAdapter$SurveyCallBack;", "surveyList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurveyQuestions;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "getItems", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSurveyCallBack", "context", "Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsFragment;", "SurveyCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CourseSurveyQuestionsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private SurveyCallBack listener;
    private final ArrayList<CourseSurveyQuestions> surveyList = new ArrayList<>();

    /* compiled from: CourseSurveyQuestionsAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsAdapter$SurveyCallBack;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_course_survey_questions, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …questions, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.surveyList.size() > 0) {
            return this.surveyList.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.surveyList.isEmpty() ? 1 : 0;
    }

    /* compiled from: CourseSurveyQuestionsAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/coursesurvey/questions/CourseSurveyQuestionsAdapter;Landroid/view/View;)V", "option1", "Landroid/widget/RadioButton;", "kotlin.jvm.PlatformType", "option2", "option3", "option4", "option5", "questionNumber", "Landroid/widget/TextView;", "questionTv", "radioBtn", "Landroid/widget/RadioGroup;", "requiredTv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final RadioButton option1;
        private final RadioButton option2;
        private final RadioButton option3;
        private final RadioButton option4;
        private final RadioButton option5;
        private final TextView questionNumber;
        private final TextView questionTv;
        private final RadioGroup radioBtn;
        private final TextView requiredTv;
        final /* synthetic */ CourseSurveyQuestionsAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(CourseSurveyQuestionsAdapter courseSurveyQuestionsAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = courseSurveyQuestionsAdapter;
            this.questionNumber = (TextView) itemView.findViewById(R.id.teacher_survey_question_no);
            this.requiredTv = (TextView) itemView.findViewById(R.id.required_tv);
            this.questionTv = (TextView) itemView.findViewById(R.id.teacher_survey_question);
            this.radioBtn = (RadioGroup) itemView.findViewById(R.id.radio_btn);
            this.option1 = (RadioButton) itemView.findViewById(R.id.option_1);
            this.option2 = (RadioButton) itemView.findViewById(R.id.option_2);
            this.option3 = (RadioButton) itemView.findViewById(R.id.option_3);
            this.option4 = (RadioButton) itemView.findViewById(R.id.option_4);
            this.option5 = (RadioButton) itemView.findViewById(R.id.option_5);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.surveyList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "surveyList[position]");
                final CourseSurveyQuestions courseSurveyQuestions = (CourseSurveyQuestions) obj;
                this.questionNumber.setText("Question " + (position + 1));
                this.questionTv.setText(courseSurveyQuestions.getQuestion());
                if (courseSurveyQuestions.getRequired()) {
                    this.requiredTv.setVisibility(0);
                } else {
                    this.requiredTv.setVisibility(8);
                }
                int size = courseSurveyQuestions.getOptions().size();
                if (size == 2) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(8);
                    this.option4.setVisibility(8);
                    this.option5.setVisibility(8);
                    this.option1.setText(courseSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(courseSurveyQuestions.getOptions().get(1).getOption());
                } else if (size == 3) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(8);
                    this.option5.setVisibility(8);
                    this.option1.setText(courseSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(courseSurveyQuestions.getOptions().get(1).getOption());
                    this.option3.setText(courseSurveyQuestions.getOptions().get(2).getOption());
                } else if (size == 4) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(0);
                    this.option5.setVisibility(8);
                    this.option1.setText(courseSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(courseSurveyQuestions.getOptions().get(1).getOption());
                    this.option3.setText(courseSurveyQuestions.getOptions().get(2).getOption());
                    this.option4.setText(courseSurveyQuestions.getOptions().get(3).getOption());
                } else if (size == 5) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(0);
                    this.option5.setVisibility(0);
                    this.option1.setText(courseSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(courseSurveyQuestions.getOptions().get(1).getOption());
                    this.option3.setText(courseSurveyQuestions.getOptions().get(2).getOption());
                    this.option4.setText(courseSurveyQuestions.getOptions().get(3).getOption());
                    this.option5.setText(courseSurveyQuestions.getOptions().get(4).getOption());
                }
                RadioGroup radioGroup = this.radioBtn;
                final CourseSurveyQuestionsAdapter courseSurveyQuestionsAdapter = this.this$0;
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.widget.RadioGroup.OnCheckedChangeListener
                    public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                        CourseSurveyQuestionsAdapter.ViewHolder.onBind$lambda$0(CourseSurveyQuestions.this, courseSurveyQuestionsAdapter, radioGroup2, i);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(CourseSurveyQuestions surveyList, CourseSurveyQuestionsAdapter this$0, RadioGroup radioGroup, int i) {
            Intrinsics.checkNotNullParameter(surveyList, "$surveyList");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
            if (radioGroup.getCheckedRadioButtonId() == R.id.option_1) {
                surveyList.setAnswer_id(surveyList.getOptions().get(0).getOption_id());
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_2) {
                surveyList.setAnswer_id(surveyList.getOptions().get(1).getOption_id());
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_3) {
                surveyList.setAnswer_id(surveyList.getOptions().get(2).getOption_id());
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_4) {
                surveyList.setAnswer_id(surveyList.getOptions().get(3).getOption_id());
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_5) {
                surveyList.setAnswer_id(surveyList.getOptions().get(4).getOption_id());
            }
            this$0.notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<CourseSurveyQuestions> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.surveyList.clear();
        this.surveyList.addAll(list);
        notifyDataSetChanged();
    }

    public final ArrayList<CourseSurveyQuestions> getItems() {
        return this.surveyList;
    }

    public final void setSurveyCallBack(CourseSurveyQuestionsFragment context) {
        this.listener = context;
    }
}