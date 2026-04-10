package in.etuwa.app.data.model.mess;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Mess.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Mess {
    private final String day;
    private final ArrayList<MessMenu> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Mess copy$default(Mess mess, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mess.day;
        }
        if ((i & 2) != 0) {
            arrayList = mess.items;
        }
        return mess.copy(str, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    public final ArrayList<MessMenu> component2() {
        return this.items;
    }

    public final Mess copy(String day, ArrayList<MessMenu> items) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(items, "items");
        return new Mess(day, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mess)) {
            return false;
        }
        Mess mess = (Mess) other;
        return Intrinsics.areEqual(this.day, mess.day) && Intrinsics.areEqual(this.items, mess.items);
    }

    public int hashCode() {
        return (this.day.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        return "Mess(day=" + this.day + ", items=" + this.items + ")";
    }

    public Mess(String day, ArrayList<MessMenu> items) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(items, "items");
        this.day = day;
        this.items = items;
    }

    public final String getDay() {
        return this.day;
    }

    public final ArrayList<MessMenu> getItems() {
        return this.items;
    }
}