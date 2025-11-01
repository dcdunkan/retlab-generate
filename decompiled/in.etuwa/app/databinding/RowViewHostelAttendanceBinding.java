package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowViewHostelAttendanceBinding implements ViewBinding {
    public final TextView dateLeave;
    public final ImageView deleteBtn;
    public final ImageView downloadBtn;
    public final TextView exitBtn;
    public final TextView leaveTypeHostel;
    public final LinearLayout linearArtsFee;
    public final LinearLayout messMenu1;
    public final TextView reasonLeave;
    private final LinearLayout rootView;
    public final TextView statusLeave;

    private RowViewHostelAttendanceBinding(LinearLayout rootView, TextView dateLeave, ImageView deleteBtn, ImageView downloadBtn, TextView exitBtn, TextView leaveTypeHostel, LinearLayout linearArtsFee, LinearLayout messMenu1, TextView reasonLeave, TextView statusLeave) {
        this.rootView = rootView;
        this.dateLeave = dateLeave;
        this.deleteBtn = deleteBtn;
        this.downloadBtn = downloadBtn;
        this.exitBtn = exitBtn;
        this.leaveTypeHostel = leaveTypeHostel;
        this.linearArtsFee = linearArtsFee;
        this.messMenu1 = messMenu1;
        this.reasonLeave = reasonLeave;
        this.statusLeave = statusLeave;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowViewHostelAttendanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowViewHostelAttendanceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_view_hostel_attendance, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowViewHostelAttendanceBinding bind(View rootView) {
        int i = R.id.date_leave;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.delete_btn;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.download_btn;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.exit_btn;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.leave_type_hostel;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.linearArtsFee;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                i = R.id.mess_menu_1;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null) {
                                    i = R.id.reason_leave;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.status_leave;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView5 != null) {
                                            return new RowViewHostelAttendanceBinding((LinearLayout) rootView, textView, imageView, imageView2, textView2, textView3, linearLayout, linearLayout2, textView4, textView5);
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