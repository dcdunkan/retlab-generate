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
public final class RowPublicaatiionSemBinding implements ViewBinding {
    public final TextView indexTv;
    public final TextView journalNameTv;
    private final LinearLayout rootView;
    public final TextView titleTv;

    private RowPublicaatiionSemBinding(LinearLayout rootView, TextView indexTv, TextView journalNameTv, TextView titleTv) {
        this.rootView = rootView;
        this.indexTv = indexTv;
        this.journalNameTv = journalNameTv;
        this.titleTv = titleTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowPublicaatiionSemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowPublicaatiionSemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_publicaatiion_sem, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowPublicaatiionSemBinding bind(View rootView) {
        int i = R.id.index_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.journal_name_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.title_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowPublicaatiionSemBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}