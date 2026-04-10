package in.etuwa.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SubjectData implements Parcelable {
    public static final Parcelable.Creator<SubjectData> CREATOR = new Creator();

    @SerializedName("percentage")
    private final double percentage;

    @SerializedName("subject code")
    private final String subjectCode;

    /* JADX INFO: compiled from: AnalysisModels.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubjectData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubjectData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubjectData(parcel.readString(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubjectData[] newArray(int i) {
            return new SubjectData[i];
        }
    }

    public static /* synthetic */ SubjectData copy$default(SubjectData subjectData, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subjectData.subjectCode;
        }
        if ((i & 2) != 0) {
            d = subjectData.percentage;
        }
        return subjectData.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectCode() {
        return this.subjectCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getPercentage() {
        return this.percentage;
    }

    public final SubjectData copy(String subjectCode, double percentage) {
        Intrinsics.checkNotNullParameter(subjectCode, "subjectCode");
        return new SubjectData(subjectCode, percentage);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectData)) {
            return false;
        }
        SubjectData subjectData = (SubjectData) other;
        return Intrinsics.areEqual(this.subjectCode, subjectData.subjectCode) && Double.compare(this.percentage, subjectData.percentage) == 0;
    }

    public int hashCode() {
        return (this.subjectCode.hashCode() * 31) + DownloadModel$$ExternalSyntheticBackport0.m(this.percentage);
    }

    public String toString() {
        return "SubjectData(subjectCode=" + this.subjectCode + ", percentage=" + this.percentage + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.subjectCode);
        parcel.writeDouble(this.percentage);
    }

    public SubjectData(String subjectCode, double d) {
        Intrinsics.checkNotNullParameter(subjectCode, "subjectCode");
        this.subjectCode = subjectCode;
        this.percentage = d;
    }

    public final String getSubjectCode() {
        return this.subjectCode;
    }

    public final double getPercentage() {
        return this.percentage;
    }
}