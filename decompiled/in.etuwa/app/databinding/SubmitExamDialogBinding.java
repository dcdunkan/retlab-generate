package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.exam.submit.SubmitExamDialogViewModel;

/* loaded from: classes3.dex */
public abstract class SubmitExamDialogBinding extends ViewDataBinding {
    public final LinearLayout examCard;
    public final TextView examSelect;
    public final TextView examUpload;
    public final TextView fileName;
    public final ProgressBar loader;

    @Bindable
    protected SubmitExamDialogViewModel mSubmitExamDialogViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final TextView tvSizeLimit;
    public final ProgressBar uploadProgressbar;

    public abstract void setSubmitExamDialogViewModel(SubmitExamDialogViewModel submitExamDialogViewModel);

    protected SubmitExamDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout examCard, TextView examSelect, TextView examUpload, TextView fileName, ProgressBar loader, TextView progressText, LinearLayout progressView, TextView tvSizeLimit, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.examCard = examCard;
        this.examSelect = examSelect;
        this.examUpload = examUpload;
        this.fileName = fileName;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.tvSizeLimit = tvSizeLimit;
        this.uploadProgressbar = uploadProgressbar;
    }

    public SubmitExamDialogViewModel getSubmitExamDialogViewModel() {
        return this.mSubmitExamDialogViewModel;
    }

    public static SubmitExamDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitExamDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SubmitExamDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.submit_exam_dialog, root, attachToRoot, component);
    }

    public static SubmitExamDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitExamDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SubmitExamDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.submit_exam_dialog, null, false, component);
    }

    public static SubmitExamDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitExamDialogBinding bind(View view, Object component) {
        return (SubmitExamDialogBinding) bind(component, view, R.layout.submit_exam_dialog);
    }
}