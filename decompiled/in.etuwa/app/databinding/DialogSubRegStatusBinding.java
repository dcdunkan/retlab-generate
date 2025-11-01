package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusViewModel;

/* loaded from: classes3.dex */
public abstract class DialogSubRegStatusBinding extends ViewDataBinding {

    @Bindable
    protected SubjectRegStatusViewModel mSubjectRegStatusViewModel;
    public final RecyclerView rvSubStatus;

    public abstract void setSubjectRegStatusViewModel(SubjectRegStatusViewModel subjectRegStatusViewModel);

    protected DialogSubRegStatusBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSubStatus) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSubStatus = rvSubStatus;
    }

    public SubjectRegStatusViewModel getSubjectRegStatusViewModel() {
        return this.mSubjectRegStatusViewModel;
    }

    public static DialogSubRegStatusBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubRegStatusBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogSubRegStatusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_sub_reg_status, root, attachToRoot, component);
    }

    public static DialogSubRegStatusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubRegStatusBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogSubRegStatusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_sub_reg_status, null, false, component);
    }

    public static DialogSubRegStatusBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubRegStatusBinding bind(View view, Object component) {
        return (DialogSubRegStatusBinding) bind(component, view, R.layout.dialog_sub_reg_status);
    }
}