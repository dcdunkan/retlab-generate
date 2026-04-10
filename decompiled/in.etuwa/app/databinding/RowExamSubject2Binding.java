package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowExamSubject2Binding implements ViewBinding {
    public final LinearLayout comletionLayout;
    public final LinearLayout dueLayout;
    private final MaterialCardView rootView;
    public final TextView subjectHead;
    public final MaterialButton viewBtn;
    public final MaterialButton viewRegisterBtn;

    private RowExamSubject2Binding(MaterialCardView rootView, LinearLayout comletionLayout, LinearLayout dueLayout, TextView subjectHead, MaterialButton viewBtn, MaterialButton viewRegisterBtn) {
        this.rootView = rootView;
        this.comletionLayout = comletionLayout;
        this.dueLayout = dueLayout;
        this.subjectHead = subjectHead;
        this.viewBtn = viewBtn;
        this.viewRegisterBtn = viewRegisterBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowExamSubject2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamSubject2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_exam_subject2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowExamSubject2Binding bind(View rootView) {
        int i = R.id.comletion_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.due_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.subject_head;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.view_btn;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                    if (materialButton != null) {
                        i = R.id.view_register_btn;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                        if (materialButton2 != null) {
                            return new RowExamSubject2Binding((MaterialCardView) rootView, linearLayout, linearLayout2, textView, materialButton, materialButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}