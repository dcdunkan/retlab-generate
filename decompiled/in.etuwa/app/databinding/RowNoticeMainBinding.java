package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowNoticeMainBinding implements ViewBinding {
    public final ExpandableTextView noticeContent;
    public final TextView noticeCreate;
    public final TextView noticeDate;
    public final TextView noticeHeading;
    private final MaterialCardView rootView;
    public final TextView topicToggle;
    public final MaterialButton viewBtnHr;

    private RowNoticeMainBinding(MaterialCardView rootView, ExpandableTextView noticeContent, TextView noticeCreate, TextView noticeDate, TextView noticeHeading, TextView topicToggle, MaterialButton viewBtnHr) {
        this.rootView = rootView;
        this.noticeContent = noticeContent;
        this.noticeCreate = noticeCreate;
        this.noticeDate = noticeDate;
        this.noticeHeading = noticeHeading;
        this.topicToggle = topicToggle;
        this.viewBtnHr = viewBtnHr;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowNoticeMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowNoticeMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_notice_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowNoticeMainBinding bind(View rootView) {
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
                            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                            if (materialButton != null) {
                                return new RowNoticeMainBinding((MaterialCardView) rootView, expandableTextView, textView, textView2, textView3, textView4, materialButton);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}