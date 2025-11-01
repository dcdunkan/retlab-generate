package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.tkmhostel.HostelMainViewModel;

/* loaded from: classes3.dex */
public abstract class HostelFragmentTkmBinding extends ViewDataBinding {
    public final LinearLayout attendanceHostelBtn;
    public final LinearLayout hostelNewRegistration;

    @Bindable
    protected HostelMainViewModel mHostelMainViewModel;
    public final LinearLayout messGcekBtn;
    public final LinearLayout payTkmBtn;
    public final LinearLayout receiptTkmBtn;
    public final TextView regTkmBtn;
    public final View viewRegHostel;

    public abstract void setHostelMainViewModel(HostelMainViewModel hostelMainViewModel);

    protected HostelFragmentTkmBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout attendanceHostelBtn, LinearLayout hostelNewRegistration, LinearLayout messGcekBtn, LinearLayout payTkmBtn, LinearLayout receiptTkmBtn, TextView regTkmBtn, View viewRegHostel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.attendanceHostelBtn = attendanceHostelBtn;
        this.hostelNewRegistration = hostelNewRegistration;
        this.messGcekBtn = messGcekBtn;
        this.payTkmBtn = payTkmBtn;
        this.receiptTkmBtn = receiptTkmBtn;
        this.regTkmBtn = regTkmBtn;
        this.viewRegHostel = viewRegHostel;
    }

    public HostelMainViewModel getHostelMainViewModel() {
        return this.mHostelMainViewModel;
    }

    public static HostelFragmentTkmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HostelFragmentTkmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (HostelFragmentTkmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.hostel_fragment_tkm, root, attachToRoot, component);
    }

    public static HostelFragmentTkmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HostelFragmentTkmBinding inflate(LayoutInflater inflater, Object component) {
        return (HostelFragmentTkmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.hostel_fragment_tkm, null, false, component);
    }

    public static HostelFragmentTkmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HostelFragmentTkmBinding bind(View view, Object component) {
        return (HostelFragmentTkmBinding) bind(component, view, R.layout.hostel_fragment_tkm);
    }
}