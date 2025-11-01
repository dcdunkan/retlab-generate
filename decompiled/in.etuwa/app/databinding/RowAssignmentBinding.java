package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.blogc.android.views.ExpandableTextView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowAssignmentBinding implements ViewBinding {
    public final LinearLayout assDetailsLayout;
    public final LinearLayout assiDetailLayout;
    public final ExpandableTextView assiDetails;
    public final TextView assiDownload;
    public final TextView assiIssueDate;
    public final TextView assiLastDate;
    public final TextView assiName;
    public final TextView assiTitle;
    public final TextView assiToggle;
    public final TextView assiUpload;
    public final TextView deleteAssignment;
    public final TextView details;
    public final LinearLayout expandAssLayout;
    private final CardView rootView;
    public final View submittedView;

    private RowAssignmentBinding(CardView rootView, LinearLayout assDetailsLayout, LinearLayout assiDetailLayout, ExpandableTextView assiDetails, TextView assiDownload, TextView assiIssueDate, TextView assiLastDate, TextView assiName, TextView assiTitle, TextView assiToggle, TextView assiUpload, TextView deleteAssignment, TextView details, LinearLayout expandAssLayout, View submittedView) {
        this.rootView = rootView;
        this.assDetailsLayout = assDetailsLayout;
        this.assiDetailLayout = assiDetailLayout;
        this.assiDetails = assiDetails;
        this.assiDownload = assiDownload;
        this.assiIssueDate = assiIssueDate;
        this.assiLastDate = assiLastDate;
        this.assiName = assiName;
        this.assiTitle = assiTitle;
        this.assiToggle = assiToggle;
        this.assiUpload = assiUpload;
        this.deleteAssignment = deleteAssignment;
        this.details = details;
        this.expandAssLayout = expandAssLayout;
        this.submittedView = submittedView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowAssignmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowAssignmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_assignment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowAssignmentBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.ass_details_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.assi_detail_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.assi_details;
                ExpandableTextView expandableTextView = (ExpandableTextView) ViewBindings.findChildViewById(rootView, i);
                if (expandableTextView != null) {
                    i = R.id.assi_download;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.assi_issue_date;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.assi_last_date;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.assi_name;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.assi_title;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.assi_toggle;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            i = R.id.assi_upload;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView7 != null) {
                                                i = R.id.delete_assignment;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView8 != null) {
                                                    i = R.id.details;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView9 != null) {
                                                        i = R.id.expand_ass_layout;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.submitted_view))) != null) {
                                                            return new RowAssignmentBinding((CardView) rootView, linearLayout, linearLayout2, expandableTextView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, linearLayout3, findChildViewById);
                                                        }
                                                    }
                                                }
                                            }
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