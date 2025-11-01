package in.etuwa.app.ui.chat.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.data.model.chat.comment.Comment;
import in.etuwa.app.data.model.chat.reply.Reply;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.chat.comment.CommentAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommentAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u001eR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lin/etuwa/app/ui/chat/comment/CommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "comments", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/chat/comment/Comment;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/chat/comment/CommentAdapter$CommentInteract;", "getListener", "()Lin/etuwa/app/ui/chat/comment/CommentAdapter$CommentInteract;", "setListener", "(Lin/etuwa/app/ui/chat/comment/CommentAdapter$CommentInteract;)V", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "Lin/etuwa/app/ui/chat/comment/CommentDialog;", "CommentInteract", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommentAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Comment> comments = new ArrayList<>();
    private Context context;
    private CommentInteract listener;

    /* compiled from: CommentAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/chat/comment/CommentAdapter$CommentInteract;", "", "onOpenReplyDialog", "", "img", "", "name", "txt", "comntId", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CommentInteract {
        void onOpenReplyDialog(String img, String name, String txt, String comntId);
    }

    public final CommentInteract getListener() {
        return this.listener;
    }

    public final void setListener(CommentInteract commentInteract) {
        this.listener = commentInteract;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comments, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_comments, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.comments.size() > 0) {
            return this.comments.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.comments.isEmpty() ? 1 : 0;
    }

    /* compiled from: CommentAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/chat/comment/CommentAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/chat/comment/CommentAdapter;Landroid/view/View;)V", "commentText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "commentUser", "commentUserImg", "Lde/hdodenhof/circleimageview/CircleImageView;", "replyBtn", "replyLayout", "Landroid/widget/RelativeLayout;", "replyText", "replyUser", "replyUserImg", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView commentText;
        private final TextView commentUser;
        private final CircleImageView commentUserImg;
        private final TextView replyBtn;
        private final RelativeLayout replyLayout;
        private final TextView replyText;
        private final TextView replyUser;
        private final CircleImageView replyUserImg;
        final /* synthetic */ CommentAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(CommentAdapter commentAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = commentAdapter;
            this.commentUserImg = (CircleImageView) itemView.findViewById(R.id.comment_user_img);
            this.replyUserImg = (CircleImageView) itemView.findViewById(R.id.reply_user_img);
            this.commentUser = (TextView) itemView.findViewById(R.id.comment_user_name);
            this.commentText = (TextView) itemView.findViewById(R.id.comment_text);
            this.replyLayout = (RelativeLayout) itemView.findViewById(R.id.reply_layout);
            this.replyUser = (TextView) itemView.findViewById(R.id.reply_user_name);
            this.replyText = (TextView) itemView.findViewById(R.id.reply_text);
            this.replyBtn = (TextView) itemView.findViewById(R.id.reply_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.comments.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "comments[position]");
                final Comment comment = (Comment) obj;
                this.commentUser.setText(comment.getCommentUser());
                this.commentText.setText(comment.getComment());
                Context context = this.this$0.context;
                Intrinsics.checkNotNull(context);
                Glide.with(context).load(comment.getImg()).into(this.commentUserImg);
                ArrayList<Reply> reply = comment.getReply();
                if (!reply.isEmpty()) {
                    this.replyLayout.setVisibility(0);
                    Context context2 = this.this$0.context;
                    Intrinsics.checkNotNull(context2);
                    Glide.with(context2).load(reply.get(0).getImg()).into(this.replyUserImg);
                    this.replyUser.setText(reply.get(0).getName());
                    this.replyText.setText(reply.get(0).getReply());
                } else {
                    this.replyLayout.setVisibility(8);
                }
                TextView textView = this.replyBtn;
                final CommentAdapter commentAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.chat.comment.CommentAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommentAdapter.ViewHolder.onBind$lambda$0(CommentAdapter.this, comment, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(CommentAdapter this$0, Comment comment, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(comment, "$comment");
            CommentInteract listener = this$0.getListener();
            if (listener != null) {
                listener.onOpenReplyDialog(comment.getImg(), comment.getCommentUser(), comment.getComment(), comment.getCommentId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(Context context, ArrayList<Comment> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.context = context;
        this.comments.clear();
        this.comments.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(CommentDialog context) {
        this.listener = context;
    }
}