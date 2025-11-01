package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel;

/* loaded from: classes3.dex */
public abstract class ChangeInTimetableFragmentBinding extends ViewDataBinding {

    @Bindable
    protected ChangeInTimetableViewModel mChangeInTimetableViewModel;
    public final RecyclerView rvChangeTimetable;

    public abstract void setChangeInTimetableViewModel(ChangeInTimetableViewModel changeInTimetableViewModel);

    protected ChangeInTimetableFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvChangeTimetable) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvChangeTimetable = rvChangeTimetable;
    }

    public ChangeInTimetableViewModel getChangeInTimetableViewModel() {
        return this.mChangeInTimetableViewModel;
    }

    public static ChangeInTimetableFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChangeInTimetableFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ChangeInTimetableFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.change_in_timetable_fragment, root, attachToRoot, component);
    }

    public static ChangeInTimetableFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChangeInTimetableFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ChangeInTimetableFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.change_in_timetable_fragment, null, false, component);
    }

    public static ChangeInTimetableFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChangeInTimetableFragmentBinding bind(View view, Object component) {
        return (ChangeInTimetableFragmentBinding) bind(component, view, R.layout.change_in_timetable_fragment);
    }
}