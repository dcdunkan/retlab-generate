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
import in.etuwa.app.ui.counselling.add.AddCounsellingViewModel;

/* loaded from: classes3.dex */
public abstract class AddCounsellingDialogBinding extends ViewDataBinding {
    public final TextView addCounsellingBtn;
    public final TextInputLayout comntLayout;
    public final TextView councTitle;
    public final TextInputEditText csComment;
    public final TextInputEditText csConcernStudies;
    public final TextInputEditText csPhisical;
    public final TextInputEditText csRelationship;
    public final TextInputEditText etCsConcern;
    public final TextInputEditText etCsConcernHome;

    @Bindable
    protected AddCounsellingViewModel mAddCounsellingDialogViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final Spinner spinnerCouncellingBefore;
    public final Spinner spinnerCouncellingMeet;
    public final Spinner spinnerCouncellingType;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddCounsellingDialogViewModel(AddCounsellingViewModel addCounsellingDialogViewModel);

    protected AddCounsellingDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addCounsellingBtn, TextInputLayout comntLayout, TextView councTitle, TextInputEditText csComment, TextInputEditText csConcernStudies, TextInputEditText csPhisical, TextInputEditText csRelationship, TextInputEditText etCsConcern, TextInputEditText etCsConcernHome, TextView progressText, CardView progressView, Spinner spinnerCouncellingBefore, Spinner spinnerCouncellingMeet, Spinner spinnerCouncellingType, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addCounsellingBtn = addCounsellingBtn;
        this.comntLayout = comntLayout;
        this.councTitle = councTitle;
        this.csComment = csComment;
        this.csConcernStudies = csConcernStudies;
        this.csPhisical = csPhisical;
        this.csRelationship = csRelationship;
        this.etCsConcern = etCsConcern;
        this.etCsConcernHome = etCsConcernHome;
        this.progressText = progressText;
        this.progressView = progressView;
        this.spinnerCouncellingBefore = spinnerCouncellingBefore;
        this.spinnerCouncellingMeet = spinnerCouncellingMeet;
        this.spinnerCouncellingType = spinnerCouncellingType;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddCounsellingViewModel getAddCounsellingDialogViewModel() {
        return this.mAddCounsellingDialogViewModel;
    }

    public static AddCounsellingDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddCounsellingDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AddCounsellingDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_counselling_dialog, root, attachToRoot, component);
    }

    public static AddCounsellingDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddCounsellingDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (AddCounsellingDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_counselling_dialog, null, false, component);
    }

    public static AddCounsellingDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddCounsellingDialogBinding bind(View view, Object component) {
        return (AddCounsellingDialogBinding) bind(component, view, R.layout.add_counselling_dialog);
    }
}