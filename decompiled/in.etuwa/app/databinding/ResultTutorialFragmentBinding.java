package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.tutorials.TutorialResultViewModel;

/* loaded from: classes3.dex */
public abstract class ResultTutorialFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabTutorialResultSemester;

    @Bindable
    protected TutorialResultViewModel mTutorialResultViewModel;
    public final RecyclerView rvTutorial;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final LinearLayout tutorialResultLayout;
    public final TextView tutorialSemTv;

    public abstract void setTutorialResultViewModel(TutorialResultViewModel tutorialResultViewModel);

    protected ResultTutorialFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabTutorialResultSemester, RecyclerView rvTutorial, Spinner spinnerSem, SwipeRefreshLayout swipeLayout, LinearLayout tutorialResultLayout, TextView tutorialSemTv) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabTutorialResultSemester = fabTutorialResultSemester;
        this.rvTutorial = rvTutorial;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.tutorialResultLayout = tutorialResultLayout;
        this.tutorialSemTv = tutorialSemTv;
    }

    public TutorialResultViewModel getTutorialResultViewModel() {
        return this.mTutorialResultViewModel;
    }

    public static ResultTutorialFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultTutorialFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ResultTutorialFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_tutorial_fragment, root, attachToRoot, component);
    }

    public static ResultTutorialFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultTutorialFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ResultTutorialFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_tutorial_fragment, null, false, component);
    }

    public static ResultTutorialFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultTutorialFragmentBinding bind(View view, Object component) {
        return (ResultTutorialFragmentBinding) bind(component, view, R.layout.result_tutorial_fragment);
    }
}