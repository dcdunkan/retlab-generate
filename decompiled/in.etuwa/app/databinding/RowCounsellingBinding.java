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
public final class RowCounsellingBinding implements ViewBinding {
    public final TextView csDate;
    public final TextView csDelete;
    public final TextView csEdit;
    public final TextView csNumber;
    public final TextView csReminderBtn;
    public final TextView csReminderTxt;
    public final TextView csReviewBtn;
    public final TextView csStatus;
    public final TextView csType;
    public final TextView csView;
    private final CardView rootView;

    private RowCounsellingBinding(CardView rootView, TextView csDate, TextView csDelete, TextView csEdit, TextView csNumber, TextView csReminderBtn, TextView csReminderTxt, TextView csReviewBtn, TextView csStatus, TextView csType, TextView csView) {
        this.rootView = rootView;
        this.csDate = csDate;
        this.csDelete = csDelete;
        this.csEdit = csEdit;
        this.csNumber = csNumber;
        this.csReminderBtn = csReminderBtn;
        this.csReminderTxt = csReminderTxt;
        this.csReviewBtn = csReviewBtn;
        this.csStatus = csStatus;
        this.csType = csType;
        this.csView = csView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowCounsellingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCounsellingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_counselling, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowCounsellingBinding bind(View rootView) {
        int i = R.id.cs_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.cs_delete;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.cs_edit;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.cs_number;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.cs_reminder_btn;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.cs_reminder_txt;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.cs_review_btn;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.cs_status;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        i = R.id.cs_type;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView9 != null) {
                                            i = R.id.cs_view;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView10 != null) {
                                                return new RowCounsellingBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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