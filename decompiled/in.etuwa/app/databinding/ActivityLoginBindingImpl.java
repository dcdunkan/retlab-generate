package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.login.LoginViewModel;

/* loaded from: classes3.dex */
public class ActivityLoginBindingImpl extends ActivityLoginBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final FrameLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.etlab, 2);
        sparseIntArray.put(R.id.clg_search_view, 3);
        sparseIntArray.put(R.id.clg_search_btn, 4);
        sparseIntArray.put(R.id.rv_college_list, 5);
        sparseIntArray.put(R.id.spinner_clg_list, 6);
        sparseIntArray.put(R.id.collge_name, 7);
        sparseIntArray.put(R.id.login_main_lyt, 8);
        sparseIntArray.put(R.id.login_lyt, 9);
        sparseIntArray.put(R.id.username, 10);
        sparseIntArray.put(R.id.password, 11);
        sparseIntArray.put(R.id.change_btn, 12);
        sparseIntArray.put(R.id.register_btn, 13);
        sparseIntArray.put(R.id.login_btn, 14);
        sparseIntArray.put(R.id.reset_btn, 15);
        sparseIntArray.put(R.id.tv_register, 16);
    }

    public ActivityLoginBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    private ActivityLoginBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[12], (SearchView) bindings[4], (LinearLayout) bindings[3], (TextView) bindings[7], (TextView) bindings[2], (TextView) bindings[14], (LinearLayout) bindings[9], (LinearLayout) bindings[8], (TextInputEditText) bindings[11], (TextView) bindings[13], (TextView) bindings[15], (RecyclerView) bindings[5], (Spinner) bindings[6], (TextView) bindings[16], (TextInputEditText) bindings[10]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView01 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (129 != variableId) {
            return false;
        }
        setLoginViewModel((LoginViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ActivityLoginBinding
    public void setLoginViewModel(LoginViewModel LoginViewModel) {
        this.mLoginViewModel = LoginViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}