package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.newquiz.viewresult.QuizResultViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentQuizResultBindingImpl extends FragmentQuizResultBinding {
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
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.main_lyt, 3);
        sparseIntArray.put(R.id.hr_view, 4);
        sparseIntArray.put(R.id.multiple_btn, 5);
        sparseIntArray.put(R.id.descriptive_btn, 6);
        sparseIntArray.put(R.id.upload_btn, 7);
        sparseIntArray.put(R.id.swipe_layout, 8);
        sparseIntArray.put(R.id.rv_multiple_quiz, 9);
        sparseIntArray.put(R.id.rv_descriptive_quiz, 10);
        sparseIntArray.put(R.id.rv_upload_quiz, 11);
    }

    public FragmentQuizResultBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentQuizResultBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[6], (HorizontalScrollView) bindings[4], (LinearLayout) bindings[3], (TextView) bindings[5], (RecyclerView) bindings[10], (RecyclerView) bindings[9], (RecyclerView) bindings[11], (SwipeRefreshLayout) bindings[8], (TextView) bindings[2], (TextView) bindings[7]);
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
        if (180 != variableId) {
            return false;
        }
        setQuizResultViewModel((QuizResultViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentQuizResultBinding
    public void setQuizResultViewModel(QuizResultViewModel QuizResultViewModel) {
        this.mQuizResultViewModel = QuizResultViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}