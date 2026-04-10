package in.etuwa.app.ui.survey.coursesurvey.subjects;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.survey.courseevaluation.DoCourseSurveyResponse;
import in.etuwa.app.data.repository.SurveyRepository;
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

/* JADX INFO: compiled from: CourseSurveySubjectsViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class CourseSurveySubjectsViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final SurveyRepository surveyRepository;
    private MutableLiveData<Resource<DoCourseSurveyResponse>> surveyResponse;

    public CourseSurveySubjectsViewModel(SurveyRepository surveyRepository) {
        Intrinsics.checkNotNullParameter(surveyRepository, "surveyRepository");
        this.surveyRepository = surveyRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.surveyResponse = new MutableLiveData<>();
    }

    public final void getSurveySubjectsList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.surveyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DoCourseSurveyResponse> singleObserveOn = this.surveyRepository.getDoCourseSurveyList(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DoCourseSurveyResponse, Unit> function1 = new Function1<DoCourseSurveyResponse, Unit>() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel.getSurveySubjectsList.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DoCourseSurveyResponse doCourseSurveyResponse) {
                invoke2(doCourseSurveyResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DoCourseSurveyResponse doCourseSurveyResponse) {
                CourseSurveySubjectsViewModel.this.surveyResponse.postValue(Resource.INSTANCE.success(doCourseSurveyResponse));
            }
        };
        Consumer<? super DoCourseSurveyResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CourseSurveySubjectsViewModel.getSurveySubjectsList$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel.getSurveySubjectsList.2
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
                CourseSurveySubjectsViewModel.this.surveyResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CourseSurveySubjectsViewModel.getSurveySubjectsList$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveySubjectsList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveySubjectsList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DoCourseSurveyResponse>> getResponse() {
        return this.surveyResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}