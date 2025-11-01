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
import in.etuwa.app.ui.live.LiveTvViewModel;

/* loaded from: classes3.dex */
public abstract class LiveTvFragmentBinding extends ViewDataBinding {

    @Bindable
    protected LiveTvViewModel mLiveTvViewModel;
    public final RecyclerView rvLive;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setLiveTvViewModel(LiveTvViewModel liveTvViewModel);

    protected LiveTvFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvLive, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvLive = rvLive;
        this.swipeLayout = swipeLayout;
    }

    public LiveTvViewModel getLiveTvViewModel() {
        return this.mLiveTvViewModel;
    }

    public static LiveTvFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveTvFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LiveTvFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.live_tv_fragment, root, attachToRoot, component);
    }

    public static LiveTvFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveTvFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (LiveTvFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.live_tv_fragment, null, false, component);
    }

    public static LiveTvFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveTvFragmentBinding bind(View view, Object component) {
        return (LiveTvFragmentBinding) bind(component, view, R.layout.live_tv_fragment);
    }
}