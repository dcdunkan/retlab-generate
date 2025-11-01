package in.etuwa.app.ui.base;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

/* compiled from: BaseFragment.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H$J\b\u0010\u0005\u001a\u00020\u0004H$J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0004H$J\b\u0010\u000e\u001a\u00020\u0004H$J\b\u0010\u000f\u001a\u00020\u0004H$¨\u0006\u0010"}, d2 = {"Lin/etuwa/app/ui/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "hideBaseView", "", "hideProgress", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "setUp", "showBaseView", "showProgress", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
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