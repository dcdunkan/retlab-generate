package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowCommentsBinding implements ViewBinding {
    public final RelativeLayout commentLayout;
    public final TextView commentText;
    public final CircleImageView commentUserImg;
    public final TextView commentUserName;
    public final TextView replyBtn;
    public final RelativeLayout replyLayout;
    public final TextView replyText;
    public final CircleImageView replyUserImg;
    public final TextView replyUserName;
    private final LinearLayout rootView;

    private RowCommentsBinding(LinearLayout rootView, RelativeLayout commentLayout, TextView commentText, CircleImageView commentUserImg, TextView commentUserName, TextView replyBtn, RelativeLayout replyLayout, TextView replyText, CircleImageView replyUserImg, TextView replyUserName) {
        this.rootView = rootView;
        this.commentLayout = commentLayout;
        this.commentText = commentText;
        this.commentUserImg = commentUserImg;
        this.commentUserName = commentUserName;
        this.replyBtn = replyBtn;
        this.replyLayout = replyLayout;
        this.replyText = replyText;
        this.replyUserImg = replyUserImg;
        this.replyUserName = replyUserName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowCommentsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCommentsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_comments, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowCommentsBinding bind(View rootView) {
        int i = R.id.comment_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
        if (relativeLayout != null) {
            i = R.id.comment_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.comment_user_img;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, i);
                if (circleImageView != null) {
                    i = R.id.comment_user_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.reply_btn;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.reply_layout;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                            if (relativeLayout2 != null) {
                                i = R.id.reply_text;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.reply_user_img;
                                    CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (circleImageView2 != null) {
                                        i = R.id.reply_user_name;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView5 != null) {
                                            return new RowCommentsBinding((LinearLayout) rootView, relativeLayout, textView, circleImageView, textView2, textView3, relativeLayout2, textView4, circleImageView2, textView5);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}