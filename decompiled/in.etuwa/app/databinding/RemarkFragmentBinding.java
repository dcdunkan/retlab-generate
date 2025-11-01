package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.remark.RemarkViewModel;

/* loaded from: classes3.dex */
public abstract class RemarkFragmentBinding extends ViewDataBinding {

    @Bindable
    protected RemarkViewModel mRemarkViewModel;
    public final RecyclerView rvRemark;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setRemarkViewModel(RemarkViewModel remarkViewModel);

    protected RemarkFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvRemark, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvRemark = rvRemark;
        this.swipeLayout = swipeLayout;
    }

    public RemarkViewModel getRemarkViewModel() {
        return this.mRemarkViewModel;
    }

    public static RemarkFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemarkFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (RemarkFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.remark_fragment, root, attachToRoot, component);
    }

    public static RemarkFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemarkFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (RemarkFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.remark_fragment, null, false, component);
    }

    public static RemarkFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemarkFragmentBinding bind(View view, Object component) {
        return (RemarkFragmentBinding) bind(component, view, R.layout.remark_fragment);
    }
}