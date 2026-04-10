package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.lab.LabViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentLabBinding extends ViewDataBinding {
    public final TextView cardDue;
    public final TextView cardEquipment;
    public final TextView cardPractical;
    public final FrameLayout equipmentLyt;
    public final HorizontalScrollView hrView;
    public final FrameLayout labDueLyt;

    @Bindable
    protected LabViewModel mLabViewModel;
    public final FrameLayout practicalLyt;
    public final RecyclerView rvLabDue;
    public final RecyclerView rvLabList;
    public final RecyclerView rvPractical;
    public final MaterialCardView sessionSpinnerLayout;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final SwipeRefreshLayout swipeLayout2;

    public abstract void setLabViewModel(LabViewModel labViewModel);

    protected FragmentLabBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView cardDue, TextView cardEquipment, TextView cardPractical, FrameLayout equipmentLyt, HorizontalScrollView hrView, FrameLayout labDueLyt, FrameLayout practicalLyt, RecyclerView rvLabDue, RecyclerView rvLabList, RecyclerView rvPractical, MaterialCardView sessionSpinnerLayout, Spinner spinnerSem, SwipeRefreshLayout swipeLayout, SwipeRefreshLayout swipeLayout2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardDue = cardDue;
        this.cardEquipment = cardEquipment;
        this.cardPractical = cardPractical;
        this.equipmentLyt = equipmentLyt;
        this.hrView = hrView;
        this.labDueLyt = labDueLyt;
        this.practicalLyt = practicalLyt;
        this.rvLabDue = rvLabDue;
        this.rvLabList = rvLabList;
        this.rvPractical = rvPractical;
        this.sessionSpinnerLayout = sessionSpinnerLayout;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.swipeLayout2 = swipeLayout2;
    }

    public LabViewModel getLabViewModel() {
        return this.mLabViewModel;
    }

    public static FragmentLabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentLabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_lab, root, attachToRoot, component);
    }

    public static FragmentLabBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLabBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentLabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_lab, null, false, component);
    }

    public static FragmentLabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLabBinding bind(View view, Object component) {
        return (FragmentLabBinding) bind(component, view, R.layout.fragment_lab);
    }
}