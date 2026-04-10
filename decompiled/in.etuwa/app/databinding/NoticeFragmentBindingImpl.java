package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.notice.NoticeViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class NoticeFragmentBindingImpl extends NoticeFragmentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.card_info, 3);
        sparseIntArray.put(R.id.info_btn, 4);
        sparseIntArray.put(R.id.swipe_layout, 5);
        sparseIntArray.put(R.id.rv_notice, 6);
        sparseIntArray.put(R.id.rv_notice_main, 7);
    }

    public NoticeFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private NoticeFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[3], (CoordinatorLayout) bindings[0], (TextView) bindings[4], (RecyclerView) bindings[6], (RecyclerView) bindings[7], (LinearLayout) bindings[5], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.dash2.setTag(null);
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
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
        if (150 != variableId) {
            return false;
        }
        setNoticeViewModel((NoticeViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.NoticeFragmentBinding
    public void setNoticeViewModel(NoticeViewModel NoticeViewModel) {
        this.mNoticeViewModel = NoticeViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}