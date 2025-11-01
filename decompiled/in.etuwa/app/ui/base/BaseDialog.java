package in.etuwa.app.ui.base;

import android.R;
import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* compiled from: BaseDialog.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H$J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H$J\b\u0010\u0007\u001a\u00020\u0004H$¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/base/BaseDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "hideProgress", "", "onResume", "setUp", "showProgress", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseDialog extends DialogFragment {
    protected abstract void hideProgress();

    protected abstract void setUp();

    protected abstract void showProgress();

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        Window window2;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null || (window = dialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
    }
}