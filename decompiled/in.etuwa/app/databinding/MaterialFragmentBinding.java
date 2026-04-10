package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.studymaterials.MaterialViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MaterialFragmentBinding extends ViewDataBinding {
    public final ImageView fabUniv;
    public final ImageView ivClearSearch;
    public final ImageView ivSearch;

    @Bindable
    protected MaterialViewModel mMaterialViewModel;
    public final RecyclerView rvMaterials;
    public final CardView searchCard;
    public final EditText searchInput;
    public final Spinner spinnerFill;
    public final Spinner spinnerModule;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;

    public abstract void setMaterialViewModel(MaterialViewModel materialViewModel);

    protected MaterialFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView fabUniv, ImageView ivClearSearch, ImageView ivSearch, RecyclerView rvMaterials, CardView searchCard, EditText searchInput, Spinner spinnerFill, Spinner spinnerModule, SwipeRefreshLayout swipeLayout, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabUniv = fabUniv;
        this.ivClearSearch = ivClearSearch;
        this.ivSearch = ivSearch;
        this.rvMaterials = rvMaterials;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.spinnerFill = spinnerFill;
        this.spinnerModule = spinnerModule;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
    }

    public MaterialViewModel getMaterialViewModel() {
        return this.mMaterialViewModel;
    }

    public static MaterialFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MaterialFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (MaterialFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.material_fragment, root, attachToRoot, component);
    }

    public static MaterialFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MaterialFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (MaterialFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.material_fragment, null, false, component);
    }

    public static MaterialFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MaterialFragmentBinding bind(View view, Object component) {
        return (MaterialFragmentBinding) bind(component, view, R.layout.material_fragment);
    }
}