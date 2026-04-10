package in.etuwa.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AnalysisSubjectBean implements Parcelable {
    public static final Parcelable.Creator<AnalysisSubjectBean> CREATOR = new Creator();
    private final double percentage_mark;
    private final String subject_code;

    /* JADX INFO: compiled from: AnalysisModels.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AnalysisSubjectBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnalysisSubjectBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AnalysisSubjectBean(parcel.readString(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnalysisSubjectBean[] newArray(int i) {
            return new AnalysisSubjectBean[i];
        }
    }

    public static /* synthetic */ AnalysisSubjectBean copy$default(AnalysisSubjectBean analysisSubjectBean, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analysisSubjectBean.subject_code;
        }
        if ((i & 2) != 0) {
            d = analysisSubjectBean.percentage_mark;
        }
        return analysisSubjectBean.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject_code() {
        return this.subject_code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getPercentage_mark() {
        return this.percentage_mark;
    }

    public final AnalysisSubjectBean copy(String subject_code, double percentage_mark) {
        Intrinsics.checkNotNullParameter(subject_code, "subject_code");
        return new AnalysisSubjectBean(subject_code, percentage_mark);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalysisSubjectBean)) {
            return false;
        }
        AnalysisSubjectBean analysisSubjectBean = (AnalysisSubjectBean) other;
        return Intrinsics.areEqual(this.subject_code, analysisSubjectBean.subject_code) && Double.compare(this.percentage_mark, analysisSubjectBean.percentage_mark) == 0;
    }

    public int hashCode() {
        return (this.subject_code.hashCode() * 31) + DownloadModel$$ExternalSyntheticBackport0.m(this.percentage_mark);
    }

    public String toString() {
        return "AnalysisSubjectBean(subject_code=" + this.subject_code + ", percentage_mark=" + this.percentage_mark + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.subject_code);
        parcel.writeDouble(this.percentage_mark);
    }

    public AnalysisSubjectBean(String subject_code, double d) {
        Intrinsics.checkNotNullParameter(subject_code, "subject_code");
        this.subject_code = subject_code;
        this.percentage_mark = d;
    }

    public final String getSubject_code() {
        return this.subject_code;
    }

    public final double getPercentage_mark() {
        return this.percentage_mark;
    }
}