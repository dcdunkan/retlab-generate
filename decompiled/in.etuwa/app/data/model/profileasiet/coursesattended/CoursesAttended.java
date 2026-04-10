package in.etuwa.app.data.model.profileasiet.coursesattended;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoursesAttended.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CoursesAttended {
    private final String achievements;
    private final String duration;
    private final String file;
    private final String from_date;
    private final String id;
    private final String name;
    private final String organized_by;
    private final String to_date;
    private final String year;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOrganized_by() {
        return this.organized_by;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAchievements() {
        return this.achievements;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFrom_date() {
        return this.from_date;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTo_date() {
        return this.to_date;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final CoursesAttended copy(String id, String name, String organized_by, String duration, String year, String achievements, String from_date, String to_date, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(organized_by, "organized_by");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(to_date, "to_date");
        Intrinsics.checkNotNullParameter(file, "file");
        return new CoursesAttended(id, name, organized_by, duration, year, achievements, from_date, to_date, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoursesAttended)) {
            return false;
        }
        CoursesAttended coursesAttended = (CoursesAttended) other;
        return Intrinsics.areEqual(this.id, coursesAttended.id) && Intrinsics.areEqual(this.name, coursesAttended.name) && Intrinsics.areEqual(this.organized_by, coursesAttended.organized_by) && Intrinsics.areEqual(this.duration, coursesAttended.duration) && Intrinsics.areEqual(this.year, coursesAttended.year) && Intrinsics.areEqual(this.achievements, coursesAttended.achievements) && Intrinsics.areEqual(this.from_date, coursesAttended.from_date) && Intrinsics.areEqual(this.to_date, coursesAttended.to_date) && Intrinsics.areEqual(this.file, coursesAttended.file);
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.organized_by.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.year.hashCode()) * 31) + this.achievements.hashCode()) * 31) + this.from_date.hashCode()) * 31) + this.to_date.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "CoursesAttended(id=" + this.id + ", name=" + this.name + ", organized_by=" + this.organized_by + ", duration=" + this.duration + ", year=" + this.year + ", achievements=" + this.achievements + ", from_date=" + this.from_date + ", to_date=" + this.to_date + ", file=" + this.file + ")";
    }

    public CoursesAttended(String id, String name, String organized_by, String duration, String year, String achievements, String from_date, String to_date, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(organized_by, "organized_by");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(to_date, "to_date");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.name = name;
        this.organized_by = organized_by;
        this.duration = duration;
        this.year = year;
        this.achievements = achievements;
        this.from_date = from_date;
        this.to_date = to_date;
        this.file = file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOrganized_by() {
        return this.organized_by;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getAchievements() {
        return this.achievements;
    }

    public final String getFrom_date() {
        return this.from_date;
    }

    public final String getTo_date() {
        return this.to_date;
    }

    public final String getFile() {
        return this.file;
    }
}