package in.etuwa.app.data.model.attendance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Attendance.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lin/etuwa/app/data/model/attendance/Attendance;", "", "subject", "", "percentage_dutyleave", "total_dutyleave", "percentage_subject", "total_subject", "credit_total", "credit_percent", "class_attended", "total_classes", "percentage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClass_attended", "()Ljava/lang/String;", "getCredit_percent", "getCredit_total", "getPercentage", "getPercentage_dutyleave", "getPercentage_subject", "getSubject", "getTotal_classes", "getTotal_dutyleave", "getTotal_subject", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Attendance {
    private final String class_attended;
    private final String credit_percent;
    private final String credit_total;
    private final String percentage;
    private final String percentage_dutyleave;
    private final String percentage_subject;
    private final String subject;
    private final String total_classes;
    private final String total_dutyleave;
    private final String total_subject;

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPercentage() {
        return this.percentage;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPercentage_dutyleave() {
        return this.percentage_dutyleave;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTotal_dutyleave() {
        return this.total_dutyleave;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPercentage_subject() {
        return this.percentage_subject;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTotal_subject() {
        return this.total_subject;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCredit_total() {
        return this.credit_total;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCredit_percent() {
        return this.credit_percent;
    }

    /* renamed from: component8, reason: from getter */
    public final String getClass_attended() {
        return this.class_attended;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTotal_classes() {
        return this.total_classes;
    }

    public final Attendance copy(String subject, String percentage_dutyleave, String total_dutyleave, String percentage_subject, String total_subject, String credit_total, String credit_percent, String class_attended, String total_classes, String percentage) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(percentage_dutyleave, "percentage_dutyleave");
        Intrinsics.checkNotNullParameter(total_dutyleave, "total_dutyleave");
        Intrinsics.checkNotNullParameter(percentage_subject, "percentage_subject");
        Intrinsics.checkNotNullParameter(total_subject, "total_subject");
        Intrinsics.checkNotNullParameter(credit_total, "credit_total");
        Intrinsics.checkNotNullParameter(credit_percent, "credit_percent");
        Intrinsics.checkNotNullParameter(class_attended, "class_attended");
        Intrinsics.checkNotNullParameter(total_classes, "total_classes");
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        return new Attendance(subject, percentage_dutyleave, total_dutyleave, percentage_subject, total_subject, credit_total, credit_percent, class_attended, total_classes, percentage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Attendance)) {
            return false;
        }
        Attendance attendance = (Attendance) other;
        return Intrinsics.areEqual(this.subject, attendance.subject) && Intrinsics.areEqual(this.percentage_dutyleave, attendance.percentage_dutyleave) && Intrinsics.areEqual(this.total_dutyleave, attendance.total_dutyleave) && Intrinsics.areEqual(this.percentage_subject, attendance.percentage_subject) && Intrinsics.areEqual(this.total_subject, attendance.total_subject) && Intrinsics.areEqual(this.credit_total, attendance.credit_total) && Intrinsics.areEqual(this.credit_percent, attendance.credit_percent) && Intrinsics.areEqual(this.class_attended, attendance.class_attended) && Intrinsics.areEqual(this.total_classes, attendance.total_classes) && Intrinsics.areEqual(this.percentage, attendance.percentage);
    }

    public int hashCode() {
        return (((((((((((((((((this.subject.hashCode() * 31) + this.percentage_dutyleave.hashCode()) * 31) + this.total_dutyleave.hashCode()) * 31) + this.percentage_subject.hashCode()) * 31) + this.total_subject.hashCode()) * 31) + this.credit_total.hashCode()) * 31) + this.credit_percent.hashCode()) * 31) + this.class_attended.hashCode()) * 31) + this.total_classes.hashCode()) * 31) + this.percentage.hashCode();
    }

    public String toString() {
        return "Attendance(subject=" + this.subject + ", percentage_dutyleave=" + this.percentage_dutyleave + ", total_dutyleave=" + this.total_dutyleave + ", percentage_subject=" + this.percentage_subject + ", total_subject=" + this.total_subject + ", credit_total=" + this.credit_total + ", credit_percent=" + this.credit_percent + ", class_attended=" + this.class_attended + ", total_classes=" + this.total_classes + ", percentage=" + this.percentage + ")";
    }

    public Attendance(String subject, String percentage_dutyleave, String total_dutyleave, String percentage_subject, String total_subject, String credit_total, String credit_percent, String class_attended, String total_classes, String percentage) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(percentage_dutyleave, "percentage_dutyleave");
        Intrinsics.checkNotNullParameter(total_dutyleave, "total_dutyleave");
        Intrinsics.checkNotNullParameter(percentage_subject, "percentage_subject");
        Intrinsics.checkNotNullParameter(total_subject, "total_subject");
        Intrinsics.checkNotNullParameter(credit_total, "credit_total");
        Intrinsics.checkNotNullParameter(credit_percent, "credit_percent");
        Intrinsics.checkNotNullParameter(class_attended, "class_attended");
        Intrinsics.checkNotNullParameter(total_classes, "total_classes");
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        this.subject = subject;
        this.percentage_dutyleave = percentage_dutyleave;
        this.total_dutyleave = total_dutyleave;
        this.percentage_subject = percentage_subject;
        this.total_subject = total_subject;
        this.credit_total = credit_total;
        this.credit_percent = credit_percent;
        this.class_attended = class_attended;
        this.total_classes = total_classes;
        this.percentage = percentage;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getPercentage_dutyleave() {
        return this.percentage_dutyleave;
    }

    public final String getTotal_dutyleave() {
        return this.total_dutyleave;
    }

    public final String getPercentage_subject() {
        return this.percentage_subject;
    }

    public final String getTotal_subject() {
        return this.total_subject;
    }

    public final String getCredit_total() {
        return this.credit_total;
    }

    public final String getCredit_percent() {
        return this.credit_percent;
    }

    public final String getClass_attended() {
        return this.class_attended;
    }

    public final String getTotal_classes() {
        return this.total_classes;
    }

    public final String getPercentage() {
        return this.percentage;
    }
}