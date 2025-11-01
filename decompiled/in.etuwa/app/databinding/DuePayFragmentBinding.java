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
import in.etuwa.app.ui.due.duepay.DuePayViewModel;

/* loaded from: classes3.dex */
public abstract class DuePayFragmentBinding extends ViewDataBinding {

    @Bindable
    protected DuePayViewModel mDuePayViewModel;
    public final TextView payDueBtn;
    public final RecyclerView rvDuePay;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvDueTotal;

    public abstract void setDuePayViewModel(DuePayViewModel duePayViewModel);

    protected DuePayFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payDueBtn, RecyclerView rvDuePay, SwipeRefreshLayout swipeLayout, TextView tvDueTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payDueBtn = payDueBtn;
        this.rvDuePay = rvDuePay;
        this.swipeLayout = swipeLayout;
        this.tvDueTotal = tvDueTotal;
    }

    public DuePayViewModel getDuePayViewModel() {
        return this.mDuePayViewModel;
    }

    public static DuePayFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DuePayFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DuePayFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.due_pay_fragment, root, attachToRoot, component);
    }

    public static DuePayFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DuePayFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (DuePayFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.due_pay_fragment, null, false, component);
    }

    public static DuePayFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DuePayFragmentBinding bind(View view, Object component) {
        return (DuePayFragmentBinding) bind(component, view, R.layout.due_pay_fragment);
    }
}