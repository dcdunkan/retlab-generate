package in.etuwa.app.data.model.hostel.attendance;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelAttView.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelAttView {
    private final boolean btn_already_exit;
    private final boolean btn_del;
    private final boolean btn_download;
    private final boolean btn_exit;
    private final String date;
    private final String id;
    private final String reason;
    private final String status;
    private final String type;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
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
    public final boolean getBtn_exit() {
        return this.btn_exit;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getBtn_already_exit() {
        return this.btn_already_exit;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getBtn_download() {
        return this.btn_download;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getBtn_del() {
        return this.btn_del;
    }

    public final HostelAttView copy(String id, String type, String date, String status, String reason, boolean btn_exit, boolean btn_already_exit, boolean btn_download, boolean btn_del, String url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(url, "url");
        return new HostelAttView(id, type, date, status, reason, btn_exit, btn_already_exit, btn_download, btn_del, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelAttView)) {
            return false;
        }
        HostelAttView hostelAttView = (HostelAttView) other;
        return Intrinsics.areEqual(this.id, hostelAttView.id) && Intrinsics.areEqual(this.type, hostelAttView.type) && Intrinsics.areEqual(this.date, hostelAttView.date) && Intrinsics.areEqual(this.status, hostelAttView.status) && Intrinsics.areEqual(this.reason, hostelAttView.reason) && this.btn_exit == hostelAttView.btn_exit && this.btn_already_exit == hostelAttView.btn_already_exit && this.btn_download == hostelAttView.btn_download && this.btn_del == hostelAttView.btn_del && Intrinsics.areEqual(this.url, hostelAttView.url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.reason.hashCode()) * 31;
        boolean z = this.btn_exit;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.btn_already_exit;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.btn_download;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z4 = this.btn_del;
        return ((i6 + (z4 ? 1 : z4 ? 1 : 0)) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "HostelAttView(id=" + this.id + ", type=" + this.type + ", date=" + this.date + ", status=" + this.status + ", reason=" + this.reason + ", btn_exit=" + this.btn_exit + ", btn_already_exit=" + this.btn_already_exit + ", btn_download=" + this.btn_download + ", btn_del=" + this.btn_del + ", url=" + this.url + ")";
    }

    public HostelAttView(String id, String type, String date, String status, String reason, boolean z, boolean z2, boolean z3, boolean z4, String url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.type = type;
        this.date = date;
        this.status = status;
        this.reason = reason;
        this.btn_exit = z;
        this.btn_already_exit = z2;
        this.btn_download = z3;
        this.btn_del = z4;
        this.url = url;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getReason() {
        return this.reason;
    }

    public final boolean getBtn_exit() {
        return this.btn_exit;
    }

    public final boolean getBtn_already_exit() {
        return this.btn_already_exit;
    }

    public final boolean getBtn_download() {
        return this.btn_download;
    }

    public final boolean getBtn_del() {
        return this.btn_del;
    }

    public final String getUrl() {
        return this.url;
    }
}