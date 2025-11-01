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
import in.etuwa.app.ui.newquiz.NewQuizViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentQuizBinding extends ViewDataBinding {

    @Bindable
    protected NewQuizViewModel mNewQuizViewModel;
    public final RecyclerView rvQuiz;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setNewQuizViewModel(NewQuizViewModel newQuizViewModel);

    protected FragmentQuizBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvQuiz, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvQuiz = rvQuiz;
        this.swipeLayout = swipeLayout;
    }

    public NewQuizViewModel getNewQuizViewModel() {
        return this.mNewQuizViewModel;
    }

    public static FragmentQuizBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentQuizBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_quiz, root, attachToRoot, component);
    }

    public static FragmentQuizBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentQuizBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_quiz, null, false, component);
    }

    public static FragmentQuizBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizBinding bind(View view, Object component) {
        return (FragmentQuizBinding) bind(component, view, R.layout.fragment_quiz);
    }
}