package in.etuwa.app.data.model.library;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Books.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Books {
    private final String author;
    private final String bookid;
    private final String category;
    private final String distribution;
    private final String edition;
    private final String isbn;
    private final String location;
    private final String name;
    private final String slno;
    private final String status;
    private final String title;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIsbn() {
        return this.isbn;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDistribution() {
        return this.distribution;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSlno() {
        return this.slno;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBookid() {
        return this.bookid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getEdition() {
        return this.edition;
    }

    public final Books copy(String name, String slno, String bookid, String author, String title, String category, String location, String status, String edition, String isbn, String distribution) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(slno, "slno");
        Intrinsics.checkNotNullParameter(bookid, "bookid");
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(edition, "edition");
        Intrinsics.checkNotNullParameter(isbn, "isbn");
        Intrinsics.checkNotNullParameter(distribution, "distribution");
        return new Books(name, slno, bookid, author, title, category, location, status, edition, isbn, distribution);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Books)) {
            return false;
        }
        Books books = (Books) other;
        return Intrinsics.areEqual(this.name, books.name) && Intrinsics.areEqual(this.slno, books.slno) && Intrinsics.areEqual(this.bookid, books.bookid) && Intrinsics.areEqual(this.author, books.author) && Intrinsics.areEqual(this.title, books.title) && Intrinsics.areEqual(this.category, books.category) && Intrinsics.areEqual(this.location, books.location) && Intrinsics.areEqual(this.status, books.status) && Intrinsics.areEqual(this.edition, books.edition) && Intrinsics.areEqual(this.isbn, books.isbn) && Intrinsics.areEqual(this.distribution, books.distribution);
    }

    public int hashCode() {
        return (((((((((((((((((((this.name.hashCode() * 31) + this.slno.hashCode()) * 31) + this.bookid.hashCode()) * 31) + this.author.hashCode()) * 31) + this.title.hashCode()) * 31) + this.category.hashCode()) * 31) + this.location.hashCode()) * 31) + this.status.hashCode()) * 31) + this.edition.hashCode()) * 31) + this.isbn.hashCode()) * 31) + this.distribution.hashCode();
    }

    public String toString() {
        return "Books(name=" + this.name + ", slno=" + this.slno + ", bookid=" + this.bookid + ", author=" + this.author + ", title=" + this.title + ", category=" + this.category + ", location=" + this.location + ", status=" + this.status + ", edition=" + this.edition + ", isbn=" + this.isbn + ", distribution=" + this.distribution + ")";
    }

    public Books(String name, String slno, String bookid, String author, String title, String category, String location, String status, String edition, String isbn, String distribution) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(slno, "slno");
        Intrinsics.checkNotNullParameter(bookid, "bookid");
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(edition, "edition");
        Intrinsics.checkNotNullParameter(isbn, "isbn");
        Intrinsics.checkNotNullParameter(distribution, "distribution");
        this.name = name;
        this.slno = slno;
        this.bookid = bookid;
        this.author = author;
        this.title = title;
        this.category = category;
        this.location = location;
        this.status = status;
        this.edition = edition;
        this.isbn = isbn;
        this.distribution = distribution;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSlno() {
        return this.slno;
    }

    public final String getBookid() {
        return this.bookid;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getEdition() {
        return this.edition;
    }

    public final String getIsbn() {
        return this.isbn;
    }

    public final String getDistribution() {
        return this.distribution;
    }
}