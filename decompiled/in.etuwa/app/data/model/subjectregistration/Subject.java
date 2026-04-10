package in.etuwa.app.data.model.subjectregistration;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class Subject {
    private final String id;
    private final String name;
    private final String preference;
    private final String status;

    public static /* synthetic */ Subject copy$default(Subject subject, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subject.id;
        }
        if ((i & 2) != 0) {
            str2 = subject.name;
        }
        if ((i & 4) != 0) {
            str3 = subject.preference;
        }
        if ((i & 8) != 0) {
            str4 = subject.status;
        }
        return subject.copy(str, str2, str3, str4);
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
    public final String getPreference() {
        return this.preference;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final Subject copy(String id, String name, String preference, String status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(preference, "preference");
        Intrinsics.checkNotNullParameter(status, "status");
        return new Subject(id, name, preference, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subject)) {
            return false;
        }
        Subject subject = (Subject) other;
        return Intrinsics.areEqual(this.id, subject.id) && Intrinsics.areEqual(this.name, subject.name) && Intrinsics.areEqual(this.preference, subject.preference) && Intrinsics.areEqual(this.status, subject.status);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.preference.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "Subject(id=" + this.id + ", name=" + this.name + ", preference=" + this.preference + ", status=" + this.status + ")";
    }

    public Subject(String id, String name, String preference, String status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(preference, "preference");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.name = name;
        this.preference = preference;
        this.status = status;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPreference() {
        return this.preference;
    }

    public final String getStatus() {
        return this.status;
    }
}