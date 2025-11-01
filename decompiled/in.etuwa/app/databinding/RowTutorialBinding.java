package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowTutorialBinding implements ViewBinding {
    public final TextView deleteTutorial;
    private final CardView rootView;
    public final TextView tutorialDetails;
    public final TextView tutorialDownload;
    public final TextView tutorialIssueDate;
    public final TextView tutorialLastDate;
    public final TextView tutorialName;
    public final TextView tutorialSem;
    public final TextView tutorialStatus;
    public final TextView tutorialTitle;
    public final TextView tutorialUpload;

    private RowTutorialBinding(CardView rootView, TextView deleteTutorial, TextView tutorialDetails, TextView tutorialDownload, TextView tutorialIssueDate, TextView tutorialLastDate, TextView tutorialName, TextView tutorialSem, TextView tutorialStatus, TextView tutorialTitle, TextView tutorialUpload) {
        this.rootView = rootView;
        this.deleteTutorial = deleteTutorial;
        this.tutorialDetails = tutorialDetails;
        this.tutorialDownload = tutorialDownload;
        this.tutorialIssueDate = tutorialIssueDate;
        this.tutorialLastDate = tutorialLastDate;
        this.tutorialName = tutorialName;
        this.tutorialSem = tutorialSem;
        this.tutorialStatus = tutorialStatus;
        this.tutorialTitle = tutorialTitle;
        this.tutorialUpload = tutorialUpload;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTutorialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTutorialBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_tutorial, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTutorialBinding bind(View rootView) {
        int i = R.id.delete_tutorial;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tutorial_details;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tutorial_download;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.tutorial_issue_date;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.tutorial_last_date;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.tutorial_name;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.tutorial_sem;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.tutorial_status;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        i = R.id.tutorial_title;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView9 != null) {
                                            i = R.id.tutorial_upload;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView10 != null) {
                                                return new RowTutorialBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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