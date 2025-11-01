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
public final class RowCellMembers2Binding implements ViewBinding {
    public final TextView cellLevel;
    public final TextView cellName;
    private final LinearLayout rootView;

    private RowCellMembers2Binding(LinearLayout rootView, TextView cellLevel, TextView cellName) {
        this.rootView = rootView;
        this.cellLevel = cellLevel;
        this.cellName = cellName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowCellMembers2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCellMembers2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_cell_members2, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowCellMembers2Binding bind(View rootView) {
        int i = R.id.cell_level;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.cell_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowCellMembers2Binding((LinearLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}