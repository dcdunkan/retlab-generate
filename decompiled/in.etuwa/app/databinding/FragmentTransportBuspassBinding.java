package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.buspass.BusPassViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentTransportBuspassBinding extends ViewDataBinding {
    public final TextView bpAcademicProgram;
    public final TextView bpAdmssnNo;
    public final TextView bpBatch;
    public final TextView bpBoardingPoint;
    public final TextView bpDuration;
    public final TextView bpGender;
    public final ImageView bpImage;
    public final TextView bpName;
    public final TextView bpPassCategory;
    public final TextView bpPassCode;
    public final ImageView bpQr;
    public final TextView bpRoute;
    public final TextView bpSem;
    public final TextView bpValidity;
    public final ScrollView bussPassView;
    public final TextView fullScreenQrBtn;

    @Bindable
    protected BusPassViewModel mBusPassViewModel;
    public final TextView tvError;

    public abstract void setBusPassViewModel(BusPassViewModel busPassViewModel);

    protected FragmentTransportBuspassBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView bpAcademicProgram, TextView bpAdmssnNo, TextView bpBatch, TextView bpBoardingPoint, TextView bpDuration, TextView bpGender, ImageView bpImage, TextView bpName, TextView bpPassCategory, TextView bpPassCode, ImageView bpQr, TextView bpRoute, TextView bpSem, TextView bpValidity, ScrollView bussPassView, TextView fullScreenQrBtn, TextView tvError) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bpAcademicProgram = bpAcademicProgram;
        this.bpAdmssnNo = bpAdmssnNo;
        this.bpBatch = bpBatch;
        this.bpBoardingPoint = bpBoardingPoint;
        this.bpDuration = bpDuration;
        this.bpGender = bpGender;
        this.bpImage = bpImage;
        this.bpName = bpName;
        this.bpPassCategory = bpPassCategory;
        this.bpPassCode = bpPassCode;
        this.bpQr = bpQr;
        this.bpRoute = bpRoute;
        this.bpSem = bpSem;
        this.bpValidity = bpValidity;
        this.bussPassView = bussPassView;
        this.fullScreenQrBtn = fullScreenQrBtn;
        this.tvError = tvError;
    }

    public BusPassViewModel getBusPassViewModel() {
        return this.mBusPassViewModel;
    }

    public static FragmentTransportBuspassBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportBuspassBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTransportBuspassBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_buspass, root, attachToRoot, component);
    }

    public static FragmentTransportBuspassBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportBuspassBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTransportBuspassBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_buspass, null, false, component);
    }

    public static FragmentTransportBuspassBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportBuspassBinding bind(View view, Object component) {
        return (FragmentTransportBuspassBinding) bind(component, view, R.layout.fragment_transport_buspass);
    }
}