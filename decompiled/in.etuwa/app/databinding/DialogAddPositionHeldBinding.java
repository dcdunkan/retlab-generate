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
import in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddPositionHeldBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextView etEndDate;
    public final TextView etFromDate;
    public final TextInputEditText etName;
    public final CardView ltEndDate;
    public final CardView ltFromDate;

    @Bindable
    protected AddPositionHeldViewModel mAddPositionHeldViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerYear;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddPositionHeldViewModel(AddPositionHeldViewModel addPositionHeldViewModel);

    protected DialogAddPositionHeldBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextView etEndDate, TextView etFromDate, TextInputEditText etName, CardView ltEndDate, CardView ltFromDate, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerYear, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etEndDate = etEndDate;
        this.etFromDate = etFromDate;
        this.etName = etName;
        this.ltEndDate = ltEndDate;
        this.ltFromDate = ltFromDate;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerYear = spinnerYear;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddPositionHeldViewModel getAddPositionHeldViewModel() {
        return this.mAddPositionHeldViewModel;
    }

    public static DialogAddPositionHeldBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddPositionHeldBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddPositionHeldBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_position_held, root, attachToRoot, component);
    }

    public static DialogAddPositionHeldBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddPositionHeldBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddPositionHeldBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_position_held, null, false, component);
    }

    public static DialogAddPositionHeldBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddPositionHeldBinding bind(View view, Object component) {
        return (DialogAddPositionHeldBinding) bind(component, view, R.layout.dialog_add_position_held);
    }
}