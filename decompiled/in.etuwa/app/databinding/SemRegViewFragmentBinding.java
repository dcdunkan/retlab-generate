package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.view.SemRegViewViewModel;

/* loaded from: classes3.dex */
public abstract class SemRegViewFragmentBinding extends ViewDataBinding {
    public final LinearLayout dueLayout;
    public final LinearLayout feeLayout;
    public final LinearLayout hodRemarkLayout;

    @Bindable
    protected SemRegViewViewModel mSemRegViewViewModel;
    public final TextView regSlipBtn;
    public final TextView semEditBtn;
    public final TextView semRegAcademic;
    public final TextView semRegAcademicDue;
    public final TextView semRegAccount;
    public final TextView semRegAccountDue;
    public final TextView semRegAdmNo;
    public final TextView semRegAmount;
    public final TextView semRegAppliedFor;
    public final TextView semRegBackPaper;
    public final TextView semRegBackPaperCount;
    public final TextView semRegBank;
    public final TextView semRegBus;
    public final TextView semRegBusDue;
    public final TextView semRegDepartment;
    public final TextView semRegDepartmentDue;
    public final TextView semRegEGrand;
    public final TextView semRegEarnedCredit;
    public final TextView semRegEmail;
    public final TextView semRegExamAppear;
    public final TextView semRegFeeConcession;
    public final TextView semRegFeePaid;
    public final TextView semRegFeeReceipt;
    public final TextView semRegGender;
    public final TextView semRegHostel;
    public final TextView semRegHostelDue;
    public final TextView semRegLibrary;
    public final TextView semRegLibraryDue;
    public final TextView semRegMonthYear;
    public final TextView semRegName;
    public final TextView semRegPaymentMode;
    public final TextView semRegPhone;
    public final CircleImageView semRegProfileImage;
    public final TextView semRegRefNo;
    public final TextView semRegRemarkByHod;
    public final TextView semRegRemarkByTeacher;
    public final TextView semRegStatus;
    public final TextView semRegUnivNo;
    public final SwipeRefreshLayout swipeLayout;
    public final LinearLayout teacherRemarkLayout;

    public abstract void setSemRegViewViewModel(SemRegViewViewModel semRegViewViewModel);

    protected SemRegViewFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout dueLayout, LinearLayout feeLayout, LinearLayout hodRemarkLayout, TextView regSlipBtn, TextView semEditBtn, TextView semRegAcademic, TextView semRegAcademicDue, TextView semRegAccount, TextView semRegAccountDue, TextView semRegAdmNo, TextView semRegAmount, TextView semRegAppliedFor, TextView semRegBackPaper, TextView semRegBackPaperCount, TextView semRegBank, TextView semRegBus, TextView semRegBusDue, TextView semRegDepartment, TextView semRegDepartmentDue, TextView semRegEGrand, TextView semRegEarnedCredit, TextView semRegEmail, TextView semRegExamAppear, TextView semRegFeeConcession, TextView semRegFeePaid, TextView semRegFeeReceipt, TextView semRegGender, TextView semRegHostel, TextView semRegHostelDue, TextView semRegLibrary, TextView semRegLibraryDue, TextView semRegMonthYear, TextView semRegName, TextView semRegPaymentMode, TextView semRegPhone, CircleImageView semRegProfileImage, TextView semRegRefNo, TextView semRegRemarkByHod, TextView semRegRemarkByTeacher, TextView semRegStatus, TextView semRegUnivNo, SwipeRefreshLayout swipeLayout, LinearLayout teacherRemarkLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dueLayout = dueLayout;
        this.feeLayout = feeLayout;
        this.hodRemarkLayout = hodRemarkLayout;
        this.regSlipBtn = regSlipBtn;
        this.semEditBtn = semEditBtn;
        this.semRegAcademic = semRegAcademic;
        this.semRegAcademicDue = semRegAcademicDue;
        this.semRegAccount = semRegAccount;
        this.semRegAccountDue = semRegAccountDue;
        this.semRegAdmNo = semRegAdmNo;
        this.semRegAmount = semRegAmount;
        this.semRegAppliedFor = semRegAppliedFor;
        this.semRegBackPaper = semRegBackPaper;
        this.semRegBackPaperCount = semRegBackPaperCount;
        this.semRegBank = semRegBank;
        this.semRegBus = semRegBus;
        this.semRegBusDue = semRegBusDue;
        this.semRegDepartment = semRegDepartment;
        this.semRegDepartmentDue = semRegDepartmentDue;
        this.semRegEGrand = semRegEGrand;
        this.semRegEarnedCredit = semRegEarnedCredit;
        this.semRegEmail = semRegEmail;
        this.semRegExamAppear = semRegExamAppear;
        this.semRegFeeConcession = semRegFeeConcession;
        this.semRegFeePaid = semRegFeePaid;
        this.semRegFeeReceipt = semRegFeeReceipt;
        this.semRegGender = semRegGender;
        this.semRegHostel = semRegHostel;
        this.semRegHostelDue = semRegHostelDue;
        this.semRegLibrary = semRegLibrary;
        this.semRegLibraryDue = semRegLibraryDue;
        this.semRegMonthYear = semRegMonthYear;
        this.semRegName = semRegName;
        this.semRegPaymentMode = semRegPaymentMode;
        this.semRegPhone = semRegPhone;
        this.semRegProfileImage = semRegProfileImage;
        this.semRegRefNo = semRegRefNo;
        this.semRegRemarkByHod = semRegRemarkByHod;
        this.semRegRemarkByTeacher = semRegRemarkByTeacher;
        this.semRegStatus = semRegStatus;
        this.semRegUnivNo = semRegUnivNo;
        this.swipeLayout = swipeLayout;
        this.teacherRemarkLayout = teacherRemarkLayout;
    }

    public SemRegViewViewModel getSemRegViewViewModel() {
        return this.mSemRegViewViewModel;
    }

    public static SemRegViewFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegViewFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SemRegViewFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_reg_view_fragment, root, attachToRoot, component);
    }

    public static SemRegViewFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegViewFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SemRegViewFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_reg_view_fragment, null, false, component);
    }

    public static SemRegViewFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegViewFragmentBinding bind(View view, Object component) {
        return (SemRegViewFragmentBinding) bind(component, view, R.layout.sem_reg_view_fragment);
    }
}