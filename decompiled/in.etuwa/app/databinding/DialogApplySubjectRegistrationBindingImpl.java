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
import in.etuwa.app.R;
import in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationViewModel;

/* loaded from: classes3.dex */
public class DialogApplySubjectRegistrationBindingImpl extends DialogApplySubjectRegistrationBinding {
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
        sparseIntArray.put(R.id.semester_lyt, 3);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 4);
        sparseIntArray.put(R.id.semester_tv, 5);
        sparseIntArray.put(R.id.minor_lyt, 6);
        sparseIntArray.put(R.id.spinner_minor, 7);
        sparseIntArray.put(R.id.minor2_lyt, 8);
        sparseIntArray.put(R.id.spinner_minor2, 9);
        sparseIntArray.put(R.id.minor3_lyt, 10);
        sparseIntArray.put(R.id.spinner_minor3, 11);
        sparseIntArray.put(R.id.honour_lyt, 12);
        sparseIntArray.put(R.id.spinner_honour, 13);
        sparseIntArray.put(R.id.elective1_lyt, 14);
        sparseIntArray.put(R.id.spinner_elective1, 15);
        sparseIntArray.put(R.id.elective2_lyt, 16);
        sparseIntArray.put(R.id.spinner_elective2, 17);
        sparseIntArray.put(R.id.elective3_lyt, 18);
        sparseIntArray.put(R.id.spinner_elective3, 19);
        sparseIntArray.put(R.id.global_elective_lyt, 20);
        sparseIntArray.put(R.id.spinner_global_elective, 21);
        sparseIntArray.put(R.id.additional_elective1_lyt, 22);
        sparseIntArray.put(R.id.spinner_additional_elective1, 23);
        sparseIntArray.put(R.id.additional_elective2_lyt, 24);
        sparseIntArray.put(R.id.spinner_additional_elective2, 25);
        sparseIntArray.put(R.id.additional_elective3_lyt, 26);
        sparseIntArray.put(R.id.spinner_additional_elective3, 27);
        sparseIntArray.put(R.id.mdc1_lyt, 28);
        sparseIntArray.put(R.id.spinner_mdc1, 29);
        sparseIntArray.put(R.id.mdc2_lyt, 30);
        sparseIntArray.put(R.id.spinner_mdc2, 31);
        sparseIntArray.put(R.id.mdc3_lyt, 32);
        sparseIntArray.put(R.id.spinner_mdc3, 33);
        sparseIntArray.put(R.id.aec1_lyt, 34);
        sparseIntArray.put(R.id.spinner_aec1, 35);
        sparseIntArray.put(R.id.aec2_lyt, 36);
        sparseIntArray.put(R.id.spinner_aec2, 37);
        sparseIntArray.put(R.id.aec3_lyt, 38);
        sparseIntArray.put(R.id.spinner_aec3, 39);
        sparseIntArray.put(R.id.dsc1_lyt, 40);
        sparseIntArray.put(R.id.spinner_dsc1, 41);
        sparseIntArray.put(R.id.dsc2_lyt, 42);
        sparseIntArray.put(R.id.spinner_dsc2, 43);
        sparseIntArray.put(R.id.dsc3_lyt, 44);
        sparseIntArray.put(R.id.spinner_dsc3, 45);
        sparseIntArray.put(R.id.register_btn, 46);
        sparseIntArray.put(R.id.progress_view, 47);
        sparseIntArray.put(R.id.upload_progressbar, 48);
        sparseIntArray.put(R.id.progress_text, 49);
    }

    public DialogApplySubjectRegistrationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 50, sIncludes, sViewsWithIds));
    }

    private DialogApplySubjectRegistrationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[22], (LinearLayout) bindings[24], (LinearLayout) bindings[26], (LinearLayout) bindings[34], (LinearLayout) bindings[36], (LinearLayout) bindings[38], (LinearLayout) bindings[40], (LinearLayout) bindings[42], (LinearLayout) bindings[44], (LinearLayout) bindings[14], (LinearLayout) bindings[16], (LinearLayout) bindings[18], (LinearLayout) bindings[20], (LinearLayout) bindings[12], (LinearLayout) bindings[28], (LinearLayout) bindings[30], (LinearLayout) bindings[32], (LinearLayout) bindings[8], (LinearLayout) bindings[10], (LinearLayout) bindings[6], (TextView) bindings[49], (CardView) bindings[47], (TextView) bindings[46], (LinearLayout) bindings[3], (TextView) bindings[5], (Spinner) bindings[23], (Spinner) bindings[25], (Spinner) bindings[27], (Spinner) bindings[35], (Spinner) bindings[37], (Spinner) bindings[39], (Spinner) bindings[41], (Spinner) bindings[43], (Spinner) bindings[45], (Spinner) bindings[15], (Spinner) bindings[17], (Spinner) bindings[19], (Spinner) bindings[21], (Spinner) bindings[13], (Spinner) bindings[29], (Spinner) bindings[31], (Spinner) bindings[33], (Spinner) bindings[7], (Spinner) bindings[9], (Spinner) bindings[11], (Spinner) bindings[4], (ProgressBar) bindings[48]);
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
        if (27 != variableId) {
            return false;
        }
        setApplySubjectRegistrationViewModel((ApplySubjectRegistrationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogApplySubjectRegistrationBinding
    public void setApplySubjectRegistrationViewModel(ApplySubjectRegistrationViewModel ApplySubjectRegistrationViewModel) {
        this.mApplySubjectRegistrationViewModel = ApplySubjectRegistrationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}