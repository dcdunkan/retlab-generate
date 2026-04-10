package in.etuwa.app.data.model.profileasiet.qualifiedexamination;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QualifiedExamination.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
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