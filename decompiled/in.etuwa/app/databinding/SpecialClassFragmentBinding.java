package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.timetable.special.SpecialClassViewModel;

/* loaded from: classes3.dex */
public abstract class SpecialClassFragmentBinding extends ViewDataBinding {

    @Bindable
    protected SpecialClassViewModel mSpecialClassViewModel;
    public final RecyclerView rvSpecialTimetable;

    public abstract void setSpecialClassViewModel(SpecialClassViewModel specialClassViewModel);

    protected SpecialClassFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSpecialTimetable) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSpecialTimetable = rvSpecialTimetable;
    }

    public SpecialClassViewModel getSpecialClassViewModel() {
        return this.mSpecialClassViewModel;
    }

    public static SpecialClassFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SpecialClassFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SpecialClassFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.special_class_fragment, root, attachToRoot, component);
    }

    public static SpecialClassFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SpecialClassFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SpecialClassFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.special_class_fragment, null, false, component);
    }

    public static SpecialClassFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SpecialClassFragmentBinding bind(View view, Object component) {
        return (SpecialClassFragmentBinding) bind(component, view, R.layout.special_class_fragment);
    }
}