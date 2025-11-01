package in.etuwa.app.data.model.hostel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelFeeRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/hostel/HostelFeeRequest;", "", "month", "", "year", "Tmethod", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTmethod", "()Ljava/lang/String;", "getMonth", "getYear", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    /* renamed from: component2, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component3, reason: from getter */
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