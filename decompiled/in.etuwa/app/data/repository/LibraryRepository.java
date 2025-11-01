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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/data/repository/LibraryRepository;", "Lorg/koin/core/component/KoinComponent;", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getLibraryBookRecordApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/library/BookRecordResponse;", "getLibraryBooksApiCall", "Lin/etuwa/app/data/model/library/BooksResponse;", "suggestBookApiCall", "Lin/etuwa/app/data/model/SuccessResponse;", "studentDetails", "", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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