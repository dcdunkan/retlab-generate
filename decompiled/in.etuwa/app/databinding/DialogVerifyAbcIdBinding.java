package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyViewModel;

/* loaded from: classes3.dex */
public abstract class DialogVerifyAbcIdBinding extends ViewDataBinding {
    public final TextView cancelBtn;
    public final TextView createBtn;
    public final EditText etSeriesDetails;

    @Bindable
    protected AbcIdVerifyViewModel mAbcIdVerifyViewModel;
    public final TextView toolbar;

    public abstract void setAbcIdVerifyViewModel(AbcIdVerifyViewModel abcIdVerifyViewModel);

    protected DialogVerifyAbcIdBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView cancelBtn, TextView createBtn, EditText etSeriesDetails, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cancelBtn = cancelBtn;
        this.createBtn = createBtn;
        this.etSeriesDetails = etSeriesDetails;
        this.toolbar = toolbar;
    }

    public AbcIdVerifyViewModel getAbcIdVerifyViewModel() {
        return this.mAbcIdVerifyViewModel;
    }

    public static DialogVerifyAbcIdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogVerifyAbcIdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogVerifyAbcIdBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_verify_abc_id, root, attachToRoot, component);
    }

    public static DialogVerifyAbcIdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogVerifyAbcIdBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogVerifyAbcIdBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_verify_abc_id, null, false, component);
    }

    public static DialogVerifyAbcIdBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogVerifyAbcIdBinding bind(View view, Object component) {
        return (DialogVerifyAbcIdBinding) bind(component, view, R.layout.dialog_verify_abc_id);
    }
}