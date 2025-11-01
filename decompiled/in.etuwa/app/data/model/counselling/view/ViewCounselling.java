package in.etuwa.app.data.model.counselling.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewCounselling.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, d2 = {"Lin/etuwa/app/data/model/counselling/view/ViewCounselling;", "", "id", "", "counsellingType", "applicant", "date", "concern", "impactHome", "impactStudies", "impactRelationship", "impactPhysicallyEmotionally", "counsellingHistory", "counsellingSessionRequired", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplicant", "()Ljava/lang/String;", "getConcern", "getCounsellingHistory", "getCounsellingSessionRequired", "getCounsellingType", "getDate", "getId", "getImpactHome", "getImpactPhysicallyEmotionally", "getImpactRelationship", "getImpactStudies", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ViewCounselling {
    private final String applicant;
    private final String concern;

    @SerializedName("counselling_history")
    @Expose
    private final String counsellingHistory;

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

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCounsellingHistory() {
        return this.counsellingHistory;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCounsellingSessionRequired() {
        return this.counsellingSessionRequired;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCounsellingType() {
        return this.counsellingType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getApplicant() {
        return this.applicant;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getConcern() {
        return this.concern;
    }

    /* renamed from: component6, reason: from getter */
    public final String getImpactHome() {
        return this.impactHome;
    }

    /* renamed from: component7, reason: from getter */
    public final String getImpactStudies() {
        return this.impactStudies;
    }

    /* renamed from: component8, reason: from getter */
    public final String getImpactRelationship() {
        return this.impactRelationship;
    }

    /* renamed from: component9, reason: from getter */
    public final String getImpactPhysicallyEmotionally() {
        return this.impactPhysicallyEmotionally;
    }

    public final ViewCounselling copy(String id, String counsellingType, String applicant, String date, String concern, String impactHome, String impactStudies, String impactRelationship, String impactPhysicallyEmotionally, String counsellingHistory, String counsellingSessionRequired) {
        Intrinsics.checkNotNullParameter(id, "id");
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
        return new ViewCounselling(id, counsellingType, applicant, date, concern, impactHome, impactStudies, impactRelationship, impactPhysicallyEmotionally, counsellingHistory, counsellingSessionRequired);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewCounselling)) {
            return false;
        }
        ViewCounselling viewCounselling = (ViewCounselling) other;
        return Intrinsics.areEqual(this.id, viewCounselling.id) && Intrinsics.areEqual(this.counsellingType, viewCounselling.counsellingType) && Intrinsics.areEqual(this.applicant, viewCounselling.applicant) && Intrinsics.areEqual(this.date, viewCounselling.date) && Intrinsics.areEqual(this.concern, viewCounselling.concern) && Intrinsics.areEqual(this.impactHome, viewCounselling.impactHome) && Intrinsics.areEqual(this.impactStudies, viewCounselling.impactStudies) && Intrinsics.areEqual(this.impactRelationship, viewCounselling.impactRelationship) && Intrinsics.areEqual(this.impactPhysicallyEmotionally, viewCounselling.impactPhysicallyEmotionally) && Intrinsics.areEqual(this.counsellingHistory, viewCounselling.counsellingHistory) && Intrinsics.areEqual(this.counsellingSessionRequired, viewCounselling.counsellingSessionRequired);
    }

    public int hashCode() {
        return (((((((((((((((((((this.id.hashCode() * 31) + this.counsellingType.hashCode()) * 31) + this.applicant.hashCode()) * 31) + this.date.hashCode()) * 31) + this.concern.hashCode()) * 31) + this.impactHome.hashCode()) * 31) + this.impactStudies.hashCode()) * 31) + this.impactRelationship.hashCode()) * 31) + this.impactPhysicallyEmotionally.hashCode()) * 31) + this.counsellingHistory.hashCode()) * 31) + this.counsellingSessionRequired.hashCode();
    }

    public String toString() {
        return "ViewCounselling(id=" + this.id + ", counsellingType=" + this.counsellingType + ", applicant=" + this.applicant + ", date=" + this.date + ", concern=" + this.concern + ", impactHome=" + this.impactHome + ", impactStudies=" + this.impactStudies + ", impactRelationship=" + this.impactRelationship + ", impactPhysicallyEmotionally=" + this.impactPhysicallyEmotionally + ", counsellingHistory=" + this.counsellingHistory + ", counsellingSessionRequired=" + this.counsellingSessionRequired + ")";
    }

    public ViewCounselling(String id, String counsellingType, String applicant, String date, String concern, String impactHome, String impactStudies, String impactRelationship, String impactPhysicallyEmotionally, String counsellingHistory, String counsellingSessionRequired) {
        Intrinsics.checkNotNullParameter(id, "id");
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