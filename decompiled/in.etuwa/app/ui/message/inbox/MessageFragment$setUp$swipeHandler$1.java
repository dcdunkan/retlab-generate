package in.etuwa.app.ui.message.inbox;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.message.Inbox;
import in.etuwa.app.helper.SwipeToDeleteCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class MessageFragment$setUp$swipeHandler$1 extends SwipeToDeleteCallback {
    final /* synthetic */ MessageFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MessageFragment$setUp$swipeHandler$1(MessageFragment messageFragment, Context context) {
        super(context);
        this.this$0 = messageFragment;
        Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final int adapterPosition = viewHolder.getAdapterPosition();
        final Inbox inboxRemoveAt = this.this$0.getAdapter().removeAt(adapterPosition);
        if (inboxRemoveAt == null) {
            this.this$0.getAdapter().notifyItemChanged(adapterPosition);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.requireContext());
        builder.setMessage(this.this$0.getString(R.string.delete_msg));
        final MessageFragment messageFragment = this.this$0;
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$setUp$swipeHandler$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MessageFragment$setUp$swipeHandler$1.onSwiped$lambda$0(messageFragment, inboxRemoveAt, dialogInterface, i);
            }
        });
        final MessageFragment messageFragment2 = this.this$0;
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$setUp$swipeHandler$1$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MessageFragment$setUp$swipeHandler$1.onSwiped$lambda$1(messageFragment2, inboxRemoveAt, adapterPosition, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$0(MessageFragment this$0, Inbox item, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.getMessageViewModel().deleteMsg(item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$1(MessageFragment this$0, Inbox item, int i, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.getAdapter().restoreItem(item, i);
    }
}