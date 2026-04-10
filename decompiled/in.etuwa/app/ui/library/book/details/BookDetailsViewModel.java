package in.etuwa.app.ui.library.book.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.library.BooksResponse;
import in.etuwa.app.data.repository.LibraryRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* JADX INFO: compiled from: BookDetailsViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class BookDetailsViewModel extends ViewModel implements KoinComponent {
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<BooksResponse>> libraryBookResponse;
    private final LibraryRepository libraryRepository;

    public BookDetailsViewModel(LibraryRepository libraryRepository) {
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        this.libraryRepository = libraryRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.libraryBookResponse = new MutableLiveData<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final void getBooksData() {
        this.libraryBookResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<BooksResponse> singleObserveOn = this.libraryRepository.getLibraryBooksApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<BooksResponse, Unit> function1 = new Function1<BooksResponse, Unit>() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsViewModel.getBooksData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BooksResponse booksResponse) {
                invoke2(booksResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BooksResponse booksResponse) {
                BookDetailsViewModel.this.libraryBookResponse.postValue(Resource.INSTANCE.success(booksResponse));
            }
        };
        Consumer<? super BooksResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookDetailsViewModel.getBooksData$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsViewModel.getBooksData.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BookDetailsViewModel.this.libraryBookResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookDetailsViewModel.getBooksData$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBooksData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBooksData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<BooksResponse>> getResponse() {
        return this.libraryBookResponse;
    }
}