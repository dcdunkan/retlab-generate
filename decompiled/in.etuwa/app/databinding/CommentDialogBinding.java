package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.chat.comment.CommentDialogViewModel;

/* loaded from: classes3.dex */
public abstract class CommentDialogBinding extends ViewDataBinding {
    public final ImageButton btnSend;
    public final EditText etCommentMsg;
    public final View line;

    @Bindable
    protected CommentDialogViewModel mCommentDialogViewModel;
    public final RecyclerView rvComment;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCommentDialogViewModel(CommentDialogViewModel commentDialogViewModel);

    protected CommentDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageButton btnSend, EditText etCommentMsg, View line, RecyclerView rvComment, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnSend = btnSend;
        this.etCommentMsg = etCommentMsg;
        this.line = line;
        this.rvComment = rvComment;
        this.swipeLayout = swipeLayout;
    }

    public CommentDialogViewModel getCommentDialogViewModel() {
        return this.mCommentDialogViewModel;
    }

    public static CommentDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CommentDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.comment_dialog, root, attachToRoot, component);
    }

    public static CommentDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CommentDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.comment_dialog, null, false, component);
    }

    public static CommentDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentDialogBinding bind(View view, Object component) {
        return (CommentDialogBinding) bind(component, view, R.layout.comment_dialog);
    }
}