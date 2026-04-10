package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentExamRegistrationNewBinding extends ViewDataBinding {
    public final ImageView btnFilter;
    public final ImageView btnSearch;
    public final TextView feeReceiptBtn;
    public final HorizontalScrollView hrView;

    @Bindable
    protected ExamRegistrationMainNewViewModel mExamRegistrationMainNewViewModel;
    public final LinearLayout mainLyt;
    public final TextView registrationBtn;
    public final TextView resultBtn;
    public final TextView revaluationBtn;
    public final RecyclerView rvExamResults;
    public final RecyclerView rvReceipts;
    public final RecyclerView rvRegistration;
    public final RecyclerView rvRevaluation;
    public final CardView searchCard;
    public final EditText searchInput;
    public final TextView toolbar;

    public abstract void setExamRegistrationMainNewViewModel(ExamRegistrationMainNewViewModel examRegistrationMainNewViewModel);

    protected FragmentExamRegistrationNewBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView btnFilter, ImageView btnSearch, TextView feeReceiptBtn, HorizontalScrollView hrView, LinearLayout mainLyt, TextView registrationBtn, TextView resultBtn, TextView revaluationBtn, RecyclerView rvExamResults, RecyclerView rvReceipts, RecyclerView rvRegistration, RecyclerView rvRevaluation, CardView searchCard, EditText searchInput, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnFilter = btnFilter;
        this.btnSearch = btnSearch;
        this.feeReceiptBtn = feeReceiptBtn;
        this.hrView = hrView;
        this.mainLyt = mainLyt;
        this.registrationBtn = registrationBtn;
        this.resultBtn = resultBtn;
        this.revaluationBtn = revaluationBtn;
        this.rvExamResults = rvExamResults;
        this.rvReceipts = rvReceipts;
        this.rvRegistration = rvRegistration;
        this.rvRevaluation = rvRevaluation;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.toolbar = toolbar;
    }

    public ExamRegistrationMainNewViewModel getExamRegistrationMainNewViewModel() {
        return this.mExamRegistrationMainNewViewModel;
    }

    public static FragmentExamRegistrationNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamRegistrationNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_registration_new, root, attachToRoot, component);
    }

    public static FragmentExamRegistrationNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationNewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamRegistrationNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_registration_new, null, false, component);
    }

    public static FragmentExamRegistrationNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationNewBinding bind(View view, Object component) {
        return (FragmentExamRegistrationNewBinding) bind(component, view, R.layout.fragment_exam_registration_new);
    }
}