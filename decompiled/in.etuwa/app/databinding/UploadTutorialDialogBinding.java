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
import in.etuwa.app.ui.tutorial.upload.UploadTutorialDialogViewModel;

/* loaded from: classes3.dex */
public abstract class UploadTutorialDialogBinding extends ViewDataBinding {
    public final TextView fileName;
    public final ProgressBar loader;

    @Bindable
    protected UploadTutorialDialogViewModel mUploadTutorialDialogViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final LinearLayout tutorialCard;
    public final TextView tutorialSelect;
    public final TextView tutorialUpload;
    public final ProgressBar uploadProgressbar;

    public abstract void setUploadTutorialDialogViewModel(UploadTutorialDialogViewModel uploadTutorialDialogViewModel);

    protected UploadTutorialDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView fileName, ProgressBar loader, TextView progressText, LinearLayout progressView, LinearLayout tutorialCard, TextView tutorialSelect, TextView tutorialUpload, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fileName = fileName;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.tutorialCard = tutorialCard;
        this.tutorialSelect = tutorialSelect;
        this.tutorialUpload = tutorialUpload;
        this.uploadProgressbar = uploadProgressbar;
    }

    public UploadTutorialDialogViewModel getUploadTutorialDialogViewModel() {
        return this.mUploadTutorialDialogViewModel;
    }

    public static UploadTutorialDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UploadTutorialDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (UploadTutorialDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.upload_tutorial_dialog, root, attachToRoot, component);
    }

    public static UploadTutorialDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UploadTutorialDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (UploadTutorialDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.upload_tutorial_dialog, null, false, component);
    }

    public static UploadTutorialDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UploadTutorialDialogBinding bind(View view, Object component) {
        return (UploadTutorialDialogBinding) bind(component, view, R.layout.upload_tutorial_dialog);
    }
}