package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.questionbank.QuestionBankViewModel;

/* loaded from: classes3.dex */
public abstract class QuestionBankFragmentBinding extends ViewDataBinding {

    @Bindable
    protected QuestionBankViewModel mQuestionBankViewModel;
    public final LinearLayout questionLayout;
    public final RecyclerView rvQuestion;
    public final Spinner spinnerFill;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setQuestionBankViewModel(QuestionBankViewModel questionBankViewModel);

    protected QuestionBankFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout questionLayout, RecyclerView rvQuestion, Spinner spinnerFill, Spinner spinnerSem, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.questionLayout = questionLayout;
        this.rvQuestion = rvQuestion;
        this.spinnerFill = spinnerFill;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
    }

    public QuestionBankViewModel getQuestionBankViewModel() {
        return this.mQuestionBankViewModel;
    }

    public static QuestionBankFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionBankFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (QuestionBankFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.question_bank_fragment, root, attachToRoot, component);
    }

    public static QuestionBankFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionBankFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (QuestionBankFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.question_bank_fragment, null, false, component);
    }

    public static QuestionBankFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionBankFragmentBinding bind(View view, Object component) {
        return (QuestionBankFragmentBinding) bind(component, view, R.layout.question_bank_fragment);
    }
}