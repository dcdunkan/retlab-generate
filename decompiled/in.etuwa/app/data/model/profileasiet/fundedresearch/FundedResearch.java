package in.etuwa.app.data.model.profileasiet.fundedresearch;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FundedResearch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FundedResearch {
    private final String agency;
    private final String amount;
    private final String duration;
    private final String file;
    private final String id;
    private final String title;
    private final String year;

    public static /* synthetic */ FundedResearch copy$default(FundedResearch fundedResearch, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fundedResearch.id;
        }
        if ((i & 2) != 0) {
            str2 = fundedResearch.title;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = fundedResearch.amount;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = fundedResearch.agency;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = fundedResearch.year;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = fundedResearch.duration;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = fundedResearch.file;
        }
        return fundedResearch.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAgency() {
        return this.agency;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final FundedResearch copy(String id, String title, String amount, String agency, String year, String duration, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(file, "file");
        return new FundedResearch(id, title, amount, agency, year, duration, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FundedResearch)) {
            return false;
        }
        FundedResearch fundedResearch = (FundedResearch) other;
        return Intrinsics.areEqual(this.id, fundedResearch.id) && Intrinsics.areEqual(this.title, fundedResearch.title) && Intrinsics.areEqual(this.amount, fundedResearch.amount) && Intrinsics.areEqual(this.agency, fundedResearch.agency) && Intrinsics.areEqual(this.year, fundedResearch.year) && Intrinsics.areEqual(this.duration, fundedResearch.duration) && Intrinsics.areEqual(this.file, fundedResearch.file);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.agency.hashCode()) * 31) + this.year.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "FundedResearch(id=" + this.id + ", title=" + this.title + ", amount=" + this.amount + ", agency=" + this.agency + ", year=" + this.year + ", duration=" + this.duration + ", file=" + this.file + ")";
    }

    public FundedResearch(String id, String title, String amount, String agency, String year, String duration, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.agency = agency;
        this.year = year;
        this.duration = duration;
        this.file = file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getAgency() {
        return this.agency;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getFile() {
        return this.file;
    }
}