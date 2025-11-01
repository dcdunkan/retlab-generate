package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.ProfileViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentProfileBinding extends ViewDataBinding {
    public final LinearLayout btnBank;
    public final LinearLayout changePwdBtn;
    public final LinearLayout contactLyt;
    public final TextView emailTv;
    public final LinearLayout logoutLyt;

    @Bindable
    protected ProfileViewModel mProfileViewModel;
    public final TextView nameTv;
    public final LinearLayout parentDetailsLyt;
    public final LinearLayout personalDetailsLyt;
    public final CircleImageView profileImage;
    public final LinearLayout shareAppBtn;

    public abstract void setProfileViewModel(ProfileViewModel profileViewModel);

    protected FragmentProfileBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout btnBank, LinearLayout changePwdBtn, LinearLayout contactLyt, TextView emailTv, LinearLayout logoutLyt, TextView nameTv, LinearLayout parentDetailsLyt, LinearLayout personalDetailsLyt, CircleImageView profileImage, LinearLayout shareAppBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnBank = btnBank;
        this.changePwdBtn = changePwdBtn;
        this.contactLyt = contactLyt;
        this.emailTv = emailTv;
        this.logoutLyt = logoutLyt;
        this.nameTv = nameTv;
        this.parentDetailsLyt = parentDetailsLyt;
        this.personalDetailsLyt = personalDetailsLyt;
        this.profileImage = profileImage;
        this.shareAppBtn = shareAppBtn;
    }

    public ProfileViewModel getProfileViewModel() {
        return this.mProfileViewModel;
    }

    public static FragmentProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_profile, root, attachToRoot, component);
    }

    public static FragmentProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_profile, null, false, component);
    }

    public static FragmentProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileBinding bind(View view, Object component) {
        return (FragmentProfileBinding) bind(component, view, R.layout.fragment_profile);
    }
}