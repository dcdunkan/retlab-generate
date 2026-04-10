package in.etuwa.app.ui.base;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

/* JADX INFO: compiled from: BaseFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseFragment extends Fragment {
    protected abstract void hideBaseView();

    protected abstract void hideProgress();

    protected abstract void setUp();

    protected abstract void showBaseView();

    protected abstract void showProgress();

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation.setDuration(500L);
            return translateAnimation;
        }
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation2.setDuration(500L);
        return translateAnimation2;
    }
}