package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialogViewModel;

/* loaded from: classes3.dex */
public abstract class ChangeProPicDialogBinding extends ViewDataBinding {
    public final CircleImageView ivProPic;
    public final ImageView ivSignature;
    public final ProgressBar loader;

    @Bindable
    protected ChangeProPicDialogViewModel mChangeProPicDialogViewModel;
    public final LinearLayout profileCard;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final TextView submitBtn;
    public final ProgressBar uploadProgressbar;

    public abstract void setChangeProPicDialogViewModel(ChangeProPicDialogViewModel changeProPicDialogViewModel);

    protected ChangeProPicDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, CircleImageView ivProPic, ImageView ivSignature, ProgressBar loader, LinearLayout profileCard, TextView progressText, LinearLayout progressView, TextView submitBtn, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivProPic = ivProPic;
        this.ivSignature = ivSignature;
        this.loader = loader;
        this.profileCard = profileCard;
        this.progressText = progressText;
        this.progressView = progressView;
        this.submitBtn = submitBtn;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ChangeProPicDialogViewModel getChangeProPicDialogViewModel() {
        return this.mChangeProPicDialogViewModel;
    }

    public static ChangeProPicDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChangeProPicDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ChangeProPicDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.change_pro_pic_dialog, root, attachToRoot, component);
    }

    public static ChangeProPicDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChangeProPicDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ChangeProPicDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.change_pro_pic_dialog, null, false, component);
    }

    public static ChangeProPicDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChangeProPicDialogBinding bind(View view, Object component) {
        return (ChangeProPicDialogBinding) bind(component, view, R.layout.change_pro_pic_dialog);
    }
}