package in.etuwa.app.data.model.lab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Practical.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/lab/Practical;", "", "subject", "", "attendance", StoreFragmentKt.SUB_ID, "subPid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttendance", "()Ljava/lang/String;", "getSubId", "getSubPid", "getSubject", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAttendance() {
        return this.attendance;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubId() {
        return this.subId;
    }

    /* renamed from: component4, reason: from getter */
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