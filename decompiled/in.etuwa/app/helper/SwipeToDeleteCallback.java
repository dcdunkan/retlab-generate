package in.etuwa.app.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeToDeleteCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {
    private final ColorDrawable background;
    private final int backgroundColor;
    private final Paint clearPaint;
    private final Drawable deleteIcon;
    private final int intrinsicHeight;
    private final int intrinsicWidth;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeToDeleteCallback(Context context) {
        super(0, 4);
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_delete);
        this.deleteIcon = drawable;
        Intrinsics.checkNotNull(drawable);
        this.intrinsicWidth = drawable.getIntrinsicWidth();
        Intrinsics.checkNotNull(drawable);
        this.intrinsicHeight = drawable.getIntrinsicHeight();
        this.background = new ColorDrawable();
        this.backgroundColor = Color.parseColor("#f44336");
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.clearPaint = paint;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        int bottom = view.getBottom() - view.getTop();
        if (((dX > 0.0f ? 1 : (dX == 0.0f ? 0 : -1)) == 0) && !isCurrentlyActive) {
            clearCanvas(c, view.getRight() + dX, view.getTop(), view.getRight(), view.getBottom());
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            return;
        }
        this.background.setColor(this.backgroundColor);
        this.background.setBounds(view.getRight() + ((int) dX), view.getTop(), view.getRight(), view.getBottom());
        this.background.draw(c);
        int top = view.getTop();
        int i = this.intrinsicHeight;
        int i2 = top + ((bottom - i) / 2);
        int i3 = (bottom - i) / 2;
        int right = (view.getRight() - i3) - this.intrinsicWidth;
        int right2 = view.getRight() - i3;
        int i4 = this.intrinsicHeight + i2;
        Drawable drawable = this.deleteIcon;
        Intrinsics.checkNotNull(drawable);
        drawable.setBounds(right, i2, right2, i4);
        this.deleteIcon.draw(c);
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    private final void clearCanvas(Canvas c, float left, float top, float right, float bottom) {
        if (c != null) {
            c.drawRect(left, top, right, bottom, this.clearPaint);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof EmptyViewHolder) {
            return 0;
        }
        return super.getMovementFlags(recyclerView, viewHolder);
    }
}