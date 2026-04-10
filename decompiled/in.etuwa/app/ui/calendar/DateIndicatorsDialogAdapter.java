package in.etuwa.app.ui.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.ui.calendar.CalendarFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateIndicatorsDialogAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DateIndicatorsDialogAdapter extends ArrayAdapter<CalendarFragment.CalendarDateIndicator> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateIndicatorsDialogAdapter(Context context, CalendarFragment.CalendarDateIndicator[] events) {
        super(context, 0, events);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(events, "events");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_date_indicator, parent, false);
        }
        try {
            CalendarFragment.CalendarDateIndicator item = getItem(position);
            View viewFindViewById = convertView.findViewById(R.id.color_view);
            Intrinsics.checkNotNull(item);
            viewFindViewById.setBackgroundColor(item.getColor());
            ((TextView) convertView.findViewById(R.id.event_name_view)).setText(item.getEventName());
        } catch (Exception unused) {
        }
        Intrinsics.checkNotNullExpressionValue(convertView, "view");
        return convertView;
    }
}