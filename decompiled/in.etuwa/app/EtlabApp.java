package in.etuwa.app;

import android.app.Application;
import in.etuwa.app.di.ModulesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;
import org.koin.core.context.DefaultContextExtKt;

/* JADX INFO: compiled from: EtlabApp.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EtlabApp extends Application {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static EtlabApp instance;

    /* JADX INFO: compiled from: EtlabApp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lin/etuwa/app/EtlabApp$Companion;", "", "()V", "instance", "Lin/etuwa/app/EtlabApp;", "getInstance", "()Lin/etuwa/app/EtlabApp;", "setInstance", "(Lin/etuwa/app/EtlabApp;)V", "get", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EtlabApp getInstance() {
            EtlabApp etlabApp = EtlabApp.instance;
            if (etlabApp != null) {
                return etlabApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        public final void setInstance(EtlabApp etlabApp) {
            Intrinsics.checkNotNullParameter(etlabApp, "<set-?>");
            EtlabApp.instance = etlabApp;
        }

        public final EtlabApp get() {
            return getInstance();
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        INSTANCE.setInstance(this);
        DefaultContextExtKt.startKoin(new Function1<KoinApplication, Unit>() { // from class: in.etuwa.app.EtlabApp.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KoinApplication koinApplication) {
                invoke2(koinApplication);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KoinApplication startKoin) {
                Intrinsics.checkNotNullParameter(startKoin, "$this$startKoin");
                KoinExtKt.androidContext(startKoin, EtlabApp.this);
                startKoin.modules(ModulesKt.getAppModules());
            }
        });
    }
}