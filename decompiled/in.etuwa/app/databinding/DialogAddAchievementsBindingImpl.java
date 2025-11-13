package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.achievements.add.AddAchievementsViewModel;

/* loaded from: classes3.dex */
public class DialogAddAchievementsBindingImpl extends DialogAddAchievementsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final FrameLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.reg_title, 3);
        sparseIntArray.put(R.id.et_details, 4);
        sparseIntArray.put(R.id.spinner_year, 5);
        sparseIntArray.put(R.id.completion_card, 6);
        sparseIntArray.put(R.id.completion_file_name, 7);
        sparseIntArray.put(R.id.completion_select, 8);
        sparseIntArray.put(R.id.add_btn, 9);
        sparseIntArray.put(R.id.update_btn, 10);
        sparseIntArray.put(R.id.progress_view, 11);
        sparseIntArray.put(R.id.upload_progressbar, 12);
        sparseIntArray.put(R.id.progress_text, 13);
    }

    public DialogAddAchievementsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private DialogAddAchievementsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (LinearLayout) bindings[6], (TextView) bindings[7], (TextView) bindings[8], (TextInputEditText) bindings[4], (TextView) bindings[13], (CardView) bindings[11], (TextView) bindings[3], (Spinner) bindings[5], (TextView) bindings[10], (ProgressBar) bindings[12]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[1];
        this.mboundView1 = frameLayout;
        frameLayout.setTag(null);
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
        if (8 != variableId) {
            return false;
        }
        setAddAchievementsViewModel((AddAchievementsViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogAddAchievementsBinding
    public void setAddAchievementsViewModel(AddAchievementsViewModel AddAchievementsViewModel) {
        this.mAddAchievementsViewModel = AddAchievementsViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}