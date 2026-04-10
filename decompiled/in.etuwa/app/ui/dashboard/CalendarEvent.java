package in.etuwa.app.ui.dashboard;

import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CalendarDayBottomSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public final /* data */ class CalendarEvent {
    private final LocalDate date;
    private final String title;
    private final CalendarEventType type;

    public static /* synthetic */ CalendarEvent copy$default(CalendarEvent calendarEvent, LocalDate localDate, String str, CalendarEventType calendarEventType, int i, Object obj) {
        if ((i & 1) != 0) {
            localDate = calendarEvent.date;
        }
        if ((i & 2) != 0) {
            str = calendarEvent.title;
        }
        if ((i & 4) != 0) {
            calendarEventType = calendarEvent.type;
        }
        return calendarEvent.copy(localDate, str, calendarEventType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CalendarEventType getType() {
        return this.type;
    }

    public final CalendarEvent copy(LocalDate date, String title, CalendarEventType type) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        return new CalendarEvent(date, title, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarEvent)) {
            return false;
        }
        CalendarEvent calendarEvent = (CalendarEvent) other;
        return Intrinsics.areEqual(this.date, calendarEvent.date) && Intrinsics.areEqual(this.title, calendarEvent.title) && this.type == calendarEvent.type;
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + this.title.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "CalendarEvent(date=" + this.date + ", title=" + this.title + ", type=" + this.type + ")";
    }

    public CalendarEvent(LocalDate date, String title, CalendarEventType type) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        this.date = date;
        this.title = title;
        this.type = type;
    }

    public final LocalDate getDate() {
        return this.date;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CalendarEventType getType() {
        return this.type;
    }
}