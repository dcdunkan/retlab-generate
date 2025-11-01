package in.etuwa.app.ui.message.inbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.message.Inbox;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.message.inbox.InboxAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InboxAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eJ\u0016\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/ui/message/inbox/InboxAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "inbox", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/message/Inbox;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/message/inbox/InboxAdapter$CallBack;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAt", "restoreItem", "item", "setCallBack", "context", "Lin/etuwa/app/ui/message/inbox/MessageFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InboxAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Inbox> inbox = new ArrayList<>();
    private CallBack listener;

    /* compiled from: InboxAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/message/inbox/InboxAdapter$CallBack;", "", "onReadClick", "", "id", "", NotificationCompat.CATEGORY_MESSAGE, "Lin/etuwa/app/data/model/message/Inbox;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onReadClick(String id, Inbox msg);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_inbox, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …row_inbox, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.inbox.size() > 0) {
            return this.inbox.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.inbox.isEmpty() ? 1 : 0;
    }

    /* compiled from: InboxAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/message/inbox/InboxAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/message/inbox/InboxAdapter;Landroid/view/View;)V", "badge", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "card", "Landroid/widget/LinearLayout;", "content", "date", "from", "subject", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView badge;
        private final LinearLayout card;
        private final TextView content;
        private final TextView date;
        private final TextView from;
        private final TextView subject;
        final /* synthetic */ InboxAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(InboxAdapter inboxAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = inboxAdapter;
            this.card = (LinearLayout) itemView.findViewById(R.id.inbox_view);
            this.from = (TextView) itemView.findViewById(R.id.inbox_from);
            this.subject = (TextView) itemView.findViewById(R.id.inbox_subject);
            this.badge = (TextView) itemView.findViewById(R.id.inbox_badge);
            this.content = (TextView) itemView.findViewById(R.id.inbox_content);
            this.date = (TextView) itemView.findViewById(R.id.inbox_date);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.inbox.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "inbox[position]");
                final Inbox inbox = (Inbox) obj;
                TextView textView = this.badge;
                String upperCase = String.valueOf(StringsKt.first(inbox.getFrom())).toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                textView.setText(upperCase);
                this.from.setText(StringsKt.capitalize(inbox.getFrom()));
                this.subject.setText(inbox.getSubject());
                this.content.setText(inbox.getContent());
                TextView textView2 = this.date;
                String substring = inbox.getDate().substring(0, 8);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                textView2.setText(substring);
                if (Intrinsics.areEqual(inbox.isRead(), "1")) {
                    this.from.setTextColor(-7829368);
                    this.date.setTextColor(-7829368);
                    this.subject.setTextColor(-7829368);
                    this.content.setTextColor(-7829368);
                } else {
                    this.from.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    this.date.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    this.subject.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    this.content.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
                LinearLayout linearLayout = this.card;
                final InboxAdapter inboxAdapter = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.message.inbox.InboxAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InboxAdapter.ViewHolder.onBind$lambda$0(InboxAdapter.ViewHolder.this, inboxAdapter, inbox, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, InboxAdapter this$1, Inbox msg, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(msg, "$msg");
            this$0.from.setTextColor(-7829368);
            this$0.date.setTextColor(-7829368);
            this$0.subject.setTextColor(-7829368);
            this$0.content.setTextColor(-7829368);
            CallBack callBack = this$1.listener;
            if (callBack != null) {
                callBack.onReadClick(msg.getId(), msg);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Inbox> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.inbox.clear();
        this.inbox.addAll(list);
        notifyDataSetChanged();
    }

    public final Inbox removeAt(int position) {
        Inbox inbox = this.inbox.get(position);
        Intrinsics.checkNotNullExpressionValue(inbox, "inbox[position]");
        Inbox inbox2 = inbox;
        try {
            this.inbox.remove(position);
        } catch (IndexOutOfBoundsException unused) {
        }
        notifyDataSetChanged();
        return inbox2;
    }

    public final void restoreItem(Inbox item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.inbox.add(position, item);
        notifyDataSetChanged();
    }

    public final void setCallBack(MessageFragment context) {
        this.listener = context;
    }
}