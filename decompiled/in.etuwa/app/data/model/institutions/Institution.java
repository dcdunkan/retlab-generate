package in.etuwa.app.data.model.institutions;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Institution.kt */
/* loaded from: classes3.dex */
public final /* data */ class Institution {
    private final ArrayList<Colleges> colleges;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Institution copy$default(Institution institution, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = institution.colleges;
        }
        return institution.copy(arrayList);
    }

    public final ArrayList<Colleges> component1() {
        return this.colleges;
    }

    public final Institution copy(ArrayList<Colleges> colleges) {
        Intrinsics.checkNotNullParameter(colleges, "colleges");
        return new Institution(colleges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Institution) && Intrinsics.areEqual(this.colleges, ((Institution) other).colleges);
    }

    public int hashCode() {
        return this.colleges.hashCode();
    }

    public String toString() {
        return "Institution(colleges=" + this.colleges + ")";
    }

    public Institution(ArrayList<Colleges> colleges) {
        Intrinsics.checkNotNullParameter(colleges, "colleges");
        this.colleges = colleges;
    }

    public final ArrayList<Colleges> getColleges() {
        return this.colleges;
    }
}