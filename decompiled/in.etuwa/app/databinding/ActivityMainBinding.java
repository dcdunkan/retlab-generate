package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.main.MainViewModel;
import me.ibrahimsn.lib.SmoothBottomBar;

/* loaded from: classes3.dex */
public abstract class ActivityMainBinding extends ViewDataBinding {
    public final SmoothBottomBar bottomNavNew;

    @Bindable
    protected MainViewModel mMainViewModel;
    public final FrameLayout mainContainer;
    public final LinearLayout root;

    public abstract void setMainViewModel(MainViewModel mainViewModel);

    protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount, SmoothBottomBar bottomNavNew, FrameLayout mainContainer, LinearLayout root) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bottomNavNew = bottomNavNew;
        this.mainContainer = mainContainer;
        this.root = root;
    }

    public MainViewModel getMainViewModel() {
        return this.mMainViewModel;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_main, null, false, component);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object component) {
        return (ActivityMainBinding) bind(component, view, R.layout.activity_main);
    }
}