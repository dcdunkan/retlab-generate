package in.etuwa.app.ui.semregistration.mea;

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

/* compiled from: MeaSemRegViewModel.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u001fJ\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\bJ\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\bJ6\u0010&\u001a\u00020\u001f2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020)`*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J>\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020)2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020)`*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J\"\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0/J\u001a\u0010-\u001a\u00020\u001f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0/R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR&\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u00060"}, d2 = {"Lin/etuwa/app/ui/semregistration/mea/MeaSemRegViewModel;", "Landroidx/lifecycle/ViewModel;", "semRegRepository", "Lin/etuwa/app/data/repository/SemRegRepository;", "(Lin/etuwa/app/data/repository/SemRegRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "dropDownResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/semregistration/AcademicYearResponse;", "getDropDownResponse", "()Landroidx/lifecycle/MutableLiveData;", "setDropDownResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "multipartFile", "Lokhttp3/MultipartBody$Part;", "progressResponse", "", "getProgressResponse", "setProgressResponse", "regResponse", "Lin/etuwa/app/data/model/SemRegSuccessResponse;", "getRegResponse", "setRegResponse", "regviewResponse", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "semRegResponse", "getSemRegResponse", "setSemRegResponse", "getData", "", "id", "", "getDropDowns", "getDropResponse", "getRegisterResponse", "getResponse", "registerWithReceipt", "partMap", "Ljava/util/HashMap;", "Lokhttp3/RequestBody;", "Lkotlin/collections/HashMap;", "file", "Ljava/io/File;", "registerWithoutReceipt", "semesterRegistration", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MeaSemRegViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<AcademicYearResponse>> dropDownResponse;
    private MultipartBody.Part multipartFile;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<SemRegSuccessResponse>> regResponse;
    private MutableLiveData<Resource<SemRegViewResponse>> regviewResponse;
    private final SemRegRepository semRegRepository;
    private MutableLiveData<Resource<SemRegSuccessResponse>> semRegResponse;

    public MeaSemRegViewModel(SemRegRepository semRegRepository) {
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
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithReceipt$1
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
                    MeaSemRegViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                }
            };
            subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda13
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MeaSemRegViewModel.registerWithReceipt$lambda$0(Function1.this, obj);
                }
            });
        } else {
            this.regResponse.postValue(Resource.INSTANCE.loading(null));
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.semRegisterApiCall(partMap, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function12 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithReceipt$2
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
                MeaSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithReceipt$lambda$1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithReceipt$3
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
                MeaSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithReceipt$lambda$2(Function1.this, obj);
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
        final Function1<SemRegSuccessResponse, Unit> function1 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithoutReceipt$1
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
                MeaSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithoutReceipt$lambda$3(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithoutReceipt$2
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
                MeaSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithoutReceipt$lambda$4(Function1.this, obj);
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
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithReceipt$4
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
                    MeaSemRegViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                }
            };
            subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda10
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MeaSemRegViewModel.registerWithReceipt$lambda$5(Function1.this, obj);
                }
            });
        } else {
            this.regResponse.postValue(Resource.INSTANCE.loading(null));
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.updateSemRegisterApiCall(id, partMap, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function12 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithReceipt$5
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
                MeaSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithReceipt$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithReceipt$6
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
                MeaSemRegViewModel.this.getRegResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithReceipt$lambda$7(Function1.this, obj);
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
        final Function1<SemRegSuccessResponse, Unit> function1 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithoutReceipt$3
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
                MeaSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithoutReceipt$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$registerWithoutReceipt$4
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
                MeaSemRegViewModel.this.getSemRegResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.registerWithoutReceipt$lambda$9(Function1.this, obj);
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
        final Function1<AcademicYearResponse, Unit> function1 = new Function1<AcademicYearResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$getDropDowns$1
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
                MeaSemRegViewModel.this.getDropDownResponse().postValue(Resource.INSTANCE.success(academicYearResponse));
            }
        };
        Consumer<? super AcademicYearResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.getDropDowns$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$getDropDowns$2
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
                MeaSemRegViewModel.this.getDropDownResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.getDropDowns$lambda$11(Function1.this, obj);
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
        final Function1<SemRegViewResponse, Unit> function1 = new Function1<SemRegViewResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$getData$1
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
                mutableLiveData = MeaSemRegViewModel.this.regviewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegViewResponse));
            }
        };
        Consumer<? super SemRegViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.getData$lambda$12(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$getData$2
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
                mutableLiveData = MeaSemRegViewModel.this.regviewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MeaSemRegViewModel.getData$lambda$13(Function1.this, obj);
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