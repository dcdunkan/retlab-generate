package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.visiondialog.VisionDialogViewModel;

/* loaded from: classes3.dex */
public abstract class DialogVisionBinding extends ViewDataBinding {

    @Bindable
    protected VisionDialogViewModel mVisionDialogViewModel;
    public final TextView visColg;
    public final TextView visDept;

    public abstract void setVisionDialogViewModel(VisionDialogViewModel visionDialogViewModel);

    protected DialogVisionBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView visColg, TextView visDept) {
        super(_bindingComponent, _root, _localFieldCount);
        this.visColg = visColg;
        this.visDept = visDept;
    }

    public VisionDialogViewModel getVisionDialogViewModel() {
        return this.mVisionDialogViewModel;
    }

    public static DialogVisionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogVisionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogVisionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_vision, root, attachToRoot, component);
    }

    public static DialogVisionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogVisionBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogVisionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_vision, null, false, component);
    }

    public static DialogVisionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogVisionBinding bind(View view, Object component) {
        return (DialogVisionBinding) bind(component, view, R.layout.dialog_vision);
    }
}