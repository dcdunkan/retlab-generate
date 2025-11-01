package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.assignment.assignment_sem_list.AssignmentSemListDialogViewModel;

/* loaded from: classes3.dex */
public abstract class AssignmentSemListDialogBinding extends ViewDataBinding {

    @Bindable
    protected AssignmentSemListDialogViewModel mAssignmentSemListDialogViewModel;
    public final RecyclerView rvSessionSemList;

    public abstract void setAssignmentSemListDialogViewModel(AssignmentSemListDialogViewModel assignmentSemListDialogViewModel);

    protected AssignmentSemListDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSessionSemList) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSessionSemList = rvSessionSemList;
    }

    public AssignmentSemListDialogViewModel getAssignmentSemListDialogViewModel() {
        return this.mAssignmentSemListDialogViewModel;
    }

    public static AssignmentSemListDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentSemListDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AssignmentSemListDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.assignment_sem_list_dialog, root, attachToRoot, component);
    }

    public static AssignmentSemListDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentSemListDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (AssignmentSemListDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.assignment_sem_list_dialog, null, false, component);
    }

    public static AssignmentSemListDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AssignmentSemListDialogBinding bind(View view, Object component) {
        return (AssignmentSemListDialogBinding) bind(component, view, R.layout.assignment_sem_list_dialog);
    }
}