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
import in.etuwa.app.ui.profile.sport.add.AddSportViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddSportBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etAward;
    public final TextView etDate;
    public final TextInputEditText etName;
    public final TextInputEditText etOrgaanisedBy;
    public final CardView ltDate;

    @Bindable
    protected AddSportViewModel mAddSportViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerCompetition;
    public final Spinner spinnerLevel;
    public final Spinner spinnerType;
    public final Spinner spinnerYear;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddSportViewModel(AddSportViewModel addSportViewModel);

    protected DialogAddSportBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etAward, TextView etDate, TextInputEditText etName, TextInputEditText etOrgaanisedBy, CardView ltDate, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerCompetition, Spinner spinnerLevel, Spinner spinnerType, Spinner spinnerYear, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etAward = etAward;
        this.etDate = etDate;
        this.etName = etName;
        this.etOrgaanisedBy = etOrgaanisedBy;
        this.ltDate = ltDate;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerCompetition = spinnerCompetition;
        this.spinnerLevel = spinnerLevel;
        this.spinnerType = spinnerType;
        this.spinnerYear = spinnerYear;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddSportViewModel getAddSportViewModel() {
        return this.mAddSportViewModel;
    }

    public static DialogAddSportBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddSportBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddSportBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_sport, root, attachToRoot, component);
    }

    public static DialogAddSportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddSportBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddSportBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_sport, null, false, component);
    }

    public static DialogAddSportBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddSportBinding bind(View view, Object component) {
        return (DialogAddSportBinding) bind(component, view, R.layout.dialog_add_sport);
    }
}