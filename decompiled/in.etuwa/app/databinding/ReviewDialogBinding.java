package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.counselling.review.ReviewDialogViewModel;

/* loaded from: classes3.dex */
public abstract class ReviewDialogBinding extends ViewDataBinding {
    public final EditText etReview;

    @Bindable
    protected ReviewDialogViewModel mReviewDialogViewModel;
    public final TextView reviewBtn;

    public abstract void setReviewDialogViewModel(ReviewDialogViewModel reviewDialogViewModel);

    protected ReviewDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText etReview, TextView reviewBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etReview = etReview;
        this.reviewBtn = reviewBtn;
    }

    public ReviewDialogViewModel getReviewDialogViewModel() {
        return this.mReviewDialogViewModel;
    }

    public static ReviewDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReviewDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ReviewDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.review_dialog, root, attachToRoot, component);
    }

    public static ReviewDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReviewDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ReviewDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.review_dialog, null, false, component);
    }

    public static ReviewDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReviewDialogBinding bind(View view, Object component) {
        return (ReviewDialogBinding) bind(component, view, R.layout.review_dialog);
    }
}