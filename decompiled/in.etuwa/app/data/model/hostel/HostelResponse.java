package in.etuwa.app.data.model.hostel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/hostel/HostelResponse;", "", "name", "", "roomNo", "hostel", "joinDate", "installment", "month", "year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHostel", "()Ljava/lang/String;", "getInstallment", "getJoinDate", "getMonth", "getName", "getRoomNo", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelResponse {
    private final String hostel;
    private final String installment;

    @SerializedName("join_date")
    @Expose
    private final String joinDate;
    private final String month;
    private final String name;

    @SerializedName("room_no")
    @Expose
    private final String roomNo;
    private final String year;

    public static /* synthetic */ HostelResponse copy$default(HostelResponse hostelResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostelResponse.name;
        }
        if ((i & 2) != 0) {
            str2 = hostelResponse.roomNo;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = hostelResponse.hostel;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = hostelResponse.joinDate;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = hostelResponse.installment;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = hostelResponse.month;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = hostelResponse.year;
        }
        return hostelResponse.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRoomNo() {
        return this.roomNo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHostel() {
        return this.hostel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getJoinDate() {
        return this.joinDate;
    }

    /* renamed from: component5, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    /* renamed from: component7, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    public final HostelResponse copy(String name, String roomNo, String hostel, String joinDate, String installment, String month, String year) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(roomNo, "roomNo");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(joinDate, "joinDate");
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        return new HostelResponse(name, roomNo, hostel, joinDate, installment, month, year);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelResponse)) {
            return false;
        }
        HostelResponse hostelResponse = (HostelResponse) other;
        return Intrinsics.areEqual(this.name, hostelResponse.name) && Intrinsics.areEqual(this.roomNo, hostelResponse.roomNo) && Intrinsics.areEqual(this.hostel, hostelResponse.hostel) && Intrinsics.areEqual(this.joinDate, hostelResponse.joinDate) && Intrinsics.areEqual(this.installment, hostelResponse.installment) && Intrinsics.areEqual(this.month, hostelResponse.month) && Intrinsics.areEqual(this.year, hostelResponse.year);
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.roomNo.hashCode()) * 31) + this.hostel.hashCode()) * 31) + this.joinDate.hashCode()) * 31) + this.installment.hashCode()) * 31) + this.month.hashCode()) * 31) + this.year.hashCode();
    }

    public String toString() {
        return "HostelResponse(name=" + this.name + ", roomNo=" + this.roomNo + ", hostel=" + this.hostel + ", joinDate=" + this.joinDate + ", installment=" + this.installment + ", month=" + this.month + ", year=" + this.year + ")";
    }

    public HostelResponse(String name, String roomNo, String hostel, String joinDate, String installment, String month, String year) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(roomNo, "roomNo");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(joinDate, "joinDate");
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        this.name = name;
        this.roomNo = roomNo;
        this.hostel = hostel;
        this.joinDate = joinDate;
        this.installment = installment;
        this.month = month;
        this.year = year;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoomNo() {
        return this.roomNo;
    }

    public final String getHostel() {
        return this.hostel;
    }

    public final String getJoinDate() {
        return this.joinDate;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getYear() {
        return this.year;
    }
}