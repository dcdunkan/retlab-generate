package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.exam.module.ModuleTestViewModel;

/* loaded from: classes3.dex */
public abstract class ModuleTestFragmentBinding extends ViewDataBinding {
    public final TextView coveredModule;

    @Bindable
    protected ModuleTestViewModel mModuleTestViewModel;
    public final TextView notCoveredModule;
    public final RecyclerView rvExam;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setModuleTestViewModel(ModuleTestViewModel moduleTestViewModel);

    protected ModuleTestFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView coveredModule, TextView notCoveredModule, RecyclerView rvExam, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.coveredModule = coveredModule;
        this.notCoveredModule = notCoveredModule;
        this.rvExam = rvExam;
        this.swipeLayout = swipeLayout;
    }

    public ModuleTestViewModel getModuleTestViewModel() {
        return this.mModuleTestViewModel;
    }

    public static ModuleTestFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ModuleTestFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ModuleTestFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.module_test_fragment, root, attachToRoot, component);
    }

    public static ModuleTestFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ModuleTestFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ModuleTestFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.module_test_fragment, null, false, component);
    }

    public static ModuleTestFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ModuleTestFragmentBinding bind(View view, Object component) {
        return (ModuleTestFragmentBinding) bind(component, view, R.layout.module_test_fragment);
    }
}