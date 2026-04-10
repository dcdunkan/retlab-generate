package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowExamBinding implements ViewBinding {
    public final MaterialButton deleteExm;
    public final TextView examSubject;
    public final MaterialButton exmDownload;
    public final TextView exmIssueDate;
    public final TextView exmLastDate;
    public final TextView exmSem;
    public final TextView exmTitle;
    public final MaterialButton exmUploadBtn;
    private final MaterialCardView rootView;
    public final View submittedViewModule;

    private RowExamBinding(MaterialCardView rootView, MaterialButton deleteExm, TextView examSubject, MaterialButton exmDownload, TextView exmIssueDate, TextView exmLastDate, TextView exmSem, TextView exmTitle, MaterialButton exmUploadBtn, View submittedViewModule) {
        this.rootView = rootView;
        this.deleteExm = deleteExm;
        this.examSubject = examSubject;
        this.exmDownload = exmDownload;
        this.exmIssueDate = exmIssueDate;
        this.exmLastDate = exmLastDate;
        this.exmSem = exmSem;
        this.exmTitle = exmTitle;
        this.exmUploadBtn = exmUploadBtn;
        this.submittedViewModule = submittedViewModule;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowExamBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_exam, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowExamBinding bind(View rootView) {
        View viewFindChildViewById;
        int i = R.id.delete_exm;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.exam_subject;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.exm_download;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                if (materialButton2 != null) {
                    i = R.id.exm_issue_date;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.exm_last_date;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.exm_sem;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.exm_title;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView5 != null) {
                                    i = R.id.exm_upload_btn;
                                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                                    if (materialButton3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.submitted_view_module))) != null) {
                                        return new RowExamBinding((MaterialCardView) rootView, materialButton, textView, materialButton2, textView2, textView3, textView4, textView5, materialButton3, viewFindChildViewById);
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