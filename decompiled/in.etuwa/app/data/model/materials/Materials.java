package in.etuwa.app.data.model.materials;

import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Materials.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006%"}, d2 = {"Lin/etuwa/app/data/model/materials/Materials;", "", "subject", "", AttendanceDayDialogKt.ARG_SEM, "title", "url", "link", "date", "module", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getLink", "setLink", "getModule", "setModule", "getSemester", "getSubject", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component7, reason: from getter */
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