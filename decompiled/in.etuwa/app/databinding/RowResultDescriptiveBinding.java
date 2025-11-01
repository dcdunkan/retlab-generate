package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowResultDescriptiveBinding implements ViewBinding {
    public final TextView descriptiveAnswer;
    public final TextView descriptiveIsAttended;
    public final TextView descriptiveMark;
    public final WebView descriptiveQuestion;
    public final LinearLayout mcqOptionView;
    public final TextView qTxt;
    private final LinearLayout rootView;

    private RowResultDescriptiveBinding(LinearLayout rootView, TextView descriptiveAnswer, TextView descriptiveIsAttended, TextView descriptiveMark, WebView descriptiveQuestion, LinearLayout mcqOptionView, TextView qTxt) {
        this.rootView = rootView;
        this.descriptiveAnswer = descriptiveAnswer;
        this.descriptiveIsAttended = descriptiveIsAttended;
        this.descriptiveMark = descriptiveMark;
        this.descriptiveQuestion = descriptiveQuestion;
        this.mcqOptionView = mcqOptionView;
        this.qTxt = qTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowResultDescriptiveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultDescriptiveBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_result_descriptive, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowResultDescriptiveBinding bind(View rootView) {
        int i = R.id.descriptive_answer;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.descriptive_is_attended;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.descriptive_mark;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.descriptive_question;
                    WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
                    if (webView != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        i = R.id.q_txt;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new RowResultDescriptiveBinding(linearLayout, textView, textView2, textView3, webView, linearLayout, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}