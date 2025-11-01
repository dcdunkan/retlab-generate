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
import in.etuwa.app.ui.profile.scholarships.ScholarshipViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentScholarshipBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected ScholarshipViewModel mScholarshipViewModel;
    public final RecyclerView rvScholarship;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setScholarshipViewModel(ScholarshipViewModel scholarshipViewModel);

    protected FragmentScholarshipBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvScholarship, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvScholarship = rvScholarship;
        this.swipeLayout = swipeLayout;
    }

    public ScholarshipViewModel getScholarshipViewModel() {
        return this.mScholarshipViewModel;
    }

    public static FragmentScholarshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentScholarshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentScholarshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_scholarship, root, attachToRoot, component);
    }

    public static FragmentScholarshipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentScholarshipBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentScholarshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_scholarship, null, false, component);
    }

    public static FragmentScholarshipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentScholarshipBinding bind(View view, Object component) {
        return (FragmentScholarshipBinding) bind(component, view, R.layout.fragment_scholarship);
    }
}