package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.subject.SubjectViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SubjectFragmentBinding extends ViewDataBinding {
    public final ImageView fabSubjectSemester;
    public final ImageView ivClearSearch;
    public final ImageView ivSearch;

    @Bindable
    protected SubjectViewModel mSubjectViewModel;
    public final RecyclerView rvSubject;
    public final CardView searchCard;
    public final EditText searchInput;
    public final Spinner spinnerSem;
    public final MaterialCardView subjectLayout;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;

    public abstract void setSubjectViewModel(SubjectViewModel subjectViewModel);

    protected SubjectFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView fabSubjectSemester, ImageView ivClearSearch, ImageView ivSearch, RecyclerView rvSubject, CardView searchCard, EditText searchInput, Spinner spinnerSem, MaterialCardView subjectLayout, SwipeRefreshLayout swipeLayout, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabSubjectSemester = fabSubjectSemester;
        this.ivClearSearch = ivClearSearch;
        this.ivSearch = ivSearch;
        this.rvSubject = rvSubject;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.spinnerSem = spinnerSem;
        this.subjectLayout = subjectLayout;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
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