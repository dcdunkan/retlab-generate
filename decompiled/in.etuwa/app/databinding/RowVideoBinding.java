package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.youtube.player.YouTubeThumbnailView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowVideoBinding implements ViewBinding {
    public final YouTubeThumbnailView ivYtThumbnail;
    private final CardView rootView;
    public final TextView tvDate;
    public final TextView tvDescription;
    public final TextView tvSem;
    public final TextView tvSub;
    public final TextView tvTitle;
    public final CardView videoCard;
    public final WebView wvThumbnail;

    private RowVideoBinding(CardView rootView, YouTubeThumbnailView ivYtThumbnail, TextView tvDate, TextView tvDescription, TextView tvSem, TextView tvSub, TextView tvTitle, CardView videoCard, WebView wvThumbnail) {
        this.rootView = rootView;
        this.ivYtThumbnail = ivYtThumbnail;
        this.tvDate = tvDate;
        this.tvDescription = tvDescription;
        this.tvSem = tvSem;
        this.tvSub = tvSub;
        this.tvTitle = tvTitle;
        this.videoCard = videoCard;
        this.wvThumbnail = wvThumbnail;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_video, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowVideoBinding bind(View rootView) {
        int i = R.id.iv_yt_thumbnail;
        YouTubeThumbnailView youTubeThumbnailView = (YouTubeThumbnailView) ViewBindings.findChildViewById(rootView, i);
        if (youTubeThumbnailView != null) {
            i = R.id.tv_date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tv_sem;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.tv_sub;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.tv_title;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                CardView cardView = (CardView) rootView;
                                i = R.id.wv_thumbnail;
                                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
                                if (webView != null) {
                                    return new RowVideoBinding(cardView, youTubeThumbnailView, textView, textView2, textView3, textView4, textView5, cardView, webView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}