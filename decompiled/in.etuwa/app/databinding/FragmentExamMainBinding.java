package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.exammain.ExamMainViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentExamMainBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final ViewPager2 examPager;

    @Bindable
    protected ExamMainViewModel mExamMainViewModel;
    public final TabLayout tabs;

    public abstract void setExamMainViewModel(ExamMainViewModel examMainViewModel);

    protected FragmentExamMainBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, ViewPager2 examPager, TabLayout tabs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.examPager = examPager;
        this.tabs = tabs;
    }

    public ExamMainViewModel getExamMainViewModel() {
        return this.mExamMainViewModel;
    }

    public static FragmentExamMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_main, root, attachToRoot, component);
    }

    public static FragmentExamMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_main, null, false, component);
    }

    public static FragmentExamMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamMainBinding bind(View view, Object component) {
        return (FragmentExamMainBinding) bind(component, view, R.layout.fragment_exam_main);
    }
}