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
import in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddFundedResearchBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etAgency;
    public final TextInputEditText etAmount;
    public final TextInputEditText etDuration;
    public final TextInputEditText etTitle;

    @Bindable
    protected AddFundedResearchViewModel mAddFundedResearchViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerYear;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddFundedResearchViewModel(AddFundedResearchViewModel addFundedResearchViewModel);

    protected DialogAddFundedResearchBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etAgency, TextInputEditText etAmount, TextInputEditText etDuration, TextInputEditText etTitle, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerYear, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etAgency = etAgency;
        this.etAmount = etAmount;
        this.etDuration = etDuration;
        this.etTitle = etTitle;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerYear = spinnerYear;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddFundedResearchViewModel getAddFundedResearchViewModel() {
        return this.mAddFundedResearchViewModel;
    }

    public static DialogAddFundedResearchBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddFundedResearchBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddFundedResearchBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_funded_research, root, attachToRoot, component);
    }

    public static DialogAddFundedResearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddFundedResearchBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddFundedResearchBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_funded_research, null, false, component);
    }

    public static DialogAddFundedResearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddFundedResearchBinding bind(View view, Object component) {
        return (DialogAddFundedResearchBinding) bind(component, view, R.layout.dialog_add_funded_research);
    }
}