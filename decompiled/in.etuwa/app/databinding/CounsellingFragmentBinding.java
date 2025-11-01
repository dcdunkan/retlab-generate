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
import in.etuwa.app.ui.counselling.CounsellingViewModel;

/* loaded from: classes3.dex */
public abstract class CounsellingFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabAddCounselling;

    @Bindable
    protected CounsellingViewModel mCounsellingViewModel;
    public final RecyclerView rvCounselling;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCounsellingViewModel(CounsellingViewModel counsellingViewModel);

    protected CounsellingFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabAddCounselling, RecyclerView rvCounselling, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabAddCounselling = fabAddCounselling;
        this.rvCounselling = rvCounselling;
        this.swipeLayout = swipeLayout;
    }

    public CounsellingViewModel getCounsellingViewModel() {
        return this.mCounsellingViewModel;
    }

    public static CounsellingFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CounsellingFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CounsellingFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.counselling_fragment, root, attachToRoot, component);
    }

    public static CounsellingFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CounsellingFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (CounsellingFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.counselling_fragment, null, false, component);
    }

    public static CounsellingFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CounsellingFragmentBinding bind(View view, Object component) {
        return (CounsellingFragmentBinding) bind(component, view, R.layout.counselling_fragment);
    }
}