package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegViewModel;

/* loaded from: classes3.dex */
public class FragmentAsietSemRegBindingImpl extends FragmentAsietSemRegBinding {
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
        sparseIntArray.put(R.id.swipe_layout, 2);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 3);
        sparseIntArray.put(R.id.mt_address, 4);
        sparseIntArray.put(R.id.et_address, 5);
        sparseIntArray.put(R.id.mt_parent_no, 6);
        sparseIntArray.put(R.id.et_parent_no, 7);
        sparseIntArray.put(R.id.mt_parent_email, 8);
        sparseIntArray.put(R.id.et_parent_email, 9);
        sparseIntArray.put(R.id.attendance_one, 10);
        sparseIntArray.put(R.id.mt_sem1, 11);
        sparseIntArray.put(R.id.et_sem1, 12);
        sparseIntArray.put(R.id.mt_sub1, 13);
        sparseIntArray.put(R.id.et_sub1, 14);
        sparseIntArray.put(R.id.mt_reason1, 15);
        sparseIntArray.put(R.id.et_reason1, 16);
        sparseIntArray.put(R.id.attendance_two, 17);
        sparseIntArray.put(R.id.mt_sem2, 18);
        sparseIntArray.put(R.id.et_sem2, 19);
        sparseIntArray.put(R.id.mt_sub2, 20);
        sparseIntArray.put(R.id.et_sub2, 21);
        sparseIntArray.put(R.id.mt_reason2, 22);
        sparseIntArray.put(R.id.et_reason2, 23);
        sparseIntArray.put(R.id.attendance_three, 24);
        sparseIntArray.put(R.id.mt_sem3, 25);
        sparseIntArray.put(R.id.et_sem3, 26);
        sparseIntArray.put(R.id.mt_sub3, 27);
        sparseIntArray.put(R.id.et_sub3, 28);
        sparseIntArray.put(R.id.mt_reason3, 29);
        sparseIntArray.put(R.id.et_reason3, 30);
        sparseIntArray.put(R.id.add_btn, 31);
        sparseIntArray.put(R.id.remove_btn, 32);
        sparseIntArray.put(R.id.quality_details_btn, 33);
        sparseIntArray.put(R.id.funded_details_btn, 34);
        sparseIntArray.put(R.id.certificate_details_btn, 35);
        sparseIntArray.put(R.id.mooc_details_btn, 36);
        sparseIntArray.put(R.id.project_details_btn, 37);
        sparseIntArray.put(R.id.scholarships_details_btn, 38);
        sparseIntArray.put(R.id.sports_details_btn, 39);
        sparseIntArray.put(R.id.position_details_btn, 40);
        sparseIntArray.put(R.id.membership_details_btn, 41);
        sparseIntArray.put(R.id.other_details_btn, 42);
        sparseIntArray.put(R.id.register_btn, 43);
    }

    public FragmentAsietSemRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 44, sIncludes, sViewsWithIds));
    }

    private FragmentAsietSemRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[31], (LinearLayout) bindings[10], (LinearLayout) bindings[24], (LinearLayout) bindings[17], (TextView) bindings[35], (TextInputEditText) bindings[5], (TextInputEditText) bindings[9], (TextInputEditText) bindings[7], (TextInputEditText) bindings[16], (TextInputEditText) bindings[23], (TextInputEditText) bindings[30], (TextInputEditText) bindings[12], (TextInputEditText) bindings[19], (TextInputEditText) bindings[26], (TextInputEditText) bindings[14], (TextInputEditText) bindings[21], (TextInputEditText) bindings[28], (TextView) bindings[34], (TextView) bindings[41], (TextView) bindings[36], (TextInputLayout) bindings[4], (TextInputLayout) bindings[8], (TextInputLayout) bindings[6], (TextInputLayout) bindings[15], (TextInputLayout) bindings[22], (TextInputLayout) bindings[29], (TextInputLayout) bindings[11], (TextInputLayout) bindings[18], (TextInputLayout) bindings[25], (TextInputLayout) bindings[13], (TextInputLayout) bindings[20], (TextInputLayout) bindings[27], (TextView) bindings[42], (TextView) bindings[40], (TextView) bindings[37], (TextView) bindings[33], (Button) bindings[43], (TextView) bindings[32], (TextView) bindings[38], (Spinner) bindings[3], (TextView) bindings[39], (SwipeRefreshLayout) bindings[2]);
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
        if (28 != variableId) {
            return false;
        }
        setAsietSemRegViewModel((AsietSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentAsietSemRegBinding
    public void setAsietSemRegViewModel(AsietSemRegViewModel AsietSemRegViewModel) {
        this.mAsietSemRegViewModel = AsietSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}