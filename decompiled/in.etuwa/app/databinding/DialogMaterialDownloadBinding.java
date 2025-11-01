package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.studymaterials.download.MaterialDownloadViewModel;

/* loaded from: classes3.dex */
public abstract class DialogMaterialDownloadBinding extends ViewDataBinding {

    @Bindable
    protected MaterialDownloadViewModel mMaterialDownloadViewModel;
    public final RecyclerView rvExamDocs;

    public abstract void setMaterialDownloadViewModel(MaterialDownloadViewModel materialDownloadViewModel);

    protected DialogMaterialDownloadBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvExamDocs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvExamDocs = rvExamDocs;
    }

    public MaterialDownloadViewModel getMaterialDownloadViewModel() {
        return this.mMaterialDownloadViewModel;
    }

    public static DialogMaterialDownloadBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMaterialDownloadBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogMaterialDownloadBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_material_download, root, attachToRoot, component);
    }

    public static DialogMaterialDownloadBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMaterialDownloadBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogMaterialDownloadBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_material_download, null, false, component);
    }

    public static DialogMaterialDownloadBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMaterialDownloadBinding bind(View view, Object component) {
        return (DialogMaterialDownloadBinding) bind(component, view, R.layout.dialog_material_download);
    }
}