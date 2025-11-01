package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowMaterialBinding implements ViewBinding {
    public final LinearLayout detailLayout;
    public final LinearLayout expandLayout;
    public final TextView materialDate;
    public final TextView materialDownloadBtn;
    public final TextView materialLink;
    public final TextView materialModule;
    public final TextView materialName;
    public final TextView materialSem;
    public final TextView materialTitle;
    private final CardView rootView;

    private RowMaterialBinding(CardView rootView, LinearLayout detailLayout, LinearLayout expandLayout, TextView materialDate, TextView materialDownloadBtn, TextView materialLink, TextView materialModule, TextView materialName, TextView materialSem, TextView materialTitle) {
        this.rootView = rootView;
        this.detailLayout = detailLayout;
        this.expandLayout = expandLayout;
        this.materialDate = materialDate;
        this.materialDownloadBtn = materialDownloadBtn;
        this.materialLink = materialLink;
        this.materialModule = materialModule;
        this.materialName = materialName;
        this.materialSem = materialSem;
        this.materialTitle = materialTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowMaterialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowMaterialBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_material, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowMaterialBinding bind(View rootView) {
        int i = R.id.detail_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.expand_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.material_date;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.material_download_btn;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.material_link;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.material_module;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.material_name;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView5 != null) {
                                    i = R.id.material_sem;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView6 != null) {
                                        i = R.id.material_title;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView7 != null) {
                                            return new RowMaterialBinding((CardView) rootView, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}