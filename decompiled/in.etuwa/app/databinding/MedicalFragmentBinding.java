package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.medical.MedicalViewModel;

/* loaded from: classes3.dex */
public abstract class MedicalFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabAddLeave;

    @Bindable
    protected MedicalViewModel mMedicalViewModel;
    public final RecyclerView rvMedical;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setMedicalViewModel(MedicalViewModel medicalViewModel);

    protected MedicalFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabAddLeave, RecyclerView rvMedical, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabAddLeave = fabAddLeave;
        this.rvMedical = rvMedical;
        this.swipeLayout = swipeLayout;
    }

    public MedicalViewModel getMedicalViewModel() {
        return this.mMedicalViewModel;
    }

    public static MedicalFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MedicalFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (MedicalFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.medical_fragment, root, attachToRoot, component);
    }

    public static MedicalFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MedicalFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (MedicalFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.medical_fragment, null, false, component);
    }

    public static MedicalFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MedicalFragmentBinding bind(View view, Object component) {
        return (MedicalFragmentBinding) bind(component, view, R.layout.medical_fragment);
    }
}