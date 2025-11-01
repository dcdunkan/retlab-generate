package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.duty.proof.ViewProofDutyLeaveViewModel;

/* loaded from: classes3.dex */
public abstract class DialogViewProofDutyLeaveBinding extends ViewDataBinding {

    @Bindable
    protected ViewProofDutyLeaveViewModel mViewProofDutyLeaveViewModel;
    public final WebView webview;

    public abstract void setViewProofDutyLeaveViewModel(ViewProofDutyLeaveViewModel viewProofDutyLeaveViewModel);

    protected DialogViewProofDutyLeaveBinding(Object _bindingComponent, View _root, int _localFieldCount, WebView webview) {
        super(_bindingComponent, _root, _localFieldCount);
        this.webview = webview;
    }

    public ViewProofDutyLeaveViewModel getViewProofDutyLeaveViewModel() {
        return this.mViewProofDutyLeaveViewModel;
    }

    public static DialogViewProofDutyLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewProofDutyLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogViewProofDutyLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_view_proof_duty_leave, root, attachToRoot, component);
    }

    public static DialogViewProofDutyLeaveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewProofDutyLeaveBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogViewProofDutyLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_view_proof_duty_leave, null, false, component);
    }

    public static DialogViewProofDutyLeaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewProofDutyLeaveBinding bind(View view, Object component) {
        return (DialogViewProofDutyLeaveBinding) bind(component, view, R.layout.dialog_view_proof_duty_leave);
    }
}