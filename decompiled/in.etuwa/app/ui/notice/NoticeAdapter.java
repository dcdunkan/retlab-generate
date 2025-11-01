package in.etuwa.app.ui.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.noticeboard.NoticeJecc;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.notice.NoticeAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: NoticeAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/notice/NoticeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/notice/NoticeAdapter$NoticeListener;", "notices", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/noticeboard/NoticeJecc;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setNoticeListener", "context", "Lin/etuwa/app/ui/notice/NoticeFragment;", "NoticeListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NoticeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private NoticeListener listener;
    private final ArrayList<NoticeJecc> notices = new ArrayList<>();

    /* compiled from: NoticeAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/notice/NoticeAdapter$NoticeListener;", "", "checkFileExistence", "", "fileName", "", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NoticeListener {
        boolean checkFileExistence(String fileName);

        void downloadFile(String url, int position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notice, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ow_notice, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.notices.size() > 0) {
            return this.notices.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.notices.isEmpty() ? 1 : 0;
    }

    /* compiled from: NoticeAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/notice/NoticeAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/notice/NoticeAdapter;Landroid/view/View;)V", "by", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "content", "Lat/blogc/android/views/ExpandableTextView;", "heading", "time", "toggle", "viewBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView by;
        private final ExpandableTextView content;
        private final TextView heading;
        final /* synthetic */ NoticeAdapter this$0;
        private final TextView time;
        private final TextView toggle;
        private final TextView viewBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(NoticeAdapter noticeAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = noticeAdapter;
            this.heading = (TextView) itemView.findViewById(R.id.notice_heading);
            this.content = (ExpandableTextView) itemView.findViewById(R.id.notice_content);
            this.toggle = (TextView) itemView.findViewById(R.id.topic_toggle);
            this.time = (TextView) itemView.findViewById(R.id.notice_date);
            this.by = (TextView) itemView.findViewById(R.id.notice_create);
            this.viewBtn = (TextView) itemView.findViewById(R.id.view_btn_hr);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.notices.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "notices[position]");
                final NoticeJecc noticeJecc = (NoticeJecc) obj;
                this.heading.setText(noticeJecc.getHeading());
                String content = noticeJecc.getContent();
                if (StringsKt.contains$default((CharSequence) content, (CharSequence) "&nbsp;", false, 2, (Object) null)) {
                    this.content.setText(StringsKt.replace(content, "&nbsp;", "", true));
                } else {
                    this.content.setText(noticeJecc.getContent());
                }
                if (!Intrinsics.areEqual(noticeJecc.getDocument(), "")) {
                    this.viewBtn.setVisibility(0);
                } else {
                    this.viewBtn.setVisibility(8);
                }
                this.time.setText("Date : " + noticeJecc.getCreatedTime());
                this.by.setText(noticeJecc.getCreateBy());
                String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(noticeJecc.getDocument(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                NoticeListener noticeListener = this.this$0.listener;
                Boolean valueOf = noticeListener != null ? Boolean.valueOf(noticeListener.checkFileExistence(replace)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    this.viewBtn.setText("Open");
                    this.viewBtn.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
                } else {
                    this.viewBtn.setText("Download");
                    this.viewBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                }
                TextView textView = this.viewBtn;
                final NoticeAdapter noticeAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.notice.NoticeAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NoticeAdapter.ViewHolder.onBind$lambda$0(NoticeAdapter.this, noticeJecc, position, view);
                    }
                });
                this.content.setAnimationDuration(1500L);
                this.content.setInterpolator(new OvershootInterpolator());
                this.toggle.setBackgroundResource(R.drawable.ic_expand);
                this.content.setExpandInterpolator(new OvershootInterpolator());
                this.content.setCollapseInterpolator(new OvershootInterpolator());
                this.toggle.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.notice.NoticeAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NoticeAdapter.ViewHolder.onBind$lambda$1(NoticeAdapter.ViewHolder.this, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(NoticeAdapter this$0, NoticeJecc notice, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(notice, "$notice");
            NoticeListener noticeListener = this$0.listener;
            if (noticeListener != null) {
                noticeListener.downloadFile(notice.getDocument(), i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.content.toggle();
            if (this$0.content.isExpanded()) {
                this$0.content.collapse();
                this$0.toggle.setBackgroundResource(R.drawable.ic_expand);
            } else {
                this$0.content.expand();
                this$0.toggle.setBackgroundResource(R.drawable.ic_collapse);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void setNoticeListener(NoticeFragment context) {
        this.listener = context;
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void addItems(ArrayList<NoticeJecc> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.notices.clear();
        this.notices.addAll(list);
        notifyDataSetChanged();
    }
}