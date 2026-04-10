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

/* JADX INFO: compiled from: ActivityMediator.kt */
/* JADX INFO: loaded from: classes5.dex */
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