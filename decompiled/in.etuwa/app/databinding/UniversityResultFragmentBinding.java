package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.university.UniversityResultViewModel;

/* loaded from: classes3.dex */
public abstract class UniversityResultFragmentBinding extends ViewDataBinding {
    public final TextView branchName;
    public final TextView downloadBtn;

    @Bindable
    protected UniversityResultViewModel mUniversityResultViewModel;
    public final TextView progName;
    public final TextView regNo;
    public final RecyclerView rvResultList;
    public final TextView semName;
    public final LinearLayout swipeLayout;
    public final TextView tvEarnedCredit;
    public final TextView tvSgpa;

    public abstract void setUniversityResultViewModel(UniversityResultViewModel universityResultViewModel);

    protected UniversityResultFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView branchName, TextView downloadBtn, TextView progName, TextView regNo, RecyclerView rvResultList, TextView semName, LinearLayout swipeLayout, TextView tvEarnedCredit, TextView tvSgpa) {
        super(_bindingComponent, _root, _localFieldCount);
        this.branchName = branchName;
        this.downloadBtn = downloadBtn;
        this.progName = progName;
        this.regNo = regNo;
        this.rvResultList = rvResultList;
        this.semName = semName;
        this.swipeLayout = swipeLayout;
        this.tvEarnedCredit = tvEarnedCredit;
        this.tvSgpa = tvSgpa;
    }

    public UniversityResultViewModel getUniversityResultViewModel() {
        return this.mUniversityResultViewModel;
    }

    public static UniversityResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (UniversityResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.university_result_fragment, root, attachToRoot, component);
    }

    public static UniversityResultFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityResultFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (UniversityResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.university_result_fragment, null, false, component);
    }

    public static UniversityResultFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UniversityResultFragmentBinding bind(View view, Object component) {
        return (UniversityResultFragmentBinding) bind(component, view, R.layout.university_result_fragment);
    }
}