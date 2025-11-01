package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.timetable.tableview.TimetableViewViewModel;

/* loaded from: classes3.dex */
public abstract class TimtableViewFragmentBinding extends ViewDataBinding {

    @Bindable
    protected TimetableViewViewModel mTimetableViewViewModel;
    public final RecyclerView rvTimetable;

    public abstract void setTimetableViewViewModel(TimetableViewViewModel timetableViewViewModel);

    protected TimtableViewFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvTimetable) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvTimetable = rvTimetable;
    }

    public TimetableViewViewModel getTimetableViewViewModel() {
        return this.mTimetableViewViewModel;
    }

    public static TimtableViewFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TimtableViewFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (TimtableViewFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.timtable_view_fragment, root, attachToRoot, component);
    }

    public static TimtableViewFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TimtableViewFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (TimtableViewFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.timtable_view_fragment, null, false, component);
    }

    public static TimtableViewFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TimtableViewFragmentBinding bind(View view, Object component) {
        return (TimtableViewFragmentBinding) bind(component, view, R.layout.timtable_view_fragment);
    }
}