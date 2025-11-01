package in.etuwa.app.data.model.profileasiet.publication;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Publication.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/publication/Publication;", "", "id", "", "title", "journal", "conference", "year", FirebaseAnalytics.Param.INDEX, "file", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConference", "()Ljava/lang/String;", "getFile", "getId", "getIndex", "getJournal", "getTitle", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Publication {
    private final String conference;
    private final String file;
    private final String id;
    private final String index;
    private final String journal;
    private final String title;
    private final String year;

    public static /* synthetic */ Publication copy$default(Publication publication, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publication.id;
        }
        if ((i & 2) != 0) {
            str2 = publication.title;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = publication.journal;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = publication.conference;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = publication.year;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = publication.index;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = publication.file;
        }
        return publication.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getJournal() {
        return this.journal;
    }

    /* renamed from: component4, reason: from getter */
    public final String getConference() {
        return this.conference;
    }

    /* renamed from: component5, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIndex() {
        return this.index;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    public final Publication copy(String id, String title, String journal, String conference, String year, String index, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(file, "file");
        return new Publication(id, title, journal, conference, year, index, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Publication)) {
            return false;
        }
        Publication publication = (Publication) other;
        return Intrinsics.areEqual(this.id, publication.id) && Intrinsics.areEqual(this.title, publication.title) && Intrinsics.areEqual(this.journal, publication.journal) && Intrinsics.areEqual(this.conference, publication.conference) && Intrinsics.areEqual(this.year, publication.year) && Intrinsics.areEqual(this.index, publication.index) && Intrinsics.areEqual(this.file, publication.file);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.journal.hashCode()) * 31) + this.conference.hashCode()) * 31) + this.year.hashCode()) * 31) + this.index.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "Publication(id=" + this.id + ", title=" + this.title + ", journal=" + this.journal + ", conference=" + this.conference + ", year=" + this.year + ", index=" + this.index + ", file=" + this.file + ")";
    }

    public Publication(String id, String title, String journal, String conference, String year, String index, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.title = title;
        this.journal = journal;
        this.conference = conference;
        this.year = year;
        this.index = index;
        this.file = file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getJournal() {
        return this.journal;
    }

    public final String getConference() {
        return this.conference;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getFile() {
        return this.file;
    }
}