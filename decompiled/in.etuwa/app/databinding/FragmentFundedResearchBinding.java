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
import in.etuwa.app.ui.profile.fundedresearch.FundedResearchViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFundedResearchBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected FundedResearchViewModel mFundedResearchViewModel;
    public final RecyclerView rvResearch;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setFundedResearchViewModel(FundedResearchViewModel fundedResearchViewModel);

    protected FragmentFundedResearchBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvResearch, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvResearch = rvResearch;
        this.swipeLayout = swipeLayout;
    }

    public FundedResearchViewModel getFundedResearchViewModel() {
        return this.mFundedResearchViewModel;
    }

    public static FragmentFundedResearchBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFundedResearchBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFundedResearchBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_funded_research, root, attachToRoot, component);
    }

    public static FragmentFundedResearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFundedResearchBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFundedResearchBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_funded_research, null, false, component);
    }

    public static FragmentFundedResearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFundedResearchBinding bind(View view, Object component) {
        return (FragmentFundedResearchBinding) bind(component, view, R.layout.fragment_funded_research);
    }
}