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
import in.etuwa.app.ui.profile.sport.add.AddSportViewModel;

/* loaded from: classes3.dex */
public class DialogAddSportBindingImpl extends DialogAddSportBinding {
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
        sparseIntArray.put(R.id.spinner_competition, 4);
        sparseIntArray.put(R.id.et_name, 5);
        sparseIntArray.put(R.id.et_orgaanised_by, 6);
        sparseIntArray.put(R.id.spinner_type, 7);
        sparseIntArray.put(R.id.spinner_level, 8);
        sparseIntArray.put(R.id.lt_date, 9);
        sparseIntArray.put(R.id.et_date, 10);
        sparseIntArray.put(R.id.spinner_year, 11);
        sparseIntArray.put(R.id.et_award, 12);
        sparseIntArray.put(R.id.completion_card, 13);
        sparseIntArray.put(R.id.completion_file_name, 14);
        sparseIntArray.put(R.id.completion_select, 15);
        sparseIntArray.put(R.id.add_btn, 16);
        sparseIntArray.put(R.id.update_btn, 17);
        sparseIntArray.put(R.id.progress_view, 18);
        sparseIntArray.put(R.id.upload_progressbar, 19);
        sparseIntArray.put(R.id.progress_text, 20);
    }

    public DialogAddSportBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private DialogAddSportBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[16], (LinearLayout) bindings[13], (TextView) bindings[14], (TextView) bindings[15], (TextInputEditText) bindings[12], (TextView) bindings[10], (TextInputEditText) bindings[5], (TextInputEditText) bindings[6], (CardView) bindings[9], (TextView) bindings[20], (CardView) bindings[18], (TextView) bindings[3], (Spinner) bindings[4], (Spinner) bindings[8], (Spinner) bindings[7], (Spinner) bindings[11], (TextView) bindings[17], (ProgressBar) bindings[19]);
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
        if (22 != variableId) {
            return false;
        }
        setAddSportViewModel((AddSportViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogAddSportBinding
    public void setAddSportViewModel(AddSportViewModel AddSportViewModel) {
        this.mAddSportViewModel = AddSportViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}