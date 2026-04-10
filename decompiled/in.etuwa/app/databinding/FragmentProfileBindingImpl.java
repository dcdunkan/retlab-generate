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

/* JADX INFO: loaded from: classes3.dex */
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
        sparseIntArray.put(R.id.college_name, 4);
        sparseIntArray.put(R.id.btn_lyt, 5);
        sparseIntArray.put(R.id.personal_details_lyt, 6);
        sparseIntArray.put(R.id.parent_details_lyt, 7);
        sparseIntArray.put(R.id.contactLyt, 8);
        sparseIntArray.put(R.id.btnBank, 9);
        sparseIntArray.put(R.id.review_app_btn, 10);
        sparseIntArray.put(R.id.share_app_btn, 11);
        sparseIntArray.put(R.id.change_pwd_btn, 12);
        sparseIntArray.put(R.id.logoutLyt, 13);
        sparseIntArray.put(R.id.veersion_tv, 14);
    }

    public FragmentProfileBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private FragmentProfileBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[9], (LinearLayout) bindings[5], (LinearLayout) bindings[12], (TextView) bindings[4], (LinearLayout) bindings[8], (TextView) bindings[3], (LinearLayout) bindings[13], (TextView) bindings[2], (LinearLayout) bindings[7], (LinearLayout) bindings[6], (CircleImageView) bindings[1], (LinearLayout) bindings[10], (LinearLayout) bindings[11], (TextView) bindings[14]);
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
        if (167 != variableId) {
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