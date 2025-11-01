package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.mace.MaceNewSemRegViewModel;

/* loaded from: classes3.dex */
public abstract class DialogMaceSemRegBinding extends ViewDataBinding {
    public final TextView backFour;
    public final RadioGroup backGroup;
    public final RadioButton backNo;
    public final TextView backOne;
    public final TextView backThree;
    public final TextView backTwo;
    public final RadioButton backYes;
    public final RadioGroup collegeLibraryGroup;
    public final RadioButton collegeLibraryNo;
    public final RadioButton collegeLibraryYes;
    public final LinearLayout duesLt;
    public final TextView duesTv;
    public final TextInputEditText etAddress;
    public final TextInputEditText etBackPaperCount;
    public final TextInputEditText etContactNum;
    public final TextInputEditText etCreditsEarned;
    public final TextInputEditText etDeptLib;
    public final TextInputEditText etEmailId;
    public final TextInputEditText etLabOne;
    public final TextInputEditText etLabOneDetails;
    public final TextInputEditText etLabTwo;
    public final TextInputEditText etLabTwoDetails;
    public final TextInputEditText etLibraryDetails;
    public final TextInputEditText etMonthYear;
    public final TextInputEditText etNameOfHouse;
    public final TextInputEditText etParentsMob;
    public final TextInputEditText etPeriodDiscontinued;
    public final TextInputEditText etPhoneNumber;
    public final TextView examAttTv;
    public final RadioGroup examGroup;
    public final RadioButton examNo;
    public final RadioButton examYes;
    public final LinearLayout honorMinorLt;
    public final RadioGroup honourGroup;
    public final RadioButton honourNo;
    public final RadioButton honourYes;
    public final RadioGroup labOneGroup;
    public final RadioButton labOneNo;
    public final RadioButton labOneYes;
    public final RadioGroup labTwoGroup;
    public final RadioButton labTwoNo;
    public final RadioButton labTwoYes;
    public final RadioGroup libraryDue;
    public final RadioButton libraryNo;
    public final RadioButton libraryYes;

    @Bindable
    protected MaceNewSemRegViewModel mMaceNewSemRegViewModel;
    public final RadioGroup minorGroup;
    public final RadioButton minorNo;
    public final RadioButton minorYes;
    public final TextInputLayout mtBackPapers;
    public final TextInputLayout mtDeptLib;
    public final TextInputLayout mtLabOneDetails;
    public final TextInputLayout mtLabTwoDetails;
    public final TextInputLayout mtLibraryDetails;
    public final TextInputLayout mtMonthYear;
    public final TextView nextFour;
    public final TextView nextOne;
    public final TextView nextThree;
    public final TextView nextTwo;
    public final LinearLayout pageFour;
    public final LinearLayout pageOne;
    public final LinearLayout pageThree;
    public final LinearLayout pageTwo;
    public final LinearLayout personalDetailsLyt;
    public final TextView registerBtn;
    public final Spinner spinnerAcademicYear;
    public final Spinner spinnerSemesterLastAttended;
    public final LinearLayout universityPreviousLayout;

    public abstract void setMaceNewSemRegViewModel(MaceNewSemRegViewModel maceNewSemRegViewModel);

