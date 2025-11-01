package in.etuwa.app.data.model.lab;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabEquipment.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/lab/LabEquipment;", "", "facilityName", "", "type", "assetType", NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssetType", "()Ljava/lang/String;", "getFacilityName", "getStatus", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LabEquipment {

    @SerializedName("asset_type")
    @Expose
    private final String assetType;

    @SerializedName("facility_name")
    @Expose
    private final String facilityName;
    private final String status;
    private final String type;

    public static /* synthetic */ LabEquipment copy$default(LabEquipment labEquipment, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = labEquipment.facilityName;
        }
        if ((i & 2) != 0) {
            str2 = labEquipment.type;
        }
        if ((i & 4) != 0) {
            str3 = labEquipment.assetType;
        }
        if ((i & 8) != 0) {
            str4 = labEquipment.status;
        }
        return labEquipment.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFacilityName() {
        return this.facilityName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAssetType() {
        return this.assetType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final LabEquipment copy(String facilityName, String type, String assetType, String status) {
        Intrinsics.checkNotNullParameter(facilityName, "facilityName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        Intrinsics.checkNotNullParameter(status, "status");
        return new LabEquipment(facilityName, type, assetType, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabEquipment)) {
            return false;
        }
        LabEquipment labEquipment = (LabEquipment) other;
        return Intrinsics.areEqual(this.facilityName, labEquipment.facilityName) && Intrinsics.areEqual(this.type, labEquipment.type) && Intrinsics.areEqual(this.assetType, labEquipment.assetType) && Intrinsics.areEqual(this.status, labEquipment.status);
    }

    public int hashCode() {
        return (((((this.facilityName.hashCode() * 31) + this.type.hashCode()) * 31) + this.assetType.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "LabEquipment(facilityName=" + this.facilityName + ", type=" + this.type + ", assetType=" + this.assetType + ", status=" + this.status + ")";
    }

    public LabEquipment(String facilityName, String type, String assetType, String status) {
        Intrinsics.checkNotNullParameter(facilityName, "facilityName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        Intrinsics.checkNotNullParameter(status, "status");
        this.facilityName = facilityName;
        this.type = type;
        this.assetType = assetType;
        this.status = status;
    }

    public final String getFacilityName() {
        return this.facilityName;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAssetType() {
        return this.assetType;
    }

    public final String getStatus() {
        return this.status;
    }
}