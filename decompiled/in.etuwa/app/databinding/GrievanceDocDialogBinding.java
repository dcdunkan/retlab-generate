package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialogViewModel;

/* loaded from: classes3.dex */
public abstract class GrievanceDocDialogBinding extends ViewDataBinding {

    @Bindable
    protected GrievanceDocDialogViewModel mGrievanceDocDialogViewModel;
    public final RecyclerView rvGrDocs;

    public abstract void setGrievanceDocDialogViewModel(GrievanceDocDialogViewModel grievanceDocDialogViewModel);

    protected GrievanceDocDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvGrDocs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvGrDocs = rvGrDocs;
    }

    public GrievanceDocDialogViewModel getGrievanceDocDialogViewModel() {
        return this.mGrievanceDocDialogViewModel;
    }

    public static GrievanceDocDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GrievanceDocDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (GrievanceDocDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.grievance_doc_dialog, root, attachToRoot, component);
    }

    public static GrievanceDocDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GrievanceDocDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (GrievanceDocDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.grievance_doc_dialog, null, false, component);
    }

    public static GrievanceDocDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GrievanceDocDialogBinding bind(View view, Object component) {
        return (GrievanceDocDialogBinding) bind(component, view, R.layout.grievance_doc_dialog);
    }
}