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
public final class RowDirectApplyBinding implements ViewBinding {
    public final TextView deleteBtn;
    public final TextView editBtn;
    public final TextView fromDateTv;
    public final TextView grDate;
    public final TextView headTv;
    public final TextView reasonTv;
    private final CardView rootView;
    public final TextView statusTv;
    public final TextView toDateTv;
    public final TextView updateHoursBtn;
    public final TextView viewProofBtn;

    private RowDirectApplyBinding(CardView rootView, TextView deleteBtn, TextView editBtn, TextView fromDateTv, TextView grDate, TextView headTv, TextView reasonTv, TextView statusTv, TextView toDateTv, TextView updateHoursBtn, TextView viewProofBtn) {
        this.rootView = rootView;
        this.deleteBtn = deleteBtn;
        this.editBtn = editBtn;
        this.fromDateTv = fromDateTv;
        this.grDate = grDate;
        this.headTv = headTv;
        this.reasonTv = reasonTv;
        this.statusTv = statusTv;
        this.toDateTv = toDateTv;
        this.updateHoursBtn = updateHoursBtn;
        this.viewProofBtn = viewProofBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowDirectApplyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDirectApplyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_direct_apply, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDirectApplyBinding bind(View rootView) {
        int i = R.id.delete_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.edit_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.from_date_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.gr_date;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.head_tv;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.reason_tv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.status_tv;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.to_date_tv;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        i = R.id.update_hours_btn;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView9 != null) {
                                            i = R.id.view_proof_btn;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView10 != null) {
                                                return new RowDirectApplyBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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