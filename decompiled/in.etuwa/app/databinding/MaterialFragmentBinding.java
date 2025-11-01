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
import in.etuwa.app.ui.studymaterials.MaterialViewModel;

/* loaded from: classes3.dex */
public abstract class MaterialFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabUniv;

    @Bindable
    protected MaterialViewModel mMaterialViewModel;
    public final RecyclerView rvMaterials;
    public final Spinner spinnerFill;
    public final Spinner spinnerModule;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setMaterialViewModel(MaterialViewModel materialViewModel);

    protected MaterialFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabUniv, RecyclerView rvMaterials, Spinner spinnerFill, Spinner spinnerModule, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabUniv = fabUniv;
        this.rvMaterials = rvMaterials;
        this.spinnerFill = spinnerFill;
        this.spinnerModule = spinnerModule;
        this.swipeLayout = swipeLayout;
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