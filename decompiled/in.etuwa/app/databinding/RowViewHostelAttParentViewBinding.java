package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowViewHostelAttParentViewBinding implements ViewBinding {
    public final LinearLayout appRejLyt;
    public final TextView approveBtn;
    public final TextView dateLeave;
    public final TextView leaveTypeHostel;
    public final LinearLayout linearArtsFee;
    public final LinearLayout messMenu1;
    public final TextView reasonLeave;
    public final TextView rejectBtn;
    public final TextView revokeBtn;
    public final LinearLayout revokeLyt;
    private final LinearLayout rootView;
    public final TextView statusLeave;

    private RowViewHostelAttParentViewBinding(LinearLayout rootView, LinearLayout appRejLyt, TextView approveBtn, TextView dateLeave, TextView leaveTypeHostel, LinearLayout linearArtsFee, LinearLayout messMenu1, TextView reasonLeave, TextView rejectBtn, TextView revokeBtn, LinearLayout revokeLyt, TextView statusLeave) {
        this.rootView = rootView;
        this.appRejLyt = appRejLyt;
        this.approveBtn = approveBtn;
        this.dateLeave = dateLeave;
        this.leaveTypeHostel = leaveTypeHostel;
        this.linearArtsFee = linearArtsFee;
        this.messMenu1 = messMenu1;
        this.reasonLeave = reasonLeave;
        this.rejectBtn = rejectBtn;
        this.revokeBtn = revokeBtn;
        this.revokeLyt = revokeLyt;
        this.statusLeave = statusLeave;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowViewHostelAttParentViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowViewHostelAttParentViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_view_hostel_att_parent_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowViewHostelAttParentViewBinding bind(View rootView) {
        int i = R.id.app_rej_lyt;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.approve_btn;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.date_leave;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.leave_type_hostel;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.linearArtsFee;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.mess_menu_1;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout3 != null) {
                                i = R.id.reason_leave;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.reject_btn;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.revoke_btn;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            i = R.id.revoke_lyt;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.status_leave;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView7 != null) {
                                                    return new RowViewHostelAttParentViewBinding((LinearLayout) rootView, linearLayout, textView, textView2, textView3, linearLayout2, linearLayout3, textView4, textView5, textView6, linearLayout4, textView7);
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