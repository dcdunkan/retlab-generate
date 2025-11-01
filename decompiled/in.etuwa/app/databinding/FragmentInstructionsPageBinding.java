package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.newquiz.instructionspage.InstructionsPageViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentInstructionsPageBinding extends ViewDataBinding {

    @Bindable
    protected InstructionsPageViewModel mInstructionsPageViewModel;

    public abstract void setInstructionsPageViewModel(InstructionsPageViewModel instructionsPageViewModel);

    protected FragmentInstructionsPageBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public InstructionsPageViewModel getInstructionsPageViewModel() {
        return this.mInstructionsPageViewModel;
    }

    public static FragmentInstructionsPageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInstructionsPageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentInstructionsPageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_instructions_page, root, attachToRoot, component);
    }

    public static FragmentInstructionsPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInstructionsPageBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentInstructionsPageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_instructions_page, null, false, component);
    }

    public static FragmentInstructionsPageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInstructionsPageBinding bind(View view, Object component) {
        return (FragmentInstructionsPageBinding) bind(component, view, R.layout.fragment_instructions_page);
    }
}