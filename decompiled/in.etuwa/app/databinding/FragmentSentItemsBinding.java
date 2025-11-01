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
import in.etuwa.app.ui.message.sentItems.SentItemViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentSentItemsBinding extends ViewDataBinding {

    @Bindable
    protected SentItemViewModel mSentItemViewModel;
    public final RecyclerView rvMsg;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSentItemViewModel(SentItemViewModel sentItemViewModel);

    protected FragmentSentItemsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvMsg, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvMsg = rvMsg;
        this.swipeLayout = swipeLayout;
    }

    public SentItemViewModel getSentItemViewModel() {
        return this.mSentItemViewModel;
    }

    public static FragmentSentItemsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSentItemsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSentItemsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sent_items, root, attachToRoot, component);
    }

    public static FragmentSentItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSentItemsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSentItemsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sent_items, null, false, component);
    }

    public static FragmentSentItemsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSentItemsBinding bind(View view, Object component) {
        return (FragmentSentItemsBinding) bind(component, view, R.layout.fragment_sent_items);
    }
}