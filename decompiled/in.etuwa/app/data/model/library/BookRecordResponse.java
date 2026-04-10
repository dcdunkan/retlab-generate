package in.etuwa.app.data.model.library;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BookRecordResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class BookRecordResponse {
    private final ArrayList<BookRecord> book_record;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookRecordResponse copy$default(BookRecordResponse bookRecordResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bookRecordResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = bookRecordResponse.book_record;
        }
        return bookRecordResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<BookRecord> component2() {
        return this.book_record;
    }

    public final BookRecordResponse copy(boolean login, ArrayList<BookRecord> book_record) {
        Intrinsics.checkNotNullParameter(book_record, "book_record");
        return new BookRecordResponse(login, book_record);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookRecordResponse)) {
            return false;
        }
        BookRecordResponse bookRecordResponse = (BookRecordResponse) other;
        return this.login == bookRecordResponse.login && Intrinsics.areEqual(this.book_record, bookRecordResponse.book_record);
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
        return (r0 * 31) + this.book_record.hashCode();
    }

    public String toString() {
        return "BookRecordResponse(login=" + this.login + ", book_record=" + this.book_record + ")";
    }

    public BookRecordResponse(boolean z, ArrayList<BookRecord> book_record) {
        Intrinsics.checkNotNullParameter(book_record, "book_record");
        this.login = z;
        this.book_record = book_record;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<BookRecord> getBook_record() {
        return this.book_record;
    }
}