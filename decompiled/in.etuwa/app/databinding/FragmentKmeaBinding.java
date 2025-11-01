package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentKmeaBinding extends ViewDataBinding {
    public final TextView kmeaAmountTv;
    public final TextView kmeaFineTv;
    public final TextView kmeaMonthTv;
    public final TextView kmeaTotalTv;

    @Bindable
    protected KmeaHostelViewModel mKmeaHostelViewModel;
    public final TextView payNowBtn;

    public abstract void setKmeaHostelViewModel(KmeaHostelViewModel kmeaHostelViewModel);

    protected FragmentKmeaBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView kmeaAmountTv, TextView kmeaFineTv, TextView kmeaMonthTv, TextView kmeaTotalTv, TextView payNowBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.kmeaAmountTv = kmeaAmountTv;
        this.kmeaFineTv = kmeaFineTv;
        this.kmeaMonthTv = kmeaMonthTv;
        this.kmeaTotalTv = kmeaTotalTv;
        this.payNowBtn = payNowBtn;
    }

    public KmeaHostelViewModel getKmeaHostelViewModel() {
        return this.mKmeaHostelViewModel;
    }

    public static FragmentKmeaBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentKmeaBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentKmeaBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_kmea, root, attachToRoot, component);
    }

    public static FragmentKmeaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentKmeaBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentKmeaBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_kmea, null, false, component);
    }

    public static FragmentKmeaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentKmeaBinding bind(View view, Object component) {
        return (FragmentKmeaBinding) bind(component, view, R.layout.fragment_kmea);
    }
}