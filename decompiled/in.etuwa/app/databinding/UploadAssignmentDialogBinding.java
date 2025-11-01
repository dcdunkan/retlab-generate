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
import in.etuwa.app.ui.assignment.upload.UploadAssignmentDialogViewModel;

/* loaded from: classes3.dex */
public abstract class UploadAssignmentDialogBinding extends ViewDataBinding {
    public final LinearLayout assiCard;
    public final TextView assiSelect;
    public final TextView assiUpload;
    public final TextView fileName;
    public final ProgressBar loader;

    @Bindable
    protected UploadAssignmentDialogViewModel mUploadAssignmentDialogViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final ProgressBar uploadProgressbar;

    public abstract void setUploadAssignmentDialogViewModel(UploadAssignmentDialogViewModel uploadAssignmentDialogViewModel);

    protected UploadAssignmentDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout assiCard, TextView assiSelect, TextView assiUpload, TextView fileName, ProgressBar loader, TextView progressText, LinearLayout progressView, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.assiCard = assiCard;
        this.assiSelect = assiSelect;
        this.assiUpload = assiUpload;
        this.fileName = fileName;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.uploadProgressbar = uploadProgressbar;
    }

    public UploadAssignmentDialogViewModel getUploadAssignmentDialogViewModel() {
        return this.mUploadAssignmentDialogViewModel;
    }

    public static UploadAssignmentDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UploadAssignmentDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (UploadAssignmentDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.upload_assignment_dialog, root, attachToRoot, component);
    }

    public static UploadAssignmentDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UploadAssignmentDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (UploadAssignmentDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.upload_assignment_dialog, null, false, component);
    }

    public static UploadAssignmentDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UploadAssignmentDialogBinding bind(View view, Object component) {
        return (UploadAssignmentDialogBinding) bind(component, view, R.layout.upload_assignment_dialog);
    }
}