package in.etuwa.app.data.model.profileasiet.sport;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sport.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/sport/Sport;", "", "id", "", "name", NotificationCompat.CATEGORY_EVENT, "organized_by", "type", FirebaseAnalytics.Param.LEVEL, "date", "year", "awards", "file", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAwards", "()Ljava/lang/String;", "getDate", "getEvent", "getFile", "getId", "getLevel", "getName", "getOrganized_by", "getType", "getYear", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Sport {
    private final String awards;
    private final String date;
    private final String event;
    private final String file;
    private final String id;
    private final String level;
    private final String name;
    private final String organized_by;
    private final String type;
    private final String year;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOrganized_by() {
        return this.organized_by;
    }

    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component8, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAwards() {
        return this.awards;
    }

    public final Sport copy(String id, String name, String event, String organized_by, String type, String level, String date, String year, String awards, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(organized_by, "organized_by");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(awards, "awards");
        Intrinsics.checkNotNullParameter(file, "file");
        return new Sport(id, name, event, organized_by, type, level, date, year, awards, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sport)) {
            return false;
        }
        Sport sport = (Sport) other;
        return Intrinsics.areEqual(this.id, sport.id) && Intrinsics.areEqual(this.name, sport.name) && Intrinsics.areEqual(this.event, sport.event) && Intrinsics.areEqual(this.organized_by, sport.organized_by) && Intrinsics.areEqual(this.type, sport.type) && Intrinsics.areEqual(this.level, sport.level) && Intrinsics.areEqual(this.date, sport.date) && Intrinsics.areEqual(this.year, sport.year) && Intrinsics.areEqual(this.awards, sport.awards) && Intrinsics.areEqual(this.file, sport.file);
    }

    public int hashCode() {
        return (((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.event.hashCode()) * 31) + this.organized_by.hashCode()) * 31) + this.type.hashCode()) * 31) + this.level.hashCode()) * 31) + this.date.hashCode()) * 31) + this.year.hashCode()) * 31) + this.awards.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "Sport(id=" + this.id + ", name=" + this.name + ", event=" + this.event + ", organized_by=" + this.organized_by + ", type=" + this.type + ", level=" + this.level + ", date=" + this.date + ", year=" + this.year + ", awards=" + this.awards + ", file=" + this.file + ")";
    }

    public Sport(String id, String name, String event, String organized_by, String type, String level, String date, String year, String awards, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(organized_by, "organized_by");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(awards, "awards");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.name = name;
        this.event = event;
        this.organized_by = organized_by;
        this.type = type;
        this.level = level;
        this.date = date;
        this.year = year;
        this.awards = awards;
        this.file = file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getOrganized_by() {
        return this.organized_by;
    }

    public final String getType() {
        return this.type;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getAwards() {
        return this.awards;
    }

    public final String getFile() {
        return this.file;
    }
}