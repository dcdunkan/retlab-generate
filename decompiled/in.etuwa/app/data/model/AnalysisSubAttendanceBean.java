package in.etuwa.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AnalysisSubAttendanceBean implements Parcelable {
    public static final Parcelable.Creator<AnalysisSubAttendanceBean> CREATOR = new Creator();
    private final double percentage_attendance;
    private final String subject_code;

    /* JADX INFO: compiled from: AnalysisModels.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AnalysisSubAttendanceBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnalysisSubAttendanceBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AnalysisSubAttendanceBean(parcel.readString(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnalysisSubAttendanceBean[] newArray(int i) {
            return new AnalysisSubAttendanceBean[i];
        }
    }

    public static /* synthetic */ AnalysisSubAttendanceBean copy$default(AnalysisSubAttendanceBean analysisSubAttendanceBean, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analysisSubAttendanceBean.subject_code;
        }
        if ((i & 2) != 0) {
            d = analysisSubAttendanceBean.percentage_attendance;
        }
        return analysisSubAttendanceBean.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject_code() {
        return this.subject_code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getPercentage_attendance() {
        return this.percentage_attendance;
    }

    public final AnalysisSubAttendanceBean copy(String subject_code, double percentage_attendance) {
        Intrinsics.checkNotNullParameter(subject_code, "subject_code");
        return new AnalysisSubAttendanceBean(subject_code, percentage_attendance);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalysisSubAttendanceBean)) {
            return false;
        }
        AnalysisSubAttendanceBean analysisSubAttendanceBean = (AnalysisSubAttendanceBean) other;
        return Intrinsics.areEqual(this.subject_code, analysisSubAttendanceBean.subject_code) && Double.compare(this.percentage_attendance, analysisSubAttendanceBean.percentage_attendance) == 0;
    }

    public int hashCode() {
        return (this.subject_code.hashCode() * 31) + DownloadModel$$ExternalSyntheticBackport0.m(this.percentage_attendance);
    }

    public String toString() {
        return "AnalysisSubAttendanceBean(subject_code=" + this.subject_code + ", percentage_attendance=" + this.percentage_attendance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.subject_code);
        parcel.writeDouble(this.percentage_attendance);
    }

    public AnalysisSubAttendanceBean(String subject_code, double d) {
        Intrinsics.checkNotNullParameter(subject_code, "subject_code");
        this.subject_code = subject_code;
        this.percentage_attendance = d;
    }

    public final String getSubject_code() {
        return this.subject_code;
    }

    public final double getPercentage_attendance() {
        return this.percentage_attendance;
    }
}