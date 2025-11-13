package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel;

/* loaded from: classes3.dex */
public class FragmentQuizQuestionsBindingImpl extends FragmentQuizQuestionsBinding {
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
        sparseIntArray.put(R.id.quiz_question_no, 2);
        sparseIntArray.put(R.id.quiz_question, 3);
        sparseIntArray.put(R.id.question_image, 4);
        sparseIntArray.put(R.id.descriptive_answer_lyt, 5);
        sparseIntArray.put(R.id.mt_descriptive, 6);
        sparseIntArray.put(R.id.et_descriptive, 7);
        sparseIntArray.put(R.id.multiple_answer_lyt, 8);
        sparseIntArray.put(R.id.quiz_questions_multiple, 9);
        sparseIntArray.put(R.id.option_1, 10);
        sparseIntArray.put(R.id.option_2, 11);
        sparseIntArray.put(R.id.option_3, 12);
        sparseIntArray.put(R.id.option_4, 13);
        sparseIntArray.put(R.id.option_5, 14);
        sparseIntArray.put(R.id.completion_card, 15);
        sparseIntArray.put(R.id.completion_file_name, 16);
        sparseIntArray.put(R.id.completion_select, 17);
        sparseIntArray.put(R.id.completion_upload, 18);
        sparseIntArray.put(R.id.progress_view, 19);
        sparseIntArray.put(R.id.upload_progressbar, 20);
        sparseIntArray.put(R.id.progress_text, 21);
        sparseIntArray.put(R.id.back_btn, 22);
        sparseIntArray.put(R.id.finish_btn, 23);
        sparseIntArray.put(R.id.next_btn, 24);
    }

    public FragmentQuizQuestionsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }

    private FragmentQuizQuestionsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[22], (LinearLayout) bindings[15], (TextView) bindings[16], (TextView) bindings[17], (TextView) bindings[18], (LinearLayout) bindings[5], (TextInputEditText) bindings[7], (TextView) bindings[23], (TextInputLayout) bindings[6], (LinearLayout) bindings[8], (TextView) bindings[24], (RadioButton) bindings[10], (RadioButton) bindings[11], (RadioButton) bindings[12], (RadioButton) bindings[13], (RadioButton) bindings[14], (TextView) bindings[21], (CardView) bindings[19], (ImageView) bindings[4], (TextView) bindings[3], (TextView) bindings[2], (RadioGroup) bindings[9], (ProgressBar) bindings[20]);
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
        if (177 != variableId) {
            return false;
        }
        setQuizQuestionsViewModel((QuizQuestionsViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentQuizQuestionsBinding
    public void setQuizQuestionsViewModel(QuizQuestionsViewModel QuizQuestionsViewModel) {
        this.mQuizQuestionsViewModel = QuizQuestionsViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}