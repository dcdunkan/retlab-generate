package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel;

/* loaded from: classes3.dex */
public abstract class DialogPalaiSemRegBinding extends ViewDataBinding {
    public final RadioGroup academicDue;
    public final RadioButton academicNo;
    public final RadioButton academicYes;
    public final RadioGroup accountsDue;
    public final RadioButton accountsNo;
    public final RadioButton accountsYes;
    public final TextView backEight;
    public final TextView backFive;
    public final TextView backFour;
    public final RadioGroup backGroup;
    public final RadioButton backNo;
    public final TextView backOne;
    public final TextView backSeven;
    public final TextView backSix;
    public final TextView backThree;
    public final TextView backTwo;
    public final RadioButton backYes;
    public final RadioGroup busDue;
    public final RadioButton busNo;
    public final RadioButton busYes;
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
    public final TextInputEditText etHostelDetails;
    public final TextInputEditText etLibraryDetails;
    public final TextInputEditText etModePayment;
    public final TextInputEditText etMonthYear;
    public final TextInputEditText etPeriodDiscontinued;
    public final TextInputEditText etRefNo;
    public final TextInputEditText etSemOne;
    public final TextView examAttTv;
    public final RadioGroup examGroup;
    public final RadioButton examNo;
    public final RadioButton examYes;
    public final LinearLayout feeDetailsLt;
    public final TextView feeDetailsTv;
    public final RadioGroup feeDue;
    public final RadioButton feeNo;
    public final RadioButton feeYes;
    public final LinearLayout globalElecLt;
    public final TextView globalElecTv;
    public final LinearLayout honorMinorLt;
    public final TextView honorMinorTv;
    public final RadioGroup hostelDue;
    public final RadioButton hostelNo;
    public final RadioButton hostelYes;
    public final RadioGroup libraryDue;
    public final RadioButton libraryNo;
    public final RadioButton libraryYes;

    @Bindable
    protected PalaiNewSemRegViewModel mPalaiNewSemRegViewModel;
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
    public final TextView nextEight;
    public final TextView nextFive;
    public final TextView nextFour;
    public final TextView nextOne;
    public final TextView nextSeven;
    public final TextView nextSix;
    public final TextView nextThree;
    public final TextView nextTwo;
    public final LinearLayout pageEight;
    public final LinearLayout pageFive;
    public final LinearLayout pageFour;
    public final LinearLayout pageOne;
    public final LinearLayout pageSeven;
    public final LinearLayout pageSix;
    public final LinearLayout pageThree;
    public final LinearLayout pageTwo;
    public final LinearLayout prevSemLt;
    public final TextView prevSemTv;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView registerBtn;
    public final TextView semDateEight;
    public final TextView semDateFive;
    public final TextView semDateFour;
    public final EditText semDateOne;
    public final TextView semDateSeven;
    public final TextView semDateSix;
    public final TextView semDateThree;
    public final TextView semDateTwo;
    public final LinearLayout sgpaCgpaLt;
    public final TextView sgpaCgpaTv;
    public final Spinner spinnerPresentHostel;
    public final Spinner spinnerSemesterLastAttended;
    public final LinearLayout supplyLt;
    public final TextView supplyTv;
    public final LinearLayout universityPreviousLayout;
    public final ProgressBar uploadProgressbar;

    public abstract void setPalaiNewSemRegViewModel(PalaiNewSemRegViewModel palaiNewSemRegViewModel);

