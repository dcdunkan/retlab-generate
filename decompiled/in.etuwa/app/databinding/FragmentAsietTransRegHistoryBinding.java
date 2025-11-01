package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentAsietTransRegHistoryBinding extends ViewDataBinding {
    public final FloatingActionButton fabAddTransReg;

    @Bindable
    protected AsietTransRegViewModel mAsietTransRegViewModel;
    public final RecyclerView rvRegHistoryTransport;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setAsietTransRegViewModel(AsietTransRegViewModel asietTransRegViewModel);

    protected FragmentAsietTransRegHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabAddTransReg, RecyclerView rvRegHistoryTransport, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabAddTransReg = fabAddTransReg;
        this.rvRegHistoryTransport = rvRegHistoryTransport;
        this.swipeLayout = swipeLayout;
    }

    public AsietTransRegViewModel getAsietTransRegViewModel() {
        return this.mAsietTransRegViewModel;
    }

    public static FragmentAsietTransRegHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAsietTransRegHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAsietTransRegHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_asiet_trans_reg_history, root, attachToRoot, component);
    }

    public static FragmentAsietTransRegHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAsietTransRegHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAsietTransRegHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_asiet_trans_reg_history, null, false, component);
    }

    public static FragmentAsietTransRegHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAsietTransRegHistoryBinding bind(View view, Object component) {
        return (FragmentAsietTransRegHistoryBinding) bind(component, view, R.layout.fragment_asiet_trans_reg_history);
    }
}