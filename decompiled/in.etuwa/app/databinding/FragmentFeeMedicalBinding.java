package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.feemedical.FeeMedicalViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFeeMedicalBinding extends ViewDataBinding {

    @Bindable
    protected FeeMedicalViewModel mFeeMedicalViewModel;
    public final TextView payFeeMedicalBtn;
    public final RecyclerView rvFeeMedical;
    public final LinearLayout swipeLayout;
    public final TextView tvFeeMedicalTotal;

    public abstract void setFeeMedicalViewModel(FeeMedicalViewModel feeMedicalViewModel);

    protected FragmentFeeMedicalBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payFeeMedicalBtn, RecyclerView rvFeeMedical, LinearLayout swipeLayout, TextView tvFeeMedicalTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payFeeMedicalBtn = payFeeMedicalBtn;
        this.rvFeeMedical = rvFeeMedical;
        this.swipeLayout = swipeLayout;
        this.tvFeeMedicalTotal = tvFeeMedicalTotal;
    }

    public FeeMedicalViewModel getFeeMedicalViewModel() {
        return this.mFeeMedicalViewModel;
    }

    public static FragmentFeeMedicalBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMedicalBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeeMedicalBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_medical, root, attachToRoot, component);
    }

    public static FragmentFeeMedicalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMedicalBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeeMedicalBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_medical, null, false, component);
    }

    public static FragmentFeeMedicalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMedicalBinding bind(View view, Object component) {
        return (FragmentFeeMedicalBinding) bind(component, view, R.layout.fragment_fee_medical);
    }
}