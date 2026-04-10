package in.etuwa.app.ui.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.noticeboard.NoticeJecc;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NoticeAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NoticeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private NoticeListener listener;
    private final ArrayList<NoticeJecc> notices = new ArrayList<>();
    private final List<String> accentColors = CollectionsKt.listOf((Object[]) new String[]{"#545996", "#1D9E75", "#BA7517"});

    /* JADX INFO: compiled from: NoticeAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/notice/NoticeAdapter$NoticeListener;", "", "checkFileExistence", "", "fileName", "", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NoticeListener {
        boolean checkFileExistence(String fileName);

        void downloadFile(String url, int position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notice, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context)\n   …ow_notice, parent, false)");
            return new ViewHolder(this, viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.notices.isEmpty()) {
            return this.notices.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.notices.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: NoticeAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0006*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0006*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0006*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/ui/notice/NoticeAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/notice/NoticeAdapter;Landroid/view/View;)V", "accentBar", "kotlin.jvm.PlatformType", "by", "Landroid/widget/TextView;", "content", "Lat/blogc/android/views/ExpandableTextView;", "heading", "time", "toggleChevron", "Landroid/widget/ImageView;", "toggleLabel", "toggleRow", "Landroid/widget/LinearLayout;", "viewBtn", "Lcom/google/android/material/button/MaterialButton;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final View accentBar;
        private final TextView by;
        private final ExpandableTextView content;
        private final TextView heading;
        final /* synthetic */ NoticeAdapter this$0;
        private final TextView time;
        private final ImageView toggleChevron;
        private final TextView toggleLabel;
        private final LinearLayout toggleRow;
        private final MaterialButton viewBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(NoticeAdapter noticeAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = noticeAdapter;
            this.accentBar = itemView.findViewById(R.id.view_accent_bar);
            this.heading = (TextView) itemView.findViewById(R.id.notice_heading);
            this.content = (ExpandableTextView) itemView.findViewById(R.id.notice_content);
            this.toggleRow = (LinearLayout) itemView.findViewById(R.id.topic_toggle);
            this.toggleLabel = (TextView) itemView.findViewById(R.id.toggle_label);
            this.toggleChevron = (ImageView) itemView.findViewById(R.id.toggle_chevron);
            this.time = (TextView) itemView.findViewById(R.id.notice_date);
            this.by = (TextView) itemView.findViewById(R.id.notice_create);
            this.viewBtn = (MaterialButton) itemView.findViewById(R.id.view_btn_hr);
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x0153 A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:3:0x0007, B:6:0x005c, B:8:0x0066, B:10:0x00a6, B:11:0x00ab, B:13:0x00ca, B:15:0x00d2, B:18:0x00e2, B:20:0x00ea, B:28:0x00f9, B:30:0x0109, B:38:0x0122, B:49:0x0163, B:39:0x012a, B:41:0x0131, B:43:0x0139, B:47:0x0142, B:48:0x0153, B:7:0x0063), top: B:54:0x0007 }] */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(final int r12) {
            /*
                Method dump skipped, instruction units count: 373
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.notice.NoticeAdapter.ViewHolder.onBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.content.isExpanded()) {
                this$0.content.collapse();
                this$0.toggleLabel.setText("Read more");
                this$0.toggleChevron.animate().rotation(0.0f).setDuration(250L).start();
            } else {
                this$0.content.expand();
                this$0.toggleLabel.setText("Show less");
                this$0.toggleChevron.animate().rotation(180.0f).setDuration(250L).start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(NoticeJecc notice, NoticeAdapter this$0, int i, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(notice, "$notice");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            String document = notice.getDocument();
            if (!(document == null || StringsKt.isBlank(document))) {
                NoticeListener noticeListener = this$0.listener;
                if (noticeListener != null) {
                    noticeListener.downloadFile(notice.getDocument(), i);
                    return;
                }
                return;
            }
            Toast.makeText(this$1.itemView.getContext(), "No document available", 0).show();
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