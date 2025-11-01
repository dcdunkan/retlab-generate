package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.subject.SubjectViewModel;

/* loaded from: classes3.dex */
public abstract class SubjectFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabSubjectSemester;

    @Bindable
    protected SubjectViewModel mSubjectViewModel;
    public final RecyclerView rvSubject;
    public final Spinner spinnerSem;
    public final LinearLayout subjectLayout;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSubjectViewModel(SubjectViewModel subjectViewModel);

    protected SubjectFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabSubjectSemester, RecyclerView rvSubject, Spinner spinnerSem, LinearLayout subjectLayout, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabSubjectSemester = fabSubjectSemester;
        this.rvSubject = rvSubject;
        this.spinnerSem = spinnerSem;
        this.subjectLayout = subjectLayout;
        this.swipeLayout = swipeLayout;
    }

    public SubjectViewModel getSubjectViewModel() {
        return this.mSubjectViewModel;
    }

    public static SubjectFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubjectFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SubjectFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.subject_fragment, root, attachToRoot, component);
    }

    public static SubjectFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubjectFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SubjectFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.subject_fragment, null, false, component);
    }

    public static SubjectFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubjectFragmentBinding bind(View view, Object component) {
        return (SubjectFragmentBinding) bind(component, view, R.layout.subject_fragment);
    }
}