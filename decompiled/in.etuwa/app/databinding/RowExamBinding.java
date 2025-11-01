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
public final class RowExamBinding implements ViewBinding {
    public final TextView deleteExm;
    public final TextView examSubject;
    public final TextView exmDownload;
    public final TextView exmIssueDate;
    public final TextView exmLastDate;
    public final TextView exmSem;
    public final TextView exmStatus;
    public final TextView exmTitle;
    public final TextView exmUploadBtn;
    private final CardView rootView;
    public final View submittedViewModule;

    private RowExamBinding(CardView rootView, TextView deleteExm, TextView examSubject, TextView exmDownload, TextView exmIssueDate, TextView exmLastDate, TextView exmSem, TextView exmStatus, TextView exmTitle, TextView exmUploadBtn, View submittedViewModule) {
        this.rootView = rootView;
        this.deleteExm = deleteExm;
        this.examSubject = examSubject;
        this.exmDownload = exmDownload;
        this.exmIssueDate = exmIssueDate;
        this.exmLastDate = exmLastDate;
        this.exmSem = exmSem;
        this.exmStatus = exmStatus;
        this.exmTitle = exmTitle;
        this.exmUploadBtn = exmUploadBtn;
        this.submittedViewModule = submittedViewModule;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowExamBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_exam, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowExamBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.delete_exm;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.exam_subject;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.exm_download;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.exm_issue_date;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.exm_last_date;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.exm_sem;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.exm_status;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.exm_title;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        i = R.id.exm_upload_btn;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView9 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.submitted_view_module))) != null) {
                                            return new RowExamBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, findChildViewById);
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