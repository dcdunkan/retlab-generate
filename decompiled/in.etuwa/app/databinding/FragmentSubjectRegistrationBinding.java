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
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentSubjectRegistrationBinding extends ViewDataBinding {
    public final FloatingActionButton fabAddSubReg;

    @Bindable
    protected SubjectRegistrationViewModel mSubjectRegistrationViewModel;
    public final RecyclerView rvRegList;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSubjectRegistrationViewModel(SubjectRegistrationViewModel subjectRegistrationViewModel);

    protected FragmentSubjectRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabAddSubReg, RecyclerView rvRegList, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabAddSubReg = fabAddSubReg;
        this.rvRegList = rvRegList;
        this.swipeLayout = swipeLayout;
    }

    public SubjectRegistrationViewModel getSubjectRegistrationViewModel() {
        return this.mSubjectRegistrationViewModel;
    }

    public static FragmentSubjectRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubjectRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSubjectRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_subject_registration, root, attachToRoot, component);
    }

    public static FragmentSubjectRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubjectRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSubjectRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_subject_registration, null, false, component);
    }

    public static FragmentSubjectRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubjectRegistrationBinding bind(View view, Object component) {
        return (FragmentSubjectRegistrationBinding) bind(component, view, R.layout.fragment_subject_registration);
    }
}