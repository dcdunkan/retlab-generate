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
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel;

/* loaded from: classes3.dex */
public abstract class ViewMvjceSemRegDialogBinding extends ViewDataBinding {
    public final LinearLayout dueLayout;
    public final LinearLayout hodRemarkLayout;

    @Bindable
    protected ViewMvjceSemRegViewModel mViewMvjceSemRegViewModel;
    public final TextView regSlipBtn;
    public final TextView semEditBtn;
    public final TextView semRegAcademic;
    public final TextView semRegAcademicDue;
    public final TextView semRegAccount;
    public final TextView semRegAccountDue;
    public final TextView semRegAdmNo;
    public final TextView semRegAppliedFor;
    public final TextView semRegBackPaper;
    public final TextView semRegBackPaperCount;
    public final TextView semRegBus;
    public final TextView semRegBusDue;
    public final TextView semRegDepartment;
    public final TextView semRegDepartmentDue;
    public final TextView semRegEarnedCredit;
    public final TextView semRegEmail;
    public final TextView semRegExamAppear;
    public final TextView semRegGender;
    public final TextView semRegHostel;
    public final TextView semRegHostelDue;
    public final TextView semRegLibrary;
    public final TextView semRegLibraryDue;
    public final TextView semRegMonthYear;
    public final TextView semRegName;
    public final TextView semRegPhone;
    public final TextView semRegRemarkByHod;
    public final TextView semRegRemarkByTeacher;
    public final TextView semRegStatus;
    public final TextView semRegUnivNo;
    public final SwipeRefreshLayout swipeLayout;
    public final LinearLayout teacherRemarkLayout;

    public abstract void setViewMvjceSemRegViewModel(ViewMvjceSemRegViewModel viewMvjceSemRegViewModel);

    protected ViewMvjceSemRegDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout dueLayout, LinearLayout hodRemarkLayout, TextView regSlipBtn, TextView semEditBtn, TextView semRegAcademic, TextView semRegAcademicDue, TextView semRegAccount, TextView semRegAccountDue, TextView semRegAdmNo, TextView semRegAppliedFor, TextView semRegBackPaper, TextView semRegBackPaperCount, TextView semRegBus, TextView semRegBusDue, TextView semRegDepartment, TextView semRegDepartmentDue, TextView semRegEarnedCredit, TextView semRegEmail, TextView semRegExamAppear, TextView semRegGender, TextView semRegHostel, TextView semRegHostelDue, TextView semRegLibrary, TextView semRegLibraryDue, TextView semRegMonthYear, TextView semRegName, TextView semRegPhone, TextView semRegRemarkByHod, TextView semRegRemarkByTeacher, TextView semRegStatus, TextView semRegUnivNo, SwipeRefreshLayout swipeLayout, LinearLayout teacherRemarkLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dueLayout = dueLayout;
        this.hodRemarkLayout = hodRemarkLayout;
        this.regSlipBtn = regSlipBtn;
        this.semEditBtn = semEditBtn;
        this.semRegAcademic = semRegAcademic;
        this.semRegAcademicDue = semRegAcademicDue;
        this.semRegAccount = semRegAccount;
        this.semRegAccountDue = semRegAccountDue;
        this.semRegAdmNo = semRegAdmNo;
        this.semRegAppliedFor = semRegAppliedFor;
        this.semRegBackPaper = semRegBackPaper;
        this.semRegBackPaperCount = semRegBackPaperCount;
        this.semRegBus = semRegBus;
        this.semRegBusDue = semRegBusDue;
        this.semRegDepartment = semRegDepartment;
        this.semRegDepartmentDue = semRegDepartmentDue;
        this.semRegEarnedCredit = semRegEarnedCredit;
        this.semRegEmail = semRegEmail;
        this.semRegExamAppear = semRegExamAppear;
        this.semRegGender = semRegGender;
        this.semRegHostel = semRegHostel;
        this.semRegHostelDue = semRegHostelDue;
        this.semRegLibrary = semRegLibrary;
        this.semRegLibraryDue = semRegLibraryDue;
        this.semRegMonthYear = semRegMonthYear;
        this.semRegName = semRegName;
        this.semRegPhone = semRegPhone;
        this.semRegRemarkByHod = semRegRemarkByHod;
        this.semRegRemarkByTeacher = semRegRemarkByTeacher;
        this.semRegStatus = semRegStatus;
        this.semRegUnivNo = semRegUnivNo;
        this.swipeLayout = swipeLayout;
        this.teacherRemarkLayout = teacherRemarkLayout;
    }

    public ViewMvjceSemRegViewModel getViewMvjceSemRegViewModel() {
        return this.mViewMvjceSemRegViewModel;
    }

    public static ViewMvjceSemRegDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewMvjceSemRegDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewMvjceSemRegDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_mvjce_sem_reg_dialog, root, attachToRoot, component);
    }

    public static ViewMvjceSemRegDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewMvjceSemRegDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewMvjceSemRegDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_mvjce_sem_reg_dialog, null, false, component);
    }

    public static ViewMvjceSemRegDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewMvjceSemRegDialogBinding bind(View view, Object component) {
        return (ViewMvjceSemRegDialogBinding) bind(component, view, R.layout.view_mvjce_sem_reg_dialog);
    }
}