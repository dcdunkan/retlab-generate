package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowEquipListBinding implements ViewBinding {
    public final TextView equipAssetType;
    public final TextView equipFecility;
    public final TextView equipStatus;
    public final TextView equipType;
    private final CardView rootView;

    private RowEquipListBinding(CardView rootView, TextView equipAssetType, TextView equipFecility, TextView equipStatus, TextView equipType) {
        this.rootView = rootView;
        this.equipAssetType = equipAssetType;
        this.equipFecility = equipFecility;
        this.equipStatus = equipStatus;
        this.equipType = equipType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowEquipListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowEquipListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_equip_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowEquipListBinding bind(View rootView) {
        int i = R.id.equip_asset_type;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.equip_fecility;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.equip_status;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.equip_type;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowEquipListBinding((CardView) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}