package in.etuwa.app.utils;

import android.content.Context;
import android.content.Intent;
import in.etuwa.app.ui.analysis.AnalysisActivity;
import in.etuwa.app.ui.login.LoginActivity;
import in.etuwa.app.ui.main.MainActivity;
import in.etuwa.app.ui.push.PushActivity;
import in.etuwa.app.ui.videoclass.player.VideoPlayerActivity;
import in.etuwa.app.ui.videoclass.player.YoutubeActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityMediator.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lin/etuwa/app/utils/ActivityMediator;", "", "()V", "startAnalysisActivity", "", "context", "Landroid/content/Context;", "startLoginActivity", "startMainActivity", "startPushActivity", "startVideoPlayerActivity", "url", "", "startYoutubeActivity", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityMediator {
    public static final ActivityMediator INSTANCE = new ActivityMediator();

    private ActivityMediator() {
    }

    public final void startMainActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(new Intent(context, (Class<?>) MainActivity.class));
    }

    public final void startLoginActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(new Intent(context, (Class<?>) LoginActivity.class));
    }

    public final void startPushActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(new Intent(context, (Class<?>) PushActivity.class));
    }

    public final void startAnalysisActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(new Intent(context, (Class<?>) AnalysisActivity.class));
    }

    public final void startYoutubeActivity(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(context, (Class<?>) YoutubeActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public final void startVideoPlayerActivity(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(context, (Class<?>) VideoPlayerActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }
}