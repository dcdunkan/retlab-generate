package in.etuwa.app.data.model.attendance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Attendance.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPercentage() {
        return this.percentage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPercentage_dutyleave() {
        return this.percentage_dutyleave;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTotal_dutyleave() {
        return this.total_dutyleave;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPercentage_subject() {
        return this.percentage_subject;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTotal_subject() {
        return this.total_subject;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCredit_total() {
        return this.credit_total;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCredit_percent() {
        return this.credit_percent;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getClass_attended() {
        return this.class_attended;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
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