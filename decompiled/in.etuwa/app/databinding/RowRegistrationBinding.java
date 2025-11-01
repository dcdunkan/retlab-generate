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
public final class RowRegistrationBinding implements ViewBinding {
    public final TextView addedAtHr;
    public final LinearLayout comletionLayout;
    public final TextView editBtnHr;
    public final TextView printBtnHr;
    public final TextView registrationTypeHr;
    private final CardView rootView;
    public final TextView semesterNameHr;
    public final TextView slNo;
    public final TextView statusHr;
    public final TextView viewBtnHr;

    private RowRegistrationBinding(CardView rootView, TextView addedAtHr, LinearLayout comletionLayout, TextView editBtnHr, TextView printBtnHr, TextView registrationTypeHr, TextView semesterNameHr, TextView slNo, TextView statusHr, TextView viewBtnHr) {
        this.rootView = rootView;
        this.addedAtHr = addedAtHr;
        this.comletionLayout = comletionLayout;
        this.editBtnHr = editBtnHr;
        this.printBtnHr = printBtnHr;
        this.registrationTypeHr = registrationTypeHr;
        this.semesterNameHr = semesterNameHr;
        this.slNo = slNo;
        this.statusHr = statusHr;
        this.viewBtnHr = viewBtnHr;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowRegistrationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_registration, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowRegistrationBinding bind(View rootView) {
        int i = R.id.added_at_hr;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.comletion_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.edit_btn_hr;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.print_btn_hr;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.registration_type_hr;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.semester_name_hr;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.sl_no;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.status_hr;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView7 != null) {
                                        i = R.id.view_btn_hr;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView8 != null) {
                                            return new RowRegistrationBinding((CardView) rootView, textView, linearLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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