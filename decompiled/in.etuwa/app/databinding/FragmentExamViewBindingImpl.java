package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel;

/* loaded from: classes3.dex */
public class FragmentExamViewBindingImpl extends FragmentExamViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final CardView mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.due_layout, 3);
        sparseIntArray.put(R.id.tv_sub_name, 4);
        sparseIntArray.put(R.id.tv_degree, 5);
        sparseIntArray.put(R.id.tv_semester, 6);
        sparseIntArray.put(R.id.tv_start_date, 7);
        sparseIntArray.put(R.id.tv_end_date, 8);
        sparseIntArray.put(R.id.tv_academic_year, 9);
        sparseIntArray.put(R.id.tv_month, 10);
        sparseIntArray.put(R.id.tv_year, 11);
        sparseIntArray.put(R.id.swipe_layout, 12);
        sparseIntArray.put(R.id.rv_reg_history, 13);
        sparseIntArray.put(R.id.error_lyt, 14);
        sparseIntArray.put(R.id.error_tv, 15);
        sparseIntArray.put(R.id.updation_layout, 16);
        sparseIntArray.put(R.id.pay_slip_btn, 17);
        sparseIntArray.put(R.id.updation_btn, 18);
        sparseIntArray.put(R.id.register_layout, 19);
        sparseIntArray.put(R.id.register_btn, 20);
    }

    public FragmentExamViewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private FragmentExamViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[3], (LinearLayout) bindings[14], (TextView) bindings[15], (TextView) bindings[17], (TextView) bindings[20], (LinearLayout) bindings[19], (RecyclerView) bindings[13], (LinearLayout) bindings[12], (TextView) bindings[9], (TextView) bindings[5], (TextView) bindings[8], (TextView) bindings[10], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[4], (TextView) bindings[11], (TextView) bindings[18], (LinearLayout) bindings[16]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        CardView cardView = (CardView) bindings[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
        Object obj = bindings[2];
        this.mboundView11 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
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
        if (85 != variableId) {
            return false;
        }
        setExamViewViewModel((ExamViewViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentExamViewBinding
    public void setExamViewViewModel(ExamViewViewModel ExamViewViewModel) {
        this.mExamViewViewModel = ExamViewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}