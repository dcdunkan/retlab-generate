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
public final class RowGrDocsBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvGrDoc;
    public final TextView tvGrDocDownBtn;
    public final TextView tvGrNo;

    private RowGrDocsBinding(LinearLayout rootView, TextView tvGrDoc, TextView tvGrDocDownBtn, TextView tvGrNo) {
        this.rootView = rootView;
        this.tvGrDoc = tvGrDoc;
        this.tvGrDocDownBtn = tvGrDocDownBtn;
        this.tvGrNo = tvGrNo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowGrDocsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowGrDocsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_gr_docs, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowGrDocsBinding bind(View rootView) {
        int i = R.id.tv_gr_doc;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_gr_doc_down_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tv_gr_no;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowGrDocsBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}