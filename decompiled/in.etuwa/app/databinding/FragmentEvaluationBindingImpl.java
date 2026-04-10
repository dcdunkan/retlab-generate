package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.evaluation.EvaluationViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentEvaluationBindingImpl extends FragmentEvaluationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.ivSearch, 2);
        sparseIntArray.put(R.id.ivFilter, 3);
        sparseIntArray.put(R.id.search_card, 4);
        sparseIntArray.put(R.id.search_input, 5);
        sparseIntArray.put(R.id.ivClearSearch, 6);
        sparseIntArray.put(R.id.main_lyt, 7);
        sparseIntArray.put(R.id.hr_view, 8);
        sparseIntArray.put(R.id.assignments_btn, 9);
        sparseIntArray.put(R.id.series_btn, 10);
        sparseIntArray.put(R.id.module_btn, 11);
        sparseIntArray.put(R.id.tutorials_btn, 12);
        sparseIntArray.put(R.id.homeworks_btn, 13);
        sparseIntArray.put(R.id.assignment_btn_lyt, 14);
        sparseIntArray.put(R.id.not_submit_btn, 15);
        sparseIntArray.put(R.id.submit_btn, 16);
        sparseIntArray.put(R.id.all_btn, 17);
        sparseIntArray.put(R.id.rv_assignments, 18);
        sparseIntArray.put(R.id.rv_series_exam, 19);
        sparseIntArray.put(R.id.rv_moduletest, 20);
        sparseIntArray.put(R.id.rv_tutorial, 21);
        sparseIntArray.put(R.id.rv_homeworks, 22);
    }

    public FragmentEvaluationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private FragmentEvaluationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[17], (CardView) bindings[14], (TextView) bindings[9], (TextView) bindings[13], (HorizontalScrollView) bindings[8], (ImageView) bindings[6], (ImageView) bindings[3], (ImageView) bindings[2], (LinearLayout) bindings[7], (TextView) bindings[11], (TextView) bindings[15], (RecyclerView) bindings[18], (RecyclerView) bindings[22], (RecyclerView) bindings[20], (RecyclerView) bindings[19], (RecyclerView) bindings[21], (CardView) bindings[4], (EditText) bindings[5], (TextView) bindings[10], (TextView) bindings[16], (TextView) bindings[1], (TextView) bindings[12]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
        if (77 != variableId) {
            return false;
        }
        setEvaluationViewModel((EvaluationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentEvaluationBinding
    public void setEvaluationViewModel(EvaluationViewModel EvaluationViewModel) {
        this.mEvaluationViewModel = EvaluationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}