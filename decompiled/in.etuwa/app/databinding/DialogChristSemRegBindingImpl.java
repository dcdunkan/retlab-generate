package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel;

/* loaded from: classes3.dex */
public class DialogChristSemRegBindingImpl extends DialogChristSemRegBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;
    private final FrameLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.page_one, 3);
        sparseIntArray.put(R.id.back_one, 4);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 5);
        sparseIntArray.put(R.id.due_tv, 6);
        sparseIntArray.put(R.id.due_lt, 7);
        sparseIntArray.put(R.id.department_due, 8);
        sparseIntArray.put(R.id.dept_yes, 9);
        sparseIntArray.put(R.id.dept_no, 10);
        sparseIntArray.put(R.id.mt_dept_detail, 11);
        sparseIntArray.put(R.id.et_dept_details, 12);
        sparseIntArray.put(R.id.library_due, 13);
        sparseIntArray.put(R.id.library_yes, 14);
        sparseIntArray.put(R.id.library_no, 15);
        sparseIntArray.put(R.id.mt_library_detail, 16);
        sparseIntArray.put(R.id.et_library_details, 17);
        sparseIntArray.put(R.id.accounts_due, 18);
        sparseIntArray.put(R.id.accounts_yes, 19);
        sparseIntArray.put(R.id.accounts_no, 20);
        sparseIntArray.put(R.id.mt_account_detail, 21);
        sparseIntArray.put(R.id.et_accounts_details, 22);
        sparseIntArray.put(R.id.academic_due, 23);
        sparseIntArray.put(R.id.academic_yes, 24);
        sparseIntArray.put(R.id.academic_no, 25);
        sparseIntArray.put(R.id.mt_academic_detail, 26);
        sparseIntArray.put(R.id.et_academic_details, 27);
        sparseIntArray.put(R.id.hostel_due, 28);
        sparseIntArray.put(R.id.hostel_yes, 29);
        sparseIntArray.put(R.id.hostel_no, 30);
        sparseIntArray.put(R.id.mt_hostel_detail, 31);
        sparseIntArray.put(R.id.et_hostel_details, 32);
        sparseIntArray.put(R.id.bus_due, 33);
        sparseIntArray.put(R.id.bus_yes, 34);
        sparseIntArray.put(R.id.bus_no, 35);
        sparseIntArray.put(R.id.mt_bus_detail, 36);
        sparseIntArray.put(R.id.et_bus_details, 37);
        sparseIntArray.put(R.id.register_btn, 38);
        sparseIntArray.put(R.id.progress_view, 39);
        sparseIntArray.put(R.id.upload_progressbar, 40);
        sparseIntArray.put(R.id.progress_text, 41);
    }

    public DialogChristSemRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 42, sIncludes, sViewsWithIds));
    }

    private DialogChristSemRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RadioGroup) bindings[23], (RadioButton) bindings[25], (RadioButton) bindings[24], (RadioGroup) bindings[18], (RadioButton) bindings[20], (RadioButton) bindings[19], (TextView) bindings[4], (RadioGroup) bindings[33], (RadioButton) bindings[35], (RadioButton) bindings[34], (RadioGroup) bindings[8], (RadioButton) bindings[10], (RadioButton) bindings[9], (LinearLayout) bindings[7], (TextView) bindings[6], (TextInputEditText) bindings[27], (TextInputEditText) bindings[22], (TextInputEditText) bindings[37], (TextInputEditText) bindings[12], (TextInputEditText) bindings[32], (TextInputEditText) bindings[17], (RadioGroup) bindings[28], (RadioButton) bindings[30], (RadioButton) bindings[29], (RadioGroup) bindings[13], (RadioButton) bindings[15], (RadioButton) bindings[14], (TextInputLayout) bindings[26], (TextInputLayout) bindings[21], (TextInputLayout) bindings[36], (TextInputLayout) bindings[11], (TextInputLayout) bindings[31], (TextInputLayout) bindings[16], (LinearLayout) bindings[3], (TextView) bindings[41], (CardView) bindings[39], (TextView) bindings[38], (Spinner) bindings[5], (ProgressBar) bindings[40]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) bindings[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
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
        if (53 != variableId) {
            return false;
        }
        setChristSemRegViewModel((ChristSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogChristSemRegBinding
    public void setChristSemRegViewModel(ChristSemRegViewModel ChristSemRegViewModel) {
        this.mChristSemRegViewModel = ChristSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}