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
import in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentBookingHistoryBinding extends ViewDataBinding {

    @Bindable
    protected BookingHistoryViewModel mBookingHistoryViewModel;
    public final RecyclerView rvBookingHistory;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setBookingHistoryViewModel(BookingHistoryViewModel bookingHistoryViewModel);

    protected FragmentBookingHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvBookingHistory, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvBookingHistory = rvBookingHistory;
        this.swipeLayout = swipeLayout;
    }

    public BookingHistoryViewModel getBookingHistoryViewModel() {
        return this.mBookingHistoryViewModel;
    }

    public static FragmentBookingHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBookingHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentBookingHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_booking_history, root, attachToRoot, component);
    }

    public static FragmentBookingHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBookingHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentBookingHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_booking_history, null, false, component);
    }

    public static FragmentBookingHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBookingHistoryBinding bind(View view, Object component) {
        return (FragmentBookingHistoryBinding) bind(component, view, R.layout.fragment_booking_history);
    }
}