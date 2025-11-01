package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.duty.directapply.viewproof.ViewProofViewModel;

/* loaded from: classes3.dex */
public abstract class DialogViewProofBinding extends ViewDataBinding {

    @Bindable
    protected ViewProofViewModel mViewProofViewModel;
    public final WebView proofView;

    public abstract void setViewProofViewModel(ViewProofViewModel viewProofViewModel);

    protected DialogViewProofBinding(Object _bindingComponent, View _root, int _localFieldCount, WebView proofView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.proofView = proofView;
    }

    public ViewProofViewModel getViewProofViewModel() {
        return this.mViewProofViewModel;
    }

    public static DialogViewProofBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewProofBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogViewProofBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_view_proof, root, attachToRoot, component);
    }

    public static DialogViewProofBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewProofBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogViewProofBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_view_proof, null, false, component);
    }

    public static DialogViewProofBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewProofBinding bind(View view, Object component) {
        return (DialogViewProofBinding) bind(component, view, R.layout.dialog_view_proof);
    }
}