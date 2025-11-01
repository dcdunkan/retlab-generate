package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddMoocCourseBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etAchievements;
    public final TextInputEditText etDuration;
    public final TextView etEndDate;
    public final TextView etFromDate;
    public final TextInputEditText etOrgaanisedBy;
    public final TextInputEditText etTitle;
    public final CardView ltEndDate;
    public final CardView ltFromDate;

    @Bindable
    protected AddMoocCourseViewModel mAddMoocCourseViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddMoocCourseViewModel(AddMoocCourseViewModel addMoocCourseViewModel);

    protected DialogAddMoocCourseBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etAchievements, TextInputEditText etDuration, TextView etEndDate, TextView etFromDate, TextInputEditText etOrgaanisedBy, TextInputEditText etTitle, CardView ltEndDate, CardView ltFromDate, TextView progressText, CardView progressView, TextView regTitle, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etAchievements = etAchievements;
        this.etDuration = etDuration;
        this.etEndDate = etEndDate;
        this.etFromDate = etFromDate;
        this.etOrgaanisedBy = etOrgaanisedBy;
        this.etTitle = etTitle;
        this.ltEndDate = ltEndDate;
        this.ltFromDate = ltFromDate;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddMoocCourseViewModel getAddMoocCourseViewModel() {
        return this.mAddMoocCourseViewModel;
    }

    public static DialogAddMoocCourseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddMoocCourseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddMoocCourseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_mooc_course, root, attachToRoot, component);
    }

    public static DialogAddMoocCourseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddMoocCourseBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddMoocCourseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_mooc_course, null, false, component);
    }

    public static DialogAddMoocCourseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddMoocCourseBinding bind(View view, Object component) {
        return (DialogAddMoocCourseBinding) bind(component, view, R.layout.dialog_add_mooc_course);
    }
}