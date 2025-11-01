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
import in.etuwa.app.ui.grievance.view.ViewGrievanceViewModel;

/* loaded from: classes3.dex */
public abstract class ViewGrievanceFragmentBinding extends ViewDataBinding {
    public final TextView actionLevelBtn;
    public final TextView cellMemberBtn;
    public final TextView grActionTaken;
    public final TextView grDateOfReply;
    public final TextView grDetails;
    public final TextView grGrievant;
    public final TextView grNumber;
    public final TextView grPostDate;
    public final TextView grReply;
    public final TextView grReplyDetails;
    public final TextView grStatus;
    public final TextView grTitle;
    public final TextView grType;

    @Bindable
    protected ViewGrievanceViewModel mViewGrievanceViewModel;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView viewGrDocBtn;
    public final TextView viewReplyDocBtn;

    public abstract void setViewGrievanceViewModel(ViewGrievanceViewModel viewGrievanceViewModel);

    protected ViewGrievanceFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView actionLevelBtn, TextView cellMemberBtn, TextView grActionTaken, TextView grDateOfReply, TextView grDetails, TextView grGrievant, TextView grNumber, TextView grPostDate, TextView grReply, TextView grReplyDetails, TextView grStatus, TextView grTitle, TextView grType, SwipeRefreshLayout swipeLayout, TextView viewGrDocBtn, TextView viewReplyDocBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.actionLevelBtn = actionLevelBtn;
        this.cellMemberBtn = cellMemberBtn;
        this.grActionTaken = grActionTaken;
        this.grDateOfReply = grDateOfReply;
        this.grDetails = grDetails;
        this.grGrievant = grGrievant;
        this.grNumber = grNumber;
        this.grPostDate = grPostDate;
        this.grReply = grReply;
        this.grReplyDetails = grReplyDetails;
        this.grStatus = grStatus;
        this.grTitle = grTitle;
        this.grType = grType;
        this.swipeLayout = swipeLayout;
        this.viewGrDocBtn = viewGrDocBtn;
        this.viewReplyDocBtn = viewReplyDocBtn;
    }

    public ViewGrievanceViewModel getViewGrievanceViewModel() {
        return this.mViewGrievanceViewModel;
    }

    public static ViewGrievanceFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewGrievanceFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewGrievanceFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_grievance_fragment, root, attachToRoot, component);
    }

    public static ViewGrievanceFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewGrievanceFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewGrievanceFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_grievance_fragment, null, false, component);
    }

    public static ViewGrievanceFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewGrievanceFragmentBinding bind(View view, Object component) {
        return (ViewGrievanceFragmentBinding) bind(component, view, R.layout.view_grievance_fragment);
    }
}