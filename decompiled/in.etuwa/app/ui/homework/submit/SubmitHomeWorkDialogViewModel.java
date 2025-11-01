package in.etuwa.app.ui.homework.submit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.repository.HomeWorkRepository;
import in.etuwa.app.helper.ProgressRequestBody;
import in.etuwa.app.utils.Resource;
import io.reactivex.Observable;
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

/* compiled from: SubmitHomeWorkDialogViewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/ui/homework/submit/SubmitHomeWorkDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "homeWorkRepository", "Lin/etuwa/app/data/repository/HomeWorkRepository;", "(Lin/etuwa/app/data/repository/HomeWorkRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "progressResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "", "getProgressResponse", "()Landroidx/lifecycle/MutableLiveData;", "setProgressResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "uploadResponse", "Lin/etuwa/app/data/model/SuccessResponse;", "getUploadResponse", "setUploadResponse", "onCleared", "", "submitHomework", "_id", "", "filePath", "Ljava/io/File;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubmitHomeWorkDialogViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final HomeWorkRepository homeWorkRepository;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<SuccessResponse>> uploadResponse;

    public SubmitHomeWorkDialogViewModel(HomeWorkRepository homeWorkRepository) {
        Intrinsics.checkNotNullParameter(homeWorkRepository, "homeWorkRepository");
        this.homeWorkRepository = homeWorkRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.uploadResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<SuccessResponse>> getUploadResponse() {
        return this.uploadResponse;
    }

    public final void setUploadResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.uploadResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    public final void submitHomework(String _id, File filePath) {
        Intrinsics.checkNotNullParameter(_id, "_id");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, _id);
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
        MultipartBody.Part createFormData = MultipartBody.Part.INSTANCE.createFormData("HomeworkData[file_name]", filePath.getName(), progressRequestBody);
        Observable<Float> subscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel$submitHomework$1
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
                SubmitHomeWorkDialogViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SubmitHomeWorkDialogViewModel.submitHomework$lambda$0(Function1.this, obj);
            }
        });
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SuccessResponse> observeOn = this.homeWorkRepository.submitHomeWorkApiCall(create, createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel$submitHomework$2
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
                SubmitHomeWorkDialogViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SubmitHomeWorkDialogViewModel.submitHomework$lambda$1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel$submitHomework$3
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
                    SubmitHomeWorkDialogViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                } else {
                    SubmitHomeWorkDialogViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                }
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SubmitHomeWorkDialogViewModel.submitHomework$lambda$2(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitHomework$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitHomework$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitHomework$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}