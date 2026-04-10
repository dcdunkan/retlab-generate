package in.etuwa.app.ui.timetable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.timetable.TimetableResponse;
import in.etuwa.app.data.repository.TimeTableRepository;
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

/* compiled from: TimeTableViewModel.kt */
/* loaded from: classes5.dex */
public final class TimeTableViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final TimeTableRepository timeTableRepository;
    private MutableLiveData<Resource<TimetableResponse>> timetableResponse;

    public TimeTableViewModel(TimeTableRepository timeTableRepository) {
        Intrinsics.checkNotNullParameter(timeTableRepository, "timeTableRepository");
        this.timeTableRepository = timeTableRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.timetableResponse = new MutableLiveData<>();
        getTimetable();
    }

    private final void getTimetable() {
        this.timetableResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TimetableResponse> observeOn = this.timeTableRepository.getTimetableApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TimetableResponse, Unit> function1 = new Function1<TimetableResponse, Unit>() { // from class: in.etuwa.app.ui.timetable.TimeTableViewModel$getTimetable$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TimetableResponse timetableResponse) {
                invoke2(timetableResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TimetableResponse timetableResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TimeTableViewModel.this.timetableResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(timetableResponse));
            }
        };
        Consumer<? super TimetableResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.timetable.TimeTableViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TimeTableViewModel.getTimetable$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.timetable.TimeTableViewModel$getTimetable$2
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
                mutableLiveData = TimeTableViewModel.this.timetableResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.timetable.TimeTableViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TimeTableViewModel.getTimetable$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTimetable$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTimetable$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TimetableResponse>> getResponse() {
        return this.timetableResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}