package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.lab.LabViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentLabBinding extends ViewDataBinding {
    public final LinearLayout cardDue;
    public final LinearLayout cardEquipment;
    public final LinearLayout cardPractical;

    @Bindable
    protected LabViewModel mLabViewModel;

    public abstract void setLabViewModel(LabViewModel labViewModel);

    protected FragmentLabBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout cardDue, LinearLayout cardEquipment, LinearLayout cardPractical) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardDue = cardDue;
        this.cardEquipment = cardEquipment;
        this.cardPractical = cardPractical;
    }

    public LabViewModel getLabViewModel() {
        return this.mLabViewModel;
    }

    public static FragmentLabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentLabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_lab, root, attachToRoot, component);
    }

    public static FragmentLabBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLabBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentLabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_lab, null, false, component);
    }

    public static FragmentLabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLabBinding bind(View view, Object component) {
        return (FragmentLabBinding) bind(component, view, R.layout.fragment_lab);
    }
}