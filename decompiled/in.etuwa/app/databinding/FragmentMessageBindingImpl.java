package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.message.inbox.MessageViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentMessageBindingImpl extends FragmentMessageBinding {
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
        sparseIntArray.put(R.id.hr_view, 3);
        sparseIntArray.put(R.id.inbox_btn, 4);
        sparseIntArray.put(R.id.sent_btn, 5);
        sparseIntArray.put(R.id.swipe_layout, 6);
        sparseIntArray.put(R.id.rv_inbox, 7);
        sparseIntArray.put(R.id.rv_sent_items, 8);
    }

    public FragmentMessageBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private FragmentMessageBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (HorizontalScrollView) bindings[3], (TextView) bindings[4], (LinearLayout) bindings[0], (RecyclerView) bindings[7], (RecyclerView) bindings[8], (TextView) bindings[5], (SwipeRefreshLayout) bindings[6], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.inboxLayout.setTag(null);
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
        if (143 != variableId) {
            return false;
        }
        setMessageViewModel((MessageViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentMessageBinding
    public void setMessageViewModel(MessageViewModel MessageViewModel) {
        this.mMessageViewModel = MessageViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}