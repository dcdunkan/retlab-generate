package in.etuwa.app.ui.notice;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.noticeboard.NoticeJeccResponse;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
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

/* compiled from: NoticeViewModel.kt */
/* loaded from: classes5.dex */
public final class NoticeViewModel extends ViewModel {
    private final CommonRepository commonRepository;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<NoticeResponse>> noticeMainResponse;
    private MutableLiveData<Resource<NoticeJeccResponse>> noticeResponse;

    public NoticeViewModel(CommonRepository commonRepository) {
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.commonRepository = commonRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.noticeResponse = new MutableLiveData<>();
        this.noticeMainResponse = new MutableLiveData<>();
        getNotice();
    }

    public final void getNotice() {
        this.noticeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<NoticeJeccResponse> observeOn = this.commonRepository.getNoticeClassJeccApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<NoticeJeccResponse, Unit> function1 = new Function1<NoticeJeccResponse, Unit>() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$getNotice$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NoticeJeccResponse noticeJeccResponse) {
                invoke2(noticeJeccResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NoticeJeccResponse noticeJeccResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = NoticeViewModel.this.noticeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(noticeJeccResponse));
            }
        };
        Consumer<? super NoticeJeccResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NoticeViewModel.getNotice$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$getNotice$2
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
                mutableLiveData = NoticeViewModel.this.noticeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NoticeViewModel.getNotice$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNotice$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNotice$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<NoticeJeccResponse>> getResponse() {
        return this.noticeResponse;
    }

    public final void getNoticeMain() {
        this.noticeMainResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<NoticeResponse> observeOn = this.commonRepository.getNoticeClassApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<NoticeResponse, Unit> function1 = new Function1<NoticeResponse, Unit>() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$getNoticeMain$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NoticeResponse noticeResponse) {
                invoke2(noticeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NoticeResponse noticeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = NoticeViewModel.this.noticeMainResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(noticeResponse));
            }
        };
        Consumer<? super NoticeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NoticeViewModel.getNoticeMain$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$getNoticeMain$2
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
                mutableLiveData = NoticeViewModel.this.noticeMainResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.notice.NoticeViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NoticeViewModel.getNoticeMain$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNoticeMain$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNoticeMain$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<NoticeResponse>> getResponseMain() {
        return this.noticeMainResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}