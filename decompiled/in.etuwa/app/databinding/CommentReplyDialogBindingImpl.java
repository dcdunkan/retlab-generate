package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogViewModel;

/* loaded from: classes3.dex */
public class CommentReplyDialogBindingImpl extends CommentReplyDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final RelativeLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.reply_comment_user_img, 3);
        sparseIntArray.put(R.id.comment_layout, 4);
        sparseIntArray.put(R.id.reply_comment_user_name, 5);
        sparseIntArray.put(R.id.reply_comment_text, 6);
        sparseIntArray.put(R.id.swipe_layout, 7);
        sparseIntArray.put(R.id.rv_reply, 8);
        sparseIntArray.put(R.id.line, 9);
        sparseIntArray.put(R.id.et_reply_msg, 10);
        sparseIntArray.put(R.id.reply_btn_send, 11);
    }

    public CommentReplyDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private CommentReplyDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RelativeLayout) bindings[4], (EditText) bindings[10], (View) bindings[9], (ImageButton) bindings[11], (TextView) bindings[6], (CircleImageView) bindings[3], (TextView) bindings[5], (RecyclerView) bindings[8], (SwipeRefreshLayout) bindings[7]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[1];
        this.mboundView1 = relativeLayout;
        relativeLayout.setTag(null);
        Object obj = bindings[2];
        this.mboundView11 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (57 != variableId) {
            return false;
        }
        setCommentReplyDialogViewModel((CommentReplyDialogViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.CommentReplyDialogBinding
    public void setCommentReplyDialogViewModel(CommentReplyDialogViewModel CommentReplyDialogViewModel) {
        this.mCommentReplyDialogViewModel = CommentReplyDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}