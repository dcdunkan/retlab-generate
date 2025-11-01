package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentAsietSemRegBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout attendanceOne;
    public final LinearLayout attendanceThree;
    public final LinearLayout attendanceTwo;
    public final TextView certificateDetailsBtn;
    public final TextInputEditText etAddress;
    public final TextInputEditText etParentEmail;
    public final TextInputEditText etParentNo;
    public final TextInputEditText etReason1;
    public final TextInputEditText etReason2;
    public final TextInputEditText etReason3;
    public final TextInputEditText etSem1;
    public final TextInputEditText etSem2;
    public final TextInputEditText etSem3;
    public final TextInputEditText etSub1;
    public final TextInputEditText etSub2;
    public final TextInputEditText etSub3;
    public final TextView fundedDetailsBtn;

    @Bindable
    protected AsietSemRegViewModel mAsietSemRegViewModel;
    public final TextView membershipDetailsBtn;
    public final TextView moocDetailsBtn;
    public final TextInputLayout mtAddress;
    public final TextInputLayout mtParentEmail;
    public final TextInputLayout mtParentNo;
    public final TextInputLayout mtReason1;
    public final TextInputLayout mtReason2;
    public final TextInputLayout mtReason3;
    public final TextInputLayout mtSem1;
    public final TextInputLayout mtSem2;
    public final TextInputLayout mtSem3;
    public final TextInputLayout mtSub1;
    public final TextInputLayout mtSub2;
    public final TextInputLayout mtSub3;
    public final TextView otherDetailsBtn;
    public final TextView positionDetailsBtn;
    public final TextView projectDetailsBtn;
    public final TextView qualityDetailsBtn;
    public final Button registerBtn;
    public final TextView removeBtn;
    public final TextView scholarshipsDetailsBtn;
    public final Spinner spinnerSemesterLastAttended;
    public final TextView sportsDetailsBtn;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setAsietSemRegViewModel(AsietSemRegViewModel asietSemRegViewModel);

    protected FragmentAsietSemRegBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout attendanceOne, LinearLayout attendanceThree, LinearLayout attendanceTwo, TextView certificateDetailsBtn, TextInputEditText etAddress, TextInputEditText etParentEmail, TextInputEditText etParentNo, TextInputEditText etReason1, TextInputEditText etReason2, TextInputEditText etReason3, TextInputEditText etSem1, TextInputEditText etSem2, TextInputEditText etSem3, TextInputEditText etSub1, TextInputEditText etSub2, TextInputEditText etSub3, TextView fundedDetailsBtn, TextView membershipDetailsBtn, TextView moocDetailsBtn, TextInputLayout mtAddress, TextInputLayout mtParentEmail, TextInputLayout mtParentNo, TextInputLayout mtReason1, TextInputLayout mtReason2, TextInputLayout mtReason3, TextInputLayout mtSem1, TextInputLayout mtSem2, TextInputLayout mtSem3, TextInputLayout mtSub1, TextInputLayout mtSub2, TextInputLayout mtSub3, TextView otherDetailsBtn, TextView positionDetailsBtn, TextView projectDetailsBtn, TextView qualityDetailsBtn, Button registerBtn, TextView removeBtn, TextView scholarshipsDetailsBtn, Spinner spinnerSemesterLastAttended, TextView sportsDetailsBtn, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.attendanceOne = attendanceOne;
        this.attendanceThree = attendanceThree;
        this.attendanceTwo = attendanceTwo;
        this.certificateDetailsBtn = certificateDetailsBtn;
        this.etAddress = etAddress;
        this.etParentEmail = etParentEmail;
        this.etParentNo = etParentNo;
        this.etReason1 = etReason1;
        this.etReason2 = etReason2;
        this.etReason3 = etReason3;
        this.etSem1 = etSem1;
        this.etSem2 = etSem2;
        this.etSem3 = etSem3;
        this.etSub1 = etSub1;
        this.etSub2 = etSub2;
        this.etSub3 = etSub3;
        this.fundedDetailsBtn = fundedDetailsBtn;
        this.membershipDetailsBtn = membershipDetailsBtn;
        this.moocDetailsBtn = moocDetailsBtn;
        this.mtAddress = mtAddress;
        this.mtParentEmail = mtParentEmail;
        this.mtParentNo = mtParentNo;
        this.mtReason1 = mtReason1;
        this.mtReason2 = mtReason2;
        this.mtReason3 = mtReason3;
        this.mtSem1 = mtSem1;
        this.mtSem2 = mtSem2;
        this.mtSem3 = mtSem3;
        this.mtSub1 = mtSub1;
        this.mtSub2 = mtSub2;
        this.mtSub3 = mtSub3;
        this.otherDetailsBtn = otherDetailsBtn;
        this.positionDetailsBtn = positionDetailsBtn;
        this.projectDetailsBtn = projectDetailsBtn;
        this.qualityDetailsBtn = qualityDetailsBtn;
        this.registerBtn = registerBtn;
        this.removeBtn = removeBtn;
        this.scholarshipsDetailsBtn = scholarshipsDetailsBtn;
        this.spinnerSemesterLastAttended = spinnerSemesterLastAttended;
        this.sportsDetailsBtn = sportsDetailsBtn;
        this.swipeLayout = swipeLayout;
    }

    public AsietSemRegViewModel getAsietSemRegViewModel() {
        return this.mAsietSemRegViewModel;
    }

    public static FragmentAsietSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAsietSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAsietSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_asiet_sem_reg, root, attachToRoot, component);
    }

    public static FragmentAsietSemRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAsietSemRegBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAsietSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_asiet_sem_reg, null, false, component);
    }

    public static FragmentAsietSemRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAsietSemRegBinding bind(View view, Object component) {
        return (FragmentAsietSemRegBinding) bind(component, view, R.layout.fragment_asiet_sem_reg);
    }
}