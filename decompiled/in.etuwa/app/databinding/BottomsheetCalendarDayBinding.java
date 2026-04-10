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
public final class BottomsheetCalendarDayBinding implements ViewBinding {
    public final TextView dateTitle;
    public final LinearLayout eventContainer;
    private final LinearLayout rootView;

    private BottomsheetCalendarDayBinding(LinearLayout rootView, TextView dateTitle, LinearLayout eventContainer) {
        this.rootView = rootView;
        this.dateTitle = dateTitle;
        this.eventContainer = eventContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomsheetCalendarDayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomsheetCalendarDayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottomsheet_calendar_day, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomsheetCalendarDayBinding bind(View rootView) {
        int i = R.id.dateTitle;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.eventContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                return new BottomsheetCalendarDayBinding((LinearLayout) rootView, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}