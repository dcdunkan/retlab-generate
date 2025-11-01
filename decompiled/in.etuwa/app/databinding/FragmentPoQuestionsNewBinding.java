package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPoQuestionsNewBinding extends ViewDataBinding {
    public final TextView backBtn;
    public final LinearLayout descriptiveAnswerLyt;
    public final TextInputEditText etDescriptive;
    public final TextInputEditText etRemarks;
    public final TextInputEditText etStrength;
    public final LinearLayout finalQuestionsLyt;
    public final TextView finishBtn;

    @Bindable
    protected PoSurveyQuestionsNewViewModel mPoSurveyQuestionsNewViewModel;
    public final TextInputLayout mtDescriptive;
    public final TextInputLayout mtRemarks;
    public final TextInputLayout mtStrength;
    public final LinearLayout multipleAnswerLyt;
    public final TextView nextBtn;
    public final RadioButton option1;
    public final RadioButton option2;
    public final RadioButton option3;
    public final RadioButton option4;
    public final RadioButton option5;
    public final RadioButton option6;
    public final TextView questionTv;
    public final TextView requiredTv;
    public final RecyclerView rvQuestionNo;
    public final LinearLayout strengthLyt;
    public final TextView teacherSurveyQuestion;
    public final TextView teacherSurveyQuestionNo;
    public final RadioGroup teacherSurveyQuestionsMultiple;

    public abstract void setPoSurveyQuestionsNewViewModel(PoSurveyQuestionsNewViewModel poSurveyQuestionsNewViewModel);

    protected FragmentPoQuestionsNewBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView backBtn, LinearLayout descriptiveAnswerLyt, TextInputEditText etDescriptive, TextInputEditText etRemarks, TextInputEditText etStrength, LinearLayout finalQuestionsLyt, TextView finishBtn, TextInputLayout mtDescriptive, TextInputLayout mtRemarks, TextInputLayout mtStrength, LinearLayout multipleAnswerLyt, TextView nextBtn, RadioButton option1, RadioButton option2, RadioButton option3, RadioButton option4, RadioButton option5, RadioButton option6, TextView questionTv, TextView requiredTv, RecyclerView rvQuestionNo, LinearLayout strengthLyt, TextView teacherSurveyQuestion, TextView teacherSurveyQuestionNo, RadioGroup teacherSurveyQuestionsMultiple) {
        super(_bindingComponent, _root, _localFieldCount);
        this.backBtn = backBtn;
        this.descriptiveAnswerLyt = descriptiveAnswerLyt;
        this.etDescriptive = etDescriptive;
        this.etRemarks = etRemarks;
        this.etStrength = etStrength;
        this.finalQuestionsLyt = finalQuestionsLyt;
        this.finishBtn = finishBtn;
        this.mtDescriptive = mtDescriptive;
        this.mtRemarks = mtRemarks;
        this.mtStrength = mtStrength;
        this.multipleAnswerLyt = multipleAnswerLyt;
        this.nextBtn = nextBtn;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.option6 = option6;
        this.questionTv = questionTv;
        this.requiredTv = requiredTv;
        this.rvQuestionNo = rvQuestionNo;
        this.strengthLyt = strengthLyt;
        this.teacherSurveyQuestion = teacherSurveyQuestion;
        this.teacherSurveyQuestionNo = teacherSurveyQuestionNo;
        this.teacherSurveyQuestionsMultiple = teacherSurveyQuestionsMultiple;
    }

    public PoSurveyQuestionsNewViewModel getPoSurveyQuestionsNewViewModel() {
        return this.mPoSurveyQuestionsNewViewModel;
    }

    public static FragmentPoQuestionsNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoQuestionsNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPoQuestionsNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_po_questions_new, root, attachToRoot, component);
    }

    public static FragmentPoQuestionsNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoQuestionsNewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPoQuestionsNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_po_questions_new, null, false, component);
    }

    public static FragmentPoQuestionsNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoQuestionsNewBinding bind(View view, Object component) {
        return (FragmentPoQuestionsNewBinding) bind(component, view, R.layout.fragment_po_questions_new);
    }
}