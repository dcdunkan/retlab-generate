package in.etuwa.app.ui.videoclass;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.video.Videos;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.videoclass.VideoClassAdapter;
import in.etuwa.app.utils.AppConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VideoClassAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class VideoClassAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private PlayerCallBack listener;
    private final ArrayList<Videos> videos = new ArrayList<>();
    private boolean readyForLoadingYoutubeThumbnail = true;
    private final ArrayList<Videos> filteredVideos = new ArrayList<>();

    /* JADX INFO: compiled from: VideoClassAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/videoclass/VideoClassAdapter$PlayerCallBack;", "", "loadPlayer", "", "video", "Lin/etuwa/app/data/model/video/Videos;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PlayerCallBack {
        void loadPlayer(Videos video);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_video, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …row_video, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.videos.size() > 0) {
            return this.videos.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.videos.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: VideoClassAdapter.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/ui/videoclass/VideoClassAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/videoclass/VideoClassAdapter;Landroid/view/View;)V", "card", "Landroidx/cardview/widget/CardView;", "kotlin.jvm.PlatformType", "date", "Landroid/widget/TextView;", "descriptionTxt", SvgConstants.Tags.IMAGE, "Lcom/google/android/youtube/player/YouTubeThumbnailView;", "sem", "subject", "title", "web", "Landroid/webkit/WebView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final CardView card;
        private final TextView date;
        private final TextView descriptionTxt;
        private final YouTubeThumbnailView image;
        private final TextView sem;
        private final TextView subject;
        final /* synthetic */ VideoClassAdapter this$0;
        private final TextView title;
        private final WebView web;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(VideoClassAdapter videoClassAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = videoClassAdapter;
            this.image = (YouTubeThumbnailView) itemView.findViewById(R.id.iv_yt_thumbnail);
            this.web = (WebView) itemView.findViewById(R.id.wv_thumbnail);
            this.card = (CardView) itemView.findViewById(R.id.video_card);
            this.subject = (TextView) itemView.findViewById(R.id.tv_sub);
            this.title = (TextView) itemView.findViewById(R.id.tv_title);
            this.date = (TextView) itemView.findViewById(R.id.tv_date);
            this.descriptionTxt = (TextView) itemView.findViewById(R.id.tv_description);
            this.sem = (TextView) itemView.findViewById(R.id.tv_sem);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.videos.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "videos[position]");
                final Videos videos = (Videos) obj;
                this.subject.setText(videos.getSubject());
                this.title.setText(videos.getTitle());
                this.descriptionTxt.setText(videos.getDescription());
                this.sem.setText(videos.getSem());
                this.date.setText("Date : " + StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) videos.getDate(), new String[]{HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR}, false, 0, 6, (Object) null).get(0)).toString());
                if (videos.getType() == 0) {
                    this.image.setVisibility(0);
                    this.web.setVisibility(8);
                    if (this.this$0.readyForLoadingYoutubeThumbnail) {
                        this.this$0.readyForLoadingYoutubeThumbnail = false;
                        YouTubeThumbnailView youTubeThumbnailView = this.image;
                        final VideoClassAdapter videoClassAdapter = this.this$0;
                        youTubeThumbnailView.initialize(AppConstant.YOUTUBE_DEVELOPER_KEY, new YouTubeThumbnailView.OnInitializedListener() { // from class: in.etuwa.app.ui.videoclass.VideoClassAdapter$ViewHolder$onBind$1
                            @Override // com.google.android.youtube.player.YouTubeThumbnailView.OnInitializedListener
                            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView2, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                                Intrinsics.checkNotNullParameter(youTubeThumbnailView2, "youTubeThumbnailView");
                                Intrinsics.checkNotNullParameter(youTubeThumbnailLoader, "youTubeThumbnailLoader");
                                youTubeThumbnailLoader.setVideo(videos.getUrl());
                                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() { // from class: in.etuwa.app.ui.videoclass.VideoClassAdapter$ViewHolder$onBind$1$onInitializationSuccess$1
                                    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener
                                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView3, String s) {
                                        Intrinsics.checkNotNullParameter(youTubeThumbnailView3, "youTubeThumbnailView");
                                        Intrinsics.checkNotNullParameter(s, "s");
                                        youTubeThumbnailLoader.release();
                                    }

                                    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener
                                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView3, YouTubeThumbnailLoader.ErrorReason errorReason) {
                                        Intrinsics.checkNotNullParameter(youTubeThumbnailView3, "youTubeThumbnailView");
                                        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
                                        youTubeThumbnailLoader.release();
                                    }
                                });
                                videoClassAdapter.readyForLoadingYoutubeThumbnail = true;
                            }

                            @Override // com.google.android.youtube.player.YouTubeThumbnailView.OnInitializedListener
                            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView2, YouTubeInitializationResult youTubeInitializationResult) {
                                Intrinsics.checkNotNullParameter(youTubeThumbnailView2, "youTubeThumbnailView");
                                Intrinsics.checkNotNullParameter(youTubeInitializationResult, "youTubeInitializationResult");
                                videoClassAdapter.readyForLoadingYoutubeThumbnail = true;
                            }
                        });
                    }
                } else {
                    this.image.setVisibility(8);
                    this.web.setVisibility(0);
                    WebSettings settings = this.web.getSettings();
                    Intrinsics.checkNotNullExpressionValue(settings, "web.settings");
                    settings.setJavaScriptEnabled(true);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setSupportMultipleWindows(true);
                    settings.setMediaPlaybackRequiresUserGesture(false);
                    settings.setDomStorageEnabled(true);
                    this.web.setWebChromeClient(new WebChromeClient());
                    this.web.loadUrl(videos.getUrl());
                }
                CardView cardView = this.card;
                final VideoClassAdapter videoClassAdapter2 = this.this$0;
                cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.videoclass.VideoClassAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoClassAdapter.ViewHolder.onBind$lambda$0(videoClassAdapter2, videos, view);
                    }
                });
                WebView webView = this.web;
                final VideoClassAdapter videoClassAdapter3 = this.this$0;
                webView.setOnTouchListener(new View.OnTouchListener() { // from class: in.etuwa.app.ui.videoclass.VideoClassAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return VideoClassAdapter.ViewHolder.onBind$lambda$1(videoClassAdapter3, videos, view, motionEvent);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(VideoClassAdapter this$0, Videos video, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(video, "$video");
            PlayerCallBack playerCallBack = this$0.listener;
            if (playerCallBack != null) {
                playerCallBack.loadPlayer(video);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onBind$lambda$1(VideoClassAdapter this$0, Videos video, View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(video, "$video");
            PlayerCallBack playerCallBack = this$0.listener;
            if (playerCallBack == null) {
                return false;
            }
            playerCallBack.loadPlayer(video);
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Videos> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.videos.clear();
        this.videos.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyCombinedFilter(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList<in.etuwa.app.data.model.video.Videos> r0 = r11.filteredVideos
            r0.clear()
            java.util.ArrayList<in.etuwa.app.data.model.video.Videos> r0 = r11.videos
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L78
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r12 = r12.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L2f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L73
            java.lang.Object r4 = r0.next()
            r5 = r4
            in.etuwa.app.data.model.video.Videos r5 = (in.etuwa.app.data.model.video.Videos) r5
            java.lang.String r6 = r5.getSubject()
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = r12
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8 = 0
            r9 = 2
            r10 = 0
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r7, r8, r9, r10)
            if (r6 != 0) goto L6c
            java.lang.String r5 = r5.getTitle()
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r7, r8, r9, r10)
            if (r5 == 0) goto L6d
        L6c:
            r8 = 1
        L6d:
            if (r8 == 0) goto L2f
            r3.add(r4)
            goto L2f
        L73:
            java.util.List r3 = (java.util.List) r3
            r0 = r3
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L78:
            java.util.ArrayList<in.etuwa.app.data.model.video.Videos> r12 = r11.filteredVideos
            java.util.Collection r0 = (java.util.Collection) r0
            r12.addAll(r0)
            r11.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.videoclass.VideoClassAdapter.applyCombinedFilter(java.lang.String):void");
    }

    public final void setPlayerCallBack(VideoClassFragment context) {
        this.listener = context;
    }
}