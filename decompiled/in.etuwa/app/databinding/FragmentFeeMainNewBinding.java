package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.FeeMainNewViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentFeeMainNewBinding extends ViewDataBinding {
    public final FrameLayout feeArtsLyt;
    public final FrameLayout feeEngineerLyt;
    public final FrameLayout feeReceiptLyt;
    public final TextView feesBtn;
    public final MaterialCardView fineLayout;
    public final HorizontalScrollView hrView;

    @Bindable
    protected FeeMainNewViewModel mFeeMainNewViewModel;
    public final LinearLayout mainLyt;
    public final MaterialCardView payBtnLyt;
    public final MaterialButton payFeeArtsBtn;
    public final MaterialButton payFeeEngnrBtn;
    public final TextView receiptBtn;
    public final RecyclerView rvFeeArts;
    public final RecyclerView rvFeeEngnr;
    public final RecyclerView rvFeeReceipt;
    public final CardView searchCard;
    public final EditText searchInput;
    public final MaterialCardView seriesLayout;
    public final Spinner spinnerSem;
    public final LinearLayout swipeLayout;
    public final TextView toolbar;
    public final TextView tvFeeArtsTotal;
    public final TextView tvFeeEngnrTotal;
    public final TextView tvFine;
    public final TextView tvSubtotal;

    public abstract void setFeeMainNewViewModel(FeeMainNewViewModel feeMainNewViewModel);

    protected FragmentFeeMainNewBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout feeArtsLyt, FrameLayout feeEngineerLyt, FrameLayout feeReceiptLyt, TextView feesBtn, MaterialCardView fineLayout, HorizontalScrollView hrView, LinearLayout mainLyt, MaterialCardView payBtnLyt, MaterialButton payFeeArtsBtn, MaterialButton payFeeEngnrBtn, TextView receiptBtn, RecyclerView rvFeeArts, RecyclerView rvFeeEngnr, RecyclerView rvFeeReceipt, CardView searchCard, EditText searchInput, MaterialCardView seriesLayout, Spinner spinnerSem, LinearLayout swipeLayout, TextView toolbar, TextView tvFeeArtsTotal, TextView tvFeeEngnrTotal, TextView tvFine, TextView tvSubtotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.feeArtsLyt = feeArtsLyt;
        this.feeEngineerLyt = feeEngineerLyt;
        this.feeReceiptLyt = feeReceiptLyt;
        this.feesBtn = feesBtn;
        this.fineLayout = fineLayout;
        this.hrView = hrView;
        this.mainLyt = mainLyt;
        this.payBtnLyt = payBtnLyt;
        this.payFeeArtsBtn = payFeeArtsBtn;
        this.payFeeEngnrBtn = payFeeEngnrBtn;
        this.receiptBtn = receiptBtn;
        this.rvFeeArts = rvFeeArts;
        this.rvFeeEngnr = rvFeeEngnr;
        this.rvFeeReceipt = rvFeeReceipt;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.seriesLayout = seriesLayout;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
        this.tvFeeArtsTotal = tvFeeArtsTotal;
        this.tvFeeEngnrTotal = tvFeeEngnrTotal;
        this.tvFine = tvFine;
        this.tvSubtotal = tvSubtotal;
    }

    public FeeMainNewViewModel getFeeMainNewViewModel() {
        return this.mFeeMainNewViewModel;
    }

    public static FragmentFeeMainNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMainNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeeMainNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_main_new, root, attachToRoot, component);
    }

    public static FragmentFeeMainNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMainNewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeeMainNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_main_new, null, false, component);
    }

    public static FragmentFeeMainNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMainNewBinding bind(View view, Object component) {
        return (FragmentFeeMainNewBinding) bind(component, view, R.layout.fragment_fee_main_new);
    }
}