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
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.edit.SemRegViewModel;

/* loaded from: classes3.dex */
public abstract class SemRegFragmentBinding extends ViewDataBinding {
    public final RadioGroup academicGroup;
    public final RadioButton academicNo;
    public final RadioButton academicYes;
    public final RadioGroup accountsGroup;
    public final RadioButton accountsNo;
    public final RadioButton accountsYes;
    public final RadioButton backNo;
    public final RadioGroup backPaperGroup;
    public final RadioButton backYes;
    public final RadioGroup busGroup;
    public final RadioButton busNo;
    public final RadioButton busYes;
    public final CardView cardDue;
    public final CardView cardFeeDetails;
    public final TextView chooseFileBtn;
    public final RadioGroup departmentGroup;
    public final RadioButton departmentNo;
    public final RadioButton departmentYes;
    public final RadioGroup eGrandGroup;
    public final RadioButton eGrandNo;
    public final RadioButton eGrandYes;
    public final TextInputEditText etSemAcademicDue;
    public final TextInputEditText etSemAccountDue;
    public final TextInputEditText etSemAmount;
    public final TextInputEditText etSemBankName;
    public final TextInputEditText etSemBusDue;
    public final TextInputEditText etSemCountBackPaper;
    public final TextInputEditText etSemDepartmentDue;
    public final TextInputEditText etSemEarnedCredit;
    public final TextInputEditText etSemFeeConcessionCategory;
    public final TextInputEditText etSemHostelDue;
    public final TextInputEditText etSemLibraryDue;
    public final TextInputEditText etSemModeOfPayment;
    public final TextInputEditText etSemMonthYear;
    public final TextInputEditText etSemPaidDate;
    public final TextInputEditText etSemRefNo;
    public final TextView etSemSubmitBtn;
    public final RadioGroup examGroup;
    public final RadioButton examNo;
    public final RadioButton examYes;
    public final LinearLayout feeLayout;
    public final RadioButton feeNo;
    public final RadioGroup feePaidGroup;
    public final RadioButton feeYes;
    public final RadioGroup hostelGroup;
    public final RadioButton hostelNo;
    public final RadioButton hostelYes;
    public final RadioGroup libraryGroup;
    public final RadioButton libraryNo;
    public final RadioButton libraryYes;

    @Bindable
    protected SemRegViewModel mSemRegViewModel;
    public final TextView payFeeBtn;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final TextView semLastAttended;
    public final LinearLayout spinnerLayout;
    public final LinearLayout spinnerLayout2;
    public final Spinner spinnerSemReg;
    public final TextView tvSemRegFilePath;
    public final ProgressBar uploadProgressbar;

    public abstract void setSemRegViewModel(SemRegViewModel semRegViewModel);

