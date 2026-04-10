package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowEvaluationAssignmentsBinding implements ViewBinding {
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
    public final MaterialCardView deleteCv;
    public final TextView details;
    public final MaterialCardView downloadCv;
    public final LinearLayout expandAssLayout;
    public final TextView linkTv;
    private final MaterialCardView rootView;
    public final View submittedView;
    public final MaterialCardView uploadCv;

    private RowEvaluationAssignmentsBinding(MaterialCardView rootView, LinearLayout assDetailsLayout, LinearLayout assiDetailLayout, ExpandableTextView assiDetails, TextView assiDownload, TextView assiIssueDate, TextView assiLastDate, TextView assiName, TextView assiTitle, TextView assiToggle, TextView assiUpload, TextView deleteAssignment, MaterialCardView deleteCv, TextView details, MaterialCardView downloadCv, LinearLayout expandAssLayout, TextView linkTv, View submittedView, MaterialCardView uploadCv) {
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
        this.deleteCv = deleteCv;
        this.details = details;
        this.downloadCv = downloadCv;
        this.expandAssLayout = expandAssLayout;
        this.linkTv = linkTv;
        this.submittedView = submittedView;
        this.uploadCv = uploadCv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowEvaluationAssignmentsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowEvaluationAssignmentsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_evaluation_assignments, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowEvaluationAssignmentsBinding bind(View rootView) {
        View viewFindChildViewById;
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
                                                    i = R.id.deleteCv;
                                                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
                                                    if (materialCardView != null) {
                                                        i = R.id.details;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView9 != null) {
                                                            i = R.id.downloadCv;
                                                            MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
                                                            if (materialCardView2 != null) {
                                                                i = R.id.expand_ass_layout;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.linkTv;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.submitted_view))) != null) {
                                                                        i = R.id.uploadCv;
                                                                        MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (materialCardView3 != null) {
                                                                            return new RowEvaluationAssignmentsBinding((MaterialCardView) rootView, linearLayout, linearLayout2, expandableTextView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, materialCardView, textView9, materialCardView2, linearLayout3, textView10, viewFindChildViewById, materialCardView3);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}