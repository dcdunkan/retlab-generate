package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.internship.InternshipViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentInternshipBinding extends ViewDataBinding {
    public final Button applyBtn;

    @Bindable
    protected InternshipViewModel mInternshipViewModel;
    public final RecyclerView rvInternship;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setInternshipViewModel(InternshipViewModel internshipViewModel);

    protected FragmentInternshipBinding(Object _bindingComponent, View _root, int _localFieldCount, Button applyBtn, RecyclerView rvInternship, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyBtn = applyBtn;
        this.rvInternship = rvInternship;
        this.swipeLayout = swipeLayout;
    }

    public InternshipViewModel getInternshipViewModel() {
        return this.mInternshipViewModel;
    }

    public static FragmentInternshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInternshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentInternshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_internship, root, attachToRoot, component);
    }

    public static FragmentInternshipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInternshipBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentInternshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_internship, null, false, component);
    }

    public static FragmentInternshipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInternshipBinding bind(View view, Object component) {
        return (FragmentInternshipBinding) bind(component, view, R.layout.fragment_internship);
    }
}