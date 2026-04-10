package in.etuwa.app.data.model.counselling.status;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CounsellingStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CounsellingStatus {
    private final String id;
    private final String name;

    public CounsellingStatus(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}