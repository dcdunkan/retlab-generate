package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogViewModelTwo;

/* loaded from: classes3.dex */
public abstract class SemListDialogSessionBinding extends ViewDataBinding {

    @Bindable
    protected SemListDialogViewModelTwo mSemListDialogViewModelTwo;
    public final RecyclerView rvSessionSemList;

    public abstract void setSemListDialogViewModelTwo(SemListDialogViewModelTwo semListDialogViewModelTwo);

    protected SemListDialogSessionBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSessionSemList) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSessionSemList = rvSessionSemList;
    }

    public SemListDialogViewModelTwo getSemListDialogViewModelTwo() {
        return this.mSemListDialogViewModelTwo;
    }

    public static SemListDialogSessionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemListDialogSessionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SemListDialogSessionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_list_dialog_session, root, attachToRoot, component);
    }

    public static SemListDialogSessionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemListDialogSessionBinding inflate(LayoutInflater inflater, Object component) {
        return (SemListDialogSessionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_list_dialog_session, null, false, component);
    }

    public static SemListDialogSessionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemListDialogSessionBinding bind(View view, Object component) {
        return (SemListDialogSessionBinding) bind(component, view, R.layout.sem_list_dialog_session);
    }
}