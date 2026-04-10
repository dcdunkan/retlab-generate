package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.videoclass.VideoClassViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VideoClassFragmentBinding extends ViewDataBinding {
    public final ImageView fabVideoSemester;
    public final ImageView ivClearSearch;
    public final ImageView ivSearch;

    @Bindable
    protected VideoClassViewModel mVideoClassViewModel;
    public final RecyclerView rvVideos;
    public final CardView searchCard;
    public final EditText searchInput;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;
    public final MaterialCardView videoFilterCard;

    public abstract void setVideoClassViewModel(VideoClassViewModel videoClassViewModel);

    protected VideoClassFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView fabVideoSemester, ImageView ivClearSearch, ImageView ivSearch, RecyclerView rvVideos, CardView searchCard, EditText searchInput, Spinner spinnerSem, SwipeRefreshLayout swipeLayout, TextView toolbar, MaterialCardView videoFilterCard) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabVideoSemester = fabVideoSemester;
        this.ivClearSearch = ivClearSearch;
        this.ivSearch = ivSearch;
        this.rvVideos = rvVideos;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
        this.videoFilterCard = videoFilterCard;
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