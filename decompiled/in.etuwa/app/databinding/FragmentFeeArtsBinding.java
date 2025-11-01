package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFeeArtsBinding extends ViewDataBinding {
    public final LinearLayout fineLayout;

    @Bindable
    protected FeeArtsViewModel mFeeArtsViewModel;
    public final TextView payFeeArtsBtn;
    public final RecyclerView rvFeeArts;
    public final LinearLayout seriesLayout;
    public final Spinner spinnerSem;
    public final LinearLayout swipeLayout;
    public final TextView tvFeeArtsTotal;
    public final TextView tvFine;
    public final TextView tvSubtotal;

    public abstract void setFeeArtsViewModel(FeeArtsViewModel feeArtsViewModel);

    protected FragmentFeeArtsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout fineLayout, TextView payFeeArtsBtn, RecyclerView rvFeeArts, LinearLayout seriesLayout, Spinner spinnerSem, LinearLayout swipeLayout, TextView tvFeeArtsTotal, TextView tvFine, TextView tvSubtotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fineLayout = fineLayout;
        this.payFeeArtsBtn = payFeeArtsBtn;
        this.rvFeeArts = rvFeeArts;
        this.seriesLayout = seriesLayout;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.tvFeeArtsTotal = tvFeeArtsTotal;
        this.tvFine = tvFine;
        this.tvSubtotal = tvSubtotal;
    }

    public FeeArtsViewModel getFeeArtsViewModel() {
        return this.mFeeArtsViewModel;
    }

    public static FragmentFeeArtsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeArtsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeeArtsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_arts, root, attachToRoot, component);
    }

    public static FragmentFeeArtsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeArtsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeeArtsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_arts, null, false, component);
    }

    public static FragmentFeeArtsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeArtsBinding bind(View view, Object component) {
        return (FragmentFeeArtsBinding) bind(component, view, R.layout.fragment_fee_arts);
    }
}