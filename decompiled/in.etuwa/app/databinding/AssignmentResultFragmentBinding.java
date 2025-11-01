package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.assignment.AssignmentResultViewModel;

/* loaded from: classes3.dex */
public abstract class AssignmentResultFragmentBinding extends ViewDataBinding {
    public final LinearLayout assignmentResultLayout;
    public final FloatingActionButton fabAssignmentResultSemester;

    @Bindable
    protected AssignmentResultViewModel mAssignmentResultViewModel;
    public final RecyclerView rvResultAssignment;
    public final TextView semesterText;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setAssignmentResultViewModel(AssignmentResultViewModel assignmentResultViewModel);

    protected AssignmentResultFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout assignmentResultLayout, FloatingActionButton fabAssignmentResultSemester, RecyclerView rvResultAssignment, TextView semesterText, Spinner spinnerSem, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.assignmentResultLayout = assignmentResultLayout;
        this.fabAssignmentResultSemester = fabAssignmentResultSemester;
        this.rvResultAssignment = rvResultAssignment;
        this.semesterText = semesterText;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
    }

    public AssignmentResultViewModel getAssignmentResultViewModel() {
        return this.mAssignmentResultViewModel;
    }

    public static AssignmentResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AssignmentResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.assignment_result_fragment, root, attachToRoot, component);
    }

    public static AssignmentResultFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentResultFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (AssignmentResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.assignment_result_fragment, null, false, component);
    }

    public static AssignmentResultFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentResultFragmentBinding bind(View view, Object component) {
        return (AssignmentResultFragmentBinding) bind(component, view, R.layout.assignment_result_fragment);
    }
}