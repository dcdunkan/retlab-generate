package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.posurvey.POSurveyViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPoSurveyBinding extends ViewDataBinding {

    @Bindable
    protected POSurveyViewModel mPOSurveyViewModel;
    public final RecyclerView rvSurvey;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setPOSurveyViewModel(POSurveyViewModel pOSurveyViewModel);

    protected FragmentPoSurveyBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSurvey, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSurvey = rvSurvey;
        this.swipeLayout = swipeLayout;
    }

    public POSurveyViewModel getPOSurveyViewModel() {
        return this.mPOSurveyViewModel;
    }

    public static FragmentPoSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPoSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_po_survey, root, attachToRoot, component);
    }

    public static FragmentPoSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoSurveyBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPoSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_po_survey, null, false, component);
    }

    public static FragmentPoSurveyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoSurveyBinding bind(View view, Object component) {
        return (FragmentPoSurveyBinding) bind(component, view, R.layout.fragment_po_survey);
    }
}