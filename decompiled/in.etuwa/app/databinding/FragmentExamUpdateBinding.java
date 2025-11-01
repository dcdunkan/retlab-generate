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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentExamUpdateBinding extends ViewDataBinding {

    @Bindable
    protected UpdateRegisterViewModel mUpdateRegisterViewModel;
    public final TextView payLaterBtn;
    public final LinearLayout payLaterLyt;
    public final LinearLayout payLyt;
    public final TextView payNowBtn;
    public final TextView registerBtn;
    public final LinearLayout registerLyt;
    public final RecyclerView rvExamSubject;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvHostelTotal;

    public abstract void setUpdateRegisterViewModel(UpdateRegisterViewModel updateRegisterViewModel);

    protected FragmentExamUpdateBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payLaterBtn, LinearLayout payLaterLyt, LinearLayout payLyt, TextView payNowBtn, TextView registerBtn, LinearLayout registerLyt, RecyclerView rvExamSubject, SwipeRefreshLayout swipeLayout, TextView tvHostelTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payLaterBtn = payLaterBtn;
        this.payLaterLyt = payLaterLyt;
        this.payLyt = payLyt;
        this.payNowBtn = payNowBtn;
        this.registerBtn = registerBtn;
        this.registerLyt = registerLyt;
        this.rvExamSubject = rvExamSubject;
        this.swipeLayout = swipeLayout;
        this.tvHostelTotal = tvHostelTotal;
    }

    public UpdateRegisterViewModel getUpdateRegisterViewModel() {
        return this.mUpdateRegisterViewModel;
    }

    public static FragmentExamUpdateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamUpdateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamUpdateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_update, root, attachToRoot, component);
    }

    public static FragmentExamUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamUpdateBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamUpdateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_update, null, false, component);
    }

    public static FragmentExamUpdateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamUpdateBinding bind(View view, Object component) {
        return (FragmentExamUpdateBinding) bind(component, view, R.layout.fragment_exam_update);
    }
}