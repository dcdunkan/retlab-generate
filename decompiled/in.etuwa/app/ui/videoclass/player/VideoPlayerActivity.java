package in.etuwa.app.ui.videoclass.player;

import android.os.Bundle;
import android.webkit.CookieManager;
import in.etuwa.app.R;
import in.etuwa.app.ui.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPlayerActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lin/etuwa/app/ui/videoclass/player/VideoPlayerActivity;", "Lin/etuwa/app/ui/base/BaseActivity;", "()V", "videoLink", "", "hideProgress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUp", "showProgress", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoPlayerActivity extends BaseActivity {
    private String videoLink = "";

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void showProgress() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        Bundle extras = getIntent().getExtras();
        Intrinsics.checkNotNull(extras);
        String string = extras.getString("url");
        if (string == null) {
            string = "";
        }
        this.videoLink = string;
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().removeSessionCookies(null);
        CookieManager.getInstance().flush();
        CookieManager.getInstance().setAcceptCookie(true);
    }
}