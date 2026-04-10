package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.imageview.ShapeableImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.teacher.TeacherViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TeacherFragmentBinding extends ViewDataBinding {
    public final TextView btnStaffAdvisor;
    public final TextView btnSubjectTeacher;
    public final ImageView fabUniv;
    public final TextView hodEmail;
    public final ShapeableImageView hodImage;
    public final TextView hodName;
    public final TextView hodPhone;
    public final TextView hodSubject;
    public final ImageView ivSearch;

    @Bindable
    protected TeacherViewModel mTeacherViewModel;
    public final RecyclerView rvTeacher;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;

    public abstract void setTeacherViewModel(TeacherViewModel teacherViewModel);

    protected TeacherFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView btnStaffAdvisor, TextView btnSubjectTeacher, ImageView fabUniv, TextView hodEmail, ShapeableImageView hodImage, TextView hodName, TextView hodPhone, TextView hodSubject, ImageView ivSearch, RecyclerView rvTeacher, SwipeRefreshLayout swipeLayout, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnStaffAdvisor = btnStaffAdvisor;
        this.btnSubjectTeacher = btnSubjectTeacher;
        this.fabUniv = fabUniv;
        this.hodEmail = hodEmail;
        this.hodImage = hodImage;
        this.hodName = hodName;
        this.hodPhone = hodPhone;
        this.hodSubject = hodSubject;
        this.ivSearch = ivSearch;
        this.rvTeacher = rvTeacher;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
    }

    public TeacherViewModel getTeacherViewModel() {
        return this.mTeacherViewModel;
    }

    public static TeacherFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TeacherFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (TeacherFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.teacher_fragment, root, attachToRoot, component);
    }

    public static TeacherFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TeacherFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (TeacherFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.teacher_fragment, null, false, component);
    }

    public static TeacherFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TeacherFragmentBinding bind(View view, Object component) {
        return (TeacherFragmentBinding) bind(component, view, R.layout.teacher_fragment);
    }
}