package in.etuwa.app.data.model.profileasiet.mooccourse;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoocCourse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MoocCourse {
    private final String achievements;
    private final String duration;
    private final String file;
    private final String from_date;
    private final String id;
    private final String name;
    private final String platform;
    private final String to_date;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFrom_date() {
        return this.from_date;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTo_date() {
        return this.to_date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAchievements() {
        return this.achievements;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final MoocCourse copy(String id, String name, String platform, String from_date, String to_date, String duration, String achievements, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(to_date, "to_date");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(file, "file");
        return new MoocCourse(id, name, platform, from_date, to_date, duration, achievements, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoocCourse)) {
            return false;
        }
        MoocCourse moocCourse = (MoocCourse) other;
        return Intrinsics.areEqual(this.id, moocCourse.id) && Intrinsics.areEqual(this.name, moocCourse.name) && Intrinsics.areEqual(this.platform, moocCourse.platform) && Intrinsics.areEqual(this.from_date, moocCourse.from_date) && Intrinsics.areEqual(this.to_date, moocCourse.to_date) && Intrinsics.areEqual(this.duration, moocCourse.duration) && Intrinsics.areEqual(this.achievements, moocCourse.achievements) && Intrinsics.areEqual(this.file, moocCourse.file);
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.from_date.hashCode()) * 31) + this.to_date.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.achievements.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "MoocCourse(id=" + this.id + ", name=" + this.name + ", platform=" + this.platform + ", from_date=" + this.from_date + ", to_date=" + this.to_date + ", duration=" + this.duration + ", achievements=" + this.achievements + ", file=" + this.file + ")";
    }

    public MoocCourse(String id, String name, String platform, String from_date, String to_date, String duration, String achievements, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(to_date, "to_date");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.from_date = from_date;
        this.to_date = to_date;
        this.duration = duration;
        this.achievements = achievements;
        this.file = file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getFrom_date() {
        return this.from_date;
    }

    public final String getTo_date() {
        return this.to_date;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getAchievements() {
        return this.achievements;
    }

    public final String getFile() {
        return this.file;
    }
}