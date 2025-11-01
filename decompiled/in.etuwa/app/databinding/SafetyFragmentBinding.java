package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.lab.equipment.labsafety.SafetyViewModel;

/* loaded from: classes3.dex */
public abstract class SafetyFragmentBinding extends ViewDataBinding {

    @Bindable
    protected SafetyViewModel mSafetyViewModel;
    public final RecyclerView rvLabSafety;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSafetyViewModel(SafetyViewModel safetyViewModel);

    protected SafetyFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvLabSafety, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvLabSafety = rvLabSafety;
        this.swipeLayout = swipeLayout;
    }

    public SafetyViewModel getSafetyViewModel() {
        return this.mSafetyViewModel;
    }

    public static SafetyFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SafetyFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SafetyFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.safety_fragment, root, attachToRoot, component);
    }

    public static SafetyFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SafetyFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SafetyFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.safety_fragment, null, false, component);
    }

    public static SafetyFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SafetyFragmentBinding bind(View view, Object component) {
        return (SafetyFragmentBinding) bind(component, view, R.layout.safety_fragment);
    }
}