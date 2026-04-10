package in.etuwa.app.data.model.lab;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabEquipment.kt */
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