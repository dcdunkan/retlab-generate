package in.etuwa.app.ui.timetable.change;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.timetable.change.ChangeTimeTableResponse;
import in.etuwa.app.data.repository.TimeTableRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChangeInTimetableViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ChangeInTimetableViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private boolean isDataLoaded;
    private final TimeTableRepository timeTableRepository;
    private MutableLiveData<Resource<ArrayList<ChangeTimeTableResponse>>> timetableResponse;

    public ChangeInTimetableViewModel(TimeTableRepository timeTableRepository) {
        Intrinsics.checkNotNullParameter(timeTableRepository, "timeTableRepository");
        this.timeTableRepository = timeTableRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.timetableResponse = new MutableLiveData<>();
        loadDataIfNeeded();
    }

    public final void loadDataIfNeeded() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        getChangeInTimetable();
    }

    private final void getChangeInTimetable() {
        this.timetableResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<ChangeTimeTableResponse>> singleObserveOn = this.timeTableRepository.getChangeInTimetableApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<ChangeTimeTableResponse>, Unit> function1 = new Function1<ArrayList<ChangeTimeTableResponse>, Unit>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel.getChangeInTimetable.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<ChangeTimeTableResponse> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<ChangeTimeTableResponse> arrayList) {
                ChangeInTimetableViewModel.this.timetableResponse.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<ChangeTimeTableResponse>> consumer = new Consumer() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChangeInTimetableViewModel.getChangeInTimetable$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel.getChangeInTimetable.2
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
                ChangeInTimetableViewModel.this.timetableResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChangeInTimetableViewModel.getChangeInTimetable$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChangeInTimetable$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChangeInTimetable$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<ChangeTimeTableResponse>>> getResponse() {
        return this.timetableResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}