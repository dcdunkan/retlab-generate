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

/* compiled from: CourseSurveySubjectsViewModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/survey/coursesurvey/subjects/CourseSurveySubjectsViewModel;", "Landroidx/lifecycle/ViewModel;", "surveyRepository", "Lin/etuwa/app/data/repository/SurveyRepository;", "(Lin/etuwa/app/data/repository/SurveyRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "surveyResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/survey/courseevaluation/DoCourseSurveyResponse;", "getResponse", "getSurveySubjectsList", "", "id", "", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
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
        Single<DoCourseSurveyResponse> observeOn = this.surveyRepository.getDoCourseSurveyList(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DoCourseSurveyResponse, Unit> function1 = new Function1<DoCourseSurveyResponse, Unit>() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel$getSurveySubjectsList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DoCourseSurveyResponse doCourseSurveyResponse) {
                invoke2(doCourseSurveyResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DoCourseSurveyResponse doCourseSurveyResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CourseSurveySubjectsViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(doCourseSurveyResponse));
            }
        };
        Consumer<? super DoCourseSurveyResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CourseSurveySubjectsViewModel.getSurveySubjectsList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel$getSurveySubjectsList$2
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
                mutableLiveData = CourseSurveySubjectsViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CourseSurveySubjectsViewModel.getSurveySubjectsList$lambda$1(Function1.this, obj);
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