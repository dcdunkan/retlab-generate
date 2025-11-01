package in.etuwa.app.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import in.etuwa.app.R;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.helper.ValidChecker$$ExternalSyntheticApiModelOutline0;
import in.etuwa.app.ui.login.LoginActivity;
import in.etuwa.app.ui.main.MainActivity;
import in.etuwa.app.ui.push.NotificationActivity;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import org.json.JSONException;
import org.json.JSONObject;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: MyFirebaseMessagingService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0003J \u0010 \u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0012\u0010!\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\r0\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lin/etuwa/app/service/MyFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "Lorg/koin/core/component/KoinComponent;", "()V", "NOTIFICATION_CHANNEL_ID", "", "dataBase", "Lin/etuwa/app/data/db/MyDataBase;", "getDataBase", "()Lin/etuwa/app/data/db/MyDataBase;", "dataBase$delegate", "Lkotlin/Lazy;", "msgId", "", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "handleMessage", "", "jsonObject", "Lorg/json/JSONObject;", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "sendNotification", "title", "message", "timestamp", "storeMsgToDB", "random", "Lkotlin/ranges/ClosedRange;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MyFirebaseMessagingService extends FirebaseMessagingService implements KoinComponent {

    /* renamed from: dataBase$delegate, reason: from kotlin metadata */
    private final Lazy dataBase;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private final int msgId = random(new IntRange(0, 50));
    private final String NOTIFICATION_CHANNEL_ID = "10001";

    public MyFirebaseMessagingService() {
        final MyFirebaseMessagingService myFirebaseMessagingService = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.service.MyFirebaseMessagingService$special$$inlined$inject$default$1
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
        LazyThreadSafetyMode defaultLazyMode2 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.dataBase = LazyKt.lazy(defaultLazyMode2, (Function0) new Function0<MyDataBase>() { // from class: in.etuwa.app.service.MyFirebaseMessagingService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.db.MyDataBase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MyDataBase invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = b2;
                Function0<? extends ParametersHolder> function0 = b3;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(MyDataBase.class), qualifier2, function0);
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    private final MyDataBase getDataBase() {
        return (MyDataBase) this.dataBase.getValue();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        getPreference().setPushToken(token);
        super.onNewToken(token);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Intrinsics.checkNotNullExpressionValue(remoteMessage.getData(), "remoteMessage.data");
        if (!r0.isEmpty()) {
            try {
                handleMessage(new JSONObject(remoteMessage.getData().toString()));
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        sendNotification(remoteMessage);
    }

    private final void handleMessage(JSONObject jsonObject) {
        try {
            JSONObject jSONObject = jsonObject.getJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
            String title = jSONObject.getString("title");
            String message = jSONObject.getString("message");
            String timestamp = jSONObject.getString("timestamp");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(message, "message");
            Intrinsics.checkNotNullExpressionValue(timestamp, "timestamp");
            sendNotification(title, message, timestamp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private final void sendNotification(RemoteMessage remoteMessage) {
        MyFirebaseMessagingService myFirebaseMessagingService = this;
        Intent intent = new Intent(myFirebaseMessagingService, (Class<?>) MainActivity.class);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(myFirebaseMessagingService, 0, intent, 67108864);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(myFirebaseMessagingService, this.NOTIFICATION_CHANNEL_ID);
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        NotificationCompat.Builder contentIntent = builder.setContentText(notification != null ? notification.getBody() : null).setAutoCancel(true).setContentTitle("etlab").setSmallIcon(R.mipmap.ic_launcher).setSound(defaultUri).setContentIntent(activity);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(this, NOTIFICATI…tentIntent(pendingIntent)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            ValidChecker$$ExternalSyntheticApiModelOutline0.m599m();
            NotificationChannel m = ValidChecker$$ExternalSyntheticApiModelOutline0.m(this.NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", 4);
            m.enableLights(true);
            m.setLightColor(SupportMenu.CATEGORY_MASK);
            m.enableVibration(true);
            m.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            contentIntent.setChannelId(this.NOTIFICATION_CHANNEL_ID);
            notificationManager.createNotificationChannel(m);
        }
        notificationManager.notify(this.msgId, contentIntent.build());
    }

    private final void sendNotification(String title, String message, String timestamp) {
        MyFirebaseMessagingService myFirebaseMessagingService = this;
        Intent intent = new Intent(myFirebaseMessagingService, (Class<?>) NotificationActivity.class);
        Intent[] intentArr = {new Intent(myFirebaseMessagingService, (Class<?>) LoginActivity.class), intent};
        intent.putExtra("title", title);
        NotificationCompat.Builder sound = new NotificationCompat.Builder(myFirebaseMessagingService, this.NOTIFICATION_CHANNEL_ID).setContentTitle(title).setContentText(message).setAutoCancel(true).setContentIntent(PendingIntent.getActivities(myFirebaseMessagingService, 101, intentArr, 67108864)).setSmallIcon(R.mipmap.ic_launcher).setSound(RingtoneManager.getDefaultUri(2));
        Intrinsics.checkNotNullExpressionValue(sound, "Builder(this, NOTIFICATI…setSound(defaultSoundUri)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            ValidChecker$$ExternalSyntheticApiModelOutline0.m599m();
            NotificationChannel m = ValidChecker$$ExternalSyntheticApiModelOutline0.m(this.NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", 4);
            m.enableLights(true);
            m.setLightColor(SupportMenu.CATEGORY_MASK);
            m.enableVibration(true);
            m.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            sound.setChannelId(this.NOTIFICATION_CHANNEL_ID);
            notificationManager.createNotificationChannel(m);
        }
        notificationManager.notify(this.msgId, sound.build());
        storeMsgToDB(title, message, timestamp);
    }

    private final void storeMsgToDB(String title, String message, String timestamp) {
        getDataBase().insertData(title, message, timestamp);
    }

    private final int random(ClosedRange<Integer> closedRange) {
        return new Random().nextInt((closedRange.getEndInclusive().intValue() + 1) - closedRange.getStart().intValue()) + closedRange.getStart().intValue();
    }
}