package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.blogc.android.views.ExpandableTextView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowNoticeBinding implements ViewBinding {
    public final ExpandableTextView noticeContent;
    public final TextView noticeCreate;
    public final TextView noticeDate;
    public final TextView noticeHeading;
    private final CardView rootView;
    public final TextView topicToggle;
    public final TextView viewBtnHr;

    private RowNoticeBinding(CardView rootView, ExpandableTextView noticeContent, TextView noticeCreate, TextView noticeDate, TextView noticeHeading, TextView topicToggle, TextView viewBtnHr) {
        this.rootView = rootView;
        this.noticeContent = noticeContent;
        this.noticeCreate = noticeCreate;
        this.noticeDate = noticeDate;
        this.noticeHeading = noticeHeading;
        this.topicToggle = topicToggle;
        this.viewBtnHr = viewBtnHr;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowNoticeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowNoticeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_notice, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowNoticeBinding bind(View rootView) {
        int i = R.id.notice_content;
        ExpandableTextView expandableTextView = (ExpandableTextView) ViewBindings.findChildViewById(rootView, i);
        if (expandableTextView != null) {
            i = R.id.notice_create;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.notice_date;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.notice_heading;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.topic_toggle;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.view_btn_hr;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                return new RowNoticeBinding((CardView) rootView, expandableTextView, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}