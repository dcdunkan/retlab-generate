package in.etuwa.app.data.model.counselling.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewCounselling.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ViewCounselling {
    private final String applicant;
    private final String concern;

    @SerializedName("counselling_history")
    @Expose
    private final String counsellingHistory;

    @SerializedName("counselling_no")
    @Expose
    private final String counsellingNo;

    @SerializedName("counselling_session_required")
    @Expose
    private final String counsellingSessionRequired;

    @SerializedName("counselling_type")
    @Expose
    private final String counsellingType;
    private final String date;
    private final String id;

    @SerializedName("impact_home")
    @Expose
    private final String impactHome;

    @SerializedName("impact_physically_emotionally")
    @Expose
    private final String impactPhysicallyEmotionally;

    @SerializedName("impact_relationship")
    @Expose
    private final String impactRelationship;

    @SerializedName("impact_studies")
    @Expose
    private final String impactStudies;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getImpactPhysicallyEmotionally() {
        return this.impactPhysicallyEmotionally;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCounsellingHistory() {
        return this.counsellingHistory;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCounsellingSessionRequired() {
        return this.counsellingSessionRequired;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCounsellingNo() {
        return this.counsellingNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCounsellingType() {
        return this.counsellingType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getApplicant() {
        return this.applicant;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getConcern() {
        return this.concern;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getImpactHome() {
        return this.impactHome;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getImpactStudies() {
        return this.impactStudies;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getImpactRelationship() {
        return this.impactRelationship;
    }

    public final ViewCounselling copy(String id, String counsellingNo, String counsellingType, String applicant, String date, String concern, String impactHome, String impactStudies, String impactRelationship, String impactPhysicallyEmotionally, String counsellingHistory, String counsellingSessionRequired) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(counsellingNo, "counsellingNo");
        Intrinsics.checkNotNullParameter(counsellingType, "counsellingType");
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(concern, "concern");
        Intrinsics.checkNotNullParameter(impactHome, "impactHome");
        Intrinsics.checkNotNullParameter(impactStudies, "impactStudies");
        Intrinsics.checkNotNullParameter(impactRelationship, "impactRelationship");
        Intrinsics.checkNotNullParameter(impactPhysicallyEmotionally, "impactPhysicallyEmotionally");
        Intrinsics.checkNotNullParameter(counsellingHistory, "counsellingHistory");
        Intrinsics.checkNotNullParameter(counsellingSessionRequired, "counsellingSessionRequired");
        return new ViewCounselling(id, counsellingNo, counsellingType, applicant, date, concern, impactHome, impactStudies, impactRelationship, impactPhysicallyEmotionally, counsellingHistory, counsellingSessionRequired);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewCounselling)) {
            return false;
        }
        ViewCounselling viewCounselling = (ViewCounselling) other;
        return Intrinsics.areEqual(this.id, viewCounselling.id) && Intrinsics.areEqual(this.counsellingNo, viewCounselling.counsellingNo) && Intrinsics.areEqual(this.counsellingType, viewCounselling.counsellingType) && Intrinsics.areEqual(this.applicant, viewCounselling.applicant) && Intrinsics.areEqual(this.date, viewCounselling.date) && Intrinsics.areEqual(this.concern, viewCounselling.concern) && Intrinsics.areEqual(this.impactHome, viewCounselling.impactHome) && Intrinsics.areEqual(this.impactStudies, viewCounselling.impactStudies) && Intrinsics.areEqual(this.impactRelationship, viewCounselling.impactRelationship) && Intrinsics.areEqual(this.impactPhysicallyEmotionally, viewCounselling.impactPhysicallyEmotionally) && Intrinsics.areEqual(this.counsellingHistory, viewCounselling.counsellingHistory) && Intrinsics.areEqual(this.counsellingSessionRequired, viewCounselling.counsellingSessionRequired);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.id.hashCode() * 31) + this.counsellingNo.hashCode()) * 31) + this.counsellingType.hashCode()) * 31) + this.applicant.hashCode()) * 31) + this.date.hashCode()) * 31) + this.concern.hashCode()) * 31) + this.impactHome.hashCode()) * 31) + this.impactStudies.hashCode()) * 31) + this.impactRelationship.hashCode()) * 31) + this.impactPhysicallyEmotionally.hashCode()) * 31) + this.counsellingHistory.hashCode()) * 31) + this.counsellingSessionRequired.hashCode();
    }

    public String toString() {
        return "ViewCounselling(id=" + this.id + ", counsellingNo=" + this.counsellingNo + ", counsellingType=" + this.counsellingType + ", applicant=" + this.applicant + ", date=" + this.date + ", concern=" + this.concern + ", impactHome=" + this.impactHome + ", impactStudies=" + this.impactStudies + ", impactRelationship=" + this.impactRelationship + ", impactPhysicallyEmotionally=" + this.impactPhysicallyEmotionally + ", counsellingHistory=" + this.counsellingHistory + ", counsellingSessionRequired=" + this.counsellingSessionRequired + ")";
    }

    public ViewCounselling(String id, String counsellingNo, String counsellingType, String applicant, String date, String concern, String impactHome, String impactStudies, String impactRelationship, String impactPhysicallyEmotionally, String counsellingHistory, String counsellingSessionRequired) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(counsellingNo, "counsellingNo");
        Intrinsics.checkNotNullParameter(counsellingType, "counsellingType");
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(concern, "concern");
        Intrinsics.checkNotNullParameter(impactHome, "impactHome");
        Intrinsics.checkNotNullParameter(impactStudies, "impactStudies");
        Intrinsics.checkNotNullParameter(impactRelationship, "impactRelationship");
        Intrinsics.checkNotNullParameter(impactPhysicallyEmotionally, "impactPhysicallyEmotionally");
        Intrinsics.checkNotNullParameter(counsellingHistory, "counsellingHistory");
        Intrinsics.checkNotNullParameter(counsellingSessionRequired, "counsellingSessionRequired");
        this.id = id;
        this.counsellingNo = counsellingNo;
        this.counsellingType = counsellingType;
        this.applicant = applicant;
        this.date = date;
        this.concern = concern;
        this.impactHome = impactHome;
        this.impactStudies = impactStudies;
        this.impactRelationship = impactRelationship;
        this.impactPhysicallyEmotionally = impactPhysicallyEmotionally;
        this.counsellingHistory = counsellingHistory;
        this.counsellingSessionRequired = counsellingSessionRequired;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCounsellingNo() {
        return this.counsellingNo;
    }

    public final String getCounsellingType() {
        return this.counsellingType;
    }

    public final String getApplicant() {
        return this.applicant;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getConcern() {
        return this.concern;
    }

    public final String getImpactHome() {
        return this.impactHome;
    }

    public final String getImpactStudies() {
        return this.impactStudies;
    }

    public final String getImpactRelationship() {
        return this.impactRelationship;
    }

    public final String getImpactPhysicallyEmotionally() {
        return this.impactPhysicallyEmotionally;
    }

    public final String getCounsellingHistory() {
        return this.counsellingHistory;
    }

    public final String getCounsellingSessionRequired() {
        return this.counsellingSessionRequired;
    }
}