package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel;

/* loaded from: classes3.dex */
public abstract class DialogEngineerFeeEtailBinding extends ViewDataBinding {

    @Bindable
    protected FeeDetailViewModel mFeeDetailViewModelViewModel;
    public final TextView monthLbl;
    public final RecyclerView rvHostelFee;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setFeeDetailViewModelViewModel(FeeDetailViewModel feeDetailViewModelViewModel);

    protected DialogEngineerFeeEtailBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView monthLbl, RecyclerView rvHostelFee, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.monthLbl = monthLbl;
        this.rvHostelFee = rvHostelFee;
        this.swipeLayout = swipeLayout;
    }

    public FeeDetailViewModel getFeeDetailViewModelViewModel() {
        return this.mFeeDetailViewModelViewModel;
    }

    public static DialogEngineerFeeEtailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEngineerFeeEtailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogEngineerFeeEtailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_engineer_fee_etail, root, attachToRoot, component);
    }

    public static DialogEngineerFeeEtailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEngineerFeeEtailBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogEngineerFeeEtailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_engineer_fee_etail, null, false, component);
    }

    public static DialogEngineerFeeEtailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEngineerFeeEtailBinding bind(View view, Object component) {
        return (DialogEngineerFeeEtailBinding) bind(component, view, R.layout.dialog_engineer_fee_etail);
    }
}