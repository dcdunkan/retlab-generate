package in.etuwa.app.data.model.placement;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Placement.kt */
/* loaded from: classes3.dex */
public final /* data */ class Placement {
    private boolean btn;
    private final String date;
    private final String description;
    private final String id;

    @SerializedName("last_date")
    @Expose
    private final String lastDate;
    private final String name;
    private String status;

    public static /* synthetic */ Placement copy$default(Placement placement, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = placement.id;
        }
        if ((i & 2) != 0) {
            str2 = placement.name;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = placement.description;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = placement.date;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = placement.lastDate;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = placement.status;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            z = placement.btn;
        }
        return placement.copy(str, str7, str8, str9, str10, str11, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLastDate() {
        return this.lastDate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getBtn() {
        return this.btn;
    }

    public final Placement copy(String id, String name, String description, String date, String lastDate, String status, boolean btn) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(status, "status");
        return new Placement(id, name, description, date, lastDate, status, btn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Placement)) {
            return false;
        }
        Placement placement = (Placement) other;
        return Intrinsics.areEqual(this.id, placement.id) && Intrinsics.areEqual(this.name, placement.name) && Intrinsics.areEqual(this.description, placement.description) && Intrinsics.areEqual(this.date, placement.date) && Intrinsics.areEqual(this.lastDate, placement.lastDate) && Intrinsics.areEqual(this.status, placement.status) && this.btn == placement.btn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.date.hashCode()) * 31) + this.lastDate.hashCode()) * 31) + this.status.hashCode()) * 31;
        boolean z = this.btn;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "Placement(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", date=" + this.date + ", lastDate=" + this.lastDate + ", status=" + this.status + ", btn=" + this.btn + ")";
    }

    public Placement(String id, String name, String description, String date, String lastDate, String status, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.lastDate = lastDate;
        this.status = status;
        this.btn = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getLastDate() {
        return this.lastDate;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final boolean getBtn() {
        return this.btn;
    }

    public final void setBtn(boolean z) {
        this.btn = z;
    }
}