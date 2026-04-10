package in.etuwa.app.ui.semregistration.mvjce;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.semregistration.AcademicYearResponse;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.repository.SemRegRepository;
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
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: MvjceSemRegViewModel.kt */
/* loaded from: classes5.dex */
public final class MvjceSemRegViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<AcademicYearResponse>> dropDownResponse;
    private MultipartBody.Part multipartFile;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<SemRegSuccessResponse>> regResponse;
    private MutableLiveData<Resource<SemRegViewResponse>> regviewResponse;
    private final SemRegRepository semRegRepository;
    private MutableLiveData<Resource<SemRegSuccessResponse>> semRegResponse;

    public MvjceSemRegViewModel(SemRegRepository semRegRepository) {
        Intrinsics.checkNotNullParameter(semRegRepository, "semRegRepository");
        this.semRegRepository = semRegRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.regResponse = new MutableLiveData<>();
        this.semRegResponse = new MutableLiveData<>();
        this.dropDownResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
        this.regviewResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<SemRegSuccessResponse>> getRegResponse() {
        return this.regResponse;
    }

    public final void setRegResponse(MutableLiveData<Resource<SemRegSuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.regResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<SemRegSuccessResponse>> getSemRegResponse() {
        return this.semRegResponse;
    }

    public final void setSemRegResponse(MutableLiveData<Resource<SemRegSuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.semRegResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<AcademicYearResponse>> getDropDownResponse() {
        return this.dropDownResponse;
    }

    public final void setDropDownResponse(MutableLiveData<Resource<AcademicYearResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.dropDownResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    public final void registerWithReceipt(HashMap<String, RequestBody> partMap, File file) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        if (file != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, FilesKt.getExtension(file), 1);
            this.multipartFile = MultipartBody.Part.INSTANCE.createFormData("SemesterRegistration[uploadedFile]", file.getName(), progressRequestBody);
            Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithReceipt$1
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
                    MvjceSemRegViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                }
            };
            subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda13
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MvjceSemRegViewModel.registerWithReceipt$lambda$0(Function1.this, obj);
                }
            });
        } else {
            this.regResponse.postValue(Resource.INSTANCE.loading(null));
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.semRegisterApiCall(partMap, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function12 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithReceipt$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegSuccessResponse semRegSuccessResponse) {
                invoke2(semRegSuccessResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegSuccessResponse semRegSuccessResponse) {
                MvjceSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithReceipt$lambda$1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithReceipt$3
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
                MvjceSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithReceipt$lambda$2(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithReceipt$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithReceipt$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithReceipt$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void registerWithoutReceipt(Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        this.semRegResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.semRegisterApiCall(semesterRegistration).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function1 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithoutReceipt$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegSuccessResponse semRegSuccessResponse) {
                invoke2(semRegSuccessResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegSuccessResponse semRegSuccessResponse) {
                MvjceSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithoutReceipt$lambda$3(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithoutReceipt$2
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
                MvjceSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithoutReceipt$lambda$4(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithoutReceipt$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithoutReceipt$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void registerWithReceipt(RequestBody id, HashMap<String, RequestBody> partMap, File file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        if (file != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, FilesKt.getExtension(file), 1);
            this.multipartFile = MultipartBody.Part.INSTANCE.createFormData("SemesterRegistration[uploadedFile]", file.getName(), progressRequestBody);
            Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithReceipt$4
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
                    MvjceSemRegViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                }
            };
            subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda10
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MvjceSemRegViewModel.registerWithReceipt$lambda$5(Function1.this, obj);
                }
            });
        } else {
            this.regResponse.postValue(Resource.INSTANCE.loading(null));
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.updateSemRegisterApiCall(id, partMap, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function12 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithReceipt$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegSuccessResponse semRegSuccessResponse) {
                invoke2(semRegSuccessResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegSuccessResponse semRegSuccessResponse) {
                MvjceSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithReceipt$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithReceipt$6
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
                MvjceSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithReceipt$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithReceipt$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithReceipt$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithReceipt$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void registerWithoutReceipt(String id, Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        this.semRegResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.updateSemRegisterApiCall(id, semesterRegistration).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function1 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithoutReceipt$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegSuccessResponse semRegSuccessResponse) {
                invoke2(semRegSuccessResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegSuccessResponse semRegSuccessResponse) {
                MvjceSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithoutReceipt$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$registerWithoutReceipt$4
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
                MvjceSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.registerWithoutReceipt$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithoutReceipt$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerWithoutReceipt$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SemRegSuccessResponse>> getRegisterResponse() {
        return this.semRegResponse;
    }

    public final void getDropDowns() {
        this.dropDownResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<AcademicYearResponse> observeOn = this.semRegRepository.getSemRegDropListApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<AcademicYearResponse, Unit> function1 = new Function1<AcademicYearResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$getDropDowns$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AcademicYearResponse academicYearResponse) {
                invoke2(academicYearResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AcademicYearResponse academicYearResponse) {
                MvjceSemRegViewModel.this.getDropDownResponse().postValue(Resource.INSTANCE.success(academicYearResponse));
            }
        };
        Consumer<? super AcademicYearResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.getDropDowns$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$getDropDowns$2
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
                MvjceSemRegViewModel.this.getDropDownResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.getDropDowns$lambda$11(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDropDowns$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDropDowns$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<AcademicYearResponse>> getDropResponse() {
        return this.dropDownResponse;
    }

    public final void getData(String id) {
        this.regviewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SemRegViewResponse> observeOn = this.semRegRepository.getSemRegDetailsMvjceApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegViewResponse, Unit> function1 = new Function1<SemRegViewResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$getData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegViewResponse semRegViewResponse) {
                invoke2(semRegViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegViewResponse semRegViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MvjceSemRegViewModel.this.regviewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegViewResponse));
            }
        };
        Consumer<? super SemRegViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.getData$lambda$12(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$getData$2
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
                mutableLiveData = MvjceSemRegViewModel.this.regviewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MvjceSemRegViewModel.getData$lambda$13(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData$lambda$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SemRegViewResponse>> getResponse() {
        return this.regviewResponse;
    }
}