package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.onlineclass.OnlineClassViewModel;

/* loaded from: classes3.dex */
public abstract class OnlineClassFragmentBinding extends ViewDataBinding {
    public final TextView batchClass;
    public final CardView cardBatch;

    @Bindable
    protected OnlineClassViewModel mOnlineClassViewModel;
    public final RecyclerView rvOnlineClass;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setOnlineClassViewModel(OnlineClassViewModel onlineClassViewModel);

    protected OnlineClassFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView batchClass, CardView cardBatch, RecyclerView rvOnlineClass, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.batchClass = batchClass;
        this.cardBatch = cardBatch;
        this.rvOnlineClass = rvOnlineClass;
        this.swipeLayout = swipeLayout;
    }

    public OnlineClassViewModel getOnlineClassViewModel() {
        return this.mOnlineClassViewModel;
    }

    public static OnlineClassFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnlineClassFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (OnlineClassFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.online_class_fragment, root, attachToRoot, component);
    }

    public static OnlineClassFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnlineClassFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (OnlineClassFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.online_class_fragment, null, false, component);
    }

    public static OnlineClassFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnlineClassFragmentBinding bind(View view, Object component) {
        return (OnlineClassFragmentBinding) bind(component, view, R.layout.online_class_fragment);
    }
}