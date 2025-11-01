package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.store.StoreDialogViewModel;

/* loaded from: classes3.dex */
public abstract class StoreDialogBinding extends ViewDataBinding {

    @Bindable
    protected StoreDialogViewModel mStoreDialogViewModel;
    public final TextView nextStoreBtn;
    public final TextView progressText;
    public final CardView progressView;
    public final Spinner spinnerCstoreSubject;
    public final Spinner spinnerStoreDepartment;
    public final Spinner spinnerStoreSemester;
    public final ProgressBar uploadProgressbar;

    public abstract void setStoreDialogViewModel(StoreDialogViewModel storeDialogViewModel);

    protected StoreDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView nextStoreBtn, TextView progressText, CardView progressView, Spinner spinnerCstoreSubject, Spinner spinnerStoreDepartment, Spinner spinnerStoreSemester, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.nextStoreBtn = nextStoreBtn;
        this.progressText = progressText;
        this.progressView = progressView;
        this.spinnerCstoreSubject = spinnerCstoreSubject;
        this.spinnerStoreDepartment = spinnerStoreDepartment;
        this.spinnerStoreSemester = spinnerStoreSemester;
        this.uploadProgressbar = uploadProgressbar;
    }

    public StoreDialogViewModel getStoreDialogViewModel() {
        return this.mStoreDialogViewModel;
    }

    public static StoreDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StoreDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (StoreDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.store_dialog, root, attachToRoot, component);
    }

    public static StoreDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StoreDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (StoreDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.store_dialog, null, false, component);
    }

    public static StoreDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StoreDialogBinding bind(View view, Object component) {
        return (StoreDialogBinding) bind(component, view, R.layout.store_dialog);
    }
}