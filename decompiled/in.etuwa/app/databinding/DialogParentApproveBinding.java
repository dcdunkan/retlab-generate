package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DialogParentApproveBinding extends ViewDataBinding {
    public final LinearLayout actionButtons;
    public final MaterialButton btnApprove;
    public final MaterialButton btnReject;
    public final CardView cardLeaveDetails;
    public final MaterialCheckBox checkboxSelectAll;
    public final View handleBar;

    @Bindable
    protected ParentApproveViewModel mParentApproveViewModel;
    public final RecyclerView rvDates;
    public final MaterialCardView selectAllCard;
    public final TextView tvLeaveType;
    public final TextView tvReason;
    public final TextView tvTitle;

    public abstract void setParentApproveViewModel(ParentApproveViewModel parentApproveViewModel);

    protected DialogParentApproveBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout actionButtons, MaterialButton btnApprove, MaterialButton btnReject, CardView cardLeaveDetails, MaterialCheckBox checkboxSelectAll, View handleBar, RecyclerView rvDates, MaterialCardView selectAllCard, TextView tvLeaveType, TextView tvReason, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.actionButtons = actionButtons;
        this.btnApprove = btnApprove;
        this.btnReject = btnReject;
        this.cardLeaveDetails = cardLeaveDetails;
        this.checkboxSelectAll = checkboxSelectAll;
        this.handleBar = handleBar;
        this.rvDates = rvDates;
        this.selectAllCard = selectAllCard;
        this.tvLeaveType = tvLeaveType;
        this.tvReason = tvReason;
        this.tvTitle = tvTitle;
    }

    public ParentApproveViewModel getParentApproveViewModel() {
        return this.mParentApproveViewModel;
    }

    public static DialogParentApproveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogParentApproveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogParentApproveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_parent_approve, root, attachToRoot, component);
    }

    public static DialogParentApproveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogParentApproveBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogParentApproveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_parent_approve, null, false, component);
    }

    public static DialogParentApproveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogParentApproveBinding bind(View view, Object component) {
        return (DialogParentApproveBinding) bind(component, view, R.layout.dialog_parent_approve);
    }
}