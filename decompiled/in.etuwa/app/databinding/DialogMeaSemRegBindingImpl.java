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
import in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel;

/* loaded from: classes3.dex */
public class DialogMeaSemRegBindingImpl extends DialogMeaSemRegBinding {
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
        sparseIntArray.put(R.id.next_one, 5);
        sparseIntArray.put(R.id.page_two, 6);
        sparseIntArray.put(R.id.back_two, 7);
        sparseIntArray.put(R.id.next_two, 8);
        sparseIntArray.put(R.id.exam_att_tv, 9);
        sparseIntArray.put(R.id.university_previous_layout, 10);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 11);
        sparseIntArray.put(R.id.exam_group, 12);
        sparseIntArray.put(R.id.exam_yes, 13);
        sparseIntArray.put(R.id.exam_no, 14);
        sparseIntArray.put(R.id.back_group, 15);
        sparseIntArray.put(R.id.back_yes, 16);
        sparseIntArray.put(R.id.back_no, 17);
        sparseIntArray.put(R.id.mt_month_year, 18);
        sparseIntArray.put(R.id.et_month_year, 19);
        sparseIntArray.put(R.id.mt_back_papers, 20);
        sparseIntArray.put(R.id.et_back_paper_count, 21);
        sparseIntArray.put(R.id.et_earned_credits, 22);
        sparseIntArray.put(R.id.fee_details_tv, 23);
        sparseIntArray.put(R.id.fee_details_lt, 24);
        sparseIntArray.put(R.id.fee_due, 25);
        sparseIntArray.put(R.id.fee_yes, 26);
        sparseIntArray.put(R.id.fee_no, 27);
        sparseIntArray.put(R.id.mt_bank_name, 28);
        sparseIntArray.put(R.id.et_bank_name, 29);
        sparseIntArray.put(R.id.mt_amount_paid, 30);
        sparseIntArray.put(R.id.et_amount_paid, 31);
        sparseIntArray.put(R.id.mt_date_payment, 32);
        sparseIntArray.put(R.id.et_date_payment, 33);
        sparseIntArray.put(R.id.mt_mode_payment, 34);
        sparseIntArray.put(R.id.et_mode_payment, 35);
        sparseIntArray.put(R.id.mt_ref_no, 36);
        sparseIntArray.put(R.id.et_ref_no, 37);
        sparseIntArray.put(R.id.upload_lyt, 38);
        sparseIntArray.put(R.id.completion_select, 39);
        sparseIntArray.put(R.id.completion_file_name, 40);
        sparseIntArray.put(R.id.concession_btn, 41);
        sparseIntArray.put(R.id.concession_yes, 42);
        sparseIntArray.put(R.id.concession_no, 43);
        sparseIntArray.put(R.id.mt_concession_detsils, 44);
        sparseIntArray.put(R.id.et_concession_details, 45);
        sparseIntArray.put(R.id.register_btn, 46);
        sparseIntArray.put(R.id.progress_view, 47);
        sparseIntArray.put(R.id.upload_progressbar, 48);
        sparseIntArray.put(R.id.progress_text, 49);
    }

    public DialogMeaSemRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 50, sIncludes, sViewsWithIds));
    }

    private DialogMeaSemRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RadioGroup) bindings[15], (RadioButton) bindings[17], (TextView) bindings[4], (TextView) bindings[7], (RadioButton) bindings[16], (TextView) bindings[40], (TextView) bindings[39], (RadioGroup) bindings[41], (RadioButton) bindings[43], (RadioButton) bindings[42], (TextInputEditText) bindings[31], (TextInputEditText) bindings[21], (TextInputEditText) bindings[29], (TextInputEditText) bindings[45], (TextInputEditText) bindings[33], (TextInputEditText) bindings[22], (TextInputEditText) bindings[35], (TextInputEditText) bindings[19], (TextInputEditText) bindings[37], (TextView) bindings[9], (RadioGroup) bindings[12], (RadioButton) bindings[14], (RadioButton) bindings[13], (LinearLayout) bindings[24], (TextView) bindings[23], (RadioGroup) bindings[25], (RadioButton) bindings[27], (RadioButton) bindings[26], (TextInputLayout) bindings[30], (TextInputLayout) bindings[20], (TextInputLayout) bindings[28], (TextInputLayout) bindings[44], (TextInputLayout) bindings[32], (TextInputLayout) bindings[34], (TextInputLayout) bindings[18], (TextInputLayout) bindings[36], (TextView) bindings[5], (TextView) bindings[8], (LinearLayout) bindings[3], (LinearLayout) bindings[6], (TextView) bindings[49], (CardView) bindings[47], (TextView) bindings[46], (Spinner) bindings[11], (LinearLayout) bindings[10], (LinearLayout) bindings[38], (ProgressBar) bindings[48]);
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
        if (137 != variableId) {
            return false;
        }
        setMeaSemRegViewModel((MeaSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogMeaSemRegBinding
    public void setMeaSemRegViewModel(MeaSemRegViewModel MeaSemRegViewModel) {
        this.mMeaSemRegViewModel = MeaSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}