    protected DialogPalaiSemRegBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioGroup academicDue, RadioButton academicNo, RadioButton academicYes, RadioGroup accountsDue, RadioButton accountsNo, RadioButton accountsYes, TextView backEight, TextView backFive, TextView backFour, RadioGroup backGroup, RadioButton backNo, TextView backOne, TextView backSeven, TextView backSix, TextView backThree, TextView backTwo, RadioButton backYes, RadioGroup busDue, RadioButton busNo, RadioButton busYes, RadioGroup concessionBtn, RadioButton concessionNo, RadioButton concessionYes, RadioGroup departmentDue, RadioButton deptNo, RadioButton deptYes, LinearLayout dueLt, TextView dueTv, TextInputEditText etAcademicDetails, TextInputEditText etAccountsDetails, TextInputEditText etAmountPaid, TextInputEditText etBackPaperCount, TextInputEditText etBankName, TextInputEditText etBusDetails, TextInputEditText etConcessionDetails, TextInputEditText etDatePayment, TextInputEditText etDeptDetails, TextInputEditText etHostelDetails, TextInputEditText etLibraryDetails, TextInputEditText etModePayment, TextInputEditText etMonthYear, TextInputEditText etPeriodDiscontinued, TextInputEditText etRefNo, TextInputEditText etSemOne, TextView examAttTv, RadioGroup examGroup, RadioButton examNo, RadioButton examYes, LinearLayout feeDetailsLt, TextView feeDetailsTv, RadioGroup feeDue, RadioButton feeNo, RadioButton feeYes, LinearLayout globalElecLt, TextView globalElecTv, LinearLayout honorMinorLt, TextView honorMinorTv, RadioGroup hostelDue, RadioButton hostelNo, RadioButton hostelYes, RadioGroup libraryDue, RadioButton libraryNo, RadioButton libraryYes, TextInputLayout mtAcademicDetail, TextInputLayout mtAccountDetail, TextInputLayout mtAmountPaid, TextInputLayout mtBackPapers, TextInputLayout mtBankName, TextInputLayout mtBusDetail, TextInputLayout mtConcessionDetsils, TextInputLayout mtDatePayment, TextInputLayout mtDeptDetail, TextInputLayout mtHostelDetail, TextInputLayout mtLibraryDetail, TextInputLayout mtModePayment, TextInputLayout mtMonthYear, TextInputLayout mtRefNo, TextView nextEight, TextView nextFive, TextView nextFour, TextView nextOne, TextView nextSeven, TextView nextSix, TextView nextThree, TextView nextTwo, LinearLayout pageEight, LinearLayout pageFive, LinearLayout pageFour, LinearLayout pageOne, LinearLayout pageSeven, LinearLayout pageSix, LinearLayout pageThree, LinearLayout pageTwo, LinearLayout prevSemLt, TextView prevSemTv, TextView progressText, CardView progressView, TextView registerBtn, TextView semDateEight, TextView semDateFive, TextView semDateFour, EditText semDateOne, TextView semDateSeven, TextView semDateSix, TextView semDateThree, TextView semDateTwo, LinearLayout sgpaCgpaLt, TextView sgpaCgpaTv, Spinner spinnerPresentHostel, Spinner spinnerSemesterLastAttended, LinearLayout supplyLt, TextView supplyTv, LinearLayout universityPreviousLayout, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.academicDue = academicDue;
        this.academicNo = academicNo;
        this.academicYes = academicYes;
        this.accountsDue = accountsDue;
        this.accountsNo = accountsNo;
        this.accountsYes = accountsYes;
        this.backEight = backEight;
        this.backFive = backFive;
        this.backFour = backFour;
        this.backGroup = backGroup;
        this.backNo = backNo;
        this.backOne = backOne;
        this.backSeven = backSeven;
        this.backSix = backSix;
        this.backThree = backThree;
        this.backTwo = backTwo;
        this.backYes = backYes;
        this.busDue = busDue;
        this.busNo = busNo;
        this.busYes = busYes;
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
        this.etHostelDetails = etHostelDetails;
        this.etLibraryDetails = etLibraryDetails;
        this.etModePayment = etModePayment;
        this.etMonthYear = etMonthYear;
        this.etPeriodDiscontinued = etPeriodDiscontinued;
        this.etRefNo = etRefNo;
        this.etSemOne = etSemOne;
        this.examAttTv = examAttTv;
        this.examGroup = examGroup;
        this.examNo = examNo;
        this.examYes = examYes;
        this.feeDetailsLt = feeDetailsLt;
        this.feeDetailsTv = feeDetailsTv;
        this.feeDue = feeDue;
        this.feeNo = feeNo;
        this.feeYes = feeYes;
        this.globalElecLt = globalElecLt;
        this.globalElecTv = globalElecTv;
        this.honorMinorLt = honorMinorLt;
        this.honorMinorTv = honorMinorTv;
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
        this.nextEight = nextEight;
        this.nextFive = nextFive;
        this.nextFour = nextFour;
        this.nextOne = nextOne;
        this.nextSeven = nextSeven;
        this.nextSix = nextSix;
        this.nextThree = nextThree;
        this.nextTwo = nextTwo;
        this.pageEight = pageEight;
        this.pageFive = pageFive;
        this.pageFour = pageFour;
        this.pageOne = pageOne;
        this.pageSeven = pageSeven;
        this.pageSix = pageSix;
        this.pageThree = pageThree;
        this.pageTwo = pageTwo;
        this.prevSemLt = prevSemLt;
        this.prevSemTv = prevSemTv;
        this.progressText = progressText;
        this.progressView = progressView;
        this.registerBtn = registerBtn;
        this.semDateEight = semDateEight;
        this.semDateFive = semDateFive;
        this.semDateFour = semDateFour;
        this.semDateOne = semDateOne;
        this.semDateSeven = semDateSeven;
        this.semDateSix = semDateSix;
        this.semDateThree = semDateThree;
        this.semDateTwo = semDateTwo;
        this.sgpaCgpaLt = sgpaCgpaLt;
        this.sgpaCgpaTv = sgpaCgpaTv;
        this.spinnerPresentHostel = spinnerPresentHostel;
        this.spinnerSemesterLastAttended = spinnerSemesterLastAttended;
        this.supplyLt = supplyLt;
        this.supplyTv = supplyTv;
        this.universityPreviousLayout = universityPreviousLayout;
        this.uploadProgressbar = uploadProgressbar;
    }

    public PalaiNewSemRegViewModel getPalaiNewSemRegViewModel() {
        return this.mPalaiNewSemRegViewModel;
    }

    public static DialogPalaiSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPalaiSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogPalaiSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_palai_sem_reg, root, attachToRoot, component);
    }

    public static DialogPalaiSemRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPalaiSemRegBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogPalaiSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_palai_sem_reg, null, false, component);
    }

    public static DialogPalaiSemRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPalaiSemRegBinding bind(View view, Object component) {
        return (DialogPalaiSemRegBinding) bind(component, view, R.layout.dialog_palai_sem_reg);
    }
}