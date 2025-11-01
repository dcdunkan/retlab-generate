package in.etuwa.app.data.model.profileasiet.mooccourse;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MoocCourse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/mooccourse/MoocCourse;", "", "id", "", "name", "platform", "from_date", "to_date", TypedValues.TransitionType.S_DURATION, "achievements", "file", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAchievements", "()Ljava/lang/String;", "getDuration", "getFile", "getFrom_date", "getId", "getName", "getPlatform", "getTo_date", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MoocCourse {
    private final String achievements;
    private final String duration;
    private final String file;
    private final String from_date;
    private final String id;
    private final String name;
    private final String platform;
    private final String to_date;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFrom_date() {
        return this.from_date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTo_date() {
        return this.to_date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAchievements() {
        return this.achievements;
    }

    /* renamed from: component8, reason: from getter */
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