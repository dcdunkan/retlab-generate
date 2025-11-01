package in.etuwa.app.data.model.result.univ;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnivDetails.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u001fH\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006*"}, d2 = {"Lin/etuwa/app/data/model/result/univ/UnivDetails;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "credit", "", "totalInternal", "passStatus", "sgpa", "cgpa", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCgpa", "()Ljava/lang/String;", "setCgpa", "(Ljava/lang/String;)V", "getCredit", "setCredit", "getPassStatus", "setPassStatus", "getSgpa", "setSgpa", "getTotalInternal", "setTotalInternal", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", XfdfConstants.FLAGS, "CREATOR", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UnivDetails implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String cgpa;
    private String credit;

    @SerializedName("pass_status")
    private String passStatus;
    private String sgpa;

    @SerializedName("total_internal")
    private String totalInternal;

    public static /* synthetic */ UnivDetails copy$default(UnivDetails univDetails, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = univDetails.credit;
        }
        if ((i & 2) != 0) {
            str2 = univDetails.totalInternal;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = univDetails.passStatus;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = univDetails.sgpa;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = univDetails.cgpa;
        }
        return univDetails.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCredit() {
        return this.credit;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTotalInternal() {
        return this.totalInternal;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPassStatus() {
        return this.passStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSgpa() {
        return this.sgpa;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCgpa() {
        return this.cgpa;
    }

    public final UnivDetails copy(String credit, String totalInternal, String passStatus, String sgpa, String cgpa) {
        return new UnivDetails(credit, totalInternal, passStatus, sgpa, cgpa);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnivDetails)) {
            return false;
        }
        UnivDetails univDetails = (UnivDetails) other;
        return Intrinsics.areEqual(this.credit, univDetails.credit) && Intrinsics.areEqual(this.totalInternal, univDetails.totalInternal) && Intrinsics.areEqual(this.passStatus, univDetails.passStatus) && Intrinsics.areEqual(this.sgpa, univDetails.sgpa) && Intrinsics.areEqual(this.cgpa, univDetails.cgpa);
    }

    public int hashCode() {
        String str = this.credit;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.totalInternal;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.passStatus;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sgpa;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cgpa;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "UnivDetails(credit=" + this.credit + ", totalInternal=" + this.totalInternal + ", passStatus=" + this.passStatus + ", sgpa=" + this.sgpa + ", cgpa=" + this.cgpa + ")";
    }

    public UnivDetails(String str, String str2, String str3, String str4, String str5) {
        this.credit = str;
        this.totalInternal = str2;
        this.passStatus = str3;
        this.sgpa = str4;
        this.cgpa = str5;
    }

    public final String getCredit() {
        return this.credit;
    }

    public final void setCredit(String str) {
        this.credit = str;
    }

    public final String getTotalInternal() {
        return this.totalInternal;
    }

    public final void setTotalInternal(String str) {
        this.totalInternal = str;
    }

    public final String getPassStatus() {
        return this.passStatus;
    }

    public final void setPassStatus(String str) {
        this.passStatus = str;
    }

    public final String getSgpa() {
        return this.sgpa;
    }

    public final void setSgpa(String str) {
        this.sgpa = str;
    }

    public final String getCgpa() {
        return this.cgpa;
    }

    public final void setCgpa(String str) {
        this.cgpa = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnivDetails(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.credit);
        parcel.writeString(this.totalInternal);
        parcel.writeString(this.passStatus);
        parcel.writeString(this.sgpa);
        parcel.writeString(this.cgpa);
    }

    /* compiled from: UnivDetails.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/result/univ/UnivDetails$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/result/univ/UnivDetails;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/result/univ/UnivDetails;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.result.univ.UnivDetails$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<UnivDetails> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnivDetails createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UnivDetails(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnivDetails[] newArray(int size) {
            return new UnivDetails[size];
        }
    }
}