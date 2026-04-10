package in.etuwa.app.ui.push;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.data.model.PushModel;
import in.etuwa.app.helper.SwipeToDeleteCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushActivity.kt */
/* loaded from: classes5.dex */
public final class PushActivity$setUp$swipeHandler$1 extends SwipeToDeleteCallback {
    final /* synthetic */ PushActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushActivity$setUp$swipeHandler$1(PushActivity pushActivity) {
        super(pushActivity);
        this.this$0 = pushActivity;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        PushAdapter adapter;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final int adapterPosition = viewHolder.getAdapterPosition();
        adapter = this.this$0.getAdapter();
        final PushModel removeAt = adapter.removeAt(adapterPosition);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0);
        builder.setMessage(this.this$0.getString(R.string.delete_msg));
        final PushActivity pushActivity = this.this$0;
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.push.PushActivity$setUp$swipeHandler$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PushActivity$setUp$swipeHandler$1.onSwiped$lambda$0(PushActivity.this, removeAt, dialogInterface, i);
            }
        });
        final PushActivity pushActivity2 = this.this$0;
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.push.PushActivity$setUp$swipeHandler$1$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PushActivity$setUp$swipeHandler$1.onSwiped$lambda$1(PushActivity.this, removeAt, adapterPosition, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$0(PushActivity this$0, PushModel item, DialogInterface dialogInterface, int i) {
        MyDataBase dataBase;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        dataBase = this$0.getDataBase();
        dataBase.deleteData(item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSwiped$lambda$1(PushActivity this$0, PushModel item, int i, DialogInterface dialogInterface, int i2) {
        PushAdapter adapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        adapter = this$0.getAdapter();
        adapter.restoreItem(item, i);
    }
}