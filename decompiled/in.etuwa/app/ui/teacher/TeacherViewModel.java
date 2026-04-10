package in.etuwa.app.ui.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.common.TeacherResponse;
import in.etuwa.app.data.repository.CommonRepository;
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

/* JADX INFO: compiled from: TeacherViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TeacherViewModel extends ViewModel {
    private final long CACHE_DURATION;
    private final CommonRepository commonRepository;
    private final CompositeDisposable compositeDisposable;
    private boolean isDataLoaded;
    private MutableLiveData<Resource<TeacherResponse>> teacherResponse;

    public TeacherViewModel(CommonRepository commonRepository) {
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.commonRepository = commonRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.teacherResponse = new MutableLiveData<>();
        this.CACHE_DURATION = 259200000L;
        loadDataIfNeeded();
    }

    public final void loadDataIfNeeded() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        getTeacher();
    }

    public final void getTeacher() {
        String cachedTeacher = this.commonRepository.getCachedTeacher();
        long teacherCacheTime = this.commonRepository.getTeacherCacheTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = cachedTeacher;
        if (!(str == null || str.length() == 0) && jCurrentTimeMillis - teacherCacheTime < this.CACHE_DURATION) {
            this.teacherResponse.postValue(Resource.INSTANCE.success(this.commonRepository.parseTeacher(cachedTeacher)));
            return;
        }
        this.teacherResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TeacherResponse> singleObserveOn = this.commonRepository.getTeacherApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TeacherResponse, Unit> function1 = new Function1<TeacherResponse, Unit>() { // from class: in.etuwa.app.ui.teacher.TeacherViewModel.getTeacher.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TeacherResponse teacherResponse) {
                invoke2(teacherResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TeacherResponse response) {
                CommonRepository commonRepository = TeacherViewModel.this.commonRepository;
                Intrinsics.checkNotNullExpressionValue(response, "response");
                commonRepository.saveTeacherCache(response);
                TeacherViewModel.this.teacherResponse.postValue(Resource.INSTANCE.success(response));
            }
        };
        Consumer<? super TeacherResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.teacher.TeacherViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherViewModel.getTeacher$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.teacher.TeacherViewModel.getTeacher.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                TeacherViewModel.this.teacherResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.teacher.TeacherViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TeacherViewModel.getTeacher$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTeacher$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTeacher$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TeacherResponse>> getResponse() {
        return this.teacherResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}