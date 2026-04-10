package in.etuwa.app.data.model.hostel;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelPalaiResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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