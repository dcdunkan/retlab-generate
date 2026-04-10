package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowCircularBinding implements ViewBinding {
    public final MaterialButton circDownload;
    public final TextView circularDate;
    public final TextView circularDescription;
    public final TextView circularLink;
    public final TextView circularName;
    private final LinearLayout rootView;

    private RowCircularBinding(LinearLayout rootView, MaterialButton circDownload, TextView circularDate, TextView circularDescription, TextView circularLink, TextView circularName) {
        this.rootView = rootView;
        this.circDownload = circDownload;
        this.circularDate = circularDate;
        this.circularDescription = circularDescription;
        this.circularLink = circularLink;
        this.circularName = circularName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowCircularBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCircularBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_circular, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowCircularBinding bind(View rootView) {
        int i = R.id.circ_download;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.circular_date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.circular_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.circular_link;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.circular_name;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new RowCircularBinding((LinearLayout) rootView, materialButton, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}