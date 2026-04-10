package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.notice.NoticeViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NoticeFragmentBinding extends ViewDataBinding {
    public final CardView cardInfo;
    public final CoordinatorLayout dash2;
    public final TextView infoBtn;

    @Bindable
    protected NoticeViewModel mNoticeViewModel;
    public final RecyclerView rvNotice;
    public final RecyclerView rvNoticeMain;
    public final LinearLayout swipeLayout;
    public final TextView toolbar;

    public abstract void setNoticeViewModel(NoticeViewModel noticeViewModel);

    protected NoticeFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardInfo, CoordinatorLayout dash2, TextView infoBtn, RecyclerView rvNotice, RecyclerView rvNoticeMain, LinearLayout swipeLayout, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardInfo = cardInfo;
        this.dash2 = dash2;
        this.infoBtn = infoBtn;
        this.rvNotice = rvNotice;
        this.rvNoticeMain = rvNoticeMain;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
    }

    public NoticeViewModel getNoticeViewModel() {
        return this.mNoticeViewModel;
    }

    public static NoticeFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NoticeFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NoticeFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.notice_fragment, root, attachToRoot, component);
    }

    public static NoticeFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NoticeFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (NoticeFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.notice_fragment, null, false, component);
    }

    public static NoticeFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NoticeFragmentBinding bind(View view, Object component) {
        return (NoticeFragmentBinding) bind(component, view, R.layout.notice_fragment);
    }
}