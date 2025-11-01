package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainViewModel;

/* loaded from: classes3.dex */
public abstract class ProgramOutcomeMainFragmentBinding extends ViewDataBinding {
    public final TextView educationalBtn;

    @Bindable
    protected ProgramOutcomeMainViewModel mProgramOutcomeMainViewModel;
    public final TextView outcomeBtn;
    public final TextView specificBtn;

    public abstract void setProgramOutcomeMainViewModel(ProgramOutcomeMainViewModel programOutcomeMainViewModel);

    protected ProgramOutcomeMainFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView educationalBtn, TextView outcomeBtn, TextView specificBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.educationalBtn = educationalBtn;
        this.outcomeBtn = outcomeBtn;
        this.specificBtn = specificBtn;
    }

    public ProgramOutcomeMainViewModel getProgramOutcomeMainViewModel() {
        return this.mProgramOutcomeMainViewModel;
    }

    public static ProgramOutcomeMainFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProgramOutcomeMainFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ProgramOutcomeMainFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.program_outcome_main_fragment, root, attachToRoot, component);
    }

    public static ProgramOutcomeMainFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProgramOutcomeMainFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ProgramOutcomeMainFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.program_outcome_main_fragment, null, false, component);
    }

    public static ProgramOutcomeMainFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProgramOutcomeMainFragmentBinding bind(View view, Object component) {
        return (ProgramOutcomeMainFragmentBinding) bind(component, view, R.layout.program_outcome_main_fragment);
    }
}