package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.questionbank.QuestionBankViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class QuestionBankFragmentBindingImpl extends QuestionBankFragmentBinding {
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
        sparseIntArray.put(R.id.ivSearch, 3);
        sparseIntArray.put(R.id.spinner_sem, 4);
        sparseIntArray.put(R.id.search_card, 5);
        sparseIntArray.put(R.id.search_input, 6);
        sparseIntArray.put(R.id.ivClearSearch, 7);
        sparseIntArray.put(R.id.spinner_fill, 8);
        sparseIntArray.put(R.id.swipe_layout, 9);
        sparseIntArray.put(R.id.rv_question, 10);
    }

    public QuestionBankFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private QuestionBankFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[7], (ImageView) bindings[3], (RecyclerView) bindings[10], (CardView) bindings[5], (EditText) bindings[6], (Spinner) bindings[8], (ImageView) bindings[4], (SwipeRefreshLayout) bindings[9], (TextView) bindings[2]);
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
        setQuestionBankViewModel((QuestionBankViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.QuestionBankFragmentBinding
    public void setQuestionBankViewModel(QuestionBankViewModel QuestionBankViewModel) {
        this.mQuestionBankViewModel = QuestionBankViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}