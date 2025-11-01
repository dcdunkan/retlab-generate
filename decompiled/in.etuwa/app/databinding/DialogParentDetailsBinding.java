package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.parentdetails.ParentDetailsViewModel;

/* loaded from: classes3.dex */
public abstract class DialogParentDetailsBinding extends ViewDataBinding {
    public final TextView email;
    public final TextView fatherName;
    public final TextView fatherNumber;
    public final TextView fatherOcc;

    @Bindable
    protected ParentDetailsViewModel mParentDetailsViewModel;
    public final TextView motherName;
    public final TextView motherNum;
    public final TextView motherOcc;

    public abstract void setParentDetailsViewModel(ParentDetailsViewModel parentDetailsViewModel);

    protected DialogParentDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView email, TextView fatherName, TextView fatherNumber, TextView fatherOcc, TextView motherName, TextView motherNum, TextView motherOcc) {
        super(_bindingComponent, _root, _localFieldCount);
        this.email = email;
        this.fatherName = fatherName;
        this.fatherNumber = fatherNumber;
        this.fatherOcc = fatherOcc;
        this.motherName = motherName;
        this.motherNum = motherNum;
        this.motherOcc = motherOcc;
    }

    public ParentDetailsViewModel getParentDetailsViewModel() {
        return this.mParentDetailsViewModel;
    }

    public static DialogParentDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogParentDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogParentDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_parent_details, root, attachToRoot, component);
    }

    public static DialogParentDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogParentDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogParentDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_parent_details, null, false, component);
    }

    public static DialogParentDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogParentDetailsBinding bind(View view, Object component) {
        return (DialogParentDetailsBinding) bind(component, view, R.layout.dialog_parent_details);
    }
}