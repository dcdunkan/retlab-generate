package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.message.inbox.MessageViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentMessageBinding extends ViewDataBinding {
    public final CoordinatorLayout inboxLayout;

    @Bindable
    protected MessageViewModel mMessageViewModel;
    public final RecyclerView rvInbox;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setMessageViewModel(MessageViewModel messageViewModel);

    protected FragmentMessageBinding(Object _bindingComponent, View _root, int _localFieldCount, CoordinatorLayout inboxLayout, RecyclerView rvInbox, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.inboxLayout = inboxLayout;
        this.rvInbox = rvInbox;
        this.swipeLayout = swipeLayout;
    }

    public MessageViewModel getMessageViewModel() {
        return this.mMessageViewModel;
    }

    public static FragmentMessageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMessageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentMessageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_message, root, attachToRoot, component);
    }

    public static FragmentMessageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMessageBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentMessageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_message, null, false, component);
    }

    public static FragmentMessageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMessageBinding bind(View view, Object component) {
        return (FragmentMessageBinding) bind(component, view, R.layout.fragment_message);
    }
}