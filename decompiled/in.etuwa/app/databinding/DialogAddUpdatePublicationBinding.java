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
import in.etuwa.app.ui.profile.quality_publication.add.AddPublicationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddUpdatePublicationBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etConference;
    public final TextInputEditText etJournel;
    public final TextInputEditText etTitle;

    @Bindable
    protected AddPublicationViewModel mAddPublicationViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerIndex;
    public final Spinner spinnerYear;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddPublicationViewModel(AddPublicationViewModel addPublicationViewModel);

    protected DialogAddUpdatePublicationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etConference, TextInputEditText etJournel, TextInputEditText etTitle, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerIndex, Spinner spinnerYear, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etConference = etConference;
        this.etJournel = etJournel;
        this.etTitle = etTitle;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerIndex = spinnerIndex;
        this.spinnerYear = spinnerYear;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddPublicationViewModel getAddPublicationViewModel() {
        return this.mAddPublicationViewModel;
    }

    public static DialogAddUpdatePublicationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddUpdatePublicationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddUpdatePublicationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_update_publication, root, attachToRoot, component);
    }

    public static DialogAddUpdatePublicationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddUpdatePublicationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddUpdatePublicationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_update_publication, null, false, component);
    }

    public static DialogAddUpdatePublicationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddUpdatePublicationBinding bind(View view, Object component) {
        return (DialogAddUpdatePublicationBinding) bind(component, view, R.layout.dialog_add_update_publication);
    }
}