package in.etuwa.app.ui.survey.teachersurvey;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.survey.GenSurveyQuestionRequest;
import in.etuwa.app.data.model.survey.TeacherList;
import in.etuwa.app.data.repository.SurveyRepository;
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

/* compiled from: TeacherSurveyViewModel.kt */
/* loaded from: classes5.dex */
public final class TeacherSurveyViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final SurveyRepository surveyRepository;
    private MutableLiveData<Resource<ArrayList<TeacherList>>> surveyResponse;

    public TeacherSurveyViewModel(SurveyRepository surveyRepository) {
        Intrinsics.checkNotNullParameter(surveyRepository, "surveyRepository");
        this.surveyRepository = surveyRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.surveyResponse = new MutableLiveData<>();
    }

    public final void getSurveyList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.surveyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<TeacherList>> observeOn = this.surveyRepository.getSurveyTeachersApiCall(new GenSurveyQuestionRequest(id)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<TeacherList>, Unit> function1 = new Function1<ArrayList<TeacherList>, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyViewModel$getSurveyList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<TeacherList> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<TeacherList> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TeacherSurveyViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<TeacherList>> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyViewModel.getSurveyList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyViewModel$getSurveyList$2
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
                mutableLiveData = TeacherSurveyViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyViewModel.getSurveyList$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<TeacherList>>> getResponse() {
        return this.surveyResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}