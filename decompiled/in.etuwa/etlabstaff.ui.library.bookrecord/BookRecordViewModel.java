package in.etuwa.etlabstaff.ui.library.bookrecord;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.library.BookRecordResponse;
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

/* compiled from: BookRecordViewModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/component/KoinComponent;", "libraryRepository", "Lin/etuwa/app/data/repository/LibraryRepository;", "(Lin/etuwa/app/data/repository/LibraryRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "libraryBookResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/library/BookRecordResponse;", "getBooksData", "", "getResponse", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BookRecordViewModel extends ViewModel implements KoinComponent {
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<BookRecordResponse>> libraryBookResponse;
    private final LibraryRepository libraryRepository;

    public BookRecordViewModel(LibraryRepository libraryRepository) {
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
        Single<BookRecordResponse> observeOn = this.libraryRepository.getLibraryBookRecordApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<BookRecordResponse, Unit> function1 = new Function1<BookRecordResponse, Unit>() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordViewModel$getBooksData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BookRecordResponse bookRecordResponse) {
                invoke2(bookRecordResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BookRecordResponse bookRecordResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = BookRecordViewModel.this.libraryBookResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(bookRecordResponse));
            }
        };
        Consumer<? super BookRecordResponse> consumer = new Consumer() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookRecordViewModel.getBooksData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordViewModel$getBooksData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                mutableLiveData = BookRecordViewModel.this.libraryBookResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookRecordViewModel.getBooksData$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<BookRecordResponse>> getResponse() {
        return this.libraryBookResponse;
    }
}