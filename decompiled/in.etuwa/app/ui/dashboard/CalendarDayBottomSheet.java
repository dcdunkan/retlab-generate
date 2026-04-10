package in.etuwa.app.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import in.etuwa.app.R;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CalendarDayBottomSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CalendarDayBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_DATE = "arg_date";
    private static final String ARG_EVENT_TITLES = "arg_event_titles";
    private static final String ARG_EVENT_TYPES = "arg_event_types";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private LocalDate date;
    private List<CalendarEvent> events = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: CalendarDayBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CalendarEventType.values().length];
            try {
                iArr[CalendarEventType.ASSIGNMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CalendarEventType.HOLIDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CalendarEventType.EXAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CalendarEventType.BIRTHDAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: compiled from: CalendarDayBottomSheet.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lin/etuwa/app/ui/dashboard/CalendarDayBottomSheet$Companion;", "", "()V", "ARG_DATE", "", "ARG_EVENT_TITLES", "ARG_EVENT_TYPES", "newInstance", "Lin/etuwa/app/ui/dashboard/CalendarDayBottomSheet;", "date", "Ljava/time/LocalDate;", "events", "", "Lin/etuwa/app/ui/dashboard/CalendarEvent;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CalendarDayBottomSheet newInstance(LocalDate date, List<CalendarEvent> events) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(events, "events");
            CalendarDayBottomSheet calendarDayBottomSheet = new CalendarDayBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(CalendarDayBottomSheet.ARG_DATE, date.toString());
            List<CalendarEvent> list = events;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CalendarEvent) it.next()).getTitle());
            }
            bundle.putStringArray(CalendarDayBottomSheet.ARG_EVENT_TITLES, (String[]) arrayList.toArray(new String[0]));
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((CalendarEvent) it2.next()).getType().name());
            }
            bundle.putStringArray(CalendarDayBottomSheet.ARG_EVENT_TYPES, (String[]) arrayList2.toArray(new String[0]));
            calendarDayBottomSheet.setArguments(bundle);
            return calendarDayBottomSheet;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ARG_DATE);
            this.date = string != null ? LocalDate.parse(string) : null;
            String[] stringArray = arguments.getStringArray(ARG_EVENT_TITLES);
            if (stringArray == null) {
                stringArray = new String[0];
            }
            String[] stringArray2 = arguments.getStringArray(ARG_EVENT_TYPES);
            if (stringArray2 == null) {
                stringArray2 = new String[0];
            }
            List<Pair> listZip = ArraysKt.zip(stringArray, stringArray2);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZip, 10));
            for (Pair pair : listZip) {
                String title = (String) pair.component1();
                String typeName = (String) pair.component2();
                LocalDate localDateNow = this.date;
                if (localDateNow == null) {
                    localDateNow = LocalDate.now();
                }
                Intrinsics.checkNotNullExpressionValue(localDateNow, "date ?: LocalDate.now()");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(typeName, "typeName");
                arrayList.add(new CalendarEvent(localDateNow, title, CalendarEventType.valueOf(typeName)));
            }
            this.events = arrayList;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.bottomsheet_calendar_day, container, false);
        TextView textView = (TextView) view.findViewById(R.id.dateTitle);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.eventContainer);
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate localDate = this.date;
        if (localDate == null || (str = localDate.format(dateTimeFormatterOfPattern)) == null) {
            str = "";
        }
        textView.setText(str);
        for (CalendarEvent calendarEvent : this.events) {
            View viewInflate = getLayoutInflater().inflate(R.layout.item_calendar_event, viewGroup, false);
            ((ImageView) viewInflate.findViewById(R.id.eventIcon)).setImageResource(getIcon(calendarEvent.getType()));
            ((TextView) viewInflate.findViewById(R.id.eventTitle)).setText(calendarEvent.getTitle());
            viewGroup.addView(viewInflate);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    private final int getIcon(CalendarEventType type) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return R.drawable.assignment;
        }
        if (i == 2) {
            return R.drawable.holiday;
        }
        if (i == 3) {
            return R.drawable.exam_events;
        }
        if (i == 4) {
            return R.drawable.birthday;
        }
        throw new NoWhenBranchMatchedException();
    }
}