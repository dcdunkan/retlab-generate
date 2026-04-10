package in.etuwa.app.data.model.materials;

import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialsNew.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MaterialsNew {
    private String date;
    private final String download;
    private String link;
    private String module;
    private final String semester;
    private final String subject;
    private final String title;
    private final ArrayList<String> url;

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

    public final ArrayList<String> component4() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDownload() {
        return this.download;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    public final MaterialsNew copy(String subject, String semester, String title, ArrayList<String> url, String download, String link, String date, String module) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(download, "download");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(module, "module");
        return new MaterialsNew(subject, semester, title, url, download, link, date, module);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaterialsNew)) {
            return false;
        }
        MaterialsNew materialsNew = (MaterialsNew) other;
        return Intrinsics.areEqual(this.subject, materialsNew.subject) && Intrinsics.areEqual(this.semester, materialsNew.semester) && Intrinsics.areEqual(this.title, materialsNew.title) && Intrinsics.areEqual(this.url, materialsNew.url) && Intrinsics.areEqual(this.download, materialsNew.download) && Intrinsics.areEqual(this.link, materialsNew.link) && Intrinsics.areEqual(this.date, materialsNew.date) && Intrinsics.areEqual(this.module, materialsNew.module);
    }

    public int hashCode() {
        return (((((((((((((this.subject.hashCode() * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.url.hashCode()) * 31) + this.download.hashCode()) * 31) + this.link.hashCode()) * 31) + this.date.hashCode()) * 31) + this.module.hashCode();
    }

    public String toString() {
        return "MaterialsNew(subject=" + this.subject + ", semester=" + this.semester + ", title=" + this.title + ", url=" + this.url + ", download=" + this.download + ", link=" + this.link + ", date=" + this.date + ", module=" + this.module + ")";
    }

    public MaterialsNew(String subject, String semester, String title, ArrayList<String> url, String download, String link, String date, String module) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(download, "download");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(module, "module");
        this.subject = subject;
        this.semester = semester;
        this.title = title;
        this.url = url;
        this.download = download;
        this.link = link;
        this.date = date;
        this.module = module;
    }

    public /* synthetic */ MaterialsNew(String str, String str2, String str3, ArrayList arrayList, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, arrayList, str4, (i & 32) != 0 ? "" : str5, str6, str7);
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

    public final ArrayList<String> getUrl() {
        return this.url;
    }

    public final String getDownload() {
        return this.download;
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