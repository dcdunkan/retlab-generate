package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewViewModel;

/* loaded from: classes3.dex */
public class FragmentPoQuestionsNewBindingImpl extends FragmentPoQuestionsNewBinding {
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
        sparseIntArray.put(R.id.teacher_survey_question_no, 3);
        sparseIntArray.put(R.id.required_tv, 4);
        sparseIntArray.put(R.id.teacher_survey_question, 5);
        sparseIntArray.put(R.id.descriptive_answer_lyt, 6);
        sparseIntArray.put(R.id.mt_descriptive, 7);
        sparseIntArray.put(R.id.et_descriptive, 8);
        sparseIntArray.put(R.id.multiple_answer_lyt, 9);
        sparseIntArray.put(R.id.teacher_survey_questions_multiple, 10);
        sparseIntArray.put(R.id.option_1, 11);
        sparseIntArray.put(R.id.option_2, 12);
        sparseIntArray.put(R.id.option_3, 13);
        sparseIntArray.put(R.id.option_4, 14);
        sparseIntArray.put(R.id.option_5, 15);
        sparseIntArray.put(R.id.option_6, 16);
        sparseIntArray.put(R.id.final_questions_lyt, 17);
        sparseIntArray.put(R.id.strength_lyt, 18);
        sparseIntArray.put(R.id.mt_strength, 19);
        sparseIntArray.put(R.id.et_strength, 20);
        sparseIntArray.put(R.id.mt_remarks, 21);
        sparseIntArray.put(R.id.et_remarks, 22);
        sparseIntArray.put(R.id.back_btn, 23);
        sparseIntArray.put(R.id.question_tv, 24);
        sparseIntArray.put(R.id.finish_btn, 25);
        sparseIntArray.put(R.id.next_btn, 26);
    }

    public FragmentPoQuestionsNewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }

    private FragmentPoQuestionsNewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[23], (LinearLayout) bindings[6], (TextInputEditText) bindings[8], (TextInputEditText) bindings[22], (TextInputEditText) bindings[20], (LinearLayout) bindings[17], (TextView) bindings[25], (TextInputLayout) bindings[7], (TextInputLayout) bindings[21], (TextInputLayout) bindings[19], (LinearLayout) bindings[9], (TextView) bindings[26], (RadioButton) bindings[11], (RadioButton) bindings[12], (RadioButton) bindings[13], (RadioButton) bindings[14], (RadioButton) bindings[15], (RadioButton) bindings[16], (TextView) bindings[24], (TextView) bindings[4], (RecyclerView) bindings[2], (LinearLayout) bindings[18], (TextView) bindings[5], (TextView) bindings[3], (RadioGroup) bindings[10]);
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
        if (162 != variableId) {
            return false;
        }
        setPoSurveyQuestionsNewViewModel((PoSurveyQuestionsNewViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentPoQuestionsNewBinding
    public void setPoSurveyQuestionsNewViewModel(PoSurveyQuestionsNewViewModel PoSurveyQuestionsNewViewModel) {
        this.mPoSurveyQuestionsNewViewModel = PoSurveyQuestionsNewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}