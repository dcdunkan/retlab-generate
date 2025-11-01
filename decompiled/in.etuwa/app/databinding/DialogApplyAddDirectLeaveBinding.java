package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveViewModel;

/* loaded from: classes3.dex */
public abstract class DialogApplyAddDirectLeaveBinding extends ViewDataBinding {
    public final TextView applyBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final EditText etFromDate;
    public final TextView etFromDate2;
    public final TextInputEditText etReason;
    public final EditText etToDate;
    public final TextView etToDate2;

    @Bindable
    protected ApplyDirectDutyLeaveViewModel mApplyDirectDutyLeaveViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final Spinner spinnerDutyHead;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setApplyDirectDutyLeaveViewModel(ApplyDirectDutyLeaveViewModel applyDirectDutyLeaveViewModel);

    protected DialogApplyAddDirectLeaveBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView applyBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, EditText etFromDate, TextView etFromDate2, TextInputEditText etReason, EditText etToDate, TextView etToDate2, TextView progressText, CardView progressView, TextView regTitle, Spinner spinnerDutyHead, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyBtn = applyBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etFromDate = etFromDate;
        this.etFromDate2 = etFromDate2;
        this.etReason = etReason;
        this.etToDate = etToDate;
        this.etToDate2 = etToDate2;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.spinnerDutyHead = spinnerDutyHead;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ApplyDirectDutyLeaveViewModel getApplyDirectDutyLeaveViewModel() {
        return this.mApplyDirectDutyLeaveViewModel;
    }

    public static DialogApplyAddDirectLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyAddDirectLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogApplyAddDirectLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_add_direct_leave, root, attachToRoot, component);
    }

    public static DialogApplyAddDirectLeaveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyAddDirectLeaveBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogApplyAddDirectLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_add_direct_leave, null, false, component);
    }

    public static DialogApplyAddDirectLeaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyAddDirectLeaveBinding bind(View view, Object component) {
        return (DialogApplyAddDirectLeaveBinding) bind(component, view, R.layout.dialog_apply_add_direct_leave);
    }
}