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
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPalaiSemRegBinding extends ViewDataBinding {

    @Bindable
    protected PalaiSemesterRegViewModel mPalaiSemesterRegViewModel;
    public final TextView newRegistrationBtn;
    public final RecyclerView rvRegistration;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvFeeEngnrTotal;

    public abstract void setPalaiSemesterRegViewModel(PalaiSemesterRegViewModel palaiSemesterRegViewModel);

    protected FragmentPalaiSemRegBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView newRegistrationBtn, RecyclerView rvRegistration, SwipeRefreshLayout swipeLayout, TextView tvFeeEngnrTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.newRegistrationBtn = newRegistrationBtn;
        this.rvRegistration = rvRegistration;
        this.swipeLayout = swipeLayout;
        this.tvFeeEngnrTotal = tvFeeEngnrTotal;
    }

    public PalaiSemesterRegViewModel getPalaiSemesterRegViewModel() {
        return this.mPalaiSemesterRegViewModel;
    }

    public static FragmentPalaiSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPalaiSemRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPalaiSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_palai_sem_reg, root, attachToRoot, component);
    }

    public static FragmentPalaiSemRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPalaiSemRegBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPalaiSemRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_palai_sem_reg, null, false, component);
    }

    public static FragmentPalaiSemRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPalaiSemRegBinding bind(View view, Object component) {
        return (FragmentPalaiSemRegBinding) bind(component, view, R.layout.fragment_palai_sem_reg);
    }
}