package in.etuwa.app.data.network;

import in.etuwa.app.data.preference.SharedPrefManager;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: ApiClientStore.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/data/network/ApiClientStore;", "Lorg/koin/core/component/KoinComponent;", "()V", "instance", "Lin/etuwa/app/data/network/ApiService;", "getInstance", "()Lin/etuwa/app/data/network/ApiService;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "preferenceManager", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreferenceManager", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preferenceManager$delegate", "Lkotlin/Lazy;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiClientStore implements KoinComponent {
    public static final ApiClientStore INSTANCE;
    private static final HttpLoggingInterceptor logger;
    private static final OkHttpClient okHttpClient;

    /* renamed from: preferenceManager$delegate, reason: from kotlin metadata */
    private static final Lazy preferenceManager;

    private ApiClientStore() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    static {
        ApiClientStore apiClientStore = new ApiClientStore();
        INSTANCE = apiClientStore;
        final ApiClientStore apiClientStore2 = apiClientStore;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        preferenceManager = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.data.network.ApiClientStore$special$$inlined$inject$default$1
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
        HttpLoggingInterceptor level = new HttpLoggingInterceptor(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0).setLevel(HttpLoggingInterceptor.Level.BODY);
        logger = level;
        okHttpClient = new OkHttpClient.Builder().connectTimeout(20L, TimeUnit.MINUTES).readTimeout(20L, TimeUnit.MINUTES).writeTimeout(20L, TimeUnit.MINUTES).addInterceptor(level).addInterceptor(new Interceptor() { // from class: in.etuwa.app.data.network.ApiClientStore$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Request.Builder url;
                SharedPrefManager preferenceManager2;
                Intrinsics.checkNotNullParameter(chain, "chain");
                Request request = chain.request();
                HttpUrl build = request.url().newBuilder().build();
                if (request.header("No-Authentication") == null) {
                    Request.Builder method = request.newBuilder().method(request.method(), request.body());
                    preferenceManager2 = ApiClientStore.INSTANCE.getPreferenceManager();
                    url = method.addHeader("Authorization", "Bearer " + preferenceManager2.getToken()).url(build);
                } else {
                    url = request.newBuilder().method(request.method(), request.body()).url(build);
                }
                return chain.proceed(url.build());
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreferenceManager() {
        return (SharedPrefManager) preferenceManager.getValue();
    }

    public final ApiService getInstance() {
        Object create = new Retrofit.Builder().baseUrl("https://aisat.store.etlab.in/engine/web/app/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(okHttpClient).build().create(ApiService.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(ApiService::class.java)");
        return (ApiService) create;
    }
}