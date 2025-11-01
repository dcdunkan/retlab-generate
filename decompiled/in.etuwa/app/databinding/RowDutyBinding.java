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
public final class RowDutyBinding implements ViewBinding {
    public final CardView cardDuty;
    public final TextView dutyApplyBtn;
    public final TextView dutyBtn;
    public final TextView dutyDescription;
    public final TextView dutyLastDate;
    public final TextView dutyName;
    public final TextView dutyStatus;
    public final TextView dutyType;
    private final CardView rootView;

    private RowDutyBinding(CardView rootView, CardView cardDuty, TextView dutyApplyBtn, TextView dutyBtn, TextView dutyDescription, TextView dutyLastDate, TextView dutyName, TextView dutyStatus, TextView dutyType) {
        this.rootView = rootView;
        this.cardDuty = cardDuty;
        this.dutyApplyBtn = dutyApplyBtn;
        this.dutyBtn = dutyBtn;
        this.dutyDescription = dutyDescription;
        this.dutyLastDate = dutyLastDate;
        this.dutyName = dutyName;
        this.dutyStatus = dutyStatus;
        this.dutyType = dutyType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowDutyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDutyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_duty, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDutyBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.duty_apply_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.duty_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.duty_description;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.duty_last_date;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.duty_name;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.duty_status;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.duty_type;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    return new RowDutyBinding(cardView, cardView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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