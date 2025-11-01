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
public final class RowProjectWorkBinding implements ViewBinding {
    public final LinearLayout comletionLayout;
    public final TextView deleteBtn;
    public final TextView detailsTv;
    public final TextView editBtn;
    public final TextView editBtnHr;
    private final CardView rootView;
    public final TextView slNo;
    public final TextView titleTv;
    public final TextView viewBtnHr;
    public final TextView yearTv;

    private RowProjectWorkBinding(CardView rootView, LinearLayout comletionLayout, TextView deleteBtn, TextView detailsTv, TextView editBtn, TextView editBtnHr, TextView slNo, TextView titleTv, TextView viewBtnHr, TextView yearTv) {
        this.rootView = rootView;
        this.comletionLayout = comletionLayout;
        this.deleteBtn = deleteBtn;
        this.detailsTv = detailsTv;
        this.editBtn = editBtn;
        this.editBtnHr = editBtnHr;
        this.slNo = slNo;
        this.titleTv = titleTv;
        this.viewBtnHr = viewBtnHr;
        this.yearTv = yearTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowProjectWorkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowProjectWorkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_project_work, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowProjectWorkBinding bind(View rootView) {
        int i = R.id.comletion_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.delete_btn;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.details_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.edit_btn;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.edit_btn_hr;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.sl_no;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.title_tv;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.view_btn_hr;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView7 != null) {
                                        i = R.id.year_tv;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView8 != null) {
                                            return new RowProjectWorkBinding((CardView) rootView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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