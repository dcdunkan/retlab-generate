package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelNewMonthlyResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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