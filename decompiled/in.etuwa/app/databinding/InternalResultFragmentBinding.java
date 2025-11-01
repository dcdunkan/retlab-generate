package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.internal.InternalResultViewModel;

/* loaded from: classes3.dex */
public abstract class InternalResultFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabInternalResultSemester;
    public final LinearLayout internalLayout;
    public final TextView internalSemText;

    @Bindable
    protected InternalResultViewModel mInternalResultViewModel;
    public final RecyclerView rvResultInternal;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setInternalResultViewModel(InternalResultViewModel internalResultViewModel);

    protected InternalResultFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabInternalResultSemester, LinearLayout internalLayout, TextView internalSemText, RecyclerView rvResultInternal, Spinner spinnerSem, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabInternalResultSemester = fabInternalResultSemester;
        this.internalLayout = internalLayout;
        this.internalSemText = internalSemText;
        this.rvResultInternal = rvResultInternal;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
    }

    public InternalResultViewModel getInternalResultViewModel() {
        return this.mInternalResultViewModel;
    }

    public static InternalResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static InternalResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (InternalResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.internal_result_fragment, root, attachToRoot, component);
    }

    public static InternalResultFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static InternalResultFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (InternalResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.internal_result_fragment, null, false, component);
    }

    public static InternalResultFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static InternalResultFragmentBinding bind(View view, Object component) {
        return (InternalResultFragmentBinding) bind(component, view, R.layout.internal_result_fragment);
    }
}