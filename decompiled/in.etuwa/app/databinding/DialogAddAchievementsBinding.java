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
import in.etuwa.app.ui.profile.achievements.add.AddAchievementsViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddAchievementsBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etDetails;

    @Bindable
    protected AddAchievementsViewModel mAddAchievementsViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerYear;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddAchievementsViewModel(AddAchievementsViewModel addAchievementsViewModel);

    protected DialogAddAchievementsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etDetails, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerYear, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etDetails = etDetails;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerYear = spinnerYear;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddAchievementsViewModel getAddAchievementsViewModel() {
        return this.mAddAchievementsViewModel;
    }

    public static DialogAddAchievementsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddAchievementsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddAchievementsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_achievements, root, attachToRoot, component);
    }

    public static DialogAddAchievementsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddAchievementsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddAchievementsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_achievements, null, false, component);
    }

    public static DialogAddAchievementsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddAchievementsBinding bind(View view, Object component) {
        return (DialogAddAchievementsBinding) bind(component, view, R.layout.dialog_add_achievements);
    }
}