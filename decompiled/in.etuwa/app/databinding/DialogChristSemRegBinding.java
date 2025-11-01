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
import in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel;

/* loaded from: classes3.dex */
public abstract class DialogChristSemRegBinding extends ViewDataBinding {
    public final RadioGroup academicDue;
    public final RadioButton academicNo;
    public final RadioButton academicYes;
    public final RadioGroup accountsDue;
    public final RadioButton accountsNo;
    public final RadioButton accountsYes;
    public final TextView backOne;
    public final RadioGroup busDue;
    public final RadioButton busNo;
    public final RadioButton busYes;
    public final RadioGroup departmentDue;
    public final RadioButton deptNo;
    public final RadioButton deptYes;
    public final LinearLayout dueLt;
    public final TextView dueTv;
    public final TextInputEditText etAcademicDetails;
    public final TextInputEditText etAccountsDetails;
    public final TextInputEditText etBusDetails;
    public final TextInputEditText etDeptDetails;
    public final TextInputEditText etHostelDetails;
    public final TextInputEditText etLibraryDetails;
    public final RadioGroup hostelDue;
    public final RadioButton hostelNo;
    public final RadioButton hostelYes;
    public final RadioGroup libraryDue;
    public final RadioButton libraryNo;
    public final RadioButton libraryYes;

    @Bindable
    protected ChristSemRegViewModel mChristSemRegViewModel;
    public final TextInputLayout mtAcademicDetail;
    public final TextInputLayout mtAccountDetail;
    public final TextInputLayout mtBusDetail;
    public final TextInputLayout mtDeptDetail;
    public final TextInputLayout mtHostelDetail;
    public final TextInputLayout mtLibraryDetail;
    public final LinearLayout pageOne;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView registerBtn;
    public final Spinner spinnerSemesterLastAttended;
    public final ProgressBar uploadProgressbar;

    public abstract void setChristSemRegViewModel(ChristSemRegViewModel christSemRegViewModel);

    protected DialogChristSemRegBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioGroup academicDue, RadioButton academicNo, RadioButton academicYes, RadioGroup accountsDue, RadioButton accountsNo, RadioButton accountsYes, TextView backOne, RadioGroup busDue, RadioButton busNo, RadioButton busYes, RadioGroup departmentDue, RadioButton deptNo, RadioButton deptYes, LinearLayout dueLt, TextView dueTv, TextInputEditText etAcademicDetails, TextInputEditText etAccountsDetails, TextInputEditText etBusDetails, TextInputEditText etDeptDetails, TextInputEditText etHostelDetails, TextInputEditText etLibraryDetails, RadioGroup hostelDue, RadioButton hostelNo, RadioButton hostelYes, RadioGroup libraryDue, RadioButton libraryNo, RadioButton libraryYes, TextInputLayout mtAcademicDetail, TextInputLayout mtAccountDetail, TextInputLayout mtBusDetail, TextInputLayout mtDeptDetail, TextInputLayout mtHostelDetail, TextInputLayout mtLibraryDetail, LinearLayout pageOne, TextView progressText, CardView progressView, TextView registerBtn, Spinner spinnerSemesterLastAttended, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.academicDue = academicDue;
        this.academicNo = academicNo;
        this.academicYes = academicYes;
        this.accountsDue = accountsDue;
        this.accountsNo = accountsNo;
        this.accountsYes = accountsYes;
        this.backOne = backOne;
        this.busDue = busDue;
        this.busNo = busNo;
        this.busYes = busYes;
        this.departmentDue = departmentDue;
        this.deptNo = deptNo;
        this.deptYes = deptYes;
        this.dueLt = dueLt;
        this.dueTv = dueTv;
        this.etAcademicDetails = etAcademicDetails;
        this.etAccountsDetails = etAccountsDetails;
        this.etBusDetails = etBusDetails;
        this.etDeptDetails = etDeptDetails;
        this.etHostelDetails = etHostelDetails;
        this.etLibraryDetails = etLibraryDetails;
        this.hostelDue = hostelDue;
        this.hostelNo = hostelNo;
        this.hostelYes = hostelYes;
        this.libraryDue = libraryDue;
        this.libraryNo = libraryNo;
        this.libraryYes = libraryYes;
        this.mtAcademicDetail = mtAcademicDetail;
        this.mtAccountDetail = mtAccountDetail;
        this.mtBusDetail = mtBusDetail;
        this.mtDeptDetail = mtDeptDetail;
        this.mtHostelDetail = mtHostelDetail;
        this.mtLibraryDetail = mtLibraryDetail;
        this.pageOne = pageOne;
        this.progressText = progressText;
        this.progressView = progressView;
        this.registerBtn = registerBtn;
        this.spinnerSemesterLastAttended = spinnerSemesterLastAttended;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ChristSemRegViewModel getChristSemRegViewModel() {
        return this.mChristSemRegViewModel;
    }

    public static DialogChristSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogChristSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogChristSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_christ_sem_reg, root, attachToRoot, component);
    }

    public static DialogChristSemRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogChristSemRegBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogChristSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_christ_sem_reg, null, false, component);
    }

    public static DialogChristSemRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogChristSemRegBinding bind(View view, Object component) {
        return (DialogChristSemRegBinding) bind(component, view, R.layout.dialog_christ_sem_reg);
    }
}