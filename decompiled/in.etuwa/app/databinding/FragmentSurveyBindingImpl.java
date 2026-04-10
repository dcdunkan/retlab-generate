package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.SurveyViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentSurveyBindingImpl extends FragmentSurveyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final LinearLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.app_bar_layout, 2);
        sparseIntArray.put(R.id.ivFilter, 3);
        sparseIntArray.put(R.id.ivSearch, 4);
        sparseIntArray.put(R.id.search_card, 5);
        sparseIntArray.put(R.id.search_input, 6);
        sparseIntArray.put(R.id.ivClearSearch, 7);
        sparseIntArray.put(R.id.po_survey_btn, 8);
        sparseIntArray.put(R.id.graduate_btn, 9);
        sparseIntArray.put(R.id.course_btn, 10);
        sparseIntArray.put(R.id.chip_group_filter, 11);
        sparseIntArray.put(R.id.chip_open, 12);
        sparseIntArray.put(R.id.chip_pending, 13);
        sparseIntArray.put(R.id.chip_completed, 14);
        sparseIntArray.put(R.id.chip_all, 15);
        sparseIntArray.put(R.id.swipe_layout, 16);
        sparseIntArray.put(R.id.rv_survey, 17);
    }

    public FragmentSurveyBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private FragmentSurveyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppBarLayout) bindings[2], (Chip) bindings[15], (Chip) bindings[14], (ChipGroup) bindings[11], (Chip) bindings[12], (Chip) bindings[13], (CardView) bindings[10], (CardView) bindings[9], (ImageView) bindings[7], (ImageView) bindings[3], (ImageView) bindings[4], (CardView) bindings[8], (RecyclerView) bindings[17], (CardView) bindings[5], (EditText) bindings[6], (SwipeRefreshLayout) bindings[16]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView01 = linearLayout;
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
        if (220 != variableId) {
            return false;
        }
        setSurveyViewModel((SurveyViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentSurveyBinding
    public void setSurveyViewModel(SurveyViewModel SurveyViewModel) {
        this.mSurveyViewModel = SurveyViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}