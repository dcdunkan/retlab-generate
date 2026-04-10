package in.etuwa.app.ui.videoclass.player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.itextpdf.svg.SvgConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPlayerActivity.kt */
/* loaded from: classes5.dex */
public final class WebChrome extends WebChromeClient {
    private final WeakReference<VideoPlayerActivity> activityRef;
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private int originalOrientation;
    private int originalSystemUiVisibility;

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView view, int progress) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public WebChrome(VideoPlayerActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityRef = new WeakReference<>(activity);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        VideoPlayerActivity videoPlayerActivity = this.activityRef.get();
        if (videoPlayerActivity != null) {
            return BitmapFactory.decodeResource(videoPlayerActivity.getApplicationContext().getResources(), 2130837573);
        }
        return null;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        VideoPlayerActivity videoPlayerActivity = this.activityRef.get();
        if (videoPlayerActivity != null) {
            View decorView = videoPlayerActivity.getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) decorView).removeView(this.customView);
            this.customView = null;
            videoPlayerActivity.getWindow().getDecorView().setSystemUiVisibility(this.originalSystemUiVisibility);
            videoPlayerActivity.setRequestedOrientation(this.originalOrientation);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.customViewCallback = null;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback viewCallback) {
        if (this.customView != null) {
            onHideCustomView();
            return;
        }
        this.customView = view;
        VideoPlayerActivity videoPlayerActivity = this.activityRef.get();
        if (videoPlayerActivity != null) {
            this.originalSystemUiVisibility = videoPlayerActivity.getWindow().getDecorView().getSystemUiVisibility();
            this.originalOrientation = videoPlayerActivity.getRequestedOrientation();
            this.customViewCallback = viewCallback;
            View decorView = videoPlayerActivity.getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) decorView).addView(this.customView, new ViewGroup.LayoutParams(-1, -1));
            videoPlayerActivity.getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
}