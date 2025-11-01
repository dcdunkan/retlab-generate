package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.GrievanceViewModel;

/* loaded from: classes3.dex */
public abstract class GrievanceFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabAddGrievance;

    @Bindable
    protected GrievanceViewModel mGrievanceViewModel;
    public final RecyclerView rvGrievance;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setGrievanceViewModel(GrievanceViewModel grievanceViewModel);

    protected GrievanceFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabAddGrievance, RecyclerView rvGrievance, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabAddGrievance = fabAddGrievance;
        this.rvGrievance = rvGrievance;
        this.swipeLayout = swipeLayout;
    }

    public GrievanceViewModel getGrievanceViewModel() {
        return this.mGrievanceViewModel;
    }

    public static GrievanceFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GrievanceFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (GrievanceFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.grievance_fragment, root, attachToRoot, component);
    }

    public static GrievanceFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GrievanceFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (GrievanceFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.grievance_fragment, null, false, component);
    }

    public static GrievanceFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GrievanceFragmentBinding bind(View view, Object component) {
        return (GrievanceFragmentBinding) bind(component, view, R.layout.grievance_fragment);
    }
}