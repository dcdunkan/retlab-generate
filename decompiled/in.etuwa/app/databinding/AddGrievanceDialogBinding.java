package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel;

/* loaded from: classes3.dex */
public abstract class AddGrievanceDialogBinding extends ViewDataBinding {
    public final TextView addGrievanceBtn;
    public final TextInputLayout comntLayout;
    public final TextInputEditText etGrSubject;
    public final TextInputEditText grComment;
    public final TextInputEditText grComplaint;
    public final TextView grUploadPath;
    public final TextView grivTitle;

    @Bindable
    protected AddGrievanceDialogViewModel mAddGrievanceDialogViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final Spinner spinnerGrievance;
    public final TextView uploadGrBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddGrievanceDialogViewModel(AddGrievanceDialogViewModel addGrievanceDialogViewModel);

    protected AddGrievanceDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addGrievanceBtn, TextInputLayout comntLayout, TextInputEditText etGrSubject, TextInputEditText grComment, TextInputEditText grComplaint, TextView grUploadPath, TextView grivTitle, TextView progressText, CardView progressView, Spinner spinnerGrievance, TextView uploadGrBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addGrievanceBtn = addGrievanceBtn;
        this.comntLayout = comntLayout;
        this.etGrSubject = etGrSubject;
        this.grComment = grComment;
        this.grComplaint = grComplaint;
        this.grUploadPath = grUploadPath;
        this.grivTitle = grivTitle;
        this.progressText = progressText;
        this.progressView = progressView;
        this.spinnerGrievance = spinnerGrievance;
        this.uploadGrBtn = uploadGrBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddGrievanceDialogViewModel getAddGrievanceDialogViewModel() {
        return this.mAddGrievanceDialogViewModel;
    }

    public static AddGrievanceDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddGrievanceDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AddGrievanceDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_grievance_dialog, root, attachToRoot, component);
    }

    public static AddGrievanceDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddGrievanceDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (AddGrievanceDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_grievance_dialog, null, false, component);
    }

    public static AddGrievanceDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddGrievanceDialogBinding bind(View view, Object component) {
        return (AddGrievanceDialogBinding) bind(component, view, R.layout.add_grievance_dialog);
    }
}