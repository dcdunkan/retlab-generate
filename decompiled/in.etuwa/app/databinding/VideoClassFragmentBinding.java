package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.videoclass.VideoClassViewModel;

/* loaded from: classes3.dex */
public abstract class VideoClassFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabVideoSemester;

    @Bindable
    protected VideoClassViewModel mVideoClassViewModel;
    public final RecyclerView rvVideos;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final LinearLayout videoLayout;

    public abstract void setVideoClassViewModel(VideoClassViewModel videoClassViewModel);

    protected VideoClassFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabVideoSemester, RecyclerView rvVideos, Spinner spinnerSem, SwipeRefreshLayout swipeLayout, LinearLayout videoLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabVideoSemester = fabVideoSemester;
        this.rvVideos = rvVideos;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.videoLayout = videoLayout;
    }

    public VideoClassViewModel getVideoClassViewModel() {
        return this.mVideoClassViewModel;
    }

    public static VideoClassFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoClassFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (VideoClassFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.video_class_fragment, root, attachToRoot, component);
    }

    public static VideoClassFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoClassFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (VideoClassFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.video_class_fragment, null, false, component);
    }

    public static VideoClassFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoClassFragmentBinding bind(View view, Object component) {
        return (VideoClassFragmentBinding) bind(component, view, R.layout.video_class_fragment);
    }
}