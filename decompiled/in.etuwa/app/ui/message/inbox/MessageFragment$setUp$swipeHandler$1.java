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

/* compiled from: MessageFragment.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"in/etuwa/app/ui/message/inbox/MessageFragment$setUp$swipeHandler$1", "Lin/etuwa/app/helper/SwipeToDeleteCallback;", "onSwiped", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", CommonCssConstants.DIRECTION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
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
        InboxAdapter adapter;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final int adapterPosition = viewHolder.getAdapterPosition();
        adapter = this.this$0.getAdapter();
        final Inbox removeAt = adapter.removeAt(adapterPosition);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.requireContext());
        builder.setMessage(this.this$0.getString(R.string.delete_msg));
        final MessageFragment messageFragment = this.this$0;
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$setUp$swipeHandler$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MessageFragment$setUp$swipeHandler$1.onSwiped$lambda$0(MessageFragment.this, removeAt, dialogInterface, i);
            }
        });
        final MessageFragment messageFragment2 = this.this$0;
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$setUp$swipeHandler$1$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MessageFragment$setUp$swipeHandler$1.onSwiped$lambda$1(MessageFragment.this, removeAt, adapterPosition, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$0(MessageFragment this$0, Inbox item, DialogInterface dialogInterface, int i) {
        MessageViewModel messageViewModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        messageViewModel = this$0.getMessageViewModel();
        messageViewModel.deleteMsg(item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$1(MessageFragment this$0, Inbox item, int i, DialogInterface dialogInterface, int i2) {
        InboxAdapter adapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        adapter = this$0.getAdapter();
        adapter.restoreItem(item, i);
    }
}