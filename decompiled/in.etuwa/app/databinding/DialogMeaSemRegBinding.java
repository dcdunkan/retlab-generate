package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel;

/* loaded from: classes3.dex */
public abstract class DialogMeaSemRegBinding extends ViewDataBinding {
    public final RadioGroup backGroup;
    public final RadioButton backNo;
    public final TextView backOne;
    public final TextView backTwo;
    public final RadioButton backYes;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final RadioGroup concessionBtn;
    public final RadioButton concessionNo;
    public final RadioButton concessionYes;
    public final TextInputEditText etAmountPaid;
    public final TextInputEditText etBackPaperCount;
    public final TextInputEditText etBankName;
    public final TextInputEditText etConcessionDetails;
    public final TextInputEditText etDatePayment;
    public final TextInputEditText etEarnedCredits;
    public final TextInputEditText etModePayment;
    public final TextInputEditText etMonthYear;
    public final TextInputEditText etRefNo;
    public final TextView examAttTv;
    public final RadioGroup examGroup;
    public final RadioButton examNo;
    public final RadioButton examYes;
    public final LinearLayout feeDetailsLt;
    public final TextView feeDetailsTv;
    public final RadioGroup feeDue;
    public final RadioButton feeNo;
    public final RadioButton feeYes;

    @Bindable
    protected MeaSemRegViewModel mMeaSemRegViewModel;
    public final TextInputLayout mtAmountPaid;
    public final TextInputLayout mtBackPapers;
    public final TextInputLayout mtBankName;
    public final TextInputLayout mtConcessionDetsils;
    public final TextInputLayout mtDatePayment;
    public final TextInputLayout mtModePayment;
    public final TextInputLayout mtMonthYear;
    public final TextInputLayout mtRefNo;
    public final TextView nextOne;
    public final TextView nextTwo;
    public final LinearLayout pageOne;
    public final LinearLayout pageTwo;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView registerBtn;
    public final Spinner spinnerSemesterLastAttended;
    public final LinearLayout universityPreviousLayout;
    public final LinearLayout uploadLyt;
    public final ProgressBar uploadProgressbar;

    public abstract void setMeaSemRegViewModel(MeaSemRegViewModel meaSemRegViewModel);

    protected DialogMeaSemRegBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioGroup backGroup, RadioButton backNo, TextView backOne, TextView backTwo, RadioButton backYes, TextView completionFileName, TextView completionSelect, RadioGroup concessionBtn, RadioButton concessionNo, RadioButton concessionYes, TextInputEditText etAmountPaid, TextInputEditText etBackPaperCount, TextInputEditText etBankName, TextInputEditText etConcessionDetails, TextInputEditText etDatePayment, TextInputEditText etEarnedCredits, TextInputEditText etModePayment, TextInputEditText etMonthYear, TextInputEditText etRefNo, TextView examAttTv, RadioGroup examGroup, RadioButton examNo, RadioButton examYes, LinearLayout feeDetailsLt, TextView feeDetailsTv, RadioGroup feeDue, RadioButton feeNo, RadioButton feeYes, TextInputLayout mtAmountPaid, TextInputLayout mtBackPapers, TextInputLayout mtBankName, TextInputLayout mtConcessionDetsils, TextInputLayout mtDatePayment, TextInputLayout mtModePayment, TextInputLayout mtMonthYear, TextInputLayout mtRefNo, TextView nextOne, TextView nextTwo, LinearLayout pageOne, LinearLayout pageTwo, TextView progressText, CardView progressView, TextView registerBtn, Spinner spinnerSemesterLastAttended, LinearLayout universityPreviousLayout, LinearLayout uploadLyt, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.backGroup = backGroup;
        this.backNo = backNo;
        this.backOne = backOne;
        this.backTwo = backTwo;
        this.backYes = backYes;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.concessionBtn = concessionBtn;
        this.concessionNo = concessionNo;
        this.concessionYes = concessionYes;
        this.etAmountPaid = etAmountPaid;
        this.etBackPaperCount = etBackPaperCount;
        this.etBankName = etBankName;
        this.etConcessionDetails = etConcessionDetails;
        this.etDatePayment = etDatePayment;
        this.etEarnedCredits = etEarnedCredits;
        this.etModePayment = etModePayment;
        this.etMonthYear = etMonthYear;
        this.etRefNo = etRefNo;
        this.examAttTv = examAttTv;
        this.examGroup = examGroup;
        this.examNo = examNo;
        this.examYes = examYes;
        this.feeDetailsLt = feeDetailsLt;
        this.feeDetailsTv = feeDetailsTv;
        this.feeDue = feeDue;
        this.feeNo = feeNo;
        this.feeYes = feeYes;
        this.mtAmountPaid = mtAmountPaid;
        this.mtBackPapers = mtBackPapers;
        this.mtBankName = mtBankName;
        this.mtConcessionDetsils = mtConcessionDetsils;
        this.mtDatePayment = mtDatePayment;
        this.mtModePayment = mtModePayment;
        this.mtMonthYear = mtMonthYear;
        this.mtRefNo = mtRefNo;
        this.nextOne = nextOne;
        this.nextTwo = nextTwo;
        this.pageOne = pageOne;
        this.pageTwo = pageTwo;
        this.progressText = progressText;
        this.progressView = progressView;
        this.registerBtn = registerBtn;
        this.spinnerSemesterLastAttended = spinnerSemesterLastAttended;
        this.universityPreviousLayout = universityPreviousLayout;
        this.uploadLyt = uploadLyt;
        this.uploadProgressbar = uploadProgressbar;
    }

    public MeaSemRegViewModel getMeaSemRegViewModel() {
        return this.mMeaSemRegViewModel;
    }

    public static DialogMeaSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMeaSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogMeaSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mea_sem_reg, root, attachToRoot, component);
    }

    public static DialogMeaSemRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMeaSemRegBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogMeaSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mea_sem_reg, null, false, component);
    }

    public static DialogMeaSemRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMeaSemRegBinding bind(View view, Object component) {
        return (DialogMeaSemRegBinding) bind(component, view, R.layout.dialog_mea_sem_reg);
    }
}