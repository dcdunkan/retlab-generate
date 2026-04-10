package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.HostelAttendanceViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentHostelAttendanceBinding extends ViewDataBinding {
    public final TextView btnApply;
    public final TextView btnView;

    @Bindable
    protected HostelAttendanceViewModel mHostelAttendanceViewModel;
    public final TextView monthTv;
    public final TextView nextBtn;
    public final TextView previousBtn;
    public final RecyclerView rvCalender;

    public abstract void setHostelAttendanceViewModel(HostelAttendanceViewModel hostelAttendanceViewModel);

    protected FragmentHostelAttendanceBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView btnApply, TextView btnView, TextView monthTv, TextView nextBtn, TextView previousBtn, RecyclerView rvCalender) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnApply = btnApply;
        this.btnView = btnView;
        this.monthTv = monthTv;
        this.nextBtn = nextBtn;
        this.previousBtn = previousBtn;
        this.rvCalender = rvCalender;
    }

    public HostelAttendanceViewModel getHostelAttendanceViewModel() {
        return this.mHostelAttendanceViewModel;
    }

    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelAttendanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_attendance, root, attachToRoot, component);
    }

    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelAttendanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_attendance, null, false, component);
    }

    public static FragmentHostelAttendanceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceBinding bind(View view, Object component) {
        return (FragmentHostelAttendanceBinding) bind(component, view, R.layout.fragment_hostel_attendance);
    }
}