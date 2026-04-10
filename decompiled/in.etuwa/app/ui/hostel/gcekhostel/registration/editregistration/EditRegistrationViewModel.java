package in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.newregistration.CategoryTypeResponse;
import in.etuwa.app.data.repository.HostelRepository;
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
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* compiled from: EditRegistrationViewModel.kt */
/* loaded from: classes5.dex */
public final class EditRegistrationViewModel extends ViewModel implements KoinComponent {
    private MutableLiveData<Resource<SuccessResponse>> applyResponse;
    private MutableLiveData<Resource<CategoryTypeResponse>> categoryTypeResponse;
    private final CompositeDisposable compositeDisposable;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;
    private MutableLiveData<Resource<SuccessResponse>> uploadResponse;

    public EditRegistrationViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.categoryTypeResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        this.applyResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
        this.uploadResponse = new MutableLiveData<>();
        getSemester();
        getCategoryTypeData();
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

    public final MutableLiveData<Resource<SuccessResponse>> getUploadResponse() {
        return this.uploadResponse;
    }

    public final void setUploadResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.uploadResponse = mutableLiveData;
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> observeOn = this.hostelRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$getSemester$1
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
                mutableLiveData = EditRegistrationViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EditRegistrationViewModel.getSemester$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$getSemester$2
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
                mutableLiveData = EditRegistrationViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EditRegistrationViewModel.getSemester$lambda$1(Function1.this, obj);
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

    public final void getCategoryTypeData() {
        this.categoryTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CategoryTypeResponse> observeOn = this.hostelRepository.getCategoryTypeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CategoryTypeResponse, Unit> function1 = new Function1<CategoryTypeResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$getCategoryTypeData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CategoryTypeResponse categoryTypeResponse) {
                invoke2(categoryTypeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CategoryTypeResponse categoryTypeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = EditRegistrationViewModel.this.categoryTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(categoryTypeResponse));
            }
        };
        Consumer<? super CategoryTypeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EditRegistrationViewModel.getCategoryTypeData$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$getCategoryTypeData$2
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
                mutableLiveData = EditRegistrationViewModel.this.categoryTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EditRegistrationViewModel.getCategoryTypeData$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCategoryTypeData$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCategoryTypeData$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<CategoryTypeResponse>> getResponse() {
        return this.categoryTypeResponse;
    }

    public final void newHostelRegistrationApiCall(String id, String reAdmission, String category, String localGuardian, String localGuardianPhone, String annualIncome, String distance, String semesterId, File filePath) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, id);
        RequestBody create2 = RequestBody.INSTANCE.create(MultipartBody.FORM, reAdmission);
        RequestBody create3 = RequestBody.INSTANCE.create(MultipartBody.FORM, category);
        RequestBody create4 = RequestBody.INSTANCE.create(MultipartBody.FORM, localGuardian);
        RequestBody create5 = RequestBody.INSTANCE.create(MultipartBody.FORM, localGuardianPhone);
        RequestBody create6 = RequestBody.INSTANCE.create(MultipartBody.FORM, annualIncome);
        RequestBody create7 = RequestBody.INSTANCE.create(MultipartBody.FORM, distance);
        RequestBody create8 = RequestBody.INSTANCE.create(MultipartBody.FORM, semesterId);
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
        MultipartBody.Part createFormData = MultipartBody.Part.INSTANCE.createFormData("HostelRegistration[uploadedFile]", filePath.getName(), progressRequestBody);
        Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$newHostelRegistrationApiCall$1
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
                EditRegistrationViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EditRegistrationViewModel.newHostelRegistrationApiCall$lambda$4(Function1.this, obj);
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SuccessResponse> observeOn = this.hostelRepository.updateHostelRegistrationApiCall(create, create2, create3, create4, create5, create6, create7, create8, createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$newHostelRegistrationApiCall$2
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
                EditRegistrationViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EditRegistrationViewModel.newHostelRegistrationApiCall$lambda$5(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$newHostelRegistrationApiCall$3
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
                    EditRegistrationViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                } else {
                    EditRegistrationViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                }
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EditRegistrationViewModel.newHostelRegistrationApiCall$lambda$6(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newHostelRegistrationApiCall$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newHostelRegistrationApiCall$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newHostelRegistrationApiCall$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}