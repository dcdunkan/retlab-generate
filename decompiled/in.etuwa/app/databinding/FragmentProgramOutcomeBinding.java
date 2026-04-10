package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentProgramOutcomeBinding extends ViewDataBinding {
    public final TextView educationalBtn;
    public final HorizontalScrollView hrView;

    @Bindable
    protected ProgramOutcomeViewModel mProgramOutcomeViewModel;
    public final TextView objectivesBtn;
    public final TextView outcomeBtn;
    public final RecyclerView rvEducational;
    public final RecyclerView rvOutcome;
    public final RecyclerView rvSpecific;
    public final TextView toolbar;

    public abstract void setProgramOutcomeViewModel(ProgramOutcomeViewModel programOutcomeViewModel);

    protected FragmentProgramOutcomeBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView educationalBtn, HorizontalScrollView hrView, TextView objectivesBtn, TextView outcomeBtn, RecyclerView rvEducational, RecyclerView rvOutcome, RecyclerView rvSpecific, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.educationalBtn = educationalBtn;
        this.hrView = hrView;
        this.objectivesBtn = objectivesBtn;
        this.outcomeBtn = outcomeBtn;
        this.rvEducational = rvEducational;
        this.rvOutcome = rvOutcome;
        this.rvSpecific = rvSpecific;
        this.toolbar = toolbar;
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