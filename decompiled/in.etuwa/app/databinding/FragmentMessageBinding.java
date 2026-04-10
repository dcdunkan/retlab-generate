package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.message.inbox.MessageViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentMessageBinding extends ViewDataBinding {
    public final HorizontalScrollView hrView;
    public final TextView inboxBtn;
    public final LinearLayout inboxLayout;

    @Bindable
    protected MessageViewModel mMessageViewModel;
    public final RecyclerView rvInbox;
    public final RecyclerView rvSentItems;
    public final TextView sentBtn;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;

    public abstract void setMessageViewModel(MessageViewModel messageViewModel);

    protected FragmentMessageBinding(Object _bindingComponent, View _root, int _localFieldCount, HorizontalScrollView hrView, TextView inboxBtn, LinearLayout inboxLayout, RecyclerView rvInbox, RecyclerView rvSentItems, TextView sentBtn, SwipeRefreshLayout swipeLayout, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.hrView = hrView;
        this.inboxBtn = inboxBtn;
        this.inboxLayout = inboxLayout;
        this.rvInbox = rvInbox;
        this.rvSentItems = rvSentItems;
        this.sentBtn = sentBtn;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
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