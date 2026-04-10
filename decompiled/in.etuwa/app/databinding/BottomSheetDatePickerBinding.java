package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class BottomSheetDatePickerBinding implements ViewBinding {
    public final TextView pickerMonthNext;
    public final TextView pickerMonthPrev;
    public final TextView pickerMonthTitle;
    public final RecyclerView pickerRvCalendar;
    public final TextView pickerTodayBtn;
    private final LinearLayout rootView;

    private BottomSheetDatePickerBinding(LinearLayout rootView, TextView pickerMonthNext, TextView pickerMonthPrev, TextView pickerMonthTitle, RecyclerView pickerRvCalendar, TextView pickerTodayBtn) {
        this.rootView = rootView;
        this.pickerMonthNext = pickerMonthNext;
        this.pickerMonthPrev = pickerMonthPrev;
        this.pickerMonthTitle = pickerMonthTitle;
        this.pickerRvCalendar = pickerRvCalendar;
        this.pickerTodayBtn = pickerTodayBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetDatePickerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetDatePickerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_date_picker, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetDatePickerBinding bind(View rootView) {
        int i = R.id.picker_month_next;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.picker_month_prev;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.picker_month_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.picker_rv_calendar;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                    if (recyclerView != null) {
                        i = R.id.picker_today_btn;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new BottomSheetDatePickerBinding((LinearLayout) rootView, textView, textView2, textView3, recyclerView, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}