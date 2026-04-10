package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentTeacherSurveyQuestionsBindingImpl extends FragmentTeacherSurveyQuestionsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final CoordinatorLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.sub_tv, 2);
        sparseIntArray.put(R.id.question_tv, 3);
        sparseIntArray.put(R.id.survey_progress, 4);
        sparseIntArray.put(R.id.rv_question_no, 5);
        sparseIntArray.put(R.id.mbits_lyt, 6);
        sparseIntArray.put(R.id.teacher_img, 7);
        sparseIntArray.put(R.id.sem_tv, 8);
        sparseIntArray.put(R.id.sub_label_tv, 9);
        sparseIntArray.put(R.id.teacher_survey_question_no, 10);
        sparseIntArray.put(R.id.required_tv, 11);
        sparseIntArray.put(R.id.teacher_survey_question, 12);
        sparseIntArray.put(R.id.multiple_answer_lyt, 13);
        sparseIntArray.put(R.id.teacher_survey_questions_multiple, 14);
        sparseIntArray.put(R.id.option_1, 15);
        sparseIntArray.put(R.id.option_2, 16);
        sparseIntArray.put(R.id.option_3, 17);
        sparseIntArray.put(R.id.option_4, 18);
        sparseIntArray.put(R.id.option_5, 19);
        sparseIntArray.put(R.id.option_6, 20);
        sparseIntArray.put(R.id.descriptive_answer_lyt, 21);
        sparseIntArray.put(R.id.mt_descriptive, 22);
        sparseIntArray.put(R.id.et_descriptive, 23);
        sparseIntArray.put(R.id.final_questions_lyt, 24);
        sparseIntArray.put(R.id.mt_strength, 25);
        sparseIntArray.put(R.id.et_strength, 26);
        sparseIntArray.put(R.id.mt_remarks, 27);
        sparseIntArray.put(R.id.et_remarks, 28);
        sparseIntArray.put(R.id.back_btn, 29);
        sparseIntArray.put(R.id.next_btn, 30);
        sparseIntArray.put(R.id.finish_btn, 31);
    }

    public FragmentTeacherSurveyQuestionsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 32, sIncludes, sViewsWithIds));
    }

    private FragmentTeacherSurveyQuestionsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialButton) bindings[29], (LinearLayout) bindings[21], (TextInputEditText) bindings[23], (TextInputEditText) bindings[28], (TextInputEditText) bindings[26], (LinearLayout) bindings[24], (MaterialButton) bindings[31], (CardView) bindings[6], (TextInputLayout) bindings[22], (TextInputLayout) bindings[27], (TextInputLayout) bindings[25], (LinearLayout) bindings[13], (MaterialButton) bindings[30], (RadioButton) bindings[15], (RadioButton) bindings[16], (RadioButton) bindings[17], (RadioButton) bindings[18], (RadioButton) bindings[19], (RadioButton) bindings[20], (TextView) bindings[3], (TextView) bindings[11], (RecyclerView) bindings[5], (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[2], (ProgressBar) bindings[4], (ImageView) bindings[7], (TextView) bindings[12], (TextView) bindings[10], (RadioGroup) bindings[14]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) bindings[0];
        this.mboundView01 = coordinatorLayout;
        coordinatorLayout.setTag(null);
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