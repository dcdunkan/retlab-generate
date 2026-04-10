package in.etuwa.app.ui.profile.mooccourse;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.mooccourse.MoocCourseResponse;
import in.etuwa.app.data.repository.ProfileRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* compiled from: MoocCourseViewModel.kt */
/* loaded from: classes5.dex */
public final class MoocCourseViewModel extends ViewModel implements KoinComponent {
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<SuccessResponse>> deleteResponse;
    private final MutableLiveData<Resource<MoocCourseResponse>> moocResponse;
    private final ProfileRepository profileRepository;

    public MoocCourseViewModel(ProfileRepository profileRepository) {
        Intrinsics.checkNotNullParameter(profileRepository, "profileRepository");
        this.profileRepository = profileRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.moocResponse = new MutableLiveData<>();
        this.deleteResponse = new MutableLiveData<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getDeleteResponse() {
        return this.deleteResponse;
    }

    public final void getMoocCourseData() {
        this.moocResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<MoocCourseResponse> observeOn = this.profileRepository.getMoocCourseUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<MoocCourseResponse, Unit> function1 = new Function1<MoocCourseResponse, Unit>() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$getMoocCourseData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MoocCourseResponse moocCourseResponse) {
                invoke2(moocCourseResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MoocCourseResponse moocCourseResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MoocCourseViewModel.this.moocResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(moocCourseResponse));
            }
        };
        Consumer<? super MoocCourseResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MoocCourseViewModel.getMoocCourseData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$getMoocCourseData$2
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
                mutableLiveData = MoocCourseViewModel.this.moocResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MoocCourseViewModel.getMoocCourseData$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMoocCourseData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMoocCourseData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<MoocCourseResponse>> getResponse() {
        return this.moocResponse;
    }

    public final void deleteMoocCourseData(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.deleteResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.profileRepository.deleteMoocCoursesUrlApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$deleteMoocCourseData$1
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
                MoocCourseViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MoocCourseViewModel.deleteMoocCourseData$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$deleteMoocCourseData$2
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
                MoocCourseViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MoocCourseViewModel.deleteMoocCourseData$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMoocCourseData$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMoocCourseData$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}