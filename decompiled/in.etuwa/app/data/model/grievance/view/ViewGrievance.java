package in.etuwa.app.data.model.grievance.view;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewGrievance.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGrievanceNo() {
        return this.grievanceNo;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getReplyDate() {
        return this.replyDate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getReplyDetails() {
        return this.replyDetails;
    }

    public final ArrayList<GrievanceDoc> component12() {
        return this.grDoc;
    }

    public final ArrayList<GrievanceDoc> component13() {
        return this.replyDoc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGrievanceType() {
        return this.grievanceType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGreivant() {
        return this.greivant;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getActionTaken() {
        return this.actionTaken;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
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