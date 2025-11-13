package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Spinner;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.session.SessionalViewModel;

/* loaded from: classes3.dex */
public class SessionalFragmentBindingImpl extends SessionalFragmentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final FrameLayout mboundView01;
    private final ViewProgressBarBinding mboundView02;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.spinner_semester, 3);
        sparseIntArray.put(R.id.spinner_session, 4);
        sparseIntArray.put(R.id.swipe_layout, 5);
        sparseIntArray.put(R.id.rv_result_session, 6);
        sparseIntArray.put(R.id.fab_session, 7);
    }

    public SessionalFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private SessionalFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (FloatingActionButton) bindings[7], (RecyclerView) bindings[6], (Spinner) bindings[3], (Spinner) bindings[4], (SwipeRefreshLayout) bindings[5]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView01 = frameLayout;
        frameLayout.setTag(null);
        Object obj2 = bindings[2];
        this.mboundView02 = obj2 != null ? ViewProgressBarBinding.bind((View) obj2) : null;
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
        if (204 != variableId) {
            return false;
        }
        setSessionalViewModel((SessionalViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.SessionalFragmentBinding
    public void setSessionalViewModel(SessionalViewModel SessionalViewModel) {
        this.mSessionalViewModel = SessionalViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}