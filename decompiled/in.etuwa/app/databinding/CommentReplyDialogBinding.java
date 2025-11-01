package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogViewModel;

/* loaded from: classes3.dex */
public abstract class CommentReplyDialogBinding extends ViewDataBinding {
    public final RelativeLayout commentLayout;
    public final EditText etReplyMsg;
    public final View line;

    @Bindable
    protected CommentReplyDialogViewModel mCommentReplyDialogViewModel;
    public final ImageButton replyBtnSend;
    public final TextView replyCommentText;
    public final CircleImageView replyCommentUserImg;
    public final TextView replyCommentUserName;
    public final RecyclerView rvReply;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCommentReplyDialogViewModel(CommentReplyDialogViewModel commentReplyDialogViewModel);

    protected CommentReplyDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout commentLayout, EditText etReplyMsg, View line, ImageButton replyBtnSend, TextView replyCommentText, CircleImageView replyCommentUserImg, TextView replyCommentUserName, RecyclerView rvReply, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.commentLayout = commentLayout;
        this.etReplyMsg = etReplyMsg;
        this.line = line;
        this.replyBtnSend = replyBtnSend;
        this.replyCommentText = replyCommentText;
        this.replyCommentUserImg = replyCommentUserImg;
        this.replyCommentUserName = replyCommentUserName;
        this.rvReply = rvReply;
        this.swipeLayout = swipeLayout;
    }

    public CommentReplyDialogViewModel getCommentReplyDialogViewModel() {
        return this.mCommentReplyDialogViewModel;
    }

    public static CommentReplyDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentReplyDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CommentReplyDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.comment_reply_dialog, root, attachToRoot, component);
    }

    public static CommentReplyDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentReplyDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CommentReplyDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.comment_reply_dialog, null, false, component);
    }

    public static CommentReplyDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentReplyDialogBinding bind(View view, Object component) {
        return (CommentReplyDialogBinding) bind(component, view, R.layout.comment_reply_dialog);
    }
}