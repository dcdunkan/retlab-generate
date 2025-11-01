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
import in.etuwa.app.ui.result.moduletest.ResultModuleTestViewModel;

/* loaded from: classes3.dex */
public abstract class ResultModuleTestFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabModuleResultSemester;

    @Bindable
    protected ResultModuleTestViewModel mResultModuleTestViewModel;
    public final LinearLayout moduleLayout;
    public final TextView moduleSemTv;
    public final RecyclerView rvResultModuleTest;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setResultModuleTestViewModel(ResultModuleTestViewModel resultModuleTestViewModel);

    protected ResultModuleTestFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabModuleResultSemester, LinearLayout moduleLayout, TextView moduleSemTv, RecyclerView rvResultModuleTest, Spinner spinnerSem, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabModuleResultSemester = fabModuleResultSemester;
        this.moduleLayout = moduleLayout;
        this.moduleSemTv = moduleSemTv;
        this.rvResultModuleTest = rvResultModuleTest;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
    }

    public ResultModuleTestViewModel getResultModuleTestViewModel() {
        return this.mResultModuleTestViewModel;
    }

    public static ResultModuleTestFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultModuleTestFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ResultModuleTestFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_module_test_fragment, root, attachToRoot, component);
    }

    public static ResultModuleTestFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultModuleTestFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ResultModuleTestFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_module_test_fragment, null, false, component);
    }

    public static ResultModuleTestFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultModuleTestFragmentBinding bind(View view, Object component) {
        return (ResultModuleTestFragmentBinding) bind(component, view, R.layout.result_module_test_fragment);
    }
}