package in.etuwa.app.data.model.lab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Practical.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Practical {

    @SerializedName("atten_text")
    @Expose
    private final String attendance;

    @SerializedName("sub_id")
    @Expose
    private final String subId;

    @SerializedName("sub_pid")
    @Expose
    private final String subPid;
    private final String subject;

    public static /* synthetic */ Practical copy$default(Practical practical, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = practical.subject;
        }
        if ((i & 2) != 0) {
            str2 = practical.attendance;
        }
        if ((i & 4) != 0) {
            str3 = practical.subId;
        }
        if ((i & 8) != 0) {
            str4 = practical.subPid;
        }
        return practical.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAttendance() {
        return this.attendance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubId() {
        return this.subId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubPid() {
        return this.subPid;
    }

    public final Practical copy(String subject, String attendance, String subId, String subPid) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(attendance, "attendance");
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(subPid, "subPid");
        return new Practical(subject, attendance, subId, subPid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Practical)) {
            return false;
        }
        Practical practical = (Practical) other;
        return Intrinsics.areEqual(this.subject, practical.subject) && Intrinsics.areEqual(this.attendance, practical.attendance) && Intrinsics.areEqual(this.subId, practical.subId) && Intrinsics.areEqual(this.subPid, practical.subPid);
    }

    public int hashCode() {
        return (((((this.subject.hashCode() * 31) + this.attendance.hashCode()) * 31) + this.subId.hashCode()) * 31) + this.subPid.hashCode();
    }

    public String toString() {
        return "Practical(subject=" + this.subject + ", attendance=" + this.attendance + ", subId=" + this.subId + ", subPid=" + this.subPid + ")";
    }

    public Practical(String subject, String attendance, String subId, String subPid) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(attendance, "attendance");
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(subPid, "subPid");
        this.subject = subject;
        this.attendance = attendance;
        this.subId = subId;
        this.subPid = subPid;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getAttendance() {
        return this.attendance;
    }

    public final String getSubId() {
        return this.subId;
    }

    public final String getSubPid() {
        return this.subPid;
    }
}