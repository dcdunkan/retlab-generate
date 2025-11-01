package in.etuwa.app.data.model.library;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Books.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, d2 = {"Lin/etuwa/app/data/model/library/Books;", "", "name", "", "slno", "bookid", "author", "title", "category", FirebaseAnalytics.Param.LOCATION, NotificationCompat.CATEGORY_STATUS, "edition", "isbn", "distribution", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getBookid", "getCategory", "getDistribution", "getEdition", "getIsbn", "getLocation", "getName", "getSlno", "getStatus", "getTitle", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getIsbn() {
        return this.isbn;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDistribution() {
        return this.distribution;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSlno() {
        return this.slno;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBookid() {
        return this.bookid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component7, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component8, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
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