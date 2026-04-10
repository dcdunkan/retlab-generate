package in.etuwa.app.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.calendar.AttendanceDetails;
import in.etuwa.app.data.model.calendar.CalendarResponse;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.dash.LibraryResponse;
import in.etuwa.app.data.model.dash.MaintenanceResponse;
import in.etuwa.app.data.model.dash.PendingSurvey;
import in.etuwa.app.data.model.main.CourseSurveyPending;
import in.etuwa.app.data.model.main.POSurveyPending;
import in.etuwa.app.data.model.main.SurveyMandatory;
import in.etuwa.app.data.model.main.SurveyPending;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.model.result.univ.UnivTotalResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.data.repository.DashRepository;
import in.etuwa.app.ui.dashboard.dashtable.TimeTableMonthlyNewResponse;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: DashboardViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashboardViewModel extends ViewModel implements KoinComponent {
    private static final String CACHE_ATT_DETAILS = "cache_att_details";
    private static final String CACHE_CALENDAR_EVENTS = "cache_calendar_events";
    private static final String CACHE_COURSE_SURVEY_STATUS = "cache_course_survey_status";
    private static final String CACHE_LIBRARY = "cache_library";
    private static final String CACHE_MAINTENANCE = "cache_maintenance";
    private static final String CACHE_NOTICE = "cache_notice";
    private static final String CACHE_PENDING_SURVEY_STATUS = "cache_pending_survey_status";
    private static final String CACHE_PO_SURVEY_STATUS = "cache_po_survey_status";
    private static final String CACHE_RESULT_PREFIX = "cache_result_";
    private static final String CACHE_SURVEY_MANDATORY_STATUS = "cache_survey_mandatory_status";
    private static final String CACHE_SURVEY_STATUS = "cache_survey_status";
    private static final String CACHE_TIMETABLE_PREFIX = "cache_timetable_";
    private final MutableLiveData<Boolean> _isSetUpCalled;
    private final MutableLiveData<Resource<CalendarResponse>> calEventsResponse;
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<CourseSurveyPending>> courseSurveyPendingResponse;
    private final MutableLiveData<Resource<AttendanceDetails>> dashAttResponse;
    private final DashRepository dashRepository;
    private final MutableLiveData<Resource<DashResponse>> dashResponse;
    private boolean isLoadingDashboard;
    private final LiveData<Boolean> isSetUpCalled;
    private MutableLiveData<Resource<LibraryResponse>> libraryResponse;
    private final MutableLiveData<Resource<MaintenanceResponse>> maintenanceResponse;
    private MutableLiveData<Resource<NoticeResponse>> noticeResponse;
    private final MutableLiveData<Resource<POSurveyPending>> poSurveyPendingResponse;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private MutableLiveData<Resource<UnivTotalResponse>> resultResponse;
    private final MutableLiveData<Resource<ArrayList<Semester>>> semResponse;
    private final MutableLiveData<Resource<SurveyMandatory>> surveyMandatoryResponse;
    private final MutableLiveData<Resource<SurveyPending>> surveyPendingResponse;
    private final MutableLiveData<Resource<PendingSurvey>> surveyResponse;
    private MutableLiveData<Resource<TimeTableMonthlyNewResponse>> tableNewResponse;

    public DashboardViewModel(DashRepository dashRepository) {
        Intrinsics.checkNotNullParameter(dashRepository, "dashRepository");
        this.dashRepository = dashRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.dashResponse = new MutableLiveData<>();
        this.dashAttResponse = new MutableLiveData<>();
        final DashboardViewModel dashboardViewModel = this;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = dashboardViewModel;
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
        this.tableNewResponse = new MutableLiveData<>();
        this.maintenanceResponse = new MutableLiveData<>();
        this.surveyResponse = new MutableLiveData<>();
        this.surveyPendingResponse = new MutableLiveData<>();
        this.poSurveyPendingResponse = new MutableLiveData<>();
        this.courseSurveyPendingResponse = new MutableLiveData<>();
        this.surveyMandatoryResponse = new MutableLiveData<>();
        this.calEventsResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._isSetUpCalled = mutableLiveData;
        this.isSetUpCalled = mutableLiveData;
        this.resultResponse = new MutableLiveData<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
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

    public static /* synthetic */ void getNotice$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getNotice(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getNotice(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L3b
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_notice"
            r2 = 172800000(0xa4cb800, double:8.53745436E-316)
            boolean r5 = r5.isCacheValid(r1, r2)
            if (r5 == 0) goto L3b
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1e
        L1c:
            r5 = r0
            goto L2b
        L1e:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L29
            java.lang.Class<in.etuwa.app.data.model.noticeboard.NoticeResponse> r2 = in.etuwa.app.data.model.noticeboard.NoticeResponse.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L29
            goto L2b
        L29:
            goto L1c
        L2b:
            in.etuwa.app.data.model.noticeboard.NoticeResponse r5 = (in.etuwa.app.data.model.noticeboard.NoticeResponse) r5
            if (r5 == 0) goto L3b
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.noticeboard.NoticeResponse>> r0 = r4.noticeResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L3b:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.noticeboard.NoticeResponse>> r5 = r4.noticeResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getNoticeClassApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda1 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda1
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$2 r1 = new kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel.getNotice.2
                static {
                    /*
                        in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$2 r0 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$2) in.etuwa.app.ui.dashboard.DashboardViewModel.getNotice.2.INSTANCE in.etuwa.app.ui.dashboard.DashboardViewModel$getNotice$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.C02362.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.C02362.<init>():void");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(java.lang.Throwable r1) {
                    /*
                        r0 = this;
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.C02362.invoke2(java.lang.Throwable):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable r1) {
                    /*
                        r0 = this;
                        java.lang.Throwable r1 = (java.lang.Throwable) r1
                        r0.invoke2(r1)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.C02362.invoke(java.lang.Object):java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda2 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda2
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getNotice(boolean):void");
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

    public static /* synthetic */ void getAttDetails$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getAttDetails(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAttDetails(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L3b
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_att_details"
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            boolean r5 = r5.isCacheValid(r1, r2)
            if (r5 == 0) goto L3b
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1e
        L1c:
            r5 = r0
            goto L2b
        L1e:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L29
            java.lang.Class<in.etuwa.app.data.model.calendar.AttendanceDetails> r2 = in.etuwa.app.data.model.calendar.AttendanceDetails.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L29
            goto L2b
        L29:
            goto L1c
        L2b:
            in.etuwa.app.data.model.calendar.AttendanceDetails r5 = (in.etuwa.app.data.model.calendar.AttendanceDetails) r5
            if (r5 == 0) goto L3b
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.calendar.AttendanceDetails>> r0 = r4.dashAttResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L3b:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.calendar.AttendanceDetails>> r5 = r4.dashAttResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getAttendanceDetails()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getAttDetails$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getAttDetails$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda0 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda0
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getAttDetails$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getAttDetails$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda11 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda11
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getAttDetails(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttDetails$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttDetails$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<AttendanceDetails>> getAttResponse() {
        return this.dashAttResponse;
    }

    public static /* synthetic */ void getTimeTableData$default(DashboardViewModel dashboardViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dashboardViewModel.getTimeTableData(str, z);
    }

    public final void getTimeTableData(String date, boolean forceRefresh) {
        Object objFromJson;
        TimeTableMonthlyNewResponse timeTableMonthlyNewResponse;
        Intrinsics.checkNotNullParameter(date, "date");
        Pair<String, String> weekRange = getWeekRange(date);
        final String str = "timetable_" + weekRange.component1() + "_to_" + weekRange.component2();
        if (!forceRefresh) {
            SharedPrefManager preference = getPreference();
            String cache = preference.getCache(str);
            if (cache == null) {
                objFromJson = null;
                timeTableMonthlyNewResponse = (TimeTableMonthlyNewResponse) objFromJson;
                long cacheTime = getPreference().getCacheTime(str);
                if (timeTableMonthlyNewResponse != null && isSameDay(cacheTime)) {
                    this.tableNewResponse.postValue(Resource.INSTANCE.success(timeTableMonthlyNewResponse));
                    return;
                }
            } else {
                try {
                    objFromJson = preference.getGson().fromJson(cache, (Class<Object>) TimeTableMonthlyNewResponse.class);
                } catch (Exception unused) {
                    objFromJson = null;
                }
                timeTableMonthlyNewResponse = (TimeTableMonthlyNewResponse) objFromJson;
                long cacheTime2 = getPreference().getCacheTime(str);
                if (timeTableMonthlyNewResponse != null) {
                    this.tableNewResponse.postValue(Resource.INSTANCE.success(timeTableMonthlyNewResponse));
                    return;
                }
            }
        }
        this.tableNewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TimeTableMonthlyNewResponse> singleObserveOn = this.dashRepository.getTimeTableMonthlyApiCall(date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TimeTableMonthlyNewResponse, Unit> function1 = new Function1<TimeTableMonthlyNewResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel.getTimeTableData.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TimeTableMonthlyNewResponse timeTableMonthlyNewResponse2) {
                invoke2(timeTableMonthlyNewResponse2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TimeTableMonthlyNewResponse timeTableMonthlyNewResponse2) {
                DashboardViewModel.this.getPreference().saveObjectCache(str, timeTableMonthlyNewResponse2);
                DashboardViewModel.this.getPreference().setCacheTime(str, System.currentTimeMillis());
                DashboardViewModel.this.tableNewResponse.postValue(Resource.INSTANCE.success(timeTableMonthlyNewResponse2));
            }
        };
        Consumer<? super TimeTableMonthlyNewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getTimeTableData$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel.getTimeTableData.2
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
                DashboardViewModel.this.tableNewResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getTimeTableData$lambda$5(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTimeTableData$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTimeTableData$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TimeTableMonthlyNewResponse>> getResponse() {
        return this.tableNewResponse;
    }

    public static /* synthetic */ void getDashData$default(DashboardViewModel dashboardViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dashboardViewModel.getDashData(str, z);
    }

    public final void getDashData(String hostel, boolean forceRefresh) {
        if (!forceRefresh) {
            DashResponse dashCache = getPreference().getDashCache();
            long dashCacheTime = getPreference().getDashCacheTime();
            if (dashCache != null && isSameDay(dashCacheTime)) {
                this.dashResponse.postValue(Resource.INSTANCE.success(dashCache));
                return;
            }
        }
        this.dashResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DashResponse> singleObserveOn = this.dashRepository.getDashApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DashResponse, Unit> function1 = new Function1<DashResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel.getDashData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashResponse dashResponse) {
                invoke2(dashResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DashResponse response) {
                SharedPrefManager preference = DashboardViewModel.this.getPreference();
                Intrinsics.checkNotNullExpressionValue(response, "response");
                preference.setDashCache(response);
                DashboardViewModel.this.getPreference().setDashCacheTime(System.currentTimeMillis());
                DashboardViewModel.this.dashResponse.postValue(Resource.INSTANCE.success(response));
            }
        };
        Consumer<? super DashResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getDashData$lambda$6(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel.getDashData.2
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
                DashboardViewModel.this.dashResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getDashData$lambda$7(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DashResponse>> getDashResponse() {
        return this.dashResponse;
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

    public static /* synthetic */ void getLibrary$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getLibrary(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getLibrary(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_library"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.dash.LibraryResponse> r2 = in.etuwa.app.data.model.dash.LibraryResponse.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.dash.LibraryResponse r5 = (in.etuwa.app.data.model.dash.LibraryResponse) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.dash.LibraryResponse>> r0 = r4.libraryResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.dash.LibraryResponse>> r5 = r4.libraryResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getDigitalLibraryApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getLibrary$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getLibrary$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda18 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda18
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getLibrary$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getLibrary$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda19 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda19
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getLibrary(boolean):void");
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

    public static /* synthetic */ void getMaintenance$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getMaintenance(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getMaintenance(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_maintenance"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.dash.MaintenanceResponse> r2 = in.etuwa.app.data.model.dash.MaintenanceResponse.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.dash.MaintenanceResponse r5 = (in.etuwa.app.data.model.dash.MaintenanceResponse) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.dash.MaintenanceResponse>> r0 = r4.maintenanceResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.dash.MaintenanceResponse>> r5 = r4.maintenanceResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getMaintenanceUrl()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getMaintenance$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getMaintenance$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda5 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda5
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getMaintenance$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getMaintenance$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda6 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda6
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getMaintenance(boolean):void");
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

    public static /* synthetic */ void getSurveyStatus$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getSurveyStatus(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getSurveyStatus(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_survey_status"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.dash.PendingSurvey> r2 = in.etuwa.app.data.model.dash.PendingSurvey.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.dash.PendingSurvey r5 = (in.etuwa.app.data.model.dash.PendingSurvey) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.dash.PendingSurvey>> r0 = r4.surveyResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.dash.PendingSurvey>> r5 = r4.surveyResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getPendingSurveyUrl()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyStatus$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyStatus$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda12 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda12
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyStatus$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyStatus$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda13 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda13
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getSurveyStatus(boolean):void");
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

    public static /* synthetic */ void getPendingSurveyStatus$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getPendingSurveyStatus(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getPendingSurveyStatus(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_pending_survey_status"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.main.SurveyPending> r2 = in.etuwa.app.data.model.main.SurveyPending.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.main.SurveyPending r5 = (in.etuwa.app.data.model.main.SurveyPending) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.SurveyPending>> r0 = r4.surveyPendingResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.SurveyPending>> r5 = r4.surveyPendingResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getSurveyPendingStatusUrlApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getPendingSurveyStatus$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getPendingSurveyStatus$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda16 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda16
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getPendingSurveyStatus$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getPendingSurveyStatus$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda17 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda17
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getPendingSurveyStatus(boolean):void");
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

    public static /* synthetic */ void getPoSurveyStatus$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getPoSurveyStatus(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getPoSurveyStatus(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_po_survey_status"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.main.POSurveyPending> r2 = in.etuwa.app.data.model.main.POSurveyPending.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.main.POSurveyPending r5 = (in.etuwa.app.data.model.main.POSurveyPending) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.POSurveyPending>> r0 = r4.poSurveyPendingResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.POSurveyPending>> r5 = r4.poSurveyPendingResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getPoSurveyPendingStatusUrlApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getPoSurveyStatus$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getPoSurveyStatus$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda9 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda9
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getPoSurveyStatus$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getPoSurveyStatus$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda10 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda10
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getPoSurveyStatus(boolean):void");
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

    public static /* synthetic */ void getCourseSurveyStatus$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getCourseSurveyStatus(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getCourseSurveyStatus(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_course_survey_status"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.main.CourseSurveyPending> r2 = in.etuwa.app.data.model.main.CourseSurveyPending.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.main.CourseSurveyPending r5 = (in.etuwa.app.data.model.main.CourseSurveyPending) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.CourseSurveyPending>> r0 = r4.courseSurveyPendingResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.CourseSurveyPending>> r5 = r4.courseSurveyPendingResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getCourseSurveyPendingStatusUrlApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getCourseSurveyStatus$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getCourseSurveyStatus$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda20 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda20
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getCourseSurveyStatus$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getCourseSurveyStatus$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda21 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda21
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getCourseSurveyStatus(boolean):void");
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

    public static /* synthetic */ void getSurveyMandatoryStatus$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getSurveyMandatoryStatus(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getSurveyMandatoryStatus(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_survey_mandatory_status"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.main.SurveyMandatory> r2 = in.etuwa.app.data.model.main.SurveyMandatory.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.main.SurveyMandatory r5 = (in.etuwa.app.data.model.main.SurveyMandatory) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.SurveyMandatory>> r0 = r4.surveyMandatoryResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.SurveyMandatory>> r5 = r4.surveyMandatoryResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getSurveyMandatoryStatusUrlApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyMandatoryStatus$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyMandatoryStatus$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda24 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda24
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyMandatoryStatus$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getSurveyMandatoryStatus$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda25 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda25
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getSurveyMandatoryStatus(boolean):void");
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

    public static /* synthetic */ void getResult$default(DashboardViewModel dashboardViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dashboardViewModel.getResult(str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getResult(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "cache_result_"
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r0 = 0
            if (r5 != 0) goto L49
            in.etuwa.app.data.preference.SharedPrefManager r5 = r3.getPreference()
            boolean r5 = r5.is24HourCacheValid(r4)
            if (r5 == 0) goto L49
            in.etuwa.app.data.preference.SharedPrefManager r5 = r3.getPreference()
            java.lang.String r1 = r5.getCache(r4)
            if (r1 != 0) goto L2c
        L2a:
            r5 = r0
            goto L39
        L2c:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L37
            java.lang.Class<in.etuwa.app.data.model.result.univ.UnivTotalResponse> r2 = in.etuwa.app.data.model.result.univ.UnivTotalResponse.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L37
            goto L39
        L37:
            goto L2a
        L39:
            in.etuwa.app.data.model.result.univ.UnivTotalResponse r5 = (in.etuwa.app.data.model.result.univ.UnivTotalResponse) r5
            if (r5 == 0) goto L49
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.result.univ.UnivTotalResponse>> r4 = r3.resultResponse
            in.etuwa.app.utils.Resource$Companion r0 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r0.success(r5)
            r4.postValue(r5)
            return
        L49:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.result.univ.UnivTotalResponse>> r5 = r3.resultResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r3.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r3.dashRepository
            io.reactivex.Single r0 = r0.getResultUnivApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getResult$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getResult$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda22 r4 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda22
            r4.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getResult$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getResult$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda23 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda23
            r2.<init>()
            io.reactivex.disposables.Disposable r4 = r0.subscribe(r4, r2)
            r5.add(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getResult(java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getResult$lambda$22(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getResult$lambda$23(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<UnivTotalResponse>> getResultResponse() {
        return this.resultResponse;
    }

    public static /* synthetic */ void getCalendarEventts$default(DashboardViewModel dashboardViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dashboardViewModel.getCalendarEventts(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getCalendarEventts(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = "cache_calendar_events"
            boolean r5 = r5.is24HourCacheValid(r1)
            if (r5 == 0) goto L38
            in.etuwa.app.data.preference.SharedPrefManager r5 = r4.getPreference()
            java.lang.String r1 = r5.getCache(r1)
            if (r1 != 0) goto L1b
        L19:
            r5 = r0
            goto L28
        L1b:
            com.google.gson.Gson r5 = r5.getGson()     // Catch: java.lang.Exception -> L26
            java.lang.Class<in.etuwa.app.data.model.calendar.CalendarResponse> r2 = in.etuwa.app.data.model.calendar.CalendarResponse.class
            java.lang.Object r5 = r5.fromJson(r1, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
            goto L19
        L28:
            in.etuwa.app.data.model.calendar.CalendarResponse r5 = (in.etuwa.app.data.model.calendar.CalendarResponse) r5
            if (r5 == 0) goto L38
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.calendar.CalendarResponse>> r0 = r4.calEventsResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r5 = r1.success(r5)
            r0.postValue(r5)
            return
        L38:
            androidx.lifecycle.MutableLiveData<in.etuwa.app.utils.Resource<in.etuwa.app.data.model.calendar.CalendarResponse>> r5 = r4.calEventsResponse
            in.etuwa.app.utils.Resource$Companion r1 = in.etuwa.app.utils.Resource.INSTANCE
            in.etuwa.app.utils.Resource r0 = r1.loading(r0)
            r5.postValue(r0)
            io.reactivex.disposables.CompositeDisposable r5 = r4.compositeDisposable
            in.etuwa.app.data.repository.DashRepository r0 = r4.dashRepository
            io.reactivex.Single r0 = r0.getCalendarEventApiCall()
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r0 = r0.observeOn(r1)
            in.etuwa.app.ui.dashboard.DashboardViewModel$getCalendarEventts$1 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getCalendarEventts$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda26 r2 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda26
            r2.<init>()
            in.etuwa.app.ui.dashboard.DashboardViewModel$getCalendarEventts$2 r1 = new in.etuwa.app.ui.dashboard.DashboardViewModel$getCalendarEventts$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda27 r3 = new in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda27
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            r5.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.getCalendarEventts(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCalendarEventts$lambda$24(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCalendarEventts$lambda$25(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<CalendarResponse>> getEventsResponse() {
        return this.calEventsResponse;
    }

    public final void getSemesterData() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> singleObserveOn = this.dashRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel.getSemesterData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Semester> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<Semester> arrayList) {
                DashboardViewModel.this.semResponse.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSemesterData$lambda$26(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel.getSemesterData.2
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
                DashboardViewModel.this.semResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.DashboardViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardViewModel.getSemesterData$lambda$27(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemesterData$lambda$26(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemesterData$lambda$27(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemesterResponse() {
        return this.semResponse;
    }

    private final boolean isSameDay(long timestamp) {
        if (timestamp == 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public final Pair<String, String> getWeekRange(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        Date date = simpleDateFormat.parse(dateStr);
        Intrinsics.checkNotNull(date);
        calendar.setTime(date);
        calendar.set(7, 2);
        String str = simpleDateFormat.format(calendar.getTime());
        calendar.add(5, 6);
        return new Pair<>(str, simpleDateFormat.format(calendar.getTime()));
    }

    public final void loadDashboardSequentially(String date, String hostel) {
        Intrinsics.checkNotNullParameter(date, "date");
        if (this.isLoadingDashboard) {
            return;
        }
        this.isLoadingDashboard = true;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C02511(date, hostel, null), 3, null);
    }

    /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardViewModel$loadDashboardSequentially$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DashboardViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "in.etuwa.app.ui.dashboard.DashboardViewModel$loadDashboardSequentially$1", f = "DashboardViewModel.kt", i = {}, l = {534, 538, 542, 546, 550}, m = "invokeSuspend", n = {}, s = {})
    static final class C02511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $date;
        final /* synthetic */ String $hostel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02511(String str, String str2, Continuation<? super C02511> continuation) {
            super(2, continuation);
            this.$date = str;
            this.$hostel = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DashboardViewModel.this.new C02511(this.$date, this.$hostel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00aa A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00e8 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardViewModel.C02511.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}