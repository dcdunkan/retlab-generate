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
import in.etuwa.app.ui.profile.qualifiedexaminations.QualifiedExaminationViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentQualifiedExaminationBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected QualifiedExaminationViewModel mQualifiedExaminationViewModel;
    public final RecyclerView rvExam;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setQualifiedExaminationViewModel(QualifiedExaminationViewModel qualifiedExaminationViewModel);

    protected FragmentQualifiedExaminationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvExam, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvExam = rvExam;
        this.swipeLayout = swipeLayout;
    }

    public QualifiedExaminationViewModel getQualifiedExaminationViewModel() {
        return this.mQualifiedExaminationViewModel;
    }

    public static FragmentQualifiedExaminationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQualifiedExaminationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentQualifiedExaminationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_qualified_examination, root, attachToRoot, component);
    }

    public static FragmentQualifiedExaminationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQualifiedExaminationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentQualifiedExaminationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_qualified_examination, null, false, component);
    }

    public static FragmentQualifiedExaminationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQualifiedExaminationBinding bind(View view, Object component) {
        return (FragmentQualifiedExaminationBinding) bind(component, view, R.layout.fragment_qualified_examination);
    }
}