package in.etuwa.app.data.model.examschedules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: ExamSchedule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ExamSchedule {
    private String date;
    private String details;
    private String exm_name;
    private String id;
    private String subject;
    private String time;
    private String url;

    public static /* synthetic */ ExamSchedule copy$default(ExamSchedule examSchedule, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = examSchedule.id;
        }
        if ((i & 2) != 0) {
            str2 = examSchedule.exm_name;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = examSchedule.details;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = examSchedule.url;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = examSchedule.subject;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = examSchedule.date;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = examSchedule.time;
        }
        return examSchedule.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExm_name() {
        return this.exm_name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    public final ExamSchedule copy(String id, String exm_name, String details, String url, String subject, String date, String time) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(exm_name, "exm_name");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        return new ExamSchedule(id, exm_name, details, url, subject, date, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamSchedule)) {
            return false;
        }
        ExamSchedule examSchedule = (ExamSchedule) other;
        return Intrinsics.areEqual(this.id, examSchedule.id) && Intrinsics.areEqual(this.exm_name, examSchedule.exm_name) && Intrinsics.areEqual(this.details, examSchedule.details) && Intrinsics.areEqual(this.url, examSchedule.url) && Intrinsics.areEqual(this.subject, examSchedule.subject) && Intrinsics.areEqual(this.date, examSchedule.date) && Intrinsics.areEqual(this.time, examSchedule.time);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.exm_name.hashCode()) * 31) + this.details.hashCode()) * 31) + this.url.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.date.hashCode()) * 31) + this.time.hashCode();
    }

    public String toString() {
        return "ExamSchedule(id=" + this.id + ", exm_name=" + this.exm_name + ", details=" + this.details + ", url=" + this.url + ", subject=" + this.subject + ", date=" + this.date + ", time=" + this.time + ")";
    }

    public ExamSchedule(String id, String exm_name, String details, String url, String subject, String date, String time) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(exm_name, "exm_name");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        this.id = id;
        this.exm_name = exm_name;
        this.details = details;
        this.url = url;
        this.subject = subject;
        this.date = date;
        this.time = time;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getExm_name() {
        return this.exm_name;
    }

    public final void setExm_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.exm_name = str;
    }

    public final String getDetails() {
        return this.details;
    }

    public final void setDetails(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.details = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final void setSubject(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subject = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.time = str;
    }
}