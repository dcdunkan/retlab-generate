package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegViewModel;
import in.etuwa.app.utils.CustomEditText;

/* loaded from: classes3.dex */
public class DialogApplyPreferenceSubRegBindingImpl extends DialogApplyPreferenceSubRegBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.spinner_semester_last_attended, 1);
        sparseIntArray.put(R.id.sem_tv, 2);
        sparseIntArray.put(R.id.spinner_pathway, 3);
        sparseIntArray.put(R.id.spinner_category, 4);
        sparseIntArray.put(R.id.subjects_btn, 5);
        sparseIntArray.put(R.id.sem_history_btn, 6);
        sparseIntArray.put(R.id.rv_question_no, 7);
        sparseIntArray.put(R.id.sem_question_lyt, 8);
        sparseIntArray.put(R.id.rv_semester_no, 9);
        sparseIntArray.put(R.id.semester_details_lyt, 10);
        sparseIntArray.put(R.id.cv_sgpa, 11);
        sparseIntArray.put(R.id.sgpa_mark, 12);
        sparseIntArray.put(R.id.rv_sem_list, 13);
        sparseIntArray.put(R.id.subjects_lyt, 14);
        sparseIntArray.put(R.id.pref_lyt_one, 15);
        sparseIntArray.put(R.id.spinner_preference_one, 16);
        sparseIntArray.put(R.id.add_btn, 17);
        sparseIntArray.put(R.id.pref_lyt_two, 18);
        sparseIntArray.put(R.id.spinner_preference_two, 19);
        sparseIntArray.put(R.id.remove_btn_one, 20);
        sparseIntArray.put(R.id.pref_lyt_three, 21);
        sparseIntArray.put(R.id.spinner_preference_three, 22);
        sparseIntArray.put(R.id.remove_btn_two, 23);
        sparseIntArray.put(R.id.pref_lyt_four, 24);
        sparseIntArray.put(R.id.spinner_preference_four, 25);
        sparseIntArray.put(R.id.remove_btn_three, 26);
        sparseIntArray.put(R.id.pref_lyt_five, 27);
        sparseIntArray.put(R.id.spinner_preference_five, 28);
        sparseIntArray.put(R.id.remove_btn_four, 29);
        sparseIntArray.put(R.id.back_btn, 30);
        sparseIntArray.put(R.id.question_tv, 31);
        sparseIntArray.put(R.id.finish_btn, 32);
        sparseIntArray.put(R.id.next_btn, 33);
    }

    public DialogApplyPreferenceSubRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 34, sIncludes, sViewsWithIds));
    }

    private DialogApplyPreferenceSubRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[17], (TextView) bindings[30], (CardView) bindings[11], (TextView) bindings[32], (TextView) bindings[33], (FrameLayout) bindings[27], (FrameLayout) bindings[24], (FrameLayout) bindings[15], (FrameLayout) bindings[21], (FrameLayout) bindings[18], (TextView) bindings[31], (TextView) bindings[29], (TextView) bindings[20], (TextView) bindings[26], (TextView) bindings[23], (RecyclerView) bindings[7], (RecyclerView) bindings[13], (RecyclerView) bindings[9], (TextView) bindings[6], (LinearLayout) bindings[8], (TextView) bindings[2], (LinearLayout) bindings[10], (CustomEditText) bindings[12], (Spinner) bindings[4], (Spinner) bindings[3], (Spinner) bindings[28], (Spinner) bindings[25], (Spinner) bindings[16], (Spinner) bindings[22], (Spinner) bindings[19], (Spinner) bindings[1], (TextView) bindings[5], (LinearLayout) bindings[14]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
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
        if (27 != variableId) {
            return false;
        }
        setApplyPreferenceSubRegViewModel((ApplyPreferenceSubRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogApplyPreferenceSubRegBinding
    public void setApplyPreferenceSubRegViewModel(ApplyPreferenceSubRegViewModel ApplyPreferenceSubRegViewModel) {
        this.mApplyPreferenceSubRegViewModel = ApplyPreferenceSubRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}