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

/* compiled from: ChangeInTimetableViewModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010\u000f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\t0\bJ\b\u0010\u0010\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/timetable/change/ChangeInTimetableViewModel;", "Landroidx/lifecycle/ViewModel;", "timeTableRepository", "Lin/etuwa/app/data/repository/TimeTableRepository;", "(Lin/etuwa/app/data/repository/TimeTableRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "timetableResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/timetable/change/ChangeTimeTableResponse;", "Lkotlin/collections/ArrayList;", "getChangeInTimetable", "", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChangeInTimetableViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final TimeTableRepository timeTableRepository;
    private MutableLiveData<Resource<ArrayList<ChangeTimeTableResponse>>> timetableResponse;

    public ChangeInTimetableViewModel(TimeTableRepository timeTableRepository) {
        Intrinsics.checkNotNullParameter(timeTableRepository, "timeTableRepository");
        this.timeTableRepository = timeTableRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.timetableResponse = new MutableLiveData<>();
        getChangeInTimetable();
    }

    private final void getChangeInTimetable() {
        this.timetableResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<ChangeTimeTableResponse>> observeOn = this.timeTableRepository.getChangeInTimetableApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<ChangeTimeTableResponse>, Unit> function1 = new Function1<ArrayList<ChangeTimeTableResponse>, Unit>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel$getChangeInTimetable$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<ChangeTimeTableResponse> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<ChangeTimeTableResponse> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChangeInTimetableViewModel.this.timetableResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<ChangeTimeTableResponse>> consumer = new Consumer() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChangeInTimetableViewModel.getChangeInTimetable$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel$getChangeInTimetable$2
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
                mutableLiveData = ChangeInTimetableViewModel.this.timetableResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChangeInTimetableViewModel.getChangeInTimetable$lambda$1(Function1.this, obj);
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