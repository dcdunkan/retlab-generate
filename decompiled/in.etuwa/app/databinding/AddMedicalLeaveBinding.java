package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.medical.add.AddMedicalLeaveViewModel;

/* loaded from: classes3.dex */
public abstract class AddMedicalLeaveBinding extends ViewDataBinding {
    public final TextView applyBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etReason;
    public final TextView fromDate;
    public final ProgressBar loader;

    @Bindable
    protected AddMedicalLeaveViewModel mAddMedicalLeaveViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final TextView toDate;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddMedicalLeaveViewModel(AddMedicalLeaveViewModel addMedicalLeaveViewModel);

    protected AddMedicalLeaveBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView applyBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etReason, TextView fromDate, ProgressBar loader, TextView progressText, LinearLayout progressView, TextView toDate, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyBtn = applyBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etReason = etReason;
        this.fromDate = fromDate;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.toDate = toDate;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddMedicalLeaveViewModel getAddMedicalLeaveViewModel() {
        return this.mAddMedicalLeaveViewModel;
    }

    public static AddMedicalLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddMedicalLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AddMedicalLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_medical_leave, root, attachToRoot, component);
    }

    public static AddMedicalLeaveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddMedicalLeaveBinding inflate(LayoutInflater inflater, Object component) {
        return (AddMedicalLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_medical_leave, null, false, component);
    }

    public static AddMedicalLeaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddMedicalLeaveBinding bind(View view, Object component) {
        return (AddMedicalLeaveBinding) bind(component, view, R.layout.add_medical_leave);
    }
}