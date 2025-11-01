package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel;

/* loaded from: classes3.dex */
public abstract class ViewCounsellingFragmentBinding extends ViewDataBinding {
    public final TextView action2LevelBtncs;
    public final TextView cellMemberBtncs;
    public final TextView csActionTaken;
    public final TextView csApplicant;
    public final TextView csConcern;
    public final TextView csCounsellingHistory;
    public final TextView csCounsellingSessionRequired;
    public final TextView csDate;
    public final TextView csImpactHome;
    public final TextView csImpactRelationship;
    public final TextView csImpactStudies;
    public final TextView csNumber;
    public final TextView csPhysicallyEmotionally;
    public final TextView csType;

    @Bindable
    protected ViewCounsellingViewModel mViewCounsellingViewModel;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setViewCounsellingViewModel(ViewCounsellingViewModel viewCounsellingViewModel);

    protected ViewCounsellingFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView action2LevelBtncs, TextView cellMemberBtncs, TextView csActionTaken, TextView csApplicant, TextView csConcern, TextView csCounsellingHistory, TextView csCounsellingSessionRequired, TextView csDate, TextView csImpactHome, TextView csImpactRelationship, TextView csImpactStudies, TextView csNumber, TextView csPhysicallyEmotionally, TextView csType, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.action2LevelBtncs = action2LevelBtncs;
        this.cellMemberBtncs = cellMemberBtncs;
        this.csActionTaken = csActionTaken;
        this.csApplicant = csApplicant;
        this.csConcern = csConcern;
        this.csCounsellingHistory = csCounsellingHistory;
        this.csCounsellingSessionRequired = csCounsellingSessionRequired;
        this.csDate = csDate;
        this.csImpactHome = csImpactHome;
        this.csImpactRelationship = csImpactRelationship;
        this.csImpactStudies = csImpactStudies;
        this.csNumber = csNumber;
        this.csPhysicallyEmotionally = csPhysicallyEmotionally;
        this.csType = csType;
        this.swipeLayout = swipeLayout;
    }

    public ViewCounsellingViewModel getViewCounsellingViewModel() {
        return this.mViewCounsellingViewModel;
    }

    public static ViewCounsellingFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewCounsellingFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewCounsellingFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_counselling_fragment, root, attachToRoot, component);
    }

    public static ViewCounsellingFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewCounsellingFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewCounsellingFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_counselling_fragment, null, false, component);
    }

    public static ViewCounsellingFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewCounsellingFragmentBinding bind(View view, Object component) {
        return (ViewCounsellingFragmentBinding) bind(component, view, R.layout.view_counselling_fragment);
    }
}