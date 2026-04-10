package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowCounsellingBinding implements ViewBinding {
    public final TextView csDate;
    public final TextView csDelete;
    public final TextView csEdit;
    public final TextView csNumber;
    public final CardView csReminderBtn;
    public final TextView csReminderTxt;
    public final TextView csReminderTxt2;
    public final CardView csReviewBtn;
    public final TextView csStatus;
    public final TextView csType;
    public final TextView csView;
    private final MaterialCardView rootView;

    private RowCounsellingBinding(MaterialCardView rootView, TextView csDate, TextView csDelete, TextView csEdit, TextView csNumber, CardView csReminderBtn, TextView csReminderTxt, TextView csReminderTxt2, CardView csReviewBtn, TextView csStatus, TextView csType, TextView csView) {
        this.rootView = rootView;
        this.csDate = csDate;
        this.csDelete = csDelete;
        this.csEdit = csEdit;
        this.csNumber = csNumber;
        this.csReminderBtn = csReminderBtn;
        this.csReminderTxt = csReminderTxt;
        this.csReminderTxt2 = csReminderTxt2;
        this.csReviewBtn = csReviewBtn;
        this.csStatus = csStatus;
        this.csType = csType;
        this.csView = csView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowCounsellingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCounsellingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_counselling, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
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
                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                        if (cardView != null) {
                            i = R.id.cs_reminder_txt;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.cs_reminder_txt2;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.cs_review_btn;
                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                    if (cardView2 != null) {
                                        i = R.id.cs_status;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView7 != null) {
                                            i = R.id.cs_type;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView8 != null) {
                                                i = R.id.cs_view;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView9 != null) {
                                                    return new RowCounsellingBinding((MaterialCardView) rootView, textView, textView2, textView3, textView4, cardView, textView5, textView6, cardView2, textView7, textView8, textView9);
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