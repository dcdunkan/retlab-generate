package in.etuwa.app.data.model.due.duepaynew;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DuePayNewResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class DuePayNewResponse {
    private final ArrayList<DuePayNew> collect;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DuePayNewResponse copy$default(DuePayNewResponse duePayNewResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = duePayNewResponse.collect;
        }
        return duePayNewResponse.copy(arrayList);
    }

    public final ArrayList<DuePayNew> component1() {
        return this.collect;
    }

    public final DuePayNewResponse copy(ArrayList<DuePayNew> collect) {
        Intrinsics.checkNotNullParameter(collect, "collect");
        return new DuePayNewResponse(collect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DuePayNewResponse) && Intrinsics.areEqual(this.collect, ((DuePayNewResponse) other).collect);
    }

    public int hashCode() {
        return this.collect.hashCode();
    }

    public String toString() {
        return "DuePayNewResponse(collect=" + this.collect + ")";
    }

    public DuePayNewResponse(ArrayList<DuePayNew> collect) {
        Intrinsics.checkNotNullParameter(collect, "collect");
        this.collect = collect;
    }

    public final ArrayList<DuePayNew> getCollect() {
        return this.collect;
    }
}