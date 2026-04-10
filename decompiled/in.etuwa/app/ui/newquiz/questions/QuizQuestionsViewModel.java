package in.etuwa.app.ui.newquiz.questions;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.quiz.QuestionsNewResponse;
import in.etuwa.app.data.model.quiz.submit.QuizSubmitResponse;
import in.etuwa.app.data.repository.QuizRepository;
import in.etuwa.app.helper.ProgressRequestBody;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: QuizQuestionsViewModel.kt */
/* loaded from: classes5.dex */
public final class QuizQuestionsViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<QuestionsNewResponse>> quizQuestionsResponse;
    private final QuizRepository quizRepository;
    private MutableLiveData<Resource<QuizSubmitResponse>> submitResponse;
    private MutableLiveData<Resource<QuizSubmitResponse>> uploadResponse;

    public QuizQuestionsViewModel(QuizRepository quizRepository) {
        Intrinsics.checkNotNullParameter(quizRepository, "quizRepository");
        this.quizRepository = quizRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.quizQuestionsResponse = new MutableLiveData<>();
        this.submitResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
        this.uploadResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<QuizSubmitResponse>> getUploadResponse() {
        return this.uploadResponse;
    }

    public final void setUploadResponse(MutableLiveData<Resource<QuizSubmitResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.uploadResponse = mutableLiveData;
    }

    public final void getQuizQuestionsList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.quizQuestionsResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<QuestionsNewResponse> observeOn = this.quizRepository.getNewQuizQuestionsApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<QuestionsNewResponse, Unit> function1 = new Function1<QuestionsNewResponse, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$getQuizQuestionsList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuestionsNewResponse questionsNewResponse) {
                invoke2(questionsNewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QuestionsNewResponse questionsNewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = QuizQuestionsViewModel.this.quizQuestionsResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(questionsNewResponse));
            }
        };
        Consumer<? super QuestionsNewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.getQuizQuestionsList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$getQuizQuestionsList$2
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
                mutableLiveData = QuizQuestionsViewModel.this.quizQuestionsResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.getQuizQuestionsList$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuizQuestionsList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuizQuestionsList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<QuestionsNewResponse>> getResponse() {
        return this.quizQuestionsResponse;
    }

    public final void getQuizAnswerSubmit(Map<String, String> answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.submitResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<QuizSubmitResponse> observeOn = this.quizRepository.newQuizAnswerSubmit(answer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<QuizSubmitResponse, Unit> function1 = new Function1<QuizSubmitResponse, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$getQuizAnswerSubmit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuizSubmitResponse quizSubmitResponse) {
                invoke2(quizSubmitResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QuizSubmitResponse quizSubmitResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = QuizQuestionsViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(quizSubmitResponse));
            }
        };
        Consumer<? super QuizSubmitResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.getQuizAnswerSubmit$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$getQuizAnswerSubmit$2
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
                mutableLiveData = QuizQuestionsViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.getQuizAnswerSubmit$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuizAnswerSubmit$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuizAnswerSubmit$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void newQuizAnswerUploadSubmit(String qNo, String id, File filePath) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, qNo);
        RequestBody create2 = RequestBody.INSTANCE.create(MultipartBody.FORM, id);
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
        MultipartBody.Part createFormData = MultipartBody.Part.INSTANCE.createFormData("file", filePath.getName(), progressRequestBody);
        Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$newQuizAnswerUploadSubmit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke2(f);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float f) {
                QuizQuestionsViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.newQuizAnswerUploadSubmit$lambda$4(Function1.this, obj);
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<QuizSubmitResponse> observeOn = this.quizRepository.newQuizAnswerUploadSubmit(create, create2, createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<QuizSubmitResponse, Unit> function12 = new Function1<QuizSubmitResponse, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$newQuizAnswerUploadSubmit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuizSubmitResponse quizSubmitResponse) {
                invoke2(quizSubmitResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QuizSubmitResponse quizSubmitResponse) {
                QuizQuestionsViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.success(quizSubmitResponse));
            }
        };
        Consumer<? super QuizSubmitResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.newQuizAnswerUploadSubmit$lambda$5(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$newQuizAnswerUploadSubmit$3
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
                if (th instanceof SocketTimeoutException) {
                    QuizQuestionsViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                } else {
                    QuizQuestionsViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                }
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.newQuizAnswerUploadSubmit$lambda$6(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newQuizAnswerUploadSubmit$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newQuizAnswerUploadSubmit$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newQuizAnswerUploadSubmit$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void newQuizAnswerUploadFinalSubmit(String qNo, String id, File filePath) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, qNo);
        RequestBody create2 = RequestBody.INSTANCE.create(MultipartBody.FORM, id);
        RequestBody create3 = RequestBody.INSTANCE.create(MultipartBody.FORM, "1");
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
        MultipartBody.Part createFormData = MultipartBody.Part.INSTANCE.createFormData("file", filePath.getName(), progressRequestBody);
        Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$newQuizAnswerUploadFinalSubmit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke2(f);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float f) {
                QuizQuestionsViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.newQuizAnswerUploadFinalSubmit$lambda$7(Function1.this, obj);
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<QuizSubmitResponse> observeOn = this.quizRepository.newQuizAnswerUploadFinalSubmit(create, create2, create3, createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<QuizSubmitResponse, Unit> function12 = new Function1<QuizSubmitResponse, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$newQuizAnswerUploadFinalSubmit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuizSubmitResponse quizSubmitResponse) {
                invoke2(quizSubmitResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QuizSubmitResponse quizSubmitResponse) {
                QuizQuestionsViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.success(quizSubmitResponse));
            }
        };
        Consumer<? super QuizSubmitResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.newQuizAnswerUploadFinalSubmit$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$newQuizAnswerUploadFinalSubmit$3
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
                if (th instanceof SocketTimeoutException) {
                    QuizQuestionsViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                } else {
                    QuizQuestionsViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                }
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizQuestionsViewModel.newQuizAnswerUploadFinalSubmit$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newQuizAnswerUploadFinalSubmit$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newQuizAnswerUploadFinalSubmit$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newQuizAnswerUploadFinalSubmit$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<QuizSubmitResponse>> getSubmitResponse() {
        return this.submitResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}