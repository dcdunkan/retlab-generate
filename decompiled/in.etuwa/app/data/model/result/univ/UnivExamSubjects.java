package in.etuwa.app.data.model.result.univ;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnivExamSubjects.kt */
/* loaded from: classes3.dex */
public final /* data */ class UnivExamSubjects implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String attendance;
    private final String credits;

    @SerializedName("internal_mark")
    private final String internalMark;
    private final String status;
    private final String subject;

    @SerializedName("univ_mark")
    private final String univMark;

    public static /* synthetic */ UnivExamSubjects copy$default(UnivExamSubjects univExamSubjects, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = univExamSubjects.subject;
        }
        if ((i & 2) != 0) {
            str2 = univExamSubjects.attendance;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = univExamSubjects.credits;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = univExamSubjects.internalMark;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = univExamSubjects.univMark;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = univExamSubjects.status;
        }
        return univExamSubjects.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAttendance() {
        return this.attendance;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCredits() {
        return this.credits;
    }

    /* renamed from: component4, reason: from getter */
    public final String getInternalMark() {
        return this.internalMark;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUnivMark() {
        return this.univMark;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final UnivExamSubjects copy(String subject, String attendance, String credits, String internalMark, String univMark, String status) {
        return new UnivExamSubjects(subject, attendance, credits, internalMark, univMark, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnivExamSubjects)) {
            return false;
        }
        UnivExamSubjects univExamSubjects = (UnivExamSubjects) other;
        return Intrinsics.areEqual(this.subject, univExamSubjects.subject) && Intrinsics.areEqual(this.attendance, univExamSubjects.attendance) && Intrinsics.areEqual(this.credits, univExamSubjects.credits) && Intrinsics.areEqual(this.internalMark, univExamSubjects.internalMark) && Intrinsics.areEqual(this.univMark, univExamSubjects.univMark) && Intrinsics.areEqual(this.status, univExamSubjects.status);
    }

    public int hashCode() {
        String str = this.subject;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.attendance;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.credits;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.internalMark;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.univMark;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.status;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "UnivExamSubjects(subject=" + this.subject + ", attendance=" + this.attendance + ", credits=" + this.credits + ", internalMark=" + this.internalMark + ", univMark=" + this.univMark + ", status=" + this.status + ")";
    }

    public UnivExamSubjects(String str, String str2, String str3, String str4, String str5, String str6) {
        this.subject = str;
        this.attendance = str2;
        this.credits = str3;
        this.internalMark = str4;
        this.univMark = str5;
        this.status = str6;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getAttendance() {
        return this.attendance;
    }

    public final String getCredits() {
        return this.credits;
    }

    public final String getInternalMark() {
        return this.internalMark;
    }

    public final String getUnivMark() {
        return this.univMark;
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnivExamSubjects(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.subject);
        parcel.writeString(this.attendance);
        parcel.writeString(this.credits);
        parcel.writeString(this.internalMark);
        parcel.writeString(this.univMark);
        parcel.writeString(this.status);
    }

    /* compiled from: UnivExamSubjects.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/result/univ/UnivExamSubjects$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/result/univ/UnivExamSubjects;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/result/univ/UnivExamSubjects;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.result.univ.UnivExamSubjects$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<UnivExamSubjects> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnivExamSubjects createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UnivExamSubjects(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnivExamSubjects[] newArray(int size) {
            return new UnivExamSubjects[size];
        }
    }
}