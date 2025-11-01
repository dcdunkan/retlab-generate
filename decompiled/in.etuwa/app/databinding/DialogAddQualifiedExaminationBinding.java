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
import in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddQualifiedExaminationBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etName;
    public final TextInputEditText etScore;

    @Bindable
    protected AddQualifiedExaminationViewModel mAddQualifiedExaminationViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerYear;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddQualifiedExaminationViewModel(AddQualifiedExaminationViewModel addQualifiedExaminationViewModel);

    protected DialogAddQualifiedExaminationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etName, TextInputEditText etScore, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerYear, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etName = etName;
        this.etScore = etScore;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerYear = spinnerYear;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddQualifiedExaminationViewModel getAddQualifiedExaminationViewModel() {
        return this.mAddQualifiedExaminationViewModel;
    }

    public static DialogAddQualifiedExaminationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddQualifiedExaminationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddQualifiedExaminationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_qualified_examination, root, attachToRoot, component);
    }

    public static DialogAddQualifiedExaminationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddQualifiedExaminationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddQualifiedExaminationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_qualified_examination, null, false, component);
    }

    public static DialogAddQualifiedExaminationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddQualifiedExaminationBinding bind(View view, Object component) {
        return (DialogAddQualifiedExaminationBinding) bind(component, view, R.layout.dialog_add_qualified_examination);
    }
}