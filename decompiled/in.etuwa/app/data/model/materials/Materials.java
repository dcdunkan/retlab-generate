package in.etuwa.app.data.model.materials;

import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Materials.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Materials {
    private String date;
    private String link;
    private String module;
    private final String semester;
    private final String subject;
    private final String title;
    private final String url;

    public static /* synthetic */ Materials copy$default(Materials materials, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = materials.subject;
        }
        if ((i & 2) != 0) {
            str2 = materials.semester;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = materials.title;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = materials.url;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = materials.link;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = materials.date;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = materials.module;
        }
        return materials.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    public final Materials copy(String subject, String semester, String title, String url, String link, String date, String module) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(module, "module");
        return new Materials(subject, semester, title, url, link, date, module);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Materials)) {
            return false;
        }
        Materials materials = (Materials) other;
        return Intrinsics.areEqual(this.subject, materials.subject) && Intrinsics.areEqual(this.semester, materials.semester) && Intrinsics.areEqual(this.title, materials.title) && Intrinsics.areEqual(this.url, materials.url) && Intrinsics.areEqual(this.link, materials.link) && Intrinsics.areEqual(this.date, materials.date) && Intrinsics.areEqual(this.module, materials.module);
    }

    public int hashCode() {
        return (((((((((((this.subject.hashCode() * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.url.hashCode()) * 31) + this.link.hashCode()) * 31) + this.date.hashCode()) * 31) + this.module.hashCode();
    }

    public String toString() {
        return "Materials(subject=" + this.subject + ", semester=" + this.semester + ", title=" + this.title + ", url=" + this.url + ", link=" + this.link + ", date=" + this.date + ", module=" + this.module + ")";
    }

    public Materials(String subject, String semester, String title, String url, String link, String date, String module) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(module, "module");
        this.subject = subject;
        this.semester = semester;
        this.title = title;
        this.url = url;
        this.link = link;
        this.date = date;
        this.module = module;
    }

    public /* synthetic */ Materials(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? "" : str5, str6, str7);
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getModule() {
        return this.module;
    }

    public final void setModule(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.module = str;
    }
}