package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialogViewModel;

/* loaded from: classes3.dex */
public abstract class CovidCertificateTwoDialogBinding extends ViewDataBinding {
    public final LinearLayout covidCard;
    public final TextView covidSelectSecond;
    public final TextView covidUploadSecond;
    public final TextView fileNameSecond;
    public final ProgressBar loader;

    @Bindable
    protected CovidCertificateTwoDialogViewModel mCovidCertificateTwoDialogViewModel;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final ProgressBar uploadProgressbar;

    public abstract void setCovidCertificateTwoDialogViewModel(CovidCertificateTwoDialogViewModel covidCertificateTwoDialogViewModel);

    protected CovidCertificateTwoDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout covidCard, TextView covidSelectSecond, TextView covidUploadSecond, TextView fileNameSecond, ProgressBar loader, TextView progressText, LinearLayout progressView, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.covidCard = covidCard;
        this.covidSelectSecond = covidSelectSecond;
        this.covidUploadSecond = covidUploadSecond;
        this.fileNameSecond = fileNameSecond;
        this.loader = loader;
        this.progressText = progressText;
        this.progressView = progressView;
        this.uploadProgressbar = uploadProgressbar;
    }

    public CovidCertificateTwoDialogViewModel getCovidCertificateTwoDialogViewModel() {
        return this.mCovidCertificateTwoDialogViewModel;
    }

    public static CovidCertificateTwoDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CovidCertificateTwoDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CovidCertificateTwoDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.covid_certificate_two_dialog, root, attachToRoot, component);
    }

    public static CovidCertificateTwoDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CovidCertificateTwoDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CovidCertificateTwoDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.covid_certificate_two_dialog, null, false, component);
    }

    public static CovidCertificateTwoDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CovidCertificateTwoDialogBinding bind(View view, Object component) {
        return (CovidCertificateTwoDialogBinding) bind(component, view, R.layout.covid_certificate_two_dialog);
    }
}