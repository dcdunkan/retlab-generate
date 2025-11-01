package in.etuwa.app.data.model.survey.courseevaluation;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DoCourseSurvey.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/data/model/survey/courseevaluation/DoCourseSurvey;", "", "slno", "", "name", "", "id", NotificationCompat.CATEGORY_STATUS, FullDayDialogKt.ARG_BTN, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBtn", "()Ljava/lang/String;", "getId", "getName", "getSlno", "()I", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final int getSlno() {
        return this.slno;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
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