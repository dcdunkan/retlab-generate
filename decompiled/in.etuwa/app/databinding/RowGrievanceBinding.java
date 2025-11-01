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
public final class RowGrievanceBinding implements ViewBinding {
    public final TextView grDate;
    public final TextView grDelete;
    public final TextView grEdit;
    public final TextView grReminderBtn;
    public final TextView grReminderTxt;
    public final TextView grStatus;
    public final TextView grSubject;
    public final TextView grType;
    public final TextView grView;
    private final CardView rootView;

    private RowGrievanceBinding(CardView rootView, TextView grDate, TextView grDelete, TextView grEdit, TextView grReminderBtn, TextView grReminderTxt, TextView grStatus, TextView grSubject, TextView grType, TextView grView) {
        this.rootView = rootView;
        this.grDate = grDate;
        this.grDelete = grDelete;
        this.grEdit = grEdit;
        this.grReminderBtn = grReminderBtn;
        this.grReminderTxt = grReminderTxt;
        this.grStatus = grStatus;
        this.grSubject = grSubject;
        this.grType = grType;
        this.grView = grView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowGrievanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowGrievanceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_grievance, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowGrievanceBinding bind(View rootView) {
        int i = R.id.gr_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.gr_delete;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.gr_edit;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.gr_reminder_btn;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.gr_reminder_txt;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.gr_status;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.gr_subject;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.gr_type;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        i = R.id.gr_view;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView9 != null) {
                                            return new RowGrievanceBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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