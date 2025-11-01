package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowReplysBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView viewReplyText;
    public final CircleImageView viewReplyUserImg;
    public final TextView viewReplyUserName;

    private RowReplysBinding(RelativeLayout rootView, TextView viewReplyText, CircleImageView viewReplyUserImg, TextView viewReplyUserName) {
        this.rootView = rootView;
        this.viewReplyText = viewReplyText;
        this.viewReplyUserImg = viewReplyUserImg;
        this.viewReplyUserName = viewReplyUserName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RowReplysBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowReplysBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_replys, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowReplysBinding bind(View rootView) {
        int i = R.id.view_reply_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.view_reply_user_img;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, i);
            if (circleImageView != null) {
                i = R.id.view_reply_user_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new RowReplysBinding((RelativeLayout) rootView, textView, circleImageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}