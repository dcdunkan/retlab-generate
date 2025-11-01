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
import in.etuwa.app.ui.activitypoint.manage.proofFile.ProofFileDialogViewModel;

/* loaded from: classes3.dex */
public abstract class ProofFileDialogBinding extends ViewDataBinding {
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextView completionUpload;
    public final ProgressBar loader;

    @Bindable
    protected ProofFileDialogViewModel mProofFileDialogViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final ProgressBar uploadProgressbar;

    public abstract void setProofFileDialogViewModel(ProofFileDialogViewModel proofFileDialogViewModel);

    protected ProofFileDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextView completionUpload, ProgressBar loader, TextView progressText, LinearLayout progressView, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.completionUpload = completionUpload;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ProofFileDialogViewModel getProofFileDialogViewModel() {
        return this.mProofFileDialogViewModel;
    }

    public static ProofFileDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProofFileDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ProofFileDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.proof_file_dialog, root, attachToRoot, component);
    }

    public static ProofFileDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProofFileDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ProofFileDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.proof_file_dialog, null, false, component);
    }

    public static ProofFileDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProofFileDialogBinding bind(View view, Object component) {
        return (ProofFileDialogBinding) bind(component, view, R.layout.proof_file_dialog);
    }
}