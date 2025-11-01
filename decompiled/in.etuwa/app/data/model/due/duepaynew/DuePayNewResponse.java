package in.etuwa.app.data.model.due.duepaynew;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DuePayNewResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/due/duepaynew/DuePayNewResponse;", "", "collect", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/due/duepaynew/DuePayNew;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getCollect", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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