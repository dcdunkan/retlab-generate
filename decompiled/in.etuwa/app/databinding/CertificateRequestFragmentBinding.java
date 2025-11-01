package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.certificate_request.CertificateRequestViewModel;

/* loaded from: classes3.dex */
public abstract class CertificateRequestFragmentBinding extends ViewDataBinding {
    public final Button addRequestBtn;

    @Bindable
    protected CertificateRequestViewModel mCertificateRequestViewModel;
    public final RecyclerView rvCertificateRequest;

    public abstract void setCertificateRequestViewModel(CertificateRequestViewModel certificateRequestViewModel);

    protected CertificateRequestFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, Button addRequestBtn, RecyclerView rvCertificateRequest) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addRequestBtn = addRequestBtn;
        this.rvCertificateRequest = rvCertificateRequest;
    }

    public CertificateRequestViewModel getCertificateRequestViewModel() {
        return this.mCertificateRequestViewModel;
    }

    public static CertificateRequestFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CertificateRequestFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CertificateRequestFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.certificate_request_fragment, root, attachToRoot, component);
    }

    public static CertificateRequestFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CertificateRequestFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (CertificateRequestFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.certificate_request_fragment, null, false, component);
    }

    public static CertificateRequestFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CertificateRequestFragmentBinding bind(View view, Object component) {
        return (CertificateRequestFragmentBinding) bind(component, view, R.layout.certificate_request_fragment);
    }
}