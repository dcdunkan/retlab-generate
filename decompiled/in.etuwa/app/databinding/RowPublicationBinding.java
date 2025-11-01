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
public final class RowPublicationBinding implements ViewBinding {
    public final TextView academicYrTv;
    public final LinearLayout comletionLayout;
    public final TextView conferenceNameTv;
    public final TextView deleteBtn;
    public final TextView editBtn;
    public final TextView editBtnHr;
    public final TextView indexTv;
    public final TextView journalNameTv;
    private final CardView rootView;
    public final TextView slNo;
    public final TextView titleTv;
    public final TextView viewBtnHr;

    private RowPublicationBinding(CardView rootView, TextView academicYrTv, LinearLayout comletionLayout, TextView conferenceNameTv, TextView deleteBtn, TextView editBtn, TextView editBtnHr, TextView indexTv, TextView journalNameTv, TextView slNo, TextView titleTv, TextView viewBtnHr) {
        this.rootView = rootView;
        this.academicYrTv = academicYrTv;
        this.comletionLayout = comletionLayout;
        this.conferenceNameTv = conferenceNameTv;
        this.deleteBtn = deleteBtn;
        this.editBtn = editBtn;
        this.editBtnHr = editBtnHr;
        this.indexTv = indexTv;
        this.journalNameTv = journalNameTv;
        this.slNo = slNo;
        this.titleTv = titleTv;
        this.viewBtnHr = viewBtnHr;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowPublicationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowPublicationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_publication, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowPublicationBinding bind(View rootView) {
        int i = R.id.academic_yr_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.comletion_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.conference_name_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.delete_btn;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.edit_btn;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.edit_btn_hr;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.index_tv;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.journal_name_tv;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView7 != null) {
                                        i = R.id.sl_no;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView8 != null) {
                                            i = R.id.title_tv;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView9 != null) {
                                                i = R.id.view_btn_hr;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView10 != null) {
                                                    return new RowPublicationBinding((CardView) rootView, textView, linearLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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