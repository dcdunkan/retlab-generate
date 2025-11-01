package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.ResultViewModel;

/* loaded from: classes3.dex */
public abstract class ResultFragmentBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;

    @Bindable
    protected ResultViewModel mResultViewModel;
    public final ViewPager resultPager;
    public final TabLayout tabs;

    public abstract void setResultViewModel(ResultViewModel resultViewModel);

    protected ResultFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, ViewPager resultPager, TabLayout tabs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.resultPager = resultPager;
        this.tabs = tabs;
    }

    public ResultViewModel getResultViewModel() {
        return this.mResultViewModel;
    }

    public static ResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_fragment, root, attachToRoot, component);
    }

    public static ResultFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_fragment, null, false, component);
    }

    public static ResultFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultFragmentBinding bind(View view, Object component) {
        return (ResultFragmentBinding) bind(component, view, R.layout.result_fragment);
    }
}