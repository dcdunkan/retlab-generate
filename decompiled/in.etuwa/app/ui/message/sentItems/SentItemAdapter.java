package in.etuwa.app.ui.message.sentItems;

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
import in.etuwa.app.data.model.message.Outbox;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.message.inbox.MessageFragment;
import in.etuwa.app.ui.message.sentItems.SentItemAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SentItemAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SentItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private final ArrayList<Outbox> outbox = new ArrayList<>();

    /* JADX INFO: compiled from: SentItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/message/sentItems/SentItemAdapter$CallBack;", "", "onRead", "", NotificationCompat.CATEGORY_MESSAGE, "Lin/etuwa/app/data/model/message/Outbox;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onRead(Outbox msg);
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
        if (this.outbox.size() > 0) {
            return this.outbox.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.outbox.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: SentItemAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/message/sentItems/SentItemAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/message/sentItems/SentItemAdapter;Landroid/view/View;)V", "badge", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "card", "Lcom/google/android/material/card/MaterialCardView;", "content", "date", "from", "subject", "applySentMessageStyling", "", "clear", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView badge;
        private final MaterialCardView card;
        private final TextView content;
        private final TextView date;
        private final TextView from;
        private final TextView subject;
        final /* synthetic */ SentItemAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SentItemAdapter sentItemAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = sentItemAdapter;
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
                Object obj = this.this$0.outbox.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "outbox[position]");
                final Outbox outbox = (Outbox) obj;
                this.itemView.getContext();
                TextView textView = this.badge;
                Character chFirstOrNull = StringsKt.firstOrNull(outbox.getTo());
                if (chFirstOrNull == null || (string = Character.valueOf(Character.toUpperCase(chFirstOrNull.charValue())).toString()) == null) {
                    string = "?";
                }
                textView.setText(string);
                TextView textView2 = this.from;
                String to = outbox.getTo();
                if (to.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char cCharAt = to.charAt(0);
                    sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt) : String.valueOf(cCharAt)));
                    String strSubstring = to.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    sb.append(strSubstring);
                    to = sb.toString();
                }
                textView2.setText("To: " + to);
                this.subject.setText(outbox.getSubject());
                this.content.setText(outbox.getContent());
                TextView textView3 = this.date;
                if (outbox.getDate().length() >= 8) {
                    String strSubstring2 = outbox.getDate().substring(0, 8);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    date = strSubstring2;
                } else {
                    date = outbox.getDate();
                }
                textView3.setText(date);
                applySentMessageStyling();
                MaterialCardView materialCardView = this.card;
                final SentItemAdapter sentItemAdapter = this.this$0;
                materialCardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.message.sentItems.SentItemAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SentItemAdapter.ViewHolder.onBind$lambda$1(sentItemAdapter, outbox, view);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(SentItemAdapter this$0, Outbox msg, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msg, "$msg");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.onRead(msg);
            }
        }

        private final void applySentMessageStyling() {
            Context context = this.itemView.getContext();
            TextView textView = this.from;
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView.setAlpha(1.0f);
            TextView textView2 = this.subject;
            textView2.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView2.setAlpha(0.9f);
            TextView textView3 = this.content;
            textView3.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView3.setAlpha(0.75f);
            TextView textView4 = this.date;
            textView4.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
            textView4.setAlpha(0.6f);
            this.badge.setAlpha(1.0f);
            this.card.setCardElevation(2.0f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Outbox> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.outbox.clear();
        this.outbox.addAll(list);
        notifyDataSetChanged();
    }

    public final Outbox removeAt(int position) {
        try {
            Outbox outboxRemove = this.outbox.remove(position);
            Intrinsics.checkNotNullExpressionValue(outboxRemove, "outbox.removeAt(position)");
            Outbox outbox = outboxRemove;
            notifyItemRemoved(position);
            return outbox;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void restoreItem(Outbox item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.outbox.add(position, item);
        notifyItemInserted(position);
    }

    public final void setCallBack(SentItemsFragment context) {
        this.listener = context;
    }

    public final void setCallBack2(MessageFragment context) {
        this.listener = context;
    }
}