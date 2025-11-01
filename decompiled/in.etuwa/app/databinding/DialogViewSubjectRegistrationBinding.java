package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogViewSubjectRegistrationBinding extends ViewDataBinding {
    public final TextView categoryTv;

    @Bindable
    protected ViewSubjectRegistrationViewModel mViewSubjectRegistrationViewModel;
    public final TextView pathwayTv;
    public final TextView progressText;
    public final CardView progressView;
    public final RecyclerView rvSemHistory;
    public final RecyclerView rvSubStatus;
    public final TextView semHistoryBtn;
    public final TextView semTv;
    public final TextView subjectsBtn;
    public final TextView updateBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setViewSubjectRegistrationViewModel(ViewSubjectRegistrationViewModel viewSubjectRegistrationViewModel);

    protected DialogViewSubjectRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView categoryTv, TextView pathwayTv, TextView progressText, CardView progressView, RecyclerView rvSemHistory, RecyclerView rvSubStatus, TextView semHistoryBtn, TextView semTv, TextView subjectsBtn, TextView updateBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.categoryTv = categoryTv;
        this.pathwayTv = pathwayTv;
        this.progressText = progressText;
        this.progressView = progressView;
        this.rvSemHistory = rvSemHistory;
        this.rvSubStatus = rvSubStatus;
        this.semHistoryBtn = semHistoryBtn;
        this.semTv = semTv;
        this.subjectsBtn = subjectsBtn;
        this.updateBtn = updateBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ViewSubjectRegistrationViewModel getViewSubjectRegistrationViewModel() {
        return this.mViewSubjectRegistrationViewModel;
    }

    public static DialogViewSubjectRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewSubjectRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogViewSubjectRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_view_subject_registration, root, attachToRoot, component);
    }

    public static DialogViewSubjectRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewSubjectRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogViewSubjectRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_view_subject_registration, null, false, component);
    }

    public static DialogViewSubjectRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewSubjectRegistrationBinding bind(View view, Object component) {
        return (DialogViewSubjectRegistrationBinding) bind(component, view, R.layout.dialog_view_subject_registration);
    }
}