package in.etuwa.app.data.model.profileasiet.publication;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PublicationResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class PublicationResponse {
    private final boolean login;
    private final ArrayList<Publication> publications;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PublicationResponse copy$default(PublicationResponse publicationResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = publicationResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = publicationResponse.publications;
        }
        return publicationResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Publication> component2() {
        return this.publications;
    }

    public final PublicationResponse copy(boolean login, ArrayList<Publication> publications) {
        Intrinsics.checkNotNullParameter(publications, "publications");
        return new PublicationResponse(login, publications);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicationResponse)) {
            return false;
        }
        PublicationResponse publicationResponse = (PublicationResponse) other;
        return this.login == publicationResponse.login && Intrinsics.areEqual(this.publications, publicationResponse.publications);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.publications.hashCode();
    }

    public String toString() {
        return "PublicationResponse(login=" + this.login + ", publications=" + this.publications + ")";
    }

    public PublicationResponse(boolean z, ArrayList<Publication> publications) {
        Intrinsics.checkNotNullParameter(publications, "publications");
        this.login = z;
        this.publications = publications;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Publication> getPublications() {
        return this.publications;
    }
}