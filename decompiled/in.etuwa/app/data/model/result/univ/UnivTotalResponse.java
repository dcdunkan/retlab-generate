package in.etuwa.app.data.model.result.univ;

import in.etuwa.app.data.model.DownloadModel$$ExternalSyntheticBackport0;
import kotlin.Metadata;

/* JADX INFO: compiled from: UnivResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class UnivTotalResponse {
    private final double cgpa;
    private final int earned_credit;
    private final int total_backlogs;
    private final int total_credit;
    private final int total_exams;
    private final int total_passed;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getCgpa() {
        return this.cgpa;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEarned_credit() {
        return this.earned_credit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTotal_credit() {
        return this.total_credit;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTotal_backlogs() {
        return this.total_backlogs;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTotal_exams() {
        return this.total_exams;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTotal_passed() {
        return this.total_passed;
    }

    public final UnivTotalResponse copy(double cgpa, int earned_credit, int total_credit, int total_backlogs, int total_exams, int total_passed) {
        return new UnivTotalResponse(cgpa, earned_credit, total_credit, total_backlogs, total_exams, total_passed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnivTotalResponse)) {
            return false;
        }
        UnivTotalResponse univTotalResponse = (UnivTotalResponse) other;
        return Double.compare(this.cgpa, univTotalResponse.cgpa) == 0 && this.earned_credit == univTotalResponse.earned_credit && this.total_credit == univTotalResponse.total_credit && this.total_backlogs == univTotalResponse.total_backlogs && this.total_exams == univTotalResponse.total_exams && this.total_passed == univTotalResponse.total_passed;
    }

    public int hashCode() {
        return (((((((((DownloadModel$$ExternalSyntheticBackport0.m(this.cgpa) * 31) + this.earned_credit) * 31) + this.total_credit) * 31) + this.total_backlogs) * 31) + this.total_exams) * 31) + this.total_passed;
    }

    public String toString() {
        return "UnivTotalResponse(cgpa=" + this.cgpa + ", earned_credit=" + this.earned_credit + ", total_credit=" + this.total_credit + ", total_backlogs=" + this.total_backlogs + ", total_exams=" + this.total_exams + ", total_passed=" + this.total_passed + ")";
    }

    public UnivTotalResponse(double d, int i, int i2, int i3, int i4, int i5) {
        this.cgpa = d;
        this.earned_credit = i;
        this.total_credit = i2;
        this.total_backlogs = i3;
        this.total_exams = i4;
        this.total_passed = i5;
    }

    public final double getCgpa() {
        return this.cgpa;
    }

    public final int getEarned_credit() {
        return this.earned_credit;
    }

    public final int getTotal_credit() {
        return this.total_credit;
    }

    public final int getTotal_backlogs() {
        return this.total_backlogs;
    }

    public final int getTotal_exams() {
        return this.total_exams;
    }

    public final int getTotal_passed() {
        return this.total_passed;
    }
}