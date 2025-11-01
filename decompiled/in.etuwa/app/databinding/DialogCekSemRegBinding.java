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
public abstract class DialogCekSemRegBinding extends ViewDataBinding {
    public final RadioGroup academicDue;
    public final RadioButton academicNo;
    public final RadioButton academicYes;
    public final RadioGroup accountsDue;
    public final RadioButton accountsNo;
    public final RadioButton accountsYes;
    public final RadioGroup backGroup;
    public final RadioButton backNo;
    public final TextView backOne;
    public final TextView backThree;
    public final TextView backTwo;
    public final RadioButton backYes;
    public final RadioGroup busDue;
    public final RadioButton busNo;
    public final RadioButton busYes;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final RadioGroup concessionBtn;
    public final RadioButton concessionNo;
    public final RadioButton concessionYes;
    public final RadioGroup departmentDue;
    public final RadioButton deptNo;
    public final RadioButton deptYes;
    public final LinearLayout dueLt;
    public final TextView dueTv;
    public final TextInputEditText etAcademicDetails;
    public final TextInputEditText etAccountsDetails;
    public final TextInputEditText etAmountPaid;
    public final TextInputEditText etBackPaperCount;
    public final TextInputEditText etBankName;
    public final TextInputEditText etBusDetails;
    public final TextInputEditText etConcessionDetails;
    public final TextInputEditText etDatePayment;
    public final TextInputEditText etDeptDetails;
    public final TextInputEditText etEarnedCredits;
    public final TextInputEditText etHostelDetails;
    public final TextInputEditText etLibraryDetails;
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
    public final RadioGroup hostelDue;
    public final RadioButton hostelNo;
    public final RadioButton hostelYes;
    public final RadioGroup libraryDue;
    public final RadioButton libraryNo;
    public final RadioButton libraryYes;

    @Bindable
    protected MeaSemRegViewModel mMeaSemRegViewModel;
    public final TextInputLayout mtAcademicDetail;
    public final TextInputLayout mtAccountDetail;
    public final TextInputLayout mtAmountPaid;
    public final TextInputLayout mtBackPapers;
    public final TextInputLayout mtBankName;
    public final TextInputLayout mtBusDetail;
    public final TextInputLayout mtConcessionDetsils;
    public final TextInputLayout mtDatePayment;
    public final TextInputLayout mtDeptDetail;
    public final TextInputLayout mtHostelDetail;
    public final TextInputLayout mtLibraryDetail;
    public final TextInputLayout mtModePayment;
    public final TextInputLayout mtMonthYear;
    public final TextInputLayout mtRefNo;
    public final TextView nextOne;
    public final TextView nextThree;
    public final TextView nextTwo;
    public final LinearLayout pageOne;
    public final LinearLayout pageThree;
    public final LinearLayout pageTwo;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView registerBtn;
    public final Spinner spinnerSemesterLastAttended;
    public final LinearLayout universityPreviousLayout;
    public final LinearLayout uploadLyt;
    public final ProgressBar uploadProgressbar;

    public abstract void setMeaSemRegViewModel(MeaSemRegViewModel meaSemRegViewModel);

