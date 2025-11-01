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
import in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanViewModel;

/* loaded from: classes3.dex */
public abstract class DialogSubjectPlanBinding extends ViewDataBinding {
    public final TextView dateTv;

    @Bindable
    protected SubjectPlanViewModel mSubjectPlanViewModel;
    public final RecyclerView rvSubjectPlan;

    public abstract void setSubjectPlanViewModel(SubjectPlanViewModel subjectPlanViewModel);

    protected DialogSubjectPlanBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView dateTv, RecyclerView rvSubjectPlan) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dateTv = dateTv;
        this.rvSubjectPlan = rvSubjectPlan;
    }

    public SubjectPlanViewModel getSubjectPlanViewModel() {
        return this.mSubjectPlanViewModel;
    }

    public static DialogSubjectPlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubjectPlanBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogSubjectPlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_subject_plan, root, attachToRoot, component);
    }

    public static DialogSubjectPlanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubjectPlanBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogSubjectPlanBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_subject_plan, null, false, component);
    }

    public static DialogSubjectPlanBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubjectPlanBinding bind(View view, Object component) {
        return (DialogSubjectPlanBinding) bind(component, view, R.layout.dialog_subject_plan);
    }
}