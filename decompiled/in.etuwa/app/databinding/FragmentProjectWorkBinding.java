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
import in.etuwa.app.ui.profile.projectwork.ProjectWorkViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentProjectWorkBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected ProjectWorkViewModel mProjectWorkViewModel;
    public final RecyclerView rvProject;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setProjectWorkViewModel(ProjectWorkViewModel projectWorkViewModel);

    protected FragmentProjectWorkBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvProject, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvProject = rvProject;
        this.swipeLayout = swipeLayout;
    }

    public ProjectWorkViewModel getProjectWorkViewModel() {
        return this.mProjectWorkViewModel;
    }

    public static FragmentProjectWorkBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProjectWorkBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentProjectWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_project_work, root, attachToRoot, component);
    }

    public static FragmentProjectWorkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProjectWorkBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentProjectWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_project_work, null, false, component);
    }

    public static FragmentProjectWorkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProjectWorkBinding bind(View view, Object component) {
        return (FragmentProjectWorkBinding) bind(component, view, R.layout.fragment_project_work);
    }
}