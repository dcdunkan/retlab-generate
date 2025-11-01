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
import in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentExamReceiptBinding extends ViewDataBinding {
    public final TextView dataNoTv;

    @Bindable
    protected ExamReceiptViewModel mExamReceiptViewModel;
    public final RecyclerView rvExamReceipt;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setExamReceiptViewModel(ExamReceiptViewModel examReceiptViewModel);

    protected FragmentExamReceiptBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView dataNoTv, RecyclerView rvExamReceipt, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dataNoTv = dataNoTv;
        this.rvExamReceipt = rvExamReceipt;
        this.swipeLayout = swipeLayout;
    }

    public ExamReceiptViewModel getExamReceiptViewModel() {
        return this.mExamReceiptViewModel;
    }

    public static FragmentExamReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_receipt, root, attachToRoot, component);
    }

    public static FragmentExamReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamReceiptBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_receipt, null, false, component);
    }

    public static FragmentExamReceiptBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamReceiptBinding bind(View view, Object component) {
        return (FragmentExamReceiptBinding) bind(component, view, R.layout.fragment_exam_receipt);
    }
}