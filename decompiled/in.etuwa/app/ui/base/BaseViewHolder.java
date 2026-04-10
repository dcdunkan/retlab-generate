package in.etuwa.app.ui.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewHolder.kt */
/* loaded from: classes4.dex */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private int currentPosition;

    protected abstract void clear();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    public void onBind(int position) {
        this.currentPosition = position;
        clear();
    }
}