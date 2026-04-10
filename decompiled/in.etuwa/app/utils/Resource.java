package in.etuwa.app.utils;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Resource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class Resource<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T data;
    private final String message;
    private final Status status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Resource copy$default(Resource resource, Status status, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            status = resource.status;
        }
        if ((i & 2) != 0) {
            obj = resource.data;
        }
        if ((i & 4) != 0) {
            str = resource.message;
        }
        return resource.copy(status, obj, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final T component2() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Resource<T> copy(Status status, T data, String message) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new Resource<>(status, data, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Resource)) {
            return false;
        }
        Resource resource = (Resource) other;
        return this.status == resource.status && Intrinsics.areEqual(this.data, resource.data) && Intrinsics.areEqual(this.message, resource.message);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        T t = this.data;
        int iHashCode2 = (iHashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.message;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Resource(status=" + this.status + ", data=" + this.data + ", message=" + this.message + ")";
    }

    public Resource(Status status, T t, String str) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.data = t;
        this.message = str;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Status getStatus() {
        return this.status;
    }

    /* JADX INFO: compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J!\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\fJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\f¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/utils/Resource$Companion;", "", "()V", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lin/etuwa/app/utils/Resource;", "T", NotificationCompat.CATEGORY_MESSAGE, "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "(Ljava/lang/String;Ljava/lang/Object;)Lin/etuwa/app/utils/Resource;", "exception", "exceptionData", "(Ljava/lang/Object;)Lin/etuwa/app/utils/Resource;", "loading", "success", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Resource<T> success(T data) {
            return new Resource<>(Status.SUCCESS, data, null);
        }

        public final <T> Resource<T> error(String msg, T data) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return new Resource<>(Status.ERROR, data, msg);
        }

        public final <T> Resource<T> loading(T data) {
            return new Resource<>(Status.LOADING, data, null);
        }

        public final <T> Resource<T> exception(String msg) {
            return new Resource<>(Status.EXCEPTION, null, msg);
        }

        public final <T> Resource<T> exceptionData(T data) {
            return new Resource<>(Status.EXCEPTION, data, null);
        }
    }
}