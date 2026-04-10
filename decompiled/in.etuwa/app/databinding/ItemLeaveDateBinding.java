package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemLeaveDateBinding implements ViewBinding {
    public final MaterialCardView cardDateItem;
    public final MaterialCheckBox checkboxDate;
    private final MaterialCardView rootView;
    public final TextView tvDate;

    private ItemLeaveDateBinding(MaterialCardView rootView, MaterialCardView cardDateItem, MaterialCheckBox checkboxDate, TextView tvDate) {
        this.rootView = rootView;
        this.cardDateItem = cardDateItem;
        this.checkboxDate = checkboxDate;
        this.tvDate = tvDate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemLeaveDateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemLeaveDateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_leave_date, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLeaveDateBinding bind(View rootView) {
        MaterialCardView materialCardView = (MaterialCardView) rootView;
        int i = R.id.checkbox_date;
        MaterialCheckBox materialCheckBox = (MaterialCheckBox) ViewBindings.findChildViewById(rootView, i);
        if (materialCheckBox != null) {
            i = R.id.tv_date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new ItemLeaveDateBinding(materialCardView, materialCardView, materialCheckBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}