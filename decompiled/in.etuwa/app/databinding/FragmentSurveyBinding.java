package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.SurveyViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentSurveyBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final Chip chipAll;
    public final Chip chipCompleted;
    public final ChipGroup chipGroupFilter;
    public final Chip chipOpen;
    public final Chip chipPending;
    public final CardView courseBtn;
    public final CardView graduateBtn;
    public final ImageView ivClearSearch;
    public final ImageView ivFilter;
    public final ImageView ivSearch;

    @Bindable
    protected SurveyViewModel mSurveyViewModel;
    public final CardView poSurveyBtn;
    public final RecyclerView rvSurvey;
    public final CardView searchCard;
    public final EditText searchInput;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSurveyViewModel(SurveyViewModel surveyViewModel);

    protected FragmentSurveyBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, Chip chipAll, Chip chipCompleted, ChipGroup chipGroupFilter, Chip chipOpen, Chip chipPending, CardView courseBtn, CardView graduateBtn, ImageView ivClearSearch, ImageView ivFilter, ImageView ivSearch, CardView poSurveyBtn, RecyclerView rvSurvey, CardView searchCard, EditText searchInput, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.chipAll = chipAll;
        this.chipCompleted = chipCompleted;
        this.chipGroupFilter = chipGroupFilter;
        this.chipOpen = chipOpen;
        this.chipPending = chipPending;
        this.courseBtn = courseBtn;
        this.graduateBtn = graduateBtn;
        this.ivClearSearch = ivClearSearch;
        this.ivFilter = ivFilter;
        this.ivSearch = ivSearch;
        this.poSurveyBtn = poSurveyBtn;
        this.rvSurvey = rvSurvey;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.swipeLayout = swipeLayout;
    }

    public SurveyViewModel getSurveyViewModel() {
        return this.mSurveyViewModel;
    }

    public static FragmentSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_survey, root, attachToRoot, component);
    }

    public static FragmentSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSurveyBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_survey, null, false, component);
    }

    public static FragmentSurveyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSurveyBinding bind(View view, Object component) {
        return (FragmentSurveyBinding) bind(component, view, R.layout.fragment_survey);
    }
}