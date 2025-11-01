package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewMonthlyResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/data/model/hostelnew/HostelNewMonthlyResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostelnew/HostelNewMonthly;", "Lkotlin/collections/ArrayList;", "fine", "", "date", "(ZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getFine", "getHostel", "()Ljava/util/ArrayList;", "getLogin", "()Z", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HostelNewMonthlyResponse {
    private final String date;
    private final String fine;
    private final ArrayList<HostelNewMonthly> hostel;
    private final boolean login;

    public HostelNewMonthlyResponse(boolean z, ArrayList<HostelNewMonthly> hostel, String fine, String date) {
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(date, "date");
        this.login = z;
        this.hostel = hostel;
        this.fine = fine;
        this.date = date;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelNewMonthly> getHostel() {
        return this.hostel;
    }

    public final String getFine() {
        return this.fine;
    }

    public final String getDate() {
        return this.date;
    }
}