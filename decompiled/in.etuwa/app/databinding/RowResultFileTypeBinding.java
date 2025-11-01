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
public final class RowResultFileTypeBinding implements ViewBinding {
    public final TextView fileTypeAnswer;
    public final TextView fileTypeIsAttended;
    public final TextView fileTypeMark;
    public final WebView fileTypeQuestion;
    public final TextView fileTypeViewBtn;
    public final TextView qTxt;
    private final LinearLayout rootView;

    private RowResultFileTypeBinding(LinearLayout rootView, TextView fileTypeAnswer, TextView fileTypeIsAttended, TextView fileTypeMark, WebView fileTypeQuestion, TextView fileTypeViewBtn, TextView qTxt) {
        this.rootView = rootView;
        this.fileTypeAnswer = fileTypeAnswer;
        this.fileTypeIsAttended = fileTypeIsAttended;
        this.fileTypeMark = fileTypeMark;
        this.fileTypeQuestion = fileTypeQuestion;
        this.fileTypeViewBtn = fileTypeViewBtn;
        this.qTxt = qTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowResultFileTypeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultFileTypeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_result_file_type, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowResultFileTypeBinding bind(View rootView) {
        int i = R.id.file_type_answer;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.file_type_is_attended;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.file_type_mark;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.file_type_question;
                    WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
                    if (webView != null) {
                        i = R.id.file_type_view_btn;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.q_txt;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                return new RowResultFileTypeBinding((LinearLayout) rootView, textView, textView2, textView3, webView, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}