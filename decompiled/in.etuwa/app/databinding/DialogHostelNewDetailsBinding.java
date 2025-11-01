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
import in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel;

/* loaded from: classes3.dex */
public abstract class DialogHostelNewDetailsBinding extends ViewDataBinding {
    public final TextView installmentHead;

    @Bindable
    protected HostelNewDetailsViewModel mHostelNewDetailsViewModel;
    public final RecyclerView rvHostelFeeDetails;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setHostelNewDetailsViewModel(HostelNewDetailsViewModel HostelNewDetailsViewModel);

    protected DialogHostelNewDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView installmentHead, RecyclerView rvHostelFeeDetails, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.installmentHead = installmentHead;
        this.rvHostelFeeDetails = rvHostelFeeDetails;
        this.swipeLayout = swipeLayout;
    }

    public HostelNewDetailsViewModel getHostelNewDetailsViewModel() {
        return this.mHostelNewDetailsViewModel;
    }

    public static DialogHostelNewDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelNewDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogHostelNewDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_hostel_new_details, root, attachToRoot, component);
    }

    public static DialogHostelNewDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelNewDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogHostelNewDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_hostel_new_details, null, false, component);
    }

    public static DialogHostelNewDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelNewDetailsBinding bind(View view, Object component) {
        return (DialogHostelNewDetailsBinding) bind(component, view, R.layout.dialog_hostel_new_details);
    }
}