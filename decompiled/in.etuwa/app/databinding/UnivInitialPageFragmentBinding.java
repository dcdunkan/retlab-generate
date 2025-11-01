package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.university.initialpage.UnivInitialPageViewModel;

/* loaded from: classes3.dex */
public abstract class UnivInitialPageFragmentBinding extends ViewDataBinding {
    public final TextView cgpa;
    public final TextView credits;
    public final TextView internalMark;
    public final TextView internalMarkTv;

    @Bindable
    protected UnivInitialPageViewModel mUnivInitialPageViewModel;
    public final TextView resultStatus;
    public final RecyclerView rvUnivSubjects;
    public final TextView sgpa;

    public abstract void setUnivInitialPageViewModel(UnivInitialPageViewModel univInitialPageViewModel);

    protected UnivInitialPageFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView cgpa, TextView credits, TextView internalMark, TextView internalMarkTv, TextView resultStatus, RecyclerView rvUnivSubjects, TextView sgpa) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cgpa = cgpa;
        this.credits = credits;
        this.internalMark = internalMark;
        this.internalMarkTv = internalMarkTv;
        this.resultStatus = resultStatus;
        this.rvUnivSubjects = rvUnivSubjects;
        this.sgpa = sgpa;
    }

    public UnivInitialPageViewModel getUnivInitialPageViewModel() {
        return this.mUnivInitialPageViewModel;
    }

    public static UnivInitialPageFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UnivInitialPageFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (UnivInitialPageFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.univ_initial_page_fragment, root, attachToRoot, component);
    }

    public static UnivInitialPageFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UnivInitialPageFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (UnivInitialPageFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.univ_initial_page_fragment, null, false, component);
    }

    public static UnivInitialPageFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UnivInitialPageFragmentBinding bind(View view, Object component) {
        return (UnivInitialPageFragmentBinding) bind(component, view, R.layout.univ_initial_page_fragment);
    }
}