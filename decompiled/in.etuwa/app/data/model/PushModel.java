package in.etuwa.app.data.model;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PushModel {
    private final int id;
    private final String msg;
    private final String time;
    private final String title;

    public PushModel(int i, String title, String msg, String time) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(time, "time");
        this.id = i;
        this.title = title;
        this.msg = msg;
        this.time = time;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }
}