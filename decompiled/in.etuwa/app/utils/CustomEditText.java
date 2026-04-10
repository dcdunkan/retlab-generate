package in.etuwa.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomEditText.kt */
/* loaded from: classes5.dex */
public final class CustomEditText extends AppCompatEditText {
    private KeyImeChange keyImeChangeListener;

    /* compiled from: CustomEditText.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/utils/CustomEditText$KeyImeChange;", "", "onKeyIme", "", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface KeyImeChange {
        void onKeyIme(int keyCode, KeyEvent event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
    }

    public final void setKeyImeChangeListener(KeyImeChange listener) {
        this.keyImeChangeListener = listener;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        KeyImeChange keyImeChange = this.keyImeChangeListener;
        if (keyImeChange == null) {
            return false;
        }
        Intrinsics.checkNotNull(keyImeChange);
        keyImeChange.onKeyIme(keyCode, event);
        return false;
    }
}