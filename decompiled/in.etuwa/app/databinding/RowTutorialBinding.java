package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowTutorialBinding implements ViewBinding {
    public final MaterialCardView deleteCv;
    public final TextView deleteTutorial;
    public final TextView details;
    public final MaterialCardView downloadCv;
    private final MaterialCardView rootView;
    public final View submittedView;
    public final LinearLayout tutDetailsLayout;
    public final TextView tutorialDetails;
    public final TextView tutorialDownload;
    public final TextView tutorialIssueDate;
    public final TextView tutorialLastDate;
    public final TextView tutorialName;
    public final TextView tutorialSem;
    public final TextView tutorialStatus;
    public final TextView tutorialTitle;
    public final TextView tutorialUpload;
    public final MaterialCardView uploadCv;

    private RowTutorialBinding(MaterialCardView rootView, MaterialCardView deleteCv, TextView deleteTutorial, TextView details, MaterialCardView downloadCv, View submittedView, LinearLayout tutDetailsLayout, TextView tutorialDetails, TextView tutorialDownload, TextView tutorialIssueDate, TextView tutorialLastDate, TextView tutorialName, TextView tutorialSem, TextView tutorialStatus, TextView tutorialTitle, TextView tutorialUpload, MaterialCardView uploadCv) {
        this.rootView = rootView;
        this.deleteCv = deleteCv;
        this.deleteTutorial = deleteTutorial;
        this.details = details;
        this.downloadCv = downloadCv;
        this.submittedView = submittedView;
        this.tutDetailsLayout = tutDetailsLayout;
        this.tutorialDetails = tutorialDetails;
        this.tutorialDownload = tutorialDownload;
        this.tutorialIssueDate = tutorialIssueDate;
        this.tutorialLastDate = tutorialLastDate;
        this.tutorialName = tutorialName;
        this.tutorialSem = tutorialSem;
        this.tutorialStatus = tutorialStatus;
        this.tutorialTitle = tutorialTitle;
        this.tutorialUpload = tutorialUpload;
        this.uploadCv = uploadCv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowTutorialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTutorialBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_tutorial, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowTutorialBinding bind(View rootView) {
        View viewFindChildViewById;
        int i = R.id.deleteCv;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
        if (materialCardView != null) {
            i = R.id.delete_tutorial;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.details;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.downloadCv;
                    MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
                    if (materialCardView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.submitted_view))) != null) {
                        i = R.id.tut_details_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.tutorial_details;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.tutorial_download;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.tutorial_issue_date;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.tutorial_last_date;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            i = R.id.tutorial_name;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView7 != null) {
                                                i = R.id.tutorial_sem;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView8 != null) {
                                                    i = R.id.tutorial_status;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView9 != null) {
                                                        i = R.id.tutorial_title;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView10 != null) {
                                                            i = R.id.tutorial_upload;
                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView11 != null) {
                                                                i = R.id.uploadCv;
                                                                MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
                                                                if (materialCardView3 != null) {
                                                                    return new RowTutorialBinding((MaterialCardView) rootView, materialCardView, textView, textView2, materialCardView2, viewFindChildViewById, linearLayout, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, materialCardView3);
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