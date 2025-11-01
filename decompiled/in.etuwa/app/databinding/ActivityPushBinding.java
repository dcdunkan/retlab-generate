package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import in.etuwa.app.R;
import in.etuwa.app.ui.push.PushViewModel;

/* loaded from: classes3.dex */
public abstract class ActivityPushBinding extends ViewDataBinding {
    public final BottomNavigationView bottomNav;

    @Bindable
    protected PushViewModel mPushViewModel;
    public final CoordinatorLayout pushLayout;
    public final RecyclerView rvPush;

    public abstract void setPushViewModel(PushViewModel pushViewModel);

    protected ActivityPushBinding(Object _bindingComponent, View _root, int _localFieldCount, BottomNavigationView bottomNav, CoordinatorLayout pushLayout, RecyclerView rvPush) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bottomNav = bottomNav;
        this.pushLayout = pushLayout;
        this.rvPush = rvPush;
    }

    public PushViewModel getPushViewModel() {
        return this.mPushViewModel;
    }

    public static ActivityPushBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPushBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityPushBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_push, root, attachToRoot, component);
    }

    public static ActivityPushBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPushBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityPushBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_push, null, false, component);
    }

    public static ActivityPushBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPushBinding bind(View view, Object component) {
        return (ActivityPushBinding) bind(component, view, R.layout.activity_push);
    }
}