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
import in.etuwa.app.ui.profile.scholarships.add.AddScholarshipViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddScholarshipBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etName;

    @Bindable
    protected AddScholarshipViewModel mAddScholarshipViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerSince;
    public final Spinner spinnerType;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddScholarshipViewModel(AddScholarshipViewModel addScholarshipViewModel);

    protected DialogAddScholarshipBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etName, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerSince, Spinner spinnerType, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etName = etName;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerSince = spinnerSince;
        this.spinnerType = spinnerType;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddScholarshipViewModel getAddScholarshipViewModel() {
        return this.mAddScholarshipViewModel;
    }

    public static DialogAddScholarshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddScholarshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddScholarshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_scholarship, root, attachToRoot, component);
    }

    public static DialogAddScholarshipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddScholarshipBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddScholarshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_scholarship, null, false, component);
    }

    public static DialogAddScholarshipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddScholarshipBinding bind(View view, Object component) {
        return (DialogAddScholarshipBinding) bind(component, view, R.layout.dialog_add_scholarship);
    }
}