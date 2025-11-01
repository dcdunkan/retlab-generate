package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowExamSubject3Binding implements ViewBinding {
    public final LinearLayout comletionLayout;
    public final LinearLayout dueLayout;
    private final CardView rootView;
    public final TextView subjectHead;
    public final TextView viewBtn;
    public final TextView viewRegisterBtn;

    private RowExamSubject3Binding(CardView rootView, LinearLayout comletionLayout, LinearLayout dueLayout, TextView subjectHead, TextView viewBtn, TextView viewRegisterBtn) {
        this.rootView = rootView;
        this.comletionLayout = comletionLayout;
        this.dueLayout = dueLayout;
        this.subjectHead = subjectHead;
        this.viewBtn = viewBtn;
        this.viewRegisterBtn = viewRegisterBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowExamSubject3Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamSubject3Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_exam_subject3, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowExamSubject3Binding bind(View rootView) {
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
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.view_register_btn;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            return new RowExamSubject3Binding((CardView) rootView, linearLayout, linearLayout2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}