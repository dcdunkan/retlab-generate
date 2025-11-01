package in.etuwa.app.data.model.mess;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Mess.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/mess/Mess;", "", "day", "", FirebaseAnalytics.Param.ITEMS, "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/mess/MessMenu;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getDay", "()Ljava/lang/String;", "getItems", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
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