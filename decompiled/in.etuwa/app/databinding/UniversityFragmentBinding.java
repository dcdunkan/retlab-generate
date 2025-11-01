package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.university.UniversityViewModel;

/* loaded from: classes3.dex */
public abstract class UniversityFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabUniv;

    @Bindable
    protected UniversityViewModel mUniversityViewModel;
    public final ViewPager univPager;
    public final TabLayout univTabs;

    public abstract void setUniversityViewModel(UniversityViewModel universityViewModel);

    protected UniversityFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabUniv, ViewPager univPager, TabLayout univTabs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabUniv = fabUniv;
        this.univPager = univPager;
        this.univTabs = univTabs;
    }

    public UniversityViewModel getUniversityViewModel() {
        return this.mUniversityViewModel;
    }

    public static UniversityFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (UniversityFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.university_fragment, root, attachToRoot, component);
    }

    public static UniversityFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (UniversityFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.university_fragment, null, false, component);
    }

    public static UniversityFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityFragmentBinding bind(View view, Object component) {
        return (UniversityFragmentBinding) bind(component, view, R.layout.university_fragment);
    }
}