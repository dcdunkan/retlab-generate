package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class BottomSheetForceUpdateBinding implements ViewBinding {
    public final TextView btnUpdate;
    public final ItemFeatureRowBinding feature1;
    public final ItemFeatureRowBinding feature2;
    public final ItemFeatureRowBinding feature3;
    private final LinearLayout rootView;

    private BottomSheetForceUpdateBinding(LinearLayout rootView, TextView btnUpdate, ItemFeatureRowBinding feature1, ItemFeatureRowBinding feature2, ItemFeatureRowBinding feature3) {
        this.rootView = rootView;
        this.btnUpdate = btnUpdate;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetForceUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetForceUpdateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_force_update, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetForceUpdateBinding bind(View rootView) {
        View viewFindChildViewById;
        int i = R.id.btnUpdate;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.feature1))) != null) {
            ItemFeatureRowBinding itemFeatureRowBindingBind = ItemFeatureRowBinding.bind(viewFindChildViewById);
            i = R.id.feature2;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (viewFindChildViewById2 != null) {
                ItemFeatureRowBinding itemFeatureRowBindingBind2 = ItemFeatureRowBinding.bind(viewFindChildViewById2);
                i = R.id.feature3;
                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (viewFindChildViewById3 != null) {
                    return new BottomSheetForceUpdateBinding((LinearLayout) rootView, textView, itemFeatureRowBindingBind, itemFeatureRowBindingBind2, ItemFeatureRowBinding.bind(viewFindChildViewById3));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}