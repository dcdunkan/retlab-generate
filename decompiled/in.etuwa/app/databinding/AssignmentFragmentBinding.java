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
import in.etuwa.app.ui.assignment.AssignmentViewModel;

/* loaded from: classes3.dex */
public abstract class AssignmentFragmentBinding extends ViewDataBinding {
    public final LinearLayout assiFilter;
    public final LinearLayout assiSort;
    public final FloatingActionButton fabAss;
    public final FloatingActionButton fabAssignmentSemester;
    public final TextView filterAll;
    public final TextView filterNotsubmited;
    public final TextView filterSubmitted;

    @Bindable
    protected AssignmentViewModel mAssignmentViewModel;
    public final RecyclerView rvAssignment;
    public final LinearLayout spinLayout;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvassignment;

    public abstract void setAssignmentViewModel(AssignmentViewModel assignmentViewModel);

    protected AssignmentFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout assiFilter, LinearLayout assiSort, FloatingActionButton fabAss, FloatingActionButton fabAssignmentSemester, TextView filterAll, TextView filterNotsubmited, TextView filterSubmitted, RecyclerView rvAssignment, LinearLayout spinLayout, Spinner spinnerSem, SwipeRefreshLayout swipeLayout, TextView tvassignment) {
        super(_bindingComponent, _root, _localFieldCount);
        this.assiFilter = assiFilter;
        this.assiSort = assiSort;
        this.fabAss = fabAss;
        this.fabAssignmentSemester = fabAssignmentSemester;
        this.filterAll = filterAll;
        this.filterNotsubmited = filterNotsubmited;
        this.filterSubmitted = filterSubmitted;
        this.rvAssignment = rvAssignment;
        this.spinLayout = spinLayout;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.tvassignment = tvassignment;
    }

    public AssignmentViewModel getAssignmentViewModel() {
        return this.mAssignmentViewModel;
    }

    public static AssignmentFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AssignmentFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.assignment_fragment, root, attachToRoot, component);
    }

    public static AssignmentFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (AssignmentFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.assignment_fragment, null, false, component);
    }

    public static AssignmentFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentFragmentBinding bind(View view, Object component) {
        return (AssignmentFragmentBinding) bind(component, view, R.layout.assignment_fragment);
    }
}