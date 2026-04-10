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
public final class ItemDatePickerDayBinding implements ViewBinding {
    public final TextView dayTv;
    private final LinearLayout rootView;
    public final View weekDot;

    private ItemDatePickerDayBinding(LinearLayout rootView, TextView dayTv, View weekDot) {
        this.rootView = rootView;
        this.dayTv = dayTv;
        this.weekDot = weekDot;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemDatePickerDayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemDatePickerDayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_date_picker_day, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemDatePickerDayBinding bind(View rootView) {
        View viewFindChildViewById;
        int i = R.id.day_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.week_dot))) != null) {
            return new ItemDatePickerDayBinding((LinearLayout) rootView, textView, viewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}