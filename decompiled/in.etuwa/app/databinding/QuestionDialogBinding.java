package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.exam.questions.QuestionDialogViewModel;

/* loaded from: classes3.dex */
public abstract class QuestionDialogBinding extends ViewDataBinding {

    @Bindable
    protected QuestionDialogViewModel mQuestionDialogViewModel;
    public final RecyclerView rvExamDocs;

    public abstract void setQuestionDialogViewModel(QuestionDialogViewModel questionDialogViewModel);

    protected QuestionDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvExamDocs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvExamDocs = rvExamDocs;
    }

    public QuestionDialogViewModel getQuestionDialogViewModel() {
        return this.mQuestionDialogViewModel;
    }

    public static QuestionDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (QuestionDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.question_dialog, root, attachToRoot, component);
    }

    public static QuestionDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (QuestionDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.question_dialog, null, false, component);
    }

    public static QuestionDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionDialogBinding bind(View view, Object component) {
        return (QuestionDialogBinding) bind(component, view, R.layout.question_dialog);
    }
}