package in.etuwa.app.ui.grievance.add;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.grievance.type.GrievanceTypeResponse;
import in.etuwa.app.data.model.grievance.view.ViewGrievanceResponse;
import in.etuwa.app.data.repository.GrievanceRepository;
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

/* compiled from: AddGrievanceDialogViewModel.kt */
/* loaded from: classes4.dex */
public final class AddGrievanceDialogViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> addGrievanceResponse;
    private final CompositeDisposable compositeDisposable;
    private final GrievanceRepository grievanceRepository;
    private MutableLiveData<Resource<GrievanceTypeResponse>> grievanceTypeResponse;
    private ArrayList<MultipartBody.Part> multipartFile;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<ViewGrievanceResponse>> viewGrievanceResponse;

    public AddGrievanceDialogViewModel(GrievanceRepository grievanceRepository) {
        Intrinsics.checkNotNullParameter(grievanceRepository, "grievanceRepository");
        this.grievanceRepository = grievanceRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.grievanceTypeResponse = new MutableLiveData<>();
        this.viewGrievanceResponse = new MutableLiveData<>();
        this.addGrievanceResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
        this.multipartFile = new ArrayList<>();
        getGrievanceTypes();
    }

    public final MutableLiveData<Resource<SuccessResponse>> getAddGrievanceResponse() {
        return this.addGrievanceResponse;
    }

    public final void setAddGrievanceResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.addGrievanceResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    private final void getGrievanceTypes() {
        this.grievanceTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<GrievanceTypeResponse> observeOn = this.grievanceRepository.getGrievanceTypeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<GrievanceTypeResponse, Unit> function1 = new Function1<GrievanceTypeResponse, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$getGrievanceTypes$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GrievanceTypeResponse grievanceTypeResponse) {
                invoke2(grievanceTypeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GrievanceTypeResponse grievanceTypeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AddGrievanceDialogViewModel.this.grievanceTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(grievanceTypeResponse));
            }
        };
        Consumer<? super GrievanceTypeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.getGrievanceTypes$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$getGrievanceTypes$2
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
                mutableLiveData = AddGrievanceDialogViewModel.this.grievanceTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.getGrievanceTypes$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrievanceTypes$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrievanceTypes$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void viewGrievance(String id) {
        this.viewGrievanceResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ViewGrievanceResponse> observeOn = this.grievanceRepository.viewGrievanceApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewGrievanceResponse, Unit> function1 = new Function1<ViewGrievanceResponse, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$viewGrievance$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGrievanceResponse viewGrievanceResponse) {
                invoke2(viewGrievanceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGrievanceResponse viewGrievanceResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AddGrievanceDialogViewModel.this.viewGrievanceResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(viewGrievanceResponse));
            }
        };
        Consumer<? super ViewGrievanceResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.viewGrievance$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$viewGrievance$2
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
                mutableLiveData = AddGrievanceDialogViewModel.this.viewGrievanceResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.viewGrievance$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewGrievance$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewGrievance$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void addGrievance(HashMap<String, RequestBody> map, ArrayList<File> pickFiles) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(pickFiles, "pickFiles");
        this.multipartFile.clear();
        if (pickFiles.size() == 0) {
            this.addGrievanceResponse.postValue(Resource.INSTANCE.loading(null));
        } else {
            for (File file : pickFiles) {
                ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, FilesKt.getExtension(file), 1);
                this.multipartFile.add(MultipartBody.Part.INSTANCE.createFormData("Grievance[file][]", file.getName(), progressRequestBody));
                Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
                final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$addGrievance$1$1
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
                        AddGrievanceDialogViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                    }
                };
                subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda5
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        AddGrievanceDialogViewModel.addGrievance$lambda$5$lambda$4(Function1.this, obj);
                    }
                });
            }
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SuccessResponse> observeOn = this.grievanceRepository.addGrievanceApiCall(map, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$addGrievance$2
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
                AddGrievanceDialogViewModel.this.getAddGrievanceResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.addGrievance$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$addGrievance$3
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
                System.out.println((Object) ("============================================= " + th.getMessage()));
                AddGrievanceDialogViewModel.this.getAddGrievanceResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.addGrievance$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addGrievance$lambda$5$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addGrievance$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addGrievance$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void updateGrievance(RequestBody id, HashMap<String, RequestBody> map, ArrayList<File> pickFiles) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(pickFiles, "pickFiles");
        this.multipartFile.clear();
        if (pickFiles.size() == 0) {
            this.addGrievanceResponse.postValue(Resource.INSTANCE.loading(null));
        } else {
            for (File file : pickFiles) {
                ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, FilesKt.getExtension(file), 1);
                this.multipartFile.add(MultipartBody.Part.INSTANCE.createFormData("Grievance[file][]", file.getName(), progressRequestBody));
                Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
                final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$updateGrievance$1$1
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
                        AddGrievanceDialogViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                    }
                };
                subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        AddGrievanceDialogViewModel.updateGrievance$lambda$9$lambda$8(Function1.this, obj);
                    }
                });
            }
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SuccessResponse> observeOn = this.grievanceRepository.updateGrievanceApiCall(id, map, this.multipartFile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$updateGrievance$2
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
                AddGrievanceDialogViewModel.this.getAddGrievanceResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.updateGrievance$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$updateGrievance$3
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
                AddGrievanceDialogViewModel.this.getAddGrievanceResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddGrievanceDialogViewModel.updateGrievance$lambda$11(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGrievance$lambda$9$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGrievance$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGrievance$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<GrievanceTypeResponse>> getTypeResponse() {
        return this.grievanceTypeResponse;
    }

    public final MutableLiveData<Resource<ViewGrievanceResponse>> getViewResponse() {
        return this.viewGrievanceResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}