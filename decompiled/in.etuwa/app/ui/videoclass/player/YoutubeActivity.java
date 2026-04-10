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

/* JADX INFO: compiled from: YoutubeActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
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
        String str = String.format("There was an error initializing the YouTubePlayer \n", Arrays.copyOf(new Object[]{errorReason.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(this, str, 1).show();
    }
}