    protected DialogMaceSemRegBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView backFour, RadioGroup backGroup, RadioButton backNo, TextView backOne, TextView backThree, TextView backTwo, RadioButton backYes, RadioGroup collegeLibraryGroup, RadioButton collegeLibraryNo, RadioButton collegeLibraryYes, LinearLayout duesLt, TextView duesTv, TextInputEditText etAddress, TextInputEditText etBackPaperCount, TextInputEditText etContactNum, TextInputEditText etCreditsEarned, TextInputEditText etDeptLib, TextInputEditText etEmailId, TextInputEditText etLabOne, TextInputEditText etLabOneDetails, TextInputEditText etLabTwo, TextInputEditText etLabTwoDetails, TextInputEditText etLibraryDetails, TextInputEditText etMonthYear, TextInputEditText etNameOfHouse, TextInputEditText etParentsMob, TextInputEditText etPeriodDiscontinued, TextInputEditText etPhoneNumber, TextView examAttTv, RadioGroup examGroup, RadioButton examNo, RadioButton examYes, LinearLayout honorMinorLt, RadioGroup honourGroup, RadioButton honourNo, RadioButton honourYes, RadioGroup labOneGroup, RadioButton labOneNo, RadioButton labOneYes, RadioGroup labTwoGroup, RadioButton labTwoNo, RadioButton labTwoYes, RadioGroup libraryDue, RadioButton libraryNo, RadioButton libraryYes, RadioGroup minorGroup, RadioButton minorNo, RadioButton minorYes, TextInputLayout mtBackPapers, TextInputLayout mtDeptLib, TextInputLayout mtLabOneDetails, TextInputLayout mtLabTwoDetails, TextInputLayout mtLibraryDetails, TextInputLayout mtMonthYear, TextView nextFour, TextView nextOne, TextView nextThree, TextView nextTwo, LinearLayout pageFour, LinearLayout pageOne, LinearLayout pageThree, LinearLayout pageTwo, LinearLayout personalDetailsLyt, TextView registerBtn, Spinner spinnerAcademicYear, Spinner spinnerSemesterLastAttended, LinearLayout universityPreviousLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.backFour = backFour;
        this.backGroup = backGroup;
        this.backNo = backNo;
        this.backOne = backOne;
        this.backThree = backThree;
        this.backTwo = backTwo;
        this.backYes = backYes;
        this.collegeLibraryGroup = collegeLibraryGroup;
        this.collegeLibraryNo = collegeLibraryNo;
        this.collegeLibraryYes = collegeLibraryYes;
        this.duesLt = duesLt;
        this.duesTv = duesTv;
        this.etAddress = etAddress;
        this.etBackPaperCount = etBackPaperCount;
        this.etContactNum = etContactNum;
        this.etCreditsEarned = etCreditsEarned;
        this.etDeptLib = etDeptLib;
        this.etEmailId = etEmailId;
        this.etLabOne = etLabOne;
        this.etLabOneDetails = etLabOneDetails;
        this.etLabTwo = etLabTwo;
        this.etLabTwoDetails = etLabTwoDetails;
        this.etLibraryDetails = etLibraryDetails;
        this.etMonthYear = etMonthYear;
        this.etNameOfHouse = etNameOfHouse;
        this.etParentsMob = etParentsMob;
        this.etPeriodDiscontinued = etPeriodDiscontinued;
        this.etPhoneNumber = etPhoneNumber;
        this.examAttTv = examAttTv;
        this.examGroup = examGroup;
        this.examNo = examNo;
        this.examYes = examYes;
        this.honorMinorLt = honorMinorLt;
        this.honourGroup = honourGroup;
        this.honourNo = honourNo;
        this.honourYes = honourYes;
        this.labOneGroup = labOneGroup;
        this.labOneNo = labOneNo;
        this.labOneYes = labOneYes;
        this.labTwoGroup = labTwoGroup;
        this.labTwoNo = labTwoNo;
        this.labTwoYes = labTwoYes;
        this.libraryDue = libraryDue;
        this.libraryNo = libraryNo;
        this.libraryYes = libraryYes;
        this.minorGroup = minorGroup;
        this.minorNo = minorNo;
        this.minorYes = minorYes;
        this.mtBackPapers = mtBackPapers;
        this.mtDeptLib = mtDeptLib;
        this.mtLabOneDetails = mtLabOneDetails;
        this.mtLabTwoDetails = mtLabTwoDetails;
        this.mtLibraryDetails = mtLibraryDetails;
        this.mtMonthYear = mtMonthYear;
        this.nextFour = nextFour;
        this.nextOne = nextOne;
        this.nextThree = nextThree;
        this.nextTwo = nextTwo;
        this.pageFour = pageFour;
        this.pageOne = pageOne;
        this.pageThree = pageThree;
        this.pageTwo = pageTwo;
        this.personalDetailsLyt = personalDetailsLyt;
        this.registerBtn = registerBtn;
        this.spinnerAcademicYear = spinnerAcademicYear;
        this.spinnerSemesterLastAttended = spinnerSemesterLastAttended;
        this.universityPreviousLayout = universityPreviousLayout;
    }

    public MaceNewSemRegViewModel getMaceNewSemRegViewModel() {
        return this.mMaceNewSemRegViewModel;
    }

    public static DialogMaceSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMaceSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogMaceSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mace_sem_reg, root, attachToRoot, component);
    }

    public static DialogMaceSemRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMaceSemRegBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogMaceSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mace_sem_reg, null, false, component);
    }

    public static DialogMaceSemRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMaceSemRegBinding bind(View view, Object component) {
        return (DialogMaceSemRegBinding) bind(component, view, R.layout.dialog_mace_sem_reg);
    }
}