package in.etuwa.app.data.model.profileasiet.projectwork;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: ProjectWork.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/projectwork/ProjectWork;", "", "id", "", "type", "year", ErrorBundle.DETAIL_ENTRY, "file", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDetails", "()Ljava/lang/String;", "getFile", "getId", "getType", "getYear", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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