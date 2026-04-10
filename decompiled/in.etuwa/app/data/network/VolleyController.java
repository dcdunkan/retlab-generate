package in.etuwa.app.data.network;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VolleyController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VolleyController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile VolleyController INSTANCE;
    private final RequestQueue requestQueue;

    public /* synthetic */ VolleyController(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private VolleyController(Context context) {
        RequestQueue requestQueueNewRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(requestQueueNewRequestQueue, "newRequestQueue(context.applicationContext)");
        this.requestQueue = requestQueueNewRequestQueue;
    }

    public final <T> void addToRequestQueue(Request<T> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.requestQueue.add(request);
    }

    /* JADX INFO: compiled from: VolleyController.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lin/etuwa/app/data/network/VolleyController$Companion;", "", "()V", "INSTANCE", "Lin/etuwa/app/data/network/VolleyController;", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VolleyController getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            VolleyController volleyController = VolleyController.INSTANCE;
            if (volleyController == null) {
                synchronized (this) {
                    volleyController = VolleyController.INSTANCE;
                    if (volleyController == null) {
                        volleyController = new VolleyController(context, null);
                        Companion companion = VolleyController.INSTANCE;
                        VolleyController.INSTANCE = volleyController;
                    }
                }
            }
            return volleyController;
        }
    }
}