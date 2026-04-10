package in.etuwa.app.ui.exam.series;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.exam.SeriesExamResponse;
import in.etuwa.app.data.repository.ExamRepository;
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

/* compiled from: SeriesExamViewModel.kt */
/* loaded from: classes4.dex */
public final class SeriesExamViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SuccessResponse>> deleteResponse;
    private final ExamRepository examRepository;
    private MutableLiveData<Resource<SeriesExamResponse>> examResponse;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;

    public SeriesExamViewModel(ExamRepository examRepository) {
        Intrinsics.checkNotNullParameter(examRepository, "examRepository");
        this.examRepository = examRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.examResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        this.deleteResponse = new MutableLiveData<>();
        getSemester();
    }

    public final MutableLiveData<Resource<SuccessResponse>> getDeleteResponse() {
        return this.deleteResponse;
    }

    public final void setDeleteResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.deleteResponse = mutableLiveData;
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> observeOn = this.examRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$getSemester$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Semester> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<Semester> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SeriesExamViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesExamViewModel.getSemester$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$getSemester$2
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
                mutableLiveData = SeriesExamViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesExamViewModel.getSemester$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemResponse() {
        return this.semResponse;
    }

    public final void getExams(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.examResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SeriesExamResponse> observeOn = this.examRepository.getSeriesExamApiCall(new AttendanceRequest(id)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SeriesExamResponse, Unit> function1 = new Function1<SeriesExamResponse, Unit>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$getExams$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SeriesExamResponse seriesExamResponse) {
                invoke2(seriesExamResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SeriesExamResponse seriesExamResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SeriesExamViewModel.this.examResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(seriesExamResponse));
            }
        };
        Consumer<? super SeriesExamResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesExamViewModel.getExams$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$getExams$2
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
                mutableLiveData = SeriesExamViewModel.this.examResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesExamViewModel.getExams$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExams$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExams$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SeriesExamResponse>> getResponse() {
        return this.examResponse;
    }

    public final void deleteExam(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.deleteResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.examRepository.deleteSeriesExamApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$deleteExam$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                SeriesExamViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesExamViewModel.deleteExam$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$deleteExam$2
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
                SeriesExamViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesExamViewModel.deleteExam$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteExam$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteExam$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}