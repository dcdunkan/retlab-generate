package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.library.BookRecordResponse;
import in.etuwa.app.data.model.library.BooksResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* compiled from: LibraryRepository.kt */
/* loaded from: classes3.dex */
public final class LibraryRepository implements KoinComponent {
    private final ApiHelper apiHelper;

    public LibraryRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final Single<BooksResponse> getLibraryBooksApiCall() {
        return this.apiHelper.getLibraryBooksApiCall();
    }

    public final Single<BookRecordResponse> getLibraryBookRecordApiCall() {
        return this.apiHelper.getLibraryBookRecordApiCall();
    }

    public final Single<SuccessResponse> suggestBookApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return this.apiHelper.suggestBookApiCall(studentDetails);
    }
}