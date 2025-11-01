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
import in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel;

/* loaded from: classes3.dex */
public abstract class SubmitHomeWorkDialogBinding extends ViewDataBinding {
    public final TextView fileName;
    public final LinearLayout hwCard;
    public final TextView hwSelect;
    public final TextView hwUpload;
    public final ProgressBar loader;

    @Bindable
    protected SubmitHomeWorkDialogViewModel mSubmitHomeWorkDialogViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final ProgressBar uploadProgressbar;

    public abstract void setSubmitHomeWorkDialogViewModel(SubmitHomeWorkDialogViewModel submitHomeWorkDialogViewModel);

    protected SubmitHomeWorkDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView fileName, LinearLayout hwCard, TextView hwSelect, TextView hwUpload, ProgressBar loader, TextView progressText, LinearLayout progressView, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fileName = fileName;
        this.hwCard = hwCard;
        this.hwSelect = hwSelect;
        this.hwUpload = hwUpload;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.uploadProgressbar = uploadProgressbar;
    }

    public SubmitHomeWorkDialogViewModel getSubmitHomeWorkDialogViewModel() {
        return this.mSubmitHomeWorkDialogViewModel;
    }

    public static SubmitHomeWorkDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitHomeWorkDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SubmitHomeWorkDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.submit_home_work_dialog, root, attachToRoot, component);
    }

    public static SubmitHomeWorkDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitHomeWorkDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SubmitHomeWorkDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.submit_home_work_dialog, null, false, component);
    }

    public static SubmitHomeWorkDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitHomeWorkDialogBinding bind(View view, Object component) {
        return (SubmitHomeWorkDialogBinding) bind(component, view, R.layout.submit_home_work_dialog);
    }
}