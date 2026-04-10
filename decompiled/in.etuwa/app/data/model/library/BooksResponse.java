package in.etuwa.app.data.model.library;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BooksResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class BooksResponse {
    private final ArrayList<Books> books;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BooksResponse copy$default(BooksResponse booksResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = booksResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = booksResponse.books;
        }
        return booksResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Books> component2() {
        return this.books;
    }

    public final BooksResponse copy(boolean login, ArrayList<Books> books) {
        Intrinsics.checkNotNullParameter(books, "books");
        return new BooksResponse(login, books);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BooksResponse)) {
            return false;
        }
        BooksResponse booksResponse = (BooksResponse) other;
        return this.login == booksResponse.login && Intrinsics.areEqual(this.books, booksResponse.books);
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
        return (r0 * 31) + this.books.hashCode();
    }

    public String toString() {
        return "BooksResponse(login=" + this.login + ", books=" + this.books + ")";
    }

    public BooksResponse(boolean z, ArrayList<Books> books) {
        Intrinsics.checkNotNullParameter(books, "books");
        this.login = z;
        this.books = books;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Books> getBooks() {
        return this.books;
    }
}