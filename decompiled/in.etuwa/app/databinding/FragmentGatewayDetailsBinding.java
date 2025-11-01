package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.gateway.GatewayViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentGatewayDetailsBinding extends ViewDataBinding {
    public final TextView addrssTv;
    public final TextView contactTv;
    public final TextView ipgDownloadBtn;

    @Bindable
    protected GatewayViewModel mGatewayViewModel;
    public final TextView merchantNameTv;
    public final TextView refundPolicyBtn;

    public abstract void setGatewayViewModel(GatewayViewModel gatewayViewModel);

    protected FragmentGatewayDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addrssTv, TextView contactTv, TextView ipgDownloadBtn, TextView merchantNameTv, TextView refundPolicyBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addrssTv = addrssTv;
        this.contactTv = contactTv;
        this.ipgDownloadBtn = ipgDownloadBtn;
        this.merchantNameTv = merchantNameTv;
        this.refundPolicyBtn = refundPolicyBtn;
    }

    public GatewayViewModel getGatewayViewModel() {
        return this.mGatewayViewModel;
    }

    public static FragmentGatewayDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGatewayDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentGatewayDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_gateway_details, root, attachToRoot, component);
    }

    public static FragmentGatewayDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGatewayDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentGatewayDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_gateway_details, null, false, component);
    }

    public static FragmentGatewayDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGatewayDetailsBinding bind(View view, Object component) {
        return (FragmentGatewayDetailsBinding) bind(component, view, R.layout.fragment_gateway_details);
    }
}