package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.material.button.MaterialButton;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowNoticeBinding implements ViewBinding {
    public final ExpandableTextView noticeContent;
    public final TextView noticeCreate;
    public final TextView noticeDate;
    public final TextView noticeHeading;
    private final CardView rootView;
    public final ImageView toggleChevron;
    public final TextView toggleLabel;
    public final LinearLayout topicToggle;
    public final View viewAccentBar;
    public final MaterialButton viewBtnHr;

    private RowNoticeBinding(CardView rootView, ExpandableTextView noticeContent, TextView noticeCreate, TextView noticeDate, TextView noticeHeading, ImageView toggleChevron, TextView toggleLabel, LinearLayout topicToggle, View viewAccentBar, MaterialButton viewBtnHr) {
        this.rootView = rootView;
        this.noticeContent = noticeContent;
        this.noticeCreate = noticeCreate;
        this.noticeDate = noticeDate;
        this.noticeHeading = noticeHeading;
        this.toggleChevron = toggleChevron;
        this.toggleLabel = toggleLabel;
        this.topicToggle = topicToggle;
        this.viewAccentBar = viewAccentBar;
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
        View viewInflate = inflater.inflate(R.layout.row_notice, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowNoticeBinding bind(View rootView) {
        View viewFindChildViewById;
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
                        i = R.id.toggle_chevron;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.toggle_label;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.topic_toggle;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_accent_bar))) != null) {
                                    i = R.id.view_btn_hr;
                                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                                    if (materialButton != null) {
                                        return new RowNoticeBinding((CardView) rootView, expandableTextView, textView, textView2, textView3, imageView, textView4, linearLayout, viewFindChildViewById, materialButton);
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