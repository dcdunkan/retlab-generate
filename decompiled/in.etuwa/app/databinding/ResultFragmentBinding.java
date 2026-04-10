package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.ResultViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ResultFragmentBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final CardView cardLiveTv;
    public final Chip chipAssignment;
    public final ChipGroup chipGroupResults;
    public final Chip chipInternal;
    public final Chip chipModule;
    public final Chip chipSeries;
    public final Chip chipTutorial;
    public final Chip chipUniversity;
    public final HorizontalScrollView hrView;
    public final TextView internalSemText;
    public final ImageView ivFilter;

    @Bindable
    protected ResultViewModel mResultViewModel;
    public final ViewPager2 resultPager;
    public final View resultView;
    public final TextView tvResults;
    public final TextView tvUniResults;
    public final LinearLayout uniResultView;
    public final View uniView;
    public final ViewPager univPager;
    public final TabLayout univTabs;

    public abstract void setResultViewModel(ResultViewModel resultViewModel);

    protected ResultFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, CardView cardLiveTv, Chip chipAssignment, ChipGroup chipGroupResults, Chip chipInternal, Chip chipModule, Chip chipSeries, Chip chipTutorial, Chip chipUniversity, HorizontalScrollView hrView, TextView internalSemText, ImageView ivFilter, ViewPager2 resultPager, View resultView, TextView tvResults, TextView tvUniResults, LinearLayout uniResultView, View uniView, ViewPager univPager, TabLayout univTabs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.cardLiveTv = cardLiveTv;
        this.chipAssignment = chipAssignment;
        this.chipGroupResults = chipGroupResults;
        this.chipInternal = chipInternal;
        this.chipModule = chipModule;
        this.chipSeries = chipSeries;
        this.chipTutorial = chipTutorial;
        this.chipUniversity = chipUniversity;
        this.hrView = hrView;
        this.internalSemText = internalSemText;
        this.ivFilter = ivFilter;
        this.resultPager = resultPager;
        this.resultView = resultView;
        this.tvResults = tvResults;
        this.tvUniResults = tvUniResults;
        this.uniResultView = uniResultView;
        this.uniView = uniView;
        this.univPager = univPager;
        this.univTabs = univTabs;
    }

    public ResultViewModel getResultViewModel() {
        return this.mResultViewModel;
    }

    public static ResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_fragment, root, attachToRoot, component);
    }

    public static ResultFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ResultFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.result_fragment, null, false, component);
    }

    public static ResultFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ResultFragmentBinding bind(View view, Object component) {
        return (ResultFragmentBinding) bind(component, view, R.layout.result_fragment);
    }
}