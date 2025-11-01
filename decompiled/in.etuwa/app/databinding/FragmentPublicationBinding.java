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
import in.etuwa.app.ui.profile.quality_publication.PublicationViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPublicationBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected PublicationViewModel mPublicationViewModel;
    public final RecyclerView rvPublication;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setPublicationViewModel(PublicationViewModel publicationViewModel);

    protected FragmentPublicationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvPublication, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvPublication = rvPublication;
        this.swipeLayout = swipeLayout;
    }

    public PublicationViewModel getPublicationViewModel() {
        return this.mPublicationViewModel;
    }

    public static FragmentPublicationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPublicationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPublicationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_publication, root, attachToRoot, component);
    }

    public static FragmentPublicationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPublicationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPublicationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_publication, null, false, component);
    }

    public static FragmentPublicationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPublicationBinding bind(View view, Object component) {
        return (FragmentPublicationBinding) bind(component, view, R.layout.fragment_publication);
    }
}