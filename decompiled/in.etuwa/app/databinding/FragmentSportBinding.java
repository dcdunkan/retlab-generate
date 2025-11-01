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
import in.etuwa.app.ui.profile.sport.SportViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentSportBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected SportViewModel mSportViewModel;
    public final RecyclerView rvParticipation;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSportViewModel(SportViewModel sportViewModel);

    protected FragmentSportBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvParticipation, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvParticipation = rvParticipation;
        this.swipeLayout = swipeLayout;
    }

    public SportViewModel getSportViewModel() {
        return this.mSportViewModel;
    }

    public static FragmentSportBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSportBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSportBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sport, root, attachToRoot, component);
    }

    public static FragmentSportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSportBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSportBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sport, null, false, component);
    }

    public static FragmentSportBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSportBinding bind(View view, Object component) {
        return (FragmentSportBinding) bind(component, view, R.layout.fragment_sport);
    }
}