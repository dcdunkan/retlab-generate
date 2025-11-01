package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class TableviewColumnHeaderLayoutBinding implements ViewBinding {
    public final LinearLayout columnHeaderContainer;
    public final ImageButton columnHeaderSortImageButton;
    public final TextView columnHeaderTextView;
    private final LinearLayout rootView;

    private TableviewColumnHeaderLayoutBinding(LinearLayout rootView, LinearLayout columnHeaderContainer, ImageButton columnHeaderSortImageButton, TextView columnHeaderTextView) {
        this.rootView = rootView;
        this.columnHeaderContainer = columnHeaderContainer;
        this.columnHeaderSortImageButton = columnHeaderSortImageButton;
        this.columnHeaderTextView = columnHeaderTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TableviewColumnHeaderLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TableviewColumnHeaderLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tableview_column_header_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TableviewColumnHeaderLayoutBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.column_header_sort_imageButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, i);
        if (imageButton != null) {
            i = R.id.column_header_textView;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new TableviewColumnHeaderLayoutBinding(linearLayout, linearLayout, imageButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}