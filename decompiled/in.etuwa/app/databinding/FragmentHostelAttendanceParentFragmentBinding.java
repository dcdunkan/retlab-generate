package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelAttendanceParentFragmentBinding extends ViewDataBinding {
    public final TextView allTv;
    public final TextView approvalTv;
    public final FloatingActionButton fabDateFilter;

    @Bindable
    protected HostelAttendanceParentViewModel mHostelAttendanceParentViewModel;
    public final TextView noData;
    public final TextView rejectsTv;
    public final RecyclerView rvHostelAttView;
    public final CardView swipeLayout;

    public abstract void setHostelAttendanceParentViewModel(HostelAttendanceParentViewModel hostelAttendanceParentViewModel);

    protected FragmentHostelAttendanceParentFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView allTv, TextView approvalTv, FloatingActionButton fabDateFilter, TextView noData, TextView rejectsTv, RecyclerView rvHostelAttView, CardView swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.allTv = allTv;
        this.approvalTv = approvalTv;
        this.fabDateFilter = fabDateFilter;
        this.noData = noData;
        this.rejectsTv = rejectsTv;
        this.rvHostelAttView = rvHostelAttView;
        this.swipeLayout = swipeLayout;
    }

    public HostelAttendanceParentViewModel getHostelAttendanceParentViewModel() {
        return this.mHostelAttendanceParentViewModel;
    }

    public static FragmentHostelAttendanceParentFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceParentFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelAttendanceParentFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_attendance_parent_fragment, root, attachToRoot, component);
    }

    public static FragmentHostelAttendanceParentFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceParentFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelAttendanceParentFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_attendance_parent_fragment, null, false, component);
    }

    public static FragmentHostelAttendanceParentFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceParentFragmentBinding bind(View view, Object component) {
        return (FragmentHostelAttendanceParentFragmentBinding) bind(component, view, R.layout.fragment_hostel_attendance_parent_fragment);
    }
}