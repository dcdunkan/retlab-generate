package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class BottomSheetMissionVissionBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView missionBtn;
    public final LinearLayout missionLyt;
    private final LinearLayout rootView;
    public final TextView titleOne;
    public final TextView titleTwo;
    public final TextView visionBtn;
    public final LinearLayout visionLyt;

    private BottomSheetMissionVissionBinding(LinearLayout rootView, TextView btnCancel, TextView missionBtn, LinearLayout missionLyt, TextView titleOne, TextView titleTwo, TextView visionBtn, LinearLayout visionLyt) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.missionBtn = missionBtn;
        this.missionLyt = missionLyt;
        this.titleOne = titleOne;
        this.titleTwo = titleTwo;
        this.visionBtn = visionBtn;
        this.visionLyt = visionLyt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetMissionVissionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetMissionVissionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_mission_vission, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetMissionVissionBinding bind(View rootView) {
        int i = R.id.btnCancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.missionBtn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.mission_lyt;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.titleOne;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.titleTwo;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.visionBtn;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.vision_lyt;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null) {
                                    return new BottomSheetMissionVissionBinding((LinearLayout) rootView, textView, textView2, linearLayout, textView3, textView4, textView5, linearLayout2);
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