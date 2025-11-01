package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.stationary.booking.BookingViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentBookingBinding extends ViewDataBinding {

    @Bindable
    protected BookingViewModel mBookingViewModel;
    public final RecyclerView rvBooking;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setBookingViewModel(BookingViewModel bookingViewModel);

    protected FragmentBookingBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvBooking, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvBooking = rvBooking;
        this.swipeLayout = swipeLayout;
    }

    public BookingViewModel getBookingViewModel() {
        return this.mBookingViewModel;
    }

    public static FragmentBookingBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBookingBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentBookingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_booking, root, attachToRoot, component);
    }

    public static FragmentBookingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBookingBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentBookingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_booking, null, false, component);
    }

    public static FragmentBookingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBookingBinding bind(View view, Object component) {
        return (FragmentBookingBinding) bind(component, view, R.layout.fragment_booking);
    }
}