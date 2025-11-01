package in.etuwa.app.data.model.grievance.view;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewGrievance.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0019\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011HÆ\u0003J\u0019\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J«\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00067"}, d2 = {"Lin/etuwa/app/data/model/grievance/view/ViewGrievance;", "", "grievanceNo", "", "grievanceType", "subject", "date", "greivant", PdfConst.Description, NotificationCompat.CATEGORY_STATUS, "actionTaken", "reply", "replyDate", "replyDetails", "grDoc", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/grievance/view/GrievanceDoc;", "Lkotlin/collections/ArrayList;", "replyDoc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getActionTaken", "()Ljava/lang/String;", "getDate", "getDescription", "getGrDoc", "()Ljava/util/ArrayList;", "getGreivant", "getGrievanceNo", "getGrievanceType", "getReply", "getReplyDate", "getReplyDetails", "getReplyDoc", "getStatus", "getSubject", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ViewGrievance {

    @SerializedName("action_taken")
    private final String actionTaken;
    private final String date;
    private final String description;

    @SerializedName("gr_doc")
    private final ArrayList<GrievanceDoc> grDoc;
    private final String greivant;

    @SerializedName("grievance_no")
    private final String grievanceNo;

    @SerializedName("grievance_type")
    private final String grievanceType;
    private final String reply;

    @SerializedName("reply_date")
    private final String replyDate;

    @SerializedName("reply_details")
    private final String replyDetails;

    @SerializedName("reply_doc")
    private final ArrayList<GrievanceDoc> replyDoc;
    private final String status;
    private final String subject;

    /* renamed from: component1, reason: from getter */
    public final String getGrievanceNo() {
        return this.grievanceNo;
    }

    /* renamed from: component10, reason: from getter */
    public final String getReplyDate() {
        return this.replyDate;
    }

    /* renamed from: component11, reason: from getter */
    public final String getReplyDetails() {
        return this.replyDetails;
    }

    public final ArrayList<GrievanceDoc> component12() {
        return this.grDoc;
    }

    public final ArrayList<GrievanceDoc> component13() {
        return this.replyDoc;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGrievanceType() {
        return this.grievanceType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGreivant() {
        return this.greivant;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getActionTaken() {
        return this.actionTaken;
    }

    /* renamed from: component9, reason: from getter */
    public final String getReply() {
        return this.reply;
    }

    public final ViewGrievance copy(String grievanceNo, String grievanceType, String subject, String date, String greivant, String description, String status, String actionTaken, String reply, String replyDate, String replyDetails, ArrayList<GrievanceDoc> grDoc, ArrayList<GrievanceDoc> replyDoc) {
        Intrinsics.checkNotNullParameter(grievanceNo, "grievanceNo");
        Intrinsics.checkNotNullParameter(grievanceType, "grievanceType");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(greivant, "greivant");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(actionTaken, "actionTaken");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(replyDate, "replyDate");
        Intrinsics.checkNotNullParameter(replyDetails, "replyDetails");
        Intrinsics.checkNotNullParameter(grDoc, "grDoc");
        Intrinsics.checkNotNullParameter(replyDoc, "replyDoc");
        return new ViewGrievance(grievanceNo, grievanceType, subject, date, greivant, description, status, actionTaken, reply, replyDate, replyDetails, grDoc, replyDoc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewGrievance)) {
            return false;
        }
        ViewGrievance viewGrievance = (ViewGrievance) other;
        return Intrinsics.areEqual(this.grievanceNo, viewGrievance.grievanceNo) && Intrinsics.areEqual(this.grievanceType, viewGrievance.grievanceType) && Intrinsics.areEqual(this.subject, viewGrievance.subject) && Intrinsics.areEqual(this.date, viewGrievance.date) && Intrinsics.areEqual(this.greivant, viewGrievance.greivant) && Intrinsics.areEqual(this.description, viewGrievance.description) && Intrinsics.areEqual(this.status, viewGrievance.status) && Intrinsics.areEqual(this.actionTaken, viewGrievance.actionTaken) && Intrinsics.areEqual(this.reply, viewGrievance.reply) && Intrinsics.areEqual(this.replyDate, viewGrievance.replyDate) && Intrinsics.areEqual(this.replyDetails, viewGrievance.replyDetails) && Intrinsics.areEqual(this.grDoc, viewGrievance.grDoc) && Intrinsics.areEqual(this.replyDoc, viewGrievance.replyDoc);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.grievanceNo.hashCode() * 31) + this.grievanceType.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.date.hashCode()) * 31) + this.greivant.hashCode()) * 31) + this.description.hashCode()) * 31) + this.status.hashCode()) * 31) + this.actionTaken.hashCode()) * 31) + this.reply.hashCode()) * 31) + this.replyDate.hashCode()) * 31) + this.replyDetails.hashCode()) * 31) + this.grDoc.hashCode()) * 31) + this.replyDoc.hashCode();
    }

    public String toString() {
        return "ViewGrievance(grievanceNo=" + this.grievanceNo + ", grievanceType=" + this.grievanceType + ", subject=" + this.subject + ", date=" + this.date + ", greivant=" + this.greivant + ", description=" + this.description + ", status=" + this.status + ", actionTaken=" + this.actionTaken + ", reply=" + this.reply + ", replyDate=" + this.replyDate + ", replyDetails=" + this.replyDetails + ", grDoc=" + this.grDoc + ", replyDoc=" + this.replyDoc + ")";
    }

    public ViewGrievance(String grievanceNo, String grievanceType, String subject, String date, String greivant, String description, String status, String actionTaken, String reply, String replyDate, String replyDetails, ArrayList<GrievanceDoc> grDoc, ArrayList<GrievanceDoc> replyDoc) {
        Intrinsics.checkNotNullParameter(grievanceNo, "grievanceNo");
        Intrinsics.checkNotNullParameter(grievanceType, "grievanceType");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(greivant, "greivant");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(actionTaken, "actionTaken");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(replyDate, "replyDate");
        Intrinsics.checkNotNullParameter(replyDetails, "replyDetails");
        Intrinsics.checkNotNullParameter(grDoc, "grDoc");
        Intrinsics.checkNotNullParameter(replyDoc, "replyDoc");
        this.grievanceNo = grievanceNo;
        this.grievanceType = grievanceType;
        this.subject = subject;
        this.date = date;
        this.greivant = greivant;
        this.description = description;
        this.status = status;
        this.actionTaken = actionTaken;
        this.reply = reply;
        this.replyDate = replyDate;
        this.replyDetails = replyDetails;
        this.grDoc = grDoc;
        this.replyDoc = replyDoc;
    }

    public final String getGrievanceNo() {
        return this.grievanceNo;
    }

    public final String getGrievanceType() {
        return this.grievanceType;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getGreivant() {
        return this.greivant;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getActionTaken() {
        return this.actionTaken;
    }

    public final String getReply() {
        return this.reply;
    }

    public final String getReplyDate() {
        return this.replyDate;
    }

    public final String getReplyDetails() {
        return this.replyDetails;
    }

    public final ArrayList<GrievanceDoc> getGrDoc() {
        return this.grDoc;
    }

    public final ArrayList<GrievanceDoc> getReplyDoc() {
        return this.replyDoc;
    }
}