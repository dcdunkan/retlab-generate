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
import in.etuwa.app.ui.profile.coursesattended.CoursesAttendedViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentCourseAttendedBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected CoursesAttendedViewModel mCoursesAttendedViewModel;
    public final RecyclerView rvCourse;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCoursesAttendedViewModel(CoursesAttendedViewModel coursesAttendedViewModel);

    protected FragmentCourseAttendedBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvCourse, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvCourse = rvCourse;
        this.swipeLayout = swipeLayout;
    }

    public CoursesAttendedViewModel getCoursesAttendedViewModel() {
        return this.mCoursesAttendedViewModel;
    }

    public static FragmentCourseAttendedBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseAttendedBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentCourseAttendedBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_attended, root, attachToRoot, component);
    }

    public static FragmentCourseAttendedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseAttendedBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentCourseAttendedBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_attended, null, false, component);
    }

    public static FragmentCourseAttendedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseAttendedBinding bind(View view, Object component) {
        return (FragmentCourseAttendedBinding) bind(component, view, R.layout.fragment_course_attended);
    }
}