    protected DialogCekSemRegBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioGroup academicDue, RadioButton academicNo, RadioButton academicYes, RadioGroup accountsDue, RadioButton accountsNo, RadioButton accountsYes, RadioGroup backGroup, RadioButton backNo, TextView backOne, TextView backThree, TextView backTwo, RadioButton backYes, RadioGroup busDue, RadioButton busNo, RadioButton busYes, TextView completionFileName, TextView completionSelect, RadioGroup concessionBtn, RadioButton concessionNo, RadioButton concessionYes, RadioGroup departmentDue, RadioButton deptNo, RadioButton deptYes, LinearLayout dueLt, TextView dueTv, TextInputEditText etAcademicDetails, TextInputEditText etAccountsDetails, TextInputEditText etAmountPaid, TextInputEditText etBackPaperCount, TextInputEditText etBankName, TextInputEditText etBusDetails, TextInputEditText etConcessionDetails, TextInputEditText etDatePayment, TextInputEditText etDeptDetails, TextInputEditText etEarnedCredits, TextInputEditText etHostelDetails, TextInputEditText etLibraryDetails, TextInputEditText etModePayment, TextInputEditText etMonthYear, TextInputEditText etRefNo, TextView examAttTv, RadioGroup examGroup, RadioButton examNo, RadioButton examYes, LinearLayout feeDetailsLt, TextView feeDetailsTv, RadioGroup feeDue, RadioButton feeNo, RadioButton feeYes, RadioGroup hostelDue, RadioButton hostelNo, RadioButton hostelYes, RadioGroup libraryDue, RadioButton libraryNo, RadioButton libraryYes, TextInputLayout mtAcademicDetail, TextInputLayout mtAccountDetail, TextInputLayout mtAmountPaid, TextInputLayout mtBackPapers, TextInputLayout mtBankName, TextInputLayout mtBusDetail, TextInputLayout mtConcessionDetsils, TextInputLayout mtDatePayment, TextInputLayout mtDeptDetail, TextInputLayout mtHostelDetail, TextInputLayout mtLibraryDetail, TextInputLayout mtModePayment, TextInputLayout mtMonthYear, TextInputLayout mtRefNo, TextView nextOne, TextView nextThree, TextView nextTwo, LinearLayout pageOne, LinearLayout pageThree, LinearLayout pageTwo, TextView progressText, CardView progressView, TextView registerBtn, Spinner spinnerSemesterLastAttended, LinearLayout universityPreviousLayout, LinearLayout uploadLyt, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.academicDue = academicDue;
        this.academicNo = academicNo;
        this.academicYes = academicYes;
        this.accountsDue = accountsDue;
        this.accountsNo = accountsNo;
        this.accountsYes = accountsYes;
        this.backGroup = backGroup;
        this.backNo = backNo;
        this.backOne = backOne;
        this.backThree = backThree;
        this.backTwo = backTwo;
        this.backYes = backYes;
        this.busDue = busDue;
        this.busNo = busNo;
        this.busYes = busYes;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.concessionBtn = concessionBtn;
        this.concessionNo = concessionNo;
        this.concessionYes = concessionYes;
        this.departmentDue = departmentDue;
        this.deptNo = deptNo;
        this.deptYes = deptYes;
        this.dueLt = dueLt;
        this.dueTv = dueTv;
        this.etAcademicDetails = etAcademicDetails;
        this.etAccountsDetails = etAccountsDetails;
        this.etAmountPaid = etAmountPaid;
        this.etBackPaperCount = etBackPaperCount;
        this.etBankName = etBankName;
        this.etBusDetails = etBusDetails;
        this.etConcessionDetails = etConcessionDetails;
        this.etDatePayment = etDatePayment;
        this.etDeptDetails = etDeptDetails;
        this.etEarnedCredits = etEarnedCredits;
        this.etHostelDetails = etHostelDetails;
        this.etLibraryDetails = etLibraryDetails;
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
        this.hostelDue = hostelDue;
        this.hostelNo = hostelNo;
        this.hostelYes = hostelYes;
        this.libraryDue = libraryDue;
        this.libraryNo = libraryNo;
        this.libraryYes = libraryYes;
        this.mtAcademicDetail = mtAcademicDetail;
        this.mtAccountDetail = mtAccountDetail;
        this.mtAmountPaid = mtAmountPaid;
        this.mtBackPapers = mtBackPapers;
        this.mtBankName = mtBankName;
        this.mtBusDetail = mtBusDetail;
        this.mtConcessionDetsils = mtConcessionDetsils;
        this.mtDatePayment = mtDatePayment;
        this.mtDeptDetail = mtDeptDetail;
        this.mtHostelDetail = mtHostelDetail;
        this.mtLibraryDetail = mtLibraryDetail;
        this.mtModePayment = mtModePayment;
        this.mtMonthYear = mtMonthYear;
        this.mtRefNo = mtRefNo;
        this.nextOne = nextOne;
        this.nextThree = nextThree;
        this.nextTwo = nextTwo;
        this.pageOne = pageOne;
        this.pageThree = pageThree;
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

    public static DialogCekSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCekSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogCekSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_cek_sem_reg, root, attachToRoot, component);
    }

    public static DialogCekSemRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCekSemRegBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogCekSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_cek_sem_reg, null, false, component);
    }

    public static DialogCekSemRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCekSemRegBinding bind(View view, Object component) {
        return (DialogCekSemRegBinding) bind(component, view, R.layout.dialog_cek_sem_reg);
    }
}