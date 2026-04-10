package in.etuwa.app.data.model.hostel.attendance;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelAttParentView.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelAttParentView {
    private final String btn_app;
    private final String btn_rej;
    private final String btn_rev;
    private final String from_date;
    private final String id;
    private final String reason;
    private final String status;
    private final String type;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFrom_date() {
        return this.from_date;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBtn_app() {
        return this.btn_app;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBtn_rej() {
        return this.btn_rej;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBtn_rev() {
        return this.btn_rev;
    }

    public final HostelAttParentView copy(String id, String type, String from_date, String status, String reason, String btn_app, String btn_rej, String btn_rev) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(btn_app, "btn_app");
        Intrinsics.checkNotNullParameter(btn_rej, "btn_rej");
        Intrinsics.checkNotNullParameter(btn_rev, "btn_rev");
        return new HostelAttParentView(id, type, from_date, status, reason, btn_app, btn_rej, btn_rev);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelAttParentView)) {
            return false;
        }
        HostelAttParentView hostelAttParentView = (HostelAttParentView) other;
        return Intrinsics.areEqual(this.id, hostelAttParentView.id) && Intrinsics.areEqual(this.type, hostelAttParentView.type) && Intrinsics.areEqual(this.from_date, hostelAttParentView.from_date) && Intrinsics.areEqual(this.status, hostelAttParentView.status) && Intrinsics.areEqual(this.reason, hostelAttParentView.reason) && Intrinsics.areEqual(this.btn_app, hostelAttParentView.btn_app) && Intrinsics.areEqual(this.btn_rej, hostelAttParentView.btn_rej) && Intrinsics.areEqual(this.btn_rev, hostelAttParentView.btn_rev);
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.from_date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.reason.hashCode()) * 31) + this.btn_app.hashCode()) * 31) + this.btn_rej.hashCode()) * 31) + this.btn_rev.hashCode();
    }

    public String toString() {
        return "HostelAttParentView(id=" + this.id + ", type=" + this.type + ", from_date=" + this.from_date + ", status=" + this.status + ", reason=" + this.reason + ", btn_app=" + this.btn_app + ", btn_rej=" + this.btn_rej + ", btn_rev=" + this.btn_rev + ")";
    }

    public HostelAttParentView(String id, String type, String from_date, String status, String reason, String btn_app, String btn_rej, String btn_rev) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(btn_app, "btn_app");
        Intrinsics.checkNotNullParameter(btn_rej, "btn_rej");
        Intrinsics.checkNotNullParameter(btn_rev, "btn_rev");
        this.id = id;
        this.type = type;
        this.from_date = from_date;
        this.status = status;
        this.reason = reason;
        this.btn_app = btn_app;
        this.btn_rej = btn_rej;
        this.btn_rev = btn_rev;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getFrom_date() {
        return this.from_date;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getBtn_app() {
        return this.btn_app;
    }

    public final String getBtn_rej() {
        return this.btn_rej;
    }

    public final String getBtn_rev() {
        return this.btn_rev;
    }
}