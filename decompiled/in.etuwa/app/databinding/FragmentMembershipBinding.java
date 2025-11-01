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
import in.etuwa.app.ui.profile.membership.MembershipViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentMembershipBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected MembershipViewModel mMembershipViewModel;
    public final RecyclerView rvMembership;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setMembershipViewModel(MembershipViewModel membershipViewModel);

    protected FragmentMembershipBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvMembership, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvMembership = rvMembership;
        this.swipeLayout = swipeLayout;
    }

    public MembershipViewModel getMembershipViewModel() {
        return this.mMembershipViewModel;
    }

    public static FragmentMembershipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMembershipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentMembershipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_membership, root, attachToRoot, component);
    }

    public static FragmentMembershipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMembershipBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentMembershipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_membership, null, false, component);
    }

    public static FragmentMembershipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMembershipBinding bind(View view, Object component) {
        return (FragmentMembershipBinding) bind(component, view, R.layout.fragment_membership);
    }
}