package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentProgramOutcomeBinding extends ViewDataBinding {

    @Bindable
    protected ProgramOutcomeViewModel mProgramOutcomeViewModel;
    public final RecyclerView rvEducational;
    public final RecyclerView rvOutcome;
    public final RecyclerView rvSpecific;

    public abstract void setProgramOutcomeViewModel(ProgramOutcomeViewModel programOutcomeViewModel);

    protected FragmentProgramOutcomeBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvEducational, RecyclerView rvOutcome, RecyclerView rvSpecific) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvEducational = rvEducational;
        this.rvOutcome = rvOutcome;
        this.rvSpecific = rvSpecific;
    }

    public ProgramOutcomeViewModel getProgramOutcomeViewModel() {
        return this.mProgramOutcomeViewModel;
    }

    public static FragmentProgramOutcomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProgramOutcomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentProgramOutcomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_program_outcome, root, attachToRoot, component);
    }

    public static FragmentProgramOutcomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProgramOutcomeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentProgramOutcomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_program_outcome, null, false, component);
    }

    public static FragmentProgramOutcomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProgramOutcomeBinding bind(View view, Object component) {
        return (FragmentProgramOutcomeBinding) bind(component, view, R.layout.fragment_program_outcome);
    }
}