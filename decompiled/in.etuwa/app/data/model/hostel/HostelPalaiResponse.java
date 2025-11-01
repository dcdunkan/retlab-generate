package in.etuwa.app.data.model.hostel;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPalaiResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/data/model/hostel/HostelPalaiResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/HostelPalaiMonth;", "Lkotlin/collections/ArrayList;", "date", "", "(ZLjava/util/ArrayList;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getHostel", "()Ljava/util/ArrayList;", "getLogin", "()Z", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HostelPalaiResponse {
    private final String date;
    private final ArrayList<HostelPalaiMonth> hostel;
    private final boolean login;

    public HostelPalaiResponse(boolean z, ArrayList<HostelPalaiMonth> hostel, String date) {
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(date, "date");
        this.login = z;
        this.hostel = hostel;
        this.date = date;
    }

    public final String getDate() {
        return this.date;
    }

    public final ArrayList<HostelPalaiMonth> getHostel() {
        return this.hostel;
    }

    public final boolean getLogin() {
        return this.login;
    }
}