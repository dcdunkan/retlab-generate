package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.message.reply.ReplyViewModel;

/* loaded from: classes3.dex */
public abstract class ReplyDialogBinding extends ViewDataBinding {
    public final TextInputEditText etReplyMsg;

    @Bindable
    protected ReplyViewModel mReplyViewModel;
    public final TextView replyBtn;
    public final TextView tvFrom;

    public abstract void setReplyViewModel(ReplyViewModel replyViewModel);

    protected ReplyDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText etReplyMsg, TextView replyBtn, TextView tvFrom) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etReplyMsg = etReplyMsg;
        this.replyBtn = replyBtn;
        this.tvFrom = tvFrom;
    }

    public ReplyViewModel getReplyViewModel() {
        return this.mReplyViewModel;
    }

    public static ReplyDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReplyDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ReplyDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.reply_dialog, root, attachToRoot, component);
    }

    public static ReplyDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReplyDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ReplyDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.reply_dialog, null, false, component);
    }

    public static ReplyDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReplyDialogBinding bind(View view, Object component) {
        return (ReplyDialogBinding) bind(component, view, R.layout.reply_dialog);
    }
}