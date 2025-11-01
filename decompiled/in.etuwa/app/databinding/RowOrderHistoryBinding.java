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
public final class RowOrderHistoryBinding implements ViewBinding {
    public final LinearLayout linearArtsFee;
    public final TextView messBookingDate;
    public final TextView messDeleteBtn;
    public final TextView messMenu;
    public final LinearLayout messMenu1;
    public final LinearLayout messMenu2;
    public final TextView messName2;
    public final TextView messQty;
    public final TextView messStatus;
    public final TextView messType;
    private final CardView rootView;

    private RowOrderHistoryBinding(CardView rootView, LinearLayout linearArtsFee, TextView messBookingDate, TextView messDeleteBtn, TextView messMenu, LinearLayout messMenu1, LinearLayout messMenu2, TextView messName2, TextView messQty, TextView messStatus, TextView messType) {
        this.rootView = rootView;
        this.linearArtsFee = linearArtsFee;
        this.messBookingDate = messBookingDate;
        this.messDeleteBtn = messDeleteBtn;
        this.messMenu = messMenu;
        this.messMenu1 = messMenu1;
        this.messMenu2 = messMenu2;
        this.messName2 = messName2;
        this.messQty = messQty;
        this.messStatus = messStatus;
        this.messType = messType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowOrderHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowOrderHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_order_history, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowOrderHistoryBinding bind(View rootView) {
        int i = R.id.linearArtsFee;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.mess_booking_date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.mess_delete_btn;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.mess_menu;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.mess_menu_1;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.mess_menu2;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout3 != null) {
                                i = R.id.mess_name2;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.mess_qty;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.mess_status;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            i = R.id.mess_type;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView7 != null) {
                                                return new RowOrderHistoryBinding((CardView) rootView, linearLayout, textView, textView2, textView3, linearLayout2, linearLayout3, textView4, textView5, textView6, textView7);
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