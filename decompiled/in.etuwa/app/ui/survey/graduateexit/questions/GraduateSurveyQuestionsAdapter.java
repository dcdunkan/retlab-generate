package in.etuwa.app.ui.survey.graduateexit.questions;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.graduateexit.DoGraduateSurveyQuestions;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraduateSurveyQuestionsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter$SurveyCallBack;", "surveyList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/graduateexit/DoGraduateSurveyQuestions;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "getItems", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSurveyCallBack", "context", "Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsFragment;", "SurveyCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GraduateSurveyQuestionsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private SurveyCallBack listener;
    private final ArrayList<DoGraduateSurveyQuestions> surveyList = new ArrayList<>();

    /* compiled from: GraduateSurveyQuestionsAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter$SurveyCallBack;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_graduate_exit_survey_questions, parent, false);
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

    /* compiled from: GraduateSurveyQuestionsAdapter.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/graduateexit/questions/GraduateSurveyQuestionsAdapter;Landroid/view/View;)V", "descriptiveText", "Lcom/google/android/material/textfield/TextInputEditText;", "kotlin.jvm.PlatformType", "descriptiveView", "Lcom/google/android/material/textfield/TextInputLayout;", "mcq", "Landroid/widget/LinearLayout;", "option1", "Landroid/widget/RadioButton;", "option2", "option3", "option4", "option5", "questionNumber", "Landroid/widget/TextView;", "questionTv", "radioBtn", "Landroid/widget/RadioGroup;", "requiredTv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextInputEditText descriptiveText;
        private final TextInputLayout descriptiveView;
        private final LinearLayout mcq;
        private final RadioButton option1;
        private final RadioButton option2;
        private final RadioButton option3;
        private final RadioButton option4;
        private final RadioButton option5;
        private final TextView questionNumber;
        private final TextView questionTv;
        private final RadioGroup radioBtn;
        private final TextView requiredTv;
        final /* synthetic */ GraduateSurveyQuestionsAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(GraduateSurveyQuestionsAdapter graduateSurveyQuestionsAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = graduateSurveyQuestionsAdapter;
            this.questionNumber = (TextView) itemView.findViewById(R.id.teacher_survey_question_no);
            this.requiredTv = (TextView) itemView.findViewById(R.id.required_tv);
            this.questionTv = (TextView) itemView.findViewById(R.id.teacher_survey_question);
            this.radioBtn = (RadioGroup) itemView.findViewById(R.id.radio_btn);
            this.option1 = (RadioButton) itemView.findViewById(R.id.option_1);
            this.option2 = (RadioButton) itemView.findViewById(R.id.option_2);
            this.option3 = (RadioButton) itemView.findViewById(R.id.option_3);
            this.option4 = (RadioButton) itemView.findViewById(R.id.option_4);
            this.option5 = (RadioButton) itemView.findViewById(R.id.option_5);
            this.descriptiveView = (TextInputLayout) itemView.findViewById(R.id.mt_descriptive);
            this.descriptiveText = (TextInputEditText) itemView.findViewById(R.id.et_descriptive);
            this.mcq = (LinearLayout) itemView.findViewById(R.id.multiple_answer_lyt);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.surveyList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "surveyList[position]");
                final DoGraduateSurveyQuestions doGraduateSurveyQuestions = (DoGraduateSurveyQuestions) obj;
                this.questionNumber.setText("Question " + (position + 1) + " (Section " + doGraduateSurveyQuestions.getSection() + ")");
                this.questionTv.setText(doGraduateSurveyQuestions.getQuestion());
                if (doGraduateSurveyQuestions.getRequired()) {
                    this.requiredTv.setVisibility(0);
                } else {
                    this.requiredTv.setVisibility(8);
                }
                if (Intrinsics.areEqual(doGraduateSurveyQuestions.getType(), "1")) {
                    this.descriptiveView.setVisibility(8);
                    this.mcq.setVisibility(0);
                } else if (Intrinsics.areEqual(doGraduateSurveyQuestions.getType(), ExifInterface.GPS_MEASUREMENT_3D)) {
                    this.descriptiveView.setVisibility(8);
                    this.mcq.setVisibility(0);
                } else {
                    this.descriptiveView.setVisibility(0);
                    this.mcq.setVisibility(8);
                }
                int size = doGraduateSurveyQuestions.getOptions().size();
                if (size == 2) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(8);
                    this.option4.setVisibility(8);
                    this.option5.setVisibility(8);
                    this.option1.setText(doGraduateSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(doGraduateSurveyQuestions.getOptions().get(1).getOption());
                } else if (size == 3) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(8);
                    this.option5.setVisibility(8);
                    this.option1.setText(doGraduateSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(doGraduateSurveyQuestions.getOptions().get(1).getOption());
                    this.option3.setText(doGraduateSurveyQuestions.getOptions().get(2).getOption());
                } else if (size == 4) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(0);
                    this.option5.setVisibility(8);
                    this.option1.setText(doGraduateSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(doGraduateSurveyQuestions.getOptions().get(1).getOption());
                    this.option3.setText(doGraduateSurveyQuestions.getOptions().get(2).getOption());
                    this.option4.setText(doGraduateSurveyQuestions.getOptions().get(3).getOption());
                } else if (size == 5) {
                    this.option1.setVisibility(0);
                    this.option2.setVisibility(0);
                    this.option3.setVisibility(0);
                    this.option4.setVisibility(0);
                    this.option5.setVisibility(0);
                    this.option1.setText(doGraduateSurveyQuestions.getOptions().get(0).getOption());
                    this.option2.setText(doGraduateSurveyQuestions.getOptions().get(1).getOption());
                    this.option3.setText(doGraduateSurveyQuestions.getOptions().get(2).getOption());
                    this.option4.setText(doGraduateSurveyQuestions.getOptions().get(3).getOption());
                    this.option5.setText(doGraduateSurveyQuestions.getOptions().get(4).getOption());
                }
                this.radioBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.widget.RadioGroup.OnCheckedChangeListener
                    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                        GraduateSurveyQuestionsAdapter.ViewHolder.onBind$lambda$0(DoGraduateSurveyQuestions.this, radioGroup, i);
                    }
                });
                if (Intrinsics.areEqual(doGraduateSurveyQuestions.getType(), ExifInterface.GPS_MEASUREMENT_2D)) {
                    this.descriptiveText.setText(doGraduateSurveyQuestions.getAnswer_id());
                } else {
                    String option_id = doGraduateSurveyQuestions.getOption_id();
                    int hashCode = option_id.hashCode();
                    if (hashCode != 0) {
                        switch (hashCode) {
                            case 49:
                                if (!option_id.equals("1")) {
                                    break;
                                } else {
                                    this.option1.setChecked(true);
                                    this.option2.setChecked(false);
                                    this.option3.setChecked(false);
                                    this.option4.setChecked(false);
                                    this.option5.setChecked(false);
                                    break;
                                }
                            case 50:
                                if (!option_id.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                                    break;
                                } else {
                                    this.option1.setChecked(false);
                                    this.option2.setChecked(true);
                                    this.option3.setChecked(false);
                                    this.option4.setChecked(false);
                                    this.option5.setChecked(false);
                                    break;
                                }
                            case 51:
                                if (!option_id.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                    break;
                                } else {
                                    this.option1.setChecked(false);
                                    this.option2.setChecked(false);
                                    this.option3.setChecked(true);
                                    this.option4.setChecked(false);
                                    this.option5.setChecked(false);
                                    break;
                                }
                            case 52:
                                if (!option_id.equals("4")) {
                                    break;
                                } else {
                                    this.option1.setChecked(false);
                                    this.option2.setChecked(false);
                                    this.option3.setChecked(false);
                                    this.option4.setChecked(true);
                                    this.option5.setChecked(false);
                                    break;
                                }
                            case 53:
                                if (!option_id.equals("5")) {
                                    break;
                                } else {
                                    this.option1.setChecked(false);
                                    this.option2.setChecked(false);
                                    this.option3.setChecked(false);
                                    this.option4.setChecked(false);
                                    this.option5.setChecked(true);
                                    break;
                                }
                        }
                    } else if (option_id.equals("")) {
                        this.radioBtn.clearCheck();
                    }
                }
                this.descriptiveText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsAdapter$ViewHolder$onBind$2
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        DoGraduateSurveyQuestions.this.setAnswer_id(String.valueOf(s));
                    }
                });
                this.this$0.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DoGraduateSurveyQuestions surveyList, RadioGroup radioGroup, int i) {
            Intrinsics.checkNotNullParameter(surveyList, "$surveyList");
            Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
            if (radioGroup.getCheckedRadioButtonId() == R.id.option_1) {
                surveyList.setAnswer_id(surveyList.getOptions().get(0).getOption_id());
                surveyList.setOption_id("1");
                return;
            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.option_2) {
                surveyList.setAnswer_id(surveyList.getOptions().get(1).getOption_id());
                surveyList.setOption_id(ExifInterface.GPS_MEASUREMENT_2D);
                return;
            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.option_3) {
                surveyList.setAnswer_id(surveyList.getOptions().get(2).getOption_id());
                surveyList.setOption_id(ExifInterface.GPS_MEASUREMENT_3D);
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_4) {
                surveyList.setAnswer_id(surveyList.getOptions().get(3).getOption_id());
                surveyList.setOption_id("4");
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.option_5) {
                surveyList.setAnswer_id(surveyList.getOptions().get(4).getOption_id());
                surveyList.setOption_id("5");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<DoGraduateSurveyQuestions> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.surveyList.clear();
        this.surveyList.addAll(list);
        notifyDataSetChanged();
    }

    public final ArrayList<DoGraduateSurveyQuestions> getItems() {
        return this.surveyList;
    }

    public final void setSurveyCallBack(GraduateSurveyQuestionsFragment context) {
        this.listener = context;
    }
}