package in.etuwa.app.data.model.grievance.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Actions.kt */
/* loaded from: classes3.dex */
public final /* data */ class Actions implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("action_taken")
    private final String actionTaken;
    private final String date;
    private final String level;

    public static /* synthetic */ Actions copy$default(Actions actions, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actions.level;
        }
        if ((i & 2) != 0) {
            str2 = actions.actionTaken;
        }
        if ((i & 4) != 0) {
            str3 = actions.date;
        }
        return actions.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* renamed from: component2, reason: from getter */
    public final String getActionTaken() {
        return this.actionTaken;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final Actions copy(String level, String actionTaken, String date) {
        return new Actions(level, actionTaken, date);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Actions)) {
            return false;
        }
        Actions actions = (Actions) other;
        return Intrinsics.areEqual(this.level, actions.level) && Intrinsics.areEqual(this.actionTaken, actions.actionTaken) && Intrinsics.areEqual(this.date, actions.date);
    }

    public int hashCode() {
        String str = this.level;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.actionTaken;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.date;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Actions(level=" + this.level + ", actionTaken=" + this.actionTaken + ", date=" + this.date + ")";
    }

    public Actions(String str, String str2, String str3) {
        this.level = str;
        this.actionTaken = str2;
        this.date = str3;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getActionTaken() {
        return this.actionTaken;
    }

    public final String getDate() {
        return this.date;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Actions(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.level);
        parcel.writeString(this.actionTaken);
        parcel.writeString(this.date);
    }

    /* compiled from: Actions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/grievance/view/Actions$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/grievance/view/Actions;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/grievance/view/Actions;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.grievance.view.Actions$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<Actions> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Actions createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Actions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Actions[] newArray(int size) {
            return new Actions[size];
        }
    }
}