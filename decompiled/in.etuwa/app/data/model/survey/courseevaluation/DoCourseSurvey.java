package in.etuwa.app.data.model.survey.courseevaluation;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DoCourseSurvey.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DoCourseSurvey {
    private final String btn;
    private final String id;
    private final String name;
    private final int slno;
    private final String status;

    public static /* synthetic */ DoCourseSurvey copy$default(DoCourseSurvey doCourseSurvey, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = doCourseSurvey.slno;
        }
        if ((i2 & 2) != 0) {
            str = doCourseSurvey.name;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = doCourseSurvey.id;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = doCourseSurvey.status;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = doCourseSurvey.btn;
        }
        return doCourseSurvey.copy(i, str5, str6, str7, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSlno() {
        return this.slno;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBtn() {
        return this.btn;
    }

    public final DoCourseSurvey copy(int slno, String name, String id, String status, String btn) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        return new DoCourseSurvey(slno, name, id, status, btn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DoCourseSurvey)) {
            return false;
        }
        DoCourseSurvey doCourseSurvey = (DoCourseSurvey) other;
        return this.slno == doCourseSurvey.slno && Intrinsics.areEqual(this.name, doCourseSurvey.name) && Intrinsics.areEqual(this.id, doCourseSurvey.id) && Intrinsics.areEqual(this.status, doCourseSurvey.status) && Intrinsics.areEqual(this.btn, doCourseSurvey.btn);
    }

    public int hashCode() {
        return (((((((this.slno * 31) + this.name.hashCode()) * 31) + this.id.hashCode()) * 31) + this.status.hashCode()) * 31) + this.btn.hashCode();
    }

    public String toString() {
        return "DoCourseSurvey(slno=" + this.slno + ", name=" + this.name + ", id=" + this.id + ", status=" + this.status + ", btn=" + this.btn + ")";
    }

    public DoCourseSurvey(int i, String name, String id, String status, String btn) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        this.slno = i;
        this.name = name;
        this.id = id;
        this.status = status;
        this.btn = btn;
    }

    public final int getSlno() {
        return this.slno;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getBtn() {
        return this.btn;
    }
}