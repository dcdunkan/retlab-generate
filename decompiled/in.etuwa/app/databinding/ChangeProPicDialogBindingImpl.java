package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialogViewModel;

/* loaded from: classes3.dex */
public class ChangeProPicDialogBindingImpl extends ChangeProPicDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.loader, 1);
        sparseIntArray.put(R.id.progress_view, 2);
        sparseIntArray.put(R.id.upload_progressbar, 3);
        sparseIntArray.put(R.id.progress_text, 4);
        sparseIntArray.put(R.id.profile_card, 5);
        sparseIntArray.put(R.id.iv_pro_pic, 6);
        sparseIntArray.put(R.id.iv_signature, 7);
        sparseIntArray.put(R.id.submit_btn, 8);
    }

    public ChangeProPicDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private ChangeProPicDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CircleImageView) bindings[6], (ImageView) bindings[7], (ProgressBar) bindings[1], (LinearLayout) bindings[5], (TextView) bindings[4], (LinearLayout) bindings[2], (TextView) bindings[8], (ProgressBar) bindings[3]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
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
        if (51 != variableId) {
            return false;
        }
        setChangeProPicDialogViewModel((ChangeProPicDialogViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ChangeProPicDialogBinding
    public void setChangeProPicDialogViewModel(ChangeProPicDialogViewModel ChangeProPicDialogViewModel) {
        this.mChangeProPicDialogViewModel = ChangeProPicDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}