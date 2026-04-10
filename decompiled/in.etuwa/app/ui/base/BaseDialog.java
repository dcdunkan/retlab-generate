package in.etuwa.app.ui.base;

import android.R;
import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* JADX INFO: compiled from: BaseDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
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