package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.university.exampages.UniversityExamsViewModel;

/* loaded from: classes3.dex */
public abstract class UniversityExamsFragmentBinding extends ViewDataBinding {

    @Bindable
    protected UniversityExamsViewModel mUniversityExamsViewModel;
    public final RecyclerView rvUnivExams;

    public abstract void setUniversityExamsViewModel(UniversityExamsViewModel universityExamsViewModel);

    protected UniversityExamsFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvUnivExams) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvUnivExams = rvUnivExams;
    }

    public UniversityExamsViewModel getUniversityExamsViewModel() {
        return this.mUniversityExamsViewModel;
    }

    public static UniversityExamsFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityExamsFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (UniversityExamsFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.university_exams_fragment, root, attachToRoot, component);
    }

    public static UniversityExamsFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityExamsFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (UniversityExamsFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.university_exams_fragment, null, false, component);
    }

    public static UniversityExamsFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityExamsFragmentBinding bind(View view, Object component) {
        return (UniversityExamsFragmentBinding) bind(component, view, R.layout.university_exams_fragment);
    }
}