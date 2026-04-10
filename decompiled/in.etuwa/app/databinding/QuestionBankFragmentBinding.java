package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.questionbank.QuestionBankViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class QuestionBankFragmentBinding extends ViewDataBinding {
    public final ImageView ivClearSearch;
    public final ImageView ivSearch;

    @Bindable
    protected QuestionBankViewModel mQuestionBankViewModel;
    public final RecyclerView rvQuestion;
    public final CardView searchCard;
    public final EditText searchInput;
    public final Spinner spinnerFill;
    public final ImageView spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;

    public abstract void setQuestionBankViewModel(QuestionBankViewModel questionBankViewModel);

    protected QuestionBankFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivClearSearch, ImageView ivSearch, RecyclerView rvQuestion, CardView searchCard, EditText searchInput, Spinner spinnerFill, ImageView spinnerSem, SwipeRefreshLayout swipeLayout, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivClearSearch = ivClearSearch;
        this.ivSearch = ivSearch;
        this.rvQuestion = rvQuestion;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.spinnerFill = spinnerFill;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
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