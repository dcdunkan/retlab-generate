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
public final class RowPrebookingBinding implements ViewBinding {
    public final TextView preBookBtn;
    private final LinearLayout rootView;
    public final TextView tvCategory;
    public final TextView tvPrice;
    public final TextView tvProductName;
    public final TextView tvSubCategory;

    private RowPrebookingBinding(LinearLayout rootView, TextView preBookBtn, TextView tvCategory, TextView tvPrice, TextView tvProductName, TextView tvSubCategory) {
        this.rootView = rootView;
        this.preBookBtn = preBookBtn;
        this.tvCategory = tvCategory;
        this.tvPrice = tvPrice;
        this.tvProductName = tvProductName;
        this.tvSubCategory = tvSubCategory;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowPrebookingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowPrebookingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_prebooking, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowPrebookingBinding bind(View rootView) {
        int i = R.id.pre_book_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_category;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tv_price;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.tv_product_name;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.tv_sub_category;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new RowPrebookingBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}