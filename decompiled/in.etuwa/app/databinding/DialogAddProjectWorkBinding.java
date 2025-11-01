package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddProjectWorkBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etDetails;

    @Bindable
    protected AddProjectWorkViewModel mAddProjectWorkViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerSince;
    public final Spinner spinnerType;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddProjectWorkViewModel(AddProjectWorkViewModel addProjectWorkViewModel);

    protected DialogAddProjectWorkBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etDetails, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerSince, Spinner spinnerType, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etDetails = etDetails;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerSince = spinnerSince;
        this.spinnerType = spinnerType;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddProjectWorkViewModel getAddProjectWorkViewModel() {
        return this.mAddProjectWorkViewModel;
    }

    public static DialogAddProjectWorkBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddProjectWorkBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddProjectWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_project_work, root, attachToRoot, component);
    }

    public static DialogAddProjectWorkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddProjectWorkBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddProjectWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_project_work, null, false, component);
    }

    public static DialogAddProjectWorkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddProjectWorkBinding bind(View view, Object component) {
        return (DialogAddProjectWorkBinding) bind(component, view, R.layout.dialog_add_project_work);
    }
}