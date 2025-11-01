package in.etuwa.app.data.model.library;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BookRecord.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jm\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006)"}, d2 = {"Lin/etuwa/app/data/model/library/BookRecord;", "", "slno", "", "title", "issue_date", "due_date", "renewal_date", "returned_date", "remarks", "is_paid", NotificationCompat.CATEGORY_STATUS, "fine", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDue_date", "()Ljava/lang/String;", "getFine", "getIssue_date", "getRemarks", "getRenewal_date", "getReturned_date", "getSlno", "getStatus", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BookRecord {
    private final String due_date;
    private final String fine;
    private final String is_paid;
    private final String issue_date;
    private final String remarks;
    private final String renewal_date;
    private final String returned_date;
    private final String slno;
    private final String status;
    private final String title;

    /* renamed from: component1, reason: from getter */
    public final String getSlno() {
        return this.slno;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIssue_date() {
        return this.issue_date;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDue_date() {
        return this.due_date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRenewal_date() {
        return this.renewal_date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReturned_date() {
        return this.returned_date;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    /* renamed from: component8, reason: from getter */
    public final String getIs_paid() {
        return this.is_paid;
    }

    /* renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final BookRecord copy(String slno, String title, String issue_date, String due_date, String renewal_date, String returned_date, String remarks, String is_paid, String status, String fine) {
        Intrinsics.checkNotNullParameter(slno, "slno");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(issue_date, "issue_date");
        Intrinsics.checkNotNullParameter(due_date, "due_date");
        Intrinsics.checkNotNullParameter(renewal_date, "renewal_date");
        Intrinsics.checkNotNullParameter(returned_date, "returned_date");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(is_paid, "is_paid");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(fine, "fine");
        return new BookRecord(slno, title, issue_date, due_date, renewal_date, returned_date, remarks, is_paid, status, fine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookRecord)) {
            return false;
        }
        BookRecord bookRecord = (BookRecord) other;
        return Intrinsics.areEqual(this.slno, bookRecord.slno) && Intrinsics.areEqual(this.title, bookRecord.title) && Intrinsics.areEqual(this.issue_date, bookRecord.issue_date) && Intrinsics.areEqual(this.due_date, bookRecord.due_date) && Intrinsics.areEqual(this.renewal_date, bookRecord.renewal_date) && Intrinsics.areEqual(this.returned_date, bookRecord.returned_date) && Intrinsics.areEqual(this.remarks, bookRecord.remarks) && Intrinsics.areEqual(this.is_paid, bookRecord.is_paid) && Intrinsics.areEqual(this.status, bookRecord.status) && Intrinsics.areEqual(this.fine, bookRecord.fine);
    }

    public int hashCode() {
        return (((((((((((((((((this.slno.hashCode() * 31) + this.title.hashCode()) * 31) + this.issue_date.hashCode()) * 31) + this.due_date.hashCode()) * 31) + this.renewal_date.hashCode()) * 31) + this.returned_date.hashCode()) * 31) + this.remarks.hashCode()) * 31) + this.is_paid.hashCode()) * 31) + this.status.hashCode()) * 31) + this.fine.hashCode();
    }

    public String toString() {
        return "BookRecord(slno=" + this.slno + ", title=" + this.title + ", issue_date=" + this.issue_date + ", due_date=" + this.due_date + ", renewal_date=" + this.renewal_date + ", returned_date=" + this.returned_date + ", remarks=" + this.remarks + ", is_paid=" + this.is_paid + ", status=" + this.status + ", fine=" + this.fine + ")";
    }

    public BookRecord(String slno, String title, String issue_date, String due_date, String renewal_date, String returned_date, String remarks, String is_paid, String status, String fine) {
        Intrinsics.checkNotNullParameter(slno, "slno");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(issue_date, "issue_date");
        Intrinsics.checkNotNullParameter(due_date, "due_date");
        Intrinsics.checkNotNullParameter(renewal_date, "renewal_date");
        Intrinsics.checkNotNullParameter(returned_date, "returned_date");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(is_paid, "is_paid");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(fine, "fine");
        this.slno = slno;
        this.title = title;
        this.issue_date = issue_date;
        this.due_date = due_date;
        this.renewal_date = renewal_date;
        this.returned_date = returned_date;
        this.remarks = remarks;
        this.is_paid = is_paid;
        this.status = status;
        this.fine = fine;
    }

    public final String getSlno() {
        return this.slno;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIssue_date() {
        return this.issue_date;
    }

    public final String getDue_date() {
        return this.due_date;
    }

    public final String getRenewal_date() {
        return this.renewal_date;
    }

    public final String getReturned_date() {
        return this.returned_date;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final String is_paid() {
        return this.is_paid;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getFine() {
        return this.fine;
    }
}