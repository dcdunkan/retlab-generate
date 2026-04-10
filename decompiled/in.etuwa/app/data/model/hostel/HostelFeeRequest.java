package in.etuwa.app.data.model.hostel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelFeeRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelFeeRequest {

    @SerializedName("transaction_method")
    @Expose
    private final String Tmethod;

    @SerializedName("month")
    @Expose
    private final String month;

    @SerializedName("year")
    @Expose
    private final String year;

    public static /* synthetic */ HostelFeeRequest copy$default(HostelFeeRequest hostelFeeRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostelFeeRequest.month;
        }
        if ((i & 2) != 0) {
            str2 = hostelFeeRequest.year;
        }
        if ((i & 4) != 0) {
            str3 = hostelFeeRequest.Tmethod;
        }
        return hostelFeeRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTmethod() {
        return this.Tmethod;
    }

    public final HostelFeeRequest copy(String month, String year, String Tmethod) {
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(Tmethod, "Tmethod");
        return new HostelFeeRequest(month, year, Tmethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelFeeRequest)) {
            return false;
        }
        HostelFeeRequest hostelFeeRequest = (HostelFeeRequest) other;
        return Intrinsics.areEqual(this.month, hostelFeeRequest.month) && Intrinsics.areEqual(this.year, hostelFeeRequest.year) && Intrinsics.areEqual(this.Tmethod, hostelFeeRequest.Tmethod);
    }

    public int hashCode() {
        return (((this.month.hashCode() * 31) + this.year.hashCode()) * 31) + this.Tmethod.hashCode();
    }

    public String toString() {
        return "HostelFeeRequest(month=" + this.month + ", year=" + this.year + ", Tmethod=" + this.Tmethod + ")";
    }

    public HostelFeeRequest(String month, String year, String Tmethod) {
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(Tmethod, "Tmethod");
        this.month = month;
        this.year = year;
        this.Tmethod = Tmethod;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getTmethod() {
        return this.Tmethod;
    }
}