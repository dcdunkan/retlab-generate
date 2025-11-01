package in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.survey.GenSurveyQuestionRequest;
import in.etuwa.app.data.model.survey.SubmitResponse;
import in.etuwa.app.data.model.survey.SurveyQuestion;
import in.etuwa.app.data.model.survey.SurveyRequest;
import in.etuwa.app.data.repository.SurveyRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TeacherSurveyQuestionViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\"\u0010\u0013\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\t0\bJ\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJB\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001bJ>\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001bJ\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012J\b\u0010\u001e\u001a\u00020\u0010H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionViewModel;", "Landroidx/lifecycle/ViewModel;", "surveyRepository", "Lin/etuwa/app/data/repository/SurveyRepository;", "(Lin/etuwa/app/data/repository/SurveyRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "submitResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/survey/SubmitResponse;", "surveyResponse", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/SurveyQuestion;", "Lkotlin/collections/ArrayList;", "getGenSurveyQuestionList", "", "id", "", "getResponse", "getSubmitResponse", "getSurveyAnswerSubmit", "teacherId", "subjectId", "remark", "specialRemark", "answer", "", "option", "getSurveyQuestionListList", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TeacherSurveyQuestionViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SubmitResponse>> submitResponse;
    private final SurveyRepository surveyRepository;
    private MutableLiveData<Resource<ArrayList<SurveyQuestion>>> surveyResponse;

    public TeacherSurveyQuestionViewModel(SurveyRepository surveyRepository) {
        Intrinsics.checkNotNullParameter(surveyRepository, "surveyRepository");
        this.surveyRepository = surveyRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.surveyResponse = new MutableLiveData<>();
        this.submitResponse = new MutableLiveData<>();
    }

    public final void getSurveyQuestionListList(String id, String teacherId, String subjectId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        this.surveyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<SurveyQuestion>> observeOn = this.surveyRepository.getSurveyQuestionApiCall(new SurveyRequest(id, teacherId, subjectId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<SurveyQuestion>, Unit> function1 = new Function1<ArrayList<SurveyQuestion>, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getSurveyQuestionListList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SurveyQuestion> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<SurveyQuestion> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TeacherSurveyQuestionViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<SurveyQuestion>> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getSurveyQuestionListList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getSurveyQuestionListList$2
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
                mutableLiveData = TeacherSurveyQuestionViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getSurveyQuestionListList$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyQuestionListList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyQuestionListList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<SurveyQuestion>>> getResponse() {
        return this.surveyResponse;
    }

    public final void getGenSurveyQuestionList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.surveyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<SurveyQuestion>> observeOn = this.surveyRepository.getSurveyQuestionApiCall(new GenSurveyQuestionRequest(id)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<SurveyQuestion>, Unit> function1 = new Function1<ArrayList<SurveyQuestion>, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getGenSurveyQuestionList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SurveyQuestion> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<SurveyQuestion> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TeacherSurveyQuestionViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<SurveyQuestion>> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getGenSurveyQuestionList$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getGenSurveyQuestionList$2
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
                mutableLiveData = TeacherSurveyQuestionViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getGenSurveyQuestionList$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGenSurveyQuestionList$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGenSurveyQuestionList$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getSurveyAnswerSubmit(String id, String teacherId, String subjectId, String remark, String specialRemark, Map<String, String> answer) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(specialRemark, "specialRemark");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.submitResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SubmitResponse> observeOn = this.surveyRepository.submitSurveyApiCall(id, teacherId, subjectId, remark, specialRemark, answer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SubmitResponse, Unit> function1 = new Function1<SubmitResponse, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getSurveyAnswerSubmit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubmitResponse submitResponse) {
                invoke2(submitResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubmitResponse submitResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TeacherSurveyQuestionViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(submitResponse));
            }
        };
        Consumer<? super SubmitResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getSurveyAnswerSubmit$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getSurveyAnswerSubmit$2
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
                mutableLiveData = TeacherSurveyQuestionViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getSurveyAnswerSubmit$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyAnswerSubmit$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyAnswerSubmit$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SubmitResponse>> getSubmitResponse() {
        return this.submitResponse;
    }

    public final void getSurveyAnswerSubmit(String id, String remark, Map<String, String> option, Map<String, String> answer) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.submitResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SubmitResponse> observeOn = this.surveyRepository.submitGenSurveyApiCall(id, remark, option).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SubmitResponse, Unit> function1 = new Function1<SubmitResponse, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getSurveyAnswerSubmit$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubmitResponse submitResponse) {
                invoke2(submitResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubmitResponse submitResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TeacherSurveyQuestionViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(submitResponse));
            }
        };
        Consumer<? super SubmitResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getSurveyAnswerSubmit$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$getSurveyAnswerSubmit$4
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
                mutableLiveData = TeacherSurveyQuestionViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherSurveyQuestionViewModel.getSurveyAnswerSubmit$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyAnswerSubmit$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyAnswerSubmit$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}