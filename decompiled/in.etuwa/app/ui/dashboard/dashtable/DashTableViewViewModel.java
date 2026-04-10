package in.etuwa.app.ui.dashboard.dashtable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.repository.DashRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* JADX INFO: compiled from: DashTableViewViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashTableViewViewModel extends ViewModel implements KoinComponent {
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<TimeTableMonthlyNewResponse>> dailyTimeTableResponse;
    private final DashRepository homeRepository;

    public DashTableViewViewModel(DashRepository homeRepository) {
        Intrinsics.checkNotNullParameter(homeRepository, "homeRepository");
        this.homeRepository = homeRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.dailyTimeTableResponse = new MutableLiveData<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final void getDailyTimeTableData(String date) {
        Single<TimeTableMonthlyNewResponse> singleSubscribeOn;
        Single<TimeTableMonthlyNewResponse> singleObserveOn;
        Intrinsics.checkNotNullParameter(date, "date");
        this.dailyTimeTableResponse.postValue(Resource.INSTANCE.loading(null));
        Single<TimeTableMonthlyNewResponse> timeTableMonthlyApiCall = this.homeRepository.getTimeTableMonthlyApiCall(date);
        if (timeTableMonthlyApiCall == null || (singleSubscribeOn = timeTableMonthlyApiCall.subscribeOn(Schedulers.io())) == null || (singleObserveOn = singleSubscribeOn.observeOn(AndroidSchedulers.mainThread())) == null) {
            return;
        }
        final Function1<TimeTableMonthlyNewResponse, Unit> function1 = new Function1<TimeTableMonthlyNewResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewViewModel$getDailyTimeTableData$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TimeTableMonthlyNewResponse timeTableMonthlyNewResponse) {
                invoke2(timeTableMonthlyNewResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TimeTableMonthlyNewResponse timeTableMonthlyNewResponse) {
                this.this$0.dailyTimeTableResponse.postValue(Resource.INSTANCE.success(timeTableMonthlyNewResponse));
            }
        };
        Consumer<? super TimeTableMonthlyNewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashTableViewViewModel.getDailyTimeTableData$lambda$3$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewViewModel$getDailyTimeTableData$1$2
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
                this.this$0.dailyTimeTableResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        Disposable disposableSubscribe = singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.dashtable.DashTableViewViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashTableViewViewModel.getDailyTimeTableData$lambda$3$lambda$1(function12, obj);
            }
        });
        if (disposableSubscribe != null) {
            this.compositeDisposable.add(disposableSubscribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDailyTimeTableData$lambda$3$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDailyTimeTableData$lambda$3$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TimeTableMonthlyNewResponse>> getDailyTimeTableResponse() {
        return this.dailyTimeTableResponse;
    }
}