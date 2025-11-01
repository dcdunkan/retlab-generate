package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowStoreBinding implements ViewBinding {
    public final LinearLayout dueLayout;
    private final CardView rootView;
    public final CheckBox storeCheckBox;
    public final TextView storeTitle;
    public final TextView storeTitlePrice;

    private RowStoreBinding(CardView rootView, LinearLayout dueLayout, CheckBox storeCheckBox, TextView storeTitle, TextView storeTitlePrice) {
        this.rootView = rootView;
        this.dueLayout = dueLayout;
        this.storeCheckBox = storeCheckBox;
        this.storeTitle = storeTitle;
        this.storeTitlePrice = storeTitlePrice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowStoreBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowStoreBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_store, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowStoreBinding bind(View rootView) {
        int i = R.id.due_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.store_check_box;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
            if (checkBox != null) {
                i = R.id.store_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.store_title_price;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new RowStoreBinding((CardView) rootView, linearLayout, checkBox, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}