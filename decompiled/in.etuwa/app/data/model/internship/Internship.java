package in.etuwa.app.data.model.internship;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Internship.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Internship {

    @SerializedName("completion_certificate")
    private final String completion;

    @SerializedName("from_date")
    private final String fromDate;
    private final String id;
    private final String name;
    private final String slno;
    private final String status;

    @SerializedName("to_date")
    private final String toDate;
    private final String url;

    @SerializedName("verified_certificate")
    private final String verifiedCertificate;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSlno() {
        return this.slno;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFromDate() {
        return this.fromDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getToDate() {
        return this.toDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCompletion() {
        return this.completion;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getVerifiedCertificate() {
        return this.verifiedCertificate;
    }

    public final Internship copy(String slno, String name, String fromDate, String toDate, String status, String id, String completion, String url, String verifiedCertificate) {
        Intrinsics.checkNotNullParameter(slno, "slno");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(verifiedCertificate, "verifiedCertificate");
        return new Internship(slno, name, fromDate, toDate, status, id, completion, url, verifiedCertificate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Internship)) {
            return false;
        }
        Internship internship = (Internship) other;
        return Intrinsics.areEqual(this.slno, internship.slno) && Intrinsics.areEqual(this.name, internship.name) && Intrinsics.areEqual(this.fromDate, internship.fromDate) && Intrinsics.areEqual(this.toDate, internship.toDate) && Intrinsics.areEqual(this.status, internship.status) && Intrinsics.areEqual(this.id, internship.id) && Intrinsics.areEqual(this.completion, internship.completion) && Intrinsics.areEqual(this.url, internship.url) && Intrinsics.areEqual(this.verifiedCertificate, internship.verifiedCertificate);
    }

    public int hashCode() {
        return (((((((((((((((this.slno.hashCode() * 31) + this.name.hashCode()) * 31) + this.fromDate.hashCode()) * 31) + this.toDate.hashCode()) * 31) + this.status.hashCode()) * 31) + this.id.hashCode()) * 31) + this.completion.hashCode()) * 31) + this.url.hashCode()) * 31) + this.verifiedCertificate.hashCode();
    }

    public String toString() {
        return "Internship(slno=" + this.slno + ", name=" + this.name + ", fromDate=" + this.fromDate + ", toDate=" + this.toDate + ", status=" + this.status + ", id=" + this.id + ", completion=" + this.completion + ", url=" + this.url + ", verifiedCertificate=" + this.verifiedCertificate + ")";
    }

    public Internship(String slno, String name, String fromDate, String toDate, String status, String id, String completion, String url, String verifiedCertificate) {
        Intrinsics.checkNotNullParameter(slno, "slno");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(verifiedCertificate, "verifiedCertificate");
        this.slno = slno;
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
        this.id = id;
        this.completion = completion;
        this.url = url;
        this.verifiedCertificate = verifiedCertificate;
    }

    public final String getSlno() {
        return this.slno;
    }

    public final String getName() {
        return this.name;
    }

    public final String getFromDate() {
        return this.fromDate;
    }

    public final String getToDate() {
        return this.toDate;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCompletion() {
        return this.completion;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVerifiedCertificate() {
        return this.verifiedCertificate;
    }
}