    protected SemRegFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioGroup academicGroup, RadioButton academicNo, RadioButton academicYes, RadioGroup accountsGroup, RadioButton accountsNo, RadioButton accountsYes, RadioButton backNo, RadioGroup backPaperGroup, RadioButton backYes, RadioGroup busGroup, RadioButton busNo, RadioButton busYes, CardView cardDue, CardView cardFeeDetails, TextView chooseFileBtn, RadioGroup departmentGroup, RadioButton departmentNo, RadioButton departmentYes, RadioGroup eGrandGroup, RadioButton eGrandNo, RadioButton eGrandYes, TextInputEditText etSemAcademicDue, TextInputEditText etSemAccountDue, TextInputEditText etSemAmount, TextInputEditText etSemBankName, TextInputEditText etSemBusDue, TextInputEditText etSemCountBackPaper, TextInputEditText etSemDepartmentDue, TextInputEditText etSemEarnedCredit, TextInputEditText etSemFeeConcessionCategory, TextInputEditText etSemHostelDue, TextInputEditText etSemLibraryDue, TextInputEditText etSemModeOfPayment, TextInputEditText etSemMonthYear, TextInputEditText etSemPaidDate, TextInputEditText etSemRefNo, TextView etSemSubmitBtn, RadioGroup examGroup, RadioButton examNo, RadioButton examYes, LinearLayout feeLayout, RadioButton feeNo, RadioGroup feePaidGroup, RadioButton feeYes, RadioGroup hostelGroup, RadioButton hostelNo, RadioButton hostelYes, RadioGroup libraryGroup, RadioButton libraryNo, RadioButton libraryYes, TextView payFeeBtn, TextView progressText, LinearLayout progressView, TextView semLastAttended, LinearLayout spinnerLayout, LinearLayout spinnerLayout2, Spinner spinnerSemReg, TextView tvSemRegFilePath, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.academicGroup = academicGroup;
        this.academicNo = academicNo;
        this.academicYes = academicYes;
        this.accountsGroup = accountsGroup;
        this.accountsNo = accountsNo;
        this.accountsYes = accountsYes;
        this.backNo = backNo;
        this.backPaperGroup = backPaperGroup;
        this.backYes = backYes;
        this.busGroup = busGroup;
        this.busNo = busNo;
        this.busYes = busYes;
        this.cardDue = cardDue;
        this.cardFeeDetails = cardFeeDetails;
        this.chooseFileBtn = chooseFileBtn;
        this.departmentGroup = departmentGroup;
        this.departmentNo = departmentNo;
        this.departmentYes = departmentYes;
        this.eGrandGroup = eGrandGroup;
        this.eGrandNo = eGrandNo;
        this.eGrandYes = eGrandYes;
        this.etSemAcademicDue = etSemAcademicDue;
        this.etSemAccountDue = etSemAccountDue;
        this.etSemAmount = etSemAmount;
        this.etSemBankName = etSemBankName;
        this.etSemBusDue = etSemBusDue;
        this.etSemCountBackPaper = etSemCountBackPaper;
        this.etSemDepartmentDue = etSemDepartmentDue;
        this.etSemEarnedCredit = etSemEarnedCredit;
        this.etSemFeeConcessionCategory = etSemFeeConcessionCategory;
        this.etSemHostelDue = etSemHostelDue;
        this.etSemLibraryDue = etSemLibraryDue;
        this.etSemModeOfPayment = etSemModeOfPayment;
        this.etSemMonthYear = etSemMonthYear;
        this.etSemPaidDate = etSemPaidDate;
        this.etSemRefNo = etSemRefNo;
        this.etSemSubmitBtn = etSemSubmitBtn;
        this.examGroup = examGroup;
        this.examNo = examNo;
        this.examYes = examYes;
        this.feeLayout = feeLayout;
        this.feeNo = feeNo;
        this.feePaidGroup = feePaidGroup;
        this.feeYes = feeYes;
        this.hostelGroup = hostelGroup;
        this.hostelNo = hostelNo;
        this.hostelYes = hostelYes;
        this.libraryGroup = libraryGroup;
        this.libraryNo = libraryNo;
        this.libraryYes = libraryYes;
        this.payFeeBtn = payFeeBtn;
        this.progressText = progressText;
        this.progressView = progressView;
        this.semLastAttended = semLastAttended;
        this.spinnerLayout = spinnerLayout;
        this.spinnerLayout2 = spinnerLayout2;
        this.spinnerSemReg = spinnerSemReg;
        this.tvSemRegFilePath = tvSemRegFilePath;
        this.uploadProgressbar = uploadProgressbar;
    }

    public SemRegViewModel getSemRegViewModel() {
        return this.mSemRegViewModel;
    }

    public static SemRegFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SemRegFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_reg_fragment, root, attachToRoot, component);
    }

    public static SemRegFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SemRegFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_reg_fragment, null, false, component);
    }

    public static SemRegFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegFragmentBinding bind(View view, Object component) {
        return (SemRegFragmentBinding) bind(component, view, R.layout.sem_reg_fragment);
    }
}