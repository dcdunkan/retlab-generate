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
import in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentExamRegistrationNewBindingImpl extends FragmentExamRegistrationNewBinding {
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
        sparseIntArray.put(R.id.btn_search, 2);
        sparseIntArray.put(R.id.btn_filter, 3);
        sparseIntArray.put(R.id.search_card, 4);
        sparseIntArray.put(R.id.search_input, 5);
        sparseIntArray.put(R.id.main_lyt, 6);
        sparseIntArray.put(R.id.hr_view, 7);
        sparseIntArray.put(R.id.registration_btn, 8);
        sparseIntArray.put(R.id.result_btn, 9);
        sparseIntArray.put(R.id.revaluation_btn, 10);
        sparseIntArray.put(R.id.fee_receipt_btn, 11);
        sparseIntArray.put(R.id.rv_registration, 12);
        sparseIntArray.put(R.id.rv_exam_results, 13);
        sparseIntArray.put(R.id.rv_revaluation, 14);
        sparseIntArray.put(R.id.rv_receipts, 15);
    }

    public FragmentExamRegistrationNewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private FragmentExamRegistrationNewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[3], (ImageView) bindings[2], (TextView) bindings[11], (HorizontalScrollView) bindings[7], (LinearLayout) bindings[6], (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[10], (RecyclerView) bindings[13], (RecyclerView) bindings[15], (RecyclerView) bindings[12], (RecyclerView) bindings[14], (CardView) bindings[4], (EditText) bindings[5], (TextView) bindings[1]);
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
        if (81 != variableId) {
            return false;
        }
        setExamRegistrationMainNewViewModel((ExamRegistrationMainNewViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentExamRegistrationNewBinding
    public void setExamRegistrationMainNewViewModel(ExamRegistrationMainNewViewModel ExamRegistrationMainNewViewModel) {
        this.mExamRegistrationMainNewViewModel = ExamRegistrationMainNewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}