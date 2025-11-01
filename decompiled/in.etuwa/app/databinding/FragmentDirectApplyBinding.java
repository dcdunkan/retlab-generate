package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentDirectApplyBinding extends ViewDataBinding {
    public final TextView applyLeaveBtn;

    @Bindable
    protected DirectApplyViewModel mDirectApplyViewModel;
    public final RecyclerView rvDutyDirectLeave;

    public abstract void setDirectApplyViewModel(DirectApplyViewModel directApplyViewModel);

    protected FragmentDirectApplyBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView applyLeaveBtn, RecyclerView rvDutyDirectLeave) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyLeaveBtn = applyLeaveBtn;
        this.rvDutyDirectLeave = rvDutyDirectLeave;
    }

    public DirectApplyViewModel getDirectApplyViewModel() {
        return this.mDirectApplyViewModel;
    }

    public static FragmentDirectApplyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDirectApplyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDirectApplyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_direct_apply, root, attachToRoot, component);
    }

    public static FragmentDirectApplyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDirectApplyBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDirectApplyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_direct_apply, null, false, component);
    }

    public static FragmentDirectApplyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDirectApplyBinding bind(View view, Object component) {
        return (FragmentDirectApplyBinding) bind(component, view, R.layout.fragment_direct_apply);
    }
}