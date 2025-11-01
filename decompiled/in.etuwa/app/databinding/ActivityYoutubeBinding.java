package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.google.android.youtube.player.YouTubePlayerView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityYoutubeBinding implements ViewBinding {
    private final YouTubePlayerView rootView;
    public final YouTubePlayerView ytPlayer;

    private ActivityYoutubeBinding(YouTubePlayerView rootView, YouTubePlayerView ytPlayer) {
        this.rootView = rootView;
        this.ytPlayer = ytPlayer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public YouTubePlayerView getRoot() {
        return this.rootView;
    }

    public static ActivityYoutubeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityYoutubeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_youtube, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityYoutubeBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) rootView;
        return new ActivityYoutubeBinding(youTubePlayerView, youTubePlayerView);
    }
}