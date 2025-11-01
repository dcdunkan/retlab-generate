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
public final class RowQuestionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvDoc;
    public final TextView tvDocDownBtn;
    public final TextView tvNo;

    private RowQuestionBinding(LinearLayout rootView, TextView tvDoc, TextView tvDocDownBtn, TextView tvNo) {
        this.rootView = rootView;
        this.tvDoc = tvDoc;
        this.tvDocDownBtn = tvDocDownBtn;
        this.tvNo = tvNo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowQuestionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowQuestionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_question, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowQuestionBinding bind(View rootView) {
        int i = R.id.tv_doc;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_doc_down_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tv_no;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowQuestionBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}