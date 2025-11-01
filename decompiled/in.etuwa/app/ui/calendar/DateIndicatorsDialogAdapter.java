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

/* compiled from: DateIndicatorsDialogAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/calendar/DateIndicatorsDialogAdapter;", "Landroid/widget/ArrayAdapter;", "Lin/etuwa/app/ui/calendar/CalendarFragment$CalendarDateIndicator;", "context", "Landroid/content/Context;", "events", "", "(Landroid/content/Context;[Lin/etuwa/app/ui/calendar/CalendarFragment$CalendarDateIndicator;)V", "getView", "Landroid/view/View;", CommonCssConstants.POSITION, "", "convertView", "parent", "Landroid/view/ViewGroup;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
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
            View findViewById = convertView.findViewById(R.id.color_view);
            Intrinsics.checkNotNull(item);
            findViewById.setBackgroundColor(item.getColor());
            ((TextView) convertView.findViewById(R.id.event_name_view)).setText(item.getEventName());
        } catch (Exception unused) {
        }
        Intrinsics.checkNotNullExpressionValue(convertView, "view");
        return convertView;
    }
}