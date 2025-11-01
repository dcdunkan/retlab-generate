package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.covidcertificate.CovidCertificateListMainViewModel;

/* loaded from: classes3.dex */
public abstract class CovidCertificateListMainFragmentBinding extends ViewDataBinding {
    public final TextView firstDoseBtn;

    @Bindable
    protected CovidCertificateListMainViewModel mCovidCertificateListMainViewModel;
    public final TextView secondDoseBtn;

    public abstract void setCovidCertificateListMainViewModel(CovidCertificateListMainViewModel covidCertificateListMainViewModel);

    protected CovidCertificateListMainFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView firstDoseBtn, TextView secondDoseBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.firstDoseBtn = firstDoseBtn;
        this.secondDoseBtn = secondDoseBtn;
    }

    public CovidCertificateListMainViewModel getCovidCertificateListMainViewModel() {
        return this.mCovidCertificateListMainViewModel;
    }

    public static CovidCertificateListMainFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CovidCertificateListMainFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CovidCertificateListMainFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.covid_certificate_list_main_fragment, root, attachToRoot, component);
    }

    public static CovidCertificateListMainFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CovidCertificateListMainFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (CovidCertificateListMainFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.covid_certificate_list_main_fragment, null, false, component);
    }

    public static CovidCertificateListMainFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CovidCertificateListMainFragmentBinding bind(View view, Object component) {
        return (CovidCertificateListMainFragmentBinding) bind(component, view, R.layout.covid_certificate_list_main_fragment);
    }
}