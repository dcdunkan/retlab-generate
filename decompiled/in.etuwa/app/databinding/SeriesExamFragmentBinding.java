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
import in.etuwa.app.ui.exam.series.SeriesExamViewModel;

/* loaded from: classes3.dex */
public abstract class SeriesExamFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabSeriesSemester;

    @Bindable
    protected SeriesExamViewModel mSeriesExamViewModel;
    public final RecyclerView rvExam;
    public final LinearLayout seriesLayout;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSeriesExamViewModel(SeriesExamViewModel seriesExamViewModel);

    protected SeriesExamFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabSeriesSemester, RecyclerView rvExam, LinearLayout seriesLayout, Spinner spinnerSem, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabSeriesSemester = fabSeriesSemester;
        this.rvExam = rvExam;
        this.seriesLayout = seriesLayout;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
    }

    public SeriesExamViewModel getSeriesExamViewModel() {
        return this.mSeriesExamViewModel;
    }

    public static SeriesExamFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SeriesExamFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SeriesExamFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.series_exam_fragment, root, attachToRoot, component);
    }

    public static SeriesExamFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SeriesExamFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SeriesExamFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.series_exam_fragment, null, false, component);
    }

    public static SeriesExamFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SeriesExamFragmentBinding bind(View view, Object component) {
        return (SeriesExamFragmentBinding) bind(component, view, R.layout.series_exam_fragment);
    }
}