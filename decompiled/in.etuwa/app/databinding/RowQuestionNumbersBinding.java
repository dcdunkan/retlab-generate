package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowQuestionNumbersBinding implements ViewBinding {
    public final LinearLayout cardDash;
    public final TextView questionTv;
    private final LinearLayout rootView;

    private RowQuestionNumbersBinding(LinearLayout rootView, LinearLayout cardDash, TextView questionTv) {
        this.rootView = rootView;
        this.cardDash = cardDash;
        this.questionTv = questionTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowQuestionNumbersBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowQuestionNumbersBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_question_numbers, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowQuestionNumbersBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.question_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new RowQuestionNumbersBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}