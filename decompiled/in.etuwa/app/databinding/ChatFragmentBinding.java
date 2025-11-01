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
import in.etuwa.app.ui.chat.ChatViewModel;

/* loaded from: classes3.dex */
public abstract class ChatFragmentBinding extends ViewDataBinding {

    @Bindable
    protected ChatViewModel mChatViewModel;
    public final RecyclerView rvChat;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setChatViewModel(ChatViewModel chatViewModel);

    protected ChatFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvChat, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvChat = rvChat;
        this.swipeLayout = swipeLayout;
    }

    public ChatViewModel getChatViewModel() {
        return this.mChatViewModel;
    }

    public static ChatFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChatFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ChatFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.chat_fragment, root, attachToRoot, component);
    }

    public static ChatFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChatFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ChatFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.chat_fragment, null, false, component);
    }

    public static ChatFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChatFragmentBinding bind(View view, Object component) {
        return (ChatFragmentBinding) bind(component, view, R.layout.chat_fragment);
    }
}