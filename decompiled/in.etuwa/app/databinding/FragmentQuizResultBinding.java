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
import in.etuwa.app.ui.newquiz.viewresult.QuizResultViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentQuizResultBinding extends ViewDataBinding {

    @Bindable
    protected QuizResultViewModel mQuizResultViewModel;
    public final RecyclerView rvDescriptiveQuiz;
    public final RecyclerView rvMultipleQuiz;
    public final RecyclerView rvUploadQuiz;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setQuizResultViewModel(QuizResultViewModel quizResultViewModel);

    protected FragmentQuizResultBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvDescriptiveQuiz, RecyclerView rvMultipleQuiz, RecyclerView rvUploadQuiz, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvDescriptiveQuiz = rvDescriptiveQuiz;
        this.rvMultipleQuiz = rvMultipleQuiz;
        this.rvUploadQuiz = rvUploadQuiz;
        this.swipeLayout = swipeLayout;
    }

    public QuizResultViewModel getQuizResultViewModel() {
        return this.mQuizResultViewModel;
    }

    public static FragmentQuizResultBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizResultBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentQuizResultBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_quiz_result, root, attachToRoot, component);
    }

    public static FragmentQuizResultBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizResultBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentQuizResultBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_quiz_result, null, false, component);
    }

    public static FragmentQuizResultBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizResultBinding bind(View view, Object component) {
        return (FragmentQuizResultBinding) bind(component, view, R.layout.fragment_quiz_result);
    }
}