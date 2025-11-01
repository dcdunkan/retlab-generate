package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegViewModel;
import in.etuwa.app.utils.CustomEditText;

/* loaded from: classes3.dex */
public abstract class DialogApplyPreferenceSubRegBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final TextView backBtn;
    public final CardView cvSgpa;
    public final TextView finishBtn;

    @Bindable
    protected ApplyPreferenceSubRegViewModel mApplyPreferenceSubRegViewModel;
    public final TextView nextBtn;
    public final FrameLayout prefLytFive;
    public final FrameLayout prefLytFour;
    public final FrameLayout prefLytOne;
    public final FrameLayout prefLytThree;
    public final FrameLayout prefLytTwo;
    public final TextView questionTv;
    public final TextView removeBtnFour;
    public final TextView removeBtnOne;
    public final TextView removeBtnThree;
    public final TextView removeBtnTwo;
    public final RecyclerView rvQuestionNo;
    public final RecyclerView rvSemList;
    public final RecyclerView rvSemesterNo;
    public final TextView semHistoryBtn;
    public final LinearLayout semQuestionLyt;
    public final TextView semTv;
    public final LinearLayout semesterDetailsLyt;
    public final CustomEditText sgpaMark;
    public final Spinner spinnerCategory;
    public final Spinner spinnerPathway;
    public final Spinner spinnerPreferenceFive;
    public final Spinner spinnerPreferenceFour;
    public final Spinner spinnerPreferenceOne;
    public final Spinner spinnerPreferenceThree;
    public final Spinner spinnerPreferenceTwo;
    public final Spinner spinnerSemesterLastAttended;
    public final TextView subjectsBtn;
    public final LinearLayout subjectsLyt;

    public abstract void setApplyPreferenceSubRegViewModel(ApplyPreferenceSubRegViewModel applyPreferenceSubRegViewModel);

    protected DialogApplyPreferenceSubRegBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, TextView backBtn, CardView cvSgpa, TextView finishBtn, TextView nextBtn, FrameLayout prefLytFive, FrameLayout prefLytFour, FrameLayout prefLytOne, FrameLayout prefLytThree, FrameLayout prefLytTwo, TextView questionTv, TextView removeBtnFour, TextView removeBtnOne, TextView removeBtnThree, TextView removeBtnTwo, RecyclerView rvQuestionNo, RecyclerView rvSemList, RecyclerView rvSemesterNo, TextView semHistoryBtn, LinearLayout semQuestionLyt, TextView semTv, LinearLayout semesterDetailsLyt, CustomEditText sgpaMark, Spinner spinnerCategory, Spinner spinnerPathway, Spinner spinnerPreferenceFive, Spinner spinnerPreferenceFour, Spinner spinnerPreferenceOne, Spinner spinnerPreferenceThree, Spinner spinnerPreferenceTwo, Spinner spinnerSemesterLastAttended, TextView subjectsBtn, LinearLayout subjectsLyt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.backBtn = backBtn;
        this.cvSgpa = cvSgpa;
        this.finishBtn = finishBtn;
        this.nextBtn = nextBtn;
        this.prefLytFive = prefLytFive;
        this.prefLytFour = prefLytFour;
        this.prefLytOne = prefLytOne;
        this.prefLytThree = prefLytThree;
        this.prefLytTwo = prefLytTwo;
        this.questionTv = questionTv;
        this.removeBtnFour = removeBtnFour;
        this.removeBtnOne = removeBtnOne;
        this.removeBtnThree = removeBtnThree;
        this.removeBtnTwo = removeBtnTwo;
        this.rvQuestionNo = rvQuestionNo;
        this.rvSemList = rvSemList;
        this.rvSemesterNo = rvSemesterNo;
        this.semHistoryBtn = semHistoryBtn;
        this.semQuestionLyt = semQuestionLyt;
        this.semTv = semTv;
        this.semesterDetailsLyt = semesterDetailsLyt;
        this.sgpaMark = sgpaMark;
        this.spinnerCategory = spinnerCategory;
        this.spinnerPathway = spinnerPathway;
        this.spinnerPreferenceFive = spinnerPreferenceFive;
        this.spinnerPreferenceFour = spinnerPreferenceFour;
        this.spinnerPreferenceOne = spinnerPreferenceOne;
        this.spinnerPreferenceThree = spinnerPreferenceThree;
        this.spinnerPreferenceTwo = spinnerPreferenceTwo;
        this.spinnerSemesterLastAttended = spinnerSemesterLastAttended;
        this.subjectsBtn = subjectsBtn;
        this.subjectsLyt = subjectsLyt;
    }

    public ApplyPreferenceSubRegViewModel getApplyPreferenceSubRegViewModel() {
        return this.mApplyPreferenceSubRegViewModel;
    }

    public static DialogApplyPreferenceSubRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyPreferenceSubRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogApplyPreferenceSubRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_preference_sub_reg, root, attachToRoot, component);
    }

    public static DialogApplyPreferenceSubRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyPreferenceSubRegBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogApplyPreferenceSubRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_preference_sub_reg, null, false, component);
    }

    public static DialogApplyPreferenceSubRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyPreferenceSubRegBinding bind(View view, Object component) {
        return (DialogApplyPreferenceSubRegBinding) bind(component, view, R.layout.dialog_apply_preference_sub_reg);
    }
}