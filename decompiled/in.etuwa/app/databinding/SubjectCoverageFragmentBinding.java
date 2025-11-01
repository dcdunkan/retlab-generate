package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.subject.coverage.SubjectCoverageViewModel;

/* loaded from: classes3.dex */
public abstract class SubjectCoverageFragmentBinding extends ViewDataBinding {
    public final TextView covered;

    @Bindable
    protected SubjectCoverageViewModel mSubjectCoverageViewModel;
    public final TextView notCovered;
    public final RecyclerView rvSubCoverage;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSubjectCoverageViewModel(SubjectCoverageViewModel subjectCoverageViewModel);

    protected SubjectCoverageFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView covered, TextView notCovered, RecyclerView rvSubCoverage, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.covered = covered;
        this.notCovered = notCovered;
        this.rvSubCoverage = rvSubCoverage;
        this.swipeLayout = swipeLayout;
    }

    public SubjectCoverageViewModel getSubjectCoverageViewModel() {
        return this.mSubjectCoverageViewModel;
    }

    public static SubjectCoverageFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubjectCoverageFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SubjectCoverageFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.subject_coverage_fragment, root, attachToRoot, component);
    }

    public static SubjectCoverageFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubjectCoverageFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SubjectCoverageFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.subject_coverage_fragment, null, false, component);
    }

    public static SubjectCoverageFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubjectCoverageFragmentBinding bind(View view, Object component) {
        return (SubjectCoverageFragmentBinding) bind(component, view, R.layout.subject_coverage_fragment);
    }
}