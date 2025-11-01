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
import in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentMoocCourseBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected MoocCourseViewModel mMoocCourseViewModel;
    public final RecyclerView rvMooc;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setMoocCourseViewModel(MoocCourseViewModel moocCourseViewModel);

    protected FragmentMoocCourseBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvMooc, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvMooc = rvMooc;
        this.swipeLayout = swipeLayout;
    }

    public MoocCourseViewModel getMoocCourseViewModel() {
        return this.mMoocCourseViewModel;
    }

    public static FragmentMoocCourseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoocCourseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentMoocCourseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_mooc_course, root, attachToRoot, component);
    }

    public static FragmentMoocCourseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoocCourseBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentMoocCourseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_mooc_course, null, false, component);
    }

    public static FragmentMoocCourseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoocCourseBinding bind(View view, Object component) {
        return (FragmentMoocCourseBinding) bind(component, view, R.layout.fragment_mooc_course);
    }
}