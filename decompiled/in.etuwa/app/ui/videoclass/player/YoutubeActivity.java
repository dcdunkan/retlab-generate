package in.etuwa.app.ui.videoclass.player;

import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import in.etuwa.app.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: YoutubeActivity.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/videoclass/player/YoutubeActivity;", "Lcom/google/android/youtube/player/YouTubeBaseActivity;", "Lcom/google/android/youtube/player/YouTubePlayer$OnInitializedListener;", "()V", "videoLink", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onInitializationFailure", "provider", "Lcom/google/android/youtube/player/YouTubePlayer$Provider;", "errorReason", "Lcom/google/android/youtube/player/YouTubeInitializationResult;", "onInitializationSuccess", "player", "Lcom/google/android/youtube/player/YouTubePlayer;", "wasRestored", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private String videoLink = "";

    @Override // com.google.android.youtube.player.YouTubeBaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Bundle extras = getIntent().getExtras();
        Intrinsics.checkNotNull(extras);
        String string = extras.getString("url");
        if (string == null) {
            string = "";
        }
        this.videoLink = string;
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (wasRestored || player == null) {
            return;
        }
        player.cueVideo(this.videoLink);
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        Intrinsics.checkNotNull(errorReason);
        if (errorReason.isUserRecoverableError()) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("There was an error initializing the YouTubePlayer \n", Arrays.copyOf(new Object[]{errorReason.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        Toast.makeText(this, format, 1).show();
    }
}