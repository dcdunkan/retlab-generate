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
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel;

/* loaded from: classes3.dex */
public abstract class DialogMessBookingBinding extends ViewDataBinding {
    public final TextView bookNowBtn;
    public final TextInputEditText etBookingDate;
    public final TextInputEditText etBookingDay;

    @Bindable
    protected MessBookingViewModel mMessBookingViewModel;
    public final TextView maxQtyTv;
    public final TextInputEditText messQuantity;
    public final TextView progressText;
    public final CardView progressView;
    public final Spinner spinnerMessMenu;
    public final Spinner spinnerMessType;
    public final ProgressBar uploadProgressbar;

    public abstract void setMessBookingViewModel(MessBookingViewModel messBookingViewModel);

    protected DialogMessBookingBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView bookNowBtn, TextInputEditText etBookingDate, TextInputEditText etBookingDay, TextView maxQtyTv, TextInputEditText messQuantity, TextView progressText, CardView progressView, Spinner spinnerMessMenu, Spinner spinnerMessType, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bookNowBtn = bookNowBtn;
        this.etBookingDate = etBookingDate;
        this.etBookingDay = etBookingDay;
        this.maxQtyTv = maxQtyTv;
        this.messQuantity = messQuantity;
        this.progressText = progressText;
        this.progressView = progressView;
        this.spinnerMessMenu = spinnerMessMenu;
        this.spinnerMessType = spinnerMessType;
        this.uploadProgressbar = uploadProgressbar;
    }

    public MessBookingViewModel getMessBookingViewModel() {
        return this.mMessBookingViewModel;
    }

    public static DialogMessBookingBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMessBookingBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogMessBookingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mess_booking, root, attachToRoot, component);
    }

    public static DialogMessBookingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMessBookingBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogMessBookingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mess_booking, null, false, component);
    }

    public static DialogMessBookingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMessBookingBinding bind(View view, Object component) {
        return (DialogMessBookingBinding) bind(component, view, R.layout.dialog_mess_booking);
    }
}