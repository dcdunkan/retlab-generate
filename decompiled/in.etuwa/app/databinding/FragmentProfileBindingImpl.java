package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.ProfileViewModel;

/* loaded from: classes3.dex */
public class FragmentProfileBindingImpl extends FragmentProfileBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.profile_image, 1);
        sparseIntArray.put(R.id.name_tv, 2);
        sparseIntArray.put(R.id.email_tv, 3);
        sparseIntArray.put(R.id.personal_details_lyt, 4);
        sparseIntArray.put(R.id.parent_details_lyt, 5);
        sparseIntArray.put(R.id.contact_lyt, 6);
        sparseIntArray.put(R.id.btn_bank, 7);
        sparseIntArray.put(R.id.change_pwd_btn, 8);
        sparseIntArray.put(R.id.share_app_btn, 9);
        sparseIntArray.put(R.id.logout_lyt, 10);
    }

    public FragmentProfileBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private FragmentProfileBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[7], (LinearLayout) bindings[8], (LinearLayout) bindings[6], (TextView) bindings[3], (LinearLayout) bindings[10], (TextView) bindings[2], (LinearLayout) bindings[5], (LinearLayout) bindings[4], (CircleImageView) bindings[1], (LinearLayout) bindings[9]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
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
        if (165 != variableId) {
            return false;
        }
        setProfileViewModel((ProfileViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentProfileBinding
    public void setProfileViewModel(ProfileViewModel ProfileViewModel) {
        this.mProfileViewModel = ProfileViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}