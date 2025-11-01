package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel;

/* loaded from: classes3.dex */
public class FragmentTeacherSurveyQuestionsBindingImpl extends FragmentTeacherSurveyQuestionsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final FrameLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rv_question_no, 2);
        sparseIntArray.put(R.id.mbits_lyt, 3);
        sparseIntArray.put(R.id.teacher_img, 4);
        sparseIntArray.put(R.id.sem_tv, 5);
        sparseIntArray.put(R.id.sub_tv, 6);
        sparseIntArray.put(R.id.teacher_survey_question_no, 7);
        sparseIntArray.put(R.id.required_tv, 8);
        sparseIntArray.put(R.id.teacher_survey_question, 9);
        sparseIntArray.put(R.id.descriptive_answer_lyt, 10);
        sparseIntArray.put(R.id.mt_descriptive, 11);
        sparseIntArray.put(R.id.et_descriptive, 12);
        sparseIntArray.put(R.id.multiple_answer_lyt, 13);
        sparseIntArray.put(R.id.teacher_survey_questions_multiple, 14);
        sparseIntArray.put(R.id.option_1, 15);
        sparseIntArray.put(R.id.option_2, 16);
        sparseIntArray.put(R.id.option_3, 17);
        sparseIntArray.put(R.id.option_4, 18);
        sparseIntArray.put(R.id.option_5, 19);
        sparseIntArray.put(R.id.option_6, 20);
        sparseIntArray.put(R.id.final_questions_lyt, 21);
        sparseIntArray.put(R.id.strength_lyt, 22);
        sparseIntArray.put(R.id.mt_strength, 23);
        sparseIntArray.put(R.id.et_strength, 24);
        sparseIntArray.put(R.id.mt_remarks, 25);
        sparseIntArray.put(R.id.et_remarks, 26);
        sparseIntArray.put(R.id.back_btn, 27);
        sparseIntArray.put(R.id.question_tv, 28);
        sparseIntArray.put(R.id.finish_btn, 29);
        sparseIntArray.put(R.id.next_btn, 30);
    }

    public FragmentTeacherSurveyQuestionsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }

    private FragmentTeacherSurveyQuestionsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[27], (LinearLayout) bindings[10], (TextInputEditText) bindings[12], (TextInputEditText) bindings[26], (TextInputEditText) bindings[24], (LinearLayout) bindings[21], (TextView) bindings[29], (LinearLayout) bindings[3], (TextInputLayout) bindings[11], (TextInputLayout) bindings[25], (TextInputLayout) bindings[23], (LinearLayout) bindings[13], (TextView) bindings[30], (RadioButton) bindings[15], (RadioButton) bindings[16], (RadioButton) bindings[17], (RadioButton) bindings[18], (RadioButton) bindings[19], (RadioButton) bindings[20], (TextView) bindings[28], (TextView) bindings[8], (RecyclerView) bindings[2], (TextView) bindings[5], (LinearLayout) bindings[22], (TextView) bindings[6], (ImageView) bindings[4], (TextView) bindings[9], (TextView) bindings[7], (RadioGroup) bindings[14]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView01 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (3 != variableId) {
            return false;
        }
        setTeacherSurveyQuestionViewModel((TeacherSurveyQuestionViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentTeacherSurveyQuestionsBinding
    public void setTeacherSurveyQuestionViewModel(TeacherSurveyQuestionViewModel TeacherSurveyQuestionViewModel) {
        this.mTeacherSurveyQuestionViewModel = TeacherSurveyQuestionViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}