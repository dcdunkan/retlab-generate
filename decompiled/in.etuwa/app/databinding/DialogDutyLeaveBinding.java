package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.duty.proof.ProofDutyLeaveViewModel;

/* loaded from: classes3.dex */
public abstract class DialogDutyLeaveBinding extends ViewDataBinding {
    public final CheckBox checkBoxEight;
    public final CheckBox checkBoxFive;
    public final CheckBox checkBoxFour;
    public final CheckBox checkBoxNine;
    public final CheckBox checkBoxOne;
    public final CheckBox checkBoxSeven;
    public final CheckBox checkBoxSix;
    public final CheckBox checkBoxTen;
    public final CheckBox checkBoxThree;
    public final CheckBox checkBoxTwo;
    public final TextView date1;
    public final TextView date10;
    public final TextView date2;
    public final TextView date3;
    public final TextView date4;
    public final TextView date5;
    public final TextView date6;
    public final TextView date7;
    public final TextView date8;
    public final TextView date9;
    public final LinearLayout datelt1;
    public final LinearLayout datelt10;
    public final LinearLayout datelt2;
    public final LinearLayout datelt3;
    public final LinearLayout datelt4;
    public final LinearLayout datelt5;
    public final LinearLayout datelt6;
    public final LinearLayout datelt7;
    public final LinearLayout datelt8;
    public final LinearLayout datelt9;
    public final LinearLayout dutyCard;
    public final TextView dutySelect;
    public final TextView dutyUpload;
    public final TextView fileName;
    public final ProgressBar loader;

    @Bindable
    protected ProofDutyLeaveViewModel mProofDutyLeaveViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final ProgressBar uploadProgressbar;

    public abstract void setProofDutyLeaveViewModel(ProofDutyLeaveViewModel proofDutyLeaveViewModel);

    protected DialogDutyLeaveBinding(Object _bindingComponent, View _root, int _localFieldCount, CheckBox checkBoxEight, CheckBox checkBoxFive, CheckBox checkBoxFour, CheckBox checkBoxNine, CheckBox checkBoxOne, CheckBox checkBoxSeven, CheckBox checkBoxSix, CheckBox checkBoxTen, CheckBox checkBoxThree, CheckBox checkBoxTwo, TextView date1, TextView date10, TextView date2, TextView date3, TextView date4, TextView date5, TextView date6, TextView date7, TextView date8, TextView date9, LinearLayout datelt1, LinearLayout datelt10, LinearLayout datelt2, LinearLayout datelt3, LinearLayout datelt4, LinearLayout datelt5, LinearLayout datelt6, LinearLayout datelt7, LinearLayout datelt8, LinearLayout datelt9, LinearLayout dutyCard, TextView dutySelect, TextView dutyUpload, TextView fileName, ProgressBar loader, TextView progressText, LinearLayout progressView, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.checkBoxEight = checkBoxEight;
        this.checkBoxFive = checkBoxFive;
        this.checkBoxFour = checkBoxFour;
        this.checkBoxNine = checkBoxNine;
        this.checkBoxOne = checkBoxOne;
        this.checkBoxSeven = checkBoxSeven;
        this.checkBoxSix = checkBoxSix;
        this.checkBoxTen = checkBoxTen;
        this.checkBoxThree = checkBoxThree;
        this.checkBoxTwo = checkBoxTwo;
        this.date1 = date1;
        this.date10 = date10;
        this.date2 = date2;
        this.date3 = date3;
        this.date4 = date4;
        this.date5 = date5;
        this.date6 = date6;
        this.date7 = date7;
        this.date8 = date8;
        this.date9 = date9;
        this.datelt1 = datelt1;
        this.datelt10 = datelt10;
        this.datelt2 = datelt2;
        this.datelt3 = datelt3;
        this.datelt4 = datelt4;
        this.datelt5 = datelt5;
        this.datelt6 = datelt6;
        this.datelt7 = datelt7;
        this.datelt8 = datelt8;
        this.datelt9 = datelt9;
        this.dutyCard = dutyCard;
        this.dutySelect = dutySelect;
        this.dutyUpload = dutyUpload;
        this.fileName = fileName;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ProofDutyLeaveViewModel getProofDutyLeaveViewModel() {
        return this.mProofDutyLeaveViewModel;
    }

    public static DialogDutyLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDutyLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogDutyLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_duty_leave, root, attachToRoot, component);
    }

    public static DialogDutyLeaveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDutyLeaveBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogDutyLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_duty_leave, null, false, component);
    }

    public static DialogDutyLeaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDutyLeaveBinding bind(View view, Object component) {
        return (DialogDutyLeaveBinding) bind(component, view, R.layout.dialog_duty_leave);
    }
}