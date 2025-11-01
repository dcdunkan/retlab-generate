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
public final class RowMoocCourseBinding implements ViewBinding {
    public final TextView achievementsTv;
    public final LinearLayout comletionLayout;
    public final TextView deleteBtn;
    public final TextView durationTv;
    public final TextView editBtn;
    public final TextView editBtnHr;
    public final TextView fromDate;
    public final TextView organisedBy;
    private final CardView rootView;
    public final TextView slNo;
    public final TextView titleTv;
    public final TextView toDateTv;
    public final TextView viewBtnHr;

    private RowMoocCourseBinding(CardView rootView, TextView achievementsTv, LinearLayout comletionLayout, TextView deleteBtn, TextView durationTv, TextView editBtn, TextView editBtnHr, TextView fromDate, TextView organisedBy, TextView slNo, TextView titleTv, TextView toDateTv, TextView viewBtnHr) {
        this.rootView = rootView;
        this.achievementsTv = achievementsTv;
        this.comletionLayout = comletionLayout;
        this.deleteBtn = deleteBtn;
        this.durationTv = durationTv;
        this.editBtn = editBtn;
        this.editBtnHr = editBtnHr;
        this.fromDate = fromDate;
        this.organisedBy = organisedBy;
        this.slNo = slNo;
        this.titleTv = titleTv;
        this.toDateTv = toDateTv;
        this.viewBtnHr = viewBtnHr;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowMoocCourseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowMoocCourseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_mooc_course, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowMoocCourseBinding bind(View rootView) {
        int i = R.id.achievements_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.comletion_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.delete_btn;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.duration_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.edit_btn;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.edit_btn_hr;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.from_date;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.organised_by;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView7 != null) {
                                        i = R.id.sl_no;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView8 != null) {
                                            i = R.id.title_tv;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView9 != null) {
                                                i = R.id.to_date_tv;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView10 != null) {
                                                    i = R.id.view_btn_hr;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView11 != null) {
                                                        return new RowMoocCourseBinding((CardView) rootView, textView, linearLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
                                                    }
                                                }
                                            }
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