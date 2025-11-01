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
import in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditViewModel;

/* loaded from: classes3.dex */
public abstract class DialogHostelPartialEditBinding extends ViewDataBinding {
    public final TextView confirmBtn;

    @Bindable
    protected HostelPartialEditViewModel mHostelPartialEditViewModel;
    public final TextView monthLbl;
    public final RecyclerView rvHostelFee;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setHostelPartialEditViewModel(HostelPartialEditViewModel hostelPartialEditViewModel);

    protected DialogHostelPartialEditBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView confirmBtn, TextView monthLbl, RecyclerView rvHostelFee, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.confirmBtn = confirmBtn;
        this.monthLbl = monthLbl;
        this.rvHostelFee = rvHostelFee;
        this.swipeLayout = swipeLayout;
    }

    public HostelPartialEditViewModel getHostelPartialEditViewModel() {
        return this.mHostelPartialEditViewModel;
    }

    public static DialogHostelPartialEditBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelPartialEditBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogHostelPartialEditBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_hostel_partial_edit, root, attachToRoot, component);
    }

    public static DialogHostelPartialEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelPartialEditBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogHostelPartialEditBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_hostel_partial_edit, null, false, component);
    }

    public static DialogHostelPartialEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelPartialEditBinding bind(View view, Object component) {
        return (DialogHostelPartialEditBinding) bind(component, view, R.layout.dialog_hostel_partial_edit);
    }
}