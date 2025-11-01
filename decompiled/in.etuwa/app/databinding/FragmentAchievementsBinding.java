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
import in.etuwa.app.ui.profile.achievements.AchievementsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentAchievementsBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected AchievementsViewModel mAchievementsViewModel;
    public final RecyclerView rvMembership;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setAchievementsViewModel(AchievementsViewModel achievementsViewModel);

    protected FragmentAchievementsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvMembership, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvMembership = rvMembership;
        this.swipeLayout = swipeLayout;
    }

    public AchievementsViewModel getAchievementsViewModel() {
        return this.mAchievementsViewModel;
    }

    public static FragmentAchievementsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAchievementsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAchievementsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_achievements, root, attachToRoot, component);
    }

    public static FragmentAchievementsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAchievementsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAchievementsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_achievements, null, false, component);
    }

    public static FragmentAchievementsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAchievementsBinding bind(View view, Object component) {
        return (FragmentAchievementsBinding) bind(component, view, R.layout.fragment_achievements);
    }
}