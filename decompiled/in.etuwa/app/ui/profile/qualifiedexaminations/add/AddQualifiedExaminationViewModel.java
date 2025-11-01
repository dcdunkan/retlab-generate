package in.etuwa.app.ui.profile.qualifiedexaminations.add;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.data.repository.ProfileRepository;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* compiled from: AddQualifiedExaminationViewModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fJ(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001dJ\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\b0\u0007J\b\u0010(\u001a\u00020\u001dH\u0014J&\u0010)\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fJ0\u0010)\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007R&\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000b¨\u0006*"}, d2 = {"Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/component/KoinComponent;", "profileRepository", "Lin/etuwa/app/data/repository/ProfileRepository;", "(Lin/etuwa/app/data/repository/ProfileRepository;)V", "addResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/SuccessResponse;", "getAddResponse", "()Landroidx/lifecycle/MutableLiveData;", "setAddResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "addResponse2", "getAddResponse2", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "deleteResponse", "getDeleteResponse", "progressResponse", "", "getProgressResponse", "setProgressResponse", "publicationResponse", "Lin/etuwa/app/data/model/profileasiet/publication/PublicationDropDownResponse;", "updateResponse2", "getUpdateResponse2", "addQualifiedExaminationData", "", "name", "", FirebaseAnalytics.Param.SCORE, "yearId", "filePath", "Ljava/io/File;", "deleteQualifiedExaminationData", "id", "getDropDownData", "getResponse", "onCleared", "updateQualifiedExaminationData", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddQualifiedExaminationViewModel extends ViewModel implements KoinComponent {
    private MutableLiveData<Resource<SuccessResponse>> addResponse;
    private final MutableLiveData<Resource<SuccessResponse>> addResponse2;
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<SuccessResponse>> deleteResponse;
    private final ProfileRepository profileRepository;
    private MutableLiveData<Resource<Float>> progressResponse;
    private final MutableLiveData<Resource<PublicationDropDownResponse>> publicationResponse;
    private final MutableLiveData<Resource<SuccessResponse>> updateResponse2;

    public AddQualifiedExaminationViewModel(ProfileRepository profileRepository) {
        Intrinsics.checkNotNullParameter(profileRepository, "profileRepository");
        this.profileRepository = profileRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.progressResponse = new MutableLiveData<>();
        this.addResponse = new MutableLiveData<>();
        this.addResponse2 = new MutableLiveData<>();
        this.updateResponse2 = new MutableLiveData<>();
        this.deleteResponse = new MutableLiveData<>();
        this.publicationResponse = new MutableLiveData<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getAddResponse() {
        return this.addResponse;
    }

    public final void setAddResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.addResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getAddResponse2() {
        return this.addResponse2;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getUpdateResponse2() {
        return this.updateResponse2;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getDeleteResponse() {
        return this.deleteResponse;
    }

    public final void addQualifiedExaminationData(String name, String score, String yearId, File filePath) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, name);
        RequestBody create2 = RequestBody.INSTANCE.create(MultipartBody.FORM, score);
        RequestBody create3 = RequestBody.INSTANCE.create(MultipartBody.FORM, yearId);
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
        MultipartBody.Part createFormData = MultipartBody.Part.INSTANCE.createFormData("StudentProfile[uploadedFile]", filePath.getName(), progressRequestBody);
        Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$addQualifiedExaminationData$1
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
                AddQualifiedExaminationViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.addQualifiedExaminationData$lambda$0(Function1.this, obj);
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.profileRepository.addQualifiedExaminationUrlApiCall(create, create2, create3, createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$addQualifiedExaminationData$2
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
                AddQualifiedExaminationViewModel.this.getAddResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.addQualifiedExaminationData$lambda$1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$addQualifiedExaminationData$3
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
                    AddQualifiedExaminationViewModel.this.getAddResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                } else {
                    AddQualifiedExaminationViewModel.this.getAddResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                }
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.addQualifiedExaminationData$lambda$2(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addQualifiedExaminationData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addQualifiedExaminationData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addQualifiedExaminationData$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void updateQualifiedExaminationData(String id, String name, String score, String yearId, File filePath) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, id);
        RequestBody create2 = RequestBody.INSTANCE.create(MultipartBody.FORM, name);
        RequestBody create3 = RequestBody.INSTANCE.create(MultipartBody.FORM, score);
        RequestBody create4 = RequestBody.INSTANCE.create(MultipartBody.FORM, yearId);
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
        MultipartBody.Part createFormData = MultipartBody.Part.INSTANCE.createFormData("StudentProfile[uploadedFile]", filePath.getName(), progressRequestBody);
        Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$updateQualifiedExaminationData$1
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
                AddQualifiedExaminationViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.updateQualifiedExaminationData$lambda$3(Function1.this, obj);
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.profileRepository.updateQualifiedExaminationUrlApiCall(create, create2, create3, create4, createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$updateQualifiedExaminationData$2
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
                AddQualifiedExaminationViewModel.this.getAddResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.updateQualifiedExaminationData$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$updateQualifiedExaminationData$3
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
                    AddQualifiedExaminationViewModel.this.getAddResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                } else {
                    AddQualifiedExaminationViewModel.this.getAddResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                }
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.updateQualifiedExaminationData$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateQualifiedExaminationData$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateQualifiedExaminationData$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateQualifiedExaminationData$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getDropDownData() {
        this.publicationResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<PublicationDropDownResponse> observeOn = this.profileRepository.getProfileDropListUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<PublicationDropDownResponse, Unit> function1 = new Function1<PublicationDropDownResponse, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$getDropDownData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublicationDropDownResponse publicationDropDownResponse) {
                invoke2(publicationDropDownResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublicationDropDownResponse publicationDropDownResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AddQualifiedExaminationViewModel.this.publicationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(publicationDropDownResponse));
            }
        };
        Consumer<? super PublicationDropDownResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.getDropDownData$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$getDropDownData$2
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
                mutableLiveData = AddQualifiedExaminationViewModel.this.publicationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.getDropDownData$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDropDownData$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDropDownData$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<PublicationDropDownResponse>> getResponse() {
        return this.publicationResponse;
    }

    public final void addQualifiedExaminationData(String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        this.addResponse2.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.profileRepository.addQualifiedExaminationUrlApiCall(name, score, yearId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$addQualifiedExaminationData$4
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
                AddQualifiedExaminationViewModel.this.getAddResponse2().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.addQualifiedExaminationData$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$addQualifiedExaminationData$5
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
                AddQualifiedExaminationViewModel.this.getAddResponse2().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.addQualifiedExaminationData$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addQualifiedExaminationData$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addQualifiedExaminationData$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void updateQualifiedExaminationData(String id, String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        this.updateResponse2.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.profileRepository.updateQualifiedExaminationUrlApiCall(id, name, score, yearId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$updateQualifiedExaminationData$4
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
                AddQualifiedExaminationViewModel.this.getUpdateResponse2().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.updateQualifiedExaminationData$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$updateQualifiedExaminationData$5
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
                AddQualifiedExaminationViewModel.this.getUpdateResponse2().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.updateQualifiedExaminationData$lambda$11(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateQualifiedExaminationData$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateQualifiedExaminationData$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void deleteQualifiedExaminationData(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.deleteResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.profileRepository.deleteQualifiedExaminationUrlApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$deleteQualifiedExaminationData$1
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
                AddQualifiedExaminationViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.deleteQualifiedExaminationData$lambda$12(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$deleteQualifiedExaminationData$2
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
                AddQualifiedExaminationViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddQualifiedExaminationViewModel.deleteQualifiedExaminationData$lambda$13(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteQualifiedExaminationData$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteQualifiedExaminationData$lambda$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}