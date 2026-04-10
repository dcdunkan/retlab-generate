package in.etuwa.app.ui.push;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.PushModel;
import in.etuwa.app.helper.SwipeToDeleteCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationActivity$setUp$swipeHandler$1 extends SwipeToDeleteCallback {
    final /* synthetic */ NotificationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationActivity$setUp$swipeHandler$1(NotificationActivity notificationActivity) {
        super(notificationActivity);
        this.this$0 = notificationActivity;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final int adapterPosition = viewHolder.getAdapterPosition();
        final PushModel pushModelRemoveAt = this.this$0.getAdapter().removeAt(adapterPosition);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0);
        builder.setMessage(this.this$0.getString(R.string.delete_msg));
        final NotificationActivity notificationActivity = this.this$0;
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.push.NotificationActivity$setUp$swipeHandler$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NotificationActivity$setUp$swipeHandler$1.onSwiped$lambda$0(notificationActivity, pushModelRemoveAt, dialogInterface, i);
            }
        });
        final NotificationActivity notificationActivity2 = this.this$0;
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.push.NotificationActivity$setUp$swipeHandler$1$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NotificationActivity$setUp$swipeHandler$1.onSwiped$lambda$1(notificationActivity2, pushModelRemoveAt, adapterPosition, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$0(NotificationActivity this$0, PushModel item, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.getDataBase().deleteData(item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$1(NotificationActivity this$0, PushModel item, int i, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.getAdapter().restoreItem(item, i);
    }
}