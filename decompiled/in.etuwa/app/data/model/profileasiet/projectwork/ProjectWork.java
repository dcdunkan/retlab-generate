package in.etuwa.app.data.model.profileasiet.projectwork;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: ProjectWork.kt */
/* loaded from: classes3.dex */
public final /* data */ class ProjectWork {
    private final String details;
    private final String file;
    private final String id;
    private final String type;
    private final String year;

    public static /* synthetic */ ProjectWork copy$default(ProjectWork projectWork, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = projectWork.id;
        }
        if ((i & 2) != 0) {
            str2 = projectWork.type;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = projectWork.year;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = projectWork.details;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = projectWork.file;
        }
        return projectWork.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final ProjectWork copy(String id, String type, String year, String details, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(file, "file");
        return new ProjectWork(id, type, year, details, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectWork)) {
            return false;
        }
        ProjectWork projectWork = (ProjectWork) other;
        return Intrinsics.areEqual(this.id, projectWork.id) && Intrinsics.areEqual(this.type, projectWork.type) && Intrinsics.areEqual(this.year, projectWork.year) && Intrinsics.areEqual(this.details, projectWork.details) && Intrinsics.areEqual(this.file, projectWork.file);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.year.hashCode()) * 31) + this.details.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "ProjectWork(id=" + this.id + ", type=" + this.type + ", year=" + this.year + ", details=" + this.details + ", file=" + this.file + ")";
    }

    public ProjectWork(String id, String type, String year, String details, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.type = type;
        this.year = year;
        this.details = details;
        this.file = file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getDetails() {
        return this.details;
    }

    public final String getFile() {
        return this.file;
    }
}