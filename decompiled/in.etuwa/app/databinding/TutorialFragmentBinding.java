package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.tutorial.TutorialViewModel;

/* loaded from: classes3.dex */
public abstract class TutorialFragmentBinding extends ViewDataBinding {

    @Bindable
    protected TutorialViewModel mTutorialViewModel;
    public final RecyclerView rvTutorial;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setTutorialViewModel(TutorialViewModel tutorialViewModel);

    protected TutorialFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvTutorial, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvTutorial = rvTutorial;
        this.swipeLayout = swipeLayout;
    }

    public TutorialViewModel getTutorialViewModel() {
        return this.mTutorialViewModel;
    }

    public static TutorialFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TutorialFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (TutorialFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.tutorial_fragment, root, attachToRoot, component);
    }

    public static TutorialFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TutorialFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (TutorialFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.tutorial_fragment, null, false, component);
    }

    public static TutorialFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TutorialFragmentBinding bind(View view, Object component) {
        return (TutorialFragmentBinding) bind(component, view, R.layout.tutorial_fragment);
    }
}