package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.due.DueMainViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentDuesMainBinding extends ViewDataBinding {

    @Bindable
    protected DueMainViewModel mDueMainViewModel;
    public final TextView payDueBtn;
    public final TextView viewDueCertificate;
    public final TextView viewDueReceipt;

    public abstract void setDueMainViewModel(DueMainViewModel dueMainViewModel);

    protected FragmentDuesMainBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payDueBtn, TextView viewDueCertificate, TextView viewDueReceipt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payDueBtn = payDueBtn;
        this.viewDueCertificate = viewDueCertificate;
        this.viewDueReceipt = viewDueReceipt;
    }

    public DueMainViewModel getDueMainViewModel() {
        return this.mDueMainViewModel;
    }

    public static FragmentDuesMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDuesMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDuesMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_dues_main, root, attachToRoot, component);
    }

    public static FragmentDuesMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDuesMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDuesMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_dues_main, null, false, component);
    }

    public static FragmentDuesMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDuesMainBinding bind(View view, Object component) {
        return (FragmentDuesMainBinding) bind(component, view, R.layout.fragment_dues_main);
    }
}