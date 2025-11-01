package in.etuwa.app.data.model.profileasiet.qualifiedexamination;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QualifiedExamination.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/qualifiedexamination/QualifiedExamination;", "", "id", "", "name", FirebaseAnalytics.Param.SCORE, "year", "file", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getId", "getName", "getScore", "getYear", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class QualifiedExamination {
    private final String file;
    private final String id;
    private final String name;
    private final String score;
    private final String year;

    public static /* synthetic */ QualifiedExamination copy$default(QualifiedExamination qualifiedExamination, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = qualifiedExamination.id;
        }
        if ((i & 2) != 0) {
            str2 = qualifiedExamination.name;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = qualifiedExamination.score;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = qualifiedExamination.year;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = qualifiedExamination.file;
        }
        return qualifiedExamination.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* renamed from: component4, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final QualifiedExamination copy(String id, String name, String score, String year, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(file, "file");
        return new QualifiedExamination(id, name, score, year, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QualifiedExamination)) {
            return false;
        }
        QualifiedExamination qualifiedExamination = (QualifiedExamination) other;
        return Intrinsics.areEqual(this.id, qualifiedExamination.id) && Intrinsics.areEqual(this.name, qualifiedExamination.name) && Intrinsics.areEqual(this.score, qualifiedExamination.score) && Intrinsics.areEqual(this.year, qualifiedExamination.year) && Intrinsics.areEqual(this.file, qualifiedExamination.file);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.score.hashCode()) * 31) + this.year.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "QualifiedExamination(id=" + this.id + ", name=" + this.name + ", score=" + this.score + ", year=" + this.year + ", file=" + this.file + ")";
    }

    public QualifiedExamination(String id, String name, String score, String year, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.name = name;
        this.score = score;
        this.year = year;
        this.file = file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScore() {
        return this.score;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getFile() {
        return this.file;
    }
}