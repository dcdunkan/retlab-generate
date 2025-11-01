package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialogViewModel;

/* loaded from: classes3.dex */
public abstract class SemListDialogBinding extends ViewDataBinding {

    @Bindable
    protected SemListDialogViewModel mSemListDialogViewModel;
    public final RecyclerView rvUnivSemList;

    public abstract void setSemListDialogViewModel(SemListDialogViewModel semListDialogViewModel);

    protected SemListDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvUnivSemList) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvUnivSemList = rvUnivSemList;
    }

    public SemListDialogViewModel getSemListDialogViewModel() {
        return this.mSemListDialogViewModel;
    }

    public static SemListDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemListDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SemListDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_list_dialog, root, attachToRoot, component);
    }

    public static SemListDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemListDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SemListDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_list_dialog, null, false, component);
    }

    public static SemListDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemListDialogBinding bind(View view, Object component) {
        return (SemListDialogBinding) bind(component, view, R.layout.sem_list_dialog);
    }
}