package in.etuwa.app.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.dash.LibraryResponse;
import in.etuwa.app.data.model.dash.MaintenanceResponse;
import in.etuwa.app.data.model.dash.PendingSurvey;
import in.etuwa.app.data.model.main.CourseSurveyPending;
import in.etuwa.app.data.model.main.POSurveyPending;
import in.etuwa.app.data.model.main.SurveyMandatory;
import in.etuwa.app.data.model.main.SurveyPending;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.model.timetable.TimetableResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.data.repository.DashRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: DashboardViewModel.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u00100\u001a\u000201J\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0007J\u0006\u00103\u001a\u000201J\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u0007J\u0010\u00105\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u000201J\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000b0\u0007J\u0006\u0010:\u001a\u000201J\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\u0007J\u0006\u0010<\u001a\u000201J\u0006\u0010=\u001a\u000201J\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u000b0\u0007J\u0006\u0010?\u001a\u000201J\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000b0\u0007J\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u0007J\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\u0007J\u0006\u0010C\u001a\u000201J\"\u0010D\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'0\u000b0\u0007J\u0006\u0010E\u001a\u000201J\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u000b0\u0007J\u0006\u0010G\u001a\u000201J\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000b0\u0007J\u0006\u0010I\u001a\u000201J\u0012\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u000b0\u0007J\u0006\u0010K\u001a\u000201J\u0006\u0010L\u001a\u000201J\b\u0010M\u001a\u000201H\u0014JF\u0010N\u001a\u0002012\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u0002072\u0006\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u0002072\u0006\u00106\u001a\u00020S2\u0006\u0010T\u001a\u0002072\u0006\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020\bR\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R*\u0010$\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u000b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/component/KoinComponent;", "dashRepository", "Lin/etuwa/app/data/repository/DashRepository;", "(Lin/etuwa/app/data/repository/DashRepository;)V", "_isSetUpCalled", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "abcViewResponse", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/dash/AbcResponse;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "courseSurveyPendingResponse", "Lin/etuwa/app/data/model/main/CourseSurveyPending;", "dashResponse", "Lin/etuwa/app/data/model/dash/DashResponse;", "isSetUpCalled", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "libraryResponse", "Lin/etuwa/app/data/model/dash/LibraryResponse;", "maintenanceResponse", "Lin/etuwa/app/data/model/dash/MaintenanceResponse;", "noticeResponse", "Lin/etuwa/app/data/model/noticeboard/NoticeResponse;", "poSurveyPendingResponse", "Lin/etuwa/app/data/model/main/POSurveyPending;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "semResponse", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "surveyMandatoryResponse", "Lin/etuwa/app/data/model/main/SurveyMandatory;", "surveyPendingResponse", "Lin/etuwa/app/data/model/main/SurveyPending;", "surveyResponse", "Lin/etuwa/app/data/model/dash/PendingSurvey;", "tableResponse", "Lin/etuwa/app/data/model/timetable/TimetableResponse;", "getAbcData", "", "getAbcResponse", "getCourseSurveyStatus", "getCourseSurveyStatusResponse", "getDashData", "hostel", "", "getLibrary", "getLibraryResponse", "getMaintenance", "getMaintenanceResponse", "getNotice", "getPendingSurveyStatus", "getPendingSurveyStatusResponse", "getPoSurveyStatus", "getPoSurveyStatusResponse", "getResponse", "getResponse2", "getSemesterData", "getSemesterResponse", "getSurveyMandatoryStatus", "getSurveyMandatoryStatusResponse", "getSurveyStatus", "getSurveyStatusResponse", "getTableData", "getTimeTableResponse", "markSetUpCalled", "markSetUpNotCalled", "onCleared", "storeUpdateResponse", "batchId", "semId", "semName", "hostelStatus", "", "course", "img", "logout_status", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DashboardViewModel extends ViewModel implements KoinComponent {
    private final MutableLiveData<Boolean> _isSetUpCalled;
    private final MutableLiveData<Resource<AbcResponse>> abcViewResponse;
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<CourseSurveyPending>> courseSurveyPendingResponse;
    private final DashRepository dashRepository;
    private final MutableLiveData<Resource<DashResponse>> dashResponse;
    private final LiveData<Boolean> isSetUpCalled;
    private MutableLiveData<Resource<LibraryResponse>> libraryResponse;
    private final MutableLiveData<Resource<MaintenanceResponse>> maintenanceResponse;
    private MutableLiveData<Resource<NoticeResponse>> noticeResponse;
    private final MutableLiveData<Resource<POSurveyPending>> poSurveyPendingResponse;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private final MutableLiveData<Resource<ArrayList<Semester>>> semResponse;
    private final MutableLiveData<Resource<SurveyMandatory>> surveyMandatoryResponse;
    private final MutableLiveData<Resource<SurveyPending>> surveyPendingResponse;
    private final MutableLiveData<Resource<PendingSurvey>> surveyResponse;
    private MutableLiveData<Resource<TimetableResponse>> tableResponse;

    public DashboardViewModel(DashRepository dashRepository) {
        Intrinsics.checkNotNullParameter(dashRepository, "dashRepository");
        this.dashRepository = dashRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.dashResponse = new MutableLiveData<>();
        final DashboardViewModel dashboardViewModel = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier2, function0);
            }
        });
        this.noticeResponse = new MutableLiveData<>();
        this.libraryResponse = new MutableLiveData<>();
        this.tableResponse = new MutableLiveData<>();
        this.maintenanceResponse = new MutableLiveData<>();
        this.surveyResponse = new MutableLiveData<>();
        this.surveyPendingResponse = new MutableLiveData<>();
        this.poSurveyPendingResponse = new MutableLiveData<>();
        this.courseSurveyPendingResponse = new MutableLiveData<>();
        this.surveyMandatoryResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        this.abcViewResponse = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._isSetUpCalled = mutableLiveData;
        this.isSetUpCalled = mutableLiveData;
        getNotice();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final LiveData<Boolean> isSetUpCalled() {
        return this.isSetUpCalled;
    }

    public final void markSetUpCalled() {
        this._isSetUpCalled.setValue(true);
    }

    public final void markSetUpNotCalled() {
        this._isSetUpCalled.setValue(false);
    }

    public final void getNotice() {
        this.noticeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<NoticeResponse> observeOn = this.dashRepository.getNoticeClassApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<NoticeResponse, Unit> function1 = new Function1<NoticeResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$1
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
                mutableLiveData = DashboardViewModel.this.noticeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(noticeResponse));
            }
        };
        Consumer<? super NoticeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getNotice$lambda$0(Function1.this, obj);
            }
        };
        final DashboardViewModel$getNotice$2 dashboardViewModel$getNotice$2 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getNotice$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<NoticeResponse>> getResponse2() {
        return this.noticeResponse;
    }

    public final void getSemesterData() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> observeOn = this.dashRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getSemesterData$1
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
                mutableLiveData = DashboardViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSemesterData$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getSemesterData$2
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
                mutableLiveData = DashboardViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSemesterData$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemesterData$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemesterData$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemesterResponse() {
        return this.semResponse;
    }

    public final void getDashData(String hostel) {
        this.dashResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DashResponse> observeOn = this.dashRepository.getDashApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DashResponse, Unit> function1 = new Function1<DashResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getDashData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashResponse dashResponse) {
                invoke2(dashResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DashResponse dashResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.dashResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(dashResponse));
            }
        };
        Consumer<? super DashResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getDashData$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getDashData$2
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
                mutableLiveData = DashboardViewModel.this.dashResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getDashData$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DashResponse>> getResponse() {
        return this.dashResponse;
    }

    public final void getTableData() {
        this.tableResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TimetableResponse> observeOn = this.dashRepository.getTimetableApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TimetableResponse, Unit> function1 = new Function1<TimetableResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getTableData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TimetableResponse timetableResponse) {
                invoke2(timetableResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TimetableResponse timetableResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.tableResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(timetableResponse));
            }
        };
        Consumer<? super TimetableResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getTableData$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getTableData$2
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
                mutableLiveData = DashboardViewModel.this.tableResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getTableData$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTableData$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTableData$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TimetableResponse>> getTimeTableResponse() {
        return this.tableResponse;
    }

    public final void storeUpdateResponse(String batchId, String semId, String semName, String hostelStatus, int hostel, String course, String img, boolean logout_status) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(semName, "semName");
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(img, "img");
        this.dashRepository.setUpdatedValues(batchId, semId, semName, hostelStatus, hostel, course, img, logout_status);
    }

    public final void getLibrary() {
        this.libraryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<LibraryResponse> observeOn = this.dashRepository.getDigitalLibraryApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<LibraryResponse, Unit> function1 = new Function1<LibraryResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getLibrary$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LibraryResponse libraryResponse) {
                invoke2(libraryResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LibraryResponse libraryResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.libraryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(libraryResponse));
            }
        };
        Consumer<? super LibraryResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getLibrary$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getLibrary$2
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
                mutableLiveData = DashboardViewModel.this.libraryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getLibrary$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLibrary$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLibrary$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<LibraryResponse>> getLibraryResponse() {
        return this.libraryResponse;
    }

    public final void getMaintenance() {
        this.maintenanceResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<MaintenanceResponse> observeOn = this.dashRepository.getMaintenanceUrl().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<MaintenanceResponse, Unit> function1 = new Function1<MaintenanceResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getMaintenance$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MaintenanceResponse maintenanceResponse) {
                invoke2(maintenanceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MaintenanceResponse maintenanceResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.maintenanceResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(maintenanceResponse));
            }
        };
        Consumer<? super MaintenanceResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getMaintenance$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getMaintenance$2
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
                mutableLiveData = DashboardViewModel.this.maintenanceResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getMaintenance$lambda$11(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMaintenance$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMaintenance$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<MaintenanceResponse>> getMaintenanceResponse() {
        return this.maintenanceResponse;
    }

    public final void getSurveyStatus() {
        this.surveyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<PendingSurvey> observeOn = this.dashRepository.getPendingSurveyUrl().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<PendingSurvey, Unit> function1 = new Function1<PendingSurvey, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PendingSurvey pendingSurvey) {
                invoke2(pendingSurvey);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PendingSurvey pendingSurvey) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(pendingSurvey));
            }
        };
        Consumer<? super PendingSurvey> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSurveyStatus$lambda$12(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyStatus$2
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
                mutableLiveData = DashboardViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSurveyStatus$lambda$13(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyStatus$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyStatus$lambda$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<PendingSurvey>> getSurveyStatusResponse() {
        return this.surveyResponse;
    }

    public final void getPendingSurveyStatus() {
        this.surveyPendingResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SurveyPending> observeOn = this.dashRepository.getSurveyPendingStatusUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SurveyPending, Unit> function1 = new Function1<SurveyPending, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getPendingSurveyStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SurveyPending surveyPending) {
                invoke2(surveyPending);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurveyPending surveyPending) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.surveyPendingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(surveyPending));
            }
        };
        Consumer<? super SurveyPending> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getPendingSurveyStatus$lambda$14(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getPendingSurveyStatus$2
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
                mutableLiveData = DashboardViewModel.this.surveyPendingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getPendingSurveyStatus$lambda$15(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPendingSurveyStatus$lambda$14(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPendingSurveyStatus$lambda$15(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SurveyPending>> getPendingSurveyStatusResponse() {
        return this.surveyPendingResponse;
    }

    public final void getPoSurveyStatus() {
        this.poSurveyPendingResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<POSurveyPending> observeOn = this.dashRepository.getPoSurveyPendingStatusUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<POSurveyPending, Unit> function1 = new Function1<POSurveyPending, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getPoSurveyStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(POSurveyPending pOSurveyPending) {
                invoke2(pOSurveyPending);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(POSurveyPending pOSurveyPending) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.poSurveyPendingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(pOSurveyPending));
            }
        };
        Consumer<? super POSurveyPending> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getPoSurveyStatus$lambda$16(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getPoSurveyStatus$2
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
                mutableLiveData = DashboardViewModel.this.poSurveyPendingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getPoSurveyStatus$lambda$17(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPoSurveyStatus$lambda$16(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPoSurveyStatus$lambda$17(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<POSurveyPending>> getPoSurveyStatusResponse() {
        return this.poSurveyPendingResponse;
    }

    public final void getCourseSurveyStatus() {
        this.courseSurveyPendingResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CourseSurveyPending> observeOn = this.dashRepository.getCourseSurveyPendingStatusUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CourseSurveyPending, Unit> function1 = new Function1<CourseSurveyPending, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getCourseSurveyStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CourseSurveyPending courseSurveyPending) {
                invoke2(courseSurveyPending);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CourseSurveyPending courseSurveyPending) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.courseSurveyPendingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(courseSurveyPending));
            }
        };
        Consumer<? super CourseSurveyPending> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getCourseSurveyStatus$lambda$18(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getCourseSurveyStatus$2
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
                mutableLiveData = DashboardViewModel.this.courseSurveyPendingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getCourseSurveyStatus$lambda$19(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCourseSurveyStatus$lambda$18(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCourseSurveyStatus$lambda$19(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<CourseSurveyPending>> getCourseSurveyStatusResponse() {
        return this.courseSurveyPendingResponse;
    }

    public final void getSurveyMandatoryStatus() {
        this.surveyMandatoryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SurveyMandatory> observeOn = this.dashRepository.getSurveyMandatoryStatusUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SurveyMandatory, Unit> function1 = new Function1<SurveyMandatory, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyMandatoryStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SurveyMandatory surveyMandatory) {
                invoke2(surveyMandatory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurveyMandatory surveyMandatory) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.surveyMandatoryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(surveyMandatory));
            }
        };
        Consumer<? super SurveyMandatory> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSurveyMandatoryStatus$lambda$20(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyMandatoryStatus$2
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
                mutableLiveData = DashboardViewModel.this.surveyMandatoryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSurveyMandatoryStatus$lambda$21(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyMandatoryStatus$lambda$20(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyMandatoryStatus$lambda$21(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SurveyMandatory>> getSurveyMandatoryStatusResponse() {
        return this.surveyMandatoryResponse;
    }

    public final void getAbcData() {
        this.abcViewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<AbcResponse> observeOn = this.dashRepository.getAbcViewApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<AbcResponse, Unit> function1 = new Function1<AbcResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getAbcData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AbcResponse abcResponse) {
                invoke2(abcResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AbcResponse abcResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DashboardViewModel.this.abcViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(abcResponse));
            }
        };
        Consumer<? super AbcResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getAbcData$lambda$22(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$getAbcData$2
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
                mutableLiveData = DashboardViewModel.this.abcViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getAbcData$lambda$23(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAbcData$lambda$22(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAbcData$lambda$23(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<AbcResponse>> getAbcResponse() {
        return this.abcViewResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}