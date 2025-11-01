package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public abstract class FragmentAttendanceDayWiseBinding extends ViewDataBinding {
    protected FragmentAttendanceDayWiseBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static FragmentAttendanceDayWiseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceDayWiseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAttendanceDayWiseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_attendance_day_wise, root, attachToRoot, component);
    }

    public static FragmentAttendanceDayWiseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceDayWiseBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAttendanceDayWiseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_attendance_day_wise, null, false, component);
    }

    public static FragmentAttendanceDayWiseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceDayWiseBinding bind(View view, Object component) {
        return (FragmentAttendanceDayWiseBinding) bind(component, view, R.layout.fragment_attendance_day_wise);
    }
}