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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u001c\u0010\u0017\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/ui/videoclass/player/WebChrome;", "Landroid/webkit/WebChromeClient;", "activity", "Lin/etuwa/app/ui/videoclass/player/VideoPlayerActivity;", "(Lin/etuwa/app/ui/videoclass/player/VideoPlayerActivity;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "customView", "Landroid/view/View;", "customViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "originalOrientation", "", "originalSystemUiVisibility", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "onHideCustomView", "", "onProgressChanged", SvgConstants.Tags.VIEW, "Landroid/webkit/WebView;", "progress", "onShowCustomView", "viewCallback", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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