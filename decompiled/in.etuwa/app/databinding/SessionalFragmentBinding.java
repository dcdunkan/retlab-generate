package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.session.SessionalViewModel;

/* loaded from: classes3.dex */
public abstract class SessionalFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabSession;

    @Bindable
    protected SessionalViewModel mSessionalViewModel;
    public final RecyclerView rvResultSession;
    public final Spinner spinnerSemester;
    public final Spinner spinnerSession;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSessionalViewModel(SessionalViewModel sessionalViewModel);

    protected SessionalFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabSession, RecyclerView rvResultSession, Spinner spinnerSemester, Spinner spinnerSession, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabSession = fabSession;
        this.rvResultSession = rvResultSession;
        this.spinnerSemester = spinnerSemester;
        this.spinnerSession = spinnerSession;
        this.swipeLayout = swipeLayout;
    }

    public SessionalViewModel getSessionalViewModel() {
        return this.mSessionalViewModel;
    }

    public static SessionalFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SessionalFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SessionalFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sessional_fragment, root, attachToRoot, component);
    }

    public static SessionalFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SessionalFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SessionalFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sessional_fragment, null, false, component);
    }

    public static SessionalFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SessionalFragmentBinding bind(View view, Object component) {
        return (SessionalFragmentBinding) bind(component, view, R.layout.sessional_fragment);
    }
}