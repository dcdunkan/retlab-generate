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
import in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialogViewModel;

/* loaded from: classes3.dex */
public abstract class CompletionCertificateDialogBinding extends ViewDataBinding {
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextView completionUpload;
    public final ProgressBar loader;

    @Bindable
    protected CompletionCertificateDialogViewModel mCompletionCertificateDialogViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final ProgressBar uploadProgressbar;

    public abstract void setCompletionCertificateDialogViewModel(CompletionCertificateDialogViewModel completionCertificateDialogViewModel);

    protected CompletionCertificateDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextView completionUpload, ProgressBar loader, TextView progressText, LinearLayout progressView, ProgressBar uploadProgressbar) {
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

    public CompletionCertificateDialogViewModel getCompletionCertificateDialogViewModel() {
        return this.mCompletionCertificateDialogViewModel;
    }

    public static CompletionCertificateDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompletionCertificateDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CompletionCertificateDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.completion_certificate_dialog, root, attachToRoot, component);
    }

    public static CompletionCertificateDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompletionCertificateDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CompletionCertificateDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.completion_certificate_dialog, null, false, component);
    }

    public static CompletionCertificateDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompletionCertificateDialogBinding bind(View view, Object component) {
        return (CompletionCertificateDialogBinding) bind(component, view, R.layout.completion_certificate_dialog);
    }
}