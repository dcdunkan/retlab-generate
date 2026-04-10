package in.etuwa.app.ui.semregistration.edit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.Semester;
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
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: SemRegViewModel.kt */
/* loaded from: classes5.dex */
public final class SemRegViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SemRegViewResponse>> dataResponse;
    private MultipartBody.Part multipartFile;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<SemRegSuccessResponse>> regResponse;
    private final SemRegRepository semRegRepository;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;

    public SemRegViewModel(SemRegRepository semRegRepository) {
        Intrinsics.checkNotNullParameter(semRegRepository, "semRegRepository");
        this.semRegRepository = semRegRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.regResponse = new MutableLiveData<>();
        this.dataResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<SemRegViewResponse>> getDataResponse() {
        return this.dataResponse;
    }

    public final void setDataResponse(MutableLiveData<Resource<SemRegViewResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.dataResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> observeOn = this.semRegRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$getSemester$1
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
                mutableLiveData = SemRegViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.getSemester$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$getSemester$2
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
                mutableLiveData = SemRegViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.getSemester$lambda$1(Function1.this, obj);
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

    public final void register(HashMap<String, RequestBody> partMap, File file) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        if (file != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, FilesKt.getExtension(file), 1);
            this.multipartFile = MultipartBody.Part.INSTANCE.createFormData("SemesterRegistration[uploadedFile]", file.getName(), progressRequestBody);
            Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$register$1
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
                    SemRegViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                }
            };
            subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SemRegViewModel.register$lambda$2(Function1.this, obj);
                }
            });
        } else {
            this.regResponse.postValue(Resource.INSTANCE.loading(null));
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.semRegisterApiCall(partMap, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function12 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$register$2
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
                MutableLiveData mutableLiveData;
                mutableLiveData = SemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.register$lambda$3(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$register$3
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
                mutableLiveData = SemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.register$lambda$4(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void updateRegister(RequestBody id, HashMap<String, RequestBody> partMap, File file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        if (file != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, FilesKt.getExtension(file), 1);
            this.multipartFile = MultipartBody.Part.INSTANCE.createFormData("SemesterRegistration[uploadedFile]", file.getName(), progressRequestBody);
            Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$updateRegister$1
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
                    SemRegViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                }
            };
            subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SemRegViewModel.updateRegister$lambda$5(Function1.this, obj);
                }
            });
        } else {
            this.regResponse.postValue(Resource.INSTANCE.loading(null));
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.updateSemRegisterApiCall(id, partMap, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function12 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$updateRegister$2
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
                MutableLiveData mutableLiveData;
                mutableLiveData = SemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.updateRegister$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$updateRegister$3
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
                mutableLiveData = SemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.updateRegister$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegister$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegister$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegister$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SemRegSuccessResponse>> getResponse() {
        return this.regResponse;
    }

    public final void getData(String id) {
        this.dataResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SemRegViewResponse> observeOn = this.semRegRepository.getSemRegDetailsMvjceApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegViewResponse, Unit> function1 = new Function1<SemRegViewResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$getData$1
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
                SemRegViewModel.this.getDataResponse().postValue(Resource.INSTANCE.success(semRegViewResponse));
            }
        };
        Consumer<? super SemRegViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.getData$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$getData$2
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
                SemRegViewModel.this.getDataResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SemRegViewModel.getData$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}