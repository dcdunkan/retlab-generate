package in.etuwa.app.ui.videoclass.player;

import android.os.Bundle;
import android.webkit.CookieManager;
import in.etuwa.app.R;
import in.etuwa.app.ui.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPlayerActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
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