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

/* JADX INFO: loaded from: classes3.dex */
public final class RowTimetableBinding implements ViewBinding {
    public final LinearLayout attendanceClickBtn;
    public final TextView hourTt;
    private final CardView rootView;
    public final CardView ttCard;
    public final LinearLayout ttLyt;
    public final TextView ttSubject;
    public final TextView ttTime;
    public final LinearLayout ttTimeLyt;
    public final TextView ttType;

    private RowTimetableBinding(CardView rootView, LinearLayout attendanceClickBtn, TextView hourTt, CardView ttCard, LinearLayout ttLyt, TextView ttSubject, TextView ttTime, LinearLayout ttTimeLyt, TextView ttType) {
        this.rootView = rootView;
        this.attendanceClickBtn = attendanceClickBtn;
        this.hourTt = hourTt;
        this.ttCard = ttCard;
        this.ttLyt = ttLyt;
        this.ttSubject = ttSubject;
        this.ttTime = ttTime;
        this.ttTimeLyt = ttTimeLyt;
        this.ttType = ttType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTimetableBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTimetableBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_timetable, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowTimetableBinding bind(View rootView) {
        int i = R.id.attendance_click_btn;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.hour_tt;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                CardView cardView = (CardView) rootView;
                i = R.id.tt_lyt;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.tt_subject;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.tt_time;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.tt_time_lyt;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout3 != null) {
                                i = R.id.tt_type;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    return new RowTimetableBinding(cardView, linearLayout, textView, cardView, linearLayout2, textView2, textView3, linearLayout3, textView4);
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