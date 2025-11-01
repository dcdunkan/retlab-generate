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
import in.etuwa.app.ui.subject.syllabus.SyllabusViewModel;

/* loaded from: classes3.dex */
public abstract class SyllabusFragmentBinding extends ViewDataBinding {

    @Bindable
    protected SyllabusViewModel mSyllabusViewModel;
    public final RecyclerView rvSyllabus;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSyllabusViewModel(SyllabusViewModel syllabusViewModel);

    protected SyllabusFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSyllabus, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSyllabus = rvSyllabus;
        this.swipeLayout = swipeLayout;
    }

    public SyllabusViewModel getSyllabusViewModel() {
        return this.mSyllabusViewModel;
    }

    public static SyllabusFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SyllabusFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SyllabusFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.syllabus_fragment, root, attachToRoot, component);
    }

    public static SyllabusFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SyllabusFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SyllabusFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.syllabus_fragment, null, false, component);
    }

    public static SyllabusFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SyllabusFragmentBinding bind(View view, Object component) {
        return (SyllabusFragmentBinding) bind(component, view, R.layout.syllabus_fragment);
    }
}