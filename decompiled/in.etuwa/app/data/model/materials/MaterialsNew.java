package in.etuwa.app.data.model.materials;

import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaterialsNew.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Ji\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lin/etuwa/app/data/model/materials/MaterialsNew;", "", "subject", "", AttendanceDayDialogKt.ARG_SEM, "title", "url", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "download", "link", "date", "module", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getDownload", "getLink", "setLink", "getModule", "setModule", "getSemester", "getSubject", "getTitle", "getUrl", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MaterialsNew {
    private String date;
    private final String download;
    private String link;
    private String module;
    private final String semester;
    private final String subject;
    private final String title;
    private final ArrayList<String> url;

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

    public final ArrayList<String> component4() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDownload() {
        return this.download;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component8, reason: from getter */
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