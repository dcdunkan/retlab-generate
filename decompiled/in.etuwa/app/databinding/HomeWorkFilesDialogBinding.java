package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.homework.files.HomeWorkFilesDialogViewModel;

/* loaded from: classes3.dex */
public abstract class HomeWorkFilesDialogBinding extends ViewDataBinding {

    @Bindable
    protected HomeWorkFilesDialogViewModel mHomeWorkFilesDialogViewModel;
    public final RecyclerView rvHwDocs;

    public abstract void setHomeWorkFilesDialogViewModel(HomeWorkFilesDialogViewModel homeWorkFilesDialogViewModel);

    protected HomeWorkFilesDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvHwDocs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvHwDocs = rvHwDocs;
    }

    public HomeWorkFilesDialogViewModel getHomeWorkFilesDialogViewModel() {
        return this.mHomeWorkFilesDialogViewModel;
    }

    public static HomeWorkFilesDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeWorkFilesDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (HomeWorkFilesDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.home_work_files_dialog, root, attachToRoot, component);
    }

    public static HomeWorkFilesDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeWorkFilesDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (HomeWorkFilesDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.home_work_files_dialog, null, false, component);
    }

    public static HomeWorkFilesDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeWorkFilesDialogBinding bind(View view, Object component) {
        return (HomeWorkFilesDialogBinding) bind(component, view, R.layout.home_work_files_dialog);
    }
}