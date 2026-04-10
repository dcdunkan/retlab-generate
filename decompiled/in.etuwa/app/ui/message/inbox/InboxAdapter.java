package in.etuwa.app.ui.message.inbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.card.MaterialCardView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.message.Inbox;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.message.inbox.InboxAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InboxAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class InboxAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Inbox> inbox = new ArrayList<>();
    private CallBack listener;

    /* JADX INFO: compiled from: InboxAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/message/inbox/InboxAdapter$CallBack;", "", "onReadClick", "", "id", "", NotificationCompat.CATEGORY_MESSAGE, "Lin/etuwa/app/data/model/message/Inbox;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onReadClick(String id, Inbox msg);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_inbox, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …row_inbox, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: InboxAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/message/inbox/InboxAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/message/inbox/InboxAdapter;Landroid/view/View;)V", "badge", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "card", "Lcom/google/android/material/card/MaterialCardView;", "content", "date", "from", "subject", "applyReadState", "", "isRead", "", "clear", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView badge;
        private final MaterialCardView card;
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
            this.card = (MaterialCardView) itemView.findViewById(R.id.inbox_view);
            this.from = (TextView) itemView.findViewById(R.id.inbox_from);
            this.subject = (TextView) itemView.findViewById(R.id.inbox_subject);
            this.badge = (TextView) itemView.findViewById(R.id.inbox_badge);
            this.content = (TextView) itemView.findViewById(R.id.inbox_content);
            this.date = (TextView) itemView.findViewById(R.id.inbox_date);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            String string;
            String date;
            super.onBind(position);
            try {
                Object obj = this.this$0.inbox.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "inbox[position]");
                final Inbox inbox = (Inbox) obj;
                TextView textView = this.badge;
                Character chFirstOrNull = StringsKt.firstOrNull(inbox.getFrom());
                if (chFirstOrNull == null || (string = Character.valueOf(Character.toUpperCase(chFirstOrNull.charValue())).toString()) == null) {
                    string = "?";
                }
                textView.setText(string);
                TextView textView2 = this.from;
                String from = inbox.getFrom();
                if (from.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char cCharAt = from.charAt(0);
                    sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt) : String.valueOf(cCharAt)));
                    String strSubstring = from.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    sb.append(strSubstring);
                    from = sb.toString();
                }
                textView2.setText(from);
                this.subject.setText(inbox.getSubject());
                this.content.setText(inbox.getContent());
                TextView textView3 = this.date;
                if (inbox.getDate().length() >= 8) {
                    String strSubstring2 = inbox.getDate().substring(0, 8);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    date = strSubstring2;
                } else {
                    date = inbox.getDate();
                }
                textView3.setText(date);
                applyReadState(Intrinsics.areEqual(inbox.isRead(), "1"));
                MaterialCardView materialCardView = this.card;
                final InboxAdapter inboxAdapter = this.this$0;
                materialCardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.message.inbox.InboxAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InboxAdapter.ViewHolder.onBind$lambda$1(this.f$0, inboxAdapter, inbox, view);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ViewHolder this$0, InboxAdapter this$1, Inbox msg, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(msg, "$msg");
            this$0.applyReadState(true);
            CallBack callBack = this$1.listener;
            if (callBack != null) {
                callBack.onReadClick(msg.getId(), msg);
            }
        }

        private final void applyReadState(boolean isRead) {
            Context context = this.itemView.getContext();
            if (isRead) {
                TextView textView = this.from;
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
                textView.setAlpha(0.6f);
                TextView textView2 = this.subject;
                textView2.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
                textView2.setAlpha(0.6f);
                TextView textView3 = this.content;
                textView3.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
                textView3.setAlpha(0.5f);
                TextView textView4 = this.date;
                textView4.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
                textView4.setAlpha(0.5f);
                this.badge.setAlpha(0.7f);
                this.card.setCardElevation(1.0f);
                return;
            }
            TextView textView5 = this.from;
            textView5.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView5.setAlpha(1.0f);
            TextView textView6 = this.subject;
            textView6.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView6.setAlpha(1.0f);
            TextView textView7 = this.content;
            textView7.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView7.setAlpha(0.85f);
            TextView textView8 = this.date;
            textView8.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView8.setAlpha(1.0f);
            this.badge.setAlpha(1.0f);
            this.card.setCardElevation(2.0f);
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
        this.inbox.remove(position);
        notifyItemRemoved(position);
        return inbox2;
    }

    public final void restoreItem(Inbox item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.inbox.add(position, item);
        notifyItemInserted(position);
    }

    public final void setCallBack(MessageFragment context) {
        this.listener = context;
    }
}