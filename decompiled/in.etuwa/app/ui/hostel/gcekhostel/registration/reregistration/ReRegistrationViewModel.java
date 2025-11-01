package in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.newregistration.CategoryTypeResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.reregistration.PresentHostelResponse;
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

/* compiled from: ReRegistrationViewModel.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b0\u0007J\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007J\"\u0010&\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\rj\b\u0012\u0004\u0012\u00020\u001d`\u000f0\b0\u0007J\u0006\u0010'\u001a\u00020\"J\u0080\u0001\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*H\u0007J\b\u0010:\u001a\u00020\"H\u0014R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R*\u0010\u001c\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\rj\b\u0012\u0004\u0012\u00020\u001d`\u000f0\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015¨\u0006;"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/reregistration/ReRegistrationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/component/KoinComponent;", "hostelRepository", "Lin/etuwa/app/data/repository/HostelRepository;", "(Lin/etuwa/app/data/repository/HostelRepository;)V", "categoryTypeResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/hostel/gcekhostel/newregistration/CategoryTypeResponse;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "multipartFile", "Ljava/util/ArrayList;", "Lokhttp3/MultipartBody$Part;", "Lkotlin/collections/ArrayList;", "newRegistrationResponse", "Lin/etuwa/app/data/model/SuccessResponse;", "getNewRegistrationResponse", "()Landroidx/lifecycle/MutableLiveData;", "setNewRegistrationResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "presentHostelResponse", "Lin/etuwa/app/data/model/hostel/gcekhostel/reregistration/PresentHostelResponse;", "progressResponse", "", "getProgressResponse", "setProgressResponse", "semResponse", "Lin/etuwa/app/data/model/Semester;", "uploadResponse", "getUploadResponse", "setUploadResponse", "getCategoryTypeData", "", "getPresentHostelData", "getPresentHostelResponse", "getResponse", "getSemResponse", "getSemester", "newRegistration", "reAdmission", "", "category", "localGuardian", "localGuardianPhone", "annualIncome", "distance", "semesterId", "filePath", "Ljava/io/File;", "hostelId", "yearCount", "hostelDetails", "isFined", "fineDetails", "feeDefaulter", "feeDetails", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReRegistrationViewModel extends ViewModel implements KoinComponent {
    private MutableLiveData<Resource<CategoryTypeResponse>> categoryTypeResponse;
    private final CompositeDisposable compositeDisposable;
    private final HostelRepository hostelRepository;
    private ArrayList<MultipartBody.Part> multipartFile;
    private MutableLiveData<Resource<SuccessResponse>> newRegistrationResponse;
    private MutableLiveData<Resource<PresentHostelResponse>> presentHostelResponse;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;
    private MutableLiveData<Resource<SuccessResponse>> uploadResponse;

    public ReRegistrationViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.categoryTypeResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        this.newRegistrationResponse = new MutableLiveData<>();
        this.multipartFile = new ArrayList<>();
        this.progressResponse = new MutableLiveData<>();
        this.uploadResponse = new MutableLiveData<>();
        this.presentHostelResponse = new MutableLiveData<>();
        getSemester();
        getCategoryTypeData();
        getPresentHostelData();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getNewRegistrationResponse() {
        return this.newRegistrationResponse;
    }

    public final void setNewRegistrationResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.newRegistrationResponse = mutableLiveData;
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
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$getSemester$1
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
                mutableLiveData = ReRegistrationViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ReRegistrationViewModel.getSemester$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$getSemester$2
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
                mutableLiveData = ReRegistrationViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ReRegistrationViewModel.getSemester$lambda$1(Function1.this, obj);
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
        final Function1<CategoryTypeResponse, Unit> function1 = new Function1<CategoryTypeResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$getCategoryTypeData$1
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
                mutableLiveData = ReRegistrationViewModel.this.categoryTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(categoryTypeResponse));
            }
        };
        Consumer<? super CategoryTypeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ReRegistrationViewModel.getCategoryTypeData$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$getCategoryTypeData$2
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
                mutableLiveData = ReRegistrationViewModel.this.categoryTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ReRegistrationViewModel.getCategoryTypeData$lambda$3(Function1.this, obj);
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

    public final void getPresentHostelData() {
        this.presentHostelResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<PresentHostelResponse> observeOn = this.hostelRepository.getPresentHostelApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<PresentHostelResponse, Unit> function1 = new Function1<PresentHostelResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$getPresentHostelData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PresentHostelResponse presentHostelResponse) {
                invoke2(presentHostelResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PresentHostelResponse presentHostelResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ReRegistrationViewModel.this.presentHostelResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(presentHostelResponse));
            }
        };
        Consumer<? super PresentHostelResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ReRegistrationViewModel.getPresentHostelData$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$getPresentHostelData$2
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
                mutableLiveData = ReRegistrationViewModel.this.presentHostelResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ReRegistrationViewModel.getPresentHostelData$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPresentHostelData$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPresentHostelData$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<PresentHostelResponse>> getPresentHostelResponse() {
        return this.presentHostelResponse;
    }

    public final void newRegistration(String reAdmission, String category, String localGuardian, String localGuardianPhone, String annualIncome, String distance, String semesterId, File filePath, String hostelId, String yearCount, String hostelDetails, String isFined, String fineDetails, String feeDefaulter, String feeDetails) {
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(hostelId, "hostelId");
        Intrinsics.checkNotNullParameter(yearCount, "yearCount");
        Intrinsics.checkNotNullParameter(hostelDetails, "hostelDetails");
        Intrinsics.checkNotNullParameter(isFined, "isFined");
        Intrinsics.checkNotNullParameter(fineDetails, "fineDetails");
        Intrinsics.checkNotNullParameter(feeDefaulter, "feeDefaulter");
        Intrinsics.checkNotNullParameter(feeDetails, "feeDetails");
        try {
            RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, reAdmission);
            RequestBody create2 = RequestBody.INSTANCE.create(MultipartBody.FORM, category);
            RequestBody create3 = RequestBody.INSTANCE.create(MultipartBody.FORM, localGuardian);
            RequestBody create4 = RequestBody.INSTANCE.create(MultipartBody.FORM, localGuardianPhone);
            RequestBody create5 = RequestBody.INSTANCE.create(MultipartBody.FORM, annualIncome);
            RequestBody create6 = RequestBody.INSTANCE.create(MultipartBody.FORM, distance);
            RequestBody create7 = RequestBody.INSTANCE.create(MultipartBody.FORM, semesterId);
            RequestBody create8 = RequestBody.INSTANCE.create(MultipartBody.FORM, hostelId);
            RequestBody create9 = RequestBody.INSTANCE.create(MultipartBody.FORM, yearCount);
            RequestBody create10 = RequestBody.INSTANCE.create(MultipartBody.FORM, hostelDetails);
            RequestBody create11 = RequestBody.INSTANCE.create(MultipartBody.FORM, isFined);
            RequestBody create12 = RequestBody.INSTANCE.create(MultipartBody.FORM, fineDetails);
            RequestBody create13 = RequestBody.INSTANCE.create(MultipartBody.FORM, feeDefaulter);
            RequestBody create14 = RequestBody.INSTANCE.create(MultipartBody.FORM, feeDetails);
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
            MultipartBody.Part createFormData = MultipartBody.Part.INSTANCE.createFormData("hostelFile", filePath.getName(), progressRequestBody);
            Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
            try {
                final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$newRegistration$1
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
                        ReRegistrationViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                    }
                };
                subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda4
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ReRegistrationViewModel.newRegistration$lambda$6(Function1.this, obj);
                    }
                });
                CompositeDisposable compositeDisposable = this.compositeDisposable;
                Observable<SuccessResponse> observeOn = this.hostelRepository.newHostelReRegistrationApiCall(create, create2, create3, create4, create5, create6, create7, createFormData, create8, create9, create10, create11, create12, create13, create14).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$newRegistration$2
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
                        ReRegistrationViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.success(successResponse));
                    }
                };
                Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda5
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ReRegistrationViewModel.newRegistration$lambda$7(Function1.this, obj);
                    }
                };
                final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$newRegistration$3
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
                            ReRegistrationViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                        } else {
                            ReRegistrationViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                        }
                    }
                };
                compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel$$ExternalSyntheticLambda6
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ReRegistrationViewModel.newRegistration$lambda$8(Function1.this, obj);
                    }
                }));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newRegistration$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newRegistration$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newRegistration$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}